package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.net.SocketFactory;

public abstract class SSLSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.113 -0400", hash_original_method = "A3C82F74D64165B62D4E0BF2DAC4717C", hash_generated_method = "CFFD1E7B9A1200471C81B5C122CFC682")
    @DSModeled(DSC.SAFE)
    public SSLSocketFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SocketFactory getDefault() {
        if (defaultSocketFactory != null) {
            return defaultSocketFactory;
        }
        if (defaultName == null) {
            defaultName = Security.getProperty("ssl.SocketFactory.provider");
            if (defaultName != null) {
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                if (cl == null) {
                    cl = ClassLoader.getSystemClassLoader();
                }
                try {
                    final Class<?> sfc = Class.forName(defaultName, true, cl);
                    defaultSocketFactory = (SocketFactory) sfc.newInstance();
                } catch (Exception e) {
                    System.logE("Problem creating " + defaultName, e);
                }
            }
        }
        if (defaultSocketFactory == null) {
            SSLContext context;
            try {
                context = SSLContext.getDefault();
            } catch (NoSuchAlgorithmException e) {
                context = null;
            }
            if (context != null) {
                defaultSocketFactory = context.getSocketFactory();
            }
        }
        if (defaultSocketFactory == null) {
            defaultSocketFactory = new DefaultSSLSocketFactory("No SSLSocketFactory installed");
        }
        return defaultSocketFactory;
    }

    
    public abstract String[] getDefaultCipherSuites();

    
    public abstract String[] getSupportedCipherSuites();

    
    public abstract Socket createSocket(Socket s, String host, int port, boolean autoClose)
            throws IOException;

    
    private static SocketFactory defaultSocketFactory;
    private static String defaultName;
}

