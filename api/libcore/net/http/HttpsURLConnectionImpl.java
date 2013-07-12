package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.517 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private HttpUrlConnectionDelegate delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.517 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "D7761E6D33F0C47B987ABA4B6009A9B6")
    protected  HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.518 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "144D9F5811306E263A0B42085141274A")
    protected  HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.518 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "02B2B6DA64447F1781541E994695B61B")
    private void checkConnected() {
    if(delegate.getSSLSocket() == null)        
        {
            IllegalStateException var15BD4ED1553200CD61F89C1384557187_341624129 = new IllegalStateException("Connection has not yet been established");
            var15BD4ED1553200CD61F89C1384557187_341624129.addTaint(taint);
            throw var15BD4ED1553200CD61F89C1384557187_341624129;
        } //End block
        // ---------- Original Method ----------
        //if (delegate.getSSLSocket() == null) {
            //throw new IllegalStateException("Connection has not yet been established");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.518 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "4D300E33C92E81668377D722889985A3")
     HttpEngine getHttpEngine() {
HttpEngine var5CD64BD690D2577CE94E8102D15C6561_998359316 =         delegate.getHttpEngine();
        var5CD64BD690D2577CE94E8102D15C6561_998359316.addTaint(taint);
        return var5CD64BD690D2577CE94E8102D15C6561_998359316;
        // ---------- Original Method ----------
        //return delegate.getHttpEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.519 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "CF120D8937C0F4209A837DDC431701F3")
    @Override
    public String getCipherSuite() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
    if(cacheResponse != null)        
        {
String varD170258215FF6D9267D56D2781A7DBDB_392595260 =             cacheResponse.getCipherSuite();
            varD170258215FF6D9267D56D2781A7DBDB_392595260.addTaint(taint);
            return varD170258215FF6D9267D56D2781A7DBDB_392595260;
        } //End block
        checkConnected();
String var52FCE36BC7E272B55975F5AF507AD756_828844385 =         delegate.getSSLSocket().getSession().getCipherSuite();
        var52FCE36BC7E272B55975F5AF507AD756_828844385.addTaint(taint);
        return var52FCE36BC7E272B55975F5AF507AD756_828844385;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getCipherSuite();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.519 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "685AF22F75A52DFEACBF6983ACF8DEF1")
    @Override
    public Certificate[] getLocalCertificates() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
    if(cacheResponse != null)        
        {
            List<Certificate> result = cacheResponse.getLocalCertificateChain();
Certificate[] varBEB34A057EF0EE8AF2FA47A1BE5B462E_1812214850 =             result != null ? result.toArray(new Certificate[result.size()]) : null;
            varBEB34A057EF0EE8AF2FA47A1BE5B462E_1812214850.addTaint(taint);
            return varBEB34A057EF0EE8AF2FA47A1BE5B462E_1812214850;
        } //End block
        checkConnected();
Certificate[] var9DD6B250543350D4F6E891FC013D3BEB_1341386002 =         delegate.getSSLSocket().getSession().getLocalCertificates();
        var9DD6B250543350D4F6E891FC013D3BEB_1341386002.addTaint(taint);
        return var9DD6B250543350D4F6E891FC013D3BEB_1341386002;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getLocalCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.520 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "C97D568B0554B62D4FC1402931273216")
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
    if(cacheResponse != null)        
        {
            List<Certificate> result = cacheResponse.getServerCertificateChain();
Certificate[] varBEB34A057EF0EE8AF2FA47A1BE5B462E_2000703149 =             result != null ? result.toArray(new Certificate[result.size()]) : null;
            varBEB34A057EF0EE8AF2FA47A1BE5B462E_2000703149.addTaint(taint);
            return varBEB34A057EF0EE8AF2FA47A1BE5B462E_2000703149;
        } //End block
        checkConnected();
