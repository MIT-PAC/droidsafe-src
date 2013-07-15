package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.Streams;
import static libcore.io.OsConstants.*;

public class PlainSocketImpl extends SocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.021 -0400", hash_original_field = "7DEF0BDA40D0E04BF9A6A07F09AE1E51", hash_generated_field = "6A8CCB2C47D2D8E132EF5F76D32DB937")

    private boolean streaming = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.021 -0400", hash_original_field = "989BFF50F10AD27F4007C187334D8DE7", hash_generated_field = "3A0B3C0A8DEC4D2F6AA0372C4FB59EF4")

    private boolean shutdownInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.022 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.022 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.022 -0400", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "6CEE3DDB33BF241213DAB79ECD0A80FE")
    public  PlainSocketImpl(FileDescriptor fd) {
        addTaint(fd.getTaint());
        this.fd = fd;
    if(fd.valid())        
        {
            guard.open("close");
        } //End block
        // ---------- Original Method ----------
        //this.fd = fd;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.023 -0400", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "572BD4D8C80F6E5CF3D7310CFBD2C2C8")
    public  PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.023 -0400", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "8644C6045E743F187FD836913AA183B7")
    public  PlainSocketImpl() {
        this(new FileDescriptor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.024 -0400", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "501CBF909E2302295230595EF8BB12D5")
    public  PlainSocketImpl(FileDescriptor fd, int localport, InetAddress addr, int port) {
        addTaint(port);
        addTaint(addr.getTaint());
        addTaint(localport);
        addTaint(fd.getTaint());
        this.fd = fd;
        this.localport = localport;
        this.address = addr;
        this.port = port;
    if(fd.valid())        
        {
            guard.open("close");
        } //End block
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localport = localport;
        //this.address = addr;
        //this.port = port;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.032 -0400", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "A06DA0480DE3ABC96C9F72342E8CC113")
    @Override
    protected void accept(SocketImpl newImpl) throws IOException {
        addTaint(newImpl.getTaint());
    if(usingSocks())        
        {
            ((PlainSocketImpl) newImpl).socksBind();
            ((PlainSocketImpl) newImpl).socksAccept();
            return;
        } //End block
        try 
        {
            InetSocketAddress peerAddress = new InetSocketAddress();
            FileDescriptor clientFd = Libcore.os.accept(fd, peerAddress);
            newImpl.fd.setInt$(clientFd.getInt$());
            newImpl.address = peerAddress.getAddress();
            newImpl.port = peerAddress.getPort();
        } //End block
        catch (ErrnoException errnoException)
        {
    if(errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK)            
            {
                SocketTimeoutException var99C30906BCCBF74FFF0D5F285D252ACC_1310509628 = new SocketTimeoutException(errnoException);
                var99C30906BCCBF74FFF0D5F285D252ACC_1310509628.addTaint(taint);
                throw var99C30906BCCBF74FFF0D5F285D252ACC_1310509628;
            } //End block
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_382022912 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_382022912.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_382022912;
        } //End block
        newImpl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(0));
        newImpl.localport = IoBridge.getSocketLocalPort(newImpl.fd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.033 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "0681F7DA1AC3EF196D53F7B06E45EC22")
    private boolean usingSocks() {
        boolean var5E1E555BE0AAD4134390E5A70C27656D_185199497 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745777735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745777735;
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.033 -0400", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "8263FCD9E99151BF2B954F0EF19B9268")
    public void initLocalPort(int localPort) {
        addTaint(localPort);
        this.localport = localPort;
        // ---------- Original Method ----------
        //this.localport = localPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.046 -0400", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "3F7238155DA9FE60A021E36DC18A54EB")
    public void initRemoteAddressAndPort(InetAddress remoteAddress, int remotePort) {
        addTaint(remotePort);
        addTaint(remoteAddress.getTaint());
        this.address = remoteAddress;
        this.port = remotePort;
        // ---------- Original Method ----------
        //this.address = remoteAddress;
        //this.port = remotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.046 -0400", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "E23528A5BEAA0F93100E53DA46AA2097")
    private void checkNotClosed() throws IOException {
    if(!fd.valid())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_1605216540 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_1605216540.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_1605216540;
        } //End block
        // ---------- Original Method ----------
        //if (!fd.valid()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.047 -0400", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "6C558FE1BFFE2481AB0BE76D538EBA44")
    @Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
    if(shutdownInput)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_98586691 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567526171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567526171;
        } //End block
        int var16B823D9AF3F941AD9DE567252E43371_79900951 = (IoBridge.available(fd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688244622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688244622;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (shutdownInput) {
            //return 0;
        //}
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.048 -0400", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "830168DD4D1F6A958969E9BB980879A0")
    @Override
    protected void bind(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
        IoBridge.bind(fd, address, port);
        this.address = address;
    if(port != 0)        
        {
            this.localport = port;
        } //End block
        else
        {
            this.localport = IoBridge.getSocketLocalPort(fd);
        } //End block
        // ---------- Original Method ----------
        //IoBridge.bind(fd, address, port);
        //this.address = address;
        //if (port != 0) {
            //this.localport = port;
        //} else {
            //this.localport = IoBridge.getSocketLocalPort(fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.048 -0400", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "028C30BDF845EBB6CAF2C41AC41890BC")
    @Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
        // ---------- Original Method ----------
        //guard.close();
        //IoBridge.closeSocket(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.048 -0400", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "5857C40065A9FCC1E77E9A2021F93431")
    @Override
    protected void connect(String aHost, int aPort) throws IOException {
        addTaint(aPort);
        addTaint(aHost.getTaint());
        connect(InetAddress.getByName(aHost), aPort);
        // ---------- Original Method ----------
        //connect(InetAddress.getByName(aHost), aPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.049 -0400", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "21690777DC01D1837184611B8BE22A3C")
    @Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        addTaint(aPort);
        addTaint(anAddr.getTaint());
        connect(anAddr, aPort, 0);
        // ---------- Original Method ----------
        //connect(anAddr, aPort, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.050 -0400", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "6DCF78AB7C6D308BD781359356703822")
    private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(aPort);
        addTaint(anAddr.getTaint());
        InetAddress normalAddr = anAddr.isAnyLocalAddress() ? InetAddress.getLocalHost() : anAddr;
    if(streaming && usingSocks())        
        {
            socksConnect(anAddr, aPort, 0);
        } //End block
        else
        {
            IoBridge.connect(fd, normalAddr, aPort, timeout);
        } //End block
        super.address = normalAddr;
        super.port = aPort;
        // ---------- Original Method ----------
        //InetAddress normalAddr = anAddr.isAnyLocalAddress() ? InetAddress.getLocalHost() : anAddr;
        //if (streaming && usingSocks()) {
            //socksConnect(anAddr, aPort, 0);
        //} else {
            //IoBridge.connect(fd, normalAddr, aPort, timeout);
        //}
        //super.address = normalAddr;
        //super.port = aPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.050 -0400", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "5CA4F9F37FE885627E57D0C5486A5E2A")
    @Override
    protected void create(boolean streaming) throws IOException {
        this.streaming = streaming;
        this.fd = IoBridge.socket(streaming);
        // ---------- Original Method ----------
        //this.streaming = streaming;
        //this.fd = IoBridge.socket(streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.051 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "271B01A0C286411ADC3A779686EF67E4")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(guard != null)            
            {
                guard.warnIfOpen();
            } //End block
            close();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //close();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.051 -0400", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "368BA2169B9AB1DA1089F7DDDE715BBB")
    @Override
    protected synchronized InputStream getInputStream() throws IOException {
        checkNotClosed();
InputStream varF6ECC47D11E65E1A2F927158501224EC_176697550 =         new PlainSocketInputStream(this);
        varF6ECC47D11E65E1A2F927158501224EC_176697550.addTaint(taint);
        return varF6ECC47D11E65E1A2F927158501224EC_176697550;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.052 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "F3FA42F419EE88023479921EDE284C32")
    @Override
    public Object getOption(int option) throws SocketException {
        addTaint(option);
Object var7559B8D6B7C6B53535C98372E0E1C884_1584172771 =         IoBridge.getSocketOption(fd, option);
        var7559B8D6B7C6B53535C98372E0E1C884_1584172771.addTaint(taint);
        return var7559B8D6B7C6B53535C98372E0E1C884_1584172771;
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.052 -0400", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "8F3E46CBDED16539410DE4906F0D4DA9")
    @Override
    protected synchronized OutputStream getOutputStream() throws IOException {
        checkNotClosed();
OutputStream var8DAACDFE406FED89DEBC5D53A23E28BB_2049737810 =         new PlainSocketOutputStream(this);
        var8DAACDFE406FED89DEBC5D53A23E28BB_2049737810.addTaint(taint);
        return var8DAACDFE406FED89DEBC5D53A23E28BB_2049737810;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.058 -0400", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "354CA1EFB9D35130B9A0D49D9A1384F4")
    @Override
    protected void listen(int backlog) throws IOException {
        addTaint(backlog);
    if(usingSocks())        
        {
            return;
        } //End block
        try 
        {
            Libcore.os.listen(fd, backlog);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_1085750277 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_1085750277.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_1085750277;
        } //End block
        // ---------- Original Method ----------
        //if (usingSocks()) {
            //return;
        //}
        //try {
            //Libcore.os.listen(fd, backlog);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.059 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "127E4B7E3859A82F0E5ABAC491329F53")
    @Override
    public void setOption(int option, Object value) throws SocketException {
        addTaint(value.getTaint());
        addTaint(option);
        IoBridge.setSocketOption(fd, option, value);
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.059 -0400", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "40C54024BFD8EE0965B679256BD46BB3")
    private int socksGetServerPort() {
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        int var10BA24E4DBAD1B64CD977FB79B2C975B_259243907 = (addr.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451807140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451807140;
        // ---------- Original Method ----------
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //return addr.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.060 -0400", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "344B12EF7C124F58965AA7D4D0ADE466")
    private InetAddress socksGetServerAddress() throws UnknownHostException {
        String proxyName;
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
    if(proxyName == null)        
        {
            proxyName = addr.getAddress().getHostAddress();
        } //End block
InetAddress varCD1AB89BEFE6D06FD984B301B3372107_1001614986 =         InetAddress.getByName(proxyName);
        varCD1AB89BEFE6D06FD984B301B3372107_1001614986.addTaint(taint);
        return varCD1AB89BEFE6D06FD984B301B3372107_1001614986;
        // ---------- Original Method ----------
        //String proxyName;
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //proxyName = addr.getHostName();
        //if (proxyName == null) {
            //proxyName = addr.getAddress().getHostAddress();
        //}
        //return InetAddress.getByName(proxyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.061 -0400", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "6BBA553A1FDCB94D7141282AF2297D99")
    private void socksConnect(InetAddress applicationServerAddress, int applicationServerPort, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(applicationServerPort);
        addTaint(applicationServerAddress.getTaint());
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort(), timeout);
        } //End block
        catch (Exception e)
        {
            SocketException varD40A76CB202DEB44D9A98BD050F51D4F_1249755146 = new SocketException("SOCKS connection failed", e);
            varD40A76CB202DEB44D9A98BD050F51D4F_1249755146.addTaint(taint);
            throw varD40A76CB202DEB44D9A98BD050F51D4F_1249755146;
        } //End block
        socksRequestConnection(applicationServerAddress, applicationServerPort);
        lastConnectedAddress = applicationServerAddress;
        lastConnectedPort = applicationServerPort;
        // ---------- Original Method ----------
        //try {
            //IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort(), timeout);
        //} catch (Exception e) {
            //throw new SocketException("SOCKS connection failed", e);
        //}
        //socksRequestConnection(applicationServerAddress, applicationServerPort);
        //lastConnectedAddress = applicationServerAddress;
        //lastConnectedPort = applicationServerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.062 -0400", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "3259023A9332B5BBDF40601AD80C53C4")
    private void socksRequestConnection(InetAddress applicationServerAddress,
            int applicationServerPort) throws IOException {
        addTaint(applicationServerPort);
        addTaint(applicationServerAddress.getTaint());
        socksSendRequest(Socks4Message.COMMAND_CONNECT,
                applicationServerAddress, applicationServerPort);
        Socks4Message reply = socksReadReply();
    if(reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS)        
        {
            IOException varD0F3DCFCA548295328776446FC2D93C6_941512557 = new IOException(reply.getErrorString(reply.getCommandOrResult()));
            varD0F3DCFCA548295328776446FC2D93C6_941512557.addTaint(taint);
            throw varD0F3DCFCA548295328776446FC2D93C6_941512557;
        } //End block
        // ---------- Original Method ----------
        //socksSendRequest(Socks4Message.COMMAND_CONNECT,
                //applicationServerAddress, applicationServerPort);
        //Socks4Message reply = socksReadReply();
        //if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            //throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.063 -0400", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "9B04A43178B2B6E39CE973D4AC282226")
    public void socksAccept() throws IOException {
        Socks4Message reply = socksReadReply();
    if(reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS)        
        {
            IOException varD0F3DCFCA548295328776446FC2D93C6_523625455 = new IOException(reply.getErrorString(reply.getCommandOrResult()));
            varD0F3DCFCA548295328776446FC2D93C6_523625455.addTaint(taint);
            throw varD0F3DCFCA548295328776446FC2D93C6_523625455;
        } //End block
        // ---------- Original Method ----------
        //Socks4Message reply = socksReadReply();
        //if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            //throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.075 -0400", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "424DE7A29D1A4D0B7E599E254FF0067B")
    @Override
    protected void shutdownInput() throws IOException {
        shutdownInput = true;
        try 
        {
            Libcore.os.shutdown(fd, SHUT_RD);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_2132926809 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_2132926809.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_2132926809;
        } //End block
        // ---------- Original Method ----------
        //shutdownInput = true;
        //try {
            //Libcore.os.shutdown(fd, SHUT_RD);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.081 -0400", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "C34967E234E45F5985011A58F550B95D")
    @Override
    protected void shutdownOutput() throws IOException {
        try 
        {
            Libcore.os.shutdown(fd, SHUT_WR);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_863592978 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_863592978.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_863592978;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.shutdown(fd, SHUT_WR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.082 -0400", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "BC8DF018CB372B7AA89EDD0BC0C8D103")
    private void socksBind() throws IOException {
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort());
        } //End block
        catch (Exception e)
        {
            IOException varE08B07D84BA635AF309AF25AC6FCB043_43104973 = new IOException("Unable to connect to SOCKS server", e);
            varE08B07D84BA635AF309AF25AC6FCB043_43104973.addTaint(taint);
            throw varE08B07D84BA635AF309AF25AC6FCB043_43104973;
        } //End block
    if(lastConnectedAddress == null)        
        {
            SocketException var44967CE51C78370F3B248C9252961803_2088615513 = new SocketException("Invalid SOCKS client");
            var44967CE51C78370F3B248C9252961803_2088615513.addTaint(taint);
            throw var44967CE51C78370F3B248C9252961803_2088615513;
        } //End block
        socksSendRequest(Socks4Message.COMMAND_BIND, lastConnectedAddress,
                lastConnectedPort);
        Socks4Message reply = socksReadReply();
    if(reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS)        
        {
            IOException varD0F3DCFCA548295328776446FC2D93C6_739989130 = new IOException(reply.getErrorString(reply.getCommandOrResult()));
            varD0F3DCFCA548295328776446FC2D93C6_739989130.addTaint(taint);
            throw varD0F3DCFCA548295328776446FC2D93C6_739989130;
        } //End block
    if(reply.getIP() == 0)        
        {
            address = socksGetServerAddress();
        } //End block
        else
        {
            byte[] replyBytes = new byte[4];
            Memory.pokeInt(replyBytes, 0, reply.getIP(), ByteOrder.BIG_ENDIAN);
            address = InetAddress.getByAddress(replyBytes);
        } //End block
        localport = reply.getPort();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.083 -0400", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "B711102A2010CCD20DC4C04C901142A2")
    private void socksSendRequest(int command, InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(command);
        Socks4Message request = new Socks4Message();
        request.setCommandOrResult(command);
        request.setPort(port);
        request.setIP(address.getAddress());
        request.setUserId("default");
        getOutputStream().write(request.getBytes(), 0, request.getLength());
        // ---------- Original Method ----------
        //Socks4Message request = new Socks4Message();
        //request.setCommandOrResult(command);
        //request.setPort(port);
        //request.setIP(address.getAddress());
        //request.setUserId("default");
        //getOutputStream().write(request.getBytes(), 0, request.getLength());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.083 -0400", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "D076955D8351D3A84D01896B0E73B097")
    private Socks4Message socksReadReply() throws IOException {
        Socks4Message reply = new Socks4Message();
        int bytesRead = 0;
        while
(bytesRead < Socks4Message.REPLY_LENGTH)        
        {
            int count = getInputStream().read(reply.getBytes(), bytesRead,
                    Socks4Message.REPLY_LENGTH - bytesRead);
    if(count == -1)            
            {
                break;
            } //End block
            bytesRead += count;
        } //End block
    if(Socks4Message.REPLY_LENGTH != bytesRead)        
        {
            SocketException varF334A2E8FCC2C6A29EA357ED2943C2B7_794568158 = new SocketException("Malformed reply from SOCKS server");
            varF334A2E8FCC2C6A29EA357ED2943C2B7_794568158.addTaint(taint);
            throw varF334A2E8FCC2C6A29EA357ED2943C2B7_794568158;
        } //End block
Socks4Message var1BC29E376418A8DFBC75319DBDA8D7C9_483277454 =         reply;
        var1BC29E376418A8DFBC75319DBDA8D7C9_483277454.addTaint(taint);
        return var1BC29E376418A8DFBC75319DBDA8D7C9_483277454;
        // ---------- Original Method ----------
        //Socks4Message reply = new Socks4Message();
        //int bytesRead = 0;
        //while (bytesRead < Socks4Message.REPLY_LENGTH) {
            //int count = getInputStream().read(reply.getBytes(), bytesRead,
                    //Socks4Message.REPLY_LENGTH - bytesRead);
            //if (count == -1) {
                //break;
            //}
            //bytesRead += count;
        //}
        //if (Socks4Message.REPLY_LENGTH != bytesRead) {
            //throw new SocketException("Malformed reply from SOCKS server");
        //}
        //return reply;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.084 -0400", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "E4FC2322673E64B5EA957763F2E27A4A")
    @Override
    protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(remoteAddr.getTaint());
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
        // ---------- Original Method ----------
        //InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        //connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.084 -0400", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "4A2A0BE2C658470CFEF747661637C5D1")
    @Override
    protected boolean supportsUrgentData() {
        boolean varB326B5062B2F0E69046810717534CB09_728997392 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782196348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782196348;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.094 -0400", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "71B66D9EB9DDF8F41678C1DE9588C47E")
    @Override
    protected void sendUrgentData(int value) throws IOException {
        addTaint(value);
        try 
        {
            byte[] buffer = new byte[] { (byte) value };
            Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_1744803363 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_1744803363.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_1744803363;
        } //End block
        // ---------- Original Method ----------
        //try {
            //byte[] buffer = new byte[] { (byte) value };
            //Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.095 -0400", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "E8BCA099E997A21ADFC42E099D17D087")
    private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
    if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_421498803 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828035134 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828035134;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(shutdownInput)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_594697717 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318293884 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318293884;
        } //End block
        int readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
    if(readCount == 0)        
        {
            SocketTimeoutException var496977C46FEABE2A04A82CBAB511C0BD_1042676292 = new SocketTimeoutException();
            var496977C46FEABE2A04A82CBAB511C0BD_1042676292.addTaint(taint);
            throw var496977C46FEABE2A04A82CBAB511C0BD_1042676292;
        } //End block
    if(readCount == -1)        
        {
            shutdownInput = true;
        } //End block
        int varADC9E8D761A52E26BEC5404508AFC000_973726824 = (readCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368509782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368509782;
        // ---------- Original Method ----------
        //if (byteCount == 0) {
            //return 0;
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        //if (shutdownInput) {
            //return -1;
        //}
        //int readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
        //if (readCount == 0) {
            //throw new SocketTimeoutException();
        //}
        //if (readCount == -1) {
            //shutdownInput = true;
        //}
        //return readCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.096 -0400", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "1DF27126A55B7EF3B58B112841E32B73")
    private void write(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(streaming)        
        {
            while
(byteCount > 0)            
            {
                int bytesWritten = IoBridge.sendto(fd, buffer, offset, byteCount, 0, null, 0);
                byteCount -= bytesWritten;
                offset += bytesWritten;
            } //End block
        } //End block
        else
        {
            IoBridge.sendto(fd, buffer, offset, byteCount, 0, address, port);
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        //if (streaming) {
            //while (byteCount > 0) {
                //int bytesWritten = IoBridge.sendto(fd, buffer, offset, byteCount, 0, null, 0);
                //byteCount -= bytesWritten;
                //offset += bytesWritten;
            //}
        //} else {
            //IoBridge.sendto(fd, buffer, offset, byteCount, 0, address, port);
        //}
    }

    
    private static class PlainSocketInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.097 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.097 -0400", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "C543451A717B658BC3AAB7E48B419774")
        public  PlainSocketInputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.097 -0400", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "45C718BCD45909A50C23735EA67AC79E")
        @Override
        public int available() throws IOException {
            int var96FD30C8E950C9A87CE3D005CF9096A1_660243197 = (socketImpl.available());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227390906 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227390906;
            // ---------- Original Method ----------
            //return socketImpl.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.098 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.098 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "0CDD47F1902CBFE9AEDD7E380ACD73CA")
        @Override
        public int read() throws IOException {
            int varC29A5AE95A30EE64395CAB97F32FA4B0_158102975 = (Streams.readSingleByte(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802846265 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802846265;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.098 -0400", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "F73F682783DB293DD57271751D6C8E37")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            int var6C4FED5047B0C50095E2473B4CFEAE65_1302559490 = (socketImpl.read(buffer, offset, byteCount));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514790559 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514790559;
            // ---------- Original Method ----------
            //return socketImpl.read(buffer, offset, byteCount);
        }

        
    }


    
    private static class PlainSocketOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.099 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.099 -0400", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "0BF9D04DB29AB8AC4588EA1E9EC7AFA4")
        public  PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.099 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.100 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "64E00942800EFBB3ACEFB66C4126D5C6")
        @Override
        public void write(int oneByte) throws IOException {
            addTaint(oneByte);
            Streams.writeSingleByte(this, oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.100 -0400", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "109FDF1E9360C5E17DD61FAD44C33710")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buffer[0]);
            socketImpl.write(buffer, offset, byteCount);
            // ---------- Original Method ----------
            //socketImpl.write(buffer, offset, byteCount);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.100 -0400", hash_original_field = "95B06B2D766DEAF3F030BBBF1B4C69EC", hash_generated_field = "8E7174254564594C7825688884BD26C6")

    private static InetAddress lastConnectedAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.100 -0400", hash_original_field = "ADB4A06A0D48FC4B9CD01A3A3960E4A5", hash_generated_field = "0C17CA5E0BC8EA30C7FC6175AC3AE9C2")

    private static int lastConnectedPort;
}

