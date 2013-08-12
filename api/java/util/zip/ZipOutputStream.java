package java.util.zip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charsets;
import java.util.ArrayList;
import java.util.Arrays;



public class ZipOutputStream extends DeflaterOutputStream implements ZipConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "3ED42D4B537F5FDB36FDF1EA0D6B44D6")

    private String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "2CAA0B6325B62EA69BDA2672691560D2", hash_generated_field = "FCD66FA4768DC8FA4CD3A9CC1267729C")

    private final ArrayList<String> entries = new ArrayList<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "36170D98737C2D16F4C7B05D2F5FB8DD", hash_generated_field = "E346083B375866BE2A4C0EAFE5E7BD2C")

    private int compressMethod = DEFLATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "85EABC2C6429E6FB7D40245EF8F4DDEA", hash_generated_field = "62D95194EDF4CD5AF603C678BBE8005F")

    private int compressLevel = Deflater.DEFAULT_COMPRESSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "199705789358F3C77C84369F88669347", hash_generated_field = "C96530FB5377271C1898F50B375B5BBD")

    private ByteArrayOutputStream cDir = new ByteArrayOutputStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "99BA38A3E6B2466208E2D2433FB7C05C", hash_generated_field = "FAD8DD5A4D43550551E80B6E823A3546")

    private ZipEntry currentEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.854 -0400", hash_original_field = "7261E76873EC00F13387C2BADC428359", hash_generated_field = "05500ADE9A7CD6E53D52A131B8F3E602")

    private final CRC32 crc = new CRC32();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "724EB7AA080C9DB92A724877C069F566")

    private int offset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "0C9D69CB336285B27A073DBF36A55063", hash_generated_field = "78E3728F7EB982C6341A9332E0F24622")

    private int curOffset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "670188D389D8410371BBA9B7E3605CFF", hash_generated_field = "74943DB2321A5915CA10DA328ADE45C0")

    private int nameLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "4CF39501033089E9762896A8FD696630", hash_generated_field = "C02803E2C735C9AD9F5E84CD57AB59E3")

    private byte[] nameBytes;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_method = "8A42A56E156B97294BE7CC83201EADCF", hash_generated_method = "9DA8DBBF060B4EA1BE2288B1965532A2")
    public  ZipOutputStream(OutputStream p1) {
        super(p1, new Deflater(Deflater.DEFAULT_COMPRESSION, true));
        addTaint(p1.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_method = "96C568DC9FCDB3D53590F6DD994D0456", hash_generated_method = "33C706BBF950AD9EA0D70E9C4604CBBB")
    @Override
    public void close() throws IOException {
        if(out != null)        
        {
            finish();
            def.end();
            out.close();
            out = null;
        } //End block
        // ---------- Original Method ----------
        //if (out != null) {
            //finish();
            //def.end();
            //out.close();
            //out = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.859 -0400", hash_original_method = "7ED55E9CAB55F4762479C264D19A0A1A", hash_generated_method = "0E2A294E84F37303FE675BC6C7CAA097")
    public void closeEntry() throws IOException {
        checkClosed();
        if(currentEntry == null)        
        {
            return;
        } //End block
        if(currentEntry.getMethod() == DEFLATED)        
        {
            super.finish();
        } //End block
        if(currentEntry.getMethod() == STORED)        
        {
            if(crc.getValue() != currentEntry.crc)            
            {
                ZipException var5801A1671C74CAA3F440CFA906EB0647_293782066 = new ZipException("CRC mismatch");
                var5801A1671C74CAA3F440CFA906EB0647_293782066.addTaint(taint);
                throw var5801A1671C74CAA3F440CFA906EB0647_293782066;
            } //End block
            if(currentEntry.size != crc.tbytes)            
            {
                ZipException var0B43C0F4381198EAF33558883E27DC84_1989009055 = new ZipException("Size mismatch");
                var0B43C0F4381198EAF33558883E27DC84_1989009055.addTaint(taint);
                throw var0B43C0F4381198EAF33558883E27DC84_1989009055;
            } //End block
        } //End block
        curOffset = LOCHDR;
        if(currentEntry.getMethod() != STORED)        
        {
            curOffset += EXTHDR;
            writeLong(out, EXTSIG);
            writeLong(out, currentEntry.crc = crc.getValue());
            writeLong(out, currentEntry.compressedSize = def.getTotalOut());
            writeLong(out, currentEntry.size = def.getTotalIn());
        } //End block
        int flags = currentEntry.getMethod() == STORED ? 0 : ZipFile.GPBF_DATA_DESCRIPTOR_FLAG;
        flags |= ZipFile.GPBF_UTF8_FLAG;
        writeLong(cDir, CENSIG);
        writeShort(cDir, ZIPLocalHeaderVersionNeeded);
        writeShort(cDir, ZIPLocalHeaderVersionNeeded);
        writeShort(cDir, flags);
        writeShort(cDir, currentEntry.getMethod());
        writeShort(cDir, currentEntry.time);
        writeShort(cDir, currentEntry.modDate);
        writeLong(cDir, crc.getValue());
        if(currentEntry.getMethod() == DEFLATED)        
        {
            curOffset += writeLong(cDir, def.getTotalOut());
            writeLong(cDir, def.getTotalIn());
        } //End block
        else
        {
            curOffset += writeLong(cDir, crc.tbytes);
            writeLong(cDir, crc.tbytes);
        } //End block
        curOffset += writeShort(cDir, nameLength);
        if(currentEntry.extra != null)        
        {
            curOffset += writeShort(cDir, currentEntry.extra.length);
        } //End block
        else
        {
            writeShort(cDir, 0);
        } //End block
        String c;
        if((c = currentEntry.getComment()) != null)        
        {
            writeShort(cDir, c.length());
        } //End block
        else
        {
            writeShort(cDir, 0);
        } //End block
        writeShort(cDir, 0);
        writeShort(cDir, 0);
        writeLong(cDir, 0);
        writeLong(cDir, offset);
        cDir.write(nameBytes);
        nameBytes = null;
        if(currentEntry.extra != null)        
        {
            cDir.write(currentEntry.extra);
        } //End block
        offset += curOffset;
        if(c != null)        
        {
            cDir.write(c.getBytes());
        } //End block
        currentEntry = null;
        crc.reset();
        def.reset();
        done = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.863 -0400", hash_original_method = "999AC26E5377CA180C9B394D52C82ED1", hash_generated_method = "BF24A98E5589A82A11047784223EBA7A")
    @Override
    public void finish() throws IOException {
        if(out == null)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_144788245 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_144788245.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_144788245;
        } //End block
        if(cDir == null)        
        {
            return;
        } //End block
        if(entries.isEmpty())        
        {
            ZipException varFAED705AFA14B41755EC3F614BA7DF17_1504717661 = new ZipException("No entries");
            varFAED705AFA14B41755EC3F614BA7DF17_1504717661.addTaint(taint);
            throw varFAED705AFA14B41755EC3F614BA7DF17_1504717661;
        } //End block
        if(currentEntry != null)        
        {
            closeEntry();
        } //End block
        int cdirSize = cDir.size();
        writeLong(cDir, ENDSIG);
        writeShort(cDir, 0);
        writeShort(cDir, 0);
        writeShort(cDir, entries.size());
        writeShort(cDir, entries.size());
        writeLong(cDir, cdirSize);
        writeLong(cDir, offset);
        if(comment != null)        
        {
            writeShort(cDir, comment.length());
            cDir.write(comment.getBytes());
        } //End block
        else
        {
            writeShort(cDir, 0);
        } //End block
        out.write(cDir.toByteArray());
        cDir = null;
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new IOException("Stream is closed");
        //}
        //if (cDir == null) {
            //return;
        //}
        //if (entries.isEmpty()) {
            //throw new ZipException("No entries");
        //}
        //if (currentEntry != null) {
            //closeEntry();
        //}
        //int cdirSize = cDir.size();
        //writeLong(cDir, ENDSIG);
        //writeShort(cDir, 0);
        //writeShort(cDir, 0);
        //writeShort(cDir, entries.size());
        //writeShort(cDir, entries.size());
        //writeLong(cDir, cdirSize);
        //writeLong(cDir, offset);
        //if (comment != null) {
            //writeShort(cDir, comment.length());
            //cDir.write(comment.getBytes());
        //} else {
            //writeShort(cDir, 0);
        //}
        //out.write(cDir.toByteArray());
        //cDir = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.865 -0400", hash_original_method = "B67EF5B3649AC60448D5855D166716A9", hash_generated_method = "A2EFD3E4D7E09D5B4C4CB7F2B69180BA")
    public void putNextEntry(ZipEntry ze) throws IOException {
        if(currentEntry != null)        
        {
            closeEntry();
        } //End block
        if(ze.getMethod() == STORED || (compressMethod == STORED && ze.getMethod() == -1))        
        {
            if(ze.crc == -1)            
            {
                ZipException var5801A1671C74CAA3F440CFA906EB0647_59625757 = new ZipException("CRC mismatch");
                var5801A1671C74CAA3F440CFA906EB0647_59625757.addTaint(taint);
                throw var5801A1671C74CAA3F440CFA906EB0647_59625757;
            } //End block
            if(ze.size == -1 && ze.compressedSize == -1)            
            {
                ZipException var0B43C0F4381198EAF33558883E27DC84_1858945661 = new ZipException("Size mismatch");
                var0B43C0F4381198EAF33558883E27DC84_1858945661.addTaint(taint);
                throw var0B43C0F4381198EAF33558883E27DC84_1858945661;
            } //End block
            if(ze.size != ze.compressedSize && ze.compressedSize != -1 && ze.size != -1)            
            {
                ZipException var0B43C0F4381198EAF33558883E27DC84_1532673722 = new ZipException("Size mismatch");
                var0B43C0F4381198EAF33558883E27DC84_1532673722.addTaint(taint);
                throw var0B43C0F4381198EAF33558883E27DC84_1532673722;
            } //End block
        } //End block
        checkClosed();
        if(entries.contains(ze.name))        
        {
            ZipException var74DC6BAD2DE6ECF9388F786A2BE54260_1244639458 = new ZipException("Entry already exists: " + ze.name);
            var74DC6BAD2DE6ECF9388F786A2BE54260_1244639458.addTaint(taint);
            throw var74DC6BAD2DE6ECF9388F786A2BE54260_1244639458;
        } //End block
        nameBytes = ze.name.getBytes(Charsets.UTF_8);
        nameLength = nameBytes.length;
        if(nameLength > 0xffff)        
        {
            IllegalArgumentException var79CF5EFB8B9ACEF9A1263BDC7878E97B_337373934 = new IllegalArgumentException("Name too long: " + nameLength + " UTF-8 bytes");
            var79CF5EFB8B9ACEF9A1263BDC7878E97B_337373934.addTaint(taint);
            throw var79CF5EFB8B9ACEF9A1263BDC7878E97B_337373934;
        } //End block
        def.setLevel(compressLevel);
        currentEntry = ze;
        entries.add(currentEntry.name);
        if(currentEntry.getMethod() == -1)        
        {
            currentEntry.setMethod(compressMethod);
        } //End block
        int flags = currentEntry.getMethod() == STORED ? 0 : ZipFile.GPBF_DATA_DESCRIPTOR_FLAG;
        flags |= ZipFile.GPBF_UTF8_FLAG;
        writeLong(out, LOCSIG);
        writeShort(out, ZIPLocalHeaderVersionNeeded);
        writeShort(out, flags);
        writeShort(out, currentEntry.getMethod());
        if(currentEntry.getTime() == -1)        
        {
            currentEntry.setTime(System.currentTimeMillis());
        } //End block
        writeShort(out, currentEntry.time);
        writeShort(out, currentEntry.modDate);
        if(currentEntry.getMethod() == STORED)        
        {
            if(currentEntry.size == -1)            
            {
                currentEntry.size = currentEntry.compressedSize;
            } //End block
            else
            if(currentEntry.compressedSize == -1)            
            {
                currentEntry.compressedSize = currentEntry.size;
            } //End block
            writeLong(out, currentEntry.crc);
            writeLong(out, currentEntry.size);
            writeLong(out, currentEntry.size);
        } //End block
        else
        {
            writeLong(out, 0);
            writeLong(out, 0);
            writeLong(out, 0);
        } //End block
        writeShort(out, nameLength);
        if(currentEntry.extra != null)        
        {
            writeShort(out, currentEntry.extra.length);
        } //End block
        else
        {
            writeShort(out, 0);
        } //End block
        out.write(nameBytes);
        if(currentEntry.extra != null)        
        {
            out.write(currentEntry.extra);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.867 -0400", hash_original_method = "26F6FBE233DD91F24B7F1E6618FAB1E0", hash_generated_method = "1C2DF00E99D3D9ABCAF2FD14EAAF3270")
    public void setComment(String comment) {
        if(comment.length() > 0xFFFF)        
        {
            IllegalArgumentException var97B9599BED78D60C8CE387F05581A040_1701231154 = new IllegalArgumentException("Comment too long: " + comment.length() + " characters");
            var97B9599BED78D60C8CE387F05581A040_1701231154.addTaint(taint);
            throw var97B9599BED78D60C8CE387F05581A040_1701231154;
        } //End block
        this.comment = comment;
        // ---------- Original Method ----------
        //if (comment.length() > 0xFFFF) {
            //throw new IllegalArgumentException("Comment too long: " + comment.length() + " characters");
        //}
        //this.comment = comment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.867 -0400", hash_original_method = "E1ADAA90D59796919F5AECC9DBBFDE9F", hash_generated_method = "D65E43D26757AF4DB8A52543436BAD5F")
    public void setLevel(int level) {
        if(level < Deflater.DEFAULT_COMPRESSION || level > Deflater.BEST_COMPRESSION)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_392748350 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_392748350.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_392748350;
        } //End block
        compressLevel = level;
        // ---------- Original Method ----------
        //if (level < Deflater.DEFAULT_COMPRESSION || level > Deflater.BEST_COMPRESSION) {
            //throw new IllegalArgumentException();
        //}
        //compressLevel = level;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.867 -0400", hash_original_method = "6F0DCE9ECB2E8D251D145F7781DE410D", hash_generated_method = "C29CF4F5E15CCFD9E01C8B9055D559C6")
    public void setMethod(int method) {
        if(method != STORED && method != DEFLATED)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1109944164 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1109944164.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1109944164;
        } //End block
        compressMethod = method;
        // ---------- Original Method ----------
        //if (method != STORED && method != DEFLATED) {
            //throw new IllegalArgumentException();
        //}
        //compressMethod = method;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.868 -0400", hash_original_method = "DBE9EE31F55A33C252870BC7FED94C64", hash_generated_method = "BE2D4082734726D6F395801B8C61ECA9")
    private long writeLong(OutputStream os, long i) throws IOException {
        addTaint(i);
        addTaint(os.getTaint());
        os.write((int) (i & 0xFF));
        os.write((int) (i >> 8) & 0xFF);
        os.write((int) (i >> 16) & 0xFF);
        os.write((int) (i >> 24) & 0xFF);
        long var865C0C0B4AB0E063E5CAA3387C1A8741_1941596166 = (i);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2038000664 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2038000664;
        // ---------- Original Method ----------
        //os.write((int) (i & 0xFF));
        //os.write((int) (i >> 8) & 0xFF);
        //os.write((int) (i >> 16) & 0xFF);
        //os.write((int) (i >> 24) & 0xFF);
        //return i;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.868 -0400", hash_original_method = "1DFA02CC93F18F84127269F34641BCA1", hash_generated_method = "668184DFDC7C729590469F6A357811BD")
    private int writeShort(OutputStream os, int i) throws IOException {
        addTaint(i);
        addTaint(os.getTaint());
        os.write(i & 0xFF);
        os.write((i >> 8) & 0xFF);
        int var865C0C0B4AB0E063E5CAA3387C1A8741_319160496 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45959025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45959025;
        // ---------- Original Method ----------
        //os.write(i & 0xFF);
        //os.write((i >> 8) & 0xFF);
        //return i;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.869 -0400", hash_original_method = "F9EBE9ED855C5E2014EA6CAF53F89130", hash_generated_method = "702975D30E03D1A386EF0C196D75146A")
    @Override
    public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if(currentEntry == null)        
        {
            ZipException var0CCF8A825234F729D7FF80919A068231_2047894337 = new ZipException("No active entry");
            var0CCF8A825234F729D7FF80919A068231_2047894337.addTaint(taint);
            throw var0CCF8A825234F729D7FF80919A068231_2047894337;
        } //End block
        if(currentEntry.getMethod() == STORED)        
        {
            out.write(buffer, offset, byteCount);
        } //End block
        else
        {
            super.write(buffer, offset, byteCount);
        } //End block
        crc.update(buffer, offset, byteCount);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        //if (currentEntry == null) {
            //throw new ZipException("No active entry");
        //}
        //if (currentEntry.getMethod() == STORED) {
            //out.write(buffer, offset, byteCount);
        //} else {
            //super.write(buffer, offset, byteCount);
        //}
        //crc.update(buffer, offset, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.870 -0400", hash_original_method = "D282356A3A75F4936D2E72EF1631ED03", hash_generated_method = "F227F98F6D44388CF627C652E594CC40")
    private void checkClosed() throws IOException {
        if(cDir == null)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1055278188 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1055278188.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1055278188;
        } //End block
        // ---------- Original Method ----------
        //if (cDir == null) {
            //throw new IOException("Stream is closed");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.870 -0400", hash_original_field = "869069D8A539375615C84E9AABE70433", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.870 -0400", hash_original_field = "892931149BD1D6C244D3C42F2AB305A9", hash_generated_field = "C303454481B8041CEF37C1E89A2E0D63")

    public static final int STORED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.870 -0400", hash_original_field = "2F83A1740381FFA7CCDAEAFBC93BC7F9", hash_generated_field = "C7C4508444B1DF1FC0028548D38411C2")

    private static final int ZIPLocalHeaderVersionNeeded = 20;
}

