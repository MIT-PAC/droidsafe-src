package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Singleton<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.287 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "782E9E6E7CD7863D539D69517CB053E4")

    private T mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.287 -0400", hash_original_method = "02AC1105777FFE0AFBB34EFAC306ABC3", hash_generated_method = "02AC1105777FFE0AFBB34EFAC306ABC3")
    public Singleton ()
    {
        //Synthesized constructor
    }


    protected abstract T create();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.288 -0400", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "2DC3939E84FA7D9D363A8ED4F311CD5B")
    public final T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_1953594184 = null; //Variable for return #1
        {
            {
                mInstance = create();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1953594184 = mInstance;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1953594184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1953594184;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mInstance == null) {
                //mInstance = create();
            //}
            //return mInstance;
        //}
    }

    
}

