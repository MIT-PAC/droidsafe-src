package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccFileHandler;
import android.os.Message;

public final class CdmaLteUiccFileHandler extends IccFileHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.532 -0400", hash_original_method = "F91AC2EC8400C94DFA50E0DE5830B6E7", hash_generated_method = "55D9097BD813095DA861460F73FEBDDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaLteUiccFileHandler(CDMALTEPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.532 -0400", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "737101F321579C321F687393E13C7130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getEFPath(int efid) {
        dsTaint.addTaint(efid);
        String varB639013BA41DC6F5B70533E9F7DF8C99_1818665456 = (getCommonIccEFPath(efid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch(efid) {
        //case EF_CSIM_SPN:
        //case EF_CSIM_LI:
        //case EF_CSIM_MDN:
        //case EF_CSIM_IMSIM:
        //case EF_CSIM_CDMAHOME:
        //case EF_CSIM_EPRL:
            //return MF_SIM + DF_CDMA;
        //case EF_AD:
            //return MF_SIM + DF_GSM;
        //case EF_IMPI:
        //case EF_DOMAIN:
        //case EF_IMPU:
            //return MF_SIM + DF_ADFISIM;
        //}
        //return getCommonIccEFPath(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.533 -0400", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "38FE47EB8B3424AEB59FE457D2FF5A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void loadEFTransparent(int fileid, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(fileid);
        {
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            0, 0, 4, null, null,
                            obtainMessage(EVENT_READ_BINARY_DONE,
                                          fileid, 0, onLoaded));
        } //End block
        {
            super.loadEFTransparent(fileid, onLoaded);
        } //End block
        // ---------- Original Method ----------
        //if (fileid == EF_CSIM_EPRL) {
            //phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            //0, 0, 4, null, null,
                            //obtainMessage(EVENT_READ_BINARY_DONE,
                                          //fileid, 0, onLoaded));
        //} else {
            //super.loadEFTransparent(fileid, onLoaded);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.533 -0400", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "458504CD6D0125DE83AEFDC827DB9C16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logd(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.533 -0400", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "3198836BD581342A3A4EC4CAFE1C9919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String msg) {
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    static final String LOG_TAG = "CDMA";
}

