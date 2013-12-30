package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;




public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.804 -0500", hash_original_field = "59C1BAA791CEAF19212336A5948AF5A0", hash_generated_field = "95F8882F466E854F78FFC45E4BE1549E")

    protected volatile AbstractPoolEntry poolEntry;


    /**
     * Creates a new connection adapter.
     *
     * @param manager   the connection manager
     * @param entry     the pool entry for the connection being wrapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.806 -0500", hash_original_method = "17C821CA89D37F65B71D1113A8F4C810", hash_generated_method = "C9D874D615A7328641199CCE9614B8DE")
    
protected AbstractPooledConnAdapter(ClientConnectionManager manager,
                                        AbstractPoolEntry entry) {
        super(manager, entry.connection);
        this.poolEntry = entry;
    }


    /**
     * Asserts that this adapter is still attached.
     *
     * @throws IllegalStateException
     *      if it is {@link #detach detach}ed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.809 -0500", hash_original_method = "FB7C4A360F838D2C567FCD9A267C1C89", hash_generated_method = "C87190F18E691D265EA60DB7C80615E1")
    
protected final void assertAttached() {
        if (poolEntry == null) {
            throw new IllegalStateException("Adapter is detached.");
        }
    }

    /**
     * Detaches this adapter from the wrapped connection.
     * This adapter becomes useless.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.811 -0500", hash_original_method = "C26DE5726C89C8A41E4FE63D33F7E7C2", hash_generated_method = "A717FDEA4592ACC45D2C3115C70CF958")
    
@Override
    protected void detach() {
        super.detach();
        poolEntry = null;
    }


    // non-javadoc, see interface ManagedHttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.813 -0500", hash_original_method = "AC84258A505CCE105FD230876F787C36", hash_generated_method = "EFA69DDE51B7630F86C7D1B3472E21DC")
    
public HttpRoute getRoute() {

        assertAttached();
        return (poolEntry.tracker == null) ?
            null : poolEntry.tracker.toRoute();
    }

    // non-javadoc, see interface ManagedHttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.816 -0500", hash_original_method = "80A37316B4189201422C5F911C37390F", hash_generated_method = "952561155CFCDB4EBA0B620620816091")
    
public void open(HttpRoute route,
                     HttpContext context, HttpParams params)
        throws IOException {

        assertAttached();
        poolEntry.open(route, context, params);
    }


    // non-javadoc, see interface ManagedHttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.818 -0500", hash_original_method = "88C576A6679A37807219C856CF85AF45", hash_generated_method = "18CAD7F69BB0EE6E702E1C301100A205")
    
public void tunnelTarget(boolean secure, HttpParams params)
        throws IOException {

        assertAttached();
        poolEntry.tunnelTarget(secure, params);
    }


    // non-javadoc, see interface ManagedHttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.820 -0500", hash_original_method = "183042F5C82645DA134EED3F0129F7AB", hash_generated_method = "A47BD756BF98591063745F20CA83D778")
    
public void tunnelProxy(HttpHost next, boolean secure, HttpParams params)
        throws IOException {

        assertAttached();
        poolEntry.tunnelProxy(next, secure, params);
    }


    // non-javadoc, see interface ManagedHttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.823 -0500", hash_original_method = "265D546872DD850E8FA8148DAC362DDA", hash_generated_method = "E77A860926952F1CA40641B2936501BA")
    
public void layerProtocol(HttpContext context, HttpParams params)
        throws IOException {

        assertAttached();
        poolEntry.layerProtocol(context, params);
    }



    // non-javadoc, see interface HttpConnection        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.825 -0500", hash_original_method = "8ECE47B171EFAD2F7C7D2EB622E49CF6", hash_generated_method = "A5B198C9CE0E6FA2F5ADEDAC6C0A9E3C")
    
public void close() throws IOException {
        if (poolEntry != null)
            poolEntry.shutdownEntry();

        OperatedClientConnection conn = getWrappedConnection();
        if (conn != null) {
            conn.close();
        }
    }

    // non-javadoc, see interface HttpConnection        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.827 -0500", hash_original_method = "62B1930ABF96982C844F6DB1D64DBF05", hash_generated_method = "9190C1A70040590F245473EFFC8101A3")
    
public void shutdown() throws IOException {
        if (poolEntry != null)
            poolEntry.shutdownEntry();

        OperatedClientConnection conn = getWrappedConnection();
        if (conn != null) {
            conn.shutdown();
        }
    }

    
    // non-javadoc, see interface ManagedClientConnection        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.829 -0500", hash_original_method = "C5C538BA26E5B2F7103C95948BE64C97", hash_generated_method = "B2835E682F02159F011582ADB544ADFF")
    
public Object getState() {
        assertAttached();
        return poolEntry.getState();
    }


    // non-javadoc, see interface ManagedClientConnection        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.832 -0500", hash_original_method = "F3A64AA6A34ABFCB96806A5E0FDB2DA5", hash_generated_method = "278D14E6745E2B1066D7DB3CA94C8AA0")
    
public void setState(final Object state) {
        assertAttached();
        poolEntry.setState(state);
    }

    
}

