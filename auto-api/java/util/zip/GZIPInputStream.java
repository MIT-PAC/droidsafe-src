package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.Memory;

public class GZIPInputStream extends InflaterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.738 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.738 -0400", hash_original_field = "4B9123C8B7E4C75BE588658E49981750", hash_generated_field = "CDC6F178723B8CC90E4127274A60802C")

    protected boolean eos = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.741 -0400", hash_original_method = "DC7C53463DEA3BC77C9FF2C25FAEFF14", hash_generated_method = "ECF56D48272603D00991EA987D1C51A7")
    public  GZIPInputStream(InputStream is) throws IOException {
        this(is, BUF_SIZE);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.761 -0400", hash_original_method = "5DD740AE0EB83490269826B6CD66524C", hash_generated_method = "B676FCE282A4BEFA042F9BB89BFAD3BD")
    public  GZIPInputStream(InputStream is, int size) throws IOException {
        super(is, new Inflater(true), size);
        byte[] header;
        header = new byte[10];
        readFully(header, 0, header.length);
        short magic;
        magic = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(String.format("unknown format (magic number %x)", magic));
        } //End block
        int flags;
        flags = header[3];
        boolean hcrc;
        hcrc = (flags & FHCRC) != 0;
        {
            crc.update(header, 0, header.length);
        } //End block
        {
            readFully(header, 0, 2);
            {
                crc.update(header, 0, 2);
            } //End block
            int length;
            length = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN) & 0xffff;
            {
                int max;
                max = buf.length;
                max = length;
                int result;
                result = in.read(buf, 0, max);
                {
                    if (DroidSafeAndroidRuntime.control) throw new EOFException();
                } //End block
                {
                    crc.update(buf, 0, result);
                } //End block
                length -= result;
            } //End block
        } //End block
        {
            readZeroTerminated(hcrc);
        } //End block
        {
            readZeroTerminated(hcrc);
        } //End block
        {
            readFully(header, 0, 2);
            short crc16;
            crc16 = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
            {
                boolean varDF24CD4CC3CA4735CDB857FDC66AEAF5_2120841083 = ((short) crc.getValue() != crc16);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
                } //End block
            } //End collapsed parenthetic
            crc.reset();
        } //End block
        addTaint(is.getTaint());
        addTaint(size);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.769 -0400", hash_original_method = "BB5EB4821217BB73F8D521350E3FEC7B", hash_generated_method = "3F2B46524DBDCE46E7A36A9F327E3A4C")
    @Override
    public void close() throws IOException {
        eos = true;
        super.close();
        // ---------- Original Method ----------
        //eos = true;
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.771 -0400", hash_original_method = "FAE53FCD1CA8F33ECA2437ABBFBE85CF", hash_generated_method = "7A8ACBB06703807CCBBFBE1245539F55")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream is closed");
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        int bytesRead;
        try 
        {
            bytesRead = super.read(buffer, offset, byteCount);
        } //End block
        finally 
        {
            eos = eof;
        } //End block
        {
            crc.update(buffer, offset, bytesRead);
        } //End block
        {
            verifyCrc();
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304509952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304509952;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Stream is closed");
        //}
        //if (eos) {
            //return -1;
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        //int bytesRead;
        //try {
            //bytesRead = super.read(buffer, offset, byteCount);
        //} finally {
            //eos = eof; 
        //}
        //if (bytesRead != -1) {
            //crc.update(buffer, offset, bytesRead);
        //}
        //if (eos) {
            //verifyCrc();
        //}
        //return bytesRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.775 -0400", hash_original_method = "6D843C12482D0F9414C1006D7B90FFFD", hash_generated_method = "965C214C366C419D4DD58DAC379ABCEE")
    private void verifyCrc() throws IOException {
        int size;
        size = inf.getRemaining();
        int trailerSize;
        trailerSize = 8;
        byte[] b;
        b = new byte[trailerSize];
        int copySize;
        copySize = trailerSize;
        copySize = size;
        System.arraycopy(buf, len - size, b, 0, copySize);
        readFully(b, copySize, trailerSize - copySize);
        {
            boolean var5DF625EDF3B3FF5C7A985A745F01E054_1549492613 = (Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC3A7C64687DEFE6659EE053CD7A27F8C_1537877780 = (Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Size mismatch");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int size = inf.getRemaining();
        //final int trailerSize = 8;
        //byte[] b = new byte[trailerSize];
        //int copySize = (size > trailerSize) ? trailerSize : size;
        //System.arraycopy(buf, len - size, b, 0, copySize);
        //readFully(b, copySize, trailerSize - copySize);
        //if (Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue()) {
            //throw new IOException("CRC mismatch");
        //}
        //if (Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut()) {
            //throw new IOException("Size mismatch");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.776 -0400", hash_original_method = "9B3EB008D719ED0FB3E689755FC76BB5", hash_generated_method = "39B263928B24E71186845DEA0A6C04A9")
    private void readFully(byte[] buffer, int offset, int length) throws IOException {
        int result;
        {
            result = in.read(buffer, offset, length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
            offset += result;
            length -= result;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //int result;
        //while (length > 0) {
            //result = in.read(buffer, offset, length);
            //if (result == -1) {
                //throw new EOFException();
            //}
            //offset += result;
            //length -= result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_method = "7C6B7FFA42529CFE943A1AC064CF5BC3", hash_generated_method = "BB636280C84065ADA0945E2DF8C161BD")
    private void readZeroTerminated(boolean hcrc) throws IOException {
        int result;
        {
            boolean var01CAA10F1466E17775B40DF9BACA8AE5_2018661683 = ((result = in.read()) > 0);
            {
                {
                    crc.update(result);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        {
            crc.update(result);
        } //End block
        addTaint(hcrc);
        // ---------- Original Method ----------
        //int result;
        //while ((result = in.read()) > 0) {
            //if (hcrc) {
                //crc.update(result);
            //}
        //}
        //if (result == -1) {
            //throw new EOFException();
        //}
        //if (hcrc) {
            //crc.update(result);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_field = "875720C110599DE52B9DC8CE6451C081", hash_generated_field = "5295DAFAA95F7526951D126584FCE990")

    private static int FCOMMENT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_field = "ADE4C8777B60E58CE08786BAB5CE86D5", hash_generated_field = "0817A1EB2E9A7F6879CE27B6C938ECDA")

    private static int FEXTRA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_field = "51F0D8B57181E4BEDBD79221D8779327", hash_generated_field = "CDB48B27A715A9E462D4CA25AFC7087E")

    private static int FHCRC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_field = "B4B65558C09E945560CEE2A6095DF899", hash_generated_field = "FAB8440DAD1A3C1BB2FB4A8DB0B2D8BF")

    private static int FNAME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.798 -0400", hash_original_field = "5037AA396B919BA9517AC7C577F457C5", hash_generated_field = "EA43AF0273B6C3B8DADF1F68E7A59DEF")

    public static final int GZIP_MAGIC = 0x8b1f;
}

