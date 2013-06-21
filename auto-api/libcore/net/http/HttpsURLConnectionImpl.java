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
    private HttpUrlConnectionDelegate delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.342 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "077483ABD61E1A899CFE754F94AFD4E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        dsTaint.addTaint(port);
        dsTaint.addTaint(url.dsTaint);
        delegate = new HttpUrlConnectionDelegate(url, port);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.343 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "5FA7A6A9E8FEFA796FAA00C6118389A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        dsTaint.addTaint(port);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        // ---------- Original Method ----------
        //delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.343 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "42219294AEA4FB2B96DFDA06E935C15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkConnected() {
        {
            boolean varBA474CA436F45D71B4740DB91291C434_2050334064 = (delegate.getSSLSocket() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection has not yet been established");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (delegate.getSSLSocket() == null) {
            //throw new IllegalStateException("Connection has not yet been established");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.343 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "42D9F071D11DE0A9A3C6A2F2021E7A0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HttpEngine getHttpEngine() {
        HttpEngine var0C43CBCD8E1173D7B349E58878E67A73_748288193 = (delegate.getHttpEngine());
        return (HttpEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getHttpEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.343 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "66136CE89A2226D2FDC7398987D77C42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getCipherSuite() {
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            String var868B3EA4506E0E2B58619E971818AB2F_390370830 = (cacheResponse.getCipherSuite());
        } //End block
        checkConnected();
        String varED496CD94A17AD61DBA3F4699877B9DA_1923424218 = (delegate.getSSLSocket().getSession().getCipherSuite());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getCipherSuite();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.344 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "3A0C680100A8A907AA57FB96D0E91B94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Certificate[] getLocalCertificates() {
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getLocalCertificateChain();
            {
                Object varF2E78C856C339442387682FAFCD663CB_1062732206 = (result.toArray(new Certificate[result.size()]));
            } //End flattened ternary
        } //End block
        checkConnected();
        Certificate[] varBA256069CB537D3B594C81DDCAFC0820_1467079885 = (delegate.getSSLSocket().getSession().getLocalCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getLocalCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.345 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "DC1D4EAD55A71EC24698ADA820486145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result;
            result = cacheResponse.getServerCertificateChain();
            {
                Object varF2E78C856C339442387682FAFCD663CB_590051355 = (result.toArray(new Certificate[result.size()]));
            } //End flattened ternary
        } //End block
        checkConnected();
        Certificate[] var5890E64EA3F31EA2BAA96424E758EF80_2055486103 = (delegate.getSSLSocket().getSession().getPeerCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //List<Certificate> result = cacheResponse.getServerCertificateChain();
            //return result != null ? result.toArray(new Certificate[result.size()]) : null;
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.346 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "EFEDE1619F69561CA05A9090FA651AC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            Principal varEFBC9A51918C598849068EDF2B977D7B_1505970054 = (cacheResponse.getPeerPrincipal());
        } //End block
        checkConnected();
        Principal varFC16B398C326B6549E6C5464435361B1_898370786 = (delegate.getSSLSocket().getSession().getPeerPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getPeerPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.346 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "7E0EDCB7289C3D6A0F62AB08D970B20D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Principal getLocalPrincipal() {
        SecureCacheResponse cacheResponse;
        cacheResponse = delegate.getCacheResponse();
        {
            Principal varFE921AEA31926FC9C253475F25778FD9_901434121 = (cacheResponse.getLocalPrincipal());
        } //End block
        checkConnected();
        Principal var84934DFF146550C05ABF44A72BF47E6E_1388245524 = (delegate.getSSLSocket().getSession().getLocalPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        //if (cacheResponse != null) {
            //return cacheResponse.getLocalPrincipal();
        //}
        //checkConnected();
        //return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.346 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void disconnect() {
        delegate.disconnect();
        // ---------- Original Method ----------
        //delegate.disconnect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.346 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "E37BF8A31BF3F49EC32304820CB3BCFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getErrorStream() {
        InputStream var9D20A744D28D3321CFC10C6973E8B5A2_698872802 = (delegate.getErrorStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getErrorStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.346 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "5C9E1DE2FF8170BC718F57DC14D76ABD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getRequestMethod() {
        String var660B4F64BAEB3FF80431D62EA668972B_442992372 = (delegate.getRequestMethod());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getRequestMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.347 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "9F399FF25DC1A013A7E78F3247EC8AE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getResponseCode() throws IOException {
        int varDC834023D584CBF2E5DE9F65DB0FB932_1937048724 = (delegate.getResponseCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return delegate.getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.347 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "B5A589B3684151FDD004035BA5D8F27F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getResponseMessage() throws IOException {
        String var29027445A09FD02F53770C0889BA90D0_1641019090 = (delegate.getResponseMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.347 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "5BDA470BE70F85884D4152EF2DC7B124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        dsTaint.addTaint(method);
        delegate.setRequestMethod(method);
        // ---------- Original Method ----------
        //delegate.setRequestMethod(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.347 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "C2FC84427FBE1D312706ADC0FBD90523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean usingProxy() {
        boolean var1A73319817A7BA58362FCE0126646E14_524921775 = (delegate.usingProxy());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.347 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "770BCDF8C7224502DFDF00B859865DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var36FEF060062CDCFFA52982B100EB3F06_2139987571 = (delegate.getInstanceFollowRedirects());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getInstanceFollowRedirects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "15121ED3801EB7345FF703F23040A69B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        dsTaint.addTaint(followRedirects);
        delegate.setInstanceFollowRedirects(followRedirects);
        // ---------- Original Method ----------
        //delegate.setInstanceFollowRedirects(followRedirects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        // ---------- Original Method ----------
        //connected = true;
        //delegate.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "564669D1528414625FE91CF652BA94E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getAllowUserInteraction() {
        boolean varD52A0AC310FCDDF8EC36D9E6668695A1_838402328 = (delegate.getAllowUserInteraction());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getAllowUserInteraction();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "DECD99B5399494FCF0A3546C06F7B42A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getContent() throws IOException {
        Object var713BEB8D7818973F00873898BDB28FAB_1493470326 = (delegate.getContent());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "C1240F00B94A258C4075212FCD09C42A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        dsTaint.addTaint(types[0].dsTaint);
        Object var4A7ADA15F501F72077EE2598D55ECEBD_1177385548 = (delegate.getContent(types));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.348 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "31CCA795942748A294FD7D899D2BF09C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentEncoding() {
        String var7AF90C2F775A5EBB6902132B29C3E459_1899377648 = (delegate.getContentEncoding());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.349 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "979875296BE53A4717BEE0C8399715CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getContentLength() {
        int var46C13ADE2970E578BB05FE5EEA0046DA_55403752 = (delegate.getContentLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return delegate.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.349 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "8CD6EB0E8244DA169FD2C145C172DA8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentType() {
        String var5A6977E42F4B3975ED3B757718529F94_1846685742 = (delegate.getContentType());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.349 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "1A4D3544597E09480DF3ECCF43E48007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getDate() {
        long var347DC365CBC90FBE87EE28BA84488696_1951934233 = (delegate.getDate());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return delegate.getDate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.349 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "070E664DA9B43ED1879A7DC09D925031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getDefaultUseCaches() {
        boolean var3FC2C68637FBA6BB6F081C916459E56C_1407939614 = (delegate.getDefaultUseCaches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.350 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "47A959D2AFC8B58D392C8E6D8A02390B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getDoInput() {
        boolean var3AD6E1CD897116123B22123C5F9351D0_1380943061 = (delegate.getDoInput());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getDoInput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.351 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "EC165B2283B0493FAC800FC5DA3BF7D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getDoOutput() {
        boolean varBB2AB3EEC37F983793BE7F09AA948961_700398662 = (delegate.getDoOutput());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getDoOutput();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.352 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "49C13ECF36979DBB2B28782233B31F81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getExpiration() {
        long varC51716E5D8873132B8303EA472292149_246960329 = (delegate.getExpiration());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return delegate.getExpiration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.353 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "39CC9747FC682F51F01281FE8EE57E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getHeaderField(int pos) {
        dsTaint.addTaint(pos);
        String var547F054EAC8116D98DA46B6F00495990_1866055490 = (delegate.getHeaderField(pos));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getHeaderField(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.355 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "56F509E79474A26AC0F023BE7AFB8E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> var947FBA931D4FB4E5292254BC3ACEBD83_1885425737 = (delegate.getHeaderFields());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getHeaderFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.355 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "093D619A36A4303833090C3D9ECF4D96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> var1044625F37583A52377A160E9ED94272_1374222757 = (delegate.getRequestProperties());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getRequestProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "FEAE4A21363AFB43310A76A50D9A9E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        delegate.addRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.addRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "6F2DC3FA3B74FAA0E7BB811D13D6F39F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getHeaderField(String key) {
        dsTaint.addTaint(key);
        String var0279B93B4ABC517492E6FF605E793049_548766522 = (delegate.getHeaderField(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getHeaderField(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "28F176819CCEC15B8E43CC208D3EDDFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        long varF9B0FA24B3C89487E1F0C5C4DEFD1A6F_989591029 = (delegate.getHeaderFieldDate(field, defaultValue));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "5CE9137655D3E8D475E22467DD4897E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        int var9141D4C32956F8B7698AADB6AE35E322_191402459 = (delegate.getHeaderFieldInt(field, defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldInt(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "D0EBEA36CC93BCB5F5C01D60518A2117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getHeaderFieldKey(int posn) {
        dsTaint.addTaint(posn);
        String varFCCDA597AA1CB1AFC116AF5AB72DBBCB_1324457788 = (delegate.getHeaderFieldKey(posn));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getHeaderFieldKey(posn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.356 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "54CAECE252E5A021E25C3EF785EFCE91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getIfModifiedSince() {
        long var2F648525489FF1333DA0B755237FF143_1345347270 = (delegate.getIfModifiedSince());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return delegate.getIfModifiedSince();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.357 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "8DEBAE9ECF31C2A08CFAC977FA7C985F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream var06274514028635C4DBB91A59FED3E5DD_525885537 = (delegate.getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.357 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "C10AEF41F3B89545A1D618C8BF80663A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLastModified() {
        long var426E8D7A6E590ED1F9B47C7958BE51AD_2065735706 = (delegate.getLastModified());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return delegate.getLastModified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.357 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "47676781CAA2E8CECF7DA5A5EED653FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream var8A340182E9240F3EBA9482143ACCB614_1810474844 = (delegate.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.357 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "BE3001600D5700D0BB3CB2A56D70201F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Permission getPermission() throws IOException {
        Permission var41F9C075CE1C2DD5B3EF8BDFE3421606_154052201 = (delegate.getPermission());
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.357 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "478CDABB05CD0A3CC4B5D4B837CBB52F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getRequestProperty(String field) {
        dsTaint.addTaint(field);
        String var04B52747C2A2A79B12DB1A22BB5AB609_41765309 = (delegate.getRequestProperty(field));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.getRequestProperty(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "AAB1A0F4465193D40369F27EB8F2C852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URL getURL() {
        URL var2ED8FB8A89629394172130A7D1542598_1122335414 = (delegate.getURL());
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getURL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "E5A5C8D845FADBF43F6D42DE9E00C336")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseCaches() {
        boolean varF45B15791721B7C5A39E6EC8FCE0C874_1182004108 = (delegate.getUseCaches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delegate.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "736E73D3CC689263918D8B27AE551536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        dsTaint.addTaint(newValue);
        delegate.setAllowUserInteraction(newValue);
        // ---------- Original Method ----------
        //delegate.setAllowUserInteraction(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "B7B0E684D98ABE0120C9D03AFAF87811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        delegate.setDefaultUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setDefaultUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "AD733083081CBD3E7B4F026DDC54D3AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDoInput(boolean newValue) {
        dsTaint.addTaint(newValue);
        delegate.setDoInput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoInput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.358 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "EC7EA196E48593AF01842AD58F8B411D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDoOutput(boolean newValue) {
        dsTaint.addTaint(newValue);
        delegate.setDoOutput(newValue);
        // ---------- Original Method ----------
        //delegate.setDoOutput(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "3588E520BD818754FB93890B20AE48DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setIfModifiedSince(long newValue) {
        dsTaint.addTaint(newValue);
        delegate.setIfModifiedSince(newValue);
        // ---------- Original Method ----------
        //delegate.setIfModifiedSince(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "3C9F9850454528FDB32C4E0CF842E23F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        delegate.setRequestProperty(field, newValue);
        // ---------- Original Method ----------
        //delegate.setRequestProperty(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "9A829402F8667809FC0F892D2254B8E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        delegate.setUseCaches(newValue);
        // ---------- Original Method ----------
        //delegate.setUseCaches(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "AF12DC7294857905020CE7C94CC00588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setConnectTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        delegate.setConnectTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setConnectTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "FAC2A40DFD6F314A0303371D8DB58B85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getConnectTimeout() {
        int var44D58E8907D6B3B15AC45D93D9FF2214_1988004464 = (delegate.getConnectTimeout());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return delegate.getConnectTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "5FFA71C477F3FD9EF2F2E05F35697E4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setReadTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        delegate.setReadTimeout(timeout);
        // ---------- Original Method ----------
        //delegate.setReadTimeout(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.359 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "6A6B885A7D8E0506BF1656ACDE623E72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getReadTimeout() {
        int var6AA840C9DF82A442D7F21A3A02E813E8_2062372542 = (delegate.getReadTimeout());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return delegate.getReadTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "2745AEFC4BCAAEBB707D6F96EDCD53D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var02D8A5732C55104F70717B8C17C6CD27_1046815544 = (delegate.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return delegate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "2B047B2C8C0B99F5CC2D852130A3259F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        dsTaint.addTaint(contentLength);
        delegate.setFixedLengthStreamingMode(contentLength);
        // ---------- Original Method ----------
        //delegate.setFixedLengthStreamingMode(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "91DB729F9A6EB0B97412DDC7AEAC8FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        dsTaint.addTaint(chunkLength);
        delegate.setChunkedStreamingMode(chunkLength);
        // ---------- Original Method ----------
        //delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "ED6A246DFB40F0E342F42E5166B8665E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            dsTaint.addTaint(port);
            dsTaint.addTaint(url.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "4EB7389FD3C8263DBAB1AAA784B4ECE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            dsTaint.addTaint(port);
            dsTaint.addTaint(proxy.dsTaint);
            dsTaint.addTaint(url.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.360 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "9373B62101CFB234EBEE404967F8D31D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            dsTaint.addTaint(requestBody.dsTaint);
            dsTaint.addTaint(connection.dsTaint);
            dsTaint.addTaint(requestHeaders.dsTaint);
            dsTaint.addTaint(method);
            HttpEngine var68739AEE3891F9E4329F64864FC27E06_758792459 = (new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this));
            return (HttpEngine)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    //HttpsURLConnectionImpl.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.361 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "8966A26BF64A1B95BD222953196B57AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SecureCacheResponse getCacheResponse() {
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            {
                Object varC251AC3F3BC5FBE9C72954AB58D6F809_595989975 = ((SecureCacheResponse) engine.getCacheResponse());
            } //End flattened ternary
            return (SecureCacheResponse)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.361 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "E0CAA112D2B753CDA4733260FB4D9CDD")
        @DSModeled(DSC.SAFE)
        public SSLSocket getSSLSocket() {
            HttpsEngine engine;
            engine = (HttpsEngine) httpEngine;
            return (SSLSocket)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HttpsEngine engine = (HttpsEngine) httpEngine;
            //return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        private SSLSocket sslSocket;
        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.361 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "B55C836AE8F29C61C34453CC88B7A008")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private HttpsEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody,
                HttpsURLConnectionImpl enclosing) throws IOException {
            super(policy, method, requestHeaders, connection, requestBody);
            dsTaint.addTaint(requestBody.dsTaint);
            dsTaint.addTaint(connection.dsTaint);
            dsTaint.addTaint(requestHeaders.dsTaint);
            dsTaint.addTaint(enclosing.dsTaint);
            dsTaint.addTaint(method);
            dsTaint.addTaint(policy.dsTaint);
            this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            // ---------- Original Method ----------
            //this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            //this.enclosing = enclosing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.361 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "43F80916429181CC626636636FEAC792")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var3AC4DFFE7CC4939DF7C4ED033B861EC8_1791875658 = (e instanceof SSLHandshakeException
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.362 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "AEA4BADE05A2D429E6892DE294C8E85D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            dsTaint.addTaint(tlsTolerant);
            {
                connection = openSocketConnection();
                {
                    boolean var8E696082C46988ED27CC92AF7EEC78DA_45837621 = (connection.getAddress().getProxy() != null);
                    {
                        makeTunnel(policy, connection, getRequestHeaders());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            sslSocket = connection.getSecureSocketIfConnected();
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.362 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "7E3E1551C748B0DACE78CAA8768F67FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void makeTunnel(HttpURLConnectionImpl policy, HttpConnection connection,
                RequestHeaders requestHeaders) throws IOException {
            dsTaint.addTaint(connection.dsTaint);
            dsTaint.addTaint(requestHeaders.dsTaint);
            dsTaint.addTaint(policy.dsTaint);
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
                    Object varE3D66A7026D8BFDE15E135A9F3AF9D8C_421336004 = (connect.getResponseCode());
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.362 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "E1FEE379877055623BFC8152F68DA1D5")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            dsTaint.addTaint(cacheResponse.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cacheResponse instanceof SecureCacheResponse;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.362 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "E77784E9F72BA3D4E69A95E74085D486")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean includeAuthorityInRequestLine() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.363 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "C93DF6C31142A816AACCF1CFE2495E22")
        @DSModeled(DSC.SAFE)
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
            return (HttpURLConnection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.363 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "43D7E68C5A8C2DA08880AB2CCC368A24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            dsTaint.addTaint(connection.dsTaint);
            dsTaint.addTaint(requestHeaders.dsTaint);
            dsTaint.addTaint(policy.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.363 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "2A424C72D3871FEBC787AEC288532F83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected RawHeaders getNetworkRequestHeaders() throws IOException {
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
            return (RawHeaders)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.363 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "BEB598ED02B3288E74D103057DD4E156")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean requiresTunnel() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
}

