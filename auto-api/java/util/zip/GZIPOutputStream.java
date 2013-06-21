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
    protected CRC32 crc = new CRC32();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.758 -0400", hash_original_method = "2B29886F93DAD97985C1121E7A12F1EB", hash_generated_method = "EE13DB16ECC31BC465EB103384412554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GZIPOutputStream(OutputStream os) throws IOException {
        this(os, BUF_SIZE);
        dsTaint.addTaint(os.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.758 -0400", hash_original_method = "982A9C109F13C35696C1D1D71982D2AE", hash_generated_method = "2F3904201B0AEE2298937C1BC81AF4C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GZIPOutputStream(OutputStream os, int size) throws IOException {
        super(os, new Deflater(Deflater.DEFAULT_COMPRESSION, true), size);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.758 -0400", hash_original_method = "A3CDE33229CB27B38C3E63AFF1767104", hash_generated_method = "95D7B90BAC733768098DE346D405FB64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.759 -0400", hash_original_method = "3845FBBF6C0965A8BD527CE35C72F9CE", hash_generated_method = "5076D1248B09B96FFCEBE5BE589508CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int off, int nbytes) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(nbytes);
        dsTaint.addTaint(off);
        super.write(buffer, off, nbytes);
        crc.update(buffer, off, nbytes);
        // ---------- Original Method ----------
        //super.write(buffer, off, nbytes);
        //crc.update(buffer, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.759 -0400", hash_original_method = "47F39FA28854367E1C176B836238D964", hash_generated_method = "AB6FBA45D7BAFEFF53A93C4C21342E9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long writeLong(long i) throws IOException {
        dsTaint.addTaint(i);
        int unsigned;
        unsigned = (int) i;
        out.write(unsigned & 0xFF);
        out.write((unsigned >> 8) & 0xFF);
        out.write((unsigned >> 16) & 0xFF);
        out.write((unsigned >> 24) & 0xFF);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //int unsigned = (int) i;
        //out.write(unsigned & 0xFF);
        //out.write((unsigned >> 8) & 0xFF);
        //out.write((unsigned >> 16) & 0xFF);
        //out.write((unsigned >> 24) & 0xFF);
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.759 -0400", hash_original_method = "22B8B662F709BB8BFEF4CD6C31753D50", hash_generated_method = "BDA460CA20F985CB6190330A1F5999CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeShort(int i) throws IOException {
        dsTaint.addTaint(i);
        out.write(i & 0xFF);
        out.write((i >> 8) & 0xFF);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //out.write(i & 0xFF);
        //out.write((i >> 8) & 0xFF);
        //return i;
    }

    
}

