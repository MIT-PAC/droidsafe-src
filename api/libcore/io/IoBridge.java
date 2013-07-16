package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOptions;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import static libcore.io.OsConstants.*;
import libcore.util.MutableInt;

public final class IoBridge {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.676 -0400", hash_original_method = "4BE9929C9EF4F07FA420F9178CCE2A9A", hash_generated_method = "1249D99A029C3582A74310C04E7ECC4A")
    private  IoBridge() {
        // ---------- Original Method ----------
    }

    
        public static int available(FileDescriptor fd) throws IOException {
        try {
            MutableInt available = new MutableInt(0);
            Libcore.os.ioctlInt(fd, FIONREAD, available);
            if (available.value < 0) {
                available.value = 0;
            }
            return available.value;
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == ENOTTY) {
                return 0;
            }
            throw errnoException.rethrowAsIOException();
        }
    }

    
        public static void bind(FileDescriptor fd, InetAddress address, int port) throws SocketException {
        if (address instanceof Inet6Address && ((Inet6Address) address).getScopeId() == 0) {
            NetworkInterface nif = NetworkInterface.getByInetAddress(address);
            if (nif == null) {
                throw new SocketException("Can't bind to a link-local address without a scope id: " + address);
            }
            try {
                address = Inet6Address.getByAddress(address.getHostName(), address.getAddress(), nif.getIndex());
            } catch (UnknownHostException ex) {
                throw new AssertionError(ex); 
            }
        }
        try {
            Libcore.os.bind(fd, address, port);
        } catch (ErrnoException errnoException) {
            throw new BindException(errnoException.getMessage(), errnoException);
        }
    }

    
        public static boolean connect(FileDescriptor fd, InetAddress inetAddress, int port) throws SocketException {
        try {
            return IoBridge.connect(fd, inetAddress, port, 0);
        } catch (SocketTimeoutException ex) {
            throw new AssertionError(ex); 
        }
    }

    
        public static boolean connect(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs) throws SocketException, SocketTimeoutException {
        try {
            return connectErrno(fd, inetAddress, port, timeoutMs);
        } catch (ErrnoException errnoException) {
            throw new ConnectException(connectDetail(inetAddress, port, timeoutMs, errnoException), errnoException);
        } catch (SocketException ex) {
            throw ex; 
        } catch (SocketTimeoutException ex) {
            throw ex; 
        } catch (IOException ex) {
            throw new SocketException(ex);
        }
    }

    
        private static boolean connectErrno(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs) throws ErrnoException, IOException {
        if (timeoutMs == 0) {
            Libcore.os.connect(fd, inetAddress, port);
            return true;
        }
        long finishTimeMs = System.currentTimeMillis() + timeoutMs;
        IoUtils.setBlocking(fd, false);
        try {
            try {
                Libcore.os.connect(fd, inetAddress, port);
                return true; 
            } catch (ErrnoException errnoException) {
                if (errnoException.errno != EINPROGRESS) {
                    throw errnoException;
                }
            }
            int remainingTimeoutMs;
            do {
                remainingTimeoutMs = (int) (finishTimeMs - System.currentTimeMillis());
                if (remainingTimeoutMs <= 0) {
                    throw new SocketTimeoutException(connectDetail(inetAddress, port, timeoutMs, null));
                }
            } while (!IoBridge.isConnected(fd, inetAddress, port, timeoutMs, remainingTimeoutMs));
            return true; 
        } finally {
            IoUtils.setBlocking(fd, true);
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static String connectDetail(InetAddress inetAddress, int port, int timeoutMs, ErrnoException cause) {
        String detail = "failed to connect to " + inetAddress + " (port " + port + ")";
        if (timeoutMs > 0) {
            detail += " after " + timeoutMs + "ms";
        }
        if (cause != null) {
            detail += ": " + cause.getMessage();
        }
        return detail;
    }

    
        public static void closeSocket(FileDescriptor fd) throws IOException {
        if (!fd.valid()) {
            return;
        }
        int intFd = fd.getInt$();
        fd.setInt$(-1);
        FileDescriptor oldFd = new FileDescriptor();
        oldFd.setInt$(intFd);
        AsynchronousCloseMonitor.signalBlockedThreads(oldFd);
        try {
            Libcore.os.close(oldFd);
        } catch (ErrnoException errnoException) {
        }
    }

    
        public static boolean isConnected(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs, int remainingTimeoutMs) throws IOException {
        ErrnoException cause;
        try {
            StructPollfd[] pollFds = new StructPollfd[] { new StructPollfd() };
            pollFds[0].fd = fd;
            pollFds[0].events = (short) POLLOUT;
            int rc = Libcore.os.poll(pollFds, remainingTimeoutMs);
            if (rc == 0) {
                return false; 
            }
            int connectError = Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_ERROR);
            if (connectError == 0) {
                return true; 
            }
            throw new ErrnoException("isConnected", connectError); 
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == EINTR) {
                return false; 
            } else {
                cause = errnoException;
            }
        }
        String detail = connectDetail(inetAddress, port, timeoutMs, cause);
        if (cause.errno == ECONNRESET || cause.errno == ECONNREFUSED ||
        cause.errno == EADDRNOTAVAIL || cause.errno == EADDRINUSE ||
        cause.errno == ENETUNREACH) {
            throw new ConnectException(detail, cause);
        } else if (cause.errno == EACCES) {
            throw new SecurityException(detail, cause);
        } else if (cause.errno == ETIMEDOUT) {
            throw new SocketTimeoutException(detail, cause);
        }
        throw new SocketException(detail, cause);
    }

    
        public static Object getSocketOption(FileDescriptor fd, int option) throws SocketException {
        try {
            return getSocketOptionErrno(fd, option);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    
        @DSModeled(DSC.SPEC)
    private static Object getSocketOptionErrno(FileDescriptor fd, int option) throws ErrnoException, SocketException {
        switch (option) {
        case SocketOptions.IP_MULTICAST_IF:
            return Libcore.os.getsockoptInAddr(fd, IPPROTO_IP, IP_MULTICAST_IF);
        case SocketOptions.IP_MULTICAST_IF2:
            return Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_IF);
        case SocketOptions.IP_MULTICAST_LOOP:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_LOOP));
        case IoBridge.JAVA_IP_MULTICAST_TTL:
            return Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_HOPS);
        case SocketOptions.IP_TOS:
            return Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_TCLASS);
        case SocketOptions.SO_BROADCAST:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_BROADCAST));
        case SocketOptions.SO_KEEPALIVE:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_KEEPALIVE));
        case SocketOptions.SO_LINGER:
            StructLinger linger = Libcore.os.getsockoptLinger(fd, SOL_SOCKET, SO_LINGER);
            if (!linger.isOn()) {
                return false;
            }
            return linger.l_linger;
        case SocketOptions.SO_OOBINLINE:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_OOBINLINE));
        case SocketOptions.SO_RCVBUF:
            return Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_SNDBUF);
        case SocketOptions.SO_REUSEADDR:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_REUSEADDR));
        case SocketOptions.SO_SNDBUF:
            return Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_SNDBUF);
        case SocketOptions.SO_TIMEOUT:
            return (int) Libcore.os.getsockoptTimeval(fd, SOL_SOCKET, SO_RCVTIMEO).toMillis();
        case SocketOptions.TCP_NODELAY:
            return booleanFromInt(Libcore.os.getsockoptInt(fd, IPPROTO_TCP, TCP_NODELAY));
        default:
            throw new SocketException("Unknown socket option: " + option);
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean booleanFromInt(int i) {
        return (i != 0);
    }

    
        @DSModeled(DSC.SAFE)
    private static int booleanToInt(boolean b) {
        return b ? 1 : 0;
    }

    
        public static void setSocketOption(FileDescriptor fd, int option, Object value) throws SocketException {
        try {
            setSocketOptionErrno(fd, option, value);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    
        private static void setSocketOptionErrno(FileDescriptor fd, int option, Object value) throws ErrnoException, SocketException {
        switch (option) {
        case SocketOptions.IP_MULTICAST_IF:
            throw new UnsupportedOperationException("Use IP_MULTICAST_IF2 on Android");
        case SocketOptions.IP_MULTICAST_IF2:
            Libcore.os.setsockoptIpMreqn(fd, IPPROTO_IP, IP_MULTICAST_IF, (Integer) value);
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_IF, (Integer) value);
            return;
        case SocketOptions.IP_MULTICAST_LOOP:
            Libcore.os.setsockoptByte(fd, IPPROTO_IP, IP_MULTICAST_LOOP, booleanToInt((Boolean) value));
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_LOOP, booleanToInt((Boolean) value));
            return;
        case IoBridge.JAVA_IP_MULTICAST_TTL:
            Libcore.os.setsockoptByte(fd, IPPROTO_IP, IP_MULTICAST_TTL, (Integer) value);
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_HOPS, (Integer) value);
            return;
        case SocketOptions.IP_TOS:
            Libcore.os.setsockoptInt(fd, IPPROTO_IP, IP_TOS, (Integer) value);
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_TCLASS, (Integer) value);
            return;
        case SocketOptions.SO_BROADCAST:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_BROADCAST, booleanToInt((Boolean) value));
            return;
        case SocketOptions.SO_KEEPALIVE:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_KEEPALIVE, booleanToInt((Boolean) value));
            return;
        case SocketOptions.SO_LINGER:
            boolean on = false;
            int seconds = 0;
            if (value instanceof Integer) {
                on = true;
                seconds = Math.min((Integer) value, 65535);
            }
            StructLinger linger = new StructLinger(booleanToInt(on), seconds);
            Libcore.os.setsockoptLinger(fd, SOL_SOCKET, SO_LINGER, linger);
            return;
        case SocketOptions.SO_OOBINLINE:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_OOBINLINE, booleanToInt((Boolean) value));
            return;
        case SocketOptions.SO_RCVBUF:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_RCVBUF, (Integer) value);
            return;
        case SocketOptions.SO_REUSEADDR:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_REUSEADDR, booleanToInt((Boolean) value));
            return;
        case SocketOptions.SO_SNDBUF:
            Libcore.os.setsockoptInt(fd, SOL_SOCKET, SO_SNDBUF, (Integer) value);
            return;
        case SocketOptions.SO_TIMEOUT:
            int millis = (Integer) value;
            StructTimeval tv = StructTimeval.fromMillis(millis);
            Libcore.os.setsockoptTimeval(fd, SOL_SOCKET, SO_RCVTIMEO, tv);
            return;
        case SocketOptions.TCP_NODELAY:
            Libcore.os.setsockoptInt(fd, IPPROTO_TCP, TCP_NODELAY, booleanToInt((Boolean) value));
            return;
        case IoBridge.JAVA_MCAST_JOIN_GROUP:
        case IoBridge.JAVA_MCAST_LEAVE_GROUP:
            StructGroupReq groupReq = (StructGroupReq) value;
            int level = (groupReq.gr_group instanceof Inet4Address) ? IPPROTO_IP : IPPROTO_IPV6;
            int op = (option == JAVA_MCAST_JOIN_GROUP) ? MCAST_JOIN_GROUP : MCAST_LEAVE_GROUP;
            Libcore.os.setsockoptGroupReq(fd, level, op, groupReq);
            return;
        default:
            throw new SocketException("Unknown socket option: " + option);
        }
    }

    
        public static FileDescriptor open(String path, int flags) throws FileNotFoundException {
        FileDescriptor fd = null;
        try {
            int mode = ((flags & O_ACCMODE) == O_RDONLY) ? 0 : 0600;
            fd = Libcore.os.open(path, flags, mode);
            if (fd.valid()) {
                if (S_ISDIR(Libcore.os.fstat(fd).st_mode)) {
                    throw new ErrnoException("open", EISDIR);
                }
            }
            return fd;
        } catch (ErrnoException errnoException) {
            try {
                if (fd != null) {
                    IoUtils.close(fd);
                }
            } catch (IOException ignored) {
            }
            FileNotFoundException ex = new FileNotFoundException(path + ": " + errnoException.getMessage());
            ex.initCause(errnoException);
            throw ex;
        }
    }

    
        public static int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(bytes.length, byteOffset, byteCount);
        if (byteCount == 0) {
            return 0;
        }
        try {
            int readCount = Libcore.os.read(fd, bytes, byteOffset, byteCount);
            if (readCount == 0) {
                return -1;
            }
            return readCount;
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == EAGAIN) {
                return 0;
            }
            throw errnoException.rethrowAsIOException();
        }
    }

    
        public static void write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(bytes.length, byteOffset, byteCount);
        if (byteCount == 0) {
            return;
        }
        try {
            while (byteCount > 0) {
                int bytesWritten = Libcore.os.write(fd, bytes, byteOffset, byteCount);
                byteCount -= bytesWritten;
                byteOffset += bytesWritten;
            }
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    
        @DSModeled(DSC.SAFE)
    public static int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws IOException {
        boolean isDatagram = (inetAddress != null);
        if (!isDatagram && byteCount <= 0) {
            return 0;
        }
        int result;
        try {
            result = Libcore.os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
        } catch (ErrnoException errnoException) {
            result = maybeThrowAfterSendto(isDatagram, errnoException);
        }
        return result;
    }

    
        @DSModeled(DSC.SAFE)
    public static int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws IOException {
        boolean isDatagram = (inetAddress != null);
        if (!isDatagram && buffer.remaining() == 0) {
            return 0;
        }
        int result;
        try {
            result = Libcore.os.sendto(fd, buffer, flags, inetAddress, port);
        } catch (ErrnoException errnoException) {
            result = maybeThrowAfterSendto(isDatagram, errnoException);
        }
        return result;
    }

    
        private static int maybeThrowAfterSendto(boolean isDatagram, ErrnoException errnoException) throws SocketException {
        if (isDatagram) {
            if (errnoException.errno == ECONNRESET || errnoException.errno == ECONNREFUSED) {
                return 0;
            }
        } else {
            if (errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK) {
                return 0;
            }
        }
        throw errnoException.rethrowAsSocketException();
    }

    
        @DSModeled(DSC.SAFE)
    public static int recvfrom(boolean isRead, FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, DatagramPacket packet, boolean isConnected) throws IOException {
        int result;
        try {
            InetSocketAddress srcAddress = (packet != null && !isConnected) ? new InetSocketAddress() : null;
            result = Libcore.os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
            result = postRecvfrom(isRead, packet, isConnected, srcAddress, result);
        } catch (ErrnoException errnoException) {
            result = maybeThrowAfterRecvfrom(isRead, isConnected, errnoException);
        }
        return result;
    }

    
        @DSModeled(DSC.SAFE)
    public static int recvfrom(boolean isRead, FileDescriptor fd, ByteBuffer buffer, int flags, DatagramPacket packet, boolean isConnected) throws IOException {
        int result;
        try {
            InetSocketAddress srcAddress = (packet != null && !isConnected) ? new InetSocketAddress() : null;
            result = Libcore.os.recvfrom(fd, buffer, flags, srcAddress);
            result = postRecvfrom(isRead, packet, isConnected, srcAddress, result);
        } catch (ErrnoException errnoException) {
            result = maybeThrowAfterRecvfrom(isRead, isConnected, errnoException);
        }
        return result;
    }

    
        @DSModeled(DSC.SAFE)
    private static int postRecvfrom(boolean isRead, DatagramPacket packet, boolean isConnected, InetSocketAddress srcAddress, int byteCount) {
        if (isRead && byteCount == 0) {
            return -1;
        }
        if (packet != null) {
            packet.setLength(byteCount);
            if (!isConnected) {
                packet.setAddress(srcAddress.getAddress());
                packet.setPort(srcAddress.getPort());
            }
        }
        return byteCount;
    }

    
        @DSModeled(DSC.SAFE)
    private static int maybeThrowAfterRecvfrom(boolean isRead, boolean isConnected, ErrnoException errnoException) throws SocketException, SocketTimeoutException {
        if (isRead) {
            if (errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK) {
                return 0;
            } else {
                throw errnoException.rethrowAsSocketException();
            }
        } else {
            if (isConnected && errnoException.errno == ECONNREFUSED) {
                throw new PortUnreachableException("", errnoException);
            } else if (errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK) {
                throw new SocketTimeoutException(errnoException);
            } else {
                throw errnoException.rethrowAsSocketException();
            }
        }
    }

    
        public static FileDescriptor socket(boolean stream) throws SocketException {
        FileDescriptor fd;
        try {
            fd = Libcore.os.socket(AF_INET6, stream ? SOCK_STREAM : SOCK_DGRAM, 0);
            if (!stream) {
                Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_HOPS, 1);
            }
            return fd;
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    
        @DSModeled(DSC.SAFE)
    public static InetAddress getSocketLocalAddress(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getAddress();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    
        @DSModeled(DSC.SAFE)
    public static int getSocketLocalPort(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getPort();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.681 -0400", hash_original_field = "366042E0CF4CF60FDE4D7EBA72AC2D58", hash_generated_field = "D17A14E38001E033C6CF0435284406CD")

    public static final int JAVA_MCAST_JOIN_GROUP = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.681 -0400", hash_original_field = "A6CBD5844730FBD3CC4AD03361347ED8", hash_generated_field = "9C4097429B3752CDC227A02807A933CC")

    public static final int JAVA_MCAST_LEAVE_GROUP = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.681 -0400", hash_original_field = "E2A59D8A2E2DEA56CCD7C43BA250E8F1", hash_generated_field = "0B9C57C378DB16A9B350E5C837748819")

    public static final int JAVA_IP_MULTICAST_TTL = 17;
}

