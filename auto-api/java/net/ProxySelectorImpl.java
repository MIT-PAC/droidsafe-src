package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

final class ProxySelectorImpl extends ProxySelector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.070 -0400", hash_original_method = "F89A8EEF2F1DE063B17CD9397EAAC594", hash_generated_method = "F89A8EEF2F1DE063B17CD9397EAAC594")
        public ProxySelectorImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.071 -0400", hash_original_method = "01DD13242757A7D8F74EE28AFD708C0E", hash_generated_method = "C3A120823BB8730AA99223DA4A83A121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        dsTaint.addTaint(sa.dsTaint);
        dsTaint.addTaint(ioe.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (uri == null || sa == null || ioe == null) {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.072 -0400", hash_original_method = "28B2C18C3900BEE8EC547F5A9EDC2C1E", hash_generated_method = "75499541A66AA83D3A01F52D1F19D967")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<Proxy> select(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        List<Proxy> var061AD6C488E0FD26D1F2E6B800D617A5_1793955452 = (Collections.singletonList(selectOneProxy(uri)));
        return (List<Proxy>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.singletonList(selectOneProxy(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.073 -0400", hash_original_method = "77552E7F4A5B4D6DFBBFBB4C81DE3154", hash_generated_method = "92F9CAFACAF9D87E2699DC4B3347DC6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Proxy selectOneProxy(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri == null");
        } //End block
        String scheme;
        scheme = uri.getScheme();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scheme == null");
        } //End block
        int port;
        port = -1;
        Proxy proxy;
        proxy = null;
        String nonProxyHostsKey;
        nonProxyHostsKey = null;
        boolean httpProxyOkay;
        httpProxyOkay = true;
        {
            boolean var099C3DB490FA18F5B96DE8EDEA1D5BD1_1662056876 = ("http".equalsIgnoreCase(scheme));
            {
                port = 80;
                nonProxyHostsKey = "http.nonProxyHosts";
                proxy = lookupProxy("http.proxyHost", "http.proxyPort", Proxy.Type.HTTP, port);
            } //End block
            {
                boolean varBE5CD356012198A0BB12BE01A0345AF9_1678050358 = ("https".equalsIgnoreCase(scheme));
                {
                    port = 443;
                    nonProxyHostsKey = "https.nonProxyHosts";
                    proxy = lookupProxy("https.proxyHost", "https.proxyPort", Proxy.Type.HTTP, port);
                } //End block
                {
                    boolean var2128F31844E17B47A150E79CC0F2EB02_1476059942 = ("ftp".equalsIgnoreCase(scheme));
                    {
                        port = 80;
                        nonProxyHostsKey = "ftp.nonProxyHosts";
                        proxy = lookupProxy("ftp.proxyHost", "ftp.proxyPort", Proxy.Type.HTTP, port);
                    } //End block
                    {
                        boolean varAEA5A4A3FC367439E50E9738D52FA87C_1611036092 = ("socket".equalsIgnoreCase(scheme));
                        {
                            httpProxyOkay = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var90DD54E078CD81F4F882B77E685DB85A_239408258 = (nonProxyHostsKey != null
                && isNonProxyHost(uri.getHost(), System.getProperty(nonProxyHostsKey)));
        } //End collapsed parenthetic
        {
            proxy = lookupProxy("proxyHost", "proxyPort", Proxy.Type.HTTP, port);
        } //End block
        proxy = lookupProxy("socksProxyHost", "socksProxyPort", Proxy.Type.SOCKS, 1080);
        return (Proxy)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.073 -0400", hash_original_method = "8F772B362E14FE9459180F7871735648", hash_generated_method = "750B1C20C8E4F10D7C594282412EFFF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Proxy lookupProxy(String hostKey, String portKey, Proxy.Type type, int defaultPort) {
        dsTaint.addTaint(portKey);
        dsTaint.addTaint(defaultPort);
        dsTaint.addTaint(hostKey);
        dsTaint.addTaint(type.dsTaint);
        String host;
        host = System.getProperty(hostKey);
        {
            boolean var72B3AAE23DD516E6BEEC93DCD65ADD44_2002461503 = (host == null || host.isEmpty());
        } //End collapsed parenthetic
        int port;
        port = getSystemPropertyInt(portKey, defaultPort);
        Proxy var93E5AD263C05E4FBFDFE33C0821A2E7C_1072842327 = (new Proxy(type, InetSocketAddress.createUnresolved(host, port)));
        return (Proxy)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String host = System.getProperty(hostKey);
        //if (host == null || host.isEmpty()) {
            //return null;
        //}
        //int port = getSystemPropertyInt(portKey, defaultPort);
        //return new Proxy(type, InetSocketAddress.createUnresolved(host, port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.074 -0400", hash_original_method = "36E6CCC8C23DA7DA61B6599903A6840E", hash_generated_method = "846E59710B3DA4675AAA20EE49921BBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getSystemPropertyInt(String key, int defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        String string;
        string = System.getProperty(key);
        {
            try 
            {
                int var3715EC1DDE30CC1B193F456CA99A0396_374841300 = (Integer.parseInt(string));
            } //End block
            catch (NumberFormatException ignored)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.074 -0400", hash_original_method = "960A16929DB84D35FDCE84F421A041D1", hash_generated_method = "5D7BA0A2CF06BC69F11E81B3789F9985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isNonProxyHost(String host, String nonProxyHosts) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(nonProxyHosts);
        StringBuilder patternBuilder;
        patternBuilder = new StringBuilder();
        {
            int i;
            i = 0;
            boolean var34D84132F51D26BE58DFA3C8D2058636_1444453318 = (i < nonProxyHosts.length());
            {
                char c;
                c = nonProxyHosts.charAt(i);
                //Begin case '.' 
                patternBuilder.append("\\.");
                //End case '.' 
                //Begin case '*' 
                patternBuilder.append(".*");
                //End case '*' 
                //Begin case default 
                patternBuilder.append(c);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        String pattern;
        pattern = patternBuilder.toString();
        boolean var9EF2FD8C4CC99942090209B67BA77704_1461538336 = (host.matches(pattern));
        return dsTaint.getTaintBoolean();
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

