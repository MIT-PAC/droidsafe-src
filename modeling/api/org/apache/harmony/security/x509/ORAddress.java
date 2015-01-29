package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class ORAddress {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.554 -0400", hash_original_field = "14489BA6A8D6330DA6B97A093572043C", hash_generated_field = "7DB4F5D395F455307AFB2ABAD6EC4C19")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Sequence(new ASN1Type[] {}) {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.909 -0500", hash_original_method = "02D174AD77642CB3C45F1493B30F850F", hash_generated_method = "4F634AD07BAFCCFBF76BDFEA170C889C")
        
@Override protected void getValues(Object object, Object[] values) {}
            }}) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.912 -0500", hash_original_method = "FD441BE0EF348E7086E1C3476170DCA0", hash_generated_method = "DE9988D436B42EA87AC08B4BA4849CD6")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            return new ORAddress();
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.915 -0500", hash_original_field = "1DCE6DCE0E13A6535CC3288537D9D5E4", hash_generated_field = "8C6B8131596F541B7B94CA285D0C506F")

        private final Object foo = new Object();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.918 -0500", hash_original_method = "1799E673C05BD9DC6FDA8F503F5A713E", hash_generated_method = "5374068127696167754404FDB0F43CD4")
        
@Override protected void getValues(Object object, Object[] values) {
            values[0] = foo;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.904 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    // orphaned legacy field
    private final Object foo = new Object();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.553 -0400", hash_original_method = "522F011D4D6C75313C82A000AA454708", hash_generated_method = "522F011D4D6C75313C82A000AA454708")
    public ORAddress ()
    {
        //Synthesized constructor
    }

    /**
     * Returns ASN.1 encoded form of this X.509 ORAddress value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.906 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
    
}

