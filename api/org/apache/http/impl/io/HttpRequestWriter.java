package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public class HttpRequestWriter extends AbstractMessageWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.821 -0400", hash_original_method = "4AD2311BD1B24C9EE9C1B85C315E33B2", hash_generated_method = "FC427F59564FEE3D99F3EAF0C0641802")
    public  HttpRequestWriter(final SessionOutputBuffer buffer,
                             final LineFormatter formatter,
                             final HttpParams params) {
        super(buffer, formatter, params);
        addTaint(buffer.getTaint());
        addTaint(formatter.getTaint());
        addTaint(params.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.821 -0400", hash_original_method = "649D146D64C47E17693DC42ABE1DC1B6", hash_generated_method = "D88EECC95755FB75C32241DFD5C63ED8")
    protected void writeHeadLine(final HttpMessage message) throws IOException {
        final CharArrayBuffer buffer = lineFormatter.formatRequestLine
            (this.lineBuf, ((HttpRequest) message).getRequestLine());
        this.sessionBuffer.writeLine(buffer);
        addTaint(message.getTaint());
        
        
            
        
    }

    
}

