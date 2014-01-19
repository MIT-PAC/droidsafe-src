package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import libcore.io.Streams;

public class SSLSocketOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.930 -0500", hash_original_field = "09345289E0F08ED39AA376881C5DC943", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private  SSLSocketImpl owner;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.932 -0500", hash_original_method = "A41E4766E55868182E82056D4801E8D9", hash_generated_method = "04B6ABE5C4995B5869C51820FCCA2F91")
    
protected SSLSocketOutputStream(SSLSocketImpl owner) {
        this.owner = owner;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.935 -0500", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "23C1BFB0F79EE3063A60285E2CC71033")
    
@Override public void write(int b) throws IOException {
        Streams.writeSingleByte(this, b);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.937 -0500", hash_original_method = "A06DCDC39D6B1A9C644C2D57A083C16C", hash_generated_method = "899EF57D5285130E25B1B9F4EB64F8B2")
    
@Override
    public void write(byte[] b, int off, int len) throws IOException {
        owner.writeAppData(b, off, len);
    }
    
}

