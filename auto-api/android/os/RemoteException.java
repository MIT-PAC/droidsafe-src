package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidException;

public class RemoteException extends AndroidException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.176 -0400", hash_original_method = "5634FE974275AC57C23528565D1940A5", hash_generated_method = "466007FF5A418054331F795B68538629")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.177 -0400", hash_original_method = "DEE27A1F58443ED534CF6DB1DEBB024B", hash_generated_method = "E21781F32E7E96B05EC2A30AFB9088BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

