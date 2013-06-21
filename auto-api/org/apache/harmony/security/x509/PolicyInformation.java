package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class PolicyInformation {
    private String policyIdentifier;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.903 -0400", hash_original_method = "97521BA30F23785F6A554ACA63DC6021", hash_generated_method = "4CC46DBB130D728B86C74C368A866978")
    @DSModeled(DSC.SAFE)
    public PolicyInformation(String policyIdentifier) {
        dsTaint.addTaint(policyIdentifier);
        // ---------- Original Method ----------
        //this.policyIdentifier = policyIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.903 -0400", hash_original_method = "012FFA67DCC82ECD3E1505D0CB12E6E1", hash_generated_method = "F235639D7654906EDA88D192B2F93AFE")
    @DSModeled(DSC.SAFE)
    public String getPolicyIdentifier() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return policyIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.903 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.903 -0400", hash_original_method = "76E469F93D4AF204B8C17A8AD4618A81", hash_generated_method = "D8B050FE73125B494B418725586E85B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        sb.append("Policy Identifier [").append(policyIdentifier).append(']');
        // ---------- Original Method ----------
        //sb.append("Policy Identifier [").append(policyIdentifier).append(']');
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] { ASN1Oid.getInstance(), ASN1Any.getInstance() }) {        {
            setOptional(1);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.904 -0400", hash_original_method = "8501EA7BFA173E6518BAFB2356927122", hash_generated_method = "0A934FC1C1E805118BA4208B9593A79D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var4DE84834F726062BC63AA5EF5B413311_756545729 = (new PolicyInformation(ObjectIdentifier.toString((int[]) values[0])));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new PolicyInformation(ObjectIdentifier.toString((int[]) values[0]));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.904 -0400", hash_original_method = "0627C35F4A048D619EB92B23493B5466", hash_generated_method = "3C3936887849218866E6573BE9B0E245")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            PolicyInformation pi;
            pi = (PolicyInformation) object;
            values[0] = ObjectIdentifier.toIntArray(pi.policyIdentifier);
            // ---------- Original Method ----------
            //PolicyInformation pi = (PolicyInformation) object;
            //values[0] = ObjectIdentifier.toIntArray(pi.policyIdentifier);
        }

        
}; //Transformed anonymous class
}

