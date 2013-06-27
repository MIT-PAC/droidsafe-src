package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.PublicKey;

public final class X509PublicKey implements PublicKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.250 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.250 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.251 -0400", hash_original_field = "A001B1C67F087A988E05F71CB2EAA379", hash_generated_field = "F8BF44934CF513C25EA736CCFDA9B231")

    private byte[] keyBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.251 -0400", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "D790DFA6420E40E56C1C8FB9BD83052A")
    public  X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        this.algorithm = algorithm;
        this.encoded = encoded;
        this.keyBytes = keyBytes;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.encoded = encoded;
        //this.keyBytes = keyBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.252 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "EE8966182484BCECD56595D029B30F41")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_2102488583 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2102488583 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_2102488583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2102488583;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.252 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "F6DCC1A6E2D9C8208C6A29D4DB3AA75F")
    public String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1762515370 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1762515370 = "X.509";
        varB4EAC82CA7396A68D541C85D26508E83_1762515370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762515370;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.252 -0400", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "4A9056C167B038363570929B85BA5711")
    public byte[] getEncoded() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1263042570 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1263042570;
        // ---------- Original Method ----------
        //return encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.261 -0400", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "20C6BA1275046447DFD50CBE6E93F9E8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1357617137 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
        varB4EAC82CA7396A68D541C85D26508E83_1357617137 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1357617137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1357617137;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder("algorithm = ");
        //buf.append(algorithm);
        //buf.append(", params unparsed, unparsed keybits = \n");
        //return buf.toString();
    }

    
}

