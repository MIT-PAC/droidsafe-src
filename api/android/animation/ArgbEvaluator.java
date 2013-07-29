package android.animation;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ArgbEvaluator implements TypeEvaluator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.508 -0400", hash_original_method = "2B314B5188522F79C40FC502122E5F12", hash_generated_method = "2B314B5188522F79C40FC502122E5F12")
    @DSModeled(DSC.SAFE)
    public ArgbEvaluator ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.512 -0400", hash_original_method = "415FA7137AA653EF40F66C5BED279EE7", hash_generated_method = "CCFCAD8E134722C31C5148BA1F01B6D8")
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
Object var8682AC4B94D3EEF03B558C75A615F0F2_1342359153 =         (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                (int)((startB + (int)(fraction * (endB - startB))));
        var8682AC4B94D3EEF03B558C75A615F0F2_1342359153.addTaint(taint);
        return var8682AC4B94D3EEF03B558C75A615F0F2_1342359153;
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

