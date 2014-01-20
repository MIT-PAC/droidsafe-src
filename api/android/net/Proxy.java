package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Return the proxy object to be used for the URL given as parameter.
     * @param ctx A Context used to get the settings for the proxy host.
     * @param url A URL to be accessed. Used to evaluate exclusion list.
     * @return Proxy (java.net) object containing the host name. If the
     *         user did not set a hostname it returns the default host.
     *         A null value means that no host is to be used.
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.945 -0500", hash_original_method = "66D3F50ED16481B0B14959535BF8F553", hash_generated_method = "528CCAEC6E9BE135E54AC7B8FB019990")
    
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

    /**
     * Return the proxy host set by the user.
     * @param ctx A Context used to get the settings for the proxy host.
     * @return String containing the host name. If the user did not set a host
     *         name it returns the default host. A null value means that no
     *         host is to be used.
     * @deprecated Use standard java vm proxy values to find the host, port
     *         and exclusion list.  This call ignores the exclusion list.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.948 -0500", hash_original_method = "F0F69366C00A2E0E35F4A59DBEA02BB9", hash_generated_method = "0E70946C3B52F40077328D4F152C081F")
    
public static final String getHost(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return null;
        try {
            return ((InetSocketAddress)(proxy.address())).getHostName();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Return the proxy port set by the user.
     * @param ctx A Context used to get the settings for the proxy port.
     * @return The port number to use or -1 if no proxy is to be used.
     * @deprecated Use standard java vm proxy values to find the host, port
     *         and exclusion list.  This call ignores the exclusion list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.950 -0500", hash_original_method = "E6F7F0D1C666FFE934B85206D0305367", hash_generated_method = "A624C191E0B15FF56E0DE2AEAE61CA27")
    
public static final int getPort(Context ctx) {
        java.net.Proxy proxy = getProxy(ctx, null);
        if (proxy == java.net.Proxy.NO_PROXY) return -1;
        try {
            return ((InetSocketAddress)(proxy.address())).getPort();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Return the default proxy host specified by the carrier.
     * @return String containing the host name or null if there is no proxy for
     * this carrier.
     * @deprecated Use standard java vm proxy values to find the host, port and
     *         exclusion list.  This call ignores the exclusion list and no
     *         longer reports only mobile-data apn-based proxy values.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.953 -0500", hash_original_method = "E669A7ACE9D8EEFE98E3D6369305AEB7", hash_generated_method = "7FC5045A7478361888863018FE1881A6")
    
public static final String getDefaultHost() {
        String host = System.getProperty("http.proxyHost");
        if (TextUtils.isEmpty(host)) return null;
        return host;
    }

    /**
     * Return the default proxy port specified by the carrier.
     * @return The port number to be used with the proxy host or -1 if there is
     * no proxy for this carrier.
     * @deprecated Use standard java vm proxy values to find the host, port and
     *         exclusion list.  This call ignores the exclusion list and no
     *         longer reports only mobile-data apn-based proxy values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.956 -0500", hash_original_method = "01B1A8B7C4F3BCE745F57F14A5BC3036", hash_generated_method = "8119E6B41E7E3AB07740DD38B66C78EF")
    
public static final int getDefaultPort() {
        if (getDefaultHost() == null) return -1;
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Returns the preferred proxy to be used by clients. This is a wrapper
     * around {@link android.net.Proxy#getHost()}.
     *
     * @param context the context which will be passed to
     * {@link android.net.Proxy#getHost()}
     * @param url the target URL for the request
     * @note Calling this method requires permission
     * android.permission.ACCESS_NETWORK_STATE
     * @return The preferred proxy to be used by clients, or null if there
     * is no proxy.
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.958 -0500", hash_original_method = "0DC6892F9119B40AD3A553AA53E42E93", hash_generated_method = "F705D319450A7271C0F406E7D09BA266")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.961 -0500", hash_original_method = "26F6A89AC3C35BA8FFA3188781C71F9A", hash_generated_method = "4F141E0CF1506F8783721B545795D180")
    
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

    /**
     * Validate syntax of hostname, port and exclusion list entries
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.964 -0500", hash_original_method = "94CFA4003ECFAF43F31C4E4E1165E3BE", hash_generated_method = "CBA1A2309F41EBDEFC09CD69FF58C38D")
    
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

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.981 -0500", hash_original_method = "6F2826910ED861BE3917BC7BA6F33E4C", hash_generated_method = "813C1AC8F77D5BB4C302553C27F9DC4E")
    
public static final HttpRoutePlanner getAndroidProxySelectorRoutePlanner(Context context) {
        AndroidProxySelectorRoutePlanner ret = new AndroidProxySelectorRoutePlanner(
                new SchemeRegistry(), ProxySelector.getDefault(), context);
        return ret;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.984 -0500", hash_original_method = "3244352400EDEDB3EB7AED58C0739291", hash_generated_method = "41A838C684F7837508B7C2979D0DC19A")
    
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

    /** @hide */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.987 -0500", hash_original_method = "660478F21FCA5D999AF8E2D00B3AE310", hash_generated_method = "46766221F08D587407E031D1B550AE85")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.920 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    
    static class AndroidProxySelectorRoutePlanner extends org.apache.http.impl.conn.ProxySelectorRoutePlanner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.967 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.970 -0500", hash_original_method = "DEB2A922BA71DCCF9BE099E600C1C02C", hash_generated_method = "1F379E88B30979A118531F32B3608B6C")
        
