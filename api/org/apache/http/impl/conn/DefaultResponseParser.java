package org.apache.http.impl.conn;

// Droidsafe Imports
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

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class DefaultResponseParser extends AbstractMessageParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.104 -0400", hash_original_field = "231DD88D1D24FBAC95F5FF27F7E132D5", hash_generated_field = "617CD99CE3703350A89163AF27F85CC2")

    private HttpResponseFactory responseFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.104 -0400", hash_original_field = "DD77BBE950DCBAAE75A78BE6835B370C", hash_generated_field = "138A98BD7AF16A46911F2E280FBA40A5")

    private CharArrayBuffer lineBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.104 -0400", hash_original_field = "ADCD3DA3E4B07BDF3BF1597A7B6425F0", hash_generated_field = "A0439754C86F54D18933BCE41E68B66E")

    private int maxGarbageLines;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.105 -0400", hash_original_method = "9FE3A37335F8238651919EE9ABE222C5", hash_generated_method = "AA1616798BAE326F2F7F2DA18968BBDF")
    public  DefaultResponseParser(
            final SessionInputBuffer buffer,
            final LineParser parser,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        super(buffer, parser, params);
        addTaint(parser.getTaint());
        addTaint(buffer.getTaint());
        if(responseFactory == null)        
        {
            IllegalArgumentException var4DE4C2B8B51C37D4C049343CDF1871A3_1965453499 = new IllegalArgumentException
                ("Response factory may not be null");
            var4DE4C2B8B51C37D4C049343CDF1871A3_1965453499.addTaint(taint);
            throw var4DE4C2B8B51C37D4C049343CDF1871A3_1965453499;
        } //End block
        this.responseFactory = responseFactory;
        this.lineBuf = new CharArrayBuffer(128);
        this.maxGarbageLines = params.getIntParameter(
            ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, Integer.MAX_VALUE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.105 -0400", hash_original_method = "C18012C1F40BC670B50816FED9E30E72", hash_generated_method = "62AB0D9B1EBDE6FA0BF6A1957F164A04")
    @Override
    protected HttpMessage parseHead(
            final SessionInputBuffer sessionBuffer) throws IOException, HttpException {
        addTaint(sessionBuffer.getTaint());
        this.lineBuf.clear();
        int count = 0;
        ParserCursor cursor = null;
        do {
            {
                int i = sessionBuffer.readLine(this.lineBuf);
                if(i == -1 && count == 0)                
                {
                    NoHttpResponseException var8E6E6A11E770AF132B510E2C0E1EA88C_2012479453 = new NoHttpResponseException("The target server failed to respond");
                    var8E6E6A11E770AF132B510E2C0E1EA88C_2012479453.addTaint(taint);
                    throw var8E6E6A11E770AF132B510E2C0E1EA88C_2012479453;
                } //End block
                cursor = new ParserCursor(0, this.lineBuf.length());
                if(lineParser.hasProtocolVersion(this.lineBuf, cursor))                
                {
                    break;
                } //End block
                else
                if(i == -1 || count >= this.maxGarbageLines)                
                {
                    ProtocolException var56F68048747662B1A2EC94E4A8575C56_797716018 = new ProtocolException("The server failed to respond with a " +
                        "valid HTTP response");
                    var56F68048747662B1A2EC94E4A8575C56_797716018.addTaint(taint);
                    throw var56F68048747662B1A2EC94E4A8575C56_797716018;
                } //End block
                count++;
            } //End block
} while (true);
        StatusLine statusline = lineParser.parseStatusLine(this.lineBuf, cursor);
HttpMessage varFF4A03EE8787FE969C6D68F686A70D62_933814614 =         this.responseFactory.newHttpResponse(statusline, null);
        varFF4A03EE8787FE969C6D68F686A70D62_933814614.addTaint(taint);
        return varFF4A03EE8787FE969C6D68F686A70D62_933814614;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

