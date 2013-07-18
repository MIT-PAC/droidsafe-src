package javax.net;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import droidsafe.annotations.DSGenerator;

final class DefaultServerSocketFactory extends ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.506 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.507 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "F3E021CEADEC1FB3251B5EE6CE16E647")
    @Override
    public ServerSocket createServerSocket() throws IOException {
ServerSocket var0DF332023E849EB0317104A964F1F502_1632810831 =         new ServerSocket();
        var0DF332023E849EB0317104A964F1F502_1632810831.addTaint(taint);
        return var0DF332023E849EB0317104A964F1F502_1632810831;
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.508 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "53D24663B9AC12FB0091FF23ED12EC5A")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
ServerSocket varABE3B6A1CDC7C9D14D97B943CEECAC98_1316567264 =         new ServerSocket(port);
        varABE3B6A1CDC7C9D14D97B943CEECAC98_1316567264.addTaint(taint);
        return varABE3B6A1CDC7C9D14D97B943CEECAC98_1316567264;
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.509 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "6BBEC338581BD39D974A77E0DD511E5B")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
ServerSocket var32E1DD942B0D675FF44A81F59EAA4D4B_2002632348 =         new ServerSocket(port, backlog);
        var32E1DD942B0D675FF44A81F59EAA4D4B_2002632348.addTaint(taint);
        return var32E1DD942B0D675FF44A81F59EAA4D4B_2002632348;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.509 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "B61E52878CDBFF82C8D107908EA34DB3")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varBEC696F7A4363189EF3CF61AC6A0FF58_1144712367 =         new ServerSocket(port, backlog, iAddress);
        varBEC696F7A4363189EF3CF61AC6A0FF58_1144712367.addTaint(taint);
        return varBEC696F7A4363189EF3CF61AC6A0FF58_1144712367;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

