package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IntEvaluator implements TypeEvaluator<Integer> {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.616 -0400", hash_original_method = "2EF7111110D38FEB0992107126625CBA", hash_generated_method = "2EF7111110D38FEB0992107126625CBA")
    
    public IntEvaluator ()
    {
        //Synthesized constructor
    }

    /**
     * This function returns the result of linearly interpolating the start and end values, with
     * <code>fraction</code> representing the proportion between the start and end values. The
     * calculation is a simple parametric calculation: <code>result = x0 + t * (v1 - v0)</code>,
     * where <code>x0</code> is <code>startValue</code>, <code>x1</code> is <code>endValue</code>,
     * and <code>t</code> is <code>fraction</code>.
     *
     * @param fraction   The fraction from the starting to the ending values
     * @param startValue The start value; should be of type <code>int</code> or
     *                   <code>Integer</code>
     * @param endValue   The end value; should be of type <code>int</code> or <code>Integer</code>
     * @return A linear interpolation between the start and end values, given the
     *         <code>fraction</code> parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.336 -0500", hash_original_method = "6401BD46F7D1EA9F5782F720B53B51D0", hash_generated_method = "99EE37795D574886793E48AD2066470F")
    
public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int)(startInt + fraction * (endValue - startInt));
    }
    
}

