package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class DisplayList {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.474 -0400", hash_original_method = "6346386A3E734B7874ECF0F0A490D6EF", hash_generated_method = "6346386A3E734B7874ECF0F0A490D6EF")
        public DisplayList ()
    {
    }


    abstract HardwareCanvas start();

    
    abstract void end();

    
    abstract void invalidate();

    
    abstract boolean isValid();

    
    abstract int getSize();

    
}

