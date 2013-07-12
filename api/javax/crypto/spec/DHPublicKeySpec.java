package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DHPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.388 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.388 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.388 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.389 -0400", hash_original_method = "BEC503CA854BAF195D783D6731B76102", hash_generated_method = "A57F4AD9759F1DE905647BDD55752590")
    public  DHPublicKeySpec(BigInteger y, BigInteger p, BigInteger g) {
        this.y = y;
        this.p = p;
        this.g = g;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.390 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "C27F0224B5EAE4F57B4CD99711D1059D")
    public BigInteger getY() {
BigInteger var01417B0442ECD521584E2B7EFB9FC218_7719686 =         y;
        var01417B0442ECD521584E2B7EFB9FC218_7719686.addTaint(taint);
        return var01417B0442ECD521584E2B7EFB9FC218_7719686;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.390 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "30D713FBD04A1CF215F63BDDEE2C3889")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_673521462 =         p;
        var74E4690D9F2A026504928C017944E149_673521462.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_673521462;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.391 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "28649EEF51A3FA6A03462BB87A122E1A")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_1175018288 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_1175018288.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_1175018288;
        
        
    }

    
}

