package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArgbEvaluator implements TypeEvaluator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.707 -0400", hash_original_method = "F472709043D4200D0F3996D30EA1E944", hash_generated_method = "F472709043D4200D0F3996D30EA1E944")
        public ArgbEvaluator ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.719 -0400", hash_original_method = "415FA7137AA653EF40F66C5BED279EE7", hash_generated_method = "16DCBAA21C17CFE1251E4FC2210C27E9")
    @DSModeled(DSC.SAFE)
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        dsTaint.addTaint(endValue.dsTaint);
        dsTaint.addTaint(startValue.dsTaint);
        dsTaint.addTaint(fraction);
        int startInt;
        startInt = (Integer) startValue;
        int startA;
        startA = (startInt >> 24);
        int startR;
        startR = (startInt >> 16) & 0xff;
        int startG;
        startG = (startInt >> 8) & 0xff;
        int startB;
        startB = startInt & 0xff;
        int endInt;
        endInt = (Integer) endValue;
        int endA;
        endA = (endInt >> 24);
        int endR;
        endR = (endInt >> 16) & 0xff;
        int endG;
        endG = (endInt >> 8) & 0xff;
        int endB;
        endB = endInt & 0xff;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int startInt = (Integer) startValue;
        //int startA = (startInt >> 24);
        //int startR = (startInt >> 16) & 0xff;
        //int startG = (startInt >> 8) & 0xff;
        //int startB = startInt & 0xff;
        //int endInt = (Integer) endValue;
        //int endA = (endInt >> 24);
        //int endR = (endInt >> 16) & 0xff;
        //int endG = (endInt >> 8) & 0xff;
        //int endB = endInt & 0xff;
        //return (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                //(int)((startR + (int)(fraction * (endR - startR))) << 16) |
                //(int)((startG + (int)(fraction * (endG - startG))) << 8) |
                //(int)((startB + (int)(fraction * (endB - startB))));
    }

    
}

