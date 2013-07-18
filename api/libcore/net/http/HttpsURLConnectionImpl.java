package libcore.net.http;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class HttpsURLConnectionImpl extends HttpsURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.662 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private HttpUrlConnectionDelegate delegate;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "D7761E6D33F0C47B987ABA4B6009A9B6")
    protected  HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "144D9F5811306E263A0B42085141274A")
    protected  HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "50768619EE7BFAB9EEDED75DBDA4A919")
    private void checkConnected() {
        if(delegate.getSSLSocket() == null)        
        {
            IllegalStateException var15BD4ED1553200CD61F89C1384557187_482495129 = new IllegalStateException("Connection has not yet been established");
            var15BD4ED1553200CD61F89C1384557187_482495129.addTaint(taint);
            throw var15BD4ED1553200CD61F89C1384557187_482495129;
        } //End block
        // ---------- Original Method ----------
        //if (delegate.getSSLSocket() == null) {
            //throw new IllegalStateException("Connection has not yet been established");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "370FDDF4873F8A64C159391D4E945BCF")
     HttpEngine getHttpEngine() {
HttpEngine var5CD64BD690D2577CE94E8102D15C6561_376124481 =         delegate.getHttpEngine();
        var5CD64BD690D2577CE94E8102D15C6561_376124481.addTaint(taint);
        return var5CD64BD690D2577CE94E8102D15C6561_376124481;
        // ---------- Original Method ----------
        //return delegate.getHttpEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "247F8B9D226196E1D0D56CA33926E5DC")
    @Override
    public String getCipherSuite() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if(cacheResponse != null)        
        {
String varD170258215FF6D9267D56D2781A7DBDB_1170806771 =             cacheResponse.getCipherSuite();
            varD170258215FF6D9267D56D2781A7DBDB_1170806771.addTaint(taint);
            return varD170258215FF6D9267D56D2781A7DBDB_1170806771;
        } //End block
        checkConnected();
String var52FCE36BC7E272B55975F5AF507AD756_1368521303 =         delegate.getSSLSocket().getSession().getCipherSuite();
        var52FCE36BC7E272B55975F5AF507AD756_1368521303.addTaint(taint);
        return var52FCE36BC7E272B55975F5AF507AD756_1368521303;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getCipherSuite();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "C4DB1FBB3F8F58852751F4C2BB39FAB5")
    @Override
    public Certificate[] getLocalCertificates() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if(cacheResponse != null)        
        {
            List<Certificate> result = cacheResponse.getLocalCertificateChain();
Certificate[] varBEB34A057EF0EE8AF2FA47A1BE5B462E_182432921 =             result != null ? result.toArray(new Certificate[result.size()]) : null;
            varBEB34A057EF0EE8AF2FA47A1BE5B462E_182432921.addTaint(taint);
            return varBEB34A057EF0EE8AF2FA47A1BE5B462E_182432921;
        } //End block
        checkConnected();
Certificate[] var9DD6B250543350D4F6E891FC013D3BEB_1911800604 =         delegate.getSSLSocket().getSession().getLocalCertificates();
        var9DD6B250543350D4F6E891FC013D3BEB_1911800604.addTaint(taint);
        return var9DD6B250543350D4F6E891FC013D3BEB_1911800604;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getLocalCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.663 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "CC8896637B5873D8AFB37B5CB5D8269F")
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if(cacheResponse != null)        
        {
            List<Certificate> result = cacheResponse.getServerCertificateChain();
Certificate[] varBEB34A057EF0EE8AF2FA47A1BE5B462E_785792920 =             result != null ? result.toArray(new Certificate[result.size()]) : null;
            varBEB34A057EF0EE8AF2FA47A1BE5B462E_785792920.addTaint(taint);
            return varBEB34A057EF0EE8AF2FA47A1BE5B462E_785792920;
        } //End block
        checkConnected();
