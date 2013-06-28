package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FloatEvaluator implements TypeEvaluator<Number> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.706 -0400", hash_original_method = "C987E70D238EF2ACA67A1E1BCA95D64E", hash_generated_method = "C987E70D238EF2ACA67A1E1BCA95D64E")
    public FloatEvaluator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.711 -0400", hash_original_method = "F409EF3C8ADBC3E8580AA402C114DFFB", hash_generated_method = "67488BD19B7983F31742F136D4FEF730")
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        Float varB4EAC82CA7396A68D541C85D26508E83_343937194 = null; //Variable for return #1
        float startFloat = startValue.floatValue();
        varB4EAC82CA7396A68D541C85D26508E83_343937194 = startFloat + fraction * (endValue.floatValue() - startFloat);
        addTaint(fraction);
        addTaint(startValue.getTaint());
        addTaint(endValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_343937194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_343937194;
        // ---------- Original Method ----------
        //float startFloat = startValue.floatValue();
        //return startFloat + fraction * (endValue.floatValue() - startFloat);
    }

    
}

