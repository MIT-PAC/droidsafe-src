package org.apache.http.impl.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.970 -0400", hash_original_method = "8B5512428A3E2CA95F49978B80962BF4", hash_generated_method = "E15DC0A74431A761CB5419BD189E5032")
    public  LaxContentLengthStrategy() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.973 -0400", hash_original_method = "41ED45EAF3AEC2DD673C6E2EB6E32552", hash_generated_method = "8EAD5C00B4B431198E7F7C84916E4C89")
    public long determineLength(final HttpMessage message) throws HttpException {
        addTaint(message.getTaint());
    if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_669560248 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_669560248.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_669560248;
        } 
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
            } 
            catch (ParseException px)
            {
                ProtocolException var5293FAAEB2A322031DD16C158A6FB942_890202145 = new ProtocolException
                    ("Invalid Transfer-Encoding header value: " +
                     transferEncodingHeader, px);
                var5293FAAEB2A322031DD16C158A6FB942_890202145.addTaint(taint);
                throw var5293FAAEB2A322031DD16C158A6FB942_890202145;
            } 
    if(strict)            
            {
for(int i = 0;i < encodings.length;i++)
                {
                    String encoding = encodings[i].getName();
    if(encoding != null && encoding.length() > 0 
                        && !encoding.equalsIgnoreCase(HTTP.CHUNK_CODING)
                        && !encoding.equalsIgnoreCase(HTTP.IDENTITY_CODING))                    
                    {
                        ProtocolException var62C1D95669BB3ADF698490CA3545339B_706062104 = new ProtocolException("Unsupported transfer encoding: " + encoding);
                        var62C1D95669BB3ADF698490CA3545339B_706062104.addTaint(taint);
                        throw var62C1D95669BB3ADF698490CA3545339B_706062104;
                    } 
                } 
            } 
            int len = encodings.length;
    if(HTTP.IDENTITY_CODING.equalsIgnoreCase(transferEncodingHeader.getValue()))            
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_23050679 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1314097401 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1314097401;
            } 
            else
    if((len > 0) && (HTTP.CHUNK_CODING.equalsIgnoreCase(
                    encodings[len - 1].getName())))            
            {
                long var8C237461BD8865ABF3E3806368E72D93_1042739911 = (CHUNKED);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_26010335 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_26010335;
            } 
            else
            {
    if(strict)                
                {
                    ProtocolException var8533BB4521A3FBD2752252682CE38595_730049 = new ProtocolException("Chunk-encoding must be the last one applied");
                    var8533BB4521A3FBD2752252682CE38595_730049.addTaint(taint);
                    throw var8533BB4521A3FBD2752252682CE38595_730049;
                } 
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_1999928109 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_251280694 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_251280694;
            } 
        } 
        else
    if(contentLengthHeader != null)        
        {
            long contentlen = -1;
            Header[] headers = message.getHeaders(HTTP.CONTENT_LEN);
    if(strict && headers.length > 1)            
            {
                ProtocolException var82294F5FA8D1F2F64F57F2E1C2B22E2A_714107897 = new ProtocolException("Multiple content length headers");
                var82294F5FA8D1F2F64F57F2E1C2B22E2A_714107897.addTaint(taint);
                throw var82294F5FA8D1F2F64F57F2E1C2B22E2A_714107897;
            } 
for(int i = headers.length - 1;i >= 0;i--)
            {
                Header header = headers[i];
                try 
                {
                    contentlen = Long.parseLong(header.getValue());
                    break;
                } 
                catch (NumberFormatException e)
                {
    if(strict)                    
                    {
                        ProtocolException var9F3FB3912860E4C007593E745EADAB2E_1120083081 = new ProtocolException("Invalid content length: " + header.getValue());
                        var9F3FB3912860E4C007593E745EADAB2E_1120083081.addTaint(taint);
                        throw var9F3FB3912860E4C007593E745EADAB2E_1120083081;
                    } 
                } 
            } 
    if(contentlen >= 0)            
            {
                long varCB93A9937843A987DEAF858742557F95_356947211 = (contentlen);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_655191695 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_655191695;
            } 
            else
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_340278560 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1165672276 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1165672276;
            } 
        } 
        else
        {
            long varD8156D3C6735D75D8A1B8DEDD0E79C8B_1336792009 = (IDENTITY);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_455592128 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_455592128;
        } 
        
        
    }

    
}

