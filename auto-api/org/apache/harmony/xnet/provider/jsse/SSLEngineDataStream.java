package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public class SSLEngineDataStream implements DataStream {
    private ByteBuffer[] srcs;
    private int offset;
    private int limit;
    private int available;
    private int consumed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.101 -0400", hash_original_method = "81A231B3D4DD015A439D187A80559964", hash_generated_method = "4F884E8C06CBAD5E1E6F5ED508608E8B")
    @DSModeled(DSC.SAFE)
    protected SSLEngineDataStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.101 -0400", hash_original_method = "07A0F5FBA37A4DFBCBEB8B11158C1E83", hash_generated_method = "FA302BFC6318CA442837C05591F63007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setSourceBuffers(ByteBuffer[] srcs, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(srcs[0].dsTaint);
        this.limit = offset+length;
        this.consumed = 0;
        this.available = 0;
        {
            int i;
            i = offset;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.101 -0400", hash_original_method = "12974A5B538247B78E89825F62815487", hash_generated_method = "52BC28F58FAB185B4A9951E25E5A2CCA")
    @DSModeled(DSC.SAFE)
    public int available() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return available;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.102 -0400", hash_original_method = "B6667DC9436017993F0441DE39A68018", hash_generated_method = "943E1FF4141DAF9896FD863833E60209")
    @DSModeled(DSC.SAFE)
    public boolean hasData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return available > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.102 -0400", hash_original_method = "C75EAA43F8837BF85C32F9A85EFFF2A3", hash_generated_method = "D25076AE7617CB0426269D3F61FCFF19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getData(int length) {
        dsTaint.addTaint(length);
        int len;
        len = length;
        len = available;
        available -= len;
        consumed += len;
        byte[] res;
        res = new byte[len];
        int pos;
        pos = 0;
        {
            {
                boolean var983D78B773B0161A252B610CBD7A2B33_1636758527 = (srcs[offset].hasRemaining());
                {
                    res[pos++] = srcs[offset].get();
                } //End block
            } //End collapsed parenthetic
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.102 -0400", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "7D0FA270F33A3BE4583097A1ED349DA7")
    @DSModeled(DSC.SAFE)
    protected int consumed() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return consumed;
    }

    
}

