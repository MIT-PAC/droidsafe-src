package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class ORAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.260 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.260 -0400", hash_original_method = "522F011D4D6C75313C82A000AA454708", hash_generated_method = "522F011D4D6C75313C82A000AA454708")
    public ORAddress ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.260 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5ABCE5B025E1AD085839F3D1ECDAE9D4")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1848699931 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1848699931;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.260 -0400", hash_original_field = "14489BA6A8D6330DA6B97A093572043C", hash_generated_field = "7DB4F5D395F455307AFB2ABAD6EC4C19")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Sequence(new ASN1Type[] {}) {
                @Override protected void getValues(Object object, Object[] values) {}
            }}) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            return new ORAddress();
        }

        private final Object foo = new Object();

        @Override protected void getValues(Object object, Object[] values) {
            values[0] = foo;
        }
    };
    
    
    
    private final Object foo = new Object();
    
}

