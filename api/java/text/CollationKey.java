package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class CollationKey implements Comparable<CollationKey> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.512 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private String source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.512 -0400", hash_original_method = "FA2BB1F012B53BF817CC40F1D26354AF", hash_generated_method = "8A83B74FC7ACECB2BEE0C5F65526CEEC")
    protected  CollationKey(String source) {
        this.source = source;
        // ---------- Original Method ----------
        //this.source = source;
    }

    
    public abstract int compareTo(CollationKey value);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.512 -0400", hash_original_method = "CAA51A8D77816B9C71E897924204286F", hash_generated_method = "14F3E0D00B5BCE5ABB4C536EB6A8BC73")
    public String getSourceString() {
String var87D92E4D22D3928BDE6A72969186AF86_1850827954 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_1850827954.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_1850827954;
        // ---------- Original Method ----------
        //return source;
    }

    
    public abstract byte[] toByteArray();

    
}

