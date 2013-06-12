package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class UUSInfo {
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
    private int uusType;
    private int uusDcs;
    private byte[] uusData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "934109F2717BDFE423352F8C63ADD428", hash_generated_method = "A5B9C8DD2C274331AFC643B7D4B96FB0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "67CE668A0F9BB2CD8D45CC92B1E7FAE2", hash_generated_method = "30A931ADE0A1F640E43E650152628B53")
    @DSModeled(DSC.SAFE)
    public UUSInfo(int uusType, int uusDcs, byte[] uusData) {
        dsTaint.addTaint(uusData);
        dsTaint.addTaint(uusType);
        dsTaint.addTaint(uusDcs);
        // ---------- Original Method ----------
        //this.uusType = uusType;
        //this.uusDcs = uusDcs;
        //this.uusData = uusData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "352357FC22D874D178D2C62527C60010", hash_generated_method = "0C30F769F19EC7442E969EB4CC568E69")
    @DSModeled(DSC.SAFE)
    public int getDcs() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return uusDcs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "304C29E73AF67DC85E7B439D2558394F", hash_generated_method = "E58B215746402CB812522987A14AC46F")
    @DSModeled(DSC.SAFE)
    public void setDcs(int uusDcs) {
        dsTaint.addTaint(uusDcs);
        // ---------- Original Method ----------
        //this.uusDcs = uusDcs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "C3F90AEC24B57BCB14BA37794741B56A", hash_generated_method = "69BAE73BB3CA296BDB35B563DA5A2B9C")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return uusType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "4FF18D0C69655C8ABC948EB5DB465A11", hash_generated_method = "BA1B02037D482E984D04A8EBB83EA3FD")
    @DSModeled(DSC.SAFE)
    public void setType(int uusType) {
        dsTaint.addTaint(uusType);
        // ---------- Original Method ----------
        //this.uusType = uusType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "CBC9083E31E276860957A8B7835786FF", hash_generated_method = "7A065572ED003ABF6553CCD48B00065B")
    @DSModeled(DSC.SAFE)
    public byte[] getUserData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return uusData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.598 -0400", hash_original_method = "E6220F4E83328DF111D0B2120F7A66C4", hash_generated_method = "C79B655F6F10C82D9191ABFDD15D4954")
    @DSModeled(DSC.SAFE)
    public void setUserData(byte[] uusData) {
        dsTaint.addTaint(uusData);
        // ---------- Original Method ----------
        //this.uusData = uusData;
    }

    
}


