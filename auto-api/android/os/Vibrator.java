package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class Vibrator {
    private static String TAG = "Vibrator";
    IVibratorService mService;
    private Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.351 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "EE7052073461539AFD3B766C3F4A4D51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.354 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "5C42FA5C3C23E18A1361CFE75DFBEA1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVibrator() {
        try 
        {
            boolean var5CDAA7782E0492C697AE35EAB5CE95A3_1494928467 = (mService.hasVibrator());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return false;
        //}
        //try {
            //return mService.hasVibrator();
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.354 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "37BFFAF55678674879D964498B03506A")
    @DSModeled(DSC.SAFE)
    public void vibrate(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        try 
        {
            mService.vibrate(milliseconds, mToken);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return;
        //}
        //try {
            //mService.vibrate(milliseconds, mToken);
        //} catch (RemoteException e) {
            //Log.w(TAG, "Failed to vibrate.", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.355 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "8BC3532E8A4026995A3D4C82025D69A9")
    @DSModeled(DSC.SAFE)
    public void vibrate(long[] pattern, int repeat) {
        dsTaint.addTaint(pattern[0]);
        dsTaint.addTaint(repeat);
        {
            try 
            {
                mService.vibratePattern(pattern, repeat, mToken);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return;
        //}
        //if (repeat < pattern.length) {
            //try {
                //mService.vibratePattern(pattern, repeat, mToken);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed to vibrate.", e);
            //}
        //} else {
            //throw new ArrayIndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.360 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "F17B63824EFFCF67ACB3C5B09750AF08")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        try 
        {
            mService.cancelVibrate(mToken);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (mService == null) {
            //return;
        //}
        //try {
            //mService.cancelVibrate(mToken);
        //} catch (RemoteException e) {
            //Log.w(TAG, "Failed to cancel vibration.", e);
        //}
    }

    
}


