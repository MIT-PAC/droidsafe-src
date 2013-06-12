package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class CollationKey implements Comparable<CollationKey> {
    private final String source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.844 -0400", hash_original_method = "FA2BB1F012B53BF817CC40F1D26354AF", hash_generated_method = "2B1409A034BA6F71D5E0C5CDEB95440E")
    @DSModeled(DSC.SAFE)
    protected CollationKey(String source) {
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
        //this.source = source;
    }

    
    public abstract int compareTo(CollationKey value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.844 -0400", hash_original_method = "CAA51A8D77816B9C71E897924204286F", hash_generated_method = "789DC70B55E64772B28DC8AF39BB87B9")
    @DSModeled(DSC.SAFE)
    public String getSourceString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return source;
    }

    
    public abstract byte[] toByteArray();

    
}


