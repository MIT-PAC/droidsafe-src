package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;
import java.util.regex.Pattern;

public class WifiP2pDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.905 -0400", hash_original_field = "271FEAE7FBE3640A38493945A82BE63F", hash_generated_field = "9A7D4F81FAFB7D27EA987849BE77B870")

    public String deviceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.916 -0400", hash_original_field = "519D99D9C5FAC874DB35B04A27557D9B", hash_generated_field = "AF33174D1ECF5398CFAFDB3DA69ECE9B")

    public String deviceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "3C3899100031989CA8DC1CD5899032D0", hash_generated_field = "D9677D104688FDB3640FCDFC7678BD77")

    public String interfaceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "5476575B2F57F8C80F22DEF75E8D228B", hash_generated_field = "C8560C786D68383CDDC32BE9AF81775C")

    public String primaryDeviceType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "92B3FF13AF549C4CD6B5B65E360FEEE7", hash_generated_field = "A0E2331A45EBC682CDD39EC85B9272F4")

    public String secondaryDeviceType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "9B21FABAED5EBC11E1EF7EE8AF35DC3F", hash_generated_field = "057DC56034FD8E15F0EE29D17084FE88")

    public int wpsConfigMethodsSupported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "01840975B61547AAF4F354C1A4E68B58", hash_generated_field = "24F1D51080FEAB5C6723A8A0299BEEA4")

    public int deviceCapability;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "F8E080D14294024BBDA5AD376B3C6CB0", hash_generated_field = "A7627F4B2A75A5A2B99BAF760EB86A74")

    public int groupCapability;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.917 -0400", hash_original_field = "44C13B312673A1B4CD877AF886680F7D", hash_generated_field = "0FCEE9D7758B8948ABBBB774FA2E2C5C")

    public int status = UNAVAILABLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.918 -0400", hash_original_method = "6DEE1BC764FD2CB933A4912269652401", hash_generated_method = "F64008BCEC449AEC52DED02A9FF6F441")
    public  WifiP2pDevice() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.955 -0400", hash_original_method = "B4DFEB594E50AA2111054B3A3A6DF197", hash_generated_method = "7DA492524BC86D42CF3E2C30FCF0B57B")
    public  WifiP2pDevice(String string) throws IllegalArgumentException {
        String[] tokens;
        tokens = string.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Malformed supplicant event");
        } //End block
        {
            deviceAddress = string;
        } //End block
        {
            Iterator<String> varD67D8F347A2D26FE6847991011252D61_1883375375 = (tokens).iterator();
            varD67D8F347A2D26FE6847991011252D61_1883375375.hasNext();
            String token = varD67D8F347A2D26FE6847991011252D61_1883375375.next();
            {
                String[] nameValue;
                nameValue = token.split("=");
                {
                    boolean var8AC9DB9DC429149EDA79109543592BA6_296375642 = (nameValue[0].equals("p2p_dev_addr"));
                    {
                        deviceAddress = nameValue[1];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var0E731094D1437FC30119369BCBB0A589_1304851343 = (nameValue[0].equals("pri_dev_type"));
                    {
                        primaryDeviceType = nameValue[1];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var09B981DCA6D84DEB8CD275F9C5F3EDB0_78233131 = (nameValue[0].equals("name"));
                    {
                        deviceName = trimQuotes(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var924CEDDD1099FF99F1FC46ADD3D9A1D8_462940598 = (nameValue[0].equals("config_methods"));
                    {
                        wpsConfigMethodsSupported = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9063703FB99A098E2A9B6A2DA9A20F55_1376038435 = (nameValue[0].equals("dev_capab"));
                    {
                        deviceCapability = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9D6445E80ABE9386BFD88F7AE226586D_720918757 = (nameValue[0].equals("group_capab"));
                    {
                        groupCapability = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4E8A7E1B22B5D7A2E828A95A82927AD6_1137746731 = (tokens[0].startsWith("P2P-DEVICE-FOUND"));
            {
                status = AVAILABLE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.958 -0400", hash_original_method = "8BE5EC4742BDBC547BA4DA345C8E71E1", hash_generated_method = "408E6B8417C36D35766E6B9F3AE1895E")
    public  WifiP2pDevice(WifiP2pDevice source) {
        {
            deviceName = source.deviceName;
            deviceAddress = source.deviceAddress;
            interfaceAddress = source.interfaceAddress;
            primaryDeviceType = source.primaryDeviceType;
            secondaryDeviceType = source.secondaryDeviceType;
            wpsConfigMethodsSupported = source.wpsConfigMethodsSupported;
            deviceCapability = source.deviceCapability;
            groupCapability = source.groupCapability;
            status = source.status;
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //deviceName = source.deviceName;
            //deviceAddress = source.deviceAddress;
            //interfaceAddress = source.interfaceAddress;
            //primaryDeviceType = source.primaryDeviceType;
            //secondaryDeviceType = source.secondaryDeviceType;
            //wpsConfigMethodsSupported = source.wpsConfigMethodsSupported;
            //deviceCapability = source.deviceCapability;
            //groupCapability = source.groupCapability;
            //status = source.status;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.959 -0400", hash_original_method = "76992CA06444764D9CF7DB1AFF10640E", hash_generated_method = "6875631D8CF05EE89F26F4102F9ADF87")
    public boolean wpsPbcSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953758472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953758472;
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_PUSHBUTTON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.966 -0400", hash_original_method = "B2A0BAE23B24F963FF842B8EAAF5D840", hash_generated_method = "E5DCA8C1513A5503A7A1E4865BE93973")
    public boolean wpsKeypadSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675154741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_675154741;
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_KEYPAD) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.970 -0400", hash_original_method = "89517E0D3099BE3BB50FEAB8A124BB8F", hash_generated_method = "45D9755347992125ABF24C5584D55E77")
    public boolean wpsDisplaySupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031166150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031166150;
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_DISPLAY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.974 -0400", hash_original_method = "3FBC138270F4ADEAF27B9A0357206073", hash_generated_method = "42B493C5232A158124D275AE8314FC76")
    public boolean isServiceDiscoveryCapable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676463634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676463634;
        // ---------- Original Method ----------
        //return (deviceCapability & DEVICE_CAPAB_SERVICE_DISCOVERY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.975 -0400", hash_original_method = "A041F8E96FF7F1638DE5EDEE0D23FE8B", hash_generated_method = "2EE06A81E34C0AFD1041FD979FDF2980")
    public boolean isGroupOwner() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119254873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119254873;
        // ---------- Original Method ----------
        //return (groupCapability & GROUP_CAPAB_GROUP_OWNER) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.989 -0400", hash_original_method = "09392A3C152DA1725DCCBD5DEBB248C2", hash_generated_method = "155DAAA32F05D9A67E5ECCF7BD3DBC55")
    @Override
    public boolean equals(Object obj) {
        WifiP2pDevice other;
        other = (WifiP2pDevice) obj;
        boolean varF2FEF16ABB9E6BF81AAF4EE3693DE3E5_1427925916 = (other.deviceAddress.equals(deviceAddress));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272107486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272107486;
        // ---------- Original Method ----------
        //if (this == obj) return true;
        //if (!(obj instanceof WifiP2pDevice)) return false;
        //WifiP2pDevice other = (WifiP2pDevice) obj;
        //if (other == null || other.deviceAddress == null) {
            //return (deviceAddress == null);
        //}
        //return other.deviceAddress.equals(deviceAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.014 -0400", hash_original_method = "016D59A2B811BA8203F4683B5513F2D5", hash_generated_method = "AC1A204DB828E8D11DF8BB9CB7445FEE")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2078488149 = null; //Variable for return #1
        StringBuffer sbuf;
        sbuf = new StringBuffer();
        sbuf.append("Device: ").append(deviceName);
        sbuf.append("\n deviceAddress: ").append(deviceAddress);
        sbuf.append("\n interfaceAddress: ").append(interfaceAddress);
        sbuf.append("\n primary type: ").append(primaryDeviceType);
        sbuf.append("\n secondary type: ").append(secondaryDeviceType);
        sbuf.append("\n wps: ").append(wpsConfigMethodsSupported);
        sbuf.append("\n grpcapab: ").append(groupCapability);
        sbuf.append("\n devcapab: ").append(deviceCapability);
        sbuf.append("\n status: ").append(status);
        varB4EAC82CA7396A68D541C85D26508E83_2078488149 = sbuf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2078488149.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2078488149;
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //sbuf.append("Device: ").append(deviceName);
        //sbuf.append("\n deviceAddress: ").append(deviceAddress);
        //sbuf.append("\n interfaceAddress: ").append(interfaceAddress);
        //sbuf.append("\n primary type: ").append(primaryDeviceType);
        //sbuf.append("\n secondary type: ").append(secondaryDeviceType);
        //sbuf.append("\n wps: ").append(wpsConfigMethodsSupported);
        //sbuf.append("\n grpcapab: ").append(groupCapability);
        //sbuf.append("\n devcapab: ").append(deviceCapability);
        //sbuf.append("\n status: ").append(status);
        //return sbuf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.015 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4C01B292C1252902DFEBD3832A3D3537")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482668916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482668916;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.017 -0400", hash_original_method = "F1F1C1D05E28ABD7E03ACA6C9259AC2F", hash_generated_method = "4338B9F77A063F8BEA4A8867424D1460")
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
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(deviceName);
        //dest.writeString(deviceAddress);
        //dest.writeString(interfaceAddress);
        //dest.writeString(primaryDeviceType);
        //dest.writeString(secondaryDeviceType);
        //dest.writeInt(wpsConfigMethodsSupported);
        //dest.writeInt(deviceCapability);
        //dest.writeInt(groupCapability);
        //dest.writeInt(status);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.018 -0400", hash_original_method = "81EACEB4EB0E2420630EBFC84E59B2A4", hash_generated_method = "45CA8D78DA32BC7A796FC9F3E559D79E")
    private String trimQuotes(String str) {
        String varB4EAC82CA7396A68D541C85D26508E83_620954663 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_614192483 = null; //Variable for return #2
        str = str.trim();
        {
            boolean varCCC98BB190CD9DF38348CFC1F7E10DC7_1464506168 = (str.startsWith("'") && str.endsWith("'"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_620954663 = str.substring(1, str.length()-1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_614192483 = str;
        addTaint(str.getTaint());
        String varA7E53CE21691AB073D9660D615818899_903333773; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_903333773 = varB4EAC82CA7396A68D541C85D26508E83_620954663;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_903333773 = varB4EAC82CA7396A68D541C85D26508E83_614192483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_903333773.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_903333773;
        // ---------- Original Method ----------
        //str = str.trim();
        //if (str.startsWith("'") && str.endsWith("'")) {
            //return str.substring(1, str.length()-1);
        //}
        //return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.019 -0400", hash_original_method = "C0F4185566F115FC2220CE409C454DF3", hash_generated_method = "8CAECA2CAC91B42E7B50E5E6EA297762")
    private int parseHex(String hexString) {
        int num;
        num = 0;
        {
            boolean var67CDF86B1EA52DCF199AB47995A915FB_1363582642 = (hexString.startsWith("0x") || hexString.startsWith("0X"));
            {
                hexString = hexString.substring(2);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            num = Integer.parseInt(hexString, 16);
        } //End block
        catch (NumberFormatException e)
        { }
        addTaint(hexString.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037338791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037338791;
        // ---------- Original Method ----------
        //int num = 0;
        //if (hexString.startsWith("0x") || hexString.startsWith("0X")) {
            //hexString = hexString.substring(2);
        //}
        //try {
            //num = Integer.parseInt(hexString, 16);
        //} catch(NumberFormatException e) {
            //Log.e(TAG, "Failed to parse hex string " + hexString);
        //}
        //return num;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "AE43CB08180DDB93087C004ADAB60C50", hash_generated_field = "DA6CD70E223B18831B8D4C484A9B237D")

    private static String TAG = "WifiP2pDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "8598204F3C37E7E1F5019D0FBDF50847", hash_generated_field = "404167251FE0A9403A52F0F7CE47C28A")

    private static int WPS_CONFIG_DISPLAY = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "32FDFB589F79EA959F0618C849371C92", hash_generated_field = "AF130370C564A44719682C2282855C74")

    private static int WPS_CONFIG_PUSHBUTTON = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "A677601AA4FDC4E1C90E63620FB86358", hash_generated_field = "B2FFE7A8BD852051C72F2A117778F593")

    private static int WPS_CONFIG_KEYPAD = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "64E3C91CE49305F32DF8E49258AF40F6", hash_generated_field = "46F1965D8D3D3FBACF7ADDB159AA18F6")

    private static int DEVICE_CAPAB_SERVICE_DISCOVERY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "848A578E2570E7EBD1C50FBED0CC6E34", hash_generated_field = "71A8CD9361AD3C0D280FB214ACBF3D6F")

    private static int DEVICE_CAPAB_CLIENT_DISCOVERABILITY = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "22F2BB19D52A359661973536C90EE58F", hash_generated_field = "8B2E1FB4814BB184FBBEB55F72138205")

    private static int DEVICE_CAPAB_CONCURRENT_OPER = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "D3F2BF333B7E0DE0788F68FB9992E66D", hash_generated_field = "9BAC92F326AFBB9112C9B5BF313942A3")

    private static int DEVICE_CAPAB_INFRA_MANAGED = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.050 -0400", hash_original_field = "FAE3F8097286B2388CB5E9E722FA9376", hash_generated_field = "801F3CCADB05D23B202F802B05277B70")

    private static int DEVICE_CAPAB_DEVICE_LIMIT = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "6ADE38D2E2FE37191B2F042452FA7CA6", hash_generated_field = "EBA88F0710329AF740BCC7B03C8F1780")

    private static int DEVICE_CAPAB_INVITATION_PROCEDURE = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "DE296303D36B91631485D4E1AB7E6C9B", hash_generated_field = "AF619761D97377E8FFF78DFB70BC0709")

    private static int GROUP_CAPAB_GROUP_OWNER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "B5C1065E7C45300EE1C1FEE28BEC039A", hash_generated_field = "CA9365394385FA5ECBAECB8B1C3FF345")

    private static int GROUP_CAPAB_PERSISTENT_GROUP = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "E6C7146C910619650200D213B9387ED7", hash_generated_field = "5F74DA25FD2147C2AE82B8B55ACDB9FE")

    private static int GROUP_CAPAB_GROUP_LIMIT = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "8C0EFCE86E4ECC424E835E5919446ADF", hash_generated_field = "F4C4ABE2792BC5118BEC97056E869F2E")

    private static int GROUP_CAPAB_INTRA_BSS_DIST = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "32DCF2A6593404424A352455EA15DB35", hash_generated_field = "8EF6C0D828EBC26593D894998822EB9B")

    private static int GROUP_CAPAB_CROSS_CONN = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "15694CADE2F6777E124BD9136061231B", hash_generated_field = "3E164DC79C65E61FB62B977239AE7B22")

    private static int GROUP_CAPAB_PERSISTENT_RECONN = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "8471780A070C5212C3BE09A278FE278B", hash_generated_field = "2278118CC297515C05E2C45848D3261D")

    private static int GROUP_CAPAB_GROUP_FORMATION = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "6B5E0957DCB6301BBFD7E668EB84B035", hash_generated_field = "C64FAE939570F571A8BAE24D1B70BD13")

    public static final int CONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "06D821117E1B6D57A639606827F9604E", hash_generated_field = "B6613B33DED36EABAC0CBA0C7B969929")

    public static final int INVITED     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "72D423E6C58FCDECEC7381F5C89F6C03", hash_generated_field = "CFFB40C2E01759BFC10D884F773E1A4F")

    public static final int FAILED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "1478E7FA7161A6AE612B8761D910DB5B", hash_generated_field = "3420700E53DA1A9A7046D001075E3AE8")

    public static final int AVAILABLE   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "9BB63F437347685327DE4C4126C58692", hash_generated_field = "EBDD50BA8ED35706997081541733CA67")

    public static final int UNAVAILABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.051 -0400", hash_original_field = "9AB723F7F4AC03B860BFCAE90A6330E9", hash_generated_field = "C2F80F230659999E6A4528EC4530DF69")

    public static final Creator<WifiP2pDevice> CREATOR =
        new Creator<WifiP2pDevice>() {
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

            public WifiP2pDevice[] newArray(int size) {
                return new WifiP2pDevice[size];
            }
        };
}

