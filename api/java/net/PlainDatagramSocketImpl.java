package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.StructGroupReq;
import libcore.util.EmptyArray;
import static libcore.io.OsConstants.*;

public class PlainDatagramSocketImpl extends DatagramSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.967 -0400", hash_original_field = "77B540FD61B8B8FFBCEAA60964FD06BB", hash_generated_field = "9D4B2046F6FC3648B8B879B96386B204")

    private volatile boolean isNativeConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.967 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.968 -0400", hash_original_field = "E9F9BA85EE8B2DA07B1AAFC67B3673C0", hash_generated_field = "73847774F9DA64C0A8E371069748C949")

    private InetAddress connectedAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.968 -0400", hash_original_field = "3DEA3D662C1D5F80091CB58099743C4F", hash_generated_field = "CEF230CAFEA932CF90A6DBC1FA0FEB98")

    private int connectedPort = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.968 -0400", hash_original_method = "FF5B4FF1395B9B48A74781458F7C1E74", hash_generated_method = "F69569036B9BF8D1D666C417831AC438")
    public  PlainDatagramSocketImpl(FileDescriptor fd, int localPort) {
        addTaint(localPort);
        addTaint(fd.getTaint());
        this.fd = fd;
        this.localPort = localPort;
    if(fd.valid())        
        {
            guard.open("close");
        } //End block
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localPort = localPort;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.969 -0400", hash_original_method = "D4BBB37482735C0570902FEE6B871111", hash_generated_method = "0B50554EC69C2AC737278909772A9528")
    public  PlainDatagramSocketImpl() {
        fd = new FileDescriptor();
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.970 -0400", hash_original_method = "B1D68F8F8FBA849D5DC5627B8806817B", hash_generated_method = "630B8F9342ED68BB41C411BDBA4020D5")
    @Override
    public void bind(int port, InetAddress address) throws SocketException {
        addTaint(address.getTaint());
        addTaint(port);
        IoBridge.bind(fd, address, port);
    if(port != 0)        
        {
            localPort = port;
        } //End block
        else
        {
            localPort = IoBridge.getSocketLocalPort(fd);
        } //End block
        try 
        {
            setOption(SocketOptions.SO_BROADCAST, Boolean.TRUE);
        } //End block
        catch (IOException ignored)
        {
        } //End block
        // ---------- Original Method ----------
        //IoBridge.bind(fd, address, port);
        //if (port != 0) {
            //localPort = port;
        //} else {
            //localPort = IoBridge.getSocketLocalPort(fd);
        //}
        //try {
            //setOption(SocketOptions.SO_BROADCAST, Boolean.TRUE);
        //} catch (IOException ignored) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.970 -0400", hash_original_method = "D39FE6DF46AF0712D00AFEA38D6C38F1", hash_generated_method = "98D2AEB4412C8F1848257B9E60BF8010")
    @Override
    public synchronized void close() {
        guard.close();
        try 
        {
            IoBridge.closeSocket(fd);
        } //End block
        catch (IOException ignored)
        {
        } //End block
        // ---------- Original Method ----------
        //guard.close();
        //try {
            //IoBridge.closeSocket(fd);
        //} catch (IOException ignored) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.971 -0400", hash_original_method = "070E6EC700413C2D4EE062356971B3CD", hash_generated_method = "14092F58ECD8BEDBFC2345B9D3F199FD")
    @Override
    public void create() throws SocketException {
        this.fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //this.fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.971 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "271B01A0C286411ADC3A779686EF67E4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.972 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "86B408D63F4D5A1DED19363B6A25550E")
    @Override
    public Object getOption(int option) throws SocketException {
        addTaint(option);
Object var7559B8D6B7C6B53535C98372E0E1C884_213983883 =         IoBridge.getSocketOption(fd, option);
        var7559B8D6B7C6B53535C98372E0E1C884_213983883.addTaint(taint);
        return var7559B8D6B7C6B53535C98372E0E1C884_213983883;
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.972 -0400", hash_original_method = "BF2D1BB0C5E1E015F3FE4931092FD89F", hash_generated_method = "4F7DE4C5108338EB5439167D6D6CBAFD")
    @Override
    public int getTimeToLive() throws IOException {
        int var19BF7F6D82885338D253D527FD37888A_631660116 = ((Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494555140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494555140;
        // ---------- Original Method ----------
        //return (Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.973 -0400", hash_original_method = "C71063A9367F37A3CEDAA8D1B842628A", hash_generated_method = "A895E8539913522A095A10050539FE09")
    @Override
    public byte getTTL() throws IOException {
        byte var27676E53A6ABED4FA8965C27129296E5_214364525 = ((byte) getTimeToLive());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1287844804 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1287844804;
        // ---------- Original Method ----------
        //return (byte) getTimeToLive();
    }

    
        private static StructGroupReq makeGroupReq(InetAddress gr_group, NetworkInterface networkInterface) {
        int gr_interface = (networkInterface != null) ? networkInterface.getIndex() : 0;
        return new StructGroupReq(gr_interface, gr_group);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.973 -0400", hash_original_method = "5A414D7F1F4B7D29FD74389039C76E5E", hash_generated_method = "F623CF466948EF076EDF4602D8B3D48D")
    @Override
    public void join(InetAddress addr) throws IOException {
        addTaint(addr.getTaint());
        setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.974 -0400", hash_original_method = "273B4AEA263ECC0370749C1CFAD10357", hash_generated_method = "E8E08867241BD294C550311728164350")
    @Override
    public void joinGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        addTaint(netInterface.getTaint());
        addTaint(addr.getTaint());
    if(addr instanceof InetSocketAddress)        
        {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.974 -0400", hash_original_method = "68D7D449E4F76C69A913900EB50ADB23", hash_generated_method = "A9B13B0311526DFD8E48A1679E82B3B8")
    @Override
    public void leave(InetAddress addr) throws IOException {
        addTaint(addr.getTaint());
        setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.975 -0400", hash_original_method = "4969BCB60F2AF80E11B01CE49FB27B9C", hash_generated_method = "036B91C1324354D84318D07395FF7A57")
    @Override
    public void leaveGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        addTaint(netInterface.getTaint());
        addTaint(addr.getTaint());
    if(addr instanceof InetSocketAddress)        
        {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.976 -0400", hash_original_method = "0B66924116C94ED3C0FF1D3069EB61F1", hash_generated_method = "CE275C095154BFA6266049D62FD6535E")
    @Override
    protected int peek(InetAddress sender) throws IOException {
        addTaint(sender.getTaint());
        DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        int result = peekData(packet);
        sender.ipaddress = packet.getAddress().getAddress();
        int varB4A88417B3D0170D754C647C30B7216A_1428713142 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243697533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243697533;
        // ---------- Original Method ----------
        //DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        //int result = peekData(packet);
        //sender.ipaddress = packet.getAddress().getAddress();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.976 -0400", hash_original_method = "7D10FF5DEA56961E254003DBDCD7E211", hash_generated_method = "5B80F8E6599BAB108A46CEDFAC9B490A")
    private void doRecv(DatagramPacket pack, int flags) throws IOException {
        addTaint(flags);
        addTaint(pack.getTaint());
        IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
    if(isNativeConnected)        
        {
            updatePacketRecvAddress(pack);
        } //End block
        // ---------- Original Method ----------
        //IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        //if (isNativeConnected) {
            //updatePacketRecvAddress(pack);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.977 -0400", hash_original_method = "224A3066C9859A283A41E4BE468B7199", hash_generated_method = "A24A277C045836674C20C541CDDB92E6")
    @Override
    public void receive(DatagramPacket pack) throws IOException {
        addTaint(pack.getTaint());
        doRecv(pack, 0);
        // ---------- Original Method ----------
        //doRecv(pack, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.978 -0400", hash_original_method = "CCC12A69269736949CE83C1543FC63FC", hash_generated_method = "8299FDFF2ABC2C2F850C41AC0E6DEA56")
    @Override
    public int peekData(DatagramPacket pack) throws IOException {
        addTaint(pack.getTaint());
        doRecv(pack, MSG_PEEK);
        int varAEF978F8ED92066B9F32649F3DFE2BCD_1178184229 = (pack.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051122802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051122802;
        // ---------- Original Method ----------
        //doRecv(pack, MSG_PEEK);
        //return pack.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.978 -0400", hash_original_method = "7ACBDBE2565DC623BE65BEE0D3657AD7", hash_generated_method = "AA3F35E5D26FFFB06A93C5D982ECD14D")
    @Override
    public void send(DatagramPacket packet) throws IOException {
        addTaint(packet.getTaint());
        int port = isNativeConnected ? 0 : packet.getPort();
        InetAddress address = isNativeConnected ? null : packet.getAddress();
        IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
        // ---------- Original Method ----------
        //int port = isNativeConnected ? 0 : packet.getPort();
        //InetAddress address = isNativeConnected ? null : packet.getAddress();
        //IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.979 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "D158AD7C51F9AD33335EEADD78E28B5A")
    public void setOption(int option, Object value) throws SocketException {
        addTaint(value.getTaint());
        addTaint(option);
        IoBridge.setSocketOption(fd, option, value);
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.979 -0400", hash_original_method = "DDE567B7B25A07BB14A31131F0762C29", hash_generated_method = "DDAC88B3271C55AE54A89183B0767503")
    @Override
    public void setTimeToLive(int ttl) throws IOException {
        addTaint(ttl);
        setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.979 -0400", hash_original_method = "AF63162F005FE2D131203598170CD418", hash_generated_method = "C2E88E2D0192CD2C913D1A96D5D6A294")
    @Override
    public void setTTL(byte ttl) throws IOException {
        addTaint(ttl);
        setTimeToLive((int) ttl & 0xff);
        // ---------- Original Method ----------
        //setTimeToLive((int) ttl & 0xff);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.980 -0400", hash_original_method = "C42A5992F0CED0134F017245292E33CB", hash_generated_method = "52D116244E3B5548C2B7D725627BC55A")
    @Override
    public void connect(InetAddress inetAddr, int port) throws SocketException {
        IoBridge.connect(fd, inetAddr, port);
        try 
        {
            connectedAddress = InetAddress.getByAddress(inetAddr.getAddress());
        } //End block
        catch (UnknownHostException e)
        {
            SocketException var815C915B1B299CF5E8808EFB2314BEE5_1838966125 = new SocketException("Host is unresolved: " + inetAddr.getHostName());
            var815C915B1B299CF5E8808EFB2314BEE5_1838966125.addTaint(taint);
            throw var815C915B1B299CF5E8808EFB2314BEE5_1838966125;
        } //End block
        connectedPort = port;
        isNativeConnected = true;
        // ---------- Original Method ----------
        //IoBridge.connect(fd, inetAddr, port);
        //try {
            //connectedAddress = InetAddress.getByAddress(inetAddr.getAddress());
        //} catch (UnknownHostException e) {
            //throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
        //}
        //connectedPort = port;
        //isNativeConnected = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.981 -0400", hash_original_method = "6540AF72C9B04626D85951E517011FFF", hash_generated_method = "5B49C83C8D202A00C7D2087021F456F9")
    @Override
    public void disconnect() {
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            AssertionError var8D75DBC63153835F7D08A31E99200A1F_794997012 = new AssertionError(errnoException);
            var8D75DBC63153835F7D08A31E99200A1F_794997012.addTaint(taint);
            throw var8D75DBC63153835F7D08A31E99200A1F_794997012;
        } //End block
        connectedPort = -1;
        connectedAddress = null;
        isNativeConnected = false;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        //} catch (ErrnoException errnoException) {
            //throw new AssertionError(errnoException);
        //}
        //connectedPort = -1;
        //connectedAddress = null;
        //isNativeConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.982 -0400", hash_original_method = "9F84EE545D7A893B2BE12E7FDE7E048D", hash_generated_method = "640C0BB32C25BE7BB659FD4016D60C77")
    private void updatePacketRecvAddress(DatagramPacket packet) {
        addTaint(packet.getTaint());
        packet.setAddress(connectedAddress);
        packet.setPort(connectedPort);
        // ---------- Original Method ----------
        //packet.setAddress(connectedAddress);
        //packet.setPort(connectedPort);
    }

    
}

