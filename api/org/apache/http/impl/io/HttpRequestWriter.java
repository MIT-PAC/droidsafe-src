package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public class HttpRequestWriter extends AbstractMessageWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.196 -0400", hash_original_method = "4AD2311BD1B24C9EE9C1B85C315E33B2", hash_generated_method = "FF844301E0401D425CC90AC5CD00F237")
    public  HttpRequestWriter(final SessionOutputBuffer buffer,
                             final LineFormatter formatter,
                             final HttpParams params) {
        super(buffer, formatter, params);
        addTaint(params.getTaint());
        addTaint(formatter.getTaint());
        addTaint(buffer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.197 -0400", hash_original_method = "649D146D64C47E17693DC42ABE1DC1B6", hash_generated_method = "BAF0059BBA4BE200CFE74DEE0E7E60D6")
    protected void writeHeadLine(final HttpMessage message) throws IOException {
        addTaint(message.getTaint());
        final CharArrayBuffer buffer = lineFormatter.formatRequestLine
            (this.lineBuf, ((HttpRequest) message).getRequestLine());
        this.sessionBuffer.writeLine(buffer);
        
        
            
        
    }

    
}

