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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.671 -0400", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "E09498EBAF4951C46FA1673122326F98")
      SimCard(GSMPhone phone) {
        super(phone, "GSM", true);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        addTaint(phone.getTaint());
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.672 -0400", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "205774C55F56B8F3492276210482CAB0")
    public  SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_1237428152 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
            {
                mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
            } //End block
        } //End collapsed parenthetic
        addTaint(phone.getTaint());
        addTaint(logTag.getTaint());
        addTaint(dbg.getTaint());
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
        //if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            //mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.672 -0400", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "767A413B17CBF9E6309C4D662754D1EF")
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);
        {
            boolean varD10401BB32B3AED09684BD0E8044F683_1909510809 = (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.678 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "6461CF004A374E9785EBC86407DBEA1E")
    @Override
    public String getServiceProviderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1872341969 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1872341969 = mPhone.mIccRecords.getServiceProviderName();
        varB4EAC82CA7396A68D541C85D26508E83_1872341969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1872341969;
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

