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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.694 -0400", hash_original_field = "7DEF0BDA40D0E04BF9A6A07F09AE1E51", hash_generated_field = "6A8CCB2C47D2D8E132EF5F76D32DB937")

    private boolean streaming = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.694 -0400", hash_original_field = "989BFF50F10AD27F4007C187334D8DE7", hash_generated_field = "3A0B3C0A8DEC4D2F6AA0372C4FB59EF4")

    private boolean shutdownInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.694 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.694 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.695 -0400", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "C67F77ACEE7022CB057375B49E47E53C")
    public  PlainSocketImpl(FileDescriptor fd) {
        this.fd = fd;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_437180144 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //this.fd = fd;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.695 -0400", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "572BD4D8C80F6E5CF3D7310CFBD2C2C8")
    public  PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.696 -0400", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "8644C6045E743F187FD836913AA183B7")
    public  PlainSocketImpl() {
        this(new FileDescriptor());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.708 -0400", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "AD871AB772F8EF7FD1213161F0ED6E50")
    public  PlainSocketImpl(FileDescriptor fd, int localport, InetAddress addr, int port) {
        this.fd = fd;
        this.localport = localport;
        this.address = addr;
        this.port = port;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_2106802866 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(localport);
        addTaint(addr.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localport = localport;
        //this.address = addr;
        //this.port = port;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.709 -0400", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "E2196C3F1208805A03443E7EE40C8013")
    @Override
    protected void accept(SocketImpl newImpl) throws IOException {
        {
            boolean varC406138A2988833B68553822CD3B489E_913302112 = (usingSocks());
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
        addTaint(newImpl.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.721 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "B6FFC94FFFA10704DBEA7C260D90ADA4")
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_1940573018 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113824539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113824539;
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.721 -0400", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "D998F7F07537A927CF5120B78C2E8180")
    public void initLocalPort(int localPort) {
        this.localport = localPort;
        addTaint(localPort);
        // ---------- Original Method ----------
        //this.localport = localPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.722 -0400", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "3BBA8F8B26AC86F52B7CFD41A6C93C0D")
    public void initRemoteAddressAndPort(InetAddress remoteAddress, int remotePort) {
        this.address = remoteAddress;
        this.port = remotePort;
        addTaint(remoteAddress.getTaint());
        addTaint(remotePort);
        // ---------- Original Method ----------
        //this.address = remoteAddress;
        //this.port = remotePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.722 -0400", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "93A2B718597A9BF35B5C3C11022719F5")
    private void checkNotClosed() throws IOException {
        {
            boolean varE59BFD645E8CFB789878AA5C4C3DD887_445236264 = (!fd.valid());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!fd.valid()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.723 -0400", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "D4A3F50E8219C11D00F4C31B44956C6B")
    @Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
        int var9C891A36C646640680B2116257EF3205_848358941 = (IoBridge.available(fd));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031130754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031130754;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (shutdownInput) {
            //return 0;
        //}
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.723 -0400", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "0826E3620A6995B297F91D8DA30227E9")
    @Override
    protected void bind(InetAddress address, int port) throws IOException {
        IoBridge.bind(fd, address, port);
        this.address = address;
        {
            this.localport = port;
        } //End block
        {
            this.localport = IoBridge.getSocketLocalPort(fd);
        } //End block
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //IoBridge.bind(fd, address, port);
        //this.address = address;
        //if (port != 0) {
            //this.localport = port;
        //} else {
            //this.localport = IoBridge.getSocketLocalPort(fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.724 -0400", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "028C30BDF845EBB6CAF2C41AC41890BC")
    @Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
        // ---------- Original Method ----------
        //guard.close();
        //IoBridge.closeSocket(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.724 -0400", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "E2AAD0075B441D118F9D7CF11BD73182")
    @Override
    protected void connect(String aHost, int aPort) throws IOException {
        connect(InetAddress.getByName(aHost), aPort);
        addTaint(aHost.getTaint());
        addTaint(aPort);
        // ---------- Original Method ----------
        //connect(InetAddress.getByName(aHost), aPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.732 -0400", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "EEE033DDA2022CC2ED94333067904E83")
    @Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        connect(anAddr, aPort, 0);
        addTaint(anAddr.getTaint());
        addTaint(aPort);
        // ---------- Original Method ----------
        //connect(anAddr, aPort, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.733 -0400", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "D0883CE98A21CF3F44C5ACC1B5D917EB")
    private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        InetAddress normalAddr;
        boolean varAB3CA3FA0BD782A23FE1A25DBF62160F_1553406789 = (anAddr.isAnyLocalAddress());
        normalAddr = InetAddress.getLocalHost();
        normalAddr = anAddr;
        {
            boolean var400AC900BEFEE49F89BB8165B8EB5056_402114422 = (streaming && usingSocks());
            {
                socksConnect(anAddr, aPort, 0);
            } //End block
            {
                IoBridge.connect(fd, normalAddr, aPort, timeout);
            } //End block
        } //End collapsed parenthetic
        super.address = normalAddr;
        super.port = aPort;
        addTaint(anAddr.getTaint());
        addTaint(aPort);
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.733 -0400", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "5CA4F9F37FE885627E57D0C5486A5E2A")
    @Override
    protected void create(boolean streaming) throws IOException {
        this.streaming = streaming;
        this.fd = IoBridge.socket(streaming);
        // ---------- Original Method ----------
        //this.streaming = streaming;
        //this.fd = IoBridge.socket(streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.734 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.734 -0400", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "DE6E3860CA8BE416F4AC3B749905DACE")
    @Override
    protected synchronized InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_209513572 = null; //Variable for return #1
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_209513572 = new PlainSocketInputStream(this);
        varB4EAC82CA7396A68D541C85D26508E83_209513572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_209513572;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketInputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.735 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "7A80B6FE18976284CCDE41F0E4CF2227")
    @Override
    public Object getOption(int option) throws SocketException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1042067108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1042067108 = IoBridge.getSocketOption(fd, option);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1042067108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042067108;
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.735 -0400", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "CF6BDF5F1D117E3B52FDE008B117AAC1")
    @Override
    protected synchronized OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_262439567 = null; //Variable for return #1
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_262439567 = new PlainSocketOutputStream(this);
        varB4EAC82CA7396A68D541C85D26508E83_262439567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262439567;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return new PlainSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.746 -0400", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "6C93937DD0C3D7C411AA1C92B74A5CD5")
    @Override
    protected void listen(int backlog) throws IOException {
        {
            boolean varC406138A2988833B68553822CD3B489E_1418688293 = (usingSocks());
        } //End collapsed parenthetic
        try 
        {
            Libcore.os.listen(fd, backlog);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } //End block
        addTaint(backlog);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.747 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "3D26DE208CF202E2A774CE8E05434E41")
    @Override
    public void setOption(int option, Object value) throws SocketException {
        IoBridge.setSocketOption(fd, option, value);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.747 -0400", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "9A6923B574ECAC2E76791134E1EDABCD")
    private int socksGetServerPort() {
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        int var87288984078DF9FAA63BC2E896AA02F3_1787325356 = (addr.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528103918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528103918;
        // ---------- Original Method ----------
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //return addr.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.748 -0400", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "F10BB36A9B4F7B9101402A55767D7AB6")
    private InetAddress socksGetServerAddress() throws UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2032211667 = null; //Variable for return #1
        String proxyName;
        InetSocketAddress addr;
        addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
        {
            proxyName = addr.getAddress().getHostAddress();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2032211667 = InetAddress.getByName(proxyName);
        varB4EAC82CA7396A68D541C85D26508E83_2032211667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2032211667;
        // ---------- Original Method ----------
        //String proxyName;
        //InetSocketAddress addr = (InetSocketAddress) proxy.address();
        //proxyName = addr.getHostName();
        //if (proxyName == null) {
            //proxyName = addr.getAddress().getHostAddress();
        //}
        //return InetAddress.getByName(proxyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.749 -0400", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "F9B03D97E27A95F69BFA852232BE7426")
    private void socksConnect(InetAddress applicationServerAddress, int applicationServerPort, int timeout) throws IOException {
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
        addTaint(applicationServerAddress.getTaint());
        addTaint(applicationServerPort);
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.753 -0400", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "230A343E83557665C78EE0D4231295F7")
    private void socksRequestConnection(InetAddress applicationServerAddress,
            int applicationServerPort) throws IOException {
        socksSendRequest(Socks4Message.COMMAND_CONNECT,
                applicationServerAddress, applicationServerPort);
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_539233397 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        addTaint(applicationServerAddress.getTaint());
        addTaint(applicationServerPort);
        // ---------- Original Method ----------
        //socksSendRequest(Socks4Message.COMMAND_CONNECT,
                //applicationServerAddress, applicationServerPort);
        //Socks4Message reply = socksReadReply();
        //if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            //throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.753 -0400", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "43DCCD213DA6DA8CDB89B1B4D5F8EC23")
    public void socksAccept() throws IOException {
        Socks4Message reply;
        reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_903856467 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.758 -0400", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "C60F93F0813BA3D29D92F1EF88F13EDA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.764 -0400", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "1D4FE6DE101B7F0AC7CB44B4170473EF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.776 -0400", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "6BC6F6E30D09ED3DF51F70036334B418")
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
            boolean varB90FD30C634CD2BE843BCFA5E143701E_1174760273 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF52642BBE0E60EBE2FFA3951D938EA0F_877994941 = (reply.getIP() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.777 -0400", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "32CC4D4CF8908B56587A42AD409F31CB")
    private void socksSendRequest(int command, InetAddress address, int port) throws IOException {
        Socks4Message request;
        request = new Socks4Message();
        request.setCommandOrResult(command);
        request.setPort(port);
        request.setIP(address.getAddress());
        request.setUserId("default");
        getOutputStream().write(request.getBytes(), 0, request.getLength());
        addTaint(command);
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //Socks4Message request = new Socks4Message();
        //request.setCommandOrResult(command);
        //request.setPort(port);
        //request.setIP(address.getAddress());
        //request.setUserId("default");
        //getOutputStream().write(request.getBytes(), 0, request.getLength());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.777 -0400", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "172C23E211FC596B47E3439E2943F301")
    private Socks4Message socksReadReply() throws IOException {
        Socks4Message varB4EAC82CA7396A68D541C85D26508E83_1890187575 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1890187575 = reply;
        varB4EAC82CA7396A68D541C85D26508E83_1890187575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890187575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.778 -0400", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "F25CEE4F142A8EBC4127EA23A7DC81EB")
    @Override
    protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) remoteAddr;
        connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
        addTaint(remoteAddr.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        //connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.778 -0400", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "BD4745CF7F794F828F6550BB5C5C2B88")
    @Override
    protected boolean supportsUrgentData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57773208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57773208;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.782 -0400", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "A0F0CF095398AA3AA1E9DE893B69EF65")
    @Override
    protected void sendUrgentData(int value) throws IOException {
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
        addTaint(value);
        // ---------- Original Method ----------
        //try {
            //byte[] buffer = new byte[] { (byte) value };
            //Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.790 -0400", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "94B1A3F3DB3663C5097B481DC076531A")
    private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        int readCount;
        readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketTimeoutException();
        } //End block
        {
            shutdownInput = true;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888065467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888065467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.791 -0400", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "D019C418CAA0C89B76C29EC314EABB7C")
    private void write(byte[] buffer, int offset, int byteCount) throws IOException {
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
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.792 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.799 -0400", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "C543451A717B658BC3AAB7E48B419774")
        public  PlainSocketInputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.800 -0400", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "7EEA24A600F541B17C50535315626F38")
        @Override
        public int available() throws IOException {
            int var86CF5DFFEEA217678DC644B06FA451FF_1439030729 = (socketImpl.available());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497820987 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497820987;
            // ---------- Original Method ----------
            //return socketImpl.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.800 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.870 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "50F70616CAEF80997C7525578D9BDCA9")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_754145018 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450471002 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450471002;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.873 -0400", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "49F9C70AD40CB74847B7D4A8B79335E7")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            int var88EDD8144C9A19872588BB8011279A12_1096762744 = (socketImpl.read(buffer, offset, byteCount));
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942764459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942764459;
            // ---------- Original Method ----------
            //return socketImpl.read(buffer, offset, byteCount);
        }

        
    }


    
    private static class PlainSocketOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.873 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.874 -0400", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "0BF9D04DB29AB8AC4588EA1E9EC7AFA4")
        public  PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            // ---------- Original Method ----------
            //this.socketImpl = socketImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.874 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            // ---------- Original Method ----------
            //socketImpl.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.875 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "7C9196718755845369790934EC3B8FE0")
        @Override
        public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
            addTaint(oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.875 -0400", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "D16AF98B4C79D86F224993C339434068")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            socketImpl.write(buffer, offset, byteCount);
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            // ---------- Original Method ----------
            //socketImpl.write(buffer, offset, byteCount);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.875 -0400", hash_original_field = "95B06B2D766DEAF3F030BBBF1B4C69EC", hash_generated_field = "8E7174254564594C7825688884BD26C6")

    private static InetAddress lastConnectedAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.875 -0400", hash_original_field = "ADB4A06A0D48FC4B9CD01A3A3960E4A5", hash_generated_field = "0C17CA5E0BC8EA30C7FC6175AC3AE9C2")

    private static int lastConnectedPort;
}

