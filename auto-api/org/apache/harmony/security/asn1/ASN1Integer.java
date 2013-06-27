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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.267 -0400", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "61455BA42D466162249D5D385FEFD5D0")
    public  ASN1Integer() {
        super(TAG_INTEGER);
        // ---------- Original Method ----------
    }

    
        public static ASN1Integer getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.271 -0400", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "0C827F5D561F7A371EF42F71BD5AEC25")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_642896612 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_901972717 = null; //Variable for return #2
        in.readInteger();
        {
            varB4EAC82CA7396A68D541C85D26508E83_642896612 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_901972717 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1971587256; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1971587256 = varB4EAC82CA7396A68D541C85D26508E83_642896612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1971587256 = varB4EAC82CA7396A68D541C85D26508E83_901972717;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1971587256.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1971587256;
        // ---------- Original Method ----------
        //in.readInteger();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.292 -0400", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "002BBD712464455C08D7E82999C57E5D")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2081366967 = null; //Variable for return #1
        byte[] bytesEncoded;
        bytesEncoded = new byte[in.length];
        System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                in.length);
        varB4EAC82CA7396A68D541C85D26508E83_2081366967 = bytesEncoded;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2081366967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081366967;
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.length];
        //System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                //in.length);
        //return bytesEncoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.292 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "BAA11C0A71C0484BDDB971998BB29CEF")
    public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.293 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.293 -0400", hash_original_field = "0BA21710FA46975454505EF7ED4D2217", hash_generated_field = "93225437B131DB482DB9287E6D8210D1")

    private static ASN1Integer ASN1 = new ASN1Integer();
}

