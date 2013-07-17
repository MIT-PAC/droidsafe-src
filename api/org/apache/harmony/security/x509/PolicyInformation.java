package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class PolicyInformation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_field = "92D0D21381807C8F8C4846CC406188DF", hash_generated_field = "9775983C00DA46C6C34065F5DC2DC5C0")

    private String policyIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.241 -0400", hash_original_method = "97521BA30F23785F6A554ACA63DC6021", hash_generated_method = "9C337939CB6B38E442B16C9693BA1B39")
    public  PolicyInformation(String policyIdentifier) {
        this.policyIdentifier = policyIdentifier;
        // ---------- Original Method ----------
        //this.policyIdentifier = policyIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_method = "012FFA67DCC82ECD3E1505D0CB12E6E1", hash_generated_method = "1A2D50E14815BC5A1648FC770B83EBA2")
    public String getPolicyIdentifier() {
String var042D1F5662848EDA928AD6E741377A61_782747704 =         policyIdentifier;
        var042D1F5662848EDA928AD6E741377A61_782747704.addTaint(taint);
        return var042D1F5662848EDA928AD6E741377A61_782747704;
        // ---------- Original Method ----------
        //return policyIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "507BDE0881F556636F0EC9C48367C7F7")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1445711149 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_776607001 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_776607001;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_method = "76E469F93D4AF204B8C17A8AD4618A81", hash_generated_method = "833700E728FE3DDB33EA1D44455CD57E")
    public void dumpValue(StringBuilder sb) {
        addTaint(sb.getTaint());
        sb.append("Policy Identifier [").append(policyIdentifier).append(']');
        // ---------- Original Method ----------
        //sb.append("Policy Identifier [").append(policyIdentifier).append(']');
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_field = "5F2D8C5221F74D1DF86123C2DA677D6B", hash_generated_field = "BFFF063EC30CEABB951E1244D2EB5617")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] { ASN1Oid.getInstance(), ASN1Any.getInstance() }) {
        {
            setOptional(1);
        }

		@DSModeled(DSC.SAFE)
        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new PolicyInformation(ObjectIdentifier.toString((int[]) values[0]));
        }

		@DSModeled(DSC.SAFE)
        @Override protected void getValues(Object object, Object[] values) {
            PolicyInformation pi = (PolicyInformation) object;
            values[0] = ObjectIdentifier.toIntArray(pi.policyIdentifier);
        }
    };
}

