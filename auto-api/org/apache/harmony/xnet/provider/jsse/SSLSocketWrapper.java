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
    private Socket socket;
    private boolean autoClose;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.273 -0400", hash_original_method = "FF4D5BDA5C4AFB5D1A6A640264C26B17", hash_generated_method = "30937D844053D8706DFCC44CC9E08F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocketWrapper(Socket socket, boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(sslParameters);
        dsTaint.addTaint(socket.dsTaint);
        dsTaint.addTaint(autoClose);
        dsTaint.addTaint(sslParameters.dsTaint);
        {
            boolean varF865E9BFD2A89C8A8567DBB6F973C9E3_589607268 = (!socket.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected.");
            } //End block
        } //End collapsed parenthetic
        init();
        // ---------- Original Method ----------
        //if (!socket.isConnected()) {
            //throw new SocketException("Socket is not connected.");
        //}
        //this.socket = socket;
        //this.autoClose = autoClose;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.273 -0400", hash_original_method = "9FF3340D77F2F34483025CED36A00A30", hash_generated_method = "7D37A0175C350D9CCFCEE1762B40E38E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void initTransportLayer() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
        // ---------- Original Method ----------
        //input = socket.getInputStream();
        //output = socket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "BD47C9CE6748D7B1802F0F857351CC5A", hash_generated_method = "1E0B1F1474B550D60C389DC58E107EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "CB13F7FA8A9145445D8F474623E5CBAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress sockaddr, int timeout) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "0F937A1E6686426D7510A061EB5B11B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress sockaddr) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "A48CD1FFBFBFF3F37BEC9CDC81A13210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bind(SocketAddress sockaddr) throws IOException {
        dsTaint.addTaint(sockaddr.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Underlying socket is already connected.");
        // ---------- Original Method ----------
        //throw new IOException("Underlying socket is already connected.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "3ACCF32EC5D78AAC8317E8D34AC8FEA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress var57F4BC824DA3D2961032D37649BB0B16_1573727312 = (socket.getRemoteSocketAddress());
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getRemoteSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.274 -0400", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "FAA0AE7EB633A6BD1C63774A36D3FC18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varA7B65C5C45F59298F48F62C45AB28069_764599369 = (socket.getLocalSocketAddress());
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "0E9BBE124FCA22DF11E26033411D6EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InetAddress getLocalAddress() {
        InetAddress var9F5AD984AB652701C81523C2C0538781_2069942771 = (socket.getLocalAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "02ADDADB8BDCA7193DC7EDFCA9A8ECA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InetAddress getInetAddress() {
        InetAddress var0A5D74F58210CCE030115861B00B7780_482944871 = (socket.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "6893DDE2F45A0A1C8B3B84028890C32A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var176B86E9557D376D4D78898013AC7FC9_776441097 = ("SSL socket over " + socket.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SSL socket over " + socket.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "507D678B4086B9848FF8D51B06E61A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        dsTaint.addTaint(linger);
        dsTaint.addTaint(on);
        socket.setSoLinger(on, linger);
        // ---------- Original Method ----------
        //socket.setSoLinger(on, linger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "5DC8D6ED5B924050AA4FF67C9A40E42D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setTcpNoDelay(on);
        // ---------- Original Method ----------
        //socket.setTcpNoDelay(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.275 -0400", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "AD1996A8B4B8A39D57ED7823EF78B2AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setReuseAddress(on);
        // ---------- Original Method ----------
        //socket.setReuseAddress(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "943F8095B2C5B9EF5B1C098A111EF262")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setKeepAlive(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        socket.setKeepAlive(on);
        // ---------- Original Method ----------
        //socket.setKeepAlive(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "4387667307DB8DD5FAC42434D073B26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTrafficClass(int tos) throws SocketException {
        dsTaint.addTaint(tos);
        socket.setTrafficClass(tos);
        // ---------- Original Method ----------
        //socket.setTrafficClass(tos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "99398BF4E61DD284BEAF3BF1D99561D2", hash_generated_method = "06B6611BF07CC39866601BA51663203F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSoTimeout(int to) throws SocketException {
        dsTaint.addTaint(to);
        socket.setSoTimeout(to);
        // ---------- Original Method ----------
        //socket.setSoTimeout(to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "8BC1C613A2AEC8B58B7B0EC85656CC5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        socket.setSendBufferSize(size);
        // ---------- Original Method ----------
        //socket.setSendBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "C9F4403A60529AAD84745968F154F589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        socket.setReceiveBufferSize(size);
        // ---------- Original Method ----------
        //socket.setReceiveBufferSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.276 -0400", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "5E295F6A699915019920600955EA0FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getTcpNoDelay() throws SocketException {
        boolean varBA46635E6CCDF82185675B67E617E047_834088828 = (socket.getTcpNoDelay());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getTcpNoDelay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "856739AC65E3A07D6CD64008ABD38E17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getReuseAddress() throws SocketException {
        boolean var349DD5E576D9FD9FFD77BF9D9E1F841C_200863192 = (socket.getReuseAddress());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getReuseAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "7CAF64F64AD36443A38F812CBC1D621D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getOOBInline() throws SocketException {
        boolean varA60A548C5570D20F2C3A5F92AFA9B194_520485118 = (socket.getOOBInline());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getOOBInline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "9C805BC660E62B8CD2BA3231196DF3BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getKeepAlive() throws SocketException {
        boolean var80926F9D34A2BEE6A7C72C9BF525B86C_426027663 = (socket.getKeepAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.getKeepAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "8E4A327A23A46866EA8F710BA8C92E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getTrafficClass() throws SocketException {
        int var9FD32AC8BBC5AB664DDE99BA031613CE_2057473602 = (socket.getTrafficClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getTrafficClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "C65F37BE6D161BD776E6589573DEEBFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSoTimeout() throws SocketException {
        int var5AB257277B73427FABF8A8593CF909D0_1958976417 = (socket.getSoTimeout());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSoTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.277 -0400", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "62BE22AF4F14B5D4DB5412AEDDFB5E71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSoLinger() throws SocketException {
        int varB52599268A19B3CD0A323449BE19BB2F_589307450 = (socket.getSoLinger());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSoLinger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "3AC339B277DA585E9958236D66734D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSendBufferSize() throws SocketException {
        int var005264550D84EF96DC70DBD100CA620E_192438694 = (socket.getSendBufferSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getSendBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "CC64982F6E0A2B1E3A134D1B10ED2DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getReceiveBufferSize() throws SocketException {
        int var8C84778F56282D35925005D6DDC23C71_2015229995 = (socket.getReceiveBufferSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getReceiveBufferSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "92049F28B03D8E5190EE5A927982C182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isConnected() {
        boolean var85B42D5B11D271EF22C86B4825E7883A_468174624 = (socket.isConnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "10E5656C162EBA09D28A264806177613")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isClosed() {
        boolean var27F495A2B555629D84C6B569E8241F1C_1748057242 = (socket.isClosed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "F0BC9C47FDD857E21189A010B2E3831A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isBound() {
        boolean var224EC1975F9239A11BE2C2D578055916_1252206060 = (socket.isBound());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isBound();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.278 -0400", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "11DA5D155CDBF33153C6E3C48E1B0A94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isOutputShutdown() {
        boolean var8F2E931B36ED0DC8C68FE10E13A8849C_90465591 = (socket.isOutputShutdown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isOutputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.279 -0400", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "FF8A1EB147B9EA26D06EB654527938D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isInputShutdown() {
        boolean varB6322C59AE9A19A60FD86D45E23B4EAA_1525426921 = (socket.isInputShutdown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return socket.isInputShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.279 -0400", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "0926F8565132AEDABA2DB262EFA657FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getPort() {
        int var8B39E7DA67EA3CEB7249FD0C46C6B32C_1169723141 = (socket.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.279 -0400", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "F2C443CD6D1727AA39BC66DAD96271CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLocalPort() {
        int varC0E5665D93FF6E7BB2882BCAFC2C6E25_1695937060 = (socket.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return socket.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.279 -0400", hash_original_method = "80D37FA57838689D0D9ECABB08EA2811", hash_generated_method = "2B64F2BF586373729D210E7442DE5139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varAC29AB073A2DFF35D72D524BB4C62850_1033247625 = (socket.getFileDescriptor$());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket.getFileDescriptor$();
    }

    
}

