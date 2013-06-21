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
    private InputStream is;
    private Socket controlSocket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.629 -0400", hash_original_method = "826919C06E887B63574F8C2AA9021EA4", hash_generated_method = "6454218360233FF66B7283A564B1CB86")
    @DSModeled(DSC.SAFE)
    public FtpURLInputStream(InputStream is, Socket controlSocket) {
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(controlSocket.dsTaint);
        // ---------- Original Method ----------
        //this.is = is;
        //this.controlSocket = controlSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "7CE2C444F0201136E21AAFE741F28564", hash_generated_method = "69D110F2CF6C5F641D20A947F33140B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var7FB0D78FE0B9B888185C4DBD14243734_2085731245 = (is.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return is.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "67E478B38D83ABBBB81FEA8967B3C884", hash_generated_method = "E403D17267A78157B97E4AEA5CD782AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        dsTaint.addTaint(nbytes);
        dsTaint.addTaint(off);
        dsTaint.addTaint(buf[0]);
        int var388CF4B9A5BA93F2FD533FC65EF57F10_1407075883 = (is.read(buf, off, nbytes));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return is.read(buf, off, nbytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "89E5476D453B2D196750B37DB629C073", hash_generated_method = "45391AFBD0C211FDDC96145EFEBA9BB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void reset() throws IOException {
        is.reset();
        // ---------- Original Method ----------
        //is.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "637EB2252F3D6A06954BF23A791270C0", hash_generated_method = "5287C4507856B3FF47858E65772CC223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void mark(int limit) {
        dsTaint.addTaint(limit);
        is.mark(limit);
        // ---------- Original Method ----------
        //is.mark(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "ACFDCFE3673D14E8936992CE0181818A", hash_generated_method = "66528FD130A75E4D1845EAF7085A3E2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean markSupported() {
        boolean varAF189E98C5801D5388665B54C19C1B3F_505761972 = (is.markSupported());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return is.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.630 -0400", hash_original_method = "AA12D47EE60CC78A392E105684A425D9", hash_generated_method = "79695BFC8B630F0EDF09239FC6DD1941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() {
        IoUtils.closeQuietly(is);
        IoUtils.closeQuietly(controlSocket);
        // ---------- Original Method ----------
        //IoUtils.closeQuietly(is);
        //IoUtils.closeQuietly(controlSocket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.631 -0400", hash_original_method = "D9F2C32897BF6671DFA8E2E4EE31F66E", hash_generated_method = "426F552A8508EBF69B914494CAA43862")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var09254EF9FA598C86A613AD848BF49F75_346888811 = (is.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return is.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.631 -0400", hash_original_method = "E4EF9B11E6886DE5F69F77BED2D5F0AB", hash_generated_method = "97FFA5CA90E5DB844CDA1CA691A1B3AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long var760D31465FD0484F1E62E549356F9137_647430052 = (is.skip(byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return is.skip(byteCount);
    }

    
}

