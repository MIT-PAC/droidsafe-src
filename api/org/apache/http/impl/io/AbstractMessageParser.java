package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.BasicLineParser;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageParser implements HttpMessageParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.026 -0400", hash_original_field = "C5C1A1B9CB00AE65F16C20243BC76E0D", hash_generated_field = "A33B1C99D4B1A85FF593937CE103B3DB")

    private SessionInputBuffer sessionBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.026 -0400", hash_original_field = "9E79D1C5118BFD93F2EA3354BE3B7BB3", hash_generated_field = "51B3B1D6F029892B5D1B485F1E8449D4")

    private int maxHeaderCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.026 -0400", hash_original_field = "3609DB2A96EDAA41922B8FF957E1AC22", hash_generated_field = "8BE013DE7B241F7CDF197195794AF2BA")

    private int maxLineLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.027 -0400", hash_original_field = "3BFFA82D6F37731C10E9CEDA46F669D0", hash_generated_field = "FA36EAE3CC325D535A91E6794A3FA61E")

    protected LineParser lineParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.028 -0400", hash_original_method = "CD9F7BFE0207530C59E31A12BA61FD32", hash_generated_method = "B85B769F0053742F99B6151B80471CF8")
    public  AbstractMessageParser(
            final SessionInputBuffer buffer,
            final LineParser parser,
            final HttpParams params) {
        super();
    if(buffer == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_314006414 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_314006414.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_314006414;
        } 
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1345721087 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1345721087.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1345721087;
        } 
        this.sessionBuffer = buffer;
        this.maxHeaderCount = params.getIntParameter(
                CoreConnectionPNames.MAX_HEADER_COUNT, -1);
        this.maxLineLen = params.getIntParameter(
                CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.lineParser = (parser != null) ? parser : BasicLineParser.DEFAULT;
        
        
            
        
        
            
        
        
        
                
        
                
        
    }

    
        public static Header[] parseHeaders(
            final SessionInputBuffer inbuffer,
            int maxHeaderCount,
            int maxLineLen,
            LineParser parser) throws HttpException, IOException {
        if (inbuffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;
        ArrayList headerLines = new ArrayList();
        CharArrayBuffer current = null;
        CharArrayBuffer previous = null;
        for (;;) {
            if (current == null) {
                current = new CharArrayBuffer(64);
            } else {
                current.clear();
            }
            int l = inbuffer.readLine(current);
            if (l == -1 || current.length() < 1) {
                break;
            }
            if ((current.charAt(0) == ' ' || current.charAt(0) == '\t') && previous != null) {
                int i = 0;
                while (i < current.length()) {
                    char ch = current.charAt(i);
                    if (ch != ' ' && ch != '\t') {
                        break;
                    }
                    i++;
                }
                if (maxLineLen > 0 
                        && previous.length() + 1 + current.length() - i > maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
                previous.append(' ');
                previous.append(current, i, current.length() - i);
            } else {
                headerLines.add(current);
                previous = current;
                current = null;
            }
            if (maxHeaderCount > 0 && headerLines.size() >= maxHeaderCount) {
                throw new IOException("Maximum header count exceeded");
            }
        }
        Header[] headers = new Header[headerLines.size()];
        for (int i = 0; i < headerLines.size(); i++) {
            CharArrayBuffer buffer = (CharArrayBuffer) headerLines.get(i);
            try {
                headers[i] = parser.parseHeader(buffer);
            } catch (ParseException ex) {
                throw new ProtocolException(ex.getMessage());
            }
        }
        return headers;
    }

    
    protected abstract HttpMessage parseHead(SessionInputBuffer sessionBuffer) 
        throws IOException, HttpException, ParseException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.029 -0400", hash_original_method = "56FD9FE99CC7B8784E50CC19E304C067", hash_generated_method = "2F15D69C0B1179A30C5C0EEBEDA61F53")
    public HttpMessage parse() throws IOException, HttpException {
        HttpMessage message = null;
        try 
        {
            message = parseHead(this.sessionBuffer);
        } 
        catch (ParseException px)
        {
            ProtocolException varD95A16F7A42FB78AC45970093BB1D826_77002380 = new ProtocolException(px.getMessage(), px);
            varD95A16F7A42FB78AC45970093BB1D826_77002380.addTaint(taint);
            throw varD95A16F7A42FB78AC45970093BB1D826_77002380;
        } 
        Header[] headers = AbstractMessageParser.parseHeaders(
                this.sessionBuffer, 
                this.maxHeaderCount,
                this.maxLineLen,
                this.lineParser);
        message.setHeaders(headers);
HttpMessage varFD182D7074F3848E773A38B067BBB880_477225068 =         message;
        varFD182D7074F3848E773A38B067BBB880_477225068.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_477225068;
        
        
        
            
        
            
        
        
                
                
                
                
        
        
    }

    
}

