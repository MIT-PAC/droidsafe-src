package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
    boolean isValid = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:45.382 -0400", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "EAED3A19585BD0B257C67C3771FF963B")
    @DSModeled(DSC.SAFE)
    protected AbstractSelectionKey() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:45.386 -0400", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "DFB7D7613F5787850F770B4FF8EC214A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isValid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isValid;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:32:19.103 -0400",hash_original_method="A279029257087CE11FC7A37CBDFB5215",hash_generated_method="66F2572FC49A5E8073407C9FCA8DF0DC")
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


