package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {

    /**
     * Returns ASN.1 octet string type default implementation
     *
     * The default implementation works with encoding
     * that is represented as byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.965 -0500", hash_original_method = "F77C5F3582B223C2ECF09C45F802AA0C", hash_generated_method = "374FB482A9F4BD4CF808640CD919DEF5")
    
public static ASN1OctetString getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.960 -0500", hash_original_field = "619AC1C12C02F4C1DB819DA5FD37CB4A", hash_generated_field = "BBC2F7EF6217ADF6A8ED0EF7FBD1ADB4")

    private static final ASN1OctetString ASN1 = new ASN1OctetString();

    /**
     * Constructs ASN.1 octet string type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 octet string type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.963 -0500", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "9BC78B95E5579B87EF4717DF3A05097B")
    
public ASN1OctetString() {
        super(TAG_OCTETSTRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.968 -0500", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "D52F93EDBB3C86D8A27C1CEDE36B2E4B")
    
@Override public Object decode(BerInputStream in) throws IOException {
        in.readOctetString();

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.971 -0500", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "97033F5FC3E52425F6CF50D667821545")
    
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
        return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.973 -0500", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "F921B2DFEAEC13798795DCF6CC1E5F34")
    
@Override public void encodeContent(BerOutputStream out) {
        out.encodeOctetString();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.976 -0500", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "180CA1AEB1CE9F7B268BC78AC57F4A6B")
    
@Override public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
    }
}

