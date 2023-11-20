package gregtech.common.blocks;

import com.google.common.base.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StatCollector;
import gregtech.common.items.ItemDimensionDisplay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimBlocks {
    public static final Map<String, Block> blocks = new HashMap<>();

    public static final String[] DimName = {
        // Non GC dimensions in progression order instead of alphabetical
        "Overworld", "Nether", "TheEnd", "Vanilla_EndAsteroids", "EndAsteroid",
        // T1
        "GalacticraftCore_Moon",
        // T2
        "GalacticraftMars_Mars",
        // T3
        "GalacticraftMars_Asteroids",
        // T10
        "Underdark", };
    public static final String[] DimNameTrimmed = Arrays.stream(DimName)
        .map(
            n -> n.replaceAll("GalacticraftCore_", "").replaceAll("GalacticraftMars_", "")
                .replaceAll("GalaxySpace_", "").replaceAll("GalacticraftAmunRa_", "")
                .replaceAll("Vanilla_", "Vanilla "))
        .toArray(String[]::new);
    public static final String[] DimNameDisplayed = { // first 2 letters if one word else 1 letter of every word, except
        "Ow", // Overworld
        "Ne", // Nether
        "ED", // TheEnd because En = Encalus
        "VA", // Vanilla_EndAsteroids
        "EA", // EndAsteroid
        // T1
        "Mo", // GalacticraftCore_Moon
        // T2
        "Ma", // GalacticraftMars_Mars
        // T3
        "As", // GalacticraftMars_Asteroids
        // T10
        "DD", // Underdark
    };

    private static final HashMap<String, List<String>> tooltipBuffer = new HashMap<>();

    private static List<String> computeString(String line) {
        String[] dims = parseDimNames(line);
        for (int j = 0; j < dims.length; j++) {
            String s = dims[j];
            for (int i = 0; i < DimNameDisplayed.length; i++) {
                if (s.equals(DimNameDisplayed[i])) {
                    String k = DimNameTrimmed[i];
                    s = StatCollector.translateToLocal("gtnop.world." + k);
                    s = switch (k) {
                        case "Moon" -> "T1: " + s;
                        case "Deimos", "Mars", "Phobos" -> "T2: " + s;
                        case "Asteroids", "Callisto", "Ceres", "Europa", "Ganymede", "Ross128b" -> "T3: " + s;
                        case "Io", "Mercury", "Venus" -> "T4: " + s;
                        case "Enceladus", "Miranda", "Oberon", "Titan", "Ross128ba" -> "T5: " + s;
                        case "Proteus", "Triton" -> "T6: " + s;
                        case "Haumea", "Kuiperbelt", "MakeMake", "Pluto" -> "T7: " + s;
                        case "BarnardC", "BarnardE", "BarnardF", "CentauriA", "TcetiE", "VegaB" -> "T8: " + s;
                        case "Anubis", "Horus", "Maahes", "Mehen Belt", "Neper", "Seth" -> "T9: " + s;
                        case "Underdark" -> "T10: " + s;
                        default -> s;
                    };

                    dims[j] = s;
                }
            }
        }

        if (dims.length > 11) {
            dims = stringsToSpacedColumns(
                dims,
                dims.length / 11 + (dims.length % 11 == 0 ? 0 : 1),
                2);
        }

        return Arrays.asList(dims);
    }

    public static String[] stringsToSpacedColumns(String[] strings, int numColumns, int minColumnSpacing) {
        if (numColumns < 1) {
            throw new IllegalArgumentException(
                String.format("Argument numColumns must be 1 or higher, got value %d", numColumns));
        }
        if (numColumns > 1) {
            int sliceSize = strings.length / numColumns;
            int remainder = strings.length % numColumns;
            String[][] columns = new String[numColumns][];
            int totalExtra = 0;

            // Arrange all strings into their proper columns so that the list of strings wraps through all columns
            for (int i = 0; i < numColumns; i++) {
                int extra = 0;
                if (remainder > 0) {
                    remainder--;
                    extra = 1;
                }
                columns[i] = Arrays
                    .copyOfRange(strings, (sliceSize * i) + totalExtra, (sliceSize * (i + 1) + totalExtra + extra));

                totalExtra += extra;
            }

            // Add extra padding to all but the last columns to align the text
            for (int i = 0; i < numColumns - 1; i++) {
                columns[i] = padStrings(columns[i], minColumnSpacing);
            }

            // Concatenate all columns into the final result
            strings = columns[0];
            for (int i = 0; i < sliceSize; i++) {
                for (int j = 1; j < numColumns; j++) {
                    strings[i] += columns[j][i];
                }
            }
        }

        return strings;
    }

    protected static int[] getStringWidths(String[] strList) {
        FontRenderer font = Minecraft.getMinecraft().fontRenderer;
        int[] widths = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            widths[i] = font.getStringWidth(strList[i]);
        }
        return widths;
    }

    public static String[] padStrings(String[] strings, int minExtraSpaces) {
        int[] widths = getStringWidths(strings);
        int maxUnPaddedStrLength = 0;
        int numSpacesAddedToLongestString = 0;
        int maxPaddedStrLength = 0;

        // Making string width a multiple of 4 by adding bold spaces of width 5
        for (int i = 0; i < strings.length; i++) {
            int mod = widths[i] % 4;
            int numBoldSpacesToAdd = (4 - mod) % 4;

            // Keep track of the number of spaces added to the longest string
            if (widths[i] > maxUnPaddedStrLength) {
                numSpacesAddedToLongestString = numBoldSpacesToAdd;
                maxUnPaddedStrLength = widths[i];
            }

            strings[i] += "§l" + Strings.repeat(" ", numBoldSpacesToAdd) + "§r";
            widths[i] += numBoldSpacesToAdd * 5;

            // Keep track of the current widest string we currently have
            if (widths[i] > maxPaddedStrLength) {
                maxPaddedStrLength = widths[i];
            }
        }

        // Make sure we pad at least up to the desired number of spaces from the longest string
        if (numSpacesAddedToLongestString < minExtraSpaces) {
            maxPaddedStrLength += (minExtraSpaces - numSpacesAddedToLongestString) * 4;
        }

        // Add required spaces to equalize length of all strings to at least the target width
        for (int i = 0; i < strings.length; i++) {
            int numSpacesToAdd = (maxPaddedStrLength - widths[i]) / 4;
            strings[i] += Strings.repeat(" ", numSpacesToAdd);
            widths[i] += numSpacesToAdd * 4;
        }

        return strings;
    }

    public static String[] parseDimNames(String line) {
        String[] dims = line.split(",");
        for (int j = 0; j < dims.length; j++) {
            String s = dims[j];
            s = s.replaceAll(",", "");
            s = s.trim();
            dims[j] = s;
        }
        return dims;
    }


    public static void init() {
        for (String dimension : DimNameDisplayed) {
            Block block = new BlockDimensionDisplay(dimension);
            GameRegistry.registerBlock(block, ItemDimensionDisplay.class, "blockDimensionDisplay_" + dimension);
            blocks.put(dimension, block);
        }
    }

    public static Block getBlock(String dimension) {
        return blocks.get(dimension);
    }

    public static List<String> convertCondensedStringToToolTip(String line) {
        return tooltipBuffer.computeIfAbsent(line, (String tmp) -> computeString(line));
    }
}
