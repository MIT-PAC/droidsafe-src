package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.745 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.745 -0400", hash_original_method = "564A7128C5B00F982644F6E1BD9B5118", hash_generated_method = "A9580C4EB874A290BB0BFB80A838049D")
    public  DefaultClientConnectionOperator(SchemeRegistry schemes) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        } //End block
        schemeRegistry = schemes;
        // ---------- Original Method ----------
        //if (schemes == null) {
            //throw new IllegalArgumentException
                //("Scheme registry must not be null.");
        //}
        //schemeRegistry = schemes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.746 -0400", hash_original_method = "A7AF136A36340299371F158C25AED0D2", hash_generated_method = "3A1457180226B1712F8CD86D36191401")
    public OperatedClientConnection createConnection() {
        OperatedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1231578915 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1231578915 = new DefaultClientConnection();
        varB4EAC82CA7396A68D541C85D26508E83_1231578915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1231578915;
        // ---------- Original Method ----------
        //return new DefaultClientConnection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.747 -0400", hash_original_method = "3035FF1473A97381B4AFABBF5B73F76A", hash_generated_method = "0ECCCD46D2DA304E3579428A23BFBBA5")
    public void openConnection(OperatedClientConnection conn,
                               HttpHost target,
                               InetAddress local,
                               HttpContext context,
                               HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean var451F9CCFC44B4276E736FF79EDEE8975_1456782066 = (conn.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be open.");
            } //End block
        } //End collapsed parenthetic
        Scheme schm;
        schm = schemeRegistry.getScheme(target.getSchemeName());
        SocketFactory sf;
        sf = schm.getSocketFactory();
        SocketFactory plain_sf;
        LayeredSocketFactory layered_sf;
        {
            plain_sf = staticPlainSocketFactory;
            layered_sf = (LayeredSocketFactory)sf;
        } //End block
        {
            plain_sf = sf;
            layered_sf = null;
        } //End block
        InetAddress[] addresses;
        addresses = InetAddress.getAllByName(target.getHostName());
        {
            int i;
            i = 0;
            {
                Socket sock;
                sock = plain_sf.createSocket();
                conn.opening(sock, target);
                try 
                {
                    Socket connsock;
                    connsock = plain_sf.connectSocket(sock,
                    addresses[i].getHostAddress(),
                    schm.resolvePort(target.getPort()),
                    local, 0, params);
                    {
                        sock = connsock;
                        conn.opening(sock, target);
                    } //End block
                    prepareSocket(sock, context, params);
                    {
                        Socket layeredsock;
                        layeredsock = layered_sf.createSocket(sock,
                        target.getHostName(),
                        schm.resolvePort(target.getPort()),
                        true);
                        {
                            conn.opening(layeredsock, target);
                        } //End block
                        conn.openCompleted(sf.isSecure(layeredsock), params);
                    } //End block
                    {
                        conn.openCompleted(sf.isSecure(sock), params);
                    } //End block
                } //End block
                catch (SocketException ex)
                {
                    {
                        ConnectException cause;
                        cause = (ConnectException) ex;
                        cause = new ConnectException(ex.getMessage(), ex);
                        if (DroidSafeAndroidRuntime.control) throw new HttpHostConnectException(target, cause);
                    } //End block
                } //End block
                catch (ConnectTimeoutException ex)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw ex;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(conn.getTaint());
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.751 -0400", hash_original_method = "B263843ECB367B56A8B3543219BABBA8", hash_generated_method = "1D45D3F121A9B8F3DF86A92DB02C405D")
    public void updateSecureConnection(OperatedClientConnection conn,
                                       HttpHost target,
                                       HttpContext context,
                                       HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean varEE62DAC45DF15B922FA2904B06CCD4A8_1109381111 = (!conn.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection must be open.");
            } //End block
        } //End collapsed parenthetic
        Scheme schm;
        schm = schemeRegistry.getScheme(target.getSchemeName());
        {
            boolean varE5B8F3A69B1B6580727686D70B4E6436_712789512 = (!(schm.getSocketFactory() instanceof LayeredSocketFactory));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target scheme (" + schm.getName() +
                 ") must have layered socket factory.");
            } //End block
        } //End collapsed parenthetic
        LayeredSocketFactory lsf;
        lsf = (LayeredSocketFactory) schm.getSocketFactory();
        Socket sock;
        try 
        {
            sock = lsf.createSocket
                (conn.getSocket(), target.getHostName(), schm.resolvePort(target.getPort()), true);
        } //End block
        catch (ConnectException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new HttpHostConnectException(target, ex);
        } //End block
        prepareSocket(sock, context, params);
        conn.update(sock, target, lsf.isSecure(sock), params);
        addTaint(conn.getTaint());
        addTaint(target.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.755 -0400", hash_original_method = "EEE63DC836F5AA81B1ECC566DDEA88C5", hash_generated_method = "B3A39BDDF1B0719874C5E7D29874C00F")
    protected void prepareSocket(Socket sock, HttpContext context,
                                 HttpParams params) throws IOException {
        sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger;
        linger = HttpConnectionParams.getLinger(params);
        {
            sock.setSoLinger(linger > 0, linger);
        } //End block
        addTaint(sock.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        //sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        //int linger = HttpConnectionParams.getLinger(params);
        //if (linger >= 0) {
            //sock.setSoLinger(linger > 0, linger);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.755 -0400", hash_original_field = "BB491613B2AC25774C0C6E92214BF9B8", hash_generated_field = "82724B468EB2450D80C27C5F53A1931A")

    private static PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
}

