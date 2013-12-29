package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.http.protocol.HTTP;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected  byte[] content = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.816 -0500", hash_original_method = "310FAE5CF3493E31DD2A41A7B590618B", hash_generated_method = "AB109E6E9CB1E6644855DA118C9B8507")
    public StringEntity(final String s, String charset) 
            throws UnsupportedEncodingException {
        super();
        if (s == null) {
            throw new IllegalArgumentException("Source string may not be null");
        }
        if (charset == null) {
            charset = HTTP.DEFAULT_CONTENT_CHARSET;
        }
        this.content = s.getBytes(charset);
        setContentType(HTTP.PLAIN_TEXT_TYPE + HTTP.CHARSET_PARAM + charset);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.794 -0400", hash_original_method = "C6F1280894F4B444CF2EFAD46C585EEF", hash_generated_method = "708E4C200C264FD91BBE539DBA47BFF1")
    public  StringEntity(final String s) throws UnsupportedEncodingException {
        //this(s, null);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    // orphaned legacy method
    public StringEntity(final String string, final ContentType contentType) {
        this.content = string.getBytes();
        setContentType(contentType.toString());
    }
    
    // orphaned legacy method
    public StringEntity(final String string, final Charset charset) {
        this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public boolean isRepeatable() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public long getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public InputStream getContent() throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.820 -0500", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "BDD092DE07E44519E63AE6CE1D7E2553")
    public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        outstream.write(this.content);
        outstream.flush();
    }

    /**
     * Tells that this entity is not streaming.
     *
     * @return <code>false</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.821 -0500", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "15A1411ACDA23E1A918918FF0CDDBE57")
    public boolean isStreaming() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.822 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // orphaned legacy method
    @Override
	public boolean isChunked() {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    // orphaned legacy method
    @Override
	public void consumeContent() throws IOException {
		// TODO Auto-generated method stub
		
	}
    
}

