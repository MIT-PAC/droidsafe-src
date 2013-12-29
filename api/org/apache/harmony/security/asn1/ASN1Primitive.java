package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class ASN1Primitive extends ASN1Type {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.702 -0500", hash_original_method = "6E01D122B93A51FA632034F321085BC1", hash_generated_method = "41E0C1EE5E8A81D2BDA3177F743F5ABE")
    public ASN1Primitive(int tagNumber) {
        super(tagNumber);
    }

    /**
     * Tests provided identifier.
     *
     * @param identifier identifier to be verified
     * @return true if identifier correspond to primitive identifier of this
     *     ASN.1 type, otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.703 -0500", hash_original_method = "C1AED137C8D8FCE0695617840DD29190", hash_generated_method = "23DD4808C1BAC688D7DCD4820865D821")
    public final boolean checkTag(int identifier) {
        return this.id == identifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.703 -0500", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "6DBE43E8C1D34645AEF0A710F73133F9")
    public void encodeASN(BerOutputStream out) {
        out.encodeTag(id);
        encodeContent(out);
    }

    
}

