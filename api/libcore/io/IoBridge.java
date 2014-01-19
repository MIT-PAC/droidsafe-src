package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET6;
import static libcore.io.OsConstants.EACCES;
import static libcore.io.OsConstants.EADDRINUSE;
import static libcore.io.OsConstants.EADDRNOTAVAIL;
import static libcore.io.OsConstants.EAGAIN;
import static libcore.io.OsConstants.ECONNREFUSED;
import static libcore.io.OsConstants.ECONNRESET;
import static libcore.io.OsConstants.EINPROGRESS;
import static libcore.io.OsConstants.EINTR;
import static libcore.io.OsConstants.EISDIR;
import static libcore.io.OsConstants.ENETUNREACH;
import static libcore.io.OsConstants.ENOTTY;
import static libcore.io.OsConstants.ETIMEDOUT;
import static libcore.io.OsConstants.EWOULDBLOCK;
import static libcore.io.OsConstants.FIONREAD;
import static libcore.io.OsConstants.IPPROTO_IP;
import static libcore.io.OsConstants.IPPROTO_IPV6;
import static libcore.io.OsConstants.IPPROTO_TCP;
import static libcore.io.OsConstants.IPV6_MULTICAST_HOPS;
import static libcore.io.OsConstants.IPV6_MULTICAST_IF;
import static libcore.io.OsConstants.IPV6_MULTICAST_LOOP;
import static libcore.io.OsConstants.IPV6_TCLASS;
import static libcore.io.OsConstants.IP_MULTICAST_IF;
import static libcore.io.OsConstants.IP_MULTICAST_LOOP;
import static libcore.io.OsConstants.IP_MULTICAST_TTL;
import static libcore.io.OsConstants.IP_TOS;
import static libcore.io.OsConstants.MCAST_JOIN_GROUP;
import static libcore.io.OsConstants.MCAST_LEAVE_GROUP;
import static libcore.io.OsConstants.O_ACCMODE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.POLLOUT;
import static libcore.io.OsConstants.SOCK_DGRAM;
import static libcore.io.OsConstants.SOCK_STREAM;
import static libcore.io.OsConstants.SOL_SOCKET;
import static libcore.io.OsConstants.SO_BROADCAST;
import static libcore.io.OsConstants.SO_ERROR;
import static libcore.io.OsConstants.SO_KEEPALIVE;
import static libcore.io.OsConstants.SO_LINGER;
import static libcore.io.OsConstants.SO_OOBINLINE;
import static libcore.io.OsConstants.SO_RCVBUF;
import static libcore.io.OsConstants.SO_RCVTIMEO;
import static libcore.io.OsConstants.SO_REUSEADDR;
import static libcore.io.OsConstants.SO_SNDBUF;
import static libcore.io.OsConstants.S_ISDIR;
import static libcore.io.OsConstants.TCP_NODELAY;

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

import libcore.util.MutableInt;

