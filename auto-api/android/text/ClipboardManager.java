package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ClipboardManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.000 -0400", hash_original_method = "96FC89CA7A654748673A68E601EDB67F", hash_generated_method = "96FC89CA7A654748673A68E601EDB67F")
        public ClipboardManager ()
    {
    }


    public abstract CharSequence getText();

    
    public abstract void setText(CharSequence text);

    
    public abstract boolean hasText();

    
}

