package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class DHParameterSpec implements AlgorithmParameterSpec {
    private BigInteger p;
    private BigInteger g;
    private int l;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.994 -0400", hash_original_method = "F8E48B54378C41D41344A45EFE5DEAF0", hash_generated_method = "90FC841CAFBE1F387FFF094DB66881AB")
    @DSModeled(DSC.SAFE)
    public DHParameterSpec(BigInteger p, BigInteger g) {
        dsTaint.addTaint(g.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        this.l = 0;
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.994 -0400", hash_original_method = "ACD960FD5413B931010CFE492BF9890E", hash_generated_method = "099BCAC5A16866B060DBBA482EB84603")
    @DSModeled(DSC.SAFE)
    public DHParameterSpec(BigInteger p, BigInteger g, int l) {
        dsTaint.addTaint(g.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(l);
        // ---------- Original Method ----------
        //this.p = p;
        //this.g = g;
        //this.l = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.994 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "7AE5338A8F093B8953D2F1949A9508B1")
    @DSModeled(DSC.SAFE)
    public BigInteger getP() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.995 -0400", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "5AFBB55D2591367C9F73B825B3B0CCD8")
    @DSModeled(DSC.SAFE)
    public BigInteger getG() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.995 -0400", hash_original_method = "657EAD8DC5C96D72590F45704DE7ABCD", hash_generated_method = "71D7AB746D9E0DF98FB9FACCCCBF5746")
    @DSModeled(DSC.SAFE)
    public int getL() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return l;
    }

    
}

