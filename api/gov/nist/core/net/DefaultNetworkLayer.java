package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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






public class DefaultNetworkLayer implements NetworkLayer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.361 -0500", hash_original_field = "AE5611103FD171303C58566B8F3BD14A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.359 -0500", hash_original_field = "873903B7FC49F40C02995A48B85609AA", hash_generated_field = "87C1504631DE52B6388145B4A5898443")


    private SSLSocketFactory sslSocketFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.360 -0500", hash_original_field = "596C860C31BFBC55B01434387C8A8429", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")


    private SSLServerSocketFactory sslServerSocketFactory;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.362 -0500", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "8EC64ABFBC6307B7394D337F972301C7")
    private DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.363 -0500", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "1BD51730283515F4AFCEDA0F6A374960")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        return new ServerSocket(port, backlog, bindAddress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.364 -0500", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "D6FFC4235218375704698D3AC22AB6DF")
    public Socket createSocket(InetAddress address, int port)
            throws IOException {
        return new Socket(address, port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.364 -0500", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "23A41768FB0B8E7E2E1730BDCDF4AD35")
    public DatagramSocket createDatagramSocket() throws SocketException {
        return new DatagramSocket();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.365 -0500", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "CB03737379E4EF4E7C41F34A6B4DB0F1")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr)
            throws SocketException {

        if ( laddr.isMulticastAddress() ) {
            try {
                MulticastSocket ds = new MulticastSocket( port );
                ds.joinGroup( laddr );
                return ds;
            } catch (IOException e) {
                throw new SocketException( e.getLocalizedMessage() );
            }
        } else return new DatagramSocket(port, laddr);
    }

    /* Added by Daniel J. Martinez Manzano <dani@dif.um.es> */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.366 -0500", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "119688E8F055C3ADFB57FC6749AD2BF6")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
    }

    /* Added by Daniel J. Martinez Manzano <dani@dif.um.es> */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.367 -0500", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "8CC4B058898211158438279B7ED5D174")
    public SSLSocket createSSLSocket(InetAddress address, int port)
            throws IOException {
        return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    /* Added by Daniel J. Martinez Manzano <dani@dif.um.es> */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.368 -0500", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "BF42325DE07BE9E5E07B9ECBECCB83DA")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        return (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.369 -0500", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "805699B089AE9CB9805E5633E9A8A132")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        if (myAddress != null)
            return new Socket(address, port, myAddress, 0);
        else
            return new Socket(address, port);
    }

    /**
     * Creates a new Socket, binds it to myAddress:myPort and connects it to
     * address:port.
     *
     * @param address the InetAddress that we'd like to connect to.
     * @param port the port that we'd like to connect to
     * @param myAddress the address that we are supposed to bind on or null
     *        for the "any" address.
     * @param myPort the port that we are supposed to bind on or 0 for a random
     * one.
     *
     * @return a new Socket, bound on myAddress:myPort and connected to
     * address:port.
     * @throws IOException if binding or connecting the socket fail for a reason
     * (exception relayed from the correspoonding Socket methods)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:13.370 -0500", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "A015978186413157B4AD18DBEEDB9864")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort)
        throws IOException
    {
        if (myAddress != null)
            return new Socket(address, port, myAddress, myPort);
        else if (port != 0)
        {
            //myAddress is null (i.e. any)  but we have a port number
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            return sock;
        }
        else
            return new Socket(address, port);
    }
}

