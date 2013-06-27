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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.777 -0400", hash_original_method = "132D2379FE75BA7CC4F9F650D388CD2E", hash_generated_method = "132D2379FE75BA7CC4F9F650D388CD2E")
    public ProxySelectorImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.787 -0400", hash_original_method = "01DD13242757A7D8F74EE28AFD708C0E", hash_generated_method = "04D2B6793EC0816A04A159E59567AEEC")
    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        addTaint(uri.getTaint());
        addTaint(sa.getTaint());
        addTaint(ioe.getTaint());
        // ---------- Original Method ----------
        //if (uri == null || sa == null || ioe == null) {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.788 -0400", hash_original_method = "28B2C18C3900BEE8EC547F5A9EDC2C1E", hash_generated_method = "2EE04AFC80006BE14EDD2535DAAA7182")
    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> varB4EAC82CA7396A68D541C85D26508E83_1813212302 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1813212302 = Collections.singletonList(selectOneProxy(uri));
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1813212302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1813212302;
        // ---------- Original Method ----------
        //return Collections.singletonList(selectOneProxy(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.870 -0400", hash_original_method = "77552E7F4A5B4D6DFBBFBB4C81DE3154", hash_generated_method = "416DBBFE4F69B0C3D50A39F3122B8F55")
    private Proxy selectOneProxy(URI uri) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_963035833 = null; //Variable for return #1
        Proxy varB4EAC82CA7396A68D541C85D26508E83_2067346670 = null; //Variable for return #2
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1034638535 = null; //Variable for return #3
        Proxy varB4EAC82CA7396A68D541C85D26508E83_49601827 = null; //Variable for return #4
        Proxy varB4EAC82CA7396A68D541C85D26508E83_505275623 = null; //Variable for return #5
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1559434897 = null; //Variable for return #6
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
            boolean var099C3DB490FA18F5B96DE8EDEA1D5BD1_494355162 = ("http".equalsIgnoreCase(scheme));
            {
                port = 80;
                nonProxyHostsKey = "http.nonProxyHosts";
                proxy = lookupProxy("http.proxyHost", "http.proxyPort", Proxy.Type.HTTP, port);
            } //End block
            {
                boolean varBE5CD356012198A0BB12BE01A0345AF9_1768689134 = ("https".equalsIgnoreCase(scheme));
                {
                    port = 443;
                    nonProxyHostsKey = "https.nonProxyHosts";
                    proxy = lookupProxy("https.proxyHost", "https.proxyPort", Proxy.Type.HTTP, port);
                } //End block
                {
                    boolean var2128F31844E17B47A150E79CC0F2EB02_961033352 = ("ftp".equalsIgnoreCase(scheme));
                    {
                        port = 80;
                        nonProxyHostsKey = "ftp.nonProxyHosts";
                        proxy = lookupProxy("ftp.proxyHost", "ftp.proxyPort", Proxy.Type.HTTP, port);
                    } //End block
                    {
                        boolean varAEA5A4A3FC367439E50E9738D52FA87C_1239006602 = ("socket".equalsIgnoreCase(scheme));
                        {
                            httpProxyOkay = false;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_963035833 = Proxy.NO_PROXY;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var90DD54E078CD81F4F882B77E685DB85A_599590159 = (nonProxyHostsKey != null
                && isNonProxyHost(uri.getHost(), System.getProperty(nonProxyHostsKey)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2067346670 = Proxy.NO_PROXY;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1034638535 = proxy;
        } //End block
        {
            proxy = lookupProxy("proxyHost", "proxyPort", Proxy.Type.HTTP, port);
            {
                varB4EAC82CA7396A68D541C85D26508E83_49601827 = proxy;
            } //End block
        } //End block
        proxy = lookupProxy("socksProxyHost", "socksProxyPort", Proxy.Type.SOCKS, 1080);
        {
            varB4EAC82CA7396A68D541C85D26508E83_505275623 = proxy;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1559434897 = Proxy.NO_PROXY;
        addTaint(uri.getTaint());
        Proxy varA7E53CE21691AB073D9660D615818899_1105141945; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_963035833;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_2067346670;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_1034638535;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_49601827;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_505275623;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1105141945 = varB4EAC82CA7396A68D541C85D26508E83_1559434897;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1105141945.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1105141945;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.872 -0400", hash_original_method = "8F772B362E14FE9459180F7871735648", hash_generated_method = "97B122E688738DE21B98EE24737C6BE8")
    private Proxy lookupProxy(String hostKey, String portKey, Proxy.Type type, int defaultPort) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1389478992 = null; //Variable for return #1
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1362727518 = null; //Variable for return #2
        String host;
        host = System.getProperty(hostKey);
        {
            boolean var72B3AAE23DD516E6BEEC93DCD65ADD44_1243579346 = (host == null || host.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1389478992 = null;
            } //End block
        } //End collapsed parenthetic
        int port;
        port = getSystemPropertyInt(portKey, defaultPort);
        varB4EAC82CA7396A68D541C85D26508E83_1362727518 = new Proxy(type, InetSocketAddress.createUnresolved(host, port));
        addTaint(hostKey.getTaint());
        addTaint(portKey.getTaint());
        addTaint(type.getTaint());
        addTaint(defaultPort);
        Proxy varA7E53CE21691AB073D9660D615818899_927056071; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_927056071 = varB4EAC82CA7396A68D541C85D26508E83_1389478992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_927056071 = varB4EAC82CA7396A68D541C85D26508E83_1362727518;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_927056071.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_927056071;
        // ---------- Original Method ----------
        //String host = System.getProperty(hostKey);
        //if (host == null || host.isEmpty()) {
            //return null;
        //}
        //int port = getSystemPropertyInt(portKey, defaultPort);
        //return new Proxy(type, InetSocketAddress.createUnresolved(host, port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.872 -0400", hash_original_method = "36E6CCC8C23DA7DA61B6599903A6840E", hash_generated_method = "A3EB1C47A1B2542220C7B26DEC9ED3E0")
    private int getSystemPropertyInt(String key, int defaultValue) {
        String string;
        string = System.getProperty(key);
        {
            try 
            {
                int var3715EC1DDE30CC1B193F456CA99A0396_172709713 = (Integer.parseInt(string));
            } //End block
            catch (NumberFormatException ignored)
            { }
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681822232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681822232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.876 -0400", hash_original_method = "960A16929DB84D35FDCE84F421A041D1", hash_generated_method = "2D78D073B479F68CF538EC71AFC05217")
    private boolean isNonProxyHost(String host, String nonProxyHosts) {
        StringBuilder patternBuilder;
        patternBuilder = new StringBuilder();
        {
            int i;
            i = 0;
            boolean var34D84132F51D26BE58DFA3C8D2058636_1232724971 = (i < nonProxyHosts.length());
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
        boolean var9EF2FD8C4CC99942090209B67BA77704_911504152 = (host.matches(pattern));
        addTaint(host.getTaint());
        addTaint(nonProxyHosts.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182193934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182193934;
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

