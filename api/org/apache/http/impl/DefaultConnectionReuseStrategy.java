package org.apache.http.impl;

// Droidsafe Imports
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import droidsafe.annotations.DSGenerator;

public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.325 -0400", hash_original_method = "34BE1FD46571091C81AAB19A83E6EA86", hash_generated_method = "9D0BE0C2898A2879319237A6A59EF44E")
    public  DefaultConnectionReuseStrategy() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.326 -0400", hash_original_method = "99701CE5AD38D49B49A62B2892241655", hash_generated_method = "E4974C9B5AC2AAD69899FB78799E465B")
    public boolean keepAlive(final HttpResponse response,
                             final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException varB7989C0E76C3AA33A02D57EF4B84FB41_406763264 = new IllegalArgumentException
                ("HTTP response may not be null.");
            varB7989C0E76C3AA33A02D57EF4B84FB41_406763264.addTaint(taint);
            throw varB7989C0E76C3AA33A02D57EF4B84FB41_406763264;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var40B06E88E14F43D9710E858AC173D5D2_2136753177 = new IllegalArgumentException
                ("HTTP context may not be null.");
            var40B06E88E14F43D9710E858AC173D5D2_2136753177.addTaint(taint);
            throw var40B06E88E14F43D9710E858AC173D5D2_2136753177;
        } //End block
        HttpConnection conn = (HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        if(conn != null && !conn.isOpen())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1027716441 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134612878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134612878;
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
                    boolean var68934A3E9455FA72420237EB05902327_746856566 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442156890 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442156890;
                } //End block
            } //End block
        } //End block
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
                        boolean var68934A3E9455FA72420237EB05902327_1489245936 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078455090 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078455090;
                    } //End block
                    else
                    if(HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token))                    
                    {
                        keepalive = true;
                    } //End block
                } //End block
                if(keepalive)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_676523066 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779623522 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_779623522;
                }
            } //End block
            catch (ParseException px)
            {
                boolean var68934A3E9455FA72420237EB05902327_1410535225 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965673155 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_965673155;
            } //End block
        } //End block
        boolean varD7433EC039027871EB92428F9FFCA1CC_494754026 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972789806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972789806;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.327 -0400", hash_original_method = "EFAD97F429DE8DB8F9E4AB7241876CEE", hash_generated_method = "7DCD393063CBF077761E5FB5C8B60F37")
    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        addTaint(hit.getTaint());
TokenIterator varDCCA97667C2D3AEA0FD9A2C43074DB8C_1810984350 =         new BasicTokenIterator(hit);
        varDCCA97667C2D3AEA0FD9A2C43074DB8C_1810984350.addTaint(taint);
        return varDCCA97667C2D3AEA0FD9A2C43074DB8C_1810984350;
        // ---------- Original Method ----------
        //return new BasicTokenIterator(hit);
    }

    
}

