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
    protected CRC32 crc = new CRC32();
    protected boolean eos = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.744 -0400", hash_original_method = "DC7C53463DEA3BC77C9FF2C25FAEFF14", hash_generated_method = "72DDB69D52DF45F36B53CA4DD63851BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GZIPInputStream(InputStream is) throws IOException {
        this(is, BUF_SIZE);
        dsTaint.addTaint(is.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.747 -0400", hash_original_method = "5DD740AE0EB83490269826B6CD66524C", hash_generated_method = "D25A95F125DD8736666022BE00D9C2D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GZIPInputStream(InputStream is, int size) throws IOException {
        super(is, new Inflater(true), size);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(size);
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
                boolean varDF24CD4CC3CA4735CDB857FDC66AEAF5_2048438853 = ((short) crc.getValue() != crc16);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
                } //End block
            } //End collapsed parenthetic
            crc.reset();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.748 -0400", hash_original_method = "BB5EB4821217BB73F8D521350E3FEC7B", hash_generated_method = "3F2B46524DBDCE46E7A36A9F327E3A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        eos = true;
        super.close();
        // ---------- Original Method ----------
        //eos = true;
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.748 -0400", hash_original_method = "FAE53FCD1CA8F33ECA2437ABBFBE85CF", hash_generated_method = "F10EB3F9DFF96F019BF693EE3BD9FD4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.749 -0400", hash_original_method = "6D843C12482D0F9414C1006D7B90FFFD", hash_generated_method = "A21E3E8AF5733C21049BCEB0D31DCD28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            boolean var5DF625EDF3B3FF5C7A985A745F01E054_789864064 = (Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC3A7C64687DEFE6659EE053CD7A27F8C_1894666566 = (Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.749 -0400", hash_original_method = "9B3EB008D719ED0FB3E689755FC76BB5", hash_generated_method = "AC43E3C2242FB86A3CF33F88B89694D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFully(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int result;
        {
            result = in.read(buffer, offset, length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
            offset += result;
            length -= result;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.749 -0400", hash_original_method = "7C6B7FFA42529CFE943A1AC064CF5BC3", hash_generated_method = "0018AAD0EC86DD630D43C0A630B87165")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readZeroTerminated(boolean hcrc) throws IOException {
        dsTaint.addTaint(hcrc);
        int result;
        {
            boolean var01CAA10F1466E17775B40DF9BACA8AE5_455805461 = ((result = in.read()) > 0);
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

    
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    public static final int GZIP_MAGIC = 0x8b1f;
}

