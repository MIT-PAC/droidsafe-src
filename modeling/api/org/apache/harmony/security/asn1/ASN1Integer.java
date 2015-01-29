package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

public final class ASN1Integer extends ASN1Primitive {

    /**
     * Returns ASN.1 Integer type default implementation
     *
     * The default implementation works with encoding
     * that is represented as byte array in two's-complement notation.
     *
     * @return ASN.1 Integer type default implementation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.185 -0500", hash_original_method = "1093EBA3DAE5D53DB178C4D59A8B2A14", hash_generated_method = "9E4F649F74B3B370F5B00505CE7D7E68")
    
public static ASN1Integer getInstance() {
        return ASN1;
    }

    /**
     * Converts decoded ASN.1 Integer to int value.
     * If the object represents an integer value
     * larger than 32 bits, the high bits will be lost.
     *
     * @param decoded a decoded object corresponding to this type
     * @return decoded int value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.196 -0500", hash_original_method = "8E4CA51B7E680A60FEA1CBDAF0FD16D6", hash_generated_method = "C743A7FE4EBA471AA8FCEB886CE3FF2E")
    
public static int toIntValue(Object decoded) {
        return new BigInteger((byte[]) decoded).intValue();
    }

    /**
     * Converts decoded ASN.1 Integer to a BigInteger.
     *
     * @param decoded a decoded object corresponding to this type
     * @return decoded BigInteger value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.198 -0500", hash_original_method = "250AC6C55784C8683EA0BB5B2A91C5D9", hash_generated_method = "94BA76524584CC3AD690F6D01F6464CF")
    
public static BigInteger toBigIntegerValue(Object decoded) {
        return new BigInteger((byte[]) decoded);
    }

    /**
     * Converts primitive int value to a form most suitable for encoding.
     *
     * @param value primitive value to be encoded
     * @return object suitable for encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.200 -0500", hash_original_method = "CD9FBA57A59BA88E6E945379741E0233", hash_generated_method = "9C12D3286368CC127062F658E5D732BE")
    
public static Object fromIntValue(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.180 -0500", hash_original_field = "93E09AECDFC0248EAC1F2CC041306588", hash_generated_field = "7903D35656FA59C7967A1F03B51EB6F4")

    private static final ASN1Integer ASN1 = new ASN1Integer();

    /**
     * Constructs ASN.1 Integer type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 Integer type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.183 -0500", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "5234CE4192CB7739898FB9F5A94CDDD8")
    
public ASN1Integer() {
        super(TAG_INTEGER);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.187 -0500", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "80072B483C0DBDF584596A617B762519")
    
public Object decode(BerInputStream in) throws IOException {
        in.readInteger();

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.189 -0500", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "F8DB7E0AEEC1ADA176EAD89B6DA9EBBD")
    
public Object getDecodedObject(BerInputStream in) throws IOException {
        byte[] bytesEncoded = new byte[in.length];
        System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                in.length);
        return bytesEncoded;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.192 -0500", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "AB94A046A59914D165FB9FEA5F11112A")
    
public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.194 -0500", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "74427AC68000019C393865D49DAE53B9")
    
public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
    }
}

