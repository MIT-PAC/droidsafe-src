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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.266 -0400", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "BA56A83C11C4D548CDA5AAC3BEDBB357")
    public  OpenSSLContextImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.266 -0400", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "4AB7A8A94F9DDD43C12E832C92955DE0")
    protected  OpenSSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        super(dummy);
        addTaint(dummy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.267 -0400", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "C36087AC75149F28EF0591FB66DD9C43")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_141142525 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_141142525 = new OpenSSLSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_141142525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141142525;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.267 -0400", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "D8D08DDF59AED67909940CC974D64221")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_2048413087 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2048413087 = new OpenSSLServerSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_2048413087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048413087;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }

    
}

