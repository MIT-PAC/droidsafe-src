package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;



public class OpenSSLContextImpl extends SSLContextImpl {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.373 -0500", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "2DAB3756C0B77899A95338CABCD4E299")
    public OpenSSLContextImpl() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.374 -0500", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "FFC388A9EE327C4A86000F47BAEA3558")
    protected OpenSSLContextImpl(DefaultSSLContextImpl dummy)
            throws GeneralSecurityException, IOException {
        super(dummy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.374 -0500", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "80609713FA2B818B0785F30705C820E9")
    @Override
public SSLSocketFactory engineGetSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.376 -0500", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "14EA10676502CCA11F3314CBF461CB4A")
    @Override
public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }

    
}

