package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class DSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.612 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.612 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.612 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.612 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.613 -0400", hash_original_method = "59DD68ABED9CC2F6FAC8589709FFB9BA", hash_generated_method = "EB02F7CC5C63D0CDE99159462457284C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.617 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "B09643795CB6A9F9A7E8DDD13A9F8287")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_792953744 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_792953744 = g;
        varB4EAC82CA7396A68D541C85D26508E83_792953744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_792953744;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.618 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "671F221C80E69A52AD619B45002FFF2C")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_957273502 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_957273502 = p;
        varB4EAC82CA7396A68D541C85D26508E83_957273502.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_957273502;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.628 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "AA0199C31641C390ECD9469213DCA5A3")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1793268049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1793268049 = q;
        varB4EAC82CA7396A68D541C85D26508E83_1793268049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793268049;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.633 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "DECBE3C3A1A806C16D3C5F3947814F89")
    public BigInteger getY() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_982575958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_982575958 = y;
        varB4EAC82CA7396A68D541C85D26508E83_982575958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_982575958;
        // ---------- Original Method ----------
        //return y;
    }

    
}

