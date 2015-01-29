package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

public final class ASN1Enumerated extends ASN1Primitive {

    /**
     * Returns ASN.1 Enumerated type default implementation
     *
     * The default implementation works with encoding
     * that is represented as byte array.
     *
     * @return ASN.1 Enumerated type default implementation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.935 -0500", hash_original_method = "C7BD5DF5B4492E50E2ACB81AC88D2AB0", hash_generated_method = "E42EF75BE538682AC0C1CB8F32E8FDAF")
    
public static ASN1Enumerated getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.929 -0500", hash_original_field = "72BE9A7AEF9426FE09EB0D78BD07B958", hash_generated_field = "E1CAA2576C780B35F20FCEF265B3C62C")

    private static final ASN1Enumerated ASN1 = new ASN1Enumerated();

    /**
     * Constructs ASN.1 Enumerated type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 Enumerated type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.932 -0500", hash_original_method = "AA03F41F75612EB5366E32BDDDAEA1AC", hash_generated_method = "B1AF031E55F072085D1941D198CBEAFE")
    
public ASN1Enumerated() {
        super(TAG_ENUM);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.937 -0500", hash_original_method = "810B1EC4B5D81C8B87770AF406E0EFF5", hash_generated_method = "03D0A5259A544183BBB4985883C2A7A2")
    
public Object decode(BerInputStream in) throws IOException {
        in.readEnumerated();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    /**
     * Extracts array of bytes from BER input stream.
     *
     * @return array of bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.939 -0500", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "21F4F02DB154DFF96D7B1CD27CD88D68")
    
public Object getDecodedObject(BerInputStream in) throws IOException {
        return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.941 -0500", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "AB94A046A59914D165FB9FEA5F11112A")
    
public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.943 -0500", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "74427AC68000019C393865D49DAE53B9")
    
public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
    }
}

