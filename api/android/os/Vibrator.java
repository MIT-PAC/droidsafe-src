package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;

public class Vibrator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.803 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6D5176DB6DC642185DCF8E32C5EC1BC9")

    IVibratorService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.803 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "338AF9C7C3937329885532B2150C11ED")

    private final Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.804 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    public  Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.805 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "7D9E8CA44EA90635EDE1B76D1A7A6E42")
    public boolean hasVibrator() {
    if(mService == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1800828460 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962793543 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962793543;
        } //End block
        try 
        {
            boolean var8053111FFFF928B3F2AEA20179772E4E_1443624658 = (mService.hasVibrator());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4904924 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_4904924;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2115980921 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518356056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518356056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.805 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "923B04A13431F62D932999C01EF768BD")
    public void vibrate(long milliseconds) {
        addTaint(milliseconds);
    if(mService == null)        
        {
            return;
        } //End block
        try 
        {
            mService.vibrate(milliseconds, mToken);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.806 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "EECB55DEABA2462EA7DE8C56AC8DCAE7")
    public void vibrate(long[] pattern, int repeat) {
        addTaint(repeat);
        addTaint(pattern[0]);
    if(mService == null)        
        {
            return;
        } //End block
    if(repeat < pattern.length)        
        {
            try 
            {
                mService.vibratePattern(pattern, repeat, mToken);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1407612409 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1407612409.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1407612409;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.808 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "8D41DB29BDA8014ECBFFAFF7A98E566E")
    public void cancel() {
    if(mService == null)        
        {
            return;
        } //End block
        try 
        {
            mService.cancelVibrate(mToken);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.808 -0400", hash_original_field = "0F10BB7F8A96946641A73EC224944DC4", hash_generated_field = "58FE1B639F58F6B845A5213089DAFE03")

    private static final String TAG = "Vibrator";
}

