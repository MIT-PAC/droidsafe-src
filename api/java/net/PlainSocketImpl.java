package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.611 -0400", hash_original_field = "7DEF0BDA40D0E04BF9A6A07F09AE1E51", hash_generated_field = "6A8CCB2C47D2D8E132EF5F76D32DB937")

    private boolean streaming = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.611 -0400", hash_original_field = "989BFF50F10AD27F4007C187334D8DE7", hash_generated_field = "3A0B3C0A8DEC4D2F6AA0372C4FB59EF4")

    private boolean shutdownInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.611 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.611 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.612 -0400", hash_original_method = "4D935B4FE660019BCAE5A9978A293C92", hash_generated_method = "0339E41B25CA2DC402DE5BA176A14F70")
    public  PlainSocketImpl(FileDescriptor fd) {
        this.fd = fd;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_1785865194 = (fd.valid());
            {
                guard.open("close");
            } 
        } 
        addTaint(fd.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.612 -0400", hash_original_method = "261EDE8B6DD34705D1641BCCC0FB075D", hash_generated_method = "572BD4D8C80F6E5CF3D7310CFBD2C2C8")
    public  PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        this.proxy = proxy;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.612 -0400", hash_original_method = "9AFAA74CF852E1C405941486398C4C8B", hash_generated_method = "8644C6045E743F187FD836913AA183B7")
    public  PlainSocketImpl() {
        this(new FileDescriptor());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.612 -0400", hash_original_method = "FFE0B1E5C9CF01CED30EEDFFB254CB41", hash_generated_method = "497B26862420ACBB497CADD991F1A590")
    public  PlainSocketImpl(FileDescriptor fd, int localport, InetAddress addr, int port) {
        this.fd = fd;
        this.localport = localport;
        this.address = addr;
        this.port = port;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_1679596751 = (fd.valid());
            {
                guard.open("close");
            } 
        } 
        addTaint(fd.getTaint());
        addTaint(localport);
        addTaint(addr.getTaint());
        addTaint(port);
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.613 -0400", hash_original_method = "7A83CE97AECF8C418E9A73B613D40E3A", hash_generated_method = "F71C242005410FD0C04ACFCF9E706DF6")
    @Override
    protected void accept(SocketImpl newImpl) throws IOException {
        {
            boolean varC406138A2988833B68553822CD3B489E_2021197605 = (usingSocks());
            {
                ((PlainSocketImpl) newImpl).socksBind();
                ((PlainSocketImpl) newImpl).socksAccept();
            } 
        } 
        try 
        {
            InetSocketAddress peerAddress = new InetSocketAddress();
            FileDescriptor clientFd = Libcore.os.accept(fd, peerAddress);
            newImpl.fd.setInt$(clientFd.getInt$());
            newImpl.address = peerAddress.getAddress();
            newImpl.port = peerAddress.getPort();
        } 
        catch (ErrnoException errnoException)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketTimeoutException(errnoException);
            } 
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        newImpl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(0));
        newImpl.localport = IoBridge.getSocketLocalPort(newImpl.fd);
        addTaint(newImpl.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.613 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "729917F591D29978FF12C52ADB8A4E33")
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_1884367619 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022355486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022355486;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.613 -0400", hash_original_method = "71A74E49E6970F91549D0885CC2DD805", hash_generated_method = "D998F7F07537A927CF5120B78C2E8180")
    public void initLocalPort(int localPort) {
        this.localport = localPort;
        addTaint(localPort);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.613 -0400", hash_original_method = "2FB3C28FA9096CEDAB5697B9A14F4A6D", hash_generated_method = "3BBA8F8B26AC86F52B7CFD41A6C93C0D")
    public void initRemoteAddressAndPort(InetAddress remoteAddress, int remotePort) {
        this.address = remoteAddress;
        this.port = remotePort;
        addTaint(remoteAddress.getTaint());
        addTaint(remotePort);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.613 -0400", hash_original_method = "000D9AECCAE4DD07D923EE0ADC4BD644", hash_generated_method = "64081A53F414BBBB956607DC5FE04823")
    private void checkNotClosed() throws IOException {
        {
            boolean varE59BFD645E8CFB789878AA5C4C3DD887_635213302 = (!fd.valid());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.614 -0400", hash_original_method = "4AE73BDFE66EC427EEC7327D1955F75B", hash_generated_method = "2F983EAE2CE735CAC4CCE6C0B5B37E3A")
    @Override
    protected synchronized int available() throws IOException {
        checkNotClosed();
        int var9C891A36C646640680B2116257EF3205_925957850 = (IoBridge.available(fd));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599776959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599776959;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.614 -0400", hash_original_method = "9F1E5C79CA0AA6C434B736E50E58B125", hash_generated_method = "0826E3620A6995B297F91D8DA30227E9")
    @Override
    protected void bind(InetAddress address, int port) throws IOException {
        IoBridge.bind(fd, address, port);
        this.address = address;
        {
            this.localport = port;
        } 
        {
            this.localport = IoBridge.getSocketLocalPort(fd);
        } 
        addTaint(address.getTaint());
        addTaint(port);
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.614 -0400", hash_original_method = "0DC75F7C7240FEBBF9FD4E0AED069D80", hash_generated_method = "028C30BDF845EBB6CAF2C41AC41890BC")
    @Override
    protected synchronized void close() throws IOException {
        guard.close();
        IoBridge.closeSocket(fd);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.615 -0400", hash_original_method = "D48633DD95102A35EC1C995654D6F3E8", hash_generated_method = "E2AAD0075B441D118F9D7CF11BD73182")
    @Override
    protected void connect(String aHost, int aPort) throws IOException {
        connect(InetAddress.getByName(aHost), aPort);
        addTaint(aHost.getTaint());
        addTaint(aPort);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.615 -0400", hash_original_method = "AC6D281722BA029F05A67510D93D7EBD", hash_generated_method = "EEE033DDA2022CC2ED94333067904E83")
    @Override
    protected void connect(InetAddress anAddr, int aPort) throws IOException {
        connect(anAddr, aPort, 0);
        addTaint(anAddr.getTaint());
        addTaint(aPort);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.615 -0400", hash_original_method = "CF0E894E8F0E8260CA9CE5027C85CCBC", hash_generated_method = "5A047D0BE84B78E5662E7287F32142FF")
    private void connect(InetAddress anAddr, int aPort, int timeout) throws IOException {
        InetAddress normalAddr;
        boolean varAB3CA3FA0BD782A23FE1A25DBF62160F_1315908646 = (anAddr.isAnyLocalAddress());
        normalAddr = InetAddress.getLocalHost();
        normalAddr = anAddr;
        {
            boolean var400AC900BEFEE49F89BB8165B8EB5056_1405199849 = (streaming && usingSocks());
            {
                socksConnect(anAddr, aPort, 0);
            } 
            {
                IoBridge.connect(fd, normalAddr, aPort, timeout);
            } 
        } 
        super.address = normalAddr;
        super.port = aPort;
        addTaint(anAddr.getTaint());
        addTaint(aPort);
        addTaint(timeout);
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.616 -0400", hash_original_method = "E78DD5CBE2B052B946F0A3B4178F9290", hash_generated_method = "5CA4F9F37FE885627E57D0C5486A5E2A")
    @Override
    protected void create(boolean streaming) throws IOException {
        this.streaming = streaming;
        this.fd = IoBridge.socket(streaming);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.616 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } 
            close();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.617 -0400", hash_original_method = "2248E71A4E4A8097B0C4AD58D0A7C2D1", hash_generated_method = "DA54F7A333A3A2AAF2E91ECA6A702317")
    @Override
    protected synchronized InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1409774453 = null; 
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1409774453 = new PlainSocketInputStream(this);
        varB4EAC82CA7396A68D541C85D26508E83_1409774453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1409774453;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.618 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "2E5AEDBD99552FF5AE1852A6300F8AFB")
    @Override
    public Object getOption(int option) throws SocketException {
        Object varB4EAC82CA7396A68D541C85D26508E83_744470674 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_744470674 = IoBridge.getSocketOption(fd, option);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_744470674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_744470674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.619 -0400", hash_original_method = "A64D8FD75C66D0E7EE62C06614C117E8", hash_generated_method = "59752B96FF5F6ACC69CF3908FA51A2CA")
    @Override
    protected synchronized OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_614306901 = null; 
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_614306901 = new PlainSocketOutputStream(this);
        varB4EAC82CA7396A68D541C85D26508E83_614306901.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_614306901;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.620 -0400", hash_original_method = "92B125776FD98ACD40A53B9D967365FC", hash_generated_method = "885F8EBCDE37CC6C6236ACCA34585A11")
    @Override
    protected void listen(int backlog) throws IOException {
        {
            boolean varC406138A2988833B68553822CD3B489E_897988614 = (usingSocks());
        } 
        try 
        {
            Libcore.os.listen(fd, backlog);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        addTaint(backlog);
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.621 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "3D26DE208CF202E2A774CE8E05434E41")
    @Override
    public void setOption(int option, Object value) throws SocketException {
        IoBridge.setSocketOption(fd, option, value);
        addTaint(option);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.621 -0400", hash_original_method = "64392856CD4BE8946E6224874D95C0C3", hash_generated_method = "5E6910647E642F270C32C381FA5C5BE6")
    private int socksGetServerPort() {
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        int var87288984078DF9FAA63BC2E896AA02F3_191328446 = (addr.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43090232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43090232;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.622 -0400", hash_original_method = "FA814969259FF99D2E9F464DE776F517", hash_generated_method = "B3D54A6E2289EC8454D3BFF691CD5DC4")
    private InetAddress socksGetServerAddress() throws UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_69162253 = null; 
        String proxyName;
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        proxyName = addr.getHostName();
        {
            proxyName = addr.getAddress().getHostAddress();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_69162253 = InetAddress.getByName(proxyName);
        varB4EAC82CA7396A68D541C85D26508E83_69162253.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_69162253;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.623 -0400", hash_original_method = "679FA19AE8A4DD99CA71F6CF7886F900", hash_generated_method = "F9B03D97E27A95F69BFA852232BE7426")
    private void socksConnect(InetAddress applicationServerAddress, int applicationServerPort, int timeout) throws IOException {
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort(), timeout);
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("SOCKS connection failed", e);
        } 
        socksRequestConnection(applicationServerAddress, applicationServerPort);
        lastConnectedAddress = applicationServerAddress;
        lastConnectedPort = applicationServerPort;
        addTaint(applicationServerAddress.getTaint());
        addTaint(applicationServerPort);
        addTaint(timeout);
        
        
            
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.623 -0400", hash_original_method = "0ACA5DB4B67DEB9A055E1E45DC82A265", hash_generated_method = "1BA3FA8D6B998CF595DC6EBBCA2AF96D")
    private void socksRequestConnection(InetAddress applicationServerAddress,
            int applicationServerPort) throws IOException {
        socksSendRequest(Socks4Message.COMMAND_CONNECT,
                applicationServerAddress, applicationServerPort);
        Socks4Message reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_582730020 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } 
        } 
        addTaint(applicationServerAddress.getTaint());
        addTaint(applicationServerPort);
        
        
                
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.624 -0400", hash_original_method = "0B2DE5EAED23ABC2AB533476CA60B194", hash_generated_method = "B1F7FBE9F757E49F091B15998671D43C")
    public void socksAccept() throws IOException {
        Socks4Message reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_122098908 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.624 -0400", hash_original_method = "69EAD59EF006B3A496038767E7251C79", hash_generated_method = "C60F93F0813BA3D29D92F1EF88F13EDA")
    @Override
    protected void shutdownInput() throws IOException {
        shutdownInput = true;
        try 
        {
            Libcore.os.shutdown(fd, SHUT_RD);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.625 -0400", hash_original_method = "40C13EAB5470D8D1FC8D6DE9CC466037", hash_generated_method = "1D4FE6DE101B7F0AC7CB44B4170473EF")
    @Override
    protected void shutdownOutput() throws IOException {
        try 
        {
            Libcore.os.shutdown(fd, SHUT_WR);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.625 -0400", hash_original_method = "D66101C95E8A449E156BD86059B4B4F6", hash_generated_method = "B3B192C558FD943D4C9F8D677C5D38F9")
    private void socksBind() throws IOException {
        try 
        {
            IoBridge.connect(fd, socksGetServerAddress(), socksGetServerPort());
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to connect to SOCKS server", e);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Invalid SOCKS client");
        } 
        socksSendRequest(Socks4Message.COMMAND_BIND, lastConnectedAddress,
                lastConnectedPort);
        Socks4Message reply = socksReadReply();
        {
            boolean varB90FD30C634CD2BE843BCFA5E143701E_1961729614 = (reply.getCommandOrResult() != Socks4Message.RETURN_SUCCESS);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(reply.getErrorString(reply.getCommandOrResult()));
            } 
        } 
        {
            boolean varF52642BBE0E60EBE2FFA3951D938EA0F_1503002505 = (reply.getIP() == 0);
            {
                address = socksGetServerAddress();
            } 
            {
                byte[] replyBytes = new byte[4];
                Memory.pokeInt(replyBytes, 0, reply.getIP(), ByteOrder.BIG_ENDIAN);
                address = InetAddress.getByAddress(replyBytes);
            } 
        } 
        localport = reply.getPort();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.626 -0400", hash_original_method = "6D223BF7FD79AD9333E45AB0A54AA37D", hash_generated_method = "F4B4D3BFE00C5285097595A88C064781")
    private void socksSendRequest(int command, InetAddress address, int port) throws IOException {
        Socks4Message request = new Socks4Message();
        request.setCommandOrResult(command);
        request.setPort(port);
        request.setIP(address.getAddress());
        request.setUserId("default");
        getOutputStream().write(request.getBytes(), 0, request.getLength());
        addTaint(command);
        addTaint(address.getTaint());
        addTaint(port);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.628 -0400", hash_original_method = "8280AE4C517B666A0E69D98449480DDD", hash_generated_method = "A28F44CF4F2418C94A128602F30D4030")
    private Socks4Message socksReadReply() throws IOException {
        Socks4Message varB4EAC82CA7396A68D541C85D26508E83_1713948975 = null; 
        Socks4Message reply = new Socks4Message();
        int bytesRead = 0;
        {
            int count = getInputStream().read(reply.getBytes(), bytesRead,
                    Socks4Message.REPLY_LENGTH - bytesRead);
            bytesRead += count;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Malformed reply from SOCKS server");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1713948975 = reply;
        varB4EAC82CA7396A68D541C85D26508E83_1713948975.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1713948975;
        
        
        
        
            
                    
            
                
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.628 -0400", hash_original_method = "A07BD72481E91ED1ACC24877AC862F5F", hash_generated_method = "827F0EE63DD76EB02AAD8DD99601BC38")
    @Override
    protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        connect(inetAddr.getAddress(), inetAddr.getPort(), timeout);
        addTaint(remoteAddr.getTaint());
        addTaint(timeout);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.629 -0400", hash_original_method = "C84277CCCCD515C678DD8E297690CF63", hash_generated_method = "4CED57B41B70146B37776EF1CC5CF9A6")
    @Override
    protected boolean supportsUrgentData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111654934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111654934;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.629 -0400", hash_original_method = "A7E9EDD729A11A6482B0E5B153D87499", hash_generated_method = "0EC76369CE18369AA05188FC0F1E908E")
    @Override
    protected void sendUrgentData(int value) throws IOException {
        try 
        {
            byte[] buffer = new byte[] { (byte) value };
            Libcore.os.sendto(fd, buffer, 0, 1, MSG_OOB, null, 0);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        addTaint(value);
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.630 -0400", hash_original_method = "8E8D9564EE0B9256E101864557DD238B", hash_generated_method = "70922E9BA5D48886610B026D01281438")
    private int read(byte[] buffer, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        int readCount = IoBridge.recvfrom(true, fd, buffer, offset, byteCount, 0, null, false);
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketTimeoutException();
        } 
        {
            shutdownInput = true;
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521205377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521205377;
        
        
            
        
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.630 -0400", hash_original_method = "0BAFEFFE1F4A4A29CFC7D3BD2B2D732D", hash_generated_method = "917B8D670A4D0D5670CD044EF0039E14")
    private void write(byte[] buffer, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            {
                int bytesWritten = IoBridge.sendto(fd, buffer, offset, byteCount, 0, null, 0);
                byteCount -= bytesWritten;
                offset += bytesWritten;
            } 
        } 
        {
            IoBridge.sendto(fd, buffer, offset, byteCount, 0, address, port);
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        
        
        
            
                
                
                
            
        
            
        
    }

    
    private static class PlainSocketInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.630 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.631 -0400", hash_original_method = "9707F729DB9DE0F069F9B6F666CEAF41", hash_generated_method = "C543451A717B658BC3AAB7E48B419774")
        public  PlainSocketInputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.631 -0400", hash_original_method = "4F6C4EDBF6F94B4350B82DBC8B61EF44", hash_generated_method = "68A3253B31222BB49037EFEC9E926278")
        @Override
        public int available() throws IOException {
            int var86CF5DFFEEA217678DC644B06FA451FF_1989109003 = (socketImpl.available());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004988448 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004988448;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.631 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.632 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "E149DC5B79AACB128732A08F9BFADA3A")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_1325668564 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402979048 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402979048;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.632 -0400", hash_original_method = "83571F5C87BAB215B1B7EB80A1B1F5C1", hash_generated_method = "E502D350CC42948A02918F808C4C7BA6")
        @Override
        public int read(byte[] buffer, int offset, int byteCount) throws IOException {
            int var88EDD8144C9A19872588BB8011279A12_766678827 = (socketImpl.read(buffer, offset, byteCount));
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291490608 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291490608;
            
            
        }

        
    }


    
    private static class PlainSocketOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.632 -0400", hash_original_field = "31BE1E23DE379D748DAA84AEF8C5EA67", hash_generated_field = "16CEE3972B12A3C5752670B7FF7939A7")

        private PlainSocketImpl socketImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.632 -0400", hash_original_method = "1A4D21BF9006CF014C027978C481D31A", hash_generated_method = "0BF9D04DB29AB8AC4588EA1E9EC7AFA4")
        public  PlainSocketOutputStream(PlainSocketImpl socketImpl) {
            this.socketImpl = socketImpl;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.632 -0400", hash_original_method = "6270DBEE277D6F2FF2E49396D9FF160A", hash_generated_method = "FA1FE10FAC253C7C1AE0451981A53FC5")
        @Override
        public void close() throws IOException {
            socketImpl.close();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.633 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "7C9196718755845369790934EC3B8FE0")
        @Override
        public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
            addTaint(oneByte);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.633 -0400", hash_original_method = "92B26271A04D40A7BFB8B8109985B5A0", hash_generated_method = "D16AF98B4C79D86F224993C339434068")
        @Override
        public void write(byte[] buffer, int offset, int byteCount) throws IOException {
            socketImpl.write(buffer, offset, byteCount);
            addTaint(buffer[0]);
            addTaint(offset);
            addTaint(byteCount);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.633 -0400", hash_original_field = "95B06B2D766DEAF3F030BBBF1B4C69EC", hash_generated_field = "8E7174254564594C7825688884BD26C6")

    private static InetAddress lastConnectedAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.633 -0400", hash_original_field = "ADB4A06A0D48FC4B9CD01A3A3960E4A5", hash_generated_field = "0C17CA5E0BC8EA30C7FC6175AC3AE9C2")

    private static int lastConnectedPort;
}

