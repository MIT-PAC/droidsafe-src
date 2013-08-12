package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;






public class OpenSSLSocketImplWrapper extends OpenSSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.993 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.993 -0400", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "DBF09A40826FAEF6321F39FCB2544343")
    protected  OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        addTaint(sslParameters.getTaint());
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        if(!socket.isConnected())        
        {
            SocketException var3EEAB102670EF01EF4AB15A481BD6DE7_1190721644 = new SocketException("Socket is not connected.");
            var3EEAB102670EF01EF4AB15A481BD6DE7_1190721644.addTaint(taint);
            throw var3EEAB102670EF01EF4AB15A481BD6DE7_1190721644;
        } //End block
        this.socket = socket;
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.994 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "26393B784D3BC3BB6797ED1EA335C51E")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_99558554 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_99558554.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_99558554;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.994 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "84D417A1B53608E13D4AC214F0835311")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_500874067 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_500874067.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_500874067;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.994 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "2FDE959A69F80A20931141B149C20001")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_588373377 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_588373377.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_588373377;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.995 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "A8EDD6721E4F5AE68D07D8E5943CF25A")
    @Override
    public SocketAddress getRemoteSocketAddress() {
SocketAddress var4967962CF7D2DE2821745DC37AD1C991_749736786 =         socket.getRemoteSocketAddress();
        var4967962CF7D2DE2821745DC37AD1C991_749736786.addTaint(taint);
        return var4967962CF7D2DE2821745DC37AD1C991_749736786;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.995 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "618377B2914CA5362B5E91698FE2D5C1")
    @Override
    public SocketAddress getLocalSocketAddress() {
SocketAddress var1C6F9B0AD89BA50278597144BF3BD232_1430827505 =         socket.getLocalSocketAddress();
        var1C6F9B0AD89BA50278597144BF3BD232_1430827505.addTaint(taint);
        return var1C6F9B0AD89BA50278597144BF3BD232_1430827505;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.995 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "338E12CBD4D068C05C2F03F7339469C6")
    @Override
    public InetAddress getLocalAddress() {
InetAddress var0C541A2DEB3DFBAE24BA22015AE99BEB_1268383364 =         socket.getLocalAddress();
        var0C541A2DEB3DFBAE24BA22015AE99BEB_1268383364.addTaint(taint);
        return var0C541A2DEB3DFBAE24BA22015AE99BEB_1268383364;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.995 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "D3F7E6D65389B55DD8A04E8FBE5FCE72")
    @Override
    public InetAddress getInetAddress() {
InetAddress varE20C5CD772B1ECBEFE0A81A1658EEE73_156348758 =         socket.getInetAddress();
        varE20C5CD772B1ECBEFE0A81A1658EEE73_156348758.addTaint(taint);
        return varE20C5CD772B1ECBEFE0A81A1658EEE73_156348758;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.996 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "4858B3F42B5025646345484B3C2F09DA")
    @Override
    public String toString() {
String var21AB22A25A1A739FCD6F0BB333FF92AB_23360976 =         "SSL socket over " + socket.toString();
        var21AB22A25A1A739FCD6F0BB333FF92AB_23360976.addTaint(taint);
        return var21AB22A25A1A739FCD6F0BB333FF92AB_23360976;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.996 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "D9C2D5E2011588A2DB8A5A29406FBD55")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        addTaint(linger);
        addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.996 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "6D19A99220A92890F100ACB9F0485C14")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.997 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "381910E8A2F6BF913BBDC9C262360D18")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.997 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "21835C9586E06EF714A7BF25034B5F9D")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.997 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "F0919E51ED1A379DDBED086BE5BE4460")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.997 -0400", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "C23066FF274F3C397AAB44BC26DD41F3")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        addTaint(to);
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
        //super.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.997 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "C638432B8B989C1373E312623B4C2B0E")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.998 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "01C5FB19F1C1FDC896F46CD6D5589930")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.998 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "C60453F38FAA5B27F25F29063FFCD98C")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean var4CCD8A7A38B4B8671074501B5E3633E5_950981699 = (socket.getTcpNoDelay());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428646766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428646766;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.998 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "D58564EBAE0CEE304C2899B9C050D5BF")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var4628784E228E345E2813D697BFE9B746_1929935547 = (socket.getReuseAddress());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379876234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379876234;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.998 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "BE770967F8D08BD480365F148E4E6095")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varFAD80CD1DB86370B01FE9D97B3E4556E_713769940 = (socket.getOOBInline());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432607051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432607051;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.999 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "4DFDC86B2888C576A0215F0B12AD7CB3")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean varCBF15E1118CC98EA3B97F686AC0AEDCD_50878793 = (socket.getKeepAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614721000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614721000;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.999 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "AF4AAA9A25B607096894A24711287583")
    @Override
    public int getTrafficClass() throws SocketException {
        int var06B3347FBAB106089124EBB7BAF9C06F_1755288643 = (socket.getTrafficClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139327724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139327724;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.999 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "8B1286005DC4B7D3C7B33909A98CEBB8")
    @Override
    public int getSoTimeout() throws SocketException {
        int var622378DB66A07CAD9A3E86701B2908C7_247476970 = (socket.getSoTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91426154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91426154;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.000 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "5715F1ADC2A305A3E2FF7ED18C0D24E9")
    @Override
    public int getSoLinger() throws SocketException {
        int var00FB217742FB71801328DCE9ECB4FC74_980307793 = (socket.getSoLinger());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026357901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026357901;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.000 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "8C616AA0E26FF6F1B7A47C0D4D1E9F46")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var90E7C21E941E280114A988C4C8C224B1_1877601428 = (socket.getSendBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984201101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984201101;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.000 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "1D0FFC065020202CF1A94D9DF60F0834")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var0FBD33505F1A0A9CC9CCE32A5178860B_282751802 = (socket.getReceiveBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462013022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462013022;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.000 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "F8E3A0A744A4F0B50546D9181D63EB7A")
    @Override
    public boolean isConnected() {
        boolean varBDC305DC6896529D4FC79DADA94ACA4B_1942263736 = (socket.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979411465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979411465;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.001 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "C418706D44E6BB5D5F1A2F2F0F42451A")
    @Override
    public boolean isClosed() {
        boolean var05DB3DDF0F9762784C2AF19041EA8306_986381736 = (socket.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713117009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713117009;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.001 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "833B27AD23BAFBD564437624CEEFE728")
    @Override
    public boolean isBound() {
        boolean var8D17B714197D609719CB8C755D53C4C5_65705960 = (socket.isBound());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341081310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341081310;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.001 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "D9A303B7B4D5BE985D407E7900AF3EC0")
    @Override
    public boolean isOutputShutdown() {
        boolean var49B4B35B06522D374383DC955CD08600_1521113841 = (socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485106120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485106120;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.001 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "B06B4E4F24549A6A2AD31A23E4872D2D")
    @Override
    public boolean isInputShutdown() {
        boolean varCA8892D09142B36BCA5D1C2D7F92E8DE_1857770644 = (socket.isInputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807878665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807878665;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.002 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "81F09F740CAAA8D00384DC509BC47610")
    @Override
    public int getPort() {
        int varFDC7ECE1B4D3FEEF411FEEC959819873_2139878125 = (socket.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586181606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586181606;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.002 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "5E5138CB7A47FDAC5CD0F21BC2CD6C23")
    @Override
    public int getLocalPort() {
        int var7FA5C72484BCE6A4744A98294631163F_1761418937 = (socket.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944285689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944285689;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
}

