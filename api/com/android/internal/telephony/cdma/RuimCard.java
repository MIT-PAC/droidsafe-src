package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.IccCard;

public final class RuimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.043 -0400", hash_original_method = "B727D2F994ECB759A082BD5FA4C042CC", hash_generated_method = "12CD7D1BE32F686D8502CB075C19CD00")
      RuimCard(CDMAPhone phone, String LOG_TAG, boolean dbg) {
        super(phone, LOG_TAG, dbg);
        addTaint(dbg);
        addTaint(LOG_TAG.getTaint());
        addTaint(phone.getTaint());
        mPhone.mCM.registerForRUIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForRUIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        // ---------- Original Method ----------
        //mPhone.mCM.registerForRUIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForRUIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.043 -0400", hash_original_method = "E58435576E88AA9F55937FD79433F654", hash_generated_method = "8E19DBFC9E727A9EF26ACC64B2B5FD29")
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForRUIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForRUIMReady(mHandler);
        // ---------- Original Method ----------
        //super.dispose();
        //mPhone.mCM.unregisterForRUIMLockedOrAbsent(mHandler);
        //mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        //mPhone.mCM.unregisterForRUIMReady(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.044 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "B26C959D3B72AD628BB594E118D0E8EF")
    @Override
    public String getServiceProviderName() {
String var7F74CA4F27DBD97ED17E538302BDEBEB_450164764 =         mPhone.mIccRecords.getServiceProviderName();
        var7F74CA4F27DBD97ED17E538302BDEBEB_450164764.addTaint(taint);
        return var7F74CA4F27DBD97ED17E538302BDEBEB_450164764;
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

