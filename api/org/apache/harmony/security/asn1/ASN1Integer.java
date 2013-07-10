package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;

public final class ASN1Integer extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.542 -0400", hash_original_method = "46ADEA8E713BD711C252666C512B58BA", hash_generated_method = "61455BA42D466162249D5D385FEFD5D0")
    public  ASN1Integer() {
        super(TAG_INTEGER);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Integer getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.543 -0400", hash_original_method = "60087C2826F4544419064E4DC181F66A", hash_generated_method = "3E1EC09ECBB2810786C93F9BFABA9FAD")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_136438957 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_897484854 = null; 
        in.readInteger();
        {
            varB4EAC82CA7396A68D541C85D26508E83_136438957 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_897484854 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2036922707; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2036922707 = varB4EAC82CA7396A68D541C85D26508E83_136438957;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2036922707 = varB4EAC82CA7396A68D541C85D26508E83_897484854;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2036922707.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2036922707;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.544 -0400", hash_original_method = "A63FF6180169FCDAA4D93BB2145B7594", hash_generated_method = "FD2E7093DD1157687EFD7A90024C754E")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1657977568 = null; 
        byte[] bytesEncoded = new byte[in.length];
        System.arraycopy(in.buffer, in.contentOffset, bytesEncoded, 0,
                in.length);
        varB4EAC82CA7396A68D541C85D26508E83_1657977568 = bytesEncoded;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1657977568.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1657977568;
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.544 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "BAA11C0A71C0484BDDB971998BB29CEF")
    public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.544 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.545 -0400", hash_original_field = "0BA21710FA46975454505EF7ED4D2217", hash_generated_field = "7903D35656FA59C7967A1F03B51EB6F4")

    private static final ASN1Integer ASN1 = new ASN1Integer();
}

