package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "D4C9C47F1F7C872802E0304B9FD77E44")

    protected OperatedClientConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "97CC789B8D32E8E2BDCBD160D5FD1F3A")

    protected volatile HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "84C5CEDAE5C6F44A990A3028DB7D51E1")

    protected volatile Object state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_field = "AE2AEB935C2A8C7A80FB116093EF35CA", hash_generated_field = "178FE92301487BDC4E429ED14BD188F8")

    protected volatile RouteTracker tracker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.377 -0400", hash_original_method = "87A56F69F978A1F4113143BFD741AEF0", hash_generated_method = "9292B8B25FB3E8B04BEE9D5FEA0426C3")
    protected  AbstractPoolEntry(ClientConnectionOperator connOperator,
                                HttpRoute route) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Connection operator may not be null");
        } 
        this.connOperator = connOperator;
        this.connection = connOperator.createConnection();
        this.route = route;
        this.tracker = null;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.378 -0400", hash_original_method = "079ECF1B585CB82D2480C2A65F324FB6", hash_generated_method = "AC643DA1D548FCBC05E69B046400B386")
    public Object getState() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1498080390 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1498080390 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1498080390.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1498080390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.378 -0400", hash_original_method = "9D16F7D7F90D43454808FD39B427C300", hash_generated_method = "B09AF06B0499DA01F80DB609204967D6")
    public void setState(final Object state) {
        this.state = state;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.379 -0400", hash_original_method = "52A8017CB43DDF5506166F15621D416B", hash_generated_method = "492A457CD669FAA17FCA4705BE40665B")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Route must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean varA53A034F09BC6D3FD6551BC8635A9340_1105990495 = ((this.tracker != null) && this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection already open.");
            } 
        } 
        this.tracker = new RouteTracker(route);
        final HttpHost proxy = route.getProxyHost();
        connOperator.openConnection
            (this.connection,
             (proxy != null) ? proxy : route.getTargetHost(),
             route.getLocalAddress(),
             context, params);
        RouteTracker localTracker = tracker;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Request aborted");
        } 
        {
            localTracker.connectTarget(this.connection.isSecure());
        } 
        {
            localTracker.connectProxy(proxy, this.connection.isSecure());
        } 
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.379 -0400", hash_original_method = "01B7EFBCCE4449D378FBB0354733064C", hash_generated_method = "DEF2751CAD9C595F7E28F98608350E16")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_1780417701 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } 
        } 
        {
            boolean var9FCCA8FE59EBDE44EBD088F0040BBA40_346947117 = (this.tracker.isTunnelled());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Connection is already tunnelled.");
            } 
        } 
        this.connection.update(null, tracker.getTargetHost(),
                               secure, params);
        this.tracker.tunnelTarget(secure);
        addTaint(secure);
        addTaint(params.getTaint());
        
        
            
                
        
        
            
        
        
            
                
        
        
                               
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.380 -0400", hash_original_method = "5E0B2221F8D2EF0994AAAD177B417545", hash_generated_method = "2977ACCFD1CB7D4CDE5DE63D0DC9D23E")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Next proxy must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_1137129205 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } 
        } 
        this.connection.update(null, next, secure, params);
        this.tracker.tunnelProxy(next, secure);
        addTaint(next.getTaint());
        addTaint(secure);
        addTaint(params.getTaint());
        
        
            
                
        
        
            
                
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.381 -0400", hash_original_method = "1EA8AE44B2BF05DF27C07019783A5F43", hash_generated_method = "BD839EF8C295242389310E1F1A90C714")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_821907092 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } 
        } 
        {
            boolean var6BCBA47712BDC3AE761EB09301F97C35_226129657 = (!this.tracker.isTunnelled());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Protocol layering without a tunnel not supported.");
            } 
        } 
        {
            boolean var76BB44DF9EFE03570CD0DF7926366FE5_892204174 = (this.tracker.isLayered());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Multiple protocol layering not supported.");
            } 
        } 
        final HttpHost target = tracker.getTargetHost();
        connOperator.updateSecureConnection(this.connection, target,
                                             context, params);
        this.tracker.layerProtocol(this.connection.isSecure());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.382 -0400", hash_original_method = "9A8AC70CC76BCE1A1C90EAA4BDE4B23E", hash_generated_method = "B91CAD5B2338FFE73AC3E521D4481C73")
    protected void shutdownEntry() {
        tracker = null;
        
        
    }

    
}

