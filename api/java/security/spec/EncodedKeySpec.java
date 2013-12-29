package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public abstract class EncodedKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.056 -0500", hash_original_field = "946CEA61F16F102AC83919F94FFB7B9D", hash_generated_field = "3144F97D80A45FCBB127B551D71851A1")

    private  byte[] encodedKey;

    /**
     * Creates a new {@code EncodedKeySpec} with the specified encoded key bytes.
     *
     * @param encodedKey
     *            the encoded key bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.057 -0500", hash_original_method = "AB5BB16CE68A0965872FC49BB9877C19", hash_generated_method = "C499631DD03306D7F40E7DE6314423B1")
    public EncodedKeySpec(byte[] encodedKey) {
        // Defensively copies parameter
        // to prevent subsequent modification
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
    }

    /**
     * Returns the encoded key bytes.
     *
     * @return the encoded key bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.058 -0500", hash_original_method = "F8B261F87BF90DD753274675BF9DA222", hash_generated_method = "37C9E1C39B1D282064DBB6F77791FC6D")
    public byte[] getEncoded() {
        // Defensively copies private array
        // to prevent subsequent modification
        byte[] ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        return ret;
    }

    /**
     * Returns the name of the encoding format of this encoded key
     * specification.
     *
     * @return the name of the encoding format of this encoded key
     *         specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.059 -0500", hash_original_method = "CA7EFC56395807F5B08C2CDFF0DEE77B", hash_generated_method = "090623DDECB8BCC454E2F65967F71FC5")
    public abstract String getFormat();

    
}