Certificate[] varA1D7D0A6F1C91A08E144F0BCE43E239A_1662034844 =         delegate.getSSLSocket().getSession().getPeerCertificates();
        varA1D7D0A6F1C91A08E144F0BCE43E239A_1662034844.addTaint(taint);
        return varA1D7D0A6F1C91A08E144F0BCE43E239A_1662034844;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getServerCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.520 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "089897E76E20B7FB007DAAEEECE2B611")
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
    if(cacheResponse != null)        
        {
Principal varE70C333A965EC3A0844C95B85B550A04_401409314 =             cacheResponse.getPeerPrincipal();
            varE70C333A965EC3A0844C95B85B550A04_401409314.addTaint(taint);
            return varE70C333A965EC3A0844C95B85B550A04_401409314;
        } //End block
        checkConnected();
Principal varADD7E9248C8B4B98A4D11772C247866A_736005515 =         delegate.getSSLSocket().getSession().getPeerPrincipal();
        varADD7E9248C8B4B98A4D11772C247866A_736005515.addTaint(taint);
        return varADD7E9248C8B4B98A4D11772C247866A_736005515;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getPeerPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.521 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "016B6111EDBFC70BD8AEC08D435CCEB6")
    @Override
    public Principal getLocalPrincipal() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
    if(cacheResponse != null)        
        {
Principal var8C9FE9111A2FA390D5E95699E7665D9E_449009394 =             cacheResponse.getLocalPrincipal();
            var8C9FE9111A2FA390D5E95699E7665D9E_449009394.addTaint(taint);
            return var8C9FE9111A2FA390D5E95699E7665D9E_449009394;
        } //End block
        checkConnected();
