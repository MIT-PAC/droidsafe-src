package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class CertificatePolicies extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.758 -0400", hash_original_field = "8A453A2022E1867EC2E64B54690F3E98", hash_generated_field = "29ED1BA56666577354DE7DACD9A96978")

    private List<PolicyInformation> policyInformations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.758 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.758 -0400", hash_original_method = "C31E4B8F2A567252600FDAE2EEE40805", hash_generated_method = "596ED5D28F3D7EA812E6FDACCFE73898")
    public  CertificatePolicies() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.759 -0400", hash_original_method = "96307D3270AEFEAD70E1FBA0E6122CDE", hash_generated_method = "291C5527D4B0C336C8ABE03770958C2A")
    private  CertificatePolicies(List<PolicyInformation> policyInformations, byte[] encoding) {
        this.policyInformations = policyInformations;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.policyInformations = policyInformations;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
    public static CertificatePolicies decode(byte[] encoding) throws IOException {
        CertificatePolicies cps = ((CertificatePolicies) ASN1.decode(encoding));
        cps.encoding = encoding;
        return cps;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.759 -0400", hash_original_method = "183BA6590E2DC5B6BD268518AC8D5EF9", hash_generated_method = "691B28BAD0F4158EC127C00D5A0466DC")
    public List<PolicyInformation> getPolicyInformations() {
List<PolicyInformation> var6CCDA06F3940A33DB354D86B75B7FE27_754196603 =         new ArrayList<PolicyInformation>(policyInformations);
        var6CCDA06F3940A33DB354D86B75B7FE27_754196603.addTaint(taint);
        return var6CCDA06F3940A33DB354D86B75B7FE27_754196603;
        // ---------- Original Method ----------
        //return new ArrayList<PolicyInformation>(policyInformations);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.760 -0400", hash_original_method = "A02C1EF38503FEE398CFC051AC7B3321", hash_generated_method = "09CBC02AC75460E2AE490C8D0319091F")
    public CertificatePolicies addPolicyInformation(PolicyInformation policyInformation) {
        addTaint(policyInformation.getTaint());
        encoding = null;
    if(policyInformations == null)        
        {
            policyInformations = new ArrayList<PolicyInformation>();
        } //End block
        policyInformations.add(policyInformation);
CertificatePolicies var72A74007B2BE62B849F475C7BDA4658B_72081126 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_72081126.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_72081126;
        // ---------- Original Method ----------
        //encoding = null;
        //if (policyInformations == null) {
            //policyInformations = new ArrayList<PolicyInformation>();
        //}
        //policyInformations.add(policyInformation);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.760 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5EDC8B506C0931DDA2DA20BC4151F5C1")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1156895142 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_756010790 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_756010790;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.761 -0400", hash_original_method = "B37538291358B4289176EF26A3BFC720", hash_generated_method = "9964310256E79850122CC41E4A2EE6A9")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("CertificatePolicies [\n");
for(PolicyInformation policyInformation : policyInformations)
        {
            sb.append(prefix);
            sb.append("  ");
            policyInformation.dumpValue(sb);
            sb.append('\n');
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.761 -0400", hash_original_field = "513989838E566B722E0AE48FE445DE0C", hash_generated_field = "C5B8ADE8005B79F0446643932F6EFA0A")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(PolicyInformation.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new CertificatePolicies((List<PolicyInformation>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            CertificatePolicies cps = (CertificatePolicies) object;
            return cps.policyInformations;
        }
    };
}

