package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import java.net.Socket;
import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpConnection extends Connection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.214 -0400", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "272759CD16D2D43385322A80BF1D6C19")
      HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        addTaint(requestFeeder.getTaint());
        addTaint(host.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.214 -0400", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "CAD37A46CA6990A5E291C9FAEBD183DF")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        addTaint(req.getTaint());
        EventHandler eventHandler = req.getEventHandler();
        mCertificate = null;
        eventHandler.certificate(mCertificate);
        AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        BasicHttpParams params = new BasicHttpParams();
        Socket sock = new Socket(mHost.getHostName(), mHost.getPort());
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sock, params);
AndroidHttpClientConnection varE92EA799FE726EFFA481FDDF43ADE4CF_1802880265 =         conn;
        varE92EA799FE726EFFA481FDDF43ADE4CF_1802880265.addTaint(taint);
        return varE92EA799FE726EFFA481FDDF43ADE4CF_1802880265;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.215 -0400", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "4B62D9E387E3411FA8910B36C93EF9E2")
     void closeConnection() {
        try 
        {
    if(mHttpClientConnection != null && mHttpClientConnection.isOpen())            
            {
                mHttpClientConnection.close();
            } 
        } 
        catch (IOException e)
        {
    if(HttpLog.LOGV)            
            HttpLog.v(
                    "closeConnection(): failed closing connection " +
                    mHost);
            e.printStackTrace();
        } 
        
        
            
                
            
        
            
                    
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.216 -0400", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "3D03B196C0054FDF260344F57DB44DDC")
     void restartConnection(boolean abort) {
        addTaint(abort);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.216 -0400", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "47E41E4EAB614CFB35D520A8333FB623")
     String getScheme() {
String var44B57466CD1C2BC7FBE96906897504B6_934017218 =         "http";
        var44B57466CD1C2BC7FBE96906897504B6_934017218.addTaint(taint);
        return var44B57466CD1C2BC7FBE96906897504B6_934017218;
        
        
    }

    
}

