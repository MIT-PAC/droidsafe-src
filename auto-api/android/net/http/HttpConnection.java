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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.818 -0400", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "D41FF93A0A638908CF0EEBEF3857DA59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(requestFeeder.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.820 -0400", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "856829A76B1EAB9D1A26C0C98390A687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        dsTaint.addTaint(req.dsTaint);
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
        return (AndroidHttpClientConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.821 -0400", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "8F37EDE427B9E0F7C81093C7F411F515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void closeConnection() {
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_1155904965 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.821 -0400", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "D98BB5B8F41D8203A4579E266E72ED06")
    @DSModeled(DSC.SAFE)
     void restartConnection(boolean abort) {
        dsTaint.addTaint(abort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.821 -0400", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "1E5F76530C16D1DA890A6788AC3204CB")
    @DSModeled(DSC.SAFE)
     String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "http";
    }

    
}

