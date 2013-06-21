package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class Validity {
    private Date notBefore;
    private Date notAfter;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.047 -0400", hash_original_method = "F8867A5D4F27966CF2038460A4C147B6", hash_generated_method = "B9E8314B2C1168F03A14CE7B0D47A952")
    @DSModeled(DSC.SAFE)
    public Validity(Date notBefore, Date notAfter) {
        dsTaint.addTaint(notBefore.dsTaint);
        dsTaint.addTaint(notAfter.dsTaint);
        // ---------- Original Method ----------
        //this.notBefore = notBefore;
        //this.notAfter = notAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.047 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "4081E5740A71757760F09E9889C23E8B")
    @DSModeled(DSC.SAFE)
    public Date getNotBefore() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return notBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.048 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "E6703BC542131D131FEB42D249EEA8EC")
    @DSModeled(DSC.SAFE)
    public Date getNotAfter() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return notAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.048 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {Time.ASN1, Time.ASN1 }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.048 -0400", hash_original_method = "F657B381EF2DD7260C3FCC1376D0818A", hash_generated_method = "20D877379D9A052A0B9613F85774A692")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object varD4FB8AE2A8BB4FCCD9E439577CA57C9A_206857546 = (new Validity((Date) values[0], (Date) values[1]));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new Validity((Date) values[0], (Date) values[1]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.049 -0400", hash_original_method = "3170F5CCBA8205B82D53F07AAA85DBB3", hash_generated_method = "316E0C1A034CF3B6ADE85F2ED15C39C8")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            Validity validity;
            validity = (Validity) object;
            values[0] = validity.notBefore;
            values[1] = validity.notAfter;
            // ---------- Original Method ----------
            //Validity validity = (Validity) object;
            //values[0] = validity.notBefore;
            //values[1] = validity.notAfter;
        }

        
}; //Transformed anonymous class
}

