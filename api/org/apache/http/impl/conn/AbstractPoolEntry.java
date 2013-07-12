package org.apache.http.impl.conn;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.734 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.734 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "D4C9C47F1F7C872802E0304B9FD77E44")

    protected OperatedClientConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.734 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "97CC789B8D32E8E2BDCBD160D5FD1F3A")

    protected volatile HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.734 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "84C5CEDAE5C6F44A990A3028DB7D51E1")

    protected volatile Object state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.734 -0400", hash_original_field = "AE2AEB935C2A8C7A80FB116093EF35CA", hash_generated_field = "178FE92301487BDC4E429ED14BD188F8")

    protected volatile RouteTracker tracker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.736 -0400", hash_original_method = "87A56F69F978A1F4113143BFD741AEF0", hash_generated_method = "13057604C930317AF0187522B1CFAB1D")
    protected  AbstractPoolEntry(ClientConnectionOperator connOperator,
                                HttpRoute route) {
        super();
    if(connOperator == null)        
        {
            IllegalArgumentException var77D8C168DB874D3F429F1A2BBEABDD03_2069505036 = new IllegalArgumentException("Connection operator may not be null");
            var77D8C168DB874D3F429F1A2BBEABDD03_2069505036.addTaint(taint);
            throw var77D8C168DB874D3F429F1A2BBEABDD03_2069505036;
        } 
        this.connOperator = connOperator;
        this.connection = connOperator.createConnection();
        this.route = route;
        this.tracker = null;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.736 -0400", hash_original_method = "079ECF1B585CB82D2480C2A65F324FB6", hash_generated_method = "A85759C94F4A635E14952D976AAAA7F1")
    public Object getState() {
Object var37C56C9D63C623261861C16DCFB73F6D_1856145489 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1856145489.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1856145489;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.736 -0400", hash_original_method = "9D16F7D7F90D43454808FD39B427C300", hash_generated_method = "B09AF06B0499DA01F80DB609204967D6")
    public void setState(final Object state) {
        this.state = state;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.737 -0400", hash_original_method = "52A8017CB43DDF5506166F15621D416B", hash_generated_method = "CF7019457932F2CF004B2FFBFD83CAF2")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
    if(route == null)        
        {
            IllegalArgumentException var9D1E04CAB225D0E33B73D3F7F4C9F93A_1253613512 = new IllegalArgumentException
                ("Route must not be null.");
            var9D1E04CAB225D0E33B73D3F7F4C9F93A_1253613512.addTaint(taint);
            throw var9D1E04CAB225D0E33B73D3F7F4C9F93A_1253613512;
        } 
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_159619154 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_159619154.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_159619154;
        } 
    if((this.tracker != null) && this.tracker.isConnected())        
        {
            IllegalStateException var9EFA0E3F95B3C927C86C9A5F3C3B0F44_353655019 = new IllegalStateException("Connection already open.");
            var9EFA0E3F95B3C927C86C9A5F3C3B0F44_353655019.addTaint(taint);
            throw var9EFA0E3F95B3C927C86C9A5F3C3B0F44_353655019;
        } 
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
            IOException var19DC2E435233885AF69F964030F77E39_566306936 = new IOException("Request aborted");
            var19DC2E435233885AF69F964030F77E39_566306936.addTaint(taint);
            throw var19DC2E435233885AF69F964030F77E39_566306936;
        } 
    if(proxy == null)        
        {
            localTracker.connectTarget(this.connection.isSecure());
        } 
        else
        {
            localTracker.connectProxy(proxy, this.connection.isSecure());
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.738 -0400", hash_original_method = "01B7EFBCCE4449D378FBB0354733064C", hash_generated_method = "F3040F84787AF77AF37A87B1F14E8604")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_619625960 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_619625960.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_619625960;
        } 
    if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_1118141597 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_1118141597.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_1118141597;
        } 
    if(this.tracker.isTunnelled())        
        {
            IllegalStateException var285AA9BEE39E730EC5B246C53E146516_1973492799 = new IllegalStateException
                ("Connection is already tunnelled.");
            var285AA9BEE39E730EC5B246C53E146516_1973492799.addTaint(taint);
            throw var285AA9BEE39E730EC5B246C53E146516_1973492799;
        } 
        this.connection.update(null, tracker.getTargetHost(),
                               secure, params);
        this.tracker.tunnelTarget(secure);
        
        
            
                
        
        
            
        
        
            
                
        
        
                               
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.739 -0400", hash_original_method = "5E0B2221F8D2EF0994AAAD177B417545", hash_generated_method = "0FAEB73EDF418EDD6C5D3BF2C982658A")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(secure);
        addTaint(next.getTaint());
    if(next == null)        
        {
            IllegalArgumentException var22F25C656A749620C460C47C1D4C9160_1333413719 = new IllegalArgumentException
                ("Next proxy must not be null.");
            var22F25C656A749620C460C47C1D4C9160_1333413719.addTaint(taint);
            throw var22F25C656A749620C460C47C1D4C9160_1333413719;
        } 
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_515166308 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_515166308.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_515166308;
        } 
    if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_131684598 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_131684598.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_131684598;
        } 
        this.connection.update(null, next, secure, params);
        this.tracker.tunnelProxy(next, secure);
        
        
            
                
        
        
            
                
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.740 -0400", hash_original_method = "1EA8AE44B2BF05DF27C07019783A5F43", hash_generated_method = "5CBDFA66FD07178FAA276271E90C3922")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(context.getTaint());
    if(params == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1767607655 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1767607655.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1767607655;
        } 
    if((this.tracker == null) || !this.tracker.isConnected())        
        {
            IllegalStateException var2C3BAE8D9D400EBC69A876F87FDE68FA_1118022101 = new IllegalStateException("Connection not open.");
            var2C3BAE8D9D400EBC69A876F87FDE68FA_1118022101.addTaint(taint);
            throw var2C3BAE8D9D400EBC69A876F87FDE68FA_1118022101;
        } 
    if(!this.tracker.isTunnelled())        
        {
            IllegalStateException var50364EE758C5DA761F7054170B5DFB2B_891108638 = new IllegalStateException
                ("Protocol layering without a tunnel not supported.");
            var50364EE758C5DA761F7054170B5DFB2B_891108638.addTaint(taint);
            throw var50364EE758C5DA761F7054170B5DFB2B_891108638;
        } 
    if(this.tracker.isLayered())        
        {
            IllegalStateException var6283407F3902AE9CD97120F27705909E_838635037 = new IllegalStateException
                ("Multiple protocol layering not supported.");
            var6283407F3902AE9CD97120F27705909E_838635037.addTaint(taint);
            throw var6283407F3902AE9CD97120F27705909E_838635037;
        } 
        final HttpHost target = tracker.getTargetHost();
        connOperator.updateSecureConnection(this.connection, target,
                                             context, params);
        this.tracker.layerProtocol(this.connection.isSecure());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.741 -0400", hash_original_method = "9A8AC70CC76BCE1A1C90EAA4BDE4B23E", hash_generated_method = "B91CAD5B2338FFE73AC3E521D4481C73")
    protected void shutdownEntry() {
        tracker = null;
        
        
    }

    
}

