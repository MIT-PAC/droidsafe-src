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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.920 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.920 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.920 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.934 -0400", hash_original_method = "BEC503CA854BAF195D783D6731B76102", hash_generated_method = "A57F4AD9759F1DE905647BDD55752590")
    public  DHPublicKeySpec(BigInteger y, BigInteger p, BigInteger g) {
        this.y = y;
        this.p = p;
        this.g = g;
        // ---------- Original Method ----------
        //this.y = y;
        //this.p = p;
        //this.g = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.934 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "DDBAF278E5FABEA76EBF701C2E6A87A4")
    public BigInteger getY() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1011334575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011334575 = y;
        varB4EAC82CA7396A68D541C85D26508E83_1011334575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011334575;
        // ---------- Original Method ----------
        //return y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.934 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "F2158F75542067694950C9F0072F81A0")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_126658483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_126658483 = p;
        varB4EAC82CA7396A68D541C85D26508E83_126658483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126658483;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.935 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "83C4B7342987A9D788EBF9529EE06F9A")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1890651740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1890651740 = g;
        varB4EAC82CA7396A68D541C85D26508E83_1890651740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890651740;
        // ---------- Original Method ----------
        //return g;
    }

    
}

