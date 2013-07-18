package org.apache.http.entity;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.http.Header;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final String content;
    
    @Override
	public boolean isRepeatable() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @Override
	public long getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @Override
	public InputStream getContent() throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

    
    @Override
	public boolean isStreaming() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.811 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "102D7ED25E1B5F12D69392169FBE7276")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_246926352 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_246926352.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_246926352;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    // orphaned legacy method
    public StringEntity(final String string, final ContentType contentType) {
        this.content = string;
        setContentType(contentType.toString());
    }
    
    // orphaned legacy method
    @Override
	public boolean isChunked() {
		// TODO Auto-generated method stub
		return false;
	}
    
    // orphaned legacy method
    @Override
	public void writeTo(OutputStream arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    // orphaned legacy method
    @Override
	public Header getContentType() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SPEC)
	public StringEntity(final String string) {
		this.content = string;
    }
    
    // orphaned legacy method
    public StringEntity(final String string, final Charset charset) {
        this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }
    
    // orphaned legacy method
    @Override
	public Header getContentEncoding() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // orphaned legacy method
    @Override
	public void consumeContent() throws IOException {
		// TODO Auto-generated method stub
		
	}
    
}

