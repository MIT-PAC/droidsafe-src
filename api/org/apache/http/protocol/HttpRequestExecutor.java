package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.341 -0400", hash_original_method = "1B3D6EB0D2C9672C0490DD487A44B10E", hash_generated_method = "5C823C110E4C37030580A4ECF9EB10B9")
    public  HttpRequestExecutor() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.342 -0400", hash_original_method = "0630A8D079D2F2EA09859A2EAC923D24", hash_generated_method = "19E5F3DFB28F335C25D2477AFC86FD9D")
    protected boolean canResponseHaveBody(final HttpRequest request,
                                          final HttpResponse response) {
        addTaint(response.getTaint());
        addTaint(request.getTaint());
        if("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1219645896 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874036828 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874036828;
        } //End block
        int status = response.getStatusLine().getStatusCode();
        boolean varC715FE0F3FDA5C1A4EE77A8D9493A126_2008176731 = (status >= HttpStatus.SC_OK 
            && status != HttpStatus.SC_NO_CONTENT 
            && status != HttpStatus.SC_NOT_MODIFIED
            && status != HttpStatus.SC_RESET_CONTENT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113256060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113256060;
        // ---------- Original Method ----------
        //if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
            //return false;
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status >= HttpStatus.SC_OK 
            //&& status != HttpStatus.SC_NO_CONTENT 
            //&& status != HttpStatus.SC_NOT_MODIFIED
            //&& status != HttpStatus.SC_RESET_CONTENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.342 -0400", hash_original_method = "119B944BAA4C5EE6E8AB8C1C74A61B19", hash_generated_method = "03683FA87AADDBC1B9041DB942FE5E01")
    public HttpResponse execute(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1583071716 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1583071716.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1583071716;
        } //End block
        if(conn == null)        
        {
            IllegalArgumentException var407669F9BB5BC8C81DD11AA5A9676948_568084484 = new IllegalArgumentException("Client connection may not be null");
            var407669F9BB5BC8C81DD11AA5A9676948_568084484.addTaint(taint);
            throw var407669F9BB5BC8C81DD11AA5A9676948_568084484;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1576448384 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1576448384.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1576448384;
        } //End block
        try 
        {
            HttpResponse response = doSendRequest(request, conn, context);
            if(response == null)            
            {
                response = doReceiveResponse(request, conn, context);
            } //End block
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_2089263908 =             response;
            var2A1114F4272D753FE23A36E3D68CD293_2089263908.addTaint(taint);
            return var2A1114F4272D753FE23A36E3D68CD293_2089263908;
        } //End block
        catch (IOException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (HttpException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            conn.close();
            ex.addTaint(taint);
            throw ex;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.343 -0400", hash_original_method = "83559981E73A0A11E2E39D8FF1D4E53C", hash_generated_method = "D400CB672C356B673A793E894EF3F09F")
    public void preProcess(
            final HttpRequest request,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(processor.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1446859714 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1446859714.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1446859714;
        } //End block
        if(processor == null)        
        {
            IllegalArgumentException varBE6F981A621D2588DCBAFD6F186E1351_1226718996 = new IllegalArgumentException("HTTP processor may not be null");
            varBE6F981A621D2588DCBAFD6F186E1351_1226718996.addTaint(taint);
            throw varBE6F981A621D2588DCBAFD6F186E1351_1226718996;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_706886890 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_706886890.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_706886890;
        } //End block
        processor.process(request, context);
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (processor == null) {
            //throw new IllegalArgumentException("HTTP processor may not be null");
        //}
        //if (context == null) {
            //throw new IllegalArgumentException("HTTP context may not be null");
        //}
        //processor.process(request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.344 -0400", hash_original_method = "3A0BDE86F44AAAE489AB1403F9B488D7", hash_generated_method = "407443C4035724F78B2430040EB04E88")
    protected HttpResponse doSendRequest(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1725341537 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1725341537.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1725341537;
        } //End block
        if(conn == null)        
        {
            IllegalArgumentException var6CFBC789236DE9A132EF716CA5496FB9_322549280 = new IllegalArgumentException("HTTP connection may not be null");
            var6CFBC789236DE9A132EF716CA5496FB9_322549280.addTaint(taint);
            throw var6CFBC789236DE9A132EF716CA5496FB9_322549280;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_2118181198 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_2118181198.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_2118181198;
        } //End block
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
                    } //End block
                    int status = response.getStatusLine().getStatusCode();
                    if(status < 200)                    
                    {
                        if(status != HttpStatus.SC_CONTINUE)                        
                        {
                            ProtocolException var9A30284AC6B7E9D346B26DB16996B6F5_3970913 = new ProtocolException(
                                    "Unexpected response: " + response.getStatusLine());
                            var9A30284AC6B7E9D346B26DB16996B6F5_3970913.addTaint(taint);
                            throw var9A30284AC6B7E9D346B26DB16996B6F5_3970913;
                        } //End block
                        response = null;
                    } //End block
                    else
                    {
                        sendentity = false;
                    } //End block
                } //End block
            } //End block
            if(sendentity)            
            {
                conn.sendRequestEntity((HttpEntityEnclosingRequest) request);
            } //End block
        } //End block
        conn.flush();
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.TRUE);
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_522377689 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_522377689.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_522377689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.346 -0400", hash_original_method = "ACD44B1A55AB2BB7AB7058E66F36FB4A", hash_generated_method = "7A1965DD11D1B6F44D4B5B2F1597461C")
    protected HttpResponse doReceiveResponse(
            final HttpRequest          request,
            final HttpClientConnection conn,
            final HttpContext          context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(conn.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_2061281069 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_2061281069.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_2061281069;
        } //End block
        if(conn == null)        
        {
            IllegalArgumentException var6CFBC789236DE9A132EF716CA5496FB9_1187567406 = new IllegalArgumentException("HTTP connection may not be null");
            var6CFBC789236DE9A132EF716CA5496FB9_1187567406.addTaint(taint);
            throw var6CFBC789236DE9A132EF716CA5496FB9_1187567406;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_625098615 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_625098615.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_625098615;
        } //End block
        HttpResponse response = null;
        int statuscode = 0;
        while
(response == null || statuscode < HttpStatus.SC_OK)        
        {
            response = conn.receiveResponseHeader();
            if(canResponseHaveBody(request, response))            
            {
                conn.receiveResponseEntity(response);
            } //End block
            statuscode = response.getStatusLine().getStatusCode();
        } //End block
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_1570480685 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1570480685.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1570480685;
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (conn == null) {
            //throw new IllegalArgumentException("HTTP connection may not be null");
        //}
        //if (context == null) {
            //throw new IllegalArgumentException("HTTP context may not be null");
        //}
        //HttpResponse response = null;
        //int statuscode = 0;
        //while (response == null || statuscode < HttpStatus.SC_OK) {
            //response = conn.receiveResponseHeader();
            //if (canResponseHaveBody(request, response)) {
                //conn.receiveResponseEntity(response);
            //}
            //statuscode = response.getStatusLine().getStatusCode();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.347 -0400", hash_original_method = "64184DC5B382438058CC5473730574C6", hash_generated_method = "96D7D27286F436D13A2F161201AF051F")
    public void postProcess(
            final HttpResponse response,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(processor.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1344026555 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1344026555.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1344026555;
        } //End block
        if(processor == null)        
        {
            IllegalArgumentException varBE6F981A621D2588DCBAFD6F186E1351_1532661413 = new IllegalArgumentException("HTTP processor may not be null");
            varBE6F981A621D2588DCBAFD6F186E1351_1532661413.addTaint(taint);
            throw varBE6F981A621D2588DCBAFD6F186E1351_1532661413;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_585613343 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_585613343.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_585613343;
        } //End block
        processor.process(response, context);
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //if (processor == null) {
            //throw new IllegalArgumentException("HTTP processor may not be null");
        //}
        //if (context == null) {
            //throw new IllegalArgumentException("HTTP context may not be null");
        //}
        //processor.process(response, context);
    }

    
}

