package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;

public class Vibrator {
    private static final String TAG = "Vibrator";
    IVibratorService mService;
    private final Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.035 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "EE7052073461539AFD3B766C3F4A4D51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.035 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "4C4DE5D6282F5090EA7795FC2A6C6BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVibrator() {
        try 
        {
            boolean var5CDAA7782E0492C697AE35EAB5CE95A3_2097823928 = (mService.hasVibrator());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.035 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "37BFFAF55678674879D964498B03506A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.035 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "3593047A9409D0159ED97261869D3383")
    @DSModeled(DSC.SAFE)
    public void vibrate(long[] pattern, int repeat) {
        dsTaint.addTaint(pattern);
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
            throw new ArrayIndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.035 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "F17B63824EFFCF67ACB3C5B09750AF08")
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


