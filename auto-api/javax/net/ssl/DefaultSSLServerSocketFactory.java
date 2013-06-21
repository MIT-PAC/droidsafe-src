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
import java.net.SocketException;
import libcore.util.EmptyArray;

class DefaultSSLServerSocketFactory extends SSLServerSocketFactory {
    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.044 -0400", hash_original_method = "75914460F849F70EB9C61E69E22A6D0F", hash_generated_method = "1322A4EED2E29D60B2574858CAC6D85B")
    @DSModeled(DSC.SAFE)
     DefaultSSLServerSocketFactory(String mes) {
        dsTaint.addTaint(mes);
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.044 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "92AFAEB08A0598071634AB26BA355610")
    @DSModeled(DSC.SAFE)
    @Override
    public String[] getDefaultCipherSuites() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.044 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "5A390AC14B34E796549B75DB1A9E1C8F")
    @DSModeled(DSC.SAFE)
    @Override
    public String[] getSupportedCipherSuites() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.045 -0400", hash_original_method = "3CA5D0FA144D223B163E20364EF717CA", hash_generated_method = "3EFE159803C14A859FCFD440321915DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        dsTaint.addTaint(port);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.045 -0400", hash_original_method = "72A7F975E743E745F7B0696336C67E27", hash_generated_method = "1073E5E35A8B1284749F278DAFE4DC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.045 -0400", hash_original_method = "46FACB6F6AB575F914E1C4CC8DD6AA24", hash_generated_method = "BE57434AD13765EC18C2473723848D94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(iAddress.dsTaint);
        dsTaint.addTaint(backlog);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

