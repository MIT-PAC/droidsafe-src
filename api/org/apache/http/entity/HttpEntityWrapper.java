package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class HttpEntityWrapper implements HttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.816 -0500", hash_original_field = "DAC198C5909CCB54353BED3B9E4CBA7E", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;

    /**
     * Creates a new entity wrapper.
     *
     * @param wrapped   the entity to wrap
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.818 -0500", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "3B463090CD85133EA75742B90CB4B38A")
    
public HttpEntityWrapper(HttpEntity wrapped) {
        super();

        if (wrapped == null) {
            throw new IllegalArgumentException
                ("wrapped entity must not be null");
        }
        wrappedEntity = wrapped;

    } // constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.821 -0500", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "A7869F408064539376386BA11273444E")
    
public boolean isRepeatable() {
        return wrappedEntity.isRepeatable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.823 -0500", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "C078A51D2F78D56E6BFF9A341C04BF09")
    
public boolean isChunked() {
        return wrappedEntity.isChunked();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.825 -0500", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "7E046C22E149DB121AF317DB8766BFCA")
    
public long getContentLength() {
        return wrappedEntity.getContentLength();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.828 -0500", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "95948A8A1C15106D85E087E36E1A5E3E")
    
public Header getContentType() {
        return wrappedEntity.getContentType();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.830 -0500", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "BAC98E383F19DD74C4235118AB581A0B")
    
public Header getContentEncoding() {
        return wrappedEntity.getContentEncoding();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.832 -0500", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "49F44DDDCF30859499FEBA5D2E51B47E")
    
public InputStream getContent()
        throws IOException {
        return wrappedEntity.getContent();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.834 -0500", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "7177975BE493E9B969B7CF7EB1DD7476")
    
public void writeTo(OutputStream outstream)
        throws IOException {
        wrappedEntity.writeTo(outstream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.836 -0500", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "FC0CC19CCC8433A550E08DFE9A586FB3")
    
public boolean isStreaming() {
        return wrappedEntity.isStreaming();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.839 -0500", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "CCF0369DEB5EC85D69C5470E4543D266")
    
public void consumeContent()
        throws IOException {
        wrappedEntity.consumeContent();
    }
    
}

