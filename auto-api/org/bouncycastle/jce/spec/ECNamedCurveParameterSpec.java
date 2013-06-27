package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECNamedCurveParameterSpec extends ECParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.946 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.947 -0400", hash_original_method = "26C644EB7C653DDD4CB6B37A75A99655", hash_generated_method = "6939707EECD27AD0B77D78E29AB30B19")
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
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.947 -0400", hash_original_method = "6202179398236C8F6061917C30684FB7", hash_generated_method = "F56C1AD046E3F8AF64A3489076973348")
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
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.948 -0400", hash_original_method = "8EFB3A2E9C5B967CAF71EC98D8241ACE", hash_generated_method = "31067BDC9D305DEEE157E4EC8C95FD03")
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
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.949 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "19BFE05780248176ED365389CDD3CE55")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1202170742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202170742 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1202170742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202170742;
        // ---------- Original Method ----------
        //return name;
    }

    
}

