package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.ProxyProperties;
import android.os.Handler;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.provider.Settings;
import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.protocol.HttpContext;

public final class Proxy {
    private static final boolean DEBUG = false;
    private static final String TAG = "Proxy";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
    public static final String EXTRA_PROXY_INFO = "proxy";
    private static ConnectivityManager sConnectivityManager = null;
    private static final String NAME_IP_REGEX =
        "[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*";
    private static final String HOSTNAME_REGEXP = "^$|^" + NAME_IP_REGEX + "$";
    private static final Pattern HOSTNAME_PATTERN;
    private static final String EXCLLIST_REGEXP = "$|^(.?" + NAME_IP_REGEX
        + ")+(,(.?" + NAME_IP_REGEX + "))*$";
    private static final Pattern EXCLLIST_PATTERN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.257 -0400", hash_original_method = "66D3F50ED16481B0B14959535BF8F553", hash_generated_method = "528CCAEC6E9BE135E54AC7B8FB019990")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.257 -0400", hash_original_method = "F0F69366C00A2E0E35F4A59DBEA02BB9", hash_generated_method = "0E70946C3B52F40077328D4F152C081F")
    public static final String getHost(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return null;
        try {
            return ((InetSocketAddress)(proxy.address())).getHostName();
        } catch (Exception e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.257 -0400", hash_original_method = "E6F7F0D1C666FFE934B85206D0305367", hash_generated_method = "A624C191E0B15FF56E0DE2AEAE61CA27")
    public static final int getPort(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return -1;
        try {
            return ((InetSocketAddress)(proxy.address())).getPort();
        } catch (Exception e) {
            return -1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.257 -0400", hash_original_method = "E669A7ACE9D8EEFE98E3D6369305AEB7", hash_generated_method = "7FC5045A7478361888863018FE1881A6")
    public static final String getDefaultHost() {
        String host = System.getProperty("http.proxyHost");
        if (TextUtils.isEmpty(host)) return null;
        return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.257 -0400", hash_original_method = "01B1A8B7C4F3BCE745F57F14A5BC3036", hash_generated_method = "8119E6B41E7E3AB07740DD38B66C78EF")
    public static final int getDefaultPort() {
        if (getDefaultHost() == null) return -1;
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "0DC6892F9119B40AD3A553AA53E42E93", hash_generated_method = "F705D319450A7271C0F406E7D09BA266")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "26F6A89AC3C35BA8FFA3188781C71F9A", hash_generated_method = "4F141E0CF1506F8783721B545795D180")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "94CFA4003ECFAF43F31C4E4E1165E3BE", hash_generated_method = "CBA1A2309F41EBDEFC09CD69FF58C38D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "6F2826910ED861BE3917BC7BA6F33E4C", hash_generated_method = "813C1AC8F77D5BB4C302553C27F9DC4E")
    public static final HttpRoutePlanner getAndroidProxySelectorRoutePlanner(Context context) {
        AndroidProxySelectorRoutePlanner ret = new AndroidProxySelectorRoutePlanner(
                new SchemeRegistry(), ProxySelector.getDefault(), context);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "3244352400EDEDB3EB7AED58C0739291", hash_generated_method = "41A838C684F7837508B7C2979D0DC19A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "660478F21FCA5D999AF8E2D00B3AE310", hash_generated_method = "46766221F08D587407E031D1B550AE85")
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
        private Context mContext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.258 -0400", hash_original_method = "DEB2A922BA71DCCF9BE099E600C1C02C", hash_generated_method = "D74E338F9DB9F18E6CF705BF20C541D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AndroidProxySelectorRoutePlanner(SchemeRegistry schreg, ProxySelector prosel,
                Context context) {
            super(schreg, prosel);
            dsTaint.addTaint(prosel.dsTaint);
            dsTaint.addTaint(schreg.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
            //mContext = context;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.259 -0400", hash_original_method = "48F5B4B79C87549F69CC4C6A9BA0C6B0", hash_generated_method = "796CD68CFB60567D6B346A4B5C5DA056")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected java.net.Proxy chooseProxy(List<java.net.Proxy> proxies, HttpHost target,
                HttpRequest request, HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(proxies.dsTaint);
            java.net.Proxy varFB6838E6FC7950F90E160BE7CEAF66EA_881556685 = (getProxy(mContext, target.getHostName()));
            return (java.net.Proxy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getProxy(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.259 -0400", hash_original_method = "9701FEC44D63FCB85406EC9CE91F80E5", hash_generated_method = "9BF5D5DD2D29F2A61390FA4D4FDFD28F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected HttpHost determineProxy(HttpHost target, HttpRequest request,
                HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            HttpHost varF391FC4647239405C0A62B4799FC6E89_388211046 = (getPreferredHttpHost(mContext, target.getHostName()));
            return (HttpHost)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getPreferredHttpHost(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.259 -0400", hash_original_method = "DA8D3BCA6C8948678C6240635F743B49", hash_generated_method = "EAE2DC545B4330B53384B8E612E11FC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public HttpRoute determineRoute(HttpHost target, HttpRequest request,
                HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            HttpHost proxy;
            proxy = getPreferredHttpHost(mContext, target.getHostName());
            return (HttpRoute)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HttpHost proxy = getPreferredHttpHost(mContext, target.getHostName());
            //if (proxy == null) {
                //return new HttpRoute(target);
            //} else {
                //return new HttpRoute(target, null, proxy, false);
            //}
        }

        
    }


    
    static {
        HOSTNAME_PATTERN = Pattern.compile(HOSTNAME_REGEXP);
        EXCLLIST_PATTERN = Pattern.compile(EXCLLIST_REGEXP);
    }
    
}


