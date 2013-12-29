package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
public class EntityTemplate extends AbstractHttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.671 -0500", hash_original_field = "210DBCA98895B7D0D277EF067D0F94AC", hash_generated_field = "A99FB28A10897E24D1BB65A3EC202A4B")


    private  ContentProducer contentproducer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.672 -0500", hash_original_method = "00598D1ACBA1C09EA0328079C62636B7", hash_generated_method = "7F93FBB523AF8124A5F7D93951B5D8C7")
    public EntityTemplate(final ContentProducer contentproducer) {
        super();
        if (contentproducer == null) {
            throw new IllegalArgumentException("Content producer may not be null");
        }
        this.contentproducer = contentproducer; 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.673 -0500", hash_original_method = "8F3921A7A9D3B2470F819E16ABC2318F", hash_generated_method = "D18531F352ABD3C1799D47E812CF4DD6")
    public long getContentLength() {
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.673 -0500", hash_original_method = "34C97105122275A5F1AFAA7197ED4E75", hash_generated_method = "FEB25EA7DED1E40060FA9CBD5DD76910")
    public InputStream getContent() {
        throw new UnsupportedOperationException("Entity template does not implement getContent()");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.674 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    public boolean isRepeatable() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.675 -0500", hash_original_method = "592FE25978346EDEF8B202F993477346", hash_generated_method = "854F806665C889F8FD6653FF90B7081E")
    public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        this.contentproducer.writeTo(outstream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.676 -0500", hash_original_method = "06CB3F2A2C5EF7DDBC28F65520517EC2", hash_generated_method = "388F8F3896A87B874B8F176D6DEC8FDF")
    public boolean isStreaming() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.676 -0500", hash_original_method = "62C2D9F9627B879E4D265B8DAE26FBD7", hash_generated_method = "B45CD566A791CC972AB699DFDCDF988B")
    public void consumeContent() throws IOException {
    }

    
}

