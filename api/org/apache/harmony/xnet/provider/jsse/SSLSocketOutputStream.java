package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;
import libcore.io.Streams;

public class SSLSocketOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.415 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private SSLSocketImpl owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.415 -0400", hash_original_method = "A41E4766E55868182E82056D4801E8D9", hash_generated_method = "CB52A3C219C1E690A6A134F779FCC9DD")
    protected  SSLSocketOutputStream(SSLSocketImpl owner) {
        this.owner = owner;
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.415 -0400", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "A356673BF18A00CFAC4BA54C535E65CE")
    @Override
    public void write(int b) throws IOException {
        addTaint(b);
        Streams.writeSingleByte(this, b);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.415 -0400", hash_original_method = "A06DCDC39D6B1A9C644C2D57A083C16C", hash_generated_method = "F51E4AFD402F18AF1810FCDF22DCEC08")
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        owner.writeAppData(b, off, len);
        // ---------- Original Method ----------
        //owner.writeAppData(b, off, len);
    }

    
}

