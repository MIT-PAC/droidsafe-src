package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.PublicKey;

public final class X509PublicKey implements PublicKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.584 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.584 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.584 -0400", hash_original_field = "A001B1C67F087A988E05F71CB2EAA379", hash_generated_field = "F8BF44934CF513C25EA736CCFDA9B231")

    private byte[] keyBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.585 -0400", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "D790DFA6420E40E56C1C8FB9BD83052A")
    public  X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        this.algorithm = algorithm;
        this.encoded = encoded;
        this.keyBytes = keyBytes;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.585 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "B3E551C33F8962C41C0E758926929516")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1546525319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1546525319 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1546525319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1546525319;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.585 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "A1216957777543E4F71423276566D585")
    public String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1292836088 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1292836088 = "X.509";
        varB4EAC82CA7396A68D541C85D26508E83_1292836088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1292836088;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.586 -0400", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "36566AB59C5F9E78A7CAC603BB1A6910")
    public byte[] getEncoded() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_275848615 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_275848615;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.586 -0400", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "98DB43E51F44D3601C9A04A807A2B0C7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1711796479 = null; 
        StringBuilder buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
        varB4EAC82CA7396A68D541C85D26508E83_1711796479 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1711796479.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1711796479;
        
        
        
        
        
    }

    
}

