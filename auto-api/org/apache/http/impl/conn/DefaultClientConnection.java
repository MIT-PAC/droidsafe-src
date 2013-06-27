package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.conn.OperatedClientConnection;

public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "6C87DB41DB9F8ED683A6987A130ECA44", hash_generated_field = "F630DCA356BF718748039FF5A5AF565A")

    private Log headerLog = LogFactory.getLog("org.apache.http.headers");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "1B631A8417506619998850DB350B22DB", hash_generated_field = "4BBB468B106DD027FCA64303676ADA85")

    private Log wireLog = LogFactory.getLog("org.apache.http.wire");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "50659BF88C73A03DFC94D9CBD95233DD")

    private volatile Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "D7E36E5942053C7FA2C1E8BD9A079825", hash_generated_field = "5985EB8DABB6B518B89C4CD8CA0ADA5A")

    private boolean connSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.701 -0400", hash_original_field = "5924F03A95EE6F7277E5BDD1E81B8FDC", hash_generated_field = "9C150001B868C03DDA27B7582F7794C7")

    private volatile boolean shutdown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.705 -0400", hash_original_method = "90469C020BD0C2691C8C778F609E10DE", hash_generated_method = "F008BABB63E20BD366844A0FEDDC4004")
    public  DefaultClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.706 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "3627A5F508BF7842D1FF75602FDA6197")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_277744462 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277744462 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_277744462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277744462;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.706 -0400", hash_original_method = "4971CDDD7E23679E1EB91619B0566CC2", hash_generated_method = "A0198F3DE413031EC87E18E8ADC8268E")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630117010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630117010;
        // ---------- Original Method ----------
        //return this.connSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.707 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "C67CE41EE7EA485FFA5163C0A4297FF1")
    @Override
    public final Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_854087940 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854087940 = this.socket;
        varB4EAC82CA7396A68D541C85D26508E83_854087940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854087940;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.721 -0400", hash_original_method = "DA5079B0FADB5957D7F2D5BE061C8D7D", hash_generated_method = "9495B63F7C19D500192B03E4F4F3E347")
    public void opening(Socket sock, HttpHost target) throws IOException {
        assertNotOpen();
        this.socket = sock;
        this.targetHost = target;
        {
            sock.close();
            if (DroidSafeAndroidRuntime.control) throw new IOException("Connection already shutdown");
        } //End block
        // ---------- Original Method ----------
        //assertNotOpen();
        //this.socket = sock;
        //this.targetHost = target;
        //if (this.shutdown) {
            //sock.close(); 
            //throw new IOException("Connection already shutdown");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.722 -0400", hash_original_method = "238B4BA0F77ED507B3FA0211642C8510", hash_generated_method = "A00D3B1C54A9CCBCE3F91E9745C08C1B")
    public void openCompleted(boolean secure, HttpParams params) throws IOException {
        assertNotOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        this.connSecure = secure;
        bind(this.socket, params);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertNotOpen();
        //if (params == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //this.connSecure = secure;
        //bind(this.socket, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.723 -0400", hash_original_method = "2C3D09F7EAB3530485FB76A4EFF6AEB8", hash_generated_method = "9056FF4619862836906E56C250B44CAC")
    @Override
    public void shutdown() throws IOException {
        log.debug("Connection shut down");
        shutdown = true;
        super.shutdown();
        Socket sock;
        sock = this.socket;
        sock.close();
        // ---------- Original Method ----------
        //log.debug("Connection shut down");
        //shutdown = true;
        //super.shutdown();
        //Socket sock = this.socket;
        //if (sock != null)
            //sock.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.727 -0400", hash_original_method = "4ADF205732DDD49A8E02AC6258F60F5A", hash_generated_method = "F2BDB9F1383ABE509042E4DA4F117CFB")
    @Override
    public void close() throws IOException {
        log.debug("Connection closed");
        super.close();
        // ---------- Original Method ----------
        //log.debug("Connection closed");
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.728 -0400", hash_original_method = "8F7D1845D5CBAF2D176D233AC7877F21", hash_generated_method = "C77A56AA7E68A97903424111D7778652")
    @Override
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer varB4EAC82CA7396A68D541C85D26508E83_1330300937 = null; //Variable for return #1
        SessionInputBuffer inbuffer;
        inbuffer = super.createSessionInputBuffer(
                socket, 
                buffersize,
                params);
        {
            boolean var6E6E95DC97CB46C75DB0192C96CAD471_575819765 = (wireLog.isDebugEnabled());
            {
                inbuffer = new LoggingSessionInputBuffer(inbuffer, new Wire(wireLog));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1330300937 = inbuffer;
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1330300937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330300937;
        // ---------- Original Method ----------
        //SessionInputBuffer inbuffer = super.createSessionInputBuffer(
                //socket, 
                //buffersize,
                //params);
        //if (wireLog.isDebugEnabled()) {
            //inbuffer = new LoggingSessionInputBuffer(inbuffer, new Wire(wireLog));
        //}
        //return inbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.731 -0400", hash_original_method = "17D3D45553913AFCC8694294B924BCA4", hash_generated_method = "C8CBD18AFDD07ABB303C229758B55D8C")
    @Override
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer varB4EAC82CA7396A68D541C85D26508E83_1441158478 = null; //Variable for return #1
        SessionOutputBuffer outbuffer;
        outbuffer = super.createSessionOutputBuffer(
                socket,
                buffersize,
                params);
        {
            boolean var6E6E95DC97CB46C75DB0192C96CAD471_1385020285 = (wireLog.isDebugEnabled());
            {
                outbuffer = new LoggingSessionOutputBuffer(outbuffer, new Wire(wireLog));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1441158478 = outbuffer;
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1441158478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441158478;
        // ---------- Original Method ----------
        //SessionOutputBuffer outbuffer = super.createSessionOutputBuffer(
                //socket,
                //buffersize,
                //params);
        //if (wireLog.isDebugEnabled()) {
            //outbuffer = new LoggingSessionOutputBuffer(outbuffer, new Wire(wireLog));
        //}
        //return outbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.732 -0400", hash_original_method = "8A983123757D80237B42B0E1C96CF087", hash_generated_method = "D692B541151B759496399A9FC987B300")
    @Override
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory, 
            final HttpParams params) {
        HttpMessageParser varB4EAC82CA7396A68D541C85D26508E83_1439490969 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1439490969 = new DefaultResponseParser
            (buffer, null, responseFactory, params);
        addTaint(buffer.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1439490969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1439490969;
        // ---------- Original Method ----------
        //return new DefaultResponseParser
            //(buffer, null, responseFactory, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.732 -0400", hash_original_method = "9118767905DEE596C55572AB6CA12E81", hash_generated_method = "DC74FF541565A7F1A9C71A9873AD8045")
    public void update(Socket sock, HttpHost target,
                       boolean secure, HttpParams params) throws IOException {
        assertOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            this.socket = sock;
            bind(sock, params);
        } //End block
        targetHost = target;
        connSecure = secure;
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertOpen();
        //if (target == null) {
            //throw new IllegalArgumentException
                //("Target host must not be null.");
        //}
        //if (params == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //if (sock != null) {
            //this.socket = sock;
            //bind(sock, params);
        //}
        //targetHost = target;
        //connSecure = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.784 -0400", hash_original_method = "74E39E85D143527EEDE4A43C784BFAA2", hash_generated_method = "1947B142E74145F901A4DE7165187B2E")
    @Override
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_837675284 = null; //Variable for return #1
        HttpResponse response;
        response = super.receiveResponseHeader();
        {
            boolean var8A04A6DFBC2B2DD9ACD4C1D4F84EB0D9_1707501430 = (headerLog.isDebugEnabled());
            {
                headerLog.debug("<< " + response.getStatusLine().toString());
                Header[] headers;
                headers = response.getAllHeaders();
                {
                    Header header = headers[0];
                    {
                        headerLog.debug("<< " + header.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_837675284 = response;
        varB4EAC82CA7396A68D541C85D26508E83_837675284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_837675284;
        // ---------- Original Method ----------
        //HttpResponse response = super.receiveResponseHeader();
        //if (headerLog.isDebugEnabled()) {
            //headerLog.debug("<< " + response.getStatusLine().toString());
            //Header[] headers = response.getAllHeaders();
            //for (Header header : headers) {
                //headerLog.debug("<< " + header.toString());
            //}
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.818 -0400", hash_original_method = "8184260E56E5B05281BA00158DD30362", hash_generated_method = "B47C312849C97511D073086EB7180FA3")
    @Override
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        super.sendRequestHeader(request);
        {
            boolean var8A04A6DFBC2B2DD9ACD4C1D4F84EB0D9_175446636 = (headerLog.isDebugEnabled());
            {
                headerLog.debug(">> " + request.getRequestLine().toString());
                Header[] headers;
                headers = request.getAllHeaders();
                {
                    Header header = headers[0];
                    {
                        headerLog.debug(">> " + header.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //super.sendRequestHeader(request);
        //if (headerLog.isDebugEnabled()) {
            //headerLog.debug(">> " + request.getRequestLine().toString());
            //Header[] headers = request.getAllHeaders();
            //for (Header header : headers) {
                //headerLog.debug(">> " + header.toString());
            //}
        //}
    }

    
}

