package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class EncodedKeySpec implements KeySpec {
    private byte[] encodedKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.661 -0400", hash_original_method = "AB5BB16CE68A0965872FC49BB9877C19", hash_generated_method = "2E4FC2F67E151F375A8BFC7D4EFE28EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EncodedKeySpec(byte[] encodedKey) {
        dsTaint.addTaint(encodedKey[0]);
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
        // ---------- Original Method ----------
        //this.encodedKey = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0,
                //this.encodedKey, 0, this.encodedKey.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.662 -0400", hash_original_method = "F8B261F87BF90DD753274675BF9DA222", hash_generated_method = "337ED6A178D368B77771242F86CD4843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        byte[] ret;
        ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] ret = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        //return ret;
    }

    
    public abstract String getFormat();

    
}

