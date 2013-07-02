package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class BasicConstraints extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.636 -0400", hash_original_field = "817E3D0F920B53847D3651CC2A6001CF", hash_generated_field = "6CCB782E85B2E142297EC5A5C8505CE2")

    private boolean ca = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.636 -0400", hash_original_field = "02B0C3A5410A6A32EF6A6055239C5A25", hash_generated_field = "C2B982A8CAC8FF9BE25F7B9D92A21175")

    private int pathLenConstraint = Integer.MAX_VALUE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.637 -0400", hash_original_method = "98F3193EB5FEEA682D1EF037C6D0CBF1", hash_generated_method = "2A77D4C0C85DE5457C2133F9F8EB375E")
    public  BasicConstraints(byte[] encoding) throws IOException {
        super(encoding);
        Object[] values = (Object[]) ASN1.decode(encoding);
        ca = (Boolean) values[0];
        {
            pathLenConstraint = new BigInteger((byte[]) values[1]).intValue();
        } 
        addTaint(encoding[0]);
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.637 -0400", hash_original_method = "BA19E2BECC620F0A37756A3C3C0D942D", hash_generated_method = "FD0A4C9A11EC32E0180330493C23EC16")
    public int getPathLenConstraint() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104926690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104926690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.637 -0400", hash_original_method = "946B6F20121D8D093231FCFBEB08839B", hash_generated_method = "BBE0E1456265EB6113D2D9892F88AC03")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_836963942 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_836963942;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.638 -0400", hash_original_method = "13B672A3A148C28AA73E910809626D2C", hash_generated_method = "2DF0665AF5898EC21D2E09C6E8B35F29")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("BasicConstraints [\n").append(prefix)
            .append("  CA: ").append(ca)
            .append("\n  ").append(prefix).append("pathLenConstraint: ")
            .append(pathLenConstraint).append('\n').append(prefix)
            .append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
            
            
            
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.638 -0400", hash_original_field = "08F29BA7DFA287FEFE128BE2F01D2233", hash_generated_field = "8C6491AD1E19D1D98E0A71A1D7A0B4B0")

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
    
    protected void getValues(Object object, Object[] values) {
            Object[] array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
        }
    
    
    public Object getDecodedObject(BerInputStream in) throws IOException {
            return in.content;
        }
    
}

