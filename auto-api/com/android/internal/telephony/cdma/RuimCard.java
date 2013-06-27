package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccCard;

public final class RuimCard extends IccCard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.572 -0400", hash_original_method = "B727D2F994ECB759A082BD5FA4C042CC", hash_generated_method = "4C1A14D0FB3EB9CF2B4B0F43B6F1D471")
      RuimCard(CDMAPhone phone, String LOG_TAG, boolean dbg) {
        super(phone, LOG_TAG, dbg);
        mPhone.mCM.registerForRUIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForRUIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        addTaint(phone.getTaint());
        addTaint(LOG_TAG.getTaint());
        addTaint(dbg);
        // ---------- Original Method ----------
        //mPhone.mCM.registerForRUIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForRUIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.572 -0400", hash_original_method = "E58435576E88AA9F55937FD79433F654", hash_generated_method = "8E19DBFC9E727A9EF26ACC64B2B5FD29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.573 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "8174A597FD8838B19A9647FD3880A4F4")
    @Override
    public String getServiceProviderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_869028308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_869028308 = mPhone.mIccRecords.getServiceProviderName();
        varB4EAC82CA7396A68D541C85D26508E83_869028308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_869028308;
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

