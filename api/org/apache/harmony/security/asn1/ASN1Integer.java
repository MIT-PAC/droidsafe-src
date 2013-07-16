package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;

public final class ASN1Integer extends ASN1Primitive {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.626 -0400", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "61455BA42D466162249D5D385FEFD5D0")
    public  ASN1Integer() {
        super(TAG_INTEGER);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    public static ASN1Integer getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.626 -0400", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "E984535F6433DFD74018941C88820D95")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readInteger();
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_795043020 =             null;
            var540C13E9E156B687226421B24F2DF178_795043020.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_795043020;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_570767924 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_570767924.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_570767924;
        // ---------- Original Method ----------
        //in.readInteger();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.627 -0400", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "3988818AC785E642553435103B06056E")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        byte[] bytesEncoded = new byte[in.length];
        System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                in.length);
Object varE123E70E73254F8B84526419D168A7C8_263992367 =         bytesEncoded;
        varE123E70E73254F8B84526419D168A7C8_263992367.addTaint(taint);
        return varE123E70E73254F8B84526419D168A7C8_263992367;
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.length];
        //System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                //in.length);
        //return bytesEncoded;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.627 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "F49D576287ACA2BF4FA8640DE6F6151F")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeInteger();
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.627 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "CF6C0D89125D265A070FAEF45137B38D")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
        @DSModeled(DSC.SAFE)
    public static int toIntValue(Object decoded) {
        return new BigInteger((byte[]) decoded).intValue();
    }

    
        @DSModeled(DSC.SAFE)
    public static BigInteger toBigIntegerValue(Object decoded) {
        return new BigInteger((byte[]) decoded);
    }

    
        @DSModeled(DSC.SAFE)
    public static Object fromIntValue(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.628 -0400", hash_original_field = "0BA21710FA46975454505EF7ED4D2217", hash_generated_field = "7903D35656FA59C7967A1F03B51EB6F4")

    private static final ASN1Integer ASN1 = new ASN1Integer();
}

