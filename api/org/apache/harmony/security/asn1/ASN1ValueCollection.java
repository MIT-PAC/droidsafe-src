package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Collection;

public abstract class ASN1ValueCollection extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.742 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public ASN1Type type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.742 -0400", hash_original_method = "50DEBE44F0AD632419D22CF3D0ACBF84", hash_generated_method = "59AD934A25DCBA5A9716FB11E6F9F371")
    public  ASN1ValueCollection(int tagNumber, ASN1Type type) {
        super(tagNumber);
        addTaint(tagNumber);
        this.type = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.743 -0400", hash_original_method = "738CC0DE26C0029C09ABE092A492DCB2", hash_generated_method = "6016B93545D0CA0192A8B682A763444B")
    public Collection<?> getValues(Object object) {
        addTaint(object.getTaint());
Collection<?> var89C2C578EE73DD2F152B0E462560B532_397700536 =         (Collection<?>) object;
        var89C2C578EE73DD2F152B0E462560B532_397700536.addTaint(taint);
        return var89C2C578EE73DD2F152B0E462560B532_397700536;
        
        
    }

    
}

