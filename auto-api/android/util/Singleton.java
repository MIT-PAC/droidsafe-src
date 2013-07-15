package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class Singleton<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.556 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "782E9E6E7CD7863D539D69517CB053E4")

    private T mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.556 -0400", hash_original_method = "02AC1105777FFE0AFBB34EFAC306ABC3", hash_generated_method = "02AC1105777FFE0AFBB34EFAC306ABC3")
    public Singleton ()
    {
        
    }


    protected abstract T create();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.557 -0400", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "1E0F80199DDE227E51CCD61166AB3ACE")
    public final T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_965085548 = null; 
        {
            {
                mInstance = create();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_965085548 = mInstance;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_965085548.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_965085548;
        
        
            
                
            
            
        
    }

    
}

