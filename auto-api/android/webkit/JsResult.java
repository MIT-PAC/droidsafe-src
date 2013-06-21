package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JsResult {
    private boolean mReady;
    private boolean mTriedToNotifyBeforeReady;
    protected boolean mResult;
    protected CallbackProxy mProxy;
    private boolean mDefaultValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.440 -0400", hash_original_method = "9B12FB4D59A264489E522CD061C38CB7", hash_generated_method = "BB179ABA921BE5B24C4AEE5416032256")
    @DSModeled(DSC.SAFE)
     JsResult(CallbackProxy proxy, boolean defaultVal) {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(defaultVal);
        // ---------- Original Method ----------
        //mProxy = proxy;
        //mDefaultValue = defaultVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.440 -0400", hash_original_method = "AA69245AF9AD4BDD3C62F81B883F32CE", hash_generated_method = "93D7125344977974C591E00A7EC98389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void cancel() {
        mResult = false;
        wakeUp();
        // ---------- Original Method ----------
        //mResult = false;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.441 -0400", hash_original_method = "600681B39DE4E67D9402AFEDAC93A2DE", hash_generated_method = "B2F187C8CA1B1351329BBAAAFCBDC899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void confirm() {
        mResult = true;
        wakeUp();
        // ---------- Original Method ----------
        //mResult = true;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.441 -0400", hash_original_method = "B19201A589B2161C860E375BCFC73111", hash_generated_method = "57D19D98378DA437940ADDAFF521A492")
    @DSModeled(DSC.SAFE)
    final boolean getResult() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.441 -0400", hash_original_method = "4642DDC2E06C70021EF03DDC6D972571", hash_generated_method = "B7A03F9A057A4A8C90ED0D033F8C3469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void setReady() {
        mReady = true;
        {
            wakeUp();
        } //End block
        // ---------- Original Method ----------
        //mReady = true;
        //if (mTriedToNotifyBeforeReady) {
            //wakeUp();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.441 -0400", hash_original_method = "0E860B2505C14EEFDBCB2EDE7B7F93FE", hash_generated_method = "90010F3DCBEA88A5D9DE027215972ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleDefault() {
        setReady();
        mResult = mDefaultValue;
        wakeUp();
        // ---------- Original Method ----------
        //setReady();
        //mResult = mDefaultValue;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.441 -0400", hash_original_method = "0B61C91975C53C4389CF807AA327DC1F", hash_generated_method = "EF2BB97B379096847B9799230934ACB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void wakeUp() {
        {
            {
                mProxy.notify();
            } //End block
        } //End block
        {
            mTriedToNotifyBeforeReady = true;
        } //End block
        // ---------- Original Method ----------
        //if (mReady) {
            //synchronized (mProxy) {
                //mProxy.notify();
            //}
        //} else {
            //mTriedToNotifyBeforeReady = true;
        //}
    }

    
}

