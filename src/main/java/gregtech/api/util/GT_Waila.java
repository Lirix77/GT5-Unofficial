package gregtech.api.util;

import static appeng.core.localization.WailaText.*;

public abstract class GT_Waila {

    public static String getMachineProgressString(boolean isActive, int maxProgresstime, int progresstime) {
        return getMachineProgressString(isActive, (long) maxProgresstime, (long) progresstime);
    }

    public static String getMachineProgressString(boolean isActive, long maxProgresstime, long progresstime) {

        if (!isActive) return "Idle";

        StringBuilder ret = new StringBuilder("In progress: ")
            .append(String.format("%,.2f", (double) progresstime / 20))
            .append("s / ")
            .append(String.format("%,.2f", (double) maxProgresstime / 20))
            .append("s (")
            .append(GT_Utility.formatNumbers((Math.round((double) progresstime / maxProgresstime * 1000) / 10.0)))
            .append("%)");

        return ret.toString();
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
