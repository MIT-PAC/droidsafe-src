package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import java.net.Socket;
import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpConnection extends Connection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.904 -0400", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "24153836523023A6CDF0D934BE6FD294")
      HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        addTaint(context.getTaint());
        addTaint(host.getTaint());
        addTaint(requestFeeder.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.904 -0400", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "D24A782F3417D77D4C0D36495DEECB30")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        AndroidHttpClientConnection varB4EAC82CA7396A68D541C85D26508E83_656824489 = null; 
        EventHandler eventHandler = req.getEventHandler();
        mCertificate = null;
        eventHandler.certificate(mCertificate);
        AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        BasicHttpParams params = new BasicHttpParams();
        Socket sock = new Socket(mHost.getHostName(), mHost.getPort());
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sock, params);
        varB4EAC82CA7396A68D541C85D26508E83_656824489 = conn;
        addTaint(req.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_656824489.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_656824489;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.905 -0400", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "E504443F33DFF7B4F31629F25F11A589")
     void closeConnection() {
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_542549130 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
                {
                    mHttpClientConnection.close();
                } 
            } 
        } 
        catch (IOException e)
        {
            HttpLog.v(
                    "closeConnection(): failed closing connection " +
                    mHost);
            e.printStackTrace();
        } 
        
        
            
                
            
        
            
                    
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.905 -0400", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "3D03B196C0054FDF260344F57DB44DDC")
     void restartConnection(boolean abort) {
        addTaint(abort);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.906 -0400", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "EF3535413166AF956867FE3F2B61BE6B")
     String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1907829731 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1907829731 = "http";
        varB4EAC82CA7396A68D541C85D26508E83_1907829731.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1907829731;
        
        
    }

    
}