public final class IoBridge {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.717 -0500", hash_original_method = "F5E1297626E5726FCF09E7D108051912", hash_generated_method = "5752EC3E1B8F0583083618205851C532")
    
public static int available(FileDescriptor fd) throws IOException {
        try {
            MutableInt available = new MutableInt(0);
            Libcore.os.ioctlInt(fd, FIONREAD, available);
            if (available.value < 0) {
                // If the fd refers to a regular file, the result is the difference between
                // the file size and the file position. This may be negative if the position
                // is past the end of the file. If the fd refers to a special file masquerading
                // as a regular file, the result may be negative because the special file
                // may appear to have zero size and yet a previous read call may have
                // read some amount of data and caused the file position to be advanced.
                available.value = 0;
            }
            return available.value;
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == ENOTTY) {
                // The fd is unwilling to opine about its read buffer.
                return 0;
            }
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.720 -0500", hash_original_method = "4065E166A2EE8DF2180E214A3A00FE79", hash_generated_method = "A1E16A208351B7B64AD7AAC2BAD3A0AE")
    
public static void bind(FileDescriptor fd, InetAddress address, int port) throws SocketException {
        if (address instanceof Inet6Address && ((Inet6Address) address).getScopeId() == 0) {
            // Linux won't let you bind a link-local address without a scope id. Find one.
            NetworkInterface nif = NetworkInterface.getByInetAddress(address);
            if (nif == null) {
                throw new SocketException("Can't bind to a link-local address without a scope id: " + address);
            }
            try {
                address = Inet6Address.getByAddress(address.getHostName(), address.getAddress(), nif.getIndex());
            } catch (UnknownHostException ex) {
                throw new AssertionError(ex); // Can't happen.
            }
        }
        try {
            Libcore.os.bind(fd, address, port);
        } catch (ErrnoException errnoException) {
            throw new BindException(errnoException.getMessage(), errnoException);
        }
    }

    /**
     * Connects socket 'fd' to 'inetAddress' on 'port', with no timeout. The lack of a timeout
     * means this method won't throw SocketTimeoutException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.723 -0500", hash_original_method = "CFD2CAFE811694E54D31D080F34F41AF", hash_generated_method = "3BBF4E6B7528C23676F8E83FB2D106FC")
    
public static boolean connect(FileDescriptor fd, InetAddress inetAddress, int port) throws SocketException {
        try {
            return IoBridge.connect(fd, inetAddress, port, 0);
        } catch (SocketTimeoutException ex) {
            throw new AssertionError(ex); // Can't happen for a connect without a timeout.
        }
    }

    /**
     * Connects socket 'fd' to 'inetAddress' on 'port', with a the given 'timeoutMs'.
     * Use timeoutMs == 0 for a blocking connect with no timeout.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.726 -0500", hash_original_method = "FE64C515B6E8C2636E66195448D35A64", hash_generated_method = "DF1124E6ECD8BECEB7DCB4164CF0A34C")
    
public static boolean connect(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs) throws SocketException, SocketTimeoutException {
        try {
            return connectErrno(fd, inetAddress, port, timeoutMs);
        } catch (ErrnoException errnoException) {
            throw new ConnectException(connectDetail(inetAddress, port, timeoutMs, errnoException), errnoException);
        } catch (SocketException ex) {
            throw ex; // We don't want to doubly wrap these.
        } catch (SocketTimeoutException ex) {
            throw ex; // We don't want to doubly wrap these.
        } catch (IOException ex) {
            throw new SocketException(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.729 -0500", hash_original_method = "D7BE365D78251E41BD99D05443E2B07E", hash_generated_method = "F38DEB8DDFFF37CFA95B96C84EB39457")
    
private static boolean connectErrno(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs) throws ErrnoException, IOException {
        // With no timeout, just call connect(2) directly.
        if (timeoutMs == 0) {
            Libcore.os.connect(fd, inetAddress, port);
            return true;
        }

        // With a timeout, we set the socket to non-blocking, connect(2), and then loop
        // using poll(2) to decide whether we're connected, whether we should keep waiting,
        // or whether we've seen a permanent failure and should give up.
        long finishTimeMs = System.currentTimeMillis() + timeoutMs;
        IoUtils.setBlocking(fd, false);
        try {
            try {
                Libcore.os.connect(fd, inetAddress, port);
                return true; // We connected immediately.
            } catch (ErrnoException errnoException) {
                if (errnoException.errno != EINPROGRESS) {
                    throw errnoException;
                }
                // EINPROGRESS means we should keep trying...
            }
            int remainingTimeoutMs;
            do {
                remainingTimeoutMs = (int) (finishTimeMs - System.currentTimeMillis());
                if (remainingTimeoutMs <= 0) {
                    throw new SocketTimeoutException(connectDetail(inetAddress, port, timeoutMs, null));
                }
            } while (!IoBridge.isConnected(fd, inetAddress, port, timeoutMs, remainingTimeoutMs));
            return true; // Or we'd have thrown.
        } finally {
            IoUtils.setBlocking(fd, true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.731 -0500", hash_original_method = "F8F4A8068EB086BE493EBCFD9E087B18", hash_generated_method = "18945ED2BF4D73CCE15F0ED9659D949A")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.734 -0500", hash_original_method = "8FBEDC9FEAFA167FF6B1B5BC4C663DCF", hash_generated_method = "373859AAA45D6C421C5ACC7035EAF466")
    
public static void closeSocket(FileDescriptor fd) throws IOException {
        if (!fd.valid()) {
            // Socket.close doesn't throw if you try to close an already-closed socket.
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
            // TODO: are there any cases in which we should throw?
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.737 -0500", hash_original_method = "AB1F161A5DBE44D4F56A55EEECA1C0FE", hash_generated_method = "099B1943543A7660D7ED4855766A6E00")
    
public static boolean isConnected(FileDescriptor fd, InetAddress inetAddress, int port, int timeoutMs, int remainingTimeoutMs) throws IOException {
        ErrnoException cause;
        try {
            StructPollfd[] pollFds = new StructPollfd[] { new StructPollfd() };
            pollFds[0].fd = fd;
            pollFds[0].events = (short) POLLOUT;
            int rc = Libcore.os.poll(pollFds, remainingTimeoutMs);
            if (rc == 0) {
                return false; // Timeout.
            }
            int connectError = Libcore.os.getsockoptInt(fd, SOL_SOCKET, SO_ERROR);
            if (connectError == 0) {
                return true; // Success!
            }
            throw new ErrnoException("isConnected", connectError); // The connect(2) failed.
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == EINTR) {
                return false; // Punt and ask the caller to try again.
            } else {
                cause = errnoException;
            }
        }
        // TODO: is it really helpful/necessary to throw so many different exceptions?
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

    /**
     * java.net has its own socket options similar to the underlying Unix ones. We paper over the
     * differences here.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.748 -0500", hash_original_method = "74DA8B934B42DF1434422A79C632FDCA", hash_generated_method = "B62EE3B4242D7FAA79A003F0B21082F4")
    
public static Object getSocketOption(FileDescriptor fd, int option) throws SocketException {
        try {
            return getSocketOptionErrno(fd, option);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.752 -0500", hash_original_method = "974AC57B647B0E19683F9AD29B934025", hash_generated_method = "A0A39A1D233B5968E89045F7EEE79078")
    
private static Object getSocketOptionErrno(FileDescriptor fd, int option) throws ErrnoException, SocketException {
        switch (option) {
        case SocketOptions.IP_MULTICAST_IF:
            // This is IPv4-only.
            return Libcore.os.getsockoptInAddr(fd, IPPROTO_IP, IP_MULTICAST_IF);
        case SocketOptions.IP_MULTICAST_IF2:
            // This is IPv6-only.
            return Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_IF);
        case SocketOptions.IP_MULTICAST_LOOP:
            // Since setting this from java.net always sets IPv4 and IPv6 to the same value,
            // it doesn't matter which we return.
            return booleanFromInt(Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_LOOP));
        case IoBridge.JAVA_IP_MULTICAST_TTL:
            // Since setting this from java.net always sets IPv4 and IPv6 to the same value,
            // it doesn't matter which we return.
            return Libcore.os.getsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_HOPS);
        case SocketOptions.IP_TOS:
            // Since setting this from java.net always sets IPv4 and IPv6 to the same value,
            // it doesn't matter which we return.
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.754 -0500", hash_original_method = "B7A8C0409E1035F8EAF6BD618B4E651E", hash_generated_method = "015524567A417EF0175B246905795F4B")
    
private static boolean booleanFromInt(int i) {
        return (i != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.757 -0500", hash_original_method = "364F2FBD8F3B46F38D29C27DFFD25B74", hash_generated_method = "2DE4623BBCBF4C0B24219C736E3A31D8")
    
private static int booleanToInt(boolean b) {
        return b ? 1 : 0;
    }

    /**
     * java.net has its own socket options similar to the underlying Unix ones. We paper over the
     * differences here.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.759 -0500", hash_original_method = "D1D4E8DBA6D654F543011AA2E0693355", hash_generated_method = "E819F22DACDD5354471A4540582C3197")
    
public static void setSocketOption(FileDescriptor fd, int option, Object value) throws SocketException {
        try {
            setSocketOptionErrno(fd, option, value);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.763 -0500", hash_original_method = "3019B6668B365ECF8A5509168D80A8D7", hash_generated_method = "EBCEE6D43E56F95799483902CD7FC603")
    
private static void setSocketOptionErrno(FileDescriptor fd, int option, Object value) throws ErrnoException, SocketException {
        switch (option) {
        case SocketOptions.IP_MULTICAST_IF:
            throw new UnsupportedOperationException("Use IP_MULTICAST_IF2 on Android");
        case SocketOptions.IP_MULTICAST_IF2:
            // Although IPv6 was cleaned up to use int, IPv4 uses an ip_mreqn containing an int.
            Libcore.os.setsockoptIpMreqn(fd, IPPROTO_IP, IP_MULTICAST_IF, (Integer) value);
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_IF, (Integer) value);
            return;
        case SocketOptions.IP_MULTICAST_LOOP:
            // Although IPv6 was cleaned up to use int, IPv4 multicast loopback uses a byte.
            Libcore.os.setsockoptByte(fd, IPPROTO_IP, IP_MULTICAST_LOOP, booleanToInt((Boolean) value));
            Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_LOOP, booleanToInt((Boolean) value));
            return;
        case IoBridge.JAVA_IP_MULTICAST_TTL:
            // Although IPv6 was cleaned up to use int, and IPv4 non-multicast TTL uses int,
            // IPv4 multicast TTL uses a byte.
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

    /**
     * java.io only throws FileNotFoundException when opening files, regardless of what actually
     * went wrong. Additionally, java.io is more restrictive than POSIX when it comes to opening
     * directories: POSIX says read-only is okay, but java.io doesn't even allow that. We also
     * have an Android-specific hack to alter the default permissions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.766 -0500", hash_original_method = "7DCDC5B075D765D7A58F6B283FA65BC0", hash_generated_method = "062FA83EFBFB4204B55A8B00490D8079")
    
public static FileDescriptor open(String path, int flags) throws FileNotFoundException {
        FileDescriptor fd = null;
        try {
            // On Android, we don't want default permissions to allow global access.
            int mode = ((flags & O_ACCMODE) == O_RDONLY) ? 0 : 0600;
            fd = Libcore.os.open(path, flags, mode);
            if (fd.valid()) {
                // Posix open(2) fails with EISDIR only if you ask for write permission.
                // Java disallows reading directories too.
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

    /**
     * java.io thinks that a read at EOF is an error and should return -1, contrary to traditional
     * Unix practice where you'd read until you got 0 bytes (and any future read would return -1).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.769 -0500", hash_original_method = "48F4ACED9715A443A4F67526A289B023", hash_generated_method = "9204FD780FAA06D7A6E45B04FF62978B")
    
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
                // We return 0 rather than throw if we try to read from an empty non-blocking pipe.
                return 0;
            }
            throw errnoException.rethrowAsIOException();
        }
    }

    /**
     * java.io always writes every byte it's asked to, or fails with an error. (That is, unlike
     * Unix it never just writes as many bytes as happens to be convenient.)
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.773 -0500", hash_original_method = "11CB195F3B96E0AC481420CD2EA50370", hash_generated_method = "F9701C25E71A197B713A220C3D33D83B")
    
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

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.775 -0500", hash_original_method = "84DABDA1F34253D93066BE07C9B186E6", hash_generated_method = "42FC2CE952C7C17B3BEDF0B7F3649432")
    
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

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.778 -0500", hash_original_method = "E255F65F53E0BAB1C0BBB756BEB3B433", hash_generated_method = "4BB845D641E4FE065B812012172F527E")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.780 -0500", hash_original_method = "2165269B00818F46FED78FE25D6C5FC5", hash_generated_method = "1AF24301DE48F3A9B717B1A856C0A8A4")
    
private static int maybeThrowAfterSendto(boolean isDatagram, ErrnoException errnoException) throws SocketException {
        if (isDatagram) {
            if (errnoException.errno == ECONNRESET || errnoException.errno == ECONNREFUSED) {
                return 0;
            }
        } else {
            if (errnoException.errno == EAGAIN || errnoException.errno == EWOULDBLOCK) {
                // We were asked to write to a non-blocking socket, but were told
                // it would block, so report "no bytes written".
                return 0;
            }
        }
        throw errnoException.rethrowAsSocketException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.783 -0500", hash_original_method = "AFBD3A85749E86AD3EF48FC5D53DDD1F", hash_generated_method = "CC90FB83DC5DB415C0F089F925B663BA")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.786 -0500", hash_original_method = "EE4E0AF55AE0825B406855AC92D8BF63", hash_generated_method = "9420D8DAB64E52D2D9225D7568203A34")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.789 -0500", hash_original_method = "871255B3F9D40210CAC4049FA8DF4788", hash_generated_method = "D55FC9DECF6127591DC3F65FAEDE437A")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.791 -0500", hash_original_method = "AB9706571F1180FC3B99F722D1F9358A", hash_generated_method = "CB8AF36A3AFB4168861DF6C0CC9A6B19")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.795 -0500", hash_original_method = "BA69B6664814E592B6F888BA7B6D1FB8", hash_generated_method = "C38E5D8C84E55FE5BB447C08A49F0534")
    
public static FileDescriptor socket(boolean stream) throws SocketException {
        FileDescriptor fd;
        try {
            fd = Libcore.os.socket(AF_INET6, stream ? SOCK_STREAM : SOCK_DGRAM, 0);

            // The RFC (http://www.ietf.org/rfc/rfc3493.txt) says that IPV6_MULTICAST_HOPS defaults
            // to 1. The Linux kernel (at least up to 2.6.38) accidentally defaults to 64 (which
            // would be correct for the *unicast* hop limit).
            // See http://www.spinics.net/lists/netdev/msg129022.html, though no patch appears to
            // have been applied as a result of that discussion. If that bug is ever fixed, we can
            // remove this code. Until then, we manually set the hop limit on IPv6 datagram sockets.
            // (IPv4 is already correct.)
            if (!stream) {
                Libcore.os.setsockoptInt(fd, IPPROTO_IPV6, IPV6_MULTICAST_HOPS, 1);
            }

            return fd;
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.797 -0500", hash_original_method = "BF91E659ADCCEA5E83B593E3412077DF", hash_generated_method = "ACE4CC37C7327B704B665A55B9FBFBDF")
    
public static InetAddress getSocketLocalAddress(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getAddress();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.800 -0500", hash_original_method = "935731650AFF466956FA2EB59931508E", hash_generated_method = "AE1F49FB6A56778B936D57D0C7372D6F")
    
public static int getSocketLocalPort(FileDescriptor fd) {
        try {
            SocketAddress sa = Libcore.os.getsockname(fd);
            InetSocketAddress isa = (InetSocketAddress) sa;
            return isa.getPort();
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.740 -0500", hash_original_field = "3875EFB4F02031E13030C41FE5F361FB", hash_generated_field = "D17A14E38001E033C6CF0435284406CD")

    public static final int JAVA_MCAST_JOIN_GROUP = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.743 -0500", hash_original_field = "92C96E6BC9AFF73FA7C627C743CFE46C", hash_generated_field = "9C4097429B3752CDC227A02807A933CC")

    public static final int JAVA_MCAST_LEAVE_GROUP = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.746 -0500", hash_original_field = "4A7EF7D027853A7D2D0F26817DCEBEF9", hash_generated_field = "0B9C57C378DB16A9B350E5C837748819")

    public static final int JAVA_IP_MULTICAST_TTL = 17;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:27.714 -0500", hash_original_method = "4BE9929C9EF4F07FA420F9178CCE2A9A", hash_generated_method = "A6F2BD253663EF887CBF40C0C63E065C")
    
private IoBridge() {
    }
}

