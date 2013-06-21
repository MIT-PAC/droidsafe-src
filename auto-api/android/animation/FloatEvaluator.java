package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FloatEvaluator implements TypeEvaluator<Number> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.724 -0400", hash_original_method = "A36F6B2BF24826F971FBB2A0A85FBD8D", hash_generated_method = "A36F6B2BF24826F971FBB2A0A85FBD8D")
        public FloatEvaluator ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.734 -0400", hash_original_method = "F409EF3C8ADBC3E8580AA402C114DFFB", hash_generated_method = "7D55890B7A27605F07F689A182600521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        dsTaint.addTaint(endValue.dsTaint);
        dsTaint.addTaint(startValue.dsTaint);
        dsTaint.addTaint(fraction);
        float startFloat;
        startFloat = startValue.floatValue();
        Float var2F3461AF2EE7B6ED048F1ABEE8B5B2D3_401506004 = (startFloat + fraction * (endValue.floatValue() - startFloat));
        return (Float)dsTaint.getTaint();
        // ---------- Original Method ----------
        //float startFloat = startValue.floatValue();
        //return startFloat + fraction * (endValue.floatValue() - startFloat);
    }

    
}

