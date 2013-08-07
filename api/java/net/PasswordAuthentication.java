package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class PasswordAuthentication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.954 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.954 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.956 -0400", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "25328EA123D9D2C607C2E93AA009C49C")
    public  PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
        // ---------- Original Method ----------
        //this.userName = userName;
        //this.password = password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.957 -0400", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "6D5548BA0F2ED4F0AC0DE5E4D0C2AE2B")
    public char[] getPassword() {
        char[] var4344A63B108F14EA871CFA63D8482D53_1055639413 = (password.clone());
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1417517042 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1417517042;
        // ---------- Original Method ----------
        //return password.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.958 -0400", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "BD67857E08EBFD145AE9488033294680")
    public String getUserName() {
String varAE6871DB21169C2532F1A9E69AA090CE_1748964133 =         userName;
        varAE6871DB21169C2532F1A9E69AA090CE_1748964133.addTaint(taint);
        return varAE6871DB21169C2532F1A9E69AA090CE_1748964133;
        // ---------- Original Method ----------
        //return userName;
    }

    
}

