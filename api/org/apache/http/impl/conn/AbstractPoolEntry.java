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
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.002 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.002 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "D4C9C47F1F7C872802E0304B9FD77E44")

    protected OperatedClientConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.002 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "97CC789B8D32E8E2BDCBD160D5FD1F3A")

    protected volatile HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.002 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "84C5CEDAE5C6F44A990A3028DB7D51E1")

    protected volatile Object state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.002 -0400", hash_original_field = "AE2AEB935C2A8C7A80FB116093EF35CA", hash_generated_field = "178FE92301487BDC4E429ED14BD188F8")

    protected volatile RouteTracker tracker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.003 -0400", hash_original_method = "87A56F69F978A1F4113143BFD741AEF0", hash_generated_method = "02B6352DE14FB2785928DA0BF9F8F74A")
    protected  AbstractPoolEntry(ClientConnectionOperator connOperator,
                                HttpRoute route) {
        super();
        if(connOperator == null)        
        {
            IllegalArgumentException var77D8C168DB874D3F429F1A2BBEABDD03_864498518 = new IllegalArgumentException("Connection operator may not be null");
            var77D8C168DB874D3F429F1A2BBEABDD03_864498518.addTaint(taint);
            throw var77D8C168DB874D3F429F1A2BBEABDD03_864498518;
        } //End block
        this.connOperator = connOperator;
        this.connection = connOperator.createConnection();
        this.route = route;
        this.tracker = null;
        // ---------- Original Method ----------
        //if (connOperator == null) {
            //throw new IllegalArgumentException("Connection operator may not be null");
        //}
        //this.connOperator = connOperator;
        //this.connection = connOperator.createConnection();
        //this.route = route;
        //this.tracker = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.004 -0400", hash_original_method = "079ECF1B585CB82D2480C2A65F324FB6", hash_generated_method = "1F8EFC4A20BD8C8E86DB4F9DAE472DBA")
    public Object getState() {
Object var37C56C9D63C623261861C16DCFB73F6D_1920332035 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1920332035.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1920332035;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.004 -0400", hash_original_method = "9D16F7D7F90D43454808FD39B427C300", hash_generated_method = "B09AF06B0499DA01F80DB609204967D6")
    public void setState(final Object state) {
        this.state = state;
        // ---------- Original Method ----------
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.006 -0400", hash_original_method = "52A8017CB43DDF5506166F15621D416B", hash_generated_method = "AF8C30C92B9A50C8C96B5ADA9AFD0CCA")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        if(route == null)        
        {
            IllegalArgumentException var9D1E04CAB225D0E33B73D3F7F4C9F93A_1065842370 = new IllegalArgumentException
                ("Route must not be null.");
            var9D1E04CAB225D0E33B73D3F7F4C9F93A_1065842370.addTaint(taint);
            throw var9D1E04CAB225D0E33B73D3F7F4C9F93A_1065842370;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_587761882 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_587761882.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_587761882;
        } //End block
        if((this.tracker != null) && this.tracker.isConnected())        
        {
            IllegalStateException var9EFA0E3F95B3C927C86C9A5F3C3B0F44_1986740730 = new IllegalStateException("Connection already open.");
            var9EFA0E3F95B3C927C86C9A5F3C3B0F44_1986740730.addTaint(taint);
            throw var9EFA0E3F95B3C927C86C9A5F3C3B0F44_1986740730;
        } //End block
        this.tracker = new RouteTracker(route);
        final HttpHost proxy = route.getProxyHost();
        connOperator.openConnection
            (this.connection,
             (proxy != null) ? proxy : route.getTargetHost(),
             route.getLocalAddress(),
             context, params);
        RouteTracker localTracker = tracker;
        if(localTracker == null)        
        {
            IOException var19DC2E435233885AF69F964030F77E39_998583848 = new IOException("Request aborted");
            var19DC2E435233885AF69F964030F77E39_998583848.addTaint(taint);
            throw var19DC2E435233885AF69F964030F77E39_998583848;
        } //End block
        if(proxy == null)        
        {
            localTracker.connectTarget(this.connection.isSecure());
        } //End block
        else
        {
            localTracker.connectProxy(proxy, this.connection.isSecure());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.007 -0400", hash_original_method = "01B7EFBCCE4449D378FBB0354733064C", hash_generated_method = "A5AB1FCB8A3A9C744AEC4AD953D467C2")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_907777442 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_907777442.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_907777442;
        } //End block
        if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_1355433271 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_1355433271.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_1355433271;
        } //End block
        if(this.tracker.isTunnelled())        
        {
            IllegalStateException var285AA9BEE39E730EC5B246C53E146516_380100048 = new IllegalStateException
                ("Connection is already tunnelled.");
            var285AA9BEE39E730EC5B246C53E146516_380100048.addTaint(taint);
            throw var285AA9BEE39E730EC5B246C53E146516_380100048;
        } //End block
        this.connection.update(null, tracker.getTargetHost(),
                               secure, params);
        this.tracker.tunnelTarget(secure);
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //if ((this.tracker == null) || !this.tracker.isConnected()) {
            //throw new IllegalStateException("Connection not open.");
        //}
        //if (this.tracker.isTunnelled()) {
            //throw new IllegalStateException
                //("Connection is already tunnelled.");
        //}
        //this.connection.update(null, tracker.getTargetHost(),
                               //secure, params);
        //this.tracker.tunnelTarget(secure);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.008 -0400", hash_original_method = "5E0B2221F8D2EF0994AAAD177B417545", hash_generated_method = "E103713D596BC4A1E05BC478686ED61C")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
        addTaint(next.getTaint());
        if(next == null)        
        {
            IllegalArgumentException var22F25C656A749620C460C47C1D4C9160_1392706099 = new IllegalArgumentException
                ("Next proxy must not be null.");
            var22F25C656A749620C460C47C1D4C9160_1392706099.addTaint(taint);
            throw var22F25C656A749620C460C47C1D4C9160_1392706099;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_221847926 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_221847926.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_221847926;
        } //End block
        if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_723373974 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_723373974.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_723373974;
        } //End block
        this.connection.update(null, next, secure, params);
        this.tracker.tunnelProxy(next, secure);
        // ---------- Original Method ----------
        //if (next == null) {
            //throw new IllegalArgumentException
                //("Next proxy must not be null.");
        //}
        //if (params == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //if ((this.tracker == null) || !this.tracker.isConnected()) {
            //throw new IllegalStateException("Connection not open.");
        //}
        //this.connection.update(null, next, secure, params);
        //this.tracker.tunnelProxy(next, secure);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.010 -0400", hash_original_method = "1EA8AE44B2BF05DF27C07019783A5F43", hash_generated_method = "2347B167692049D07FB583FF680CF3B6")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
        if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_321530865 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_321530865.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_321530865;
        } //End block
        if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_658925494 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_658925494.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_658925494;
        } //End block
        if(!this.tracker.isTunnelled())        
        {
            IllegalStateException var50364EE758C5DA761F7054170B5DFB2B_1918456491 = new IllegalStateException
                ("Protocol layering without a tunnel not supported.");
            var50364EE758C5DA761F7054170B5DFB2B_1918456491.addTaint(taint);
            throw var50364EE758C5DA761F7054170B5DFB2B_1918456491;
        } //End block
        if(this.tracker.isLayered())        
        {
            IllegalStateException var6283407F3902AE9CD97120F27705909E_683028250 = new IllegalStateException
                ("Multiple protocol layering not supported.");
            var6283407F3902AE9CD97120F27705909E_683028250.addTaint(taint);
            throw var6283407F3902AE9CD97120F27705909E_683028250;
        } //End block
        final HttpHost target = tracker.getTargetHost();
        connOperator.updateSecureConnection(this.connection, target,
                                             context, params);
        this.tracker.layerProtocol(this.connection.isSecure());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.011 -0400", hash_original_method = "9A8AC70CC76BCE1A1C90EAA4BDE4B23E", hash_generated_method = "B91CAD5B2338FFE73AC3E521D4481C73")
    protected void shutdownEntry() {
        tracker = null;
        // ---------- Original Method ----------
        //tracker = null;
    }

    
}