Certificate[] varA1D7D0A6F1C91A08E144F0BCE43E239A_1497354277 =         delegate.getSSLSocket().getSession().getPeerCertificates();
        varA1D7D0A6F1C91A08E144F0BCE43E239A_1497354277.addTaint(taint);
        return varA1D7D0A6F1C91A08E144F0BCE43E239A_1497354277;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getServerCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "4C2564F011210BC5330D3E8191EBD250")
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if(cacheResponse != null)        
        {
Principal varE70C333A965EC3A0844C95B85B550A04_809205434 =             cacheResponse.getPeerPrincipal();
            varE70C333A965EC3A0844C95B85B550A04_809205434.addTaint(taint);
            return varE70C333A965EC3A0844C95B85B550A04_809205434;
        } //End block
        checkConnected();
Principal varADD7E9248C8B4B98A4D11772C247866A_609540588 =         delegate.getSSLSocket().getSession().getPeerPrincipal();
        varADD7E9248C8B4B98A4D11772C247866A_609540588.addTaint(taint);
        return varADD7E9248C8B4B98A4D11772C247866A_609540588;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getPeerPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "EC5F642A19184F50C3AAD55A888CF0D3")
    @Override
    public Principal getLocalPrincipal() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if(cacheResponse != null)        
        {
Principal var8C9FE9111A2FA390D5E95699E7665D9E_1402504366 =             cacheResponse.getLocalPrincipal();
            var8C9FE9111A2FA390D5E95699E7665D9E_1402504366.addTaint(taint);
            return var8C9FE9111A2FA390D5E95699E7665D9E_1402504366;
        } //End block
        checkConnected();
