package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class DSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.066 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.066 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.066 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.066 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.067 -0400", hash_original_method = "59DD68ABED9CC2F6FAC8589709FFB9BA", hash_generated_method = "EB02F7CC5C63D0CDE99159462457284C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.067 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "47488EA6442D69290BF9135A75926269")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_227523290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_227523290 = g;
        varB4EAC82CA7396A68D541C85D26508E83_227523290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_227523290;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.068 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "0D8558D4114F90AE4140F32F43E085C6")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1408168729 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1408168729 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1408168729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1408168729;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.068 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "57B7A35E6A24D0FDD385FF531FB1B1DD")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1212788434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1212788434 = q;
        varB4EAC82CA7396A68D541C85D26508E83_1212788434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212788434;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.071 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "44D1900E532E2C703D31A0989F116A1E")
    public BigInteger getY() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_82436439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_82436439 = y;
        varB4EAC82CA7396A68D541C85D26508E83_82436439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_82436439;
        // ---------- Original Method ----------
        //return y;
    }

    
}

