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
    private SSLSocketFactory sslSocketFactory;
    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.794 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        // ---------- Original Method ----------
        //sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                //.getDefault();
        //sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.794 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "9B00FEE8666E6C75D40FE31F5AF442E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(bindAddress.dsTaint);
        ServerSocket varBB07E4E456D0E00DF1C5BECA6716C41C_2016066200 = (new ServerSocket(port, backlog, bindAddress));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.795 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "619004CF69C66888838A9A4F9ECF030E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        Socket varE328213FDE008DF2462029BE5D05E3CF_1720446959 = (new Socket(address, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.795 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "2061D97DCD8285BAEED3F0F472BD75B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket var616282B8D8BD448F2F7B4899DB11058F_893956237 = (new DatagramSocket());
        return (DatagramSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DatagramSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.795 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "DB54A9681480E0AE051D68B722D22B3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(laddr.dsTaint);
        {
            boolean var8D87C811DF441B215A5F938090F85822_1321625921 = (laddr.isMulticastAddress());
            {
                try 
                {
                    MulticastSocket ds;
                    ds = new MulticastSocket( port );
                    ds.joinGroup( laddr );
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException( e.getLocalizedMessage() );
                } //End block
            } //End block
            DatagramSocket var0E0A9233478F30838F994CABDCEF33A9_419957156 = (new DatagramSocket(port, laddr));
        } //End collapsed parenthetic
        return (DatagramSocket)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.795 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "99998F81D3C0E0AF4B207D2E0EF1F070")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(bindAddress.dsTaint);
        SSLServerSocket var6DE5C25C4F04B5A5569F4AD0760A60C2_550778236 = ((SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress));
        return (SSLServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                //port, backlog, bindAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.796 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "1215C61D9A21174F69AE660F7266D0E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        SSLSocket varA46E2800932F2A3F5433F40C1DDDE16E_1245896294 = ((SSLSocket) sslSocketFactory.createSocket(address, port));
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.796 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "080510231DBD51C70C19E3E7028F24B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        SSLSocket var06F050A104C68FC6096B4B9F9BCC8DE0_500739068 = ((SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0));
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) sslSocketFactory.createSocket(address, port,
                //myAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.796 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "EBF79CDD32D59835966C6AE4063E73BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        Socket varD8347E7E96D2D15C40BE55D901E6E073_1165443815 = (new Socket(address, port, myAddress, 0));
        Socket varE328213FDE008DF2462029BE5D05E3CF_338987258 = (new Socket(address, port));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (myAddress != null)
            //return new Socket(address, port, myAddress, 0);
        //else
            //return new Socket(address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.796 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "8B43CA40070F44026D01A38BFC4C96FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(myPort);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(myAddress.dsTaint);
        Socket varDF5A8CBB67556C2E0D5645E8B4031632_180658510 = (new Socket(address, port, myAddress, myPort));
        {
            Socket sock;
            sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
        } //End block
        Socket varE328213FDE008DF2462029BE5D05E3CF_1297381365 = (new Socket(address, port));
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

    
    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

