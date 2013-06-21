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
    private byte[] encoding;
    private List<AttributeTypeAndValue> authenticatedAttributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.159 -0400", hash_original_method = "56322F0DE2F5B85A8944FA9A9F9F5ADE", hash_generated_method = "7B4B46006311348A83D7DB6329E0DD04")
    @DSModeled(DSC.SAFE)
    private AuthenticatedAttributes(byte[] encoding,
            List<AttributeTypeAndValue> authenticatedAttributes) {
        dsTaint.addTaint(authenticatedAttributes.dsTaint);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
        //this.encoding = encoding;
        //this.authenticatedAttributes = authenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.159 -0400", hash_original_method = "17512B9B260049DCE667B4C278AB32BC", hash_generated_method = "1A8B46DEC5B5530CBBFA237DB29AA786")
    @DSModeled(DSC.SAFE)
    public List<AttributeTypeAndValue> getAttributes() {
        return (List<AttributeTypeAndValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return authenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.159 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    public static final ASN1SetOf ASN1 = new ASN1SetOf(AttributeTypeAndValue.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.159 -0400", hash_original_method = "5573740F3DACB7D46EB4DD6230978B94", hash_generated_method = "EC73E7361A1991A446A31EE06C09ED35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var4A8786FBB0ECE2C0AD66FCDF56211D64_1598913324 = (new AuthenticatedAttributes(in.getEncoded(),
                    (List<AttributeTypeAndValue>) in.content));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AuthenticatedAttributes(in.getEncoded(),
                    //(List<AttributeTypeAndValue>) in.content);
        }

        
}; //Transformed anonymous class
}

