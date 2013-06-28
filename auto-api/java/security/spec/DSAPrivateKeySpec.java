package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class DSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.061 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3D78E4B6D398CF86CC9666CFD1AA5B41")

    private BigInteger x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.061 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.061 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.061 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.061 -0400", hash_original_method = "391A7E7DFDE60B2C21A2B29998A00F20", hash_generated_method = "A54F6C07E02005AE26980ACC88E3F268")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.062 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "10EE4DE38584D9F0F8E018188C72B594")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_776662695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_776662695 = g;
        varB4EAC82CA7396A68D541C85D26508E83_776662695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_776662695;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.063 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "411C703A6A3A0FAAC0D385D09CEE95D0")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_799608609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_799608609 = p;
        varB4EAC82CA7396A68D541C85D26508E83_799608609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_799608609;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.063 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "668A025B27E7D5F3043D908F5A12A7B5")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1452211992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1452211992 = q;
        varB4EAC82CA7396A68D541C85D26508E83_1452211992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452211992;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.064 -0400", hash_original_method = "67A367EC1A42595A125F9EA99F2EC9F5", hash_generated_method = "527B51A32EAC33AF2D54BA5DD55A695F")
    public BigInteger getX() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1422191081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1422191081 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1422191081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422191081;
        // ---------- Original Method ----------
        //return x;
    }

    
}

