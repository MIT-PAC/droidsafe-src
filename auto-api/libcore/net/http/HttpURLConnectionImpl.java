package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int defaultPort;
    private Proxy proxy;
    private RawHeaders rawRequestHeaders = new RawHeaders();
    private int redirectionCount;
    protected IOException httpEngineFailure;
    protected HttpEngine httpEngine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.311 -0400", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "A9BB95964DB1583FDC9CF600E4018825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpURLConnectionImpl(URL url, int port) {
        super(url);
        dsTaint.addTaint(port);
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
        //defaultPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.312 -0400", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "9103C5271D5BB8CA9025A62733B5957B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.312 -0400", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "B08642E815393E5148D7A6F89EC76906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.312 -0400", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "E7767C0DEF86453F38282A3F19B4B27E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void disconnect() {
        {
            httpEngine.release(false);
        } //End block
        // ---------- Original Method ----------
        //if (httpEngine != null) {
            //httpEngine.release(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.312 -0400", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "EC04290711AF4871431E2AD0D1F66477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final InputStream getErrorStream() {
        try 
        {
            HttpEngine response;
            response = getResponse();
            {
                boolean varD7347A00FCC783C9748325680F5F39D3_693965690 = (response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST);
                {
                    InputStream varBCF8B128515D5444D138EA322706A930_833590109 = (response.getResponseBody());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        { }
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.313 -0400", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "055026DF760FB116516EE7EF74464F80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String getHeaderField(int position) {
        dsTaint.addTaint(position);
        try 
        {
            String var57A79C31B0850B6A6AD55CC18F97552D_1412903525 = (getResponse().getResponseHeaders().getHeaders().getValue(position));
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getValue(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.314 -0400", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "2E739248DC3E78F72FB83BB93BF79936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String getHeaderField(String fieldName) {
        dsTaint.addTaint(fieldName);
        try 
        {
            RawHeaders rawHeaders;
            rawHeaders = getResponse().getResponseHeaders().getHeaders();
            {
                Object var308F3D43174B8CB620E7B399A7723751_1117079168 = (rawHeaders.getStatusLine());
                Object varCF8A05CA095D7CD9FD38FC692695E40F_1585270515 = (rawHeaders.get(fieldName));
            } //End flattened ternary
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.314 -0400", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "5E5C7AA475FA011025F92E8F74CFF5A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String getHeaderFieldKey(int position) {
        dsTaint.addTaint(position);
        try 
        {
            String var4E5C771C10AC43ABC414FCCF476A5A5D_1731167299 = (getResponse().getResponseHeaders().getHeaders().getFieldName(position));
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.314 -0400", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "5486883456344E7A7D7516FD651FAE94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        try 
        {
            Map<String, List<String>> varCD2CF1FE19EF715D58C001B7D695E466_818886413 = (getResponse().getResponseHeaders().getHeaders().toMultimap());
        } //End block
        catch (IOException e)
        { }
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().toMultimap();
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.314 -0400", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "65335002D0C705A646F32123E3111832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Map<String, List<String>> getRequestProperties() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot access request header fields after connection is set");
        } //End block
        Map<String, List<String>> varA16C1AE2A979156CA1C8819EA24AA556_838844093 = (rawRequestHeaders.toMultimap());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException(
                    //"Cannot access request header fields after connection is set");
        //}
        //return rawRequestHeaders.toMultimap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.315 -0400", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "605FDA4002BB55469FD170769D9F6DA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final InputStream getInputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("This protocol does not support input");
        } //End block
        HttpEngine response;
        response = getResponse();
        {
            boolean varD8022199865993DD9F92A0CC3F71EE2C_81749004 = (getResponseCode() >= HTTP_BAD_REQUEST);
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(url.toString());
            } //End block
        } //End collapsed parenthetic
        InputStream result;
        result = response.getResponseBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No response body exists; responseCode=" + getResponseCode());
        } //End block
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.315 -0400", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "A66F0D278C7CE81577B696623EC5354D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final OutputStream getOutputStream() throws IOException {
        connect();
        OutputStream result;
        result = httpEngine.getRequestBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("method does not support a request body: " + method);
        } //End block
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_169207564 = (httpEngine.hasResponse());
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("cannot write request body after response has been read");
            } //End block
        } //End collapsed parenthetic
        return (OutputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.315 -0400", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "AE642295CF36D3CFED136ED9D0649B3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Permission getPermission() throws IOException {
        String connectToAddress;
        connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        Permission var837EDC69BFCC00BE4EB6E81710836021_1943857523 = (new SocketPermission(connectToAddress, "connect, resolve"));
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        //return new SocketPermission(connectToAddress, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.315 -0400", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "3757EDB124D032DEEC26CE783BB80FE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getConnectToHost() {
        {
            boolean var46E80309D088038DF516AF1F3E227167_1243008370 = (usingProxy());
            Object varA1945F1B2FC08BF18AEE9878416560E0_1462017187 = (((InetSocketAddress) proxy.address()).getHostName());
            Object var893B0C75DD784A93F67DA8189CFBCD8F_1131252935 = (getURL().getHost());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getHostName()
                //: getURL().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.316 -0400", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "80DC63F1F54BB62B17081FB5D0B1CD40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getConnectToPort() {
        int hostPort;
        boolean varF06E67F8D313A89972318AEDC57EC5D5_487194118 = (usingProxy());
        hostPort = ((InetSocketAddress) proxy.address()).getPort();
        hostPort = getURL().getPort();
        {
            Object var55AFC7D50DDC7EC77B4E62135E02DAE7_2020225783 = (getDefaultPort());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hostPort = usingProxy()
                //? ((InetSocketAddress) proxy.address()).getPort()
                //: getURL().getPort();
        //return hostPort < 0 ? getDefaultPort() : hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.317 -0400", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "586318A6F6D7682D61FC66BD59A4427E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String getRequestProperty(String field) {
        dsTaint.addTaint(field);
        String var5BB0EC162E4396B71EE13AA8914F98BE_2101980247 = (rawRequestHeaders.get(field));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (field == null) {
            //return null;
        //}
        //return rawRequestHeaders.get(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.319 -0400", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "1ED67F477FF202290349A8C07FD13747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initHttpEngine() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw httpEngineFailure;
        } //End block
        connected = true;
        try 
        {
            {
                {
                    method = HttpEngine.POST;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException(method + " does not support writing");
                } //End block
            } //End block
            httpEngine = newHttpEngine(method, rawRequestHeaders, null, null);
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.320 -0400", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "EDA77E8E4697F5213E9604648CB3A3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        dsTaint.addTaint(requestBody.dsTaint);
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(requestHeaders.dsTaint);
        dsTaint.addTaint(method);
        HttpEngine varAC5C94FC972C309174226ABD81E036E4_757431373 = (new HttpEngine(this, method, requestHeaders, connection, requestBody));
        return (HttpEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HttpEngine(this, method, requestHeaders, connection, requestBody);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.322 -0400", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "F25311E62AB3A34AC3F26890A09697BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpEngine getResponse() throws IOException {
        initHttpEngine();
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_2030672687 = (httpEngine.hasResponse());
        } //End collapsed parenthetic
        try 
        {
            {
                httpEngine.sendRequest();
                httpEngine.readResponse();
                Retry retry;
                retry = processResponseHeaders();
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                } //End block
                String retryMethod;
                retryMethod = method;
                OutputStream requestBody;
                requestBody = httpEngine.getRequestBody();
                int responseCode;
                responseCode = getResponseCode();
                {
                    retryMethod = HttpEngine.GET;
                    requestBody = null;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new HttpRetryException("Cannot retry streamed HTTP body",
                            httpEngine.getResponseCode());
                } //End block
                {
                    httpEngine.automaticallyReleaseConnectionToPool();
                } //End block
                httpEngine.release(true);
                httpEngine = newHttpEngine(retryMethod, rawRequestHeaders,
                        httpEngine.getConnection(), (RetryableOutputStream) requestBody);
            } //End block
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        return (HttpEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.323 -0400", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "21211667F577D3628EB963F606FC7F16")
    @DSModeled(DSC.SAFE)
     HttpEngine getHttpEngine() {
        return (HttpEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return httpEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.323 -0400", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "62CE8E75F79B87EEC1E0B713AA3F8312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Retry processResponseHeaders() throws IOException {
        {
            Object var20F042546572D69C7A9AC081DF38D953_1707825091 = (getResponseCode());
            //Begin case HTTP_PROXY_AUTH 
            {
                boolean var2930139243087265820932B7BDB2A558_674348478 = (!usingProxy());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } //End block
            } //End collapsed parenthetic
            //End case HTTP_PROXY_AUTH 
            //Begin case HTTP_UNAUTHORIZED 
            boolean credentialsFound;
            credentialsFound = processAuthHeader(getResponseCode(),
                    httpEngine.getResponseHeaders(), rawRequestHeaders);
            //End case HTTP_UNAUTHORIZED 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var4231036716F9E7BE127364976920804F_632361979 = (!getInstanceFollowRedirects());
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Too many redirects");
            } //End block
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            String location;
            location = getHeaderField("Location");
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            URL previousUrl;
            previousUrl = url;
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            url = new URL(previousUrl, location);
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var127C9F96D37ED4D3E737D93D37262DCE_1563005129 = (!previousUrl.getProtocol().equals(url.getProtocol()));
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var75E1451812FE086497460E33682B0EAF_143038649 = (previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort());
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
        } //End collapsed parenthetic
        return (Retry)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.323 -0400", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "9CB0373EB3778999580FC3F3D9EEAB10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean processAuthHeader(int responseCode, ResponseHeaders response,
            RawHeaders successorRequestHeaders) throws IOException {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(responseCode);
        dsTaint.addTaint(successorRequestHeaders.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        String challenge;
        challenge = response.getProxyAuthenticate();
        challenge = response.getWwwAuthenticate();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Received authentication challenge is null");
        } //End block
        String credentials;
        credentials = getAuthorizationCredentials(challenge);
        String fieldName;
        fieldName = "Proxy-Authorization";
        fieldName = "Authorization";
        successorRequestHeaders.set(fieldName, credentials);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.324 -0400", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "6845B2BD8CB971D0642C257558DA8029")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getAuthorizationCredentials(String challenge) throws IOException {
        dsTaint.addTaint(challenge);
        int idx;
        idx = challenge.indexOf(" ");
        String scheme;
        scheme = challenge.substring(0, idx);
        int realm;
        realm = challenge.indexOf("realm=\"") + 7;
        String prompt;
        prompt = null;
        {
            int end;
            end = challenge.indexOf('"', realm);
            {
                prompt = challenge.substring(realm, end);
            } //End block
        } //End block
        PasswordAuthentication pa;
        pa = Authenticator.requestPasswordAuthentication(
                getConnectToInetAddress(), getConnectToPort(), url.getProtocol(), prompt, scheme);
        String usernameAndPassword;
        usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes;
        bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded;
        encoded = Base64.encode(bytes);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.324 -0400", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "42FE89EDFD10ACC94854734CEE458692")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InetAddress getConnectToInetAddress() throws IOException {
        {
            boolean var46E80309D088038DF516AF1F3E227167_365721003 = (usingProxy());
            Object varFBCEF7B61E35CEE3826EB22F55BEF192_652828812 = (((InetSocketAddress) proxy.address()).getAddress());
            Object varB1B5AC9CE3A2FB3F45D4F2B7BAFCB27A_2004439649 = (InetAddress.getByName(getURL().getHost()));
        } //End flattened ternary
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getAddress()
                //: InetAddress.getByName(getURL().getHost());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.324 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "4745E2D5DBA0964227D0B14AF88630FF")
    @DSModeled(DSC.SAFE)
    final int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "D9FE67F6273B5E77847C88A7819886A1")
    @DSModeled(DSC.SAFE)
    final int getFixedContentLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fixedContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "B80657C17BC5AC86F76C15DA02044549")
    @DSModeled(DSC.SAFE)
    final int getChunkLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return chunkLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "1827665F610E947E8313D01B3253B093")
    @DSModeled(DSC.SAFE)
    final Proxy getProxy() {
        return (Proxy)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "B5FDCF1EACBB593B09082269E3A5CD68")
    @DSModeled(DSC.SAFE)
    final void setProxy(Proxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "6AEA28535A43FE9DF0A97F713330E4D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean usingProxy() {
        boolean var16D5082FA751067548E744F8E069E68A_323491528 = ((proxy != null && proxy.type() != Proxy.Type.DIRECT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (proxy != null && proxy.type() != Proxy.Type.DIRECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.325 -0400", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "13E8BFCAA19B8EDB0C496F8E1F54AF73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getResponseMessage() throws IOException {
        String varBE9E665C31CD4B9EE25CD300794C8569_838182527 = (getResponse().getResponseHeaders().getHeaders().getResponseMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.326 -0400", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "AB24706BF60683B5BAA96A4EADA8EB6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getResponseCode() throws IOException {
        int varDC13817E00562421F93742BC26746AB9_784216701 = (getResponse().getResponseCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getResponse().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.326 -0400", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "AD90ECD97B27F36A12A438700CAF8F09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void setRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot set request property after connection is made");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.326 -0400", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "6A591CE38A8F3252F7398FBF55D3B548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void addRequestProperty(String field, String value) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot add request property after connection is made");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
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

