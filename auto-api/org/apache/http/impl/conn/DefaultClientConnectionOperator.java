package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketException;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;

public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.459 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.460 -0400", hash_original_method = "564A7128C5B00F982644F6E1BD9B5118", hash_generated_method = "A9580C4EB874A290BB0BFB80A838049D")
    public  DefaultClientConnectionOperator(SchemeRegistry schemes) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        } 
        schemeRegistry = schemes;
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.460 -0400", hash_original_method = "A7AF136A36340299371F158C25AED0D2", hash_generated_method = "A9E954E902E9CA7A24E9192F57553985")
    public OperatedClientConnection createConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1528837502 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1528837502 = new DefaultClientConnection();
        varB4EAC82CA7396A68D541C85D26508E83_1528837502.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1528837502;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.461 -0400", hash_original_method = "3035FF1473A97381B4AFABBF5B73F76A", hash_generated_method = "8C410154A037228D28A8799A649F78B8")
    public void openConnection(OperatedClientConnection conn,
                               HttpHost target,
                               InetAddress local,
                               HttpContext context,
                               HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean var451F9CCFC44B4276E736FF79EDEE8975_1958705287 = (conn.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be open.");
            } 
        } 
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        final SocketFactory sf = schm.getSocketFactory();
        SocketFactory plain_sf;
        LayeredSocketFactory layered_sf;
        {
            plain_sf = staticPlainSocketFactory;
            layered_sf = (LayeredSocketFactory)sf;
        } 
        {
            plain_sf = sf;
            layered_sf = null;
        } 
        InetAddress[] addresses = InetAddress.getAllByName(target.getHostName());
        {
            int i = 0;
            {
                Socket sock = plain_sf.createSocket();
                conn.opening(sock, target);
                try 
                {
                    Socket connsock = plain_sf.connectSocket(sock,
                    addresses[i].getHostAddress(),
                    schm.resolvePort(target.getPort()),
                    local, 0, params);
                    {
                        sock = connsock;
                        conn.opening(sock, target);
                    } 
                    prepareSocket(sock, context, params);
                    {
                        Socket layeredsock = layered_sf.createSocket(sock,
                        target.getHostName(),
                        schm.resolvePort(target.getPort()),
                        true);
                        {
                            conn.opening(layeredsock, target);
                        } 
                        conn.openCompleted(sf.isSecure(layeredsock), params);
                    } 
                    {
                        conn.openCompleted(sf.isSecure(sock), params);
                    } 
                } 
                catch (SocketException ex)
                {
                    {
                        ConnectException cause;
                        cause = (ConnectException) ex;
                        cause = new ConnectException(ex.getMessage(), ex);
                        if (DroidSafeAndroidRuntime.control) throw new HttpHostConnectException(target, cause);
                    } 
                } 
                catch (ConnectTimeoutException ex)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw ex;
                    } 
                } 
            } 
        } 
        addTaint(conn.getTaint());
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.462 -0400", hash_original_method = "B263843ECB367B56A8B3543219BABBA8", hash_generated_method = "51892F327996794061F3CCE5A188CF85")
    public void updateSecureConnection(OperatedClientConnection conn,
                                       HttpHost target,
                                       HttpContext context,
                                       HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean varEE62DAC45DF15B922FA2904B06CCD4A8_1889929869 = (!conn.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must be open.");
            } 
        } 
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        {
            boolean varE5B8F3A69B1B6580727686D70B4E6436_1963860025 = (!(schm.getSocketFactory() instanceof LayeredSocketFactory));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target scheme (" + schm.getName() +
                 ") must have layered socket factory.");
            } 
        } 
        final LayeredSocketFactory lsf = (LayeredSocketFactory) schm.getSocketFactory();
        Socket sock = null;
        try 
        {
            sock = lsf.createSocket
                (conn.getSocket(), target.getHostName(), schm.resolvePort(target.getPort()), true);
        } 
        catch (ConnectException ex)
        {
        	throw new HttpHostConnectException(target, ex);
        } 
        prepareSocket(sock, context, params);
        conn.update(sock, target, lsf.isSecure(sock), params);
        addTaint(conn.getTaint());
        addTaint(target.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.462 -0400", hash_original_method = "EEE63DC836F5AA81B1ECC566DDEA88C5", hash_generated_method = "AC5AD7692653F1F52E7DF426050C3497")
    protected void prepareSocket(Socket sock, HttpContext context,
                                 HttpParams params) throws IOException {
        sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger = HttpConnectionParams.getLinger(params);
        {
            sock.setSoLinger(linger > 0, linger);
        } 
        addTaint(sock.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.462 -0400", hash_original_field = "BB491613B2AC25774C0C6E92214BF9B8", hash_generated_field = "117D19A17E0FA862F4540CD5E143142A")

    private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
}

