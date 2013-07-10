package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.923 -0400", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "A1D747B1C080037349A15E8367E192A5")
    protected String getEFPath(int efid) {
        String varB4EAC82CA7396A68D541C85D26508E83_1960239099 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_939757110 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_905538229 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_927885652 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1960239099 = MF_SIM + DF_CDMA;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_939757110 = MF_SIM + DF_GSM;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_905538229 = MF_SIM + DF_ADFISIM;
        
        varB4EAC82CA7396A68D541C85D26508E83_927885652 = getCommonIccEFPath(efid);
        addTaint(efid);
        String varA7E53CE21691AB073D9660D615818899_1189950549; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_1960239099;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_939757110;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_905538229;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1189950549 = varB4EAC82CA7396A68D541C85D26508E83_927885652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1189950549.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1189950549;
        
        
        
        
        
        
        
        
            
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "4C04F00BCB703E4EFAE5F363E603B98C")
    @Override
    public void loadEFTransparent(int fileid, Message onLoaded) {
        {
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            0, 0, 4, null, null,
                            obtainMessage(EVENT_READ_BINARY_DONE,
                                          fileid, 0, onLoaded));
        } 
        {
            super.loadEFTransparent(fileid, onLoaded);
        } 
        addTaint(fileid);
        addTaint(onLoaded.getTaint());
        
        
            
                            
                            
                                          
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "80CD08E6ED0BE069C01C8E7F6AED97E9")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "716A6202FD80821EFA4FCD5E3A01AB59")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.924 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
}

