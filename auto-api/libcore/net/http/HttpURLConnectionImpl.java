package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.nio.charset.Charsets;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import libcore.io.Base64;

class HttpURLConnectionImpl extends HttpURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "C02B6920286CEE389E703ADA43236DB7", hash_generated_field = "8901C38E8957C4A2EFEC6534B9EB9BEE")

    private final RawHeaders rawRequestHeaders = new RawHeaders();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "F24FBA8C419BC9FD2E48BCA15C14AACF", hash_generated_field = "EC2EBB12D4ECEAB53DC00655B16FEA0F")

    private int redirectionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "3C47E1E05D3879469502E6F58E1CAE6D", hash_generated_field = "7A97BD477901CB40BE3809D713545FCF")

    protected IOException httpEngineFailure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.128 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.129 -0400", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "2C1B9C1D66985D7A0121D87CDF841E32")
    protected  HttpURLConnectionImpl(URL url, int port) {
        super(url);
        defaultPort = port;
        addTaint(url.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.129 -0400", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "FB613379D440B80A9E0688E06C916D18")
    protected  HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        this.proxy = proxy;
        addTaint(url.getTaint());
        addTaint(port);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.129 -0400", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "B08642E815393E5148D7A6F89EC76906")
    @Override
    public final void connect() throws IOException {
        initHttpEngine();
        try 
        {
            httpEngine.sendRequest();
        } 
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.130 -0400", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "E7767C0DEF86453F38282A3F19B4B27E")
    @Override
    public final void disconnect() {
        {
            httpEngine.release(false);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.130 -0400", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "DA2AAE183B5F290FE0C09E7ED2940DCA")
    @Override
    public final InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_33740445 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_98823714 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_31071283 = null; 
        try 
        {
            HttpEngine response = getResponse();
            {
                boolean varD7347A00FCC783C9748325680F5F39D3_1982355505 = (response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_33740445 = response.getResponseBody();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_98823714 = null;
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_31071283 = null;
        } 
        InputStream varA7E53CE21691AB073D9660D615818899_1869625062; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1869625062 = varB4EAC82CA7396A68D541C85D26508E83_33740445;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1869625062 = varB4EAC82CA7396A68D541C85D26508E83_98823714;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1869625062 = varB4EAC82CA7396A68D541C85D26508E83_31071283;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1869625062.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1869625062;
        
        
            
            
                    
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.131 -0400", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "39675AC2C2ACFD37226F14565C64E210")
    @Override
    public final String getHeaderField(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_126387277 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_462343015 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_126387277 = getResponse().getResponseHeaders().getHeaders().getValue(position);
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_462343015 = null;
        } 
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_567230967; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_567230967 = varB4EAC82CA7396A68D541C85D26508E83_126387277;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_567230967 = varB4EAC82CA7396A68D541C85D26508E83_462343015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_567230967.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_567230967;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.132 -0400", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "0D9F2A124BD1C557F8BF109E479C5855")
    @Override
    public final String getHeaderField(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_294007448 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1894046226 = null; 
        try 
        {
            RawHeaders rawHeaders = getResponse().getResponseHeaders().getHeaders();
            varB4EAC82CA7396A68D541C85D26508E83_294007448 = fieldName == null
                    ? rawHeaders.getStatusLine()
                    : rawHeaders.get(fieldName);
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1894046226 = null;
        } 
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_236063576; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_236063576 = varB4EAC82CA7396A68D541C85D26508E83_294007448;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_236063576 = varB4EAC82CA7396A68D541C85D26508E83_1894046226;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_236063576.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_236063576;
        
        
            
            
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.134 -0400", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "B7A0A8E2E7BFA38A609F2B6EDB51F970")
    @Override
    public final String getHeaderFieldKey(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_975883653 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_42329630 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_975883653 = getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_42329630 = null;
        } 
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_111193364; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_111193364 = varB4EAC82CA7396A68D541C85D26508E83_975883653;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_111193364 = varB4EAC82CA7396A68D541C85D26508E83_42329630;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_111193364.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_111193364;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.134 -0400", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "4A362F285082284148317D84F7CB89C5")
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1846261825 = null; 
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1383930913 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1846261825 = getResponse().getResponseHeaders().getHeaders().toMultimap();
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1383930913 = null;
        } 
        Map<String, List<String>> varA7E53CE21691AB073D9660D615818899_935759273; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_935759273 = varB4EAC82CA7396A68D541C85D26508E83_1846261825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_935759273 = varB4EAC82CA7396A68D541C85D26508E83_1383930913;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_935759273.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_935759273;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.135 -0400", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "DDE7B05D60D2B9CC53F5DACF5BA7DFA8")
    @Override
    public final Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_181107960 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot access request header fields after connection is set");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_181107960 = rawRequestHeaders.toMultimap();
        varB4EAC82CA7396A68D541C85D26508E83_181107960.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181107960;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.135 -0400", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "5A869E163A123CDF04E1D9ABA8AFB34B")
    @Override
    public final InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2000869348 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("This protocol does not support input");
        } 
        HttpEngine response = getResponse();
        {
            boolean varD8022199865993DD9F92A0CC3F71EE2C_1738738412 = (getResponseCode() >= HTTP_BAD_REQUEST);
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(url.toString());
            } 
        } 
        InputStream result = response.getResponseBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No response body exists; responseCode=" + getResponseCode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2000869348 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2000869348.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2000869348;
        
        
            
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.136 -0400", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "EBA6ED8D36F5045A3D7CE4050120AAD9")
    @Override
    public final OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_282764697 = null; 
        connect();
        OutputStream result = httpEngine.getRequestBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("method does not support a request body: " + method);
        } 
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_1637832355 = (httpEngine.hasResponse());
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("cannot write request body after response has been read");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_282764697 = result;
        varB4EAC82CA7396A68D541C85D26508E83_282764697.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_282764697;
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.136 -0400", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "350CE3374661642D28B74FE4CA57847C")
    @Override
    public final Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1234463723 = null; 
        String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        varB4EAC82CA7396A68D541C85D26508E83_1234463723 = new SocketPermission(connectToAddress, "connect, resolve");
        varB4EAC82CA7396A68D541C85D26508E83_1234463723.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1234463723;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.137 -0400", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "97A3C7355F55182F398BC3FA21371EFC")
    private String getConnectToHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_2058744467 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2058744467 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getHostName()
                : getURL().getHost();
        varB4EAC82CA7396A68D541C85D26508E83_2058744467.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2058744467;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.137 -0400", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "A0089B1F0ED099189A86A7051C21635D")
    private int getConnectToPort() {
        int hostPort;
        boolean varF06E67F8D313A89972318AEDC57EC5D5_903702355 = (usingProxy());
        hostPort = ((InetSocketAddress) proxy.address()).getPort();
        hostPort = getURL().getPort();
        {
            Object var55AFC7D50DDC7EC77B4E62135E02DAE7_1697192210 = (getDefaultPort());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903357742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903357742;
        
        
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.138 -0400", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "01A428E32AE3B45920253566204DD0D8")
    @Override
    public final String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_1545377359 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_909575788 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1545377359 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_909575788 = rawRequestHeaders.get(field);
        addTaint(field.getTaint());
        String varA7E53CE21691AB073D9660D615818899_186091671; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_186091671 = varB4EAC82CA7396A68D541C85D26508E83_1545377359;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_186091671 = varB4EAC82CA7396A68D541C85D26508E83_909575788;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_186091671.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_186091671;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.138 -0400", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "1ED67F477FF202290349A8C07FD13747")
    private void initHttpEngine() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw httpEngineFailure;
        } 
        connected = true;
        try 
        {
            {
                {
                    method = HttpEngine.POST;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException(method + " does not support writing");
                } 
            } 
            httpEngine = newHttpEngine(method, rawRequestHeaders, null, null);
        } 
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        
        
            
        
            
        
        
        
            
                
                    
                
                    
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.139 -0400", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "89881DD346236DFCA4A8FF6C6F5F7926")
    protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_561523001 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_561523001 = new HttpEngine(this, method, requestHeaders, connection, requestBody);
        addTaint(method.getTaint());
        addTaint(requestHeaders.getTaint());
        addTaint(connection.getTaint());
        addTaint(requestBody.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_561523001.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_561523001;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.140 -0400", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "357075426617CEE5B9F7D1919A360983")
    private HttpEngine getResponse() throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_380258777 = null; 
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1446387064 = null; 
        initHttpEngine();
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_954580106 = (httpEngine.hasResponse());
            {
                varB4EAC82CA7396A68D541C85D26508E83_380258777 = httpEngine;
            } 
        } 
        try 
        {
            {
                httpEngine.sendRequest();
                httpEngine.readResponse();
                Retry retry = processResponseHeaders();
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                } 
                String retryMethod = method;
                OutputStream requestBody = httpEngine.getRequestBody();
                int responseCode = getResponseCode();
                {
                    retryMethod = HttpEngine.GET;
                    requestBody = null;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new HttpRetryException("Cannot retry streamed HTTP body",
                            httpEngine.getResponseCode());
                } 
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                } 
                httpEngine.release(true);
                httpEngine = newHttpEngine(retryMethod, rawRequestHeaders,
                        httpEngine.getConnection(), (RetryableOutputStream) requestBody);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1446387064 = httpEngine;
        } 
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        HttpEngine varA7E53CE21691AB073D9660D615818899_1754380856; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1754380856 = varB4EAC82CA7396A68D541C85D26508E83_380258777;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1754380856 = varB4EAC82CA7396A68D541C85D26508E83_1446387064;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1754380856.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1754380856;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.140 -0400", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "4E84B2F726FF5FA3D3CE5BAAB552255C")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_413291152 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_413291152 = httpEngine;
        varB4EAC82CA7396A68D541C85D26508E83_413291152.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_413291152;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.141 -0400", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "40EE529A036214919941E7964E684533")
    private Retry processResponseHeaders() throws IOException {
        Retry varB4EAC82CA7396A68D541C85D26508E83_787720590 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_2095589334 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_1219565023 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_1460607696 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_293877160 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_1116249612 = null; 
        Retry varB4EAC82CA7396A68D541C85D26508E83_32036001 = null; 
        {
            Object var20F042546572D69C7A9AC081DF38D953_651540064 = (getResponseCode());
            
            {
                boolean var2930139243087265820932B7BDB2A558_978591734 = (!usingProxy());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } 
            } 
            
            
            boolean credentialsFound = processAuthHeader(getResponseCode(),
                    httpEngine.getResponseHeaders(), rawRequestHeaders);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_787720590 = credentialsFound ? Retry.SAME_CONNECTION : Retry.NONE;
            
            
            {
                boolean var4231036716F9E7BE127364976920804F_833270498 = (!getInstanceFollowRedirects());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2095589334 = Retry.NONE;
                } 
            } 
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Too many redirects");
            } 
            
            
            String location = getHeaderField("Location");
            
            
            {
                varB4EAC82CA7396A68D541C85D26508E83_1219565023 = Retry.NONE;
            } 
            
            
            URL previousUrl = url;
            
            
            url = new URL(previousUrl, location);
            
            
            {
                boolean var127C9F96D37ED4D3E737D93D37262DCE_2027686855 = (!previousUrl.getProtocol().equals(url.getProtocol()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1460607696 = Retry.NONE;
                } 
            } 
            
            
            {
                boolean var75E1451812FE086497460E33682B0EAF_1137730731 = (previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_293877160 = Retry.SAME_CONNECTION;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1116249612 = Retry.DIFFERENT_CONNECTION;
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_32036001 = Retry.NONE;
            
        } 
        Retry varA7E53CE21691AB073D9660D615818899_1071583286; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_787720590;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_2095589334;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_1219565023;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_1460607696;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_293877160;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_1116249612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1071583286 = varB4EAC82CA7396A68D541C85D26508E83_32036001;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1071583286.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1071583286;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.142 -0400", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "71F0143DA8F9183E49AABA02C0CFE873")
    final boolean processAuthHeader(int responseCode, ResponseHeaders response,
            RawHeaders successorRequestHeaders) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        String challenge;
        challenge = response.getProxyAuthenticate();
        challenge = response.getWwwAuthenticate();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Received authentication challenge is null");
        } 
        String credentials = getAuthorizationCredentials(challenge);
        String fieldName;
        fieldName = "Proxy-Authorization";
        fieldName = "Authorization";
        successorRequestHeaders.set(fieldName, credentials);
        addTaint(responseCode);
        addTaint(response.getTaint());
        addTaint(successorRequestHeaders.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785265105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785265105;
        
        
            
        
        
                
                
        
            
        
        
        
            
        
        
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.144 -0400", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "E643457A534390CD2CB545438490FDB9")
    private String getAuthorizationCredentials(String challenge) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_699948173 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_490246452 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1028042742 = null; 
        int idx = challenge.indexOf(" ");
        {
            varB4EAC82CA7396A68D541C85D26508E83_699948173 = null;
        } 
        String scheme = challenge.substring(0, idx);
        int realm = challenge.indexOf("realm=\"") + 7;
        String prompt = null;
        {
            int end = challenge.indexOf('"', realm);
            {
                prompt = challenge.substring(realm, end);
            } 
        } 
        PasswordAuthentication pa = Authenticator.requestPasswordAuthentication(
                getConnectToInetAddress(), getConnectToPort(), url.getProtocol(), prompt, scheme);
        {
            varB4EAC82CA7396A68D541C85D26508E83_490246452 = null;
        } 
        String usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded = Base64.encode(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1028042742 = scheme + " " + encoded;
        addTaint(challenge.getTaint());
        String varA7E53CE21691AB073D9660D615818899_477177065; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_477177065 = varB4EAC82CA7396A68D541C85D26508E83_699948173;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_477177065 = varB4EAC82CA7396A68D541C85D26508E83_490246452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_477177065 = varB4EAC82CA7396A68D541C85D26508E83_1028042742;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_477177065.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_477177065;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.146 -0400", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "01714574BDD96A2691394EC7C524658C")
    private InetAddress getConnectToInetAddress() throws IOException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_251000964 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_251000964 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getAddress()
                : InetAddress.getByName(getURL().getHost());
        varB4EAC82CA7396A68D541C85D26508E83_251000964.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_251000964;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.146 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "61307CDE613A6946E6D54291BE16B2E5")
    final int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003646013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003646013;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.147 -0400", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "BAC3B949483CA2272253A41A8CB914E6")
    final int getFixedContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128675476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128675476;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.147 -0400", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "547672A30D0DD073982DBB1E0DE51BDD")
    final int getChunkLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832338132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832338132;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.148 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "D120E17525CAD3265BF0787870935C21")
    final Proxy getProxy() {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_2025162916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2025162916 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_2025162916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2025162916;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.148 -0400", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "8F3413271570AEBF18F485ACB70ADDF9")
    final void setProxy(Proxy proxy) {
        this.proxy = proxy;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.148 -0400", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "A1AFC4C42E9DCF444226176707250E6B")
    @Override
    public final boolean usingProxy() {
        boolean var16D5082FA751067548E744F8E069E68A_1593838586 = ((proxy != null && proxy.type() != Proxy.Type.DIRECT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243953318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243953318;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.149 -0400", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "755308C631A0052D1055B066161BC2FC")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_273512050 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_273512050 = getResponse().getResponseHeaders().getHeaders().getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_273512050.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_273512050;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.149 -0400", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "8888B892D73987DD43B5EE3A2EC1643D")
    @Override
    public final int getResponseCode() throws IOException {
        int varDC13817E00562421F93742BC26746AB9_497634364 = (getResponse().getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870196781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870196781;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.149 -0400", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "AB976BA80845AE137C4065E8E7E93B41")
    @Override
    public final void setRequestProperty(String field, String newValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot set request property after connection is made");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } 
        rawRequestHeaders.set(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.149 -0400", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "74F8CD8124DD50C32F80F311EBBF6DB7")
    @Override
    public final void addRequestProperty(String field, String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot add request property after connection is made");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } 
        rawRequestHeaders.add(field, value);
        addTaint(field.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
        
        
    }

    
    enum Retry {
        NONE,
        SAME_CONNECTION,
        DIFFERENT_CONNECTION
    }

    
}

