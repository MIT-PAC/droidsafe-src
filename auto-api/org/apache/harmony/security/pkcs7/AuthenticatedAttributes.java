package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;

final class AuthenticatedAttributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.732 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.732 -0400", hash_original_field = "6898DC6E12D104D17852F4A4A49EA05A", hash_generated_field = "147A37554AFD2423D8BB55EBBE06C894")

    private List<AttributeTypeAndValue> authenticatedAttributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.736 -0400", hash_original_method = "56322F0DE2F5B85A8944FA9A9F9F5ADE", hash_generated_method = "160A13FCA6726717A1B9C3D9A09862BE")
    private  AuthenticatedAttributes(byte[] encoding,
            List<AttributeTypeAndValue> authenticatedAttributes) {
        this.encoding = encoding;
        this.authenticatedAttributes = authenticatedAttributes;
        // ---------- Original Method ----------
        //this.encoding = encoding;
        //this.authenticatedAttributes = authenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.737 -0400", hash_original_method = "17512B9B260049DCE667B4C278AB32BC", hash_generated_method = "B603E08319D267F531C8CAA0B895BC28")
    public List<AttributeTypeAndValue> getAttributes() {
        List<AttributeTypeAndValue> varB4EAC82CA7396A68D541C85D26508E83_1929760266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929760266 = authenticatedAttributes;
        varB4EAC82CA7396A68D541C85D26508E83_1929760266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929760266;
        // ---------- Original Method ----------
        //return authenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.738 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "FA64DB6AF2969C641DDD00EBC752C61C")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_493230333 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_493230333;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.738 -0400", hash_original_field = "2611A8BAF0FBA182E1D618DBDEE9F51B", hash_generated_field = "F0C53D8DBCC45A640193D6CD74C62FBF")

    public static final ASN1SetOf ASN1 =
        new ASN1SetOf(AttributeTypeAndValue.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new AuthenticatedAttributes(in.getEncoded(),
                    (List<AttributeTypeAndValue>) in.content);
        }
    };
}

