package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;



public final class SimCard extends IccCard {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.902 -0500", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "9F0A913CCE42D6EF6B4C91409D578CD8")
    
SimCard(GSMPhone phone) {
        super(phone, "GSM", true);

        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
    }

    /**
    * We have the Sim card for LTE on CDMA phone
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.905 -0500", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "647189C2CD6450042C1E09FC5061E0A6")
    
public SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();

        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.909 -0500", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "33F8948DD521027B438452D2D16395AF")
    
@Override
    public void dispose() {
        super.dispose();
        //Unregister for all events
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);

        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.912 -0500", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "0EDAD9D4EAB75FE9706C00B6C5AE3662")
    
@Override
    public String getServiceProviderName () {
        return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

