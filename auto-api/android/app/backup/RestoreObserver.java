package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.String;
import android.app.backup.RestoreSet;

public abstract class RestoreObserver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.757 -0400", hash_original_method = "F9D1A298B1697AD74387E190133C441C", hash_generated_method = "F9D1A298B1697AD74387E190133C441C")
    public RestoreObserver ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.757 -0400", hash_original_method = "668807DC740187B04A6B6A3F86625C1D", hash_generated_method = "56B48799E86DF69774EB7E39DF803D80")
    public void restoreSetsAvailable(RestoreSet[] result) {
        addTaint(result[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.757 -0400", hash_original_method = "DBB8890F5DB9136F39685677B4F1E581", hash_generated_method = "F45A2E370A12340E498B522E905055FF")
    public void restoreStarting(int numPackages) {
        addTaint(numPackages);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.758 -0400", hash_original_method = "0D7718CD7EB4ACA6FF6B636456D0E82A", hash_generated_method = "9B8351EDE62F71543011E88844C55541")
    public void onUpdate(int nowBeingRestored, String currentPackage) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nowBeingRestored);
        addTaint(currentPackage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.758 -0400", hash_original_method = "0756746AA6CF68909818DDB3CD0E35A6", hash_generated_method = "A9D73FB1C6F34BEDD03E0507D68E30D2")
    public void restoreFinished(int error) {
        addTaint(error);
        // ---------- Original Method ----------
    }

    
}

