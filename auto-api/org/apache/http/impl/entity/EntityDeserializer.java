package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
        } //End block
        this.lenStrategy = lenStrategy;
        // ---------- Original Method ----------
        //if (lenStrategy == null) {
            //throw new IllegalArgumentException("Content length strategy may not be null");
        //}
        //this.lenStrategy = lenStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.530 -0400", hash_original_method = "1D794DD29EBBF563C5B5C17E3457B66D", hash_generated_method = "129F2F06E033D1B3454AA2DA5A42FEB3")
    protected BasicHttpEntity doDeserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        BasicHttpEntity varB4EAC82CA7396A68D541C85D26508E83_756389255 = null; //Variable for return #1
        BasicHttpEntity entity = new BasicHttpEntity();
        long len = this.lenStrategy.determineLength(message);
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } //End block
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } //End block
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } //End block
        Header contentTypeHeader = message.getFirstHeader(HTTP.CONTENT_TYPE);
        {
            entity.setContentType(contentTypeHeader);
        } //End block
        Header contentEncodingHeader = message.getFirstHeader(HTTP.CONTENT_ENCODING);
        {
            entity.setContentEncoding(contentEncodingHeader);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_756389255 = entity;
        addTaint(inbuffer.getTaint());
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_756389255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_756389255;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.531 -0400", hash_original_method = "C26F2C28984D06F5314E4FD5C02EFDA9", hash_generated_method = "401841C4B73BA8A782A53248D6607544")
    public HttpEntity deserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1558757965 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session input buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1558757965 = doDeserialize(inbuffer, message);
        addTaint(inbuffer.getTaint());
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1558757965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1558757965;
        // ---------- Original Method ----------
        //if (inbuffer == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //if (message == null) {
            //throw new IllegalArgumentException("HTTP message may not be null");
        //}
        //return doDeserialize(inbuffer, message);
    }

    
}

