package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;

import libcore.io.Memory;
import libcore.io.SizeOf;

public class DataOutputStream extends FilterOutputStream implements DataOutput {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.600 -0500", hash_original_field = "BB6EE13587F628B91D273A1D077E6D31", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.603 -0500", hash_original_field = "6BEB77487CF3182B1F4EE9D9A9B77205", hash_generated_field = "E741850208E8C13ED74657425073FA6A")

    protected int written;

    /**
     * Constructs a new {@code DataOutputStream} on the {@code OutputStream}
     * {@code out}. Note that data written by this stream is not in a human
     * readable form but can be reconstructed by using a {@link DataInputStream}
     * on the resulting output.
     *
     * @param out
     *            the target stream for writing.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.605 -0500", hash_original_method = "1F21B50AF2AC9DDDB6B0A66AE5784248", hash_generated_method = "5DCE7229AD881E0B9ABCB5542416823B")
    
public DataOutputStream(OutputStream out) {
        super(out);
    }

    /**
     * Flushes this stream to ensure all pending data is sent out to the target
     * stream. This implementation then also flushes the target stream.
     *
     * @throws IOException
     *             if an error occurs attempting to flush this stream.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.608 -0500", hash_original_method = "85FD61C7B117729DDA17405FA5EDFA09", hash_generated_method = "685D98350CD97C9342EE1C690C8DF05E")
    
@Override
    public void flush() throws IOException {
        super.flush();
    }

    /**
     * Returns the total number of bytes written to the target stream so far.
     *
     * @return the number of bytes written to the target stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.611 -0500", hash_original_method = "93505B8C7EE8964F6C5155AF365C502B", hash_generated_method = "EF0FDF676146F6BDFEDB75BACC892E4B")
    
public final int size() {
        if (written < 0) {
            written = Integer.MAX_VALUE;
        }
        return written;
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * {@code offset} to the target stream.
     *
     * @param buffer
     *            the buffer to write to the target stream.
     * @param offset
     *            the index of the first byte in {@code buffer} to write.
     * @param count
     *            the number of bytes from the {@code buffer} to write.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.614 -0500", hash_original_method = "91D255AEAD2ED7375F2242249D64C3A6", hash_generated_method = "1314E249A0FB0A0967DD391BB94D9A0D")
    
@Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        if (buffer == null) {
            throw new NullPointerException("buffer == null");
        }
        out.write(buffer, offset, count);
        written += count;
    }

    /**
     * Writes a byte to the target stream. Only the least significant byte of
     * the integer {@code oneByte} is written.
     *
     * @param oneByte
     *            the byte to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see DataInputStream#readByte()
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.616 -0500", hash_original_method = "480870EC6BADBB21CCFBD983315F3126", hash_generated_method = "0DA8DCF8A72CE0A0690961D8DC195CF7")
    
@Override
    public void write(int oneByte) throws IOException {
        out.write(oneByte);
        written++;
    }

    /**
     * Writes a boolean to the target stream.
     *
     * @param val
     *            the boolean value to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see DataInputStream#readBoolean()
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.619 -0500", hash_original_method = "A77584E214A9D3ECC7E83106209731E2", hash_generated_method = "B8415B4CF44291581AD37B7E19828B7B")
    
public final void writeBoolean(boolean val) throws IOException {
        out.write(val ? 1 : 0);
        written++;
    }

    /**
     * Writes an 8-bit byte to the target stream. Only the least significant
     * byte of the integer {@code val} is written.
     *
     * @param val
     *            the byte value to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see DataInputStream#readByte()
     * @see DataInputStream#readUnsignedByte()
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.621 -0500", hash_original_method = "3FF3B06C0E9CF4CECAE3125D160806A3", hash_generated_method = "467CC22D59F0D574A1647E1C1FF806FE")
    
public final void writeByte(int val) throws IOException {
        out.write(val);
        written++;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.624 -0500", hash_original_method = "2B2A2FBAAA2AE585E2D089CF030D969B", hash_generated_method = "9EE83BA4C7BA1BF83E75A29293DC19EF")
    
public final void writeBytes(String str) throws IOException {
        if (str.length() == 0) {
            return;
        }
        byte[] bytes = new byte[str.length()];
        for (int index = 0; index < str.length(); index++) {
            bytes[index] = (byte) str.charAt(index);
        }
        out.write(bytes);
        written += bytes.length;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.627 -0500", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "932B9992937F002B26811C18101888C1")
    
public final void writeChar(int val) throws IOException {
        writeShort(val);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.629 -0500", hash_original_method = "8A00B7ED3E4C8E18D5DAA971EE1A3300", hash_generated_method = "4C4548AA5CDEEC6841B45960D446F88C")
    
public final void writeChars(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-16BE");
        out.write(bytes);
        written += bytes.length;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.632 -0500", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "F3BF6663D138ED0E1DFEA62B1C80FA3F")
    
public final void writeDouble(double val) throws IOException {
        writeLong(Double.doubleToLongBits(val));
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.634 -0500", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "1792C72D5DB8A7188EE6A15A300D3124")
    
public final void writeFloat(float val) throws IOException {
        writeInt(Float.floatToIntBits(val));
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.637 -0500", hash_original_method = "F03796591B445F12DEDD3500300CBF0A", hash_generated_method = "5E91487BC25631CF747CB54ECA66F448")
    
public final void writeInt(int val) throws IOException {
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.INT);
        written += SizeOf.INT;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.639 -0500", hash_original_method = "95F3A047CFE8B2E6EECA757BB89D80AE", hash_generated_method = "091AAB9442100D8BDAEDE95427FB4C48")
    
public final void writeLong(long val) throws IOException {
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.LONG);
        written += SizeOf.LONG;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.642 -0500", hash_original_method = "C58CFA32359226806A4206A3D5262CA2", hash_generated_method = "EEC192FAADE8CC25AA4C6B2838FDC939")
    
public final void writeShort(int val) throws IOException {
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.SHORT);
        written += SizeOf.SHORT;
    }

    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.644 -0500", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "58B20B8780C4182A44E8248160366D2A")
    
public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
    }
    
}

