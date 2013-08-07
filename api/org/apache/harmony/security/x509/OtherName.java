package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;






public final class OtherName {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.567 -0400", hash_original_field = "C96CCC77A9681286BF7C11884DC97343", hash_generated_field = "5C62373BB1CE6BB099AFB641D23AB828")

    private String typeID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.567 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "4A3D1B288C868029766DBCBE1C784E4E")

    private byte[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.567 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.567 -0400", hash_original_method = "8C037AC601E342BA78689B6228900DCB", hash_generated_method = "09F0907ABE90DBAFBEFA8C413EFD8E2C")
    public  OtherName(String typeID, byte[] value) {
        this(typeID, value, null);
        addTaint(value[0]);
        addTaint(typeID.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.568 -0400", hash_original_method = "595A6767FA47B61357D3EB21D3BC18A1", hash_generated_method = "BFC1570F9ED10661ABF3396DF662D49E")
    private  OtherName(String typeID, byte[] value, byte[] encoding) {
        this.typeID = typeID;
        this.value = value;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.typeID = typeID;
        //this.value = value;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.568 -0400", hash_original_method = "7B542DE43DC21978E6F04336AAB05EBD", hash_generated_method = "9432476B34DA4E6D353FA5C5BFA6EE50")
    public byte[] getValue() {
        byte[] var2063C1608D6E0BAF80249C42E2BE5804_678284029 = (value);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_846681140 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_846681140;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.569 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "23E9CCF6B377B9EBA3A3218D6FED1CE3")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1764343781 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1240925224 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1240925224;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.569 -0400", hash_original_field = "1D500C6DBA2251A558BBCB0545FF091B", hash_generated_field = "DB5EBDABA98F44EB3E15AA9BA7B3778D")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            new ASN1Explicit(0, ASN1Any.getInstance()) }) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new OtherName(ObjectIdentifier.toString((int[]) values[0]),
                    (byte[]) values[1], in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            OtherName on = (OtherName) object;
            values[0] = ObjectIdentifier.toIntArray(on.typeID);
            values[1] = on.value;
        }
    };
}

