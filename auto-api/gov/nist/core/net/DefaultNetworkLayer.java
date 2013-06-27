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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.489 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.490 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.490 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    private  DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        // ---------- Original Method ----------
        //sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                //.getDefault();
        //sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.509 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "3E19B0C4301AAB10B5064B78DE3DF485")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_505568401 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_505568401 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_505568401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_505568401;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.509 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "780E9DDDA950B1452BCBCB8FCA08A88F")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_973717317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_973717317 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_973717317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_973717317;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.510 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "E864A2EC2CE38D484B8D450D6492EAA5")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_557250627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_557250627 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_557250627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557250627;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.510 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "63E72FC2E03B2E3C1D045F76985C60C0")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_129800729 = null; //Variable for return #1
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1137484289 = null; //Variable for return #2
        {
            boolean var8D87C811DF441B215A5F938090F85822_1802737736 = (laddr.isMulticastAddress());
            {
                try 
                {
                    MulticastSocket ds;
                    ds = new MulticastSocket( port );
                    ds.joinGroup( laddr );
                    varB4EAC82CA7396A68D541C85D26508E83_129800729 = ds;
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException( e.getLocalizedMessage() );
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1137484289 = new DatagramSocket(port, laddr);
        } //End collapsed parenthetic
        addTaint(port);
        addTaint(laddr.getTaint());
        DatagramSocket varA7E53CE21691AB073D9660D615818899_952876162; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_952876162 = varB4EAC82CA7396A68D541C85D26508E83_129800729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_952876162 = varB4EAC82CA7396A68D541C85D26508E83_1137484289;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_952876162.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_952876162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.511 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "45FB7581753AD3AE2728AA266651DE57")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_1913339030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1913339030 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1913339030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1913339030;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.521 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "1DE7CC55EBB37E5BD9792C39B181FA4C")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_2058087926 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2058087926 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_2058087926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058087926;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.521 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "6253233D0A2441E6E89638CB072F7121")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1632613016 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1632613016 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1632613016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1632613016;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.522 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "3FA053B518AFB0FC9FA1D5AA4DFDC121")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1167620845 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1798499487 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1167620845 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1798499487 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_1417728410; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1417728410 = varB4EAC82CA7396A68D541C85D26508E83_1167620845;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1417728410 = varB4EAC82CA7396A68D541C85D26508E83_1798499487;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1417728410.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1417728410;
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.542 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "B39C27B419214D1840810A4ED25EE1C2")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1271659043 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_988096722 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_1948352245 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1271659043 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_988096722 = sock;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1948352245 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_1433428795; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1433428795 = varB4EAC82CA7396A68D541C85D26508E83_1271659043;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1433428795 = varB4EAC82CA7396A68D541C85D26508E83_988096722;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1433428795 = varB4EAC82CA7396A68D541C85D26508E83_1948352245;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1433428795.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1433428795;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.542 -0400", hash_original_field = "4B8E9A9A303C63C1FBAF973B562E572A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

