package detrav.net;

import java.util.HashMap;

import com.google.common.io.ByteArrayDataInput;
import gregtech.GTMod;
import gregtech.api.net.GTPacket;
import gregtech.api.net.GTPacketTypes;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.google.common.base.Objects;

import bartworks.system.material.Werkstoff;
import detrav.DetravScannerMod;
import detrav.gui.DetravScannerGUI;
import detrav.gui.textures.DetravMapTexture;
import detrav.utils.FluidColors;
import detrav.utils.GTppHelper;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.Materials;
import gregtech.api.util.GTLanguageManager;

/**
 * Created by wital_000 on 20.03.2016.
 */
public class ProspectingPacket extends GTPacket {

    public int chunkX;
    public int chunkZ;
    public int posX;
    public int posZ;
    public int size;
    public int ptype;
    public HashMap<Byte, Short>[][] map;
    public HashMap<String, Integer> ores;
    public HashMap<Short, String> metaMap;

    public int level = -1;
    public ProspectingPacket(){
        super();
    }

    public ProspectingPacket(int chunkX, int chunkZ, int posX, int posZ, int size, int ptype) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.posX = posX;
        this.posZ = posZ;
        GTMod.GT_FML_LOGGER.debug("posZ = " + posZ);
        this.size = size;
        GTMod.GT_FML_LOGGER.debug("size2 = " + size);
        this.ptype = ptype;
        GTMod.GT_FML_LOGGER.debug("ptype = " + ptype);
        this.map = new HashMap[(size * 2 + 1) * 16][(size * 2 + 1) * 16];
        this.ores = new HashMap<>();
        this.metaMap = new HashMap<>();
    }

    private static void addOre(ProspectingPacket packet, byte y, int i, int j, short meta) {
        final short[] rgba;
        final String name;
        try {
            if (packet.ptype == 0 || packet.ptype == 1) {
                // Ore or Small Ore
                if (meta < 7000 || meta > 7500) {
                    if (meta > 0) {
                        Materials tMaterial = GregTechAPI.sGeneratedMaterials[meta % 1000];
                        rgba = tMaterial.getRGBA();
                        name = tMaterial.getLocalizedNameForItem(
                            GTLanguageManager.getTranslation("gt.blockores." + meta + ".name"));
                    } else {
                        final Werkstoff werkstoff = Werkstoff.werkstoffHashMap.getOrDefault((short) (meta * -1), null);
                        String translated = GTLanguageManager.getTranslation("bw.blocktype.ore");
                        name = translated.replace("%material", werkstoff.getLocalizedName());
                        rgba = werkstoff.getRGBA();
                    }
                } else {
                    gtPlusPlus.core.material.Material mat = GTppHelper.getMatFromMeta(meta);
                    rgba = mat.getRGBA();
                    name = mat.getLocalizedName() + " Ore";
                }
            } else if (packet.ptype == 2) {
                // Fluid
                rgba = FluidColors.getColor(meta);
                name = Objects.firstNonNull(
                    FluidRegistry.getFluid(meta)
                        .getLocalizedName(new FluidStack(FluidRegistry.getFluid(meta), 0)),
                    StatCollector.translateToLocal("gui.detrav.scanner.unknown_fluid"));
            } else if (packet.ptype == 3) {
                // Pollution
                name = StatCollector.translateToLocal("gui.detrav.scanner.pollution");
                rgba = new short[] { 125, 123, 118, 0 };
            } else {
                return;
            }
        } catch (Exception ignored) {
            return;
        }
        packet.ores.put(name, ((rgba[0] & 0xFF) << 16) + ((rgba[1] & 0xFF) << 8) + ((rgba[2] & 0xFF)));
        packet.metaMap.put(meta, name);
    }

    public GTPacket decode(ByteArrayDataInput in) {
        //DataInput aData = new DataInputStream(new GZIPInputStream(in));
        ProspectingPacket packet = new ProspectingPacket(
            in.readInt(),
            in.readInt(),
            in.readInt(),
            in.readInt(),
            in.readInt(),
            in.readInt());
        packet.level = in.readInt();

        int aSize = (packet.size * 2 + 1) * 16;
        int checkOut = 0;
        for (int i = 0; i < aSize; i++) for (int j = 0; j < aSize; j++) {
            byte kSize = in.readByte();
            if (kSize == 0) continue;
            packet.map[i][j] = new HashMap<>();
            for (int k = 0; k < kSize; k++) {
                final byte y = in.readByte();
                final short meta = in.readShort();
                packet.map[i][j].put(y, meta);
                if (packet.ptype != 2 || y == 1) addOre(packet, y, i, j, meta);
                checkOut++;
            }
        }
        int checkOut2 = in.readInt();
        if (checkOut != checkOut2) return null;
        return packet;
    }

    @Override
    public void process(IBlockAccess world) {
        DetravScannerGUI.newMap(new DetravMapTexture(this));
        DetravScannerMod.proxy.openProspectorGUI();
    }

    @Override
    public byte getPacketID() {
        return GTPacketTypes.DEVRAV.id;
    }

    @Override
    public void encode(ByteBuf out) {
        //DataOutputStream tOut = new DataOutputStream(new GZIPOutputStream(out));
        out.writeInt(chunkX);
        out.writeInt(chunkZ);
        out.writeInt(posX);
        out.writeInt(posZ);
        out.writeInt(size);
        out.writeInt(ptype);
        out.writeInt(level);

        int aSize = (size * 2 + 1) * 16;
        int checkOut = 0;
        for (int i = 0; i < aSize; i++) for (int j = 0; j < aSize; j++) {
            HashMap<Byte, Short> data = map[i][j];
            if (data == null) out.writeByte(0);
            else {
                out.writeByte(
                    data.keySet()
                        .size());
                for (byte key : data.keySet()) {
                    out.writeByte(key);
                    out.writeShort(data.get(key));
                    checkOut++;
                }
            }
        }
        out.writeInt(checkOut);
    }

    public void addBlock(int x, int y, int z, short metaData) {
        int aX = x - (chunkX - size) * 16;
        int aZ = z - (chunkZ - size) * 16;
        if (map[aX][aZ] == null) map[aX][aZ] = new HashMap<>();
        map[aX][aZ].put((byte) y, metaData);
    }

    public int getSize() {
        return (size * 2 + 1) * 16;
    }
}
