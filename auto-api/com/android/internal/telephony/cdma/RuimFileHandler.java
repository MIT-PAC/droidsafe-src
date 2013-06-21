package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccException;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccFileTypeMismatch;
import com.android.internal.telephony.IccIoResult;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneProxy;
import java.util.ArrayList;

public final class RuimFileHandler extends IccFileHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "CF453B27C96776BB45DA5C39513E79B9", hash_generated_method = "39632A23D7E4439B4CBB55E4ADE9AEC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuimFileHandler(CDMAPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "CF724477DA2C2A9786B4BE9A808F0A43", hash_generated_method = "306A6DED831E1F700C7DE363599E8A4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        Log.d(LOG_TAG, "RuimFileHandler finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "RuimFileHandler finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "7CD46C2339603E91E870121ED1EC8F59", hash_generated_method = "711698560D3E5424B7DD0E39B4B92133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(lowOffset);
        dsTaint.addTaint(length);
        dsTaint.addTaint(highOffset);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, "img", 0, 0,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                //onLoaded);
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, "img", 0, 0,
                //GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "C6E3EA3638A1123EDA1C37F1352177B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        super.handleMessage(msg);
        // ---------- Original Method ----------
        //super.handleMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.806 -0400", hash_original_method = "607B460DC742A6DBDB6C6AB4B03B96A2", hash_generated_method = "C473187DA2198773F6A9AACBD8B8D8F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getEFPath(int efid) {
        dsTaint.addTaint(efid);
        String varB639013BA41DC6F5B70533E9F7DF8C99_881571524 = (getCommonIccEFPath(efid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch(efid) {
        //case EF_SMS:
        //case EF_CST:
        //case EF_RUIM_SPN:
            //return MF_SIM + DF_CDMA;
        //}
        //return getCommonIccEFPath(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.807 -0400", hash_original_method = "14F2EAD0BAAC0C4A3E4A3932F0B0B9F3", hash_generated_method = "A3A80C71C0F8042EA8E500FCBC900F29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logd(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[RuimFileHandler] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.807 -0400", hash_original_method = "6458B63A49DDA09CACB99172BE6F4B0B", hash_generated_method = "DC4853C2EFABC4C7E76149E3DEBFEA09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String msg) {
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimFileHandler] " + msg);
    }

    
    static final String LOG_TAG = "CDMA";
}

