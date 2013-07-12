package org.apache.http.impl.entity;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.996 -0400", hash_original_method = "A65C37571E3ECC9A929C203280BB89E8", hash_generated_method = "D45C93F906D0EA835886288481D205FA")
    public  StrictContentLengthStrategy() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.998 -0400", hash_original_method = "27CE2D4FD8280195B6E05E2B487DF036", hash_generated_method = "CE10E0938895394FDBE4A6819A56D0E4")
    public long determineLength(final HttpMessage message) throws HttpException {
        addTaint(message.getTaint());
    if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_847989078 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_847989078.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_847989078;
        } 
        Header transferEncodingHeader = message.getFirstHeader(HTTP.TRANSFER_ENCODING);
        Header contentLengthHeader = message.getFirstHeader(HTTP.CONTENT_LEN);
    if(transferEncodingHeader != null)        
        {
            String s = transferEncodingHeader.getValue();
    if(HTTP.CHUNK_CODING.equalsIgnoreCase(s))            
            {
    if(message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0))                
                {
                    ProtocolException var0BF481110DD3D11FA49D5D376F3BAC7C_999089037 = new ProtocolException(
                            "Chunked transfer encoding not allowed for " + 
                            message.getProtocolVersion());
                    var0BF481110DD3D11FA49D5D376F3BAC7C_999089037.addTaint(taint);
                    throw var0BF481110DD3D11FA49D5D376F3BAC7C_999089037;
                } 
                long var8C237461BD8865ABF3E3806368E72D93_109666194 = (CHUNKED);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1427066063 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1427066063;
            } 
            else
    if(HTTP.IDENTITY_CODING.equalsIgnoreCase(s))            
            {
                long varD8156D3C6735D75D8A1B8DEDD0E79C8B_275374421 = (IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1807583998 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1807583998;
            } 
            else
            {
                ProtocolException varE21A04867FF0895DA982B4D073A68FB9_2075880979 = new ProtocolException(
                        "Unsupported transfer encoding: " + s);
                varE21A04867FF0895DA982B4D073A68FB9_2075880979.addTaint(taint);
                throw varE21A04867FF0895DA982B4D073A68FB9_2075880979;
            } 
        } 
        else
    if(contentLengthHeader != null)        
        {
            String s = contentLengthHeader.getValue();
            try 
            {
                long len = Long.parseLong(s);
                long varF5A8E923F8CD24B56B3BAB32358CC58A_1557785258 = (len);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1635463442 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1635463442;
            } 
            catch (NumberFormatException e)
            {
                ProtocolException var0749D41409A4CDC04BA9434826D9C007_279786795 = new ProtocolException("Invalid content length: " + s);
                var0749D41409A4CDC04BA9434826D9C007_279786795.addTaint(taint);
                throw var0749D41409A4CDC04BA9434826D9C007_279786795;
            } 
        } 
        else
        {
            long varD8156D3C6735D75D8A1B8DEDD0E79C8B_984513871 = (IDENTITY);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1497043883 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1497043883;
        } 
        
        
    }

    
}

