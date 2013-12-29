package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;






public final class PolicyInformation {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_field = "5F2D8C5221F74D1DF86123C2DA677D6B", hash_generated_field = "BFFF063EC30CEABB951E1244D2EB5617")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] { ASN1Oid.getInstance(), ASN1Any.getInstance() }) {
        {
            setOptional(1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.375 -0500", hash_original_method = "8501EA7BFA173E6518BAFB2356927122", hash_generated_method = "09D687E9F905A831F5B25FAAFF17A479")
        @Override
protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new PolicyInformation(ObjectIdentifier.toString((int[]) values[0]));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.376 -0500", hash_original_method = "0627C35F4A048D619EB92B23493B5466", hash_generated_method = "3A58122F2D5CFA5A8FDBF58E91D783DC")
        @Override
protected void getValues(Object object, Object[] values) {
            PolicyInformation pi = (PolicyInformation) object;
            values[0] = ObjectIdentifier.toIntArray(pi.policyIdentifier);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.369 -0500", hash_original_field = "A9ABC7EE563DCA91222939281867AAC8", hash_generated_field = "9775983C00DA46C6C34065F5DC2DC5C0")

    private  String policyIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.371 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.371 -0500", hash_original_method = "97521BA30F23785F6A554ACA63DC6021", hash_generated_method = "833091C6C18CA140FD7DE85A57DDDAB7")
    public PolicyInformation(String policyIdentifier) {
        this.policyIdentifier = policyIdentifier;
    }

    /**
     * Returns the value of policyIdentifier field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.372 -0500", hash_original_method = "012FFA67DCC82ECD3E1505D0CB12E6E1", hash_generated_method = "637BB49A56CB3A3EEA0763BCBC98422F")
    public String getPolicyIdentifier() {
        return policyIdentifier;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 PolicyInformation value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.373 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.374 -0500", hash_original_method = "76E469F93D4AF204B8C17A8AD4618A81", hash_generated_method = "9EC1E0EA0EE52F366308126A8C4FEA58")
    public void dumpValue(StringBuilder sb) {
        sb.append("Policy Identifier [").append(policyIdentifier).append(']');
    }
}

