package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.PublicKey;

public final class X509PublicKey implements PublicKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.490 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.490 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.490 -0400", hash_original_field = "A001B1C67F087A988E05F71CB2EAA379", hash_generated_field = "F8BF44934CF513C25EA736CCFDA9B231")

    private byte[] keyBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.491 -0400", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "D790DFA6420E40E56C1C8FB9BD83052A")
    public  X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        this.algorithm = algorithm;
        this.encoded = encoded;
        this.keyBytes = keyBytes;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.491 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "4700BA1D967A849AC430A6949A96BE0E")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_622114149 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_622114149.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_622114149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.491 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "4263F17F835BCF423CBB6A8EDA1AA89A")
    public String getFormat() {
String varF820115C876B7F160DE375988A3E1CA1_836851858 =         "X.509";
        varF820115C876B7F160DE375988A3E1CA1_836851858.addTaint(taint);
        return varF820115C876B7F160DE375988A3E1CA1_836851858;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.491 -0400", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "74A2538AE93B0DE45A3D41048D870808")
    public byte[] getEncoded() {
        byte[] var4B719ACEE4A1D5E30577F59E80D06205_1158298820 = (encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1706146712 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1706146712;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.492 -0400", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "9E9BF0C6115A46E0936FE11D72A20D8E")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
String var4FC680801218E6372BC708D6FA44AE60_1746723920 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1746723920.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1746723920;
        
        
        
        
        
    }

    
}

