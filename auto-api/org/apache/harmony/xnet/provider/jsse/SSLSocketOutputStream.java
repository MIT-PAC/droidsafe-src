package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import libcore.io.Streams;

public class SSLSocketOutputStream extends OutputStream {
    private SSLSocketImpl owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.270 -0400", hash_original_method = "A41E4766E55868182E82056D4801E8D9", hash_generated_method = "6BA8F5E91F625DCF7B6882A259DCCB82")
    @DSModeled(DSC.SAFE)
    protected SSLSocketOutputStream(SSLSocketImpl owner) {
        dsTaint.addTaint(owner.dsTaint);
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.270 -0400", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "1B5C363EA3CCD918C562424A138EAEC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int b) throws IOException {
        dsTaint.addTaint(b);
        Streams.writeSingleByte(this, b);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.270 -0400", hash_original_method = "A06DCDC39D6B1A9C644C2D57A083C16C", hash_generated_method = "29E75A3E5F7FAE493C2406B488699B42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        owner.writeAppData(b, off, len);
        // ---------- Original Method ----------
        //owner.writeAppData(b, off, len);
    }

    
}

