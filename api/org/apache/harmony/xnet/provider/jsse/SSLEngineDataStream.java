package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.ByteBuffer;






public class SSLEngineDataStream implements DataStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_field = "70EFB0EA53D4AFD2D2BE19A55D2C1FB6", hash_generated_field = "1C70C2AA0A47E98C00D82E05EF21E063")

    private ByteBuffer[] srcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "6C61B8D89C0034A86F0E7842A74684F8")

    private int available;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_field = "48FE8558CE14C4C865198444C538ECC5", hash_generated_field = "0A663A78B7DB557980D9443265FD83B7")

    private int consumed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.112 -0400", hash_original_method = "81A231B3D4DD015A439D187A80559964", hash_generated_method = "4F884E8C06CBAD5E1E6F5ED508608E8B")
    protected  SSLEngineDataStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.114 -0400", hash_original_method = "07A0F5FBA37A4DFBCBEB8B11158C1E83", hash_generated_method = "8D45692BF55686E14F588240BA160202")
    protected void setSourceBuffers(ByteBuffer[] srcs, int offset, int length) {
        this.srcs = srcs;
        this.offset = offset;
        this.limit = offset+length;
        this.consumed = 0;
        this.available = 0;
for(int i=offset;i<limit;i++)
        {
            if(srcs[i] == null)            
            {
                IllegalStateException var205149AF7ED940A9AB9D4D1787309CCB_2065761751 = new IllegalStateException(
                        "Some of the input parameters are null");
                var205149AF7ED940A9AB9D4D1787309CCB_2065761751.addTaint(taint);
                throw var205149AF7ED940A9AB9D4D1787309CCB_2065761751;
            } //End block
            available += srcs[i].remaining();
        } //End block
        // ---------- Original Method ----------
        //this.srcs = srcs;
        //this.offset = offset;
        //this.limit = offset+length;
        //this.consumed = 0;
        //this.available = 0;
        //for (int i=offset; i<limit; i++) {
            //if (srcs[i] == null) {
                //throw new IllegalStateException(
                        //"Some of the input parameters are null");
            //}
            //available += srcs[i].remaining();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.115 -0400", hash_original_method = "12974A5B538247B78E89825F62815487", hash_generated_method = "5C719ECA7E52B6425EBFCF1E8582A0FA")
    public int available() {
        int varE4894CA167B08880BFC35862F18575EB_1103083684 = (available);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966252667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966252667;
        // ---------- Original Method ----------
        //return available;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.115 -0400", hash_original_method = "B6667DC9436017993F0441DE39A68018", hash_generated_method = "8A1E75613583EE1005CB476DDBFEEE41")
    public boolean hasData() {
        boolean var187323F648CA0F77519D1FF133B598A4_1161997401 = (available > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119720652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_119720652;
        // ---------- Original Method ----------
        //return available > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.116 -0400", hash_original_method = "C75EAA43F8837BF85C32F9A85EFFF2A3", hash_generated_method = "777FB7DE200178CB45485690F5B1C068")
    public byte[] getData(int length) {
        addTaint(length);
        int len = (length < available) ? length : available;
        available -= len;
        consumed += len;
        byte[] res = new byte[len];
        int pos = 0;
        loop        :
for(;offset<limit;offset++)
        {
            while
(srcs[offset].hasRemaining())            
            {
                res[pos++] = srcs[offset].get();
                len --;
                if(len == 0)                
                {
                    break loop;
                } //End block
            } //End block
        } //End block
        byte[] var9B207167E5381C47682C6B4F58A623FB_1314105521 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1657033879 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1657033879;
        // ---------- Original Method ----------
        //int len = (length < available) ? length : available;
        //available -= len;
        //consumed += len;
        //byte[] res = new byte[len];
        //int pos = 0;
        //loop:
        //for (; offset<limit; offset++) {
            //while (srcs[offset].hasRemaining()) {
                //res[pos++] = srcs[offset].get();
                //len --;
                //if (len == 0) {
                    //break loop;
                //}
            //}
        //}
        //return res;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.117 -0400", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "1700166E98C3B99E4450D1ECB40F0E1D")
    protected int consumed() {
        int var48FE8558CE14C4C865198444C538ECC5_891562451 = (consumed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935767017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935767017;
        // ---------- Original Method ----------
        //return consumed;
    }

    
}

