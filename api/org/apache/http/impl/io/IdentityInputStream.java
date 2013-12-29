package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.SessionInputBuffer;






public class IdentityInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.384 -0500", hash_original_field = "70993BC56EC5FB33DD67D98C82018650", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    
    private  SessionInputBuffer in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.385 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    
    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.386 -0500", hash_original_method = "9BF2DB3D820A8A5E47D8F845957A3FBA", hash_generated_method = "02CA87C5038900CAFE9B94925F103C66")
    public IdentityInputStream(final SessionInputBuffer in) {
        super();
        if (in == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        this.in = in;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.387 -0500", hash_original_method = "DCB121D8842EB51547DBC31A4230EDC6", hash_generated_method = "5CD863C5AA1EC1E8A1FD76E994C7BF4D")
    public int available() throws IOException {
        if (!this.closed && this.in.isDataAvailable(10)) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.388 -0500", hash_original_method = "311E5281CF91526FD2B39B7023BBB3B5", hash_generated_method = "E9229935EC81724C05DDA3378F484A43")
    public void close() throws IOException {
        this.closed = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.388 -0500", hash_original_method = "F6A0760AFCA549A5825114F4EAC4FB8F", hash_generated_method = "9E0DD976E5A0EA9794F891A4D359B15F")
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.389 -0500", hash_original_method = "E3ECD120B22D1F545DEC5B2DDE1C9AA2", hash_generated_method = "F96A7B756D9E3C99004DF720461E90B4")
    public int read(final byte[] b, int off, int len) throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read(b, off, len);
        }
    }

    
}

