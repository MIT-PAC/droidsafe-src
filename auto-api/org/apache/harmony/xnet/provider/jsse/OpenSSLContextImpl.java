package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class OpenSSLContextImpl extends SSLContextImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.835 -0400", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "BA56A83C11C4D548CDA5AAC3BEDBB357")
    @DSModeled(DSC.SAFE)
    public OpenSSLContextImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.836 -0400", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "C7F37E859776D535F0EA377B789A51E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        super(dummy);
        dsTaint.addTaint(dummy.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.836 -0400", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "F1EEE3D18FAC11173484378D57683D4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLSocketFactory var298F40FE87A30BBF94055B1484925626_1252065548 = (new OpenSSLSocketFactoryImpl(sslParameters));
        return (SSLSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.836 -0400", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "0729A9BC59BB46978393EB72579B4E77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLServerSocketFactory var350C96D883973EB5607558D0BD9D460B_1401137708 = (new OpenSSLServerSocketFactoryImpl(sslParameters));
        return (SSLServerSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }

    
}

