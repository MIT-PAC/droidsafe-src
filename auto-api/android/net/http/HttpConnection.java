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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.889 -0400", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "24153836523023A6CDF0D934BE6FD294")
      HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        addTaint(context.getTaint());
        addTaint(host.getTaint());
        addTaint(requestFeeder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.896 -0400", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "A3870224B1C3086A9AC5B004B26F6864")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        AndroidHttpClientConnection varB4EAC82CA7396A68D541C85D26508E83_865794411 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_865794411 = conn;
        addTaint(req.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_865794411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_865794411;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.898 -0400", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "F9AA4899EB83DBAB2F01544CE5948FAA")
     void closeConnection() {
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_1580782810 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.898 -0400", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "3D03B196C0054FDF260344F57DB44DDC")
     void restartConnection(boolean abort) {
        addTaint(abort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.921 -0400", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "01C9C144D1577C2D037153581D455E59")
     String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_925455123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_925455123 = "http";
        varB4EAC82CA7396A68D541C85D26508E83_925455123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_925455123;
        // ---------- Original Method ----------
        //return "http";
    }

    
}

