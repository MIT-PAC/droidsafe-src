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
    private SSLSocketFactory sslSocketFactory;
    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.804 -0400", hash_original_method = "E0E59DE264556EE5E620A1F868DD9E92", hash_generated_method = "8D91C7065670C6DA957D2395C2BB654A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslNetworkLayer(
            String trustStoreFile,
            String keyStoreFile,
            char[] keyStorePassword,
            String keyStoreType) throws GeneralSecurityException, FileNotFoundException, IOException {
        dsTaint.addTaint(trustStoreFile);
        dsTaint.addTaint(keyStoreType);
        dsTaint.addTaint(keyStoreFile);
        dsTaint.addTaint(keyStorePassword[0]);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.805 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "3749BF1D406D4DEBCA40A860689D11AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(bindAddress.dsTaint);
        ServerSocket varBB07E4E456D0E00DF1C5BECA6716C41C_1592541883 = (new ServerSocket(port, backlog, bindAddress));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.805 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "6ED1B5476E5692255475142AC44256E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        Socket varE328213FDE008DF2462029BE5D05E3CF_1127902877 = (new Socket(address, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.805 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "24C8501E6B9BE26EC41384CE88203582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket var616282B8D8BD448F2F7B4899DB11058F_1893131198 = (new DatagramSocket());
        return (DatagramSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.806 -0400", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "4D47214A540F1EE1BCEA1B37560A531D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(laddr.dsTaint);
        DatagramSocket varBA9B41FBDA31CC8ECB84426AF29A230B_1352943732 = (new DatagramSocket(port, laddr));
        return (DatagramSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DatagramSocket(port, laddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.806 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "AAE20B7F56403C5022CC53433F7665A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(bindAddress.dsTaint);
        SSLServerSocket varE469ECFA569E320D1CA61D8EA1020910_1290870745 = ((SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress));
        return (SSLServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.806 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "806B873DEB611286EF10CC6C080C19CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        SSLSocket varA46E2800932F2A3F5433F40C1DDDE16E_133180353 = ((SSLSocket) sslSocketFactory.createSocket(address, port));
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.806 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "1437A7D62D356643F41FBE8C07F79A7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        SSLSocket var844D7D8EC83C87826688FA27F8FC4A21_1784397590 = ((SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0));
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.806 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "D60761722BF0E78206448833477A1AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        Socket varD8347E7E96D2D15C40BE55D901E6E073_1463296287 = (new Socket(address, port, myAddress, 0));
        Socket varE328213FDE008DF2462029BE5D05E3CF_1477137182 = (new Socket(address, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.807 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "47A79C1897114EA636A84E632F50780C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(myPort);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        Socket varDF5A8CBB67556C2E0D5645E8B4031632_1650828824 = (new Socket(address, port, myAddress, myPort));
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
        } //End block
        Socket varE328213FDE008DF2462029BE5D05E3CF_1106381641 = (new Socket(address, port));
        return (Socket)dsTaint.getTaint();
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

