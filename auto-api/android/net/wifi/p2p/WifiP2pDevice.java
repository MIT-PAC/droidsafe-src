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
    public String deviceName;
    public String deviceAddress;
    public String interfaceAddress;
    public String primaryDeviceType;
    public String secondaryDeviceType;
    public int wpsConfigMethodsSupported;
    public int deviceCapability;
    public int groupCapability;
    public int status = UNAVAILABLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.693 -0400", hash_original_method = "6DEE1BC764FD2CB933A4912269652401", hash_generated_method = "F64008BCEC449AEC52DED02A9FF6F441")
    @DSModeled(DSC.SAFE)
    public WifiP2pDevice() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.695 -0400", hash_original_method = "B4DFEB594E50AA2111054B3A3A6DF197", hash_generated_method = "AC837C6C62D551AC2987B7C87C46D8C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pDevice(String string) throws IllegalArgumentException {
        dsTaint.addTaint(string);
        String[] tokens;
        tokens = string.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Malformed supplicant event");
        } //End block
        {
            Iterator<String> varD67D8F347A2D26FE6847991011252D61_1545229083 = (tokens).iterator();
            varD67D8F347A2D26FE6847991011252D61_1545229083.hasNext();
            String token = varD67D8F347A2D26FE6847991011252D61_1545229083.next();
            {
                String[] nameValue;
                nameValue = token.split("=");
                {
                    boolean var8AC9DB9DC429149EDA79109543592BA6_427238130 = (nameValue[0].equals("p2p_dev_addr"));
                    {
                        deviceAddress = nameValue[1];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var0E731094D1437FC30119369BCBB0A589_1161959755 = (nameValue[0].equals("pri_dev_type"));
                    {
                        primaryDeviceType = nameValue[1];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var09B981DCA6D84DEB8CD275F9C5F3EDB0_2053873465 = (nameValue[0].equals("name"));
                    {
                        deviceName = trimQuotes(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var924CEDDD1099FF99F1FC46ADD3D9A1D8_202841292 = (nameValue[0].equals("config_methods"));
                    {
                        wpsConfigMethodsSupported = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9063703FB99A098E2A9B6A2DA9A20F55_111216295 = (nameValue[0].equals("dev_capab"));
                    {
                        deviceCapability = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9D6445E80ABE9386BFD88F7AE226586D_35166731 = (nameValue[0].equals("group_capab"));
                    {
                        groupCapability = parseHex(nameValue[1]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4E8A7E1B22B5D7A2E828A95A82927AD6_172249553 = (tokens[0].startsWith("P2P-DEVICE-FOUND"));
            {
                status = AVAILABLE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.696 -0400", hash_original_method = "8BE5EC4742BDBC547BA4DA345C8E71E1", hash_generated_method = "84CDF90E405019F5F1280B9B35B3CA30")
    @DSModeled(DSC.SAFE)
    public WifiP2pDevice(WifiP2pDevice source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.696 -0400", hash_original_method = "76992CA06444764D9CF7DB1AFF10640E", hash_generated_method = "EC7F85BDB3824E6D8CE1B02BD599CA68")
    @DSModeled(DSC.SAFE)
    public boolean wpsPbcSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_PUSHBUTTON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.696 -0400", hash_original_method = "B2A0BAE23B24F963FF842B8EAAF5D840", hash_generated_method = "6A04DD69C9CE4882B5F154493510DCE4")
    @DSModeled(DSC.SAFE)
    public boolean wpsKeypadSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_KEYPAD) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.697 -0400", hash_original_method = "89517E0D3099BE3BB50FEAB8A124BB8F", hash_generated_method = "999B9B56F6EEC48AD4683B36DEDCE420")
    @DSModeled(DSC.SAFE)
    public boolean wpsDisplaySupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (wpsConfigMethodsSupported & WPS_CONFIG_DISPLAY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.697 -0400", hash_original_method = "3FBC138270F4ADEAF27B9A0357206073", hash_generated_method = "42105B32268B15B9E359DBBFE6983BAF")
    @DSModeled(DSC.SAFE)
    public boolean isServiceDiscoveryCapable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (deviceCapability & DEVICE_CAPAB_SERVICE_DISCOVERY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.697 -0400", hash_original_method = "A041F8E96FF7F1638DE5EDEE0D23FE8B", hash_generated_method = "788F420701F8975AD92315DBFDB125FA")
    @DSModeled(DSC.SAFE)
    public boolean isGroupOwner() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (groupCapability & GROUP_CAPAB_GROUP_OWNER) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.697 -0400", hash_original_method = "09392A3C152DA1725DCCBD5DEBB248C2", hash_generated_method = "2B62FBCE0F420464763E89E0395192C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        WifiP2pDevice other;
        other = (WifiP2pDevice) obj;
        boolean varF2FEF16ABB9E6BF81AAF4EE3693DE3E5_1098600024 = (other.deviceAddress.equals(deviceAddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == obj) return true;
        //if (!(obj instanceof WifiP2pDevice)) return false;
        //WifiP2pDevice other = (WifiP2pDevice) obj;
        //if (other == null || other.deviceAddress == null) {
            //return (deviceAddress == null);
        //}
        //return other.deviceAddress.equals(deviceAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.698 -0400", hash_original_method = "016D59A2B811BA8203F4683B5513F2D5", hash_generated_method = "0465CD3288EBB1E05781BBE233449BD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
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
        String var0826C75FB1499484A6621049C9E9DB4E_308318478 = (sbuf.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.699 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.699 -0400", hash_original_method = "F1F1C1D05E28ABD7E03ACA6C9259AC2F", hash_generated_method = "3BE0E55D90D1C7D03E148EE8ADD3933D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(deviceName);
        dest.writeString(deviceAddress);
        dest.writeString(interfaceAddress);
        dest.writeString(primaryDeviceType);
        dest.writeString(secondaryDeviceType);
        dest.writeInt(wpsConfigMethodsSupported);
        dest.writeInt(deviceCapability);
        dest.writeInt(groupCapability);
        dest.writeInt(status);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.699 -0400", hash_original_method = "81EACEB4EB0E2420630EBFC84E59B2A4", hash_generated_method = "1EC035DC43CE734C846ECD8B1E73F00A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String trimQuotes(String str) {
        dsTaint.addTaint(str);
        str = str.trim();
        {
            boolean varCCC98BB190CD9DF38348CFC1F7E10DC7_610569245 = (str.startsWith("'") && str.endsWith("'"));
            {
                String var979ADBE8A269BA09CFB4A02C9B06EE07_703666009 = (str.substring(1, str.length()-1));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //str = str.trim();
        //if (str.startsWith("'") && str.endsWith("'")) {
            //return str.substring(1, str.length()-1);
        //}
        //return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.700 -0400", hash_original_method = "C0F4185566F115FC2220CE409C454DF3", hash_generated_method = "07BD64EDBA850D5349D4EF77EE28DE20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseHex(String hexString) {
        dsTaint.addTaint(hexString);
        int num;
        num = 0;
        {
            boolean var67CDF86B1EA52DCF199AB47995A915FB_1048530056 = (hexString.startsWith("0x") || hexString.startsWith("0X"));
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
        return dsTaint.getTaintInt();
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

    
    private static final String TAG = "WifiP2pDevice";
    private static final int WPS_CONFIG_DISPLAY         = 0x0008;
    private static final int WPS_CONFIG_PUSHBUTTON      = 0x0080;
    private static final int WPS_CONFIG_KEYPAD          = 0x0100;
    private static final int DEVICE_CAPAB_SERVICE_DISCOVERY         = 1;
    private static final int DEVICE_CAPAB_CLIENT_DISCOVERABILITY    = 1<<1;
    private static final int DEVICE_CAPAB_CONCURRENT_OPER           = 1<<2;
    private static final int DEVICE_CAPAB_INFRA_MANAGED             = 1<<3;
    private static final int DEVICE_CAPAB_DEVICE_LIMIT              = 1<<4;
    private static final int DEVICE_CAPAB_INVITATION_PROCEDURE      = 1<<5;
    private static final int GROUP_CAPAB_GROUP_OWNER                = 1;
    private static final int GROUP_CAPAB_PERSISTENT_GROUP           = 1<<1;
    private static final int GROUP_CAPAB_GROUP_LIMIT                = 1<<2;
    private static final int GROUP_CAPAB_INTRA_BSS_DIST             = 1<<3;
    private static final int GROUP_CAPAB_CROSS_CONN                 = 1<<4;
    private static final int GROUP_CAPAB_PERSISTENT_RECONN          = 1<<5;
    private static final int GROUP_CAPAB_GROUP_FORMATION            = 1<<6;
    public static final int CONNECTED   = 0;
    public static final int INVITED     = 1;
    public static final int FAILED      = 2;
    public static final int AVAILABLE   = 3;
    public static final int UNAVAILABLE = 4;
    public static final Creator<WifiP2pDevice> CREATOR = new Creator<WifiP2pDevice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.701 -0400", hash_original_method = "5387382CA16A3AD5682D1C391F3488A3", hash_generated_method = "86C324F68F41D08BE4DECE747CF7BDA4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pDevice createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiP2pDevice device;
            device = new WifiP2pDevice();
            device.deviceName = in.readString();
            device.deviceAddress = in.readString();
            device.interfaceAddress = in.readString();
            device.primaryDeviceType = in.readString();
            device.secondaryDeviceType = in.readString();
            device.wpsConfigMethodsSupported = in.readInt();
            device.deviceCapability = in.readInt();
            device.groupCapability = in.readInt();
            device.status = in.readInt();
            return (WifiP2pDevice)dsTaint.getTaint();
            // ---------- Original Method ----------
            //WifiP2pDevice device = new WifiP2pDevice();
            //device.deviceName = in.readString();
            //device.deviceAddress = in.readString();
            //device.interfaceAddress = in.readString();
            //device.primaryDeviceType = in.readString();
            //device.secondaryDeviceType = in.readString();
            //device.wpsConfigMethodsSupported = in.readInt();
            //device.deviceCapability = in.readInt();
            //device.groupCapability = in.readInt();
            //device.status = in.readInt();
            //return device;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.702 -0400", hash_original_method = "984A6A383474F78D9CC3B6A5D85D6E25", hash_generated_method = "E4F2D1432B6426B0DE6E8FB1CB4483FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pDevice[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiP2pDevice[] var99208EBA634625D42477211D16EC84DB_500787430 = (new WifiP2pDevice[size]);
            return (WifiP2pDevice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiP2pDevice[size];
        }

        
}; //Transformed anonymous class
}

