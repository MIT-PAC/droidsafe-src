package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.458 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.458 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.458 -0400", hash_original_field = "C02B6920286CEE389E703ADA43236DB7", hash_generated_field = "8901C38E8957C4A2EFEC6534B9EB9BEE")

    private final RawHeaders rawRequestHeaders = new RawHeaders();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.458 -0400", hash_original_field = "F24FBA8C419BC9FD2E48BCA15C14AACF", hash_generated_field = "EC2EBB12D4ECEAB53DC00655B16FEA0F")

    private int redirectionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.459 -0400", hash_original_field = "3C47E1E05D3879469502E6F58E1CAE6D", hash_generated_field = "7A97BD477901CB40BE3809D713545FCF")

    protected IOException httpEngineFailure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.459 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.459 -0400", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "7CBA8FCA196AEE6B9E9044A4807B746E")
    protected  HttpURLConnectionImpl(URL url, int port) {
        super(url);
        addTaint(url.getTaint());
        defaultPort = port;
        // ---------- Original Method ----------
        //defaultPort = port;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.460 -0400", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "EB0F23C10BF92F54B6E07023E872F21C")
    protected  HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        addTaint(port);
        addTaint(url.getTaint());
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.460 -0400", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "E1FD78B75D60F97B5383D361BAFF6510")
    @Override
    public final void connect() throws IOException {
        initHttpEngine();
        try 
        {
            httpEngine.sendRequest();
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        //initHttpEngine();
        //try {
            //httpEngine.sendRequest();
        //} catch (IOException e) {
            //httpEngineFailure = e;
            //throw e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.460 -0400", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "0AFE0B763AD05292C20589E8E763F275")
    @Override
    public final void disconnect() {
    if(httpEngine != null)        
        {
            httpEngine.release(false);
        } //End block
        // ---------- Original Method ----------
        //if (httpEngine != null) {
            //httpEngine.release(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.461 -0400", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "FD3EB03A100F2722DA1A7092CA002036")
    @Override
    public final InputStream getErrorStream() {
        try 
        {
            HttpEngine response = getResponse();
    if(response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST)            
            {
InputStream var630F79CB87EE19EB59841F077F4677AC_84542005 =                 response.getResponseBody();
                var630F79CB87EE19EB59841F077F4677AC_84542005.addTaint(taint);
                return var630F79CB87EE19EB59841F077F4677AC_84542005;
            } //End block
InputStream var540C13E9E156B687226421B24F2DF178_862886323 =             null;
            var540C13E9E156B687226421B24F2DF178_862886323.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_862886323;
        } //End block
        catch (IOException e)
        {
InputStream var540C13E9E156B687226421B24F2DF178_572070240 =             null;
            var540C13E9E156B687226421B24F2DF178_572070240.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_572070240;
        } //End block
        // ---------- Original Method ----------
        //try {
            //HttpEngine response = getResponse();
            //if (response.hasResponseBody()
                    //&& response.getResponseCode() >= HTTP_BAD_REQUEST) {
                //return response.getResponseBody();
            //}
            //return null;
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.461 -0400", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "7D0A9B0479C7288BF62285259BA88863")
    @Override
    public final String getHeaderField(int position) {
        addTaint(position);
        try 
        {
String var5B345634DDE250AAA264CDAFCD2DA4B1_1271813639 =             getResponse().getResponseHeaders().getHeaders().getValue(position);
            var5B345634DDE250AAA264CDAFCD2DA4B1_1271813639.addTaint(taint);
            return var5B345634DDE250AAA264CDAFCD2DA4B1_1271813639;
        } //End block
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_1916438762 =             null;
            var540C13E9E156B687226421B24F2DF178_1916438762.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1916438762;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getValue(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.462 -0400", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "11730F132BF7A125D7A0B59A571DD078")
    @Override
    public final String getHeaderField(String fieldName) {
        addTaint(fieldName.getTaint());
        try 
        {
            RawHeaders rawHeaders = getResponse().getResponseHeaders().getHeaders();
String varF692274FF09EEAD90FEA1B0F6F057D50_897692933 =             fieldName == null
                    ? rawHeaders.getStatusLine()
                    : rawHeaders.get(fieldName);
            varF692274FF09EEAD90FEA1B0F6F057D50_897692933.addTaint(taint);
            return varF692274FF09EEAD90FEA1B0F6F057D50_897692933;
        } //End block
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_46486710 =             null;
            var540C13E9E156B687226421B24F2DF178_46486710.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_46486710;
        } //End block
        // ---------- Original Method ----------
        //try {
            //RawHeaders rawHeaders = getResponse().getResponseHeaders().getHeaders();
            //return fieldName == null
                    //? rawHeaders.getStatusLine()
                    //: rawHeaders.get(fieldName);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.462 -0400", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "640F5922B110B558ECCC7597E1DE5B9F")
    @Override
    public final String getHeaderFieldKey(int position) {
        addTaint(position);
        try 
        {
String var0D85E3C24C39CB1BDF127AB561AACB1F_2070231177 =             getResponse().getResponseHeaders().getHeaders().getFieldName(position);
            var0D85E3C24C39CB1BDF127AB561AACB1F_2070231177.addTaint(taint);
            return var0D85E3C24C39CB1BDF127AB561AACB1F_2070231177;
        } //End block
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_357931254 =             null;
            var540C13E9E156B687226421B24F2DF178_357931254.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_357931254;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.462 -0400", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "13E4C7F51377BFB4C399CF26811BC2FF")
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        try 
        {
Map<String, List<String>> varE86C7AA4D734895D99B63F399CB92041_1898249931 =             getResponse().getResponseHeaders().getHeaders().toMultimap();
            varE86C7AA4D734895D99B63F399CB92041_1898249931.addTaint(taint);
            return varE86C7AA4D734895D99B63F399CB92041_1898249931;
        } //End block
        catch (IOException e)
        {
Map<String, List<String>> var540C13E9E156B687226421B24F2DF178_1927284616 =             null;
            var540C13E9E156B687226421B24F2DF178_1927284616.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1927284616;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().toMultimap();
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.463 -0400", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "4902B4B1F3C0F359317B2637D4A2CE1A")
    @Override
    public final Map<String, List<String>> getRequestProperties() {
    if(connected)        
        {
            IllegalStateException var4074FAC0DE7745E557FD176118B5B401_942372436 = new IllegalStateException(
                    "Cannot access request header fields after connection is set");
            var4074FAC0DE7745E557FD176118B5B401_942372436.addTaint(taint);
            throw var4074FAC0DE7745E557FD176118B5B401_942372436;
        } //End block
Map<String, List<String>> var83478CF7F4DB10649ACA2AF3BD1940B5_892629248 =         rawRequestHeaders.toMultimap();
        var83478CF7F4DB10649ACA2AF3BD1940B5_892629248.addTaint(taint);
        return var83478CF7F4DB10649ACA2AF3BD1940B5_892629248;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException(
                    //"Cannot access request header fields after connection is set");
        //}
        //return rawRequestHeaders.toMultimap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.463 -0400", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "98F5173D5A1C9D8D9233D3F7A1530A53")
    @Override
    public final InputStream getInputStream() throws IOException {
    if(!doInput)        
        {
            ProtocolException var724918665FB7A9D2EC9C5AC56975AD32_766596070 = new ProtocolException("This protocol does not support input");
            var724918665FB7A9D2EC9C5AC56975AD32_766596070.addTaint(taint);
            throw var724918665FB7A9D2EC9C5AC56975AD32_766596070;
        } //End block
        HttpEngine response = getResponse();
    if(getResponseCode() >= HTTP_BAD_REQUEST)        
        {
            FileNotFoundException varC9784FB60A75089CB20756559A80D1FF_38703441 = new FileNotFoundException(url.toString());
            varC9784FB60A75089CB20756559A80D1FF_38703441.addTaint(taint);
            throw varC9784FB60A75089CB20756559A80D1FF_38703441;
        } //End block
        InputStream result = response.getResponseBody();
    if(result == null)        
        {
            IOException var00E5038CCE111707EDFCF0D03AEDF71C_952200076 = new IOException("No response body exists; responseCode=" + getResponseCode());
            var00E5038CCE111707EDFCF0D03AEDF71C_952200076.addTaint(taint);
            throw var00E5038CCE111707EDFCF0D03AEDF71C_952200076;
        } //End block
InputStream varDC838461EE2FA0CA4C9BBB70A15456B0_1998667086 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1998667086.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1998667086;
        // ---------- Original Method ----------
        //if (!doInput) {
            //throw new ProtocolException("This protocol does not support input");
        //}
        //HttpEngine response = getResponse();
        //if (getResponseCode() >= HTTP_BAD_REQUEST) {
            //throw new FileNotFoundException(url.toString());
        //}
        //InputStream result = response.getResponseBody();
        //if (result == null) {
            //throw new IOException("No response body exists; responseCode=" + getResponseCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.464 -0400", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "885D2C14675262AEE54120CDF50A3907")
    @Override
    public final OutputStream getOutputStream() throws IOException {
        connect();
        OutputStream result = httpEngine.getRequestBody();
    if(result == null)        
        {
            ProtocolException varB26BE304020CBF6B10F33F72D2330036_1500128812 = new ProtocolException("method does not support a request body: " + method);
            varB26BE304020CBF6B10F33F72D2330036_1500128812.addTaint(taint);
            throw varB26BE304020CBF6B10F33F72D2330036_1500128812;
        } //End block
        else
    if(httpEngine.hasResponse())        
        {
            ProtocolException var8FC69F1BD8FA1A98EB7C817AB09F3B87_732161349 = new ProtocolException("cannot write request body after response has been read");
            var8FC69F1BD8FA1A98EB7C817AB09F3B87_732161349.addTaint(taint);
            throw var8FC69F1BD8FA1A98EB7C817AB09F3B87_732161349;
        } //End block
OutputStream varDC838461EE2FA0CA4C9BBB70A15456B0_389000404 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_389000404.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_389000404;
        // ---------- Original Method ----------
        //connect();
        //OutputStream result = httpEngine.getRequestBody();
        //if (result == null) {
            //throw new ProtocolException("method does not support a request body: " + method);
        //} else if (httpEngine.hasResponse()) {
            //throw new ProtocolException("cannot write request body after response has been read");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.464 -0400", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "7864DF955DC3DE03588ABDBD74221F37")
    @Override
    public final Permission getPermission() throws IOException {
        String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
Permission var9D7DA8812B4FFEFF8AF26BF4EBD67933_1661738590 =         new SocketPermission(connectToAddress, "connect, resolve");
        var9D7DA8812B4FFEFF8AF26BF4EBD67933_1661738590.addTaint(taint);
        return var9D7DA8812B4FFEFF8AF26BF4EBD67933_1661738590;
        // ---------- Original Method ----------
        //String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        //return new SocketPermission(connectToAddress, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.465 -0400", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "0CBD01A99270D746B97D6364ED1583F9")
    private String getConnectToHost() {
String varD98A48BB4EDCF32A414442F1174BE9A0_1616170620 =         usingProxy()
                ? ((InetSocketAddress) proxy.address()).getHostName()
                : getURL().getHost();
        varD98A48BB4EDCF32A414442F1174BE9A0_1616170620.addTaint(taint);
        return varD98A48BB4EDCF32A414442F1174BE9A0_1616170620;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getHostName()
                //: getURL().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.465 -0400", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "2097DB8DA98985673C498753209AA7E2")
    private int getConnectToPort() {
        int hostPort = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getPort()
                : getURL().getPort();
        int varD0A8C52058E1926D4773C0E4524C9E86_1915412933 = (hostPort < 0 ? getDefaultPort() : hostPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499490746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499490746;
        // ---------- Original Method ----------
        //int hostPort = usingProxy()
                //? ((InetSocketAddress) proxy.address()).getPort()
                //: getURL().getPort();
        //return hostPort < 0 ? getDefaultPort() : hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.465 -0400", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "0C79B5E8E3151BFB867BD74BD79E2136")
    @Override
    public final String getRequestProperty(String field) {
        addTaint(field.getTaint());
    if(field == null)        
        {
String var540C13E9E156B687226421B24F2DF178_282696506 =             null;
            var540C13E9E156B687226421B24F2DF178_282696506.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_282696506;
        } //End block
String varCFA12E4FF31F6BDF669A47CB12D4A809_1083544559 =         rawRequestHeaders.get(field);
        varCFA12E4FF31F6BDF669A47CB12D4A809_1083544559.addTaint(taint);
        return varCFA12E4FF31F6BDF669A47CB12D4A809_1083544559;
        // ---------- Original Method ----------
        //if (field == null) {
            //return null;
        //}
        //return rawRequestHeaders.get(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.466 -0400", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "75F997B668CF3B4CC8950A3BE724B0DE")
    private void initHttpEngine() throws IOException {
    if(httpEngineFailure != null)        
        {
            httpEngineFailure.addTaint(taint);
            throw httpEngineFailure;
        } //End block
        else
    if(httpEngine != null)        
        {
            return;
        } //End block
        connected = true;
        try 
        {
    if(doOutput)            
            {
    if(method == HttpEngine.GET)                
                {
                    method = HttpEngine.POST;
                } //End block
                else
    if(method != HttpEngine.POST && method != HttpEngine.PUT)                
                {
                    ProtocolException varE96328B3EEB158F4E8883D5F26A76A43_753301038 = new ProtocolException(method + " does not support writing");
                    varE96328B3EEB158F4E8883D5F26A76A43_753301038.addTaint(taint);
                    throw varE96328B3EEB158F4E8883D5F26A76A43_753301038;
                } //End block
            } //End block
            httpEngine = newHttpEngine(method, rawRequestHeaders, null, null);
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        //if (httpEngineFailure != null) {
            //throw httpEngineFailure;
        //} else if (httpEngine != null) {
            //return;
        //}
        //connected = true;
        //try {
            //if (doOutput) {
                //if (method == HttpEngine.GET) {
                    //method = HttpEngine.POST;
                //} else if (method != HttpEngine.POST && method != HttpEngine.PUT) {
                    //throw new ProtocolException(method + " does not support writing");
                //}
            //}
            //httpEngine = newHttpEngine(method, rawRequestHeaders, null, null);
        //} catch (IOException e) {
            //httpEngineFailure = e;
            //throw e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.467 -0400", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "05C3CB343619D3E9A6E5E00C6051586A")
    protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        addTaint(requestBody.getTaint());
        addTaint(connection.getTaint());
        addTaint(requestHeaders.getTaint());
        addTaint(method.getTaint());
HttpEngine var83FEA069440C6425B9B7BD852FCB896D_1153964773 =         new HttpEngine(this, method, requestHeaders, connection, requestBody);
        var83FEA069440C6425B9B7BD852FCB896D_1153964773.addTaint(taint);
        return var83FEA069440C6425B9B7BD852FCB896D_1153964773;
        // ---------- Original Method ----------
        //return new HttpEngine(this, method, requestHeaders, connection, requestBody);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.468 -0400", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "3ECFF4B1479E9C28B6E106E72938BFA4")
    private HttpEngine getResponse() throws IOException {
        initHttpEngine();
    if(httpEngine.hasResponse())        
        {
HttpEngine varAA56CD70F706D25D7750C40296FAF5EA_1411183582 =             httpEngine;
            varAA56CD70F706D25D7750C40296FAF5EA_1411183582.addTaint(taint);
            return varAA56CD70F706D25D7750C40296FAF5EA_1411183582;
        } //End block
        try 
        {
            while
(true)            
            {
                httpEngine.sendRequest();
                httpEngine.readResponse();
                Retry retry = processResponseHeaders();
    if(retry == Retry.NONE)                
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                    break;
                } //End block
                String retryMethod = method;
                OutputStream requestBody = httpEngine.getRequestBody();
                int responseCode = getResponseCode();
    if(responseCode == HTTP_MULT_CHOICE || responseCode == HTTP_MOVED_PERM
                        || responseCode == HTTP_MOVED_TEMP || responseCode == HTTP_SEE_OTHER)                
                {
                    retryMethod = HttpEngine.GET;
                    requestBody = null;
                } //End block
    if(requestBody != null && !(requestBody instanceof RetryableOutputStream))                
                {
                    HttpRetryException var728235CFA9F9BEEE194C6C8DA43277CF_229737128 = new HttpRetryException("Cannot retry streamed HTTP body",
                            httpEngine.getResponseCode());
                    var728235CFA9F9BEEE194C6C8DA43277CF_229737128.addTaint(taint);
                    throw var728235CFA9F9BEEE194C6C8DA43277CF_229737128;
                } //End block
    if(retry == Retry.DIFFERENT_CONNECTION)                
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                } //End block
                httpEngine.release(true);
                httpEngine = newHttpEngine(retryMethod, rawRequestHeaders,
                        httpEngine.getConnection(), (RetryableOutputStream) requestBody);
            } //End block
HttpEngine varAA56CD70F706D25D7750C40296FAF5EA_1119388219 =             httpEngine;
            varAA56CD70F706D25D7750C40296FAF5EA_1119388219.addTaint(taint);
            return varAA56CD70F706D25D7750C40296FAF5EA_1119388219;
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.468 -0400", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "938256FBDFB027543FCC6D622019C37C")
     HttpEngine getHttpEngine() {
HttpEngine varAA56CD70F706D25D7750C40296FAF5EA_1927208625 =         httpEngine;
        varAA56CD70F706D25D7750C40296FAF5EA_1927208625.addTaint(taint);
        return varAA56CD70F706D25D7750C40296FAF5EA_1927208625;
        // ---------- Original Method ----------
        //return httpEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.469 -0400", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "B76E6E3D37B452E578AD48A7D6C058A1")
    private Retry processResponseHeaders() throws IOException {
switch(getResponseCode()){
        case HTTP_PROXY_AUTH:
    if(!usingProxy())        
        {
            IOException var157A5D5088E40C8AE7929767807D5E72_1287676170 = new IOException(
                        "Received HTTP_PROXY_AUTH (407) code while not using proxy");
            var157A5D5088E40C8AE7929767807D5E72_1287676170.addTaint(taint);
            throw var157A5D5088E40C8AE7929767807D5E72_1287676170;
        } //End block
        case HTTP_UNAUTHORIZED:
        boolean credentialsFound = processAuthHeader(getResponseCode(),
                    httpEngine.getResponseHeaders(), rawRequestHeaders);
Retry varA6864B4BBDA05465FF60816476FC174B_1473623805 =         credentialsFound ? Retry.SAME_CONNECTION : Retry.NONE;
        varA6864B4BBDA05465FF60816476FC174B_1473623805.addTaint(taint);
        return varA6864B4BBDA05465FF60816476FC174B_1473623805;
        case HTTP_MULT_CHOICE:
        case HTTP_MOVED_PERM:
        case HTTP_MOVED_TEMP:
        case HTTP_SEE_OTHER:
    if(!getInstanceFollowRedirects())        
        {
Retry var261310BD8E5C3519A25312A7E432722D_1825812782 =             Retry.NONE;
            var261310BD8E5C3519A25312A7E432722D_1825812782.addTaint(taint);
            return var261310BD8E5C3519A25312A7E432722D_1825812782;
        } //End block
    if(++redirectionCount > HttpEngine.MAX_REDIRECTS)        
        {
            ProtocolException var6231C2F8AF9C1A34E7D9818C4B5F575A_341798941 = new ProtocolException("Too many redirects");
            var6231C2F8AF9C1A34E7D9818C4B5F575A_341798941.addTaint(taint);
            throw var6231C2F8AF9C1A34E7D9818C4B5F575A_341798941;
        } //End block
        String location = getHeaderField("Location");
    if(location == null)        
        {
Retry var261310BD8E5C3519A25312A7E432722D_2063035344 =             Retry.NONE;
            var261310BD8E5C3519A25312A7E432722D_2063035344.addTaint(taint);
            return var261310BD8E5C3519A25312A7E432722D_2063035344;
        } //End block
        URL previousUrl = url;
        url = new URL(previousUrl, location);
    if(!previousUrl.getProtocol().equals(url.getProtocol()))        
        {
Retry var261310BD8E5C3519A25312A7E432722D_146733852 =             Retry.NONE;
            var261310BD8E5C3519A25312A7E432722D_146733852.addTaint(taint);
            return var261310BD8E5C3519A25312A7E432722D_146733852;
        } //End block
    if(previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort())        
        {
Retry var9A8F03DC6A0BA22765ECAC03163ABA7E_879109635 =             Retry.SAME_CONNECTION;
            var9A8F03DC6A0BA22765ECAC03163ABA7E_879109635.addTaint(taint);
            return var9A8F03DC6A0BA22765ECAC03163ABA7E_879109635;
        } //End block
        else
        {
Retry var8ECFF3075DCBA2F5913471F573E9B77A_1550380498 =             Retry.DIFFERENT_CONNECTION;
            var8ECFF3075DCBA2F5913471F573E9B77A_1550380498.addTaint(taint);
            return var8ECFF3075DCBA2F5913471F573E9B77A_1550380498;
        } //End block
        default:
Retry var261310BD8E5C3519A25312A7E432722D_90592123 =         Retry.NONE;
        var261310BD8E5C3519A25312A7E432722D_90592123.addTaint(taint);
        return var261310BD8E5C3519A25312A7E432722D_90592123;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.470 -0400", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "BB9245C876800C805DA9DD8E890DD346")
    final boolean processAuthHeader(int responseCode, ResponseHeaders response,
            RawHeaders successorRequestHeaders) throws IOException {
        addTaint(successorRequestHeaders.getTaint());
        addTaint(response.getTaint());
        addTaint(responseCode);
    if(responseCode != HTTP_PROXY_AUTH && responseCode != HTTP_UNAUTHORIZED)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_532114247 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_532114247.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_532114247;
        } //End block
        String challenge = responseCode == HTTP_PROXY_AUTH
                ? response.getProxyAuthenticate()
                : response.getWwwAuthenticate();
    if(challenge == null)        
        {
            IOException var075EE462F235DCA9CC7D9036D2F6B3D2_265210958 = new IOException("Received authentication challenge is null");
            var075EE462F235DCA9CC7D9036D2F6B3D2_265210958.addTaint(taint);
            throw var075EE462F235DCA9CC7D9036D2F6B3D2_265210958;
        } //End block
        String credentials = getAuthorizationCredentials(challenge);
    if(credentials == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_999494634 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629765496 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_629765496;
        } //End block
        String fieldName = responseCode == HTTP_PROXY_AUTH
                ? "Proxy-Authorization"
                : "Authorization";
        successorRequestHeaders.set(fieldName, credentials);
        boolean varB326B5062B2F0E69046810717534CB09_510145809 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136137118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136137118;
        // ---------- Original Method ----------
        //if (responseCode != HTTP_PROXY_AUTH && responseCode != HTTP_UNAUTHORIZED) {
            //throw new IllegalArgumentException();
        //}
        //String challenge = responseCode == HTTP_PROXY_AUTH
                //? response.getProxyAuthenticate()
                //: response.getWwwAuthenticate();
        //if (challenge == null) {
            //throw new IOException("Received authentication challenge is null");
        //}
        //String credentials = getAuthorizationCredentials(challenge);
        //if (credentials == null) {
            //return false; 
        //}
        //String fieldName = responseCode == HTTP_PROXY_AUTH
                //? "Proxy-Authorization"
                //: "Authorization";
        //successorRequestHeaders.set(fieldName, credentials);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.471 -0400", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "39D9FCB01642DF6FD781677236485578")
    private String getAuthorizationCredentials(String challenge) throws IOException {
        addTaint(challenge.getTaint());
        int idx = challenge.indexOf(" ");
    if(idx == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_497880890 =             null;
            var540C13E9E156B687226421B24F2DF178_497880890.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_497880890;
        } //End block
        String scheme = challenge.substring(0, idx);
        int realm = challenge.indexOf("realm=\"") + 7;
        String prompt = null;
    if(realm != -1)        
        {
            int end = challenge.indexOf('"', realm);
    if(end != -1)            
            {
                prompt = challenge.substring(realm, end);
            } //End block
        } //End block
        PasswordAuthentication pa = Authenticator.requestPasswordAuthentication(
                getConnectToInetAddress(), getConnectToPort(), url.getProtocol(), prompt, scheme);
    if(pa == null)        
        {
String var540C13E9E156B687226421B24F2DF178_410230096 =             null;
            var540C13E9E156B687226421B24F2DF178_410230096.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_410230096;
        } //End block
        String usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded = Base64.encode(bytes);
String var33A5D8597EF845A2988B8D284418CA88_1938002915 =         scheme + " " + encoded;
        var33A5D8597EF845A2988B8D284418CA88_1938002915.addTaint(taint);
        return var33A5D8597EF845A2988B8D284418CA88_1938002915;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.471 -0400", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "019A757BF297D20B6A54B5A3ABFF2444")
    private InetAddress getConnectToInetAddress() throws IOException {
InetAddress varD46BBB19BBDDFD810185B2CBF9A3750A_1679766457 =         usingProxy()
                ? ((InetSocketAddress) proxy.address()).getAddress()
                : InetAddress.getByName(getURL().getHost());
        varD46BBB19BBDDFD810185B2CBF9A3750A_1679766457.addTaint(taint);
        return varD46BBB19BBDDFD810185B2CBF9A3750A_1679766457;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getAddress()
                //: InetAddress.getByName(getURL().getHost());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.471 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "2AE37B6C47C59A912F049C76A71728B0")
    final int getDefaultPort() {
        int varAD9869ADBCCEEFF5A73F8163B0777153_211677239 = (defaultPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820382180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820382180;
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.472 -0400", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "FC57C642E19DCB380536486B6448E1C0")
    final int getFixedContentLength() {
        int var85C6846C0A594942A26E857E8E0FB74D_525358693 = (fixedContentLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048693754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048693754;
        // ---------- Original Method ----------
        //return fixedContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.472 -0400", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "0D542C3A071D2469ACE2E411C81B51D2")
    final int getChunkLength() {
        int varCC64A8DA322DC52D44A247834F646DEC_1349778356 = (chunkLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604290290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604290290;
        // ---------- Original Method ----------
        //return chunkLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.472 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "5436F8CBE64AE4D522479900C7055F0B")
    final Proxy getProxy() {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_861476942 =         proxy;
        var60FC9F22F7E863EBFD33B2ADB8462743_861476942.addTaint(taint);
        return var60FC9F22F7E863EBFD33B2ADB8462743_861476942;
        // ---------- Original Method ----------
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.473 -0400", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "8F3413271570AEBF18F485ACB70ADDF9")
    final void setProxy(Proxy proxy) {
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.473 -0400", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "74A08734329CC625379B9418BE04ADB6")
    @Override
    public final boolean usingProxy() {
        boolean varDD5E369BCA6F1A6B54727C844D26BED1_422220567 = ((proxy != null && proxy.type() != Proxy.Type.DIRECT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376596735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_376596735;
        // ---------- Original Method ----------
        //return (proxy != null && proxy.type() != Proxy.Type.DIRECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.473 -0400", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "CF642632B0367B63A9DD087DE9E386FC")
    @Override
    public String getResponseMessage() throws IOException {
String varE8C6F6C86B5FB2D3EECAF34E66264D0E_596288278 =         getResponse().getResponseHeaders().getHeaders().getResponseMessage();
        varE8C6F6C86B5FB2D3EECAF34E66264D0E_596288278.addTaint(taint);
        return varE8C6F6C86B5FB2D3EECAF34E66264D0E_596288278;
        // ---------- Original Method ----------
        //return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.474 -0400", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "3ED5497D70007009B637894A5F3D3886")
    @Override
    public final int getResponseCode() throws IOException {
        int varEDF19B18AA75E08C91E3C94DAA0B2D3A_197127340 = (getResponse().getResponseCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977323662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977323662;
        // ---------- Original Method ----------
        //return getResponse().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.474 -0400", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "5294E4D13BB802F819EC8D5FF5BFA62F")
    @Override
    public final void setRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
    if(connected)        
        {
            IllegalStateException var9BF9502B5CDE1690424E1DA9A03CC376_1730225355 = new IllegalStateException("Cannot set request property after connection is made");
            var9BF9502B5CDE1690424E1DA9A03CC376_1730225355.addTaint(taint);
            throw var9BF9502B5CDE1690424E1DA9A03CC376_1730225355;
        } //End block
    if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_253721882 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_253721882.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_253721882;
        } //End block
        rawRequestHeaders.set(field, newValue);
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Cannot set request property after connection is made");
        //}
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
        //rawRequestHeaders.set(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.474 -0400", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "1ED4FF220E33A618AB8947972CD14A9D")
    @Override
    public final void addRequestProperty(String field, String value) {
        addTaint(value.getTaint());
        addTaint(field.getTaint());
    if(connected)        
        {
            IllegalStateException var610C85F331E13D759318F06D9DEB8C1C_1302701634 = new IllegalStateException("Cannot add request property after connection is made");
            var610C85F331E13D759318F06D9DEB8C1C_1302701634.addTaint(taint);
            throw var610C85F331E13D759318F06D9DEB8C1C_1302701634;
        } //End block
    if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_127988229 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_127988229.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_127988229;
        } //End block
        rawRequestHeaders.add(field, value);
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Cannot add request property after connection is made");
        //}
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
        //rawRequestHeaders.add(field, value);
    }

    
    enum Retry {
        NONE,
        SAME_CONNECTION,
        DIFFERENT_CONNECTION
    }

    
}

