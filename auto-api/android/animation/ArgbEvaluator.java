package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArgbEvaluator implements TypeEvaluator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.929 -0400", hash_original_method = "2B314B5188522F79C40FC502122E5F12", hash_generated_method = "2B314B5188522F79C40FC502122E5F12")
    public ArgbEvaluator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:46.134 -0400", hash_original_method = "415FA7137AA653EF40F66C5BED279EE7", hash_generated_method = "5F7B0DF05B34C7AE9031D6B61D4CDE48")
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2145463489 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2145463489 = (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                (int)((startB + (int)(fraction * (endB - startB))));
        addTaint(fraction);
        addTaint(startValue.getTaint());
        addTaint(endValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2145463489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145463489;
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

