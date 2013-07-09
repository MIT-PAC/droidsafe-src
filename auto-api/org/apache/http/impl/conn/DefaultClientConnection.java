package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "6C87DB41DB9F8ED683A6987A130ECA44", hash_generated_field = "4E5EA705088864E33B87793C6FE07C16")

    private final Log headerLog = LogFactory.getLog("org.apache.http.headers");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "1B631A8417506619998850DB350B22DB", hash_generated_field = "A13F3EDC8B3D2050126D58CBAE58152B")

    private final Log wireLog = LogFactory.getLog("org.apache.http.wire");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "50659BF88C73A03DFC94D9CBD95233DD")

    private volatile Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "D7E36E5942053C7FA2C1E8BD9A079825", hash_generated_field = "5985EB8DABB6B518B89C4CD8CA0ADA5A")

    private boolean connSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.417 -0400", hash_original_field = "5924F03A95EE6F7277E5BDD1E81B8FDC", hash_generated_field = "9C150001B868C03DDA27B7582F7794C7")

    private volatile boolean shutdown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.418 -0400", hash_original_method = "90469C020BD0C2691C8C778F609E10DE", hash_generated_method = "F008BABB63E20BD366844A0FEDDC4004")
    public  DefaultClientConnection() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.418 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "2F55BF6D7DD690B47BDCACB35782DFDA")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1886078666 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1886078666 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1886078666.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1886078666;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.418 -0400", hash_original_method = "4971CDDD7E23679E1EB91619B0566CC2", hash_generated_method = "0F591C07764CFAF1E6C2E07B2F7ED048")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311046842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311046842;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.419 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "8934F527F9DEDABC9A9EDFFFC751AA8C")
    @Override
    public final Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1776035747 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1776035747 = this.socket;
        varB4EAC82CA7396A68D541C85D26508E83_1776035747.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1776035747;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.420 -0400", hash_original_method = "DA5079B0FADB5957D7F2D5BE061C8D7D", hash_generated_method = "9495B63F7C19D500192B03E4F4F3E347")
    public void opening(Socket sock, HttpHost target) throws IOException {
        assertNotOpen();
        this.socket = sock;
        this.targetHost = target;
        {
            sock.close();
            if (DroidSafeAndroidRuntime.control) throw new IOException("Connection already shutdown");
        } 
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.421 -0400", hash_original_method = "238B4BA0F77ED507B3FA0211642C8510", hash_generated_method = "A00D3B1C54A9CCBCE3F91E9745C08C1B")
    public void openCompleted(boolean secure, HttpParams params) throws IOException {
        assertNotOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        this.connSecure = secure;
        bind(this.socket, params);
        addTaint(params.getTaint());
        
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.422 -0400", hash_original_method = "2C3D09F7EAB3530485FB76A4EFF6AEB8", hash_generated_method = "D209411216CE395DCA9FE956BF56C769")
    @Override
    public void shutdown() throws IOException {
        log.debug("Connection shut down");
        shutdown = true;
        super.shutdown();
        Socket sock = this.socket;
        sock.close();
        
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.423 -0400", hash_original_method = "4ADF205732DDD49A8E02AC6258F60F5A", hash_generated_method = "F2BDB9F1383ABE509042E4DA4F117CFB")
    @Override
    public void close() throws IOException {
        log.debug("Connection closed");
        super.close();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.426 -0400", hash_original_method = "8F7D1845D5CBAF2D176D233AC7877F21", hash_generated_method = "3F189392AA6E80A3E7F1EEA5D5D81CCF")
    @Override
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer varB4EAC82CA7396A68D541C85D26508E83_1044997052 = null; 
        SessionInputBuffer inbuffer = super.createSessionInputBuffer(
                socket, 
                buffersize,
                params);
        {
            boolean var6E6E95DC97CB46C75DB0192C96CAD471_1850751295 = (wireLog.isDebugEnabled());
            {
                inbuffer = new LoggingSessionInputBuffer(inbuffer, new Wire(wireLog));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1044997052 = inbuffer;
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1044997052.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1044997052;
        
        
                
                
                
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.428 -0400", hash_original_method = "17D3D45553913AFCC8694294B924BCA4", hash_generated_method = "D91AA93407F8A9108AED1AFF034CA0D0")
    @Override
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer varB4EAC82CA7396A68D541C85D26508E83_606737100 = null; 
        SessionOutputBuffer outbuffer = super.createSessionOutputBuffer(
                socket,
                buffersize,
                params);
        {
            boolean var6E6E95DC97CB46C75DB0192C96CAD471_384183169 = (wireLog.isDebugEnabled());
            {
                outbuffer = new LoggingSessionOutputBuffer(outbuffer, new Wire(wireLog));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_606737100 = outbuffer;
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_606737100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_606737100;
        
        
                
                
                
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.428 -0400", hash_original_method = "8A983123757D80237B42B0E1C96CF087", hash_generated_method = "7397125BA6FF6675522442818474A58A")
    @Override
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory, 
            final HttpParams params) {
        HttpMessageParser varB4EAC82CA7396A68D541C85D26508E83_229235098 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_229235098 = new DefaultResponseParser
            (buffer, null, responseFactory, params);
        addTaint(buffer.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_229235098.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_229235098;
        
        
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.429 -0400", hash_original_method = "9118767905DEE596C55572AB6CA12E81", hash_generated_method = "DC74FF541565A7F1A9C71A9873AD8045")
    public void update(Socket sock, HttpHost target,
                       boolean secure, HttpParams params) throws IOException {
        assertOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            this.socket = sock;
            bind(sock, params);
        } 
        targetHost = target;
        connSecure = secure;
        addTaint(params.getTaint());
        
        
        
            
                
        
        
            
                
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.436 -0400", hash_original_method = "74E39E85D143527EEDE4A43C784BFAA2", hash_generated_method = "C69AAF1D76D9DF4540977520D8661E64")
    @Override
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_2007320236 = null; 
        HttpResponse response = super.receiveResponseHeader();
        {
            boolean var8A04A6DFBC2B2DD9ACD4C1D4F84EB0D9_673689200 = (headerLog.isDebugEnabled());
            {
                headerLog.debug("<< " + response.getStatusLine().toString());
                Header[] headers = response.getAllHeaders();
                {
                    Header header = headers[0];
                    {
                        headerLog.debug("<< " + header.toString());
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2007320236 = response;
        varB4EAC82CA7396A68D541C85D26508E83_2007320236.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2007320236;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.442 -0400", hash_original_method = "8184260E56E5B05281BA00158DD30362", hash_generated_method = "3072684D12719050EA9DD0AAE9B658AB")
    @Override
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        super.sendRequestHeader(request);
        {
            boolean var8A04A6DFBC2B2DD9ACD4C1D4F84EB0D9_1582585676 = (headerLog.isDebugEnabled());
            {
                headerLog.debug(">> " + request.getRequestLine().toString());
                Header[] headers = request.getAllHeaders();
                {
                    Header header = headers[0];
                    {
                        headerLog.debug(">> " + header.toString());
                    } 
                } 
            } 
        } 
        addTaint(request.getTaint());
        
        
        
            
            
            
                
            
        
    }

    
}

