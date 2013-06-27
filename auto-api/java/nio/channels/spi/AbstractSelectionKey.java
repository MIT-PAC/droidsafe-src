package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.601 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "FFFCC50D3A278EF95DEB022E99DE2B21")

    boolean isValid = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.612 -0400", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "52C6E15195C092E6066AA2AE54BDD2E1")
    protected  AbstractSelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.612 -0400", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "31EA87152B124512CD17E889367D0209")
    @Override
    public final boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712087556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712087556;
        // ---------- Original Method ----------
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.613 -0400", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "6D04DE3A84849DD38026A88E4AE2CFAD")
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

