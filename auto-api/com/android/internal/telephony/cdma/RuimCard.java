package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccCard;

public final class RuimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.803 -0400", hash_original_method = "B727D2F994ECB759A082BD5FA4C042CC", hash_generated_method = "EA138622B65B7906974EB247F1F8321D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuimCard(CDMAPhone phone, String LOG_TAG, boolean dbg) {
        super(phone, LOG_TAG, dbg);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(LOG_TAG);
        dsTaint.addTaint(dbg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.803 -0400", hash_original_method = "E58435576E88AA9F55937FD79433F654", hash_generated_method = "8E19DBFC9E727A9EF26ACC64B2B5FD29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.803 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "A5C3B5E84F0DFF934F6254ED33D59A58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getServiceProviderName() {
        String var9FE5486CA801680BBE841FA54F09C042_2071605185 = (mPhone.mIccRecords.getServiceProviderName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

