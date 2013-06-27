package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class DSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.061 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3D78E4B6D398CF86CC9666CFD1AA5B41")

    private BigInteger x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.061 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.061 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.061 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.072 -0400", hash_original_method = "391A7E7DFDE60B2C21A2B29998A00F20", hash_generated_method = "A54F6C07E02005AE26980ACC88E3F268")
    public  DSAPrivateKeySpec(BigInteger x, BigInteger p,
            BigInteger q, BigInteger g) {
        this.x = x;
        this.p = p;
        this.q = q;
        this.g = g;
        // ---------- Original Method ----------
        //this.x = x;
        //this.p = p;
        //this.q = q;
        //this.g = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.073 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "A5AC154560932B4409D11F75E2FCE648")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_320348902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_320348902 = g;
        varB4EAC82CA7396A68D541C85D26508E83_320348902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_320348902;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.073 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "713FA94E8B4BE2CF2751EF2FEF84F3E2")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1319864845 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1319864845 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1319864845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319864845;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.074 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "DF3495DF935A7A653B147CC2391CBC8F")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1246943784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1246943784 = q;
        varB4EAC82CA7396A68D541C85D26508E83_1246943784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246943784;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.074 -0400", hash_original_method = "67A367EC1A42595A125F9EA99F2EC9F5", hash_generated_method = "BABEEED233BB70AA7EC4BF87B585AC48")
    public BigInteger getX() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_866210105 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_866210105 = x;
        varB4EAC82CA7396A68D541C85D26508E83_866210105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866210105;
        // ---------- Original Method ----------
        //return x;
    }

    
}

