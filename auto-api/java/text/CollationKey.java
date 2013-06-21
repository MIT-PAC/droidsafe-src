package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class CollationKey implements Comparable<CollationKey> {
    private String source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.878 -0400", hash_original_method = "FA2BB1F012B53BF817CC40F1D26354AF", hash_generated_method = "5753301FBF577224012D6FB2D5FB8A7C")
    @DSModeled(DSC.SAFE)
    protected CollationKey(String source) {
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
        //this.source = source;
    }

    
    public abstract int compareTo(CollationKey value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.878 -0400", hash_original_method = "CAA51A8D77816B9C71E897924204286F", hash_generated_method = "EEA3FE445098990CAFACE3BBD1768734")
    @DSModeled(DSC.SAFE)
    public String getSourceString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return source;
    }

    
    public abstract byte[] toByteArray();

    
}

