package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;






public class SSLSocketWrapper extends SSLSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.601 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.601 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.602 -0400", hash_original_method = "FF4D5BDA5C4AFB5D1A6A640264C26B17", hash_generated_method = "2115C9FD7C8B96CE2F2C67492D7A6F13")
    protected  SSLSocketWrapper(Socket socket, boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(sslParameters);
        addTaint(sslParameters.getTaint());
        if(!socket.isConnected())        
        {
            SocketException var3EEAB102670EF01EF4AB15A481BD6DE7_1278950768 = new SocketException("Socket is not connected.");
            var3EEAB102670EF01EF4AB15A481BD6DE7_1278950768.addTaint(taint);
            throw var3EEAB102670EF01EF4AB15A481BD6DE7_1278950768;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.603 -0400", hash_original_method = "9FF3340D77F2F34483025CED36A00A30", hash_generated_method = "7D37A0175C350D9CCFCEE1762B40E38E")
    @Override
    protected void initTransportLayer() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
        // ---------- Original Method ----------
        //input = socket.getInputStream();
        //output = socket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.603 -0400", hash_original_method = "BD47C9CE6748D7B1802F0F857351CC5A", hash_generated_method = "D4E0DDB20E7BC63059C4D773A969108B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.604 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "BE8DECB54A5F440E2BE976F2F9CB74AF")
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_504553315 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_504553315.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_504553315;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.604 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "95BDBC17C3A91E524ADBCD28B036E53E")
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_1080391530 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_1080391530.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_1080391530;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.605 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "BFDEB2BFFFC2251B1649051846E03524")
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        addTaint(sockaddr.getTaint());
        IOException var24F53EE647420CC7D8443F7A9913471F_692684299 = new IOException("Underlying socket is already connected.");
        var24F53EE647420CC7D8443F7A9913471F_692684299.addTaint(taint);
        throw var24F53EE647420CC7D8443F7A9913471F_692684299;
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.605 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "EDFA3CC2AA793877EA6E6F6203544E90")
    @Override
    public SocketAddress getRemoteSocketAddress() {
SocketAddress var4967962CF7D2DE2821745DC37AD1C991_567972489 =         socket.getRemoteSocketAddress();
        var4967962CF7D2DE2821745DC37AD1C991_567972489.addTaint(taint);
        return var4967962CF7D2DE2821745DC37AD1C991_567972489;
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.606 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "8B71BEC6B58F99250EDC74310DDD4509")
    @Override
    public SocketAddress getLocalSocketAddress() {
SocketAddress var1C6F9B0AD89BA50278597144BF3BD232_561283169 =         socket.getLocalSocketAddress();
        var1C6F9B0AD89BA50278597144BF3BD232_561283169.addTaint(taint);
        return var1C6F9B0AD89BA50278597144BF3BD232_561283169;
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.606 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "BC1262FE7D62BE0CD43545D7CE89677B")
    @Override
    public InetAddress getLocalAddress() {
InetAddress var0C541A2DEB3DFBAE24BA22015AE99BEB_1422280074 =         socket.getLocalAddress();
        var0C541A2DEB3DFBAE24BA22015AE99BEB_1422280074.addTaint(taint);
        return var0C541A2DEB3DFBAE24BA22015AE99BEB_1422280074;
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.607 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "48979FACBEA1A8C6D99DBDA3235D1FB7")
    @Override
    public InetAddress getInetAddress() {
InetAddress varE20C5CD772B1ECBEFE0A81A1658EEE73_411245620 =         socket.getInetAddress();
        varE20C5CD772B1ECBEFE0A81A1658EEE73_411245620.addTaint(taint);
        return varE20C5CD772B1ECBEFE0A81A1658EEE73_411245620;
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.608 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "C9BB83135AC9C20847F26AB1F0DF85E6")
    @Override
    public String toString() {
String var21AB22A25A1A739FCD6F0BB333FF92AB_1510243818 =         "SSL socket over " + socket.toString();
        var21AB22A25A1A739FCD6F0BB333FF92AB_1510243818.addTaint(taint);
        return var21AB22A25A1A739FCD6F0BB333FF92AB_1510243818;
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.608 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "D9C2D5E2011588A2DB8A5A29406FBD55")
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        addTaint(linger);
        addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.608 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "6D19A99220A92890F100ACB9F0485C14")
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.609 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "381910E8A2F6BF913BBDC9C262360D18")
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.609 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "21835C9586E06EF714A7BF25034B5F9D")
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.610 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "F0919E51ED1A379DDBED086BE5BE4460")
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.610 -0400", hash_original_method = "99398BF4E61DD284BEAF3BF1D99561D2", hash_generated_method = "BD07127514127323B8A0EFAD0B7B89D5")
    @Override
    public void setSoTimeout(int to) throws SocketException {
        addTaint(to);
        socket.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.610 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "C638432B8B989C1373E312623B4C2B0E")
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.610 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "01C5FB19F1C1FDC896F46CD6D5589930")
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.611 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "A5485F8F1E04A681D338137BACB578F2")
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean var4CCD8A7A38B4B8671074501B5E3633E5_1501142712 = (socket.getTcpNoDelay());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295342797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295342797;
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.611 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "7B92F7AC84347542F0730A1CA9DE32B3")
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var4628784E228E345E2813D697BFE9B746_750827370 = (socket.getReuseAddress());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273684475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273684475;
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.611 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "BDDFE848F74F71D2BB5F1504BCF1BBA4")
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varFAD80CD1DB86370B01FE9D97B3E4556E_601219215 = (socket.getOOBInline());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221067339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221067339;
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.612 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "302FA9BB95030A6BAFA6237FB07D9297")
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean varCBF15E1118CC98EA3B97F686AC0AEDCD_1873783120 = (socket.getKeepAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015430586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015430586;
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.612 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "CC62D6EE30300A806D11EDA8F47C114C")
    @Override
    public int getTrafficClass() throws SocketException {
        int var06B3347FBAB106089124EBB7BAF9C06F_1012038311 = (socket.getTrafficClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525760065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525760065;
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.612 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "58945CAEE588DCCC9B4A585C26D820BD")
    @Override
    public int getSoTimeout() throws SocketException {
        int var622378DB66A07CAD9A3E86701B2908C7_1021185538 = (socket.getSoTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610423307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610423307;
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.612 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "9E839989A989F505EDEA23429ED719B5")
    @Override
    public int getSoLinger() throws SocketException {
        int var00FB217742FB71801328DCE9ECB4FC74_730097386 = (socket.getSoLinger());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325957689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325957689;
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.613 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "588302A79E52B2347AC564B180881B5D")
    @Override
    public int getSendBufferSize() throws SocketException {
        int var90E7C21E941E280114A988C4C8C224B1_1485751024 = (socket.getSendBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069357704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069357704;
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.613 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "585F7B1A70D216F5E234E8CFD272E0FD")
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var0FBD33505F1A0A9CC9CCE32A5178860B_843978446 = (socket.getReceiveBufferSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154750354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154750354;
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.613 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "9CFF9DD294662EEC8177978870ED2CB9")
    @Override
    public boolean isConnected() {
        boolean varBDC305DC6896529D4FC79DADA94ACA4B_509700406 = (socket.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50391454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50391454;
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.614 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "D17B0DAECA216D60F9D0C8E158F7D934")
    @Override
    public boolean isClosed() {
        boolean var05DB3DDF0F9762784C2AF19041EA8306_927418502 = (socket.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7783855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7783855;
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.614 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "D7420D02EA4D8913467285DB397D9A66")
    @Override
    public boolean isBound() {
        boolean var8D17B714197D609719CB8C755D53C4C5_1268109521 = (socket.isBound());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019749159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019749159;
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.614 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "17B534DCD2A9A71046D676CF1346CB0A")
    @Override
    public boolean isOutputShutdown() {
        boolean var49B4B35B06522D374383DC955CD08600_1648826487 = (socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854209958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854209958;
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.614 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "DC3A118A6AA1E6E0E2D6BA32B324CE12")
    @Override
    public boolean isInputShutdown() {
        boolean varCA8892D09142B36BCA5D1C2D7F92E8DE_377839517 = (socket.isInputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999583367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999583367;
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.615 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "E26F2C1A6E8083CAFE6E0D6719264DF4")
    @Override
    public int getPort() {
        int varFDC7ECE1B4D3FEEF411FEEC959819873_543802015 = (socket.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131079808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131079808;
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.615 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "9CC6F71FE42224D001B2228C4C947AE3")
    @Override
    public int getLocalPort() {
        int var7FA5C72484BCE6A4744A98294631163F_824813812 = (socket.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537950557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537950557;
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.615 -0400", hash_original_method = "80D37FA57838689D0D9ECABB08EA2811", hash_generated_method = "6BCE734E3B08B79EC500103A6ACD21B5")
    @Override
    public FileDescriptor getFileDescriptor$() {
FileDescriptor varECF71702861DD6150A427D89C35684D2_1177115466 =         socket.getFileDescriptor$();
        varECF71702861DD6150A427D89C35684D2_1177115466.addTaint(taint);
        return varECF71702861DD6150A427D89C35684D2_1177115466;
        // ---------- Original Method ----------
        //return socket.getFileDescriptor$();
    }

    
}

