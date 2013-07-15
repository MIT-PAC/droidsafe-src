package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class DisplayList {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.924 -0400", hash_original_method = "D56C6AFD01D3460D9F9028A561421FB3", hash_generated_method = "D56C6AFD01D3460D9F9028A561421FB3")
    public DisplayList ()
    {
        
    }


    abstract HardwareCanvas start();

    
    abstract void end();

    
    abstract void invalidate();

    
    abstract boolean isValid();

    
    abstract int getSize();

    
}

