package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public abstract class SSLServerSocket extends ServerSocket {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.097 -0400", hash_original_method = "0C32E268EE0846B0058E51DE9119BB88", hash_generated_method = "B37F190B43A3AAD81F61BB2FEBA35EB3")
    @DSModeled(DSC.SAFE)
    protected SSLServerSocket() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.097 -0400", hash_original_method = "6BF605439AB4EACD05FCE94D8066CA51", hash_generated_method = "DBC7CE132122D6466F6C64D993D74850")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocket(int port) throws IOException {
        super(port);
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.097 -0400", hash_original_method = "B059A4E5C7C0ACF77295A5FB6F9F0E0C", hash_generated_method = "5CFE7819E72BEC43E2BE5191505C2137")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocket(int port, int backlog) throws IOException {
        super(port, backlog);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.098 -0400", hash_original_method = "52663793633798E1236728C0ACB46452", hash_generated_method = "0ADE0D43082DE8F48CC2527CB97CEE67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocket(int port, int backlog, InetAddress address) throws IOException {
        super(port, backlog, address);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(address.dsTaint);
        // ---------- Original Method ----------
    }

    
    public abstract String[] getEnabledCipherSuites();

    
    public abstract void setEnabledCipherSuites(String[] suites);

    
    public abstract String[] getSupportedCipherSuites();

    
    public abstract String[] getSupportedProtocols();

    
    public abstract String[] getEnabledProtocols();

    
    public abstract void setEnabledProtocols(String[] protocols);

    
    public abstract void setNeedClientAuth(boolean need);

    
    public abstract boolean getNeedClientAuth();

    
    public abstract void setWantClientAuth(boolean want);

    
    public abstract boolean getWantClientAuth();

    
    public abstract void setUseClientMode(boolean mode);

    
    public abstract boolean getUseClientMode();

    
    public abstract void setEnableSessionCreation(boolean flag);

    
    public abstract boolean getEnableSessionCreation();

    
}

