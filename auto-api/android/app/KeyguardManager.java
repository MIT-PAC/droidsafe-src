package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.162 -0400", hash_original_method = "5B69E23112A7A32F8407EC1FFE36B34D", hash_generated_method = "3C92E03D678C4B924547CF2813CCA769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     KeyguardManager() {
        mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        // ---------- Original Method ----------
        //mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.162 -0400", hash_original_method = "5C652CD18FFB9FB973F397E439BEDA7E", hash_generated_method = "99CB664D51A5CABC7EA0AC224A68B9A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public KeyguardLock newKeyguardLock(String tag) {
        dsTaint.addTaint(tag);
        KeyguardLock var436D658029F1FBD4F58985E57BEF9C78_1787753589 = (new KeyguardLock(tag));
        return (KeyguardLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyguardLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.163 -0400", hash_original_method = "A2184A2736F97B1687D11E2CDBE84F5B", hash_generated_method = "7C6F9266CBA63395F130EAC05A7C8BE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isKeyguardLocked() {
        try 
        {
            boolean var48B9435D4B101DE12A3DCD069D2F7A58_1122976045 = (mWM.isKeyguardLocked());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.163 -0400", hash_original_method = "D9B1D6FBA38958F439C4BED06843FB22", hash_generated_method = "8CCF01B7E1DC5636C881D8BD643E55F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isKeyguardSecure() {
        try 
        {
            boolean var72AFE6D50FD40100A4042D4D858724FD_947021937 = (mWM.isKeyguardSecure());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.164 -0400", hash_original_method = "4D76893BACDA286FED51AB2B592BACEE", hash_generated_method = "BAC6307808AB9615DFE1CEE7C942B0D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean inKeyguardRestrictedInputMode() {
        try 
        {
            boolean var4688DD4A673F3F9603D7BAE9FE98157D_1641736865 = (mWM.inKeyguardRestrictedInputMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.164 -0400", hash_original_method = "FE8F5B525A90789B7FAA52BD35F0F030", hash_generated_method = "08AEACEE22811AB51E6E40802B70B88C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void exitKeyguardSecurely(final OnKeyguardExitResult callback) {
        dsTaint.addTaint(callback.dsTaint);
        try 
        {
            mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.164 -0400", hash_original_method = "3EC2E5FCC08061EF9551EB1CD521B8A8", hash_generated_method = "E7B7C3BF18DF6F093B1D19C42654F4E6")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onKeyguardExitResult(boolean success) throws RemoteException {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(success);
                    callback.onKeyguardExitResult(success);
                    // ---------- Original Method ----------
                    //callback.onKeyguardExitResult(success);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.165 -0400", hash_original_method = "4D032B51654914D2B6BB0DA8DB46B141", hash_generated_method = "FEE5E12C569EFDFCB79579217253E06F")
        @DSModeled(DSC.SAFE)
         KeyguardLock(String tag) {
            dsTaint.addTaint(tag);
            // ---------- Original Method ----------
            //mTag = tag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.165 -0400", hash_original_method = "D57DA4E953B853BFA2A0F53D32EDF463", hash_generated_method = "2FF67CACB261606C9E6B981D2D5839CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.165 -0400", hash_original_method = "A230379C02A7A7A26A0484D5752F5D3C", hash_generated_method = "3BEF0EE8C309CB5122A032C7D34DBE94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

