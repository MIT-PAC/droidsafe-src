package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

public class SSLStreamedInput extends SSLInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.199 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.201 -0500", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "815CBA021DDFEBE9388BB9CCBF77BA26")
    
public SSLStreamedInput(InputStream in) {
        this.in = in;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.204 -0500", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "8E5606FF0A120193314716C29AE15BAC")
    
@Override
    public int available() throws IOException {
        return in.available();
    }

    /**
     * Read an opaque value from the stream.
     * @return the value read from the underlying stream.
     * @throws IOException if the data could not be read from
     * the underlying stream
     * @throws org.apache.harmony.xnet.provider.jsse.EndOfSourceException if the end of the underlying
     * stream has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.206 -0500", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "A285847CD23F2C7C711C4A57F7E4A09F")
    
@Override
    public int read() throws IOException {
        int res = in.read();
        if (res < 0) {
            throw new EndOfSourceException();
        }
        return res;
    }
    
}

