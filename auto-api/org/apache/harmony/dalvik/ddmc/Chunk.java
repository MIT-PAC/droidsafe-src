package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public class Chunk {
    public int type;
    public byte[] data;
    public int offset, length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.776 -0400", hash_original_method = "6A535F879971D0788BB13E4964856994", hash_generated_method = "839E6F2CD1EA5EBDD2D384B79E8AB041")
    @DSModeled(DSC.SAFE)
    public Chunk() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.777 -0400", hash_original_method = "C04A7188909E46725BABBA45D3411BA7", hash_generated_method = "3D42BA0B8C06A48D58542FDE5AB0F583")
    @DSModeled(DSC.SAFE)
    public Chunk(int type, byte[] data, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.type = type;
        //this.data = data;
        //this.offset = offset;
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.777 -0400", hash_original_method = "E3AC8BD9C0992AF624180216E36F1FC7", hash_generated_method = "946055834F9270AA86358258728D01C2")
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

