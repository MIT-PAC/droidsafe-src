package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class CRC32 implements Checksum {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.159 -0500", hash_original_field = "5E188210823E517BAA91872EABCAF7CD", hash_generated_field = "103DD39C404FCCE4417B434D3EE0291E")

    private long crc = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.161 -0500", hash_original_field = "2CA876BB74D9B634ED48B07BACA76027", hash_generated_field = "2CA876BB74D9B634ED48B07BACA76027")

    long tbytes = 0L;
    
    @DSComment("no info moving")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.485 -0400", hash_original_method = "D55E28551E901525721E2A005775E885", hash_generated_method = "D55E28551E901525721E2A005775E885")
    public CRC32 ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the CRC32 checksum for all input received.
     *
     * @return The checksum for this instance.
     */
    @DSComment("no info moving")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.163 -0500", hash_original_method = "854FE5E27AD17353F420BE5FB492E27A", hash_generated_method = "B19B471301649942B63964C318AED819")
    
public long getValue() {
        return crc;
    }

    /**
     * Resets the CRC32 checksum to it initial state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.166 -0500", hash_original_method = "3C94069B7580B83ACAD9A7049BA1E3DA", hash_generated_method = "14ACC9FC067849549AFBF7F4DBB09450")
    
public void reset() {
        tbytes = crc = 0;

    }

    /**
     * Updates this checksum with the byte value provided as integer.
     *
     * @param val
     *            represents the byte to update the checksum.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.168 -0500", hash_original_method = "CC03AC9F84902D02E7C98FF0D9B3A071", hash_generated_method = "1BB18586428AA9D56B3090422507B482")
    
public void update(int val) {
        crc = updateByteImpl((byte) val, crc);
    }

    /**
     * Updates this checksum with the bytes contained in buffer {@code buf}.
     *
     * @param buf
     *            the buffer holding the data to update the checksum with.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.171 -0500", hash_original_method = "CE6B29801A6FECCB312673EE525F73B5", hash_generated_method = "C7A3A99D53983972F56F1121073E3E00")
    
public void update(byte[] buf) {
        update(buf, 0, buf.length);
    }

    /**
     * Update this {@code CRC32} checksum with the contents of {@code buf},
     * starting from {@code offset} and reading {@code byteCount} bytes of data.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.173 -0500", hash_original_method = "FA32CF22527C3BE95E419FDEDA807F82", hash_generated_method = "67B151244B370C307496F0872FD40CDC")
    
public void update(byte[] buf, int offset, int byteCount) {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        tbytes += byteCount;
        crc = updateImpl(buf, offset, byteCount, crc);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.177 -0500", hash_original_method = "680551833B0F700FD9FEA4D72A9561BF", hash_generated_method = "15F291A5104183040493E4679B402CE7")
    
    private long updateImpl(byte[] buf, int offset, int byteCount, long crc1){
    	//Formerly a native method
    	addTaint(buf[0]);
    	addTaint(offset);
    	addTaint(byteCount);
    	addTaint(crc1);
    	return getTaintLong();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.181 -0500", hash_original_method = "90348FBF3DF8B04612B506AE017DBA82", hash_generated_method = "B0C80CE3385CE04CE8B102059C4983AE")
    
    private long updateByteImpl(byte val, long crc1){
    	//Formerly a native method
    	addTaint(val);
    	addTaint(crc1);
    	return getTaintLong();
    }
    
}

