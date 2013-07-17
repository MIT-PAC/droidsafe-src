package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.net.SocketFactory;

public abstract class SSLSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.820 -0400", hash_original_method = "A3C82F74D64165B62D4E0BF2DAC4717C", hash_generated_method = "CFFD1E7B9A1200471C81B5C122CFC682")
    public  SSLSocketFactory() {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.822 -0400", hash_original_field = "759E86615733C2D8434702D88FE7FA2B", hash_generated_field = "A80F243EA35036FEFF75D6C4C02000B5")

    private static SocketFactory defaultSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.822 -0400", hash_original_field = "3E15478143ED323D8F1D3CE8D42780EA", hash_generated_field = "B5EAD347CF9492DD929521E60E38417F")

    private static String defaultName;
}

