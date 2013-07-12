package org.apache.harmony.security.x501;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.harmony.security.utils.ObjectIdentifier;

public class AttributeTypeAndValueComparator implements Comparator, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.513 -0400", hash_original_method = "A875CA77DCF86273FF83ADF73F0AA798", hash_generated_method = "A875CA77DCF86273FF83ADF73F0AA798")
    public AttributeTypeAndValueComparator ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.514 -0400", hash_original_method = "3F7D901C5D2A92F81B8BE7A716DA67AE", hash_generated_method = "9F4632445497AF2714100970E71346E9")
    public int compare(Object obj1, Object obj2) {
        addTaint(obj2.getTaint());
        addTaint(obj1.getTaint());
    if(obj1 == obj2)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_332684371 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34649226 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34649226;
        } 
        AttributeTypeAndValue atav1 = (AttributeTypeAndValue) obj1;
        AttributeTypeAndValue atav2 = (AttributeTypeAndValue) obj2;
        String kw1 = atav1.getType().getName();
        String kw2 = atav2.getType().getName();
    if(kw1 != null && kw2 == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_286615029 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029216288 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029216288;
        } 
    if(kw1 == null && kw2 != null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1850729691 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561885564 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561885564;
        } 
    if(kw1 != null && kw2 != null)        
        {
            int varBA95312D025F5BDE3389A33E2C5C46ED_1972436267 = (kw1.compareTo(kw2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807864668 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807864668;
        } 
        int var290C36B97CAF7D5EB27E5F7093E5C382_987147921 = (compateOids(atav1.getType(), atav2.getType()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749214288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749214288;
        
        
            
        
        
        
        
        
        
            
        
        
            
        
        
            
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.515 -0400", hash_original_field = "552BD64E17BE452CB24FFE6F7520D2C3", hash_generated_field = "D4ECDC5A87F7ADFE1C3A33CD3F11715D")

    private static final long serialVersionUID = -1286471842007103132L;
}

