package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.MSG_PEEK;

import java.io.FileDescriptor;
import java.io.IOException;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.StructGroupReq;
import libcore.util.EmptyArray;
import dalvik.system.CloseGuard;

public class PlainDatagramSocketImpl extends DatagramSocketImpl {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.877 -0500", hash_original_method = "E20F53A6F68C893F54FE6F4EDC3A37F7", hash_generated_method = "C644F8A0EF4D10717D34427B0C7526D8")
    
private static StructGroupReq makeGroupReq(InetAddress gr_group, NetworkInterface networkInterface) {
        int gr_interface = (networkInterface != null) ? networkInterface.getIndex() : 0;
        return new StructGroupReq(gr_interface, gr_group);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.844 -0500", hash_original_field = "A2C06E7ABDE0E3F9668B442F14231C44", hash_generated_field = "9D4B2046F6FC3648B8B879B96386B204")

    private volatile boolean isNativeConnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.846 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.849 -0500", hash_original_field = "10D0D7C38A3D62029C9AC38CB273BC17", hash_generated_field = "73847774F9DA64C0A8E371069748C949")

    private InetAddress connectedAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.851 -0500", hash_original_field = "F885AFC27512D26CA5ACC3CB5E7EF1C6", hash_generated_field = "CEF230CAFEA932CF90A6DBC1FA0FEB98")

    private int connectedPort = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.854 -0500", hash_original_method = "FF5B4FF1395B9B48A74781458F7C1E74", hash_generated_method = "CD243A4D406B1CE88D096C4AB5B82346")
    
public PlainDatagramSocketImpl(FileDescriptor fd, int localPort) {
        this.fd = fd;
        this.localPort = localPort;
        if (fd.valid()) {
            guard.open("close");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.856 -0500", hash_original_method = "D4BBB37482735C0570902FEE6B871111", hash_generated_method = "1127C899720EE2506E7999AAA4DA17BE")
    
public PlainDatagramSocketImpl() {
        fd = new FileDescriptor();
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.859 -0500", hash_original_method = "B1D68F8F8FBA849D5DC5627B8806817B", hash_generated_method = "5DA1DF467FE12E447F3EA339A88EA704")
    
@Override public void bind(int port, InetAddress address) throws SocketException {
        IoBridge.bind(fd, address, port);
        if (port != 0) {
            localPort = port;
        } else {
            localPort = IoBridge.getSocketLocalPort(fd);
        }
        try {
            setOption(SocketOptions.SO_BROADCAST, Boolean.TRUE);
        } catch (IOException ignored) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.861 -0500", hash_original_method = "D39FE6DF46AF0712D00AFEA38D6C38F1", hash_generated_method = "503BF11CAEA101C1FC4C8E16D8E95DBE")
    
@Override
    public synchronized void close() {
        guard.close();
        try {
            IoBridge.closeSocket(fd);
        } catch (IOException ignored) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.864 -0500", hash_original_method = "070E6EC700413C2D4EE062356971B3CD", hash_generated_method = "FE916DDD2535BF364114696335B3A32A")
    
@Override
    public void create() throws SocketException {
        this.fd = IoBridge.socket(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.866 -0500", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "F0F8D8EC0C5D8FA9E7582C7E60A1D793")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.868 -0500", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "E4022F8103EB1A999EF7210C13D3EA7F")
    
@Override public Object getOption(int option) throws SocketException {
        return IoBridge.getSocketOption(fd, option);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.871 -0500", hash_original_method = "BF2D1BB0C5E1E015F3FE4931092FD89F", hash_generated_method = "1F5574FA71AF89814F0AD998499522EC")
    
@Override
    public int getTimeToLive() throws IOException {
        return (Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.874 -0500", hash_original_method = "C71063A9367F37A3CEDAA8D1B842628A", hash_generated_method = "17861E7107997E722492B2BD561FB223")
    
@Override
    public byte getTTL() throws IOException {
        return (byte) getTimeToLive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.879 -0500", hash_original_method = "5A414D7F1F4B7D29FD74389039C76E5E", hash_generated_method = "AEEC27F4570512560CD2A977C2A29CD4")
    
@Override
    public void join(InetAddress addr) throws IOException {
        setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.882 -0500", hash_original_method = "273B4AEA263ECC0370749C1CFAD10357", hash_generated_method = "80FCEC3D8111F4A0A693F99E3FF9B4E4")
    
@Override
    public void joinGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        if (addr instanceof InetSocketAddress) {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.884 -0500", hash_original_method = "68D7D449E4F76C69A913900EB50ADB23", hash_generated_method = "081A9C537409B02BDEA2CC9681E53A6E")
    
@Override
    public void leave(InetAddress addr) throws IOException {
        setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.887 -0500", hash_original_method = "4969BCB60F2AF80E11B01CE49FB27B9C", hash_generated_method = "C50ECF58B1D166483FAB91D1159DEA92")
    
@Override
    public void leaveGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        if (addr instanceof InetSocketAddress) {
            InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.889 -0500", hash_original_method = "0B66924116C94ED3C0FF1D3069EB61F1", hash_generated_method = "9C9E97C0947B597CD5D26B91DCCCE613")
    
@Override
    protected int peek(InetAddress sender) throws IOException {
        // We don't actually want the data: we just want the DatagramPacket's filled-in address.
        DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        int result = peekData(packet);
        // Note: evil side-effect on InetAddress! This method should have returned InetSocketAddress!
        sender.ipaddress = packet.getAddress().getAddress();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.892 -0500", hash_original_method = "7D10FF5DEA56961E254003DBDCD7E211", hash_generated_method = "B5A7C5EAF6249AF20CD97CA8D51B9B88")
    
private void doRecv(DatagramPacket pack, int flags) throws IOException {
        IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        if (isNativeConnected) {
            updatePacketRecvAddress(pack);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.894 -0500", hash_original_method = "224A3066C9859A283A41E4BE468B7199", hash_generated_method = "0363AB5552EDF647F600D6EC1ACAECAA")
    
@Override
    public void receive(DatagramPacket pack) throws IOException {
        doRecv(pack, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.897 -0500", hash_original_method = "CCC12A69269736949CE83C1543FC63FC", hash_generated_method = "D36ED480D64CA9733767A29812015850")
    
@Override
    public int peekData(DatagramPacket pack) throws IOException {
        doRecv(pack, MSG_PEEK);
        return pack.getPort();
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.899 -0500", hash_original_method = "7ACBDBE2565DC623BE65BEE0D3657AD7", hash_generated_method = "0BFCA5B9E8610196A8781683A57C6233")
    
@Override
    public void send(DatagramPacket packet) throws IOException {
        int port = isNativeConnected ? 0 : packet.getPort();
        InetAddress address = isNativeConnected ? null : packet.getAddress();
        IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.902 -0500", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "AE27391CD17E1D58FFCEB5C4E4CAE6A8")
    
public void setOption(int option, Object value) throws SocketException {
        IoBridge.setSocketOption(fd, option, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.904 -0500", hash_original_method = "DDE567B7B25A07BB14A31131F0762C29", hash_generated_method = "5C3E2943F69E515E3612C32D8E04FB94")
    
@Override
    public void setTimeToLive(int ttl) throws IOException {
        setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.907 -0500", hash_original_method = "AF63162F005FE2D131203598170CD418", hash_generated_method = "BAF0960B9E2027329CA8EFAE2F0A80A8")
    
@Override
    public void setTTL(byte ttl) throws IOException {
        setTimeToLive((int) ttl & 0xff); // Avoid sign extension.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.909 -0500", hash_original_method = "C42A5992F0CED0134F017245292E33CB", hash_generated_method = "A23644CEE9E44AA49DA7490CE492C65A")
    
@Override
    public void connect(InetAddress inetAddr, int port) throws SocketException {
        IoBridge.connect(fd, inetAddr, port); // Throws on failure.
        try {
            connectedAddress = InetAddress.getByAddress(inetAddr.getAddress());
        } catch (UnknownHostException e) {
            // this is never expected to happen as we should not have gotten
            // here if the address is not resolvable
            throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
        }
        connectedPort = port;
        isNativeConnected = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.912 -0500", hash_original_method = "6540AF72C9B04626D85951E517011FFF", hash_generated_method = "007C9978E4CC413064271527F5299112")
    
@Override
    public void disconnect() {
        try {
            Libcore.os.connect(fd, InetAddress.UNSPECIFIED, 0);
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
        connectedPort = -1;
        connectedAddress = null;
        isNativeConnected = false;
    }

    /**
     * Set the received address and port in the packet. We do this when the
     * Datagram socket is connected at the native level and the
     * recvConnnectedDatagramImpl does not update the packet with address from
     * which the packet was received
     *
     * @param packet
     *            the packet to be updated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.914 -0500", hash_original_method = "9F84EE545D7A893B2BE12E7FDE7E048D", hash_generated_method = "3550118099D2274DF1E233703CE4A395")
    
private void updatePacketRecvAddress(DatagramPacket packet) {
        packet.setAddress(connectedAddress);
        packet.setPort(connectedPort);
    }
    
}

