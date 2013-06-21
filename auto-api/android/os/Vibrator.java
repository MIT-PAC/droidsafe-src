package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class Vibrator {
    IVibratorService mService;
    private Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.391 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.391 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "E3C966F4FBDABBF477C4BF8659D939A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVibrator() {
        try 
        {
            boolean var5CDAA7782E0492C697AE35EAB5CE95A3_135156962 = (mService.hasVibrator());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.392 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "7A9A5B69626500F3B11AF2F4F092D4D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.392 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "16D4FD1AEF0A71E0A8BF1D437327330A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.392 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "CA18ED2B0743D8CDB9503A504E4ABAFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static final String TAG = "Vibrator";
}

