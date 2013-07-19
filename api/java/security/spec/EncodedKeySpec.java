package java.security.spec;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class EncodedKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.042 -0400", hash_original_field = "4567E7356B633148D4D0693AC01FDEEE", hash_generated_field = "3144F97D80A45FCBB127B551D71851A1")

    private byte[] encodedKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.043 -0400", hash_original_method = "AB5BB16CE68A0965872FC49BB9877C19", hash_generated_method = "31248C080AE7561C6892218AC4D58C46")
    public  EncodedKeySpec(byte[] encodedKey) {
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
        // ---------- Original Method ----------
        //this.encodedKey = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0,
                //this.encodedKey, 0, this.encodedKey.length);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.043 -0400", hash_original_method = "F8B261F87BF90DD753274675BF9DA222", hash_generated_method = "387B4A6D258F448CA9E0F55DE2D8E21B")
    public byte[] getEncoded() {
        byte[] ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1372564037 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_228249082 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_228249082;
        // ---------- Original Method ----------
        //byte[] ret = new byte[encodedKey.length];
        //System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        //return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String getFormat();

    
}

