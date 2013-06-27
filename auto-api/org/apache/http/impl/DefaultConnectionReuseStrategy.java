package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.938 -0400", hash_original_method = "34BE1FD46571091C81AAB19A83E6EA86", hash_generated_method = "9D0BE0C2898A2879319237A6A59EF44E")
    public  DefaultConnectionReuseStrategy() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.950 -0400", hash_original_method = "99701CE5AD38D49B49A62B2892241655", hash_generated_method = "53906FE6F9648A383B8D4B930F61CA78")
    public boolean keepAlive(final HttpResponse response,
                             final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP response may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP context may not be null.");
        } //End block
        HttpConnection conn;
        conn = (HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        {
            boolean var3F09B4DA4021A00B0E0E85A7A98C2EF2_1640476105 = (conn != null && !conn.isOpen());
        } //End collapsed parenthetic
        HttpEntity entity;
        entity = response.getEntity();
        ProtocolVersion ver;
        ver = response.getStatusLine().getProtocolVersion();
        {
            {
                boolean varD4D0AAD58097CCD39F1ACA1D9158C81F_1620820134 = (entity.getContentLength() < 0);
                {
                    {
                        boolean varC2F0501924F6F7E7590E1CED020FA344_332709808 = (!entity.isChunked() ||
                    ver.lessEquals(HttpVersion.HTTP_1_0));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        HeaderIterator hit;
        hit = response.headerIterator(HTTP.CONN_DIRECTIVE);
        {
            boolean varB62678A9216DB888D7A953146D726E3D_748485723 = (!hit.hasNext());
            hit = response.headerIterator("Proxy-Connection");
        } //End collapsed parenthetic
        {
            boolean var4C12C71F85CFF6191436B849F85B7DAA_1816594563 = (hit.hasNext());
            {
                try 
                {
                    TokenIterator ti;
                    ti = createTokenIterator(hit);
                    boolean keepalive;
                    keepalive = false;
                    {
                        boolean var8E7664A820B63620CE275738BD741579_2063623603 = (ti.hasNext());
                        {
                            String token;
                            token = ti.nextToken();
                            {
                                boolean var3DBF486233962B0413FF7C729681DA39_1042782335 = (HTTP.CONN_CLOSE.equalsIgnoreCase(token));
                                {
                                    boolean varB558070B36A52344FEB0BCCC60FCB3C4_651189894 = (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token));
                                    {
                                        keepalive = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (ParseException px)
                { }
            } //End block
        } //End collapsed parenthetic
        boolean varE7C0AF165CB1162AB0C6BED102DEE29E_1343070088 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913823687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913823687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.951 -0400", hash_original_method = "EFAD97F429DE8DB8F9E4AB7241876CEE", hash_generated_method = "A63581F6E52C59FE462BD37FA6DDCD34")
    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        TokenIterator varB4EAC82CA7396A68D541C85D26508E83_200280511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_200280511 = new BasicTokenIterator(hit);
        addTaint(hit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_200280511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200280511;
        // ---------- Original Method ----------
        //return new BasicTokenIterator(hit);
    }

    
}

