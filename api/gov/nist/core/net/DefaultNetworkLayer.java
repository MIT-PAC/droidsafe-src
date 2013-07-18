package gov.nist.core.net;

// Droidsafe Imports
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DefaultNetworkLayer implements NetworkLayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.789 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.789 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.789 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    private  DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        // ---------- Original Method ----------
        //sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                //.getDefault();
        //sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.790 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "267ED68E8F87E8B582A136D9AAB1AD73")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket varE4B9B613713A284A68E30C41D0180672_878585228 =         new ServerSocket(port, backlog, bindAddress);
        varE4B9B613713A284A68E30C41D0180672_878585228.addTaint(taint);
        return varE4B9B613713A284A68E30C41D0180672_878585228;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.791 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "E8BDF8A295F853355F391C3C2E8C3C1C")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
Socket var5E79725D08CDDFD22D09C6C43A37CB90_2133244391 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_2133244391.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_2133244391;
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.791 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "3A6C6C653F25902905866C375C4E11C0")
    public DatagramSocket createDatagramSocket() throws SocketException {
DatagramSocket varF3F5BFEAD339A7B18CCDB5E45144558F_1150985509 =         new DatagramSocket();
        varF3F5BFEAD339A7B18CCDB5E45144558F_1150985509.addTaint(taint);
        return varF3F5BFEAD339A7B18CCDB5E45144558F_1150985509;
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.792 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "554978AF49E94F4A911503A4CB38E781")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        addTaint(laddr.getTaint());
        addTaint(port);
        if(laddr.isMulticastAddress())        
        {
            try 
            {
                MulticastSocket ds = new MulticastSocket( port );
                ds.joinGroup( laddr );
DatagramSocket var326AB3082797E11390DC7F191D96A430_339717733 =                 ds;
                var326AB3082797E11390DC7F191D96A430_339717733.addTaint(taint);
                return var326AB3082797E11390DC7F191D96A430_339717733;
            } //End block
            catch (IOException e)
            {
                SocketException var064DCB284F4B19267BC3027A208CD5E6_1027145699 = new SocketException( e.getLocalizedMessage() );
                var064DCB284F4B19267BC3027A208CD5E6_1027145699.addTaint(taint);
                throw var064DCB284F4B19267BC3027A208CD5E6_1027145699;
            } //End block
        } //End block
        else
        {
DatagramSocket var820EBD96BF02810AC98BFD2304C9D9D4_600855685 =         new DatagramSocket(port, laddr);
        var820EBD96BF02810AC98BFD2304C9D9D4_600855685.addTaint(taint);
        return var820EBD96BF02810AC98BFD2304C9D9D4_600855685;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.792 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "B1C98F47646BDAE3FF707C7595BBCBF6")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        addTaint(bindAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
SSLServerSocket varDB234CDB256B380882CFCA310DE2E9A9_427848426 =         (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        varDB234CDB256B380882CFCA310DE2E9A9_427848426.addTaint(taint);
        return varDB234CDB256B380882CFCA310DE2E9A9_427848426;
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.793 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "8FEEF3C958797D1C4BE005665B509DEE")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket var49B70040270D50337C2159532A57C2F2_943111211 =         (SSLSocket) sslSocketFactory.createSocket(address, port);
        var49B70040270D50337C2159532A57C2F2_943111211.addTaint(taint);
        return var49B70040270D50337C2159532A57C2F2_943111211;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.793 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "C135FD9DA0DAAB85BBFA95D1A84BF869")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
SSLSocket varEF759514F740B9EA798E50D9AB0AAE35_797790975 =         (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        varEF759514F740B9EA798E50D9AB0AAE35_797790975.addTaint(taint);
        return varEF759514F740B9EA798E50D9AB0AAE35_797790975;
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.794 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "82BC5ACFD035CE425821963F03BA0F6C")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        if(myAddress != null)        
        {
Socket varC993D01A4A0021129635B26049A65900_1349973473 =         new Socket(address, port, myAddress, 0);
        varC993D01A4A0021129635B26049A65900_1349973473.addTaint(taint);
        return varC993D01A4A0021129635B26049A65900_1349973473;
        }
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_474205111 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_474205111.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_474205111;
        }
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.795 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "88A11A075B6E4F79DB514720E2190B40")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        addTaint(myPort);
        addTaint(myAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        if(myAddress != null)        
        {
Socket var714C0A100CD3A7064A2EB768AEC78FF6_606712840 =         new Socket(address, port, myAddress, myPort);
        var714C0A100CD3A7064A2EB768AEC78FF6_606712840.addTaint(taint);
        return var714C0A100CD3A7064A2EB768AEC78FF6_606712840;
        }
        else
        if(port != 0)        
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
Socket var947470A701CF490B15CD8DA4BCF73C48_789489182 =             sock;
            var947470A701CF490B15CD8DA4BCF73C48_789489182.addTaint(taint);
            return var947470A701CF490B15CD8DA4BCF73C48_789489182;
        } //End block
        else
        {
Socket var5E79725D08CDDFD22D09C6C43A37CB90_2145550500 =         new Socket(address, port);
        var5E79725D08CDDFD22D09C6C43A37CB90_2145550500.addTaint(taint);
        return var5E79725D08CDDFD22D09C6C43A37CB90_2145550500;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.795 -0400", hash_original_field = "4B8E9A9A303C63C1FBAF973B562E572A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

