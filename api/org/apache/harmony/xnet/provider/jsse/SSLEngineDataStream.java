package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;






public class SSLEngineDataStream implements DataStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.824 -0500", hash_original_field = "A6220FCD2F083DFC5C0FB7892B85F836", hash_generated_field = "1C70C2AA0A47E98C00D82E05EF21E063")


    private ByteBuffer[] srcs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.825 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.826 -0500", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.827 -0500", hash_original_field = "96F0D4829338588EDBA66E77F8C233B3", hash_generated_field = "6C61B8D89C0034A86F0E7842A74684F8")


    private int available;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.827 -0500", hash_original_field = "F297D4A4FEAFBF5D8C96F47F68BD926A", hash_generated_field = "0A663A78B7DB557980D9443265FD83B7")

    private int consumed;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.828 -0500", hash_original_method = "81A231B3D4DD015A439D187A80559964", hash_generated_method = "6103BD62BCBBE9B5F56246FB2AC24064")
    protected SSLEngineDataStream() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.829 -0500", hash_original_method = "07A0F5FBA37A4DFBCBEB8B11158C1E83", hash_generated_method = "5C88D9498B6A667D49A4B7595F477D69")
    protected void setSourceBuffers(ByteBuffer[] srcs, int offset, int length) {
        this.srcs = srcs;
        this.offset = offset;
        this.limit = offset+length;
        this.consumed = 0;
        this.available = 0;
        for (int i=offset; i<limit; i++) {
            if (srcs[i] == null) {
                throw new IllegalStateException(
                        "Some of the input parameters are null");
            }
            available += srcs[i].remaining();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.830 -0500", hash_original_method = "12974A5B538247B78E89825F62815487", hash_generated_method = "5BA18069819CB65ABADA384D4274D071")
    public int available() {
        return available;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.831 -0500", hash_original_method = "B6667DC9436017993F0441DE39A68018", hash_generated_method = "18DFFBA1CF33B5F26C63EAF0088F4D89")
    public boolean hasData() {
        return available > 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.831 -0500", hash_original_method = "C75EAA43F8837BF85C32F9A85EFFF2A3", hash_generated_method = "14E7B9E525A28443B8697F7833C40486")
    public byte[] getData(int length) {
        // TODO: optimization work:
        // use ByteBuffer.get(byte[],int,int)
        // and ByteBuffer.hasArray() methods
        int len = (length < available) ? length : available;
        available -= len;
        consumed += len;
        byte[] res = new byte[len];
        int pos = 0;
        loop:
        for (; offset<limit; offset++) {
            while (srcs[offset].hasRemaining()) {
                res[pos++] = srcs[offset].get();
                len --;
                if (len == 0) {
                    break loop;
                }
            }
        }
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:13.832 -0500", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "4A45CAF2AB4D7575A1E95B4998505638")
    protected int consumed() {
        return consumed;
    }

    
}

