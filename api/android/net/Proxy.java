package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;



public final class Proxy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.092 -0400", hash_original_method = "9B17734F1ACD31FFE2C2D0AFEC291967", hash_generated_method = "9B17734F1ACD31FFE2C2D0AFEC291967")
    public Proxy ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public static final java.net.Proxy getProxy(Context ctx, String url) {
        String host = "";
        if (url != null) {
            URI uri = URI.create(url);
            host = uri.getHost();
        }
        if (!isLocalHost(host)) {
            if (sConnectivityManager == null) {
                sConnectivityManager = (ConnectivityManager)ctx.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            }
            if (sConnectivityManager == null) return java.net.Proxy.NO_PROXY;
            ProxyProperties proxyProperties = sConnectivityManager.getProxy();
            if (proxyProperties != null) {
                if (!proxyProperties.isExcluded(host)) {
                    return proxyProperties.makeProxy();
                }
            }
        }
        return java.net.Proxy.NO_PROXY;
    }

    
    public static final String getHost(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return null;
        try {
            return ((InetSocketAddress)(proxy.address())).getHostName();
        } catch (Exception e) {
            return null;
        }
    }

    
    public static final int getPort(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return -1;
        try {
            return ((InetSocketAddress)(proxy.address())).getPort();
        } catch (Exception e) {
            return -1;
        }
    }

    
    public static final String getDefaultHost() {
        String host = System.getProperty("http.proxyHost");
        if (TextUtils.isEmpty(host)) return null;
        return host;
    }

    
    public static final int getDefaultPort() {
        if (getDefaultHost() == null) return -1;
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    @DSModeled(DSC.BAN)
    public static final HttpHost getPreferredHttpHost(Context context,
            String url) {
        java.net.Proxy prefProxy = getProxy(context, url);
        if (prefProxy.equals(java.net.Proxy.NO_PROXY)) {
            return null;
        } else {
            InetSocketAddress sa = (InetSocketAddress)prefProxy.address();
            return new HttpHost(sa.getHostName(), sa.getPort(), "http");
        }
    }

    
    @DSModeled(DSC.BAN)
    private static final boolean isLocalHost(String host) {
        if (host == null) {
            return false;
        }
        try {
            if (host != null) {
                if (host.equalsIgnoreCase("localhost")) {
                    return true;
                }
                if (NetworkUtils.numericToInetAddress(host).isLoopbackAddress()) {
                    return true;
                }
            }
        } catch (IllegalArgumentException iex) {
        }
        return false;
    }

    
    @DSModeled(DSC.BAN)
    public static void validate(String hostname, String port, String exclList) {
        Matcher match = HOSTNAME_PATTERN.matcher(hostname);
        Matcher listMatch = EXCLLIST_PATTERN.matcher(exclList);
        if (!match.matches()) {
            throw new IllegalArgumentException();
        }
        if (!listMatch.matches()) {
            throw new IllegalArgumentException();
        }
        if (hostname.length() > 0 && port.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (port.length() > 0) {
            if (hostname.length() == 0) {
                throw new IllegalArgumentException();
            }
            int portVal = -1;
            try {
                portVal = Integer.parseInt(port);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
            if (portVal <= 0 || portVal > 0xFFFF) {
                throw new IllegalArgumentException();
            }
        }
    }

    
    @DSModeled(DSC.BAN)
    public static final HttpRoutePlanner getAndroidProxySelectorRoutePlanner(Context context) {
        AndroidProxySelectorRoutePlanner ret = new AndroidProxySelectorRoutePlanner(
                new SchemeRegistry(), ProxySelector.getDefault(), context);
        return ret;
    }

    
    @DSModeled(DSC.BAN)
    public static final void setHttpProxySystemProperty(ProxyProperties p) {
        String host = null;
        String port = null;
        String exclList = null;
        if (p != null) {
            host = p.getHost();
            port = Integer.toString(p.getPort());
            exclList = p.getExclusionList();
        }
        setHttpProxySystemProperty(host, port, exclList);
    }

    
    @DSModeled(DSC.BAN)
    public static final void setHttpProxySystemProperty(String host, String port, String exclList) {
        if (exclList != null) exclList = exclList.replace(",", "|");
        if (false) Log.d(TAG, "setHttpProxySystemProperty :"+host+":"+port+" - "+exclList);
        if (host != null) {
            System.setProperty("http.proxyHost", host);
            System.setProperty("https.proxyHost", host);
        } else {
            System.clearProperty("http.proxyHost");
            System.clearProperty("https.proxyHost");
        }
        if (port != null) {
            System.setProperty("http.proxyPort", port);
            System.setProperty("https.proxyPort", port);
        } else {
            System.clearProperty("http.proxyPort");
            System.clearProperty("https.proxyPort");
        }
        if (exclList != null) {
            System.setProperty("http.nonProxyHosts", exclList);
            System.setProperty("https.nonProxyHosts", exclList);
        } else {
            System.clearProperty("http.nonProxyHosts");
            System.clearProperty("https.nonProxyHosts");
        }
    }

    
    static class AndroidProxySelectorRoutePlanner extends org.apache.http.impl.conn.ProxySelectorRoutePlanner {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.097 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.097 -0400", hash_original_method = "DEB2A922BA71DCCF9BE099E600C1C02C", hash_generated_method = "C044BDDECDC7F6657B1E611AE2250E56")
        public  AndroidProxySelectorRoutePlanner(SchemeRegistry schreg, ProxySelector prosel,
                Context context) {
            super(schreg, prosel);
            addTaint(prosel.getTaint());
            addTaint(schreg.getTaint());
            mContext = context;
            // ---------- Original Method ----------
            //mContext = context;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.098 -0400", hash_original_method = "48F5B4B79C87549F69CC4C6A9BA0C6B0", hash_generated_method = "76508D34F8CFC2C5E73F3CFB8FEC4EE3")
        @Override
        protected java.net.Proxy chooseProxy(List<java.net.Proxy> proxies, HttpHost target,
                HttpRequest request, HttpContext context) {
            addTaint(context.getTaint());
            addTaint(request.getTaint());
            addTaint(target.getTaint());
            addTaint(proxies.getTaint());
java.net.Proxy var5B499AD3433E400F9B38C6C2DB6406F2_1004601029 =             getProxy(mContext, target.getHostName());
            var5B499AD3433E400F9B38C6C2DB6406F2_1004601029.addTaint(taint);
            return var5B499AD3433E400F9B38C6C2DB6406F2_1004601029;
            // ---------- Original Method ----------
            //return getProxy(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.098 -0400", hash_original_method = "9701FEC44D63FCB85406EC9CE91F80E5", hash_generated_method = "3EBA3DA019D7D9FDE5018A20E2B24803")
        @Override
        protected HttpHost determineProxy(HttpHost target, HttpRequest request,
                HttpContext context) {
            addTaint(context.getTaint());
            addTaint(request.getTaint());
            addTaint(target.getTaint());
HttpHost var482C37C9B06DF2A4753F7E794E89D67C_993685478 =             getPreferredHttpHost(mContext, target.getHostName());
            var482C37C9B06DF2A4753F7E794E89D67C_993685478.addTaint(taint);
            return var482C37C9B06DF2A4753F7E794E89D67C_993685478;
            // ---------- Original Method ----------
            //return getPreferredHttpHost(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_method = "DA8D3BCA6C8948678C6240635F743B49", hash_generated_method = "354A70910792E9250E6AE81A8CDB6282")
        @Override
        public HttpRoute determineRoute(HttpHost target, HttpRequest request,
                HttpContext context) {
            addTaint(context.getTaint());
            addTaint(request.getTaint());
            addTaint(target.getTaint());
            HttpHost proxy = getPreferredHttpHost(mContext, target.getHostName());
            if(proxy == null)            
            {
HttpRoute var388BE1934E26966FCFE6F8DBBCA78348_1434644154 =                 new HttpRoute(target);
                var388BE1934E26966FCFE6F8DBBCA78348_1434644154.addTaint(taint);
                return var388BE1934E26966FCFE6F8DBBCA78348_1434644154;
            } //End block
            else
            {
HttpRoute var1047DAA740D371C7B185759950EFDC44_1868416232 =                 new HttpRoute(target, null, proxy, false);
                var1047DAA740D371C7B185759950EFDC44_1868416232.addTaint(taint);
                return var1047DAA740D371C7B185759950EFDC44_1868416232;
            } //End block
            // ---------- Original Method ----------
            //HttpHost proxy = getPreferredHttpHost(mContext, target.getHostName());
            //if (proxy == null) {
                //return new HttpRoute(target);
            //} else {
                //return new HttpRoute(target, null, proxy, false);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "CABD4F25416CE1B3A304D99C5A20EEDB", hash_generated_field = "07BC923D17DFEE12B12FD2485130D09A")

    private static final String TAG = "Proxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "F61CE72036D58FBD7C6BD6932CD4B72C", hash_generated_field = "34A5B97C5529F7F21DA262B2610C8857")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "189CDF8A07CA55950CF6085ACABF9A71", hash_generated_field = "08AADCAC60D2A1DE86FE693DB601F5A0")

    public static final String EXTRA_PROXY_INFO = "proxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "82A04D1110652BF4D042FA221BF215F0", hash_generated_field = "427960B73CFD9444E575418808762B27")

    private static ConnectivityManager sConnectivityManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "39C4A6A3E0AA688A2877FA4B920141A3", hash_generated_field = "25D62CACD7430139D5FAC1C63172E7D4")

    private static final String NAME_IP_REGEX = "[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "DE555095703CD47320FDF1F4D3178EB1", hash_generated_field = "C3F164D9CCD44E65DF6B06B17C810E5C")

    private static final String HOSTNAME_REGEXP = "^$|^" + NAME_IP_REGEX + "$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "E20E4AE1F056D0E6EA5EA07A701659DF", hash_generated_field = "3F163D91D2D2BE24E05C601350F994B9")

    private static Pattern HOSTNAME_PATTERN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.099 -0400", hash_original_field = "8C6963CC3F6E08234881A4323DB78350", hash_generated_field = "50BAC89EA09AFF7002FC1AACFF8AD21E")

    private static final String EXCLLIST_REGEXP = "$|^(.?" + NAME_IP_REGEX
        + ")+(,(.?" + NAME_IP_REGEX + "))*$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.100 -0400", hash_original_field = "44F907F27D5E08B5D18D45C2240F881D", hash_generated_field = "15EAB5B4DB69207C81675593AAD3F9C2")

    private static Pattern EXCLLIST_PATTERN;
    static {
        HOSTNAME_PATTERN = Pattern.compile(HOSTNAME_REGEXP);
        EXCLLIST_PATTERN = Pattern.compile(EXCLLIST_REGEXP);
    }
    
}

