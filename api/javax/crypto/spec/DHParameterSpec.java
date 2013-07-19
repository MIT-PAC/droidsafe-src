package javax.crypto.spec;

// Droidsafe Imports
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DHParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.336 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.336 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.337 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "79426B8570FE3512AB32B66CEA5A4180")

    private int l;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.338 -0400", hash_original_method = "F8E48B54378C41D41344A45EFE5DEAF0", hash_generated_method = "F3E49A122D6436FD446BB87E32C19389")
    public  DHParameterSpec(BigInteger p, BigInteger g) {
        this.p = p;
        this.g = g;
        this.l = 0;
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.339 -0400", hash_original_method = "ACD960FD5413B931010CFE492BF9890E", hash_generated_method = "C966810A766680754342EBC5CE901E83")
    public  DHParameterSpec(BigInteger p, BigInteger g, int l) {
        this.p = p;
        this.g = g;
        this.l = l;
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.339 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "0F8C85AC780952E731E9D07319C40220")
    public BigInteger getP() {
BigInteger var74E4690D9F2A026504928C017944E149_108226284 =         p;
        var74E4690D9F2A026504928C017944E149_108226284.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_108226284;
        // ---------- Original Method ----------
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.339 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "D824F855661916A85D70DD4256D7C341")
    public BigInteger getG() {
BigInteger var96B5EDC7D356FCBAF3C926D8A70305DA_136690006 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_136690006.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_136690006;
        // ---------- Original Method ----------
        //return g;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.340 -0400", hash_original_method = "657EAD8DC5C96D72590F45704DE7ABCD", hash_generated_method = "809B1FCE98F7E1591E9C679F30E86127")
    public int getL() {
        int var2DB95E8E1A9267B7A1188556B2013B33_12833300 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088208411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088208411;
        // ---------- Original Method ----------
        //return l;
    }

    
}

