package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Singleton<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.140 -0500", hash_original_field = "3D00B588D04AEAB45027249A92A58FD8", hash_generated_field = "782E9E6E7CD7863D539D69517CB053E4")

    private T mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.072 -0400", hash_original_method = "02AC1105777FFE0AFBB34EFAC306ABC3", hash_generated_method = "02AC1105777FFE0AFBB34EFAC306ABC3")
    public Singleton ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.143 -0500", hash_original_method = "143703A29AF7B044F625A19484C15EC6", hash_generated_method = "7FFE270DF8135A8EC19A46E31E7B1DE8")
    
protected abstract T create();

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.145 -0500", hash_original_method = "CF8212F11D8E5F22A25C4FBFDDF16383", hash_generated_method = "62CFCE0241BE7E6153D0BE1DAA53363E")
    
public final T get() {
        synchronized (this) {
            if (mInstance == null) {
                mInstance = create();
            }
            return mInstance;
        }
    }
    
}

