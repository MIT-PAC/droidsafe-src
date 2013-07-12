package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.IoBridge;

public abstract class DatagramSocketImpl implements SocketOptions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.595 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    protected FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.595 -0400", hash_original_field = "55FC25CF376E1B7BFFBC2D46F357C231", hash_generated_field = "835B3BA626C36002B6BEC677A2C9AE47")

    protected int localPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.595 -0400", hash_original_method = "36741B3348F3C30E5BB773EA210AEA7B", hash_generated_method = "BE9AB5AB91B36FA3C83AE715C819627B")
    public  DatagramSocketImpl() {
        localPort = -1;
        // ---------- Original Method ----------
        //localPort = -1;
    }

    
    protected abstract void bind(int port, InetAddress addr) throws SocketException;

    
    protected abstract void close();

    
    protected abstract void create() throws SocketException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.596 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "8715BC18891BC17CAF8D89E689D19E7A")
    protected FileDescriptor getFileDescriptor() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_2026463505 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_2026463505.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_2026463505;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.597 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "91D80FED199FD6A9C8885E0DD117AE7B")
     InetAddress getLocalAddress() {
InetAddress var5B04D0CA841642814A75D4CAB88C3763_741710610 =         IoBridge.getSocketLocalAddress(fd);
        var5B04D0CA841642814A75D4CAB88C3763_741710610.addTaint(taint);
        return var5B04D0CA841642814A75D4CAB88C3763_741710610;
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.597 -0400", hash_original_method = "85505F9FF32DDEB1685867EF44676F61", hash_generated_method = "C1ADD9998DC835736E384DA0374EC946")
    protected int getLocalPort() {
        int var55FC25CF376E1B7BFFBC2D46F357C231_1970628083 = (localPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187387742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187387742;
        // ---------- Original Method ----------
        //return localPort;
    }

    
        @Deprecated
protected abstract byte getTTL() throws IOException;

    
    protected abstract int getTimeToLive() throws IOException;

    
    protected abstract void join(InetAddress addr) throws IOException;

    
    protected abstract void joinGroup(SocketAddress addr,
            NetworkInterface netInterface) throws IOException;

    
    protected abstract void leave(InetAddress addr) throws IOException;

    
    protected abstract void leaveGroup(SocketAddress addr,
            NetworkInterface netInterface) throws IOException;

    
    protected abstract int peek(InetAddress sender) throws IOException;

    
    protected abstract void receive(DatagramPacket pack) throws IOException;

    
    protected abstract void send(DatagramPacket pack) throws IOException;

    
    protected abstract void setTimeToLive(int ttl) throws IOException;

    
        @Deprecated
protected abstract void setTTL(byte ttl) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.599 -0400", hash_original_method = "4B57C399BF813581E92D5F53070EA8D4", hash_generated_method = "4E0325303BB17DD186D37C1B3AE1E6B2")
    protected void connect(InetAddress inetAddr, int port) throws SocketException {
        addTaint(port);
        addTaint(inetAddr.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.600 -0400", hash_original_method = "E948DE2D4A723F3312DB782756156847", hash_generated_method = "CD37B12F2AD777DD5DE0335AE279D597")
    protected void disconnect() {
        // ---------- Original Method ----------
    }

    
    protected abstract int peekData(DatagramPacket pack) throws IOException;

    
}

