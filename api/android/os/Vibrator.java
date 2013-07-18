package android.os;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Vibrator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6D5176DB6DC642185DCF8E32C5EC1BC9")

    IVibratorService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "338AF9C7C3937329885532B2150C11ED")

    private final Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    public  Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        // ---------- Original Method ----------
        //mService = IVibratorService.Stub.asInterface(
                //ServiceManager.getService("vibrator"));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "151D3F2E4276DA07BF42252D33EAFAD7")
    public boolean hasVibrator() {
        if(mService == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1447282135 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871856656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_871856656;
        } //End block
        try 
        {
            boolean var8053111FFFF928B3F2AEA20179772E4E_1912904040 = (mService.hasVibrator());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877249334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877249334;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_655900001 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535797388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535797388;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "923B04A13431F62D932999C01EF768BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "4FEC1D25C674D0C4EBF3B684610D737E")
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
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_2067812072 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_2067812072.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_2067812072;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.820 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "8D41DB29BDA8014ECBFFAFF7A98E566E")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.820 -0400", hash_original_field = "0F10BB7F8A96946641A73EC224944DC4", hash_generated_field = "58FE1B639F58F6B845A5213089DAFE03")

    private static final String TAG = "Vibrator";
}

