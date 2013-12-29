package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.EINVAL;
import static libcore.io.OsConstants.O_ACCMODE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.SOL_SOCKET;
import static libcore.io.OsConstants.SO_LINGER;
import static libcore.io.OsConstants.S_ISSOCK;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

import dalvik.system.BlockGuard;
import dalvik.system.SocketTagger;




public class BlockGuardOs extends ForwardingOs {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.284 -0500", hash_original_method = "FD2393C99E08832136F507440F02147C", hash_generated_method = "1AB8A2AC20313109B0C2BB709BF2CB1D")
    private static boolean isLingerSocket(FileDescriptor fd) throws ErrnoException {
        StructLinger linger = Libcore.os.getsockoptLinger(fd, SOL_SOCKET, SO_LINGER);
        return linger.isOn() && linger.l_linger > 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.280 -0500", hash_original_method = "2D0FCA28E55AE009AE62E6973DC0875A", hash_generated_method = "3C9DDD2D3AAC7A12C9AF9AA33B63816F")
    public BlockGuardOs(Os os) {
        super(os);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.281 -0500", hash_original_method = "C76A4564374F8B1BE91B3642FF0C847C", hash_generated_method = "1C00AB71C54DFF9D9D155ACAF287C9A0")
    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        try {
            SocketTagger.get().tag(fd);
            return fd;
        } catch (SocketException e) {
            throw new ErrnoException("socket", EINVAL, e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.282 -0500", hash_original_method = "94528424D623701A416A9704EA17EE51", hash_generated_method = "447A2ACDEA191C5139194065E4053984")
    private void untagSocket(FileDescriptor fd) throws ErrnoException {
        try {
            SocketTagger.get().untag(fd);
        } catch (SocketException e) {
            throw new ErrnoException("socket", EINVAL, e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.282 -0500", hash_original_method = "635584284C97FD1E7DC4024F591AB4FA", hash_generated_method = "676C520967CA74B0F3F7558A63C9FE22")
    @Override
public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        return tagSocket(os.accept(fd, peerAddress));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.283 -0500", hash_original_method = "5D4ED9A04E2D732CC559EB48A60FC49B", hash_generated_method = "55EA3E8A49F6ECF9F1B87036B15BB468")
    @Override
public void close(FileDescriptor fd) throws ErrnoException {
        try {
            if (S_ISSOCK(Libcore.os.fstat(fd).st_mode)) {
                if (isLingerSocket(fd)) {
                    // If the fd is a socket with SO_LINGER set, we might block indefinitely.
                    // We allow non-linger sockets so that apps can close their network
                    // connections in methods like onDestroy which will run on the UI thread.
                    BlockGuard.getThreadPolicy().onNetwork();
                }
                untagSocket(fd);
            }
        } catch (ErrnoException ignored) {
            // We're called via Socket.close (which doesn't ask for us to be called), so we
            // must not throw here, because Socket.close must not throw if asked to close an
            // already-closed socket. Also, the passed-in FileDescriptor isn't necessarily
            // a socket at all.
        }
        os.close(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.286 -0500", hash_original_method = "524D1337E9F0426B22674071C6D0693B", hash_generated_method = "7C987822AF28A157E6661C1553C0FD2C")
    @Override
public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        os.connect(fd, address, port);
    }

    // TODO: Untag newFd when needed for dup2(FileDescriptor oldFd, int newFd)

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.287 -0500", hash_original_method = "651C9D4A8AD9CD60F42C588D20417ED0", hash_generated_method = "E185498FC06724DA273028A54FB5266C")
    @Override
public void fdatasync(FileDescriptor fd) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fdatasync(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.287 -0500", hash_original_method = "E0F4576754752430F3173F2FFDEB5F93", hash_generated_method = "B865F9E5C9D65416C939A56BF71DDAA9")
    @Override
public void fsync(FileDescriptor fd) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fsync(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.288 -0500", hash_original_method = "D97DA02F2520733C349FC66FF2A146AF", hash_generated_method = "060432411DAD8D6D95DC1D88BF614760")
    @Override
public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.ftruncate(fd, length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.289 -0500", hash_original_method = "60BB804A04FED2996BE622E8EB3C8C72", hash_generated_method = "F446F92771498FCF38175E929E12FE3A")
    @Override
public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        if ((mode & O_ACCMODE) != O_RDONLY) {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        }
        return os.open(path, flags, mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.290 -0500", hash_original_method = "F416944E2BAC8A3A477E3A9DF95661DC", hash_generated_method = "45F20C6B8F3A629ADCA111290D0716A6")
    @Override
public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        // Greater than 0 is a timeout in milliseconds and -1 means "block forever",
        // but 0 means "poll and return immediately", which shouldn't be subject to BlockGuard.
        if (timeoutMs != 0) {
            BlockGuard.getThreadPolicy().onNetwork();
        }
        return os.poll(fds, timeoutMs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.291 -0500", hash_original_method = "B4077B073E0F60ADBED6DEE6A699AD14", hash_generated_method = "F576813CC82EEF3036B79C7EF7047350")
    @Override
public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return os.pread(fd, buffer, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.292 -0500", hash_original_method = "51D119A1C60E3F0FF85DFC4F5BCBEBDF", hash_generated_method = "C9142093C6208212ED735257D5F2C6A8")
    @Override
public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.293 -0500", hash_original_method = "0F2134A6426D9EB8374019A9EA67DB6B", hash_generated_method = "D2957F59CC3C136E7952A05DF1285401")
    @Override
public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return os.pwrite(fd, buffer, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.294 -0500", hash_original_method = "A4033B69E198E86AF41C6F2BD93A7F05", hash_generated_method = "CBD5428DCA16267DA508241B0A51777B")
    @Override
public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.294 -0500", hash_original_method = "ED8C50F685094B5680C00B42F9F5F045", hash_generated_method = "927518DCCA32240F31B1BF6C80A42D37")
    @Override
public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return os.read(fd, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.295 -0500", hash_original_method = "2387C0D98FE16C1C4919C1D4A5A4F85D", hash_generated_method = "9B7C0F93A57C641CB2241D6EE2D1BA28")
    @Override
public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return os.read(fd, bytes, byteOffset, byteCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.296 -0500", hash_original_method = "418568873B9A73D38D7FF96ACC4F4219", hash_generated_method = "3E48B201BC21B864201BAAB2827246C4")
    @Override
public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return os.readv(fd, buffers, offsets, byteCounts);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.297 -0500", hash_original_method = "E5449C41BDDE69AE1805A14CD8C0DB04", hash_generated_method = "8BF9D4ADBE0CBE7A4F96BCEA870D07CB")
    @Override
public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.298 -0500", hash_original_method = "F697E31CA82538D4CA19A49211FAEDE8", hash_generated_method = "A75DAE4EB0DACACCC600F176B51C0DD5")
    @Override
public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.299 -0500", hash_original_method = "712364CE21E2D97A52399AF047375669", hash_generated_method = "4DA969E3E5A443B776A9E7AB46CEB6A3")
    @Override
public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.300 -0500", hash_original_method = "55701E5A28F22D42DFE5E9BDB107BB3B", hash_generated_method = "9480915A84663E6433B2E655B1945871")
    @Override
public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        // We permit datagrams without hostname lookups.
        if (inetAddress != null) {
            BlockGuard.getThreadPolicy().onNetwork();
        }
        return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.301 -0500", hash_original_method = "3EA6FC55F29379EA1669AB58FC394717", hash_generated_method = "8ED959D7D4C6CF5A442B91321AAC0A01")
    @Override
public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        return tagSocket(os.socket(domain, type, protocol));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.301 -0500", hash_original_method = "5EE10271D9A1F133950EEC82FBA5FE84", hash_generated_method = "A922184F30CA8EF7B62403EDC1532BE2")
    @Override
public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return os.write(fd, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.302 -0500", hash_original_method = "45958860FE67213CB5E2A0FF79C39AE3", hash_generated_method = "6FCD5F9B8387FC975BAFCD03CD8F1A87")
    @Override
public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return os.write(fd, bytes, byteOffset, byteCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.303 -0500", hash_original_method = "5DBA61950559A586673FCC47110213A7", hash_generated_method = "0766A999D4E29DB4A88DDC2CD139381A")
    @Override
public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

