package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

final class DefaultServerSocketFactory extends ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.020 -0400", hash_original_method = "16E8C9960F37DC91E4BE0C3A2428CF26", hash_generated_method = "16E8C9960F37DC91E4BE0C3A2428CF26")
        public DefaultServerSocketFactory ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.021 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "B5C3D57E25D133B835F947FC0E9E146A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket var5C7740201CF5ABE59BDCC0B625F925AF_1524170180 = (new ServerSocket());
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.021 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "84C0321D634C1503FA54018BE8B30462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        dsTaint.addTaint(port);
        ServerSocket var004CD9F2FCF8388C8CE5F7FD775ACD7D_1885641631 = (new ServerSocket(port));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.021 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "DF72C20D4AF4A7AE9446E3ABB5930487")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        ServerSocket varB4561E17D29960B8A1AAB6DB25C7D0AD_1769245527 = (new ServerSocket(port, backlog));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.021 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "95AFFF02FC7310A75AE0F541C543EFA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(iAddress.dsTaint);
        dsTaint.addTaint(backlog);
        ServerSocket var2E1B4E56ED8A97D900550F0B48DA603D_1431330052 = (new ServerSocket(port, backlog, iAddress));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

