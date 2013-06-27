package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import libcore.io.IoUtils;

class FtpURLInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.092 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.092 -0400", hash_original_field = "62CE5FD8E6BD8C916853B8B84063B5BC", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")

    private Socket controlSocket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.093 -0400", hash_original_method = "826919C06E887B63574F8C2AA9021EA4", hash_generated_method = "AE5139D29BF3056C3C33DA54DF2C377C")
    public  FtpURLInputStream(InputStream is, Socket controlSocket) {
        this.is = is;
        this.controlSocket = controlSocket;
        // ---------- Original Method ----------
        //this.is = is;
        //this.controlSocket = controlSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.093 -0400", hash_original_method = "7CE2C444F0201136E21AAFE741F28564", hash_generated_method = "38F2FCBAAF0669219269AB434B790F45")
    @Override
    public int read() throws IOException {
        int var7FB0D78FE0B9B888185C4DBD14243734_1438590920 = (is.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313824122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313824122;
        // ---------- Original Method ----------
        //return is.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.093 -0400", hash_original_method = "67E478B38D83ABBBB81FEA8967B3C884", hash_generated_method = "71D929BE0234A6CF360BB5C58EDC6B38")
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        int var388CF4B9A5BA93F2FD533FC65EF57F10_2126845726 = (is.read(buf, off, nbytes));
        addTaint(buf[0]);
        addTaint(off);
        addTaint(nbytes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912684484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912684484;
        // ---------- Original Method ----------
        //return is.read(buf, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.094 -0400", hash_original_method = "89E5476D453B2D196750B37DB629C073", hash_generated_method = "45391AFBD0C211FDDC96145EFEBA9BB1")
    @Override
    public synchronized void reset() throws IOException {
        is.reset();
        // ---------- Original Method ----------
        //is.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.094 -0400", hash_original_method = "637EB2252F3D6A06954BF23A791270C0", hash_generated_method = "7D3F648093A0409353B7D195CDCBD339")
    @Override
    public synchronized void mark(int limit) {
        is.mark(limit);
        addTaint(limit);
        // ---------- Original Method ----------
        //is.mark(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.094 -0400", hash_original_method = "ACFDCFE3673D14E8936992CE0181818A", hash_generated_method = "C10DEBECA8B3FEFA7310558375FD578C")
    @Override
    public boolean markSupported() {
        boolean varAF189E98C5801D5388665B54C19C1B3F_548813928 = (is.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081129486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081129486;
        // ---------- Original Method ----------
        //return is.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.094 -0400", hash_original_method = "AA12D47EE60CC78A392E105684A425D9", hash_generated_method = "79695BFC8B630F0EDF09239FC6DD1941")
    @Override
    public void close() {
        IoUtils.closeQuietly(is);
        IoUtils.closeQuietly(controlSocket);
        // ---------- Original Method ----------
        //IoUtils.closeQuietly(is);
        //IoUtils.closeQuietly(controlSocket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.103 -0400", hash_original_method = "D9F2C32897BF6671DFA8E2E4EE31F66E", hash_generated_method = "F185A4525BA5C45035DC5D8B3D8D3B40")
    @Override
    public int available() throws IOException {
        int var09254EF9FA598C86A613AD848BF49F75_293586086 = (is.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009128103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009128103;
        // ---------- Original Method ----------
        //return is.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.103 -0400", hash_original_method = "E4EF9B11E6886DE5F69F77BED2D5F0AB", hash_generated_method = "68A3355ACBAFA7BC374E89E1A4F61CD4")
    @Override
    public long skip(long byteCount) throws IOException {
        long var760D31465FD0484F1E62E549356F9137_619283731 = (is.skip(byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1939498101 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1939498101;
        // ---------- Original Method ----------
        //return is.skip(byteCount);
    }

    
}

