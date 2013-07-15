package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.Memory;

public class GZIPInputStream extends InflaterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.413 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.413 -0400", hash_original_field = "4B9123C8B7E4C75BE588658E49981750", hash_generated_field = "CDC6F178723B8CC90E4127274A60802C")

    protected boolean eos = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.413 -0400", hash_original_method = "DC7C53463DEA3BC77C9FF2C25FAEFF14", hash_generated_method = "ECF56D48272603D00991EA987D1C51A7")
    public  GZIPInputStream(InputStream is) throws IOException {
        this(is, BUF_SIZE);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.414 -0400", hash_original_method = "5DD740AE0EB83490269826B6CD66524C", hash_generated_method = "D598E0FDA50EEE83AA58FD6AFFF52374")
    public  GZIPInputStream(InputStream is, int size) throws IOException {
        super(is, new Inflater(true), size);
        addTaint(size);
        addTaint(is.getTaint());
        byte[] header = new byte[10];
        readFully(header, 0, header.length);
        short magic = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
    if(magic != (short) GZIP_MAGIC)        
        {
            IOException var46E31AEAA46980334AFA13D41AD42F50_1085337540 = new IOException(String.format("unknown format (magic number %x)", magic));
            var46E31AEAA46980334AFA13D41AD42F50_1085337540.addTaint(taint);
            throw var46E31AEAA46980334AFA13D41AD42F50_1085337540;
        } //End block
        int flags = header[3];
        boolean hcrc = (flags & FHCRC) != 0;
    if(hcrc)        
        {
            crc.update(header, 0, header.length);
        } //End block
    if((flags & FEXTRA) != 0)        
        {
            readFully(header, 0, 2);
    if(hcrc)            
            {
                crc.update(header, 0, 2);
            } //End block
            int length = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN) & 0xffff;
            while
(length > 0)            
            {
                int max = length > buf.length ? buf.length : length;
                int result = in.read(buf, 0, max);
    if(result == -1)                
                {
                    EOFException var0239D63DB748BB20D119EB36D6D1C384_1028631961 = new EOFException();
                    var0239D63DB748BB20D119EB36D6D1C384_1028631961.addTaint(taint);
                    throw var0239D63DB748BB20D119EB36D6D1C384_1028631961;
                } //End block
    if(hcrc)                
                {
                    crc.update(buf, 0, result);
                } //End block
                length -= result;
            } //End block
        } //End block
    if((flags & FNAME) != 0)        
        {
            readZeroTerminated(hcrc);
        } //End block
    if((flags & FCOMMENT) != 0)        
        {
            readZeroTerminated(hcrc);
        } //End block
    if(hcrc)        
        {
            readFully(header, 0, 2);
            short crc16 = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
    if((short) crc.getValue() != crc16)            
            {
                IOException var6662443A05BBD7E56314F659252E34FC_1756103141 = new IOException("CRC mismatch");
                var6662443A05BBD7E56314F659252E34FC_1756103141.addTaint(taint);
                throw var6662443A05BBD7E56314F659252E34FC_1756103141;
            } //End block
            crc.reset();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.414 -0400", hash_original_method = "BB5EB4821217BB73F8D521350E3FEC7B", hash_generated_method = "3F2B46524DBDCE46E7A36A9F327E3A4C")
    @Override
    public void close() throws IOException {
        eos = true;
        super.close();
        // ---------- Original Method ----------
        //eos = true;
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.414 -0400", hash_original_method = "FAE53FCD1CA8F33ECA2437ABBFBE85CF", hash_generated_method = "7B184CDEC931BAF727634A14C2A3B0C3")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
    if(closed)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_524723670 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_524723670.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_524723670;
        } //End block
    if(eos)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_355736419 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059451569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059451569;
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
    if(bytesRead != -1)        
        {
            crc.update(buffer, offset, bytesRead);
        } //End block
    if(eos)        
        {
            verifyCrc();
        } //End block
        int varD871906E18D7E876E6494103DA4BEEBD_1232245285 = (bytesRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044372541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044372541;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_method = "6D843C12482D0F9414C1006D7B90FFFD", hash_generated_method = "F887014557DF061F16D3774FEF9A7374")
    private void verifyCrc() throws IOException {
        int size = inf.getRemaining();
        final int trailerSize = 8;
        byte[] b = new byte[trailerSize];
        int copySize = (size > trailerSize) ? trailerSize : size;
        System.arraycopy(buf, len - size, b, 0, copySize);
        readFully(b, copySize, trailerSize - copySize);
    if(Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue())        
        {
            IOException var6662443A05BBD7E56314F659252E34FC_1129223158 = new IOException("CRC mismatch");
            var6662443A05BBD7E56314F659252E34FC_1129223158.addTaint(taint);
            throw var6662443A05BBD7E56314F659252E34FC_1129223158;
        } //End block
    if(Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut())        
        {
            IOException var51D8211A9B3A3EEB7C5C665E9D174100_575258999 = new IOException("Size mismatch");
            var51D8211A9B3A3EEB7C5C665E9D174100_575258999.addTaint(taint);
            throw var51D8211A9B3A3EEB7C5C665E9D174100_575258999;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_method = "9B3EB008D719ED0FB3E689755FC76BB5", hash_generated_method = "7B3C1FFEDE3C2536B472D334A65E31B2")
    private void readFully(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        int result;
        while
(length > 0)        
        {
            result = in.read(buffer, offset, length);
    if(result == -1)            
            {
                EOFException var0239D63DB748BB20D119EB36D6D1C384_1763839856 = new EOFException();
                var0239D63DB748BB20D119EB36D6D1C384_1763839856.addTaint(taint);
                throw var0239D63DB748BB20D119EB36D6D1C384_1763839856;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_method = "7C6B7FFA42529CFE943A1AC064CF5BC3", hash_generated_method = "97A7601AB07EA20749FE758E3659535E")
    private void readZeroTerminated(boolean hcrc) throws IOException {
        addTaint(hcrc);
        int result;
        while
((result = in.read()) > 0)        
        {
    if(hcrc)            
            {
                crc.update(result);
            } //End block
        } //End block
    if(result == -1)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_1846582422 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_1846582422.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_1846582422;
        } //End block
    if(hcrc)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_field = "875720C110599DE52B9DC8CE6451C081", hash_generated_field = "02DDC74956F881D64CE1C7D6050C9F70")

    private static final int FCOMMENT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_field = "ADE4C8777B60E58CE08786BAB5CE86D5", hash_generated_field = "E75B8E4FDF02F0C7E68C62FE1BBF493F")

    private static final int FEXTRA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.415 -0400", hash_original_field = "51F0D8B57181E4BEDBD79221D8779327", hash_generated_field = "390F1EF548C925A41577D8A8F438ADC9")

    private static final int FHCRC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.416 -0400", hash_original_field = "B4B65558C09E945560CEE2A6095DF899", hash_generated_field = "BEF062C8719D26CFC454C2C6074500B1")

    private static final int FNAME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.416 -0400", hash_original_field = "5037AA396B919BA9517AC7C577F457C5", hash_generated_field = "EA43AF0273B6C3B8DADF1F68E7A59DEF")

    public static final int GZIP_MAGIC = 0x8b1f;
}

