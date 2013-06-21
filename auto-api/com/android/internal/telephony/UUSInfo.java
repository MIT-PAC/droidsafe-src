package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UUSInfo {
    private int uusType;
    private int uusDcs;
    private byte[] uusData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.541 -0400", hash_original_method = "934109F2717BDFE423352F8C63ADD428", hash_generated_method = "70C59DBD978ED83225181802393CEE38")
    @DSModeled(DSC.SAFE)
    public UUSInfo() {
        this.uusType = UUS_TYPE1_IMPLICIT;
        this.uusDcs = UUS_DCS_IA5c;
        this.uusData = null;
        // ---------- Original Method ----------
        //this.uusType = UUS_TYPE1_IMPLICIT;
        //this.uusDcs = UUS_DCS_IA5c;
        //this.uusData = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.541 -0400", hash_original_method = "67CE668A0F9BB2CD8D45CC92B1E7FAE2", hash_generated_method = "8D1FD8157777099F8602FD5A7CEA343A")
    @DSModeled(DSC.SAFE)
    public UUSInfo(int uusType, int uusDcs, byte[] uusData) {
        dsTaint.addTaint(uusData[0]);
        dsTaint.addTaint(uusType);
        dsTaint.addTaint(uusDcs);
        // ---------- Original Method ----------
        //this.uusType = uusType;
        //this.uusDcs = uusDcs;
        //this.uusData = uusData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.542 -0400", hash_original_method = "352357FC22D874D178D2C62527C60010", hash_generated_method = "52516B2A5AAF7F042D3A8B61C2D51F0A")
    @DSModeled(DSC.SAFE)
    public int getDcs() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return uusDcs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.542 -0400", hash_original_method = "304C29E73AF67DC85E7B439D2558394F", hash_generated_method = "52846B2180B3B2EA51E92A43738A363B")
    @DSModeled(DSC.SAFE)
    public void setDcs(int uusDcs) {
        dsTaint.addTaint(uusDcs);
        // ---------- Original Method ----------
        //this.uusDcs = uusDcs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.542 -0400", hash_original_method = "C3F90AEC24B57BCB14BA37794741B56A", hash_generated_method = "91B8714B488AA84759D3E2DD7CA7D76F")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return uusType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.542 -0400", hash_original_method = "4FF18D0C69655C8ABC948EB5DB465A11", hash_generated_method = "B9FC7C99098F9171933C49C2FA8ECCF9")
    @DSModeled(DSC.SAFE)
    public void setType(int uusType) {
        dsTaint.addTaint(uusType);
        // ---------- Original Method ----------
        //this.uusType = uusType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.542 -0400", hash_original_method = "CBC9083E31E276860957A8B7835786FF", hash_generated_method = "6071F2498AC72DAAB29E7993171FCCEA")
    @DSModeled(DSC.SAFE)
    public byte[] getUserData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return uusData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.543 -0400", hash_original_method = "E6220F4E83328DF111D0B2120F7A66C4", hash_generated_method = "B5E43BAD7208893C9D4D853793CB5406")
    @DSModeled(DSC.SAFE)
    public void setUserData(byte[] uusData) {
        dsTaint.addTaint(uusData[0]);
        // ---------- Original Method ----------
        //this.uusData = uusData;
    }

    
    public static final int UUS_TYPE1_IMPLICIT = 0;
    public static final int UUS_TYPE1_REQUIRED = 1;
    public static final int UUS_TYPE1_NOT_REQUIRED = 2;
    public static final int UUS_TYPE2_REQUIRED = 3;
    public static final int UUS_TYPE2_NOT_REQUIRED = 4;
    public static final int UUS_TYPE3_REQUIRED = 5;
    public static final int UUS_TYPE3_NOT_REQUIRED = 6;
    public static final int UUS_DCS_USP = 0;
    public static final int UUS_DCS_OSIHLP = 1;
    public static final int UUS_DCS_X244 = 2;
    public static final int UUS_DCS_RMCF = 3;
    public static final int UUS_DCS_IA5c = 4;
}

