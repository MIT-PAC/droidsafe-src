package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Annotation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.730 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.733 -0400", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "39B2C3DA0D326D411001D911DA4DDF90")
    public  Annotation(Object attribute) {
        value = attribute;
        // ---------- Original Method ----------
        //value = attribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.734 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "F8EF93B1856BF65723920E982B134F50")
    public Object getValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1139315730 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1139315730 = value;
        varB4EAC82CA7396A68D541C85D26508E83_1139315730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1139315730;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.734 -0400", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "28BD303C8E3ACF402A8614698A769884")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1885063989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1885063989 = getClass().getName() + "[value=" + value + ']';
        varB4EAC82CA7396A68D541C85D26508E83_1885063989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885063989;
        // ---------- Original Method ----------
        //return getClass().getName() + "[value=" + value + ']';
    }

    
}

