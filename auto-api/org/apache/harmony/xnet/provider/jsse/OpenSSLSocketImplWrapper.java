package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class OpenSSLSocketImplWrapper extends OpenSSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.237 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.249 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "8D97D256C135D552E8C21006784CE7CE")
    protected  OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_682816299 = (!socket.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected.");
            } //End block
        } //End collapsed parenthetic
        this.socket = socket;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.249 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "1A064EC557450C7EA2764FB4DB01E4C0")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.249 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "B10D9E4BDDC1EC0BBBD388520B8D78B5")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.250 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "879B551EC89CF9FC73B28F75178FBD21")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.250 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "0227D2CADE690E05C0F9636CC1ED7DC2")
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_803511650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_803511650 = socket.getRemoteSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_803511650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_803511650;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.250 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "48E8A94FC8BBB90D3AADCF31E006523C")
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2139090263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2139090263 = socket.getLocalSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2139090263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2139090263;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.251 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "48739EC7ACD20D3ED55D1F7983A1BB45")
    @Override
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_159740275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_159740275 = socket.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_159740275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_159740275;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.251 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "AAB1DB62E2260FFEFF7764507ACCF0AF")
    @Override
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_62084470 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_62084470 = socket.getInetAddress();
        varB4EAC82CA7396A68D541C85D26508E83_62084470.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_62084470;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.261 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "06D9371E50F5917A80C060F5F20616F0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_164050417 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_164050417 = "SSL socket over " + socket.toString();
        varB4EAC82CA7396A68D541C85D26508E83_164050417.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_164050417;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.262 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "8BF63EB618A8A20BA3045AD7CE0301B2")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        socket.setSoLinger(on, linger);
        addTaint(on);
        addTaint(linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.262 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "ADDDBEBB6020BAC3000366C593A8E5FA")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        socket.setTcpNoDelay(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.262 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "F51E15FEAA1AAF350A87A7B52B05C4BC")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        socket.setReuseAddress(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.262 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "2864058A22F7EA46FC805B79D732BACF")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        socket.setKeepAlive(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.263 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "E88C8D8FCC1216E91574A36430F7AE3A")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        socket.setTrafficClass(tos);
        addTaint(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.263 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "82C42B1A0DBBF3FEB090668865C9F27F")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        addTaint(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
        //super.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.263 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "AE25A2C62767B956A81F8B9CCF73EAEA")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        socket.setSendBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.263 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "A88C32957F249CFF760FCD4B7090D09C")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.264 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "53B2A8B61DCEBA51F46341AD859E91EA")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_1658560535 = (socket.getTcpNoDelay());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303895646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303895646;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.264 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "B4725B4157E1B3A1D8C426B8C9D55C8B")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_1469045978 = (socket.getReuseAddress());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661061244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661061244;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.264 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "BC10895563C6A33506D94A2F932C5086")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_790426210 = (socket.getOOBInline());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472954767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472954767;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.264 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "6466AFBABF018532E47EDF0F9AA4EC00")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_1236697149 = (socket.getKeepAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42634796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42634796;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.265 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "48735E8B90423F3661EEF93904FFDBEF")
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_1576880233 = (socket.getTrafficClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546612431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546612431;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.265 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "99ACED799181B57019383EA25B7C6716")
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_193389390 = (socket.getSoTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044547498 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044547498;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.265 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "4431FF5E7D3A64F539FBF096EDFD927D")
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_574277246 = (socket.getSoLinger());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212697671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212697671;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.274 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "9BDC311704D10F3E9E174D845A69ACA2")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_1014225211 = (socket.getSendBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107928084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107928084;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.275 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "497A1BC09BFAA7262EB40BF675139F56")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_835058880 = (socket.getReceiveBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023174308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023174308;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.275 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "034E4041BF74DBD41813D0012C339179")
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_581868824 = (socket.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585768950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585768950;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.275 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "74162DFF5DB33457F6FD90D18F0A58A4")
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_1479244390 = (socket.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077492330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077492330;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.276 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "DDAE7215EAC4A393F57379C6C285F7EE")
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_414838738 = (socket.isBound());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752520955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_752520955;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.276 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "AEC0480A0B1078A332B7259F13384BBC")
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_429086669 = (socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39683029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39683029;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.276 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "483725A6AC7C3B61B2392798756DE3AF")
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_521327494 = (socket.isInputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855590374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_855590374;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.276 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "8E744CA8FDAD60AFD3FF33F142E8BC30")
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_595533529 = (socket.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20003928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20003928;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.276 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "24FF6EA4D42B8ACC0F7DDB3D249949B7")
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_1674423275 = (socket.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423331491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423331491;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
}

