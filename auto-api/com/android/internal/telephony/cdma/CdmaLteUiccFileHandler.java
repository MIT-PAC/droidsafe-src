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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.923 -0400", hash_original_method = "F91AC2EC8400C94DFA50E0DE5830B6E7", hash_generated_method = "CE2FF0BDB64F66AEEF51F473190BEDAB")
      CdmaLteUiccFileHandler(CDMALTEPhone phone) {
        super(phone);
        addTaint(phone.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.923 -0400", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "A1D747B1C080037349A15E8367E192A5")
    protected String getEFPath(int efid) {
        String varB4EAC82CA7396A68D541C85D26508E83_1960239099 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_939757110 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_905538229 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_927885652 = null; //Variable for return #4
        //Begin case EF_CSIM_SPN EF_CSIM_LI EF_CSIM_MDN EF_CSIM_IMSIM EF_CSIM_CDMAHOME EF_CSIM_EPRL 
        varB4EAC82CA7396A68D541C85D26508E83_1960239099 = MF_SIM + DF_CDMA;
        //End case EF_CSIM_SPN EF_CSIM_LI EF_CSIM_MDN EF_CSIM_IMSIM EF_CSIM_CDMAHOME EF_CSIM_EPRL 
        //Begin case EF_AD 
        varB4EAC82CA7396A68D541C85D26508E83_939757110 = MF_SIM + DF_GSM;
        //End case EF_AD 
        //Begin case EF_IMPI EF_DOMAIN EF_IMPU 
        varB4EAC82CA7396A68D541C85D26508E83_905538229 = MF_SIM + DF_ADFISIM;
        //End case EF_IMPI EF_DOMAIN EF_IMPU 
        varB4EAC82CA7396A68D541C85D26508E83_927885652 = getCommonIccEFPath(efid);
        addTaint(efid);
        String varA7E53CE21691AB073D9660D615818899_1189950549; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_1960239099;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_939757110;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_905538229;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_927885652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1189950549.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1189950549;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "4C04F00BCB703E4EFAE5F363E603B98C")
    @Override
    public void loadEFTransparent(int fileid, Message onLoaded) {
        {
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            0, 0, 4, null, null,
                            obtainMessage(EVENT_READ_BINARY_DONE,
                                          fileid, 0, onLoaded));
        } //End block
        {
            super.loadEFTransparent(fileid, onLoaded);
        } //End block
        addTaint(fileid);
        addTaint(onLoaded.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "80CD08E6ED0BE069C01C8E7F6AED97E9")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "716A6202FD80821EFA4FCD5E3A01AB59")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
}

