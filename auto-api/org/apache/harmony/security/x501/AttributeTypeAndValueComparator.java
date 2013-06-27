package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.harmony.security.utils.ObjectIdentifier;

public class AttributeTypeAndValueComparator implements Comparator, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.194 -0400", hash_original_method = "A875CA77DCF86273FF83ADF73F0AA798", hash_generated_method = "A875CA77DCF86273FF83ADF73F0AA798")
    public AttributeTypeAndValueComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.195 -0400", hash_original_method = "3F7D901C5D2A92F81B8BE7A716DA67AE", hash_generated_method = "2F9669D3A2F51A63F35613EDDCCFA9A4")
    public int compare(Object obj1, Object obj2) {
        AttributeTypeAndValue atav1;
        atav1 = (AttributeTypeAndValue) obj1;
        AttributeTypeAndValue atav2;
        atav2 = (AttributeTypeAndValue) obj2;
        String kw1;
        kw1 = atav1.getType().getName();
        String kw2;
        kw2 = atav2.getType().getName();
        {
            int varDF053E728FF3446E2A4ACCAE2F970CAB_1880681650 = (kw1.compareTo(kw2));
        } //End block
        int varFFBF5540CE921DEEB7A5A162F4171799_975517108 = (compateOids(atav1.getType(), atav2.getType()));
        addTaint(obj1.getTaint());
        addTaint(obj2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364214091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364214091;
        // ---------- Original Method ----------
        //if (obj1 == obj2) {
            //return 0;
        //}
        //AttributeTypeAndValue atav1 = (AttributeTypeAndValue) obj1;
        //AttributeTypeAndValue atav2 = (AttributeTypeAndValue) obj2;
        //String kw1 = atav1.getType().getName();
        //String kw2 = atav2.getType().getName();
        //if (kw1 != null && kw2 == null) {
            //return -1;
        //}
        //if (kw1 == null && kw2 != null) {
            //return 1;
        //}
        //if (kw1 != null && kw2 != null) {
            //return kw1.compareTo(kw2);
        //}
        //return compateOids(atav1.getType(), atav2.getType());
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.204 -0400", hash_original_field = "552BD64E17BE452CB24FFE6F7520D2C3", hash_generated_field = "5A2E254478FA88079AB984D89920B3E9")

    private static long serialVersionUID = -1286471842007103132L;
}

