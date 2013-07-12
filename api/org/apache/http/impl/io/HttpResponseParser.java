package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.ParseException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public class HttpResponseParser extends AbstractMessageParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.206 -0400", hash_original_field = "231DD88D1D24FBAC95F5FF27F7E132D5", hash_generated_field = "617CD99CE3703350A89163AF27F85CC2")

    private HttpResponseFactory responseFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.207 -0400", hash_original_field = "DD77BBE950DCBAAE75A78BE6835B370C", hash_generated_field = "138A98BD7AF16A46911F2E280FBA40A5")

    private CharArrayBuffer lineBuf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.207 -0400", hash_original_method = "85B3567407021E0E58042A3E368512FA", hash_generated_method = "DDE9714ADDFE525F2D7EBE8F5B10D4B1")
    public  HttpResponseParser(
            final SessionInputBuffer buffer,
            final LineParser parser,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        super(buffer, parser, params);
        addTaint(params.getTaint());
        addTaint(parser.getTaint());
        addTaint(buffer.getTaint());
    if(responseFactory == null)        
        {
            IllegalArgumentException var4DE4C2B8B51C37D4C049343CDF1871A3_711428915 = new IllegalArgumentException("Response factory may not be null");
            var4DE4C2B8B51C37D4C049343CDF1871A3_711428915.addTaint(taint);
            throw var4DE4C2B8B51C37D4C049343CDF1871A3_711428915;
        } 
        this.responseFactory = responseFactory;
        this.lineBuf = new CharArrayBuffer(128);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.208 -0400", hash_original_method = "3017F26D59D622B6AFE8D24C9E35B44D", hash_generated_method = "F6457FAA4D0958D241D17FAD30DE8EE4")
    protected HttpMessage parseHead(
            final SessionInputBuffer sessionBuffer) throws IOException, HttpException, ParseException {
        addTaint(sessionBuffer.getTaint());
        this.lineBuf.clear();
        int i = sessionBuffer.readLine(this.lineBuf);
    if(i == -1)        
        {
            NoHttpResponseException var8E6E6A11E770AF132B510E2C0E1EA88C_1890209473 = new NoHttpResponseException("The target server failed to respond");
            var8E6E6A11E770AF132B510E2C0E1EA88C_1890209473.addTaint(taint);
            throw var8E6E6A11E770AF132B510E2C0E1EA88C_1890209473;
        } 
        ParserCursor cursor = new ParserCursor(0, this.lineBuf.length());
        StatusLine statusline = lineParser.parseStatusLine(this.lineBuf, cursor);
HttpMessage varFF4A03EE8787FE969C6D68F686A70D62_174530077 =         this.responseFactory.newHttpResponse(statusline, null);
        varFF4A03EE8787FE969C6D68F686A70D62_174530077.addTaint(taint);
        return varFF4A03EE8787FE969C6D68F686A70D62_174530077;
        
        
        
        
            
        
        
        
        
    }

    
}

