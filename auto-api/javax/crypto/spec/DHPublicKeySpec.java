package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DHPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.258 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.258 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.259 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.259 -0400", hash_original_method = "BEC503CA854BAF195D783D6731B76102", hash_generated_method = "A57F4AD9759F1DE905647BDD55752590")
    public  DHPublicKeySpec(BigInteger y, BigInteger p, BigInteger g) {
        this.y = y;
        this.p = p;
        this.g = g;
        // ---------- Original Method ----------
        //this.y = y;
        //this.p = p;
        //this.g = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.260 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "1A7215A064E158B1358767808804A1BC")
    public BigInteger getY() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1019785159 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1019785159 = y;
        varB4EAC82CA7396A68D541C85D26508E83_1019785159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1019785159;
        // ---------- Original Method ----------
        //return y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.263 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "56200666EEA4967A048A08DDC705E30D")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_940958619 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_940958619 = p;
        varB4EAC82CA7396A68D541C85D26508E83_940958619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_940958619;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.264 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "FF08CAA96399BF2BC2329AE725405376")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_641098241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_641098241 = g;
        varB4EAC82CA7396A68D541C85D26508E83_641098241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641098241;
        // ---------- Original Method ----------
        //return g;
    }

    
}

