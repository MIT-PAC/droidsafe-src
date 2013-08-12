package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dalvik.system.SocketTagger;



final class HttpConnectionPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.089 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "071E397744914F08240B3CDE573A9670")

    private int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.089 -0400", hash_original_field = "D749297B79826167AB9A50AC9DFA5C1B", hash_generated_field = "8E1D2C60713B625C54295C515F88EF48")

    private final HashMap<HttpConnection.Address, List<HttpConnection>> connectionPool = new HashMap<HttpConnection.Address, List<HttpConnection>>();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.089 -0400", hash_original_method = "40F2B2B572ACE3BCAAEC11C8662EC74A", hash_generated_method = "49065ACC2CF51AB84FE4EA2E33DE95CA")
    private  HttpConnectionPool() {
        String keepAlive = System.getProperty("http.keepAlive");
        if(keepAlive != null && !Boolean.parseBoolean(keepAlive))        
        {
            maxConnections = 0;
            return;
        } //End block
        String maxConnectionsString = System.getProperty("http.maxConnections");
        this.maxConnections = maxConnectionsString != null
                ? Integer.parseInt(maxConnectionsString)
                : 5;
        // ---------- Original Method ----------
        //String keepAlive = System.getProperty("http.keepAlive");
        //if (keepAlive != null && !Boolean.parseBoolean(keepAlive)) {
            //maxConnections = 0;
            //return;
        //}
        //String maxConnectionsString = System.getProperty("http.maxConnections");
        //this.maxConnections = maxConnectionsString != null
                //? Integer.parseInt(maxConnectionsString)
                //: 5;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.103 -0400", hash_original_method = "9723020948C88E298F74B7B4BEB4D8BB", hash_generated_method = "0141DBD36C0084C32DD7F97904D1D374")
    public HttpConnection get(HttpConnection.Address address, int connectTimeout) throws IOException {
        addTaint(connectTimeout);
        addTaint(address.getTaint());
        synchronized
(connectionPool)        {
            List<HttpConnection> connections = connectionPool.get(address);
            if(connections != null)            
            {
                while
(!connections.isEmpty())                
                {
                    HttpConnection connection = connections.remove(connections.size() - 1);
                    if(!connection.isStale())                    
                    {
                        final Socket socket = connection.getSocket();
                        SocketTagger.get().tag(socket);
HttpConnection var9911BB1C5F1522C1630847C40E8BC67E_361873497 =                         connection;
                        var9911BB1C5F1522C1630847C40E8BC67E_361873497.addTaint(taint);
                        return var9911BB1C5F1522C1630847C40E8BC67E_361873497;
                    } //End block
                } //End block
                connectionPool.remove(address);
            } //End block
        } //End block
HttpConnection varA3969E918D3E68DBEDAE3D4F56B1CEE1_1967748393 =         address.connect(connectTimeout);
        varA3969E918D3E68DBEDAE3D4F56B1CEE1_1967748393.addTaint(taint);
        return varA3969E918D3E68DBEDAE3D4F56B1CEE1_1967748393;
        // ---------- Original Method ----------
        //synchronized (connectionPool) {
            //List<HttpConnection> connections = connectionPool.get(address);
            //if (connections != null) {
                //while (!connections.isEmpty()) {
                    //HttpConnection connection = connections.remove(connections.size() - 1);
                    //if (!connection.isStale()) { 
                        //final Socket socket = connection.getSocket();
                        //SocketTagger.get().tag(socket);
                        //return connection;
                    //}
                //}
                //connectionPool.remove(address);
            //}
        //}
        //return address.connect(connectTimeout);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.103 -0400", hash_original_method = "96125B0E756F418D511DE46CCDC8F5C6", hash_generated_method = "D5408E1B37C340A2F33FB1721C216F88")
    public void recycle(HttpConnection connection) {
        addTaint(connection.getTaint());
        final Socket socket = connection.getSocket();
        try 
        {
            SocketTagger.get().untag(socket);
        } //End block
        catch (SocketException e)
        {
            System.logW("Unable to untagSocket(): " + e);
            connection.closeSocketAndStreams();
            return;
        } //End block
        if(maxConnections > 0 && connection.isEligibleForRecycling())        
        {
            HttpConnection.Address address = connection.getAddress();
            synchronized
(connectionPool)            {
                List<HttpConnection> connections = connectionPool.get(address);
                if(connections == null)                
                {
                    connections = new ArrayList<HttpConnection>();
                    connectionPool.put(address, connections);
                } //End block
                if(connections.size() < maxConnections)                
                {
                    connections.add(connection);
                    return;
                } //End block
            } //End block
        } //End block
        connection.closeSocketAndStreams();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.104 -0400", hash_original_field = "445126F9E7B6CECDACF5FF2D040CAA9E", hash_generated_field = "590A253342226BF0F52B2AA46E36D139")

    public static final HttpConnectionPool INSTANCE = new HttpConnectionPool();
}

