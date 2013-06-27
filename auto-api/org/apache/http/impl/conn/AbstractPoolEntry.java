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
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractPoolEntry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.600 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.600 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "D4C9C47F1F7C872802E0304B9FD77E44")

    protected OperatedClientConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.600 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "97CC789B8D32E8E2BDCBD160D5FD1F3A")

    protected volatile HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.600 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "84C5CEDAE5C6F44A990A3028DB7D51E1")

    protected volatile Object state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.608 -0400", hash_original_field = "AE2AEB935C2A8C7A80FB116093EF35CA", hash_generated_field = "178FE92301487BDC4E429ED14BD188F8")

    protected volatile RouteTracker tracker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.609 -0400", hash_original_method = "87A56F69F978A1F4113143BFD741AEF0", hash_generated_method = "9292B8B25FB3E8B04BEE9D5FEA0426C3")
    protected  AbstractPoolEntry(ClientConnectionOperator connOperator,
                                HttpRoute route) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Connection operator may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.609 -0400", hash_original_method = "079ECF1B585CB82D2480C2A65F324FB6", hash_generated_method = "0EC597E938D586CA6D2DDA41803CC94B")
    public Object getState() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1615856425 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1615856425 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1615856425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615856425;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.610 -0400", hash_original_method = "9D16F7D7F90D43454808FD39B427C300", hash_generated_method = "B09AF06B0499DA01F80DB609204967D6")
    public void setState(final Object state) {
        this.state = state;
        // ---------- Original Method ----------
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.617 -0400", hash_original_method = "52A8017CB43DDF5506166F15621D416B", hash_generated_method = "E18BCE55093327FE06A50E6F1B19CCF3")
    public void open(HttpRoute route,
                     HttpContext context, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Route must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean varA53A034F09BC6D3FD6551BC8635A9340_901977964 = ((this.tracker != null) && this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection already open.");
            } //End block
        } //End collapsed parenthetic
        this.tracker = new RouteTracker(route);
        HttpHost proxy;
        proxy = route.getProxyHost();
        connOperator.openConnection
            (this.connection,
             (proxy != null) ? proxy : route.getTargetHost(),
             route.getLocalAddress(),
             context, params);
        RouteTracker localTracker;
        localTracker = tracker;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Request aborted");
        } //End block
        {
            localTracker.connectTarget(this.connection.isSecure());
        } //End block
        {
            localTracker.connectProxy(proxy, this.connection.isSecure());
        } //End block
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.618 -0400", hash_original_method = "01B7EFBCCE4449D378FBB0354733064C", hash_generated_method = "41DA9B954E197C9187FF8435935D8A29")
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_198689989 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9FCCA8FE59EBDE44EBD088F0040BBA40_1839242237 = (this.tracker.isTunnelled());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Connection is already tunnelled.");
            } //End block
        } //End collapsed parenthetic
        this.connection.update(null, tracker.getTargetHost(),
                               secure, params);
        this.tracker.tunnelTarget(secure);
        addTaint(secure);
        addTaint(params.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.618 -0400", hash_original_method = "5E0B2221F8D2EF0994AAAD177B417545", hash_generated_method = "5BDB2E2CA41016EA4D9D7E4636A83725")
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Next proxy must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_484465702 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } //End block
        } //End collapsed parenthetic
        this.connection.update(null, next, secure, params);
        this.tracker.tunnelProxy(next, secure);
        addTaint(next.getTaint());
        addTaint(secure);
        addTaint(params.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.619 -0400", hash_original_method = "1EA8AE44B2BF05DF27C07019783A5F43", hash_generated_method = "2CE79E08BB5926056F05ECAF517A1FF5")
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        {
            boolean var618E2647C174E7CCBE3421E13C15B597_1454940184 = ((this.tracker == null) || !this.tracker.isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection not open.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6BCBA47712BDC3AE761EB09301F97C35_1319648860 = (!this.tracker.isTunnelled());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Protocol layering without a tunnel not supported.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var76BB44DF9EFE03570CD0DF7926366FE5_1344821339 = (this.tracker.isLayered());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Multiple protocol layering not supported.");
            } //End block
        } //End collapsed parenthetic
        HttpHost target;
        target = tracker.getTargetHost();
        connOperator.updateSecureConnection(this.connection, target,
                                             context, params);
        this.tracker.layerProtocol(this.connection.isSecure());
        addTaint(context.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.628 -0400", hash_original_method = "9A8AC70CC76BCE1A1C90EAA4BDE4B23E", hash_generated_method = "B91CAD5B2338FFE73AC3E521D4481C73")
    protected void shutdownEntry() {
        tracker = null;
        // ---------- Original Method ----------
        //tracker = null;
    }

    
}

