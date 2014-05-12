package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.O_APPEND;
import static libcore.io.OsConstants.O_CREAT;
import static libcore.io.OsConstants.O_TRUNC;
import static libcore.io.OsConstants.O_WRONLY;

import java.nio.NioUtils;
import java.nio.channels.FileChannel;

import libcore.io.IoBridge;
import libcore.io.IoUtils;
import dalvik.system.CloseGuard;

public class FileOutputStream extends OutputStream implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.237 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.240 -0500", hash_original_field = "58BD5E983B42D5DA1EAF3358ED6D6916", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private  boolean shouldClose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.242 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.245 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private  int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.247 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code file}. The file will be
     * truncated if it exists, and created if it doesn't exist.
     *
     * @throws FileNotFoundException if file cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.250 -0500", hash_original_method = "FCD724AE92A53995D4248A6FA35A6403", hash_generated_method = "5CA8ED8E9C177F71E64A9FC67130AD07")
    
public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
    }
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public FileOutputStream(DSOnlyType dsonly) {
        
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code file}.
     * If {@code append} is true and the file already exists, it will be appended to; otherwise
     * it will be truncated. The file will be created if it does not exist.
     *
     * @throws FileNotFoundException if the file cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.253 -0500", hash_original_method = "E1E823059D628A64A7C3F0D9FD132483", hash_generated_method = "E40C8D38C9C606422A657576F3C3F690")
    
public FileOutputStream(File file, boolean append) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        this.mode = O_WRONLY | O_CREAT | (append ? O_APPEND : O_TRUNC);
        this.fd = IoBridge.open(file.getAbsolutePath(), mode);
        this.shouldClose = true;
        this.guard.open("close");
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code fd}.
     *
     * @throws NullPointerException if {@code fd} is null.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.256 -0500", hash_original_method = "CA1AE4948CB074C25B5079F997384B75", hash_generated_method = "3ADA39C2CD37854FCB7C6FEEDDF8F6B3")
    
public FileOutputStream(FileDescriptor fd) {
        if (fd == null) {
            throw new NullPointerException("fd == null");
        }
        this.fd = fd;
        this.shouldClose = false;
        this.mode = O_WRONLY;
        this.channel = NioUtils.newFileChannel(this, fd, mode);
        // Note that we do not call guard.open here because the
        // FileDescriptor is not owned by the stream.
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code path}. The file will be
     * truncated if it exists, and created if it doesn't exist.
     *
     * @throws FileNotFoundException if file cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.259 -0500", hash_original_method = "ACD65E09F20B5B610F80054FC06EAD01", hash_generated_method = "06712B4764DEFF8D08AB3A20DDAF8BC3")
    
public FileOutputStream(String path) throws FileNotFoundException {
        this(path, false);
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code path}.
     * If {@code append} is true and the file already exists, it will be appended to; otherwise
     * it will be truncated. The file will be created if it does not exist.
     *
     * @throws FileNotFoundException if the file cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.263 -0500", hash_original_method = "2C15450100DC44A70908DD69335AD0CF", hash_generated_method = "6E4F3CA1AD99189EA98540B9544BCE06")
    
public FileOutputStream(String path, boolean append) throws FileNotFoundException {
        this(new File(path), append);
    }

    @DSComment("File Output Stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.265 -0500", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "0DF0B8874963515CB2F09EA5F083FA85")
    
@Override
    public void close() throws IOException {
        guard.close();
        synchronized (this) {
            if (channel != null) {
                channel.close();
            }
            if (shouldClose) {
                IoUtils.close(fd);
            } else {
                // An owned fd has been invalidated by IoUtils.close, but
                // we need to explicitly stop using an unowned fd (http://b/4361076).
                fd = new FileDescriptor();
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.268 -0500", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "D1DCB3056D2414B4C27AA873251B546E")
    
@Override protected void finalize() throws IOException {
        /*
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            close();
        } finally {
            try {
                super.finalize();
            } catch (Throwable t) {
                // for consistency with the RI, we must override Object.finalize() to
                // remove the 'throws Throwable' clause.
                throw new AssertionError(t);
            }
        }
        */
    }

    /**
     * Returns a write-only {@link FileChannel} that shares its position with
     * this stream.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.271 -0500", hash_original_method = "ED8CC62185555A958270FAF77C7A0E38", hash_generated_method = "9A812DB1A2B8287B9416C38AD1DB0488")
    
public FileChannel getChannel() {
        synchronized (this) {
            if (channel == null) {
                channel = NioUtils.newFileChannel(this, fd, mode);
            }
            return channel;
        }
    }

    /**
     * Returns the underlying file descriptor.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.273 -0500", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "BF99A80A25EF13693DBEFA2A53118A0A")
    
public final FileDescriptor getFD() throws IOException {
        return fd;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.276 -0500", hash_original_method = "F915AF116DBABF662C85674FE9C75DD1", hash_generated_method = "3276381B087865C1654194DB26559861")
    
@Override
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        IoBridge.write(fd, buffer, byteOffset, byteCount);
    }

    @DSComment("Activity on IO class")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.278 -0500", hash_original_method = "36E798E1E7EB95F42CDB9DAEDA0C8547", hash_generated_method = "B2300D19D772DA5EE64EF342E1F6E879")
    
@Override
    public void write(int oneByte) throws IOException {
        write(new byte[] { (byte) oneByte }, 0, 1);
    }
    
}

