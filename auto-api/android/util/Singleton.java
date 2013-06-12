package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Singleton<T> {
    private T mInstance;
    
    protected abstract T create();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.660 -0400", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "681962A3305BAF303E1D351A59428012")
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


