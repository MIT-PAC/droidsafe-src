package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JsResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.990 -0400", hash_original_field = "8A034D9D40F5DCF35C77C64C24C4BF76", hash_generated_field = "D1199D18CCA330DECA84293F8FD8B1E5")

    private boolean mReady;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.990 -0400", hash_original_field = "18043B6632AEE172BD7E09EF0FB91A14", hash_generated_field = "C5E029DC197B3311D56EE909873B4AF0")

    private boolean mTriedToNotifyBeforeReady;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.990 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "169513F3A1AEE2077AC5E7B61DDCBE55")

    protected boolean mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.990 -0400", hash_original_field = "7D88DE9DD0EF018B770128257B4D159F", hash_generated_field = "93CB6B6B857D4AEC6718FFA552717B6F")

    protected CallbackProxy mProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.990 -0400", hash_original_field = "3D9F826E2A85D6A96D8493A9F2E57CAC", hash_generated_field = "C65A41BB850ACA3B55CD2C0CC2F7144A")

    private boolean mDefaultValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.991 -0400", hash_original_method = "9B12FB4D59A264489E522CD061C38CB7", hash_generated_method = "9274A70F7ACCF58449D48131F2AB5396")
      JsResult(CallbackProxy proxy, boolean defaultVal) {
        mProxy = proxy;
        mDefaultValue = defaultVal;
        // ---------- Original Method ----------
        //mProxy = proxy;
        //mDefaultValue = defaultVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.991 -0400", hash_original_method = "AA69245AF9AD4BDD3C62F81B883F32CE", hash_generated_method = "93D7125344977974C591E00A7EC98389")
    public final void cancel() {
        mResult = false;
        wakeUp();
        // ---------- Original Method ----------
        //mResult = false;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.991 -0400", hash_original_method = "600681B39DE4E67D9402AFEDAC93A2DE", hash_generated_method = "B2F187C8CA1B1351329BBAAAFCBDC899")
    public final void confirm() {
        mResult = true;
        wakeUp();
        // ---------- Original Method ----------
        //mResult = true;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.992 -0400", hash_original_method = "B19201A589B2161C860E375BCFC73111", hash_generated_method = "10340FA07BDE495279B3A75AA5159368")
    final boolean getResult() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29133899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29133899;
        // ---------- Original Method ----------
        //return mResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.992 -0400", hash_original_method = "4642DDC2E06C70021EF03DDC6D972571", hash_generated_method = "B7A03F9A057A4A8C90ED0D033F8C3469")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.992 -0400", hash_original_method = "0E860B2505C14EEFDBCB2EDE7B7F93FE", hash_generated_method = "90010F3DCBEA88A5D9DE027215972ED1")
     void handleDefault() {
        setReady();
        mResult = mDefaultValue;
        wakeUp();
        // ---------- Original Method ----------
        //setReady();
        //mResult = mDefaultValue;
        //wakeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.993 -0400", hash_original_method = "0B61C91975C53C4389CF807AA327DC1F", hash_generated_method = "EF2BB97B379096847B9799230934ACB6")
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

