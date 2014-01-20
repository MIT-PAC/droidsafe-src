package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;

import libcore.io.Memory;
import libcore.io.SizeOf;
import libcore.io.Streams;

public class DataInputStream extends FilterInputStream implements DataInput {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.261 -0500", hash_original_method = "67FCD1C79AA5AB7081ED61CA977F833F", hash_generated_method = "155E09981B88266614B7B0331C008BE8")
    
private static String decodeUTF(int utfSize, DataInput in) throws IOException {
        byte[] buf = new byte[utfSize];
        in.readFully(buf, 0, utfSize);
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.264 -0500", hash_original_method = "48D45EEAED3352F596D800D5190ACC41", hash_generated_method = "9EA8D8A168036339E307513D7F2AD7AD")
    
public static final String readUTF(DataInput in) throws IOException {
        return decodeUTF(in.readUnsignedShort(), in);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.212 -0500", hash_original_field = "BB6EE13587F628B91D273A1D077E6D31", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];

    /**
     * Constructs a new DataInputStream on the InputStream {@code in}. All
     * reads are then filtered through this stream. Note that data read by this
     * stream is not in a human readable format and was most likely created by a
     * DataOutputStream.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code DataInputStream}. All operations on such a stream will fail.
     *
     * @param in
     *            the source InputStream the filter reads from.
     * @see DataOutputStream
     * @see RandomAccessFile
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.214 -0500", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "5EC1B7B98AF57C776C4E6449EBBB1FD9")
    
public DataInputStream(InputStream in) {
        super(in);
    }

    // overridden to add 'final'
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.217 -0500", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "6EFE21C624F4526140DE26DD214855F3")
    
@Override public final int read(byte[] buffer) throws IOException {
        return super.read(buffer);
    }

    /**
     * Reads at most {@code length} bytes from this stream and stores them in
     * the byte array {@code buffer} starting at {@code offset}. Returns the
     * number of bytes that have been read or -1 if no bytes have been read and
     * the end of the stream has been reached.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes
     *            read from this stream.
     * @param length
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes that have been read or -1 if the end of the
     *         stream has been reached.
     * @throws IOException
     *             if a problem occurs while reading from this stream.
     * @see DataOutput#write(byte[])
     * @see DataOutput#write(byte[], int, int)
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.220 -0500", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "FD30BAD0DC3FB7FDB16BB01F578FEE23")
    
@Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        return in.read(buffer, offset, length);
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.222 -0500", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "D88517E7D5EE14A5658DEF4EDAD9DB86")
    
public final boolean readBoolean() throws IOException {
        int temp = in.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return temp != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.225 -0500", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "BF89FDFB9F1F44FEE7263800350EBECD")
    
public final byte readByte() throws IOException {
        int temp = in.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return (byte) temp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.228 -0500", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "B0732E37E958B55BB10FAA52B3D5674C")
    
public final char readChar() throws IOException {
        return (char) readShort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.230 -0500", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "D338B640779B17CB7260528C9150884A")
    
public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.232 -0500", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "80593170191F13BFD0E1C07AC7E4AFC0")
    
public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.235 -0500", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "A7F355DBB7B4EAE4A328A9A9E3910E20")
    
public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.238 -0500", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "63C911CF15A622193902D9D738EE61C2")
    
public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Streams.readFully(in, dst, offset, byteCount);
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.241 -0500", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "9112DA648D62C2A937D7C558FC5866FC")
    
public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.244 -0500", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "84589DFEC3B64DF8C1541613CF612599")
    
@Deprecated
    public final String readLine() throws IOException {
        StringBuilder line = new StringBuilder(80); // Typical line length
        boolean foundTerminator = false;
        while (true) {
            int nextByte = in.read();
            switch (nextByte) {
                case -1:
                    if (line.length() == 0 && !foundTerminator) {
                        return null;
                    }
                    return line.toString();
                case (byte) '\r':
                    if (foundTerminator) {
                        ((PushbackInputStream) in).unread(nextByte);
                        return line.toString();
                    }
                    foundTerminator = true;
                    /* Have to be able to peek ahead one byte */
                    if (!(in.getClass() == PushbackInputStream.class)) {
                        in = new PushbackInputStream(in);
                    }
                    break;
                case (byte) '\n':
                    return line.toString();
                default:
                    if (foundTerminator) {
                        ((PushbackInputStream) in).unread(nextByte);
                        return line.toString();
                    }
                    line.append((char) nextByte);
            }
        }
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.246 -0500", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "F5A3C7CEE92A45C5691BAA619958DC92")
    
public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.249 -0500", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "EB42EA6D36573C0AD80D7A6AD7292C79")
    
public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.251 -0500", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "598A274726BA31E7F4FFEE9CF67A92C5")
    
public final int readUnsignedByte() throws IOException {
        int temp = in.read();
        if (temp < 0) {
            throw new EOFException();
        }
        return temp;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.254 -0500", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "D61B634BAB1210C26ADCEAB5B21DE464")
    
public final int readUnsignedShort() throws IOException {
        return ((int) readShort()) & 0xffff;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.256 -0500", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "F3B7E68C8D455A57290BD1DE8C561729")
    
public final String readUTF() throws IOException {
        return decodeUTF(readUnsignedShort());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.258 -0500", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "97504F653AF4B98C0D73EF18B85FA029")
    
String decodeUTF(int utfSize) throws IOException {
        return decodeUTF(utfSize, this);
    }

    /**
     * Skips {@code count} number of bytes in this stream. Subsequent {@code
     * read()}s will not return these bytes unless {@code reset()} is used.
     *
     * This method will not throw an {@link EOFException} if the end of the
     * input is reached before {@code count} bytes where skipped.
     *
     * @param count
     *            the number of bytes to skip.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if a problem occurs during skipping.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.267 -0500", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "77D0CFB3B32DEBAE2CD75A6637090944")
    
public final int skipBytes(int count) throws IOException {
        int skipped = 0;
        long skip;
        while (skipped < count && (skip = in.skip(count - skipped)) != 0) {
            skipped += skip;
        }
        return skipped;
    }
    
}

