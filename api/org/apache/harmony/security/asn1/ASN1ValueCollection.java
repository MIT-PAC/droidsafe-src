package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;






public abstract class ASN1ValueCollection extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.495 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public ASN1Type type;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.496 -0400", hash_original_method = "50DEBE44F0AD632419D22CF3D0ACBF84", hash_generated_method = "59AD934A25DCBA5A9716FB11E6F9F371")
    public  ASN1ValueCollection(int tagNumber, ASN1Type type) {
        super(tagNumber);
        addTaint(tagNumber);
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.497 -0400", hash_original_method = "738CC0DE26C0029C09ABE092A492DCB2", hash_generated_method = "2560BD781EC6D04DC4D4ED144F515DBF")
    public Collection<?> getValues(Object object) {
        addTaint(object.getTaint());
Collection<?> var89C2C578EE73DD2F152B0E462560B532_1903306910 =         (Collection<?>) object;
        var89C2C578EE73DD2F152B0E462560B532_1903306910.addTaint(taint);
        return var89C2C578EE73DD2F152B0E462560B532_1903306910;
        // ---------- Original Method ----------
        //return (Collection<?>) object;
    }

    
}

