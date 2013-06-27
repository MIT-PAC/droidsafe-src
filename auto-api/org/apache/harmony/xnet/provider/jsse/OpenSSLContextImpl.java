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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.033 -0400", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "BA56A83C11C4D548CDA5AAC3BEDBB357")
    public  OpenSSLContextImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.033 -0400", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "4AB7A8A94F9DDD43C12E832C92955DE0")
    protected  OpenSSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        super(dummy);
        addTaint(dummy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.034 -0400", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "77E6185F8C9365C9D205F54EF0B91991")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_733715400 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_733715400 = new OpenSSLSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_733715400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733715400;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.035 -0400", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "0BDC06B69980B0787C42C67620A86635")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_842143044 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_842143044 = new OpenSSLServerSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_842143044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842143044;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }

    
}

