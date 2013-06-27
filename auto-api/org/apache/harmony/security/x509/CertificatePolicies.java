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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.474 -0400", hash_original_field = "8A453A2022E1867EC2E64B54690F3E98", hash_generated_field = "29ED1BA56666577354DE7DACD9A96978")

    private List<PolicyInformation> policyInformations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.474 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.475 -0400", hash_original_method = "C31E4B8F2A567252600FDAE2EEE40805", hash_generated_method = "596ED5D28F3D7EA812E6FDACCFE73898")
    public  CertificatePolicies() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.475 -0400", hash_original_method = "96307D3270AEFEAD70E1FBA0E6122CDE", hash_generated_method = "291C5527D4B0C336C8ABE03770958C2A")
    private  CertificatePolicies(List<PolicyInformation> policyInformations, byte[] encoding) {
        this.policyInformations = policyInformations;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.policyInformations = policyInformations;
        //this.encoding = encoding;
    }

    
        public static CertificatePolicies decode(byte[] encoding) throws IOException {
        CertificatePolicies cps = ((CertificatePolicies) ASN1.decode(encoding));
        cps.encoding = encoding;
        return cps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.479 -0400", hash_original_method = "183BA6590E2DC5B6BD268518AC8D5EF9", hash_generated_method = "52518C4884B91829F0FA4816B9E065A3")
    public List<PolicyInformation> getPolicyInformations() {
        List<PolicyInformation> varB4EAC82CA7396A68D541C85D26508E83_2017643176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2017643176 = new ArrayList<PolicyInformation>(policyInformations);
        varB4EAC82CA7396A68D541C85D26508E83_2017643176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017643176;
        // ---------- Original Method ----------
        //return new ArrayList<PolicyInformation>(policyInformations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.480 -0400", hash_original_method = "A02C1EF38503FEE398CFC051AC7B3321", hash_generated_method = "6C9600ACAE7B118E4EE259C6CEF41E31")
    public CertificatePolicies addPolicyInformation(PolicyInformation policyInformation) {
        CertificatePolicies varB4EAC82CA7396A68D541C85D26508E83_441405966 = null; //Variable for return #1
        encoding = null;
        {
            policyInformations = new ArrayList<PolicyInformation>();
        } //End block
        policyInformations.add(policyInformation);
        varB4EAC82CA7396A68D541C85D26508E83_441405966 = this;
        addTaint(policyInformation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_441405966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_441405966;
        // ---------- Original Method ----------
        //encoding = null;
        //if (policyInformations == null) {
            //policyInformations = new ArrayList<PolicyInformation>();
        //}
        //policyInformations.add(policyInformation);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.482 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "396F7930FBDBCF9788D326A5C07A2B6E")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1975969660 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1975969660;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.499 -0400", hash_original_method = "B37538291358B4289176EF26A3BFC720", hash_generated_method = "61BBE4D912B837B285CA016E7D5F5C3E")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CertificatePolicies [\n");
        {
            Iterator<PolicyInformation> varA4262885D0941F7E32CD8692CB983ECC_129564222 = (policyInformations).iterator();
            varA4262885D0941F7E32CD8692CB983ECC_129564222.hasNext();
            PolicyInformation policyInformation = varA4262885D0941F7E32CD8692CB983ECC_129564222.next();
            {
                sb.append(prefix);
                sb.append("  ");
                policyInformation.dumpValue(sb);
                sb.append('\n');
            } //End block
        } //End collapsed parenthetic
        sb.append(prefix).append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.499 -0400", hash_original_field = "513989838E566B722E0AE48FE445DE0C", hash_generated_field = "C5B8ADE8005B79F0446643932F6EFA0A")

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

