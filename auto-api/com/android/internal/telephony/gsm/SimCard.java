package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.TelephonyProperties;
import android.os.SystemProperties;

public final class SimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.935 -0400", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "48F6B09048B70FDC5A752417ED88BBEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SimCard(GSMPhone phone) {
        super(phone, "GSM", true);
        dsTaint.addTaint(phone.dsTaint);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.935 -0400", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "3C2172991E4B54EAE4BCB9EEE5970CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(logTag);
        dsTaint.addTaint(dbg.dsTaint);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_1950247648 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
            {
                mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
        //if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            //mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.935 -0400", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "05878F633CB86BF6DF58F6C60513EB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_1294725164 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
            {
                mPhone.mCM.unregisterForIccStatusChanged(mHandler);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispose();
        //mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        //mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        //mPhone.mCM.unregisterForSIMReady(mHandler);
        //if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            //mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.935 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "93B7E3BD022C61D8C353BB4B6E910CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getServiceProviderName() {
        String var9FE5486CA801680BBE841FA54F09C042_1760059747 = (mPhone.mIccRecords.getServiceProviderName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}


