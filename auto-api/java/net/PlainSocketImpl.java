package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private boolean streaming = true;
    private boolean shutdownInput;
    private Proxy proxy;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.039 -0400", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "770D0F82BFB957DAA13155B3177A201A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        this.fd = fd;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_1833387456 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.fd = fd;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.039 -0400", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "AD81D8704C114EF96A8AE76AE806CD4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.039 -0400", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "8644C6045E743F187FD836913AA183B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl() {
        this(new FileDescriptor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.040 -0400", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "23E6E385AB668D0A68B3D73FE564A559")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl(FileDescriptor fd, int localport, InetAddress addr, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(localport);
        this.fd = fd;
        this.localport = localport;
        this.address = addr;
        this.port = port;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_880254633 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localport = localport;
        //this.address = addr;
        //this.port = port;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.040 -0400", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "C877F61462DD91B6D2B4C3AA747B9B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void accept(SocketImpl newImpl) throws IOException {
        dsTaint.addTaint(newImpl.dsTaint);
        {
            boolean varC406138A2988833B68553822CD3B489E_1758908491 = (usingSocks());
            {
                ((PlainSocketImpl) newImpl).socksBind();
                ((PlainSocketImpl) newImpl).socksAccept();
            } //End block
        } //End collapsed parenthetic
        try 
        {
            InetSocketAddress peerAddress;
            peerAddress = new InetSocketAddress();
            FileDescriptor clientFd;
            clientFd = Libcore.os.accept(fd, peerAddress);
            newImpl.fd.setInt$(clientFd.getInt$());
            newImpl.address = peerAddress.getAddress();
            newImpl.port = peerAddress.getPort();
        } //End block
        catch (ErrnoException errnoException)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketTimeoutException(errnoException);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } //End block
        newImpl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(0));
        newImpl.localport = IoBridge.getSocketLocalPort(newImpl.fd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.041 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "9938EE5F8BD8E4B96A29E632281FBF5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_80308756 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.042 -0400", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "69B0E4C42E72A84A8F8AC158A73AE6BC")
    @DSModeled(DSC.SAFE)
    public void initLocalPort(int localPort) {
        dsTaint.addTaint(localPort);
        this.localport = localPort;
        // ---------- Original Method ----------
        //this.localport = localPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.042 -0400", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "F4FD077B6F0FB7F442FC01E57475B4AA")
    @DSModeled(DSC.SAFE)
    public void initRemoteAddressAndPort(InetAddress remoteAddress, int remotePort) {
        dsTaint.addTaint(remoteAddress.dsTaint);
        dsTaint.addTaint(remotePort);
        this.address = remoteAddress;
        this.port = remotePort;
        // ---------- Original Method ----------
        //this.address = remoteAddress;
        //this.port = remotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.043 -0400", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "6AA9482924693E35421C51384254D270")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varE59BFD645E8CFB789878AA5C4C3DD887_439772043 = (!fd.valid());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!fd.valid()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.044 -0400", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "047BA845C0EF58CD174452AFA24DFC2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
        int var9C891A36C646640680B2116257EF3205_1105325884 = (IoBridge.available(fd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (shutdownInput) {
            //return 0;
        //}
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.044 -0400", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "0A6922F8BAE7E27A4356EAF877095B6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void bind(InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        IoBridge.bind(fd, address, port);
        this.address = address;
        {
            this.localport = port;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.044 -0400", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "028C30BDF845EBB6CAF2C41AC41890BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
        // ---------- Original Method ----------
        //guard.close();
        //IoBridge.closeSocket(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.044 -0400", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "69183D4E10156A85286E6C721F975554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void connect(String aHost, int aPort) throws IOException {
        dsTaint.addTaint(aHost);
        dsTaint.addTaint(aPort);
        connect(InetAddress.getByName(aHost), aPort);
        // ---------- Original Method ----------
        //connect(InetAddress.getByName(aHost), aPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.045 -0400", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "C7019E1B5632FDAF3C436B0E99C42179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        dsTaint.addTaint(aPort);
        dsTaint.addTaint(anAddr.dsTaint);
        connect(anAddr, aPort, 0);
        // ---------- Original Method ----------
        //connect(anAddr, aPort, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.045 -0400", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "D12B71E3193DC0E68B6206C3A6E33674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        dsTaint.addTaint(aPort);
        dsTaint.addTaint(anAddr.dsTaint);
        dsTaint.addTaint(timeout);
        InetAddress normalAddr;
        boolean varAB3CA3FA0BD782A23FE1A25DBF62160F_2128335272 = (anAddr.isAnyLocalAddress());
        normalAddr = InetAddress.getLocalHost();
        normalAddr = anAddr;
        {
            boolean var400AC900BEFEE49F89BB8165B8EB5056_1099624263 = (streaming && usingSocks());
            {
                socksConnect(anAddr, aPort, 0);
            } //End block
            {
                IoBridge.connect(fd, normalAddr, aPort, timeout);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.045 -0400", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "E43EF785A47F5467C0E0331C82178167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void create(boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        this.fd = IoBridge.socket(streaming);
        // ---------- Original Method ----------
        //this.streaming = streaming;
        //this.fd = IoBridge.socket(streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.046 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.046 -0400", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "B75D95CB2EF6137A9B620B809BDABCBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized InputStream getInputStream() throws IOException {
        checkNotClosed();
        InputStream var0BED7B231B7AB396438DAE3399054498_888986963 = (new PlainSocketInputStream(this));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.046 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "64F41C24CC0EDC6259D8D597A70DDEFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getOption(int option) throws SocketException {
        dsTaint.addTaint(option);
        Object varFEAA6C60FB0EA54EAAF32393AD9D756B_1860182400 = (IoBridge.getSocketOption(fd, option));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.046 -0400", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "171543E2BCB1CF3A14754E79387CBD26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized OutputStream getOutputStream() throws IOException {
        checkNotClosed();
        OutputStream var8B27118557C90CDFBC38838C3DF85118_31249835 = (new PlainSocketOutputStream(this));
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.047 -0400", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "D172FDF1A171789C47059E484BBCDB04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void listen(int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        {
            boolean varC406138A2988833B68553822CD3B489E_1045086132 = (usingSocks());
        } //End collapsed parenthetic
        try 
        {
            Libcore.os.listen(fd, backlog);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.047 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "9F3F8FC4DB975368D6588A88436AADCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOption(int option, Object value) throws SocketException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(option);
        IoBridge.setSocketOption(fd, option, value);
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.047 -0400", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "5D208D1339F922C4A5AB85E4D4123C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int socksGetServerPort() {
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        int var87288984078DF9FAA63BC2E896AA02F3_1637648256 = (addr.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //return addr.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.047 -0400", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "AD41A78124C447ED20750DEC4294C860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InetAddress socksGetServerAddress() throws UnknownHostException {
        String proxyName;
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
        {
            proxyName = addr.getAddress().getHostAddress();
        } //End block
        InetAddress var68365E319AC73EF764D07ABC326F9A97_1663008657 = (InetAddress.getByName(proxyName));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String proxyName;
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //proxyName = addr.getHostName();
        //if (proxyName == null) {
            //proxyName = addr.getAddress().getHostAddress();
        //}
        //return InetAddress.getByName(proxyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.047 -0400", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "E9A8FC01063C4C937E55ED88B1022277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void socksConnect(InetAddress applicationServerAddress, int applicationServerPort, int timeout) throws IOException {
        dsTaint.addTaint(applicationServerPort);
        dsTaint.addTaint(applicationServerAddress.dsTaint);
        dsTaint.addTaint(timeout);
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort(), timeout);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("SOCKS connection failed", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.048 -0400", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "E5DDF99C11D0BE8F1D56E8537793D82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void socksRequestConnection(InetAddress applicationServerAddress,
            int applicationServerPort) throws IOException {
        dsTaint.addTaint(applicationServerPort);
        dsTaint.addTaint(applicationServerAddress.dsTaint);
        socksSendRequest(Socks4Message.COMMAND_CONNECT,
                applicationServerAddress, applicationServerPort);
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_1098159418 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //socksSendRequest(Socks4Message.COMMAND_CONNECT,
                //applicationServerAddress, applicationServerPort);
        //Socks4Message reply = socksReadReply();
        //if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            //throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.048 -0400", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "75C52CFA8952F4306C92124724BA9EF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void socksAccept() throws IOException {
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_988134776 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Socks4Message reply = socksReadReply();
        //if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            //throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.048 -0400", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "C60F93F0813BA3D29D92F1EF88F13EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void shutdownInput() throws IOException {
        shutdownInput = true;
        try 
        {
            Libcore.os.shutdown(fd, SHUT_RD);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } //End block
        // ---------- Original Method ----------
        //shutdownInput = true;
        //try {
            //Libcore.os.shutdown(fd, SHUT_RD);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.048 -0400", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "1D4FE6DE101B7F0AC7CB44B4170473EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void shutdownOutput() throws IOException {
        try 
        {
            Libcore.os.shutdown(fd, SHUT_WR);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.shutdown(fd, SHUT_WR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.049 -0400", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "B4771CB317ED8708177A1C3B15EC2034")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void socksBind() throws IOException {
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort());
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to connect to SOCKS server", e);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Invalid SOCKS client");
        } //End block
        socksSendRequest(Socks4Message.COMMAND_BIND, lastConnectedAddress,
                lastConnectedPort);
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_717831536 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF52642BBE0E60EBE2FFA3951D938EA0F_499927154 = (reply.getIP() == 0);
            {
                address = socksGetServerAddress();
            } //End block
            {
                byte[] replyBytes;
                replyBytes = new byte[4];
                Memory.pokeInt(replyBytes, 0, reply.getIP(), ByteOrder.BIG_ENDIAN);
                address = InetAddress.getByAddress(replyBytes);
            } //End block
        } //End collapsed parenthetic
        localport = reply.getPort();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.049 -0400", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "84E1885932D5CDA5A37D4D9B2374DDFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void socksSendRequest(int command, InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(command);
        Socks4Message request;
        request = new Socks4Message();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.049 -0400", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "E5FEF7176ED115DA744DFA4626564807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Socks4Message socksReadReply() throws IOException {
        Socks4Message reply;
        reply = new Socks4Message();
        int bytesRead;
        bytesRead = 0;
        {
            int count;
            count = getInputStream().read(reply.getBytes(), bytesRead,
                    Socks4Message.REPLY_LENGTH - bytesRead);
            bytesRead += count;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Malformed reply from SOCKS server");
        } //End block
        return (Socks4Message)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.050 -0400", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "E107BD946AB1DC2475A619C89A2977AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(remoteAddr.dsTaint);
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) remoteAddr;
        connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
        // ---------- Original Method ----------
        //InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        //connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.050 -0400", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "832E197E6EB012822F22C67B84F17239")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean supportsUrgentData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.050 -0400", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "6CD34267F0C5EBB64DF4800E8C0AC85B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendUrgentData(int value) throws IOException {
        dsTaint.addTaint(value);
        try 
        {
            byte[] buffer;
            buffer = new byte[] { (byte) value };
            Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } //End block
        // ---------- Original Method ----------
        //try {
            //byte[] buffer = new byte[] { (byte) value };
            //Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.050 -0400", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "835EA6D86F39477CA7077E2B2DEB9C07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        int readCount;
        readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketTimeoutException();
        } //End block
        {
            shutdownInput = true;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.051 -0400", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "A16F5272FF9852380643CB7D104C897E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void write(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            {
                int bytesWritten;
                bytesWritten = IoBridge.sendto(fd, buffer, offset, byteCount, 0, null, 0);
                byteCount -= bytesWritten;
                offset += bytesWritten;
            } //End block
        } //End block
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
        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.051 -0400", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "71CF6766AD248C9A74FAC23DEC3434EF")
        @DSModeled(DSC.SAFE)
        public PlainSocketInputStream(PlainSocketImpl socketImpl) {
            dsTaint.addTaint(socketImpl.dsTaint);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.051 -0400", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "2F0B539C9D1B82540E79CBC4B4E85D4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            int var86CF5DFFEEA217678DC644B06FA451FF_1190198569 = (socketImpl.available());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return socketImpl.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.052 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.052 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "7467B5DE12030BAA2C0F0C59F8EDD700")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_1880983521 = (Streams.readSingleByte(this));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.052 -0400", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "64225B9BD970862E7DD269B8D50D43A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer[0]);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            int var88EDD8144C9A19872588BB8011279A12_1633316722 = (socketImpl.read(buffer, offset, byteCount));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return socketImpl.read(buffer, offset, byteCount);
        }

        
    }


    
    private static class PlainSocketOutputStream extends OutputStream {
        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.052 -0400", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "E944894D1639822869F837F45B54A51E")
        @DSModeled(DSC.SAFE)
        public PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            dsTaint.addTaint(socketImpl.dsTaint);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.052 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.053 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "57B6B388F457DD9D18B1F4CD1B038C42")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            Streams.writeSingleByte(this, oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.053 -0400", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "615951C2B558106A22BE9ECC002605F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer[0]);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            socketImpl.write(buffer, offset, byteCount);
            // ---------- Original Method ----------
            //socketImpl.write(buffer, offset, byteCount);
        }

        
    }


    
    private static InetAddress lastConnectedAddress;
    private static int lastConnectedPort;
}

