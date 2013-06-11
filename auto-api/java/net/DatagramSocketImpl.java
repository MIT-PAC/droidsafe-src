package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.IoBridge;

public abstract class DatagramSocketImpl implements SocketOptions {
    protected FileDescriptor fd;
    protected int localPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.108 -0400", hash_original_method = "36741B3348F3C30E5BB773EA210AEA7B", hash_generated_method = "033B274A013D261BF92A9755BD4D87EB")
    @DSModeled(DSC.SAFE)
    public DatagramSocketImpl() {
        localPort = -1;
        // ---------- Original Method ----------
        //localPort = -1;
    }

    
    protected abstract void bind(int port, InetAddress addr) throws SocketException;

    
    protected abstract void close();

    
    protected abstract void create() throws SocketException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.110 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "3E4245F8027A4753C557689466D73220")
    @DSModeled(DSC.SAFE)
    protected FileDescriptor getFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.112 -0400", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "052A47240C080F2ADE6E17D1DC5D4E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InetAddress getLocalAddress() {
        InetAddress var540A9FDEE04145BDE375376F63493F5B_10533617 = (IoBridge.getSocketLocalAddress(fd));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IoBridge.getSocketLocalAddress(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.114 -0400", hash_original_method = "85505F9FF32DDEB1685867EF44676F61", hash_generated_method = "C2A663936A885AE91042343E3350B38A")
    @DSModeled(DSC.SAFE)
    protected int getLocalPort() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.131 -0400", hash_original_method = "4B57C399BF813581E92D5F53070EA8D4", hash_generated_method = "00DB70298501FEB1EBD81EF027785A9E")
    @DSModeled(DSC.SAFE)
    protected void connect(InetAddress inetAddr, int port) throws SocketException {
        dsTaint.addTaint(inetAddr.dsTaint);
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:33:29.134 -0400", hash_original_method = "E948DE2D4A723F3312DB782756156847", hash_generated_method = "AD0C7646B903C45FBB64C362ED7E5150")
    @DSModeled(DSC.SAFE)
    protected void disconnect() {
        // ---------- Original Method ----------
    }

    
    protected abstract int peekData(DatagramPacket pack) throws IOException;

    
}


