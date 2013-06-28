package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Annotation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.239 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.239 -0400", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "39B2C3DA0D326D411001D911DA4DDF90")
    public  Annotation(Object attribute) {
        value = attribute;
        // ---------- Original Method ----------
        //value = attribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.240 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "B669F6BF83FD31BF891E2C8A93F1946B")
    public Object getValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2038562884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2038562884 = value;
        varB4EAC82CA7396A68D541C85D26508E83_2038562884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2038562884;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.242 -0400", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "3EA1C369A5C5EE1BB6D4EAC35FBD634E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1617929508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1617929508 = getClass().getName() + "[value=" + value + ']';
        varB4EAC82CA7396A68D541C85D26508E83_1617929508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1617929508;
        // ---------- Original Method ----------
        //return getClass().getName() + "[value=" + value + ']';
    }

    
}

