package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Singleton<T> {
    private T mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.333 -0400", hash_original_method = "F690099100A98A07FA7A1C97A5E2AEA4", hash_generated_method = "F690099100A98A07FA7A1C97A5E2AEA4")
        public Singleton ()
    {
    }


    protected abstract T create();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.333 -0400", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "64900959C54BC707A7DD66B9137F919A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final T get() {
        {
            {
                mInstance = create();
            } //End block
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mInstance == null) {
                //mInstance = create();
            //}
            //return mInstance;
        //}
    }

    
}

