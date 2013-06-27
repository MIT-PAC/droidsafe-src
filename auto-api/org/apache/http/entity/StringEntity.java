package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.917 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")

    protected byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.928 -0400", hash_original_method = "310FAE5CF3493E31DD2A41A7B590618B", hash_generated_method = "47DA21B265E09611F147265867C85524")
    public  StringEntity(final String s, String charset) throws UnsupportedEncodingException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Source string may not be null");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.929 -0400", hash_original_method = "C6F1280894F4B444CF2EFAD46C585EEF", hash_generated_method = "708E4C200C264FD91BBE539DBA47BFF1")
    public  StringEntity(final String s) throws UnsupportedEncodingException {
        this(s, null);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.929 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "F58A9DE45749F8329B3F728479512430")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762429435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762429435;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.929 -0400", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "F51CDF8EAE750B55FECA4A29E28C9C67")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_958331281 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_958331281;
        // ---------- Original Method ----------
        //return this.content.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.930 -0400", hash_original_method = "194171D7375452E3CA000FB317D6C6FC", hash_generated_method = "5E6F0E86B542EE64BC1DF68121C6ECD5")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_732053291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732053291 = new ByteArrayInputStream(this.content);
        varB4EAC82CA7396A68D541C85D26508E83_732053291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732053291;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(this.content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.930 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "54161771E12CA61F63AA77C457A76B65")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } //End block
        outstream.write(this.content);
        outstream.flush();
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //outstream.write(this.content);
        //outstream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.930 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "F0A8CF37DC63908754A928818E49D45C")
    public boolean isStreaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160752348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160752348;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.931 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "CAFE2AE4A2CF779C47F1E52BBFF32A4C")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1290802604 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1290802604 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1290802604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1290802604;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

