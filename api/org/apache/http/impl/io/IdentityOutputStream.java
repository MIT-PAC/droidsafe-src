package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.io.SessionOutputBuffer;

public class IdentityOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.977 -0500", hash_original_field = "862CD4E306AB155A980F18A7EE0A0BF8", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private  SessionOutputBuffer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.979 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.982 -0500", hash_original_method = "E16B6A29C07B7180AFC28B24A819F792", hash_generated_method = "CEBC8119D1624EA02DBB42197CA61AB0")
    
public IdentityOutputStream(final SessionOutputBuffer out) {
        super();
        if (out == null) {
            throw new IllegalArgumentException("Session output buffer may not be null");
        }
        this.out = out;
    }

    /**
     * <p>Does not close the underlying socket output.</p>
     * 
     * @throws IOException If an I/O problem occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.984 -0500", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "26BE9D5EBA83E15A05E65873FF8E9852")
    
public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.986 -0500", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "69E9959092BAC6291CF23078F47E18CD")
    
public void flush() throws IOException {
        this.out.flush();
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.989 -0500", hash_original_method = "48248C1CEDDF87D374745F5C11B9054E", hash_generated_method = "7F1EEA77B8D7D9D5B6E019E3E6A5026A")
    
public void write(byte[] b, int off, int len) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.out.write(b, off, len);
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.992 -0500", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "571732832533DA058E04BC8F76720194")
    
public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.994 -0500", hash_original_method = "A7A4BE3D6472F4EA278A930E01512219", hash_generated_method = "1B3E9B9018910F4607B7F2AADA451F40")
    
public void write(int b) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.out.write(b);
    }
    
}

