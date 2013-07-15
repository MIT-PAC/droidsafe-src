package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class BasicConstraints extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.705 -0400", hash_original_field = "817E3D0F920B53847D3651CC2A6001CF", hash_generated_field = "6CCB782E85B2E142297EC5A5C8505CE2")

    private boolean ca = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.705 -0400", hash_original_field = "02B0C3A5410A6A32EF6A6055239C5A25", hash_generated_field = "C2B982A8CAC8FF9BE25F7B9D92A21175")

    private int pathLenConstraint = Integer.MAX_VALUE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.705 -0400", hash_original_method = "98F3193EB5FEEA682D1EF037C6D0CBF1", hash_generated_method = "21204B31B29AB410B6637338560FD5BF")
    public  BasicConstraints(byte[] encoding) throws IOException {
        super(encoding);
        addTaint(encoding[0]);
        Object[] values = (Object[]) ASN1.decode(encoding);
        ca = (Boolean) values[0];
    if(values[1] != null)        
        {
            pathLenConstraint = new BigInteger((byte[]) values[1]).intValue();
        } //End block
        // ---------- Original Method ----------
        //Object[] values = (Object[]) ASN1.decode(encoding);
        //ca = (Boolean) values[0];
        //if (values[1] != null) {
            //pathLenConstraint = new BigInteger((byte[]) values[1]).intValue();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.705 -0400", hash_original_method = "BA19E2BECC620F0A37756A3C3C0D942D", hash_generated_method = "D471F9165C3AEDEAA153BF5C970892A1")
    public int getPathLenConstraint() {
        int var9DE6E40C955CD00B514CC5F874B7A6BA_1408831816 = (pathLenConstraint);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713918109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713918109;
        // ---------- Original Method ----------
        //return pathLenConstraint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.706 -0400", hash_original_method = "946B6F20121D8D093231FCFBEB08839B", hash_generated_method = "553C6F781FFEB7787B220B01A2F07F8E")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1797831550 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1027337270 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1027337270;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.706 -0400", hash_original_method = "13B672A3A148C28AA73E910809626D2C", hash_generated_method = "067B8394D5404825844B6BE829E1DD07")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("BasicConstraints [\n").append(prefix)
            .append("  CA: ").append(ca)
            .append("\n  ").append(prefix).append("pathLenConstraint: ")
            .append(pathLenConstraint).append('\n').append(prefix)
            .append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("BasicConstraints [\n").append(prefix)
            //.append("  CA: ").append(ca)
            //.append("\n  ").append(prefix).append("pathLenConstraint: ")
            //.append(pathLenConstraint).append('\n').append(prefix)
            //.append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.706 -0400", hash_original_field = "08F29BA7DFA287FEFE128BE2F01D2233", hash_generated_field = "8C6491AD1E19D1D98E0A71A1D7A0B4B0")

    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Boolean.getInstance(), ASN1Integer.getInstance() }) {
        {
            setDefault(Boolean.FALSE, 0);
            setOptional(1);
        }

        public Object getDecodedObject(BerInputStream in) throws IOException {
            return in.content;
        }

        protected void getValues(Object object, Object[] values) {
            Object[] array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
        }
    };
    // orphaned legacy method
    protected void getValues(Object object, Object[] values) {
            Object[] array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
        }
    
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) throws IOException {
            return in.content;
        }
    
}

