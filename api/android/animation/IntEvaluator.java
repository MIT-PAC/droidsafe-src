package android.animation;

// Droidsafe Imports
import droidsafe.annotations.*;




public class IntEvaluator implements TypeEvaluator<Integer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.616 -0400", hash_original_method = "2EF7111110D38FEB0992107126625CBA", hash_generated_method = "2EF7111110D38FEB0992107126625CBA")
    @DSModeled(DSC.SAFE)
    public IntEvaluator ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.622 -0400", hash_original_method = "6401BD46F7D1EA9F5782F720B53B51D0", hash_generated_method = "7F3D3F6F019F204E0CBAB1A734CFA500")
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        addTaint(endValue.getTaint());
        addTaint(startValue.getTaint());
        addTaint(fraction);
        int startInt = startValue;
Integer varC552D327F4C770F40BF1C1A41BA4F5AE_1431041085 =         (int)(startInt + fraction * (endValue - startInt));
        varC552D327F4C770F40BF1C1A41BA4F5AE_1431041085.addTaint(taint);
        return varC552D327F4C770F40BF1C1A41BA4F5AE_1431041085;
        // ---------- Original Method ----------
        //int startInt = startValue;
        //return (int)(startInt + fraction * (endValue - startInt));
    }

    
}

