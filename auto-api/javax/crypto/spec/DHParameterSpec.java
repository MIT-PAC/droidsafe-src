package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class DHParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.926 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.927 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.927 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "79426B8570FE3512AB32B66CEA5A4180")

    private int l;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.930 -0400", hash_original_method = "F8E48B54378C41D41344A45EFE5DEAF0", hash_generated_method = "F3E49A122D6436FD446BB87E32C19389")
    public  DHParameterSpec(BigInteger p, BigInteger g) {
        this.p = p;
        this.g = g;
        this.l = 0;
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.931 -0400", hash_original_method = "ACD960FD5413B931010CFE492BF9890E", hash_generated_method = "C966810A766680754342EBC5CE901E83")
    public  DHParameterSpec(BigInteger p, BigInteger g, int l) {
        this.p = p;
        this.g = g;
        this.l = l;
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.931 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "43FF4E6E3C414ADB542892512D4C0519")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1925145689 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1925145689 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1925145689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1925145689;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.931 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "3928C11DCA8E41CBAC5128E6FE7A0275")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1683376544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683376544 = g;
        varB4EAC82CA7396A68D541C85D26508E83_1683376544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683376544;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.932 -0400", hash_original_method = "657EAD8DC5C96D72590F45704DE7ABCD", hash_generated_method = "F5612C88E25C034973EAFDDC022A9B1F")
    public int getL() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502254327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502254327;
        // ---------- Original Method ----------
        //return l;
    }

    
}

