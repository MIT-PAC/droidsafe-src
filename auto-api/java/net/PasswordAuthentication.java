package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class PasswordAuthentication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.532 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.532 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.533 -0400", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "25328EA123D9D2C607C2E93AA009C49C")
    public  PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
        // ---------- Original Method ----------
        //this.userName = userName;
        //this.password = password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.534 -0400", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "ECC056505F28439BEA64DCB8FEC17014")
    public char[] getPassword() {
        char[] var69A284DF0CEA33951D475A52924F7393_1133245189 = (password.clone());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1482032214 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1482032214;
        // ---------- Original Method ----------
        //return password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.534 -0400", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "1416172B432D123F76F584DF01667CF7")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1562447303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1562447303 = userName;
        varB4EAC82CA7396A68D541C85D26508E83_1562447303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1562447303;
        // ---------- Original Method ----------
        //return userName;
    }

    
}

