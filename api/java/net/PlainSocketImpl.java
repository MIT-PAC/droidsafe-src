package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.EAGAIN;
import static libcore.io.OsConstants.EWOULDBLOCK;
import static libcore.io.OsConstants.MSG_OOB;
import static libcore.io.OsConstants.SHUT_RD;
import static libcore.io.OsConstants.SHUT_WR;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.util.Arrays;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.Streams;
import dalvik.system.CloseGuard;

public class PlainSocketImpl extends SocketImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.513 -0500", hash_original_field = "F0CA0B6A36CA244BB1CC0FFC0B728C8A", hash_generated_field = "6D9FFDACEA318C6C72BAD824AA432EA6")

    // host connected to in its request.
    private static InetAddress lastConnectedAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.516 -0500", hash_original_field = "13ABAE85F4A0A7717045A563DB3039CB", hash_generated_field = "0C17CA5E0BC8EA30C7FC6175AC3AE9C2")

    private static int lastConnectedPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.518 -0500", hash_original_field = "A337E277329F6DC1C9EA7E279642F199", hash_generated_field = "6A8CCB2C47D2D8E132EF5F76D32DB937")

    private boolean streaming = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.911 -0500", hash_original_field = "840EE78A334019BDE73FFECFB6C31FB6", hash_generated_field = "3A0B3C0A8DEC4D2F6AA0372C4FB59EF4")

    private boolean shutdownInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.913 -0500", hash_original_field = "CA775536D3A7F4013C2E9C464BE24463", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.916 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.918 -0500", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "0666BEA52525B8BAD522E131C4ADD809")
    
