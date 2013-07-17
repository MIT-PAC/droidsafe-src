package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class RouteTracker implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.914 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.914 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.914 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "C918229792F6B488CD7E2D698EFF8324")

    private boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.914 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.915 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.915 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.915 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.916 -0400", hash_original_method = "225F1E2FD25662F69AE6A7484F5A3DE6", hash_generated_method = "E9D21B01112E8BD7B2331CD92A121978")
    public  RouteTracker(HttpHost target, InetAddress local) {
        if(target == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_647035969 = new IllegalArgumentException("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_647035969.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_647035969;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.916 -0400", hash_original_method = "9F2302B948E2DACBF43BEB44AB6E1806", hash_generated_method = "1431D61C28009DA2526CE6306C32B6F9")
    public  RouteTracker(HttpRoute route) {
        this(route.getTargetHost(), route.getLocalAddress());
        addTaint(route.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.917 -0400", hash_original_method = "BF1F9DC8D5382B51655F853917583FAE", hash_generated_method = "E3876B31315E201209DE930C9A7AF9B7")
    public final void connectTarget(boolean secure) {
        if(this.connected)        
        {
            IllegalStateException var0CA65896F322A09D3E6BD61A388FA8B5_1621264654 = new IllegalStateException("Already connected.");
            var0CA65896F322A09D3E6BD61A388FA8B5_1621264654.addTaint(taint);
            throw var0CA65896F322A09D3E6BD61A388FA8B5_1621264654;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.918 -0400", hash_original_method = "3003DC7DA59FD970800BABF8F86CE4CE", hash_generated_method = "BA7CC4B8DAFFCBF4D391FEAB7D84D0DB")
    public final void connectProxy(HttpHost proxy, boolean secure) {
        addTaint(proxy.getTaint());
        if(proxy == null)        
        {
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_1058755973 = new IllegalArgumentException("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_1058755973.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_1058755973;
        } //End block
        if(this.connected)        
        {
            IllegalStateException var0CA65896F322A09D3E6BD61A388FA8B5_1386922557 = new IllegalStateException("Already connected.");
            var0CA65896F322A09D3E6BD61A388FA8B5_1386922557.addTaint(taint);
            throw var0CA65896F322A09D3E6BD61A388FA8B5_1386922557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.919 -0400", hash_original_method = "E27069CB33BE85EAA2A2A23BD0F575F7", hash_generated_method = "8F44723C2C33C36D3EBA623984B7CE59")
    public final void tunnelTarget(boolean secure) {
        if(!this.connected)        
        {
            IllegalStateException var84B6D964FE82434F45EFD2853AD96CB7_468815544 = new IllegalStateException("No tunnel unless connected.");
            var84B6D964FE82434F45EFD2853AD96CB7_468815544.addTaint(taint);
            throw var84B6D964FE82434F45EFD2853AD96CB7_468815544;
        } //End block
        if(this.proxyChain == null)        
        {
            IllegalStateException var6381764CC756A597EE30F01CAC6781FB_718101639 = new IllegalStateException("No tunnel without proxy.");
            var6381764CC756A597EE30F01CAC6781FB_718101639.addTaint(taint);
            throw var6381764CC756A597EE30F01CAC6781FB_718101639;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.921 -0400", hash_original_method = "F92C099980BF3075944300484370C03E", hash_generated_method = "1CB086EE439B6BF9752AC7267F8E0EF5")
    public final void tunnelProxy(HttpHost proxy, boolean secure) {
        addTaint(proxy.getTaint());
        if(proxy == null)        
        {
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_1737822856 = new IllegalArgumentException("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_1737822856.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_1737822856;
        } //End block
        if(!this.connected)        
        {
            IllegalStateException var84B6D964FE82434F45EFD2853AD96CB7_1938012772 = new IllegalStateException("No tunnel unless connected.");
            var84B6D964FE82434F45EFD2853AD96CB7_1938012772.addTaint(taint);
            throw var84B6D964FE82434F45EFD2853AD96CB7_1938012772;
        } //End block
        if(this.proxyChain == null)        
        {
            IllegalStateException var28AF9133120E1F47404F4E22D650F28A_1762161042 = new IllegalStateException("No proxy tunnel without proxy.");
            var28AF9133120E1F47404F4E22D650F28A_1762161042.addTaint(taint);
            throw var28AF9133120E1F47404F4E22D650F28A_1762161042;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.922 -0400", hash_original_method = "54E7131A3C39BD59A18A0ED51B306BB3", hash_generated_method = "E52496B5E844C902EC2CF66533D477E5")
    public final void layerProtocol(boolean secure) {
        if(!this.connected)        
        {
            IllegalStateException varDCA3356D51E641A02D8D439B2EC6C6CB_318156112 = new IllegalStateException
                ("No layered protocol unless connected.");
            varDCA3356D51E641A02D8D439B2EC6C6CB_318156112.addTaint(taint);
            throw varDCA3356D51E641A02D8D439B2EC6C6CB_318156112;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.923 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "0F0F03282FFC8CA149488AFFD043D67F")
    public final HttpHost getTargetHost() {
HttpHost var67C71439C5981484698447EE93E1A003_1453220130 =         this.targetHost;
        var67C71439C5981484698447EE93E1A003_1453220130.addTaint(taint);
        return var67C71439C5981484698447EE93E1A003_1453220130;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.923 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "19C77BD7AD1FFE103445A5EEC97590A3")
    public final InetAddress getLocalAddress() {
InetAddress varD252CCE80C2F3B9DE81EE46EA65F5895_1545736463 =         this.localAddress;
        varD252CCE80C2F3B9DE81EE46EA65F5895_1545736463.addTaint(taint);
        return varD252CCE80C2F3B9DE81EE46EA65F5895_1545736463;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.924 -0400", hash_original_method = "6ABB5CCC8F0E8E8F1BDF34E043639F85", hash_generated_method = "37046C7962046851E42482A02303EF3D")
    public final int getHopCount() {
        int hops = 0;
        if(this.connected)        
        {
            if(proxyChain == null)            
            hops = 1;
            else
            hops = proxyChain.length + 1;
        } //End block
        int varA6B9236BF6C7A3DFAFDBC0709208ACC0_955162906 = (hops);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322950879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322950879;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.925 -0400", hash_original_method = "CFC4B3441FDC551CC1F391519968AE1F", hash_generated_method = "FC86257485D333EB890386DD7A00422D")
    public final HttpHost getHopTarget(int hop) {
        addTaint(hop);
        if(hop < 0)        
        {
        IllegalArgumentException var853EA8D3011B4A803E1D3E44BA5221BB_479576065 = new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        var853EA8D3011B4A803E1D3E44BA5221BB_479576065.addTaint(taint);
        throw var853EA8D3011B4A803E1D3E44BA5221BB_479576065;
        }
        final int hopcount = getHopCount();
        if(hop >= hopcount)        
        {
            IllegalArgumentException var1799D5024220AB2FFBB3F8AC12DD69BF_625045221 = new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds tracked route length " + hopcount +".");
            var1799D5024220AB2FFBB3F8AC12DD69BF_625045221.addTaint(taint);
            throw var1799D5024220AB2FFBB3F8AC12DD69BF_625045221;
        } //End block
        HttpHost result = null;
        if(hop < hopcount-1)        
        result = this.proxyChain[hop];
        else
        result = this.targetHost;
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_1962763159 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1962763159.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1962763159;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.926 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "131E32B6482E8A8099DB4F436EFA627A")
    public final HttpHost getProxyHost() {
HttpHost varF8CC471EE86A19D0A727D1FC9C328686_1175552183 =         (this.proxyChain == null) ? null : this.proxyChain[0];
        varF8CC471EE86A19D0A727D1FC9C328686_1175552183.addTaint(taint);
        return varF8CC471EE86A19D0A727D1FC9C328686_1175552183;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.926 -0400", hash_original_method = "42622BE2571C040A9FEE72D0CCBA0217", hash_generated_method = "DDFCD61D25B7227CA28F9CBA0205460E")
    public final boolean isConnected() {
        boolean varB72E10DC8F160FCBA9062C311E010F86_21075167 = (this.connected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158086446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158086446;
        // ---------- Original Method ----------
        //return this.connected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.927 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "95072EE34F32CE78BDDFBE90A83D948C")
    public final TunnelType getTunnelType() {
TunnelType var2217FBB31A61A2BC06264383F23E2C7F_1821141208 =         this.tunnelled;
        var2217FBB31A61A2BC06264383F23E2C7F_1821141208.addTaint(taint);
        return var2217FBB31A61A2BC06264383F23E2C7F_1821141208;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.927 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "2F104F6CE2D765EB0BA46AB08DD32E9D")
    public final boolean isTunnelled() {
        boolean var6E17A163EAADFAAEEF827D05D550510F_1045013786 = ((this.tunnelled == TunnelType.TUNNELLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507089070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507089070;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.928 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "90742058E4A9C386D9AD83ACC8D42269")
    public final LayerType getLayerType() {
LayerType var0B365440B9E6602F90569354BDD2D5AF_1530682020 =         this.layered;
        var0B365440B9E6602F90569354BDD2D5AF_1530682020.addTaint(taint);
        return var0B365440B9E6602F90569354BDD2D5AF_1530682020;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.928 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "7AD1D6EFDBDAD044ECFE1F4376592287")
    public final boolean isLayered() {
        boolean var78483962D1129A47EBB9F287858CE500_1311015258 = ((this.layered == LayerType.LAYERED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074014324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074014324;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.929 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "462157B6EA50BFE1AD9207DADBCF6FAE")
    public final boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_2124339138 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742454923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742454923;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.929 -0400", hash_original_method = "F708D9F908B17C9085BF9A499A01375A", hash_generated_method = "0D404DF0E7CE9CAD5B229EBD14E6B988")
    public final HttpRoute toRoute() {
HttpRoute varE41698FEE7663C0A9148DADE09262853_705790838 =         !this.connected ?
            null : new HttpRoute(this.targetHost, this.localAddress,
                                 this.proxyChain, this.secure,
                                 this.tunnelled, this.layered);
        varE41698FEE7663C0A9148DADE09262853_705790838.addTaint(taint);
        return varE41698FEE7663C0A9148DADE09262853_705790838;
        // ---------- Original Method ----------
        //return !this.connected ?
            //null : new HttpRoute(this.targetHost, this.localAddress,
                                 //this.proxyChain, this.secure,
                                 //this.tunnelled, this.layered);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.930 -0400", hash_original_method = "63363EB4B4D28F766A23B83B48599393", hash_generated_method = "FB2FD647993FAE33C0B3D6BE68E28E20")
    @Override
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2082058926 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089681078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089681078;
        }
        if(!(o instanceof RouteTracker))        
        {
        boolean var68934A3E9455FA72420237EB05902327_637467488 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675176706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_675176706;
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
        boolean var465289687A70DB7AA7217CC240C29F0F_1091984567 = (equal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715571284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715571284;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.931 -0400", hash_original_method = "DF8EA32EAB4DFA40B45F048298D9408F", hash_generated_method = "3148F00990B841041F1DF4131E7FBD88")
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
        int var6320C1115D5BC2B6CA615B96BE050884_1129117210 = (hc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115619777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115619777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.932 -0400", hash_original_method = "B9AFE31805DA49D5CF66B21B19FA6A72", hash_generated_method = "EEB4524CC6602E0C43EC8653194030E8")
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
String var5D73975C9EFF81CD9FF6232386AC7C22_1799321174 =         cab.toString();
        var5D73975C9EFF81CD9FF6232386AC7C22_1799321174.addTaint(taint);
        return var5D73975C9EFF81CD9FF6232386AC7C22_1799321174;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.933 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "6F713336D1194406AAFA4730CB9B86B4")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_958811096 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_958811096.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_958811096;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

