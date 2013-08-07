package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;





public abstract class SSLServerSocket extends ServerSocket {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.761 -0400", hash_original_method = "0C32E268EE0846B0058E51DE9119BB88", hash_generated_method = "B37F190B43A3AAD81F61BB2FEBA35EB3")
    protected  SSLServerSocket() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.761 -0400", hash_original_method = "6BF605439AB4EACD05FCE94D8066CA51", hash_generated_method = "6FE19A8839DF400B67B74C0B08F71A95")
    protected  SSLServerSocket(int port) throws IOException {
        super(port);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.762 -0400", hash_original_method = "B059A4E5C7C0ACF77295A5FB6F9F0E0C", hash_generated_method = "AA894D163A9EFEEB332E4FF4EB30149A")
    protected  SSLServerSocket(int port, int backlog) throws IOException {
        super(port, backlog);
        addTaint(backlog);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.763 -0400", hash_original_method = "52663793633798E1236728C0ACB46452", hash_generated_method = "15D67A4C5120A2E692332B15CB43BDA1")
    protected  SSLServerSocket(int port, int backlog, InetAddress address) throws IOException {
        super(port, backlog, address);
        addTaint(address.getTaint());
        addTaint(backlog);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getEnabledCipherSuites();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnabledCipherSuites(String[] suites);

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getSupportedCipherSuites();

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getSupportedProtocols();

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getEnabledProtocols();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnabledProtocols(String[] protocols);

    
    @DSModeled(DSC.SAFE)
    public abstract void setNeedClientAuth(boolean need);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getNeedClientAuth();

    
    @DSModeled(DSC.SAFE)
    public abstract void setWantClientAuth(boolean want);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getWantClientAuth();

    
    @DSModeled(DSC.SAFE)
    public abstract void setUseClientMode(boolean mode);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getUseClientMode();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnableSessionCreation(boolean flag);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getEnableSessionCreation();

    
}

