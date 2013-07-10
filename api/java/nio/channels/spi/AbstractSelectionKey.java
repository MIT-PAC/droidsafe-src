package java.nio.channels.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.774 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "FFFCC50D3A278EF95DEB022E99DE2B21")

    boolean isValid = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.775 -0400", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "52C6E15195C092E6066AA2AE54BDD2E1")
    protected  AbstractSelectionKey() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.775 -0400", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "6A210D0DC13177BE652480B61E6A0C8E")
    @Override
    public final boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685563900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685563900;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.775 -0400", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "6D04DE3A84849DD38026A88E4AE2CFAD")
    @Override
    public final void cancel() {
        {
            isValid = false;
            ((AbstractSelector) selector()).cancel(this);
        } 
        
        
            
            
        
    }

    
}

