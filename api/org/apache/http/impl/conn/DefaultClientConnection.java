package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;






public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.061 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.061 -0400", hash_original_field = "6C87DB41DB9F8ED683A6987A130ECA44", hash_generated_field = "4E5EA705088864E33B87793C6FE07C16")

    private final Log headerLog = LogFactory.getLog("org.apache.http.headers");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.061 -0400", hash_original_field = "1B631A8417506619998850DB350B22DB", hash_generated_field = "A13F3EDC8B3D2050126D58CBAE58152B")

    private final Log wireLog = LogFactory.getLog("org.apache.http.wire");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.061 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "50659BF88C73A03DFC94D9CBD95233DD")

    private volatile Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.061 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.062 -0400", hash_original_field = "D7E36E5942053C7FA2C1E8BD9A079825", hash_generated_field = "5985EB8DABB6B518B89C4CD8CA0ADA5A")

    private boolean connSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.062 -0400", hash_original_field = "5924F03A95EE6F7277E5BDD1E81B8FDC", hash_generated_field = "9C150001B868C03DDA27B7582F7794C7")

    private volatile boolean shutdown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.062 -0400", hash_original_method = "90469C020BD0C2691C8C778F609E10DE", hash_generated_method = "F008BABB63E20BD366844A0FEDDC4004")
    public  DefaultClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.063 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "6E4F19A93AEB99BEEC3D5B73F300AEDD")
    public final HttpHost getTargetHost() {
HttpHost var67C71439C5981484698447EE93E1A003_1018056380 =         this.targetHost;
        var67C71439C5981484698447EE93E1A003_1018056380.addTaint(taint);
        return var67C71439C5981484698447EE93E1A003_1018056380;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.063 -0400", hash_original_method = "4971CDDD7E23679E1EB91619B0566CC2", hash_generated_method = "9CB60586500089CB69C9442686C3DD22")
    public final boolean isSecure() {
        boolean var1589795B26F953D6CF1D3B000BEE1AEA_1176895057 = (this.connSecure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215334919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215334919;
        // ---------- Original Method ----------
        //return this.connSecure;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.064 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "8988A797B61AC33A785CD845C746489F")
    @Override
    public final Socket getSocket() {
Socket var6B38E62DD669FDAB6F1C8B30960FAB66_1207897800 =         this.socket;
        var6B38E62DD669FDAB6F1C8B30960FAB66_1207897800.addTaint(taint);
        return var6B38E62DD669FDAB6F1C8B30960FAB66_1207897800;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.065 -0400", hash_original_method = "DA5079B0FADB5957D7F2D5BE061C8D7D", hash_generated_method = "0CDAF23AB2214E1B6F3AEE8FCDBB3A3B")
    public void opening(Socket sock, HttpHost target) throws IOException {
        assertNotOpen();
        this.socket = sock;
        this.targetHost = target;
        if(this.shutdown)        
        {
            sock.close();
            IOException varA5CC848843DF75C6BC8F83E942245B6E_1244001717 = new IOException("Connection already shutdown");
            varA5CC848843DF75C6BC8F83E942245B6E_1244001717.addTaint(taint);
            throw varA5CC848843DF75C6BC8F83E942245B6E_1244001717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.066 -0400", hash_original_method = "238B4BA0F77ED507B3FA0211642C8510", hash_generated_method = "CD1DC3097D42DADAC99D81CB08843836")
    public void openCompleted(boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        assertNotOpen();
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1142575878 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1142575878.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1142575878;
        } //End block
        this.connSecure = secure;
        bind(this.socket, params);
        // ---------- Original Method ----------
        //assertNotOpen();
        //if (params == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //this.connSecure = secure;
        //bind(this.socket, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.066 -0400", hash_original_method = "2C3D09F7EAB3530485FB76A4EFF6AEB8", hash_generated_method = "64946B2D51A3DBA746D0D3775030CD8A")
    @Override
    public void shutdown() throws IOException {
        log.debug("Connection shut down");
        shutdown = true;
        super.shutdown();
        Socket sock = this.socket;
        if(sock != null)        
        sock.close();
        // ---------- Original Method ----------
        //log.debug("Connection shut down");
        //shutdown = true;
        //super.shutdown();
        //Socket sock = this.socket;
        //if (sock != null)
            //sock.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.067 -0400", hash_original_method = "4ADF205732DDD49A8E02AC6258F60F5A", hash_generated_method = "F2BDB9F1383ABE509042E4DA4F117CFB")
    @Override
    public void close() throws IOException {
        log.debug("Connection closed");
        super.close();
        // ---------- Original Method ----------
        //log.debug("Connection closed");
        //super.close();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.067 -0400", hash_original_method = "8F7D1845D5CBAF2D176D233AC7877F21", hash_generated_method = "90026C16B669FDCC69C149AA04A43C9A")
    @Override
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(buffersize);
        addTaint(socket.getTaint());
        SessionInputBuffer inbuffer = super.createSessionInputBuffer(
                socket, 
                buffersize,
                params);
        if(wireLog.isDebugEnabled())        
        {
            inbuffer = new LoggingSessionInputBuffer(inbuffer, new Wire(wireLog));
        } //End block
SessionInputBuffer var736A436546842D53E14743BF3FAC79E6_1066388828 =         inbuffer;
        var736A436546842D53E14743BF3FAC79E6_1066388828.addTaint(taint);
        return var736A436546842D53E14743BF3FAC79E6_1066388828;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.068 -0400", hash_original_method = "17D3D45553913AFCC8694294B924BCA4", hash_generated_method = "142C1244EE1B535E89F25F46DE4F2443")
    @Override
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(buffersize);
        addTaint(socket.getTaint());
        SessionOutputBuffer outbuffer = super.createSessionOutputBuffer(
                socket,
                buffersize,
                params);
        if(wireLog.isDebugEnabled())        
        {
            outbuffer = new LoggingSessionOutputBuffer(outbuffer, new Wire(wireLog));
        } //End block
SessionOutputBuffer var6647B0BB282283042E6D25A390B5E288_188186824 =         outbuffer;
        var6647B0BB282283042E6D25A390B5E288_188186824.addTaint(taint);
        return var6647B0BB282283042E6D25A390B5E288_188186824;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.068 -0400", hash_original_method = "8A983123757D80237B42B0E1C96CF087", hash_generated_method = "66D7766AEF528A86AAA7A5EC9CA40F62")
    @Override
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory, 
            final HttpParams params) {
        addTaint(params.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(buffer.getTaint());
HttpMessageParser var77984927842A040FCF920A71EAA2A2B9_1419266477 =         new DefaultResponseParser
            (buffer, null, responseFactory, params);
        var77984927842A040FCF920A71EAA2A2B9_1419266477.addTaint(taint);
        return var77984927842A040FCF920A71EAA2A2B9_1419266477;
        // ---------- Original Method ----------
        //return new DefaultResponseParser
            //(buffer, null, responseFactory, params);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.069 -0400", hash_original_method = "9118767905DEE596C55572AB6CA12E81", hash_generated_method = "B7CDD920C9FD6F4C0219D7C1513710B4")
    public void update(Socket sock, HttpHost target,
                       boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        assertOpen();
        if(target == null)        
        {
            IllegalArgumentException varEC83656C97A1AEE534C63E8749A9F3F6_354759902 = new IllegalArgumentException
                ("Target host must not be null.");
            varEC83656C97A1AEE534C63E8749A9F3F6_354759902.addTaint(taint);
            throw varEC83656C97A1AEE534C63E8749A9F3F6_354759902;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1771904001 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1771904001.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1771904001;
        } //End block
        if(sock != null)        
        {
            this.socket = sock;
            bind(sock, params);
        } //End block
        targetHost = target;
        connSecure = secure;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.070 -0400", hash_original_method = "74E39E85D143527EEDE4A43C784BFAA2", hash_generated_method = "16B3A83D825E5F0B22AEE99625BEC581")
    @Override
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse response = super.receiveResponseHeader();
        if(headerLog.isDebugEnabled())        
        {
            headerLog.debug("<< " + response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
for(Header header : headers)
            {
                headerLog.debug("<< " + header.toString());
            } //End block
        } //End block
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_420212834 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_420212834.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_420212834;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.071 -0400", hash_original_method = "8184260E56E5B05281BA00158DD30362", hash_generated_method = "D3D6157CD4BFFD8D004A969DA5397802")
    @Override
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
        super.sendRequestHeader(request);
        if(headerLog.isDebugEnabled())        
        {
            headerLog.debug(">> " + request.getRequestLine().toString());
            Header[] headers = request.getAllHeaders();
for(Header header : headers)
            {
                headerLog.debug(">> " + header.toString());
            } //End block
        } //End block
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

