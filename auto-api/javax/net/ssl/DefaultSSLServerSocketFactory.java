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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.492 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.493 -0400", hash_original_method = "75914460F849F70EB9C61E69E22A6D0F", hash_generated_method = "D44D9734EF6EA12716A4A51DD204BD62")
      DefaultSSLServerSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.494 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "3BB9E149ED59E44F6450B89AF1DBF54B")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_414223024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_414223024 = EmptyArray.STRING;
        varB4EAC82CA7396A68D541C85D26508E83_414223024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_414223024;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.494 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "7285268C58ED952A7B8C931CACFD59A6")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_978683070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978683070 = EmptyArray.STRING;
        varB4EAC82CA7396A68D541C85D26508E83_978683070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978683070;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.495 -0400", hash_original_method = "3CA5D0FA144D223B163E20364EF717CA", hash_generated_method = "CD0F0F0CDE476F807ABE0A42201BFF5C")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(port);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
        return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.495 -0400", hash_original_method = "72A7F975E743E745F7B0696336C67E27", hash_generated_method = "4DA4E5590F28C7F9DA1E7B2C6BF50B3B")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(port);
        addTaint(backlog);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
        return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.496 -0400", hash_original_method = "46FACB6F6AB575F914E1C4CC8DD6AA24", hash_generated_method = "3806206BD7814E64E72096C13D146997")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

