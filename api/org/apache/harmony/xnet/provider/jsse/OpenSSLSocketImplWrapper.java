package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class OpenSSLSocketImplWrapper extends OpenSSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.619 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.620 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "2463EAFEC87B9BC41D74E902CD43312A")
    protected  OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_819738346 = (!socket.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected.");
            } 
        } 
        this.socket = socket;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        addTaint(sslParameters.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.620 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "1A064EC557450C7EA2764FB4DB01E4C0")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        addTaint(timeout);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.620 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "B10D9E4BDDC1EC0BBBD388520B8D78B5")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.621 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "879B551EC89CF9FC73B28F75178FBD21")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        addTaint(sockaddr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.621 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "9D080AFCE7179FB78D19BD8D790EAC7B")
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2060751142 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2060751142 = socket.getRemoteSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2060751142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2060751142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.621 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "F03AC51C1C565817953D4691A8A778B1")
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2001978687 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2001978687 = socket.getLocalSocketAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2001978687.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2001978687;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.622 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "F8107217F97F88EC118F3C64DD04EC3E")
    @Override
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1572252067 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1572252067 = socket.getLocalAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1572252067.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1572252067;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.622 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "7093E8AFC53A6F34D35F1584B8A9FEA2")
    @Override
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_16464525 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_16464525 = socket.getInetAddress();
        varB4EAC82CA7396A68D541C85D26508E83_16464525.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_16464525;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.622 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "2575406C903340DA64473ADA527A9E02")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1047733688 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1047733688 = "SSL socket over " + socket.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1047733688.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1047733688;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.623 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "8BF63EB618A8A20BA3045AD7CE0301B2")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        socket.setSoLinger(on, linger);
        addTaint(on);
        addTaint(linger);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.623 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "ADDDBEBB6020BAC3000366C593A8E5FA")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        socket.setTcpNoDelay(on);
        addTaint(on);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.623 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "F51E15FEAA1AAF350A87A7B52B05C4BC")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        socket.setReuseAddress(on);
        addTaint(on);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.623 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "2864058A22F7EA46FC805B79D732BACF")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        socket.setKeepAlive(on);
        addTaint(on);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.623 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "E88C8D8FCC1216E91574A36430F7AE3A")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        socket.setTrafficClass(tos);
        addTaint(tos);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.625 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "82C42B1A0DBBF3FEB090668865C9F27F")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        addTaint(to);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.626 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "AE25A2C62767B956A81F8B9CCF73EAEA")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        socket.setSendBufferSize(size);
        addTaint(size);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.626 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "A88C32957F249CFF760FCD4B7090D09C")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        addTaint(size);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.626 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "8C7365719CE7D738A7EAA37BB801AC0C")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_1369433092 = (socket.getTcpNoDelay());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108271697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108271697;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.627 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "6E9478D07B2ECF9CF79DD9866504F0B7")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_946783489 = (socket.getReuseAddress());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798878179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798878179;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.627 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "0EDBE19C1831F4F290A0B92ED048F094")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_1415459537 = (socket.getOOBInline());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922798522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922798522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.627 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "136E89A137336714F668129F941BBE9D")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_1277454075 = (socket.getKeepAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026036381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026036381;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.627 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "FF33478D526692083020247712825EF5")
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_1988204224 = (socket.getTrafficClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651390943 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651390943;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.628 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "A0C3ACB9CF8EC2F320F8E173E56BD0F0")
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_1948388011 = (socket.getSoTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130418128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130418128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.628 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "E6567CE2710E356884083F0CA0CB8F5F")
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_1852576485 = (socket.getSoLinger());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956279316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956279316;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.629 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "DD337CA4B0B7BD4F651A8FBC768895E6")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_753730252 = (socket.getSendBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603746017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603746017;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.629 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "1E176E384F9BD3EB1AF80D274743AECF")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_1791712830 = (socket.getReceiveBufferSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586447146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586447146;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.629 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "E39E1DE56C3D1A5116BE39A54454F4EC")
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_1540172180 = (socket.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689347928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689347928;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.630 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "AD5BE4421DE70D3226C688AAE09896DA")
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_393814668 = (socket.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002354216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002354216;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.630 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "AB7C94CE97BA1653C079F63AEAB114F5")
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_571144226 = (socket.isBound());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026946683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026946683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.630 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "2593169AB78A57F2BF5F2CA4DB1582A8")
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_1522375891 = (socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936164294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936164294;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.631 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "7BC479FBA18EBD14298557C748E9DE3B")
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_1630237618 = (socket.isInputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023182447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023182447;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.631 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "711C4CF03158C35F914C31E294ABB042")
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_1704782473 = (socket.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073842711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073842711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.632 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "EDE0D9646B7AD876F518F9472EBE61B3")
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_878557651 = (socket.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115359564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115359564;
        
        
    }

    
}

