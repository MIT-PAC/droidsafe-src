package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.368 -0400", hash_original_method = "7027194AD9EE6C73E0D1E06E53602BFC", hash_generated_method = "7027194AD9EE6C73E0D1E06E53602BFC")
        public Proxy ()
    {
    }


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

    
        public static final HttpRoutePlanner getAndroidProxySelectorRoutePlanner(Context context) {
        AndroidProxySelectorRoutePlanner ret = new AndroidProxySelectorRoutePlanner(
                new SchemeRegistry(), ProxySelector.getDefault(), context);
        return ret;
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.371 -0400", hash_original_method = "DEB2A922BA71DCCF9BE099E600C1C02C", hash_generated_method = "AEA409474585F3B2270DE9565DB125B6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.371 -0400", hash_original_method = "48F5B4B79C87549F69CC4C6A9BA0C6B0", hash_generated_method = "0D69711076B84D2BC6BBE336EE7CDC00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected java.net.Proxy chooseProxy(List<java.net.Proxy> proxies, HttpHost target,
                HttpRequest request, HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            dsTaint.addTaint(proxies.dsTaint);
            java.net.Proxy varFB6838E6FC7950F90E160BE7CEAF66EA_1402795674 = (getProxy(mContext, target.getHostName()));
            return (java.net.Proxy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getProxy(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.372 -0400", hash_original_method = "9701FEC44D63FCB85406EC9CE91F80E5", hash_generated_method = "353A4D6E60F3F02C26E0E6AE14EFC403")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected HttpHost determineProxy(HttpHost target, HttpRequest request,
                HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            HttpHost varF391FC4647239405C0A62B4799FC6E89_1034356156 = (getPreferredHttpHost(mContext, target.getHostName()));
            return (HttpHost)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getPreferredHttpHost(mContext, target.getHostName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.373 -0400", hash_original_method = "DA8D3BCA6C8948678C6240635F743B49", hash_generated_method = "51810DFF08238A3DFA290650DD4D57A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public HttpRoute determineRoute(HttpHost target, HttpRequest request,
                HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            HttpHost proxy;
            proxy = getPreferredHttpHost(mContext, target.getHostName());
            {
                HttpRoute var1FBA228E09F460E309072AC5F8703A59_1976966031 = (new HttpRoute(target));
            } //End block
            {
                HttpRoute var4475B0F255FE2B3156CEDC4D140F67EC_1936941835 = (new HttpRoute(target, null, proxy, false));
            } //End block
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


    
    private static final boolean DEBUG = false;
    private static final String TAG = "Proxy";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
    public static final String EXTRA_PROXY_INFO = "proxy";
    private static ConnectivityManager sConnectivityManager = null;
    private static final String NAME_IP_REGEX =
        "[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*";
    private static final String HOSTNAME_REGEXP = "^$|^" + NAME_IP_REGEX + "$";
    private static final Pattern HOSTNAME_PATTERN;
    private static final String EXCLLIST_REGEXP = "$|^(.?" + NAME_IP_REGEX
        + ")+(,(.?" + NAME_IP_REGEX + "))*$";
    private static final Pattern EXCLLIST_PATTERN;
    static {
        HOSTNAME_PATTERN = Pattern.compile(HOSTNAME_REGEXP);
        EXCLLIST_PATTERN = Pattern.compile(EXCLLIST_REGEXP);
    }
    
}

