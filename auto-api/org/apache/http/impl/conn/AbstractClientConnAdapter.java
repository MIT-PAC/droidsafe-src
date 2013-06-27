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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "785590630ABBC51419662A1F6C90EC57", hash_generated_field = "93A1502471BEBD8A1D320A124A64C925")

    private Thread executionThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "5B1DB60EB737FCE9D8CE8B7EB0423FFA")

    private volatile ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "2C3321C55B26FA40A2F649D6D19A092C", hash_generated_field = "917911B52507F6EAD6ABB3C534C08061")

    private volatile OperatedClientConnection wrappedConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "77035017D39C20BF71D208F4896BC5CA", hash_generated_field = "536CD81D74826635B01647B1F98CB897")

    private volatile boolean markedReusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "E6C2D59700A91862A935CE6ECAB4AE34")

    private volatile boolean aborted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.582 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "E04672A216F0A14E9EF0EC0ECFC2A7EA")

    private volatile long duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.583 -0400", hash_original_method = "F19F8D1447EDBBE8B1DB0973B5A52449", hash_generated_method = "AA89DA589BAF87371C0A1B2B9D3961F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.591 -0400", hash_original_method = "5CCC2D76AB339C78C9BD8A2A561C74E1", hash_generated_method = "C05FA2E5875C4FAD66CDB84286BB9B34")
    protected void detach() {
        wrappedConnection = null;
        connManager = null;
        duration = Long.MAX_VALUE;
        // ---------- Original Method ----------
        //wrappedConnection = null;
        //connManager = null;
        //duration = Long.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.592 -0400", hash_original_method = "6A8409740777F9B554371FD5CA23B84B", hash_generated_method = "39B367C0C50D447C568FE38A0642265F")
    protected OperatedClientConnection getWrappedConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1537071211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1537071211 = wrappedConnection;
        varB4EAC82CA7396A68D541C85D26508E83_1537071211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537071211;
        // ---------- Original Method ----------
        //return wrappedConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.592 -0400", hash_original_method = "D124AA8CBEEBBCAB0459F467E40DD04B", hash_generated_method = "A254536866494BEA136593DBAE1FFF62")
    protected ClientConnectionManager getManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_2028343531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2028343531 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_2028343531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2028343531;
        // ---------- Original Method ----------
        //return connManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.592 -0400", hash_original_method = "9979A78C8840F79217BFF27E2D058EEC", hash_generated_method = "D105657F186563D6D1A2F5D79F733CBC")
    protected final void assertNotAborted() throws InterruptedIOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InterruptedIOException("Connection has been shut down.");
        } //End block
        // ---------- Original Method ----------
        //if (aborted) {
            //throw new InterruptedIOException("Connection has been shut down.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.592 -0400", hash_original_method = "948816836115B6F212C1F0250C125169", hash_generated_method = "ADD28CC5587C3B58E34F2DFF22D8EF60")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.593 -0400", hash_original_method = "2FF9625B0864983A43D78C23BFFFC0A5", hash_generated_method = "7FC3E494814153E5822E8E33FCADC6A4")
    public boolean isOpen() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        boolean varE7A4B471159AD2DE9ECB4691541B383D_803544012 = (conn.isOpen());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469038208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469038208;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return false;
        //return conn.isOpen();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.593 -0400", hash_original_method = "90FAABB6F73024DC33344558EFAA1B46", hash_generated_method = "325669941B0033C9E7D942545351337D")
    public boolean isStale() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        boolean varAD3FA2F7989BFDCF358C357A4888CB7F_93116113 = (conn.isStale());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905848237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905848237;
        // ---------- Original Method ----------
        //if (aborted)
            //return true;
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn == null)
            //return true;
        //return conn.isStale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.593 -0400", hash_original_method = "B78291A4996D117FD5B4CC742670B408", hash_generated_method = "17218BDA76E843F93DA1EDB546824FCA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.598 -0400", hash_original_method = "BE23B10B196A5676F79C60CBBEA5CE71", hash_generated_method = "E7E314A5360ECAF6804D478C9B0E23A6")
    public int getSocketTimeout() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int varA22656DB6D884636BB9D2B60C273BEAD_946593893 = (conn.getSocketTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478179662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478179662;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getSocketTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.598 -0400", hash_original_method = "E00A8936DFAA9158B267C15F614D75D2", hash_generated_method = "67DFA6AE25E4A1E828B1AA3E14FFF78F")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_2089960626 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_2089960626 = conn.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_2089960626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2089960626;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getMetrics();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.599 -0400", hash_original_method = "4AF00870D9F2520B9D9724B955A54108", hash_generated_method = "9FA5A9C3C8A3F95D81E0A3B3CC0CD85D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.599 -0400", hash_original_method = "25E2D0AFEEAE4A9FF0C3D2AE265B1F31", hash_generated_method = "B715B60219AEDCF5788888B7AB540FC1")
    public boolean isResponseAvailable(int timeout) throws IOException {
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        boolean var6F89BC7DA9888529913BD690065EB22F_145208087 = (conn.isResponseAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942379816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942379816;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isResponseAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.599 -0400", hash_original_method = "329A88989F2294EA414AFD573C61A83C", hash_generated_method = "8F4A3E372C45886793B0D01EDFCF6C51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.624 -0400", hash_original_method = "DE944D48C7CF4AE77CB8336F5E9ECC2B", hash_generated_method = "79792D86A648CA9850D32EEE67A38623")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_2088995669 = null; //Variable for return #1
        assertNotAborted();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        varB4EAC82CA7396A68D541C85D26508E83_2088995669 = conn.receiveResponseHeader();
        varB4EAC82CA7396A68D541C85D26508E83_2088995669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2088995669;
        // ---------- Original Method ----------
        //assertNotAborted();
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //unmarkReusable();
        //return conn.receiveResponseHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.624 -0400", hash_original_method = "BB213D1ED83C696B5F4C4C57285E4F37", hash_generated_method = "83CD2FAF83C3728A78228D8F274CB898")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.625 -0400", hash_original_method = "54941B5E0F36540E3C9EF8677D0A50F2", hash_generated_method = "361027F75BEC65FC65616BA9C25B304F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.625 -0400", hash_original_method = "24C66DF3AC644AC2F2EBA8DCA3FC4629", hash_generated_method = "880C022C755F1DD679A794E75D5D7B8D")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1126545981 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_1126545981 = conn.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1126545981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126545981;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.626 -0400", hash_original_method = "CFFC28C49AC23EFEB6812E81E4BB886D", hash_generated_method = "AD7A2669C0102134E566EDAD75F457F5")
    public int getLocalPort() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int varBBA56698F4CB877BCC7D186705E509B7_2085816387 = (conn.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60200591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60200591;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.626 -0400", hash_original_method = "600F3FFEA838B52DB2FC8A00D0FD1454", hash_generated_method = "8FE3AE570E6582BC56A8751FF6C832A8")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_243470250 = null; //Variable for return #1
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        varB4EAC82CA7396A68D541C85D26508E83_243470250 = conn.getRemoteAddress();
        varB4EAC82CA7396A68D541C85D26508E83_243470250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243470250;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemoteAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.626 -0400", hash_original_method = "8BDC367E1BB67504AED838B12612BDA6", hash_generated_method = "89598D9CF08E06E9F1CD6271800A7F06")
    public int getRemotePort() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        int var3A0A898A1C062332D769D435D569D031_497843236 = (conn.getRemotePort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15295313 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15295313;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.getRemotePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.627 -0400", hash_original_method = "4D12F5B41CA786A718C0CE38C40DC2DA", hash_generated_method = "DD09E71F64A68C79CFF830DBB53FEBB0")
    public boolean isSecure() {
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        boolean var5F624B4FE00336318932D5C2A52C876F_715206871 = (conn.isSecure());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138454430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138454430;
        // ---------- Original Method ----------
        //OperatedClientConnection conn = getWrappedConnection();
        //assertValid(conn);
        //return conn.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.628 -0400", hash_original_method = "08E9B3DBCD970FB9C319F7E659C9D167", hash_generated_method = "BEF808D6A929372112381F4AE7E100EC")
    public SSLSession getSSLSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1243425907 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1017206425 = null; //Variable for return #2
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        assertValid(conn);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2071693274 = (!isOpen());
            varB4EAC82CA7396A68D541C85D26508E83_1243425907 = null;
        } //End collapsed parenthetic
        SSLSession result;
        result = null;
        Socket sock;
        sock = conn.getSocket();
        {
            result = ((SSLSocket)sock).getSession();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1017206425 = result;
        SSLSession varA7E53CE21691AB073D9660D615818899_720785368; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_720785368 = varB4EAC82CA7396A68D541C85D26508E83_1243425907;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_720785368 = varB4EAC82CA7396A68D541C85D26508E83_1017206425;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_720785368.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_720785368;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.628 -0400", hash_original_method = "839709285FE118C452FA26DE879FFB1D", hash_generated_method = "7BE665094380AED20128BA3103013769")
    public void markReusable() {
        markedReusable = true;
        // ---------- Original Method ----------
        //markedReusable = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.635 -0400", hash_original_method = "7923E01503297FB76AA22E34EEF6FDF5", hash_generated_method = "F127E589DEE28AC35FB277B0F37C1F36")
    public void unmarkReusable() {
        markedReusable = false;
        // ---------- Original Method ----------
        //markedReusable = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.635 -0400", hash_original_method = "2387742F6BF9638BB6ECF14FF1FDB0EE", hash_generated_method = "A64A6AABF9BEA49243A1D3677275ADE5")
    public boolean isMarkedReusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74653195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74653195;
        // ---------- Original Method ----------
        //return markedReusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.636 -0400", hash_original_method = "37F53EE2ADE585D06847009D28379E6D", hash_generated_method = "30C061D35B00A90AE432C2578011B0B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.649 -0400", hash_original_method = "6E364751B79392C296E473C8CD17B57B", hash_generated_method = "229274605D4E105923FDB3118C266F14")
    public void releaseConnection() {
        {
            connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        } //End block
        // ---------- Original Method ----------
        //if (connManager != null) {
            //connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.649 -0400", hash_original_method = "8C46EA9A337087A0A63A85A9D3E05177", hash_generated_method = "F7CC931B60EE1C2D240314900A6243FB")
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
            boolean var4A29A9E0F951B1C4442C15321E502EC6_51152410 = (executionThread.equals(Thread.currentThread()));
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

