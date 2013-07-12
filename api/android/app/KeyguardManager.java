package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.ServiceManager;
import android.view.IWindowManager;
import android.view.IOnKeyguardExitResult;

public class KeyguardManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.674 -0400", hash_original_field = "4FEDCF33DA439800CB483956AE637716", hash_generated_field = "900206E0E1CB232AC9B36B78FD174716")

    private IWindowManager mWM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.675 -0400", hash_original_method = "5B69E23112A7A32F8407EC1FFE36B34D", hash_generated_method = "3C92E03D678C4B924547CF2813CCA769")
      KeyguardManager() {
        mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        // ---------- Original Method ----------
        //mWM = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.675 -0400", hash_original_method = "5C652CD18FFB9FB973F397E439BEDA7E", hash_generated_method = "2E3D9D56DC2DD9362339E6DB59475B0A")
    @Deprecated
    public KeyguardLock newKeyguardLock(String tag) {
        addTaint(tag.getTaint());
KeyguardLock varF94DC7E8A9793C7121D37FAB19D77E2D_2116941310 =         new KeyguardLock(tag);
        varF94DC7E8A9793C7121D37FAB19D77E2D_2116941310.addTaint(taint);
        return varF94DC7E8A9793C7121D37FAB19D77E2D_2116941310;
        // ---------- Original Method ----------
        //return new KeyguardLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.676 -0400", hash_original_method = "A2184A2736F97B1687D11E2CDBE84F5B", hash_generated_method = "AB72A71DB817E2A21EEA4EE9CBFABEF5")
    public boolean isKeyguardLocked() {
        try 
        {
            boolean var3C36CA7330DB079E34B974089829DB13_449243492 = (mWM.isKeyguardLocked());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207493116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207493116;
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1808600976 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371672938 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_371672938;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardLocked();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.676 -0400", hash_original_method = "D9B1D6FBA38958F439C4BED06843FB22", hash_generated_method = "56FEA4E982EABD6E5FE5B96A744A732A")
    public boolean isKeyguardSecure() {
        try 
        {
            boolean varE5A33C01CE2969B848F2F3442C462F84_1088459290 = (mWM.isKeyguardSecure());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136252191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_136252191;
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_455461565 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30117087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_30117087;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mWM.isKeyguardSecure();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.677 -0400", hash_original_method = "4D76893BACDA286FED51AB2B592BACEE", hash_generated_method = "481D2798B621DFF412FD8FB9563AFCB3")
    public boolean inKeyguardRestrictedInputMode() {
        try 
        {
            boolean var264F95E421F60912B701F635207F7053_1252498810 = (mWM.inKeyguardRestrictedInputMode());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068066492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068066492;
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_351444881 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577028629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_577028629;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mWM.inKeyguardRestrictedInputMode();
        //} catch (RemoteException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.678 -0400", hash_original_method = "FE8F5B525A90789B7FAA52BD35F0F030", hash_generated_method = "8766D492BBAE7C97FDBE453226DC6338")
    @Deprecated
    public void exitKeyguardSecurely(final OnKeyguardExitResult callback) {
        addTaint(callback.getTaint());
        try 
        {
            mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.678 -0400", hash_original_method = "3EC2E5FCC08061EF9551EB1CD521B8A8", hash_generated_method = "D3CE17FC8F30A272A316DE9D2D6CBA05")
        public void onKeyguardExitResult(boolean success) throws RemoteException {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(success);
            callback.onKeyguardExitResult(success);
            // ---------- Original Method ----------
            //callback.onKeyguardExitResult(success);
        }
});
        } //End block
        catch (RemoteException e)
        {
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.679 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "0A3D50E0763C2392A4FD5877627E0D78")

        private IBinder mToken = new Binder();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.679 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.680 -0400", hash_original_method = "4D032B51654914D2B6BB0DA8DB46B141", hash_generated_method = "C4956F8D2CA9FF0EA9184C6E2220865C")
          KeyguardLock(String tag) {
            mTag = tag;
            // ---------- Original Method ----------
            //mTag = tag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.681 -0400", hash_original_method = "D57DA4E953B853BFA2A0F53D32EDF463", hash_generated_method = "D28A2D90780DAE2B162143289BBBC835")
        public void disableKeyguard() {
            try 
            {
                mWM.disableKeyguard(mToken, mTag);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
            // ---------- Original Method ----------
            //try {
                //mWM.disableKeyguard(mToken, mTag);
            //} catch (RemoteException ex) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.681 -0400", hash_original_method = "A230379C02A7A7A26A0484D5752F5D3C", hash_generated_method = "6EFC040D730E4BC7C0E18A5339E6A4D2")
        public void reenableKeyguard() {
            try 
            {
                mWM.reenableKeyguard(mToken);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
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

