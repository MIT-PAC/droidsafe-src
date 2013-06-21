package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class BasicConstraints extends ExtensionValue {
    private boolean ca = false;
    private int pathLenConstraint = Integer.MAX_VALUE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.549 -0400", hash_original_method = "98F3193EB5FEEA682D1EF037C6D0CBF1", hash_generated_method = "C8BA261EE9E1897F53FF7D48F4E489CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BasicConstraints(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        Object[] values;
        values = (Object[]) ASN1.decode(encoding);
        ca = (Boolean) values[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.550 -0400", hash_original_method = "BA19E2BECC620F0A37756A3C3C0D942D", hash_generated_method = "94729D27DB420619E0E5841E3C56A0AF")
    @DSModeled(DSC.SAFE)
    public int getPathLenConstraint() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pathLenConstraint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.550 -0400", hash_original_method = "946B6F20121D8D093231FCFBEB08839B", hash_generated_method = "9D1C98512ECA4D6D20C93ADDF0DA3E33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(new Object[]{ca, BigInteger.valueOf(pathLenConstraint) });
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.551 -0400", hash_original_method = "13B672A3A148C28AA73E910809626D2C", hash_generated_method = "3B7CA26FA6A5B9BE6AB40EB3B5D02236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
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

    
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Boolean.getInstance(), ASN1Integer.getInstance() }) {        {
            setDefault(Boolean.FALSE, 0);
            setOptional(1);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.551 -0400", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "046961EE90BFB9EB3EEF2ED6697E00DD")
        @DSModeled(DSC.SAFE)
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return in.content;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.551 -0400", hash_original_method = "A1992AD437B5BD7EBE036BB635CECD5B", hash_generated_method = "3B838443302D7A81A85E8C9BACAB3E6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            Object[] array;
            array = (Object[]) object;
            values[0] = array[0];
            values[1] = ((BigInteger) array[1]).toByteArray();
            // ---------- Original Method ----------
            //Object[] array = (Object[]) object;
            //values[0] = array[0];
            //values[1] = ((BigInteger) array[1]).toByteArray();
        }

        
}; //Transformed anonymous class
}

