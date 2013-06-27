package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class HttpRoute implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.471 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.472 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "927BB5F8253224F1A756FDFB9028EC63")
    private  HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy required if tunnelled.");
        } //End block
        tunnelled = TunnelType.PLAIN;
        layered = LayerType.PLAIN;
        this.targetHost   = target;
        this.localAddress = local;
        this.proxyChain   = proxies;
        this.secure       = secure;
        this.tunnelled    = tunnelled;
        this.layered      = layered;
        // ---------- Original Method ----------
        //if (target == null) {
            //throw new IllegalArgumentException
                //("Target host may not be null.");
        //}
        //if ((tunnelled == TunnelType.TUNNELLED) && (proxies == null)) {
            //throw new IllegalArgumentException
                //("Proxy required if tunnelled.");
        //}
        //if (tunnelled == null)
            //tunnelled = TunnelType.PLAIN;
        //if (layered == null)
            //layered = LayerType.PLAIN;
        //this.targetHost   = target;
        //this.localAddress = local;
        //this.proxyChain   = proxies;
        //this.secure       = secure;
        //this.tunnelled    = tunnelled;
        //this.layered      = layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.472 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "50EEBD76B7F39E55EB9DAAFDE4935DD2")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxies[0].getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.473 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "41C421CC4A0CCE3E2EF49AFBEA5AA9A9")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.473 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "5C6A10D8E362889D3FCA3FDD404BEF30")
    public  HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(secure);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.473 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "5C0081891C0BEB28A75B40D4B82FF215")
    public  HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.474 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "A4F7DC3868A2C5646DE71DFCE628C3AB")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy host may not be null.");
        } //End block
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException
                //("Proxy host may not be null.");
        //}
    }

    
        private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;
        return new HttpHost[]{ proxy };
    }

    
        private static HttpHost[] toChain(HttpHost[] proxies) {
        if ((proxies == null) || (proxies.length < 1))
            return null;
        for (HttpHost proxy : proxies) {
            if (proxy == null)
                throw new IllegalArgumentException
                        ("Proxy chain may not contain null elements.");
        }
        HttpHost[] result = new HttpHost[proxies.length];
        System.arraycopy(proxies, 0, result, 0, proxies.length);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.474 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "4BF9D93975888E953F3781C4C8C8FBF0")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_78428800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_78428800 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_78428800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_78428800;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.475 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "9D88F8375FA9672B84D1308F52BA0097")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1067712463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1067712463 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1067712463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1067712463;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.475 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "22A644090F3E0D04A7F034C934D6E474")
    public final int getHopCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170949264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170949264;
        // ---------- Original Method ----------
        //return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.487 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "DCD3F091FE3489DD7065F6DF8FC17A4A")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_196197161 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        int hopcount;
        hopcount = getHopCount();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        HttpHost result;
        result = null;
        result = this.proxyChain[hop];
        result = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_196197161 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_196197161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196197161;
        // ---------- Original Method ----------
        //if (hop < 0)
            //throw new IllegalArgumentException
                //("Hop index must not be negative: " + hop);
        //final int hopcount = getHopCount();
        //if (hop >= hopcount)
            //throw new IllegalArgumentException
                //("Hop index " + hop +
                 //" exceeds route length " + hopcount);
        //HttpHost result = null;
        //if (hop < hopcount-1)
            //result = this.proxyChain[hop];
        //else
            //result = this.targetHost;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.487 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "456D2B28CFA8E3E7885BD9217616619D")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_224706762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_224706762 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_224706762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224706762;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.488 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "C7D5460D67F9A0713020EE24A9758CC7")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_380928495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_380928495 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_380928495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380928495;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.488 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "B17168A1787B82C8C7F710D80A956B7C")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789722867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_789722867;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.503 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "E5B59B7B1B3E02415A125A9C39980C57")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_2094133979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2094133979 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_2094133979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2094133979;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.504 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "4D0E5B426C7B63B64146AC3966953619")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682969452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682969452;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.505 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "0FEDEB8E868549228A9746813C97F0FC")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251230799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251230799;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.525 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "9175B3763443922820EEC7D4C5990817")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_2099910840 = (o == this);
        } //End collapsed parenthetic
        HttpRoute that;
        that = (HttpRoute) o;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782993005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782993005;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.595 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "0D8C1E20154E1428C83F157EAD4479E2")
    @Override
    public final int hashCode() {
        int hc;
        hc = this.targetHost.hashCode();
        hc ^= localAddress.hashCode();
        {
            hc ^= proxyChain.length;
            {
                HttpHost aProxyChain = proxyChain[0];
                hc ^= aProxyChain.hashCode();
            } //End collapsed parenthetic
        } //End block
        hc ^= 0x11111111;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040402730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040402730;
        // ---------- Original Method ----------
        //int hc = this.targetHost.hashCode();
        //if (this.localAddress != null)
            //hc ^= localAddress.hashCode();
        //if (this.proxyChain != null) {
            //hc ^= proxyChain.length;
            //for (HttpHost aProxyChain : proxyChain) hc ^= aProxyChain.hashCode();
        //}
        //if (this.secure)
            //hc ^= 0x11111111;
        //hc ^= this.tunnelled.hashCode();
        //hc ^= this.layered.hashCode();
        //return hc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.652 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "A758D1AD8DF372A262A924E47CA5EC93")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1272154777 = null; //Variable for return #1
        StringBuilder cab;
        cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("HttpRoute[");
        {
            cab.append(this.localAddress);
            cab.append("->");
        } //End block
        cab.append('{');
        cab.append('t');
        cab.append('l');
        cab.append('s');
        cab.append("}->");
        {
            {
                HttpHost aProxyChain = this.proxyChain[0];
                {
                    cab.append(aProxyChain);
                    cab.append("->");
                } //End block
            } //End collapsed parenthetic
        } //End block
        cab.append(this.targetHost);
        cab.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1272154777 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1272154777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272154777;
        // ---------- Original Method ----------
        //StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        //cab.append("HttpRoute[");
        //if (this.localAddress != null) {
            //cab.append(this.localAddress);
            //cab.append("->");
        //}
        //cab.append('{');
        //if (this.tunnelled == TunnelType.TUNNELLED)
            //cab.append('t');
        //if (this.layered == LayerType.LAYERED)
            //cab.append('l');
        //if (this.secure)
            //cab.append('s');
        //cab.append("}->");
        //if (this.proxyChain != null) {
            //for (HttpHost aProxyChain : this.proxyChain) {
                //cab.append(aProxyChain);
                //cab.append("->");
            //}
        //}
        //cab.append(this.targetHost);
        //cab.append(']');
        //return cab.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.661 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "6B70FC3573934890503D556AD2260F67")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_51609777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51609777 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_51609777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51609777;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