Principal var9BBD49A1A800D7EACFCFD295CACCAB2E_224424667 =         delegate.getSSLSocket().getSession().getLocalPrincipal();
        var9BBD49A1A800D7EACFCFD295CACCAB2E_224424667.addTaint(taint);
        return var9BBD49A1A800D7EACFCFD295CACCAB2E_224424667;
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getLocalPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.521 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    @Override
    public void disconnect() {
        delegate.disconnect();
        // ---------- Original Method ----------
        //delegate.disconnect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.521 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "D274BB3B574661E0411BF2D6870041A9")
    @Override
    public InputStream getErrorStream() {
InputStream var5AB11938BFB3E389F92E9DF02927F1E9_1468269869 =         delegate.getErrorStream();
        var5AB11938BFB3E389F92E9DF02927F1E9_1468269869.addTaint(taint);
        return var5AB11938BFB3E389F92E9DF02927F1E9_1468269869;
        // ---------- Original Method ----------
        //return delegate.getErrorStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.521 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "BD2C131C9E73BFEFD966A146C415C8E1")
    @Override
    public String getRequestMethod() {
String var4B40D7919A015205E6BF3BD275D540D6_998969783 =         delegate.getRequestMethod();
        var4B40D7919A015205E6BF3BD275D540D6_998969783.addTaint(taint);
        return var4B40D7919A015205E6BF3BD275D540D6_998969783;
        // ---------- Original Method ----------
        //return delegate.getRequestMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.522 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "4CDB1F2D8354A9DE6CD57880CAB720CB")
    @Override
    public int getResponseCode() throws IOException {
        int var531F74661189AF5AFF20B5DF99C3C0B4_314072032 = (delegate.getResponseCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881074284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881074284;
        // ---------- Original Method ----------
        //return delegate.getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.522 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "9145803504F39A3B7B7D209F52C10E3E")
    @Override
    public String getResponseMessage() throws IOException {
String varEC7678C2C582B4839D528E15495632E0_1764735947 =         delegate.getResponseMessage();
        varEC7678C2C582B4839D528E15495632E0_1764735947.addTaint(taint);
        return varEC7678C2C582B4839D528E15495632E0_1764735947;
        // ---------- Original Method ----------
        //return delegate.getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.522 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "4663E1463DF24180675F0663D05FD05F")
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        addTaint(method.getTaint());
        delegate.setRequestMethod(method);
        // ---------- Original Method ----------
        //delegate.setRequestMethod(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.523 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "13D2DEA9774CADD08716BADF81D4BF16")
    @Override
    public boolean usingProxy() {
        boolean varCC52A8AE80AB6FF3ABDD1F5E6E00DC59_1647041903 = (delegate.usingProxy());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523571816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523571816;
        // ---------- Original Method ----------
        //return delegate.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.523 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "75B5219CB388D1F87618CFAA71FF8B4A")
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var80ECDB430EC8842E1416E2354ADCF1C7_1352543170 = (delegate.getInstanceFollowRedirects());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253986821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253986821;
        // ---------- Original Method ----------
        //return delegate.getInstanceFollowRedirects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.523 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "16C35FB186E347ABFFEBF670418559DE")
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        addTaint(followRedirects);
        delegate.setInstanceFollowRedirects(followRedirects);
        // ---------- Original Method ----------
        //delegate.setInstanceFollowRedirects(followRedirects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.524 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        // ---------- Original Method ----------
        //connected = true;
        //delegate.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.524 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "A92F7C4438FCF1E728A6CE2F6BF31530")
    @Override
    public boolean getAllowUserInteraction() {
        boolean var90527CE6B6B410FBA7CA923B07A1CED7_1613793408 = (delegate.getAllowUserInteraction());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649496526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649496526;
        // ---------- Original Method ----------
        //return delegate.getAllowUserInteraction();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.524 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "3B57C157EDE08CF8E15D4B7040CF895D")
    @Override
    public Object getContent() throws IOException {
Object var0992CCA47F11BC3F186C1A663FDE84C9_1319537572 =         delegate.getContent();
        var0992CCA47F11BC3F186C1A663FDE84C9_1319537572.addTaint(taint);
        return var0992CCA47F11BC3F186C1A663FDE84C9_1319537572;
        // ---------- Original Method ----------
        //return delegate.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.524 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "BE0CB1100D072CAC69951CDF49E7AC22")
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        addTaint(types[0].getTaint());
Object var160AB04DD32D12114A6D7364B391005D_1687423536 =         delegate.getContent(types);
        var160AB04DD32D12114A6D7364B391005D_1687423536.addTaint(taint);
        return var160AB04DD32D12114A6D7364B391005D_1687423536;
        // ---------- Original Method ----------
        //return delegate.getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.525 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "0C379F953EF424E396EC71F67C9832E1")
    @Override
    public String getContentEncoding() {
String var4D847C56D41E90F7625C8163629E6425_1595168914 =         delegate.getContentEncoding();
        var4D847C56D41E90F7625C8163629E6425_1595168914.addTaint(taint);
        return var4D847C56D41E90F7625C8163629E6425_1595168914;
        // ---------- Original Method ----------
        //return delegate.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.525 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "F77BD3E91C74659A03425BA7541DF51E")
    @Override
    public int getContentLength() {
        int var32E363B557C5100C9A92D76CE2537A6C_1531842734 = (delegate.getContentLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725731270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725731270;
        // ---------- Original Method ----------
        //return delegate.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.525 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "B9A3F68F3463F46E4190637F50169ED5")
    @Override
    public String getContentType() {
String var9793E879B8A646DB233A9A2D2C3C2DCD_46893821 =         delegate.getContentType();
        var9793E879B8A646DB233A9A2D2C3C2DCD_46893821.addTaint(taint);
        return var9793E879B8A646DB233A9A2D2C3C2DCD_46893821;
        // ---------- Original Method ----------
        //return delegate.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.526 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "52EE1D4C6569E8E0CD6122E1DA1FF8E7")
    @Override
    public long getDate() {
        long var5783C187D54DD7D1F02B1A7E44A80A9C_194853015 = (delegate.getDate());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1676696418 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1676696418;
        // ---------- Original Method ----------
        //return delegate.getDate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.526 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "386EEAAEC59EB28454206812E579DA7E")
    @Override
    public boolean getDefaultUseCaches() {
        boolean varFCAFADA83FDE4F1151E28AD5EB620CE5_1035447936 = (delegate.getDefaultUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803379799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803379799;
        // ---------- Original Method ----------
        //return delegate.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.526 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "F04254D3E0F72D524B59351DBB8A609E")
    @Override
    public boolean getDoInput() {
        boolean varC64E8413CAD00A74B9A1A22BCB9473DE_1104428950 = (delegate.getDoInput());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837562005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837562005;
        // ---------- Original Method ----------
        //return delegate.getDoInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.527 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "A0572E0DB9113861E025E90DAD76BF2D")
    @Override
    public boolean getDoOutput() {
        boolean var36BA7361DCD3D8FFB46C88801AEE5F69_525540969 = (delegate.getDoOutput());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238190087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238190087;
        // ---------- Original Method ----------
        //return delegate.getDoOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.527 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "3D5903B2FC7964760C6ED584E650882E")
    @Override
    public long getExpiration() {
        long var258782E2CB76F187891942F0C2B4615F_767832812 = (delegate.getExpiration());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1738694321 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1738694321;
        // ---------- Original Method ----------
        //return delegate.getExpiration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.527 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "B39DAB2F1CFBF49112EDF5B2D74A5F0A")
    @Override
    public String getHeaderField(int pos) {
        addTaint(pos);
String varF19BCDF155D022F8720610E5AEAC66E8_1548105574 =         delegate.getHeaderField(pos);
        varF19BCDF155D022F8720610E5AEAC66E8_1548105574.addTaint(taint);
        return varF19BCDF155D022F8720610E5AEAC66E8_1548105574;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.528 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "501A32C36F876931331C5262F34618E7")
    @Override
    public Map<String, List<String>> getHeaderFields() {
Map<String, List<String>> var49173AD3D4E88D7DE53074EE6C4D3AB6_841852679 =         delegate.getHeaderFields();
        var49173AD3D4E88D7DE53074EE6C4D3AB6_841852679.addTaint(taint);
        return var49173AD3D4E88D7DE53074EE6C4D3AB6_841852679;
        // ---------- Original Method ----------
        //return delegate.getHeaderFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.528 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "005A5983F46405043B7724255AFE913A")
    @Override
    public Map<String, List<String>> getRequestProperties() {
Map<String, List<String>> varA0D8910F76C36E1A3A9A27D8CEF0597C_1037115357 =         delegate.getRequestProperties();
        varA0D8910F76C36E1A3A9A27D8CEF0597C_1037115357.addTaint(taint);
        return varA0D8910F76C36E1A3A9A27D8CEF0597C_1037115357;
        // ---------- Original Method ----------
        //return delegate.getRequestProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.528 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "0EC78A514E5A0D295D4B97102FDD2F3A")
    @Override
    public void addRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        delegate.addRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.addRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.528 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "A644A49845FE735A07DCD08FA5700D1F")
    @Override
    public String getHeaderField(String key) {
        addTaint(key.getTaint());
String var6EFB1FDEC2E277B17FC4A3A691801850_892083299 =         delegate.getHeaderField(key);
        var6EFB1FDEC2E277B17FC4A3A691801850_892083299.addTaint(taint);
        return var6EFB1FDEC2E277B17FC4A3A691801850_892083299;
        // ---------- Original Method ----------
        //return delegate.getHeaderField(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.529 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "41994771661D628062AE2A7CDE3C3B03")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        long var9B3FC141DB375FFC8ADDAC9A707CA59C_902344171 = (delegate.getHeaderFieldDate(field, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1409729769 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1409729769;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.529 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "E1081EECFABFC81F614B334FC0DE2D6D")
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        int var3A74F19990997CCFF1E1FC856690ACF3_2124437353 = (delegate.getHeaderFieldInt(field, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189978857 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189978857;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldInt(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.529 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "E98E1872F36BD3229F46311028A16B7C")
    @Override
    public String getHeaderFieldKey(int posn) {
        addTaint(posn);
String varE2E936A2C1D394E0A178CF43FBC4AF39_535163294 =         delegate.getHeaderFieldKey(posn);
        varE2E936A2C1D394E0A178CF43FBC4AF39_535163294.addTaint(taint);
        return varE2E936A2C1D394E0A178CF43FBC4AF39_535163294;
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldKey(posn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.530 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "97E0617F754EB547269A316C6C211B60")
    @Override
    public long getIfModifiedSince() {
        long varCB50B494905E172FEEBE9EAEC7926627_1789681907 = (delegate.getIfModifiedSince());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_740573337 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_740573337;
        // ---------- Original Method ----------
        //return delegate.getIfModifiedSince();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.530 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "E5041A47AE05CD75A758F04A5ADDFD50")
    @Override
    public InputStream getInputStream() throws IOException {
InputStream varA6057298161142AA94562760706596B6_905877633 =         delegate.getInputStream();
        varA6057298161142AA94562760706596B6_905877633.addTaint(taint);
        return varA6057298161142AA94562760706596B6_905877633;
        // ---------- Original Method ----------
        //return delegate.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.530 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "0C48B1D408BDBD3706E93C1FE3574742")
    @Override
    public long getLastModified() {
        long var747A7E792089C9DFB807A2FF78E9D6CC_657837917 = (delegate.getLastModified());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_452485923 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_452485923;
        // ---------- Original Method ----------
        //return delegate.getLastModified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.531 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "106F339C7B8E8BDF1CF543FC34E684B4")
    @Override
    public OutputStream getOutputStream() throws IOException {
OutputStream var26E4766CFD76703CF0EDA62B428D31E2_1828762798 =         delegate.getOutputStream();
        var26E4766CFD76703CF0EDA62B428D31E2_1828762798.addTaint(taint);
        return var26E4766CFD76703CF0EDA62B428D31E2_1828762798;
        // ---------- Original Method ----------
        //return delegate.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.531 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "DF295E4279E331791CDCC33544844455")
    @Override
    public Permission getPermission() throws IOException {
Permission varC4E07256C0BCF81F626D018B0F5CAC90_557002505 =         delegate.getPermission();
        varC4E07256C0BCF81F626D018B0F5CAC90_557002505.addTaint(taint);
        return varC4E07256C0BCF81F626D018B0F5CAC90_557002505;
        // ---------- Original Method ----------
        //return delegate.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.531 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "5F9BC5D7CF33365053EB1B061F8817B2")
    @Override
    public String getRequestProperty(String field) {
        addTaint(field.getTaint());
String varAC7E243492D4A6C3C9AB4C6997F244B1_1855955445 =         delegate.getRequestProperty(field);
        varAC7E243492D4A6C3C9AB4C6997F244B1_1855955445.addTaint(taint);
        return varAC7E243492D4A6C3C9AB4C6997F244B1_1855955445;
        // ---------- Original Method ----------
        //return delegate.getRequestProperty(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.531 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "A199EA202475E295C163D42C08C63477")
    @Override
    public URL getURL() {
URL var6884EDA0C600EABAFFD2E6B72828DBC6_1172326698 =         delegate.getURL();
        var6884EDA0C600EABAFFD2E6B72828DBC6_1172326698.addTaint(taint);
        return var6884EDA0C600EABAFFD2E6B72828DBC6_1172326698;
        // ---------- Original Method ----------
        //return delegate.getURL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.532 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "A8DD9703CFCEFBB876ADEFB10D101691")
    @Override
    public boolean getUseCaches() {
        boolean varCC47F02C2E479DDEB8BA085BFD4C608F_640286984 = (delegate.getUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301822691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301822691;
        // ---------- Original Method ----------
        //return delegate.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.532 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "F86CF2295E0B05DCE36CC01C0EB303BD")
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        addTaint(newValue);
        delegate.setAllowUserInteraction(newValue);
        // ---------- Original Method ----------
        //delegate.setAllowUserInteraction(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.532 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "1BED3828A1A4BFF538D63AF58852AF3D")
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        addTaint(newValue);
        delegate.setDefaultUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setDefaultUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.533 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "B4B551A035BECA88C62FCED886B89488")
    @Override
    public void setDoInput(boolean newValue) {
        addTaint(newValue);
        delegate.setDoInput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoInput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.533 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "31C3442A572DE14351BDF9B8284C9503")
    @Override
    public void setDoOutput(boolean newValue) {
        addTaint(newValue);
        delegate.setDoOutput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoOutput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.533 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "23FE48642099C8956B35E282CEAFDCCE")
    @Override
    public void setIfModifiedSince(long newValue) {
        addTaint(newValue);
        delegate.setIfModifiedSince(newValue);
        // ---------- Original Method ----------
        //delegate.setIfModifiedSince(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.534 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "665FBB5FBF32CAE23159A45BB916EC6A")
    @Override
    public void setRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        delegate.setRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.setRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.534 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "D03D792D95DC066EFABCCDD79763828B")
    @Override
    public void setUseCaches(boolean newValue) {
        addTaint(newValue);
        delegate.setUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.534 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "AF9704001C0801A1F335045DA3E2EB63")
    @Override
    public void setConnectTimeout(int timeout) {
        addTaint(timeout);
        delegate.setConnectTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setConnectTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.534 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "728A76ADB94C8CDF6DEE6BE4E9891568")
    @Override
    public int getConnectTimeout() {
        int var3B7820C4F8E3B01C6BC70059CAC3E436_202171948 = (delegate.getConnectTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966603231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966603231;
        // ---------- Original Method ----------
        //return delegate.getConnectTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.535 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "021134BB2C3F24A8353501B2C1800E80")
    @Override
    public void setReadTimeout(int timeout) {
        addTaint(timeout);
        delegate.setReadTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setReadTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.535 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "4A65DCC92665D1935A63798CEF3E3E5B")
    @Override
    public int getReadTimeout() {
        int varAEF03DF43E1FA12D30CFE1F6E089D09C_173161979 = (delegate.getReadTimeout());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860992924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860992924;
        // ---------- Original Method ----------
        //return delegate.getReadTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.535 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "F94F71404EAAEF02FE0208E7F91201DE")
    @Override
    public String toString() {
String varFB90DA94A5E41D35E9CAB1F945B07348_1343692988 =         delegate.toString();
        varFB90DA94A5E41D35E9CAB1F945B07348_1343692988.addTaint(taint);
        return varFB90DA94A5E41D35E9CAB1F945B07348_1343692988;
        // ---------- Original Method ----------
        //return delegate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.536 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "5BD4FB4CA8A5611C7CD5D3FC2CBC9EB9")
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        addTaint(contentLength);
        delegate.setFixedLengthStreamingMode(contentLength);
        // ---------- Original Method ----------
        //delegate.setFixedLengthStreamingMode(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.536 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "FED5A2F7728D12ACB987DEE94BE7F2B6")
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        addTaint(chunkLength);
        delegate.setChunkedStreamingMode(chunkLength);
        // ---------- Original Method ----------
        //delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.536 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "EFDF6B2A40127A321E3579EA2108DB76")
        private  HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            addTaint(port);
            addTaint(url.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.537 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "25137BDC92BB1379AA29210558B26D50")
        private  HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            addTaint(proxy.getTaint());
            addTaint(port);
            addTaint(url.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.537 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "D26A6F768A5DD31F2B5896028E639D7D")
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            addTaint(requestBody.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(method.getTaint());
HttpEngine var4275551A0E87ACEAEFB678DB8BB37064_1604000275 =             new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
            var4275551A0E87ACEAEFB678DB8BB37064_1604000275.addTaint(taint);
            return var4275551A0E87ACEAEFB678DB8BB37064_1604000275;
            // ---------- Original Method ----------
            //return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    //HttpsURLConnectionImpl.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.537 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "28FE24DCD8B9165F4611CAEDFC56B32D")
        public SecureCacheResponse getCacheResponse() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
SecureCacheResponse var871EF139AE570FACE37934F5F72D643E_343826486 =             engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
            var871EF139AE570FACE37934F5F72D643E_343826486.addTaint(taint);
            return var871EF139AE570FACE37934F5F72D643E_343826486;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.538 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "57E0364BE812B29DBEF7BF8C70C76549")
        public SSLSocket getSSLSocket() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
SSLSocket var61F4735CFEE1975FCF23B8A439E04FDA_1034354983 =             engine != null ? engine.sslSocket : null;
            var61F4735CFEE1975FCF23B8A439E04FDA_1034354983.addTaint(taint);
            return var61F4735CFEE1975FCF23B8A439E04FDA_1034354983;
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.538 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.538 -0400", hash_original_field = "06B167584A75871D42FCD159D2218E9A", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")

        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.539 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "3EB6C03FB9BC660C5BD5D375629BD073")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.539 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "1955C779F5B503BE888A4BF4EB52E6F7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.540 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "A180B9C36AB505ECBC6103E1A4FC5C8F")
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
                boolean varB326B5062B2F0E69046810717534CB09_1079796793 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267635476 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267635476;
            } //End block
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            boolean var68934A3E9455FA72420237EB05902327_1360179421 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105158380 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105158380;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.541 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "102626F855B734CA5464F56E0AA8B007")
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
                    IOException varA7405ABC79D717A768C069FC31724F97_1757973715 = new IOException("Failed to authenticate with proxy");
                    varA7405ABC79D717A768C069FC31724F97_1757973715.addTaint(taint);
                    throw varA7405ABC79D717A768C069FC31724F97_1757973715;
                } //End block
                default:
                IOException var5E23AB435FF46F926F17D0788C01696D_1734589598 = new IOException("Unexpected response code for CONNECT: " + responseCode);
                var5E23AB435FF46F926F17D0788C01696D_1734589598.addTaint(taint);
                throw var5E23AB435FF46F926F17D0788C01696D_1734589598;
}
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.542 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "99CCD059F07B9BAC0735CCDA4FE4DA3F")
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            addTaint(cacheResponse.getTaint());
            boolean var01C10E608C22923A812E7933E0DF2253_1623093345 = (cacheResponse instanceof SecureCacheResponse);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125526430 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_125526430;
            // ---------- Original Method ----------
            //return cacheResponse instanceof SecureCacheResponse;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.542 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "1973C0806CF8B9C7C7D395ED8C7185F2")
        @Override
        protected boolean includeAuthorityInRequestLine() {
            boolean var68934A3E9455FA72420237EB05902327_788434944 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592236221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592236221;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.542 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "7160F375755752D6E2DF5AE49735031A")
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
HttpURLConnection varBC9F2915706BB2F8D72691CF4F26214A_238247233 =             enclosing;
            varBC9F2915706BB2F8D72691CF4F26214A_238247233.addTaint(taint);
            return varBC9F2915706BB2F8D72691CF4F26214A_238247233;
            // ---------- Original Method ----------
            //return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.543 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "0DCDD93F96A82B14AE0DF07AD2329C37")
        public  ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(policy.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.543 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "3A6BB6317E12EEE38A24F387046372AC")
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
RawHeaders varDC838461EE2FA0CA4C9BBB70A15456B0_513260938 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_513260938.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_513260938;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.544 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "4AFD102921D2F093FB8C72635C75E80A")
        @Override
        protected boolean requiresTunnel() {
            boolean varB326B5062B2F0E69046810717534CB09_712827012 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074490696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074490696;
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
}

