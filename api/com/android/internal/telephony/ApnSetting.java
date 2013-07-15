package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ApnSetting {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.815 -0400", hash_original_field = "D45EC3C4AF38967DE454F9E45BB1CEF4", hash_generated_field = "1B56B32F4BBBFCB07F306A0886B2F6DD")

    public String carrier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.815 -0400", hash_original_field = "006F1F60AC2C8635325E1AE37581797A", hash_generated_field = "43C67387F9D911D56E54C3F641D51852")

    public String apn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.815 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "204F02D2F127442F5112CF2440745992")

    public String proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.815 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "B29C4253E03CC2A3CB8BF39AE0A2E0B8")

    public String port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.815 -0400", hash_original_field = "BB1697FE6E01DB169450DB10E0A5F5C5", hash_generated_field = "EB442594E5C6CB6F271D09EB2CE6F4D6")

    public String mmsc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "7C0A166C947C00F136A7C6C5F0234458", hash_generated_field = "04E859DEEB689204B556F76B5E3CC499")

    public String mmsProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "F0AB7A19DFFBCCA97CEB7F6686991DD3", hash_generated_field = "6EF8897D8A281D751BA5B5366F199ABE")

    public String mmsPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "EE11CBB19052E40B07AAC0CA060C23EE", hash_generated_field = "0D37FB1187DC93A5CBFAB3C14B0F27FB")

    public String user;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "0446FA69F560C33BCB5F21BC6DCFB254")

    public String password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "280FA711B12D488436B7CDCBFB2543FC", hash_generated_field = "32526975D8C21A7F3ED70D70FA9B4A95")

    public int authType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "C14D67F278B4AD2B78219EA179DE6529")

    public String[] types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "49057168D24DC9566533EC48326CED2C", hash_generated_field = "E8F4A660D351A64CFB19BF1938B21CA7")

    public String numeric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "3A97C2FA19B2163E578F6919D504ED80")

    public String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "ED60CE11CA492684E5D2ED6F8D0101DF", hash_generated_field = "A23BC43BD5E5C02CE697183561409560")

    public String roamingProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "4F380BD482C68A16CFC5784FB21813FE", hash_generated_field = "B7CB42509FAEFB23D011734CE6D1C670")

    public boolean carrierEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.816 -0400", hash_original_field = "040D78A40AE0C384FB528C3EEDCD65F1", hash_generated_field = "CACBC7F220FD0DABA80B6499EE2FA7B6")

    public int bearer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.820 -0400", hash_original_method = "F17703E22091A1B5F76C15F7BC9ABE4F", hash_generated_method = "734F820B59160C8D91EB5207CDDB46F5")
    public  ApnSetting(int id, String numeric, String carrier, String apn,
            String proxy, String port,
            String mmsc, String mmsProxy, String mmsPort,
            String user, String password, int authType, String[] types,
            String protocol, String roamingProtocol, boolean carrierEnabled, int bearer) {
        this.id = id;
        this.numeric = numeric;
        this.carrier = carrier;
        this.apn = apn;
        this.proxy = proxy;
        this.port = port;
        this.mmsc = mmsc;
        this.mmsProxy = mmsProxy;
        this.mmsPort = mmsPort;
        this.user = user;
        this.password = password;
        this.authType = authType;
        this.types = types;
        this.protocol = protocol;
        this.roamingProtocol = roamingProtocol;
        this.carrierEnabled = carrierEnabled;
        this.bearer = bearer;
        // ---------- Original Method ----------
        //this.id = id;
        //this.numeric = numeric;
        //this.carrier = carrier;
        //this.apn = apn;
        //this.proxy = proxy;
        //this.port = port;
        //this.mmsc = mmsc;
        //this.mmsProxy = mmsProxy;
        //this.mmsPort = mmsPort;
        //this.user = user;
        //this.password = password;
        //this.authType = authType;
        //this.types = types;
        //this.protocol = protocol;
        //this.roamingProtocol = roamingProtocol;
        //this.carrierEnabled = carrierEnabled;
        //this.bearer = bearer;
    }

    
        public static ApnSetting fromString(String data) {
        if (data == null) return null;
        int version;
        if (data.matches(V2_FORMAT_REGEX + ".*")) {
            version = 2;
            data = data.replaceFirst(V2_FORMAT_REGEX, "");
        } else {
            version = 1;
        }
        String[] a = data.split("\\s*,\\s*");
        if (a.length < 14) {
            return null;
        }
        int authType;
        try {
            authType = Integer.parseInt(a[12]);
        } catch (Exception e) {
            authType = 0;
        }
        String[] typeArray;
        String protocol, roamingProtocol;
        boolean carrierEnabled;
        int bearer;
        if (version == 1) {
            typeArray = new String[a.length - 13];
            System.arraycopy(a, 13, typeArray, 0, a.length - 13);
            protocol = RILConstants.SETUP_DATA_PROTOCOL_IP;
            roamingProtocol = RILConstants.SETUP_DATA_PROTOCOL_IP;
            carrierEnabled = true;
            bearer = 0;
        } else {
            if (a.length < 18) {
                return null;
            }
            typeArray = a[13].split("\\s*\\|\\s*");
            protocol = a[14];
            roamingProtocol = a[15];
            try {
                carrierEnabled = Boolean.parseBoolean(a[16]);
            } catch (Exception e) {
                carrierEnabled = true;
            }
            bearer = Integer.parseInt(a[17]);
        }
        return new ApnSetting(-1,a[10]+a[11],a[0],a[1],a[2],a[3],a[7],a[8],
                a[9],a[4],a[5],authType,typeArray,protocol,roamingProtocol,carrierEnabled,bearer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.821 -0400", hash_original_method = "A2933E4E94FCB15D27495600AE7ECB36", hash_generated_method = "F0819CB30063F4A30D1F4B5EBEDED260")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ApnSettingV2] ")
        .append(carrier)
        .append(", ").append(id)
        .append(", ").append(numeric)
        .append(", ").append(apn)
        .append(", ").append(proxy)
        .append(", ").append(mmsc)
        .append(", ").append(mmsProxy)
        .append(", ").append(mmsPort)
        .append(", ").append(port)
        .append(", ").append(authType).append(", ");
for(int i = 0;i < types.length;i++)
        {
            sb.append(types[i]);
    if(i < types.length - 1)            
            {
                sb.append(" | ");
            } //End block
        } //End block
        sb.append(", ").append(protocol);
        sb.append(", ").append(roamingProtocol);
        sb.append(", ").append(carrierEnabled);
        sb.append(", ").append(bearer);
String var2460B846747F8B22185AD8BE722266A5_44165301 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_44165301.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_44165301;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.822 -0400", hash_original_method = "36728FD5FCF430F65422B3FEF52D0F76", hash_generated_method = "D6F6F3EF499FD012AAB7B77E923846FB")
    public boolean canHandleType(String type) {
        addTaint(type.getTaint());
for(String t : types)
        {
    if(t.equals(type) || t.equals(Phone.APN_TYPE_ALL) ||
                    (t.equals(Phone.APN_TYPE_DEFAULT) &&
                    type.equals(Phone.APN_TYPE_HIPRI)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1305608587 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274884061 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_274884061;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1554464180 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159665420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159665420;
        // ---------- Original Method ----------
        //for (String t : types) {
            //if (t.equals(type) || t.equals(Phone.APN_TYPE_ALL) ||
                    //(t.equals(Phone.APN_TYPE_DEFAULT) &&
                    //type.equals(Phone.APN_TYPE_HIPRI))) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.823 -0400", hash_original_method = "08D43BEDE35E924972E54800A3F170A8", hash_generated_method = "5789F93F7811C4DC74662EDB19C70A07")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof ApnSetting == false)        
        {
        boolean var68934A3E9455FA72420237EB05902327_289125439 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243241908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_243241908;
        }
        boolean var16EE280E18A7FF37820D23FDCEA22EBD_97381100 = ((this.toString().equals(o.toString())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780389478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780389478;
        // ---------- Original Method ----------
        //if (o instanceof ApnSetting == false) return false;
        //return (this.toString().equals(o.toString()));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.823 -0400", hash_original_field = "1F57D45CD0E569AD1BA08CA6A234DDE5", hash_generated_field = "98446639026B9F4F206499ECD891F44B")

    static final String V2_FORMAT_REGEX = "^\\[ApnSettingV2\\]\\s*";
}

