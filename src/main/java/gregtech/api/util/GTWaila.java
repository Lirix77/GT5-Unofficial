package gregtech.api.util;

import static appeng.core.localization.WailaText.*;

public abstract class GTWaila {

    public static String getMachineProgressString(boolean isActive, int maxProgresstime, int progresstime) {
        return getMachineProgressString(isActive, maxProgresstime, (long) progresstime);
    }

    public static String getMachineProgressString(boolean isActive, long maxProgresstime, long progresstime) {

        if (!isActive) return "Idle";

        return "In progress: " + String.format("%,.2f", (double) progresstime / 20)
            + "s / "
            + String.format("%,.2f", (double) maxProgresstime / 20)
            + "s ("
            + GTUtility.formatNumbers((Math.round((double) progresstime / maxProgresstime * 1000) / 10.0))
            + "%)";
    }

    public static String getPowerState(boolean isActive, boolean isPowered, boolean isBooting) {
        if (isBooting) {
            return Booting.getLocal();
        } else if (isActive && isPowered) {
            return DeviceOnline.getLocal();
        } else {
            return isPowered ? DeviceMissingChannel.getLocal() : DeviceOffline.getLocal();
        }
    }

}
