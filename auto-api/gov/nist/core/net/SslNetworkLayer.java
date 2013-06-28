package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SslNetworkLayer implements NetworkLayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.967 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.967 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.968 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "9EB50DE81D4AD14631E390B0E8E6A050")
    public  SslNetworkLayer(
            String trustStoreFile,
            String keyStoreFile,
            char[] keyStorePassword,
            String keyStoreType) throws GeneralSecurityException, FileNotFoundException, IOException {
        SSLContext sslContext;
        sslContext = SSLContext.getInstance("TLS");
        String algorithm = KeyManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmFactory = TrustManagerFactory.getInstance(algorithm);
        KeyManagerFactory kmFactory = KeyManagerFactory.getInstance(algorithm);
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        KeyStore trustStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(new FileInputStream(keyStoreFile), keyStorePassword);
        trustStore.load(new FileInputStream(trustStoreFile), keyStorePassword);
        tmFactory.init(trustStore);
        kmFactory.init(keyStore, keyStorePassword);
        sslContext.init(kmFactory.getKeyManagers(), tmFactory.getTrustManagers(), secureRandom);
        sslServerSocketFactory = sslContext.getServerSocketFactory();
        sslSocketFactory = sslContext.getSocketFactory();
        addTaint(trustStoreFile.getTaint());
        addTaint(keyStoreFile.getTaint());
        addTaint(keyStorePassword[0]);
        addTaint(keyStoreType.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.969 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "C7F74143CFD4B3F7EA6CBFF0C9CB1E29")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1259581150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1259581150 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1259581150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1259581150;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.969 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "5F1D7A8DC180FF06CF3F2DB1591EB498")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1394460156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1394460156 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1394460156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1394460156;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.970 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "2276E98F4074F214345D733DB42B7B31")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1748463433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748463433 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1748463433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748463433;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.971 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "F7468CC07CB740CD1BF1F48B7467D030")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1265242507 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1265242507 = new DatagramSocket(port, laddr);
        addTaint(port);
        addTaint(laddr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1265242507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265242507;
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.971 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "65D92C6E5A86B2FD41AA94004CA61BF6")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_644375445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_644375445 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_644375445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644375445;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.972 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "FF95CF1042177DECFA642D26B10E1301")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1569256361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1569256361 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1569256361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1569256361;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.972 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "BCEB03617440A7E0131C3BDBD8B2FB79")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1432550109 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1432550109 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1432550109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432550109;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.973 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "3070E634D8DDA178F2D94C5F2257B548")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_432936300 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1153183215 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_432936300 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1153183215 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_1929171308; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1929171308 = varB4EAC82CA7396A68D541C85D26508E83_432936300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1929171308 = varB4EAC82CA7396A68D541C85D26508E83_1153183215;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1929171308.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1929171308;
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.974 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "9773FA1F1F357E9B43667A7A651D0E49")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1300174333 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1905009653 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_1644143312 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1300174333 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_1905009653 = sock;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1644143312 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_988689976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_988689976 = varB4EAC82CA7396A68D541C85D26508E83_1300174333;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_988689976 = varB4EAC82CA7396A68D541C85D26508E83_1905009653;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_988689976 = varB4EAC82CA7396A68D541C85D26508E83_1644143312;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_988689976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_988689976;
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

    
}

