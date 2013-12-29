package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import libcore.io.IoUtils;





class FtpURLInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.703 -0500", hash_original_field = "B25CAE9BF82BA95FEFAA4B1FEB647560", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")


    private InputStream is;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.703 -0500", hash_original_field = "6CF25C888D3E662FD8C4A2A5DD7D4D81", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")


    private Socket controlSocket;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.704 -0500", hash_original_method = "826919C06E887B63574F8C2AA9021EA4", hash_generated_method = "36301287EDE371CE7E548E880F815674")
    public FtpURLInputStream(InputStream is, Socket controlSocket) {
        this.is = is;
        this.controlSocket = controlSocket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.705 -0500", hash_original_method = "7CE2C444F0201136E21AAFE741F28564", hash_generated_method = "DF6FA14B93B3D3083AE217F4EE817C64")
    @Override
public int read() throws IOException {
        return is.read();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.706 -0500", hash_original_method = "67E478B38D83ABBBB81FEA8967B3C884", hash_generated_method = "2828806F2C8D5A9174A8E6F3C39664CC")
    @Override
public int read(byte[] buf, int off, int nbytes) throws IOException {
        return is.read(buf, off, nbytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.707 -0500", hash_original_method = "89E5476D453B2D196750B37DB629C073", hash_generated_method = "59100886A8908EF2F15B01CDAD294215")
    @Override
public synchronized void reset() throws IOException {
        is.reset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.708 -0500", hash_original_method = "637EB2252F3D6A06954BF23A791270C0", hash_generated_method = "199F39716B884A38CCE81A3E4684788C")
    @Override
public synchronized void mark(int limit) {
        is.mark(limit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.708 -0500", hash_original_method = "ACFDCFE3673D14E8936992CE0181818A", hash_generated_method = "6FE649BBAA3604BC015565C732B4541C")
    @Override
public boolean markSupported() {
        return is.markSupported();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.709 -0500", hash_original_method = "AA12D47EE60CC78A392E105684A425D9", hash_generated_method = "81DA28F4488AF203BA7DC1CABC0994B2")
    @Override
public void close() {
        IoUtils.closeQuietly(is);
        IoUtils.closeQuietly(controlSocket);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.710 -0500", hash_original_method = "D9F2C32897BF6671DFA8E2E4EE31F66E", hash_generated_method = "F59823328F606FE8BFD6C352403723BA")
    @Override
public int available() throws IOException {
        return is.available();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.711 -0500", hash_original_method = "E4EF9B11E6886DE5F69F77BED2D5F0AB", hash_generated_method = "D049E862079BA20C47481A3C43C5C187")
    @Override
public long skip(long byteCount) throws IOException {
        return is.skip(byteCount);
    }

    
}

