package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;

public final class ASN1Integer extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.972 -0400", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "61455BA42D466162249D5D385FEFD5D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Integer() {
        super(TAG_INTEGER);
        // ---------- Original Method ----------
    }

    
        public static ASN1Integer getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.973 -0400", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "59E621FC59FF3A02AC18B0F98844200A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readInteger();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_699822006 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readInteger();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.973 -0400", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "4BC0AD7D01F0868A643927E7A0967E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        byte[] bytesEncoded;
        bytesEncoded = new byte[in.length];
        System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                in.length);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.length];
        //System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                //in.length);
        //return bytesEncoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.973 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "A59C0D05F7EFCB81EEB267F4EF2C6BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeInteger();
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.973 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "5880804059FB3DAF2086019E77E60A22")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
        public static int toIntValue(Object decoded) {
        return new BigInteger((byte[]) decoded).intValue();
    }

    
        public static BigInteger toBigIntegerValue(Object decoded) {
        return new BigInteger((byte[]) decoded);
    }

    
        public static Object fromIntValue(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }

    
    private static final ASN1Integer ASN1 = new ASN1Integer();
}

