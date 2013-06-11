package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteBuffer;

public class Chunk {
    public int type;
    public byte[] data;
    public int offset, length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.555 -0400", hash_original_method = "6A535F879971D0788BB13E4964856994", hash_generated_method = "68F17FF792B73CC4DB6F073BC0EA9136")
    @DSModeled(DSC.SAFE)
    public Chunk() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.555 -0400", hash_original_method = "C04A7188909E46725BABBA45D3411BA7", hash_generated_method = "0D14538AF8FEFD704CE75C0AF64449F4")
    @DSModeled(DSC.SAFE)
    public Chunk(int type, byte[] data, int offset, int length) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(length);
        dsTaint.addTaint(type);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.type = type;
        //this.data = data;
        //this.offset = offset;
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.555 -0400", hash_original_method = "E3AC8BD9C0992AF624180216E36F1FC7", hash_generated_method = "1A4A532A92DCD759DAAC8E5C01AD5B66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk(int type, ByteBuffer buf) {
        dsTaint.addTaint(type);
        dsTaint.addTaint(buf.dsTaint);
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


