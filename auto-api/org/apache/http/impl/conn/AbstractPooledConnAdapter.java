package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.636 -0400", hash_original_field = "1ED3D3BFFB26F10C3A3630D847DAF20E", hash_generated_field = "95F8882F466E854F78FFC45E4BE1549E")

    protected volatile AbstractPoolEntry poolEntry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.643 -0400", hash_original_method = "17C821CA89D37F65B71D1113A8F4C810", hash_generated_method = "6D57AFEA683DDD187F633BB41F13BF9A")
    protected  AbstractPooledConnAdapter(ClientConnectionManager manager,
                                        AbstractPoolEntry entry) {
        super(manager, entry.connection);
        this.poolEntry = entry;
        addTaint(manager.getTaint());
        // ---------- Original Method ----------
        //this.poolEntry = entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.644 -0400", hash_original_method = "FB7C4A360F838D2C567FCD9A267C1C89", hash_generated_method = "C03572F6383C02ED58AA194B106A4C2C")
    protected final void assertAttached() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Adapter is detached.");
        } //End block
        // ---------- Original Method ----------
        //if (poolEntry == null) {
            //throw new IllegalStateException("Adapter is detached.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.647 -0400", hash_original_method = "C26DE5726C89C8A41E4FE63D33F7E7C2", hash_generated_method = "A1B21E7B51D2D59879F3FC61DC918C7B")
    @Override
    protected void detach() {
        super.detach();
        poolEntry = null;
        // ---------- Original Method ----------
        //super.detach();
        //poolEntry = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.654 -0400", hash_original_method = "AC84258A505CCE105FD230876F787C36", hash_generated_method = "62E0558F968BB08AB9598A9A1E78967A")
    public HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1378947111 = null; //Variable for return #1
        assertAttached();
        varB4EAC82CA7396A68D541C85D26508E83_1378947111 = (poolEntry.tracker == null) ?
            null : poolEntry.tracker.toRoute();
        varB4EAC82CA7396A68D541C85D26508E83_1378947111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1378947111;
        // ---------- Original Method ----------
        //assertAttached();
        //return (poolEntry.tracker == null) ?
            //null : poolEntry.tracker.toRoute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.655 -0400", hash_original_method = "80A37316B4189201422C5F911C37390F", hash_generated_method = "064242F4C801FC8D5E43A7BF648D77EC")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        assertAttached();
        poolEntry.open(route, context, params);
        addTaint(route.getTaint());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.open(route, context, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.655 -0400", hash_original_method = "88C576A6679A37807219C856CF85AF45", hash_generated_method = "0C1C67D38C4EE99D64A0C008127136D7")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        assertAttached();
        poolEntry.tunnelTarget(secure, params);
        addTaint(secure);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.tunnelTarget(secure, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.655 -0400", hash_original_method = "183042F5C82645DA134EED3F0129F7AB", hash_generated_method = "6D15F10C6580542FF1C1BA6B79CD026B")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        assertAttached();
        poolEntry.tunnelProxy(next, secure, params);
        addTaint(next.getTaint());
        addTaint(secure);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.tunnelProxy(next, secure, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.656 -0400", hash_original_method = "265D546872DD850E8FA8148DAC362DDA", hash_generated_method = "9E5AF541B547C34FBDE63A9FC0D69816")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        assertAttached();
        poolEntry.layerProtocol(context, params);
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.layerProtocol(context, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.663 -0400", hash_original_method = "8ECE47B171EFAD2F7C7D2EB622E49CF6", hash_generated_method = "6F59C19885AA3923DCAE6F40FAA65D57")
    public void close() throws IOException {
        poolEntry.shutdownEntry();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        {
            conn.close();
        } //End block
        // ---------- Original Method ----------
        //if (poolEntry != null)
            //poolEntry.shutdownEntry();
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn != null) {
            //conn.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.664 -0400", hash_original_method = "62B1930ABF96982C844F6DB1D64DBF05", hash_generated_method = "F578FE6C137D636DAA3BB97365005926")
    public void shutdown() throws IOException {
        poolEntry.shutdownEntry();
        OperatedClientConnection conn;
        conn = getWrappedConnection();
        {
            conn.shutdown();
        } //End block
        // ---------- Original Method ----------
        //if (poolEntry != null)
            //poolEntry.shutdownEntry();
        //OperatedClientConnection conn = getWrappedConnection();
        //if (conn != null) {
            //conn.shutdown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.664 -0400", hash_original_method = "C5C538BA26E5B2F7103C95948BE64C97", hash_generated_method = "8310231330C6416EAC7BB0F9CD86AFE3")
    public Object getState() {
        Object varB4EAC82CA7396A68D541C85D26508E83_309067388 = null; //Variable for return #1
        assertAttached();
        varB4EAC82CA7396A68D541C85D26508E83_309067388 = poolEntry.getState();
        varB4EAC82CA7396A68D541C85D26508E83_309067388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309067388;
        // ---------- Original Method ----------
        //assertAttached();
        //return poolEntry.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.664 -0400", hash_original_method = "F3A64AA6A34ABFCB96806A5E0FDB2DA5", hash_generated_method = "0458AFD4A4B57E896C5F021AA7E69C7F")
    public void setState(final Object state) {
        assertAttached();
        poolEntry.setState(state);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.setState(state);
    }

    
}

