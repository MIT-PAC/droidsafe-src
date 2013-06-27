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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.419 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.419 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "87E4C5C5F81A6F58DFCC31863E67D441")
    protected  OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_1858653663 = (!socket.isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.420 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "1A064EC557450C7EA2764FB4DB01E4C0")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.420 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "B10D9E4BDDC1EC0BBBD388520B8D78B5")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.420 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "879B551EC89CF9FC73B28F75178FBD21")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.438 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "158195AB4D1E907E429661D6E5D560DD")
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_166140862 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_166140862 = socket.getRemoteSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_166140862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_166140862;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.439 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "D9E2AB005132152318956CB18450403E")
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1362937398 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1362937398 = socket.getLocalSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1362937398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362937398;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.439 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "BBA8060F01D477E8C28D80E486E9F482")
    @Override
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1265457363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1265457363 = socket.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1265457363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265457363;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.439 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "8C9275451B74C5D939D0B3F88B477718")
    @Override
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1487665787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1487665787 = socket.getInetAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1487665787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1487665787;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.440 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "8EA18B5C14A906B9AA86CD7236F4DB1B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_138068022 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_138068022 = "SSL socket over " + socket.toString();
        varB4EAC82CA7396A68D541C85D26508E83_138068022.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138068022;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.440 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "8BF63EB618A8A20BA3045AD7CE0301B2")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        socket.setSoLinger(on, linger);
        addTaint(on);
        addTaint(linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.445 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "ADDDBEBB6020BAC3000366C593A8E5FA")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        socket.setTcpNoDelay(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.446 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "F51E15FEAA1AAF350A87A7B52B05C4BC")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        socket.setReuseAddress(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.447 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "2864058A22F7EA46FC805B79D732BACF")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        socket.setKeepAlive(on);
        addTaint(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.448 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "E88C8D8FCC1216E91574A36430F7AE3A")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        socket.setTrafficClass(tos);
        addTaint(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.448 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "82C42B1A0DBBF3FEB090668865C9F27F")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        addTaint(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
        //super.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.448 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "AE25A2C62767B956A81F8B9CCF73EAEA")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        socket.setSendBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.448 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "A88C32957F249CFF760FCD4B7090D09C")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.449 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "C25F800B27ED8248794A06C8D62399DB")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_465326406 = (socket.getTcpNoDelay());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456273097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456273097;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.449 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "B1D2011E86C7CFC9785385B6C89B46F2")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_1658551186 = (socket.getReuseAddress());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241978795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241978795;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.449 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "DE6A7B22AF9B1F1BC6221ACF020B2CDD")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_1119790527 = (socket.getOOBInline());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3872850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_3872850;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.449 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "6F709C9A2F06201472B15C3D113DCBC8")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_1509647659 = (socket.getKeepAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771985511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771985511;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.469 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "768D5A6E3A38523584D7E23035A65E10")
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_269648781 = (socket.getTrafficClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49503575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49503575;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.469 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "5FBF717E4A6C0424F0762C6672EE9DEA")
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_1935195206 = (socket.getSoTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080773646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080773646;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.469 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "DF4CADA26B4B8C16D038C88FA3C09C9B")
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_693527216 = (socket.getSoLinger());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625919996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625919996;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.469 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "F511DC2A10C087E95CA60BB657C1E886")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_122380701 = (socket.getSendBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842141809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842141809;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.470 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "614484C66032A634E7923D2796CC8F0A")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_1832939704 = (socket.getReceiveBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522909967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522909967;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.471 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "5F53F1D94F1505D8830F392635885385")
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_1350084785 = (socket.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146583227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146583227;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.471 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "9CEF2B2D9B038D0E35DDFCC26AEC2734")
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_595723764 = (socket.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283384155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_283384155;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.471 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "1AFDD8542705C14235CD6906CF4FB942")
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_114927737 = (socket.isBound());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647514656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647514656;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.471 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "EE4E3C79DD11C0FB8C547056F7F956FD")
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_1564364899 = (socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376735676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376735676;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.471 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "4B7B32F38F4FD4B76F2D14C3CA5BE93B")
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_1830889314 = (socket.isInputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416854585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416854585;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.472 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "C1BAF91F74DB08B4DF968F9AFE5E3E6B")
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_362166681 = (socket.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497254330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497254330;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.472 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "D81D7254C6BB4ED2AB4F0390A6D6293C")
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_810029678 = (socket.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191890216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191890216;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
}

