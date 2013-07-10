package org.apache.http.impl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.687 -0400", hash_original_method = "34BE1FD46571091C81AAB19A83E6EA86", hash_generated_method = "9D0BE0C2898A2879319237A6A59EF44E")
    public  DefaultConnectionReuseStrategy() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.689 -0400", hash_original_method = "99701CE5AD38D49B49A62B2892241655", hash_generated_method = "453BEB9001236373A1AE78FB4ABA0EB7")
    public boolean keepAlive(final HttpResponse response,
                             final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP response may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP context may not be null.");
        } 
        HttpConnection conn = (HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        {
            boolean var3F09B4DA4021A00B0E0E85A7A98C2EF2_2060246656 = (conn != null && !conn.isOpen());
        } 
        HttpEntity entity = response.getEntity();
        ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
        {
            {
                boolean varD4D0AAD58097CCD39F1ACA1D9158C81F_390667643 = (entity.getContentLength() < 0);
                {
                    {
                        boolean varC2F0501924F6F7E7590E1CED020FA344_1998589039 = (!entity.isChunked() ||
                    ver.lessEquals(HttpVersion.HTTP_1_0));
                    } 
                } 
            } 
        } 
        HeaderIterator hit = response.headerIterator(HTTP.CONN_DIRECTIVE);
        {
            boolean varB62678A9216DB888D7A953146D726E3D_1461044124 = (!hit.hasNext());
            hit = response.headerIterator("Proxy-Connection");
        } 
        {
            boolean var4C12C71F85CFF6191436B849F85B7DAA_848305387 = (hit.hasNext());
            {
                try 
                {
                    TokenIterator ti = createTokenIterator(hit);
                    boolean keepalive = false;
                    {
                        boolean var8E7664A820B63620CE275738BD741579_386043211 = (ti.hasNext());
                        {
                            final String token = ti.nextToken();
                            {
                                boolean var3DBF486233962B0413FF7C729681DA39_530018105 = (HTTP.CONN_CLOSE.equalsIgnoreCase(token));
                                {
                                    boolean varB558070B36A52344FEB0BCCC60FCB3C4_965918808 = (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token));
                                    {
                                        keepalive = true;
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                catch (ParseException px)
                { }
            } 
        } 
        boolean varE7C0AF165CB1162AB0C6BED102DEE29E_951207942 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216236992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216236992;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.690 -0400", hash_original_method = "EFAD97F429DE8DB8F9E4AB7241876CEE", hash_generated_method = "D00A0656DCDEA27D64C1F485B6EEEF7A")
    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        TokenIterator varB4EAC82CA7396A68D541C85D26508E83_1897685489 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1897685489 = new BasicTokenIterator(hit);
        addTaint(hit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1897685489.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1897685489;
        
        
    }

    
}

