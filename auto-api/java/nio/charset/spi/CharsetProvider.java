package java.nio.charset.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class CharsetProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.566 -0400", hash_original_method = "71B9A0846B394A5E85543A853F8CC262", hash_generated_method = "44E341390924EFBA18E01AA43EAD17F6")
    @DSModeled(DSC.SAFE)
    protected CharsetProvider() {
        // ---------- Original Method ----------
    }

    
    public abstract Iterator<Charset> charsets();

    
    public abstract Charset charsetForName(String charsetName);

    
}


