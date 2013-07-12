package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class FloatEvaluator implements TypeEvaluator<Number> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.224 -0400", hash_original_method = "C987E70D238EF2ACA67A1E1BCA95D64E", hash_generated_method = "C987E70D238EF2ACA67A1E1BCA95D64E")
    public FloatEvaluator ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.226 -0400", hash_original_method = "F409EF3C8ADBC3E8580AA402C114DFFB", hash_generated_method = "8D3058A782E3BF457D5BD24AF9FE28E9")
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        addTaint(endValue.getTaint());
        addTaint(startValue.getTaint());
        addTaint(fraction);
        float startFloat = startValue.floatValue();
Float var656FC13B6262E391C84EE64663CF350D_465937602 =         startFloat + fraction * (endValue.floatValue() - startFloat);
        var656FC13B6262E391C84EE64663CF350D_465937602.addTaint(taint);
        return var656FC13B6262E391C84EE64663CF350D_465937602;
        
        
        
    }

    
}

