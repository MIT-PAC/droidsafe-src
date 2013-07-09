package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.480 -0400", hash_original_method = "CF453B27C96776BB45DA5C39513E79B9", hash_generated_method = "5FD7ADC0DD4EB4164DE52029EA7F7906")
      RuimFileHandler(CDMAPhone phone) {
        super(phone);
        addTaint(phone.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.480 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.480 -0400", hash_original_method = "CF724477DA2C2A9786B4BE9A808F0A43", hash_generated_method = "306A6DED831E1F700C7DE363599E8A4A")
    protected void finalize() {
        Log.d(LOG_TAG, "RuimFileHandler finalized");
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.481 -0400", hash_original_method = "7CD46C2339603E91E870121ED1EC8F59", hash_generated_method = "871F8ED116268B489F5E9E85BB42BAB5")
    @Override
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, "img", 0, 0,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
        addTaint(fileid);
        addTaint(highOffset);
        addTaint(lowOffset);
        addTaint(length);
        addTaint(onLoaded.getTaint());
        
        
                
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.481 -0400", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "3D6F3DBC2E4A8D25910B641F329886F5")
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.481 -0400", hash_original_method = "607B460DC742A6DBDB6C6AB4B03B96A2", hash_generated_method = "04CB4A48A7162589EC8A35E599C1FA9F")
    protected String getEFPath(int efid) {
        String varB4EAC82CA7396A68D541C85D26508E83_1400486228 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_575828802 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1400486228 = MF_SIM + DF_CDMA;
        
        varB4EAC82CA7396A68D541C85D26508E83_575828802 = getCommonIccEFPath(efid);
        addTaint(efid);
        String varA7E53CE21691AB073D9660D615818899_433258027; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_433258027 = varB4EAC82CA7396A68D541C85D26508E83_1400486228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_433258027 = varB4EAC82CA7396A68D541C85D26508E83_575828802;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_433258027.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_433258027;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.481 -0400", hash_original_method = "14F2EAD0BAAC0C4A3E4A3932F0B0B9F3", hash_generated_method = "05B1F89A4716A294366F2429C1802A7D")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[RuimFileHandler] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.482 -0400", hash_original_method = "6458B63A49DDA09CACB99172BE6F4B0B", hash_generated_method = "225A20AF544E5C4E447675F604DA0459")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.482 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
}

