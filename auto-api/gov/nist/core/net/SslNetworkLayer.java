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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.974 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.974 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.975 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "5C3EB5049AD513D5B6389035B88F6AB9")
    public  SslNetworkLayer(
            String trustStoreFile,
            String keyStoreFile,
            char[] keyStorePassword,
            String keyStoreType) throws GeneralSecurityException, FileNotFoundException, IOException {
        SSLContext sslContext;
        sslContext = SSLContext.getInstance("TLS");
        String algorithm;
        algorithm = KeyManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmFactory;
        tmFactory = TrustManagerFactory.getInstance(algorithm);
        KeyManagerFactory kmFactory;
        kmFactory = KeyManagerFactory.getInstance(algorithm);
        SecureRandom secureRandom;
        secureRandom = new SecureRandom();
        secureRandom.nextInt();
        KeyStore keyStore;
        keyStore = KeyStore.getInstance(keyStoreType);
        KeyStore trustStore;
        trustStore = KeyStore.getInstance(keyStoreType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.978 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "4A179F0624F499659C4764D3F97338A9")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_193845498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_193845498 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_193845498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_193845498;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.982 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "6C924D3FA64A71C1E75FF3A3ED5DD72C")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_558341058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_558341058 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_558341058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_558341058;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.983 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "49052F518ECD679D8542B17787D27511")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1668906346 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1668906346 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1668906346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1668906346;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.992 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "EB9B622E572B60E8949CD9826563B725")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_2069552966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2069552966 = new DatagramSocket(port, laddr);
        addTaint(port);
        addTaint(laddr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2069552966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069552966;
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.992 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "C3832C872666E2DAE953F0E555FB6C83")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_220601466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_220601466 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_220601466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_220601466;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.993 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "C594A029E3EFF5BD03A00EE1AE056DEC")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1944345285 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1944345285 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1944345285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1944345285;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.003 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "9638E8C6CC633299520494CFCF7D7297")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_425224261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_425224261 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_425224261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_425224261;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.006 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "4001E57F2797AF772035F81E2B3C00E3")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1253090309 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_2025885165 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1253090309 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_2025885165 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_1248508791; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1248508791 = varB4EAC82CA7396A68D541C85D26508E83_1253090309;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1248508791 = varB4EAC82CA7396A68D541C85D26508E83_2025885165;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1248508791.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1248508791;
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.016 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "C6DBC7DBD0E5490A866A036D9A065FA4")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1508794068 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_199832431 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_898015256 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1508794068 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_199832431 = sock;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_898015256 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_836668511; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_836668511 = varB4EAC82CA7396A68D541C85D26508E83_1508794068;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_836668511 = varB4EAC82CA7396A68D541C85D26508E83_199832431;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_836668511 = varB4EAC82CA7396A68D541C85D26508E83_898015256;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_836668511.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_836668511;
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

