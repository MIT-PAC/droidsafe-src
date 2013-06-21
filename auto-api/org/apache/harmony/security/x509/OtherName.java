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
    private String typeID;
    private byte[] value;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.892 -0400", hash_original_method = "8C037AC601E342BA78689B6228900DCB", hash_generated_method = "7AABCACFFB3FBD90F95CAF8B0C39C7FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OtherName(String typeID, byte[] value) {
        this(typeID, value, null);
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(typeID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.892 -0400", hash_original_method = "595A6767FA47B61357D3EB21D3BC18A1", hash_generated_method = "CCAA19139A6F074097CA956C82F96100")
    @DSModeled(DSC.SAFE)
    private OtherName(String typeID, byte[] value, byte[] encoding) {
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(typeID);
        // ---------- Original Method ----------
        //this.typeID = typeID;
        //this.value = value;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.892 -0400", hash_original_method = "7B542DE43DC21978E6F04336AAB05EBD", hash_generated_method = "1EFCFD46306E648A9026A2E25CA2E817")
    @DSModeled(DSC.SAFE)
    public byte[] getValue() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.892 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            new ASN1Explicit(0, ASN1Any.getInstance()) }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.893 -0400", hash_original_method = "FC6D2FA23EC46C968D9824F16BF66498", hash_generated_method = "A6B3CA6E15DC25AE3642B84268F05DF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var274A4A22506BC0B71BC7BC4D5A8A152D_1643148541 = (new OtherName(ObjectIdentifier.toString((int[]) values[0]),
                    (byte[]) values[1], in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new OtherName(ObjectIdentifier.toString((int[]) values[0]),
                    //(byte[]) values[1], in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.893 -0400", hash_original_method = "0DE9BAFC95122F8D50AA6EB71A414DDD", hash_generated_method = "236B5224E11D4CFFDC69BE6CBEFBCCBD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            OtherName on;
            on = (OtherName) object;
            values[0] = ObjectIdentifier.toIntArray(on.typeID);
            values[1] = on.value;
            // ---------- Original Method ----------
            //OtherName on = (OtherName) object;
            //values[0] = ObjectIdentifier.toIntArray(on.typeID);
            //values[1] = on.value;
        }

        
}; //Transformed anonymous class
}

