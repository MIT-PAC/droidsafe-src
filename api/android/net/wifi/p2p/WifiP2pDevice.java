package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pDevice implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.178 -0500", hash_original_field = "F04D9FB2301464066CA4B658866B1A7C", hash_generated_field = "2D3FA46E684AAF11DB903AED32FED7F0")

    private static final String TAG = "WifiP2pDevice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.193 -0500", hash_original_field = "277B34EC794982313F1D75A836F7B86F", hash_generated_field = "34C7BFF4A71DE101F52E5FEEC7E3D4DD")

    /* WPS config methods supported */
    private static final int WPS_CONFIG_DISPLAY         = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.195 -0500", hash_original_field = "F717D91FF96C9C9EC7FA53EED4647EDA", hash_generated_field = "78E701778F1AAA542995E26A9F4815B3")

    private static final int WPS_CONFIG_PUSHBUTTON      = 0x0080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.197 -0500", hash_original_field = "B333D01AC44B5A99730B745F8AEF3314", hash_generated_field = "4441C9AC819F241188C2F8B8A1223F6F")

    private static final int WPS_CONFIG_KEYPAD          = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.199 -0500", hash_original_field = "EF9B64FC69DA901C8B52C86E38EACB94", hash_generated_field = "ED7E840AF6B67252A5F338FC4F9F5C16")

    private static final int DEVICE_CAPAB_SERVICE_DISCOVERY         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.202 -0500", hash_original_field = "84824328ADBA71FEA215811B5BEA4BB3", hash_generated_field = "B3F55D1FD38440F6A01D01E71751E240")

    private static final int DEVICE_CAPAB_CLIENT_DISCOVERABILITY    = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.204 -0500", hash_original_field = "33F3C4F2D4FB0B56A929EE20C73076FF", hash_generated_field = "C11C29B1C6B7394FEDFE0A204E03D494")

    private static final int DEVICE_CAPAB_CONCURRENT_OPER           = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.207 -0500", hash_original_field = "2B7784C51800E6EA5D3685CDB060CADF", hash_generated_field = "E4889542C18A4CAD394FE39FD0A7E53A")

    private static final int DEVICE_CAPAB_INFRA_MANAGED             = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.209 -0500", hash_original_field = "5D219595828A825F2FDCE4BDA24F4655", hash_generated_field = "C6FDFEE4D831077E17A8F87B79E1542B")

    private static final int DEVICE_CAPAB_DEVICE_LIMIT              = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.212 -0500", hash_original_field = "1018D187A218B4592E92BE1B7C919462", hash_generated_field = "E11BF5DA4C652DC3885D2F89B8BC8CBC")

    private static final int DEVICE_CAPAB_INVITATION_PROCEDURE      = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.214 -0500", hash_original_field = "24F661532E9D1B4D08BE5F212CB3E17A", hash_generated_field = "660117B2CCF1684725E38F606720D4F8")

    private static final int GROUP_CAPAB_GROUP_OWNER                = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.217 -0500", hash_original_field = "F4A90B0A9E7C28CBABB56A2E0AF37DD8", hash_generated_field = "1ED43ED6AC42E70FA6E2AE19C57697F9")

    private static final int GROUP_CAPAB_PERSISTENT_GROUP           = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.219 -0500", hash_original_field = "9E66DE990F0D7A5BCEBBEC2630135172", hash_generated_field = "0E2B6BAC640107ABB60FC85978FC8B33")

    private static final int GROUP_CAPAB_GROUP_LIMIT                = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.221 -0500", hash_original_field = "5F6D0EF31719FCE25D837681ABA1B626", hash_generated_field = "B55D83B08662B8007693B6A4BCB60BB7")

    private static final int GROUP_CAPAB_INTRA_BSS_DIST             = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.223 -0500", hash_original_field = "4BC4F53128197C7412B89789773B026A", hash_generated_field = "A7083D15E179404DC8C6B584349D2977")

    private static final int GROUP_CAPAB_CROSS_CONN                 = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.226 -0500", hash_original_field = "AE1B00A39883DE1A246441B48134F5BF", hash_generated_field = "B109428E0DF961D64558D4C2EB0C7A20")

    private static final int GROUP_CAPAB_PERSISTENT_RECONN          = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.228 -0500", hash_original_field = "5A238D1DD68031E8EB01569FB8A26A2A", hash_generated_field = "ABA5135F62F4403CCC24802B45944736")

    private static final int GROUP_CAPAB_GROUP_FORMATION            = 1<<6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.237 -0500", hash_original_field = "1E24F9D848DD61AFCB4567859AC1F346", hash_generated_field = "C64FAE939570F571A8BAE24D1B70BD13")

    public static final int CONNECTED   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.239 -0500", hash_original_field = "8BCF35DAC151898B7E0676E11300D32A", hash_generated_field = "B6613B33DED36EABAC0CBA0C7B969929")

    public static final int INVITED     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.242 -0500", hash_original_field = "000FFC8FE97CA2AB4E413EC0653951D5", hash_generated_field = "CFFB40C2E01759BFC10D884F773E1A4F")

    public static final int FAILED      = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.244 -0500", hash_original_field = "C611119B863329F40641FC29F0354467", hash_generated_field = "3420700E53DA1A9A7046D001075E3AE8")

    public static final int AVAILABLE   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.247 -0500", hash_original_field = "0DEDA97B66D944C394999D09C8277D82", hash_generated_field = "EBDD50BA8ED35706997081541733CA67")

    public static final int UNAVAILABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.624 -0400", hash_original_field = "9AB723F7F4AC03B860BFCAE90A6330E9", hash_generated_field = "C2F80F230659999E6A4528EC4530DF69")

    public static final Creator<WifiP2pDevice> CREATOR =
        new Creator<WifiP2pDevice>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.283 -0500", hash_original_method = "5387382CA16A3AD5682D1C391F3488A3", hash_generated_method = "DB007C546816C2DDE05F93E41058B0E5")
        
