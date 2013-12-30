package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.O_CREAT;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.O_RDWR;
import static libcore.io.OsConstants.O_SYNC;
import static libcore.io.OsConstants.SEEK_CUR;
import static libcore.io.OsConstants.SEEK_SET;

import java.nio.ByteOrder;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import java.nio.charset.ModifiedUtf8;
import java.util.Arrays;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.SizeOf;
import dalvik.system.CloseGuard;





public class RandomAccessFile implements DataInput, DataOutput, Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.168 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.171 -0500", hash_original_field = "920CF7C13BFADA1EF4D89DFD1D609670", hash_generated_field = "3B32EAA0CEEDC75E8106E9EDC5E4B7B8")


    private boolean syncMetadata = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.173 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "A73C1BBF84E836D55D5484C6C8858F5D")

    // initialized).
    private FileChannel channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.175 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")


    private int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.177 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")


    private final CloseGuard guard = CloseGuard.get();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.180 -0500", hash_original_field = "BB6EE13587F628B91D273A1D077E6D31", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")


    private final byte[] scratch = new byte[8];

    /**
     * Constructs a new {@code RandomAccessFile} based on {@code file} and opens
     * it according to the access string in {@code mode}.
     * <p><a id="accessmode"/>
     * {@code mode} may have one of following values:
     * <table border="0">
     * <tr>
     * <td>{@code "r"}</td>
     * <td>The file is opened in read-only mode. An {@code IOException} is
     * thrown if any of the {@code write} methods is called.</td>
     * </tr>
     * <tr>
     * <td>{@code "rw"}</td>
     * <td>The file is opened for reading and writing. If the file does not
     * exist, it will be created.</td>
     * </tr>
     * <tr>
     * <td>{@code "rws"}</td>
     * <td>The file is opened for reading and writing. Every change of the
     * file's content or metadata must be written synchronously to the target
     * device.</td>
     * </tr>
     * <tr>
     * <td>{@code "rwd"}</td>
     * <td>The file is opened for reading and writing. Every change of the
     * file's content must be written synchronously to the target device.</td>
     * </tr>
     * </table>
     *
     * @param file
     *            the file to open.
     * @param mode
     *            the file access <a href="#accessmode">mode</a>, either {@code
     *            "r"}, {@code "rw"}, {@code "rws"} or {@code "rwd"}.
     * @throws FileNotFoundException
     *             if the file cannot be opened or created according to {@code
     *             mode}.
     * @throws IllegalArgumentException
     *             if {@code mode} is not {@code "r"}, {@code "rw"}, {@code
     *             "rws"} or {@code "rwd"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.183 -0500", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "9CA1ACF5C8FE6BED9CE22A688A14F80F")
    
public RandomAccessFile(File file, String mode) throws FileNotFoundException {
        int flags;
        if (mode.equals("r")) {
            flags = O_RDONLY;
        } else if (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd")) {
            flags = O_RDWR | O_CREAT;
            if (mode.equals("rws")) {
                // Sync file and metadata with every write
                syncMetadata = true;
            } else if (mode.equals("rwd")) {
                // Sync file, but not necessarily metadata
                flags |= O_SYNC;
            }
        } else {
            throw new IllegalArgumentException("Invalid mode: " + mode);
        }
        this.mode = flags;
        this.fd = IoBridge.open(file.getAbsolutePath(), flags);

        // if we are in "rws" mode, attempt to sync file+metadata
        if (syncMetadata) {
            try {
                fd.sync();
            } catch (IOException e) {
                // Ignored
            }
        }
        guard.open("close");
    }

    /**
     * Constructs a new {@code RandomAccessFile} based on the file named {@code
     * fileName} and opens it according to the access string in {@code mode}.
     * The file path may be specified absolutely or relative to the system
     * property {@code "user.dir"}.
     *
     * @param fileName
     *            the name of the file to open.
     * @param mode
     *            the file access <a href="#accessmode">mode</a>, either {@code
     *            "r"}, {@code "rw"}, {@code "rws"} or {@code "rwd"}.
     * @throws FileNotFoundException
     *             if the file cannot be opened or created according to {@code
     *             mode}.
     * @throws IllegalArgumentException
     *             if {@code mode} is not {@code "r"}, {@code "rw"}, {@code
     *             "rws"} or {@code "rwd"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.186 -0500", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "EB168E11185786D18D391DC8D7754EFC")
    
public RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
    }

    /**
     * Closes this file.
     *
     * @throws IOException
     *             if an error occurs while closing this file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.188 -0500", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "0096CF7A8E8C11058C92174E45F5E004")
    
public void close() throws IOException {
        guard.close();
        synchronized (this) {
            if (channel != null && channel.isOpen()) {
                channel.close();
                channel = null;
            }
            IoUtils.close(fd);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.191 -0500", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "F0F8D8EC0C5D8FA9E7582C7E60A1D793")
    
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

    /**
     * Gets this file's {@link FileChannel} object.
     * <p>
     * The file channel's {@link FileChannel#position() position} is the same
     * as this file's file pointer offset (see {@link #getFilePointer()}). Any
     * changes made to this file's file pointer offset are also visible in the
     * file channel's position and vice versa.
     *
     * @return this file's file channel instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.194 -0500", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "71023C0B035767FEDEF5C724C59A4BDF")
    
public final synchronized FileChannel getChannel() {
        if(channel == null) {
            channel = NioUtils.newFileChannel(this, fd, mode);
        }
        return channel;
    }

    /**
     * Gets this file's {@link FileDescriptor}. This represents the operating
     * system resource for this random access file.
     *
     * @return this file's file descriptor object.
     * @throws IOException
     *             if an error occurs while getting the file descriptor of this
     *             file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.196 -0500", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "BF99A80A25EF13693DBEFA2A53118A0A")
    
public final FileDescriptor getFD() throws IOException {
        return fd;
    }

    /**
     * Gets the current position within this file. All reads and
     * writes take place at the current file pointer position.
     *
     * @return the current offset in bytes from the beginning of the file.
     *
     * @throws IOException
     *             if an error occurs while getting the file pointer of this
     *             file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.199 -0500", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "78E5DC27F44F7D2899D06F9452A20977")
    
public long getFilePointer() throws IOException {
        try {
            return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    /**
     * Returns the length of this file in bytes.
     *
     * @return the file's length in bytes.
     * @throws IOException
     *             if this file is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.201 -0500", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "CB2CD97BAA9992C591917F959A4543EB")
    
public long length() throws IOException {
        try {
            return Libcore.os.fstat(fd).st_size;
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    /**
     * Reads a single byte from the current position in this file and returns it
     * as an integer in the range from 0 to 255. Returns -1 if the end of the
     * file has been reached. Blocks until one byte has been read, the end of
     * the file is detected, or an exception is thrown.
     *
     * @return the byte read or -1 if the end of the file has been reached.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.204 -0500", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "C43FAE37877C94D1A4278A353B3DC98F")
    
public int read() throws IOException {
        return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    /**
     * Reads bytes from the current position in this file and stores them in the
     * byte array {@code buffer}. The maximum number of bytes read corresponds
     * to the size of {@code buffer}. Blocks until at least one byte has been
     * read, the end of the file is detected, or an exception is thrown.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @return the number of bytes actually read or -1 if the end of the file
     *         has been reached.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.206 -0500", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "6E5D00FFA2D494E6084FF31B9747697A")
    
public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    /**
     * Reads at most {@code byteCount} bytes from the current position in this file
     * and stores them in the byte array {@code buffer} starting at {@code
     * byteOffset}. Blocks until at least one byte has been
     * read, the end of the file is detected, or an exception is thrown.
     *
     * @return the number of bytes actually read or -1 if the end of the stream
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code byteOffset < 0} or {@code byteCount < 0}, or if {@code
     *             byteOffset + byteCount} is greater than the size of {@code buffer}.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.208 -0500", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "DC7919B1248E944CD403B40630CBB67F")
    
public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    /**
     * Reads a boolean from the current position in this file. Blocks until one
     * byte has been read, the end of the file is reached or an exception is
     * thrown.
     *
     * @return the next boolean value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeBoolean(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.211 -0500", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "F9A31F84ADBCA19B6043EA35A5DF9513")
    
public final boolean readBoolean() throws IOException {
        int temp = this.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return temp != 0;
    }

    /**
     * Reads an 8-bit byte from the current position in this file. Blocks until
     * one byte has been read, the end of the file is reached or an exception is
     * thrown.
     *
     * @return the next signed 8-bit byte value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeBoolean(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.214 -0500", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "60488882DC013DC02E5B18F972072683")
    
public final byte readByte() throws IOException {
        int temp = this.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return (byte) temp;
    }

    /**
     * Reads a big-endian 16-bit character from the current position in this file. Blocks until
     * two bytes have been read, the end of the file is reached or an exception is
     * thrown.
     *
     * @return the next char value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeChar(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.217 -0500", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "B0732E37E958B55BB10FAA52B3D5674C")
    
public final char readChar() throws IOException {
        return (char) readShort();
    }

    /**
     * Reads a big-endian 64-bit double from the current position in this file. Blocks
     * until eight bytes have been read, the end of the file is reached or an
     * exception is thrown.
     *
     * @return the next double value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeDouble(double)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.219 -0500", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "D338B640779B17CB7260528C9150884A")
    
public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    /**
     * Reads a big-endian 32-bit float from the current position in this file. Blocks
     * until four bytes have been read, the end of the file is reached or an
     * exception is thrown.
     *
     * @return the next float value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeFloat(float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.222 -0500", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "80593170191F13BFD0E1C07AC7E4AFC0")
    
public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    /**
     * Equivalent to {@code readFully(dst, 0, dst.length);}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.224 -0500", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "A7F355DBB7B4EAE4A328A9A9E3910E20")
    
public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
    }

    /**
     * Reads {@code byteCount} bytes from this stream and stores them in the byte
     * array {@code dst} starting at {@code offset}. If {@code byteCount} is zero, then this
     * method returns without reading any bytes. Otherwise, this method blocks until
     * {@code byteCount} bytes have been read. If insufficient bytes are available,
     * {@code EOFException} is thrown. If an I/O error occurs, {@code IOException} is
     * thrown. When an exception is thrown, some bytes may have been consumed from the stream
     * and written into the array.
     *
     * @param dst
     *            the byte array into which the data is read.
     * @param offset
     *            the offset in {@code dst} at which to store the bytes.
     * @param byteCount
     *            the number of bytes to read.
     * @throws EOFException
     *             if the end of the source stream is reached before enough
     *             bytes have been read.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code byteCount < 0}, or
     *             {@code offset + byteCount > dst.length}.
     * @throws IOException
     *             if a problem occurs while reading from this stream.
     * @throws NullPointerException
     *             if {@code dst} is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.227 -0500", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "D5B8143676F49C157F3B2AD3E184A597")
    
public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        while (byteCount > 0) {
            int result = read(dst, offset, byteCount);
            if (result < 0) {
                throw new EOFException();
            }
            offset += result;
            byteCount -= result;
        }
    }

    /**
     * Reads a big-endian 32-bit integer from the current position in this file. Blocks
     * until four bytes have been read, the end of the file is reached or an
     * exception is thrown.
     *
     * @return the next int value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeInt(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.230 -0500", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "5D6C62E5010CBE21FE3E33B342C82583")
    
public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Reads a line of text form the current position in this file. A line is
     * represented by zero or more characters followed by {@code '\n'}, {@code
     * '\r'}, {@code "\r\n"} or the end of file marker. The string does not
     * include the line terminating sequence.
     * <p>
     * Blocks until a line terminating sequence has been read, the end of the
     * file is reached or an exception is thrown.
     *
     * @return the contents of the line or {@code null} if no characters have
     *         been read before the end of the file has been reached.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.233 -0500", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "BEAFAA89A57C515E05B4E556EACE92EE")
    
public final String readLine() throws IOException {
        StringBuilder line = new StringBuilder(80); // Typical line length
        boolean foundTerminator = false;
        long unreadPosition = 0;
        while (true) {
            int nextByte = read();
            switch (nextByte) {
                case -1:
                    return line.length() != 0 ? line.toString() : null;
                case (byte) '\r':
                    if (foundTerminator) {
                        seek(unreadPosition);
                        return line.toString();
                    }
                    foundTerminator = true;
                    /* Have to be able to peek ahead one byte */
                    unreadPosition = getFilePointer();
                    break;
                case (byte) '\n':
                    return line.toString();
                default:
                    if (foundTerminator) {
                        seek(unreadPosition);
                        return line.toString();
                    }
                    line.append((char) nextByte);
            }
        }
    }

    /**
     * Reads a big-endian 64-bit long from the current position in this file. Blocks until
     * eight bytes have been read, the end of the file is reached or an
     * exception is thrown.
     *
     * @return the next long value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeLong(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.235 -0500", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "A9605FE51958909BD225DA582AF5352D")
    
public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Reads a big-endian 16-bit short from the current position in this file. Blocks until
     * two bytes have been read, the end of the file is reached or an exception
     * is thrown.
     *
     * @return the next short value from this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeShort(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.238 -0500", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "8C1BC44A51E102FD4811ACD830EA9366")
    
public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Reads an unsigned 8-bit byte from the current position in this file and
     * returns it as an integer. Blocks until one byte has been read, the end of
     * the file is reached or an exception is thrown.
     *
     * @return the next unsigned byte value from this file as an int.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeByte(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.240 -0500", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "E10289AF1D5496D17669A60BBBE2F9E9")
    
public final int readUnsignedByte() throws IOException {
        int temp = this.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return temp;
    }

    /**
     * Reads an unsigned big-endian 16-bit short from the current position in this file and
     * returns it as an integer. Blocks until two bytes have been read, the end of
     * the file is reached or an exception is thrown.
     *
     * @return the next unsigned short value from this file as an int.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #writeShort(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.243 -0500", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "D61B634BAB1210C26ADCEAB5B21DE464")
    
public final int readUnsignedShort() throws IOException {
        return ((int) readShort()) & 0xffff;
    }

    /**
     * Reads a string that is encoded in {@link DataInput modified UTF-8} from
     * this file. The number of bytes that must be read for the complete string
     * is determined by the first two bytes read from the file. Blocks until all
     * required bytes have been read, the end of the file is reached or an
     * exception is thrown.
     *
     * @return the next string encoded in {@link DataInput modified UTF-8} from
     *         this file.
     * @throws EOFException
     *             if the end of this file is detected.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @throws UTFDataFormatException
     *             if the bytes read cannot be decoded into a character string.
     * @see #writeUTF(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.246 -0500", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "9185F536AED2E9334E1588BCE6D15B49")
    
public final String readUTF() throws IOException {
        int utfSize = readUnsignedShort();
        if (utfSize == 0) {
            return "";
        }
        byte[] buf = new byte[utfSize];
        if (read(buf, 0, buf.length) != buf.length) {
            throw new EOFException();
        }
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    /**
     * Moves this file's file pointer to a new position, from where following
     * {@code read}, {@code write} or {@code skip} operations are done. The
     * position may be greater than the current length of the file, but the
     * file's length will only change if the moving of the pointer is followed
     * by a {@code write} operation.
     *
     * @param offset
     *            the new file pointer position.
     * @throws IOException
     *             if this file is closed, {@code pos < 0} or another I/O error
     *             occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.249 -0500", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "73DC14107C93695D525162506C13794D")
    
public void seek(long offset) throws IOException {
        if (offset < 0) {
            throw new IOException("offset < 0: " + offset);
        }
        try {
            Libcore.os.lseek(fd, offset, SEEK_SET);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    /**
     * Sets the length of this file to {@code newLength}. If the current file is
     * smaller, it is expanded but the contents from the previous end of the
     * file to the new end are undefined. The file is truncated if its current
     * size is bigger than {@code newLength}. If the current file pointer
     * position is in the truncated part, it is set to the end of the file.
     *
     * @param newLength
     *            the new file length in bytes.
     * @throws IllegalArgumentException
     *             if {@code newLength < 0}.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.251 -0500", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "AB5A5369B402ECB690F6A9D77ABACB90")
    
public void setLength(long newLength) throws IOException {
        if (newLength < 0) {
            throw new IllegalArgumentException("newLength < 0");
        }
        try {
            Libcore.os.ftruncate(fd, newLength);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }

        long filePointer = getFilePointer();
        if (filePointer > newLength) {
            seek(newLength);
        }

        // if we are in "rws" mode, attempt to sync file+metadata
        if (syncMetadata) {
            fd.sync();
        }
    }

    /**
     * Skips over {@code count} bytes in this file. Less than {@code count}
     * bytes are skipped if the end of the file is reached or an exception is
     * thrown during the operation. Nothing is done if {@code count} is
     * negative.
     *
     * @param count
     *            the number of bytes to skip.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.254 -0500", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "F28BDDC6AFDD6D20810D78F064E232CF")
    
public int skipBytes(int count) throws IOException {
        if (count > 0) {
            long currentPos = getFilePointer(), eof = length();
            int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            seek(currentPos + newCount);
            return newCount;
        }
        return 0;
    }

    /**
     * Writes the entire contents of the byte array {@code buffer} to this file,
     * starting at the current file pointer.
     *
     * @param buffer
     *            the buffer to write.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.257 -0500", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "227B669FDA8AD574341B08A5DD95557F")
    
public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
    }

    /**
     * Writes {@code byteCount} bytes from the byte array {@code buffer} to this
     * file, starting at the current file pointer and using {@code byteOffset} as
     * the first position within {@code buffer} to get bytes.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code byteCount < 0}, {@code byteOffset < 0} or {@code byteCount +
     *             byteOffset} is greater than the size of {@code buffer}.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.259 -0500", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "408D805D9F4B74A29DDEBF53541D0A55")
    
public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        // if we are in "rws" mode, attempt to sync file+metadata
        if (syncMetadata) {
            fd.sync();
        }
    }

    /**
     * Writes a byte to this file, starting at the current file pointer. Only
     * the least significant byte of the integer {@code oneByte} is written.
     *
     * @param oneByte
     *            the byte to write to this file.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #read()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.262 -0500", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "5ED746FBDAF085038B13817E660DB906")
    
public void write(int oneByte) throws IOException {
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
    }

    /**
     * Writes a boolean to this file as a single byte (1 for true, 0 for false), starting at the
     * current file pointer.
     *
     * @param val
     *            the boolean to write to this file.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #readBoolean()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.264 -0500", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "BC3F06DA4ACE3228AF29A037952DAF6A")
    
public final void writeBoolean(boolean val) throws IOException {
        write(val ? 1 : 0);
    }

    /**
     * Writes an 8-bit byte to this file, starting at the current file pointer.
     * Only the least significant byte of the integer {@code val} is written.
     *
     * @param val
     *            the byte to write to this file.
     * @throws IOException
     *             if this file is closed or another I/O error occurs.
     * @see #readByte()
     * @see #readUnsignedByte()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.267 -0500", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "B8250C3250A38DA6C7D198731C269ADA")
    
public final void writeByte(int val) throws IOException {
        write(val & 0xFF);
    }

    /**
     * Writes the low order 8-bit bytes from a string to this file, starting at
     * the current file pointer.
     *
     * @param str
     *            the string containing the bytes to write to this file
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.269 -0500", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "39275A257DB50D61A6E49D9313454A28")
    
public final void writeBytes(String str) throws IOException {
        byte[] bytes = new byte[str.length()];
        for (int index = 0; index < str.length(); index++) {
            bytes[index] = (byte) (str.charAt(index) & 0xFF);
        }
        write(bytes);
    }

    /**
     * Writes a big-endian 16-bit character to this file, starting at the current file
     * pointer. Only the two least significant bytes of the integer {@code val}
     * are written, with the high byte first.
     *
     * @param val
     *            the char to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readChar()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.272 -0500", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "932B9992937F002B26811C18101888C1")
    
public final void writeChar(int val) throws IOException {
        writeShort(val);
    }

    /**
     * Writes big-endian 16-bit characters from {@code str} to this file, starting at the
     * current file pointer.
     *
     * @param str
     *            the string to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readChar()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.274 -0500", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "9C778C35E08DCB80938DC8E57B2C1AA4")
    
public final void writeChars(String str) throws IOException {
        write(str.getBytes("UTF-16BE"));
    }

    /**
     * Writes a big-endian 64-bit double to this file, starting at the current file
     * pointer. The bytes are those returned by
     * {@link Double#doubleToLongBits(double)}, meaning a canonical NaN is used.
     *
     * @param val
     *            the double to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readDouble()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.277 -0500", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "F3BF6663D138ED0E1DFEA62B1C80FA3F")
    
public final void writeDouble(double val) throws IOException {
        writeLong(Double.doubleToLongBits(val));
    }

    /**
     * Writes a big-endian 32-bit float to this file, starting at the current file pointer.
     * The bytes are those returned by {@link Float#floatToIntBits(float)}, meaning a canonical NaN
     * is used.
     *
     * @param val
     *            the float to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readFloat()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.279 -0500", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "1792C72D5DB8A7188EE6A15A300D3124")
    
public final void writeFloat(float val) throws IOException {
        writeInt(Float.floatToIntBits(val));
    }

    /**
     * Writes a big-endian 32-bit integer to this file, starting at the current file
     * pointer.
     *
     * @param val
     *            the int to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readInt()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.282 -0500", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "614D95C47B63C83EC304F76F5EA63F78")
    
public final void writeInt(int val) throws IOException {
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
    }

    /**
     * Writes a big-endian 64-bit long to this file, starting at the current file
     * pointer.
     *
     * @param val
     *            the long to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readLong()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.285 -0500", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "EC58106DBA84FF2516FCC382DA22D5AA")
    
public final void writeLong(long val) throws IOException {
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
    }

    /**
     * Writes a big-endian 16-bit short to this file, starting at the current file
     * pointer. Only the two least significant bytes of the integer {@code val}
     * are written.
     *
     * @param val
     *            the short to write to this file.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @see #readShort()
     * @see DataInput#readUnsignedShort()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.287 -0500", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "BD718C7C8DCE79BD36DF8E1657B26DBA")
    
public final void writeShort(int val) throws IOException {
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
    }

    /**
     * Writes a string encoded with {@link DataInput modified UTF-8} to this
     * file, starting at the current file pointer.
     *
     * @param str
     *            the string to write in {@link DataInput modified UTF-8}
     *            format.
     * @throws IOException
     *             if an I/O error occurs while writing to this file.
     * @throws UTFDataFormatException
     *             if the encoded string is longer than 65535 bytes.
     * @see #readUTF()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.290 -0500", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "58B20B8780C4182A44E8248160366D2A")
    
public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
    }

    
}

