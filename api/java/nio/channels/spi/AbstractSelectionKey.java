package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.703 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "FFFCC50D3A278EF95DEB022E99DE2B21")

    boolean isValid = true;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.704 -0400", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "52C6E15195C092E6066AA2AE54BDD2E1")
    protected  AbstractSelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.704 -0400", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "B0FB1B624EC12B26176F500407AE236D")
    @Override
    public final boolean isValid() {
        boolean varCE74825B5A01C99B06AF231DE0BD667D_871190498 = (isValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823229996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_823229996;
        // ---------- Original Method ----------
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.704 -0400", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "2EAA993CEBCBCF295DB2F81EBEA8396B")
    @Override
    public final void cancel() {
    if(isValid)        
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

