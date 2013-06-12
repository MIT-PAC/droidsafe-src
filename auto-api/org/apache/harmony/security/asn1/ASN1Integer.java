package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.math.BigInteger;

public final class ASN1Integer extends ASN1Primitive {
    private static final ASN1Integer ASN1 = new ASN1Integer();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "3492B6C6D342B0A49FBFAD89DFD5CD01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Integer() {
        super(TAG_INTEGER);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "1093EBA3DAE5D53DB178C4D59A8B2A14", hash_generated_method = "9E4F649F74B3B370F5B00505CE7D7E68")
    public static ASN1Integer getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "2CA0F9BA94D4002CBA9B1C895F9F5C91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readInteger();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_492155100 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readInteger();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "D57C0BC4A32ADAAB3FE0BDD58E2D0AFB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "7D62FABB6F5C735BBF794ACE57D1FFA7")
    @DSModeled(DSC.SAFE)
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeInteger();
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "A73841C87AD2C7D3CE0A6597466E4D16")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "8E4CA51B7E680A60FEA1CBDAF0FD16D6", hash_generated_method = "C743A7FE4EBA471AA8FCEB886CE3FF2E")
    public static int toIntValue(Object decoded) {
        return new BigInteger((byte[]) decoded).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "250AC6C55784C8683EA0BB5B2A91C5D9", hash_generated_method = "94BA76524584CC3AD690F6D01F6464CF")
    public static BigInteger toBigIntegerValue(Object decoded) {
        return new BigInteger((byte[]) decoded);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.638 -0400", hash_original_method = "CD9FBA57A59BA88E6E945379741E0233", hash_generated_method = "9C12D3286368CC127062F658E5D732BE")
    public static Object fromIntValue(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }

    
}


