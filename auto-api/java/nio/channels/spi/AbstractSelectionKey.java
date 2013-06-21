package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
    boolean isValid = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.165 -0400", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "52C6E15195C092E6066AA2AE54BDD2E1")
    @DSModeled(DSC.SAFE)
    protected AbstractSelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.165 -0400", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "DDBD13AF255DA7867A541B6BFFBFFFD3")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isValid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.165 -0400", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "6D04DE3A84849DD38026A88E4AE2CFAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void cancel() {
        {
            isValid = false;
            ((AbstractSelector) selector()).cancel(this);
        } //End block
        // ---------- Original Method ----------
        //if (isValid) {
            //isValid = false;
            //((AbstractSelector) selector()).cancel(this);
        //}
    }

    
}

