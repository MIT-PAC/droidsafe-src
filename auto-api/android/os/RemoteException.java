package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidException;

public class RemoteException extends AndroidException {
    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 12:02:00.768 -0400",hash_original_method="DEE27A1F58443ED534CF6DB1DEBB024B",hash_generated_method="5E56C4745DE2DC6663C22FD37DB72909")
public RemoteException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 12:02:00.768 -0400",hash_original_method="DEE27A1F58443ED534CF6DB1DEBB024B",hash_generated_method="5E56C4745DE2DC6663C22FD37DB72909")
public RemoteException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}