Principal var9BBD49A1A800D7EACFCFD295CACCAB2E_571942463 =         delegate.getSSLSocket().getSession().getLocalPrincipal();
        var9BBD49A1A800D7EACFCFD295CACCAB2E_571942463.addTaint(taint);
        return var9BBD49A1A800D7EACFCFD295CACCAB2E_571942463;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getLocalPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    @Override
    public void disconnect() {
        delegate.disconnect();
        // ---------- Original Method ----------
        //delegate.disconnect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "134D031E74B6DADF7E41FF9E0AE0E8C0")
    @Override
    public InputStream getErrorStream() {
InputStream var5AB11938BFB3E389F92E9DF02927F1E9_532038668 =         delegate.getErrorStream();
        var5AB11938BFB3E389F92E9DF02927F1E9_532038668.addTaint(taint);
        return var5AB11938BFB3E389F92E9DF02927F1E9_532038668;
        // ---------- Original Method ----------
        //return delegate.getErrorStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "E13F7BAA16C3D797436947CC8B12E19C")
    @Override
    public String getRequestMethod() {
String var4B40D7919A015205E6BF3BD275D540D6_1065296077 =         delegate.getRequestMethod();
        var4B40D7919A015205E6BF3BD275D540D6_1065296077.addTaint(taint);
        return var4B40D7919A015205E6BF3BD275D540D6_1065296077;
        // ---------- Original Method ----------
        //return delegate.getRequestMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "E01F0168ACE0B880F839AE47EF9D8ABA")
    @Override
    public int getResponseCode() throws IOException {
        int var531F74661189AF5AFF20B5DF99C3C0B4_732907809 = (delegate.getResponseCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776627184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776627184;
        // ---------- Original Method ----------
        //return delegate.getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "1E56625D9D2900843C853BB2639E77AE")
    @Override
    public String getResponseMessage() throws IOException {
String varEC7678C2C582B4839D528E15495632E0_1355289308 =         delegate.getResponseMessage();
        varEC7678C2C582B4839D528E15495632E0_1355289308.addTaint(taint);
        return varEC7678C2C582B4839D528E15495632E0_1355289308;
        // ---------- Original Method ----------
        //return delegate.getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "4663E1463DF24180675F0663D05FD05F")
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        addTaint(method.getTaint());
        delegate.setRequestMethod(method);
        // ---------- Original Method ----------
        //delegate.setRequestMethod(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.664 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "F50F95811DD9F5056399552F8639835B")
    @Override
    public boolean usingProxy() {
        boolean varCC52A8AE80AB6FF3ABDD1F5E6E00DC59_367967137 = (delegate.usingProxy());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779239656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779239656;
        // ---------- Original Method ----------
        //return delegate.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "1BE4E93A1FD312D48642AA130E6B006E")
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var80ECDB430EC8842E1416E2354ADCF1C7_44775797 = (delegate.getInstanceFollowRedirects());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498014386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498014386;
        // ---------- Original Method ----------
        //return delegate.getInstanceFollowRedirects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "16C35FB186E347ABFFEBF670418559DE")
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        addTaint(followRedirects);
        delegate.setInstanceFollowRedirects(followRedirects);
        // ---------- Original Method ----------
        //delegate.setInstanceFollowRedirects(followRedirects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        // ---------- Original Method ----------
        //connected = true;
        //delegate.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "91F5EFACAB6573D977C349D7D05DB872")
    @Override
    public boolean getAllowUserInteraction() {
        boolean var90527CE6B6B410FBA7CA923B07A1CED7_858123073 = (delegate.getAllowUserInteraction());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890268193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890268193;
        // ---------- Original Method ----------
        //return delegate.getAllowUserInteraction();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "9A5D549CCA3ABC2FEBE88A72421285B6")
    @Override
    public Object getContent() throws IOException {
Object var0992CCA47F11BC3F186C1A663FDE84C9_1476269884 =         delegate.getContent();
        var0992CCA47F11BC3F186C1A663FDE84C9_1476269884.addTaint(taint);
        return var0992CCA47F11BC3F186C1A663FDE84C9_1476269884;
        // ---------- Original Method ----------
        //return delegate.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "9D791EECA2B69EE332BBA57E6EB8084E")
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        addTaint(types[0].getTaint());
Object var160AB04DD32D12114A6D7364B391005D_1476264063 =         delegate.getContent(types);
        var160AB04DD32D12114A6D7364B391005D_1476264063.addTaint(taint);
        return var160AB04DD32D12114A6D7364B391005D_1476264063;
        // ---------- Original Method ----------
        //return delegate.getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "97204DDBDAD5090B614DC96C7C75F990")
    @Override
    public String getContentEncoding() {
String var4D847C56D41E90F7625C8163629E6425_1308790 =         delegate.getContentEncoding();
        var4D847C56D41E90F7625C8163629E6425_1308790.addTaint(taint);
        return var4D847C56D41E90F7625C8163629E6425_1308790;
        // ---------- Original Method ----------
        //return delegate.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "304AFB24E9DD2886C593B5B031222193")
    @Override
    public int getContentLength() {
        int var32E363B557C5100C9A92D76CE2537A6C_761382056 = (delegate.getContentLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120473143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120473143;
        // ---------- Original Method ----------
        //return delegate.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "0AD602D01A8BC3219E8BA206616917C2")
    @Override
    public String getContentType() {
String var9793E879B8A646DB233A9A2D2C3C2DCD_1452433751 =         delegate.getContentType();
        var9793E879B8A646DB233A9A2D2C3C2DCD_1452433751.addTaint(taint);
        return var9793E879B8A646DB233A9A2D2C3C2DCD_1452433751;
        // ---------- Original Method ----------
        //return delegate.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "6F49E66C7846F00149A03A7B9E43DBFC")
    @Override
    public long getDate() {
        long var5783C187D54DD7D1F02B1A7E44A80A9C_884071799 = (delegate.getDate());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2108425719 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2108425719;
        // ---------- Original Method ----------
        //return delegate.getDate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.665 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "C40A23A1C83E0410B8D8FBE767E0E1C2")
    @Override
    public boolean getDefaultUseCaches() {
        boolean varFCAFADA83FDE4F1151E28AD5EB620CE5_25535156 = (delegate.getDefaultUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250361604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250361604;
        // ---------- Original Method ----------
        //return delegate.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "3B3582ADAE9DC67F221C5359DF23DA61")
    @Override
    public boolean getDoInput() {
        boolean varC64E8413CAD00A74B9A1A22BCB9473DE_522874145 = (delegate.getDoInput());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106223261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106223261;
        // ---------- Original Method ----------
        //return delegate.getDoInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "20BA65F83967FE4741735F13C97E1B0A")
    @Override
    public boolean getDoOutput() {
        boolean var36BA7361DCD3D8FFB46C88801AEE5F69_1596880177 = (delegate.getDoOutput());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154535222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154535222;
        // ---------- Original Method ----------
        //return delegate.getDoOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "E87F1A39F6C0245A40EFA300AFC860A8")
    @Override
    public long getExpiration() {
        long var258782E2CB76F187891942F0C2B4615F_1957425112 = (delegate.getExpiration());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_950542670 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_950542670;
        // ---------- Original Method ----------
        //return delegate.getExpiration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "7A05A577FD340D2B8678A36E2814DC32")
    @Override
    public String getHeaderField(int pos) {
        addTaint(pos);
String varF19BCDF155D022F8720610E5AEAC66E8_1414109404 =         delegate.getHeaderField(pos);
        varF19BCDF155D022F8720610E5AEAC66E8_1414109404.addTaint(taint);
        return varF19BCDF155D022F8720610E5AEAC66E8_1414109404;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "0E0F2A717AC6E5AB84B3947528B1E355")
    @Override
    public Map<String, List<String>> getHeaderFields() {
Map<String, List<String>> var49173AD3D4E88D7DE53074EE6C4D3AB6_716578040 =         delegate.getHeaderFields();
        var49173AD3D4E88D7DE53074EE6C4D3AB6_716578040.addTaint(taint);
        return var49173AD3D4E88D7DE53074EE6C4D3AB6_716578040;
        // ---------- Original Method ----------
        //return delegate.getHeaderFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "4F82B60C618E92C437628F7969D41BFB")
    @Override
    public Map<String, List<String>> getRequestProperties() {
Map<String, List<String>> varA0D8910F76C36E1A3A9A27D8CEF0597C_561607607 =         delegate.getRequestProperties();
        varA0D8910F76C36E1A3A9A27D8CEF0597C_561607607.addTaint(taint);
        return varA0D8910F76C36E1A3A9A27D8CEF0597C_561607607;
        // ---------- Original Method ----------
        //return delegate.getRequestProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "0EC78A514E5A0D295D4B97102FDD2F3A")
    @Override
    public void addRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        delegate.addRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.addRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "3776914F4BE7BA405EFA404295F82414")
    @Override
    public String getHeaderField(String key) {
        addTaint(key.getTaint());
String var6EFB1FDEC2E277B17FC4A3A691801850_1954996817 =         delegate.getHeaderField(key);
        var6EFB1FDEC2E277B17FC4A3A691801850_1954996817.addTaint(taint);
        return var6EFB1FDEC2E277B17FC4A3A691801850_1954996817;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "94ABAE8B6A04736A40124046845D57E2")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        long var9B3FC141DB375FFC8ADDAC9A707CA59C_1434781590 = (delegate.getHeaderFieldDate(field, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1622160087 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1622160087;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "F22F65F292681C505DFB394DB6984693")
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        int var3A74F19990997CCFF1E1FC856690ACF3_1074141629 = (delegate.getHeaderFieldInt(field, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710126570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710126570;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldInt(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.666 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "EA0E4A8032B21E4EB36A1B3B6BD5FCE5")
    @Override
    public String getHeaderFieldKey(int posn) {
        addTaint(posn);
String varE2E936A2C1D394E0A178CF43FBC4AF39_627050559 =         delegate.getHeaderFieldKey(posn);
        varE2E936A2C1D394E0A178CF43FBC4AF39_627050559.addTaint(taint);
        return varE2E936A2C1D394E0A178CF43FBC4AF39_627050559;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldKey(posn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "1B733E6A576C1267B7BF53477B3EDF47")
    @Override
    public long getIfModifiedSince() {
        long varCB50B494905E172FEEBE9EAEC7926627_836604362 = (delegate.getIfModifiedSince());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1451630830 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1451630830;
        // ---------- Original Method ----------
        //return delegate.getIfModifiedSince();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "8820E277F996B001ABFDCC6090726BF8")
    @Override
    public InputStream getInputStream() throws IOException {
InputStream varA6057298161142AA94562760706596B6_768844120 =         delegate.getInputStream();
        varA6057298161142AA94562760706596B6_768844120.addTaint(taint);
        return varA6057298161142AA94562760706596B6_768844120;
        // ---------- Original Method ----------
        //return delegate.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "ACD0CC3151ACBD3B5945638A59E1E53B")
    @Override
    public long getLastModified() {
        long var747A7E792089C9DFB807A2FF78E9D6CC_1977689427 = (delegate.getLastModified());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_440396464 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_440396464;
        // ---------- Original Method ----------
        //return delegate.getLastModified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "9B2979DD5822846F333068CCB50034B7")
    @Override
    public OutputStream getOutputStream() throws IOException {
OutputStream var26E4766CFD76703CF0EDA62B428D31E2_799785701 =         delegate.getOutputStream();
        var26E4766CFD76703CF0EDA62B428D31E2_799785701.addTaint(taint);
        return var26E4766CFD76703CF0EDA62B428D31E2_799785701;
        // ---------- Original Method ----------
        //return delegate.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "F867C7649700A3C3ED1F5E06B1DB9D8B")
    @Override
    public Permission getPermission() throws IOException {
Permission varC4E07256C0BCF81F626D018B0F5CAC90_1480763354 =         delegate.getPermission();
        varC4E07256C0BCF81F626D018B0F5CAC90_1480763354.addTaint(taint);
        return varC4E07256C0BCF81F626D018B0F5CAC90_1480763354;
        // ---------- Original Method ----------
        //return delegate.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "97FD4172DACE6ADC91688E18DECFB541")
    @Override
    public String getRequestProperty(String field) {
        addTaint(field.getTaint());
String varAC7E243492D4A6C3C9AB4C6997F244B1_310268801 =         delegate.getRequestProperty(field);
        varAC7E243492D4A6C3C9AB4C6997F244B1_310268801.addTaint(taint);
        return varAC7E243492D4A6C3C9AB4C6997F244B1_310268801;
        // ---------- Original Method ----------
        //return delegate.getRequestProperty(field);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "F84415658B5161CC0CFD8A12498508D7")
    @Override
    public URL getURL() {
URL var6884EDA0C600EABAFFD2E6B72828DBC6_2007265676 =         delegate.getURL();
        var6884EDA0C600EABAFFD2E6B72828DBC6_2007265676.addTaint(taint);
        return var6884EDA0C600EABAFFD2E6B72828DBC6_2007265676;
        // ---------- Original Method ----------
        //return delegate.getURL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "3A4F2872FEFBD17EB4C08F834365E637")
    @Override
    public boolean getUseCaches() {
        boolean varCC47F02C2E479DDEB8BA085BFD4C608F_349900993 = (delegate.getUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370571004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370571004;
        // ---------- Original Method ----------
        //return delegate.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "F86CF2295E0B05DCE36CC01C0EB303BD")
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        addTaint(newValue);
        delegate.setAllowUserInteraction(newValue);
        // ---------- Original Method ----------
        //delegate.setAllowUserInteraction(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.667 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "1BED3828A1A4BFF538D63AF58852AF3D")
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        addTaint(newValue);
        delegate.setDefaultUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setDefaultUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "B4B551A035BECA88C62FCED886B89488")
    @Override
    public void setDoInput(boolean newValue) {
        addTaint(newValue);
        delegate.setDoInput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoInput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "31C3442A572DE14351BDF9B8284C9503")
    @Override
    public void setDoOutput(boolean newValue) {
        addTaint(newValue);
        delegate.setDoOutput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoOutput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "23FE48642099C8956B35E282CEAFDCCE")
    @Override
    public void setIfModifiedSince(long newValue) {
        addTaint(newValue);
        delegate.setIfModifiedSince(newValue);
        // ---------- Original Method ----------
        //delegate.setIfModifiedSince(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "665FBB5FBF32CAE23159A45BB916EC6A")
    @Override
    public void setRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        delegate.setRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.setRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "D03D792D95DC066EFABCCDD79763828B")
    @Override
    public void setUseCaches(boolean newValue) {
        addTaint(newValue);
        delegate.setUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "AF9704001C0801A1F335045DA3E2EB63")
    @Override
    public void setConnectTimeout(int timeout) {
        addTaint(timeout);
        delegate.setConnectTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setConnectTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "1E4D5782B0717EDDAC85A9C657C86E41")
    @Override
    public int getConnectTimeout() {
        int var3B7820C4F8E3B01C6BC70059CAC3E436_2039330234 = (delegate.getConnectTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638450536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638450536;
        // ---------- Original Method ----------
        //return delegate.getConnectTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "021134BB2C3F24A8353501B2C1800E80")
    @Override
    public void setReadTimeout(int timeout) {
        addTaint(timeout);
        delegate.setReadTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setReadTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "2C98BC8B6F6187E15B75FECB13841456")
    @Override
    public int getReadTimeout() {
        int varAEF03DF43E1FA12D30CFE1F6E089D09C_400628478 = (delegate.getReadTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101040738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101040738;
        // ---------- Original Method ----------
        //return delegate.getReadTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.668 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "A17C252BCAF4FE60A3382DA9B6A2A0B0")
    @Override
    public String toString() {
String varFB90DA94A5E41D35E9CAB1F945B07348_837841878 =         delegate.toString();
        varFB90DA94A5E41D35E9CAB1F945B07348_837841878.addTaint(taint);
        return varFB90DA94A5E41D35E9CAB1F945B07348_837841878;
        // ---------- Original Method ----------
        //return delegate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "5BD4FB4CA8A5611C7CD5D3FC2CBC9EB9")
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        addTaint(contentLength);
        delegate.setFixedLengthStreamingMode(contentLength);
        // ---------- Original Method ----------
        //delegate.setFixedLengthStreamingMode(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "FED5A2F7728D12ACB987DEE94BE7F2B6")
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        addTaint(chunkLength);
        delegate.setChunkedStreamingMode(chunkLength);
        // ---------- Original Method ----------
        //delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "EFDF6B2A40127A321E3579EA2108DB76")
        private  HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            addTaint(port);
            addTaint(url.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "25137BDC92BB1379AA29210558B26D50")
        private  HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            addTaint(proxy.getTaint());
            addTaint(port);
            addTaint(url.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "4B3BDCD9AAA160D2B82B58F696B1F5FE")
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            addTaint(requestBody.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(method.getTaint());
HttpEngine var4275551A0E87ACEAEFB678DB8BB37064_1421086091 =             new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
            var4275551A0E87ACEAEFB678DB8BB37064_1421086091.addTaint(taint);
            return var4275551A0E87ACEAEFB678DB8BB37064_1421086091;
            // ---------- Original Method ----------
            //return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    //HttpsURLConnectionImpl.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "1BE8A6FB8C3DA58064D5F39A942A06DB")
        public SecureCacheResponse getCacheResponse() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
SecureCacheResponse var871EF139AE570FACE37934F5F72D643E_1636559754 =             engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
            var871EF139AE570FACE37934F5F72D643E_1636559754.addTaint(taint);
            return var871EF139AE570FACE37934F5F72D643E_1636559754;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "780A01AD2B91EC65C5BFE0A9DD518B15")
        public SSLSocket getSSLSocket() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
SSLSocket var61F4735CFEE1975FCF23B8A439E04FDA_625926625 =             engine != null ? engine.sslSocket : null;
            var61F4735CFEE1975FCF23B8A439E04FDA_625926625.addTaint(taint);
            return var61F4735CFEE1975FCF23B8A439E04FDA_625926625;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.669 -0400", hash_original_field = "06B167584A75871D42FCD159D2218E9A", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")

        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.670 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "3EB6C03FB9BC660C5BD5D375629BD073")
        private  HttpsEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody,
                HttpsURLConnectionImpl enclosing) throws IOException {
            super(policy, method, requestHeaders, connection, requestBody);
            addTaint(requestBody.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(method.getTaint());
            addTaint(policy.getTaint());
            this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            this.enclosing = enclosing;
            // ---------- Original Method ----------
            //this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            //this.enclosing = enclosing;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.670 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "1955C779F5B503BE888A4BF4EB52E6F7")
        @Override
        protected void connect() throws IOException {
            boolean connectionReused;
            try 
            {
                connectionReused = makeSslConnection(true);
            } //End block
            catch (IOException e)
            {
                if(e instanceof SSLHandshakeException
                        && e.getCause() instanceof CertificateException)                
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                release(false);
                connectionReused = makeSslConnection(false);
            } //End block
            if(!connectionReused)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.670 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "2F1AC5C38A329FD7F9D6B049407B29F1")
        private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            addTaint(tlsTolerant);
            if(connection == null)            
            {
                connection = openSocketConnection();
                if(connection.getAddress().getProxy() != null)                
                {
                    makeTunnel(policy, connection, getRequestHeaders());
                } //End block
            } //End block
            sslSocket = connection.getSecureSocketIfConnected();
            if(sslSocket != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_410324361 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140335317 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140335317;
            } //End block
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            boolean var68934A3E9455FA72420237EB05902327_1110401212 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222713647 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222713647;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.671 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "9910D6508A92EF0E71596B2849314DE5")
        private void makeTunnel(HttpURLConnectionImpl policy, HttpConnection connection,
                RequestHeaders requestHeaders) throws IOException {
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            addTaint(policy.getTaint());
            RawHeaders rawRequestHeaders = requestHeaders.getHeaders();
            while
(true)            
            {
                HttpEngine connect = new ProxyConnectEngine(policy, rawRequestHeaders, connection);
                connect.sendRequest();
                connect.readResponse();
                int responseCode = connect.getResponseCode();
switch(connect.getResponseCode()){
                case HTTP_OK:
                return;
                case HTTP_PROXY_AUTH:
                rawRequestHeaders = new RawHeaders(rawRequestHeaders);
                boolean credentialsFound = policy.processAuthHeader(HTTP_PROXY_AUTH,
                            connect.getResponseHeaders(), rawRequestHeaders);
                if(credentialsFound)                
                {
                    continue;
                } //End block
                else
                {
                    IOException varA7405ABC79D717A768C069FC31724F97_1486507871 = new IOException("Failed to authenticate with proxy");
                    varA7405ABC79D717A768C069FC31724F97_1486507871.addTaint(taint);
                    throw varA7405ABC79D717A768C069FC31724F97_1486507871;
                } //End block
                default:
                IOException var5E23AB435FF46F926F17D0788C01696D_361764913 = new IOException("Unexpected response code for CONNECT: " + responseCode);
                var5E23AB435FF46F926F17D0788C01696D_361764913.addTaint(taint);
                throw var5E23AB435FF46F926F17D0788C01696D_361764913;
}
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.671 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "61D6254D1FD0E0E1E57FE9A4AD32C4FD")
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            addTaint(cacheResponse.getTaint());
            boolean var01C10E608C22923A812E7933E0DF2253_267215160 = (cacheResponse instanceof SecureCacheResponse);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666756725 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_666756725;
            // ---------- Original Method ----------
            //return cacheResponse instanceof SecureCacheResponse;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.671 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "8C9632417B1950DFE02AEB0400589402")
        @Override
        protected boolean includeAuthorityInRequestLine() {
            boolean var68934A3E9455FA72420237EB05902327_1715784761 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151472279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151472279;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.671 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "2ED63F987073FBBC5072CFFFD22F49E6")
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
HttpURLConnection varBC9F2915706BB2F8D72691CF4F26214A_97994180 =             enclosing;
            varBC9F2915706BB2F8D72691CF4F26214A_97994180.addTaint(taint);
            return varBC9F2915706BB2F8D72691CF4F26214A_97994180;
            // ---------- Original Method ----------
            //return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.671 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "0DCDD93F96A82B14AE0DF07AD2329C37")
        public  ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(policy.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.672 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "4DF1940E0C8093228D70E5F2BDFA70DB")
        @Override
        protected RawHeaders getNetworkRequestHeaders() throws IOException {
            RequestHeaders privateHeaders = getRequestHeaders();
            URL url = policy.getURL();
            RawHeaders result = new RawHeaders();
            result.setStatusLine("CONNECT " + url.getHost() + ":" + url.getEffectivePort()
                    + " HTTP/1.1");
            String host = privateHeaders.getHost();
            if(host == null)            
            {
                host = getOriginAddress(url);
            } //End block
            result.set("Host", host);
            String userAgent = privateHeaders.getUserAgent();
            if(userAgent == null)            
            {
                userAgent = getDefaultUserAgent();
            } //End block
            result.set("User-Agent", userAgent);
            String proxyAuthorization = privateHeaders.getProxyAuthorization();
            if(proxyAuthorization != null)            
            {
                result.set("Proxy-Authorization", proxyAuthorization);
            } //End block
            result.set("Proxy-Connection", "Keep-Alive");
RawHeaders varDC838461EE2FA0CA4C9BBB70A15456B0_462551249 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_462551249.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_462551249;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.672 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "716186824AC70D7337AE54D89847F1B6")
        @Override
        protected boolean requiresTunnel() {
            boolean varB326B5062B2F0E69046810717534CB09_1643038648 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265599588 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_265599588;
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
}

