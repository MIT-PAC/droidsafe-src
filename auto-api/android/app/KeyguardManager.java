package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.ServiceManager;
import android.view.IWindowManager;
import android.view.IOnKeyguardExitResult;

public class KeyguardManager {
    private IWindowManager mWM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.985 -0400", hash_original_method = "5B69E23112A7A32F8407EC1FFE36B34D", hash_generated_method = "EFFAD22E3E70165F8A6DE7F8E2A13108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     KeyguardManager() {
        mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        // ---------- Original Method ----------
        //mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.985 -0400", hash_original_method = "5C652CD18FFB9FB973F397E439BEDA7E", hash_generated_method = "F59DD2513586F919570DD6786DA6DE35")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public KeyguardLock newKeyguardLock(String tag) {
        dsTaint.addTaint(tag);
        return (KeyguardLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyguardLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.985 -0400", hash_original_method = "A2184A2736F97B1687D11E2CDBE84F5B", hash_generated_method = "34388FDE0552E4A883C523C7B59C7DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isKeyguardLocked() {
        try 
        {
            boolean var48B9435D4B101DE12A3DCD069D2F7A58_1201742876 = (mWM.isKeyguardLocked());
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardLocked();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.986 -0400", hash_original_method = "D9B1D6FBA38958F439C4BED06843FB22", hash_generated_method = "1B97F4EB96549A2E6D9955A7FF4D4523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isKeyguardSecure() {
        try 
        {
            boolean var72AFE6D50FD40100A4042D4D858724FD_895612438 = (mWM.isKeyguardSecure());
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardSecure();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.986 -0400", hash_original_method = "4D76893BACDA286FED51AB2B592BACEE", hash_generated_method = "E96C35FDF6A39CF55CC3EDE33F838A8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean inKeyguardRestrictedInputMode() {
        try 
        {
            boolean var4688DD4A673F3F9603D7BAE9FE98157D_730256705 = (mWM.inKeyguardRestrictedInputMode());
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mWM.inKeyguardRestrictedInputMode();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.986 -0400", hash_original_method = "FE8F5B525A90789B7FAA52BD35F0F030", hash_generated_method = "0E1F8E72067D335D994BBA5E21CD841D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void exitKeyguardSecurely(final OnKeyguardExitResult callback) {
        dsTaint.addTaint(callback.dsTaint);
        try 
        {
            mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() {
                public void onKeyguardExitResult(boolean success) throws RemoteException {
                    callback.onKeyguardExitResult(success);
                }
            });
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() {
                //public void onKeyguardExitResult(boolean success) throws RemoteException {
                    //callback.onKeyguardExitResult(success);
                //}
            //});
        //} catch (RemoteException e) {
        //}
    }

    
    public class KeyguardLock {
        private IBinder mToken = new Binder();
        private String mTag;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.986 -0400", hash_original_method = "4D032B51654914D2B6BB0DA8DB46B141", hash_generated_method = "1017F71A68D29820629C992EA8412401")
        @DSModeled(DSC.SAFE)
         KeyguardLock(String tag) {
            dsTaint.addTaint(tag);
            // ---------- Original Method ----------
            //mTag = tag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.987 -0400", hash_original_method = "D57DA4E953B853BFA2A0F53D32EDF463", hash_generated_method = "7D29C2533A88D8A1F1F3609D5AAD6C4C")
        @DSModeled(DSC.SAFE)
        public void disableKeyguard() {
            try 
            {
                mWM.disableKeyguard(mToken, mTag);
            } //End block
            catch (RemoteException ex)
            { }
            // ---------- Original Method ----------
            //try {
                //mWM.disableKeyguard(mToken, mTag);
            //} catch (RemoteException ex) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.987 -0400", hash_original_method = "A230379C02A7A7A26A0484D5752F5D3C", hash_generated_method = "12E6E4C94377BF65F5107BADDE49EE4C")
        @DSModeled(DSC.SAFE)
        public void reenableKeyguard() {
            try 
            {
                mWM.reenableKeyguard(mToken);
            } //End block
            catch (RemoteException ex)
            { }
            // ---------- Original Method ----------
            //try {
                //mWM.reenableKeyguard(mToken);
            //} catch (RemoteException ex) {
            //}
        }

        
    }


    
    public interface OnKeyguardExitResult {

        
        void onKeyguardExitResult(boolean success);
    }
    
}


