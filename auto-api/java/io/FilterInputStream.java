package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FilterInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.921 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "6D3D0ED73C3C0D0A9AF6A684E0D210F5")

    protected volatile InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.931 -0400", hash_original_method = "28F38498A0B180D5BCC888F2248F3934", hash_generated_method = "5A27BC4A52A8F095F38D366D78918442")
    protected  FilterInputStream(InputStream in) {
        this.in = in;
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.932 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "EAF050578CFC6F5D2049230BA4A77378")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_1421354606 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962251249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962251249;
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.932 -0400", hash_original_method = "8853C25F592811C3C813B7E0334D3C5F", hash_generated_method = "9CF60855AD0CE7D671F0019EA0CE4A52")
    @Override
    public void close() throws IOException {
        in.close();
        // ---------- Original Method ----------
        //in.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.932 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "AA053874BBA26ECE7C7BFC30340E292E")
    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        addTaint(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.932 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "5DA7340A9D851D5C3AC838013C199CF1")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_581577626 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743009478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743009478;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.933 -0400", hash_original_method = "E44784058F4742ED0C6AEE646C9728C1", hash_generated_method = "5F3E0D6BC0A23399A2C4300A5D020D45")
    @Override
    public int read() throws IOException {
        int var2EE2703F88097027B4DEA42C13801E06_1805565904 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979916421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979916421;
        // ---------- Original Method ----------
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.933 -0400", hash_original_method = "77ABDF7CA6BAECB9E04E38AE745E4AA8", hash_generated_method = "ED3EDE5048DCD99E6D12BF29516446A9")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        int var6FC718818B0D5A7441A370022FEAAC33_1287864546 = (in.read(buffer, offset, count));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636110220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636110220;
        // ---------- Original Method ----------
        //return in.read(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.933 -0400", hash_original_method = "61478AA9F56747991020142C67580FB8", hash_generated_method = "9EDBB723B02439FE9CA3EA9025D627E0")
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        // ---------- Original Method ----------
        //in.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.934 -0400", hash_original_method = "871C50CABEA9E636393963333B4BFE2A", hash_generated_method = "2CB948F4842C23BD3770B141A1AA24C8")
    @Override
    public long skip(long byteCount) throws IOException {
        long varF2B1178A12E2ADBBBFD1911F8D622366_1881651273 = (in.skip(byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_896561688 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_896561688;
        // ---------- Original Method ----------
        //return in.skip(byteCount);
    }

    
}

