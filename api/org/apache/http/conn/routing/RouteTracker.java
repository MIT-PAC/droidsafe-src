package org.apache.http.conn.routing;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class RouteTracker implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.256 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.256 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.256 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "C918229792F6B488CD7E2D698EFF8324")

    private boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_method = "225F1E2FD25662F69AE6A7484F5A3DE6", hash_generated_method = "D2F64EDD692833D0D9261C488E2609B4")
    public  RouteTracker(HttpHost target, InetAddress local) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Target host may not be null.");
        } 
        this.targetHost   = target;
        this.localAddress = local;
        this.tunnelled    = TunnelType.PLAIN;
        this.layered      = LayerType.PLAIN;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.257 -0400", hash_original_method = "9F2302B948E2DACBF43BEB44AB6E1806", hash_generated_method = "1431D61C28009DA2526CE6306C32B6F9")
    public  RouteTracker(HttpRoute route) {
        this(route.getTargetHost(), route.getLocalAddress());
        addTaint(route.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.258 -0400", hash_original_method = "BF1F9DC8D5382B51655F853917583FAE", hash_generated_method = "73763FC050D2C3DCF22885753D3B9F71")
    public final void connectTarget(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected.");
        } 
        this.connected = true;
        this.secure = secure;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.258 -0400", hash_original_method = "3003DC7DA59FD970800BABF8F86CE4CE", hash_generated_method = "4672D04FA646BE7E459AD125141FF4BB")
    public final void connectProxy(HttpHost proxy, boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy host may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected.");
        } 
        this.connected  = true;
        this.proxyChain = new HttpHost[]{ proxy };
        this.secure     = secure;
        addTaint(proxy.getTaint());
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.258 -0400", hash_original_method = "E27069CB33BE85EAA2A2A23BD0F575F7", hash_generated_method = "B814C587C5B1BE25CCA9C1D6869489DC")
    public final void tunnelTarget(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel unless connected.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel without proxy.");
        } 
        this.tunnelled = TunnelType.TUNNELLED;
        this.secure    = secure;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.259 -0400", hash_original_method = "F92C099980BF3075944300484370C03E", hash_generated_method = "B814DCECE5F23471B84D584C677F0893")
    public final void tunnelProxy(HttpHost proxy, boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy host may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tunnel unless connected.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No proxy tunnel without proxy.");
        } 
        HttpHost[] proxies = new HttpHost[this.proxyChain.length+1];
        System.arraycopy(this.proxyChain, 0,
                         proxies, 0, this.proxyChain.length);
        proxies[proxies.length-1] = proxy;
        this.proxyChain = proxies;
        this.secure     = secure;
        addTaint(proxy.getTaint());
        
        
            
        
        
            
        
        
            
        
        
        
                         
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.259 -0400", hash_original_method = "54E7131A3C39BD59A18A0ED51B306BB3", hash_generated_method = "ED35C82EDDF9529173CE74EA649FD468")
    public final void layerProtocol(boolean secure) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No layered protocol unless connected.");
        } 
        this.layered = LayerType.LAYERED;
        this.secure  = secure;
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.260 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "BEC8611FB03A5AA2716EBB3BDB525E39")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_568297437 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_568297437 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_568297437.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_568297437;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.261 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "B242B7CD68285EA5CB913B777972F7CA")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_198511465 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_198511465 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_198511465.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_198511465;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.261 -0400", hash_original_method = "6ABB5CCC8F0E8E8F1BDF34E043639F85", hash_generated_method = "766FC878BEA0ED08DA0AE9A516AB244E")
    public final int getHopCount() {
        int hops = 0;
        {
            hops = 1;
            hops = proxyChain.length + 1;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549259528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549259528;
        
        
        
            
                
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.262 -0400", hash_original_method = "CFC4B3441FDC551CC1F391519968AE1F", hash_generated_method = "00D2ED9160ED6AF0F66DB6190B4D2D70")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1127806296 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        final int hopcount = getHopCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds tracked route length " + hopcount +".");
        } 
        HttpHost result = null;
        result = this.proxyChain[hop];
        result = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1127806296 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_1127806296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1127806296;
        
        
            
                
        
        
            
                
                 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.263 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "676DF9D223572DE74521C8782AF68C97")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1897330404 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1897330404 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_1897330404.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1897330404;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.263 -0400", hash_original_method = "42622BE2571C040A9FEE72D0CCBA0217", hash_generated_method = "21B0BEF7F1B6587EC47CF90DC79E44E5")
    public final boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475822597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475822597;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.264 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "E9E333F6393AFA4E5F185B4B19C62A9A")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_1722325150 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1722325150 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_1722325150.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1722325150;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.264 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "BBAE830D7520E2A69385F767866A50C7")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900046780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900046780;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.264 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "A18A8DC68E078331EA95A64BF95C6019")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_1317762903 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1317762903 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_1317762903.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1317762903;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.264 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "26479DB7C451EEE3DB1B4CB25E2DB684")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895112224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895112224;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.265 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "AB5BE1AAE9253B552C9270A8AE5E4391")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1404994766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1404994766;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.265 -0400", hash_original_method = "F708D9F908B17C9085BF9A499A01375A", hash_generated_method = "0CA0966648DC3F11E2C62313A00D4FF4")
    public final HttpRoute toRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_930866949 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_930866949 = !this.connected ?
            null : new HttpRoute(this.targetHost, this.localAddress,
                                 this.proxyChain, this.secure,
                                 this.tunnelled, this.layered);
        varB4EAC82CA7396A68D541C85D26508E83_930866949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_930866949;
        
        
            
                                 
                                 
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.267 -0400", hash_original_method = "63363EB4B4D28F766A23B83B48599393", hash_generated_method = "357DDA7F5331BED3F4B99207AF584FF3")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_271167467 = (o == this);
        } 
        RouteTracker that = (RouteTracker) o;
        boolean equal = this.targetHost.equals(that.targetHost);
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
                int i = 0;
                equal = this.proxyChain[i].equals(that.proxyChain[i]);
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775755042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775755042;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.267 -0400", hash_original_method = "DF8EA32EAB4DFA40B45F048298D9408F", hash_generated_method = "0AA3F22FE8B5A4D37D33BD3518D946DA")
    @Override
    public final int hashCode() {
        int hc = this.targetHost.hashCode();
        hc ^= localAddress.hashCode();
        {
            hc ^= proxyChain.length;
            {
                int i = 0;
                hc ^= proxyChain[i].hashCode();
            } 
        } 
        hc ^= 0x11111111;
        hc ^= 0x22222222;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110339490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110339490;
        
        
        
            
        
            
            
                
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.268 -0400", hash_original_method = "B9AFE31805DA49D5CF66B21B19FA6A72", hash_generated_method = "ACC39BE7CACF836A6F7CB5D48873E5FC")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1877270617 = null; 
        StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("RouteTracker[");
        {
            cab.append(this.localAddress);
            cab.append("->");
        } 
        cab.append('{');
        cab.append('c');
        cab.append('t');
        cab.append('l');
        cab.append('s');
        cab.append("}->");
        {
            {
                int i = 0;
                {
                    cab.append(this.proxyChain[i]);
                    cab.append("->");
                } 
            } 
        } 
        cab.append(this.targetHost);
        cab.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1877270617 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1877270617.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1877270617;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.274 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "87018FEDA9811AE118498D07D8723F7F")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_322438240 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_322438240 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_322438240.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_322438240;
        
        
    }

    
}

