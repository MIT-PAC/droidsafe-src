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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.772 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private SSLSocketImpl owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.773 -0400", hash_original_method = "A41E4766E55868182E82056D4801E8D9", hash_generated_method = "CB52A3C219C1E690A6A134F779FCC9DD")
    protected  SSLSocketOutputStream(SSLSocketImpl owner) {
        this.owner = owner;
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.773 -0400", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "A2120F3993594C72A1AB5EA705EDBD82")
    @Override
    public void write(int b) throws IOException {
        Streams.writeSingleByte(this, b);
        addTaint(b);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.773 -0400", hash_original_method = "A06DCDC39D6B1A9C644C2D57A083C16C", hash_generated_method = "8C6DF73F41FDF92903A83666AAD4819A")
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        owner.writeAppData(b, off, len);
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //owner.writeAppData(b, off, len);
    }

    
}

