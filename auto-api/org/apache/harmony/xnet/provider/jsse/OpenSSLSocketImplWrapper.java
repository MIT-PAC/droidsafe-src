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
    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.060 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "5FF8962E2AEE50A6315B53EEF7AC2684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(socket.dsTaint);
        dsTaint.addTaint(autoClose);
        dsTaint.addTaint(sslParameters.dsTaint);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_269934472 = (!socket.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.060 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "CB13F7FA8A9145445D8F474623E5CBAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.060 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "0F937A1E6686426D7510A061EB5B11B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.060 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "A48CD1FFBFBFF3F37BEC9CDC81A13210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.060 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "FA92479AAA8E77B4BA00243E27C14BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress var57F4BC824DA3D2961032D37649BB0B16_880510001 = (socket.getRemoteSocketAddress());
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.061 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "0B2126E3EE1384A8AB227CEAB38032BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varA7B65C5C45F59298F48F62C45AB28069_619317031 = (socket.getLocalSocketAddress());
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.061 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "7ED07055DC29BE7026CDCA47456A3D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InetAddress getLocalAddress() {
        InetAddress var9F5AD984AB652701C81523C2C0538781_283344870 = (socket.getLocalAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.061 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "5B82A85079382E97BF187D49188EFD2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InetAddress getInetAddress() {
        InetAddress var0A5D74F58210CCE030115861B00B7780_1258921853 = (socket.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.061 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "1F038F994BBA74EED24C2D783CEFD8F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var176B86E9557D376D4D78898013AC7FC9_448129791 = ("SSL socket over " + socket.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.061 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "507D678B4086B9848FF8D51B06E61A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        dsTaint.addTaint(linger);
        dsTaint.addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.065 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "5DC8D6ED5B924050AA4FF67C9A40E42D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "AD1996A8B4B8A39D57ED7823EF78B2AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "943F8095B2C5B9EF5B1C098A111EF262")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "4387667307DB8DD5FAC42434D073B26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        dsTaint.addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "E797ACEC8B05678E97D6303A77C6870A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSoTimeout(int to) throws SocketException {
        dsTaint.addTaint(to);
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
        //super.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "8BC1C613A2AEC8B58B7B0EC85656CC5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "C9F4403A60529AAD84745968F154F589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.066 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "7F8566D48E7484BA98B64C58F683DB99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_832620692 = (socket.getTcpNoDelay());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "A32EE99328DE5C6A378880D1928D14BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_751820779 = (socket.getReuseAddress());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "1B0D4C4A2A2F8371B3631C144761DC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_1265586341 = (socket.getOOBInline());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "F4E24E9912CA453ADCDD120AC852A068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_1217365245 = (socket.getKeepAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "336E5044DF54AA3F62D810206192D419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_2021381104 = (socket.getTrafficClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "67E98D955963DE9047B3048DC1438F67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_1134670501 = (socket.getSoTimeout());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.067 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "6A290B66114056112BAB2F649505C22B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_1049319366 = (socket.getSoLinger());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "4A700EAA320979AF1D2F85F4116689D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_1302073480 = (socket.getSendBufferSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "61F88AAD8967537F19609F481CC607B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_503147946 = (socket.getReceiveBufferSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "A51DB5423E842E87C5FC1973B8D78492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_190432074 = (socket.isConnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "309520D57906CD99EF879EE508D88178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_1232151557 = (socket.isClosed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "3590185A677376E549D6396BA2A96B8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_1935601121 = (socket.isBound());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "BB938F9479E6294EAA5BB5D974C7C3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_2016972113 = (socket.isOutputShutdown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "3D929E6996D1190198F521FE6C9958A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_1584665605 = (socket.isInputShutdown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.068 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "0B6A2A202A09A9C4D5D79AF5C0DFEE98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_1594769389 = (socket.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.069 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "7914A08BF1A91C1192DBE5D8DB9EAC4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_1775891317 = (socket.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
}

