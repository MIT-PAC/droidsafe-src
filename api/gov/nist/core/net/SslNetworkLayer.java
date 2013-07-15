package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.864 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.864 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.865 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "0CD8920B3A530EF109887AFD2CA11F0E")
    public  SslNetworkLayer(
            String trustStoreFile,
            String keyStoreFile,
            char[] keyStorePassword,
            String keyStoreType) throws GeneralSecurityException, FileNotFoundException, IOException {
        addTaint(keyStoreType.getTaint());
        addTaint(keyStorePassword[0]);
        addTaint(keyStoreFile.getTaint());
        addTaint(trustStoreFile.getTaint());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.865 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "C8C3E4ACDFC5B549CF031BDBE84078EC")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varE4B9B613713A284A68E30C41D0180672_2046904473 =         new ServerSocket(port, backlog, bindAddress);
        varE4B9B613713A284A68E30C41D0180672_2046904473.addTaint(taint);
        return varE4B9B613713A284A68E30C41D0180672_2046904473;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.865 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "CC153095CE470BC455BAF8EB7C2DE49C")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
Socket var5E79725D08CDDFD22D09C6C43A37CB90_1193215831 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_1193215831.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_1193215831;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.866 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "10BF69729305AD25930CFCD4F0F44640")
    public DatagramSocket createDatagramSocket() throws SocketException {
DatagramSocket varF3F5BFEAD339A7B18CCDB5E45144558F_1343868113 =         new DatagramSocket();
        varF3F5BFEAD339A7B18CCDB5E45144558F_1343868113.addTaint(taint);
        return varF3F5BFEAD339A7B18CCDB5E45144558F_1343868113;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.866 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "1A21C8394D96B427E86F5F89154099E9")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        addTaint(laddr.getTaint());
        addTaint(port);
DatagramSocket var820EBD96BF02810AC98BFD2304C9D9D4_1005801266 =         new DatagramSocket(port, laddr);
        var820EBD96BF02810AC98BFD2304C9D9D4_1005801266.addTaint(taint);
        return var820EBD96BF02810AC98BFD2304C9D9D4_1005801266;
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.866 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "B97603F9FCF4500AB5AD84D957C20FE7")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
SSLServerSocket varDB234CDB256B380882CFCA310DE2E9A9_1908167528 =         (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        varDB234CDB256B380882CFCA310DE2E9A9_1908167528.addTaint(taint);
        return varDB234CDB256B380882CFCA310DE2E9A9_1908167528;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.867 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "2CE3571803E45CF0CB7656F77F65FF59")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket var49B70040270D50337C2159532A57C2F2_1757160819 =         (SSLSocket) sslSocketFactory.createSocket(address, port);
        var49B70040270D50337C2159532A57C2F2_1757160819.addTaint(taint);
        return var49B70040270D50337C2159532A57C2F2_1757160819;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.867 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "13D04CDCC685B820212B03B920B2FBB9")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket varEF759514F740B9EA798E50D9AB0AAE35_1735951031 =         (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        varEF759514F740B9EA798E50D9AB0AAE35_1735951031.addTaint(taint);
        return varEF759514F740B9EA798E50D9AB0AAE35_1735951031;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.868 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "F6CBC2C966CB470687EC3963720E9E29")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
    if(myAddress != null)        
        {
Socket varC993D01A4A0021129635B26049A65900_706369887 =         new Socket(address, port, myAddress, 0);
        varC993D01A4A0021129635B26049A65900_706369887.addTaint(taint);
        return varC993D01A4A0021129635B26049A65900_706369887;
        }
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_980601886 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_980601886.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_980601886;
        }
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.869 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "9F3CE4BE1387F352CBC27DA4B9951A5F")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        addTaint(myPort);
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
    if(myAddress != null)        
        {
Socket var714C0A100CD3A7064A2EB768AEC78FF6_1495300785 =         new Socket(address, port, myAddress, myPort);
        var714C0A100CD3A7064A2EB768AEC78FF6_1495300785.addTaint(taint);
        return var714C0A100CD3A7064A2EB768AEC78FF6_1495300785;
        }
        else
    if(port != 0)        
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
Socket var947470A701CF490B15CD8DA4BCF73C48_188580761 =             sock;
            var947470A701CF490B15CD8DA4BCF73C48_188580761.addTaint(taint);
            return var947470A701CF490B15CD8DA4BCF73C48_188580761;
        } //End block
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_1965201860 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_1965201860.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_1965201860;
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

    
}

