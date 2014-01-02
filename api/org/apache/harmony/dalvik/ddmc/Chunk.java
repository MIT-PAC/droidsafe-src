package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;




public class Chunk {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.181 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.183 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "F02DD38BDDF66ED8369494A65A3A6765")

    public byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "29401E0923088C769B2CF76AB91921CE")

    public int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;      // position within "data"

    /**
     * Blank constructor.  Fill in your own fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.188 -0500", hash_original_method = "6A535F879971D0788BB13E4964856994", hash_generated_method = "C7E2E20F4D9C5CE6F4D248CA29ADE431")
    
public Chunk() {}

    /**
     * Constructor with all fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.192 -0500", hash_original_method = "C04A7188909E46725BABBA45D3411BA7", hash_generated_method = "10A66FA8B7385AE3D2B9AB29CACBDE31")
    
public Chunk(int type, byte[] data, int offset, int length) {
        this.type = type;
        this.data = data;
        this.offset = offset;
        this.length = length;
    }

    /**
     * Construct from a ByteBuffer.  The chunk is assumed to start at
     * offset 0 and continue to the current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.194 -0500", hash_original_method = "E3AC8BD9C0992AF624180216E36F1FC7", hash_generated_method = "DDD1B73EF63996EC35AEB8E335F6DB91")
    
public Chunk(int type, ByteBuffer buf) {
        this.type = type;

        this.data = buf.array();
        this.offset = buf.arrayOffset();
        this.length = buf.position();
    }

    
}

