package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.DirectoryString;

public final class EDIPartyName {
    private String nameAssigner;
    private String partyName;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.643 -0400", hash_original_method = "2E4835ED3F1B68ED273C9B2B326EFCFA", hash_generated_method = "FE80AE9A3C28C7380CE97E7195D65B33")
    @DSModeled(DSC.SAFE)
    private EDIPartyName(String nameAssigner, String partyName, byte[] encoding) {
        dsTaint.addTaint(partyName);
        dsTaint.addTaint(nameAssigner);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
        //this.nameAssigner = nameAssigner;
        //this.partyName = partyName;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.643 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                new ASN1Explicit(0, DirectoryString.ASN1),
                new ASN1Explicit(1, DirectoryString.ASN1)
            }) {        {
            setOptional(0);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.643 -0400", hash_original_method = "80CB811341E4F5308AB1A53211E096F1", hash_generated_method = "BEA558412A8FDFAAF7334A2722C5DD3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var982262D46C9FD02BE989B481493DF76E_1275010364 = (new EDIPartyName((String) values[0], (String) values[1],
                    in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new EDIPartyName((String) values[0], (String) values[1],
                    //in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.644 -0400", hash_original_method = "B1C02B42453062F13A81A1B4E1763CE8", hash_generated_method = "6D65913CDD17C2512D1E36DAB32C801C")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            EDIPartyName epn;
            epn = (EDIPartyName) object;
            values[0] = epn.nameAssigner;
            values[1] = epn.partyName;
            // ---------- Original Method ----------
            //EDIPartyName epn = (EDIPartyName) object;
            //values[0] = epn.nameAssigner;
            //values[1] = epn.partyName;
        }

        
}; //Transformed anonymous class
}

