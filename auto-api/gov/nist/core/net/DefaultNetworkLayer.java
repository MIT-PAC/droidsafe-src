package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.954 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.954 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.955 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    private  DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        // ---------- Original Method ----------
        //sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                //.getDefault();
        //sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.955 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "A5A6C47E41230B6451AA91483CEDAEED")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_747994460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_747994460 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_747994460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747994460;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.961 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "D1E10AC112871128616DCCB26BDD51C7")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1660022665 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660022665 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1660022665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660022665;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.961 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "3325AC444D04B872202C3E72E9F6E4A8")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1589541636 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589541636 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1589541636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589541636;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.963 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "08D5181D817E252E39CDF489E2F14F4E")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_119141337 = null; //Variable for return #1
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_919144434 = null; //Variable for return #2
        {
            boolean var8D87C811DF441B215A5F938090F85822_307932677 = (laddr.isMulticastAddress());
            {
                try 
                {
                    MulticastSocket ds;
                    ds = new MulticastSocket( port );
                    ds.joinGroup( laddr );
                    varB4EAC82CA7396A68D541C85D26508E83_119141337 = ds;
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException( e.getLocalizedMessage() );
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_919144434 = new DatagramSocket(port, laddr);
        } //End collapsed parenthetic
        addTaint(port);
        addTaint(laddr.getTaint());
        DatagramSocket varA7E53CE21691AB073D9660D615818899_297622804; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_297622804 = varB4EAC82CA7396A68D541C85D26508E83_119141337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_297622804 = varB4EAC82CA7396A68D541C85D26508E83_919144434;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_297622804.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_297622804;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.964 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "97E264962AF0BA68C2967FE5EDC1CB8F")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_2113087188 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2113087188 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2113087188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2113087188;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.981 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "480D492702CA58B122E7C7E06D8603A9")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_340394527 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_340394527 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_340394527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340394527;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.982 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "940C88E9F6AE0D8865987B1FC9F20B08")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1835728084 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1835728084 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1835728084.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1835728084;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.997 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "0E8BE9CAE41CD91FA1CF985E9FC91836")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_75849851 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1441188038 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_75849851 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1441188038 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_1815632911; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1815632911 = varB4EAC82CA7396A68D541C85D26508E83_75849851;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1815632911 = varB4EAC82CA7396A68D541C85D26508E83_1441188038;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1815632911.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1815632911;
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.999 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "25C6791F0515ACE95D6CF19A1D656D58")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1213469056 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_108199047 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_1731535942 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1213469056 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_108199047 = sock;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1731535942 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_1238974492; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1238974492 = varB4EAC82CA7396A68D541C85D26508E83_1213469056;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1238974492 = varB4EAC82CA7396A68D541C85D26508E83_108199047;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1238974492 = varB4EAC82CA7396A68D541C85D26508E83_1731535942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1238974492.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1238974492;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.002 -0400", hash_original_field = "4B8E9A9A303C63C1FBAF973B562E572A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

