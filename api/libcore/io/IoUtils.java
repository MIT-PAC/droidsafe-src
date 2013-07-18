package libcore.io;

// Droidsafe Imports
import static libcore.io.OsConstants.F_GETFL;
import static libcore.io.OsConstants.F_SETFL;
import static libcore.io.OsConstants.O_NONBLOCK;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.charset.Charsets;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class IoUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.575 -0400", hash_original_method = "79E9471925B005378EBE1BC903B5DD58", hash_generated_method = "23C96EFBE22D08DF5FBBE8620DF9E369")
    private  IoUtils() {
        // ---------- Original Method ----------
    }

    
    public static void close(FileDescriptor fd) throws IOException {
        try {
            if (fd != null && fd.valid()) {
                Libcore.os.close(fd);
            }
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    
    public static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception ignored) {
            }
        }
    }

    
    public static void closeQuietly(FileDescriptor fd) {
        try {
            IoUtils.close(fd);
        } catch (IOException ignored) {
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception ignored) {
            }
        }
    }

    
    public static void setBlocking(FileDescriptor fd, boolean blocking) throws IOException {
        try {
            int flags = Libcore.os.fcntlVoid(fd, F_GETFL);
            if (!blocking) {
                flags |= O_NONBLOCK;
            } else {
                flags &= ~O_NONBLOCK;
            }
            Libcore.os.fcntlLong(fd, F_SETFL, flags);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    
    public static byte[] readFileAsByteArray(String path) throws IOException {
        return readFileAsBytes(path).toByteArray();
    }

    
    @DSModeled(DSC.SPEC)
    public static String readFileAsString(String path) throws IOException {
        return readFileAsBytes(path).toString(Charsets.UTF_8);
    }

    
    private static UnsafeByteSequence readFileAsBytes(String path) throws IOException {
        RandomAccessFile f = null;
        try {
            f = new RandomAccessFile(path, "r");
            UnsafeByteSequence bytes = new UnsafeByteSequence((int) f.length());
            byte[] buffer = new byte[8192];
            while (true) {
                int byteCount = f.read(buffer);
                if (byteCount == -1) {
                    return bytes;
                }
                bytes.write(buffer, 0, byteCount);
            }
        } finally {
            IoUtils.closeQuietly(f);
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static void deleteContents(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("not a directory: " + dir);
        }
        for (File file : files) {
            if (file.isDirectory()) {
                deleteContents(file);
            }
            if (!file.delete()) {
                throw new IOException("failed to delete file: " + file);
            }
        }
    }

    
}

