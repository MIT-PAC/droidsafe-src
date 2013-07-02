package org.bouncycastle.jce.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECNamedCurveParameterSpec extends ECParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.271 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.271 -0400", hash_original_method = "26C644EB7C653DDD4CB6B37A75A99655", hash_generated_method = "6939707EECD27AD0B77D78E29AB30B19")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n) {
        super(curve, G, n);
        this.name = name;
        addTaint(curve.getTaint());
        addTaint(G.getTaint());
        addTaint(n.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.272 -0400", hash_original_method = "6202179398236C8F6061917C30684FB7", hash_generated_method = "F56C1AD046E3F8AF64A3489076973348")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h) {
        super(curve, G, n, h);
        this.name = name;
        addTaint(curve.getTaint());
        addTaint(G.getTaint());
        addTaint(n.getTaint());
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.272 -0400", hash_original_method = "8EFB3A2E9C5B967CAF71EC98D8241ACE", hash_generated_method = "31067BDC9D305DEEE157E4EC8C95FD03")
    public  ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed) {
        super(curve, G, n, h, seed);
        this.name = name;
        addTaint(curve.getTaint());
        addTaint(G.getTaint());
        addTaint(n.getTaint());
        addTaint(h.getTaint());
        addTaint(seed[0]);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.272 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "994C1C87BCEB6FCBF7EEDEB802AE4640")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_756216905 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_756216905 = name;
        varB4EAC82CA7396A68D541C85D26508E83_756216905.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_756216905;
        
        
    }

    
}

