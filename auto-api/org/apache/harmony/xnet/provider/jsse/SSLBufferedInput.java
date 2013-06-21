package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SSLBufferedInput extends SSLInputStream {
    private ByteBuffer in;
    private int bytik;
    private int consumed = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.090 -0400", hash_original_method = "0FA622847329CF4AC911569EF96C37AF", hash_generated_method = "207C02C0F42AD27E2901C37C4EA4E064")
    @DSModeled(DSC.SAFE)
    protected SSLBufferedInput() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.091 -0400", hash_original_method = "4BA9811A4EA68D06D9EBAD32A862938E", hash_generated_method = "BF0ECF53B41941D74A05190E6C9C71EE")
    @DSModeled(DSC.SAFE)
    protected void setSourceBuffer(ByteBuffer in) {
        dsTaint.addTaint(in.dsTaint);
        consumed = 0;
        // ---------- Original Method ----------
        //consumed = 0;
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.091 -0400", hash_original_method = "BB38BB904E493CEE8626853626B4B1AC", hash_generated_method = "CDB209BDB5445781A3B50C2BE3937377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var46693C0FE71F5656EFDB47C257C9CAA2_1666316538 = (in.remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.remaining();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.091 -0400", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "7D0FA270F33A3BE4583097A1ED349DA7")
    @DSModeled(DSC.SAFE)
    protected int consumed() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return consumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.091 -0400", hash_original_method = "575079C176E4EB6FD7A12CD67A6942A7", hash_generated_method = "AD7804766371350365D4D541F8071754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        bytik = in.get() & 0x00FF;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //bytik = in.get() & 0x00FF;
        //consumed ++;
        //return bytik;
    }

    
}

