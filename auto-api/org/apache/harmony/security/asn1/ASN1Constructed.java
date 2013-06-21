package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ASN1Constructed extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.936 -0400", hash_original_method = "9FFE4A234D2E2DB42C06DD57E257B3F5", hash_generated_method = "6D97CFA94303FD8AC7D7B75A7BDEF423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ASN1Constructed(int tagNumber) {
        super(CLASS_UNIVERSAL, tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.936 -0400", hash_original_method = "0ED0D05BF14BE7B30955286BAE5204E3", hash_generated_method = "40BE9A2F2C149A81F47AFCA939F6E00B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ASN1Constructed(int tagClass, int tagNumber) {
        super(tagClass, tagNumber);
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(tagClass);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.936 -0400", hash_original_method = "B936C5375D6639A303C6027641033901", hash_generated_method = "B5146308930F7CFCAFB0B7DAF8A123B1")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.constrId == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.937 -0400", hash_original_method = "D76B5AEAE2B5495729712535531D2D80", hash_generated_method = "A6CF5DFDFBFC71F4938B4365FB031CF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeTag(constrId);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(constrId);
        //encodeContent(out);
    }

    
}

