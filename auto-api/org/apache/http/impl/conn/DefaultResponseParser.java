package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.conn.params.ConnConnectionPNames;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public class DefaultResponseParser extends AbstractMessageParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.472 -0400", hash_original_field = "231DD88D1D24FBAC95F5FF27F7E132D5", hash_generated_field = "617CD99CE3703350A89163AF27F85CC2")

    private HttpResponseFactory responseFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.472 -0400", hash_original_field = "DD77BBE950DCBAAE75A78BE6835B370C", hash_generated_field = "138A98BD7AF16A46911F2E280FBA40A5")

    private CharArrayBuffer lineBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.472 -0400", hash_original_field = "ADCD3DA3E4B07BDF3BF1597A7B6425F0", hash_generated_field = "A0439754C86F54D18933BCE41E68B66E")

    private int maxGarbageLines;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.473 -0400", hash_original_method = "9FE3A37335F8238651919EE9ABE222C5", hash_generated_method = "2FA0AD3A51B333254F7217C889EC508B")
    public  DefaultResponseParser(
            final SessionInputBuffer buffer,
            final LineParser parser,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        super(buffer, parser, params);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Response factory may not be null");
        } //End block
        this.responseFactory = responseFactory;
        this.lineBuf = new CharArrayBuffer(128);
        this.maxGarbageLines = params.getIntParameter(
            ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, Integer.MAX_VALUE);
        addTaint(buffer.getTaint());
        addTaint(parser.getTaint());
        // ---------- Original Method ----------
        //if (responseFactory == null) {
            //throw new IllegalArgumentException
                //("Response factory may not be null");
        //}
        //this.responseFactory = responseFactory;
        //this.lineBuf = new CharArrayBuffer(128);
        //this.maxGarbageLines = params.getIntParameter(
            //ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.474 -0400", hash_original_method = "C18012C1F40BC670B50816FED9E30E72", hash_generated_method = "A7F90FD160996E83255150562B44C3BC")
    @Override
    protected HttpMessage parseHead(
            final SessionInputBuffer sessionBuffer) throws IOException, HttpException {
        HttpMessage varB4EAC82CA7396A68D541C85D26508E83_950813857 = null; //Variable for return #1
        this.lineBuf.clear();
        int count = 0;
        ParserCursor cursor = null;
        {
            int i = sessionBuffer.readLine(this.lineBuf);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoHttpResponseException("The target server failed to respond");
            } //End block
            cursor = new ParserCursor(0, this.lineBuf.length());
            {
                boolean var5AC484C239E6FF2F638CBF0BDF14EAC2_855852778 = (lineParser.hasProtocolVersion(this.lineBuf, cursor));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException("The server failed to respond with a " +
                        "valid HTTP response");
                } //End block
            } //End collapsed parenthetic
        } //End block
        StatusLine statusline = lineParser.parseStatusLine(this.lineBuf, cursor);
        varB4EAC82CA7396A68D541C85D26508E83_950813857 = this.responseFactory.newHttpResponse(statusline, null);
        addTaint(sessionBuffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_950813857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_950813857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

