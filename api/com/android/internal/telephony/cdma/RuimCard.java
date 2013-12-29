package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.telephony.IccCard;



public final class RuimCard extends IccCard {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.216 -0500", hash_original_method = "B727D2F994ECB759A082BD5FA4C042CC", hash_generated_method = "B727D2F994ECB759A082BD5FA4C042CC")
    RuimCard(CDMAPhone phone, String LOG_TAG, boolean dbg) {
        super(phone, LOG_TAG, dbg);
        mPhone.mCM.registerForRUIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForRUIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.217 -0500", hash_original_method = "E58435576E88AA9F55937FD79433F654", hash_generated_method = "C2192FF6807B31AE4C9E0CAC9EA2CC79")
    @Override
public void dispose() {
        super.dispose();
        //Unregister for all events
        mPhone.mCM.unregisterForRUIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForRUIMReady(mHandler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.218 -0500", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "0EDAD9D4EAB75FE9706C00B6C5AE3662")
    @Override
public String getServiceProviderName () {
        return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

