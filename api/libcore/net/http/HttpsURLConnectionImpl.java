package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.517 -0500", hash_original_field = "FF29CF3606AC4412B339E90870C81D88", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private  HttpUrlConnectionDelegate delegate;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.521 -0500", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "9DBE049B19624D7E0060BF8865810FDB")
    
protected HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.524 -0500", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "49C99C3AD97CC5198A923A58925A0F69")
    
protected HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.526 -0500", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "1FF8F64F38B77A9125AD65A815A925AC")
    
private void checkConnected() {
        if (delegate.getSSLSocket() == null) {
            throw new IllegalStateException("Connection has not yet been established");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.528 -0500", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "974BBD03908437759747BBBC84511BEF")
    
HttpEngine getHttpEngine() {
        return delegate.getHttpEngine();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.531 -0500", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "6FA3D77CAEB9E52851F8E28B3300197C")
    
@Override
    public String getCipherSuite() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if (cacheResponse != null) {
            return cacheResponse.getCipherSuite();
        }
        checkConnected();
        return delegate.getSSLSocket().getSession().getCipherSuite();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.533 -0500", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "75A9256DDBF5BA12C580DA26E57490C8")
    
@Override
    public Certificate[] getLocalCertificates() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if (cacheResponse != null) {
            List<Certificate> result = cacheResponse.getLocalCertificateChain();
            return result != null ? result.toArray(new Certificate[result.size()]) : null;
        }
        checkConnected();
        return delegate.getSSLSocket().getSession().getLocalCertificates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.536 -0500", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "A740603CC3E2B2129F96B9AB742E3D72")
    
@Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if (cacheResponse != null) {
            List<Certificate> result = cacheResponse.getServerCertificateChain();
            return result != null ? result.toArray(new Certificate[result.size()]) : null;
        }
        checkConnected();
        return delegate.getSSLSocket().getSession().getPeerCertificates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.538 -0500", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "E8DA23BC128A6470C837E52557A8D7BD")
    
@Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if (cacheResponse != null) {
            return cacheResponse.getPeerPrincipal();
        }
        checkConnected();
        return delegate.getSSLSocket().getSession().getPeerPrincipal();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.540 -0500", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "2CCAA48571D9A3B4D5B14F569C2DC1CC")
    
@Override
    public Principal getLocalPrincipal() {
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        if (cacheResponse != null) {
            return cacheResponse.getLocalPrincipal();
        }
        checkConnected();
        return delegate.getSSLSocket().getSession().getLocalPrincipal();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.543 -0500", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "9BE3C9ECB53FA5C19966BB7887037DD1")
    
@Override
    public void disconnect() {
        delegate.disconnect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.546 -0500", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "52C0B7228652F5C8D15700B0204D5B77")
    
@Override
    public InputStream getErrorStream() {
        return delegate.getErrorStream();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.548 -0500", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "D69CB77181F991BDBCB49C7173E3784E")
    
@Override
    public String getRequestMethod() {
        return delegate.getRequestMethod();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.550 -0500", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "E80774D81D30A66CAD45FA889CE09A1B")
    
@Override
    public int getResponseCode() throws IOException {
        return delegate.getResponseCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.553 -0500", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "C73DBA1CB144484B3CD94979DF687A50")
    
@Override
    public String getResponseMessage() throws IOException {
        return delegate.getResponseMessage();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.555 -0500", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "1C8E0CE2806EAFA8671686A0CF087378")
    
@Override
    public void setRequestMethod(String method) throws ProtocolException {
        delegate.setRequestMethod(method);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.558 -0500", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "E457C6585324AB513E62BDDFF1015D23")
    
@Override
    public boolean usingProxy() {
        return delegate.usingProxy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.560 -0500", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "8A189F34C82D9298EDAAD6028C2A481A")
    
@Override
    public boolean getInstanceFollowRedirects() {
        return delegate.getInstanceFollowRedirects();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.562 -0500", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "58353FEFB488BB9DA9F2D124C4361924")
    
@Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        delegate.setInstanceFollowRedirects(followRedirects);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.564 -0500", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "59D84AADD30BEA021F862F861145AE1E")
    
@Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.567 -0500", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "8639635F2B28F1369F7FEEDFAA9FD5D1")
    
@Override
    public boolean getAllowUserInteraction() {
        return delegate.getAllowUserInteraction();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.569 -0500", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "69B3BF0C27BD4F25831A2E6A9209B43A")
    
@Override
    public Object getContent() throws IOException {
        return delegate.getContent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.572 -0500", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "668137B942BD16E67D52C9FAB0D35973")
    
@SuppressWarnings("unchecked") // Spec does not generify
    @Override
    public Object getContent(Class[] types) throws IOException {
        return delegate.getContent(types);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.575 -0500", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "200A69252D611A43F5C26719E6E69617")
    
@Override
    public String getContentEncoding() {
        return delegate.getContentEncoding();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.577 -0500", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "33DB1B6973748C471D7A95BC637A9CB1")
    
@Override
    public int getContentLength() {
        return delegate.getContentLength();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.580 -0500", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "6261C1D2058E376C9505E8926CD577AC")
    
@Override
    public String getContentType() {
        return delegate.getContentType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.582 -0500", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "3E164171DFE4F69FF967402E89BD1736")
    
@Override
    public long getDate() {
        return delegate.getDate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.584 -0500", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "03B50F88A890D63806C63BFC1BC1757B")
    
@Override
    public boolean getDefaultUseCaches() {
        return delegate.getDefaultUseCaches();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.586 -0500", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "9FB5151885C3ED78D31680CDBF4E48DF")
    
@Override
    public boolean getDoInput() {
        return delegate.getDoInput();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.589 -0500", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "0B3476C47D40EAEDD5186E1F97F30C65")
    
@Override
    public boolean getDoOutput() {
        return delegate.getDoOutput();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.591 -0500", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "994D4FCF3CE2015BA69A8101C4E7C5C5")
    
@Override
    public long getExpiration() {
        return delegate.getExpiration();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.594 -0500", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "2A6C5FD4248C798B12EC2730001CAF7A")
    
@Override
    public String getHeaderField(int pos) {
        return delegate.getHeaderField(pos);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.596 -0500", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "CA8E93D45A56F25522E648B2008A193E")
    
@Override
    public Map<String, List<String>> getHeaderFields() {
        return delegate.getHeaderFields();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.598 -0500", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "F0C3BD3D5CD7AD698CF99BE75C855125")
    
@Override
    public Map<String, List<String>> getRequestProperties() {
        return delegate.getRequestProperties();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.601 -0500", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "A2ED2231F33E6EB3E180AC9F242F8B3A")
    
@Override
    public void addRequestProperty(String field, String newValue) {
        delegate.addRequestProperty(field, newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.603 -0500", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "829AA6789A98DC6FBCC6C196019D2500")
    
@Override
    public String getHeaderField(String key) {
        return delegate.getHeaderField(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.605 -0500", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "D437A9E67C7E4CA614717320A954518D")
    
@Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        return delegate.getHeaderFieldDate(field, defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.609 -0500", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "1CF745614EA77B4E01F7D4E91AC4F109")
    
@Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        return delegate.getHeaderFieldInt(field, defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.611 -0500", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "71907C6BBAC22F059F5E4EA04E20A94C")
    
@Override
    public String getHeaderFieldKey(int posn) {
        return delegate.getHeaderFieldKey(posn);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.613 -0500", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "295253BB3A3AAF683C8439B55BD9E3DE")
    
@Override
    public long getIfModifiedSince() {
        return delegate.getIfModifiedSince();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.616 -0500", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "F9821BEDC2D3D58907D60ED320B7A086")
    
@Override
    public InputStream getInputStream() throws IOException {
        return delegate.getInputStream();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.618 -0500", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "29DF39FDED563259593190FBE013B309")
    
@Override
    public long getLastModified() {
        return delegate.getLastModified();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.621 -0500", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "B5F71F5879375ECA4D36D73ED1DB7D06")
    
@Override
    public OutputStream getOutputStream() throws IOException {
        return delegate.getOutputStream();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.623 -0500", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "EF99FB9A25773D4A9AC28BE70FEB1040")
    
@Override
    public Permission getPermission() throws IOException {
        return delegate.getPermission();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.625 -0500", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "11E5D82DA87A5A804F857DD80360768C")
    
@Override
    public String getRequestProperty(String field) {
        return delegate.getRequestProperty(field);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.628 -0500", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "045909435F27B2405EC3A491F48E1AD8")
    
@Override
    public URL getURL() {
        return delegate.getURL();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.630 -0500", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "69A702D92660103A77B30B9A096961A6")
    
@Override
    public boolean getUseCaches() {
        return delegate.getUseCaches();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.632 -0500", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "97096E4DDA9F8460F2294F9611A08850")
    
@Override
    public void setAllowUserInteraction(boolean newValue) {
        delegate.setAllowUserInteraction(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.635 -0500", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "ACD156A0C5436F9B423DB5EC4972EE54")
    
@Override
    public void setDefaultUseCaches(boolean newValue) {
        delegate.setDefaultUseCaches(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.637 -0500", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "AB87BFF1E5BFAF22713BCBA9B12F5B88")
    
@Override
    public void setDoInput(boolean newValue) {
        delegate.setDoInput(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.640 -0500", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "4EAF2E07A664EEE323C2E95C02C2991C")
    
@Override
    public void setDoOutput(boolean newValue) {
        delegate.setDoOutput(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.642 -0500", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "A8D0CA47065A75BB2C1390DF683E1F63")
    
@Override
    public void setIfModifiedSince(long newValue) {
        delegate.setIfModifiedSince(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.644 -0500", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "7FBB952A275C52A301F21B145BE9CAFC")
    
@Override
    public void setRequestProperty(String field, String newValue) {
        delegate.setRequestProperty(field, newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.647 -0500", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "6B9262F5B068BA91CB3BD7EC8D1A3C13")
    
@Override
    public void setUseCaches(boolean newValue) {
        delegate.setUseCaches(newValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.649 -0500", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "56CB950FC3643D30D2BE16BCF1F7DF3D")
    
@Override
    public void setConnectTimeout(int timeout) {
        delegate.setConnectTimeout(timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.653 -0500", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "DBC75CF970F065537A19D8EA6DA61073")
    
@Override
    public int getConnectTimeout() {
        return delegate.getConnectTimeout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.655 -0500", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "2827585D0D84DAB384140211F070E2C1")
    
@Override
    public void setReadTimeout(int timeout) {
        delegate.setReadTimeout(timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.657 -0500", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "4DCF476AD151E2A2E72697DAE41D1D11")
    
@Override
    public int getReadTimeout() {
        return delegate.getReadTimeout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.659 -0500", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "CA827170D7C5249DC2C5C38C99ED4FB3")
    
@Override
    public String toString() {
        return delegate.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.661 -0500", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "6EAA4C2E8FD59D75A341DBD05796C5AF")
    
@Override
    public void setFixedLengthStreamingMode(int contentLength) {
        delegate.setFixedLengthStreamingMode(contentLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.664 -0500", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "C68954564ED2B525D25A84373DF47710")
    
@Override
    public void setChunkedStreamingMode(int chunkLength) {
        delegate.setChunkedStreamingMode(chunkLength);
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.668 -0500", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "BD5BA6AA626884E6712A973B05E70371")
        
private HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.671 -0500", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "B892FC6769CFD72E9BBF6BCCA42C20E9")
        
private HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.673 -0500", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "8B2DDFBD19CF655DD106A64F5A044F6A")
        
@Override protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            return new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.675 -0500", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "51B1E6920051EAE7131B104D479E30EB")
        
public SecureCacheResponse getCacheResponse() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
            return engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.678 -0500", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "A5A0FD4F627335BB1AA4CC9581ECC87B")
        
public SSLSocket getSSLSocket() {
            HttpsEngine engine = (HttpsEngine) httpEngine;
            return engine != null ? engine.sslSocket : null;
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.683 -0500", hash_original_field = "AEF574D1FDB94AB7E47AFE01544C161B", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.685 -0500", hash_original_field = "329F91C58FD45CA74DF8B91D3C90A286", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")


        private  HttpsURLConnectionImpl enclosing;

        /**
         * @param policy the HttpURLConnectionImpl with connection configuration
         * @param enclosing the HttpsURLConnection with HTTPS features
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.688 -0500", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "343BDD4B79FCEF886F48FE528CF834EA")
        
private HttpsEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody,
                HttpsURLConnectionImpl enclosing) throws IOException {
            super(policy, method, requestHeaders, connection, requestBody);
            this.sslSocket = connection != null ? connection.getSecureSocketIfConnected() : null;
            this.enclosing = enclosing;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.692 -0500", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "26DF35070230A6938703C82BDB8ADBBE")
        
@Override protected void connect() throws IOException {
            // first try an SSL connection with compression and
            // various TLS extensions enabled, if it fails (and its
            // not unheard of that it will) fallback to a more
            // barebones connections
            boolean connectionReused;
            try {
                connectionReused = makeSslConnection(true);
            } catch (IOException e) {
                // If the problem was a CertificateException from the X509TrustManager,
                // do not retry, we didn't have an abrupt server initiated exception.
                if (e instanceof SSLHandshakeException
                        && e.getCause() instanceof CertificateException) {
                    throw e;
                }
                release(false);
                connectionReused = makeSslConnection(false);
            }

            if (!connectionReused) {
                sslSocket = connection.verifySecureSocketHostname(enclosing.getHostnameVerifier());
            }
        }

        /**
         * Attempt to make an https connection. Returns true if a
         * connection was reused, false otherwise.
         *
         * @param tlsTolerant If true, assume server can handle common
         * TLS extensions and SSL deflate compression. If false, use
         * an SSL3 only fallback mode without compression.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.695 -0500", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "733CB4A8B98E8A3ECBDD66AF9B8E42E4")
        
private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            // make an SSL Tunnel on the first message pair of each SSL + proxy connection
            if (connection == null) {
                connection = openSocketConnection();
                if (connection.getAddress().getProxy() != null) {
                    makeTunnel(policy, connection, getRequestHeaders());
                }
            }

            // if super.makeConnection returned a connection from the
            // pool, sslSocket needs to be initialized here. If it is
            // a new connection, it will be initialized by
            // getSecureSocket below.
            sslSocket = connection.getSecureSocketIfConnected();

            // we already have an SSL connection,
            if (sslSocket != null) {
                return true;
            }

            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            return false;
        }

        /**
         * To make an HTTPS connection over an HTTP proxy, send an unencrypted
         * CONNECT request to create the proxy connection. This may need to be
         * retried if the proxy requires authorization.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.697 -0500", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "B00DCA3BC1FF1A80D3AB079202C7E62D")
        
private void makeTunnel(HttpURLConnectionImpl policy, HttpConnection connection,
                RequestHeaders requestHeaders) throws IOException {
            RawHeaders rawRequestHeaders = requestHeaders.getHeaders();
            while (true) {
                HttpEngine connect = new ProxyConnectEngine(policy, rawRequestHeaders, connection);
                connect.sendRequest();
                connect.readResponse();

                int responseCode = connect.getResponseCode();
                switch (connect.getResponseCode()) {
                case HTTP_OK:
                    return;
                case HTTP_PROXY_AUTH:
                    rawRequestHeaders = new RawHeaders(rawRequestHeaders);
                    boolean credentialsFound = policy.processAuthHeader(HTTP_PROXY_AUTH,
                            connect.getResponseHeaders(), rawRequestHeaders);
                    if (credentialsFound) {
                        continue;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + responseCode);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.700 -0500", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "703EE2D12462EC0E785FDA52573613BA")
        
@Override protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            return cacheResponse instanceof SecureCacheResponse;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.702 -0500", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "28EDA5886AF1EF9C515634404728D2B9")
        
@Override protected boolean includeAuthorityInRequestLine() {
            // Even if there is a proxy, it isn't involved. Always request just the file.
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.704 -0500", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "99AF2061D8A06876B6F66364F4B0EB6E")
        
@Override protected HttpURLConnection getHttpConnectionToCache() {
            return enclosing;
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.711 -0500", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "C762954F287B5BB2D4F6B89DCAF5C932")
        
public ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
        }

        /**
         * If we're establishing an HTTPS tunnel with CONNECT (RFC 2817 5.2), send
         * only the minimum set of headers. This avoids sending potentially
         * sensitive data like HTTP cookies to the proxy unencrypted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.715 -0500", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "642D4E7DC689E97EEB2C6F7329BE6364")
        
@Override protected RawHeaders getNetworkRequestHeaders() throws IOException {
            RequestHeaders privateHeaders = getRequestHeaders();
            URL url = policy.getURL();

            RawHeaders result = new RawHeaders();
            result.setStatusLine("CONNECT " + url.getHost() + ":" + url.getEffectivePort()
                    + " HTTP/1.1");

            // Always set Host and User-Agent.
            String host = privateHeaders.getHost();
            if (host == null) {
                host = getOriginAddress(url);
            }
            result.set("Host", host);

            String userAgent = privateHeaders.getUserAgent();
            if (userAgent == null) {
                userAgent = getDefaultUserAgent();
            }
            result.set("User-Agent", userAgent);

            // Copy over the Proxy-Authorization header if it exists.
            String proxyAuthorization = privateHeaders.getProxyAuthorization();
            if (proxyAuthorization != null) {
                result.set("Proxy-Authorization", proxyAuthorization);
            }

            // Always set the Proxy-Connection to Keep-Alive for the benefit of
            // HTTP/1.0 proxies like Squid.
            result.set("Proxy-Connection", "Keep-Alive");
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:36.717 -0500", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "E45101E7C1A932B7E8B9F04388A6A91D")
        
@Override protected boolean requiresTunnel() {
            return true;
        }

        
    }


    
}

