package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class JsResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.709 -0500", hash_original_field = "83914817B5695355805A1E02640480C2", hash_generated_field = "26A6070CDE592271AECF8680D22F56EE")

    // ready to handle it.
    private boolean mReady;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.712 -0500", hash_original_field = "F3608284D80D94EED5809EAD615F2E56", hash_generated_field = "DBA679B57EBDAD06E7175E445513626C")

    // is ready.
    private boolean mTriedToNotifyBeforeReady;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.714 -0500", hash_original_field = "C6DF67E193487DBE805C425277CD0BAE", hash_generated_field = "169513F3A1AEE2077AC5E7B61DDCBE55")

    protected boolean mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.716 -0500", hash_original_field = "1E5369AF7A9DB6B943C6C44A25559283", hash_generated_field = "93CB6B6B857D4AEC6718FFA552717B6F")

    protected  CallbackProxy mProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.718 -0500", hash_original_field = "35D048265130B20AB5BA7653DC5E5DA7", hash_generated_field = "C65A41BB850ACA3B55CD2C0CC2F7144A")

    private  boolean mDefaultValue;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.725 -0500", hash_original_method = "9B12FB4D59A264489E522CD061C38CB7", hash_generated_method = "9B12FB4D59A264489E522CD061C38CB7")
    
JsResult(CallbackProxy proxy, boolean defaultVal) {
        mProxy = proxy;
        mDefaultValue = defaultVal;
    }

    /**
     * Handle the result if the user cancelled the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.720 -0500", hash_original_method = "AA69245AF9AD4BDD3C62F81B883F32CE", hash_generated_method = "1B275A6F39C10C052D7EF49093FFA34B")
    
public final void cancel() {
        mResult = false;
        wakeUp();
    }

    /**
     * Handle a confirmation response from the user.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.722 -0500", hash_original_method = "600681B39DE4E67D9402AFEDAC93A2DE", hash_generated_method = "C95AD86C921BF59FC64E8F9566591A20")
    
public final void confirm() {
        mResult = true;
        wakeUp();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.727 -0500", hash_original_method = "B19201A589B2161C860E375BCFC73111", hash_generated_method = "1BA024346F9531D85D136101E5D63312")
    
final boolean getResult() {
        return mResult;
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.729 -0500", hash_original_method = "4642DDC2E06C70021EF03DDC6D972571", hash_generated_method = "A638CE09C26842DDBC63307852F58667")
    
final void setReady() {
        mReady = true;
        if (mTriedToNotifyBeforeReady) {
            wakeUp();
        }
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.731 -0500", hash_original_method = "0E860B2505C14EEFDBCB2EDE7B7F93FE", hash_generated_method = "0E860B2505C14EEFDBCB2EDE7B7F93FE")
    
void handleDefault() {
        setReady();
        mResult = mDefaultValue;
        wakeUp();
    }

    /* Wake up the WebCore thread. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.734 -0500", hash_original_method = "0B61C91975C53C4389CF807AA327DC1F", hash_generated_method = "E22CF063C081F4FA4BE4F2C95B1FF744")
    
protected final void wakeUp() {
        if (mReady) {
            synchronized (mProxy) {
                mProxy.notify();
            }
        } else {
            mTriedToNotifyBeforeReady = true;
        }
    }
    
}

