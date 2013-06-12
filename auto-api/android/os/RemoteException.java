package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.AndroidException;

public class RemoteException extends AndroidException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.865 -0400", hash_original_method = "5634FE974275AC57C23528565D1940A5", hash_generated_method = "08696EC6C7847BFE742BF49FBE526014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.865 -0400", hash_original_method = "DEE27A1F58443ED534CF6DB1DEBB024B", hash_generated_method = "5E56C4745DE2DC6663C22FD37DB72909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}


