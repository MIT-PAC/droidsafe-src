package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

import libcore.util.EmptyArray;





class DefaultSSLServerSocketFactory extends SSLServerSocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.039 -0500", hash_original_field = "E54DFF2DC8E1BA5EA237533EDA39F4E1", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")


    private  String errMessage;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.042 -0500", hash_original_method = "75914460F849F70EB9C61E69E22A6D0F", hash_generated_method = "75914460F849F70EB9C61E69E22A6D0F")
    
DefaultSSLServerSocketFactory(String mes) {
        errMessage = mes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.044 -0500", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "75E10C557E5ED421A6A96DF7BC668ED0")
    
@Override
    public String[] getDefaultCipherSuites() {
        return EmptyArray.STRING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.047 -0500", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "EF7DACA8298C2A694CB6406898565668")
    
@Override
    public String[] getSupportedCipherSuites() {
        return EmptyArray.STRING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.049 -0500", hash_original_method = "3CA5D0FA144D223B163E20364EF717CA", hash_generated_method = "0DA37F16AB440864C47F5E95951842AE")
    
@Override
    public ServerSocket createServerSocket(int port) throws IOException {
        throw new SocketException(errMessage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.051 -0500", hash_original_method = "72A7F975E743E745F7B0696336C67E27", hash_generated_method = "463F6D20369C616B6F1F8D19B4E92DC2")
    
@Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        throw new SocketException(errMessage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.053 -0500", hash_original_method = "46FACB6F6AB575F914E1C4CC8DD6AA24", hash_generated_method = "B09F5F30F24E446C076557409CFC186D")
    
@Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException {
        throw new SocketException(errMessage);
    }

    
}

