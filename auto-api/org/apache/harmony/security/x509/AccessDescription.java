package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class AccessDescription {
    private String accessMethod;
    private GeneralName accessLocation;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.522 -0400", hash_original_method = "FB49FC0C1C39F6A3E5A7CF2545478BA4", hash_generated_method = "27689C5AADC6E52BEBDEF975F694D98F")
    @DSModeled(DSC.SAFE)
    private AccessDescription(String accessMethod, GeneralName accessLocation, byte[] encoding) {
        dsTaint.addTaint(accessMethod);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(accessLocation.dsTaint);
        // ---------- Original Method ----------
        //this.accessMethod = accessMethod;
        //this.accessLocation = accessLocation;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.522 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.523 -0400", hash_original_method = "4D59D0B3E432FF02219BDDB6D479EFFA", hash_generated_method = "22A61F9D8ECA8321B97B6FBC8C5D86EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("\n-- AccessDescription:");
        res.append("\naccessMethod:  ");
        res.append(accessMethod);
        res.append("\naccessLocation:  ");
        res.append(accessLocation);
        res.append("\n-- AccessDescription END\n");
        String var3F7A63C0290A7D59CE78DF2F46EB4AAE_2077874981 = (res.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("\n-- AccessDescription:");
        //res.append("\naccessMethod:  ");
        //res.append(accessMethod);
        //res.append("\naccessLocation:  ");
        //res.append(accessLocation);
        //res.append("\n-- AccessDescription END\n");
        //return res.toString();
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            GeneralName.ASN1 }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.523 -0400", hash_original_method = "1D159E6CCAE0893CDD0658CA6C34CFD2", hash_generated_method = "D189EAFF76A9B8605EE470EEFAFE6165")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var08EB0C78825F0F8FE75C7DA6A85953B8_872399403 = (new AccessDescription(
                    ObjectIdentifier.toString((int[]) values[0]),
                    (GeneralName) values[1], in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new AccessDescription(
                    //ObjectIdentifier.toString((int[]) values[0]),
                    //(GeneralName) values[1], in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.523 -0400", hash_original_method = "7BC355E37B89E837034CC3EA45D5612B", hash_generated_method = "2774613B780C7A8879EF545C2021354A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            AccessDescription ad;
            ad = (AccessDescription) object;
            values[0] = ObjectIdentifier.toIntArray(ad.accessMethod);
            values[1] = ad.accessLocation;
            // ---------- Original Method ----------
            //AccessDescription ad = (AccessDescription) object;
            //values[0] = ObjectIdentifier.toIntArray(ad.accessMethod);
            //values[1] = ad.accessLocation;
        }

        
}; //Transformed anonymous class
}

