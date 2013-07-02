package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.TelephonyProperties;
import android.os.SystemProperties;

public final class SimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.372 -0400", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "E09498EBAF4951C46FA1673122326F98")
      SimCard(GSMPhone phone) {
        super(phone, "GSM", true);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        addTaint(phone.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.372 -0400", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "37ACAAEA9365AD28E1F6D77CC29E7F3B")
    public  SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_212777724 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
            {
                mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
            } 
        } 
        addTaint(phone.getTaint());
        addTaint(logTag.getTaint());
        addTaint(dbg.getTaint());
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.372 -0400", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "D043695468A1EEF7FDB97B3569483382")
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_1536178883 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
            {
                mPhone.mCM.unregisterForIccStatusChanged(mHandler);
            } 
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.373 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "98708F304D725597CD54D3A913341334")
    @Override
    public String getServiceProviderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1600184977 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1600184977 = mPhone.mIccRecords.getServiceProviderName();
        varB4EAC82CA7396A68D541C85D26508E83_1600184977.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1600184977;
        
        
    }

    
}

