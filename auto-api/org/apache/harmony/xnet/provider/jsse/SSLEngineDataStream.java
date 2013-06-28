package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public class SSLEngineDataStream implements DataStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_field = "70EFB0EA53D4AFD2D2BE19A55D2C1FB6", hash_generated_field = "1C70C2AA0A47E98C00D82E05EF21E063")

    private ByteBuffer[] srcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "6C61B8D89C0034A86F0E7842A74684F8")

    private int available;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_field = "48FE8558CE14C4C865198444C538ECC5", hash_generated_field = "0A663A78B7DB557980D9443265FD83B7")

    private int consumed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.726 -0400", hash_original_method = "81A231B3D4DD015A439D187A80559964", hash_generated_method = "4F884E8C06CBAD5E1E6F5ED508608E8B")
    protected  SSLEngineDataStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.727 -0400", hash_original_method = "07A0F5FBA37A4DFBCBEB8B11158C1E83", hash_generated_method = "309560089E72AB4939EEF34DF53428F1")
    protected void setSourceBuffers(ByteBuffer[] srcs, int offset, int length) {
        this.srcs = srcs;
        this.offset = offset;
        this.limit = offset+length;
        this.consumed = 0;
        this.available = 0;
        {
            int i = offset;
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Some of the input parameters are null");
                } //End block
                available += srcs[i].remaining();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.727 -0400", hash_original_method = "12974A5B538247B78E89825F62815487", hash_generated_method = "E9554EA62D60FD78A60721D8A5D9E6F1")
    public int available() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066266707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066266707;
        // ---------- Original Method ----------
        //return available;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.727 -0400", hash_original_method = "B6667DC9436017993F0441DE39A68018", hash_generated_method = "2FE7B8789550A10CF567BA07FA52E1C7")
    public boolean hasData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834136272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834136272;
        // ---------- Original Method ----------
        //return available > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.728 -0400", hash_original_method = "C75EAA43F8837BF85C32F9A85EFFF2A3", hash_generated_method = "5394715D26288D984111EFA96EE50DB9")
    public byte[] getData(int length) {
        int len;
        len = length;
        len = available;
        available -= len;
        consumed += len;
        byte[] res = new byte[len];
        int pos = 0;
        {
            {
                boolean var983D78B773B0161A252B610CBD7A2B33_1879650113 = (srcs[offset].hasRemaining());
                {
                    res[pos++] = srcs[offset].get();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1177210771 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1177210771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.728 -0400", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "194FE11CA0E1333D98D9F59050529628")
    protected int consumed() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435941877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435941877;
        // ---------- Original Method ----------
        //return consumed;
    }

    
}

