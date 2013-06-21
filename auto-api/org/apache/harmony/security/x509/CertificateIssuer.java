package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class CertificateIssuer extends ExtensionValue {
    private X500Principal issuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.577 -0400", hash_original_method = "DA4BDBC496D2A998B5C29C74B17A91EA", hash_generated_method = "77BD8292F522060C2F26346305F90BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateIssuer(byte[] encoding) {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.577 -0400", hash_original_method = "A624F7DB93A0D045C3602F26988D09C5", hash_generated_method = "809888AE4CD2F29C7F0F041DB3844A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getIssuer() throws IOException {
        {
            issuer = (X500Principal) ASN1.decode(getEncoded());
        } //End block
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (issuer == null) {
            //issuer = (X500Principal) ASN1.decode(getEncoded());
        //}
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.577 -0400", hash_original_method = "50826A9F4B6111EEE8495EBA7ED178B7", hash_generated_method = "4424F480461FE988F576EAAC80D9FDA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Certificate Issuer: ");
        {
            try 
            {
                issuer = getIssuer();
            } //End block
            catch (IOException e)
            {
                sb.append("Unparseable (incorrect!) extension value:\n");
                super.dumpValue(sb);
            } //End block
        } //End block
        sb.append(issuer).append('\n');
        // ---------- Original Method ----------
        //sb.append(prefix).append("Certificate Issuer: ");
        //if (issuer == null) {
            //try {
                //issuer = getIssuer();
            //} catch (IOException e) {
                //sb.append("Unparseable (incorrect!) extension value:\n");
                //super.dumpValue(sb);
            //}
        //}
        //sb.append(issuer).append('\n');
    }

    
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] { GeneralName.ASN1 }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.577 -0400", hash_original_method = "B2A2BF1AEEB9B5ED68F04D56AA862E02", hash_generated_method = "C67E6426673167A54AD28DC1D75DB398")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var3E5E69D0CB6F4DFC71AEC67CBE6BE9C2_502810807 = (((Name) ((GeneralName) ((Object[]) in.content)[0])
                    .getName()).getX500Principal());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((Name) ((GeneralName) ((Object[]) in.content)[0])
                    //.getName()).getX500Principal();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.578 -0400", hash_original_method = "F62248487F946226E81F44B251123553", hash_generated_method = "0CE378D78D973F6CBAE1E23D108A714F")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            values[0] = object;
            // ---------- Original Method ----------
            //values[0] = object;
        }

        
}; //Transformed anonymous class
}

