package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.519 -0400", hash_original_method = "1B3D6EB0D2C9672C0490DD487A44B10E", hash_generated_method = "5C823C110E4C37030580A4ECF9EB10B9")
    public  HttpRequestExecutor() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.520 -0400", hash_original_method = "0630A8D079D2F2EA09859A2EAC923D24", hash_generated_method = "8DDCC363E17E5822CABEAC6393D9955B")
    protected boolean canResponseHaveBody(final HttpRequest request,
                                          final HttpResponse response) {
        {
            boolean varD156E42C6563538534C094BC9F8B30CC_669599064 = ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod()));
        } //End collapsed parenthetic
        int status;
        status = response.getStatusLine().getStatusCode();
        addTaint(request.getTaint());
        addTaint(response.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766027422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766027422;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.531 -0400", hash_original_method = "119B944BAA4C5EE6E8AB8C1C74A61B19", hash_generated_method = "D8E6AE494C3A537B852FE1AC645C01B5")
    public HttpResponse execute(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_335727753 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Client connection may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        try 
        {
            HttpResponse response;
            response = doSendRequest(request, conn, context);
            {
                response = doReceiveResponse(request, conn, context);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_335727753 = response;
        } //End block
        catch (IOException ex)
        {
            conn.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (HttpException ex)
        {
            conn.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            conn.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        addTaint(request.getTaint());
        addTaint(conn.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_335727753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_335727753;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.531 -0400", hash_original_method = "83559981E73A0A11E2E39D8FF1D4E53C", hash_generated_method = "5D77BBC4B3586E99238F5EFD1D9471B1")
    public void preProcess(
            final HttpRequest request,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP processor may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        processor.process(request, context);
        addTaint(request.getTaint());
        addTaint(processor.getTaint());
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.541 -0400", hash_original_method = "3A0BDE86F44AAAE489AB1403F9B488D7", hash_generated_method = "C7BE3B14C23CC416C207DA251BD6219E")
    protected HttpResponse doSendRequest(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1694133455 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP connection may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        HttpResponse response;
        response = null;
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.FALSE);
        conn.sendRequestHeader(request);
        {
            boolean sendentity;
            sendentity = true;
            ProtocolVersion ver;
            ver = request.getRequestLine().getProtocolVersion();
            {
                boolean var43491DB99A4160B9C640073F657E942C_829304273 = (((HttpEntityEnclosingRequest) request).expectContinue() &&
                !ver.lessEquals(HttpVersion.HTTP_1_0));
                {
                    conn.flush();
                    int tms;
                    tms = request.getParams().getIntParameter(
                        CoreProtocolPNames.WAIT_FOR_CONTINUE, 2000);
                    {
                        boolean var37F76CBB3128C83B9D1F17320CBEB427_1248494175 = (conn.isResponseAvailable(tms));
                        {
                            response = conn.receiveResponseHeader();
                            {
                                boolean var1658CC8B4194AE69AA37E3D73F449498_2141163200 = (canResponseHaveBody(request, response));
                                {
                                    conn.receiveResponseEntity(response);
                                } //End block
                            } //End collapsed parenthetic
                            int status;
                            status = response.getStatusLine().getStatusCode();
                            {
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                                    "Unexpected response: " + response.getStatusLine());
                                } //End block
                                response = null;
                            } //End block
                            {
                                sendentity = false;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                conn.sendRequestEntity((HttpEntityEnclosingRequest) request);
            } //End block
        } //End block
        conn.flush();
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.TRUE);
        varB4EAC82CA7396A68D541C85D26508E83_1694133455 = response;
        addTaint(request.getTaint());
        addTaint(conn.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1694133455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694133455;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.546 -0400", hash_original_method = "ACD44B1A55AB2BB7AB7058E66F36FB4A", hash_generated_method = "0689818BFF61A84F265FF83CCEF9AABC")
    protected HttpResponse doReceiveResponse(
            final HttpRequest          request,
            final HttpClientConnection conn,
            final HttpContext          context) throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_693456193 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP connection may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        HttpResponse response;
        response = null;
        int statuscode;
        statuscode = 0;
        {
            response = conn.receiveResponseHeader();
            {
                boolean var6B88B4CB1811D7DE18E3DA4B1231F057_1610071287 = (canResponseHaveBody(request, response));
                {
                    conn.receiveResponseEntity(response);
                } //End block
            } //End collapsed parenthetic
            statuscode = response.getStatusLine().getStatusCode();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_693456193 = response;
        addTaint(request.getTaint());
        addTaint(conn.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_693456193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_693456193;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.546 -0400", hash_original_method = "64184DC5B382438058CC5473730574C6", hash_generated_method = "AC92B84600BA81C31D407C3EFAD4A58E")
    public void postProcess(
            final HttpResponse response,
            final HttpProcessor processor,
            final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP processor may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        processor.process(response, context);
        addTaint(response.getTaint());
        addTaint(processor.getTaint());
        addTaint(context.getTaint());
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

