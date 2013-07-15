package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.935 -0400", hash_original_field = "27B348194FA2C44245DD354AB07C0458", hash_generated_field = "ADE4068D7F9D27835F9860151E36C4D1")

    private ContentLengthStrategy lenStrategy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.936 -0400", hash_original_method = "43D1E101961C0CA215F907F346FBEAD7", hash_generated_method = "94772BDCDE342CA2FFA4646E5EFBF054")
    public  EntityDeserializer(final ContentLengthStrategy lenStrategy) {
        super();
    if(lenStrategy == null)        
        {
            IllegalArgumentException var2ED90DC28C31D7F9E7A793F1A6612732_330335265 = new IllegalArgumentException("Content length strategy may not be null");
            var2ED90DC28C31D7F9E7A793F1A6612732_330335265.addTaint(taint);
            throw var2ED90DC28C31D7F9E7A793F1A6612732_330335265;
        } //End block
        this.lenStrategy = lenStrategy;
        // ---------- Original Method ----------
        //if (lenStrategy == null) {
            //throw new IllegalArgumentException("Content length strategy may not be null");
        //}
        //this.lenStrategy = lenStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.936 -0400", hash_original_method = "1D794DD29EBBF563C5B5C17E3457B66D", hash_generated_method = "EFD2730E5172950F803C6AD4FD7EF654")
    protected BasicHttpEntity doDeserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        addTaint(message.getTaint());
        addTaint(inbuffer.getTaint());
        BasicHttpEntity entity = new BasicHttpEntity();
        long len = this.lenStrategy.determineLength(message);
    if(len == ContentLengthStrategy.CHUNKED)        
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } //End block
        else
    if(len == ContentLengthStrategy.IDENTITY)        
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } //End block
        else
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } //End block
        Header contentTypeHeader = message.getFirstHeader(HTTP.CONTENT_TYPE);
    if(contentTypeHeader != null)        
        {
            entity.setContentType(contentTypeHeader);
        } //End block
        Header contentEncodingHeader = message.getFirstHeader(HTTP.CONTENT_ENCODING);
    if(contentEncodingHeader != null)        
        {
            entity.setContentEncoding(contentEncodingHeader);
        } //End block
BasicHttpEntity var5E2D610DE63DCFFE14343DA0A43AB041_909776309 =         entity;
        var5E2D610DE63DCFFE14343DA0A43AB041_909776309.addTaint(taint);
        return var5E2D610DE63DCFFE14343DA0A43AB041_909776309;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.937 -0400", hash_original_method = "C26F2C28984D06F5314E4FD5C02EFDA9", hash_generated_method = "C1E65CB8C60A78E6F33DA9AF58250A31")
    public HttpEntity deserialize(
            final SessionInputBuffer inbuffer,
            final HttpMessage message) throws HttpException, IOException {
        addTaint(message.getTaint());
        addTaint(inbuffer.getTaint());
    if(inbuffer == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_210788997 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_210788997.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_210788997;
        } //End block
    if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_176868240 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_176868240.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_176868240;
        } //End block
HttpEntity varF990E2DB2F769F39D78F9CAF9EA3A18A_1754572961 =         doDeserialize(inbuffer, message);
        varF990E2DB2F769F39D78F9CAF9EA3A18A_1754572961.addTaint(taint);
        return varF990E2DB2F769F39D78F9CAF9EA3A18A_1754572961;
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

