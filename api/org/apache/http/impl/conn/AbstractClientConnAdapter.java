package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.ClientConnectionManager;

public abstract class AbstractClientConnAdapter implements ManagedClientConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "785590630ABBC51419662A1F6C90EC57", hash_generated_field = "93A1502471BEBD8A1D320A124A64C925")

    private Thread executionThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "5B1DB60EB737FCE9D8CE8B7EB0423FFA")

    private volatile ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "2C3321C55B26FA40A2F649D6D19A092C", hash_generated_field = "917911B52507F6EAD6ABB3C534C08061")

    private volatile OperatedClientConnection wrappedConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "77035017D39C20BF71D208F4896BC5CA", hash_generated_field = "536CD81D74826635B01647B1F98CB897")

    private volatile boolean markedReusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "E6C2D59700A91862A935CE6ECAB4AE34")

    private volatile boolean aborted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.339 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "E04672A216F0A14E9EF0EC0ECFC2A7EA")

    private volatile long duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.340 -0400", hash_original_method = "F19F8D1447EDBBE8B1DB0973B5A52449", hash_generated_method = "AA89DA589BAF87371C0A1B2B9D3961F3")
    protected  AbstractClientConnAdapter(ClientConnectionManager mgr,
                                        OperatedClientConnection conn) {
        super();
        executionThread = Thread.currentThread();
        connManager = mgr;
        wrappedConnection = conn;
        markedReusable = false;
        aborted = false;
        duration = Long.MAX_VALUE;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.340 -0400", hash_original_method = "5CCC2D76AB339C78C9BD8A2A561C74E1", hash_generated_method = "C05FA2E5875C4FAD66CDB84286BB9B34")
    protected void detach() {
        wrappedConnection = null;
        connManager = null;
        duration = Long.MAX_VALUE;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.341 -0400", hash_original_method = "6A8409740777F9B554371FD5CA23B84B", hash_generated_method = "3C636157F253BACD9E3DE246430C756E")
    protected OperatedClientConnection getWrappedConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1328905209 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1328905209 = wrappedConnection;
        varB4EAC82CA7396A68D541C85D26508E83_1328905209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1328905209;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.341 -0400", hash_original_method = "D124AA8CBEEBBCAB0459F467E40DD04B", hash_generated_method = "989CA3D84711A76B7CB2DB7866317754")
    protected ClientConnectionManager getManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_249162246 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_249162246 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_249162246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_249162246;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.342 -0400", hash_original_method = "9979A78C8840F79217BFF27E2D058EEC", hash_generated_method = "D105657F186563D6D1A2F5D79F733CBC")
    protected final void assertNotAborted() throws InterruptedIOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InterruptedIOException("Connection has been shut down.");
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.342 -0400", hash_original_method = "948816836115B6F212C1F0250C125169", hash_generated_method = "ADD28CC5587C3B58E34F2DFF22D8EF60")
    protected final void assertValid(
            final OperatedClientConnection wrappedConn) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No wrapped connection.");
        } 
        addTaint(wrappedConn.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.343 -0400", hash_original_method = "2FF9625B0864983A43D78C23BFFFC0A5", hash_generated_method = "3D5613855DA4FB1F7EADE5C9DEB539EE")
    public boolean isOpen() {
        OperatedClientConnection conn = getWrappedConnection();
        boolean varE7A4B471159AD2DE9ECB4691541B383D_1498234198 = (conn.isOpen());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760904788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760904788;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.343 -0400", hash_original_method = "90FAABB6F73024DC33344558EFAA1B46", hash_generated_method = "41071F4F05AA78E2A0A34286A3A3195B")
    public boolean isStale() {
        OperatedClientConnection conn = getWrappedConnection();
        boolean varAD3FA2F7989BFDCF358C357A4888CB7F_217346944 = (conn.isStale());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758161772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758161772;
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.343 -0400", hash_original_method = "B78291A4996D117FD5B4CC742670B408", hash_generated_method = "9EF31553F91E55ACCB2068ACF2229F6D")
    public void setSocketTimeout(int timeout) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.setSocketTimeout(timeout);
        addTaint(timeout);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.344 -0400", hash_original_method = "BE23B10B196A5676F79C60CBBEA5CE71", hash_generated_method = "036DB50A096E6C343B857AB176B807EB")
    public int getSocketTimeout() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int varA22656DB6D884636BB9D2B60C273BEAD_85202671 = (conn.getSocketTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207086399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207086399;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.346 -0400", hash_original_method = "E00A8936DFAA9158B267C15F614D75D2", hash_generated_method = "18D3BBB031EA682CB4335DFBD78170AB")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_1966323678 = null; 
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_1966323678 = conn.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_1966323678.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1966323678;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.349 -0400", hash_original_method = "4AF00870D9F2520B9D9724B955A54108", hash_generated_method = "6A0F716E66F5A1D2A895FECF6E36BA7E")
    public void flush() throws IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.flush();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.350 -0400", hash_original_method = "25E2D0AFEEAE4A9FF0C3D2AE265B1F31", hash_generated_method = "A3B9F06CE6374B9705F00B17CD768B95")
    public boolean isResponseAvailable(int timeout) throws IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        boolean var6F89BC7DA9888529913BD690065EB22F_1248991775 = (conn.isResponseAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928371862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928371862;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.350 -0400", hash_original_method = "329A88989F2294EA414AFD573C61A83C", hash_generated_method = "9C5BC2199D062389D290BC18B1E77D71")
    public void receiveResponseEntity(HttpResponse response) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.receiveResponseEntity(response);
        addTaint(response.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.351 -0400", hash_original_method = "DE944D48C7CF4AE77CB8336F5E9ECC2B", hash_generated_method = "1461A22571EC6549131FD82658C57521")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_2038685945 = null; 
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        varB4EAC82CA7396A68D541C85D26508E83_2038685945 = conn.receiveResponseHeader();
        varB4EAC82CA7396A68D541C85D26508E83_2038685945.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2038685945;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.352 -0400", hash_original_method = "BB213D1ED83C696B5F4C4C57285E4F37", hash_generated_method = "2BB10C4E785E7A7EA0EFC5206F4E4145")
    public void sendRequestEntity(HttpEntityEnclosingRequest request) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestEntity(request);
        addTaint(request.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.352 -0400", hash_original_method = "54941B5E0F36540E3C9EF8677D0A50F2", hash_generated_method = "E1C14039909FC67BDE0041FA84879634")
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestHeader(request);
        addTaint(request.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.352 -0400", hash_original_method = "24C66DF3AC644AC2F2EBA8DCA3FC4629", hash_generated_method = "27CDD5C23AD9781B2289A6E493584131")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2131615680 = null; 
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_2131615680 = conn.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2131615680.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2131615680;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.353 -0400", hash_original_method = "CFFC28C49AC23EFEB6812E81E4BB886D", hash_generated_method = "9ED07C4A7896F81B1D26321D2876731F")
    public int getLocalPort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int varBBA56698F4CB877BCC7D186705E509B7_1770482157 = (conn.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684592711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684592711;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.354 -0400", hash_original_method = "600F3FFEA838B52DB2FC8A00D0FD1454", hash_generated_method = "0BD4648EE6ECCE0591C2A0CAE0806C29")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_295562364 = null; 
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_295562364 = conn.getRemoteAddress();
        varB4EAC82CA7396A68D541C85D26508E83_295562364.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_295562364;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.354 -0400", hash_original_method = "8BDC367E1BB67504AED838B12612BDA6", hash_generated_method = "873E9AE725482F465358F0794DCD27DB")
    public int getRemotePort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        int var3A0A898A1C062332D769D435D569D031_2000909367 = (conn.getRemotePort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661022289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661022289;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.355 -0400", hash_original_method = "4D12F5B41CA786A718C0CE38C40DC2DA", hash_generated_method = "4E4562CC9CA034985D8A194B71C2BB9A")
    public boolean isSecure() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        boolean var5F624B4FE00336318932D5C2A52C876F_967111347 = (conn.isSecure());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324372953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324372953;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.356 -0400", hash_original_method = "08E9B3DBCD970FB9C319F7E659C9D167", hash_generated_method = "7E60D7D6CA98C7DF1CDBE72135E7FF55")
    public SSLSession getSSLSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1170984036 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1062688867 = null; 
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1007759031 = (!isOpen());
            varB4EAC82CA7396A68D541C85D26508E83_1170984036 = null;
        } 
        SSLSession result = null;
        Socket sock = conn.getSocket();
        {
            result = ((SSLSocket)sock).getSession();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1062688867 = result;
        SSLSession varA7E53CE21691AB073D9660D615818899_864047799; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_864047799 = varB4EAC82CA7396A68D541C85D26508E83_1170984036;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_864047799 = varB4EAC82CA7396A68D541C85D26508E83_1062688867;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_864047799.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_864047799;
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.357 -0400", hash_original_method = "839709285FE118C452FA26DE879FFB1D", hash_generated_method = "7BE665094380AED20128BA3103013769")
    public void markReusable() {
        markedReusable = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.358 -0400", hash_original_method = "7923E01503297FB76AA22E34EEF6FDF5", hash_generated_method = "F127E589DEE28AC35FB277B0F37C1F36")
    public void unmarkReusable() {
        markedReusable = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.358 -0400", hash_original_method = "2387742F6BF9638BB6ECF14FF1FDB0EE", hash_generated_method = "7E57A3FA7B3C451EC615D04906F9F5F4")
    public boolean isMarkedReusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148018016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148018016;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.359 -0400", hash_original_method = "37F53EE2ADE585D06847009D28379E6D", hash_generated_method = "30C061D35B00A90AE432C2578011B0B0")
    public void setIdleDuration(long duration, TimeUnit unit) {
        {
            this.duration = unit.toMillis(duration);
        } 
        {
            this.duration = -1;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.359 -0400", hash_original_method = "6E364751B79392C296E473C8CD17B57B", hash_generated_method = "229274605D4E105923FDB3118C266F14")
    public void releaseConnection() {
        {
            connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.359 -0400", hash_original_method = "8C46EA9A337087A0A63A85A9D3E05177", hash_generated_method = "7D2C9182059520F074E51DE600B47FC3")
    public void abortConnection() {
        aborted = true;
        unmarkReusable();
        try 
        {
            shutdown();
        } 
        catch (IOException ignore)
        { }
        {
            boolean var4A29A9E0F951B1C4442C15321E502EC6_216579615 = (executionThread.equals(Thread.currentThread()));
            {
                releaseConnection();
            } 
        } 
        
        
            
        
        
        
        
            
        
        
        
            
        
    }

    
}

