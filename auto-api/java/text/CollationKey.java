package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class CollationKey implements Comparable<CollationKey> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.846 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private String source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.846 -0400", hash_original_method = "FA2BB1F012B53BF817CC40F1D26354AF", hash_generated_method = "8A83B74FC7ACECB2BEE0C5F65526CEEC")
    protected  CollationKey(String source) {
        this.source = source;
        // ---------- Original Method ----------
        //this.source = source;
    }

    
    public abstract int compareTo(CollationKey value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.847 -0400", hash_original_method = "CAA51A8D77816B9C71E897924204286F", hash_generated_method = "AC537F27DF458E6B0F13CCDB1DEF2CA0")
    public String getSourceString() {
        String varB4EAC82CA7396A68D541C85D26508E83_211915875 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_211915875 = source;
        varB4EAC82CA7396A68D541C85D26508E83_211915875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_211915875;
        // ---------- Original Method ----------
        //return source;
    }

    
    public abstract byte[] toByteArray();

    
}

