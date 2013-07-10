package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class ClipboardManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.564 -0400", hash_original_method = "47A2DF210DD8BA7527F7EBA65DD74954", hash_generated_method = "47A2DF210DD8BA7527F7EBA65DD74954")
    public ClipboardManager ()
    {
        
    }


    public abstract CharSequence getText();

    
    public abstract void setText(CharSequence text);

    
    public abstract boolean hasText();

    
}

