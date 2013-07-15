package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class DefaultNetworkLayer implements NetworkLayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.828 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.828 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.829 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    private  DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        // ---------- Original Method ----------
        //sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                //.getDefault();
        //sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.829 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "8005DD3C42AB01F23A31C8785BA39C87")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varE4B9B613713A284A68E30C41D0180672_384618197 =         new ServerSocket(port, backlog, bindAddress);
        varE4B9B613713A284A68E30C41D0180672_384618197.addTaint(taint);
        return varE4B9B613713A284A68E30C41D0180672_384618197;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.830 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "43297119CD6AFA43056AB40E5DEA1F2A")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
Socket var5E79725D08CDDFD22D09C6C43A37CB90_49003308 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_49003308.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_49003308;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.830 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "37493C91611540AB5353AEAC2BF5B5BF")
    public DatagramSocket createDatagramSocket() throws SocketException {
DatagramSocket varF3F5BFEAD339A7B18CCDB5E45144558F_671213544 =         new DatagramSocket();
        varF3F5BFEAD339A7B18CCDB5E45144558F_671213544.addTaint(taint);
        return varF3F5BFEAD339A7B18CCDB5E45144558F_671213544;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.830 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "45DDECA986247791EB8B5D4CF9996901")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        addTaint(laddr.getTaint());
        addTaint(port);
    if(laddr.isMulticastAddress())        
        {
            try 
            {
                MulticastSocket ds = new MulticastSocket( port );
                ds.joinGroup( laddr );
DatagramSocket var326AB3082797E11390DC7F191D96A430_1314184759 =                 ds;
                var326AB3082797E11390DC7F191D96A430_1314184759.addTaint(taint);
                return var326AB3082797E11390DC7F191D96A430_1314184759;
            } //End block
            catch (IOException e)
            {
                SocketException var064DCB284F4B19267BC3027A208CD5E6_136577916 = new SocketException( e.getLocalizedMessage() );
                var064DCB284F4B19267BC3027A208CD5E6_136577916.addTaint(taint);
                throw var064DCB284F4B19267BC3027A208CD5E6_136577916;
            } //End block
        } //End block
        else
        {
DatagramSocket var820EBD96BF02810AC98BFD2304C9D9D4_990808132 =         new DatagramSocket(port, laddr);
        var820EBD96BF02810AC98BFD2304C9D9D4_990808132.addTaint(taint);
        return var820EBD96BF02810AC98BFD2304C9D9D4_990808132;
        }
        // ---------- Original Method ----------
        //if ( laddr.isMulticastAddress() ) {
            //try {
                //MulticastSocket ds = new MulticastSocket( port );
                //ds.joinGroup( laddr );
                //return ds;
            //} catch (IOException e) {
                //throw new SocketException( e.getLocalizedMessage() );
            //}
        //} else return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.831 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "23ED821EDA868ED833A7089756C075FD")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
SSLServerSocket varDB234CDB256B380882CFCA310DE2E9A9_2142115931 =         (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        varDB234CDB256B380882CFCA310DE2E9A9_2142115931.addTaint(taint);
        return varDB234CDB256B380882CFCA310DE2E9A9_2142115931;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.831 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "048EA08A6F67F8B9270600022351C314")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket var49B70040270D50337C2159532A57C2F2_1721305741 =         (SSLSocket) sslSocketFactory.createSocket(address, port);
        var49B70040270D50337C2159532A57C2F2_1721305741.addTaint(taint);
        return var49B70040270D50337C2159532A57C2F2_1721305741;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.832 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "F8879392970EF5247EA977BCEDB67E6C")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket varEF759514F740B9EA798E50D9AB0AAE35_1356585491 =         (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        varEF759514F740B9EA798E50D9AB0AAE35_1356585491.addTaint(taint);
        return varEF759514F740B9EA798E50D9AB0AAE35_1356585491;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.832 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "317B740D145CFB8FA8254C8CAB8F14EE")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
    if(myAddress != null)        
        {
Socket varC993D01A4A0021129635B26049A65900_2143555482 =         new Socket(address, port, myAddress, 0);
        varC993D01A4A0021129635B26049A65900_2143555482.addTaint(taint);
        return varC993D01A4A0021129635B26049A65900_2143555482;
        }
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_587005369 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_587005369.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_587005369;
        }
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.833 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "FB49176EC69C0B644FFFFA5B3C88C73F")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        addTaint(myPort);
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
    if(myAddress != null)        
        {
Socket var714C0A100CD3A7064A2EB768AEC78FF6_838516366 =         new Socket(address, port, myAddress, myPort);
        var714C0A100CD3A7064A2EB768AEC78FF6_838516366.addTaint(taint);
        return var714C0A100CD3A7064A2EB768AEC78FF6_838516366;
        }
        else
    if(port != 0)        
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
Socket var947470A701CF490B15CD8DA4BCF73C48_1266769542 =             sock;
            var947470A701CF490B15CD8DA4BCF73C48_1266769542.addTaint(taint);
            return var947470A701CF490B15CD8DA4BCF73C48_1266769542;
        } //End block
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_527829010 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_527829010.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_527829010;
        }
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, myPort);
        //else if (port != 0)
        //{
            //Socket sock = new Socket();
            //sock.bind(new InetSocketAddress(port));
            //sock.connect(new InetSocketAddress(address, port));
            //return sock;
        //}
        //else
            //return new Socket(address, port);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.834 -0400", hash_original_field = "4B8E9A9A303C63C1FBAF973B562E572A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

