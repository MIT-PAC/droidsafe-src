package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class IntEvaluator implements TypeEvaluator<Integer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.788 -0400", hash_original_method = "2EF7111110D38FEB0992107126625CBA", hash_generated_method = "2EF7111110D38FEB0992107126625CBA")
    public IntEvaluator ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.794 -0400", hash_original_method = "6401BD46F7D1EA9F5782F720B53B51D0", hash_generated_method = "796AB6B6B003884A769700D129A86775")
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        Integer varB4EAC82CA7396A68D541C85D26508E83_1889564400 = null; 
        int startInt = startValue;
        varB4EAC82CA7396A68D541C85D26508E83_1889564400 = (int)(startInt + fraction * (endValue - startInt));
        addTaint(fraction);
        addTaint(startValue.getTaint());
        addTaint(endValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1889564400.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1889564400;
        
        
        
    }

    
}

