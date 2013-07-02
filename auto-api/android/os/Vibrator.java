package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;

public class Vibrator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.426 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6D5176DB6DC642185DCF8E32C5EC1BC9")

    IVibratorService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.426 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "338AF9C7C3937329885532B2150C11ED")

    private final Binder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.427 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    public  Vibrator() {
        mService = IVibratorService.Stub.asInterface(
                ServiceManager.getService("vibrator"));
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.427 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "AB8A6699E4B4701CA9E0E7789237D3EE")
    public boolean hasVibrator() {
        try 
        {
            boolean var5CDAA7782E0492C697AE35EAB5CE95A3_1399268364 = (mService.hasVibrator());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110350674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110350674;
        
        
            
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.428 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "F037A67D35643E415E9C55D7CEECE9AE")
    public void vibrate(long milliseconds) {
        try 
        {
            mService.vibrate(milliseconds, mToken);
        } 
        catch (RemoteException e)
        { }
        addTaint(milliseconds);
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.428 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "746057240AF49A69237F19353942DFA9")
    public void vibrate(long[] pattern, int repeat) {
        {
            try 
            {
                mService.vibratePattern(pattern, repeat, mToken);
            } 
            catch (RemoteException e)
            { }
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } 
        addTaint(pattern[0]);
        addTaint(repeat);
        
        
            
            
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.429 -0400", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "CA18ED2B0743D8CDB9503A504E4ABAFF")
    public void cancel() {
        try 
        {
            mService.cancelVibrate(mToken);
        } 
        catch (RemoteException e)
        { }
        
        
            
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.429 -0400", hash_original_field = "0F10BB7F8A96946641A73EC224944DC4", hash_generated_field = "58FE1B639F58F6B845A5213089DAFE03")

    private static final String TAG = "Vibrator";
}

