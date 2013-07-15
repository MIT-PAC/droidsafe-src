package org.apache.http.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.650 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")

    protected byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.650 -0400", hash_original_method = "310FAE5CF3493E31DD2A41A7B590618B", hash_generated_method = "47DA21B265E09611F147265867C85524")
    public  StringEntity(final String s, String charset) throws UnsupportedEncodingException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Source string may not be null");
        } 
        {
            charset = HTTP.DEFAULT_CONTENT_CHARSET;
        } 
        this.content = s.getBytes(charset);
        setContentType(HTTP.PLAIN_TEXT_TYPE + HTTP.CHARSET_PARAM + charset);
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.651 -0400", hash_original_method = "C6F1280894F4B444CF2EFAD46C585EEF", hash_generated_method = "708E4C200C264FD91BBE539DBA47BFF1")
    public  StringEntity(final String s) throws UnsupportedEncodingException {
        this(s, null);
        addTaint(s.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.651 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "144256EF7F3202792413B5908A91DD67")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268298577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268298577;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.651 -0400", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "47B048B984B639FE377ABF2D070F0E0E")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1015390081 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1015390081;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.651 -0400", hash_original_method = "194171D7375452E3CA000FB317D6C6FC", hash_generated_method = "664597409BB19D4DF9B685F229866E05")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1491094311 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1491094311 = new ByteArrayInputStream(this.content);
        varB4EAC82CA7396A68D541C85D26508E83_1491094311.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1491094311;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.652 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "54161771E12CA61F63AA77C457A76B65")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } 
        outstream.write(this.content);
        outstream.flush();
        addTaint(outstream.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.652 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "0FC9616E36DAABD20643A5352B16F6A9")
    public boolean isStreaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554588338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554588338;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.652 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "241B5AD86F225C99433B1441CCEE70FB")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_42269526 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_42269526 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_42269526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_42269526;
        
        
    }

    
}

