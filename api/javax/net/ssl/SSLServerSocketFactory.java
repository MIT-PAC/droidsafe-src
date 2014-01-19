package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.net.ServerSocketFactory;

public abstract class SSLServerSocketFactory extends ServerSocketFactory {

    /**
     * Returns the default {@code SSLServerSocketFactory} instance. The default
     * implementation is defined by the security property
     * "ssl.ServerSocketFactory.provider".
     *
     * @return the default {@code SSLServerSocketFactory} instance.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.529 -0500", hash_original_method = "A7F1CDDCECEE4B1BBC83F94321EC50FE", hash_generated_method = "1FB4E1E4CDB0F0EE29F19CB3F8E71013")
    
public static synchronized ServerSocketFactory getDefault() {
        if (defaultServerSocketFactory != null) {
            return defaultServerSocketFactory;
        }
        if (defaultName == null) {
            defaultName = Security.getProperty("ssl.ServerSocketFactory.provider");
            if (defaultName != null) {
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                if (cl == null) {
                    cl = ClassLoader.getSystemClassLoader();
                }
                try {
                    final Class<?> ssfc = Class.forName(defaultName, true, cl);
                    defaultServerSocketFactory = (ServerSocketFactory) ssfc.newInstance();
                } catch (Exception e) {
                }
            }
        }
        if (defaultServerSocketFactory == null) {
            SSLContext context;
            try {
                context = SSLContext.getDefault();
            } catch (NoSuchAlgorithmException e) {
                context = null;
            }
            if (context != null) {
                defaultServerSocketFactory = context.getServerSocketFactory();
            }
        }
        if (defaultServerSocketFactory == null) {
            // Use internal dummy implementation
            defaultServerSocketFactory = new DefaultSSLServerSocketFactory(
                    "No ServerSocketFactory installed");
        }
        return defaultServerSocketFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.524 -0500", hash_original_field = "7F967218D10CD1AC03791A88D0EBB0BA", hash_generated_field = "D22A92C7866CD49D60974132EDB6FF22")

    // The default SSL socket factory
    private static ServerSocketFactory defaultServerSocketFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.527 -0500", hash_original_field = "84BC5372A12AA239726FB6B8D530CCAC", hash_generated_field = "B5EAD347CF9492DD929521E60E38417F")

    private static String defaultName;

    /**
     * Creates a new {@code SSLServerSocketFactory} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.532 -0500", hash_original_method = "BC3ACB83646E5282AC0839BB4C043770", hash_generated_method = "C89C69B54B34F4F0DF519231EC3A370E")
    
protected SSLServerSocketFactory() {
    }

    /**
     * Returns the names of the cipher suites that are enabled by default.
     *
     * @return the names of the cipher suites that are enabled by default
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.534 -0500", hash_original_method = "39637FAA2A428B026F3142CDE9E65872", hash_generated_method = "B1D7CA4E890A48074B49D06D9FFA1B03")
    
public abstract String[] getDefaultCipherSuites();

    /**
     * Returns the list of supported cipher suites that could be enabled for an
     * SSL connection created by this factory.
     *
     * @return the list of supported cipher suites
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.537 -0500", hash_original_method = "972B577B4B04B597248145E0CF6E63D2", hash_generated_method = "09D1FF6565C262832AA989BA28390929")
    
public abstract String[] getSupportedCipherSuites();
}

