package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class DSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.026 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3D78E4B6D398CF86CC9666CFD1AA5B41")

    private BigInteger x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.026 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.026 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.026 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.027 -0400", hash_original_method = "391A7E7DFDE60B2C21A2B29998A00F20", hash_generated_method = "A54F6C07E02005AE26980ACC88E3F268")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.028 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "757FBD916BCF50DAE693245367B7895E")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_1790650949 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_1790650949.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_1790650949;
        // ---------- Original Method ----------
        //return g;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.028 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "9D4CE826789424DF5D83965E5883F0EA")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_1200327178 =         p;
        var74E4690D9F2A026504928C017944E149_1200327178.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1200327178;
        // ---------- Original Method ----------
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.028 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "0B758B8A4744E6580FE91DCCCF67A53E")
    public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_206083080 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_206083080.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_206083080;
        // ---------- Original Method ----------
        //return q;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.029 -0400", hash_original_method = "67A367EC1A42595A125F9EA99F2EC9F5", hash_generated_method = "C089E165D945EFD176DFFDCF454CF795")
    public BigInteger getX() {
BigInteger varEA5659DA512DECF23E6D37EE8060D074_373979852 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_373979852.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_373979852;
        // ---------- Original Method ----------
        //return x;
    }

    
}

