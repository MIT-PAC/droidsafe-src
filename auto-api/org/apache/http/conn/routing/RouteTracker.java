package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class RouteTracker implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "C918229792F6B488CD7E2D698EFF8324")

    private boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.524 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.525 -0400", hash_original_method = "225F1E2FD25662F69AE6A7484F5A3DE6", hash_generated_method = "D2F64EDD692833D0D9261C488E2609B4")
    public  RouteTracker(HttpHost target, InetAddress local) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Target host may not be null.");
        } //End block
        this.targetHost   = target;
        this.localAddress = local;
        this.tunnelled    = TunnelType.PLAIN;
        this.layered      = LayerType.PLAIN;
        // ---------- Original Method ----------
        //if (target == null) {
            //throw new IllegalArgumentException("Target host may not be null.");
        //}
        //this.targetHost   = target;
        //this.localAddress = local;
        //this.tunnelled    = TunnelType.PLAIN;
        //this.layered      = LayerType.PLAIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.525 -0400", hash_original_method = "9F2302B948E2DACBF43BEB44AB6E1806", hash_generated_method = "1431D61C28009DA2526CE6306C32B6F9")
    public  RouteTracker(HttpRoute route) {
        this(route.getTargetHost(), route.getLocalAddress());
        addTaint(route.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.525 -0400", hash_original_method = "BF1F9DC8D5382B51655F853917583FAE", hash_generated_method = "73763FC050D2C3DCF22885753D3B9F71")
    public final void connectTarget(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected.");
        } //End block
        this.connected = true;
        this.secure = secure;
        // ---------- Original Method ----------
        //if (this.connected) {
            //throw new IllegalStateException("Already connected.");
        //}
        //this.connected = true;
        //this.secure = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.526 -0400", hash_original_method = "3003DC7DA59FD970800BABF8F86CE4CE", hash_generated_method = "4672D04FA646BE7E459AD125141FF4BB")
    public final void connectProxy(HttpHost proxy, boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected.");
        } //End block
        this.connected  = true;
        this.proxyChain = new HttpHost[]{ proxy };
        this.secure     = secure;
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("Proxy host may not be null.");
        //}
        //if (this.connected) {
            //throw new IllegalStateException("Already connected.");
        //}
        //this.connected  = true;
        //this.proxyChain = new HttpHost[]{ proxy };
        //this.secure     = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.526 -0400", hash_original_method = "E27069CB33BE85EAA2A2A23BD0F575F7", hash_generated_method = "B814C587C5B1BE25CCA9C1D6869489DC")
    public final void tunnelTarget(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel unless connected.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel without proxy.");
        } //End block
        this.tunnelled = TunnelType.TUNNELLED;
        this.secure    = secure;
        // ---------- Original Method ----------
        //if (!this.connected) {
            //throw new IllegalStateException("No tunnel unless connected.");
        //}
        //if (this.proxyChain == null) {
            //throw new IllegalStateException("No tunnel without proxy.");
        //}
        //this.tunnelled = TunnelType.TUNNELLED;
        //this.secure    = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.535 -0400", hash_original_method = "F92C099980BF3075944300484370C03E", hash_generated_method = "86E7D7CDC1021B78D23BFC00F2424087")
    public final void tunnelProxy(HttpHost proxy, boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel unless connected.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No proxy tunnel without proxy.");
        } //End block
        HttpHost[] proxies;
        proxies = new HttpHost[this.proxyChain.length+1];
        System.arraycopy(this.proxyChain, 0,
                         proxies, 0, this.proxyChain.length);
        proxies[proxies.length-1] = proxy;
        this.proxyChain = proxies;
        this.secure     = secure;
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("Proxy host may not be null.");
        //}
        //if (!this.connected) {
            //throw new IllegalStateException("No tunnel unless connected.");
        //}
        //if (this.proxyChain == null) {
            //throw new IllegalStateException("No proxy tunnel without proxy.");
        //}
        //HttpHost[] proxies = new HttpHost[this.proxyChain.length+1];
        //System.arraycopy(this.proxyChain, 0,
                         //proxies, 0, this.proxyChain.length);
        //proxies[proxies.length-1] = proxy;
        //this.proxyChain = proxies;
        //this.secure     = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.536 -0400", hash_original_method = "54E7131A3C39BD59A18A0ED51B306BB3", hash_generated_method = "ED35C82EDDF9529173CE74EA649FD468")
    public final void layerProtocol(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No layered protocol unless connected.");
        } //End block
        this.layered = LayerType.LAYERED;
        this.secure  = secure;
        // ---------- Original Method ----------
        //if (!this.connected) {
            //throw new IllegalStateException
                //("No layered protocol unless connected.");
        //}
        //this.layered = LayerType.LAYERED;
        //this.secure  = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.539 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "E3A886EB3431FC56393CEA753004D58E")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1402633761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1402633761 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1402633761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1402633761;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.539 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "2D40F52A5D7357AAD203C7A5DB01D689")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_524654648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524654648 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_524654648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524654648;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.546 -0400", hash_original_method = "6ABB5CCC8F0E8E8F1BDF34E043639F85", hash_generated_method = "AE497B4F33069A4076869D537F039BE7")
    public final int getHopCount() {
        int hops;
        hops = 0;
        {
            hops = 1;
            hops = proxyChain.length + 1;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201241267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201241267;
        // ---------- Original Method ----------
        //int hops = 0;
        //if (this.connected) {
            //if (proxyChain == null)
                //hops = 1;
            //else
                //hops = proxyChain.length + 1;
        //}
        //return hops;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.558 -0400", hash_original_method = "CFC4B3441FDC551CC1F391519968AE1F", hash_generated_method = "6487434E5B54C8F32FF58BD07548E5FE")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1449485526 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        int hopcount;
        hopcount = getHopCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds tracked route length " + hopcount +".");
        } //End block
        HttpHost result;
        result = null;
        result = this.proxyChain[hop];
        result = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1449485526 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_1449485526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1449485526;
        // ---------- Original Method ----------
        //if (hop < 0)
            //throw new IllegalArgumentException
                //("Hop index must not be negative: " + hop);
        //final int hopcount = getHopCount();
        //if (hop >= hopcount) {
            //throw new IllegalArgumentException
                //("Hop index " + hop +
                 //" exceeds tracked route length " + hopcount +".");
        //}
        //HttpHost result = null;
        //if (hop < hopcount-1)
            //result = this.proxyChain[hop];
        //else
            //result = this.targetHost;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.559 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "DA00169B0881CB9AA152AF88CB957B9D")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_778459691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_778459691 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_778459691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_778459691;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.559 -0400", hash_original_method = "42622BE2571C040A9FEE72D0CCBA0217", hash_generated_method = "6B96557BB579059DE25667308D72DBE3")
    public final boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124334975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124334975;
        // ---------- Original Method ----------
        //return this.connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.559 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "06DC98BD0240BA06369FB09138ACABEF")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_1407714756 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1407714756 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_1407714756.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1407714756;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.560 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "72751A3DB8FC57077C4CC50F348C8465")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660091127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660091127;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.560 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "E3935543D4318BD4AEC184DE22CA0A25")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_786543283 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_786543283 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_786543283.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_786543283;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.565 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "1F67592506B49F53415A7D768C8E3125")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765731189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765731189;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.572 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "36F8C47ED96EFB35054C7EC2DE49BB30")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200041958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200041958;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.577 -0400", hash_original_method = "F708D9F908B17C9085BF9A499A01375A", hash_generated_method = "CEE3DF93D075B2A50BB18D55AE46C418")
    public final HttpRoute toRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1422803987 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1422803987 = !this.connected ?
            null : new HttpRoute(this.targetHost, this.localAddress,
                                 this.proxyChain, this.secure,
                                 this.tunnelled, this.layered);
        varB4EAC82CA7396A68D541C85D26508E83_1422803987.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422803987;
        // ---------- Original Method ----------
        //return !this.connected ?
            //null : new HttpRoute(this.targetHost, this.localAddress,
                                 //this.proxyChain, this.secure,
                                 //this.tunnelled, this.layered);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.587 -0400", hash_original_method = "63363EB4B4D28F766A23B83B48599393", hash_generated_method = "E70F92A6D4FF6DBC9B7332A545CDCA0B")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_2098597548 = (o == this);
        } //End collapsed parenthetic
        RouteTracker that;
        that = (RouteTracker) o;
        boolean equal;
        equal = this.targetHost.equals(that.targetHost);
        equal &=
            ( this.localAddress == that.localAddress) ||
            ((this.localAddress != null) &&
              this.localAddress.equals(that.localAddress));
        equal &=
            ( this.proxyChain        == that.proxyChain) ||
            ((this.proxyChain        != null) &&
             (that.proxyChain        != null) &&
             (this.proxyChain.length == that.proxyChain.length));
        equal &=
            (this.connected == that.connected) &&
            (this.secure    == that.secure) &&
            (this.tunnelled == that.tunnelled) &&
            (this.layered   == that.layered);
        {
            {
                int i;
                i = 0;
                equal = this.proxyChain[i].equals(that.proxyChain[i]);
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624696210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624696210;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.591 -0400", hash_original_method = "DF8EA32EAB4DFA40B45F048298D9408F", hash_generated_method = "66DECFA271DEB231F6A7EF6C0A1053C9")
    @Override
    public final int hashCode() {
        int hc;
        hc = this.targetHost.hashCode();
        hc ^= localAddress.hashCode();
        {
            hc ^= proxyChain.length;
            {
                int i;
                i = 0;
                hc ^= proxyChain[i].hashCode();
            } //End collapsed parenthetic
        } //End block
        hc ^= 0x11111111;
        hc ^= 0x22222222;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121507405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121507405;
        // ---------- Original Method ----------
        //int hc = this.targetHost.hashCode();
        //if (this.localAddress != null)
            //hc ^= localAddress.hashCode();
        //if (this.proxyChain != null) {
            //hc ^= proxyChain.length;
            //for (int i=0; i<proxyChain.length; i++)
                //hc ^= proxyChain[i].hashCode();
        //}
        //if (this.connected)
            //hc ^= 0x11111111;
        //if (this.secure)
            //hc ^= 0x22222222;
        //hc ^= this.tunnelled.hashCode();
        //hc ^= this.layered.hashCode();
        //return hc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.630 -0400", hash_original_method = "B9AFE31805DA49D5CF66B21B19FA6A72", hash_generated_method = "B51976F834F97F25A828CCEB9374D539")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_188405410 = null; //Variable for return #1
        StringBuilder cab;
        cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("RouteTracker[");
        {
            cab.append(this.localAddress);
            cab.append("->");
        } //End block
        cab.append('{');
        cab.append('c');
        cab.append('t');
        cab.append('l');
        cab.append('s');
        cab.append("}->");
        {
            {
                int i;
                i = 0;
                {
                    cab.append(this.proxyChain[i]);
                    cab.append("->");
                } //End block
            } //End collapsed parenthetic
        } //End block
        cab.append(this.targetHost);
        cab.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_188405410 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_188405410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_188405410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.631 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "1D29DAA9FDDA65DBF75C7677370569FE")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1330082151 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1330082151 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1330082151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330082151;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

