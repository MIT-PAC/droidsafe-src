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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.814 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.814 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.815 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "0CD8920B3A530EF109887AFD2CA11F0E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.816 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "073FB6BF4DAD9C2D5A0C3F1627CB14B4")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varE4B9B613713A284A68E30C41D0180672_1985476699 =         new ServerSocket(port, backlog, bindAddress);
        varE4B9B613713A284A68E30C41D0180672_1985476699.addTaint(taint);
        return varE4B9B613713A284A68E30C41D0180672_1985476699;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.816 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "BE7AC7D758C835BFDDD243220DAF3C08")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
Socket var5E79725D08CDDFD22D09C6C43A37CB90_962534980 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_962534980.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_962534980;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.816 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "FDA8F4787855E4A77E655ADA841E596D")
    public DatagramSocket createDatagramSocket() throws SocketException {
DatagramSocket varF3F5BFEAD339A7B18CCDB5E45144558F_12525727 =         new DatagramSocket();
        varF3F5BFEAD339A7B18CCDB5E45144558F_12525727.addTaint(taint);
        return varF3F5BFEAD339A7B18CCDB5E45144558F_12525727;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.817 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "E430041D4C9913C2A5063F3AE647678B")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        addTaint(laddr.getTaint());
        addTaint(port);
DatagramSocket var820EBD96BF02810AC98BFD2304C9D9D4_118765032 =         new DatagramSocket(port, laddr);
        var820EBD96BF02810AC98BFD2304C9D9D4_118765032.addTaint(taint);
        return var820EBD96BF02810AC98BFD2304C9D9D4_118765032;
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.817 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "CAC81632BE0CECC2B32EEE9A1305DB12")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
SSLServerSocket varDB234CDB256B380882CFCA310DE2E9A9_1934758876 =         (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        varDB234CDB256B380882CFCA310DE2E9A9_1934758876.addTaint(taint);
        return varDB234CDB256B380882CFCA310DE2E9A9_1934758876;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.817 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "C1BCFBA8B620941EE058A4CC8D9C3D31")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket var49B70040270D50337C2159532A57C2F2_1603367753 =         (SSLSocket) sslSocketFactory.createSocket(address, port);
        var49B70040270D50337C2159532A57C2F2_1603367753.addTaint(taint);
        return var49B70040270D50337C2159532A57C2F2_1603367753;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.818 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "36F5D2B1C14AFFA1A357323F4ED39CB4")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket varEF759514F740B9EA798E50D9AB0AAE35_781810008 =         (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        varEF759514F740B9EA798E50D9AB0AAE35_781810008.addTaint(taint);
        return varEF759514F740B9EA798E50D9AB0AAE35_781810008;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.818 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "1686FF4FEE0984BD36D2FA677FFB0C72")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        if(myAddress != null)        
        {
Socket varC993D01A4A0021129635B26049A65900_792876898 =         new Socket(address, port, myAddress, 0);
        varC993D01A4A0021129635B26049A65900_792876898.addTaint(taint);
        return varC993D01A4A0021129635B26049A65900_792876898;
        }
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_693054723 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_693054723.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_693054723;
        }
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.819 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "0D3056FAA999B651222DFB80AAFCB103")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        addTaint(myPort);
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        if(myAddress != null)        
        {
Socket var714C0A100CD3A7064A2EB768AEC78FF6_1008649637 =         new Socket(address, port, myAddress, myPort);
        var714C0A100CD3A7064A2EB768AEC78FF6_1008649637.addTaint(taint);
        return var714C0A100CD3A7064A2EB768AEC78FF6_1008649637;
        }
        else
        if(port != 0)        
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
Socket var947470A701CF490B15CD8DA4BCF73C48_230226561 =             sock;
            var947470A701CF490B15CD8DA4BCF73C48_230226561.addTaint(taint);
            return var947470A701CF490B15CD8DA4BCF73C48_230226561;
        } //End block
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_1161473187 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_1161473187.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_1161473187;
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

