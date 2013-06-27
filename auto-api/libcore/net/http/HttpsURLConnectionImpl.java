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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.559 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private HttpUrlConnectionDelegate delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.560 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "D7761E6D33F0C47B987ABA4B6009A9B6")
    protected  HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.560 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "144D9F5811306E263A0B42085141274A")
    protected  HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.561 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "2FB3562C29D519DE9AC88893E4CD0ACC")
    private void checkConnected() {
        {
            boolean varBA474CA436F45D71B4740DB91291C434_1067997240 = (delegate.getSSLSocket() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection has not yet been established");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (delegate.getSSLSocket() == null) {
            //throw new IllegalStateException("Connection has not yet been established");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.562 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "315A2368329477259AA7FAF739E00E6C")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1495383927 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1495383927 = delegate.getHttpEngine();
        varB4EAC82CA7396A68D541C85D26508E83_1495383927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1495383927;
        // ---------- Original Method ----------
        //return delegate.getHttpEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.575 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "05265E7483C0E0E6A303AC767CD10B01")
    @Override
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_867303874 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_115855092 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_867303874 = cacheResponse.getCipherSuite();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_115855092 = delegate.getSSLSocket().getSession().getCipherSuite();
        String varA7E53CE21691AB073D9660D615818899_453266657; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_453266657 = varB4EAC82CA7396A68D541C85D26508E83_867303874;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_453266657 = varB4EAC82CA7396A68D541C85D26508E83_115855092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_453266657.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_453266657;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getCipherSuite();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.576 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "779CD9179377291B56FC0204789A646C")
    @Override
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1516722484 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1821687591 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getLocalCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_1516722484 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1821687591 = delegate.getSSLSocket().getSession().getLocalCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_1982674787; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1982674787 = varB4EAC82CA7396A68D541C85D26508E83_1516722484;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1982674787 = varB4EAC82CA7396A68D541C85D26508E83_1821687591;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1982674787.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1982674787;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getLocalCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.581 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "85C81D121ACAC316CA598124371C8A32")
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1901379001 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1761376456 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getServerCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_1901379001 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1761376456 = delegate.getSSLSocket().getSession().getPeerCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_720968147; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_720968147 = varB4EAC82CA7396A68D541C85D26508E83_1901379001;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_720968147 = varB4EAC82CA7396A68D541C85D26508E83_1761376456;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_720968147.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_720968147;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getServerCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.582 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "A585693ABE14378D526882605E02DCBB")
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_287922248 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_850454720 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_287922248 = cacheResponse.getPeerPrincipal();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_850454720 = delegate.getSSLSocket().getSession().getPeerPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_1886276890; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1886276890 = varB4EAC82CA7396A68D541C85D26508E83_287922248;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1886276890 = varB4EAC82CA7396A68D541C85D26508E83_850454720;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1886276890.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1886276890;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getPeerPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.582 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "01F8C563C920637DCC12CAF17525DF74")
    @Override
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1857192150 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_95285081 = null; //Variable for return #2
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1857192150 = cacheResponse.getLocalPrincipal();
        } //End block
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_95285081 = delegate.getSSLSocket().getSession().getLocalPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_989919186; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_989919186 = varB4EAC82CA7396A68D541C85D26508E83_1857192150;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_989919186 = varB4EAC82CA7396A68D541C85D26508E83_95285081;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_989919186.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_989919186;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getLocalPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.587 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    @Override
    public void disconnect() {
        delegate.disconnect();
        // ---------- Original Method ----------
        //delegate.disconnect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.588 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "1C090F0CAAEBA41F4286C02BEF108807")
    @Override
    public InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_952925805 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_952925805 = delegate.getErrorStream();
        varB4EAC82CA7396A68D541C85D26508E83_952925805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952925805;
        // ---------- Original Method ----------
        //return delegate.getErrorStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.589 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "8E24ED7FDE13B92925A7B168F99748D9")
    @Override
    public String getRequestMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1877242289 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1877242289 = delegate.getRequestMethod();
        varB4EAC82CA7396A68D541C85D26508E83_1877242289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877242289;
        // ---------- Original Method ----------
        //return delegate.getRequestMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.589 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "FDB64ECF63CE05448BD1F24DC27D3A56")
    @Override
    public int getResponseCode() throws IOException {
        int varDC834023D584CBF2E5DE9F65DB0FB932_533260926 = (delegate.getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375022812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375022812;
        // ---------- Original Method ----------
        //return delegate.getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.597 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "EA6DA7071E785ED4F7E2E57401034AFB")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_658915005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658915005 = delegate.getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_658915005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658915005;
        // ---------- Original Method ----------
        //return delegate.getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.598 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "96C31B8B5ED1067D8DDD87E968D455E8")
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        delegate.setRequestMethod(method);
        addTaint(method.getTaint());
        // ---------- Original Method ----------
        //delegate.setRequestMethod(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.598 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "4BFA18D8DC610C9ED74603F411542745")
    @Override
    public boolean usingProxy() {
        boolean var1A73319817A7BA58362FCE0126646E14_162058726 = (delegate.usingProxy());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676385969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676385969;
        // ---------- Original Method ----------
        //return delegate.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.599 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "50E0EA46B310FBF9F5955C8742C1D2FB")
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var36FEF060062CDCFFA52982B100EB3F06_1594432485 = (delegate.getInstanceFollowRedirects());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275964331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275964331;
        // ---------- Original Method ----------
        //return delegate.getInstanceFollowRedirects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.599 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "B749037A4CF115D9FF640C306F206053")
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        delegate.setInstanceFollowRedirects(followRedirects);
        addTaint(followRedirects);
        // ---------- Original Method ----------
        //delegate.setInstanceFollowRedirects(followRedirects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.599 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        // ---------- Original Method ----------
        //connected = true;
        //delegate.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.600 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "4B1A6683B8BAEF0A8DA5DF2EEA3E5C65")
    @Override
    public boolean getAllowUserInteraction() {
        boolean varD52A0AC310FCDDF8EC36D9E6668695A1_470721266 = (delegate.getAllowUserInteraction());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027350084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027350084;
        // ---------- Original Method ----------
        //return delegate.getAllowUserInteraction();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.600 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "031ED264E2A311524D3CE4B0F2589E4E")
    @Override
    public Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_224470669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_224470669 = delegate.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_224470669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224470669;
        // ---------- Original Method ----------
        //return delegate.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.610 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "18CC37A8140961BE14B8A34BEFFFE5BD")
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_850740187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_850740187 = delegate.getContent(types);
        addTaint(types[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_850740187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_850740187;
        // ---------- Original Method ----------
        //return delegate.getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.611 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "5F31AEA8313FDE46570A63F4659EA6C4")
    @Override
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1568640346 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568640346 = delegate.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_1568640346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568640346;
        // ---------- Original Method ----------
        //return delegate.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.611 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "6A4EFBC7F189462A08253067EE3FC54E")
    @Override
    public int getContentLength() {
        int var46C13ADE2970E578BB05FE5EEA0046DA_1667829855 = (delegate.getContentLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298916672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298916672;
        // ---------- Original Method ----------
        //return delegate.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.616 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "C0A534F9F915F346B6A238C3AB7E24BD")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_886091808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_886091808 = delegate.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_886091808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886091808;
        // ---------- Original Method ----------
        //return delegate.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.617 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "1D8E183AA17F605CA8F37CB145BC27E6")
    @Override
    public long getDate() {
        long var347DC365CBC90FBE87EE28BA84488696_1797755002 = (delegate.getDate());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1413738515 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1413738515;
        // ---------- Original Method ----------
        //return delegate.getDate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.617 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "85988E8AB71B350A11956E3873DD8A52")
    @Override
    public boolean getDefaultUseCaches() {
        boolean var3FC2C68637FBA6BB6F081C916459E56C_1208875134 = (delegate.getDefaultUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952747263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952747263;
        // ---------- Original Method ----------
        //return delegate.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.617 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "3738C5E14D27B80F6304703A3F689726")
    @Override
    public boolean getDoInput() {
        boolean var3AD6E1CD897116123B22123C5F9351D0_1696883468 = (delegate.getDoInput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_407316924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_407316924;
        // ---------- Original Method ----------
        //return delegate.getDoInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.618 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "3DED0FA0D24A4C513730DDD3229C6A1D")
    @Override
    public boolean getDoOutput() {
        boolean varBB2AB3EEC37F983793BE7F09AA948961_1816725150 = (delegate.getDoOutput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163945332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163945332;
        // ---------- Original Method ----------
        //return delegate.getDoOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.618 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "07D526D1F84F12E3AF74066BFB0CDBEA")
    @Override
    public long getExpiration() {
        long varC51716E5D8873132B8303EA472292149_1903243141 = (delegate.getExpiration());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1695964586 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1695964586;
        // ---------- Original Method ----------
        //return delegate.getExpiration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.623 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "A1558EE217DB2DED25D99BE4C5C5CBC5")
    @Override
    public String getHeaderField(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_68870994 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_68870994 = delegate.getHeaderField(pos);
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_68870994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_68870994;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.624 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "419444BCB6BB50E0BB569B92882A935F")
    @Override
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_2047576652 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2047576652 = delegate.getHeaderFields();
        varB4EAC82CA7396A68D541C85D26508E83_2047576652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047576652;
        // ---------- Original Method ----------
        //return delegate.getHeaderFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.624 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "EB177F71CAF5CB624490892533441DB4")
    @Override
    public Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_993452315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_993452315 = delegate.getRequestProperties();
        varB4EAC82CA7396A68D541C85D26508E83_993452315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_993452315;
        // ---------- Original Method ----------
        //return delegate.getRequestProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.628 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "5B496D640FDFED5ABDD99EF1524459C4")
    @Override
    public void addRequestProperty(String field, String newValue) {
        delegate.addRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //delegate.addRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.629 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "30616E1052FF590818FB33F8CB25A515")
    @Override
    public String getHeaderField(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_569962242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_569962242 = delegate.getHeaderField(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_569962242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_569962242;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.629 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "959C76F361B4536E7D8A96279C3B5D8C")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        long varF9B0FA24B3C89487E1F0C5C4DEFD1A6F_742927268 = (delegate.getHeaderFieldDate(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_575243514 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_575243514;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.630 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "4361490933E9F2FA962530445F81BF81")
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        int var9141D4C32956F8B7698AADB6AE35E322_1583199758 = (delegate.getHeaderFieldInt(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469152486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469152486;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldInt(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.630 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "CD8B677FD89B92A34E6DED1765786C5C")
    @Override
    public String getHeaderFieldKey(int posn) {
        String varB4EAC82CA7396A68D541C85D26508E83_2111369074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2111369074 = delegate.getHeaderFieldKey(posn);
        addTaint(posn);
        varB4EAC82CA7396A68D541C85D26508E83_2111369074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2111369074;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldKey(posn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.630 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "2C42A9C0E54839E5842FCF6C4BEEE0C8")
    @Override
    public long getIfModifiedSince() {
        long var2F648525489FF1333DA0B755237FF143_1442741994 = (delegate.getIfModifiedSince());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1047617960 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1047617960;
        // ---------- Original Method ----------
        //return delegate.getIfModifiedSince();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.631 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "7F691D460B63E943EDDF80A4EE39A14E")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1995304403 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1995304403 = delegate.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1995304403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1995304403;
        // ---------- Original Method ----------
        //return delegate.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.641 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "A6CABAC4572B4DA10A78AA0C530410F7")
    @Override
    public long getLastModified() {
        long var426E8D7A6E590ED1F9B47C7958BE51AD_1531882086 = (delegate.getLastModified());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2084567457 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2084567457;
        // ---------- Original Method ----------
        //return delegate.getLastModified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.642 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "0802B5A1BBBBB2E86919A360986EA4CD")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1060307497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1060307497 = delegate.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1060307497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1060307497;
        // ---------- Original Method ----------
        //return delegate.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.643 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "18E4597FEB6BF2787A17DDB632005226")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1648444235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1648444235 = delegate.getPermission();
        varB4EAC82CA7396A68D541C85D26508E83_1648444235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1648444235;
        // ---------- Original Method ----------
        //return delegate.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.643 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "25A05FAFA7081E7291666E6F8F2E1E3A")
    @Override
    public String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_1862965263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1862965263 = delegate.getRequestProperty(field);
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1862965263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1862965263;
        // ---------- Original Method ----------
        //return delegate.getRequestProperty(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.643 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "9123E0207E599BE103DC95A4EB9FD5F1")
    @Override
    public URL getURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1022012160 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1022012160 = delegate.getURL();
        varB4EAC82CA7396A68D541C85D26508E83_1022012160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1022012160;
        // ---------- Original Method ----------
        //return delegate.getURL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.644 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "D82C5E68D7BE86EC1C3E7932A98A529D")
    @Override
    public boolean getUseCaches() {
        boolean varF45B15791721B7C5A39E6EC8FCE0C874_1485370851 = (delegate.getUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276986803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276986803;
        // ---------- Original Method ----------
        //return delegate.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.644 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "02757753814864D79B417A4E5560E6EA")
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        delegate.setAllowUserInteraction(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setAllowUserInteraction(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.644 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "3C3C89655A3D6AECD88D33B37547EC97")
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        delegate.setDefaultUseCaches(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDefaultUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.648 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "DE7B6452AD8A3FE1A7045875984FE6A2")
    @Override
    public void setDoInput(boolean newValue) {
        delegate.setDoInput(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDoInput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.649 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "AA8A96B085C00AD18F5980AC73553873")
    @Override
    public void setDoOutput(boolean newValue) {
        delegate.setDoOutput(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setDoOutput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.649 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "D14199A3B941EEE74B5D2C6648A5F597")
    @Override
    public void setIfModifiedSince(long newValue) {
        delegate.setIfModifiedSince(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setIfModifiedSince(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.649 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "6B6D20991C7095A3C9F78228FC1B9636")
    @Override
    public void setRequestProperty(String field, String newValue) {
        delegate.setRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //delegate.setRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.653 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "927600B68A0BF85DC96C4DC0C7806FFD")
    @Override
    public void setUseCaches(boolean newValue) {
        delegate.setUseCaches(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //delegate.setUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.653 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "30ADD793C24680380480910105D6F638")
    @Override
    public void setConnectTimeout(int timeout) {
        delegate.setConnectTimeout(timeout);
        addTaint(timeout);
        // ---------- Original Method ----------
        //delegate.setConnectTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.654 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "4F1955E5CD8C8E4F82412D62674726A5")
    @Override
    public int getConnectTimeout() {
        int var44D58E8907D6B3B15AC45D93D9FF2214_827726623 = (delegate.getConnectTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141253653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141253653;
        // ---------- Original Method ----------
        //return delegate.getConnectTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.654 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "14E84308D3CFF1DBE96F7FF169D33305")
    @Override
    public void setReadTimeout(int timeout) {
        delegate.setReadTimeout(timeout);
        addTaint(timeout);
        // ---------- Original Method ----------
        //delegate.setReadTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.654 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "AFBF230BA088BA2C53EB47EF1B84A70D")
    @Override
    public int getReadTimeout() {
        int var6AA840C9DF82A442D7F21A3A02E813E8_2068440522 = (delegate.getReadTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006367107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006367107;
        // ---------- Original Method ----------
        //return delegate.getReadTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.658 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "FF24E070B4C0C3292A3F116EE32F1D74")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_492904103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_492904103 = delegate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_492904103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492904103;
        // ---------- Original Method ----------
        //return delegate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.659 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "509A3EF6AD1E19EC7C99267806699592")
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        delegate.setFixedLengthStreamingMode(contentLength);
        addTaint(contentLength);
        // ---------- Original Method ----------
        //delegate.setFixedLengthStreamingMode(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.659 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "B5561F2543E0B374874DFB2AF81D7456")
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        delegate.setChunkedStreamingMode(chunkLength);
        addTaint(chunkLength);
        // ---------- Original Method ----------
        //delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.660 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "50A8EEC8FB19EF703EB1D2AD125E34DD")
        private  HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            addTaint(url.getTaint());
            addTaint(port);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.660 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "E9B5447036109B1EF5921CBC009F2D5F")
        private  HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            addTaint(url.getTaint());
            addTaint(port);
            addTaint(proxy.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.663 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "3A3E1595EFC71C5830CC7FDB42350459")
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1628666260 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1628666260 = new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
            addTaint(method.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestBody.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1628666260.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1628666260;
            // ---------- Original Method ----------
            //return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    //HttpsURLConnectionImpl.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.663 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "645EA526C9BC5C289AB936DAA080EF1D")
        public SecureCacheResponse getCacheResponse() {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_1257060717 = null; //Variable for return #1
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_1257060717 = engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1257060717.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1257060717;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.664 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "A705B8A3D932D4951FEB0B7F9EB65416")
        public SSLSocket getSSLSocket() {
            SSLSocket varB4EAC82CA7396A68D541C85D26508E83_659337591 = null; //Variable for return #1
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_659337591 = engine != null ? engine.sslSocket : null;
            varB4EAC82CA7396A68D541C85D26508E83_659337591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_659337591;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.664 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.664 -0400", hash_original_field = "06B167584A75871D42FCD159D2218E9A", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")

        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.673 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "62C2DDAC8588DD301A50D31B54A2D261")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.675 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "E768B71DE2DEF9B011581097061E0CE2")
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
                    boolean var3AC4DFFE7CC4939DF7C4ED033B861EC8_1016355457 = (e instanceof SSLHandshakeException
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.676 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "A8A32E76D9538554B0FE5460CD7CEFCA")
        private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            {
                connection = openSocketConnection();
                {
                    boolean var8E696082C46988ED27CC92AF7EEC78DA_1469476465 = (connection.getAddress().getProxy() != null);
                    {
                        makeTunnel(policy, connection, getRequestHeaders());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            sslSocket = connection.getSecureSocketIfConnected();
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            addTaint(tlsTolerant);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210238584 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210238584;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "6ADCF122429AE987DCAA7662012EBD57")
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
                    Object varE3D66A7026D8BFDE15E135A9F3AF9D8C_1786605256 = (connect.getResponseCode());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "6634C856F615987829A7331DE421BFC3")
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            addTaint(cacheResponse.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620190750 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_620190750;
            // ---------- Original Method ----------
            //return cacheResponse instanceof SecureCacheResponse;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "8ABD9C186913727D303E7C5FD5826ADD")
        @Override
        protected boolean includeAuthorityInRequestLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544239870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_544239870;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.682 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "0EDF241F28CEF050E7B1C6D89C853D5A")
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
            HttpURLConnection varB4EAC82CA7396A68D541C85D26508E83_254133118 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_254133118 = enclosing;
            varB4EAC82CA7396A68D541C85D26508E83_254133118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_254133118;
            // ---------- Original Method ----------
            //return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.682 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "FC467743B88D50776BC092FFC979445E")
        public  ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            addTaint(policy.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.689 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "AC6D862D9E3D629E15A8AFE5613D0E6C")
        @Override
        protected RawHeaders getNetworkRequestHeaders() throws IOException {
            RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1685824802 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1685824802 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1685824802.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1685824802;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.689 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "65F4EEEFE07E9216EBCF5EE932A6302A")
        @Override
        protected boolean requiresTunnel() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205821541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_205821541;
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
}

