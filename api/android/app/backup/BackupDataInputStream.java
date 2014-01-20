package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

public class BackupDataInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.233 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.235 -0500", hash_original_field = "BE50627D89367B94B26C95254370D367", hash_generated_field = "BE50627D89367B94B26C95254370D367")

    int dataSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.237 -0500", hash_original_field = "E3D8EC927026C22AB4F4A51B7D52DBD7", hash_generated_field = "E3D8EC927026C22AB4F4A51B7D52DBD7")

    BackupDataInput mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.239 -0500", hash_original_field = "741CFBB37C334A9DBBB5084AC407FBC5", hash_generated_field = "741CFBB37C334A9DBBB5084AC407FBC5")

    byte[] mOneByte;

    /** @hide */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.241 -0500", hash_original_method = "C2C10C1477F29698CE48A2404B00FC26", hash_generated_method = "C2C10C1477F29698CE48A2404B00FC26")
    
BackupDataInputStream(BackupDataInput data) {
        mData = data;
    }

    /**
     * Read one byte of entity data from the stream, returning it as
     * an integer value.  If more than {@link #size()} bytes of data
     * are read from the stream, the output of this method is undefined.
     *
     * @return The byte read, or undefined if the end of the stream has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.243 -0500", hash_original_method = "F4751627195ADC12549C9A18CF48A412", hash_generated_method = "26DF838EDF126DC5FE4F1559454DD1D0")
    
public int read() throws IOException {
        byte[] one = mOneByte;
        if (mOneByte == null) {
            one = mOneByte = new byte[1];
        }
        mData.readEntityData(one, 0, 1);
        return one[0];
    }

    /**
     * Read up to {@code size} bytes of data into a byte array, beginning at position
     * {@code offset} within the array.
     *
     * @param b Byte array into which the data will be read
     * @param offset The data will be stored in {@code b} beginning at this index
     *   within the array.
     * @param size The number of bytes to read in this operation.  If insufficient
     *   data exists within the entity to fulfill this request, only as much data
     *   will be read as is available.
     * @return The number of bytes of data read, or zero if all of the entity's
     *   data has already been read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.245 -0500", hash_original_method = "E5C8D10363AA6A5828998ABAFBD3DBB5", hash_generated_method = "601B02709E778923A0555435FD1DF499")
    
public int read(byte[] b, int offset, int size) throws IOException {
        return mData.readEntityData(b, offset, size);
    }

    /**
     * Read enough entity data into a byte array to fill the array.
     *
     * @param b Byte array to fill with data from the stream.  If the stream does not
     *   have sufficient data to fill the array, then the contents of the remainder of
     *   the array will be undefined.
     * @return The number of bytes of data read, or zero if all of the entity's
     *   data has already been read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.248 -0500", hash_original_method = "261A99F04C534DF9C91290D411F9A374", hash_generated_method = "434D5B216ED5B1485E9D7D433C43AFB5")
    
public int read(byte[] b) throws IOException {
        return mData.readEntityData(b, 0, b.length);
    }

    /**
     * Report the key string associated with this entity within the backup data set.
     *
     * @return The key string for this entity, equivalent to calling
     *   {@link BackupDataInput#getKey()} on the underlying {@link BackupDataInput}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.250 -0500", hash_original_method = "EC81A9ECDA808FF062BB2254D312B94E", hash_generated_method = "1F9E4BFB97B0FD054EDF7E1DE43DB6DC")
    
public String getKey() {
        return this.key;
    }

    /**
     * Report the total number of bytes of data available for the current entity.
     *
     * @return The number of data bytes available, equivalent to calling
     *   {@link BackupDataInput#getDataSize()} on the underlying {@link BackupDataInput}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.252 -0500", hash_original_method = "EB0F38C5E31652AF776348A02A47056B", hash_generated_method = "74C06BE7072E312CD9B8F51DA0C39606")
    
public int size() {
        return this.dataSize;
    }
    
}

