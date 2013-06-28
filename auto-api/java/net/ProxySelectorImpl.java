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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.685 -0400", hash_original_method = "132D2379FE75BA7CC4F9F650D388CD2E", hash_generated_method = "132D2379FE75BA7CC4F9F650D388CD2E")
    public ProxySelectorImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.685 -0400", hash_original_method = "01DD13242757A7D8F74EE28AFD708C0E", hash_generated_method = "04D2B6793EC0816A04A159E59567AEEC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.686 -0400", hash_original_method = "28B2C18C3900BEE8EC547F5A9EDC2C1E", hash_generated_method = "C3BA748E2312C3ED5573997B5FE1C6E7")
    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> varB4EAC82CA7396A68D541C85D26508E83_1903790320 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1903790320 = Collections.singletonList(selectOneProxy(uri));
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1903790320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903790320;
        // ---------- Original Method ----------
        //return Collections.singletonList(selectOneProxy(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.688 -0400", hash_original_method = "77552E7F4A5B4D6DFBBFBB4C81DE3154", hash_generated_method = "D3E1CC634BD95AF7C729979044925D49")
    private Proxy selectOneProxy(URI uri) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1289707322 = null; //Variable for return #1
        Proxy varB4EAC82CA7396A68D541C85D26508E83_464397138 = null; //Variable for return #2
        Proxy varB4EAC82CA7396A68D541C85D26508E83_564077783 = null; //Variable for return #3
        Proxy varB4EAC82CA7396A68D541C85D26508E83_807123089 = null; //Variable for return #4
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1791821708 = null; //Variable for return #5
        Proxy varB4EAC82CA7396A68D541C85D26508E83_1929918835 = null; //Variable for return #6
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri == null");
        } //End block
        String scheme = uri.getScheme();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scheme == null");
        } //End block
        int port = -1;
        Proxy proxy = null;
        String nonProxyHostsKey = null;
        boolean httpProxyOkay = true;
        {
            boolean var099C3DB490FA18F5B96DE8EDEA1D5BD1_525923463 = ("http".equalsIgnoreCase(scheme));
            {
                port = 80;
                nonProxyHostsKey = "http.nonProxyHosts";
                proxy = lookupProxy("http.proxyHost", "http.proxyPort", Proxy.Type.HTTP, port);
            } //End block
            {
                boolean varBE5CD356012198A0BB12BE01A0345AF9_1844523520 = ("https".equalsIgnoreCase(scheme));
                {
                    port = 443;
                    nonProxyHostsKey = "https.nonProxyHosts";
                    proxy = lookupProxy("https.proxyHost", "https.proxyPort", Proxy.Type.HTTP, port);
                } //End block
                {
                    boolean var2128F31844E17B47A150E79CC0F2EB02_2034255247 = ("ftp".equalsIgnoreCase(scheme));
                    {
                        port = 80;
                        nonProxyHostsKey = "ftp.nonProxyHosts";
                        proxy = lookupProxy("ftp.proxyHost", "ftp.proxyPort", Proxy.Type.HTTP, port);
                    } //End block
                    {
                        boolean varAEA5A4A3FC367439E50E9738D52FA87C_1262501897 = ("socket".equalsIgnoreCase(scheme));
                        {
                            httpProxyOkay = false;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1289707322 = Proxy.NO_PROXY;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var90DD54E078CD81F4F882B77E685DB85A_15886978 = (nonProxyHostsKey != null
                && isNonProxyHost(uri.getHost(), System.getProperty(nonProxyHostsKey)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_464397138 = Proxy.NO_PROXY;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_564077783 = proxy;
        } //End block
        {
            proxy = lookupProxy("proxyHost", "proxyPort", Proxy.Type.HTTP, port);
            {
                varB4EAC82CA7396A68D541C85D26508E83_807123089 = proxy;
            } //End block
        } //End block
        proxy = lookupProxy("socksProxyHost", "socksProxyPort", Proxy.Type.SOCKS, 1080);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1791821708 = proxy;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1929918835 = Proxy.NO_PROXY;
        addTaint(uri.getTaint());
        Proxy varA7E53CE21691AB073D9660D615818899_787511029; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_1289707322;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_464397138;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_564077783;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_807123089;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_1791821708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_787511029 = varB4EAC82CA7396A68D541C85D26508E83_1929918835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_787511029.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_787511029;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.689 -0400", hash_original_method = "8F772B362E14FE9459180F7871735648", hash_generated_method = "956A2F466661231E1F063156F20BC717")
    private Proxy lookupProxy(String hostKey, String portKey, Proxy.Type type, int defaultPort) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_621053912 = null; //Variable for return #1
        Proxy varB4EAC82CA7396A68D541C85D26508E83_2141385975 = null; //Variable for return #2
        String host = System.getProperty(hostKey);
        {
            boolean var72B3AAE23DD516E6BEEC93DCD65ADD44_532259951 = (host == null || host.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_621053912 = null;
            } //End block
        } //End collapsed parenthetic
        int port = getSystemPropertyInt(portKey, defaultPort);
        varB4EAC82CA7396A68D541C85D26508E83_2141385975 = new Proxy(type, InetSocketAddress.createUnresolved(host, port));
        addTaint(hostKey.getTaint());
        addTaint(portKey.getTaint());
        addTaint(type.getTaint());
        addTaint(defaultPort);
        Proxy varA7E53CE21691AB073D9660D615818899_531277458; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_531277458 = varB4EAC82CA7396A68D541C85D26508E83_621053912;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_531277458 = varB4EAC82CA7396A68D541C85D26508E83_2141385975;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_531277458.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_531277458;
        // ---------- Original Method ----------
        //String host = System.getProperty(hostKey);
        //if (host == null || host.isEmpty()) {
            //return null;
        //}
        //int port = getSystemPropertyInt(portKey, defaultPort);
        //return new Proxy(type, InetSocketAddress.createUnresolved(host, port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.690 -0400", hash_original_method = "36E6CCC8C23DA7DA61B6599903A6840E", hash_generated_method = "22E752690883A1635BCDFCDC6E19DE2C")
    private int getSystemPropertyInt(String key, int defaultValue) {
        String string = System.getProperty(key);
        {
            try 
            {
                int var3715EC1DDE30CC1B193F456CA99A0396_294780262 = (Integer.parseInt(string));
            } //End block
            catch (NumberFormatException ignored)
            { }
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599863734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599863734;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.691 -0400", hash_original_method = "960A16929DB84D35FDCE84F421A041D1", hash_generated_method = "154ECEA66CDBD8AA8A2466B0E22A23F8")
    private boolean isNonProxyHost(String host, String nonProxyHosts) {
        StringBuilder patternBuilder = new StringBuilder();
        {
            int i = 0;
            boolean var34D84132F51D26BE58DFA3C8D2058636_748224033 = (i < nonProxyHosts.length());
            {
                char c = nonProxyHosts.charAt(i);
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
        String pattern = patternBuilder.toString();
        boolean var9EF2FD8C4CC99942090209B67BA77704_1877508810 = (host.matches(pattern));
        addTaint(host.getTaint());
        addTaint(nonProxyHosts.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862333130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862333130;
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

