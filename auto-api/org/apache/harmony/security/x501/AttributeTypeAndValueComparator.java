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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.442 -0400", hash_original_method = "B4F915A753FB0135D3A3108057B85050", hash_generated_method = "B4F915A753FB0135D3A3108057B85050")
        public AttributeTypeAndValueComparator ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.443 -0400", hash_original_method = "3F7D901C5D2A92F81B8BE7A716DA67AE", hash_generated_method = "355F772A2DE035D73736AB05D8611E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compare(Object obj1, Object obj2) {
        dsTaint.addTaint(obj1.dsTaint);
        dsTaint.addTaint(obj2.dsTaint);
        AttributeTypeAndValue atav1;
        atav1 = (AttributeTypeAndValue) obj1;
        AttributeTypeAndValue atav2;
        atav2 = (AttributeTypeAndValue) obj2;
        String kw1;
        kw1 = atav1.getType().getName();
        String kw2;
        kw2 = atav2.getType().getName();
        {
            int varDF053E728FF3446E2A4ACCAE2F970CAB_577263312 = (kw1.compareTo(kw2));
        } //End block
        int varFFBF5540CE921DEEB7A5A162F4171799_764871071 = (compateOids(atav1.getType(), atav2.getType()));
        return dsTaint.getTaintInt();
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

    
    private static final long serialVersionUID = -1286471842007103132L;
}

