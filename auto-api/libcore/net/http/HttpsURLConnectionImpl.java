package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SecureCacheResponse;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

final class HttpsURLConnectionImpl extends HttpsURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.261 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private HttpUrlConnectionDelegate delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.262 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "D7761E6D33F0C47B987ABA4B6009A9B6")
    protected  HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.262 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "144D9F5811306E263A0B42085141274A")
    protected  HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.262 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "269DFC6F169ED8059CF293F47788ECA1")
    private void checkConnected() {
        {
            boolean varBA474CA436F45D71B4740DB91291C434_1958848495 = (delegate.getSSLSocket() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection has not yet been established");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (delegate.getSSLSocket() == null) {
            //throw new IllegalStateException("Connection has not yet been established");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.266 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "D2A938671C03F61A0B453DF5E04BAA7D")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_2074540857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2074540857 = delegate.getHttpEngine();
        varB4EAC82CA7396A68D541C85D26508E83_2074540857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2074540857;
        // ---------- Original Method ----------
        //return delegate.getHttpEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.267 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "E235C361A7C211E85B5415FEAF202FFB")
    @Override
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_1675965425 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_565285799 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1675965425 = cacheResponse.getCipherSuite();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_565285799 = delegate.getSSLSocket().getSession().getCipherSuite();
        String varA7E53CE21691AB073D9660D615818899_885056900; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_885056900 = varB4EAC82CA7396A68D541C85D26508E83_1675965425;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_885056900 = varB4EAC82CA7396A68D541C85D26508E83_565285799;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_885056900.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_885056900;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getCipherSuite();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.268 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "7651BCC93C30425514594566D79D09C8")
    @Override
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1004834541 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_109248628 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getLocalCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_1004834541 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_109248628 = delegate.getSSLSocket().getSession().getLocalCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_633403343; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_633403343 = varB4EAC82CA7396A68D541C85D26508E83_1004834541;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_633403343 = varB4EAC82CA7396A68D541C85D26508E83_109248628;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_633403343.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_633403343;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getLocalCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.268 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "86AC0DE1CCEE87D30C1CF9FACA5C055E")
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_698195894 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_360059372 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getServerCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_698195894 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_360059372 = delegate.getSSLSocket().getSession().getPeerCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_192461336; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_192461336 = varB4EAC82CA7396A68D541C85D26508E83_698195894;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_192461336 = varB4EAC82CA7396A68D541C85D26508E83_360059372;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_192461336.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_192461336;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getServerCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.269 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "C04B4450939C28EA950B5A2330D35B23")
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1108743661 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_1904743760 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1108743661 = cacheResponse.getPeerPrincipal();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1904743760 = delegate.getSSLSocket().getSession().getPeerPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_880432991; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_880432991 = varB4EAC82CA7396A68D541C85D26508E83_1108743661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_880432991 = varB4EAC82CA7396A68D541C85D26508E83_1904743760;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_880432991.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_880432991;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getPeerPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.288 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "7B5060003B70DB11F194474511084C9A")
    @Override
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1782355927 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_1259321805 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1782355927 = cacheResponse.getLocalPrincipal();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1259321805 = delegate.getSSLSocket().getSession().getLocalPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_485987729; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_485987729 = varB4EAC82CA7396A68D541C85D26508E83_1782355927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_485987729 = varB4EAC82CA7396A68D541C85D26508E83_1259321805;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_485987729.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_485987729;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getLocalPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.289 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    @Override
    public void disconnect() {
        delegate.disconnect();
        // ---------- Original Method ----------
        //delegate.disconnect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.290 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "501384F762DC575CD5DD54FAF390853C")
    @Override
    public InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1683865028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683865028 = delegate.getErrorStream();
        varB4EAC82CA7396A68D541C85D26508E83_1683865028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683865028;
        // ---------- Original Method ----------
        //return delegate.getErrorStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.290 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "A1288CDCBB84155447F0C60D09E999FF")
    @Override
    public String getRequestMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1928266592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928266592 = delegate.getRequestMethod();
        varB4EAC82CA7396A68D541C85D26508E83_1928266592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928266592;
        // ---------- Original Method ----------
        //return delegate.getRequestMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.294 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "521DC483CF5364CF4696633081B4B020")
    @Override
    public int getResponseCode() throws IOException {
        int varDC834023D584CBF2E5DE9F65DB0FB932_1403315341 = (delegate.getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922508905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922508905;
        // ---------- Original Method ----------
        //return delegate.getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.294 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "89C3F8DE998C5194867AA4E71A3B7CD5")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_341214816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_341214816 = delegate.getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_341214816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_341214816;
        // ---------- Original Method ----------
        //return delegate.getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.294 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "96C31B8B5ED1067D8DDD87E968D455E8")
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        delegate.setRequestMethod(method);
        addTaint(method.getTaint());
        // ---------- Original Method ----------
        //delegate.setRequestMethod(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.298 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "0032C685C7F210691588FA262D4BAD28")
    @Override
    public boolean usingProxy() {
        boolean var1A73319817A7BA58362FCE0126646E14_33522573 = (delegate.usingProxy());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138244952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138244952;
        // ---------- Original Method ----------
        //return delegate.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.298 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "3FAB9E279A81686DE933F43921B34619")
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var36FEF060062CDCFFA52982B100EB3F06_488732755 = (delegate.getInstanceFollowRedirects());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116671123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116671123;
        // ---------- Original Method ----------
        //return delegate.getInstanceFollowRedirects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.299 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "B749037A4CF115D9FF640C306F206053")
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        delegate.setInstanceFollowRedirects(followRedirects);
        addTaint(followRedirects);
        // ---------- Original Method ----------
        //delegate.setInstanceFollowRedirects(followRedirects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.299 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        // ---------- Original Method ----------
        //connected = true;
        //delegate.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.299 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "80F5FC6D2C5382319135074B05C4BF13")
    @Override
    public boolean getAllowUserInteraction() {
        boolean varD52A0AC310FCDDF8EC36D9E6668695A1_348881976 = (delegate.getAllowUserInteraction());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280289281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280289281;
        // ---------- Original Method ----------
        //return delegate.getAllowUserInteraction();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.318 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "C4AE5B5075B9929AA5D7B27B2B0B65A5")
    @Override
    public Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_530648336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530648336 = delegate.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_530648336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530648336;
        // ---------- Original Method ----------
        //return delegate.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.318 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "E87ABAAA37A7CD073871933A9C064CB4")
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2131656303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2131656303 = delegate.getContent(types);
        addTaint(types[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2131656303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2131656303;
        // ---------- Original Method ----------
        //return delegate.getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.319 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "E9C9272CFA14466DD08F11BF810CA527")
    @Override
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_207811838 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_207811838 = delegate.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_207811838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207811838;
        // ---------- Original Method ----------
        //return delegate.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.319 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "783DEB7B2FB9A0A8F46BFDEE5D38A2CC")
    @Override
    public int getContentLength() {
        int var46C13ADE2970E578BB05FE5EEA0046DA_150533206 = (delegate.getContentLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547982535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547982535;
        // ---------- Original Method ----------
        //return delegate.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.325 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "4DC484F91786779B54F9D210EF2B83D0")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1600558998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1600558998 = delegate.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_1600558998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1600558998;
        // ---------- Original Method ----------
        //return delegate.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.329 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "DA82C595886F1CA6ED2C38C354A12C22")
    @Override
    public long getDate() {
        long var347DC365CBC90FBE87EE28BA84488696_1739718671 = (delegate.getDate());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_652797440 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_652797440;
        // ---------- Original Method ----------
        //return delegate.getDate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.329 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "A68C095AB1EEA7582C89A6A096FB49E0")
    @Override
    public boolean getDefaultUseCaches() {
        boolean var3FC2C68637FBA6BB6F081C916459E56C_1445883538 = (delegate.getDefaultUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050377056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050377056;
        // ---------- Original Method ----------
        //return delegate.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.330 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "2D0BD5F0E13B7BB94B0AA8C5A8F36D57")
    @Override
    public boolean getDoInput() {
        boolean var3AD6E1CD897116123B22123C5F9351D0_177076308 = (delegate.getDoInput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861864512 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861864512;
        // ---------- Original Method ----------
        //return delegate.getDoInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.340 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "F48C5D80F8C891B88B486A23A15463D4")
    @Override
    public boolean getDoOutput() {
        boolean varBB2AB3EEC37F983793BE7F09AA948961_371378088 = (delegate.getDoOutput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317601892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_317601892;
        // ---------- Original Method ----------
        //return delegate.getDoOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.340 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "23584F4ED122B78801EA19E14E938720")
    @Override
    public long getExpiration() {
        long varC51716E5D8873132B8303EA472292149_511091263 = (delegate.getExpiration());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_369723902 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_369723902;
        // ---------- Original Method ----------
        //return delegate.getExpiration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.340 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "DBDD363B5E43A1BB4B7B8BE8A307C819")
    @Override
    public String getHeaderField(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_212424021 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212424021 = delegate.getHeaderField(pos);
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_212424021.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212424021;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.341 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "83FAC7C3B04A2849BAB872D788D958A7")
    @Override
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1207457019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1207457019 = delegate.getHeaderFields();
        varB4EAC82CA7396A68D541C85D26508E83_1207457019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207457019;
        // ---------- Original Method ----------
        //return delegate.getHeaderFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.341 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "46BE6419AFDC1A9E126CD9A3A952EB0A")
    @Override
    public Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1479613931 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479613931 = delegate.getRequestProperties();
        varB4EAC82CA7396A68D541C85D26508E83_1479613931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479613931;
        // ---------- Original Method ----------
        //return delegate.getRequestProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.356 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "5B496D640FDFED5ABDD99EF1524459C4")
    @Override
    public void addRequestProperty(String field, String newValue) {
        delegate.addRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //delegate.addRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.357 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "FC69686AB4340D09AED2F4FD0427B0D8")
    @Override
    public String getHeaderField(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1209222367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1209222367 = delegate.getHeaderField(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1209222367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1209222367;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.358 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "28915F20985C3D4640618BB5517514CF")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        long varF9B0FA24B3C89487E1F0C5C4DEFD1A6F_1190791936 = (delegate.getHeaderFieldDate(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_803569661 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_803569661;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.358 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "E1BF1837E701CB28B23325602A0F765E")
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        int var9141D4C32956F8B7698AADB6AE35E322_237293440 = (delegate.getHeaderFieldInt(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169108703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169108703;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldInt(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.359 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "575C6938F82A3966274C749031FEE2AE")
    @Override
    public String getHeaderFieldKey(int posn) {
        String varB4EAC82CA7396A68D541C85D26508E83_190306699 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_190306699 = delegate.getHeaderFieldKey(posn);
        addTaint(posn);
        varB4EAC82CA7396A68D541C85D26508E83_190306699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_190306699;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldKey(posn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.359 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "B4B800AB85E88C3F5AA5E2E7484B74F9")
    @Override
    public long getIfModifiedSince() {
        long var2F648525489FF1333DA0B755237FF143_1935810865 = (delegate.getIfModifiedSince());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1678513700 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1678513700;
        // ---------- Original Method ----------
        //return delegate.getIfModifiedSince();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.370 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "8524305A8D98F9A95D16C70FA01CE706")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_477779673 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_477779673 = delegate.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_477779673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_477779673;
        // ---------- Original Method ----------
        //return delegate.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.371 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "2AE6D44EB838BC5B62195142D9F69BD5")
    @Override
    public long getLastModified() {
        long var426E8D7A6E590ED1F9B47C7958BE51AD_679655223 = (delegate.getLastModified());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_522524010 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_522524010;
        // ---------- Original Method ----------
        //return delegate.getLastModified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.371 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "D2E7C8A890663750FF0E7B0E91663BA3")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1421901969 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1421901969 = delegate.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1421901969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1421901969;
        // ---------- Original Method ----------
        //return delegate.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.372 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "D1BD7BC66F82D1B22C7F05F48483D402")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1417038753 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1417038753 = delegate.getPermission();
        varB4EAC82CA7396A68D541C85D26508E83_1417038753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1417038753;
        // ---------- Original Method ----------
        //return delegate.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.372 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "A9BDBADA422C8DA3B3F539799FEEDEB6")
    @Override
    public String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_2051327577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2051327577 = delegate.getRequestProperty(field);
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2051327577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051327577;
        // ---------- Original Method ----------
        //return delegate.getRequestProperty(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.373 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "D57E76330E87AE5D696729F4495B492F")
    @Override
    public URL getURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1110147525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1110147525 = delegate.getURL();
        varB4EAC82CA7396A68D541C85D26508E83_1110147525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1110147525;
        // ---------- Original Method ----------
        //return delegate.getURL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.383 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "ED9D66C4B6C0F7D67AEF4C2433A777B6")
    @Override
    public boolean getUseCaches() {
        boolean varF45B15791721B7C5A39E6EC8FCE0C874_1373553306 = (delegate.getUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464712292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_464712292;
        // ---------- Original Method ----------
        //return delegate.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.383 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "02757753814864D79B417A4E5560E6EA")
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        delegate.setAllowUserInteraction(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setAllowUserInteraction(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.383 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "3C3C89655A3D6AECD88D33B37547EC97")
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        delegate.setDefaultUseCaches(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDefaultUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.384 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "DE7B6452AD8A3FE1A7045875984FE6A2")
    @Override
    public void setDoInput(boolean newValue) {
        delegate.setDoInput(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDoInput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.384 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "AA8A96B085C00AD18F5980AC73553873")
    @Override
    public void setDoOutput(boolean newValue) {
        delegate.setDoOutput(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDoOutput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.385 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "D14199A3B941EEE74B5D2C6648A5F597")
    @Override
    public void setIfModifiedSince(long newValue) {
        delegate.setIfModifiedSince(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setIfModifiedSince(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.385 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "6B6D20991C7095A3C9F78228FC1B9636")
    @Override
    public void setRequestProperty(String field, String newValue) {
        delegate.setRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //delegate.setRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.403 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "927600B68A0BF85DC96C4DC0C7806FFD")
    @Override
    public void setUseCaches(boolean newValue) {
        delegate.setUseCaches(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.404 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "30ADD793C24680380480910105D6F638")
    @Override
    public void setConnectTimeout(int timeout) {
        delegate.setConnectTimeout(timeout);
        addTaint(timeout);
        // ---------- Original Method ----------
        //delegate.setConnectTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.404 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "C2203E4613EB5E9F2D124971EC181B9D")
    @Override
    public int getConnectTimeout() {
        int var44D58E8907D6B3B15AC45D93D9FF2214_987206333 = (delegate.getConnectTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343930361 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343930361;
        // ---------- Original Method ----------
        //return delegate.getConnectTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.405 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "14E84308D3CFF1DBE96F7FF169D33305")
    @Override
    public void setReadTimeout(int timeout) {
        delegate.setReadTimeout(timeout);
        addTaint(timeout);
        // ---------- Original Method ----------
        //delegate.setReadTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.406 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "0CF1957E26F388CA3C843FC1E16E0F4B")
    @Override
    public int getReadTimeout() {
        int var6AA840C9DF82A442D7F21A3A02E813E8_333657355 = (delegate.getReadTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559742798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559742798;
        // ---------- Original Method ----------
        //return delegate.getReadTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.406 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "FEC0482207E652549FC4B44CA93FF296")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_310825631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310825631 = delegate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_310825631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310825631;
        // ---------- Original Method ----------
        //return delegate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.414 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "509A3EF6AD1E19EC7C99267806699592")
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        delegate.setFixedLengthStreamingMode(contentLength);
        addTaint(contentLength);
        // ---------- Original Method ----------
        //delegate.setFixedLengthStreamingMode(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.414 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "B5561F2543E0B374874DFB2AF81D7456")
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        delegate.setChunkedStreamingMode(chunkLength);
        addTaint(chunkLength);
        // ---------- Original Method ----------
        //delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.415 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "50A8EEC8FB19EF703EB1D2AD125E34DD")
        private  HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            addTaint(url.getTaint());
            addTaint(port);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.415 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "E9B5447036109B1EF5921CBC009F2D5F")
        private  HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            addTaint(url.getTaint());
            addTaint(port);
            addTaint(proxy.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.416 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "6DD323C82DC701CF5786A6EDF4685A8C")
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            HttpEngine varB4EAC82CA7396A68D541C85D26508E83_2021246041 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2021246041 = new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
            addTaint(method.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestBody.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2021246041.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2021246041;
            // ---------- Original Method ----------
            //return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    //HttpsURLConnectionImpl.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.416 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "C916F7B8EC240DE128E4C10240E2B578")
        public SecureCacheResponse getCacheResponse() {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_371218283 = null; //Variable for return #1
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_371218283 = engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
            varB4EAC82CA7396A68D541C85D26508E83_371218283.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_371218283;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.417 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "9FB8211CB833E10B10C4A807C18CDC8F")
        public SSLSocket getSSLSocket() {
            SSLSocket varB4EAC82CA7396A68D541C85D26508E83_688868976 = null; //Variable for return #1
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_688868976 = engine != null ? engine.sslSocket : null;
            varB4EAC82CA7396A68D541C85D26508E83_688868976.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_688868976;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.417 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.417 -0400", hash_original_field = "06B167584A75871D42FCD159D2218E9A", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")

        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.436 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "62C2DDAC8588DD301A50D31B54A2D261")
        private  HttpsEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody,
                HttpsURLConnectionImpl enclosing) throws IOException {
            super(policy, method, requestHeaders, connection, requestBody);
            this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            this.enclosing = enclosing;
            addTaint(policy.getTaint());
            addTaint(method.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(requestBody.getTaint());
            // ---------- Original Method ----------
            //this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            //this.enclosing = enclosing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.437 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "0A5751B71DAF8D787C269568912E9840")
        @Override
        protected void connect() throws IOException {
            boolean connectionReused;
            try 
            {
                connectionReused = makeSslConnection(true);
            } //End block
            catch (IOException e)
            {
                {
                    boolean var3AC4DFFE7CC4939DF7C4ED033B861EC8_137261787 = (e instanceof SSLHandshakeException
                        && e.getCause() instanceof CertificateException);
                    {
                        if (DroidSafeAndroidRuntime.control) throw e;
                    } //End block
                } //End collapsed parenthetic
                release(false);
                connectionReused = makeSslConnection(false);
            } //End block
            {
                sslSocket = connection.verifySecureSocketHostname(enclosing.getHostnameVerifier());
            } //End block
            // ---------- Original Method ----------
            //boolean connectionReused;
            //try {
                //connectionReused = makeSslConnection(true);
            //} catch (IOException e) {
                //if (e instanceof SSLHandshakeException
                        //&& e.getCause() instanceof CertificateException) {
                    //throw e;
                //}
                //release(false);
                //connectionReused = makeSslConnection(false);
            //}
            //if (!connectionReused) {
                //sslSocket = connection.verifySecureSocketHostname(enclosing.getHostnameVerifier());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.452 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "43F4CAF01CF518ED06EB718F4624988E")
        private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            {
                connection = openSocketConnection();
                {
                    boolean var8E696082C46988ED27CC92AF7EEC78DA_1673868346 = (connection.getAddress().getProxy() != null);
                    {
                        makeTunnel(policy, connection, getRequestHeaders());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            sslSocket = connection.getSecureSocketIfConnected();
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            addTaint(tlsTolerant);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503412936 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_503412936;
            // ---------- Original Method ----------
            //if (connection == null) {
                //connection = openSocketConnection();
                //if (connection.getAddress().getProxy() != null) {
                    //makeTunnel(policy, connection, getRequestHeaders());
                //}
            //}
            //sslSocket = connection.getSecureSocketIfConnected();
            //if (sslSocket != null) {
                //return true;
            //}
            //connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.453 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "21F3C29AB8FE3DC78E29583DA0309300")
        private void makeTunnel(HttpURLConnectionImpl policy, HttpConnection connection,
                RequestHeaders requestHeaders) throws IOException {
            RawHeaders rawRequestHeaders;
            rawRequestHeaders = requestHeaders.getHeaders();
            {
                HttpEngine connect;
                connect = new ProxyConnectEngine(policy, rawRequestHeaders, connection);
                connect.sendRequest();
                connect.readResponse();
                int responseCode;
                responseCode = connect.getResponseCode();
                {
                    Object varE3D66A7026D8BFDE15E135A9F3AF9D8C_791385593 = (connect.getResponseCode());
                    //Begin case HTTP_PROXY_AUTH 
                    rawRequestHeaders = new RawHeaders(rawRequestHeaders);
                    //End case HTTP_PROXY_AUTH 
                    //Begin case HTTP_PROXY_AUTH 
                    boolean credentialsFound;
                    credentialsFound = policy.processAuthHeader(HTTP_PROXY_AUTH,
                            connect.getResponseHeaders(), rawRequestHeaders);
                    //End case HTTP_PROXY_AUTH 
                    //Begin case HTTP_PROXY_AUTH 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Failed to authenticate with proxy");
                    } //End block
                    //End case HTTP_PROXY_AUTH 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Unexpected response code for CONNECT: " + responseCode);
                    //End case default 
                } //End collapsed parenthetic
            } //End block
            addTaint(policy.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.454 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "149EEE8AFEA8A0D47974E01AC00C92F4")
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            addTaint(cacheResponse.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708715661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_708715661;
            // ---------- Original Method ----------
            //return cacheResponse instanceof SecureCacheResponse;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.454 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "B46ABEFF18944935FFBAADA3E9B62FAE")
        @Override
        protected boolean includeAuthorityInRequestLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401768266 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_401768266;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.454 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "3FD8E7B2A59A523368651CAA1785B327")
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
            HttpURLConnection varB4EAC82CA7396A68D541C85D26508E83_253926159 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_253926159 = enclosing;
            varB4EAC82CA7396A68D541C85D26508E83_253926159.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_253926159;
            // ---------- Original Method ----------
            //return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.455 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "FC467743B88D50776BC092FFC979445E")
        public  ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            addTaint(policy.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.456 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "48D3036E35C33BF3DF21C5A1BAC7E92B")
        @Override
        protected RawHeaders getNetworkRequestHeaders() throws IOException {
            RawHeaders varB4EAC82CA7396A68D541C85D26508E83_584497742 = null; //Variable for return #1
            RequestHeaders privateHeaders;
            privateHeaders = getRequestHeaders();
            URL url;
            url = policy.getURL();
            RawHeaders result;
            result = new RawHeaders();
            result.setStatusLine("CONNECT " + url.getHost() + ":" + url.getEffectivePort()
                    + " HTTP/1.1");
            String host;
            host = privateHeaders.getHost();
            {
                host = getOriginAddress(url);
            } //End block
            result.set("Host", host);
            String userAgent;
            userAgent = privateHeaders.getUserAgent();
            {
                userAgent = getDefaultUserAgent();
            } //End block
            result.set("User-Agent", userAgent);
            String proxyAuthorization;
            proxyAuthorization = privateHeaders.getProxyAuthorization();
            {
                result.set("Proxy-Authorization", proxyAuthorization);
            } //End block
            result.set("Proxy-Connection", "Keep-Alive");
            varB4EAC82CA7396A68D541C85D26508E83_584497742 = result;
            varB4EAC82CA7396A68D541C85D26508E83_584497742.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_584497742;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.470 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "7488BBB2CDE2EE3C2818153A74427BC8")
        @Override
        protected boolean requiresTunnel() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031182362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031182362;
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
}

