package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class PasswordAuthentication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.948 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.948 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.949 -0400", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "25328EA123D9D2C607C2E93AA009C49C")
    public  PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
        // ---------- Original Method ----------
        //this.userName = userName;
        //this.password = password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.949 -0400", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "3DC3F178785E9583E9A7ABF234230F1C")
    public char[] getPassword() {
        char[] var4344A63B108F14EA871CFA63D8482D53_1719425536 = (password.clone());
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1978159692 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1978159692;
        // ---------- Original Method ----------
        //return password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.950 -0400", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "814072814DB01392377C25C13C9BF0D4")
    public String getUserName() {
String varAE6871DB21169C2532F1A9E69AA090CE_534158763 =         userName;
        varAE6871DB21169C2532F1A9E69AA090CE_534158763.addTaint(taint);
        return varAE6871DB21169C2532F1A9E69AA090CE_534158763;
        // ---------- Original Method ----------
        //return userName;
    }

    
}

