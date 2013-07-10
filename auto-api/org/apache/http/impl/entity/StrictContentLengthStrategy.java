package org.apache.http.impl.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;

public class StrictContentLengthStrategy implements ContentLengthStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.573 -0400", hash_original_method = "A65C37571E3ECC9A929C203280BB89E8", hash_generated_method = "D45C93F906D0EA835886288481D205FA")
    public  StrictContentLengthStrategy() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.574 -0400", hash_original_method = "27CE2D4FD8280195B6E05E2B487DF036", hash_generated_method = "9FDD01032805A525ACC680C33ACAD5E9")
    public long determineLength(final HttpMessage message) throws HttpException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } 
        Header transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
        {
            String s = transferEncodingHeader.getValue();
            {
                boolean var27CE5E0B53386BA287AE10A4E0178F22_95122181 = (HTTP.CHUNK_CODING.equalsIgnoreCase(s));
                {
                    {
                        boolean var9175B9ED7F5A8E8F71546399FB60FBE4_2002554873 = (message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                            "Chunked transfer encoding not allowed for " + 
                            message.getProtocolVersion());
                        } 
                    } 
                } 
                {
                    boolean varFCE811B82D72E59F887FAB90CE29F26F_611002688 = (HTTP.IDENTITY_CODING.equalsIgnoreCase(s));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                        "Unsupported transfer encoding: " + s);
                    } 
                } 
            } 
        } 
        {
            String s = contentLengthHeader.getValue();
            try 
            {
                long len = Long.parseLong(s);
            } 
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid content length: " + s);
            } 
        } 
        addTaint(message.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1817648321 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1817648321;
        
        
    }

    
}

