package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ASN1Primitive extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.995 -0400", hash_original_method = "6E01D122B93A51FA632034F321085BC1", hash_generated_method = "08AE1F2B21FC28B5CB5A1F7CEF32B8D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Primitive(int tagNumber) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.995 -0400", hash_original_method = "C1AED137C8D8FCE0695617840DD29190", hash_generated_method = "C3C2F678824F1EB77A2418C5C9D8E912")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.id == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.995 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "513EDBA3166614A51C3201B35752465F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeTag(id);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
}

