package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class OtherName {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.272 -0400", hash_original_field = "C96CCC77A9681286BF7C11884DC97343", hash_generated_field = "5C62373BB1CE6BB099AFB641D23AB828")

    private String typeID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.272 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "4A3D1B288C868029766DBCBE1C784E4E")

    private byte[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.272 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.273 -0400", hash_original_method = "8C037AC601E342BA78689B6228900DCB", hash_generated_method = "F68201F497BBA0AF5D040B3D70032C8E")
    public  OtherName(String typeID, byte[] value) {
        this(typeID, value, null);
        addTaint(typeID.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.273 -0400", hash_original_method = "595A6767FA47B61357D3EB21D3BC18A1", hash_generated_method = "BFC1570F9ED10661ABF3396DF662D49E")
    private  OtherName(String typeID, byte[] value, byte[] encoding) {
        this.typeID = typeID;
        this.value = value;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.typeID = typeID;
        //this.value = value;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.273 -0400", hash_original_method = "7B542DE43DC21978E6F04336AAB05EBD", hash_generated_method = "9A1B0736C4E955834DC017E7C6DF41B5")
    public byte[] getValue() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_574106168 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_574106168;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.274 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "FAFEEDA1EA55F5B26D539EF68C643DA0")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_140561570 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_140561570;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.274 -0400", hash_original_field = "1D500C6DBA2251A558BBCB0545FF091B", hash_generated_field = "DB5EBDABA98F44EB3E15AA9BA7B3778D")

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
    /*
    // orphaned legacy method
    @Override protected void getValues(Object object, Object[] values) {
            OtherName on = (OtherName) object;
            values[0] = ObjectIdentifier.toIntArray(on.typeID);
            values[1] = on.value;
        }
    
    // orphaned legacy method
    @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new OtherName(ObjectIdentifier.toString((int[]) values[0]),
                    (byte[]) values[1], in.getEncoded());
        }
    
    */
}

