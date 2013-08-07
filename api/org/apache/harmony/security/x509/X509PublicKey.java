package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.PublicKey;






public final class X509PublicKey implements PublicKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.975 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.975 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.975 -0400", hash_original_field = "A001B1C67F087A988E05F71CB2EAA379", hash_generated_field = "F8BF44934CF513C25EA736CCFDA9B231")

    private byte[] keyBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.976 -0400", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "D790DFA6420E40E56C1C8FB9BD83052A")
    public  X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        this.algorithm = algorithm;
        this.encoded = encoded;
        this.keyBytes = keyBytes;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.encoded = encoded;
        //this.keyBytes = keyBytes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.977 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8612C6ACB4B90F7472DB4FB1BDFC3B2F")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_57337466 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_57337466.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_57337466;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.977 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "CF0829DF9D52B3B57EB03036561094EB")
    public String getFormat() {
String varF820115C876B7F160DE375988A3E1CA1_1306700469 =         "X.509";
        varF820115C876B7F160DE375988A3E1CA1_1306700469.addTaint(taint);
        return varF820115C876B7F160DE375988A3E1CA1_1306700469;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.977 -0400", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "698D53804EE2BDE91716388357EA534F")
    public byte[] getEncoded() {
        byte[] var4B719ACEE4A1D5E30577F59E80D06205_613105453 = (encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_327711589 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_327711589;
        // ---------- Original Method ----------
        //return encoded;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.977 -0400", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "246F56D4C624B63B775FF2C5F819B5B2")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
String var4FC680801218E6372BC708D6FA44AE60_768229637 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_768229637.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_768229637;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder("algorithm = ");
        //buf.append(algorithm);
        //buf.append(", params unparsed, unparsed keybits = \n");
        //return buf.toString();
    }

    
}

