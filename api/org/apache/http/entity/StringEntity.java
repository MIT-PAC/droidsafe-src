package org.apache.http.entity;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.http.protocol.HTTP;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final String content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.793 -0400", hash_original_method = "310FAE5CF3493E31DD2A41A7B590618B", hash_generated_method = "D6DF4A142B89E0B0B95941A5CA423B41")
    public  StringEntity(final String s, String charset) throws UnsupportedEncodingException {
        super();
        if(s == null)        
        {
            IllegalArgumentException varE24C186B16DB6A69B6EFDB5064864FE5_1995702918 = new IllegalArgumentException("Source string may not be null");
            varE24C186B16DB6A69B6EFDB5064864FE5_1995702918.addTaint(taint);
            throw varE24C186B16DB6A69B6EFDB5064864FE5_1995702918;
        } //End block
        if(charset == null)        
        {
            charset = HTTP.DEFAULT_CONTENT_CHARSET;
        } //End block
        this.content = s.getBytes(charset);
        setContentType(HTTP.PLAIN_TEXT_TYPE + HTTP.CHARSET_PARAM + charset);
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new IllegalArgumentException("Source string may not be null");
        //}
        //if (charset == null) {
            //charset = HTTP.DEFAULT_CONTENT_CHARSET;
        //}
        //this.content = s.getBytes(charset);
        //setContentType(HTTP.PLAIN_TEXT_TYPE + HTTP.CHARSET_PARAM + charset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.794 -0400", hash_original_method = "C6F1280894F4B444CF2EFAD46C585EEF", hash_generated_method = "708E4C200C264FD91BBE539DBA47BFF1")
    public  StringEntity(final String s) throws UnsupportedEncodingException {
        this(s, null);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.799 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "5F994F9AF4B08F36F8435C59D110FF86")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_1274632363 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_1274632363.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_1274632363;
        } //End block
        outstream.write(this.content);
        outstream.flush();
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //outstream.write(this.content);
        //outstream.flush();
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