public AndroidProxySelectorRoutePlanner(SchemeRegistry schreg, ProxySelector prosel,
                Context context) {
            super(schreg, prosel);
            mContext = context;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.972 -0500", hash_original_method = "48F5B4B79C87549F69CC4C6A9BA0C6B0", hash_generated_method = "D3D7466DCAF4FF7ECC1368E7028B0ABF")
        
@Override
        protected java.net.Proxy chooseProxy(List<java.net.Proxy> proxies, HttpHost target,
                HttpRequest request, HttpContext context) {
            return getProxy(mContext, target.getHostName());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.975 -0500", hash_original_method = "9701FEC44D63FCB85406EC9CE91F80E5", hash_generated_method = "EEF969573025953B1CE3EDB692A0C264")
        
@Override
        protected HttpHost determineProxy(HttpHost target, HttpRequest request,
                HttpContext context) {
            return getPreferredHttpHost(mContext, target.getHostName());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.977 -0500", hash_original_method = "DA8D3BCA6C8948678C6240635F743B49", hash_generated_method = "A67CCF3DEE0153B0ACC5FC6033E7D650")
        
@Override
        public HttpRoute determineRoute(HttpHost target, HttpRequest request,
                HttpContext context) {
            HttpHost proxy = getPreferredHttpHost(mContext, target.getHostName());
            if (proxy == null) {
                return new HttpRoute(target);
            } else {
                return new HttpRoute(target, null, proxy, false);
            }
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.924 -0500", hash_original_field = "386710A63E400853F0A8D53DB73B0BDE", hash_generated_field = "07BC923D17DFEE12B12FD2485130D09A")

    private static final String TAG = "Proxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.926 -0500", hash_original_field = "3F6FD903C6823390867079DB91105920", hash_generated_field = "34A5B97C5529F7F21DA262B2610C8857")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.928 -0500", hash_original_field = "6380E5BE351C7512F36A2B18B808A46C", hash_generated_field = "08AADCAC60D2A1DE86FE693DB601F5A0")

    public static final String EXTRA_PROXY_INFO = "proxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.931 -0500", hash_original_field = "27EC7DAB5BF9DE0B37C6DF53C80F465D", hash_generated_field = "427960B73CFD9444E575418808762B27")

    private static ConnectivityManager sConnectivityManager = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.933 -0500", hash_original_field = "D8ADB57BB658BA5CF16A36C5E92EB4BD", hash_generated_field = "7F41A38C2F8FA812438F7455C162B285")

    // Matches blank input, ips, and domain names
    private static final String NAME_IP_REGEX =
        "[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.935 -0500", hash_original_field = "F616F34B67D5772FCF10CD9BC3F67DA8", hash_generated_field = "C3F164D9CCD44E65DF6B06B17C810E5C")

    private static final String HOSTNAME_REGEXP = "^$|^" + NAME_IP_REGEX + "$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.938 -0500", hash_original_field = "31ACAE76089FBD47C4DC2F47370399AC", hash_generated_field = "3F163D91D2D2BE24E05C601350F994B9")

    private static  Pattern HOSTNAME_PATTERN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.940 -0500", hash_original_field = "0C666730DB91C16D174BD02F71E56BFE", hash_generated_field = "50BAC89EA09AFF7002FC1AACFF8AD21E")

    private static final String EXCLLIST_REGEXP = "$|^(.?" + NAME_IP_REGEX
        + ")+(,(.?" + NAME_IP_REGEX + "))*$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.943 -0500", hash_original_field = "F01F8BB9B09FD3F793952B572E617534", hash_generated_field = "15EAB5B4DB69207C81675593AAD3F9C2")

    private static  Pattern EXCLLIST_PATTERN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.092 -0400", hash_original_method = "9B17734F1ACD31FFE2C2D0AFEC291967", hash_generated_method = "9B17734F1ACD31FFE2C2D0AFEC291967")
    public Proxy ()
    {
        //Synthesized constructor
    }
    static {
        HOSTNAME_PATTERN = Pattern.compile(HOSTNAME_REGEXP);
        EXCLLIST_PATTERN = Pattern.compile(EXCLLIST_REGEXP);
    }
    
}

