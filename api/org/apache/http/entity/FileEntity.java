package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
public class FileEntity extends AbstractHttpEntity implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.738 -0500", hash_original_field = "CF0C1CE75EC12E637A82B051B1AA9983", hash_generated_field = "BC43AA2BAF191D9B3508364DC44789C4")

    protected  File file;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.741 -0500", hash_original_method = "7B0CB5F6DC40F7AD2351558FFB54B759", hash_generated_method = "F57F3AA31E1E2FE345555E275B2BB7B0")
    
public FileEntity(final File file, final String contentType) {
        super();
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file;
        setContentType(contentType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.743 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    
public boolean isRepeatable() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.745 -0500", hash_original_method = "6FED64655A79F9611E60093AE1FA3DE4", hash_generated_method = "751F3742785BF191FFEF07527C97F949")
    
public long getContentLength() {
        return this.file.length();
    }
    
    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.748 -0500", hash_original_method = "95DDD95C9EF8C53495A581F72CFD5F10", hash_generated_method = "5E093CAE8892AED657B08A4E5732ACB7")
    
public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.752 -0500", hash_original_method = "91C2E73E59371A9FF089FC4D36B416A0", hash_generated_method = "C1F08362BF925EDDC80AA72667B77F8F")
    
public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream instream = new FileInputStream(this.file);
        try {
            byte[] tmp = new byte[4096];
            int l;
            while ((l = instream.read(tmp)) != -1) {
                outstream.write(tmp, 0, l);
            }
            outstream.flush();
        } finally {
            instream.close();
        }
    }

    /**
     * Tells that this entity is not streaming.
     *
     * @return <code>false</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.754 -0500", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "15A1411ACDA23E1A918918FF0CDDBE57")
    
public boolean isStreaming() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.757 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "B863BB858407008DA21379C4FC098BB2")
    
public Object clone() throws CloneNotSupportedException {
        // File instance is considered immutable
        // No need to make a copy of it
        return super.clone();
    }
    
}

