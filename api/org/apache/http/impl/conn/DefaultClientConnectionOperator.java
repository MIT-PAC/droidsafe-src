package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;






public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.090 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.091 -0400", hash_original_method = "564A7128C5B00F982644F6E1BD9B5118", hash_generated_method = "8265D304914E0FE690265899B76F1ECB")
    public  DefaultClientConnectionOperator(SchemeRegistry schemes) {
        if(schemes == null)        
        {
            IllegalArgumentException var9D0DCFA9FB8D2370B81F25E8E10E412A_2107515088 = new IllegalArgumentException
                ("Scheme registry must not be null.");
            var9D0DCFA9FB8D2370B81F25E8E10E412A_2107515088.addTaint(taint);
            throw var9D0DCFA9FB8D2370B81F25E8E10E412A_2107515088;
        } //End block
        schemeRegistry = schemes;
        // ---------- Original Method ----------
        //if (schemes == null) {
            //throw new IllegalArgumentException
                //("Scheme registry must not be null.");
        //}
        //schemeRegistry = schemes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.091 -0400", hash_original_method = "A7AF136A36340299371F158C25AED0D2", hash_generated_method = "780E834E0404362105D9AB566277688E")
    public OperatedClientConnection createConnection() {
OperatedClientConnection varB7F75C6A5AEFC78EC04959C9746E7695_1665772296 =         new DefaultClientConnection();
        varB7F75C6A5AEFC78EC04959C9746E7695_1665772296.addTaint(taint);
        return varB7F75C6A5AEFC78EC04959C9746E7695_1665772296;
        // ---------- Original Method ----------
        //return new DefaultClientConnection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.092 -0400", hash_original_method = "3035FF1473A97381B4AFABBF5B73F76A", hash_generated_method = "FE8684CB0865AF31ABEFDAF4700B2D28")
    public void openConnection(OperatedClientConnection conn,
                               HttpHost target,
                               InetAddress local,
                               HttpContext context,
                               HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        addTaint(local.getTaint());
        addTaint(target.getTaint());
        addTaint(conn.getTaint());
        if(conn == null)        
        {
            IllegalArgumentException varEE0931985C4077C40A6DEC3DEB45BA63_2146022473 = new IllegalArgumentException
                ("Connection must not be null.");
            varEE0931985C4077C40A6DEC3DEB45BA63_2146022473.addTaint(taint);
            throw varEE0931985C4077C40A6DEC3DEB45BA63_2146022473;
        } //End block
        if(target == null)        
        {
            IllegalArgumentException varEC83656C97A1AEE534C63E8749A9F3F6_1192590859 = new IllegalArgumentException
                ("Target host must not be null.");
            varEC83656C97A1AEE534C63E8749A9F3F6_1192590859.addTaint(taint);
            throw varEC83656C97A1AEE534C63E8749A9F3F6_1192590859;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1390461017 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1390461017.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1390461017;
        } //End block
        if(conn.isOpen())        
        {
            IllegalArgumentException varE99A0414E35FADD7209110E9DC35FDC4_467012850 = new IllegalArgumentException
                ("Connection must not be open.");
            varE99A0414E35FADD7209110E9DC35FDC4_467012850.addTaint(taint);
            throw varE99A0414E35FADD7209110E9DC35FDC4_467012850;
        } //End block
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        final SocketFactory sf = schm.getSocketFactory();
        SocketFactory plain_sf;
        LayeredSocketFactory layered_sf;
        if(sf instanceof LayeredSocketFactory)        
        {
            plain_sf = staticPlainSocketFactory;
            layered_sf = (LayeredSocketFactory)sf;
        } //End block
        else
        {
            plain_sf = sf;
            layered_sf = null;
        } //End block
        InetAddress[] addresses = InetAddress.getAllByName(target.getHostName());
for(int i = 0;i < addresses.length;++i)
        {
            Socket sock = plain_sf.createSocket();
            conn.opening(sock, target);
            try 
            {
                Socket connsock = plain_sf.connectSocket(sock,
                    addresses[i].getHostAddress(),
                    schm.resolvePort(target.getPort()),
                    local, 0, params);
                if(sock != connsock)                
                {
                    sock = connsock;
                    conn.opening(sock, target);
                } //End block
                prepareSocket(sock, context, params);
                if(layered_sf != null)                
                {
                    Socket layeredsock = layered_sf.createSocket(sock,
                        target.getHostName(),
                        schm.resolvePort(target.getPort()),
                        true);
                    if(layeredsock != sock)                    
                    {
                        conn.opening(layeredsock, target);
                    } //End block
                    conn.openCompleted(sf.isSecure(layeredsock), params);
                } //End block
                else
                {
                    conn.openCompleted(sf.isSecure(sock), params);
                } //End block
                break;
            } //End block
            catch (SocketException ex)
            {
                if(i == addresses.length - 1)                
                {
                    ConnectException cause = ex instanceof ConnectException
                            ? (ConnectException) ex : new ConnectException(ex.getMessage(), ex);
                    HttpHostConnectException var9013BD2F333EDC7603EB273BF6B33D82_1932410761 = new HttpHostConnectException(target, cause);
                    var9013BD2F333EDC7603EB273BF6B33D82_1932410761.addTaint(taint);
                    throw var9013BD2F333EDC7603EB273BF6B33D82_1932410761;
                } //End block
            } //End block
            catch (ConnectTimeoutException ex)
            {
                if(i == addresses.length - 1)                
                {
                    ex.addTaint(taint);
                    throw ex;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.093 -0400", hash_original_method = "B263843ECB367B56A8B3543219BABBA8", hash_generated_method = "BA2520BD83EDC420147A01F62BFB73F9")
    public void updateSecureConnection(OperatedClientConnection conn,
                                       HttpHost target,
                                       HttpContext context,
                                       HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        addTaint(target.getTaint());
        addTaint(conn.getTaint());
        if(conn == null)        
        {
            IllegalArgumentException varEE0931985C4077C40A6DEC3DEB45BA63_1449288766 = new IllegalArgumentException
                ("Connection must not be null.");
            varEE0931985C4077C40A6DEC3DEB45BA63_1449288766.addTaint(taint);
            throw varEE0931985C4077C40A6DEC3DEB45BA63_1449288766;
        } //End block
        if(target == null)        
        {
            IllegalArgumentException varEC83656C97A1AEE534C63E8749A9F3F6_566370907 = new IllegalArgumentException
                ("Target host must not be null.");
            varEC83656C97A1AEE534C63E8749A9F3F6_566370907.addTaint(taint);
            throw varEC83656C97A1AEE534C63E8749A9F3F6_566370907;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1453880963 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1453880963.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1453880963;
        } //End block
        if(!conn.isOpen())        
        {
            IllegalArgumentException var3FC106620C2F669DF3AA6AB529A6D958_963063166 = new IllegalArgumentException
                ("Connection must be open.");
            var3FC106620C2F669DF3AA6AB529A6D958_963063166.addTaint(taint);
            throw var3FC106620C2F669DF3AA6AB529A6D958_963063166;
        } //End block
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        if(!(schm.getSocketFactory() instanceof LayeredSocketFactory))        
        {
            IllegalArgumentException var164C817E75C4DF376FE08E5BA46DE128_351105944 = new IllegalArgumentException
                ("Target scheme (" + schm.getName() +
                 ") must have layered socket factory.");
            var164C817E75C4DF376FE08E5BA46DE128_351105944.addTaint(taint);
            throw var164C817E75C4DF376FE08E5BA46DE128_351105944;
        } //End block
        final LayeredSocketFactory lsf = (LayeredSocketFactory) schm.getSocketFactory();
        Socket sock;
        try 
        {
            sock = lsf.createSocket
                (conn.getSocket(), target.getHostName(), schm.resolvePort(target.getPort()), true);
        } //End block
        catch (ConnectException ex)
        {
            HttpHostConnectException varC75EB74B85814145957679B765BD7655_795663356 = new HttpHostConnectException(target, ex);
            varC75EB74B85814145957679B765BD7655_795663356.addTaint(taint);
            throw varC75EB74B85814145957679B765BD7655_795663356;
        } //End block
        prepareSocket(sock, context, params);
        conn.update(sock, target, lsf.isSecure(sock), params);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.094 -0400", hash_original_method = "EEE63DC836F5AA81B1ECC566DDEA88C5", hash_generated_method = "59042B2CF1FC4CDCDBDD66CFB82220B7")
    protected void prepareSocket(Socket sock, HttpContext context,
                                 HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        addTaint(sock.getTaint());
        sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger = HttpConnectionParams.getLinger(params);
        if(linger >= 0)        
        {
            sock.setSoLinger(linger > 0, linger);
        } //End block
        // ---------- Original Method ----------
        //sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        //sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        //int linger = HttpConnectionParams.getLinger(params);
        //if (linger >= 0) {
            //sock.setSoLinger(linger > 0, linger);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.094 -0400", hash_original_field = "BB491613B2AC25774C0C6E92214BF9B8", hash_generated_field = "117D19A17E0FA862F4540CD5E143142A")

    private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
}

