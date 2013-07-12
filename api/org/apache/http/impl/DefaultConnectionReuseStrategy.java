package org.apache.http.impl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpConnection;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;

public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.008 -0400", hash_original_method = "34BE1FD46571091C81AAB19A83E6EA86", hash_generated_method = "9D0BE0C2898A2879319237A6A59EF44E")
    public  DefaultConnectionReuseStrategy() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.009 -0400", hash_original_method = "99701CE5AD38D49B49A62B2892241655", hash_generated_method = "021799DC6612BDB222AC10C7A977A40B")
    public boolean keepAlive(final HttpResponse response,
                             final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException varB7989C0E76C3AA33A02D57EF4B84FB41_975971597 = new IllegalArgumentException
                ("HTTP response may not be null.");
            varB7989C0E76C3AA33A02D57EF4B84FB41_975971597.addTaint(taint);
            throw varB7989C0E76C3AA33A02D57EF4B84FB41_975971597;
        } 
    if(context == null)        
        {
            IllegalArgumentException var40B06E88E14F43D9710E858AC173D5D2_1560121743 = new IllegalArgumentException
                ("HTTP context may not be null.");
            var40B06E88E14F43D9710E858AC173D5D2_1560121743.addTaint(taint);
            throw var40B06E88E14F43D9710E858AC173D5D2_1560121743;
        } 
        HttpConnection conn = (HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
    if(conn != null && !conn.isOpen())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1895304471 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748516106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748516106;
        }
        HttpEntity entity = response.getEntity();
        ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
    if(entity != null)        
        {
    if(entity.getContentLength() < 0)            
            {
    if(!entity.isChunked() ||
                    ver.lessEquals(HttpVersion.HTTP_1_0))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1210073840 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679964028 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679964028;
                } 
            } 
        } 
        HeaderIterator hit = response.headerIterator(HTTP.CONN_DIRECTIVE);
    if(!hit.hasNext())        
        hit = response.headerIterator("Proxy-Connection");
    if(hit.hasNext())        
        {
            try 
            {
                TokenIterator ti = createTokenIterator(hit);
                boolean keepalive = false;
                while
(ti.hasNext())                
                {
                    final String token = ti.nextToken();
    if(HTTP.CONN_CLOSE.equalsIgnoreCase(token))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_272608301 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386033420 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386033420;
                    } 
                    else
    if(HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token))                    
                    {
                        keepalive = true;
                    } 
                } 
    if(keepalive)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1726727081 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849889347 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849889347;
                }
            } 
            catch (ParseException px)
            {
                boolean var68934A3E9455FA72420237EB05902327_1294514757 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369529052 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_369529052;
            } 
        } 
        boolean varD7433EC039027871EB92428F9FFCA1CC_1610740725 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448296309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448296309;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.009 -0400", hash_original_method = "EFAD97F429DE8DB8F9E4AB7241876CEE", hash_generated_method = "B1CF4A51175B6794182EFB647DBB790C")
    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        addTaint(hit.getTaint());
TokenIterator varDCCA97667C2D3AEA0FD9A2C43074DB8C_1020553826 =         new BasicTokenIterator(hit);
        varDCCA97667C2D3AEA0FD9A2C43074DB8C_1020553826.addTaint(taint);
        return varDCCA97667C2D3AEA0FD9A2C43074DB8C_1020553826;
        
        
    }

    
}

