package org.apache.http.client.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.protocol.HttpContext;

public class RequestDefaultHeaders implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.247 -0400", hash_original_method = "A692411AA68D5698704806EAFB0D6447", hash_generated_method = "BC9A54616EA56C3FB9CBB65BD3CE817E")
    public  RequestDefaultHeaders() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.247 -0400", hash_original_method = "BC6D4315FE478105CC299FA29DDE20AF", hash_generated_method = "22E8F5A84C462058C94F4862D68CD85E")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1065650527 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1065650527.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1065650527;
        } 
        Collection<?> defHeaders = (Collection<?>) request.getParams().getParameter(
                ClientPNames.DEFAULT_HEADERS);
    if(defHeaders != null)        
        {
for(Object defHeader : defHeaders)
            {
                request.addHeader((Header) defHeader);
            } 
        } 
        
        
            
        
        
                
        
            
                
            
        
    }

    
}

