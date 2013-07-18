package com.android.internal.telephony.cdma;

// Droidsafe Imports
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class CdmaLteUiccFileHandler extends IccFileHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.770 -0400", hash_original_method = "F91AC2EC8400C94DFA50E0DE5830B6E7", hash_generated_method = "CE2FF0BDB64F66AEEF51F473190BEDAB")
      CdmaLteUiccFileHandler(CDMALTEPhone phone) {
        super(phone);
        addTaint(phone.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.771 -0400", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "0285DB39E034E21E683D8D888BC585E6")
    protected String getEFPath(int efid) {
        addTaint(efid);
switch(efid){
        case EF_CSIM_SPN:
        case EF_CSIM_LI:
        case EF_CSIM_MDN:
        case EF_CSIM_IMSIM:
        case EF_CSIM_CDMAHOME:
        case EF_CSIM_EPRL:
String varA39241C94F461998BF062D2228896F50_2108971703 =         MF_SIM + DF_CDMA;
        varA39241C94F461998BF062D2228896F50_2108971703.addTaint(taint);
        return varA39241C94F461998BF062D2228896F50_2108971703;
        case EF_AD:
String varFA2EA53600AD8E391FF729ACE748F1EA_947062579 =         MF_SIM + DF_GSM;
        varFA2EA53600AD8E391FF729ACE748F1EA_947062579.addTaint(taint);
        return varFA2EA53600AD8E391FF729ACE748F1EA_947062579;
        case EF_IMPI:
        case EF_DOMAIN:
        case EF_IMPU:
String varF4D283B5C0D01F03F5830893B3B42A1A_929733933 =         MF_SIM + DF_ADFISIM;
        varF4D283B5C0D01F03F5830893B3B42A1A_929733933.addTaint(taint);
        return varF4D283B5C0D01F03F5830893B3B42A1A_929733933;
}String var1CB5B6A61B4429889211CCB6597A0DD8_117205372 =         getCommonIccEFPath(efid);
        var1CB5B6A61B4429889211CCB6597A0DD8_117205372.addTaint(taint);
        return var1CB5B6A61B4429889211CCB6597A0DD8_117205372;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.772 -0400", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "D9C95A21FD183A1E3C1F81666B5EADA2")
    @Override
    public void loadEFTransparent(int fileid, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(fileid);
        if(fileid == EF_CSIM_EPRL)        
        {
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            0, 0, 4, null, null,
                            obtainMessage(EVENT_READ_BINARY_DONE,
                                          fileid, 0, onLoaded));
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.772 -0400", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "4BE1957A5EF6E784777E741487538607")
    protected void logd(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.773 -0400", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "716A6202FD80821EFA4FCD5E3A01AB59")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.773 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
}

