package android.net.wifi.p2p;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;
import java.util.regex.Pattern;

public class WifiP2pDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.132 -0400", hash_original_field = "271FEAE7FBE3640A38493945A82BE63F", hash_generated_field = "9A7D4F81FAFB7D27EA987849BE77B870")

    public String deviceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.132 -0400", hash_original_field = "519D99D9C5FAC874DB35B04A27557D9B", hash_generated_field = "AF33174D1ECF5398CFAFDB3DA69ECE9B")

    public String deviceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "3C3899100031989CA8DC1CD5899032D0", hash_generated_field = "D9677D104688FDB3640FCDFC7678BD77")

    public String interfaceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "5476575B2F57F8C80F22DEF75E8D228B", hash_generated_field = "C8560C786D68383CDDC32BE9AF81775C")

    public String primaryDeviceType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "92B3FF13AF549C4CD6B5B65E360FEEE7", hash_generated_field = "A0E2331A45EBC682CDD39EC85B9272F4")

    public String secondaryDeviceType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "9B21FABAED5EBC11E1EF7EE8AF35DC3F", hash_generated_field = "057DC56034FD8E15F0EE29D17084FE88")

    public int wpsConfigMethodsSupported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "01840975B61547AAF4F354C1A4E68B58", hash_generated_field = "24F1D51080FEAB5C6723A8A0299BEEA4")

    public int deviceCapability;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "F8E080D14294024BBDA5AD376B3C6CB0", hash_generated_field = "A7627F4B2A75A5A2B99BAF760EB86A74")

    public int groupCapability;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.133 -0400", hash_original_field = "44C13B312673A1B4CD877AF886680F7D", hash_generated_field = "0FCEE9D7758B8948ABBBB774FA2E2C5C")

    public int status = UNAVAILABLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.134 -0400", hash_original_method = "6DEE1BC764FD2CB933A4912269652401", hash_generated_method = "F64008BCEC449AEC52DED02A9FF6F441")
    public  WifiP2pDevice() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.136 -0400", hash_original_method = "B4DFEB594E50AA2111054B3A3A6DF197", hash_generated_method = "E02B60B4D92D559A45105D665FA0D9F5")
    public  WifiP2pDevice(String string) throws IllegalArgumentException {
        String[] tokens = string.split(" ");
    if(tokens.length < 1)        
        {
            IllegalArgumentException varC6004F11587813439225B94CE376D336_1445488896 = new IllegalArgumentException("Malformed supplicant event");
            varC6004F11587813439225B94CE376D336_1445488896.addTaint(taint);
            throw varC6004F11587813439225B94CE376D336_1445488896;
        } 
    if(tokens.length == 1)        
        {
            deviceAddress = string;
            return;
        } 
for(String token : tokens)
        {
            String[] nameValue = token.split("=");
    if(nameValue.length != 2)            
            continue;
    if(nameValue[0].equals("p2p_dev_addr"))            
            {
                deviceAddress = nameValue[1];
                continue;
            } 
    if(nameValue[0].equals("pri_dev_type"))            
            {
                primaryDeviceType = nameValue[1];
                continue;
            } 
    if(nameValue[0].equals("name"))            
            {
                deviceName = trimQuotes(nameValue[1]);
                continue;
            } 
    if(nameValue[0].equals("config_methods"))            
            {
                wpsConfigMethodsSupported = parseHex(nameValue[1]);
                continue;
            } 
    if(nameValue[0].equals("dev_capab"))            
            {
                deviceCapability = parseHex(nameValue[1]);
                continue;
            } 
    if(nameValue[0].equals("group_capab"))            
            {
                groupCapability = parseHex(nameValue[1]);
                continue;
            } 
        } 
    if(tokens[0].startsWith("P2P-DEVICE-FOUND"))        
        {
            status = AVAILABLE;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.137 -0400", hash_original_method = "8BE5EC4742BDBC547BA4DA345C8E71E1", hash_generated_method = "DA5AC86B594A9ED5697AEB6D0BB3C08F")
    public  WifiP2pDevice(WifiP2pDevice source) {
    if(source != null)        
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
        } 
        
        
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.138 -0400", hash_original_method = "76992CA06444764D9CF7DB1AFF10640E", hash_generated_method = "93CCDE1B42606723D42B46110E6B7578")
    public boolean wpsPbcSupported() {
        boolean var3C08D742A43F3CA6BCBC29B07201315B_678003651 = ((wpsConfigMethodsSupported & WPS_CONFIG_PUSHBUTTON) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346596633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346596633;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.138 -0400", hash_original_method = "B2A0BAE23B24F963FF842B8EAAF5D840", hash_generated_method = "B53642ECF4DD2E20CD2FEFDD48FBBE24")
    public boolean wpsKeypadSupported() {
        boolean var1C14923349E39578A26384C6AAF203C8_1198042623 = ((wpsConfigMethodsSupported & WPS_CONFIG_KEYPAD) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188212143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188212143;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.138 -0400", hash_original_method = "89517E0D3099BE3BB50FEAB8A124BB8F", hash_generated_method = "E99299A35DDD614C3F8F7263EFCAAC18")
    public boolean wpsDisplaySupported() {
        boolean var26C0ADF20D06F65D2845F4DBA6CB06E9_1375015733 = ((wpsConfigMethodsSupported & WPS_CONFIG_DISPLAY) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602051106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602051106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.139 -0400", hash_original_method = "3FBC138270F4ADEAF27B9A0357206073", hash_generated_method = "9CA007C0F6CDF3BCB2C213965D7F5EA2")
    public boolean isServiceDiscoveryCapable() {
        boolean var5EA4B87FB1FADC800F9BA0C2976C9B9B_654679432 = ((deviceCapability & DEVICE_CAPAB_SERVICE_DISCOVERY) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774525671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774525671;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.139 -0400", hash_original_method = "A041F8E96FF7F1638DE5EDEE0D23FE8B", hash_generated_method = "6366353FF088994A66DD2FAA79CA66FB")
    public boolean isGroupOwner() {
        boolean var5AA29A5D99A1CCDE4C4E4C88D30C9F46_1168515314 = ((groupCapability & GROUP_CAPAB_GROUP_OWNER) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027184788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027184788;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.139 -0400", hash_original_method = "09392A3C152DA1725DCCBD5DEBB248C2", hash_generated_method = "BE0377C63836D514DEC4C2DD88C8DB41")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_317988224 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981135642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_981135642;
        }
    if(!(obj instanceof WifiP2pDevice))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1836430084 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16264497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16264497;
        }
        WifiP2pDevice other = (WifiP2pDevice) obj;
    if(other == null || other.deviceAddress == null)        
        {
            boolean var0D483FE855C694067868829C3EC1FDB2_550043579 = ((deviceAddress == null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588491372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_588491372;
        } 
        boolean varBA854C6752A405C2F84DE40A233F53E0_19932565 = (other.deviceAddress.equals(deviceAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383887260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383887260;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.140 -0400", hash_original_method = "016D59A2B811BA8203F4683B5513F2D5", hash_generated_method = "A66B5AA6A52CCD6EE951D78DA805154F")
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
String var69222FFA45D1268AEE1923C5558B0BD5_846022831 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_846022831.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_846022831;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.140 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B2E924A4FD70525AF9B885A5A543F833")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1086140651 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202850837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202850837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.141 -0400", hash_original_method = "F1F1C1D05E28ABD7E03ACA6C9259AC2F", hash_generated_method = "CAC736DCC6093181C1E19002887B656A")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.142 -0400", hash_original_method = "81EACEB4EB0E2420630EBFC84E59B2A4", hash_generated_method = "8C7163017954E3E7103D439C53AFB9D5")
    private String trimQuotes(String str) {
        addTaint(str.getTaint());
        str = str.trim();
    if(str.startsWith("'") && str.endsWith("'"))        
        {
String var8B365E7532D232C6C0049AB493A762A6_1485853008 =             str.substring(1, str.length()-1);
            var8B365E7532D232C6C0049AB493A762A6_1485853008.addTaint(taint);
            return var8B365E7532D232C6C0049AB493A762A6_1485853008;
        } 
String var061B89662D09DE43FE2A2D88636258A2_1435452816 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1435452816.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1435452816;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.142 -0400", hash_original_method = "C0F4185566F115FC2220CE409C454DF3", hash_generated_method = "73F2708678C6C6A024A26F18AEF5D8A0")
    private int parseHex(String hexString) {
        addTaint(hexString.getTaint());
        int num = 0;
    if(hexString.startsWith("0x") || hexString.startsWith("0X"))        
        {
            hexString = hexString.substring(2);
        } 
        try 
        {
            num = Integer.parseInt(hexString, 16);
        } 
        catch (NumberFormatException e)
        {
        } 
        int var0FC3CFBC27E91EA60A787DE13DAE3E3C_1391790727 = (num);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585006851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585006851;
        
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "AE43CB08180DDB93087C004ADAB60C50", hash_generated_field = "2D3FA46E684AAF11DB903AED32FED7F0")

    private static final String TAG = "WifiP2pDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "8598204F3C37E7E1F5019D0FBDF50847", hash_generated_field = "D2C76F901E5BC3A5C02272862E00F60C")

    private static final int WPS_CONFIG_DISPLAY = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "32FDFB589F79EA959F0618C849371C92", hash_generated_field = "78E701778F1AAA542995E26A9F4815B3")

    private static final int WPS_CONFIG_PUSHBUTTON = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "A677601AA4FDC4E1C90E63620FB86358", hash_generated_field = "4441C9AC819F241188C2F8B8A1223F6F")

    private static final int WPS_CONFIG_KEYPAD = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "64E3C91CE49305F32DF8E49258AF40F6", hash_generated_field = "ED7E840AF6B67252A5F338FC4F9F5C16")

    private static final int DEVICE_CAPAB_SERVICE_DISCOVERY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "848A578E2570E7EBD1C50FBED0CC6E34", hash_generated_field = "B3F55D1FD38440F6A01D01E71751E240")

    private static final int DEVICE_CAPAB_CLIENT_DISCOVERABILITY = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "22F2BB19D52A359661973536C90EE58F", hash_generated_field = "C11C29B1C6B7394FEDFE0A204E03D494")

    private static final int DEVICE_CAPAB_CONCURRENT_OPER = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "D3F2BF333B7E0DE0788F68FB9992E66D", hash_generated_field = "E4889542C18A4CAD394FE39FD0A7E53A")

    private static final int DEVICE_CAPAB_INFRA_MANAGED = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "FAE3F8097286B2388CB5E9E722FA9376", hash_generated_field = "C6FDFEE4D831077E17A8F87B79E1542B")

    private static final int DEVICE_CAPAB_DEVICE_LIMIT = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.143 -0400", hash_original_field = "6ADE38D2E2FE37191B2F042452FA7CA6", hash_generated_field = "E11BF5DA4C652DC3885D2F89B8BC8CBC")

    private static final int DEVICE_CAPAB_INVITATION_PROCEDURE = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "DE296303D36B91631485D4E1AB7E6C9B", hash_generated_field = "660117B2CCF1684725E38F606720D4F8")

    private static final int GROUP_CAPAB_GROUP_OWNER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "B5C1065E7C45300EE1C1FEE28BEC039A", hash_generated_field = "1ED43ED6AC42E70FA6E2AE19C57697F9")

    private static final int GROUP_CAPAB_PERSISTENT_GROUP = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "E6C7146C910619650200D213B9387ED7", hash_generated_field = "0E2B6BAC640107ABB60FC85978FC8B33")

    private static final int GROUP_CAPAB_GROUP_LIMIT = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "8C0EFCE86E4ECC424E835E5919446ADF", hash_generated_field = "B55D83B08662B8007693B6A4BCB60BB7")

    private static final int GROUP_CAPAB_INTRA_BSS_DIST = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "32DCF2A6593404424A352455EA15DB35", hash_generated_field = "A7083D15E179404DC8C6B584349D2977")

    private static final int GROUP_CAPAB_CROSS_CONN = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "15694CADE2F6777E124BD9136061231B", hash_generated_field = "B109428E0DF961D64558D4C2EB0C7A20")

    private static final int GROUP_CAPAB_PERSISTENT_RECONN = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.144 -0400", hash_original_field = "8471780A070C5212C3BE09A278FE278B", hash_generated_field = "ABA5135F62F4403CCC24802B45944736")

    private static final int GROUP_CAPAB_GROUP_FORMATION = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "6B5E0957DCB6301BBFD7E668EB84B035", hash_generated_field = "C64FAE939570F571A8BAE24D1B70BD13")

    public static final int CONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "06D821117E1B6D57A639606827F9604E", hash_generated_field = "B6613B33DED36EABAC0CBA0C7B969929")

    public static final int INVITED     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "72D423E6C58FCDECEC7381F5C89F6C03", hash_generated_field = "CFFB40C2E01759BFC10D884F773E1A4F")

    public static final int FAILED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "1478E7FA7161A6AE612B8761D910DB5B", hash_generated_field = "3420700E53DA1A9A7046D001075E3AE8")

    public static final int AVAILABLE   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "9BB63F437347685327DE4C4126C58692", hash_generated_field = "EBDD50BA8ED35706997081541733CA67")

    public static final int UNAVAILABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.145 -0400", hash_original_field = "9AB723F7F4AC03B860BFCAE90A6330E9", hash_generated_field = "C2F80F230659999E6A4528EC4530DF69")

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
    
}

