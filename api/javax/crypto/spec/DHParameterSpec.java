package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class DHParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.251 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.251 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.251 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "79426B8570FE3512AB32B66CEA5A4180")

    private int l;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.252 -0400", hash_original_method = "F8E48B54378C41D41344A45EFE5DEAF0", hash_generated_method = "F3E49A122D6436FD446BB87E32C19389")
    public  DHParameterSpec(BigInteger p, BigInteger g) {
        this.p = p;
        this.g = g;
        this.l = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.252 -0400", hash_original_method = "ACD960FD5413B931010CFE492BF9890E", hash_generated_method = "C966810A766680754342EBC5CE901E83")
    public  DHParameterSpec(BigInteger p, BigInteger g, int l) {
        this.p = p;
        this.g = g;
        this.l = l;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.253 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "A508E4234DF2047BB4F4BA12E95C3D9B")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2136568369 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2136568369 = p;
        varB4EAC82CA7396A68D541C85D26508E83_2136568369.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2136568369;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.254 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "CC039EC506F474DD1DD0F441B75E9F05")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_245611085 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_245611085 = g;
        varB4EAC82CA7396A68D541C85D26508E83_245611085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_245611085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.254 -0400", hash_original_method = "657EAD8DC5C96D72590F45704DE7ABCD", hash_generated_method = "3CE640207B44512EEF633AC759ECFEEA")
    public int getL() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763893784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763893784;
        
        
    }

    
}

