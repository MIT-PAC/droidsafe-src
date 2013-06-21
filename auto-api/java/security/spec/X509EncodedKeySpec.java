package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.665 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "E920C555F3ABB3518C50C2972642AEAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        dsTaint.addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.665 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "B31494B1B81FEB17FF8D30E128D8A0D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        byte[] var0AFBA75A2C6754ACFF8759A1F1214E22_517326359 = (super.getEncoded());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.666 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "6FAFFCB386CBEBFAE10FB50AC207D725")
    @DSModeled(DSC.SAFE)
    public final String getFormat() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "X.509";
    }

    
}

