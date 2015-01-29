package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;



public class HttpRequestWriter extends AbstractMessageWriter {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.865 -0500", hash_original_method = "4AD2311BD1B24C9EE9C1B85C315E33B2", hash_generated_method = "55CB82CAB3A84B52CAA08358E1220F90")
    
public HttpRequestWriter(final SessionOutputBuffer buffer,
                             final LineFormatter formatter,
                             final HttpParams params) {
        super(buffer, formatter, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.867 -0500", hash_original_method = "649D146D64C47E17693DC42ABE1DC1B6", hash_generated_method = "1CFA7771AFE5DA9C7591FEB2F3118AF4")
    
protected void writeHeadLine(final HttpMessage message)
        throws IOException {

        final CharArrayBuffer buffer = lineFormatter.formatRequestLine
            (this.lineBuf, ((HttpRequest) message).getRequestLine());
        this.sessionBuffer.writeLine(buffer);
    }

    
}

