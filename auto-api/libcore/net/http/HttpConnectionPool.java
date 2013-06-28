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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.783 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "071E397744914F08240B3CDE573A9670")

    private int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.783 -0400", hash_original_field = "D749297B79826167AB9A50AC9DFA5C1B", hash_generated_field = "8E1D2C60713B625C54295C515F88EF48")

    private final HashMap<HttpConnection.Address, List<HttpConnection>> connectionPool = new HashMap<HttpConnection.Address, List<HttpConnection>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.783 -0400", hash_original_method = "40F2B2B572ACE3BCAAEC11C8662EC74A", hash_generated_method = "8518B2DCF704282317EC4DEAEAF84513")
    private  HttpConnectionPool() {
        String keepAlive = System.getProperty("http.keepAlive");
        {
            boolean varC3B303741AD694160ACC67ED73C632D9_353223630 = (keepAlive != null && !Boolean.parseBoolean(keepAlive));
            {
                maxConnections = 0;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.784 -0400", hash_original_method = "9723020948C88E298F74B7B4BEB4D8BB", hash_generated_method = "54EEB7E7FF5C268682BD3992958D8E38")
    public HttpConnection get(HttpConnection.Address address, int connectTimeout) throws IOException {
        HttpConnection varB4EAC82CA7396A68D541C85D26508E83_126140191 = null; //Variable for return #1
        HttpConnection varB4EAC82CA7396A68D541C85D26508E83_276454535 = null; //Variable for return #2
        {
            List<HttpConnection> connections = connectionPool.get(address);
            {
                {
                    boolean varDD844AC76AB622687419D853D672FBD4_783953414 = (!connections.isEmpty());
                    {
                        HttpConnection connection = connections.remove(connections.size() - 1);
                        {
                            boolean var7083866BF6CF5537B8D9A9DBCE355B37_325840590 = (!connection.isStale());
                            {
                                final Socket socket = connection.getSocket();
                                SocketTagger.get().tag(socket);
                                varB4EAC82CA7396A68D541C85D26508E83_126140191 = connection;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                connectionPool.remove(address);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_276454535 = address.connect(connectTimeout);
        addTaint(address.getTaint());
        addTaint(connectTimeout);
        HttpConnection varA7E53CE21691AB073D9660D615818899_1281839875; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1281839875 = varB4EAC82CA7396A68D541C85D26508E83_126140191;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1281839875 = varB4EAC82CA7396A68D541C85D26508E83_276454535;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1281839875.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1281839875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.785 -0400", hash_original_method = "96125B0E756F418D511DE46CCDC8F5C6", hash_generated_method = "8F9FBE6008E4D8AB191859644CA20258")
    public void recycle(HttpConnection connection) {
        final Socket socket = connection.getSocket();
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
            boolean var1FC0D1A493CD87E0F12AB45744D1933F_2107827350 = (maxConnections > 0 && connection.isEligibleForRecycling());
            {
                HttpConnection.Address address = connection.getAddress();
                {
                    List<HttpConnection> connections = connectionPool.get(address);
                    {
                        connections = new ArrayList<HttpConnection>();
                        connectionPool.put(address, connections);
                    } //End block
                    {
                        boolean var10006BF5D2F935A1BE3AE27F5ECA0930_1277454571 = (connections.size() < maxConnections);
                        {
                            connections.add(connection);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        connection.closeSocketAndStreams();
        addTaint(connection.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.785 -0400", hash_original_field = "445126F9E7B6CECDACF5FF2D040CAA9E", hash_generated_field = "590A253342226BF0F52B2AA46E36D139")

    public static final HttpConnectionPool INSTANCE = new HttpConnectionPool();
}

