package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Comparator;

import org.apache.harmony.security.utils.ObjectIdentifier;

public class AttributeTypeAndValueComparator implements Comparator, Serializable {

    /**
     * compares two Object identifiers
     *
     * @param oid1
     *            first OID
     * @param oid2
     *            second OID
     * @return -1 of first OID "less" than second OID 1 otherwise, 0 if they are
     *         equal
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.273 -0500", hash_original_method = "B35DA3AB8471E98A0F9901B66FBBA5C9", hash_generated_method = "7557328DF4D4A138F8EF4FFB2D8845C4")
    
private static int compateOids(ObjectIdentifier oid1, ObjectIdentifier oid2) {
        if (oid1 == oid2) {
            return 0;
        }

        int[] ioid1 = oid1.getOid();
        int[] ioid2 = oid2.getOid();
        int min = ioid1.length < ioid2.length ? ioid1.length : ioid2.length;
        for (int i = 0; i < min; ++i) {
            if (ioid1[i] < ioid2[i]) {
                return -1;
            }
            if (ioid1[i] > ioid2[i]) {
                return 1;
            }
            if ((i + 1) == ioid1.length && (i + 1) < ioid2.length) {
                return -1;
            }
            if ((i + 1) < ioid1.length && (i + 1) == ioid2.length) {
                return 1;
            }
        }
        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.268 -0500", hash_original_field = "B4233DEB3183D4BBD895A0DA12ED5529", hash_generated_field = "D4ECDC5A87F7ADFE1C3A33CD3F11715D")

    private static final long serialVersionUID = -1286471842007103132L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.531 -0400", hash_original_method = "A875CA77DCF86273FF83ADF73F0AA798", hash_generated_method = "A875CA77DCF86273FF83ADF73F0AA798")
    public AttributeTypeAndValueComparator ()
    {
        //Synthesized constructor
    }

    /**
     * compares two AttributeTypeAndValues
     *
     * @param obj1
     *            first AttributeTypeAndValue
     * @param obj2
     *            second AttributeTypeAndValue
     * @return -1 of first AttributeTypeAndValue "less" than second
     *         AttributeTypeAndValue 1 otherwise, 0 if they are equal
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.270 -0500", hash_original_method = "3F7D901C5D2A92F81B8BE7A716DA67AE", hash_generated_method = "FED4FBCEA05778094376463F7BBF91F1")
    
public int compare(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return 0;
        }

        AttributeTypeAndValue atav1 = (AttributeTypeAndValue) obj1;
        AttributeTypeAndValue atav2 = (AttributeTypeAndValue) obj2;
        String kw1 = atav1.getType().getName();
        String kw2 = atav2.getType().getName();
        if (kw1 != null && kw2 == null) {
            return -1;
        }
        if (kw1 == null && kw2 != null) {
            return 1;
        }
        if (kw1 != null && kw2 != null) {
            return kw1.compareTo(kw2);
        }

        return compateOids(atav1.getType(), atav2.getType());
    }
}

