package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AvoidXfermode extends Xfermode {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.671 -0400", hash_original_method = "293A98A7728721725813AFA29BD3A029", hash_generated_method = "A240F39A65C0D1F14017A81FDF3C80D3")
    public  AvoidXfermode(int opColor, int tolerance, Mode mode) {
        addTaint(mode.getTaint());
        addTaint(tolerance);
        addTaint(opColor);
    if(tolerance < 0 || tolerance > 255)        
        {
            IllegalArgumentException var1055A444EADED692008EF1EEFB985FCC_986623807 = new IllegalArgumentException("tolerance must be 0..255");
            var1055A444EADED692008EF1EEFB985FCC_986623807.addTaint(taint);
            throw var1055A444EADED692008EF1EEFB985FCC_986623807;
        } 
        native_instance = nativeCreate(opColor, tolerance, mode.nativeInt);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(int opColor, int tolerance,
                                           int nativeMode) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613288083 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613288083;
    }

    
    public enum Mode {
        AVOID   (0),    
        TARGET  (1);    
        Mode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
}

