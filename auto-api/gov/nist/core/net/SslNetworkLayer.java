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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.523 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.523 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.524 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "5C3EB5049AD513D5B6389035B88F6AB9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.525 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "E2DC8C90C36961761E0A1455579806F6")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_936683988 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_936683988 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_936683988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_936683988;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.532 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "542E0B6FD5C45FA3710C45B720C9C2A5")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_403335958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_403335958 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_403335958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_403335958;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.540 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "E910BA0064EA0CB16C0719CE74B6664A")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1047219271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1047219271 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1047219271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1047219271;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.540 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "12CA59DF2A9F7C956F8C9E764BFA76B3")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_173900512 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_173900512 = new DatagramSocket(port, laddr);
        addTaint(port);
        addTaint(laddr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_173900512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_173900512;
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.540 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "BDFC20C84B768178CD9ED3834908D202")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_1656975126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1656975126 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1656975126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1656975126;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.541 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "491694202B67C6E34348EA5CF2BCB924")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_379674187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_379674187 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_379674187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379674187;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.541 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "79795C705CCC559DDCC68357F046D797")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1610732093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1610732093 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1610732093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610732093;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.545 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "89F2CCFB51468C628D718CB8AC831623")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1189734274 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_2068684744 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1189734274 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_2068684744 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_562323299; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_562323299 = varB4EAC82CA7396A68D541C85D26508E83_1189734274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_562323299 = varB4EAC82CA7396A68D541C85D26508E83_2068684744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_562323299.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_562323299;
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.557 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "4BA00F5BC17358E6298DEF9D008F8BD8")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1213794550 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1073652053 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_1027131470 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1213794550 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_1073652053 = sock;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1027131470 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_1323674176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1323674176 = varB4EAC82CA7396A68D541C85D26508E83_1213794550;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1323674176 = varB4EAC82CA7396A68D541C85D26508E83_1073652053;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1323674176 = varB4EAC82CA7396A68D541C85D26508E83_1027131470;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1323674176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1323674176;
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

