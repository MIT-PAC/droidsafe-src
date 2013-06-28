package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class PasswordAuthentication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.540 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.540 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.541 -0400", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "25328EA123D9D2C607C2E93AA009C49C")
    public  PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
        // ---------- Original Method ----------
        //this.userName = userName;
        //this.password = password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.541 -0400", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "A593C57DA89350E3296B25C0E968BD1D")
    public char[] getPassword() {
        char[] var69A284DF0CEA33951D475A52924F7393_846912321 = (password.clone());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_604525233 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_604525233;
        // ---------- Original Method ----------
        //return password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.542 -0400", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "FD1531F00A59CE3C883AC77D91FC5C09")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2091602263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2091602263 = userName;
        varB4EAC82CA7396A68D541C85D26508E83_2091602263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091602263;
        // ---------- Original Method ----------
        //return userName;
    }

    
}

