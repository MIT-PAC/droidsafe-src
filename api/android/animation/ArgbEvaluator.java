package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ArgbEvaluator implements TypeEvaluator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.214 -0400", hash_original_method = "2B314B5188522F79C40FC502122E5F12", hash_generated_method = "2B314B5188522F79C40FC502122E5F12")
    public ArgbEvaluator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.217 -0400", hash_original_method = "415FA7137AA653EF40F66C5BED279EE7", hash_generated_method = "7C4CEC4D2AAB10CBB2A909B5996B0FE9")
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        addTaint(endValue.getTaint());
        addTaint(startValue.getTaint());
        addTaint(fraction);
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24);
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;
        int endInt = (Integer) endValue;
        int endA = (endInt >> 24);
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;
Object var8682AC4B94D3EEF03B558C75A615F0F2_519896368 =         (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                (int)((startB + (int)(fraction * (endB - startB))));
        var8682AC4B94D3EEF03B558C75A615F0F2_519896368.addTaint(taint);
        return var8682AC4B94D3EEF03B558C75A615F0F2_519896368;
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

