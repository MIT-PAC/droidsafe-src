package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class RouteTracker implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "C918229792F6B488CD7E2D698EFF8324")

    private boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.574 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.575 -0400", hash_original_method = "225F1E2FD25662F69AE6A7484F5A3DE6", hash_generated_method = "E9F7D2908D6DA73BAA2178CC33E9CF17")
    public  RouteTracker(HttpHost target, InetAddress local) {
    if(target == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_1980976317 = new IllegalArgumentException("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_1980976317.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_1980976317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.576 -0400", hash_original_method = "9F2302B948E2DACBF43BEB44AB6E1806", hash_generated_method = "1431D61C28009DA2526CE6306C32B6F9")
    public  RouteTracker(HttpRoute route) {
        this(route.getTargetHost(), route.getLocalAddress());
        addTaint(route.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.576 -0400", hash_original_method = "BF1F9DC8D5382B51655F853917583FAE", hash_generated_method = "04D4E5A0C2790AD8D2CD10AFC0B33B22")
    public final void connectTarget(boolean secure) {
    if(this.connected)        
        {
            IllegalStateException var0CA65896F322A09D3E6BD61A388FA8B5_810085552 = new IllegalStateException("Already connected.");
            var0CA65896F322A09D3E6BD61A388FA8B5_810085552.addTaint(taint);
            throw var0CA65896F322A09D3E6BD61A388FA8B5_810085552;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.577 -0400", hash_original_method = "3003DC7DA59FD970800BABF8F86CE4CE", hash_generated_method = "E3353D2B08B01A842E87FEB89388A5AB")
    public final void connectProxy(HttpHost proxy, boolean secure) {
        addTaint(proxy.getTaint());
    if(proxy == null)        
        {
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_1188941972 = new IllegalArgumentException("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_1188941972.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_1188941972;
        } //End block
    if(this.connected)        
        {
            IllegalStateException var0CA65896F322A09D3E6BD61A388FA8B5_783910196 = new IllegalStateException("Already connected.");
            var0CA65896F322A09D3E6BD61A388FA8B5_783910196.addTaint(taint);
            throw var0CA65896F322A09D3E6BD61A388FA8B5_783910196;
        } //End block
        this.connected  = true;
        this.proxyChain = new HttpHost[]{ proxy };
        this.secure     = secure;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.578 -0400", hash_original_method = "E27069CB33BE85EAA2A2A23BD0F575F7", hash_generated_method = "5863A91467F84C0B9214E166F47A2EE1")
    public final void tunnelTarget(boolean secure) {
    if(!this.connected)        
        {
            IllegalStateException var84B6D964FE82434F45EFD2853AD96CB7_1571018586 = new IllegalStateException("No tunnel unless connected.");
            var84B6D964FE82434F45EFD2853AD96CB7_1571018586.addTaint(taint);
            throw var84B6D964FE82434F45EFD2853AD96CB7_1571018586;
        } //End block
    if(this.proxyChain == null)        
        {
            IllegalStateException var6381764CC756A597EE30F01CAC6781FB_785245682 = new IllegalStateException("No tunnel without proxy.");
            var6381764CC756A597EE30F01CAC6781FB_785245682.addTaint(taint);
            throw var6381764CC756A597EE30F01CAC6781FB_785245682;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.579 -0400", hash_original_method = "F92C099980BF3075944300484370C03E", hash_generated_method = "723E94D53A989F7F429F85AB180BFC54")
    public final void tunnelProxy(HttpHost proxy, boolean secure) {
        addTaint(proxy.getTaint());
    if(proxy == null)        
        {
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_1028892375 = new IllegalArgumentException("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_1028892375.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_1028892375;
        } //End block
    if(!this.connected)        
        {
            IllegalStateException var84B6D964FE82434F45EFD2853AD96CB7_136950897 = new IllegalStateException("No tunnel unless connected.");
            var84B6D964FE82434F45EFD2853AD96CB7_136950897.addTaint(taint);
            throw var84B6D964FE82434F45EFD2853AD96CB7_136950897;
        } //End block
    if(this.proxyChain == null)        
        {
            IllegalStateException var28AF9133120E1F47404F4E22D650F28A_1029733981 = new IllegalStateException("No proxy tunnel without proxy.");
            var28AF9133120E1F47404F4E22D650F28A_1029733981.addTaint(taint);
            throw var28AF9133120E1F47404F4E22D650F28A_1029733981;
        } //End block
        HttpHost[] proxies = new HttpHost[this.proxyChain.length+1];
        System.arraycopy(this.proxyChain, 0,
                         proxies, 0, this.proxyChain.length);
        proxies[proxies.length-1] = proxy;
        this.proxyChain = proxies;
        this.secure     = secure;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.579 -0400", hash_original_method = "54E7131A3C39BD59A18A0ED51B306BB3", hash_generated_method = "CDFFA99104170D9C636573048433C552")
    public final void layerProtocol(boolean secure) {
    if(!this.connected)        
        {
            IllegalStateException varDCA3356D51E641A02D8D439B2EC6C6CB_1590017451 = new IllegalStateException
                ("No layered protocol unless connected.");
            varDCA3356D51E641A02D8D439B2EC6C6CB_1590017451.addTaint(taint);
            throw varDCA3356D51E641A02D8D439B2EC6C6CB_1590017451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.580 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "32AAC17091D0A76B3FCD2626A4F7FCCA")
    public final HttpHost getTargetHost() {
HttpHost var67C71439C5981484698447EE93E1A003_1892475422 =         this.targetHost;
        var67C71439C5981484698447EE93E1A003_1892475422.addTaint(taint);
        return var67C71439C5981484698447EE93E1A003_1892475422;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.580 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "E49D89A79B95E9B00AA196D529832864")
    public final InetAddress getLocalAddress() {
InetAddress varD252CCE80C2F3B9DE81EE46EA65F5895_989702654 =         this.localAddress;
        varD252CCE80C2F3B9DE81EE46EA65F5895_989702654.addTaint(taint);
        return varD252CCE80C2F3B9DE81EE46EA65F5895_989702654;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.580 -0400", hash_original_method = "6ABB5CCC8F0E8E8F1BDF34E043639F85", hash_generated_method = "59A0C5A4AAA3FA2F618D14861FD41CE6")
    public final int getHopCount() {
        int hops = 0;
    if(this.connected)        
        {
    if(proxyChain == null)            
            hops = 1;
            else
            hops = proxyChain.length + 1;
        } //End block
        int varA6B9236BF6C7A3DFAFDBC0709208ACC0_1726658054 = (hops);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631988027 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631988027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.581 -0400", hash_original_method = "CFC4B3441FDC551CC1F391519968AE1F", hash_generated_method = "82062A7D11285986FD02C8DF5651ED81")
    public final HttpHost getHopTarget(int hop) {
        addTaint(hop);
    if(hop < 0)        
        {
        IllegalArgumentException var853EA8D3011B4A803E1D3E44BA5221BB_468751432 = new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        var853EA8D3011B4A803E1D3E44BA5221BB_468751432.addTaint(taint);
        throw var853EA8D3011B4A803E1D3E44BA5221BB_468751432;
        }
        final int hopcount = getHopCount();
    if(hop >= hopcount)        
        {
            IllegalArgumentException var1799D5024220AB2FFBB3F8AC12DD69BF_2107156259 = new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds tracked route length " + hopcount +".");
            var1799D5024220AB2FFBB3F8AC12DD69BF_2107156259.addTaint(taint);
            throw var1799D5024220AB2FFBB3F8AC12DD69BF_2107156259;
        } //End block
        HttpHost result = null;
    if(hop < hopcount-1)        
        result = this.proxyChain[hop];
        else
        result = this.targetHost;
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_1732886632 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1732886632.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1732886632;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.581 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "7908B9BD711102323835EE17EE8D40E4")
    public final HttpHost getProxyHost() {
HttpHost varF8CC471EE86A19D0A727D1FC9C328686_504364465 =         (this.proxyChain == null) ? null : this.proxyChain[0];
        varF8CC471EE86A19D0A727D1FC9C328686_504364465.addTaint(taint);
        return varF8CC471EE86A19D0A727D1FC9C328686_504364465;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.581 -0400", hash_original_method = "42622BE2571C040A9FEE72D0CCBA0217", hash_generated_method = "4177FF323CFF8735D60AB585152619C5")
    public final boolean isConnected() {
        boolean varB72E10DC8F160FCBA9062C311E010F86_2053265048 = (this.connected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277145142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_277145142;
        // ---------- Original Method ----------
        //return this.connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.582 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "CDD87C059AFEE3680B7F07EFDC5783D6")
    public final TunnelType getTunnelType() {
TunnelType var2217FBB31A61A2BC06264383F23E2C7F_563091468 =         this.tunnelled;
        var2217FBB31A61A2BC06264383F23E2C7F_563091468.addTaint(taint);
        return var2217FBB31A61A2BC06264383F23E2C7F_563091468;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.582 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "E330E366C510081188662826F1E6A006")
    public final boolean isTunnelled() {
        boolean var6E17A163EAADFAAEEF827D05D550510F_1716735193 = ((this.tunnelled == TunnelType.TUNNELLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143390867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143390867;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.597 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "ED23BAE6C04AEFCD31165EABE72F12F0")
    public final LayerType getLayerType() {
LayerType var0B365440B9E6602F90569354BDD2D5AF_1548395405 =         this.layered;
        var0B365440B9E6602F90569354BDD2D5AF_1548395405.addTaint(taint);
        return var0B365440B9E6602F90569354BDD2D5AF_1548395405;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.597 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "4078D0411EF4983F273643B377A317F5")
    public final boolean isLayered() {
        boolean var78483962D1129A47EBB9F287858CE500_1751980073 = ((this.layered == LayerType.LAYERED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046962431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046962431;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.598 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "F27578B4180E8C1CFC4D9C0B62A9814A")
    public final boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_1612716908 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970957806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970957806;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.598 -0400", hash_original_method = "F708D9F908B17C9085BF9A499A01375A", hash_generated_method = "C503CDD32C6A110671490FA480E78A17")
    public final HttpRoute toRoute() {
HttpRoute varE41698FEE7663C0A9148DADE09262853_727516693 =         !this.connected ?
            null : new HttpRoute(this.targetHost, this.localAddress,
                                 this.proxyChain, this.secure,
                                 this.tunnelled, this.layered);
        varE41698FEE7663C0A9148DADE09262853_727516693.addTaint(taint);
        return varE41698FEE7663C0A9148DADE09262853_727516693;
        // ---------- Original Method ----------
        //return !this.connected ?
            //null : new HttpRoute(this.targetHost, this.localAddress,
                                 //this.proxyChain, this.secure,
                                 //this.tunnelled, this.layered);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.599 -0400", hash_original_method = "63363EB4B4D28F766A23B83B48599393", hash_generated_method = "49C258BA752FAB814519B0EFDA956C05")
    @Override
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_486859085 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57879457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57879457;
        }
    if(!(o instanceof RouteTracker))        
        {
        boolean var68934A3E9455FA72420237EB05902327_340154220 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870472324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870472324;
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
    if(equal && (this.proxyChain != null))        
        {
for(int i=0;equal && (i<this.proxyChain.length);i++)
            equal = this.proxyChain[i].equals(that.proxyChain[i]);
        } //End block
        boolean var465289687A70DB7AA7217CC240C29F0F_660462396 = (equal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750270559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750270559;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.601 -0400", hash_original_method = "DF8EA32EAB4DFA40B45F048298D9408F", hash_generated_method = "F2D23E2D180F6E932499EA8DF71F3BE2")
    @Override
    public final int hashCode() {
        int hc = this.targetHost.hashCode();
    if(this.localAddress != null)        
        hc ^= localAddress.hashCode();
    if(this.proxyChain != null)        
        {
            hc ^= proxyChain.length;
for(int i=0;i<proxyChain.length;i++)
            hc ^= proxyChain[i].hashCode();
        } //End block
    if(this.connected)        
        hc ^= 0x11111111;
    if(this.secure)        
        hc ^= 0x22222222;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int var6320C1115D5BC2B6CA615B96BE050884_468296195 = (hc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061873899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061873899;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.601 -0400", hash_original_method = "B9AFE31805DA49D5CF66B21B19FA6A72", hash_generated_method = "FDC6D43116FA520A5B00349D66B2925A")
    @Override
    public final String toString() {
        StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("RouteTracker[");
    if(this.localAddress != null)        
        {
            cab.append(this.localAddress);
            cab.append("->");
        } //End block
        cab.append('{');
    if(this.connected)        
        cab.append('c');
    if(this.tunnelled == TunnelType.TUNNELLED)        
        cab.append('t');
    if(this.layered == LayerType.LAYERED)        
        cab.append('l');
    if(this.secure)        
        cab.append('s');
        cab.append("}->");
    if(this.proxyChain != null)        
        {
for(int i=0;i<this.proxyChain.length;i++)
            {
                cab.append(this.proxyChain[i]);
                cab.append("->");
            } //End block
        } //End block
        cab.append(this.targetHost);
        cab.append(']');
String var5D73975C9EFF81CD9FF6232386AC7C22_1955463785 =         cab.toString();
        var5D73975C9EFF81CD9FF6232386AC7C22_1955463785.addTaint(taint);
        return var5D73975C9EFF81CD9FF6232386AC7C22_1955463785;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.602 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "A6DED38A7D8351526391CEFD1C0C2C67")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1637249317 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1637249317.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1637249317;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

