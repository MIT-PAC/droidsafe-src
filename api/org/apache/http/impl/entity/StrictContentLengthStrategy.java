package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;



public class StrictContentLengthStrategy implements ContentLengthStrategy {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.643 -0500", hash_original_method = "A65C37571E3ECC9A929C203280BB89E8", hash_generated_method = "44602CACFC5191B9BF91741DE7D47859")
    
public StrictContentLengthStrategy() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.646 -0500", hash_original_method = "27CE2D4FD8280195B6E05E2B487DF036", hash_generated_method = "2D8B29A7EA7AC3F4588CF68164E99D8A")
    
public long determineLength(final HttpMessage message) throws HttpException {
        if (message == null) {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        // Although Transfer-Encoding is specified as a list, in practice
        // it is either missing or has the single value "chunked". So we
        // treat it as a single-valued header here.
        Header transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
        if (transferEncodingHeader != null) {
            String s = transferEncodingHeader.getValue();
            if (HTTP.CHUNK_CODING.equalsIgnoreCase(s)) {
                if (message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException(
                            "Chunked transfer encoding not allowed for " + 
                            message.getProtocolVersion());
                }
                return CHUNKED;
            } else if (HTTP.IDENTITY_CODING.equalsIgnoreCase(s)) {
                return IDENTITY;
            } else {
                throw new ProtocolException(
                        "Unsupported transfer encoding: " + s);
            }
        } else if (contentLengthHeader != null) {
            String s = contentLengthHeader.getValue();
            try {
                long len = Long.parseLong(s);
                return len;
            } catch (NumberFormatException e) {
                throw new ProtocolException("Invalid content length: " + s);
            }
        } else {
            return IDENTITY; 
        }
    }

    
}

