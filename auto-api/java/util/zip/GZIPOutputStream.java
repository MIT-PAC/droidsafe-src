package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class GZIPOutputStream extends DeflaterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.727 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.728 -0400", hash_original_method = "2B29886F93DAD97985C1121E7A12F1EB", hash_generated_method = "2C8E2856AF17712C73783E1CB392984F")
    public  GZIPOutputStream(OutputStream os) throws IOException {
        this(os, BUF_SIZE);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.729 -0400", hash_original_method = "982A9C109F13C35696C1D1D71982D2AE", hash_generated_method = "B59C79784BD32DCA1655D9DE0AC61284")
    public  GZIPOutputStream(OutputStream os, int size) throws IOException {
        super(os, new Deflater(Deflater.DEFAULT_COMPRESSION, true), size);
        writeShort(GZIPInputStream.GZIP_MAGIC);
        out.write(Deflater.DEFLATED);
        out.write(0);
        writeLong(0);
        out.write(0);
        out.write(0);
        addTaint(os.getTaint());
        addTaint(size);
        // ---------- Original Method ----------
        //writeShort(GZIPInputStream.GZIP_MAGIC);
        //out.write(Deflater.DEFLATED);
        //out.write(0);
        //writeLong(0);
        //out.write(0);
        //out.write(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.730 -0400", hash_original_method = "A3CDE33229CB27B38C3E63AFF1767104", hash_generated_method = "95D7B90BAC733768098DE346D405FB64")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.731 -0400", hash_original_method = "3845FBBF6C0965A8BD527CE35C72F9CE", hash_generated_method = "74C9003C407138A138A4798E27C19037")
    @Override
    public void write(byte[] buffer, int off, int nbytes) throws IOException {
        super.write(buffer, off, nbytes);
        crc.update(buffer, off, nbytes);
        addTaint(buffer[0]);
        addTaint(off);
        addTaint(nbytes);
        // ---------- Original Method ----------
        //super.write(buffer, off, nbytes);
        //crc.update(buffer, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.740 -0400", hash_original_method = "47F39FA28854367E1C176B836238D964", hash_generated_method = "BC16CF022783A7CE14E85889C6BBE351")
    private long writeLong(long i) throws IOException {
        int unsigned;
        unsigned = (int) i;
        out.write(unsigned & 0xFF);
        out.write((unsigned >> 8) & 0xFF);
        out.write((unsigned >> 16) & 0xFF);
        out.write((unsigned >> 24) & 0xFF);
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_320644326 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_320644326;
        // ---------- Original Method ----------
        //int unsigned = (int) i;
        //out.write(unsigned & 0xFF);
        //out.write((unsigned >> 8) & 0xFF);
        //out.write((unsigned >> 16) & 0xFF);
        //out.write((unsigned >> 24) & 0xFF);
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.749 -0400", hash_original_method = "22B8B662F709BB8BFEF4CD6C31753D50", hash_generated_method = "A8E563B4336556289E1F253D3A4A1665")
    private int writeShort(int i) throws IOException {
        out.write(i & 0xFF);
        out.write((i >> 8) & 0xFF);
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629226596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629226596;
        // ---------- Original Method ----------
        //out.write(i & 0xFF);
        //out.write((i >> 8) & 0xFF);
        //return i;
    }

    
}

