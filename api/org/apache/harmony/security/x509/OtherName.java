package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;






public final class OtherName {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.569 -0400", hash_original_field = "1D500C6DBA2251A558BBCB0545FF091B", hash_generated_field = "DB5EBDABA98F44EB3E15AA9BA7B3778D")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            new ASN1Explicit(0, ASN1Any.getInstance()) }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.919 -0500", hash_original_method = "FC6D2FA23EC46C968D9824F16BF66498", hash_generated_method = "7881AF0D8906B9CDB42F375775C678CF")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new OtherName(ObjectIdentifier.toString((int[]) values[0]),
                    (byte[]) values[1], in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.923 -0500", hash_original_method = "0DE9BAFC95122F8D50AA6EB71A414DDD", hash_generated_method = "DE7E7FB7C9B1AB0F23AA3BEED64AEAE6")
        
@Override protected void getValues(Object object, Object[] values) {
            OtherName on = (OtherName) object;
            values[0] = ObjectIdentifier.toIntArray(on.typeID);
            values[1] = on.value;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.897 -0500", hash_original_field = "A7CF1A91FCA6B015EBA5F7E3B9283BA8", hash_generated_field = "5C62373BB1CE6BB099AFB641D23AB828")

    private String typeID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.900 -0500", hash_original_field = "F9C75A2CE0A51DFBAC153841DAE8E8E2", hash_generated_field = "4A3D1B288C868029766DBCBE1C784E4E")

    private byte[] value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.904 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.908 -0500", hash_original_method = "8C037AC601E342BA78689B6228900DCB", hash_generated_method = "02376856375D882C7B27EA89F0499003")
    
public OtherName(String typeID, byte[] value) {
        this(typeID, value, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.911 -0500", hash_original_method = "595A6767FA47B61357D3EB21D3BC18A1", hash_generated_method = "40527F6E1D0BCF42501B2FD9E9D7D203")
    
private OtherName(String typeID, byte[] value, byte[] encoding) {
        this.typeID = typeID;
        this.value = value;
        this.encoding = encoding;
    }

    /**
     * Returns the value of value field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.913 -0500", hash_original_method = "7B542DE43DC21978E6F04336AAB05EBD", hash_generated_method = "97650376B82B1489652C66F91FF1242D")
    
public byte[] getValue() {
        return value;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 OtherName value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.916 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

