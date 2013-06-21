package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.SocketTagger;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class HttpConnectionPool {
    private int maxConnections;
    private HashMap<HttpConnection.Address, List<HttpConnection>> connectionPool
            = new HashMap<HttpConnection.Address, List<HttpConnection>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.129 -0400", hash_original_method = "40F2B2B572ACE3BCAAEC11C8662EC74A", hash_generated_method = "3E3016CCEBDF6E3A8D0DDC12EA0DC028")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpConnectionPool() {
        String keepAlive;
        keepAlive = System.getProperty("http.keepAlive");
        {
            boolean varC3B303741AD694160ACC67ED73C632D9_1313356319 = (keepAlive != null && !Boolean.parseBoolean(keepAlive));
            {
                maxConnections = 0;
            } //End block
        } //End collapsed parenthetic
        String maxConnectionsString;
        maxConnectionsString = System.getProperty("http.maxConnections");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.129 -0400", hash_original_method = "9723020948C88E298F74B7B4BEB4D8BB", hash_generated_method = "FF333D92D6157DE1982E7FF2015EDD71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpConnection get(HttpConnection.Address address, int connectTimeout) throws IOException {
        dsTaint.addTaint(connectTimeout);
        dsTaint.addTaint(address.dsTaint);
        {
            List<HttpConnection> connections;
            connections = connectionPool.get(address);
            {
                {
                    boolean varDD844AC76AB622687419D853D672FBD4_513152640 = (!connections.isEmpty());
                    {
                        HttpConnection connection;
                        connection = connections.remove(connections.size() - 1);
                        {
                            boolean var7083866BF6CF5537B8D9A9DBCE355B37_180265217 = (!connection.isStale());
                            {
                                Socket socket;
                                socket = connection.getSocket();
                                SocketTagger.get().tag(socket);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                connectionPool.remove(address);
            } //End block
        } //End block
        HttpConnection var959BD4C78F05351C61811403ED4B13CD_1782827043 = (address.connect(connectTimeout));
        return (HttpConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.130 -0400", hash_original_method = "96125B0E756F418D511DE46CCDC8F5C6", hash_generated_method = "5B729B15CBCF8452C581DF73E4414655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle(HttpConnection connection) {
        dsTaint.addTaint(connection.dsTaint);
        Socket socket;
        socket = connection.getSocket();
        try 
        {
            SocketTagger.get().untag(socket);
        } //End block
        catch (SocketException e)
        {
            System.logW("Unable to untagSocket(): " + e);
            connection.closeSocketAndStreams();
        } //End block
        {
            boolean var1FC0D1A493CD87E0F12AB45744D1933F_870075751 = (maxConnections > 0 && connection.isEligibleForRecycling());
            {
                HttpConnection.Address address;
                address = connection.getAddress();
                {
                    List<HttpConnection> connections;
                    connections = connectionPool.get(address);
                    {
                        connections = new ArrayList<HttpConnection>();
                        connectionPool.put(address, connections);
                    } //End block
                    {
                        boolean var10006BF5D2F935A1BE3AE27F5ECA0930_279449116 = (connections.size() < maxConnections);
                        {
                            connections.add(connection);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        connection.closeSocketAndStreams();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final HttpConnectionPool INSTANCE = new HttpConnectionPool();
}

