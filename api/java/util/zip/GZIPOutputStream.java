package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;

public class GZIPOutputStream extends DeflaterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.623 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.624 -0400", hash_original_method = "2B29886F93DAD97985C1121E7A12F1EB", hash_generated_method = "2C8E2856AF17712C73783E1CB392984F")
    public  GZIPOutputStream(OutputStream os) throws IOException {
        this(os, BUF_SIZE);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.624 -0400", hash_original_method = "982A9C109F13C35696C1D1D71982D2AE", hash_generated_method = "2EE2C02EF9F1C4F917DF133ECA746245")
    public  GZIPOutputStream(OutputStream os, int size) throws IOException {
        super(os, new Deflater(Deflater.DEFAULT_COMPRESSION, true), size);
        addTaint(size);
        addTaint(os.getTaint());
        writeShort(GZIPInputStream.GZIP_MAGIC);
        out.write(Deflater.DEFLATED);
        out.write(0);
        writeLong(0);
        out.write(0);
        out.write(0);
        // ---------- Original Method ----------
        //writeShort(GZIPInputStream.GZIP_MAGIC);
        //out.write(Deflater.DEFLATED);
        //out.write(0);
        //writeLong(0);
        //out.write(0);
        //out.write(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.625 -0400", hash_original_method = "A3CDE33229CB27B38C3E63AFF1767104", hash_generated_method = "95D7B90BAC733768098DE346D405FB64")
    @Override
    public void finish() throws IOException {
        super.finish();
        writeLong(crc.getValue());
        writeLong(crc.tbytes);
        // ---------- Original Method ----------
        //super.finish();
        //writeLong(crc.getValue());
        //writeLong(crc.tbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.625 -0400", hash_original_method = "3845FBBF6C0965A8BD527CE35C72F9CE", hash_generated_method = "2469851F7C9AD1BFC1913AD50D1248F9")
    @Override
    public void write(byte[] buffer, int off, int nbytes) throws IOException {
        addTaint(nbytes);
        addTaint(off);
        addTaint(buffer[0]);
        super.write(buffer, off, nbytes);
        crc.update(buffer, off, nbytes);
        // ---------- Original Method ----------
        //super.write(buffer, off, nbytes);
        //crc.update(buffer, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.626 -0400", hash_original_method = "47F39FA28854367E1C176B836238D964", hash_generated_method = "9A7650F54A1E1714B0B6595F858B8D60")
    private long writeLong(long i) throws IOException {
        addTaint(i);
        int unsigned = (int) i;
        out.write(unsigned & 0xFF);
        out.write((unsigned >> 8) & 0xFF);
        out.write((unsigned >> 16) & 0xFF);
        out.write((unsigned >> 24) & 0xFF);
        long var865C0C0B4AB0E063E5CAA3387C1A8741_332616399 = (i);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_195741700 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_195741700;
        // ---------- Original Method ----------
        //int unsigned = (int) i;
        //out.write(unsigned & 0xFF);
        //out.write((unsigned >> 8) & 0xFF);
        //out.write((unsigned >> 16) & 0xFF);
        //out.write((unsigned >> 24) & 0xFF);
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.626 -0400", hash_original_method = "22B8B662F709BB8BFEF4CD6C31753D50", hash_generated_method = "B9997233F9A1678FBB88C27AB140FBDA")
    private int writeShort(int i) throws IOException {
        addTaint(i);
        out.write(i & 0xFF);
        out.write((i >> 8) & 0xFF);
        int var865C0C0B4AB0E063E5CAA3387C1A8741_1851771549 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808986820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808986820;
        // ---------- Original Method ----------
        //out.write(i & 0xFF);
        //out.write((i >> 8) & 0xFF);
        //return i;
    }

    
}

