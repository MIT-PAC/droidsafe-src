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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "C918229792F6B488CD7E2D698EFF8324")

    private boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.544 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.554 -0400", hash_original_method = "225F1E2FD25662F69AE6A7484F5A3DE6", hash_generated_method = "D2F64EDD692833D0D9261C488E2609B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.554 -0400", hash_original_method = "9F2302B948E2DACBF43BEB44AB6E1806", hash_generated_method = "1431D61C28009DA2526CE6306C32B6F9")
    public  RouteTracker(HttpRoute route) {
        this(route.getTargetHost(), route.getLocalAddress());
        addTaint(route.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.555 -0400", hash_original_method = "BF1F9DC8D5382B51655F853917583FAE", hash_generated_method = "73763FC050D2C3DCF22885753D3B9F71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.555 -0400", hash_original_method = "3003DC7DA59FD970800BABF8F86CE4CE", hash_generated_method = "4672D04FA646BE7E459AD125141FF4BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.567 -0400", hash_original_method = "E27069CB33BE85EAA2A2A23BD0F575F7", hash_generated_method = "B814C587C5B1BE25CCA9C1D6869489DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.568 -0400", hash_original_method = "F92C099980BF3075944300484370C03E", hash_generated_method = "86E7D7CDC1021B78D23BFC00F2424087")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.568 -0400", hash_original_method = "54E7131A3C39BD59A18A0ED51B306BB3", hash_generated_method = "ED35C82EDDF9529173CE74EA649FD468")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.569 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "27CD78246C46A345462DA34517D836E0")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_986218505 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_986218505 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_986218505.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986218505;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.569 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "557346E095ACAB12F5C1518F93099419")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_368012919 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_368012919 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_368012919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_368012919;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.574 -0400", hash_original_method = "6ABB5CCC8F0E8E8F1BDF34E043639F85", hash_generated_method = "8B41691382DA5C16621EC7A099A715CC")
    public final int getHopCount() {
        int hops;
        hops = 0;
        {
            hops = 1;
            hops = proxyChain.length + 1;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837757155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837757155;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.575 -0400", hash_original_method = "CFC4B3441FDC551CC1F391519968AE1F", hash_generated_method = "3682950A514946ED3A1DEF5F9F55FD95")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_327132700 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_327132700 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_327132700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327132700;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.582 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "A24C1CDCEDF2139AFF72BE4929E31571")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1095418198 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1095418198 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_1095418198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1095418198;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.588 -0400", hash_original_method = "42622BE2571C040A9FEE72D0CCBA0217", hash_generated_method = "AD10E7FC19BCE14F888269323B278257")
    public final boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962821669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962821669;
        // ---------- Original Method ----------
        //return this.connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.589 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "54BD5C9B4017749DBB6E923C3210643F")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_335823144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_335823144 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_335823144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_335823144;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.589 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "BADBD9479D9F6F77B9C66C2953FCE360")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077996123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077996123;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.607 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "7721EE4ED0938FA382BFC363A4B6E2AB")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_2009521504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2009521504 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_2009521504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2009521504;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.607 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "8C2B0392FE4C354B0953901EF0390094")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978309112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978309112;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.608 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "53E9FEE1EA88F494DFFFD94502F544FC")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922333339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922333339;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.608 -0400", hash_original_method = "F708D9F908B17C9085BF9A499A01375A", hash_generated_method = "24745ECACDA652352D48991B60D9C438")
    public final HttpRoute toRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_885141529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_885141529 = !this.connected ?
            null : new HttpRoute(this.targetHost, this.localAddress,
                                 this.proxyChain, this.secure,
                                 this.tunnelled, this.layered);
        varB4EAC82CA7396A68D541C85D26508E83_885141529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_885141529;
        // ---------- Original Method ----------
        //return !this.connected ?
            //null : new HttpRoute(this.targetHost, this.localAddress,
                                 //this.proxyChain, this.secure,
                                 //this.tunnelled, this.layered);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.610 -0400", hash_original_method = "63363EB4B4D28F766A23B83B48599393", hash_generated_method = "92FF6D9FE2767EAE06920627FAFFF724")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_12941990 = (o == this);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692423934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692423934;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.613 -0400", hash_original_method = "DF8EA32EAB4DFA40B45F048298D9408F", hash_generated_method = "4ADF9F7C288A9EB7CC4F0FC82714930B")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538629460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538629460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.614 -0400", hash_original_method = "B9AFE31805DA49D5CF66B21B19FA6A72", hash_generated_method = "F885D6442066A3BBCB0AF4A8D394D405")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_640711807 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_640711807 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_640711807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_640711807;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.636 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "6B737D713F98EB2DF861D6D28E922CB8")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_595921940 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_595921940 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_595921940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_595921940;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

