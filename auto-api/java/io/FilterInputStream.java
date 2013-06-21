package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FilterInputStream extends InputStream {
    protected volatile InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.791 -0400", hash_original_method = "28F38498A0B180D5BCC888F2248F3934", hash_generated_method = "A51DC0C5D7AAF4B8B3A8B2C926B1E9BF")
    @DSModeled(DSC.SAFE)
    protected FilterInputStream(InputStream in) {
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "F9EF169CF0B6F8D5A5EF82E89A86B39A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_887442435 = (in.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "8853C25F592811C3C813B7E0334D3C5F", hash_generated_method = "9CF60855AD0CE7D671F0019EA0CE4A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        in.close();
        // ---------- Original Method ----------
        //in.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "C18065C3F91883FD1050B9CA534BFCAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        in.mark(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "EB69AE39380E1108523D38B42D9B3F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_1846686086 = (in.markSupported());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "E44784058F4742ED0C6AEE646C9728C1", hash_generated_method = "368C7A6D8F72F8384C1384F4D3FA2B65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var2EE2703F88097027B4DEA42C13801E06_1908728730 = (in.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "77ABDF7CA6BAECB9E04E38AE745E4AA8", hash_generated_method = "A8AF9BC50AFC79AD8C2B144365266340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        int var6FC718818B0D5A7441A370022FEAAC33_1357837747 = (in.read(buffer, offset, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.792 -0400", hash_original_method = "61478AA9F56747991020142C67580FB8", hash_generated_method = "9EDBB723B02439FE9CA3EA9025D627E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        // ---------- Original Method ----------
        //in.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.793 -0400", hash_original_method = "871C50CABEA9E636393963333B4BFE2A", hash_generated_method = "FCE6C5B89EE85B9AA56C33EC764AF516")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long varF2B1178A12E2ADBBBFD1911F8D622366_2091066613 = (in.skip(byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return in.skip(byteCount);
    }

    
}

