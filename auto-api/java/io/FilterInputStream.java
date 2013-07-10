package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class FilterInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.000 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "6D3D0ED73C3C0D0A9AF6A684E0D210F5")

    protected volatile InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.000 -0400", hash_original_method = "28F38498A0B180D5BCC888F2248F3934", hash_generated_method = "5A27BC4A52A8F095F38D366D78918442")
    protected  FilterInputStream(InputStream in) {
        this.in = in;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.001 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "93FBF65E21EBA5F20F77C576A6724CDA")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_456835006 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310902594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310902594;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.001 -0400", hash_original_method = "8853C25F592811C3C813B7E0334D3C5F", hash_generated_method = "9CF60855AD0CE7D671F0019EA0CE4A52")
    @Override
    public void close() throws IOException {
        in.close();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.001 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "AA053874BBA26ECE7C7BFC30340E292E")
    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        addTaint(readlimit);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.001 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "6EADE09BE06C0DA82E57D8BC45486269")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_1743906732 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734644321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734644321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.002 -0400", hash_original_method = "E44784058F4742ED0C6AEE646C9728C1", hash_generated_method = "DB2F8492663840AB1D0C21A1C5C8BD99")
    @Override
    public int read() throws IOException {
        int var2EE2703F88097027B4DEA42C13801E06_240800812 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119169025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119169025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.002 -0400", hash_original_method = "77ABDF7CA6BAECB9E04E38AE745E4AA8", hash_generated_method = "B0CCA6528AE191E282A6E3700B2B4B55")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        int var6FC718818B0D5A7441A370022FEAAC33_665860521 = (in.read(buffer, offset, count));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25591996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25591996;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.002 -0400", hash_original_method = "61478AA9F56747991020142C67580FB8", hash_generated_method = "9EDBB723B02439FE9CA3EA9025D627E0")
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.002 -0400", hash_original_method = "871C50CABEA9E636393963333B4BFE2A", hash_generated_method = "C70074D913314405A6DEB76159B778F4")
    @Override
    public long skip(long byteCount) throws IOException {
        long varF2B1178A12E2ADBBBFD1911F8D622366_721650476 = (in.skip(byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_604228792 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_604228792;
        
        
    }

    
}

