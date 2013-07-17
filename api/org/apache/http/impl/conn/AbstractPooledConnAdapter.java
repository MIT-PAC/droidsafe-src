package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.031 -0400", hash_original_field = "1ED3D3BFFB26F10C3A3630D847DAF20E", hash_generated_field = "95F8882F466E854F78FFC45E4BE1549E")

    protected volatile AbstractPoolEntry poolEntry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.031 -0400", hash_original_method = "17C821CA89D37F65B71D1113A8F4C810", hash_generated_method = "5B5BF99024B1E02237B7C8D14B730D22")
    protected  AbstractPooledConnAdapter(ClientConnectionManager manager,
                                        AbstractPoolEntry entry) {
        super(manager, entry.connection);
        addTaint(manager.getTaint());
        this.poolEntry = entry;
        // ---------- Original Method ----------
        //this.poolEntry = entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.032 -0400", hash_original_method = "FB7C4A360F838D2C567FCD9A267C1C89", hash_generated_method = "A05FA4588327E9A95202A64011AF230E")
    protected final void assertAttached() {
        if(poolEntry == null)        
        {
            IllegalStateException var4F03C2847F7EFD305CBAEBEAC5D82E5C_1775703210 = new IllegalStateException("Adapter is detached.");
            var4F03C2847F7EFD305CBAEBEAC5D82E5C_1775703210.addTaint(taint);
            throw var4F03C2847F7EFD305CBAEBEAC5D82E5C_1775703210;
        } //End block
        // ---------- Original Method ----------
        //if (poolEntry == null) {
            //throw new IllegalStateException("Adapter is detached.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.032 -0400", hash_original_method = "C26DE5726C89C8A41E4FE63D33F7E7C2", hash_generated_method = "A1B21E7B51D2D59879F3FC61DC918C7B")
    @Override
    protected void detach() {
        super.detach();
        poolEntry = null;
        // ---------- Original Method ----------
        //super.detach();
        //poolEntry = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.033 -0400", hash_original_method = "AC84258A505CCE105FD230876F787C36", hash_generated_method = "DAB7957F731169BED8CD48114B5C8AB0")
    public HttpRoute getRoute() {
        assertAttached();
HttpRoute varC5F8D4120C28E1A13BED5146C1E50603_594532148 =         (poolEntry.tracker == null) ?
            null : poolEntry.tracker.toRoute();
        varC5F8D4120C28E1A13BED5146C1E50603_594532148.addTaint(taint);
        return varC5F8D4120C28E1A13BED5146C1E50603_594532148;
        // ---------- Original Method ----------
        //assertAttached();
        //return (poolEntry.tracker == null) ?
            //null : poolEntry.tracker.toRoute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.033 -0400", hash_original_method = "80A37316B4189201422C5F911C37390F", hash_generated_method = "1B7DE4FF94EEA34DFE9424E01E844E80")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        addTaint(route.getTaint());
        assertAttached();
        poolEntry.open(route, context, params);
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.open(route, context, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.033 -0400", hash_original_method = "88C576A6679A37807219C856CF85AF45", hash_generated_method = "C7A772C5D9CA5483F6968B0C747911C8")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
        assertAttached();
        poolEntry.tunnelTarget(secure, params);
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.tunnelTarget(secure, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.034 -0400", hash_original_method = "183042F5C82645DA134EED3F0129F7AB", hash_generated_method = "687D80B806CC4A6432C152EC06D59E1D")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
        addTaint(next.getTaint());
        assertAttached();
        poolEntry.tunnelProxy(next, secure, params);
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.tunnelProxy(next, secure, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.034 -0400", hash_original_method = "265D546872DD850E8FA8148DAC362DDA", hash_generated_method = "91C07C00F27EE95A6AB0510A6E3D2FCB")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        assertAttached();
        poolEntry.layerProtocol(context, params);
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.layerProtocol(context, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.035 -0400", hash_original_method = "8ECE47B171EFAD2F7C7D2EB622E49CF6", hash_generated_method = "3EFB64B7C9ED953A22501D25E8D5B822")
    public void close() throws IOException {
        if(poolEntry != null)        
        poolEntry.shutdownEntry();
        OperatedClientConnection conn = getWrappedConnection();
        if(conn != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.035 -0400", hash_original_method = "62B1930ABF96982C844F6DB1D64DBF05", hash_generated_method = "1CED8DA7C62C6ADEDF386868CBA5833C")
    public void shutdown() throws IOException {
        if(poolEntry != null)        
        poolEntry.shutdownEntry();
        OperatedClientConnection conn = getWrappedConnection();
        if(conn != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.035 -0400", hash_original_method = "C5C538BA26E5B2F7103C95948BE64C97", hash_generated_method = "07ACD9B2EF238BD9C9684EA1EC0BAE41")
    public Object getState() {
        assertAttached();
Object var7F2463EB7333088EF88482ACEB1D2901_1454566684 =         poolEntry.getState();
        var7F2463EB7333088EF88482ACEB1D2901_1454566684.addTaint(taint);
        return var7F2463EB7333088EF88482ACEB1D2901_1454566684;
        // ---------- Original Method ----------
        //assertAttached();
        //return poolEntry.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.036 -0400", hash_original_method = "F3A64AA6A34ABFCB96806A5E0FDB2DA5", hash_generated_method = "15A5E7901381F6A0A47ECEFF8993A677")
    public void setState(final Object state) {
        addTaint(state.getTaint());
        assertAttached();
        poolEntry.setState(state);
        // ---------- Original Method ----------
        //assertAttached();
        //poolEntry.setState(state);
    }

    
}

