package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

final class DefaultServerSocketFactory extends ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.504 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.504 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "9BAA51F5334691DD3A2226F5BBA9000D")
    @Override
    public ServerSocket createServerSocket() throws IOException {
ServerSocket var0DF332023E849EB0317104A964F1F502_2108043422 =         new ServerSocket();
        var0DF332023E849EB0317104A964F1F502_2108043422.addTaint(taint);
        return var0DF332023E849EB0317104A964F1F502_2108043422;
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.504 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "2E6C2C220B55E8CE6D68F6B09D3F2630")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
ServerSocket varABE3B6A1CDC7C9D14D97B943CEECAC98_306247821 =         new ServerSocket(port);
        varABE3B6A1CDC7C9D14D97B943CEECAC98_306247821.addTaint(taint);
        return varABE3B6A1CDC7C9D14D97B943CEECAC98_306247821;
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.505 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "467CFDA62B9D3A8914627225F659BB8A")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
ServerSocket var32E1DD942B0D675FF44A81F59EAA4D4B_603361903 =         new ServerSocket(port, backlog);
        var32E1DD942B0D675FF44A81F59EAA4D4B_603361903.addTaint(taint);
        return var32E1DD942B0D675FF44A81F59EAA4D4B_603361903;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.505 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "120B22BC10FE9B81FFF47E3076FB6343")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varBEC696F7A4363189EF3CF61AC6A0FF58_1019577876 =         new ServerSocket(port, backlog, iAddress);
        varBEC696F7A4363189EF3CF61AC6A0FF58_1019577876.addTaint(taint);
        return varBEC696F7A4363189EF3CF61AC6A0FF58_1019577876;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

