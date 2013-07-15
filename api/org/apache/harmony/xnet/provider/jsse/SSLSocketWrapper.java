package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class SSLSocketWrapper extends SSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.427 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.427 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "FF4D5BDA5C4AFB5D1A6A640264C26B17", hash_generated_method = "5EED383929661E3CE140252CD84D9132")
    protected  SSLSocketWrapper(Socket socket, boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(sslParameters);
        addTaint(sslParameters.getTaint());
    if(!socket.isConnected())        
        {
            SocketException var3EEAB102670EF01EF4AB15A481BD6DE7_400254347 = new SocketException("Socket is not connected.");
            var3EEAB102670EF01EF4AB15A481BD6DE7_400254347.addTaint(taint);
            throw var3EEAB102670EF01EF4AB15A481BD6DE7_400254347;
        } //End block
        this.socket = socket;
        this.autoClose = autoClose;
        init();
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
        //this.autoClose = autoClose;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "9FF3340D77F2F34483025CED36A00A30", hash_generated_method = "7D37A0175C350D9CCFCEE1762B40E38E")
    @Override
    protected void initTransportLayer() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
        // ---------- Original Method ----------
        //input = socket.getInputStream();
        //output = socket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "BD47C9CE6748D7B1802F0F857351CC5A", hash_generated_method = "D4E0DDB20E7BC63059C4D773A969108B")
    @Override
    protected void closeTransportLayer() throws IOException {
    if(autoClose && (input != null))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "6E2E48E1976DAC6DF93A915E06E80977")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_1145804970 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_1145804970.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_1145804970;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "6C6911FBD24F574F0E0CFA69EBE69107")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_1893085648 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_1893085648.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_1893085648;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.428 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "05BF5426C5A3D87F9B13B810BF2E1342")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_1480280202 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_1480280202.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_1480280202;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "65EA10B123AF223988B210399707DF5C")
    @Override
    public SocketAddress getRemoteSocketAddress() {
SocketAddress var4967962CF7D2DE2821745DC37AD1C991_1611415295 =         socket.getRemoteSocketAddress();
        var4967962CF7D2DE2821745DC37AD1C991_1611415295.addTaint(taint);
        return var4967962CF7D2DE2821745DC37AD1C991_1611415295;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "14F4240BABC337D977F5B52FC2D2119A")
    @Override
    public SocketAddress getLocalSocketAddress() {
SocketAddress var1C6F9B0AD89BA50278597144BF3BD232_2086258820 =         socket.getLocalSocketAddress();
        var1C6F9B0AD89BA50278597144BF3BD232_2086258820.addTaint(taint);
        return var1C6F9B0AD89BA50278597144BF3BD232_2086258820;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "699D4455487BFC05508550610BD0E8AC")
    @Override
    public InetAddress getLocalAddress() {
InetAddress var0C541A2DEB3DFBAE24BA22015AE99BEB_1144724055 =         socket.getLocalAddress();
        var0C541A2DEB3DFBAE24BA22015AE99BEB_1144724055.addTaint(taint);
        return var0C541A2DEB3DFBAE24BA22015AE99BEB_1144724055;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "65AFD0A3D6AAC63CF0110EAB3AF365D7")
    @Override
    public InetAddress getInetAddress() {
InetAddress varE20C5CD772B1ECBEFE0A81A1658EEE73_1138220796 =         socket.getInetAddress();
        varE20C5CD772B1ECBEFE0A81A1658EEE73_1138220796.addTaint(taint);
        return varE20C5CD772B1ECBEFE0A81A1658EEE73_1138220796;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "366FA5C4C84E46341399C5DB3F71828E")
    @Override
    public String toString() {
String var21AB22A25A1A739FCD6F0BB333FF92AB_231234496 =         "SSL socket over " + socket.toString();
        var21AB22A25A1A739FCD6F0BB333FF92AB_231234496.addTaint(taint);
        return var21AB22A25A1A739FCD6F0BB333FF92AB_231234496;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "D9C2D5E2011588A2DB8A5A29406FBD55")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        addTaint(linger);
        addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "6D19A99220A92890F100ACB9F0485C14")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "381910E8A2F6BF913BBDC9C262360D18")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "21835C9586E06EF714A7BF25034B5F9D")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.429 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "F0919E51ED1A379DDBED086BE5BE4460")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.430 -0400", hash_original_method = "99398BF4E61DD284BEAF3BF1D99561D2", hash_generated_method = "BD07127514127323B8A0EFAD0B7B89D5")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        addTaint(to);
        socket.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.430 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "C638432B8B989C1373E312623B4C2B0E")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.430 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "01C5FB19F1C1FDC896F46CD6D5589930")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.430 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "7E3E5D78F6B6A056AA7B0DF9187767C0")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean var4CCD8A7A38B4B8671074501B5E3633E5_1447984018 = (socket.getTcpNoDelay());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785333326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785333326;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.431 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "EFE0F26DBAF2D7B6346C982912CE5861")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var4628784E228E345E2813D697BFE9B746_2065042609 = (socket.getReuseAddress());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480959888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480959888;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.431 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "AB2A78B6B28D3422BE5EC46D85CDF61F")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varFAD80CD1DB86370B01FE9D97B3E4556E_838477470 = (socket.getOOBInline());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732661069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732661069;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.431 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "5A24442D65C0A2D83E6B71DA2782935B")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean varCBF15E1118CC98EA3B97F686AC0AEDCD_678515605 = (socket.getKeepAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912881165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912881165;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.431 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "455C2BED28C94B4DD832C26A80C803A5")
    @Override
    public int getTrafficClass() throws SocketException {
        int var06B3347FBAB106089124EBB7BAF9C06F_1757023405 = (socket.getTrafficClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766381033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766381033;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.431 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "3DF1D92D621F714B33B9E90E8D66FC28")
    @Override
    public int getSoTimeout() throws SocketException {
        int var622378DB66A07CAD9A3E86701B2908C7_702395049 = (socket.getSoTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389809270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389809270;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "C688C0812118243F17E93CDD5B215809")
    @Override
    public int getSoLinger() throws SocketException {
        int var00FB217742FB71801328DCE9ECB4FC74_309023091 = (socket.getSoLinger());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558812312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558812312;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "315796039E55B79BEE0E4023ADF50E20")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var90E7C21E941E280114A988C4C8C224B1_441715178 = (socket.getSendBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748192848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748192848;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "2286DF561CBE228A4C54500AB1C36736")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var0FBD33505F1A0A9CC9CCE32A5178860B_1362675907 = (socket.getReceiveBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128206527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128206527;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "9BB31F731875360E7FFE22225019BA86")
    @Override
    public boolean isConnected() {
        boolean varBDC305DC6896529D4FC79DADA94ACA4B_1255860858 = (socket.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766568746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766568746;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "7598B540EB3CD25631305BB3BB643179")
    @Override
    public boolean isClosed() {
        boolean var05DB3DDF0F9762784C2AF19041EA8306_1190990107 = (socket.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655391317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655391317;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "F6D0EA980A9B09EDB150AC32C28C717D")
    @Override
    public boolean isBound() {
        boolean var8D17B714197D609719CB8C755D53C4C5_2041596384 = (socket.isBound());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575751138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575751138;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "23F9827DCD5512186699F53B2F32F369")
    @Override
    public boolean isOutputShutdown() {
        boolean var49B4B35B06522D374383DC955CD08600_1873021430 = (socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038195216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038195216;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "D970BBDADD3835DEF4B65A4799A7EB0C")
    @Override
    public boolean isInputShutdown() {
        boolean varCA8892D09142B36BCA5D1C2D7F92E8DE_140362226 = (socket.isInputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455996602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_455996602;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.432 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "672E5B03154FE51CC4F7E3293930B3E4")
    @Override
    public int getPort() {
        int varFDC7ECE1B4D3FEEF411FEEC959819873_1289196106 = (socket.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184160642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184160642;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.433 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "3D8373574945AC8728179AA22A668FE9")
    @Override
    public int getLocalPort() {
        int var7FA5C72484BCE6A4744A98294631163F_1018720336 = (socket.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175871741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175871741;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.433 -0400", hash_original_method = "80D37FA57838689D0D9ECABB08EA2811", hash_generated_method = "BA4CE1809FAE331544F7ABCAB07BC6A2")
    @Override
    public FileDescriptor getFileDescriptor$() {
FileDescriptor varECF71702861DD6150A427D89C35684D2_651777888 =         socket.getFileDescriptor$();
        varECF71702861DD6150A427D89C35684D2_651777888.addTaint(taint);
        return varECF71702861DD6150A427D89C35684D2_651777888;
        // ---------- Original Method ----------
        //return socket.getFileDescriptor$();
    }

    
}

