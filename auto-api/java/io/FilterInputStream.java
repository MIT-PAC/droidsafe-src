package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FilterInputStream extends InputStream {
    protected volatile InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "28F38498A0B180D5BCC888F2248F3934", hash_generated_method = "217574B848E8CE2EC0A0DA5549E1F5E9")
    @DSModeled(DSC.SAFE)
    protected FilterInputStream(InputStream in) {
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "7E51A40DF029D06D1996291A56C72BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_789824442 = (in.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "8853C25F592811C3C813B7E0334D3C5F", hash_generated_method = "E637571D344ABCCBBFFAB0285602FC43")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        in.close();
        // ---------- Original Method ----------
        //in.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "0A1F2816C83E9ED2BE1731933E518334")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        in.mark(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "9621B5C0E02D71774272253F3B404290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_2042436683 = (in.markSupported());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "E44784058F4742ED0C6AEE646C9728C1", hash_generated_method = "91E2478A0847102D638F2FF0F56E98A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var2EE2703F88097027B4DEA42C13801E06_1026847300 = (in.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "77ABDF7CA6BAECB9E04E38AE745E4AA8", hash_generated_method = "EF5DFE617D1E2BB003F4CFB496CE412F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        int var6FC718818B0D5A7441A370022FEAAC33_1477717476 = (in.read(buffer, offset, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "61478AA9F56747991020142C67580FB8", hash_generated_method = "9BA274CF4983A328A09B19513F865F39")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        // ---------- Original Method ----------
        //in.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.464 -0400", hash_original_method = "871C50CABEA9E636393963333B4BFE2A", hash_generated_method = "AE752B547241CCF71D2DEEE9ECC26A9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long varF2B1178A12E2ADBBBFD1911F8D622366_1698370320 = (in.skip(byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return in.skip(byteCount);
    }

    
}


