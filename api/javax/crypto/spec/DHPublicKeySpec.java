package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.spec.KeySpec;






public class DHPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.345 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.345 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.345 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.346 -0400", hash_original_method = "BEC503CA854BAF195D783D6731B76102", hash_generated_method = "A57F4AD9759F1DE905647BDD55752590")
    public  DHPublicKeySpec(BigInteger y, BigInteger p, BigInteger g) {
        this.y = y;
        this.p = p;
        this.g = g;
        // ---------- Original Method ----------
        //this.y = y;
        //this.p = p;
        //this.g = g;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.347 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "1F232AC0A18694EB111AE09992771FAC")
    public BigInteger getY() {
BigInteger var01417B0442ECD521584E2B7EFB9FC218_285431772 =         y;
        var01417B0442ECD521584E2B7EFB9FC218_285431772.addTaint(taint);
        return var01417B0442ECD521584E2B7EFB9FC218_285431772;
        // ---------- Original Method ----------
        //return y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.347 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "9CEFE27F449B2D10D4AAAE16783713A0")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_318118322 =         p;
        var74E4690D9F2A026504928C017944E149_318118322.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_318118322;
        // ---------- Original Method ----------
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.347 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "1FF59A310D08D27BE2AB94B6212613C6")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_823166468 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_823166468.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_823166468;
        // ---------- Original Method ----------
        //return g;
    }

    
}

