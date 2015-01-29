package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IOnKeyguardExitResult;
import android.view.IWindowManager;

public class KeyguardManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.636 -0500", hash_original_field = "71165EAD9C083BBFAF16999CC816A558", hash_generated_field = "900206E0E1CB232AC9B36B78FD174716")

    private IWindowManager mWM;
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.547 -0400", hash_original_method = "5B69E23112A7A32F8407EC1FFE36B34D", hash_generated_method = "3C92E03D678C4B924547CF2813CCA769")
    public KeyguardManager() {
        //mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        // ---------- Original Method ----------
        //mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
    }

    /**
     * @deprecated Use {@link android.view.WindowManager.LayoutParams#FLAG_DISMISS_KEYGUARD}
     * and/or {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED}
     * instead; this allows you to seamlessly hide the keyguard as your application
     * moves in and out of the foreground and does not require that any special
     * permissions be requested.
     *
     * Enables you to lock or unlock the keyboard. Get an instance of this class by
     * calling {@link android.content.Context#getSystemService(java.lang.String) Context.getSystemService()}. 
     * This class is wrapped by {@link android.app.KeyguardManager KeyguardManager}.
     * @param tag A tag that informally identifies who you are (for debugging who
     *   is disabling he keyguard).
     *
     * @return A {@link KeyguardLock} handle to use to disable and reenable the
     *   keyguard.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.657 -0500", hash_original_method = "5C652CD18FFB9FB973F397E439BEDA7E", hash_generated_method = "CD6447334B6D5472BB47560DDD8C84F3")
    
@Deprecated
    public KeyguardLock newKeyguardLock(String tag) {
        return new KeyguardLock(tag);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.547 -0400", hash_original_method = "A2184A2736F97B1687D11E2CDBE84F5B", hash_generated_method = "3D2D001658EBF59BB5DB37E17C504095")
    public boolean isKeyguardLocked() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardLocked();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.547 -0400", hash_original_method = "D9B1D6FBA38958F439C4BED06843FB22", hash_generated_method = "F8860485DA1511952057E7BEF480512D")
    public boolean isKeyguardSecure() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardSecure();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }
    
    @DSComment("device control")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.548 -0400", hash_original_method = "4D76893BACDA286FED51AB2B592BACEE", hash_generated_method = "35AC64A1ADCA8D6D4F4AC5E9F5EA7C98")
    public boolean inKeyguardRestrictedInputMode() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.inKeyguardRestrictedInputMode();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    /**
     * @deprecated Use {@link android.view.WindowManager.LayoutParams#FLAG_DISMISS_KEYGUARD}
     * and/or {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED}
     * instead; this allows you to seamlessly hide the keyguard as your application
     * moves in and out of the foreground and does not require that any special
     * permissions be requested.
     *
     * Exit the keyguard securely.  The use case for this api is that, after
     * disabling the keyguard, your app, which was granted permission to
     * disable the keyguard and show a limited amount of information deemed
     * safe without the user getting past the keyguard, needs to navigate to
     * something that is not safe to view without getting past the keyguard.
     *
     * This will, if the keyguard is secure, bring up the unlock screen of
     * the keyguard.
     *
     * @param callback Let's you know whether the operation was succesful and
     *   it is safe to launch anything that would normally be considered safe
     *   once the user has gotten past the keyguard.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.669 -0500", hash_original_method = "FE8F5B525A90789B7FAA52BD35F0F030", hash_generated_method = "3DBA21B3C6F2E1FCDFFFE6D6B1EA77BE")
    
@Deprecated
    public void exitKeyguardSecurely(final OnKeyguardExitResult callback) {
        try {
            mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() {
                public void onKeyguardExitResult(boolean success) throws RemoteException {
                    callback.onKeyguardExitResult(success);
                }
            });
        } catch (RemoteException e) {

        }
    }
    
    public class KeyguardLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.639 -0500", hash_original_field = "0DA9108D2E2A711522F589279D2F355A", hash_generated_field = "0A3D50E0763C2392A4FD5877627E0D78")

        private IBinder mToken = new Binder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.642 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.644 -0500", hash_original_method = "4D032B51654914D2B6BB0DA8DB46B141", hash_generated_method = "4D032B51654914D2B6BB0DA8DB46B141")
        
KeyguardLock(String tag) {
            mTag = tag;
        }
        
        public KeyguardLock() {
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.549 -0400", hash_original_method = "D57DA4E953B853BFA2A0F53D32EDF463", hash_generated_method = "D28A2D90780DAE2B162143289BBBC835")
        public void disableKeyguard() {
            addTaint(false);
            /*
            try 
            {
                mWM.disableKeyguard(mToken, mTag);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
            */
            // ---------- Original Method ----------
            //try {
                //mWM.disableKeyguard(mToken, mTag);
            //} catch (RemoteException ex) {
            //}
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.549 -0400", hash_original_method = "A230379C02A7A7A26A0484D5752F5D3C", hash_generated_method = "6EFC040D730E4BC7C0E18A5339E6A4D2")
        public void reenableKeyguard() {
            addTaint(true);
            /*
            try 
            {
                mWM.reenableKeyguard(mToken);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
            */
            // ---------- Original Method ----------
            //try {
                //mWM.reenableKeyguard(mToken);
            //} catch (RemoteException ex) {
            //}
        }
        
    }
    
    public interface OnKeyguardExitResult {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onKeyguardExitResult(boolean success);
    }
    
}

