package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class SSLSocketWrapper extends SSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.804 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.804 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.816 -0400", hash_original_method = "FF4D5BDA5C4AFB5D1A6A640264C26B17", hash_generated_method = "0BCDE605D2F5C0AD5E38E28888B84A06")
    protected  SSLSocketWrapper(Socket socket, boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(sslParameters);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_1166844474 = (!socket.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected.");
            } //End block
        } //End collapsed parenthetic
        this.socket = socket;
        this.autoClose = autoClose;
        init();
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
        //this.autoClose = autoClose;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.817 -0400", hash_original_method = "9FF3340D77F2F34483025CED36A00A30", hash_generated_method = "7D37A0175C350D9CCFCEE1762B40E38E")
    @Override
    protected void initTransportLayer() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
        // ---------- Original Method ----------
        //input = socket.getInputStream();
        //output = socket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.823 -0400", hash_original_method = "BD47C9CE6748D7B1802F0F857351CC5A", hash_generated_method = "1E0B1F1474B550D60C389DC58E107EFE")
    @Override
    protected void closeTransportLayer() throws IOException {
        {
            socket.close();
            input.close();
            output.close();
        } //End block
        // ---------- Original Method ----------
        //if (autoClose && (input != null)) {
            //socket.close();
            //input.close();
            //output.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.829 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "1A064EC557450C7EA2764FB4DB01E4C0")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.829 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "B10D9E4BDDC1EC0BBBD388520B8D78B5")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.829 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "879B551EC89CF9FC73B28F75178FBD21")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.830 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "B8A2254DFA1C2DEE8A8A4486C37B7BB2")
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_889646054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_889646054 = socket.getRemoteSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_889646054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889646054;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.840 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "B2818674E651BD4152514FAE94E4E100")
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1184706521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1184706521 = socket.getLocalSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1184706521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184706521;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.844 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "1D26AF5634CC7CADAE8419109CBBCEDE")
    @Override
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1454812370 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1454812370 = socket.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1454812370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454812370;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.856 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "D890EF912EE5A05573D708FEBB0D2A42")
    @Override
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_644685927 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_644685927 = socket.getInetAddress();
        varB4EAC82CA7396A68D541C85D26508E83_644685927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644685927;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.856 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "9455508F066890A89C080B77D8F2E39D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1363216062 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363216062 = "SSL socket over " + socket.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1363216062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363216062;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.856 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "8BF63EB618A8A20BA3045AD7CE0301B2")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        socket.setSoLinger(on, linger);
        addTaint(on);
        addTaint(linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.857 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "ADDDBEBB6020BAC3000366C593A8E5FA")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        socket.setTcpNoDelay(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.857 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "F51E15FEAA1AAF350A87A7B52B05C4BC")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        socket.setReuseAddress(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.857 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "2864058A22F7EA46FC805B79D732BACF")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        socket.setKeepAlive(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.857 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "E88C8D8FCC1216E91574A36430F7AE3A")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        socket.setTrafficClass(tos);
        addTaint(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.877 -0400", hash_original_method = "99398BF4E61DD284BEAF3BF1D99561D2", hash_generated_method = "BDA6E9B34A85E9B1E33EDE26A07ADF66")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        socket.setSoTimeout(to);
        addTaint(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.877 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "AE25A2C62767B956A81F8B9CCF73EAEA")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        socket.setSendBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.877 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "A88C32957F249CFF760FCD4B7090D09C")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.878 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "698B18DEB9A530E8501620EE3F5A0202")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_1885362063 = (socket.getTcpNoDelay());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197127768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197127768;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.878 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "F953B8B98F684199F54AB680F32532E0")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_600624174 = (socket.getReuseAddress());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576687811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576687811;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.878 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "BA8DD997F41FFFD8DCAA6BA6BF9A91AE")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_766589284 = (socket.getOOBInline());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114912131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114912131;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.878 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "9D21DAE53DC5F1C17018A87E99BEC942")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_604317565 = (socket.getKeepAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471341514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471341514;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.878 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "BEC80B81F038F944D600361BF7825A39")
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_1688212925 = (socket.getTrafficClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739915903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739915903;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.879 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "77A79896B1BD8E17CD67342B2CA2BFF9")
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_220733860 = (socket.getSoTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869595977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869595977;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.879 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "6770FD4A157B513FC7F50CDC7DC8EB3B")
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_1419880061 = (socket.getSoLinger());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286554676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286554676;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.879 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "41FC28F0CABF7D266521F6E07B2D4816")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_1870854121 = (socket.getSendBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007491215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007491215;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.884 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "0497CF526352F9E3C54A1973A1C33A49")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_1894947033 = (socket.getReceiveBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888180038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888180038;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.884 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "FF2E6AE9377387D98A3B2C38D5A30CB8")
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_1947720966 = (socket.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399000724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399000724;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.885 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "A6948B1DD95AF882CAF82FDF61AD217A")
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_104911640 = (socket.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981738859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981738859;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.885 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "CD553694EC09681272F5E1ADF1F0ABFF")
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_1911881248 = (socket.isBound());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659650066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659650066;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.885 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "E820AF24F00434A01C307238D7FA68F9")
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_1646263084 = (socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000252947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000252947;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.885 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "20579A04A673DEC34548A8AC72631BB6")
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_825175490 = (socket.isInputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357612780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_357612780;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.900 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "A79C5E79450738439E99CCA207FBF6DA")
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_2076088344 = (socket.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539639479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539639479;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.900 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "EA54DFEEE432BA93DA1EFC0A1F10B4F1")
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_1189791155 = (socket.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082310161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082310161;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.901 -0400", hash_original_method = "80D37FA57838689D0D9ECABB08EA2811", hash_generated_method = "E6296362E4501906FA441D321095E424")
    @Override
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1004865152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004865152 = socket.getFileDescriptor$();
        varB4EAC82CA7396A68D541C85D26508E83_1004865152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004865152;
        // ---------- Original Method ----------
        //return socket.getFileDescriptor$();
    }

    
}

