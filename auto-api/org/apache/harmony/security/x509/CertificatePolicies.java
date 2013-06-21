package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class CertificatePolicies extends ExtensionValue {
    private List<PolicyInformation> policyInformations;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.587 -0400", hash_original_method = "C31E4B8F2A567252600FDAE2EEE40805", hash_generated_method = "596ED5D28F3D7EA812E6FDACCFE73898")
    @DSModeled(DSC.SAFE)
    public CertificatePolicies() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.587 -0400", hash_original_method = "96307D3270AEFEAD70E1FBA0E6122CDE", hash_generated_method = "B4FBE236264B7ACD6244B0212B009308")
    @DSModeled(DSC.SAFE)
    private CertificatePolicies(List<PolicyInformation> policyInformations, byte[] encoding) {
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(policyInformations.dsTaint);
        // ---------- Original Method ----------
        //this.policyInformations = policyInformations;
        //this.encoding = encoding;
    }

    
        public static CertificatePolicies decode(byte[] encoding) throws IOException {
        CertificatePolicies cps = ((CertificatePolicies) ASN1.decode(encoding));
        cps.encoding = encoding;
        return cps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.587 -0400", hash_original_method = "183BA6590E2DC5B6BD268518AC8D5EF9", hash_generated_method = "D81E2A0318438BFB75820E91724E0574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<PolicyInformation> getPolicyInformations() {
        List<PolicyInformation> var4C49E3C6E5B60A10F00462DD8C890366_121381295 = (new ArrayList<PolicyInformation>(policyInformations));
        return (List<PolicyInformation>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ArrayList<PolicyInformation>(policyInformations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.587 -0400", hash_original_method = "A02C1EF38503FEE398CFC051AC7B3321", hash_generated_method = "49BDEBD0848991B29558CE196E94F38F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificatePolicies addPolicyInformation(PolicyInformation policyInformation) {
        dsTaint.addTaint(policyInformation.dsTaint);
        encoding = null;
        {
            policyInformations = new ArrayList<PolicyInformation>();
        } //End block
        policyInformations.add(policyInformation);
        return (CertificatePolicies)dsTaint.getTaint();
        // ---------- Original Method ----------
        //encoding = null;
        //if (policyInformations == null) {
            //policyInformations = new ArrayList<PolicyInformation>();
        //}
        //policyInformations.add(policyInformation);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.587 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.590 -0400", hash_original_method = "B37538291358B4289176EF26A3BFC720", hash_generated_method = "7B1334A2E485AAD50126C92982FCA68B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("CertificatePolicies [\n");
        {
            Iterator<PolicyInformation> varA4262885D0941F7E32CD8692CB983ECC_427779485 = (policyInformations).iterator();
            varA4262885D0941F7E32CD8692CB983ECC_427779485.hasNext();
            PolicyInformation policyInformation = varA4262885D0941F7E32CD8692CB983ECC_427779485.next();
            {
                sb.append(prefix);
                sb.append("  ");
                policyInformation.dumpValue(sb);
                sb.append('\n');
            } //End block
        } //End collapsed parenthetic
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("CertificatePolicies [\n");
        //for (PolicyInformation policyInformation : policyInformations) {
            //sb.append(prefix);
            //sb.append("  ");
            //policyInformation.dumpValue(sb);
            //sb.append('\n');
        //}
        //sb.append(prefix).append("]\n");
    }

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(PolicyInformation.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.590 -0400", hash_original_method = "457342872C7F92CB7E191C0BDCD7A375", hash_generated_method = "1FD991C4E2C0648DFF2A29F62142A425")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var2DCF6632236B54257C0CF301F343EF7E_2085664179 = (new CertificatePolicies((List<PolicyInformation>) in.content, in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CertificatePolicies((List<PolicyInformation>) in.content, in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.591 -0400", hash_original_method = "563F4100455C194AB82610E48FB026CF", hash_generated_method = "20AC1535DD8D741E09E7F92B2E1FE07C")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            CertificatePolicies cps;
            cps = (CertificatePolicies) object;
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //CertificatePolicies cps = (CertificatePolicies) object;
            //return cps.policyInformations;
        }

        
}; //Transformed anonymous class
}

