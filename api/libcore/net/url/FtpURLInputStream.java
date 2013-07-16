package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import libcore.io.IoUtils;

class FtpURLInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.007 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.007 -0400", hash_original_field = "62CE5FD8E6BD8C916853B8B84063B5BC", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")

    private Socket controlSocket;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.008 -0400", hash_original_method = "826919C06E887B63574F8C2AA9021EA4", hash_generated_method = "AE5139D29BF3056C3C33DA54DF2C377C")
    public  FtpURLInputStream(InputStream is, Socket controlSocket) {
        this.is = is;
        this.controlSocket = controlSocket;
        // ---------- Original Method ----------
        //this.is = is;
        //this.controlSocket = controlSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.008 -0400", hash_original_method = "7CE2C444F0201136E21AAFE741F28564", hash_generated_method = "BA39F1ECC14347D7929DF0ECAF051997")
    @Override
    public int read() throws IOException {
        int var938BFE1E2B1B866EF0C17C516F788BB6_1705935129 = (is.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123655000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123655000;
        // ---------- Original Method ----------
        //return is.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.009 -0400", hash_original_method = "67E478B38D83ABBBB81FEA8967B3C884", hash_generated_method = "EA490670618D914D268F37DCB10753E9")
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        addTaint(nbytes);
        addTaint(off);
        addTaint(buf[0]);
        int var7D2DE23E9BAED244DAE0532C0F58B292_1804164385 = (is.read(buf, off, nbytes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832112941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832112941;
        // ---------- Original Method ----------
        //return is.read(buf, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.009 -0400", hash_original_method = "89E5476D453B2D196750B37DB629C073", hash_generated_method = "45391AFBD0C211FDDC96145EFEBA9BB1")
    @Override
    public synchronized void reset() throws IOException {
        is.reset();
        // ---------- Original Method ----------
        //is.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.009 -0400", hash_original_method = "637EB2252F3D6A06954BF23A791270C0", hash_generated_method = "21DF34A4F4913D4F9064DF69CE5E07E2")
    @Override
    public synchronized void mark(int limit) {
        addTaint(limit);
        is.mark(limit);
        // ---------- Original Method ----------
        //is.mark(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.010 -0400", hash_original_method = "ACFDCFE3673D14E8936992CE0181818A", hash_generated_method = "768751B89C14FFB2D1B4260DC378399C")
    @Override
    public boolean markSupported() {
        boolean varA77FF1CF6434B3BF94A3328A38BB7FB5_726272266 = (is.markSupported());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850055419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_850055419;
        // ---------- Original Method ----------
        //return is.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.010 -0400", hash_original_method = "AA12D47EE60CC78A392E105684A425D9", hash_generated_method = "79695BFC8B630F0EDF09239FC6DD1941")
    @Override
    public void close() {
        IoUtils.closeQuietly(is);
        IoUtils.closeQuietly(controlSocket);
        // ---------- Original Method ----------
        //IoUtils.closeQuietly(is);
        //IoUtils.closeQuietly(controlSocket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.010 -0400", hash_original_method = "D9F2C32897BF6671DFA8E2E4EE31F66E", hash_generated_method = "088EF2202960384CEBDFC2DEB7844144")
    @Override
    public int available() throws IOException {
        int var29D049C0576020876FCD2C7E94605AB2_1818558133 = (is.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128554851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128554851;
        // ---------- Original Method ----------
        //return is.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.010 -0400", hash_original_method = "E4EF9B11E6886DE5F69F77BED2D5F0AB", hash_generated_method = "8F7DF81742A3306857EF361B922DAC7C")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        long var1BE0B9E2AD48673F22F04E6C493BA356_1246198849 = (is.skip(byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1078292118 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1078292118;
        // ---------- Original Method ----------
        //return is.skip(byteCount);
    }

    
}

