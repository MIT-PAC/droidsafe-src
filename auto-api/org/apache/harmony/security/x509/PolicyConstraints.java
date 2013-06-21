package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class PolicyConstraints extends ExtensionValue {
    private BigInteger requireExplicitPolicy;
    private BigInteger inhibitPolicyMapping;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.898 -0400", hash_original_method = "4066280A3CCDE594602954A8F84CD571", hash_generated_method = "A45A4E9DF3F0CD2241A7890B03B9C877")
    @DSModeled(DSC.SAFE)
    public PolicyConstraints(BigInteger requireExplicitPolicy,
            BigInteger inhibitPolicyMapping) {
        dsTaint.addTaint(requireExplicitPolicy.dsTaint);
        dsTaint.addTaint(inhibitPolicyMapping.dsTaint);
        // ---------- Original Method ----------
        //this.requireExplicitPolicy = requireExplicitPolicy;
        //this.inhibitPolicyMapping = inhibitPolicyMapping;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.898 -0400", hash_original_method = "D14D123A6A25A0AC6CCBFD6F67D6AABA", hash_generated_method = "C57F9FFEE44FC5BDD2605797315959FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PolicyConstraints(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        PolicyConstraints pc;
        pc = (PolicyConstraints) ASN1.decode(encoding);
        this.requireExplicitPolicy = pc.requireExplicitPolicy;
        this.inhibitPolicyMapping = pc.inhibitPolicyMapping;
        // ---------- Original Method ----------
        //PolicyConstraints pc = (PolicyConstraints) ASN1.decode(encoding);
        //this.requireExplicitPolicy = pc.requireExplicitPolicy;
        //this.inhibitPolicyMapping = pc.inhibitPolicyMapping;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.898 -0400", hash_original_method = "8B4F6C3FF9A61E2FC4F0FDE77894DD6A", hash_generated_method = "AD4666E80CA4B564EA7233D681DE41A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PolicyConstraints(BigInteger requireExplicitPolicy,
                            BigInteger inhibitPolicyMapping, byte[] encoding) {
        this(requireExplicitPolicy, inhibitPolicyMapping);
        dsTaint.addTaint(requireExplicitPolicy.dsTaint);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(inhibitPolicyMapping.dsTaint);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.898 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.899 -0400", hash_original_method = "6254749C2BCE6B73C098F3685BA802AD", hash_generated_method = "B908C00A4A5822AB9ADC253470DD815D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("PolicyConstraints: [\n");
        {
            sb.append(prefix).append("  requireExplicitPolicy: ").append(requireExplicitPolicy).append('\n');
        } //End block
        {
            sb.append(prefix).append("  inhibitPolicyMapping: ").append(inhibitPolicyMapping).append('\n');
        } //End block
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("PolicyConstraints: [\n");
        //if (requireExplicitPolicy != null) {
            //sb.append(prefix).append("  requireExplicitPolicy: ").append(requireExplicitPolicy).append('\n');
        //}
        //if (inhibitPolicyMapping != null) {
            //sb.append(prefix).append("  inhibitPolicyMapping: ").append(inhibitPolicyMapping).append('\n');
        //}
        //sb.append(prefix).append("]\n");
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Implicit(0, ASN1Integer.getInstance()),
            new ASN1Implicit(1, ASN1Integer.getInstance()) }) {        {
            setOptional(0);
            setOptional(1);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.899 -0400", hash_original_method = "52D1944AB6FBE2391120949CCC85415F", hash_generated_method = "B86B774D2F36B956F0367D2E8FFD23E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            BigInteger requireExplicitPolicy;
            requireExplicitPolicy = null;
            BigInteger inhibitPolicyMapping;
            inhibitPolicyMapping = null;
            {
                requireExplicitPolicy = new BigInteger((byte[]) values[0]);
            } //End block
            {
                inhibitPolicyMapping = new BigInteger((byte[]) values[1]);
            } //End block
            Object var12A9579EE8E34C19CE78F6D3FA8428EB_1931199772 = (new PolicyConstraints(
                requireExplicitPolicy, inhibitPolicyMapping,
                    in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //BigInteger requireExplicitPolicy = null;
            //BigInteger inhibitPolicyMapping = null;
            //if (values[0] != null) {
                //requireExplicitPolicy = new BigInteger((byte[]) values[0]);
            //}
            //if (values[1] != null) {
                //inhibitPolicyMapping = new BigInteger((byte[]) values[1]);
            //}
            //return new PolicyConstraints(
                //requireExplicitPolicy, inhibitPolicyMapping,
                    //in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.899 -0400", hash_original_method = "50126F45A388A526E7AF739F350CFA6E", hash_generated_method = "810C1C6EA57CB93BB8FDB623290A7E54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            PolicyConstraints pc;
            pc = (PolicyConstraints) object;
            values[0] = pc.requireExplicitPolicy.toByteArray();
            values[1] = pc.inhibitPolicyMapping.toByteArray();
            // ---------- Original Method ----------
            //PolicyConstraints pc = (PolicyConstraints) object;
            //values[0] = pc.requireExplicitPolicy.toByteArray();
            //values[1] = pc.inhibitPolicyMapping.toByteArray();
        }

        
}; //Transformed anonymous class
}

