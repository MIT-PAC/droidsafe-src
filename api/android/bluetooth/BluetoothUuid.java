package android.bluetooth;

// Droidsafe Imports
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import android.os.ParcelUuid;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class BluetoothUuid {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.741 -0400", hash_original_method = "FFEFA3BC7BFF4E84DBF24098C0B3A717", hash_generated_method = "FFEFA3BC7BFF4E84DBF24098C0B3A717")
    public BluetoothUuid ()
    {
        //Synthesized constructor
    }


    public static boolean isAudioSource(ParcelUuid uuid) {
        return uuid.equals(AudioSource);
    }

    
    public static boolean isAudioSink(ParcelUuid uuid) {
        return uuid.equals(AudioSink);
    }

    
    public static boolean isAdvAudioDist(ParcelUuid uuid) {
        return uuid.equals(AdvAudioDist);
    }

    
    public static boolean isHandsfree(ParcelUuid uuid) {
        return uuid.equals(Handsfree);
    }

    
    public static boolean isHeadset(ParcelUuid uuid) {
        return uuid.equals(HSP);
    }

    
    public static boolean isAvrcpController(ParcelUuid uuid) {
        return uuid.equals(AvrcpController);
    }

    
    public static boolean isAvrcpTarget(ParcelUuid uuid) {
        return uuid.equals(AvrcpTarget);
    }

    
    public static boolean isInputDevice(ParcelUuid uuid) {
        return uuid.equals(Hid);
    }

    
    public static boolean isPanu(ParcelUuid uuid) {
        return uuid.equals(PANU);
    }

    
    public static boolean isNap(ParcelUuid uuid) {
        return uuid.equals(NAP);
    }

    
    public static boolean isBnep(ParcelUuid uuid) {
        return uuid.equals(BNEP);
    }

    
    public static boolean isUuidPresent(ParcelUuid[] uuidArray, ParcelUuid uuid) {
        if ((uuidArray == null || uuidArray.length == 0) && uuid == null)
            return true;
        if (uuidArray == null)
            return false;
        for (ParcelUuid element: uuidArray) {
            if (element.equals(uuid)) return true;
        }
        return false;
    }

    
    public static boolean containsAnyUuid(ParcelUuid[] uuidA, ParcelUuid[] uuidB) {
        if (uuidA == null && uuidB == null) return true;
        if (uuidA == null) {
            return uuidB.length == 0 ? true : false;
        }
        if (uuidB == null) {
            return uuidA.length == 0 ? true : false;
        }
        HashSet<ParcelUuid> uuidSet = new HashSet<ParcelUuid> (Arrays.asList(uuidA));
        for (ParcelUuid uuid: uuidB) {
            if (uuidSet.contains(uuid)) return true;
        }
        return false;
    }

    
    public static boolean containsAllUuids(ParcelUuid[] uuidA, ParcelUuid[] uuidB) {
        if (uuidA == null && uuidB == null) return true;
        if (uuidA == null) {
            return uuidB.length == 0 ? true : false;
        }
        if (uuidB == null) return true;
        HashSet<ParcelUuid> uuidSet = new HashSet<ParcelUuid> (Arrays.asList(uuidA));
        for (ParcelUuid uuid: uuidB) {
            if (!uuidSet.contains(uuid)) return false;
        }
        return true;
    }

    
    public static int getServiceIdentifierFromParcelUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        long value = (uuid.getMostSignificantBits() & 0x0000FFFF00000000L) >>> 32;
        return (int)value;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.749 -0400", hash_original_field = "747FDB85E5ADB49FBDD6F620A27BF3D3", hash_generated_field = "F359610201989CB2AF4AAC47BBFC7DE3")

    public static final ParcelUuid AudioSink =
            ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.750 -0400", hash_original_field = "544138A61E6968FBB9DB6BE10A12986C", hash_generated_field = "311CD8A9AC8E0F2A27B689FBD57C2D97")

    public static final ParcelUuid AudioSource =
            ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.750 -0400", hash_original_field = "983684C1C541BFE255E6D1296B4D28A3", hash_generated_field = "DDA406BBE304C417312756D9C9FA848C")

    public static final ParcelUuid AdvAudioDist =
            ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.750 -0400", hash_original_field = "7F5C87C880F4A538109F00240082884A", hash_generated_field = "94C83300C9FD3DD4445D093C881AE311")

    public static final ParcelUuid HSP =
            ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.750 -0400", hash_original_field = "D80A535E90C5BE52E911F861EAFFF904", hash_generated_field = "A8716277C367CFFECA81EE406C703EC4")

    public static final ParcelUuid HSP_AG =
            ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "9630BD5A6F6CA2EC8E77ECEF029B05DB", hash_generated_field = "F65BE4EA7E86A63F3F8C2FE288570C05")

    public static final ParcelUuid Handsfree =
            ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "D603CE571FF94026488B4319ECCBC4BB", hash_generated_field = "84885ECC78B4D3850B0C8A9FAFCE1098")

    public static final ParcelUuid Handsfree_AG =
            ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "F6AE7BB560BE0B821D957A3F320F5A52", hash_generated_field = "A16E0DBA0D8FDAA66F32D4A4CD7C5B64")

    public static final ParcelUuid AvrcpController =
            ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "193508CB2D48276F8D2E744744281F70", hash_generated_field = "6DF603FD2840F83CB3B7E5275C9906FF")

    public static final ParcelUuid AvrcpTarget =
            ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "8F05CDC5862C714B72527E79293E8AF5", hash_generated_field = "29D7958A4B7F4376DA9FB7A5153DC803")

    public static final ParcelUuid ObexObjectPush =
            ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.751 -0400", hash_original_field = "D718629C40327C63F8FA0E370FDB2392", hash_generated_field = "6C94A075F8F648576D398ABBE69F9B5C")

    public static final ParcelUuid Hid =
            ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.752 -0400", hash_original_field = "0CAFDB26210B880BEA6B5D4B5F380586", hash_generated_field = "BF68444EAA11BF24FB0C3BD970D099A8")

    public static final ParcelUuid PANU =
            ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.752 -0400", hash_original_field = "BCFFDC530C9854831C6140F6F18AECF4", hash_generated_field = "B3814C7772E6BDC291321A7775060BD2")

    public static final ParcelUuid NAP =
            ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.752 -0400", hash_original_field = "3420F7448A4EE220121FCCD3CB201D99", hash_generated_field = "C0AA6678DBE3CFED1B8246D39CA85DC7")

    public static final ParcelUuid BNEP =
            ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.752 -0400", hash_original_field = "CD4121031CF026248131D21EC456611B", hash_generated_field = "4A653A0EC0C71C8E285EC329D0C3DEAA")

    public static final ParcelUuid PBAP_PSE =
            ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.752 -0400", hash_original_field = "7A49F7DE1378113878FEC7071D197BDE", hash_generated_field = "21C8273B00AA1A7F9C975686F7D4F5C5")

    public static final ParcelUuid[] RESERVED_UUIDS = {
        AudioSink, AudioSource, AdvAudioDist, HSP, Handsfree, AvrcpController, AvrcpTarget,
        ObexObjectPush, PANU, NAP};
}

