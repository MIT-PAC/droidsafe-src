package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class DSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.072 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.073 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.073 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.073 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.073 -0400", hash_original_method = "59DD68ABED9CC2F6FAC8589709FFB9BA", hash_generated_method = "EB02F7CC5C63D0CDE99159462457284C")
    public  DSAPublicKeySpec(BigInteger y, BigInteger p,
            BigInteger q, BigInteger g) {
        this.y = y;
        this.p = p;
        this.q = q;
        this.g = g;
        // ---------- Original Method ----------
        //this.y = y;
        //this.p = p;
        //this.q = q;
        //this.g = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.074 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "1AD6597A973CFDE4E50B293625ECE029")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1435372194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1435372194 = g;
        varB4EAC82CA7396A68D541C85D26508E83_1435372194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1435372194;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.074 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "70216F7EAF18370256B8AE7EC78DEB6A")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_293208619 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_293208619 = p;
        varB4EAC82CA7396A68D541C85D26508E83_293208619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293208619;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.074 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "B93718184F1D0250B609D813F773525B")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2037078497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2037078497 = q;
        varB4EAC82CA7396A68D541C85D26508E83_2037078497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2037078497;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.075 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "8EB2697EDCE6809C71327E8F86D3D582")
    public BigInteger getY() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1561913186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561913186 = y;
        varB4EAC82CA7396A68D541C85D26508E83_1561913186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561913186;
        // ---------- Original Method ----------
        //return y;
    }

    
}