public WifiP2pDevice createFromParcel(Parcel in) {
                WifiP2pDevice device = new WifiP2pDevice();
                device.deviceName = in.readString();
                device.deviceAddress = in.readString();
                device.interfaceAddress = in.readString();
                device.primaryDeviceType = in.readString();
                device.secondaryDeviceType = in.readString();
                device.wpsConfigMethodsSupported = in.readInt();
                device.deviceCapability = in.readInt();
                device.groupCapability = in.readInt();
                device.status = in.readInt();
                return device;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.285 -0500", hash_original_method = "984A6A383474F78D9CC3B6A5D85D6E25", hash_generated_method = "0D37828AC4D1484F573DBA82BF341A7B")
        
public WifiP2pDevice[] newArray(int size) {
                return new WifiP2pDevice[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.181 -0500", hash_original_field = "A372F52D013F6BC1A5F9285AD3DD76BD", hash_generated_field = "9A7D4F81FAFB7D27EA987849BE77B870")

    public String deviceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.183 -0500", hash_original_field = "5680069B0A3D4DFE817187C6DB2A220A", hash_generated_field = "AF33174D1ECF5398CFAFDB3DA69ECE9B")

    public String deviceAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.185 -0500", hash_original_field = "C6E9D1B190579E67491392023B2D5CFB", hash_generated_field = "D9677D104688FDB3640FCDFC7678BD77")

    public String interfaceAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.187 -0500", hash_original_field = "D4D2818B4D6F39F379EC8B79657B094C", hash_generated_field = "C8560C786D68383CDDC32BE9AF81775C")

    public String primaryDeviceType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.189 -0500", hash_original_field = "047AC8625134AAEB04163BBEA4DBE772", hash_generated_field = "A0E2331A45EBC682CDD39EC85B9272F4")

    public String secondaryDeviceType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.230 -0500", hash_original_field = "8EF211DFFFE4A4C9E32C5EDC7C584581", hash_generated_field = "057DC56034FD8E15F0EE29D17084FE88")

    public int wpsConfigMethodsSupported;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.232 -0500", hash_original_field = "05536B106DCAD6286CA13396646E1606", hash_generated_field = "24F1D51080FEAB5C6723A8A0299BEEA4")

    public int deviceCapability;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.234 -0500", hash_original_field = "86469BBD4C008876FFA94DD0F89455DB", hash_generated_field = "A7627F4B2A75A5A2B99BAF760EB86A74")

    public int groupCapability;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.249 -0500", hash_original_field = "29430799A944FDBDB26E548B96A723D0", hash_generated_field = "0FCEE9D7758B8948ABBBB774FA2E2C5C")

    public int status = UNAVAILABLE;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.251 -0500", hash_original_method = "6DEE1BC764FD2CB933A4912269652401", hash_generated_method = "F16508AAFF899630171AC9A8E9233A52")
    
public WifiP2pDevice() {
    }

    /**
     * @param string formats supported include
     *  P2P-DEVICE-FOUND fa:7b:7a:42:02:13 p2p_dev_addr=fa:7b:7a:42:02:13
     *  pri_dev_type=1-0050F204-1 name='p2p-TEST1' config_methods=0x188 dev_capab=0x27
     *  group_capab=0x0
     *
     *  P2P-DEVICE-LOST p2p_dev_addr=fa:7b:7a:42:02:13
     *
     *  fa:7b:7a:42:02:13
     *
     *  P2P-PROV-DISC-PBC-REQ 42:fc:89:e1:e2:27 p2p_dev_addr=42:fc:89:e1:e2:27
     *  pri_dev_type=1-0050F204-1 name='p2p-TEST2' config_methods=0x188 dev_capab=0x27
     *  group_capab=0x0
     *
     *  P2P-PROV-DISC-ENTER-PIN 42:fc:89:e1:e2:27 p2p_dev_addr=42:fc:89:e1:e2:27
     *  pri_dev_type=1-0050F204-1 name='p2p-TEST2' config_methods=0x188 dev_capab=0x27
     *  group_capab=0x0
     *
     *  P2P-PROV-DISC-SHOW-PIN 42:fc:89:e1:e2:27 44490607 p2p_dev_addr=42:fc:89:e1:e2:27
     *  pri_dev_type=1-0050F204-1 name='p2p-TEST2' config_methods=0x188 dev_capab=0x27
     *  group_capab=0x0
     *
     *  Note: The events formats can be looked up in the wpa_supplicant code
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.255 -0500", hash_original_method = "B4DFEB594E50AA2111054B3A3A6DF197", hash_generated_method = "FE0BA10AC47EA8541703F7DA0FF274C1")
    
public WifiP2pDevice(String string) throws IllegalArgumentException {
        String[] tokens = string.split(" ");

        if (tokens.length < 1) {
            throw new IllegalArgumentException("Malformed supplicant event");
        }

        /* Just a device address */
        if (tokens.length == 1) {
            deviceAddress = string;
            return;
        }

        for (String token : tokens) {
            String[] nameValue = token.split("=");
            if (nameValue.length != 2) continue;

            if (nameValue[0].equals("p2p_dev_addr")) {
                deviceAddress = nameValue[1];
                continue;
            }

            if (nameValue[0].equals("pri_dev_type")) {
                primaryDeviceType = nameValue[1];
                continue;
            }

            if (nameValue[0].equals("name")) {
                deviceName = trimQuotes(nameValue[1]);
                continue;
            }

            if (nameValue[0].equals("config_methods")) {
                wpsConfigMethodsSupported = parseHex(nameValue[1]);
                continue;
            }

            if (nameValue[0].equals("dev_capab")) {
                deviceCapability = parseHex(nameValue[1]);
                continue;
            }

            if (nameValue[0].equals("group_capab")) {
                groupCapability = parseHex(nameValue[1]);
                continue;
            }
        }

        if (tokens[0].startsWith("P2P-DEVICE-FOUND")) {
            status = AVAILABLE;
        }
    }

    /** copy constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.276 -0500", hash_original_method = "8BE5EC4742BDBC547BA4DA345C8E71E1", hash_generated_method = "793018AD230FBA8C91A1710C1DB2C406")
    
public WifiP2pDevice(WifiP2pDevice source) {
        if (source != null) {
            deviceName = source.deviceName;
            deviceAddress = source.deviceAddress;
            interfaceAddress = source.interfaceAddress;
            primaryDeviceType = source.primaryDeviceType;
            secondaryDeviceType = source.secondaryDeviceType;
            wpsConfigMethodsSupported = source.wpsConfigMethodsSupported;
            deviceCapability = source.deviceCapability;
            groupCapability = source.groupCapability;
            status = source.status;
        }
    }

    /** Returns true if WPS push button configuration is supported */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.257 -0500", hash_original_method = "76992CA06444764D9CF7DB1AFF10640E", hash_generated_method = "5B1E0534FC73153EA3F058EDA9D163AF")
    
public boolean wpsPbcSupported() {
        return (wpsConfigMethodsSupported & WPS_CONFIG_PUSHBUTTON) != 0;
    }

    /** Returns true if WPS keypad configuration is supported */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.259 -0500", hash_original_method = "B2A0BAE23B24F963FF842B8EAAF5D840", hash_generated_method = "8291981AB63407AE29C5D4C7916DDECA")
    
public boolean wpsKeypadSupported() {
        return (wpsConfigMethodsSupported & WPS_CONFIG_KEYPAD) != 0;
    }

    /** Returns true if WPS display configuration is supported */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.261 -0500", hash_original_method = "89517E0D3099BE3BB50FEAB8A124BB8F", hash_generated_method = "FA68B779C0A9D00C5971A12EE0357A09")
    
public boolean wpsDisplaySupported() {
        return (wpsConfigMethodsSupported & WPS_CONFIG_DISPLAY) != 0;
    }

    /** Returns true if the device is capable of service discovery */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.263 -0500", hash_original_method = "3FBC138270F4ADEAF27B9A0357206073", hash_generated_method = "A008793A021577C8A500442E7593AECB")
    
public boolean isServiceDiscoveryCapable() {
        return (deviceCapability & DEVICE_CAPAB_SERVICE_DISCOVERY) != 0;
    }

    /** Returns true if the device is a group owner */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.266 -0500", hash_original_method = "A041F8E96FF7F1638DE5EDEE0D23FE8B", hash_generated_method = "5EF2B59EC71A41C6F2469CE5E44BCCC8")
    
public boolean isGroupOwner() {
        return (groupCapability & GROUP_CAPAB_GROUP_OWNER) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.268 -0500", hash_original_method = "09392A3C152DA1725DCCBD5DEBB248C2", hash_generated_method = "5D550A39FAC86B8A1E962F0736DBB9A9")
    
@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WifiP2pDevice)) return false;

        WifiP2pDevice other = (WifiP2pDevice) obj;
        if (other == null || other.deviceAddress == null) {
            return (deviceAddress == null);
        }
        return other.deviceAddress.equals(deviceAddress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.270 -0500", hash_original_method = "016D59A2B811BA8203F4683B5513F2D5", hash_generated_method = "011133C52A8A5C2BA1398ECCF2140305")
    
public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("Device: ").append(deviceName);
        sbuf.append("\n deviceAddress: ").append(deviceAddress);
        sbuf.append("\n interfaceAddress: ").append(interfaceAddress);
        sbuf.append("\n primary type: ").append(primaryDeviceType);
        sbuf.append("\n secondary type: ").append(secondaryDeviceType);
        sbuf.append("\n wps: ").append(wpsConfigMethodsSupported);
        sbuf.append("\n grpcapab: ").append(groupCapability);
        sbuf.append("\n devcapab: ").append(deviceCapability);
        sbuf.append("\n status: ").append(status);
        return sbuf.toString();
    }

    /** Implement the Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.272 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.278 -0500", hash_original_method = "F1F1C1D05E28ABD7E03ACA6C9259AC2F", hash_generated_method = "9823E54C53B079EDAC31D5C9B4C87A7F")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(deviceName);
        dest.writeString(deviceAddress);
        dest.writeString(interfaceAddress);
        dest.writeString(primaryDeviceType);
        dest.writeString(secondaryDeviceType);
        dest.writeInt(wpsConfigMethodsSupported);
        dest.writeInt(deviceCapability);
        dest.writeInt(groupCapability);
        dest.writeInt(status);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.290 -0500", hash_original_method = "81EACEB4EB0E2420630EBFC84E59B2A4", hash_generated_method = "C0E2D1AD994CCEE1CBE97C16FA3E6C1C")
    
private String trimQuotes(String str) {
        str = str.trim();
        if (str.startsWith("'") && str.endsWith("'")) {
            return str.substring(1, str.length()-1);
        }
        return str;
    }

    //supported formats: 0x1abc, 0X1abc, 1abc
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.292 -0500", hash_original_method = "C0F4185566F115FC2220CE409C454DF3", hash_generated_method = "26CE78F6E6F315F479373762C2EBF819")
    
private int parseHex(String hexString) {
        int num = 0;
        if (hexString.startsWith("0x") || hexString.startsWith("0X")) {
            hexString = hexString.substring(2);
        }

        try {
            num = Integer.parseInt(hexString, 16);
        } catch(NumberFormatException e) {
            Log.e(TAG, "Failed to parse hex string " + hexString);
        }
        return num;
    }
    // orphaned legacy method
    public WifiP2pDevice createFromParcel(Parcel in) {
                WifiP2pDevice device = new WifiP2pDevice();
                device.deviceName = in.readString();
                device.deviceAddress = in.readString();
                device.interfaceAddress = in.readString();
                device.primaryDeviceType = in.readString();
                device.secondaryDeviceType = in.readString();
                device.wpsConfigMethodsSupported = in.readInt();
                device.deviceCapability = in.readInt();
                device.groupCapability = in.readInt();
                device.status = in.readInt();
                return device;
            }
    
    // orphaned legacy method
    public WifiP2pDevice[] newArray(int size) {
                return new WifiP2pDevice[size];
            }
    
}

