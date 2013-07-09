package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.217 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "78DC7187ACD4D2AF4A458EEC4F87313D")

    private HttpUrlConnectionDelegate delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.218 -0400", hash_original_method = "F295B580C14FF5A1734764BBCB494556", hash_generated_method = "D7761E6D33F0C47B987ABA4B6009A9B6")
    protected  HttpsURLConnectionImpl(URL url, int port) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.218 -0400", hash_original_method = "4AA9A1CCAF3707AB1A6045360D36785E", hash_generated_method = "144D9F5811306E263A0B42085141274A")
    protected  HttpsURLConnectionImpl(URL url, int port, Proxy proxy) {
        super(url);
        delegate = new HttpUrlConnectionDelegate(url, port, proxy);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.218 -0400", hash_original_method = "EBF39AE3893E60948871AA1B184525FE", hash_generated_method = "F87B948E26373011EF04ACEEC2B8B583")
    private void checkConnected() {
        {
            boolean varBA474CA436F45D71B4740DB91291C434_882857970 = (delegate.getSSLSocket() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection has not yet been established");
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.218 -0400", hash_original_method = "974BBD03908437759747BBBC84511BEF", hash_generated_method = "8FC9F4C590A26C74A01C7BB24A7CB9B0")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_171295723 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_171295723 = delegate.getHttpEngine();
        varB4EAC82CA7396A68D541C85D26508E83_171295723.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_171295723;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.219 -0400", hash_original_method = "155731E74CA98125F972F21F897F0136", hash_generated_method = "2E9B5DBD472EEA70789B1A136AF2D3BD")
    @Override
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_360592446 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_174012368 = null; 
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_360592446 = cacheResponse.getCipherSuite();
        } 
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_174012368 = delegate.getSSLSocket().getSession().getCipherSuite();
        String varA7E53CE21691AB073D9660D615818899_2074491908; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2074491908 = varB4EAC82CA7396A68D541C85D26508E83_360592446;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2074491908 = varB4EAC82CA7396A68D541C85D26508E83_174012368;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2074491908.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2074491908;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.220 -0400", hash_original_method = "59A96612A195A833164564D75F7BEB2F", hash_generated_method = "174A23509C4BCDD7F234BEAD5A5B9FFA")
    @Override
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1302370893 = null; 
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1178019712 = null; 
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result = cacheResponse.getLocalCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_1302370893 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } 
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1178019712 = delegate.getSSLSocket().getSession().getLocalCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_991720858; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_991720858 = varB4EAC82CA7396A68D541C85D26508E83_1302370893;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_991720858 = varB4EAC82CA7396A68D541C85D26508E83_1178019712;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_991720858.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_991720858;
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.221 -0400", hash_original_method = "C50FDA18F5AC693D9D6A537F393FD7DA", hash_generated_method = "30F6B03961FDF5A5B88A7388FCEE0B9D")
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1823233370 = null; 
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2069558753 = null; 
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        {
            List<Certificate> result = cacheResponse.getServerCertificateChain();
            varB4EAC82CA7396A68D541C85D26508E83_1823233370 = result != null ? result.toArray(new Certificate[result.size()]) : null;
        } 
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_2069558753 = delegate.getSSLSocket().getSession().getPeerCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_1159345820; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1159345820 = varB4EAC82CA7396A68D541C85D26508E83_1823233370;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1159345820 = varB4EAC82CA7396A68D541C85D26508E83_2069558753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1159345820.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1159345820;
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.222 -0400", hash_original_method = "338E8C989701B6BF05274837B0D6BEE6", hash_generated_method = "869749FF10BFD66D8F6D765F8EF11A4B")
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_974529068 = null; 
        Principal varB4EAC82CA7396A68D541C85D26508E83_1794243595 = null; 
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_974529068 = cacheResponse.getPeerPrincipal();
        } 
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1794243595 = delegate.getSSLSocket().getSession().getPeerPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_1704504934; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1704504934 = varB4EAC82CA7396A68D541C85D26508E83_974529068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1704504934 = varB4EAC82CA7396A68D541C85D26508E83_1794243595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1704504934.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1704504934;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.223 -0400", hash_original_method = "F333957A90B5D4D5E51C5A4F24271433", hash_generated_method = "448FC67A1A5BE8F1899E148451F5B9C8")
    @Override
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_875507245 = null; 
        Principal varB4EAC82CA7396A68D541C85D26508E83_1746522776 = null; 
        SecureCacheResponse cacheResponse = delegate.getCacheResponse();
        {
            varB4EAC82CA7396A68D541C85D26508E83_875507245 = cacheResponse.getLocalPrincipal();
        } 
        checkConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1746522776 = delegate.getSSLSocket().getSession().getLocalPrincipal();
        Principal varA7E53CE21691AB073D9660D615818899_1292008541; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1292008541 = varB4EAC82CA7396A68D541C85D26508E83_875507245;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1292008541 = varB4EAC82CA7396A68D541C85D26508E83_1746522776;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1292008541.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1292008541;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.223 -0400", hash_original_method = "FAAF3AF27AC1EEEE821770BDB1E4029F", hash_generated_method = "857DA892330995E3B678761F6011BC98")
    @Override
    public void disconnect() {
        delegate.disconnect();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.224 -0400", hash_original_method = "D952402D6E6885573194FC664F511699", hash_generated_method = "89CF2AF42DF766FE2AE6B138353EEB66")
    @Override
    public InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1559338838 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1559338838 = delegate.getErrorStream();
        varB4EAC82CA7396A68D541C85D26508E83_1559338838.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1559338838;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.224 -0400", hash_original_method = "FC175FF243EBDFCBA74F286A11EBC730", hash_generated_method = "77EBF9351B36307554F0D814DF4CB67D")
    @Override
    public String getRequestMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1428826666 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1428826666 = delegate.getRequestMethod();
        varB4EAC82CA7396A68D541C85D26508E83_1428826666.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428826666;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.224 -0400", hash_original_method = "AD6F48AFE9EC6AE32D6CD6FE66C53E35", hash_generated_method = "1EA77F97083EF549F041483ECBAC558D")
    @Override
    public int getResponseCode() throws IOException {
        int varDC834023D584CBF2E5DE9F65DB0FB932_936616751 = (delegate.getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426050198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426050198;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.225 -0400", hash_original_method = "E5D5179DD117372174F65295E494F257", hash_generated_method = "797AD771305C04A8E1C5BE60095EB34E")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_440481581 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_440481581 = delegate.getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_440481581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_440481581;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.225 -0400", hash_original_method = "2C6B382BE152760ADFD195450C987C4D", hash_generated_method = "96C31B8B5ED1067D8DDD87E968D455E8")
    @Override
    public void setRequestMethod(String method) throws ProtocolException {
        delegate.setRequestMethod(method);
        addTaint(method.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.225 -0400", hash_original_method = "22D2496AF1B2839B389537158A9729AB", hash_generated_method = "40A634C5B309A194AAE7BD6B06FA407B")
    @Override
    public boolean usingProxy() {
        boolean var1A73319817A7BA58362FCE0126646E14_1906526249 = (delegate.usingProxy());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160925529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160925529;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.225 -0400", hash_original_method = "439C2855160035729D04975898C80087", hash_generated_method = "86645E49F3C3100CCF58E7B70CC1F54D")
    @Override
    public boolean getInstanceFollowRedirects() {
        boolean var36FEF060062CDCFFA52982B100EB3F06_1530800714 = (delegate.getInstanceFollowRedirects());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099371956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099371956;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.225 -0400", hash_original_method = "1CE78FDDD0E27462FCE8A63F52D5A42C", hash_generated_method = "B749037A4CF115D9FF640C306F206053")
    @Override
    public void setInstanceFollowRedirects(boolean followRedirects) {
        delegate.setInstanceFollowRedirects(followRedirects);
        addTaint(followRedirects);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.226 -0400", hash_original_method = "68AA9115D6CA56C77FCF489E5AF8B073", hash_generated_method = "8AEF26C3AC17AD5E888DC676C23600B8")
    @Override
    public void connect() throws IOException {
        connected = true;
        delegate.connect();
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.226 -0400", hash_original_method = "1B83D286A575B6A78D134EAC7C1D9DD3", hash_generated_method = "A139864027A06C9196F618A945CEB17A")
    @Override
    public boolean getAllowUserInteraction() {
        boolean varD52A0AC310FCDDF8EC36D9E6668695A1_1801414221 = (delegate.getAllowUserInteraction());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089589224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089589224;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.226 -0400", hash_original_method = "4D3C7B4DC86C2DF10766AF0DB6ED4BD8", hash_generated_method = "81885052850561EE9CF5A1BFB38BBC37")
    @Override
    public Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1665705478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1665705478 = delegate.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_1665705478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1665705478;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.227 -0400", hash_original_method = "8DEC3456606C9E626527D54BDEC95DC3", hash_generated_method = "3AB1410AF623DA693BB13C225DE30E17")
    @SuppressWarnings("unchecked")
    @Override
    public Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_16472854 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_16472854 = delegate.getContent(types);
        addTaint(types[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_16472854.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_16472854;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.227 -0400", hash_original_method = "ABBD3502C7527680B52B95AA3EC74AFC", hash_generated_method = "E5C119CE2FAAA03F34473C5723FFF775")
    @Override
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_181861599 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_181861599 = delegate.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_181861599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181861599;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.227 -0400", hash_original_method = "6C8CAEAF7A9319BC70F11CEE8387FB0A", hash_generated_method = "CE165D2B19D09BB41999D890EDEF988E")
    @Override
    public int getContentLength() {
        int var46C13ADE2970E578BB05FE5EEA0046DA_1055932521 = (delegate.getContentLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804138880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804138880;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "81BB131A6A631BF5E1A864757443FB7D", hash_generated_method = "1B027380B3EE31C8CC2130EC7A6FA22C")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1762420101 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1762420101 = delegate.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_1762420101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1762420101;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "5117770DF96AC50E368D6854F6F2A979", hash_generated_method = "889A789C1E317C2C3C063BCCB3A81021")
    @Override
    public long getDate() {
        long var347DC365CBC90FBE87EE28BA84488696_419550852 = (delegate.getDate());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1636479533 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1636479533;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "9C23E3A9AC3F55473DB136B9A49D2026", hash_generated_method = "C30CEFCDF580F8C6263C620736C4C3AE")
    @Override
    public boolean getDefaultUseCaches() {
        boolean var3FC2C68637FBA6BB6F081C916459E56C_527535316 = (delegate.getDefaultUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377776225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377776225;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "15EC744A02ED7BA3A5A6566722D66939", hash_generated_method = "007F9CA2BB840AFB49D6C92A0DC5ADEA")
    @Override
    public boolean getDoInput() {
        boolean var3AD6E1CD897116123B22123C5F9351D0_1222925505 = (delegate.getDoInput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25187757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25187757;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "5D82CAC9B7B4359D319F7AC87D71668E", hash_generated_method = "6E5834D187484DEF61B8D1300DBDCC13")
    @Override
    public boolean getDoOutput() {
        boolean varBB2AB3EEC37F983793BE7F09AA948961_2037312142 = (delegate.getDoOutput());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_333515828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_333515828;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.228 -0400", hash_original_method = "BC20C32698FC32A5759485BF0A84E23C", hash_generated_method = "75E26E2DA000B6F04F665109F9BBD8B9")
    @Override
    public long getExpiration() {
        long varC51716E5D8873132B8303EA472292149_1681348386 = (delegate.getExpiration());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_620548740 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_620548740;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.229 -0400", hash_original_method = "DAE76134F84E2121B4429AAD80303201", hash_generated_method = "36069BE9C0E03F70693983AAE2ABD024")
    @Override
    public String getHeaderField(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_301913737 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_301913737 = delegate.getHeaderField(pos);
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_301913737.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_301913737;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.229 -0400", hash_original_method = "BB20372E5EE6EF8C43C84B6146823EE4", hash_generated_method = "CC15A426619B7010153054B4F03F0E8D")
    @Override
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_201255211 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_201255211 = delegate.getHeaderFields();
        varB4EAC82CA7396A68D541C85D26508E83_201255211.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_201255211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.230 -0400", hash_original_method = "3103302F4CC7F7FF9EDEB8586989C2F9", hash_generated_method = "318404B218C3FC568CFEA2C97C1ECD08")
    @Override
    public Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1122793108 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1122793108 = delegate.getRequestProperties();
        varB4EAC82CA7396A68D541C85D26508E83_1122793108.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1122793108;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.230 -0400", hash_original_method = "BA9A614E0D58CD60F498CC567B2500F2", hash_generated_method = "5B496D640FDFED5ABDD99EF1524459C4")
    @Override
    public void addRequestProperty(String field, String newValue) {
        delegate.addRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.230 -0400", hash_original_method = "26A5E0D486707FEDEA1C6EC7C371F3C4", hash_generated_method = "96DBF7A94CABF8F61C4E02687B4EC213")
    @Override
    public String getHeaderField(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_2010029788 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2010029788 = delegate.getHeaderField(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2010029788.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2010029788;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.231 -0400", hash_original_method = "81F98E073E99F771F5BC04C4A034001B", hash_generated_method = "9AF0FC8D4E261026CEEC04CAD4A54F02")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        long varF9B0FA24B3C89487E1F0C5C4DEFD1A6F_1206178561 = (delegate.getHeaderFieldDate(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1241491679 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1241491679;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.231 -0400", hash_original_method = "DE18D057A993F545C1495B93B6465BD1", hash_generated_method = "6B41388C21A7E423B3765A23AD5875B3")
    @Override
    public int getHeaderFieldInt(String field, int defaultValue) {
        int var9141D4C32956F8B7698AADB6AE35E322_651819887 = (delegate.getHeaderFieldInt(field, defaultValue));
        addTaint(field.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738451868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738451868;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.231 -0400", hash_original_method = "3D8E3857D0E1E94EB69AD159FAC02777", hash_generated_method = "38C591AC205F5B696C9F4E7B299DED22")
    @Override
    public String getHeaderFieldKey(int posn) {
        String varB4EAC82CA7396A68D541C85D26508E83_1377958465 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1377958465 = delegate.getHeaderFieldKey(posn);
        addTaint(posn);
        varB4EAC82CA7396A68D541C85D26508E83_1377958465.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1377958465;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.232 -0400", hash_original_method = "A637AA3684679F9C42FC6E7420DEC61B", hash_generated_method = "CE61EF040B9B31C34F9FD6E1AA1FE1D2")
    @Override
    public long getIfModifiedSince() {
        long var2F648525489FF1333DA0B755237FF143_1475201841 = (delegate.getIfModifiedSince());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1856897164 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1856897164;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.232 -0400", hash_original_method = "FAABEF995D60E668FB295911EFFB6D5E", hash_generated_method = "CEC9E93E16578901FF85745D4C025689")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1876151118 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1876151118 = delegate.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1876151118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876151118;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.232 -0400", hash_original_method = "6BE2970030EDACDD8BD4DF51355B8423", hash_generated_method = "E9FF02E6DA9957FCBC75EA31872957DE")
    @Override
    public long getLastModified() {
        long var426E8D7A6E590ED1F9B47C7958BE51AD_1294433575 = (delegate.getLastModified());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_47738758 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_47738758;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.233 -0400", hash_original_method = "71AA63E6E74D761830B069C27085564C", hash_generated_method = "DD15C9D802932F5D6DA976C22B48BC37")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1147672101 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1147672101 = delegate.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1147672101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1147672101;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.233 -0400", hash_original_method = "88A49F792111172FBCFE768F5707BEFA", hash_generated_method = "E46DFCD318D00C54DAC1707DADFC46F6")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_693300782 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_693300782 = delegate.getPermission();
        varB4EAC82CA7396A68D541C85D26508E83_693300782.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_693300782;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.234 -0400", hash_original_method = "4FEF6B093C5D8D6C61A98244E23E68F9", hash_generated_method = "052E5614E8F7346082AF48BAF126847E")
    @Override
    public String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_909563166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_909563166 = delegate.getRequestProperty(field);
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_909563166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_909563166;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.234 -0400", hash_original_method = "F4484503A21727E01861772B7BDC0B42", hash_generated_method = "76AAEBC746EF931ADE7EAC6EB043BF0C")
    @Override
    public URL getURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_986434257 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_986434257 = delegate.getURL();
        varB4EAC82CA7396A68D541C85D26508E83_986434257.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_986434257;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.235 -0400", hash_original_method = "4985D2BB79DFCDA8A0FDD0ED30423692", hash_generated_method = "6610D04F12BF14169CCCA8DB5F96B761")
    @Override
    public boolean getUseCaches() {
        boolean varF45B15791721B7C5A39E6EC8FCE0C874_91746438 = (delegate.getUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392103227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392103227;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.235 -0400", hash_original_method = "E67509C1EAE75E8F0E616AF503875962", hash_generated_method = "02757753814864D79B417A4E5560E6EA")
    @Override
    public void setAllowUserInteraction(boolean newValue) {
        delegate.setAllowUserInteraction(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.235 -0400", hash_original_method = "155D8D948EB2756D2E02BD36D7B9A981", hash_generated_method = "3C3C89655A3D6AECD88D33B37547EC97")
    @Override
    public void setDefaultUseCaches(boolean newValue) {
        delegate.setDefaultUseCaches(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.236 -0400", hash_original_method = "DBFBE38519C2ED2CAD57B85CDCF157A7", hash_generated_method = "DE7B6452AD8A3FE1A7045875984FE6A2")
    @Override
    public void setDoInput(boolean newValue) {
        delegate.setDoInput(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.236 -0400", hash_original_method = "4C7DD3E9EB706BD0B590423DABADE520", hash_generated_method = "AA8A96B085C00AD18F5980AC73553873")
    @Override
    public void setDoOutput(boolean newValue) {
        delegate.setDoOutput(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.236 -0400", hash_original_method = "0CABFED9F9019D2C3BA169C5A2DB9982", hash_generated_method = "D14199A3B941EEE74B5D2C6648A5F597")
    @Override
    public void setIfModifiedSince(long newValue) {
        delegate.setIfModifiedSince(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.236 -0400", hash_original_method = "06E81C177B17FA690704B9F52C2E2188", hash_generated_method = "6B6D20991C7095A3C9F78228FC1B9636")
    @Override
    public void setRequestProperty(String field, String newValue) {
        delegate.setRequestProperty(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.237 -0400", hash_original_method = "9DD3A94ED9DC7E27933AACD0BEB1B2CF", hash_generated_method = "927600B68A0BF85DC96C4DC0C7806FFD")
    @Override
    public void setUseCaches(boolean newValue) {
        delegate.setUseCaches(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.237 -0400", hash_original_method = "EF4CCDEC725CA0081AEF3F1DD3AA2FF3", hash_generated_method = "30ADD793C24680380480910105D6F638")
    @Override
    public void setConnectTimeout(int timeout) {
        delegate.setConnectTimeout(timeout);
        addTaint(timeout);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.237 -0400", hash_original_method = "71D878565F9CF54F7701444C0AD48792", hash_generated_method = "8332EB9C02404E3CDB36F67CEF91C39B")
    @Override
    public int getConnectTimeout() {
        int var44D58E8907D6B3B15AC45D93D9FF2214_485135392 = (delegate.getConnectTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956410184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956410184;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.237 -0400", hash_original_method = "602DF27834E77E85211B3744966AE6ED", hash_generated_method = "14E84308D3CFF1DBE96F7FF169D33305")
    @Override
    public void setReadTimeout(int timeout) {
        delegate.setReadTimeout(timeout);
        addTaint(timeout);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.237 -0400", hash_original_method = "5E9CC5D1351390EBFBC54A20520520CA", hash_generated_method = "0F4DE3A4C09D0DC0A825BF7DD9788377")
    @Override
    public int getReadTimeout() {
        int var6AA840C9DF82A442D7F21A3A02E813E8_259187592 = (delegate.getReadTimeout());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609375919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609375919;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.238 -0400", hash_original_method = "191DD44584BFD7834B75AD1CE9E17770", hash_generated_method = "F57968D41E63DFCD4A5F1DF29F7967B2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1941271392 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1941271392 = delegate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1941271392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1941271392;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.238 -0400", hash_original_method = "F9300CAD817EA355A1DED8FDB2C663E0", hash_generated_method = "509A3EF6AD1E19EC7C99267806699592")
    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
        delegate.setFixedLengthStreamingMode(contentLength);
        addTaint(contentLength);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.238 -0400", hash_original_method = "F190D6D21DD2676D30EC542F0B391145", hash_generated_method = "B5561F2543E0B374874DFB2AF81D7456")
    @Override
    public void setChunkedStreamingMode(int chunkLength) {
        delegate.setChunkedStreamingMode(chunkLength);
        addTaint(chunkLength);
        
        
    }

    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.239 -0400", hash_original_method = "3AF8C0CBB6814014DDC85DEC3B91D01C", hash_generated_method = "50A8EEC8FB19EF703EB1D2AD125E34DD")
        private  HttpUrlConnectionDelegate(URL url, int port) {
            super(url, port);
            addTaint(url.getTaint());
            addTaint(port);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.239 -0400", hash_original_method = "A74BDB7D7A715A5C0D19C172C28B7777", hash_generated_method = "E9B5447036109B1EF5921CBC009F2D5F")
        private  HttpUrlConnectionDelegate(URL url, int port, Proxy proxy) {
            super(url, port, proxy);
            addTaint(url.getTaint());
            addTaint(port);
            addTaint(proxy.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.240 -0400", hash_original_method = "FFC1DB14C914B560B0C4A38C980238E1", hash_generated_method = "2FD9EA945062749393F45C40947B8A01")
        @Override
        protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
                HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
            HttpEngine varB4EAC82CA7396A68D541C85D26508E83_2873177 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2873177 = new HttpsEngine(this, method, requestHeaders, connection, requestBody,
                    HttpsURLConnectionImpl.this);
            addTaint(method.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestBody.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2873177.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2873177;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.242 -0400", hash_original_method = "A8CE37181DEBD97DFD2BB41BFF08AE80", hash_generated_method = "AFA59A9C6AA4EA36C3BACDA6878AD93E")
        public SecureCacheResponse getCacheResponse() {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_215273032 = null; 
            HttpsEngine engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_215273032 = engine != null ? (SecureCacheResponse) engine.getCacheResponse() : null;
            varB4EAC82CA7396A68D541C85D26508E83_215273032.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_215273032;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.244 -0400", hash_original_method = "F3639B01983CFF48B5D8296AB1C5BDBE", hash_generated_method = "BDFBFEEF3508A61ED59329969D28570E")
        public SSLSocket getSSLSocket() {
            SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1227038992 = null; 
            HttpsEngine engine = (HttpsEngine) httpEngine;
            varB4EAC82CA7396A68D541C85D26508E83_1227038992 = engine != null ? engine.sslSocket : null;
            varB4EAC82CA7396A68D541C85D26508E83_1227038992.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1227038992;
            
            
            
        }

        
    }


    
    private static class HttpsEngine extends HttpEngine {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.245 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

        private SSLSocket sslSocket;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.245 -0400", hash_original_field = "06B167584A75871D42FCD159D2218E9A", hash_generated_field = "02DC0A0E916639252FA2CD832BAB1719")

        private HttpsURLConnectionImpl enclosing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.246 -0400", hash_original_method = "8AE083BB8B8AC6DA8D0AC1B890A493FE", hash_generated_method = "62C2DDAC8588DD301A50D31B54A2D261")
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
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.247 -0400", hash_original_method = "2764C3EBE7E55CBE19AD199214E9E45F", hash_generated_method = "02E6ECFDCF5CEDF5B6F74C745F2B66D5")
        @Override
        protected void connect() throws IOException {
            boolean connectionReused;
            try 
            {
                connectionReused = makeSslConnection(true);
            } 
            catch (IOException e)
            {
                {
                    boolean var3AC4DFFE7CC4939DF7C4ED033B861EC8_686699089 = (e instanceof SSLHandshakeException
                        && e.getCause() instanceof CertificateException);
                    {
                        if (DroidSafeAndroidRuntime.control) throw e;
                    } 
                } 
                release(false);
                connectionReused = makeSslConnection(false);
            } 
            {
                sslSocket = connection.verifySecureSocketHostname(enclosing.getHostnameVerifier());
            } 
            
            
            
                
            
                
                        
                    
                
                
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.248 -0400", hash_original_method = "E179043C81F65C857C0C51A1F43AC946", hash_generated_method = "D53A04F55AB2ED0F0725AE506DFE473F")
        private boolean makeSslConnection(boolean tlsTolerant) throws IOException {
            {
                connection = openSocketConnection();
                {
                    boolean var8E696082C46988ED27CC92AF7EEC78DA_196631073 = (connection.getAddress().getProxy() != null);
                    {
                        makeTunnel(policy, connection, getRequestHeaders());
                    } 
                } 
            } 
            sslSocket = connection.getSecureSocketIfConnected();
            connection.setupSecureSocket(enclosing.getSSLSocketFactory(), tlsTolerant);
            addTaint(tlsTolerant);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505721211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_505721211;
            
            
                
                
                    
                
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.249 -0400", hash_original_method = "8A9A8685511C9FB74B559F38C5A36FB4", hash_generated_method = "F1868E9E17BA72DDFB90A76BF29343EB")
        private void makeTunnel(HttpURLConnectionImpl policy, HttpConnection connection,
                RequestHeaders requestHeaders) throws IOException {
            RawHeaders rawRequestHeaders = requestHeaders.getHeaders();
            {
                HttpEngine connect = new ProxyConnectEngine(policy, rawRequestHeaders, connection);
                connect.sendRequest();
                connect.readResponse();
                int responseCode = connect.getResponseCode();
                {
                    Object varE3D66A7026D8BFDE15E135A9F3AF9D8C_2069762151 = (connect.getResponseCode());
                    
                    rawRequestHeaders = new RawHeaders(rawRequestHeaders);
                    
                    
                    boolean credentialsFound = policy.processAuthHeader(HTTP_PROXY_AUTH,
                            connect.getResponseHeaders(), rawRequestHeaders);
                    
                    
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Failed to authenticate with proxy");
                    } 
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Unexpected response code for CONNECT: " + responseCode);
                    
                } 
            } 
            addTaint(policy.getTaint());
            addTaint(connection.getTaint());
            addTaint(requestHeaders.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.250 -0400", hash_original_method = "E90F26103F02D3FE62A3059524C5B610", hash_generated_method = "737838A5CF7BDD8B4FDBE12D83100480")
        @Override
        protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
            addTaint(cacheResponse.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884233107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_884233107;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.250 -0400", hash_original_method = "7AEFB2847C4237E3ACCA6586A2D947A2", hash_generated_method = "C6E86E6DBCB38E333BE4804359E90EA7")
        @Override
        protected boolean includeAuthorityInRequestLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386806673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386806673;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.251 -0400", hash_original_method = "F1E50F3C05FEF05D40BA1FEDA33CCDCF", hash_generated_method = "56AE574FA71798D523D3FD2F9DFEEA3C")
        @Override
        protected HttpURLConnection getHttpConnectionToCache() {
            HttpURLConnection varB4EAC82CA7396A68D541C85D26508E83_1276355967 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1276355967 = enclosing;
            varB4EAC82CA7396A68D541C85D26508E83_1276355967.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1276355967;
            
            
        }

        
    }


    
    private static class ProxyConnectEngine extends HttpEngine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.252 -0400", hash_original_method = "253DCEEC4E85075EF2717AE1BE2B3A60", hash_generated_method = "FC467743B88D50776BC092FFC979445E")
        public  ProxyConnectEngine(HttpURLConnectionImpl policy, RawHeaders requestHeaders,
                HttpConnection connection) throws IOException {
            super(policy, HttpEngine.CONNECT, requestHeaders, connection, null);
            addTaint(policy.getTaint());
            addTaint(requestHeaders.getTaint());
            addTaint(connection.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.253 -0400", hash_original_method = "4E873E328DE258FE448018732F781F9A", hash_generated_method = "A2F3B365844A2E3EBD2987EF43131A4A")
        @Override
        protected RawHeaders getNetworkRequestHeaders() throws IOException {
            RawHeaders varB4EAC82CA7396A68D541C85D26508E83_936145689 = null; 
            RequestHeaders privateHeaders = getRequestHeaders();
            URL url = policy.getURL();
            RawHeaders result = new RawHeaders();
            result.setStatusLine("CONNECT " + url.getHost() + ":" + url.getEffectivePort()
                    + " HTTP/1.1");
            String host = privateHeaders.getHost();
            {
                host = getOriginAddress(url);
            } 
            result.set("Host", host);
            String userAgent = privateHeaders.getUserAgent();
            {
                userAgent = getDefaultUserAgent();
            } 
            result.set("User-Agent", userAgent);
            String proxyAuthorization = privateHeaders.getProxyAuthorization();
            {
                result.set("Proxy-Authorization", proxyAuthorization);
            } 
            result.set("Proxy-Connection", "Keep-Alive");
            varB4EAC82CA7396A68D541C85D26508E83_936145689 = result;
            varB4EAC82CA7396A68D541C85D26508E83_936145689.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_936145689;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.254 -0400", hash_original_method = "8CAA920CAFADAC8866B230CA35502445", hash_generated_method = "7A05E66C7F7662465FA822424469B23D")
        @Override
        protected boolean requiresTunnel() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676426774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676426774;
            
            
        }

        
    }


    
}

