package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class Vibrator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.659 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6D5176DB6DC642185DCF8E32C5EC1BC9")

    IVibratorService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.659 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "FC3A8406FD823CC8C4E230612CCD0C74")

    private Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.660 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    public  Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.669 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "8EA13B07191C58BE7F7CFC0DF973D182")
    public boolean hasVibrator() {
        try 
        {
            boolean var5CDAA7782E0492C697AE35EAB5CE95A3_1492346599 = (mService.hasVibrator());
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839480942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839480942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.670 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "F037A67D35643E415E9C55D7CEECE9AE")
    public void vibrate(long milliseconds) {
        try 
        {
            mService.vibrate(milliseconds, mToken);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(milliseconds);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.671 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "746057240AF49A69237F19353942DFA9")
    public void vibrate(long[] pattern, int repeat) {
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
        addTaint(pattern[0]);
        addTaint(repeat);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.683 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "CA18ED2B0743D8CDB9503A504E4ABAFF")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.684 -0400", hash_original_field = "0F10BB7F8A96946641A73EC224944DC4", hash_generated_field = "DBA2C497A94BA4CA5E5F9E7EA8BBE7EA")

    private static String TAG = "Vibrator";
}

