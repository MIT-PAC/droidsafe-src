package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;






public abstract class AbstractClientConnAdapter implements ManagedClientConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "785590630ABBC51419662A1F6C90EC57", hash_generated_field = "93A1502471BEBD8A1D320A124A64C925")

    private Thread executionThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "5B1DB60EB737FCE9D8CE8B7EB0423FFA")

    private volatile ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "2C3321C55B26FA40A2F649D6D19A092C", hash_generated_field = "917911B52507F6EAD6ABB3C534C08061")

    private volatile OperatedClientConnection wrappedConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "77035017D39C20BF71D208F4896BC5CA", hash_generated_field = "536CD81D74826635B01647B1F98CB897")

    private volatile boolean markedReusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "E6C2D59700A91862A935CE6ECAB4AE34")

    private volatile boolean aborted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.967 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "E04672A216F0A14E9EF0EC0ECFC2A7EA")

    private volatile long duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.968 -0400", hash_original_method = "F19F8D1447EDBBE8B1DB0973B5A52449", hash_generated_method = "AA89DA589BAF87371C0A1B2B9D3961F3")
    protected  AbstractClientConnAdapter(ClientConnectionManager mgr,
                                        OperatedClientConnection conn) {
        super();
        executionThread = Thread.currentThread();
        connManager = mgr;
        wrappedConnection = conn;
        markedReusable = false;
        aborted = false;
        duration = Long.MAX_VALUE;
        // ---------- Original Method ----------
        //executionThread = Thread.currentThread();
        //connManager = mgr;
        //wrappedConnection = conn;
        //markedReusable = false;
        //aborted = false;
        //duration = Long.MAX_VALUE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.969 -0400", hash_original_method = "5CCC2D76AB339C78C9BD8A2A561C74E1", hash_generated_method = "C05FA2E5875C4FAD66CDB84286BB9B34")
    protected void detach() {
        wrappedConnection = null;
        connManager = null;
        duration = Long.MAX_VALUE;
        // ---------- Original Method ----------
        //wrappedConnection = null;
        //connManager = null;
        //duration = Long.MAX_VALUE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.969 -0400", hash_original_method = "6A8409740777F9B554371FD5CA23B84B", hash_generated_method = "2C8A5692938C942151272D506333381F")
    protected OperatedClientConnection getWrappedConnection() {
OperatedClientConnection var67BFE8639BF4D54D36BCCAB7D2BDEA1E_1852837932 =         wrappedConnection;
        var67BFE8639BF4D54D36BCCAB7D2BDEA1E_1852837932.addTaint(taint);
        return var67BFE8639BF4D54D36BCCAB7D2BDEA1E_1852837932;
        // ---------- Original Method ----------
        //return wrappedConnection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.970 -0400", hash_original_method = "D124AA8CBEEBBCAB0459F467E40DD04B", hash_generated_method = "740F1493535A1C055168E488282E97CE")
    protected ClientConnectionManager getManager() {
ClientConnectionManager varA3F19198A23DEA30D08223E00C8A3A82_1349615508 =         connManager;
        varA3F19198A23DEA30D08223E00C8A3A82_1349615508.addTaint(taint);
        return varA3F19198A23DEA30D08223E00C8A3A82_1349615508;
        // ---------- Original Method ----------
        //return connManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.970 -0400", hash_original_method = "9979A78C8840F79217BFF27E2D058EEC", hash_generated_method = "8DA54D4F789844FFC9201E5B3CC21399")
    protected final void assertNotAborted() throws InterruptedIOException {
        if(aborted)        
        {
            InterruptedIOException var5B27A46B909A31111E8F9174329C2770_1431602807 = new InterruptedIOException("Connection has been shut down.");
            var5B27A46B909A31111E8F9174329C2770_1431602807.addTaint(taint);
            throw var5B27A46B909A31111E8F9174329C2770_1431602807;
        } //End block
        // ---------- Original Method ----------
        //if (aborted) {
            //throw new InterruptedIOException("Connection has been shut down.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.970 -0400", hash_original_method = "948816836115B6F212C1F0250C125169", hash_generated_method = "0205B0A6683231EC091AB6E65661EBF0")
    protected final void assertValid(
            final OperatedClientConnection wrappedConn) {
        addTaint(wrappedConn.getTaint());
        if(wrappedConn == null)        
        {
            IllegalStateException var4F64B52FA212B6D9F221A3F109CFE0F8_253828378 = new IllegalStateException("No wrapped connection.");
            var4F64B52FA212B6D9F221A3F109CFE0F8_253828378.addTaint(taint);
            throw var4F64B52FA212B6D9F221A3F109CFE0F8_253828378;
        } //End block
        // ---------- Original Method ----------
        //if (wrappedConn == null) {
            //throw new IllegalStateException("No wrapped connection.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.970 -0400", hash_original_method = "2FF9625B0864983A43D78C23BFFFC0A5", hash_generated_method = "9248DDDBAA1A8BAC3BB561159E00F975")
    public boolean isOpen() {
        OperatedClientConnection conn = getWrappedConnection();
        if(conn == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_664468249 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7365625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7365625;
        }
        boolean var160D40DABB921BD72607FBE1DD13336F_1224982511 = (conn.isOpen());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443930111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443930111;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return false;
        //return conn.isOpen();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.971 -0400", hash_original_method = "90FAABB6F73024DC33344558EFAA1B46", hash_generated_method = "A02266357DFDA86D460292CAF9DBD74F")
    public boolean isStale() {
        if(aborted)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_812076642 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799527733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799527733;
        }
        OperatedClientConnection conn = getWrappedConnection();
        if(conn == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1222942278 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226024356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226024356;
        }
        boolean var25BF3D1354E39595C509CB31111EF97B_314783484 = (conn.isStale());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018071018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018071018;
        // ---------- Original Method ----------
        //if (aborted)
            //return true;
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return true;
        //return conn.isStale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.971 -0400", hash_original_method = "B78291A4996D117FD5B4CC742670B408", hash_generated_method = "FE1CCF25BDB1D72ADA3A2DA45CAD165C")
    public void setSocketTimeout(int timeout) {
        addTaint(timeout);
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.setSocketTimeout(timeout);
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //conn.setSocketTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.972 -0400", hash_original_method = "BE23B10B196A5676F79C60CBBEA5CE71", hash_generated_method = "A37C657F7032C9B101E964F4969056FC")
    public int getSocketTimeout() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int var95FFA445D5A9A4BC36AB1DC44BAE0D85_599720566 = (conn.getSocketTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924902099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924902099;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getSocketTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.972 -0400", hash_original_method = "E00A8936DFAA9158B267C15F614D75D2", hash_generated_method = "17287771588EC906E34AC094094FB357")
    public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
HttpConnectionMetrics varEB4189BE8F03207E4416B4772007C2FF_1967927531 =         conn.getMetrics();
        varEB4189BE8F03207E4416B4772007C2FF_1967927531.addTaint(taint);
        return varEB4189BE8F03207E4416B4772007C2FF_1967927531;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getMetrics();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.972 -0400", hash_original_method = "4AF00870D9F2520B9D9724B955A54108", hash_generated_method = "6A0F716E66F5A1D2A895FECF6E36BA7E")
    public void flush() throws IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.flush();
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //conn.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.972 -0400", hash_original_method = "25E2D0AFEEAE4A9FF0C3D2AE265B1F31", hash_generated_method = "70AB7BA45A99B085B270DD9DA1C565C9")
    public boolean isResponseAvailable(int timeout) throws IOException {
        addTaint(timeout);
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        boolean var8EF05C19AD6A8E1E89B4F486FD4CC329_583279657 = (conn.isResponseAvailable(timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206986414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206986414;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isResponseAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.972 -0400", hash_original_method = "329A88989F2294EA414AFD573C61A83C", hash_generated_method = "3B628F6B3AAAE629019115D28EBF76AD")
    public void receiveResponseEntity(HttpResponse response) throws HttpException, IOException {
        addTaint(response.getTaint());
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.receiveResponseEntity(response);
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.receiveResponseEntity(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.973 -0400", hash_original_method = "DE944D48C7CF4AE77CB8336F5E9ECC2B", hash_generated_method = "586E00100177AEA24EDF925556AEB1DB")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
HttpResponse varE063336E2071DB69DB08B2CDD9CDA3CC_1005260817 =         conn.receiveResponseHeader();
        varE063336E2071DB69DB08B2CDD9CDA3CC_1005260817.addTaint(taint);
        return varE063336E2071DB69DB08B2CDD9CDA3CC_1005260817;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //return conn.receiveResponseHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.973 -0400", hash_original_method = "BB213D1ED83C696B5F4C4C57285E4F37", hash_generated_method = "F60E52111B2F23EC9C72B8B9CC9FE379")
    public void sendRequestEntity(HttpEntityEnclosingRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestEntity(request);
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.sendRequestEntity(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.973 -0400", hash_original_method = "54941B5E0F36540E3C9EF8677D0A50F2", hash_generated_method = "FA8C2D3C033E81E5A665B69F72B1F98A")
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestHeader(request);
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.sendRequestHeader(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.974 -0400", hash_original_method = "24C66DF3AC644AC2F2EBA8DCA3FC4629", hash_generated_method = "7A876427C0C16309439565B23C3A21C0")
    public InetAddress getLocalAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
InetAddress varCDFAB36BFB4DA07291E03E81DE197703_299570086 =         conn.getLocalAddress();
        varCDFAB36BFB4DA07291E03E81DE197703_299570086.addTaint(taint);
        return varCDFAB36BFB4DA07291E03E81DE197703_299570086;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.974 -0400", hash_original_method = "CFFC28C49AC23EFEB6812E81E4BB886D", hash_generated_method = "51AFCCACF2F5E883382770199DBB7413")
    public int getLocalPort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int varA232E3DF66EF4784D674D13BEA784FF7_1716033156 = (conn.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626383569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626383569;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.974 -0400", hash_original_method = "600F3FFEA838B52DB2FC8A00D0FD1454", hash_generated_method = "2CACB8E642A346719FA8C36C493C26A8")
    public InetAddress getRemoteAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
InetAddress varC665637F3EB55A5589053A929E6B6A83_1492725337 =         conn.getRemoteAddress();
        varC665637F3EB55A5589053A929E6B6A83_1492725337.addTaint(taint);
        return varC665637F3EB55A5589053A929E6B6A83_1492725337;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemoteAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.974 -0400", hash_original_method = "8BDC367E1BB67504AED838B12612BDA6", hash_generated_method = "3E89D98923FC4DD12A46F5DA3A8D5CA0")
    public int getRemotePort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int var7C19380A7B4AEDEFF30B3FCBB4DEFBBC_1271077728 = (conn.getRemotePort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703721861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703721861;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemotePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.975 -0400", hash_original_method = "4D12F5B41CA786A718C0CE38C40DC2DA", hash_generated_method = "23A5E4032CBE96105685B688FAA4007C")
    public boolean isSecure() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        boolean var79772CEFF0063644ED296D0AE2ECD1B3_714483322 = (conn.isSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504286974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504286974;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.975 -0400", hash_original_method = "08E9B3DBCD970FB9C319F7E659C9D167", hash_generated_method = "5646B39DFF4AEC220058BCB39556DBCF")
    public SSLSession getSSLSession() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if(!isOpen())        
        {
SSLSession var540C13E9E156B687226421B24F2DF178_1380207897 =         null;
        var540C13E9E156B687226421B24F2DF178_1380207897.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1380207897;
        }
        SSLSession result = null;
        Socket sock = conn.getSocket();
        if(sock instanceof SSLSocket)        
        {
            result = ((SSLSocket)sock).getSession();
        } //End block
SSLSession varDC838461EE2FA0CA4C9BBB70A15456B0_2097197077 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2097197077.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2097197077;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //if (!isOpen())
            //return null;
        //SSLSession result = null;
        //Socket    sock    = conn.getSocket();
        //if (sock instanceof SSLSocket) {
            //result = ((SSLSocket)sock).getSession();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.975 -0400", hash_original_method = "839709285FE118C452FA26DE879FFB1D", hash_generated_method = "7BE665094380AED20128BA3103013769")
    public void markReusable() {
        markedReusable = true;
        // ---------- Original Method ----------
        //markedReusable = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.976 -0400", hash_original_method = "7923E01503297FB76AA22E34EEF6FDF5", hash_generated_method = "F127E589DEE28AC35FB277B0F37C1F36")
    public void unmarkReusable() {
        markedReusable = false;
        // ---------- Original Method ----------
        //markedReusable = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.976 -0400", hash_original_method = "2387742F6BF9638BB6ECF14FF1FDB0EE", hash_generated_method = "A55DFC5E8D45BFC8DE27F139AA0E05EA")
    public boolean isMarkedReusable() {
        boolean var77035017D39C20BF71D208F4896BC5CA_96743063 = (markedReusable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193599792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193599792;
        // ---------- Original Method ----------
        //return markedReusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.976 -0400", hash_original_method = "37F53EE2ADE585D06847009D28379E6D", hash_generated_method = "40B744060463D29495B29E6820310F4D")
    public void setIdleDuration(long duration, TimeUnit unit) {
        if(duration > 0)        
        {
            this.duration = unit.toMillis(duration);
        } //End block
        else
        {
            this.duration = -1;
        } //End block
        // ---------- Original Method ----------
        //if(duration > 0) {
            //this.duration = unit.toMillis(duration);
        //} else {
            //this.duration = -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.977 -0400", hash_original_method = "6E364751B79392C296E473C8CD17B57B", hash_generated_method = "C2ED76AB0A08FB328E14071FA50B1B32")
    public void releaseConnection() {
        if(connManager != null)        
        {
            connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        } //End block
        // ---------- Original Method ----------
        //if (connManager != null) {
            //connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.977 -0400", hash_original_method = "8C46EA9A337087A0A63A85A9D3E05177", hash_generated_method = "198814D7DEB6D71E0D2BA763D7BD7C66")
    public void abortConnection() {
        if(aborted)        
        {
            return;
        } //End block
        aborted = true;
        unmarkReusable();
        try 
        {
            shutdown();
        } //End block
        catch (IOException ignore)
        {
        } //End block
        if(executionThread.equals(Thread.currentThread()))        
        {
            releaseConnection();
        } //End block
        // ---------- Original Method ----------
        //if (aborted) {
            //return;
        //}
        //aborted = true;
        //unmarkReusable();
        //try {
            //shutdown();
        //} catch (IOException ignore) {
        //}
        //if (executionThread.equals(Thread.currentThread())) {
            //releaseConnection();
        //}
    }

    
}

