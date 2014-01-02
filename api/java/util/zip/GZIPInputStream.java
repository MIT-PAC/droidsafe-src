package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;

import libcore.io.Memory;


public class GZIPInputStream extends InflaterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.638 -0500", hash_original_field = "562DED064ECF9245FD9964B42E1B365A", hash_generated_field = "02DDC74956F881D64CE1C7D6050C9F70")

    private static final int FCOMMENT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.641 -0500", hash_original_field = "959B3384CBC0C3E67D0ECCEA64D202E1", hash_generated_field = "E75B8E4FDF02F0C7E68C62FE1BBF493F")


    private static final int FEXTRA = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.644 -0500", hash_original_field = "93C6A00BB570B22DACF6A67FBE45DDB0", hash_generated_field = "390F1EF548C925A41577D8A8F438ADC9")


    private static final int FHCRC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.646 -0500", hash_original_field = "B844997ECF08C6CD1FC43F320571A37F", hash_generated_field = "BEF062C8719D26CFC454C2C6074500B1")


    private static final int FNAME = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.649 -0500", hash_original_field = "A60D6887DA9295E3D6BABAE0A26A0251", hash_generated_field = "EA43AF0273B6C3B8DADF1F68E7A59DEF")

    public static final int GZIP_MAGIC = 0x8b1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.652 -0500", hash_original_field = "8797544496C08ADE2D4F77E9A38D0FB1", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.654 -0500", hash_original_field = "542D70E5D5A3290907DA75B37B0954FD", hash_generated_field = "CDC6F178723B8CC90E4127274A60802C")

    protected boolean eos = false;

    /**
     * Construct a {@code GZIPInputStream} to read from GZIP data from the
     * underlying stream.
     *
     * @param is
     *            the {@code InputStream} to read data from.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.657 -0500", hash_original_method = "DC7C53463DEA3BC77C9FF2C25FAEFF14", hash_generated_method = "4CACDDA3C01475C988E89A026717E9AA")
    
public GZIPInputStream(InputStream is) throws IOException {
        this(is, BUF_SIZE);
    }

    /**
     * Construct a {@code GZIPInputStream} to read from GZIP data from the
     * underlying stream. Set the internal buffer size to {@code size}.
     *
     * @param is
     *            the {@code InputStream} to read data from.
     * @param size
     *            the internal read buffer size.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.660 -0500", hash_original_method = "5DD740AE0EB83490269826B6CD66524C", hash_generated_method = "AF15E3C7F5B5382DCDADBB1DF73D5083")
    
public GZIPInputStream(InputStream is, int size) throws IOException {
        super(is, new Inflater(true), size);
        byte[] header = new byte[10];
        readFully(header, 0, header.length);
        short magic = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
        if (magic != (short) GZIP_MAGIC) {
            throw new IOException(String.format("unknown format (magic number %x)", magic));
        }
        int flags = header[3];
        boolean hcrc = (flags & FHCRC) != 0;
        if (hcrc) {
            crc.update(header, 0, header.length);
        }
        if ((flags & FEXTRA) != 0) {
            readFully(header, 0, 2);
            if (hcrc) {
                crc.update(header, 0, 2);
            }
            int length = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN) & 0xffff;
            while (length > 0) {
                int max = length > buf.length ? buf.length : length;
                int result = in.read(buf, 0, max);
                if (result == -1) {
                    throw new EOFException();
                }
                if (hcrc) {
                    crc.update(buf, 0, result);
                }
                length -= result;
            }
        }
        if ((flags & FNAME) != 0) {
            readZeroTerminated(hcrc);
        }
        if ((flags & FCOMMENT) != 0) {
            readZeroTerminated(hcrc);
        }
        if (hcrc) {
            readFully(header, 0, 2);
            short crc16 = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
            if ((short) crc.getValue() != crc16) {
                throw new IOException("CRC mismatch");
            }
            crc.reset();
        }
    }

    /**
     * Closes this stream and any underlying streams.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.663 -0500", hash_original_method = "BB5EB4821217BB73F8D521350E3FEC7B", hash_generated_method = "BA6BD4389234E8C218462453C8EB683C")
    
@Override
    public void close() throws IOException {
        eos = true;
        super.close();
    }

    /**
     * Reads and decompresses GZIP data from the underlying stream into the
     * given buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.666 -0500", hash_original_method = "FAE53FCD1CA8F33ECA2437ABBFBE85CF", hash_generated_method = "46FBC679AB395A203BA80D20DE3C76DA")
    
@Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        if (closed) {
            throw new IOException("Stream is closed");
        }
        if (eos) {
            return -1;
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);

        int bytesRead;
        try {
            bytesRead = super.read(buffer, offset, byteCount);
        } finally {
            eos = eof; // update eos after every read(), even when it throws
        }

        if (bytesRead != -1) {
            crc.update(buffer, offset, bytesRead);
        }

        if (eos) {
            verifyCrc();
        }

        return bytesRead;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.669 -0500", hash_original_method = "6D843C12482D0F9414C1006D7B90FFFD", hash_generated_method = "8C3AD726F1F3E6CDDABB7FC7BFC4171A")
    
private void verifyCrc() throws IOException {
        // Get non-compressed bytes read by fill
        int size = inf.getRemaining();
        final int trailerSize = 8; // crc (4 bytes) + total out (4 bytes)
        byte[] b = new byte[trailerSize];
        int copySize = (size > trailerSize) ? trailerSize : size;

        System.arraycopy(buf, len - size, b, 0, copySize);
        readFully(b, copySize, trailerSize - copySize);

        if (Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue()) {
            throw new IOException("CRC mismatch");
        }
        if (Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut()) {
            throw new IOException("Size mismatch");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.671 -0500", hash_original_method = "9B3EB008D719ED0FB3E689755FC76BB5", hash_generated_method = "CC43A6B9AB766388B022EC0324861731")
    
private void readFully(byte[] buffer, int offset, int length) throws IOException {
        int result;
        while (length > 0) {
            result = in.read(buffer, offset, length);
            if (result == -1) {
                throw new EOFException();
            }
            offset += result;
            length -= result;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.674 -0500", hash_original_method = "7C6B7FFA42529CFE943A1AC064CF5BC3", hash_generated_method = "B001FE4DE62E99E6040B8044D96F693E")
    
private void readZeroTerminated(boolean hcrc) throws IOException {
        int result;
        while ((result = in.read()) > 0) {
            if (hcrc) {
                crc.update(result);
            }
        }
        if (result == -1) {
            throw new EOFException();
        }
        // Add the zero
        if (hcrc) {
            crc.update(result);
        }
    }
}

