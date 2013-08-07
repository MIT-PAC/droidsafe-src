package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.ByteBuffer;




public class Chunk {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "F02DD38BDDF66ED8369494A65A3A6765")

    public byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "29401E0923088C769B2CF76AB91921CE")

    public int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_method = "6A535F879971D0788BB13E4964856994", hash_generated_method = "839E6F2CD1EA5EBDD2D384B79E8AB041")
    public  Chunk() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.850 -0400", hash_original_method = "C04A7188909E46725BABBA45D3411BA7", hash_generated_method = "915E27FE45BBAC9B59A1D2D30C41E2F5")
    public  Chunk(int type, byte[] data, int offset, int length) {
        this.type = type;
        this.data = data;
        this.offset = offset;
        this.length = length;
        // ---------- Original Method ----------
        //this.type = type;
        //this.data = data;
        //this.offset = offset;
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.850 -0400", hash_original_method = "E3AC8BD9C0992AF624180216E36F1FC7", hash_generated_method = "C234E7436EBB4569FAE5DE901F4FF55C")
    public  Chunk(int type, ByteBuffer buf) {
        this.type = type;
        this.data = buf.array();
        this.offset = buf.arrayOffset();
        this.length = buf.position();
        // ---------- Original Method ----------
        //this.type = type;
        //this.data = buf.array();
        //this.offset = buf.arrayOffset();
        //this.length = buf.position();
    }

    
}

