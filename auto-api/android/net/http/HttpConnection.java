package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.133 -0400", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "24153836523023A6CDF0D934BE6FD294")
      HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        addTaint(context.getTaint());
        addTaint(host.getTaint());
        addTaint(requestFeeder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.135 -0400", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "2A4B914AAD561DE7AA0537733EAC0307")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        AndroidHttpClientConnection varB4EAC82CA7396A68D541C85D26508E83_645003292 = null; //Variable for return #1
        EventHandler eventHandler;
        eventHandler = req.getEventHandler();
        mCertificate = null;
        eventHandler.certificate(mCertificate);
        AndroidHttpClientConnection conn;
        conn = new AndroidHttpClientConnection();
        BasicHttpParams params;
        params = new BasicHttpParams();
        Socket sock;
        sock = new Socket(mHost.getHostName(), mHost.getPort());
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sock, params);
        varB4EAC82CA7396A68D541C85D26508E83_645003292 = conn;
        addTaint(req.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_645003292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_645003292;
        // ---------- Original Method ----------
        //EventHandler eventHandler = req.getEventHandler();
        //mCertificate = null;
        //eventHandler.certificate(mCertificate);
        //AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        //BasicHttpParams params = new BasicHttpParams();
        //Socket sock = new Socket(mHost.getHostName(), mHost.getPort());
        //params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        //conn.bind(sock, params);
        //return conn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.146 -0400", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "598D73B7B9D90B0468040DD4E437E76E")
     void closeConnection() {
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_1565687130 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
                {
                    mHttpClientConnection.close();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            HttpLog.v(
                    "closeConnection(): failed closing connection " +
                    mHost);
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mHttpClientConnection != null && mHttpClientConnection.isOpen()) {
                //mHttpClientConnection.close();
            //}
        //} catch (IOException e) {
            //if (HttpLog.LOGV) HttpLog.v(
                    //"closeConnection(): failed closing connection " +
                    //mHost);
            //e.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.147 -0400", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "3D03B196C0054FDF260344F57DB44DDC")
     void restartConnection(boolean abort) {
        addTaint(abort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.148 -0400", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "76023E3E907E1DA212D7385D440AFFA2")
     String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1010260889 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1010260889 = "http";
        varB4EAC82CA7396A68D541C85D26508E83_1010260889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010260889;
        // ---------- Original Method ----------
        //return "http";
    }

    
}

