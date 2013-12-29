package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class BasicConstraints extends ExtensionValue {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.845 -0400", hash_original_field = "08F29BA7DFA287FEFE128BE2F01D2233", hash_generated_field = "8C6491AD1E19D1D98E0A71A1D7A0B4B0")

    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Boolean.getInstance(), ASN1Integer.getInstance() }) {
        {
            setDefault(Boolean.FALSE, 0);
            setOptional(1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.724 -0500", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "B66EE4A4596F6ED85DA04FC094547D35")
        public Object getDecodedObject(BerInputStream in) throws IOException {
            return in.content;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.725 -0500", hash_original_method = "A1992AD437B5BD7EBE036BB635CECD5B", hash_generated_method = "77AA4D547272B40792A6559B61157478")
        protected void getValues(Object object, Object[] values) {
            Object[] array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.719 -0500", hash_original_field = "AB6282E6A316D6E21FB0AD3AFC9DA417", hash_generated_field = "6CCB782E85B2E142297EC5A5C8505CE2")

    private boolean ca = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.720 -0500", hash_original_field = "9AD509756B4BD6A6D64C446D8CB5D0ED", hash_generated_field = "C2B982A8CAC8FF9BE25F7B9D92A21175")

    private int pathLenConstraint = Integer.MAX_VALUE;

    /**
     * Creates the extension object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.721 -0500", hash_original_method = "98F3193EB5FEEA682D1EF037C6D0CBF1", hash_generated_method = "0094AF36B5E659EC475EF5D18369F294")
    public BasicConstraints(byte[] encoding) throws IOException {
        super(encoding);
        Object[] values = (Object[]) ASN1.decode(encoding);
        ca = (Boolean) values[0];
        if (values[1] != null) {
            pathLenConstraint = new BigInteger((byte[]) values[1]).intValue();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.722 -0500", hash_original_method = "BA19E2BECC620F0A37756A3C3C0D942D", hash_generated_method = "71593070597BC1EB6C5B74063E78A764")
    public int getPathLenConstraint() {
        return pathLenConstraint;
    }

    /**
     * Returns the encoded form of the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.722 -0500", hash_original_method = "946B6F20121D8D093231FCFBEB08839B", hash_generated_method = "8461DBA1A5D45C67C79BFC47B35D2B2F")
    public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.723 -0500", hash_original_method = "13B672A3A148C28AA73E910809626D2C", hash_generated_method = "298A8D6901C26F55484D56FDA2FF09C1")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("BasicConstraints [\n").append(prefix)
            .append("  CA: ").append(ca)
            .append("\n  ").append(prefix).append("pathLenConstraint: ")
            .append(pathLenConstraint).append('\n').append(prefix)
            .append("]\n");
    }
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) throws IOException {
            return in.content;
        }
    
    // orphaned legacy method
    protected void getValues(Object object, Object[] values) {
            Object[] array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
        }
    
}

