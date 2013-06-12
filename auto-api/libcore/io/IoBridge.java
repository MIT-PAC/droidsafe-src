package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    public static final int JAVA_MCAST_JOIN_GROUP = 19;
    public static final int JAVA_MCAST_LEAVE_GROUP = 20;
    public static final int JAVA_IP_MULTICAST_TTL = 17;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "4BE9929C9EF4F07FA420F9178CCE2A9A", hash_generated_method = "D5DEE87211FE7185DCC43EAC1EB439B3")
    @DSModeled(DSC.SAFE)
    private IoBridge() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "F5E1297626E5726FCF09E7D108051912", hash_generated_method = "CBFFF7C88E0DC5BF7CA5574036065DFF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "4065E166A2EE8DF2180E214A3A00FE79", hash_generated_method = "D41A6EC82CD96C8058CCDB6206CD590F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "CFD2CAFE811694E54D31D080F34F41AF", hash_generated_method = "BEC0EF9AE8EAAF0EF1C0BAFF5A468958")
    public static boolean connect(FileDescriptor fd, InetAddress inetAddress, int port) throws SocketException {
        try {
            return IoBridge.connect(fd, inetAddress, port, 0);
        } catch (SocketTimeoutException ex) {
            throw new AssertionError(ex); 
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "FE64C515B6E8C2636E66195448D35A64", hash_generated_method = "3491DBDE0AE97F1906F75F93C3DEF091")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.467 -0400", hash_original_method = "D7BE365D78251E41BD99D05443E2B07E", hash_generated_method = "A7604654378E5114BD05A421CF2642C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "F8F4A8068EB086BE493EBCFD9E087B18", hash_generated_method = "18945ED2BF4D73CCE15F0ED9659D949A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "8FBEDC9FEAFA167FF6B1B5BC4C663DCF", hash_generated_method = "5838248003AE267AF5F0EA80EF246314")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "AB1F161A5DBE44D4F56A55EEECA1C0FE", hash_generated_method = "D20D0289AD97A4F4CA428AEEB81876EC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "74DA8B934B42DF1434422A79C632FDCA", hash_generated_method = "B62EE3B4242D7FAA79A003F0B21082F4")
    public static Object getSocketOption(FileDescriptor fd, int option) throws SocketException {
        try {
            return getSocketOptionErrno(fd, option);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "974AC57B647B0E19683F9AD29B934025", hash_generated_method = "FAE05403C44C64C06C6D956F00FDC790")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "B7A8C0409E1035F8EAF6BD618B4E651E", hash_generated_method = "015524567A417EF0175B246905795F4B")
    private static boolean booleanFromInt(int i) {
        return (i != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "364F2FBD8F3B46F38D29C27DFFD25B74", hash_generated_method = "2DE4623BBCBF4C0B24219C736E3A31D8")
    private static int booleanToInt(boolean b) {
        return b ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "D1D4E8DBA6D654F543011AA2E0693355", hash_generated_method = "E819F22DACDD5354471A4540582C3197")
    public static void setSocketOption(FileDescriptor fd, int option, Object value) throws SocketException {
        try {
            setSocketOptionErrno(fd, option, value);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "3019B6668B365ECF8A5509168D80A8D7", hash_generated_method = "0ADB4C779C77FF811A9938D57B861A48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "7DCDC5B075D765D7A58F6B283FA65BC0", hash_generated_method = "242B7AA3CF911B14D382C0B2BD6E134D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.468 -0400", hash_original_method = "48F4ACED9715A443A4F67526A289B023", hash_generated_method = "ECEB6B3C78B0A4B9EF95DCFB6B1D7BCA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "11CB195F3B96E0AC481420CD2EA50370", hash_generated_method = "F9701C25E71A197B713A220C3D33D83B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "84DABDA1F34253D93066BE07C9B186E6", hash_generated_method = "42FC2CE952C7C17B3BEDF0B7F3649432")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "E255F65F53E0BAB1C0BBB756BEB3B433", hash_generated_method = "4BB845D641E4FE065B812012172F527E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "2165269B00818F46FED78FE25D6C5FC5", hash_generated_method = "FE24DD1E0FA058994728286D065BC03E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "AFBD3A85749E86AD3EF48FC5D53DDD1F", hash_generated_method = "CC90FB83DC5DB415C0F089F925B663BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "EE4E0AF55AE0825B406855AC92D8BF63", hash_generated_method = "9420D8DAB64E52D2D9225D7568203A34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "871255B3F9D40210CAC4049FA8DF4788", hash_generated_method = "D55FC9DECF6127591DC3F65FAEDE437A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "AB9706571F1180FC3B99F722D1F9358A", hash_generated_method = "CB8AF36A3AFB4168861DF6C0CC9A6B19")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "BA69B6664814E592B6F888BA7B6D1FB8", hash_generated_method = "A79E489D76A4320B603E9A0F79C94A02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "BF91E659ADCCEA5E83B593E3412077DF", hash_generated_method = "ACE4CC37C7327B704B665A55B9FBFBDF")
    public static InetAddress getSocketLocalAddress(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getAddress();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.469 -0400", hash_original_method = "935731650AFF466956FA2EB59931508E", hash_generated_method = "AE1F49FB6A56778B936D57D0C7372D6F")
    public static int getSocketLocalPort(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getPort();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    
}


