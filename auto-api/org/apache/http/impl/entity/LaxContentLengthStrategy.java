package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.params.HttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HTTP;

public class LaxContentLengthStrategy implements ContentLengthStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.622 -0400", hash_original_method = "8B5512428A3E2CA95F49978B80962BF4", hash_generated_method = "E15DC0A74431A761CB5419BD189E5032")
    public  LaxContentLengthStrategy() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.623 -0400", hash_original_method = "41ED45EAF3AEC2DD673C6E2EB6E32552", hash_generated_method = "EF672DB8DC7665801B8FA347E898666A")
    public long determineLength(final HttpMessage message) throws HttpException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } //End block
        HttpParams params;
        params = message.getParams();
        boolean strict;
        strict = params.isParameterTrue(CoreProtocolPNames.STRICT_TRANSFER_ENCODING);
        Header transferEncodingHeader;
        transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader;
        contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
        {
            HeaderElement[] encodings;
            encodings = null;
            try 
            {
                encodings = transferEncodingHeader.getElements();
            } //End block
            catch (ParseException px)
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException
                    ("Invalid Transfer-Encoding header value: " +
                     transferEncodingHeader, px);
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        String encoding;
                        encoding = encodings[i].getName();
                        {
                            boolean var69706BB13B7609376409D4245F18C85D_1937019899 = (encoding != null && encoding.length() > 0 
                        && !encoding.equalsIgnoreCase(HTTP.CHUNK_CODING)
                        && !encoding.equalsIgnoreCase(HTTP.IDENTITY_CODING));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Unsupported transfer encoding: " + encoding);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int len;
            len = encodings.length;
            {
                boolean var2F568F79C173BB7064045C081F5F11B3_1845331494 = (HTTP.IDENTITY_CODING.equalsIgnoreCase(transferEncodingHeader.getValue()));
                {
                    boolean var3BDC41E872095DEF19F59987F82C46D0_2084564582 = ((len > 0) && (HTTP.CHUNK_CODING.equalsIgnoreCase(
                    encodings[len - 1].getName())));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Chunk-encoding must be the last one applied");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            long contentlen;
            contentlen = -1;
            Header[] headers;
            headers = message.getHeaders(HTTP.CONTENT_LEN);
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Multiple content length headers");
            } //End block
            {
                int i;
                i = headers.length - 1;
                {
                    Header header;
                    header = headers[i];
                    try 
                    {
                        contentlen = Long.parseLong(header.getValue());
                    } //End block
                    catch (NumberFormatException e)
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid content length: " + header.getValue());
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(message.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_705737695 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_705737695;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

