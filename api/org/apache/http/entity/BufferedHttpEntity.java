package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class BufferedHttpEntity extends HttpEntityWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.391 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")
      
    private  byte[] buffer;
      
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.394 -0500", hash_original_method = "9933624B15A1F62492A5E829A3A364D0", hash_generated_method = "7365481014051F2C49B60B2ABC35D68E")
    
public BufferedHttpEntity(final HttpEntity entity) throws IOException {
        super(entity);
        if (!entity.isRepeatable() || entity.getContentLength() < 0) {
            this.buffer = EntityUtils.toByteArray(entity);
        } else {
            this.buffer = null;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.396 -0500", hash_original_method = "26AA3A162E430A9FEBBBBE7476A32626", hash_generated_method = "FE7798FDA94ED939F34AA0192E837B3C")
    
public long getContentLength() {
        if (this.buffer != null) {
            return this.buffer.length;
        } else {
            return wrappedEntity.getContentLength();
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.399 -0500", hash_original_method = "C66624A0F56D5B3373911F6483E82581", hash_generated_method = "92D13803F2C5D004E4F8464E7AD317ED")
    
public InputStream getContent() throws IOException {
        if (this.buffer != null) {
            return new ByteArrayInputStream(this.buffer);
        } else {
            return wrappedEntity.getContent();
        }
    }

    /**
     * Tells that this entity does not have to be chunked.
     *
     * @return  <code>false</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.402 -0500", hash_original_method = "2A121AFE9268A901CC611E90FC00D0E8", hash_generated_method = "8EAEAA8DF652C30AE6AA4AA6CB855AEB")
    
public boolean isChunked() {
        return (buffer == null) && wrappedEntity.isChunked();
    }
    
    /**
     * Tells that this entity is repeatable.
     *
     * @return  <code>true</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.404 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    
public boolean isRepeatable() {
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.406 -0500", hash_original_method = "6978AFF2D6BA6FB48D86DE86B3A93492", hash_generated_method = "C76A5C9ECA2850EB6E2362D1F4C588D4")
    
public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        if (this.buffer != null) {
            outstream.write(this.buffer);
        } else {
            wrappedEntity.writeTo(outstream);
        }
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.408 -0500", hash_original_method = "298A03178432926E5E6E7F0EA9A50E03", hash_generated_method = "391960D0CDAF5FB656465768F0570EFD")
    
public boolean isStreaming() {
        return (buffer == null) && wrappedEntity.isStreaming();
    }
    
}

