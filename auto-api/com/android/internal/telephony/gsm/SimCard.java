package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.TelephonyProperties;
import android.os.SystemProperties;

public final class SimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.808 -0400", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "7BE12F6FE6EFE17685F1309F10498A09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.809 -0400", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "2C7F0B2AD865DC65438D25A9D75C89AF")
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
            boolean varD10401BB32B3AED09684BD0E8044F683_972387235 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.810 -0400", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "C3124BB6192C69E33EBCC73300E7571D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_543475799 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.812 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "0BA00511F59E9668D0323E6028D18194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getServiceProviderName() {
        String var9FE5486CA801680BBE841FA54F09C042_1690541228 = (mPhone.mIccRecords.getServiceProviderName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

