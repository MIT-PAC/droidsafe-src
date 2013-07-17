package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECNamedCurveParameterSpec extends ECParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.333 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.333 -0400", hash_original_method = "26C644EB7C653DDD4CB6B37A75A99655", hash_generated_method = "5C5793AF83B3DF289B9DE0123D7102DD")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n) {
        super(curve, G, n);
        addTaint(n.getTaint());
        addTaint(G.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.334 -0400", hash_original_method = "6202179398236C8F6061917C30684FB7", hash_generated_method = "87CE00B27615BA64337CF8091F2FF52E")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h) {
        super(curve, G, n, h);
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(G.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.335 -0400", hash_original_method = "8EFB3A2E9C5B967CAF71EC98D8241ACE", hash_generated_method = "6469145694E4FE1196ECEB90A2B71BAF")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed) {
        super(curve, G, n, h, seed);
        addTaint(seed[0]);
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(G.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.335 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "D631FE91F974C586326C6DE6331C64C7")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1857564182 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1857564182.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1857564182;
        // ---------- Original Method ----------
        //return name;
    }

    
}

