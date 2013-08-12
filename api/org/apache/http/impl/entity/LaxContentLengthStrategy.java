package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;



public class LaxContentLengthStrategy implements ContentLengthStrategy {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.331 -0400", hash_original_method = "8B5512428A3E2CA95F49978B80962BF4", hash_generated_method = "E15DC0A74431A761CB5419BD189E5032")
    public  LaxContentLengthStrategy() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.333 -0400", hash_original_method = "41ED45EAF3AEC2DD673C6E2EB6E32552", hash_generated_method = "E588C6A3391D042FFD2C0C41257C34AD")
    public long determineLength(final HttpMessage message) throws HttpException {
        addTaint(message.getTaint());
        if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_90929236 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_90929236.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_90929236;
        } //End block
        HttpParams params = message.getParams();
        boolean strict = params.isParameterTrue(CoreProtocolPNames.STRICT_TRANSFER_ENCODING);
        Header transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
        if(transferEncodingHeader != null)        
        {
            HeaderElement[] encodings = null;
            try 
            {
                encodings = transferEncodingHeader.getElements();
            } //End block
            catch (ParseException px)
            {
                ProtocolException var5293FAAEB2A322031DD16C158A6FB942_596612226 = new ProtocolException
                    ("Invalid Transfer-Encoding header value: " +
                     transferEncodingHeader, px);
                var5293FAAEB2A322031DD16C158A6FB942_596612226.addTaint(taint);
                throw var5293FAAEB2A322031DD16C158A6FB942_596612226;
            } //End block
            if(strict)            
            {
for(int i = 0;i < encodings.length;i++)
                {
                    String encoding = encodings[i].getName();
                    if(encoding != null && encoding.length() > 0 
                        && !encoding.equalsIgnoreCase(HTTP.CHUNK_CODING)
                        && !encoding.equalsIgnoreCase(HTTP.IDENTITY_CODING))                    
                    {
                        ProtocolException var62C1D95669BB3ADF698490CA3545339B_792209048 = new ProtocolException("Unsupported transfer encoding: " + encoding);
                        var62C1D95669BB3ADF698490CA3545339B_792209048.addTaint(taint);
                        throw var62C1D95669BB3ADF698490CA3545339B_792209048;
                    } //End block
                } //End block
            } //End block
            int len = encodings.length;
            if(HTTP.IDENTITY_CODING.equalsIgnoreCase(transferEncodingHeader.getValue()))            
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_1644642263 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1558891940 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1558891940;
            } //End block
            else
            if((len > 0) && (HTTP.CHUNK_CODING.equalsIgnoreCase(
                    encodings[len - 1].getName())))            
            {
                long var8C237461BD8865ABF3E3806368E72D93_940963851 = (CHUNKED);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_869923365 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_869923365;
            } //End block
            else
            {
                if(strict)                
                {
                    ProtocolException var8533BB4521A3FBD2752252682CE38595_1480171173 = new ProtocolException("Chunk-encoding must be the last one applied");
                    var8533BB4521A3FBD2752252682CE38595_1480171173.addTaint(taint);
                    throw var8533BB4521A3FBD2752252682CE38595_1480171173;
                } //End block
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_1301501374 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1937338789 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1937338789;
            } //End block
        } //End block
        else
        if(contentLengthHeader != null)        
        {
            long contentlen = -1;
            Header[] headers = message.getHeaders(HTTP.CONTENT_LEN);
            if(strict && headers.length > 1)            
            {
                ProtocolException var82294F5FA8D1F2F64F57F2E1C2B22E2A_1026247177 = new ProtocolException("Multiple content length headers");
                var82294F5FA8D1F2F64F57F2E1C2B22E2A_1026247177.addTaint(taint);
                throw var82294F5FA8D1F2F64F57F2E1C2B22E2A_1026247177;
            } //End block
for(int i = headers.length - 1;i >= 0;i--)
            {
                Header header = headers[i];
                try 
                {
                    contentlen = Long.parseLong(header.getValue());
                    break;
                } //End block
                catch (NumberFormatException e)
                {
                    if(strict)                    
                    {
                        ProtocolException var9F3FB3912860E4C007593E745EADAB2E_1111713930 = new ProtocolException("Invalid content length: " + header.getValue());
                        var9F3FB3912860E4C007593E745EADAB2E_1111713930.addTaint(taint);
                        throw var9F3FB3912860E4C007593E745EADAB2E_1111713930;
                    } //End block
                } //End block
            } //End block
            if(contentlen >= 0)            
            {
                long varCB93A9937843A987DEAF858742557F95_332391273 = (contentlen);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_434817902 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_434817902;
            } //End block
            else
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_708079987 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_966661013 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_966661013;
            } //End block
        } //End block
        else
        {
            long varD8156D3C6735D75D8A1B8DEDD0E79C8B_181658249 = (IDENTITY);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_785428087 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_785428087;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

