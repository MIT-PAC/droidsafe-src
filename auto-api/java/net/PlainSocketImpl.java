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
    private static InetAddress lastConnectedAddress;
    private static int lastConnectedPort;
    private boolean streaming = true;
    private boolean shutdownInput;
    private Proxy proxy;
    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.947 -0400", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "8658C290EAE1930836FA006CF40D3650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        this.fd = fd;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_408595552 = (fd.valid());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.952 -0400", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "BD2FBB99DC119A9AD74BE4E53632A226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.956 -0400", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "35C6B19020B5291A8C92A13EFA880518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainSocketImpl() {
        this(new FileDescriptor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.962 -0400", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "AA8E846EEA2E9A8387BFDAB4DFCCCAA9")
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
            boolean varF60ABC869823C7B081E571E9390323D2_388678813 = (fd.valid());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.977 -0400", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "3040DA8FAAE03097A9427204F9BD3578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void accept(SocketImpl newImpl) throws IOException {
        dsTaint.addTaint(newImpl.dsTaint);
        {
            boolean varC406138A2988833B68553822CD3B489E_565153153 = (usingSocks());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.986 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "E2D0DB4B1C171B48DE5DF0070C768E40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_962745941 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:58.992 -0400", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "22DA81FCD42AA51FCC227C5B52A25CF2")
    @DSModeled(DSC.SAFE)
    public void initLocalPort(int localPort) {
        dsTaint.addTaint(localPort);
        this.localport = localPort;
        // ---------- Original Method ----------
        //this.localport = localPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.000 -0400", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "667B62B97676476850D984B3AD274799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.005 -0400", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "7B23D29FCEEED8AFEFC55D12E4C8E21E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varE59BFD645E8CFB789878AA5C4C3DD887_806236450 = (!fd.valid());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!fd.valid()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.021 -0400", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "F9C74DA8F7F6F43F34C0B25F1EB2D838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
        int var9C891A36C646640680B2116257EF3205_517003342 = (IoBridge.available(fd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (shutdownInput) {
            //return 0;
        //}
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.027 -0400", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "76067BA0749D9BBA0B5E0FBEFBF319F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.039 -0400", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "215020AFF6C3280D4BE252FF6128104C")
    @DSModeled(DSC.SAFE)
    @Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
        // ---------- Original Method ----------
        //guard.close();
        //IoBridge.closeSocket(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.044 -0400", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "D4091B9992124C37A705BDBB3F757453")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void connect(String aHost, int aPort) throws IOException {
        dsTaint.addTaint(aHost);
        dsTaint.addTaint(aPort);
        connect(InetAddress.getByName(aHost), aPort);
        // ---------- Original Method ----------
        //connect(InetAddress.getByName(aHost), aPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.048 -0400", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "3FB97EF9A2D3A5B50015E39717B3025D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        dsTaint.addTaint(anAddr.dsTaint);
        dsTaint.addTaint(aPort);
        connect(anAddr, aPort, 0);
        // ---------- Original Method ----------
        //connect(anAddr, aPort, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.058 -0400", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "0CE1F47C68F58BB61F5453F6FFA8FF9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        dsTaint.addTaint(anAddr.dsTaint);
        dsTaint.addTaint(aPort);
        dsTaint.addTaint(timeout);
        InetAddress normalAddr;
        boolean varAB3CA3FA0BD782A23FE1A25DBF62160F_508954386 = (anAddr.isAnyLocalAddress());
        normalAddr = InetAddress.getLocalHost();
        normalAddr = anAddr;
        {
            boolean var400AC900BEFEE49F89BB8165B8EB5056_1625405630 = (streaming && usingSocks());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.065 -0400", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "C175BE86080AD13FE456C67EE54BDF54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void create(boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        this.fd = IoBridge.socket(streaming);
        // ---------- Original Method ----------
        //this.streaming = streaming;
        //this.fd = IoBridge.socket(streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.072 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "648B7AB6646E68C24A879D2C00314B10")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.082 -0400", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "924389F2639FD9A34F7DB4B0EF94D344")
    @DSModeled(DSC.SAFE)
    @Override
    protected synchronized InputStream getInputStream() throws IOException {
        checkNotClosed();
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.088 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "85B5BFD26E990A2655E234801771B70A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getOption(int option) throws SocketException {
        dsTaint.addTaint(option);
        Object varFEAA6C60FB0EA54EAAF32393AD9D756B_1359934653 = (IoBridge.getSocketOption(fd, option));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.096 -0400", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "AA4AD6D8F89D734B536A25C6AC35FB91")
    @DSModeled(DSC.SAFE)
    @Override
    protected synchronized OutputStream getOutputStream() throws IOException {
        checkNotClosed();
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.105 -0400", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "268D1402346F5842E5150F9A5FE14B02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void listen(int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        {
            boolean varC406138A2988833B68553822CD3B489E_533644135 = (usingSocks());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.115 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "143B783C1D42A1C9C3259E5868B6D393")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOption(int option, Object value) throws SocketException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(option);
        IoBridge.setSocketOption(fd, option, value);
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.122 -0400", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "896B98A5725E1263E210B4D9AA323839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int socksGetServerPort() {
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        int var87288984078DF9FAA63BC2E896AA02F3_102012683 = (addr.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //return addr.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.133 -0400", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "9CB5B1F228483768FD3C31C764FBB6A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InetAddress socksGetServerAddress() throws UnknownHostException {
        String proxyName;
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
        {
            proxyName = addr.getAddress().getHostAddress();
        } //End block
        InetAddress var68365E319AC73EF764D07ABC326F9A97_231254803 = (InetAddress.getByName(proxyName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.142 -0400", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "A425464AD983EB6C85827E3849AE93AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.154 -0400", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "27532A31893D2A16A9E6771E4897B4FB")
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
            boolean varB90FD30C634CD2BE843BCFA5E143701E_2062011683 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.164 -0400", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "90E1CD154A4DEB80D378C1D92C8B5CC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void socksAccept() throws IOException {
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_368797328 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.172 -0400", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "4854DED0C549559A682AD08E95D784C3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.181 -0400", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "3E5CFE35D1600DB5749E176F54D9A637")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.197 -0400", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "C69BCC83E6950C89A21D543831F24DFB")
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
            boolean varB90FD30C634CD2BE843BCFA5E143701E_1249795927 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF52642BBE0E60EBE2FFA3951D938EA0F_1701199675 = (reply.getIP() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.210 -0400", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "A67138D90472AB5B7B3FB0CDE24A368A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.222 -0400", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "317FDB810479E011D5BAFB7ADCA154A9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.230 -0400", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "DF65D6484B94CB94A45851AD5C9AD2D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.236 -0400", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "6676466740AB4D3FC0EFA2A722A291E7")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean supportsUrgentData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.242 -0400", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "6CEC4634D236073A1727CF001E754D04")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.261 -0400", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "86CEFF811778249258D88A064538A4CC")
    @DSModeled(DSC.SAFE)
    private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.274 -0400", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "4D69BA54C3368F652D5843F78DF780F2")
    @DSModeled(DSC.SAFE)
    private void write(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.286 -0400", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "893ACEE861E6C06C9CAD20A6D2E71B1A")
        @DSModeled(DSC.SAFE)
        public PlainSocketInputStream(PlainSocketImpl socketImpl) {
            dsTaint.addTaint(socketImpl.dsTaint);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.294 -0400", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "BA160B0C278B42DC11157FA8ECA85851")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            int var86CF5DFFEEA217678DC644B06FA451FF_1862536019 = (socketImpl.available());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return socketImpl.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.300 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "9769D6ED2F3D50D20CAFFB24BC4AF8E1")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.308 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "A3F9BB8C140ADC1224B1C091F2FDEA22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_2017158994 = (Streams.readSingleByte(this));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.325 -0400", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "66F7A1E30D68E93475DCC7165652F6E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            int var88EDD8144C9A19872588BB8011279A12_299425638 = (socketImpl.read(buffer, offset, byteCount));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return socketImpl.read(buffer, offset, byteCount);
        }

        
    }


    
    private static class PlainSocketOutputStream extends OutputStream {
        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.330 -0400", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "67D1575E90556EF12E89CBDC0130F78C")
        @DSModeled(DSC.SAFE)
        public PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            dsTaint.addTaint(socketImpl.dsTaint);
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.336 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "9769D6ED2F3D50D20CAFFB24BC4AF8E1")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.341 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "1412692312D9E2FC2D91C6355DCE790F")
        @DSModeled(DSC.SAFE)
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            Streams.writeSingleByte(this, oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:47:59.347 -0400", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "5CFF4640BE0130CA63A357985ABE5687")
        @DSModeled(DSC.SAFE)
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            socketImpl.write(buffer, offset, byteCount);
            // ---------- Original Method ----------
            //socketImpl.write(buffer, offset, byteCount);
        }

        
    }


    
}


