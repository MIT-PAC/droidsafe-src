package java.io;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class FilterInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.981 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "6D3D0ED73C3C0D0A9AF6A684E0D210F5")

    protected volatile InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.981 -0400", hash_original_method = "28F38498A0B180D5BCC888F2248F3934", hash_generated_method = "5A27BC4A52A8F095F38D366D78918442")
    protected  FilterInputStream(InputStream in) {
        this.in = in;
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.981 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "14B5D4493E92C9E3A2E4B5103B70FD6A")
    @Override
    public int available() throws IOException {
        int var443A4CD22A314221356D4EA83AFE1E61_877972787 = (in.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465929403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465929403;
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.982 -0400", hash_original_method = "8853C25F592811C3C813B7E0334D3C5F", hash_generated_method = "9CF60855AD0CE7D671F0019EA0CE4A52")
    @Override
    public void close() throws IOException {
        in.close();
        // ---------- Original Method ----------
        //in.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.982 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "F56924027E62E4D2B8F7633C4CCD626A")
    @Override
    public synchronized void mark(int readlimit) {
        addTaint(readlimit);
        in.mark(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.982 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "00F2A93EE923A08DB5E375A6405104F1")
    @Override
    public boolean markSupported() {
        boolean var92424DC7E92354A95936078BD657F7DC_1390901070 = (in.markSupported());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964026654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_964026654;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.983 -0400", hash_original_method = "E44784058F4742ED0C6AEE646C9728C1", hash_generated_method = "F19EBFE81BE6E79884387D56951EDD14")
    @Override
    public int read() throws IOException {
        int varC746AA2461228F1337791E992A2C4661_527843226 = (in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187745222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187745222;
        // ---------- Original Method ----------
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.983 -0400", hash_original_method = "77ABDF7CA6BAECB9E04E38AE745E4AA8", hash_generated_method = "2B108C8ACE67D66B28D62885BAE02134")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        int var16B8A5ED779D2972EF4A24F254214E3B_1945178515 = (in.read(buffer, offset, count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710163731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710163731;
        // ---------- Original Method ----------
        //return in.read(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.984 -0400", hash_original_method = "61478AA9F56747991020142C67580FB8", hash_generated_method = "9EDBB723B02439FE9CA3EA9025D627E0")
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        // ---------- Original Method ----------
        //in.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.984 -0400", hash_original_method = "871C50CABEA9E636393963333B4BFE2A", hash_generated_method = "CC9F33999CE93ECD6D82AEF98A295198")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        long varEBA3748D4ACE0E943E64A9E07D224ABB_1626742347 = (in.skip(byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1905651770 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1905651770;
        // ---------- Original Method ----------
        //return in.skip(byteCount);
    }

    
}

