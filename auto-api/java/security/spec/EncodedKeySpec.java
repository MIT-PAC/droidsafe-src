package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class EncodedKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.079 -0400", hash_original_field = "4567E7356B633148D4D0693AC01FDEEE", hash_generated_field = "3144F97D80A45FCBB127B551D71851A1")

    private byte[] encodedKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.080 -0400", hash_original_method = "AB5BB16CE68A0965872FC49BB9877C19", hash_generated_method = "31248C080AE7561C6892218AC4D58C46")
    public  EncodedKeySpec(byte[] encodedKey) {
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
        // ---------- Original Method ----------
        //this.encodedKey = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0,
                //this.encodedKey, 0, this.encodedKey.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.080 -0400", hash_original_method = "F8B261F87BF90DD753274675BF9DA222", hash_generated_method = "4FB4AA41D8B335B4F4AC88027836A131")
    public byte[] getEncoded() {
        byte[] ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_79874373 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_79874373;
        // ---------- Original Method ----------
        //byte[] ret = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        //return ret;
    }

    
    public abstract String getFormat();

    
}

