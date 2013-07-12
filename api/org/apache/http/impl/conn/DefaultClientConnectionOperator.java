package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.803 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.804 -0400", hash_original_method = "564A7128C5B00F982644F6E1BD9B5118", hash_generated_method = "DD1642709AB41EF002044864C8D74D2A")
    public  DefaultClientConnectionOperator(SchemeRegistry schemes) {
    if(schemes == null)        
        {
            IllegalArgumentException var9D0DCFA9FB8D2370B81F25E8E10E412A_240621843 = new IllegalArgumentException
                ("Scheme registry must not be null.");
            var9D0DCFA9FB8D2370B81F25E8E10E412A_240621843.addTaint(taint);
            throw var9D0DCFA9FB8D2370B81F25E8E10E412A_240621843;
        } 
        schemeRegistry = schemes;
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.804 -0400", hash_original_method = "A7AF136A36340299371F158C25AED0D2", hash_generated_method = "E3547F561063ABDB1FE87AD896645760")
    public OperatedClientConnection createConnection() {
OperatedClientConnection varB7F75C6A5AEFC78EC04959C9746E7695_1170696350 =         new DefaultClientConnection();
        varB7F75C6A5AEFC78EC04959C9746E7695_1170696350.addTaint(taint);
        return varB7F75C6A5AEFC78EC04959C9746E7695_1170696350;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.806 -0400", hash_original_method = "3035FF1473A97381B4AFABBF5B73F76A", hash_generated_method = "B84B83DCFCC6F34E78398C98BE06A52B")
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
            IllegalArgumentException varEE0931985C4077C40A6DEC3DEB45BA63_1240242638 = new IllegalArgumentException
                ("Connection must not be null.");
            varEE0931985C4077C40A6DEC3DEB45BA63_1240242638.addTaint(taint);
            throw varEE0931985C4077C40A6DEC3DEB45BA63_1240242638;
        } 
    if(target == null)        
        {
            IllegalArgumentException varEC83656C97A1AEE534C63E8749A9F3F6_867365704 = new IllegalArgumentException
                ("Target host must not be null.");
            varEC83656C97A1AEE534C63E8749A9F3F6_867365704.addTaint(taint);
            throw varEC83656C97A1AEE534C63E8749A9F3F6_867365704;
        } 
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_707729953 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_707729953.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_707729953;
        } 
    if(conn.isOpen())        
        {
            IllegalArgumentException varE99A0414E35FADD7209110E9DC35FDC4_619605505 = new IllegalArgumentException
                ("Connection must not be open.");
            varE99A0414E35FADD7209110E9DC35FDC4_619605505.addTaint(taint);
            throw varE99A0414E35FADD7209110E9DC35FDC4_619605505;
        } 
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        final SocketFactory sf = schm.getSocketFactory();
        SocketFactory plain_sf;
        LayeredSocketFactory layered_sf;
    if(sf instanceof LayeredSocketFactory)        
        {
            plain_sf = staticPlainSocketFactory;
            layered_sf = (LayeredSocketFactory)sf;
        } 
        else
        {
            plain_sf = sf;
            layered_sf = null;
        } 
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
                } 
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
                    } 
                    conn.openCompleted(sf.isSecure(layeredsock), params);
                } 
                else
                {
                    conn.openCompleted(sf.isSecure(sock), params);
                } 
                break;
            } 
            catch (SocketException ex)
            {
    if(i == addresses.length - 1)                
                {
                    ConnectException cause = ex instanceof ConnectException
                            ? (ConnectException) ex : new ConnectException(ex.getMessage(), ex);
                    HttpHostConnectException var9013BD2F333EDC7603EB273BF6B33D82_126525461 = new HttpHostConnectException(target, cause);
                    var9013BD2F333EDC7603EB273BF6B33D82_126525461.addTaint(taint);
                    throw var9013BD2F333EDC7603EB273BF6B33D82_126525461;
                } 
            } 
            catch (ConnectTimeoutException ex)
            {
    if(i == addresses.length - 1)                
                {
                    ex.addTaint(taint);
                    throw ex;
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.809 -0400", hash_original_method = "B263843ECB367B56A8B3543219BABBA8", hash_generated_method = "F8EDF1D862F6B3EF7F6718FD41531FDE")
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
            IllegalArgumentException varEE0931985C4077C40A6DEC3DEB45BA63_2123073884 = new IllegalArgumentException
                ("Connection must not be null.");
            varEE0931985C4077C40A6DEC3DEB45BA63_2123073884.addTaint(taint);
            throw varEE0931985C4077C40A6DEC3DEB45BA63_2123073884;
        } 
    if(target == null)        
        {
            IllegalArgumentException varEC83656C97A1AEE534C63E8749A9F3F6_257273070 = new IllegalArgumentException
                ("Target host must not be null.");
            varEC83656C97A1AEE534C63E8749A9F3F6_257273070.addTaint(taint);
            throw varEC83656C97A1AEE534C63E8749A9F3F6_257273070;
        } 
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_937098425 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_937098425.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_937098425;
        } 
    if(!conn.isOpen())        
        {
            IllegalArgumentException var3FC106620C2F669DF3AA6AB529A6D958_1414096672 = new IllegalArgumentException
                ("Connection must be open.");
            var3FC106620C2F669DF3AA6AB529A6D958_1414096672.addTaint(taint);
            throw var3FC106620C2F669DF3AA6AB529A6D958_1414096672;
        } 
        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
    if(!(schm.getSocketFactory() instanceof LayeredSocketFactory))        
        {
            IllegalArgumentException var164C817E75C4DF376FE08E5BA46DE128_1860016003 = new IllegalArgumentException
                ("Target scheme (" + schm.getName() +
                 ") must have layered socket factory.");
            var164C817E75C4DF376FE08E5BA46DE128_1860016003.addTaint(taint);
            throw var164C817E75C4DF376FE08E5BA46DE128_1860016003;
        } 
        final LayeredSocketFactory lsf = (LayeredSocketFactory) schm.getSocketFactory();
        Socket sock;
        try 
        {
            sock = lsf.createSocket
                (conn.getSocket(), target.getHostName(), schm.resolvePort(target.getPort()), true);
        } 
        catch (ConnectException ex)
        {
            HttpHostConnectException varC75EB74B85814145957679B765BD7655_950206392 = new HttpHostConnectException(target, ex);
            varC75EB74B85814145957679B765BD7655_950206392.addTaint(taint);
            throw varC75EB74B85814145957679B765BD7655_950206392;
        } 
        prepareSocket(sock, context, params);
        conn.update(sock, target, lsf.isSecure(sock), params);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.810 -0400", hash_original_method = "EEE63DC836F5AA81B1ECC566DDEA88C5", hash_generated_method = "59042B2CF1FC4CDCDBDD66CFB82220B7")
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
        } 
        
        
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.810 -0400", hash_original_field = "BB491613B2AC25774C0C6E92214BF9B8", hash_generated_field = "117D19A17E0FA862F4540CD5E143142A")

    private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
}

