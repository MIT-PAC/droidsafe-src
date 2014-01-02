package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;






public class SSLBufferedInput extends SSLInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.915 -0500", hash_original_field = "1A56AB50090D28A02F47C32C2668C7FD", hash_generated_field = "3B141A9D4793286CCC8107F666C9770C")


    private ByteBuffer in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.918 -0500", hash_original_field = "532D7488A927B1D867DA636C071D1BB6", hash_generated_field = "57C57C6B5A44D0B945AC629B5C8D3802")

    private int bytik;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.920 -0500", hash_original_field = "63AB233FA6EF1285AEB9654E5C7266F1", hash_generated_field = "58E74C0831CBD382581EE5956FDD5009")

    private int consumed = 0;

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.923 -0500", hash_original_method = "0FA622847329CF4AC911569EF96C37AF", hash_generated_method = "C8B59A0FF5C0D8A4086B76B2389A8D68")
    
protected SSLBufferedInput() {}

    /**
     * Sets the buffer as a data source
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.925 -0500", hash_original_method = "4BA9811A4EA68D06D9EBAD32A862938E", hash_generated_method = "6762055C18D7E7AF428C9CFC87D123B1")
    
protected void setSourceBuffer(ByteBuffer in) {
        consumed = 0;
        this.in = in;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.928 -0500", hash_original_method = "BB38BB904E493CEE8626853626B4B1AC", hash_generated_method = "AA73DAF788F8E3B9B23B91AC6E385275")
    
@Override
    public int available() throws IOException {
        // in assumption that the buffer has been set
        return in.remaining();
    }

    /**
     * Returns the number of consumed bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.931 -0500", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "4A45CAF2AB4D7575A1E95B4998505638")
    
protected int consumed() {
        return consumed;
    }

    /**
     * Reads the following byte value. If there are no bytes in the source
     * buffer, method throws java.nio.BufferUnderflowException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.933 -0500", hash_original_method = "575079C176E4EB6FD7A12CD67A6942A7", hash_generated_method = "4A008A76C11FDFEC076499B05D184DCF")
    
@Override
    public int read() throws IOException {
        // TODO: implement optimized read(int)
        // and read(byte[], int, int) methods
        bytik = in.get() & 0x00FF;
        consumed ++;
        return bytik;
    }

    
}

