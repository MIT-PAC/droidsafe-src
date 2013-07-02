package java.util.zip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.Memory;

public class GZIPInputStream extends InflaterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.787 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.787 -0400", hash_original_field = "4B9123C8B7E4C75BE588658E49981750", hash_generated_field = "CDC6F178723B8CC90E4127274A60802C")

    protected boolean eos = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.787 -0400", hash_original_method = "DC7C53463DEA3BC77C9FF2C25FAEFF14", hash_generated_method = "ECF56D48272603D00991EA987D1C51A7")
    public  GZIPInputStream(InputStream is) throws IOException {
        this(is, BUF_SIZE);
        addTaint(is.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.788 -0400", hash_original_method = "5DD740AE0EB83490269826B6CD66524C", hash_generated_method = "2DC372EBE19A1CE21F81F711278182C0")
    public  GZIPInputStream(InputStream is, int size) throws IOException {
        super(is, new Inflater(true), size);
        byte[] header = new byte[10];
        readFully(header, 0, header.length);
        short magic = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(String.format("unknown format (magic number %x)", magic));
        } 
        int flags = header[3];
        boolean hcrc = (flags & FHCRC) != 0;
        {
            crc.update(header, 0, header.length);
        } 
        {
            readFully(header, 0, 2);
            {
                crc.update(header, 0, 2);
            } 
            int length = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN) & 0xffff;
            {
                int max;
                max = buf.length;
                max = length;
                int result = in.read(buf, 0, max);
                {
                    if (DroidSafeAndroidRuntime.control) throw new EOFException();
                } 
                {
                    crc.update(buf, 0, result);
                } 
                length -= result;
            } 
        } 
        {
            readZeroTerminated(hcrc);
        } 
        {
            readZeroTerminated(hcrc);
        } 
        {
            readFully(header, 0, 2);
            short crc16 = Memory.peekShort(header, 0, ByteOrder.LITTLE_ENDIAN);
            {
                boolean varDF24CD4CC3CA4735CDB857FDC66AEAF5_1413582896 = ((short) crc.getValue() != crc16);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
                } 
            } 
            crc.reset();
        } 
        addTaint(is.getTaint());
        addTaint(size);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.788 -0400", hash_original_method = "BB5EB4821217BB73F8D521350E3FEC7B", hash_generated_method = "3F2B46524DBDCE46E7A36A9F327E3A4C")
    @Override
    public void close() throws IOException {
        eos = true;
        super.close();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.789 -0400", hash_original_method = "FAE53FCD1CA8F33ECA2437ABBFBE85CF", hash_generated_method = "8273FFE51AE7D32B4635965DC2BB75C4")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream is closed");
        } 
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        int bytesRead;
        try 
        {
            bytesRead = super.read(buffer, offset, byteCount);
        } 
        finally 
        {
            eos = eof;
        } 
        {
            crc.update(buffer, offset, bytesRead);
        } 
        {
            verifyCrc();
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746280206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746280206;
        
        
            
        
        
            
        
        
        
        
            
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.789 -0400", hash_original_method = "6D843C12482D0F9414C1006D7B90FFFD", hash_generated_method = "FF75768C88CCBD566EF6CADAC6B16710")
    private void verifyCrc() throws IOException {
        int size = inf.getRemaining();
        final int trailerSize = 8;
        byte[] b = new byte[trailerSize];
        int copySize;
        copySize = trailerSize;
        copySize = size;
        System.arraycopy(buf, len - size, b, 0, copySize);
        readFully(b, copySize, trailerSize - copySize);
        {
            boolean var5DF625EDF3B3FF5C7A985A745F01E054_1480759608 = (Memory.peekInt(b, 0, ByteOrder.LITTLE_ENDIAN) != (int) crc.getValue());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("CRC mismatch");
            } 
        } 
        {
            boolean varC3A7C64687DEFE6659EE053CD7A27F8C_198861377 = (Memory.peekInt(b, 4, ByteOrder.LITTLE_ENDIAN) != inf.getTotalOut());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Size mismatch");
            } 
        } 
        
        
        
        
        
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.790 -0400", hash_original_method = "9B3EB008D719ED0FB3E689755FC76BB5", hash_generated_method = "39B263928B24E71186845DEA0A6C04A9")
    private void readFully(byte[] buffer, int offset, int length) throws IOException {
        int result;
        {
            result = in.read(buffer, offset, length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } 
            offset += result;
            length -= result;
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        
        
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_method = "7C6B7FFA42529CFE943A1AC064CF5BC3", hash_generated_method = "123A0767FCBF2653C39E759409CDB1E2")
    private void readZeroTerminated(boolean hcrc) throws IOException {
        int result;
        {
            boolean var01CAA10F1466E17775B40DF9BACA8AE5_1878080818 = ((result = in.read()) > 0);
            {
                {
                    crc.update(result);
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        {
            crc.update(result);
        } 
        addTaint(hcrc);
        
        
        
            
                
            
        
        
            
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_field = "875720C110599DE52B9DC8CE6451C081", hash_generated_field = "02DDC74956F881D64CE1C7D6050C9F70")

    private static final int FCOMMENT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_field = "ADE4C8777B60E58CE08786BAB5CE86D5", hash_generated_field = "E75B8E4FDF02F0C7E68C62FE1BBF493F")

    private static final int FEXTRA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_field = "51F0D8B57181E4BEDBD79221D8779327", hash_generated_field = "390F1EF548C925A41577D8A8F438ADC9")

    private static final int FHCRC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_field = "B4B65558C09E945560CEE2A6095DF899", hash_generated_field = "BEF062C8719D26CFC454C2C6074500B1")

    private static final int FNAME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.791 -0400", hash_original_field = "5037AA396B919BA9517AC7C577F457C5", hash_generated_field = "EA43AF0273B6C3B8DADF1F68E7A59DEF")

    public static final int GZIP_MAGIC = 0x8b1f;
}

