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
    private volatile boolean isNativeConnected;
    private CloseGuard guard = CloseGuard.get();
    private InetAddress connectedAddress;
    private int connectedPort = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.018 -0400", hash_original_method = "FF5B4FF1395B9B48A74781458F7C1E74", hash_generated_method = "BFD9F95EE9C4BE6F2C2ED0D724EAA201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainDatagramSocketImpl(FileDescriptor fd, int localPort) {
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(fd.dsTaint);
        this.fd = fd;
        this.localPort = localPort;
        {
            boolean varF60ABC869823C7B081E571E9390323D2_1332126912 = (fd.valid());
            {
                guard.open("close");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.localPort = localPort;
        //if (fd.valid()) {
            //guard.open("close");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.018 -0400", hash_original_method = "D4BBB37482735C0570902FEE6B871111", hash_generated_method = "0B50554EC69C2AC737278909772A9528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainDatagramSocketImpl() {
        fd = new FileDescriptor();
        // ---------- Original Method ----------
        //fd = new FileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.019 -0400", hash_original_method = "B1D68F8F8FBA849D5DC5627B8806817B", hash_generated_method = "AE84CD535AC104571B770926FB4C1F8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bind(int port, InetAddress address) throws SocketException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.019 -0400", hash_original_method = "D39FE6DF46AF0712D00AFEA38D6C38F1", hash_generated_method = "B7B2FE18BCE016DD2B512FFEF9222461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.019 -0400", hash_original_method = "070E6EC700413C2D4EE062356971B3CD", hash_generated_method = "14092F58ECD8BEDBFC2345B9D3F199FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void create() throws SocketException {
        this.fd = IoBridge.socket(false);
        // ---------- Original Method ----------
        //this.fd = IoBridge.socket(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.019 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.019 -0400", hash_original_method = "2F19BF683B55893709E7099E07E46044", hash_generated_method = "5A5EF84557BC71F8B8F4C2E8E7DC1C9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getOption(int option) throws SocketException {
        dsTaint.addTaint(option);
        Object varFEAA6C60FB0EA54EAAF32393AD9D756B_247743969 = (IoBridge.getSocketOption(fd, option));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IoBridge.getSocketOption(fd, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.020 -0400", hash_original_method = "BF2D1BB0C5E1E015F3FE4931092FD89F", hash_generated_method = "A24BCA1037EB9BEC4DA3B352460CE533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getTimeToLive() throws IOException {
        int varD34738B2125E8EE210EA143BCDE37814_1485353865 = ((Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Integer) getOption(IoBridge.JAVA_IP_MULTICAST_TTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.020 -0400", hash_original_method = "C71063A9367F37A3CEDAA8D1B842628A", hash_generated_method = "4A6CFE0ACC51C83BA3770C8A8F11F4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte getTTL() throws IOException {
        byte var3D376918AC930F39253C94D294027A83_943837143 = ((byte) getTimeToLive());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) getTimeToLive();
    }

    
        private static StructGroupReq makeGroupReq(InetAddress gr_group, NetworkInterface networkInterface) {
        int gr_interface = (networkInterface != null) ? networkInterface.getIndex() : 0;
        return new StructGroupReq(gr_interface, gr_group);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.020 -0400", hash_original_method = "5A414D7F1F4B7D29FD74389039C76E5E", hash_generated_method = "E7A7AE4892CF4210771946724E4125D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void join(InetAddress addr) throws IOException {
        dsTaint.addTaint(addr.dsTaint);
        setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.020 -0400", hash_original_method = "273B4AEA263ECC0370749C1CFAD10357", hash_generated_method = "130699A1B092F61F3B0033DE91454E84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void joinGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        dsTaint.addTaint(netInterface.dsTaint);
        dsTaint.addTaint(addr.dsTaint);
        {
            InetAddress groupAddr;
            groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_JOIN_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.020 -0400", hash_original_method = "68D7D449E4F76C69A913900EB50ADB23", hash_generated_method = "A4B773261497C31EB898301B2D7F1F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void leave(InetAddress addr) throws IOException {
        dsTaint.addTaint(addr.dsTaint);
        setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(addr, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.021 -0400", hash_original_method = "4969BCB60F2AF80E11B01CE49FB27B9C", hash_generated_method = "C7F59DB5678B59A4A819118B3C4FF81B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void leaveGroup(SocketAddress addr, NetworkInterface netInterface) throws IOException {
        dsTaint.addTaint(netInterface.dsTaint);
        dsTaint.addTaint(addr.dsTaint);
        {
            InetAddress groupAddr;
            groupAddr = ((InetSocketAddress) addr).getAddress();
            setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        } //End block
        // ---------- Original Method ----------
        //if (addr instanceof InetSocketAddress) {
            //InetAddress groupAddr = ((InetSocketAddress) addr).getAddress();
            //setOption(IoBridge.JAVA_MCAST_LEAVE_GROUP, makeGroupReq(groupAddr, netInterface));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.021 -0400", hash_original_method = "0B66924116C94ED3C0FF1D3069EB61F1", hash_generated_method = "EFFADB5083984BEBA7B14C613A5017FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int peek(InetAddress sender) throws IOException {
        dsTaint.addTaint(sender.dsTaint);
        DatagramPacket packet;
        packet = new DatagramPacket(EmptyArray.BYTE, 0);
        int result;
        result = peekData(packet);
        sender.ipaddress = packet.getAddress().getAddress();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //DatagramPacket packet = new DatagramPacket(EmptyArray.BYTE, 0);
        //int result = peekData(packet);
        //sender.ipaddress = packet.getAddress().getAddress();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.021 -0400", hash_original_method = "7D10FF5DEA56961E254003DBDCD7E211", hash_generated_method = "6F188D19E29EC0722F1B9CB6296F12BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doRecv(DatagramPacket pack, int flags) throws IOException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pack.dsTaint);
        IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        {
            updatePacketRecvAddress(pack);
        } //End block
        // ---------- Original Method ----------
        //IoBridge.recvfrom(false, fd, pack.getData(), pack.getOffset(), pack.getLength(), flags, pack, isNativeConnected);
        //if (isNativeConnected) {
            //updatePacketRecvAddress(pack);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.021 -0400", hash_original_method = "224A3066C9859A283A41E4BE468B7199", hash_generated_method = "3D988C860BE9D0E36F862E66F82B0D35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void receive(DatagramPacket pack) throws IOException {
        dsTaint.addTaint(pack.dsTaint);
        doRecv(pack, 0);
        // ---------- Original Method ----------
        //doRecv(pack, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.021 -0400", hash_original_method = "CCC12A69269736949CE83C1543FC63FC", hash_generated_method = "7942321C2C419184B00854D80DC324AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int peekData(DatagramPacket pack) throws IOException {
        dsTaint.addTaint(pack.dsTaint);
        doRecv(pack, MSG_PEEK);
        int varE290529FA3FF9D9955112219499A49B1_1874183164 = (pack.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //doRecv(pack, MSG_PEEK);
        //return pack.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.022 -0400", hash_original_method = "7ACBDBE2565DC623BE65BEE0D3657AD7", hash_generated_method = "78E887687711BDBC2EA0587CCB98F17E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(DatagramPacket packet) throws IOException {
        dsTaint.addTaint(packet.dsTaint);
        int port;
        port = 0;
        port = packet.getPort();
        InetAddress address;
        address = null;
        address = packet.getAddress();
        IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
        // ---------- Original Method ----------
        //int port = isNativeConnected ? 0 : packet.getPort();
        //InetAddress address = isNativeConnected ? null : packet.getAddress();
        //IoBridge.sendto(fd, packet.getData(), packet.getOffset(), packet.getLength(), 0, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.022 -0400", hash_original_method = "F61FA251C1FD1E3875B2C69F1E04AD45", hash_generated_method = "0D6ED39E9F521732A12B2A1AEE1B35EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOption(int option, Object value) throws SocketException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(option);
        IoBridge.setSocketOption(fd, option, value);
        // ---------- Original Method ----------
        //IoBridge.setSocketOption(fd, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.022 -0400", hash_original_method = "DDE567B7B25A07BB14A31131F0762C29", hash_generated_method = "0A4B092C63FEAE6689C554950A8DC16E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTimeToLive(int ttl) throws IOException {
        dsTaint.addTaint(ttl);
        setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
        // ---------- Original Method ----------
        //setOption(IoBridge.JAVA_IP_MULTICAST_TTL, Integer.valueOf(ttl));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.022 -0400", hash_original_method = "AF63162F005FE2D131203598170CD418", hash_generated_method = "C251C17C33DB5BBE37B9621AC2D32C40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTTL(byte ttl) throws IOException {
        dsTaint.addTaint(ttl);
        setTimeToLive((int) ttl & 0xff);
        // ---------- Original Method ----------
        //setTimeToLive((int) ttl & 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.022 -0400", hash_original_method = "C42A5992F0CED0134F017245292E33CB", hash_generated_method = "0BD8B65B9B6D374794CC2102A6F49B9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(InetAddress inetAddr, int port) throws SocketException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(inetAddr.dsTaint);
        IoBridge.connect(fd, inetAddr, port);
        try 
        {
            connectedAddress = InetAddress.getByAddress(inetAddr.getAddress());
        } //End block
        catch (UnknownHostException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.023 -0400", hash_original_method = "6540AF72C9B04626D85951E517011FFF", hash_generated_method = "522F06E76F717507EB96BA081608CD41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.023 -0400", hash_original_method = "9F84EE545D7A893B2BE12E7FDE7E048D", hash_generated_method = "855D853C4AE3A77311EDB91E1422DAEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePacketRecvAddress(DatagramPacket packet) {
        dsTaint.addTaint(packet.dsTaint);
        packet.setAddress(connectedAddress);
        packet.setPort(connectedPort);
        // ---------- Original Method ----------
        //packet.setAddress(connectedAddress);
        //packet.setPort(connectedPort);
    }

    
}

