package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ECParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.896 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.897 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.897 -0400", hash_original_field = "DFCF28D0734569A6A693BC8194DE62BF", hash_generated_field = "316439DA3E4C6914572EC3C942E00A79")

    private ECPoint G;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.903 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.904 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger h;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.904 -0400", hash_original_method = "E581F0D1251777D8F8C2673628C02E33", hash_generated_method = "BC4BA806059D9BDAE6852176904A8600")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.916 -0400", hash_original_method = "3844E6DD38495376CE54503FB9102730", hash_generated_method = "A2E0F09C4976987DF3E63173F3024972")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.917 -0400", hash_original_method = "B4859A7864ACD85B3E9FEBE41FAB289F", hash_generated_method = "7998DF03A46481AEE4F92C1AE6A73F24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.917 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "AD26856FB4B3F14DFDFD7187F2A31A66")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_737600964 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_737600964 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_737600964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737600964;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.918 -0400", hash_original_method = "ED03A647C1E8B017F749575ECBD102C0", hash_generated_method = "C5A6241B020F4B7FD58CA9E8FF865D1F")
    public ECPoint getG() {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_418678154 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_418678154 = G;
        varB4EAC82CA7396A68D541C85D26508E83_418678154.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418678154;
        // ---------- Original Method ----------
        //return G;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.921 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "3C7C85BB6AB450E8C4107C2856B5BBA2")
    public BigInteger getN() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_239005897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_239005897 = n;
        varB4EAC82CA7396A68D541C85D26508E83_239005897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_239005897;
        // ---------- Original Method ----------
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.921 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "0CBA1DB292AEEEC765ADAECBA0EDB5B6")
    public BigInteger getH() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1450298671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1450298671 = h;
        varB4EAC82CA7396A68D541C85D26508E83_1450298671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1450298671;
        // ---------- Original Method ----------
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.922 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "2E137F7D4B5AA31E40679ED06DF38772")
    public byte[] getSeed() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2020460928 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2020460928;
        // ---------- Original Method ----------
        //return seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.922 -0400", hash_original_method = "4D0C476A07E0F700EE67C6B7126A56CA", hash_generated_method = "0BD3E1761A2F6024B8A84400AC77CABD")
    public boolean equals(Object o) {
        ECParameterSpec other;
        other = (ECParameterSpec)o;
        boolean varE9EF6AB4460DE872418DC640D18CC2C9_1581181491 = (this.getCurve().equals(other.getCurve()) && this.getG().equals(other.getG()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942536391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942536391;
        // ---------- Original Method ----------
        //if (!(o instanceof ECParameterSpec))
        //{
            //return false;
        //}
        //ECParameterSpec other = (ECParameterSpec)o;
        //return this.getCurve().equals(other.getCurve()) && this.getG().equals(other.getG());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.922 -0400", hash_original_method = "222EBFC3DE5F327343BF00A614895E1C", hash_generated_method = "E7A7E28C96D829BE8DA3C684609495DA")
    public int hashCode() {
        int var8841AFECDD0D0F55014D15C3EC1D9B36_1778684102 = (this.getCurve().hashCode() ^ this.getG().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138604977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138604977;
        // ---------- Original Method ----------
        //return this.getCurve().hashCode() ^ this.getG().hashCode();
    }

    
}

