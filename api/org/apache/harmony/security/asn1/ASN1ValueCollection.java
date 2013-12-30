package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;






public abstract class ASN1ValueCollection extends ASN1Constructed {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.107 -0500", hash_original_field = "43976773C1CAD6B63CB025EEFB3E3545", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public  ASN1Type type;

    /**
     * Constructs ASN1 collection type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.110 -0500", hash_original_method = "50DEBE44F0AD632419D22CF3D0ACBF84", hash_generated_method = "6A7243271996456135C67330F3D6B312")
    
public ASN1ValueCollection(int tagNumber, ASN1Type type) {
        super(tagNumber);
        this.type = type;
    }

    /**
     * Provides an object's values to be encoded
     *
     * Derived classes should override this method to provide
     * encoding for a selected class of objects.
     *
     * @param - an object to be encoded
     * @return - a collection of object's values to be encoded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.112 -0500", hash_original_method = "738CC0DE26C0029C09ABE092A492DCB2", hash_generated_method = "727A56E94FBEF73248F900A950D90850")
    
public Collection<?> getValues(Object object) {
        return (Collection<?>) object;
    }

    
}

