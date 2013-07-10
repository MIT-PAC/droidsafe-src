package gov.nist.core.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.942 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.942 -0400", hash_original_field = "6CC693A32FE44C27FC3FF8CA3F98D72A", hash_generated_field = "C44352573933B1EA5CAC2388C9289B1C")

    private SSLServerSocketFactory sslServerSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.943 -0400", hash_original_method = "253BE5EB0B43BB49D7A03BB30C32FCC9", hash_generated_method = "0990CB06845B3FD8AC96DB452D8D6622")
    private  DefaultNetworkLayer() {
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.944 -0400", hash_original_method = "39DE8B0183FF9C9623367868EEA6CEAD", hash_generated_method = "27F149563A11F043554AEE65F32750CD")
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1754184522 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1754184522 = new ServerSocket(port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1754184522.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1754184522;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.945 -0400", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "EA1E9FA0EC3A12C80786E01AADC80659")
    public Socket createSocket(InetAddress address, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1099812734 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1099812734 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1099812734.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1099812734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.946 -0400", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "727A6848F485DB45368CF76A5E7A7827")
    public DatagramSocket createDatagramSocket() throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1957840048 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1957840048 = new DatagramSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1957840048.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1957840048;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.947 -0400", hash_original_method = "4F640C1CCB147C7F781B27A2D6CB7BC7", hash_generated_method = "D3DC95CB45302EAC5ED4015162DEAF06")
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_1318475988 = null; 
        DatagramSocket varB4EAC82CA7396A68D541C85D26508E83_388272903 = null; 
        {
            boolean var8D87C811DF441B215A5F938090F85822_364477303 = (laddr.isMulticastAddress());
            {
                try 
                {
                    MulticastSocket ds = new MulticastSocket( port );
                    ds.joinGroup( laddr );
                    varB4EAC82CA7396A68D541C85D26508E83_1318475988 = ds;
                } 
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException( e.getLocalizedMessage() );
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_388272903 = new DatagramSocket(port, laddr);
        } 
        addTaint(port);
        addTaint(laddr.getTaint());
        DatagramSocket varA7E53CE21691AB073D9660D615818899_777831200; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_777831200 = varB4EAC82CA7396A68D541C85D26508E83_1318475988;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_777831200 = varB4EAC82CA7396A68D541C85D26508E83_388272903;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_777831200.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_777831200;
        
        
            
                
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.947 -0400", hash_original_method = "C136B26924FEF16657D19F16D9E45E07", hash_generated_method = "B88B93DD4BA2DFF0B692F1DE2E2BC6A2")
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException {
        SSLServerSocket varB4EAC82CA7396A68D541C85D26508E83_481444586 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_481444586 = (SSLServerSocket) sslServerSocketFactory.createServerSocket(
                port, backlog, bindAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(bindAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_481444586.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_481444586;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.948 -0400", hash_original_method = "A69DB4651ABD80BB673808D27D01239A", hash_generated_method = "186E6A4ED65C2C79438F1E2784AE7F85")
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1990320917 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1990320917 = (SSLSocket) sslSocketFactory.createSocket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1990320917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990320917;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.948 -0400", hash_original_method = "42E28448C903215260E4CCA841EF7FB7", hash_generated_method = "53F5C4746BAA954243D7DC8F9649E314")
    public SSLSocket createSSLSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_864927853 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_864927853 = (SSLSocket) sslSocketFactory.createSocket(address, port,
                myAddress, 0);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_864927853.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_864927853;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.949 -0400", hash_original_method = "65BD7B891ADF1B016345452655A0F82B", hash_generated_method = "0917886656CA4B4E07C7C69FCFD39052")
    public Socket createSocket(InetAddress address, int port,
            InetAddress myAddress) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1491380555 = null; 
        Socket varB4EAC82CA7396A68D541C85D26508E83_879406291 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1491380555 = new Socket(address, port, myAddress, 0);
        varB4EAC82CA7396A68D541C85D26508E83_879406291 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_1535643231; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1535643231 = varB4EAC82CA7396A68D541C85D26508E83_1491380555;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1535643231 = varB4EAC82CA7396A68D541C85D26508E83_879406291;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1535643231.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1535643231;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.949 -0400", hash_original_method = "79DF1B5079137D62C29C5EAC0F3F40E2", hash_generated_method = "F52A94743B27D1F5FC0795E67EB987D8")
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2003616380 = null; 
        Socket varB4EAC82CA7396A68D541C85D26508E83_1614484333 = null; 
        Socket varB4EAC82CA7396A68D541C85D26508E83_2142837334 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2003616380 = new Socket(address, port, myAddress, myPort);
        {
            Socket sock = new Socket();
            sock.bind(new InetSocketAddress(port));
            sock.connect(new InetSocketAddress(address, port));
            varB4EAC82CA7396A68D541C85D26508E83_1614484333 = sock;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2142837334 = new Socket(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(myAddress.getTaint());
        addTaint(myPort);
        Socket varA7E53CE21691AB073D9660D615818899_1542201771; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1542201771 = varB4EAC82CA7396A68D541C85D26508E83_2003616380;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1542201771 = varB4EAC82CA7396A68D541C85D26508E83_1614484333;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1542201771 = varB4EAC82CA7396A68D541C85D26508E83_2142837334;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1542201771.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1542201771;
        
        
            
        
        
            
            
            
            
        
        
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.949 -0400", hash_original_field = "4B8E9A9A303C63C1FBAF973B562E572A", hash_generated_field = "4E42397BE6B55C66A78B822DB003C509")

    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
}

