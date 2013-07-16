package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class OpenSSLSocketImplWrapper extends OpenSSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.828 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.830 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "A5B558FEF1208ED6FA02558FADAD9F6F")
    protected  OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        addTaint(sslParameters.getTaint());
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
    if(!socket.isConnected())        
        {
            SocketException var3EEAB102670EF01EF4AB15A481BD6DE7_1263204349 = new SocketException("Socket is not connected.");
            var3EEAB102670EF01EF4AB15A481BD6DE7_1263204349.addTaint(taint);
            throw var3EEAB102670EF01EF4AB15A481BD6DE7_1263204349;
        } //End block
        this.socket = socket;
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.831 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "48EC8EFC879FEE039584521A50CA36B2")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_457004404 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_457004404.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_457004404;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.831 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "FE7523C73677260A51AFCAA116B071EB")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_467417926 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_467417926.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_467417926;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.832 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "5FF79CDEB5F8AC552574A41D4D84582B")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_1010338723 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_1010338723.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_1010338723;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.832 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "6D9DABB08315BD2B775697C7071C6233")
    @Override
    public SocketAddress getRemoteSocketAddress() {
SocketAddress var4967962CF7D2DE2821745DC37AD1C991_813959940 =         socket.getRemoteSocketAddress();
        var4967962CF7D2DE2821745DC37AD1C991_813959940.addTaint(taint);
        return var4967962CF7D2DE2821745DC37AD1C991_813959940;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.832 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "89E1252409D188D7633DDAE6A35C75BE")
    @Override
    public SocketAddress getLocalSocketAddress() {
SocketAddress var1C6F9B0AD89BA50278597144BF3BD232_2088881773 =         socket.getLocalSocketAddress();
        var1C6F9B0AD89BA50278597144BF3BD232_2088881773.addTaint(taint);
        return var1C6F9B0AD89BA50278597144BF3BD232_2088881773;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.832 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "57DEE5C22B6B0E7238FD61124844F89C")
    @Override
    public InetAddress getLocalAddress() {
InetAddress var0C541A2DEB3DFBAE24BA22015AE99BEB_9602230 =         socket.getLocalAddress();
        var0C541A2DEB3DFBAE24BA22015AE99BEB_9602230.addTaint(taint);
        return var0C541A2DEB3DFBAE24BA22015AE99BEB_9602230;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.833 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "E9F5ABC012FA2F03F8FD2B026F3D30F9")
    @Override
    public InetAddress getInetAddress() {
InetAddress varE20C5CD772B1ECBEFE0A81A1658EEE73_1061618743 =         socket.getInetAddress();
        varE20C5CD772B1ECBEFE0A81A1658EEE73_1061618743.addTaint(taint);
        return varE20C5CD772B1ECBEFE0A81A1658EEE73_1061618743;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.833 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "93CA44C544BA6DE6C1498298C040EE6F")
    @Override
    public String toString() {
String var21AB22A25A1A739FCD6F0BB333FF92AB_1935369524 =         "SSL socket over " + socket.toString();
        var21AB22A25A1A739FCD6F0BB333FF92AB_1935369524.addTaint(taint);
        return var21AB22A25A1A739FCD6F0BB333FF92AB_1935369524;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.833 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "D9C2D5E2011588A2DB8A5A29406FBD55")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        addTaint(linger);
        addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.834 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "6D19A99220A92890F100ACB9F0485C14")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.834 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "381910E8A2F6BF913BBDC9C262360D18")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.834 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "21835C9586E06EF714A7BF25034B5F9D")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.835 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "F0919E51ED1A379DDBED086BE5BE4460")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.835 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "C23066FF274F3C397AAB44BC26DD41F3")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        addTaint(to);
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
        //super.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.835 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "C638432B8B989C1373E312623B4C2B0E")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.836 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "01C5FB19F1C1FDC896F46CD6D5589930")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.836 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "0CA2C7C83C9E7F01A2718D099091BBB7")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean var4CCD8A7A38B4B8671074501B5E3633E5_1789239161 = (socket.getTcpNoDelay());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1643884586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1643884586;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.836 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "C6134EA2C936E358EE6FEB9F0ECE3F87")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var4628784E228E345E2813D697BFE9B746_993263603 = (socket.getReuseAddress());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948517576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948517576;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.836 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "3F917973FDFFC29209F2619FF7917B8C")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varFAD80CD1DB86370B01FE9D97B3E4556E_623323325 = (socket.getOOBInline());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012435635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012435635;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.837 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "2921BF349B12C8EF07B51147544F6C8D")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean varCBF15E1118CC98EA3B97F686AC0AEDCD_1985522042 = (socket.getKeepAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533949615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533949615;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.837 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "8484988E5BDC442F2E96DAC6A54AD9F5")
    @Override
    public int getTrafficClass() throws SocketException {
        int var06B3347FBAB106089124EBB7BAF9C06F_842980291 = (socket.getTrafficClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790999401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790999401;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.837 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "DAF47B4D7F73ABE33B7E9DAF6F2E9B99")
    @Override
    public int getSoTimeout() throws SocketException {
        int var622378DB66A07CAD9A3E86701B2908C7_510430027 = (socket.getSoTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768662815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768662815;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.837 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "0497F2186C6701423F3FE280D36D5F56")
    @Override
    public int getSoLinger() throws SocketException {
        int var00FB217742FB71801328DCE9ECB4FC74_479765663 = (socket.getSoLinger());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076488662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076488662;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.837 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "8599C5271F71A707E81A3CDBDC2737E4")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var90E7C21E941E280114A988C4C8C224B1_954564305 = (socket.getSendBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491575113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491575113;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.838 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "6A2601216B2491B6521F4BA9F5209830")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var0FBD33505F1A0A9CC9CCE32A5178860B_605762222 = (socket.getReceiveBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686261616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686261616;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.838 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "0DFDA382BE79D73B724C5B5A996D5EC8")
    @Override
    public boolean isConnected() {
        boolean varBDC305DC6896529D4FC79DADA94ACA4B_1807054344 = (socket.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500362863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500362863;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.838 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "C2FEEBD0B3372F3752E87659530A7B7D")
    @Override
    public boolean isClosed() {
        boolean var05DB3DDF0F9762784C2AF19041EA8306_448417471 = (socket.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176035560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176035560;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.838 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "593EC412CDE8716998AF409582FD138F")
    @Override
    public boolean isBound() {
        boolean var8D17B714197D609719CB8C755D53C4C5_1117417420 = (socket.isBound());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638378432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638378432;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.839 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "7320F77958D55586B415A294B559086E")
    @Override
    public boolean isOutputShutdown() {
        boolean var49B4B35B06522D374383DC955CD08600_1306583936 = (socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70657871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70657871;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.839 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "61995CD0B77BB6FDDF1B92A71425A39E")
    @Override
    public boolean isInputShutdown() {
        boolean varCA8892D09142B36BCA5D1C2D7F92E8DE_708493685 = (socket.isInputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243418770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243418770;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.839 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "64CDF2E54BD483C6E12206AEDD771A9C")
    @Override
    public int getPort() {
        int varFDC7ECE1B4D3FEEF411FEEC959819873_1106993903 = (socket.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235702232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235702232;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.839 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "574FFEA0F7FA4E058334FEC764805CA9")
    @Override
    public int getLocalPort() {
        int var7FA5C72484BCE6A4744A98294631163F_528148077 = (socket.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843016087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843016087;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
}

