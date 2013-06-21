package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DHPublicKeySpec implements KeySpec {
    private BigInteger y;
    private BigInteger p;
    private BigInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.996 -0400", hash_original_method = "BEC503CA854BAF195D783D6731B76102", hash_generated_method = "573CBEF7555BA3D5417E52679B6D54DA")
    @DSModeled(DSC.SAFE)
    public DHPublicKeySpec(BigInteger y, BigInteger p, BigInteger g) {
        dsTaint.addTaint(g.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(y.dsTaint);
        // ---------- Original Method ----------
        //this.y = y;
        //this.p = p;
        //this.g = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.996 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "BAE4913E3781C299030E7760B44EB972")
    @DSModeled(DSC.SAFE)
    public BigInteger getY() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.996 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "7AE5338A8F093B8953D2F1949A9508B1")
    @DSModeled(DSC.SAFE)
    public BigInteger getP() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.996 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "5AFBB55D2591367C9F73B825B3B0CCD8")
    @DSModeled(DSC.SAFE)
    public BigInteger getG() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return g;
    }

    
}

