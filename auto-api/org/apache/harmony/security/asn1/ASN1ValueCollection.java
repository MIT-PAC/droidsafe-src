package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Collection;

public abstract class ASN1ValueCollection extends ASN1Constructed {
    public ASN1Type type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.027 -0400", hash_original_method = "50DEBE44F0AD632419D22CF3D0ACBF84", hash_generated_method = "5CFBB550B9E171121079522E0E58D336")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1ValueCollection(int tagNumber, ASN1Type type) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.027 -0400", hash_original_method = "738CC0DE26C0029C09ABE092A492DCB2", hash_generated_method = "9DDB1F36E6549A57860257A353C516D7")
    @DSModeled(DSC.SAFE)
    public Collection<?> getValues(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return (Collection<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Collection<?>) object;
    }

    
}

