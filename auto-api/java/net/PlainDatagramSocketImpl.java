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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.562 -0400", hash_original_field = "77B540FD61B8B8FFBCEAA60964FD06BB", hash_generated_field = "9D4B2046F6FC3648B8B879B96386B204")

    private volatile boolean isNativeConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.562 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.562 -0400", hash_original_field = "E9F9BA85EE8B2DA07B1AAFC67B3673C0", hash_generated_field = "73847774F9DA64C0A8E371069748C949")

    private InetAddress connectedAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.562 -0400", hash_original_field = "3DEA3D662C1D5F80091CB58099743C4F", hash_generated_field = "CEF230CAFEA932CF90A6DBC1FA0FEB98")

    private int connectedPort = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.563 -0400", hash_original_method = "FF5B4FF1395B9B48A74781458F7C1E74", hash_generated_method = "84B60E6D85B537A3ADC652BC99D0C559")
    public  PlainDatagramSocketImpl(FileDescriptor fd, int localPort) {
        this.fd = fd;
        this.localPort = localPort;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_1183219904 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(localPort);
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localPort = localPort;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.563 -0400", hash_original_method = "D4BBB37482735C0570902FEE6B871111", hash_generated_method = "0B50554EC69C2AC737278909772A9528")
    public  PlainDatagramSocketImpl() {
        fd = new FileDescriptor();
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.563 -0400", hash_original_method = "B1D68F8F8FBA849D5DC5627B8806817B", hash_generated_method = "5E9500AA7199D64F6665560ABAA5EE26")
    @Override
    public void bind(int port, InetAddress address) throws SocketException {
        IoBridge.bind(fd, address, port);
        {
            localPort = port;
        } //End block
        {
            localPort = IoBridge.getSocketLocalPort(fd);
        } //End block
        try 
        {
            setOption(SocketOptions.SO_BROADCAST, Boolean.TRUE);
        } //End block
        catch (IOException ignored)
        { }
        addTaint(port);
        addTaint(address.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.563 -0400", hash_original_method = "D39FE6DF46AF0712D00AFEA38D6C38F1", hash_generated_method = "B7B2FE18BCE016DD2B512FFEF9222461")
    @Override
    public synchronized void close() {
        guard.close();
        try 
        {
            IoBridge.closeSocket(fd);
        } //End block
        catch (IOException ignored)
        { }
        // ---------- Original Method ----------
        //guard.close();
        //try {
            //IoBridge.closeSocket(fd);
        //} catch (IOException ignored) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.564 -0400", hash_original_method = "070E6EC700413C2D4EE062356971B3CD", hash_generated_method = "14092F58ECD8BEDBFC2345B9D3F199FD")
    @Override
    public void create() throws SocketException {
        this.fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //this.fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.564 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.565 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "999939AFE6F8812D2F79366B8E8868DD")
    @Override
    public Object getOption(int option) throws SocketException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1586761998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1586761998 = IoBridge.getSocketOption(fd, option);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1586761998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586761998;
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.565 -0400", hash_original_method = "BF2D1BB0C5E1E015F3FE4931092FD89F", hash_generated_method = "882B2A82150E7F35DC14362938DFDA51")
    @Override
    public int getTimeToLive() throws IOException {
        int varD34738B2125E8EE210EA143BCDE37814_1097054913 = ((Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410612774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410612774;
        // ---------- Original Method ----------
        //return (Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.565 -0400", hash_original_method = "C71063A9367F37A3CEDAA8D1B842628A", hash_generated_method = "99CF06277859DCA94B91162B818F8874")
    @Override
    public byte getTTL() throws IOException {
        byte var3D376918AC930F39253C94D294027A83_1804131921 = ((byte) getTimeToLive());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_2131156026 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2131156026;
        // ---------- Original Method ----------
        //return (byte) getTimeToLive();
    }

    
    private static StructGroupReq makeGroupReq(InetAddress gr_group, NetworkInterface networkInterface) {
        int gr_interface = (networkInterface != null) ? networkInterface.getIndex() : 0;
        return new StructGroupReq(gr_interface, gr_group);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.565 -0400", hash_original_method = "5A414D7F1F4B7D29FD74389039C76E5E", hash_generated_method = "0827F2572B234121879D1FB9A249DC04")
    @Override
    public void join(InetAddress addr) throws IOException {
        setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
        addTaint(addr.getTaint());
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.566 -0400", hash_original_method = "273B4AEA263ECC0370749C1CFAD10357", hash_generated_method = "5D47380C0A4755486BA45050EF4C911B")
    @Override
    public void joinGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        addTaint(addr.getTaint());
        addTaint(netInterface.getTaint());
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.566 -0400", hash_original_method = "68D7D449E4F76C69A913900EB50ADB23", hash_generated_method = "D1FA54468FDF0F12B1C12A77D54089B2")
    @Override
    public void leave(InetAddress addr) throws IOException {
        setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
        addTaint(addr.getTaint());
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.566 -0400", hash_original_method = "4969BCB60F2AF80E11B01CE49FB27B9C", hash_generated_method = "865DC62F9EA02C837490F1EDEF74CA33")
    @Override
    public void leaveGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        addTaint(addr.getTaint());
        addTaint(netInterface.getTaint());
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.566 -0400", hash_original_method = "0B66924116C94ED3C0FF1D3069EB61F1", hash_generated_method = "CC5D6717A4679ED02FE869B415E8958A")
    @Override
    protected int peek(InetAddress sender) throws IOException {
        DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        int result = peekData(packet);
        sender.ipaddress = packet.getAddress().getAddress();
        addTaint(sender.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346458254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346458254;
        // ---------- Original Method ----------
        //DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        //int result = peekData(packet);
        //sender.ipaddress = packet.getAddress().getAddress();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.567 -0400", hash_original_method = "7D10FF5DEA56961E254003DBDCD7E211", hash_generated_method = "FBFC39047BFF6968079EF849333C8C8D")
    private void doRecv(DatagramPacket pack, int flags) throws IOException {
        IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        {
            updatePacketRecvAddress(pack);
        } //End block
        addTaint(pack.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        //if (isNativeConnected) {
            //updatePacketRecvAddress(pack);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.567 -0400", hash_original_method = "224A3066C9859A283A41E4BE468B7199", hash_generated_method = "0329A57BDE0ABC0256C3B772DA2E934B")
    @Override
    public void receive(DatagramPacket pack) throws IOException {
        doRecv(pack, 0);
        addTaint(pack.getTaint());
        // ---------- Original Method ----------
        //doRecv(pack, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.567 -0400", hash_original_method = "CCC12A69269736949CE83C1543FC63FC", hash_generated_method = "B2A7EF3B310704BBE485B16358A579DB")
    @Override
    public int peekData(DatagramPacket pack) throws IOException {
        doRecv(pack, MSG_PEEK);
        int varE290529FA3FF9D9955112219499A49B1_1918213002 = (pack.getPort());
        addTaint(pack.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624393673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624393673;
        // ---------- Original Method ----------
        //doRecv(pack, MSG_PEEK);
        //return pack.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.567 -0400", hash_original_method = "7ACBDBE2565DC623BE65BEE0D3657AD7", hash_generated_method = "E633F1FA62D568847F2F6CE39CDA7B45")
    @Override
    public void send(DatagramPacket packet) throws IOException {
        int port;
        port = 0;
        port = packet.getPort();
        InetAddress address;
        address = null;
        address = packet.getAddress();
        IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
        addTaint(packet.getTaint());
        // ---------- Original Method ----------
        //int port = isNativeConnected ? 0 : packet.getPort();
        //InetAddress address = isNativeConnected ? null : packet.getAddress();
        //IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.568 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "8545D34DFA4312AAA88AD5F02694A1EF")
    public void setOption(int option, Object value) throws SocketException {
        IoBridge.setSocketOption(fd, option, value);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.568 -0400", hash_original_method = "DDE567B7B25A07BB14A31131F0762C29", hash_generated_method = "7935A9B21A61988A48CE74641498E6B3")
    @Override
    public void setTimeToLive(int ttl) throws IOException {
        setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
        addTaint(ttl);
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.568 -0400", hash_original_method = "AF63162F005FE2D131203598170CD418", hash_generated_method = "7304BCD2A9B0DACF0FABF3A3ED953C52")
    @Override
    public void setTTL(byte ttl) throws IOException {
        setTimeToLive((int) ttl & 0xff);
        addTaint(ttl);
        // ---------- Original Method ----------
        //setTimeToLive((int) ttl & 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.568 -0400", hash_original_method = "C42A5992F0CED0134F017245292E33CB", hash_generated_method = "774FFEE907A0F5A5829085F39CB7CF83")
    @Override
    public void connect(InetAddress inetAddr, int port) throws SocketException {
        IoBridge.connect(fd, inetAddr, port);
        try 
        {
            connectedAddress = InetAddress.getByAddress(inetAddr.getAddress());
        } //End block
        catch (UnknownHostException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.569 -0400", hash_original_method = "6540AF72C9B04626D85951E517011FFF", hash_generated_method = "522F06E76F717507EB96BA081608CD41")
    @Override
    public void disconnect() {
        try 
        {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.569 -0400", hash_original_method = "9F84EE545D7A893B2BE12E7FDE7E048D", hash_generated_method = "1034C6B1C3C30326707191D2343D7C98")
    private void updatePacketRecvAddress(DatagramPacket packet) {
        packet.setAddress(connectedAddress);
        packet.setPort(connectedPort);
        addTaint(packet.getTaint());
        // ---------- Original Method ----------
        //packet.setAddress(connectedAddress);
        //packet.setPort(connectedPort);
    }

    
}

