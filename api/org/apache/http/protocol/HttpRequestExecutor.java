package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.CoreProtocolPNames;

public class HttpRequestExecutor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.959 -0400", hash_original_method = "1B3D6EB0D2C9672C0490DD487A44B10E", hash_generated_method = "5C823C110E4C37030580A4ECF9EB10B9")
    public  HttpRequestExecutor() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.960 -0400", hash_original_method = "0630A8D079D2F2EA09859A2EAC923D24", hash_generated_method = "FDCD0C655CD9A917990B677B67B42261")
    protected boolean canResponseHaveBody(final HttpRequest request,
                                          final HttpResponse response) {
        addTaint(response.getTaint());
        addTaint(request.getTaint());
    if("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_213916256 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479941320 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479941320;
        } 
        int status = response.getStatusLine().getStatusCode();
        boolean varC715FE0F3FDA5C1A4EE77A8D9493A126_476092283 = (status >= HttpStatus.SC_OK 
            && status != HttpStatus.SC_NO_CONTENT 
            && status != HttpStatus.SC_NOT_MODIFIED
            && status != HttpStatus.SC_RESET_CONTENT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1528773101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1528773101;
        
        
            
        
        
        
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.961 -0400", hash_original_method = "119B944BAA4C5EE6E8AB8C1C74A61B19", hash_generated_method = "3DA72F165775A1B17FFCAC8430919578")
    public HttpResponse execute(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1331948594 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1331948594.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1331948594;
        } 
    if(conn == null)        
        {
            IllegalArgumentException var407669F9BB5BC8C81DD11AA5A9676948_2099854952 = new IllegalArgumentException("Client connection may not be null");
            var407669F9BB5BC8C81DD11AA5A9676948_2099854952.addTaint(taint);
            throw var407669F9BB5BC8C81DD11AA5A9676948_2099854952;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1018513390 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1018513390.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1018513390;
        } 
        try 
        {
            HttpResponse response = doSendRequest(request, conn, context);
    if(response == null)            
            {
                response = doReceiveResponse(request, conn, context);
            } 
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_324423264 =             response;
            var2A1114F4272D753FE23A36E3D68CD293_324423264.addTaint(taint);
            return var2A1114F4272D753FE23A36E3D68CD293_324423264;
        } 
        catch (IOException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } 
        catch (HttpException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } 
        catch (RuntimeException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.961 -0400", hash_original_method = "83559981E73A0A11E2E39D8FF1D4E53C", hash_generated_method = "81CC78D37F11B77EAC8DE108BFEA81C9")
    public void preProcess(
            final HttpRequest request,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(processor.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_793090670 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_793090670.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_793090670;
        } 
    if(processor == null)        
        {
            IllegalArgumentException varBE6F981A621D2588DCBAFD6F186E1351_210955307 = new IllegalArgumentException("HTTP processor may not be null");
            varBE6F981A621D2588DCBAFD6F186E1351_210955307.addTaint(taint);
            throw varBE6F981A621D2588DCBAFD6F186E1351_210955307;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1323225480 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1323225480.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1323225480;
        } 
        processor.process(request, context);
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.963 -0400", hash_original_method = "3A0BDE86F44AAAE489AB1403F9B488D7", hash_generated_method = "2B429DD196B0848DE294DD24550F47B6")
    protected HttpResponse doSendRequest(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1110389084 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1110389084.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1110389084;
        } 
    if(conn == null)        
        {
            IllegalArgumentException var6CFBC789236DE9A132EF716CA5496FB9_18076173 = new IllegalArgumentException("HTTP connection may not be null");
            var6CFBC789236DE9A132EF716CA5496FB9_18076173.addTaint(taint);
            throw var6CFBC789236DE9A132EF716CA5496FB9_18076173;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1200873933 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1200873933.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1200873933;
        } 
        HttpResponse response = null;
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.FALSE);
        conn.sendRequestHeader(request);
    if(request instanceof HttpEntityEnclosingRequest)        
        {
            boolean sendentity = true;
            final ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
    if(((HttpEntityEnclosingRequest) request).expectContinue() &&
                !ver.lessEquals(HttpVersion.HTTP_1_0))            
            {
                conn.flush();
                int tms = request.getParams().getIntParameter(
                        CoreProtocolPNames.WAIT_FOR_CONTINUE, 2000);
    if(conn.isResponseAvailable(tms))                
                {
                    response = conn.receiveResponseHeader();
    if(canResponseHaveBody(request, response))                    
                    {
                        conn.receiveResponseEntity(response);
                    } 
                    int status = response.getStatusLine().getStatusCode();
    if(status < 200)                    
                    {
    if(status != HttpStatus.SC_CONTINUE)                        
                        {
                            ProtocolException var9A30284AC6B7E9D346B26DB16996B6F5_154422095 = new ProtocolException(
                                    "Unexpected response: " + response.getStatusLine());
                            var9A30284AC6B7E9D346B26DB16996B6F5_154422095.addTaint(taint);
                            throw var9A30284AC6B7E9D346B26DB16996B6F5_154422095;
                        } 
                        response = null;
                    } 
                    else
                    {
                        sendentity = false;
                    } 
                } 
            } 
    if(sendentity)            
            {
                conn.sendRequestEntity((HttpEntityEnclosingRequest) request);
            } 
        } 
        conn.flush();
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.TRUE);
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_291393182 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_291393182.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_291393182;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.964 -0400", hash_original_method = "ACD44B1A55AB2BB7AB7058E66F36FB4A", hash_generated_method = "8A1A15221750C4A70426C07D69876838")
    protected HttpResponse doReceiveResponse(
            final HttpRequest          request,
            final HttpClientConnection conn,
            final HttpContext          context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1403011042 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1403011042.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1403011042;
        } 
    if(conn == null)        
        {
            IllegalArgumentException var6CFBC789236DE9A132EF716CA5496FB9_958292838 = new IllegalArgumentException("HTTP connection may not be null");
            var6CFBC789236DE9A132EF716CA5496FB9_958292838.addTaint(taint);
            throw var6CFBC789236DE9A132EF716CA5496FB9_958292838;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1810110659 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1810110659.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1810110659;
        } 
        HttpResponse response = null;
        int statuscode = 0;
        while
(response == null || statuscode < HttpStatus.SC_OK)        
        {
            response = conn.receiveResponseHeader();
    if(canResponseHaveBody(request, response))            
            {
                conn.receiveResponseEntity(response);
            } 
            statuscode = response.getStatusLine().getStatusCode();
        } 
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_557675637 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_557675637.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_557675637;
        
        
            
        
        
            
        
        
            
        
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.965 -0400", hash_original_method = "64184DC5B382438058CC5473730574C6", hash_generated_method = "B1BBC8B61DAE1C49E69DFBA499C9340C")
    public void postProcess(
            final HttpResponse response,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(processor.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_905787015 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_905787015.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_905787015;
        } 
    if(processor == null)        
        {
            IllegalArgumentException varBE6F981A621D2588DCBAFD6F186E1351_1071349283 = new IllegalArgumentException("HTTP processor may not be null");
            varBE6F981A621D2588DCBAFD6F186E1351_1071349283.addTaint(taint);
            throw varBE6F981A621D2588DCBAFD6F186E1351_1071349283;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1005973702 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1005973702.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1005973702;
        } 
        processor.process(response, context);
        
        
            
        
        
            
        
        
            
        
        
    }

    
}

