package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dalvik.system.SocketTagger;

final class HttpConnectionPool {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.014 -0500", hash_original_field = "91F55BFC2249BA6B68F460ABB48ACE22", hash_generated_field = "590A253342226BF0F52B2AA46E36D139")

    public static final HttpConnectionPool INSTANCE = new HttpConnectionPool();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.016 -0500", hash_original_field = "CF1F23AB5460D986D85752F07123AEA1", hash_generated_field = "071E397744914F08240B3CDE573A9670")

    private  int maxConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.019 -0500", hash_original_field = "2CFF140A7C85435FF25FDD386EB8AAD9", hash_generated_field = "8E1D2C60713B625C54295C515F88EF48")

    private final HashMap<HttpConnection.Address, List<HttpConnection>> connectionPool
            = new HashMap<HttpConnection.Address, List<HttpConnection>>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.021 -0500", hash_original_method = "40F2B2B572ACE3BCAAEC11C8662EC74A", hash_generated_method = "4EB758AD1843ADFC34E458BF79B2665A")
    
private HttpConnectionPool() {
        String keepAlive = System.getProperty("http.keepAlive");
        if (keepAlive != null && !Boolean.parseBoolean(keepAlive)) {
            maxConnections = 0;
            return;
        }

        String maxConnectionsString = System.getProperty("http.maxConnections");
        this.maxConnections = maxConnectionsString != null
                ? Integer.parseInt(maxConnectionsString)
                : 5;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.024 -0500", hash_original_method = "9723020948C88E298F74B7B4BEB4D8BB", hash_generated_method = "6BB8FBC7574704A8C30AEC60BA9E5D7F")
    
public HttpConnection get(HttpConnection.Address address, int connectTimeout)
            throws IOException {
        // First try to reuse an existing HTTP connection.
        synchronized (connectionPool) {
            List<HttpConnection> connections = connectionPool.get(address);
            if (connections != null) {
                while (!connections.isEmpty()) {
                    HttpConnection connection = connections.remove(connections.size() - 1);
                    if (!connection.isStale()) { // TODO: this op does I/O!
                        // Since Socket is recycled, re-tag before using
                        final Socket socket = connection.getSocket();
                        SocketTagger.get().tag(socket);
                        return connection;
                    }
                }
                connectionPool.remove(address);
            }
        }

        /*
         * We couldn't find a reusable connection, so we need to create a new
         * connection. We're careful not to do so while holding a lock!
         */
        return address.connect(connectTimeout);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.028 -0500", hash_original_method = "96125B0E756F418D511DE46CCDC8F5C6", hash_generated_method = "0AAB80EAFE9742A63EC9D2FAA87FD167")
    
public void recycle(HttpConnection connection) {
        final Socket socket = connection.getSocket();
        try {
            SocketTagger.get().untag(socket);
        } catch (SocketException e) {
            // When unable to remove tagging, skip recycling and close
            System.logW("Unable to untagSocket(): " + e);
            connection.closeSocketAndStreams();
            return;
        }

        if (maxConnections > 0 && connection.isEligibleForRecycling()) {
            HttpConnection.Address address = connection.getAddress();
            synchronized (connectionPool) {
                List<HttpConnection> connections = connectionPool.get(address);
                if (connections == null) {
                    connections = new ArrayList<HttpConnection>();
                    connectionPool.put(address, connections);
                }
                if (connections.size() < maxConnections) {
                    connections.add(connection);
                    return; // keep the connection open
                }
            }
        }

        // don't close streams while holding a lock!
        connection.closeSocketAndStreams();
    }
}

