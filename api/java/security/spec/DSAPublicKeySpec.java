package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class DSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.036 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.036 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.036 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.036 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.037 -0400", hash_original_method = "59DD68ABED9CC2F6FAC8589709FFB9BA", hash_generated_method = "EB02F7CC5C63D0CDE99159462457284C")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.037 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "4BB542D2B9D82DF66791296D54BCE3DA")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_388618775 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_388618775.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_388618775;
        // ---------- Original Method ----------
        //return g;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.038 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "4E8E39F02F1619546908DEC0D4C95DF1")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_870198076 =         p;
        var74E4690D9F2A026504928C017944E149_870198076.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_870198076;
        // ---------- Original Method ----------
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.038 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "FA0ECBC9A21A6F6742ECB9DEF9BE1A9F")
    public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_760392679 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_760392679.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_760392679;
        // ---------- Original Method ----------
        //return q;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.038 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "2DA589D96693ECB94BF69157469ACCB0")
    public BigInteger getY() {
BigInteger var01417B0442ECD521584E2B7EFB9FC218_1219445499 =         y;
        var01417B0442ECD521584E2B7EFB9FC218_1219445499.addTaint(taint);
        return var01417B0442ECD521584E2B7EFB9FC218_1219445499;
        // ---------- Original Method ----------
        //return y;
    }

    
}

