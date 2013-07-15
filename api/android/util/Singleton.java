package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Singleton<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.207 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "782E9E6E7CD7863D539D69517CB053E4")

    private T mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.207 -0400", hash_original_method = "02AC1105777FFE0AFBB34EFAC306ABC3", hash_generated_method = "02AC1105777FFE0AFBB34EFAC306ABC3")
    public Singleton ()
    {
        //Synthesized constructor
    }


    protected abstract T create();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.207 -0400", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "A26C048707D1348B57ACC577982D57A1")
    public final T get() {
        synchronized
(this)        {
    if(mInstance == null)            
            {
                mInstance = create();
            } //End block
T var01A4E1572BEF98558ED7F4E845C07CFE_1466157868 =             mInstance;
            var01A4E1572BEF98558ED7F4E845C07CFE_1466157868.addTaint(taint);
            return var01A4E1572BEF98558ED7F4E845C07CFE_1466157868;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mInstance == null) {
                //mInstance = create();
            //}
            //return mInstance;
        //}
    }

    
}

