package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.PublicKey;

public final class X509PublicKey implements PublicKey {
    private String algorithm;
    private byte[] encoded;
    private byte[] keyBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.051 -0400", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "15BA85FC54EC2FBF034E690ECB24B495")
    @DSModeled(DSC.SAFE)
    public X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        dsTaint.addTaint(encoded[0]);
        dsTaint.addTaint(keyBytes[0]);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.encoded = encoded;
        //this.keyBytes = keyBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.051 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AB6B64DEEAE2006CFA3127C5F18A75FB")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.051 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "C094408CB82753687A18D46EB8EFAB67")
    @DSModeled(DSC.SAFE)
    public String getFormat() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "X.509";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.052 -0400", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "C47013A54D8186EE44867A9481FD7AD3")
    @DSModeled(DSC.SAFE)
    public byte[] getEncoded() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.052 -0400", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "01BF929729F2DF91E76B1EF28C459851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
        String var0C174602EFE4BFBCB80A7056CFA680FB_133600437 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder("algorithm = ");
        //buf.append(algorithm);
        //buf.append(", params unparsed, unparsed keybits = \n");
        //return buf.toString();
    }

    
}

