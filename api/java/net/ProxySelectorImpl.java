package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

final class ProxySelectorImpl extends ProxySelector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.152 -0400", hash_original_method = "132D2379FE75BA7CC4F9F650D388CD2E", hash_generated_method = "132D2379FE75BA7CC4F9F650D388CD2E")
    public ProxySelectorImpl ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.152 -0400", hash_original_method = "01DD13242757A7D8F74EE28AFD708C0E", hash_generated_method = "AE7C8864ED0A3D6886FD4C3A982C0A27")
    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        addTaint(ioe.getTaint());
        addTaint(sa.getTaint());
        addTaint(uri.getTaint());
    if(uri == null || sa == null || ioe == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_955903002 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_955903002.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_955903002;
        } //End block
        // ---------- Original Method ----------
        //if (uri == null || sa == null || ioe == null) {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.153 -0400", hash_original_method = "28B2C18C3900BEE8EC547F5A9EDC2C1E", hash_generated_method = "F95427750421E081138515DA25A1C37D")
    @Override
    public List<Proxy> select(URI uri) {
        addTaint(uri.getTaint());
List<Proxy> var5E22424134D08E91E6B049D6790CF264_517089611 =         Collections.singletonList(selectOneProxy(uri));
        var5E22424134D08E91E6B049D6790CF264_517089611.addTaint(taint);
        return var5E22424134D08E91E6B049D6790CF264_517089611;
        // ---------- Original Method ----------
        //return Collections.singletonList(selectOneProxy(uri));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.155 -0400", hash_original_method = "77552E7F4A5B4D6DFBBFBB4C81DE3154", hash_generated_method = "25C489AE9D0222042A99B5F7E79B1CD3")
    private Proxy selectOneProxy(URI uri) {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            IllegalArgumentException var6F752B00E4842526D87F465C0AC0B9FC_595255751 = new IllegalArgumentException("uri == null");
            var6F752B00E4842526D87F465C0AC0B9FC_595255751.addTaint(taint);
            throw var6F752B00E4842526D87F465C0AC0B9FC_595255751;
        } //End block
        String scheme = uri.getScheme();
    if(scheme == null)        
        {
            IllegalArgumentException var8772D8B259AAE191BDD4823603742C40_631488128 = new IllegalArgumentException("scheme == null");
            var8772D8B259AAE191BDD4823603742C40_631488128.addTaint(taint);
            throw var8772D8B259AAE191BDD4823603742C40_631488128;
        } //End block
        int port = -1;
        Proxy proxy = null;
        String nonProxyHostsKey = null;
        boolean httpProxyOkay = true;
    if("http".equalsIgnoreCase(scheme))        
        {
            port = 80;
            nonProxyHostsKey = "http.nonProxyHosts";
            proxy = lookupProxy("http.proxyHost", "http.proxyPort", Proxy.Type.HTTP, port);
        } //End block
        else
    if("https".equalsIgnoreCase(scheme))        
        {
            port = 443;
            nonProxyHostsKey = "https.nonProxyHosts";
            proxy = lookupProxy("https.proxyHost", "https.proxyPort", Proxy.Type.HTTP, port);
        } //End block
        else
    if("ftp".equalsIgnoreCase(scheme))        
        {
            port = 80;
            nonProxyHostsKey = "ftp.nonProxyHosts";
            proxy = lookupProxy("ftp.proxyHost", "ftp.proxyPort", Proxy.Type.HTTP, port);
        } //End block
        else
    if("socket".equalsIgnoreCase(scheme))        
        {
            httpProxyOkay = false;
        } //End block
        else
        {
Proxy var7D4E701A1F0837EF6523426E9F4A0688_1931689592 =             Proxy.NO_PROXY;
            var7D4E701A1F0837EF6523426E9F4A0688_1931689592.addTaint(taint);
            return var7D4E701A1F0837EF6523426E9F4A0688_1931689592;
        } //End block
    if(nonProxyHostsKey != null
                && isNonProxyHost(uri.getHost(), System.getProperty(nonProxyHostsKey)))        
        {
Proxy var7D4E701A1F0837EF6523426E9F4A0688_1629492699 =             Proxy.NO_PROXY;
            var7D4E701A1F0837EF6523426E9F4A0688_1629492699.addTaint(taint);
            return var7D4E701A1F0837EF6523426E9F4A0688_1629492699;
        } //End block
    if(proxy != null)        
        {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_1131186883 =             proxy;
            var60FC9F22F7E863EBFD33B2ADB8462743_1131186883.addTaint(taint);
            return var60FC9F22F7E863EBFD33B2ADB8462743_1131186883;
        } //End block
    if(httpProxyOkay)        
        {
            proxy = lookupProxy("proxyHost", "proxyPort", Proxy.Type.HTTP, port);
    if(proxy != null)            
            {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_548020030 =                 proxy;
                var60FC9F22F7E863EBFD33B2ADB8462743_548020030.addTaint(taint);
                return var60FC9F22F7E863EBFD33B2ADB8462743_548020030;
            } //End block
        } //End block
        proxy = lookupProxy("socksProxyHost", "socksProxyPort", Proxy.Type.SOCKS, 1080);
    if(proxy != null)        
        {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_502973181 =             proxy;
            var60FC9F22F7E863EBFD33B2ADB8462743_502973181.addTaint(taint);
            return var60FC9F22F7E863EBFD33B2ADB8462743_502973181;
        } //End block
Proxy var7D4E701A1F0837EF6523426E9F4A0688_1642456583 =         Proxy.NO_PROXY;
        var7D4E701A1F0837EF6523426E9F4A0688_1642456583.addTaint(taint);
        return var7D4E701A1F0837EF6523426E9F4A0688_1642456583;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.156 -0400", hash_original_method = "8F772B362E14FE9459180F7871735648", hash_generated_method = "7BE3FFE59C244B1B3306C1F7A6F2EBDD")
    private Proxy lookupProxy(String hostKey, String portKey, Proxy.Type type, int defaultPort) {
        addTaint(defaultPort);
        addTaint(type.getTaint());
        addTaint(portKey.getTaint());
        addTaint(hostKey.getTaint());
        String host = System.getProperty(hostKey);
    if(host == null || host.isEmpty())        
        {
Proxy var540C13E9E156B687226421B24F2DF178_644943858 =             null;
            var540C13E9E156B687226421B24F2DF178_644943858.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_644943858;
        } //End block
        int port = getSystemPropertyInt(portKey, defaultPort);
Proxy var02AD375D853B0C8A83897EB8FF814B7F_1979763549 =         new Proxy(type, InetSocketAddress.createUnresolved(host, port));
        var02AD375D853B0C8A83897EB8FF814B7F_1979763549.addTaint(taint);
        return var02AD375D853B0C8A83897EB8FF814B7F_1979763549;
        // ---------- Original Method ----------
        //String host = System.getProperty(hostKey);
        //if (host == null || host.isEmpty()) {
            //return null;
        //}
        //int port = getSystemPropertyInt(portKey, defaultPort);
        //return new Proxy(type, InetSocketAddress.createUnresolved(host, port));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.157 -0400", hash_original_method = "36E6CCC8C23DA7DA61B6599903A6840E", hash_generated_method = "F810DFEAE9EDD825AB90C73820BDF8B2")
    private int getSystemPropertyInt(String key, int defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        String string = System.getProperty(key);
    if(string != null)        
        {
            try 
            {
                int var09C6840C55522B1AEA3556FFCCEE65DD_1390976308 = (Integer.parseInt(string));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345944710 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345944710;
            } //End block
            catch (NumberFormatException ignored)
            {
            } //End block
        } //End block
        int var16830A58E1E33A4163524366BA7B701B_1911647672 = (defaultValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902918472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902918472;
        // ---------- Original Method ----------
        //String string = System.getProperty(key);
        //if (string != null) {
            //try {
                //return Integer.parseInt(string);
            //} catch (NumberFormatException ignored) {
            //}
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.158 -0400", hash_original_method = "960A16929DB84D35FDCE84F421A041D1", hash_generated_method = "641256B156A05513B6B71AD1C48895D9")
    private boolean isNonProxyHost(String host, String nonProxyHosts) {
        addTaint(nonProxyHosts.getTaint());
        addTaint(host.getTaint());
    if(host == null || nonProxyHosts == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_958096473 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540318173 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540318173;
        } //End block
        StringBuilder patternBuilder = new StringBuilder();
for(int i = 0;i < nonProxyHosts.length();i++)
        {
            char c = nonProxyHosts.charAt(i);
switch(c){
            case '.':
            patternBuilder.append("\\.");
            break;
            case '*':
            patternBuilder.append(".*");
            break;
            default:
            patternBuilder.append(c);
}
        } //End block
        String pattern = patternBuilder.toString();
        boolean var2AA61A13658CDB61803223DA53B63C84_94803325 = (host.matches(pattern));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221541244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221541244;
        // ---------- Original Method ----------
        //if (host == null || nonProxyHosts == null) {
            //return false;
        //}
        //StringBuilder patternBuilder = new StringBuilder();
        //for (int i = 0; i < nonProxyHosts.length(); i++) {
            //char c = nonProxyHosts.charAt(i);
            //switch (c) {
            //case '.':
                //patternBuilder.append("\\.");
                //break;
            //case '*':
                //patternBuilder.append(".*");
                //break;
            //default:
                //patternBuilder.append(c);
            //}
        //}
        //String pattern = patternBuilder.toString();
        //return host.matches(pattern);
    }

    
}

