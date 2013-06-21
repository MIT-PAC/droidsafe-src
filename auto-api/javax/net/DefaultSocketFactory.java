package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

final class DefaultSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
    @DSModeled(DSC.SAFE)
     DefaultSocketFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "3D9CD554A45BA3CDB08AFF7D55AB5EAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket() throws IOException {
        Socket var16170B41F40C9336E3767650DA154372_1081654971 = (new Socket());
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "EA515DA18C154E01A63A237D5722726C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        Socket varC67E2888708564B70701477210B37289_1933134867 = (new Socket(host, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "19159F5BACE3DCC9C60C4C763B7C08A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localHost.dsTaint);
        Socket var976ECE56AD03DA159C78C4EFDC0CA7F7_1387585519 = (new Socket(host, port, localHost, localPort));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(host, port, localHost, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "F28775891551DABD1D7EC16600B15E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        Socket varC67E2888708564B70701477210B37289_1458403583 = (new Socket(host, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.022 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "7C0BB46A1BE4A99121556A84BB8B2525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        Socket var24AFD7A7B1775CAB69E03A031578C0C1_609300865 = (new Socket(address, port, localAddress, localPort));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(address, port, localAddress, localPort);
    }

    
}