public PlainSocketImpl(FileDescriptor fd) {
        this.fd = fd;
        if (fd.valid()) {
            guard.open("close");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.922 -0500", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "BCE4E206E1D08C0CBF24805F88B631DE")
    
public PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        this.proxy = proxy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.925 -0500", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "C45452C008FB51031723E1A52F90A02E")
    
public PlainSocketImpl() {
        this(new FileDescriptor());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.928 -0500", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "91B165E02A32B27960C67BF518A716F1")
    
public PlainSocketImpl(FileDescriptor fd, int localport, InetAddress addr, int port) {
        this.fd = fd;
        this.localport = localport;
        this.address = addr;
        this.port = port;
        if (fd.valid()) {
            guard.open("close");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.931 -0500", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "84915A463DF4DF5656C9F40364C897B5")
    
@Override
    protected void accept(SocketImpl newImpl) throws IOException {
        if (usingSocks()) {
            ((PlainSocketImpl) newImpl).socksBind();
            ((PlainSocketImpl) newImpl).socksAccept();
            return;
        }

        try {
            InetSocketAddress peerAddress = new InetSocketAddress();
            FileDescriptor clientFd = Libcore.os.accept(fd, peerAddress);

            // TODO: we can't just set newImpl.fd to clientFd because a nio SocketChannel may
            // be sharing the FileDescriptor. http://b//4452981.
            newImpl.fd.setInt$(clientFd.getInt$());

            newImpl.address = peerAddress.getAddress();
            newImpl.port = peerAddress.getPort();
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK) {
                throw new SocketTimeoutException(errnoException);
            }
            throw errnoException.rethrowAsSocketException();
        }

        // Reset the client's inherited read timeout to the Java-specified default of 0.
        newImpl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(0));

        newImpl.localport = IoBridge.getSocketLocalPort(newImpl.fd);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.933 -0500", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "286D168AC5969CEEC8D7177AFB54002B")
    
private boolean usingSocks() {
        return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.936 -0500", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "95344778089C6FC4D9EE49F9CD75B689")
    
public void initLocalPort(int localPort) {
        this.localport = localPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.938 -0500", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "5D78C63AA81A60769C1A1E71D4103F86")
    
public void initRemoteAddressAndPort(InetAddress remoteAddress, int remotePort) {
        this.address = remoteAddress;
        this.port = remotePort;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.940 -0500", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "797517EE3BCF41975E6EB9F62189A2F4")
    
private void checkNotClosed() throws IOException {
        if (!fd.valid()) {
            throw new SocketException("Socket is closed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.943 -0500", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "CD754D3830E15F943E35286002692D09")
    
@Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
        // we need to check if the input has been shutdown. If so
        // we should return that there is no data to be read
        if (shutdownInput) {
            return 0;
        }
        return IoBridge.available(fd);
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.945 -0500", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "F10A380BD5E024D88F6FD6F1D854DF90")
    
@Override protected void bind(InetAddress address, int port) throws IOException {
        IoBridge.bind(fd, address, port);
        this.address = address;
        if (port != 0) {
            this.localport = port;
        } else {
            this.localport = IoBridge.getSocketLocalPort(fd);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.948 -0500", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "1BDB995F74F20B9D905CA1CAA337629F")
    
@Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.951 -0500", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "A9B1DAB707F03B7322CD3355B62BEAD9")
    
@Override
    protected void connect(String aHost, int aPort) throws IOException {
        connect(InetAddress.getByName(aHost), aPort);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.953 -0500", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "ACF008804767A75C4F076C3058DB2F17")
    
@Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        connect(anAddr, aPort, 0);
    }

    /**
     * Connects this socket to the specified remote host address/port.
     *
     * @param anAddr
     *            the remote host address to connect to
     * @param aPort
     *            the remote port to connect to
     * @param timeout
     *            a timeout where supported. 0 means no timeout
     * @throws IOException
     *             if an error occurs while connecting
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.956 -0500", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "33D143EF85E8AD02E15A033090CF0D8D")
    
private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        InetAddress normalAddr = anAddr.isAnyLocalAddress() ? InetAddress.getLocalHost() : anAddr;
        if (streaming && usingSocks()) {
            socksConnect(anAddr, aPort, 0);
        } else {
            IoBridge.connect(fd, normalAddr, aPort, timeout);
        }
        super.address = normalAddr;
        super.port = aPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.958 -0500", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "499313C8191F5B4C58177A534C459A07")
    
@Override
    protected void create(boolean streaming) throws IOException {
        this.streaming = streaming;
        this.fd = IoBridge.socket(streaming);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.960 -0500", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "F0F8D8EC0C5D8FA9E7582C7E60A1D793")
    
@Override protected void finalize() throws Throwable {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.963 -0500", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "548791816B3337E9919C1CB035D36CDB")
    
@Override protected synchronized InputStream getInputStream() throws IOException {
        checkNotClosed();
        return new PlainSocketInputStream(this);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.985 -0500", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "E4022F8103EB1A999EF7210C13D3EA7F")
    
@Override public Object getOption(int option) throws SocketException {
        return IoBridge.getSocketOption(fd, option);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.987 -0500", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "95A988AFC46708A91DEB05109869926B")
    
@Override protected synchronized OutputStream getOutputStream() throws IOException {
        checkNotClosed();
        return new PlainSocketOutputStream(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.006 -0500", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "7973381A97B013C8F10682B15FB6776A")
    
@Override
    protected void listen(int backlog) throws IOException {
        if (usingSocks()) {
            // Do nothing for a SOCKS connection. The listen occurs on the
            // server during the bind.
            return;
        }
        try {
            Libcore.os.listen(fd, backlog);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.008 -0500", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "9BF9637567DA8570E7C18AF8C3E21269")
    
@Override
    public void setOption(int option, Object value) throws SocketException {
        IoBridge.setSocketOption(fd, option, value);
    }

    /**
     * Gets the SOCKS proxy server port.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.011 -0500", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "BCF93A278DC9D95CE64E1A5A048773E7")
    
private int socksGetServerPort() {
        // get socks server port from proxy. It is unnecessary to check
        // "socksProxyPort" property, since proxy setting should only be
        // determined by ProxySelector.
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        return addr.getPort();
    }

    /**
     * Gets the InetAddress of the SOCKS proxy server.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.013 -0500", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "FD504285D7DB41C0F76B38BF01BE8A13")
    
private InetAddress socksGetServerAddress() throws UnknownHostException {
        String proxyName;
        // get socks server address from proxy. It is unnecessary to check
        // "socksProxyHost" property, since all proxy setting should be
        // determined by ProxySelector.
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
        if (proxyName == null) {
            proxyName = addr.getAddress().getHostAddress();
        }
        return InetAddress.getByName(proxyName);
    }

    /**
     * Connect using a SOCKS server.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.016 -0500", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "61DB079FA9FD35C506423BF91572915B")
    
private void socksConnect(InetAddress applicationServerAddress, int applicationServerPort, int timeout) throws IOException {
        try {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort(), timeout);
        } catch (Exception e) {
            throw new SocketException("SOCKS connection failed", e);
        }

        socksRequestConnection(applicationServerAddress, applicationServerPort);

        lastConnectedAddress = applicationServerAddress;
        lastConnectedPort = applicationServerPort;
    }

    /**
     * Request a SOCKS connection to the application server given. If the
     * request fails to complete successfully, an exception is thrown.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.019 -0500", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "5E007C1EA5F4274C098B880EEF579411")
    
private void socksRequestConnection(InetAddress applicationServerAddress,
            int applicationServerPort) throws IOException {
        socksSendRequest(Socks4Message.COMMAND_CONNECT,
                applicationServerAddress, applicationServerPort);
        Socks4Message reply = socksReadReply();
        if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        }
    }

    /**
     * Perform an accept for a SOCKS bind.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.021 -0500", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "F9084A2132A4774A25EB67D6F9253A14")
    
public void socksAccept() throws IOException {
        Socks4Message reply = socksReadReply();
        if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        }
    }

    /**
     * Shutdown the input portion of the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.024 -0500", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "E8BF02F1B64289F3B2238534086D0E8C")
    
@Override
    protected void shutdownInput() throws IOException {
        shutdownInput = true;
        try {
            Libcore.os.shutdown(fd, SHUT_RD);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    /**
     * Shutdown the output portion of the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.027 -0500", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "A75F5A1D74EFBDCC42E1E7CDB0133394")
    
@Override
    protected void shutdownOutput() throws IOException {
        try {
            Libcore.os.shutdown(fd, SHUT_WR);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    /**
     * Bind using a SOCKS server.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.030 -0500", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "96E1944E2D52A530889950726361FE08")
    
private void socksBind() throws IOException {
        try {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort());
        } catch (Exception e) {
            throw new IOException("Unable to connect to SOCKS server", e);
        }

        // There must be a connection to an application host for the bind to work.
        if (lastConnectedAddress == null) {
            throw new SocketException("Invalid SOCKS client");
        }

        // Use the last connected address and port in the bind request.
        socksSendRequest(Socks4Message.COMMAND_BIND, lastConnectedAddress,
                lastConnectedPort);
        Socks4Message reply = socksReadReply();

        if (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS) {
            throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
        }

        // A peculiarity of socks 4 - if the address returned is 0, use the
        // original socks server address.
        if (reply.getIP() == 0) {
            address = socksGetServerAddress();
        } else {
            // IPv6 support not yet required as
            // currently the Socks4Message.getIP() only returns int,
            // so only works with IPv4 4byte addresses
            byte[] replyBytes = new byte[4];
            Memory.pokeInt(replyBytes, 0, reply.getIP(), ByteOrder.BIG_ENDIAN);
            address = InetAddress.getByAddress(replyBytes);
        }
        localport = reply.getPort();
    }

    /**
     * Send a SOCKS V4 request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.032 -0500", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "6E32EC11506185A59EE9CB1CAD77DBB8")
    
private void socksSendRequest(int command, InetAddress address, int port) throws IOException {
        Socks4Message request = new Socks4Message();
        request.setCommandOrResult(command);
        request.setPort(port);
        request.setIP(address.getAddress());
        request.setUserId("default");

        getOutputStream().write(request.getBytes(), 0, request.getLength());
    }

    /**
     * Read a SOCKS V4 reply.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.035 -0500", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "FC82C17F2238474BCA844E921F3F0511")
    
private Socks4Message socksReadReply() throws IOException {
        Socks4Message reply = new Socks4Message();
        int bytesRead = 0;
        while (bytesRead < Socks4Message.REPLY_LENGTH) {
            int count = getInputStream().read(reply.getBytes(), bytesRead,
                    Socks4Message.REPLY_LENGTH - bytesRead);
            if (count == -1) {
                break;
            }
            bytesRead += count;
        }
        if (Socks4Message.REPLY_LENGTH != bytesRead) {
            throw new SocketException("Malformed reply from SOCKS server");
        }
        return reply;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.038 -0500", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "8C82F0A20E48AF9C5DA055E6ED464957")
    
@Override
    protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.040 -0500", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "79CCA64255BD450720A598CCD70DE5E5")
    
@Override
    protected boolean supportsUrgentData() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.043 -0500", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "F29586DC2AA2C2174CD8C7FB4CE30C33")
    
@Override
    protected void sendUrgentData(int value) throws IOException {
        try {
            byte[] buffer = new byte[] { (byte) value };
            Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }
    
    private static class PlainSocketInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.967 -0500", hash_original_field = "C92DD3B7F09F6096C227812F0F4031CF", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private  PlainSocketImpl socketImpl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.970 -0500", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "A2C45C726DF3589E75CC30136A07DA65")
        
public PlainSocketInputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.973 -0500", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "802CA1465F02E8195BBE40C292899388")
        
@Override public int available() throws IOException {
            return socketImpl.available();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.976 -0500", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "7E74E92E43F9BAA71C71D362FC69910A")
        
@Override public void close() throws IOException {
            socketImpl.close();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.978 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
        
@Override public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.981 -0500", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "5DFAC29EEC49AAF97DBB02CB60B20F3F")
        
@Override public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            return socketImpl.read(buffer, offset, byteCount);
        }
        
    }
    
    private static class PlainSocketOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.991 -0500", hash_original_field = "C92DD3B7F09F6096C227812F0F4031CF", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private  PlainSocketImpl socketImpl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.993 -0500", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "1471238D75713B5372A51EA45B1CCEE1")
        
public PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.996 -0500", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "7E74E92E43F9BAA71C71D362FC69910A")
        
@Override public void close() throws IOException {
            socketImpl.close();
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.999 -0500", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "2F6F8FCE8DC2AA447CE6E550ABE70F33")
        
@Override public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.001 -0500", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "0D4BAAF7F5F6E7E7943F39A61D2F6DF4")
        
@Override public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            socketImpl.write(buffer, offset, byteCount);
        }
        
    }

    /**
     * For PlainSocketInputStream.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.045 -0500", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "A1B021345B0502A87394E4382A6C7523")
    
private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        if (byteCount == 0) {
            return 0;
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if (shutdownInput) {
            return -1;
        }
        int readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
        // Return of zero bytes for a blocking socket means a timeout occurred
        if (readCount == 0) {
            throw new SocketTimeoutException();
        }
        // Return of -1 indicates the peer was closed
        if (readCount == -1) {
            shutdownInput = true;
        }
        return readCount;
    }

    /**
     * For PlainSocketOutputStream.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.047 -0500", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "5463C664C45B30B1791965FF58ACADD6")
    
private void write(byte[] buffer, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if (streaming) {
            while (byteCount > 0) {
                int bytesWritten = IoBridge.sendto(fd, buffer, offset, byteCount, 0, null, 0);
                byteCount -= bytesWritten;
                offset += bytesWritten;
            }
        } else {
            // Unlike writes to a streaming socket, writes to a datagram
            // socket are all-or-nothing, so we don't need a loop here.
            // http://code.google.com/p/android/issues/detail?id=15304
            IoBridge.sendto(fd, buffer, offset, byteCount, 0, address, port);
        }
    }
}

