package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;

public class StrictContentLengthStrategy implements ContentLengthStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.341 -0400", hash_original_method = "A65C37571E3ECC9A929C203280BB89E8", hash_generated_method = "D45C93F906D0EA835886288481D205FA")
    public  StrictContentLengthStrategy() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.342 -0400", hash_original_method = "27CE2D4FD8280195B6E05E2B487DF036", hash_generated_method = "5264E4969818E5390D7EC8DB0CE9CB6E")
    public long determineLength(final HttpMessage message) throws HttpException {
        addTaint(message.getTaint());
        if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_1677411493 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_1677411493.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_1677411493;
        } //End block
        Header transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
        if(transferEncodingHeader != null)        
        {
            String s = transferEncodingHeader.getValue();
            if(HTTP.CHUNK_CODING.equalsIgnoreCase(s))            
            {
                if(message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0))                
                {
                    ProtocolException var0BF481110DD3D11FA49D5D376F3BAC7C_183798201 = new ProtocolException(
                            "Chunked transfer encoding not allowed for " + 
                            message.getProtocolVersion());
                    var0BF481110DD3D11FA49D5D376F3BAC7C_183798201.addTaint(taint);
                    throw var0BF481110DD3D11FA49D5D376F3BAC7C_183798201;
                } //End block
                long var8C237461BD8865ABF3E3806368E72D93_924501735 = (CHUNKED);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1972316487 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1972316487;
            } //End block
            else
            if(HTTP.IDENTITY_CODING.equalsIgnoreCase(s))            
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_1741985833 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1159551172 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1159551172;
            } //End block
            else
            {
                ProtocolException varE21A04867FF0895DA982B4D073A68FB9_1038429306 = new ProtocolException(
                        "Unsupported transfer encoding: " + s);
                varE21A04867FF0895DA982B4D073A68FB9_1038429306.addTaint(taint);
                throw varE21A04867FF0895DA982B4D073A68FB9_1038429306;
            } //End block
        } //End block
        else
        if(contentLengthHeader != null)        
        {
            String s = contentLengthHeader.getValue();
            try 
            {
                long len = Long.parseLong(s);
                long varF5A8E923F8CD24B56B3BAB32358CC58A_1852052040 = (len);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_2118995876 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_2118995876;
            } //End block
            catch (NumberFormatException e)
            {
                ProtocolException var0749D41409A4CDC04BA9434826D9C007_1837865934 = new ProtocolException("Invalid content length: " + s);
                var0749D41409A4CDC04BA9434826D9C007_1837865934.addTaint(taint);
                throw var0749D41409A4CDC04BA9434826D9C007_1837865934;
            } //End block
        } //End block
        else
        {
            long varD8156D3C6735D75D8A1B8DEDD0E79C8B_506250112 = (IDENTITY);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1978564552 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1978564552;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

