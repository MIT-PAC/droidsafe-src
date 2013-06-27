package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.626 -0400", hash_original_field = "785590630ABBC51419662A1F6C90EC57", hash_generated_field = "93A1502471BEBD8A1D320A124A64C925")

    private Thread executionThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.627 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "5B1DB60EB737FCE9D8CE8B7EB0423FFA")

    private volatile ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.627 -0400", hash_original_field = "2C3321C55B26FA40A2F649D6D19A092C", hash_generated_field = "917911B52507F6EAD6ABB3C534C08061")

    private volatile OperatedClientConnection wrappedConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.627 -0400", hash_original_field = "77035017D39C20BF71D208F4896BC5CA", hash_generated_field = "536CD81D74826635B01647B1F98CB897")

    private volatile boolean markedReusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.627 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "E6C2D59700A91862A935CE6ECAB4AE34")

    private volatile boolean aborted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.627 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "E04672A216F0A14E9EF0EC0ECFC2A7EA")

    private volatile long duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.628 -0400", hash_original_method = "F19F8D1447EDBBE8B1DB0973B5A52449", hash_generated_method = "AA89DA589BAF87371C0A1B2B9D3961F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.628 -0400", hash_original_method = "5CCC2D76AB339C78C9BD8A2A561C74E1", hash_generated_method = "C05FA2E5875C4FAD66CDB84286BB9B34")
    protected void detach() {
        wrappedConnection = null;
        connManager = null;
        duration = Long.MAX_VALUE;
        // ---------- Original Method ----------
        //wrappedConnection = null;
        //connManager = null;
        //duration = Long.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.636 -0400", hash_original_method = "6A8409740777F9B554371FD5CA23B84B", hash_generated_method = "13F08147A065516D69F8C080E157DEC5")
    protected OperatedClientConnection getWrappedConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_77981534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_77981534 = wrappedConnection;
        varB4EAC82CA7396A68D541C85D26508E83_77981534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_77981534;
        // ---------- Original Method ----------
        //return wrappedConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.636 -0400", hash_original_method = "D124AA8CBEEBBCAB0459F467E40DD04B", hash_generated_method = "5ED83FA6E0E7BFDB05E9B68BBF21BEC0")
    protected ClientConnectionManager getManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_275587037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_275587037 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_275587037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275587037;
        // ---------- Original Method ----------
        //return connManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.636 -0400", hash_original_method = "9979A78C8840F79217BFF27E2D058EEC", hash_generated_method = "D105657F186563D6D1A2F5D79F733CBC")
    protected final void assertNotAborted() throws InterruptedIOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InterruptedIOException("Connection has been shut down.");
        } //End block
        // ---------- Original Method ----------
        //if (aborted) {
            //throw new InterruptedIOException("Connection has been shut down.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.637 -0400", hash_original_method = "948816836115B6F212C1F0250C125169", hash_generated_method = "ADD28CC5587C3B58E34F2DFF22D8EF60")
    protected final void assertValid(
            final OperatedClientConnection wrappedConn) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No wrapped connection.");
        } //End block
        addTaint(wrappedConn.getTaint());
        // ---------- Original Method ----------
        //if (wrappedConn == null) {
            //throw new IllegalStateException("No wrapped connection.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.646 -0400", hash_original_method = "2FF9625B0864983A43D78C23BFFFC0A5", hash_generated_method = "847E59AC9F88D509B6EA6583180CD65B")
    public boolean isOpen() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        boolean varE7A4B471159AD2DE9ECB4691541B383D_1135532647 = (conn.isOpen());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825488292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825488292;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return false;
        //return conn.isOpen();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.646 -0400", hash_original_method = "90FAABB6F73024DC33344558EFAA1B46", hash_generated_method = "5A0872B15A73A700F1955F3F8B7DF187")
    public boolean isStale() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        boolean varAD3FA2F7989BFDCF358C357A4888CB7F_1886669149 = (conn.isStale());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898486944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898486944;
        // ---------- Original Method ----------
        //if (aborted)
            //return true;
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return true;
        //return conn.isStale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.646 -0400", hash_original_method = "B78291A4996D117FD5B4CC742670B408", hash_generated_method = "17218BDA76E843F93DA1EDB546824FCA")
    public void setSocketTimeout(int timeout) {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        conn.setSocketTimeout(timeout);
        addTaint(timeout);
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //conn.setSocketTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.647 -0400", hash_original_method = "BE23B10B196A5676F79C60CBBEA5CE71", hash_generated_method = "5A91AAB1FF4C99EE055AFA073C40DD4D")
    public int getSocketTimeout() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int varA22656DB6D884636BB9D2B60C273BEAD_1438258155 = (conn.getSocketTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008278483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008278483;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getSocketTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.647 -0400", hash_original_method = "E00A8936DFAA9158B267C15F614D75D2", hash_generated_method = "2B29A76831E2BC3182EF4C5134DF82AD")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_577926447 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_577926447 = conn.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_577926447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577926447;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getMetrics();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.647 -0400", hash_original_method = "4AF00870D9F2520B9D9724B955A54108", hash_generated_method = "9FA5A9C3C8A3F95D81E0A3B3CC0CD85D")
    public void flush() throws IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        conn.flush();
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //conn.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.667 -0400", hash_original_method = "25E2D0AFEEAE4A9FF0C3D2AE265B1F31", hash_generated_method = "B19A54C572E27A4F2F567FC466345658")
    public boolean isResponseAvailable(int timeout) throws IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        boolean var6F89BC7DA9888529913BD690065EB22F_1764139679 = (conn.isResponseAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021651557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021651557;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isResponseAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.668 -0400", hash_original_method = "329A88989F2294EA414AFD573C61A83C", hash_generated_method = "8F4A3E372C45886793B0D01EDFCF6C51")
    public void receiveResponseEntity(HttpResponse response) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.receiveResponseEntity(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.receiveResponseEntity(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.668 -0400", hash_original_method = "DE944D48C7CF4AE77CB8336F5E9ECC2B", hash_generated_method = "2CB15A1C5650BC1D18F71276040155F7")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_160666998 = null; //Variable for return #1
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        varB4EAC82CA7396A68D541C85D26508E83_160666998 = conn.receiveResponseHeader();
        varB4EAC82CA7396A68D541C85D26508E83_160666998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_160666998;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //return conn.receiveResponseHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.672 -0400", hash_original_method = "BB213D1ED83C696B5F4C4C57285E4F37", hash_generated_method = "83CD2FAF83C3728A78228D8F274CB898")
    public void sendRequestEntity(HttpEntityEnclosingRequest request) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestEntity(request);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.sendRequestEntity(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.673 -0400", hash_original_method = "54941B5E0F36540E3C9EF8677D0A50F2", hash_generated_method = "361027F75BEC65FC65616BA9C25B304F")
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestHeader(request);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //conn.sendRequestHeader(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.681 -0400", hash_original_method = "24C66DF3AC644AC2F2EBA8DCA3FC4629", hash_generated_method = "5FD41D00DDC365922DEAD01BE05535A9")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_680687788 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_680687788 = conn.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_680687788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680687788;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.693 -0400", hash_original_method = "CFFC28C49AC23EFEB6812E81E4BB886D", hash_generated_method = "A8B19C95ECB5AAF194F3118174AFD41A")
    public int getLocalPort() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int varBBA56698F4CB877BCC7D186705E509B7_1861090939 = (conn.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73665433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73665433;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.693 -0400", hash_original_method = "600F3FFEA838B52DB2FC8A00D0FD1454", hash_generated_method = "D69E93AD5F0067BCAD31D959143DA0FA")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1472870140 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_1472870140 = conn.getRemoteAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1472870140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1472870140;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemoteAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.694 -0400", hash_original_method = "8BDC367E1BB67504AED838B12612BDA6", hash_generated_method = "57662219B53DB78E773B7188D2F2C54C")
    public int getRemotePort() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int var3A0A898A1C062332D769D435D569D031_1364799625 = (conn.getRemotePort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991418814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991418814;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemotePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.694 -0400", hash_original_method = "4D12F5B41CA786A718C0CE38C40DC2DA", hash_generated_method = "FA5E912755587D5F57AEDDC1A4F6EF51")
    public boolean isSecure() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        boolean var5F624B4FE00336318932D5C2A52C876F_1847710449 = (conn.isSecure());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210679122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210679122;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.706 -0400", hash_original_method = "08E9B3DBCD970FB9C319F7E659C9D167", hash_generated_method = "940AB4D7F64BD8D31A425B58F1CDD646")
    public SSLSession getSSLSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_777596465 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_2056439985 = null; //Variable for return #2
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1643847410 = (!isOpen());
            varB4EAC82CA7396A68D541C85D26508E83_777596465 = null;
        } //End collapsed parenthetic
        SSLSession result;
        result = null;
        Socket sock;
        sock = conn.getSocket();
        {
            result = ((SSLSocket)sock).getSession();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2056439985 = result;
        SSLSession varA7E53CE21691AB073D9660D615818899_1356646533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1356646533 = varB4EAC82CA7396A68D541C85D26508E83_777596465;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1356646533 = varB4EAC82CA7396A68D541C85D26508E83_2056439985;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1356646533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1356646533;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.707 -0400", hash_original_method = "839709285FE118C452FA26DE879FFB1D", hash_generated_method = "7BE665094380AED20128BA3103013769")
    public void markReusable() {
        markedReusable = true;
        // ---------- Original Method ----------
        //markedReusable = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.720 -0400", hash_original_method = "7923E01503297FB76AA22E34EEF6FDF5", hash_generated_method = "F127E589DEE28AC35FB277B0F37C1F36")
    public void unmarkReusable() {
        markedReusable = false;
        // ---------- Original Method ----------
        //markedReusable = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.728 -0400", hash_original_method = "2387742F6BF9638BB6ECF14FF1FDB0EE", hash_generated_method = "7EA5EECA5170BCFE5007847FD2F3D8B2")
    public boolean isMarkedReusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146668068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146668068;
        // ---------- Original Method ----------
        //return markedReusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.728 -0400", hash_original_method = "37F53EE2ADE585D06847009D28379E6D", hash_generated_method = "30C061D35B00A90AE432C2578011B0B0")
    public void setIdleDuration(long duration, TimeUnit unit) {
        {
            this.duration = unit.toMillis(duration);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.728 -0400", hash_original_method = "6E364751B79392C296E473C8CD17B57B", hash_generated_method = "229274605D4E105923FDB3118C266F14")
    public void releaseConnection() {
        {
            connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        } //End block
        // ---------- Original Method ----------
        //if (connManager != null) {
            //connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.729 -0400", hash_original_method = "8C46EA9A337087A0A63A85A9D3E05177", hash_generated_method = "A0107D8B240EC817BBE2C59DF9B65054")
    public void abortConnection() {
        aborted = true;
        unmarkReusable();
        try 
        {
            shutdown();
        } //End block
        catch (IOException ignore)
        { }
        {
            boolean var4A29A9E0F951B1C4442C15321E502EC6_1983322715 = (executionThread.equals(Thread.currentThread()));
            {
                releaseConnection();
            } //End block
        } //End collapsed parenthetic
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

