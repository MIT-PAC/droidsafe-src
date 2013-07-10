package org.apache.http.impl.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.protocol.HTTP;

public class EntityDeserializer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.528 -0400", hash_original_field = "27B348194FA2C44245DD354AB07C0458", hash_generated_field = "ADE4068D7F9D27835F9860151E36C4D1")

    private ContentLengthStrategy lenStrategy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.529 -0400", hash_original_method = "43D1E101961C0CA215F907F346FBEAD7", hash_generated_method = "BD31070A3EF044B9F72ED5C0FAF09D14")
    public  EntityDeserializer(final ContentLengthStrategy lenStrategy) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Content length strategy may not be null");
        } 
        this.lenStrategy = lenStrategy;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.530 -0400", hash_original_method = "1D794DD29EBBF563C5B5C17E3457B66D", hash_generated_method = "129F2F06E033D1B3454AA2DA5A42FEB3")
    protected BasicHttpEntity doDeserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        BasicHttpEntity varB4EAC82CA7396A68D541C85D26508E83_756389255 = null; 
        BasicHttpEntity entity = new BasicHttpEntity();
        long len = this.lenStrategy.determineLength(message);
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } 
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } 
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } 
        Header contentTypeHeader = message.getFirstHeader(HTTP.CONTENT_TYPE);
        {
            entity.setContentType(contentTypeHeader);
        } 
        Header contentEncodingHeader = message.getFirstHeader(HTTP.CONTENT_ENCODING);
        {
            entity.setContentEncoding(contentEncodingHeader);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_756389255 = entity;
        addTaint(inbuffer.getTaint());
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_756389255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_756389255;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.531 -0400", hash_original_method = "C26F2C28984D06F5314E4FD5C02EFDA9", hash_generated_method = "401841C4B73BA8A782A53248D6607544")
    public HttpEntity deserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1558757965 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session input buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1558757965 = doDeserialize(inbuffer, message);
        addTaint(inbuffer.getTaint());
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1558757965.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1558757965;
        
        
            
        
        
            
        
        
    }

    
}

