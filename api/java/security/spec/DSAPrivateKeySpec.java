package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class DSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.932 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3D78E4B6D398CF86CC9666CFD1AA5B41")

    private BigInteger x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.932 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.932 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.932 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.933 -0400", hash_original_method = "391A7E7DFDE60B2C21A2B29998A00F20", hash_generated_method = "A54F6C07E02005AE26980ACC88E3F268")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.933 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "8573E56BEEE5F595FD31E45B70840ED0")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_1919180870 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_1919180870.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_1919180870;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.933 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "00D2E4FA87868E6830EFE684DB125943")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_1820549421 =         p;
        var74E4690D9F2A026504928C017944E149_1820549421.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1820549421;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.934 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "F2EE3FDF0561B77533E549D72CC565F0")
    public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_1575375371 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_1575375371.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_1575375371;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.934 -0400", hash_original_method = "67A367EC1A42595A125F9EA99F2EC9F5", hash_generated_method = "F9AF32D2B32AD2625AF65F795A5CB8A9")
    public BigInteger getX() {
BigInteger varEA5659DA512DECF23E6D37EE8060D074_1053038612 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1053038612.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1053038612;
        // ---------- Original Method ----------
        //return x;
    }

    
}

