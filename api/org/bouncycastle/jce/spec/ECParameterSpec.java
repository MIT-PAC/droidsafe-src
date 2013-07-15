package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ECParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.728 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.728 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.728 -0400", hash_original_field = "DFCF28D0734569A6A693BC8194DE62BF", hash_generated_field = "316439DA3E4C6914572EC3C942E00A79")

    private ECPoint G;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.728 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.728 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger h;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.729 -0400", hash_original_method = "E581F0D1251777D8F8C2673628C02E33", hash_generated_method = "BC4BA806059D9BDAE6852176904A8600")
    public  ECParameterSpec(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = BigInteger.valueOf(1);
        this.seed = null;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = BigInteger.valueOf(1);
        //this.seed = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.730 -0400", hash_original_method = "3844E6DD38495376CE54503FB9102730", hash_generated_method = "A2E0F09C4976987DF3E63173F3024972")
    public  ECParameterSpec(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = null;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = h;
        //this.seed = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.738 -0400", hash_original_method = "B4859A7864ACD85B3E9FEBE41FAB289F", hash_generated_method = "7998DF03A46481AEE4F92C1AE6A73F24")
    public  ECParameterSpec(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = seed;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = h;
        //this.seed = seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.738 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "D8215E8DEA4B423F219022BB7D699A68")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_1104337875 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_1104337875.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_1104337875;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.738 -0400", hash_original_method = "ED03A647C1E8B017F749575ECBD102C0", hash_generated_method = "7DEB162533869351FFEE090324D97BA7")
    public ECPoint getG() {
ECPoint varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_2103783237 =         G;
        varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_2103783237.addTaint(taint);
        return varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_2103783237;
        // ---------- Original Method ----------
        //return G;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.738 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "0BDCFC908D7FE86DBBB198CCE1CFA35B")
    public BigInteger getN() {
BigInteger var041154653C812B0D1663EC287BE4C757_2113974630 =         n;
        var041154653C812B0D1663EC287BE4C757_2113974630.addTaint(taint);
        return var041154653C812B0D1663EC287BE4C757_2113974630;
        // ---------- Original Method ----------
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.739 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "17E9D6F805660D1108D527F255DFEE17")
    public BigInteger getH() {
BigInteger var81CECAAA363C2B26C476DE4A79F58961_2070135074 =         h;
        var81CECAAA363C2B26C476DE4A79F58961_2070135074.addTaint(taint);
        return var81CECAAA363C2B26C476DE4A79F58961_2070135074;
        // ---------- Original Method ----------
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.739 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "C3695667EF26C095EE6D0972934D489C")
    public byte[] getSeed() {
        byte[] varFE4C0F30AA359C41D9F9A5F69C8C4192_896802986 = (seed);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_546623444 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_546623444;
        // ---------- Original Method ----------
        //return seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.739 -0400", hash_original_method = "4D0C476A07E0F700EE67C6B7126A56CA", hash_generated_method = "20FB74201805DB031F8885008C640278")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof ECParameterSpec))        
        {
            boolean var68934A3E9455FA72420237EB05902327_477021956 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_507680760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_507680760;
        } //End block
        ECParameterSpec other = (ECParameterSpec)o;
        boolean varD92ABEA2995180998D0ECD4AB844E8AC_762858143 = (this.getCurve().equals(other.getCurve()) && this.getG().equals(other.getG()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761844698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_761844698;
        // ---------- Original Method ----------
        //if (!(o instanceof ECParameterSpec))
        //{
            //return false;
        //}
        //ECParameterSpec other = (ECParameterSpec)o;
        //return this.getCurve().equals(other.getCurve()) && this.getG().equals(other.getG());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.739 -0400", hash_original_method = "222EBFC3DE5F327343BF00A614895E1C", hash_generated_method = "43BB8CC28B95C79E5CC7AE26BD6BDA93")
    public int hashCode() {
        int varD6D19EF04FF7562D9882478C7AD7E40B_352140523 = (this.getCurve().hashCode() ^ this.getG().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046906488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046906488;
        // ---------- Original Method ----------
        //return this.getCurve().hashCode() ^ this.getG().hashCode();
    }

    
}

