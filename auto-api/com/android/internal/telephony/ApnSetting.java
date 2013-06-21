package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ApnSetting {
    public String carrier;
    public String apn;
    public String proxy;
    public String port;
    public String mmsc;
    public String mmsProxy;
    public String mmsPort;
    public String user;
    public String password;
    public int authType;
    public String[] types;
    public int id;
    public String numeric;
    public String protocol;
    public String roamingProtocol;
    public boolean carrierEnabled;
    public int bearer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.689 -0400", hash_original_method = "F17703E22091A1B5F76C15F7BC9ABE4F", hash_generated_method = "BB15B98682A467A526BC7352468BF6F3")
    @DSModeled(DSC.SAFE)
    public ApnSetting(int id, String numeric, String carrier, String apn,
            String proxy, String port,
            String mmsc, String mmsProxy, String mmsPort,
            String user, String password, int authType, String[] types,
            String protocol, String roamingProtocol, boolean carrierEnabled, int bearer) {
        dsTaint.addTaint(bearer);
        dsTaint.addTaint(port);
        dsTaint.addTaint(carrierEnabled);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(numeric);
        dsTaint.addTaint(mmsc);
        dsTaint.addTaint(password);
        dsTaint.addTaint(id);
        dsTaint.addTaint(roamingProtocol);
        dsTaint.addTaint(proxy);
        dsTaint.addTaint(carrier);
        dsTaint.addTaint(mmsProxy);
        dsTaint.addTaint(authType);
        dsTaint.addTaint(types[0]);
        dsTaint.addTaint(apn);
        dsTaint.addTaint(mmsPort);
        dsTaint.addTaint(user);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.691 -0400", hash_original_method = "A2933E4E94FCB15D27495600AE7ECB36", hash_generated_method = "CBD8EB3537E72AEAD9745722C41500DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
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
        {
            int i;
            i = 0;
            {
                sb.append(types[i]);
                {
                    sb.append(" | ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        sb.append(", ").append(protocol);
        sb.append(", ").append(roamingProtocol);
        sb.append(", ").append(carrierEnabled);
        sb.append(", ").append(bearer);
        String var806458D832AB974D230FEE4CBBDBD390_1700783330 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.695 -0400", hash_original_method = "36728FD5FCF430F65422B3FEF52D0F76", hash_generated_method = "FB49C78CA58920BA11B64BBB890F867C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canHandleType(String type) {
        dsTaint.addTaint(type);
        {
            String t = types[0];
            {
                {
                    boolean var7778B6DC68CF430DFDEB2873C3E5C489_1868332050 = (t.equals(type) || t.equals(Phone.APN_TYPE_ALL) ||
                    (t.equals(Phone.APN_TYPE_DEFAULT) &&
                    type.equals(Phone.APN_TYPE_HIPRI)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.696 -0400", hash_original_method = "08D43BEDE35E924972E54800A3F170A8", hash_generated_method = "BCEDF5ED075771E596E07896C8B1754C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var115C3123BE82B2431D507F47953FF07E_2016221627 = ((this.toString().equals(o.toString())));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof ApnSetting == false) return false;
        //return (this.toString().equals(o.toString()));
    }

    
    static final String V2_FORMAT_REGEX = "^\\[ApnSettingV2\\]\\s*";
}

