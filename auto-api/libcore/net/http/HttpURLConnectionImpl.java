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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "C02B6920286CEE389E703ADA43236DB7", hash_generated_field = "C24593B7EDE7F3F9DC41BDC6F73FB5B0")

    private RawHeaders rawRequestHeaders = new RawHeaders();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "F24FBA8C419BC9FD2E48BCA15C14AACF", hash_generated_field = "EC2EBB12D4ECEAB53DC00655B16FEA0F")

    private int redirectionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "3C47E1E05D3879469502E6F58E1CAE6D", hash_generated_field = "7A97BD477901CB40BE3809D713545FCF")

    protected IOException httpEngineFailure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.339 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.350 -0400", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "2C1B9C1D66985D7A0121D87CDF841E32")
    protected  HttpURLConnectionImpl(URL url, int port) {
        super(url);
        defaultPort = port;
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //defaultPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.351 -0400", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "FB613379D440B80A9E0688E06C916D18")
    protected  HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        this.proxy = proxy;
        addTaint(url.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.351 -0400", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "B08642E815393E5148D7A6F89EC76906")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.351 -0400", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "E7767C0DEF86453F38282A3F19B4B27E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.352 -0400", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "2891E0D4CB6F9B7E51A0A932F2C3773F")
    @Override
    public final InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_70931383 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2124038531 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_736040440 = null; //Variable for return #3
        try 
        {
            HttpEngine response;
            response = getResponse();
            {
                boolean varD7347A00FCC783C9748325680F5F39D3_2083278108 = (response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_70931383 = response.getResponseBody();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2124038531 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_736040440 = null;
        } //End block
        InputStream varA7E53CE21691AB073D9660D615818899_856916339; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_856916339 = varB4EAC82CA7396A68D541C85D26508E83_70931383;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_856916339 = varB4EAC82CA7396A68D541C85D26508E83_2124038531;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_856916339 = varB4EAC82CA7396A68D541C85D26508E83_736040440;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_856916339.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_856916339;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.355 -0400", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "06B69BFEAB3505036A6C7C329B9A77FD")
    @Override
    public final String getHeaderField(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_385358744 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_150187272 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_385358744 = getResponse().getResponseHeaders().getHeaders().getValue(position);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_150187272 = null;
        } //End block
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_226769966; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_226769966 = varB4EAC82CA7396A68D541C85D26508E83_385358744;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_226769966 = varB4EAC82CA7396A68D541C85D26508E83_150187272;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_226769966.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_226769966;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getValue(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.356 -0400", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "ED97844304D76EF6A1AC2EB6B706CA17")
    @Override
    public final String getHeaderField(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_85869141 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1230828430 = null; //Variable for return #2
        try 
        {
            RawHeaders rawHeaders;
            rawHeaders = getResponse().getResponseHeaders().getHeaders();
            varB4EAC82CA7396A68D541C85D26508E83_85869141 = fieldName == null
                    ? rawHeaders.getStatusLine()
                    : rawHeaders.get(fieldName);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1230828430 = null;
        } //End block
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1871588468; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1871588468 = varB4EAC82CA7396A68D541C85D26508E83_85869141;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1871588468 = varB4EAC82CA7396A68D541C85D26508E83_1230828430;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1871588468.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1871588468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.357 -0400", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "9446E8BBD02FA4D28118218141A020F9")
    @Override
    public final String getHeaderFieldKey(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_1132557935 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_585434287 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1132557935 = getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_585434287 = null;
        } //End block
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_1932071705; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1932071705 = varB4EAC82CA7396A68D541C85D26508E83_1132557935;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1932071705 = varB4EAC82CA7396A68D541C85D26508E83_585434287;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1932071705.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1932071705;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.366 -0400", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "9319D028619303E9C59C06FF0B6DAAAB")
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_2071501192 = null; //Variable for return #1
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_269997997 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2071501192 = getResponse().getResponseHeaders().getHeaders().toMultimap();
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_269997997 = null;
        } //End block
        Map<String, List<String>> varA7E53CE21691AB073D9660D615818899_280292012; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_280292012 = varB4EAC82CA7396A68D541C85D26508E83_2071501192;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_280292012 = varB4EAC82CA7396A68D541C85D26508E83_269997997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_280292012.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_280292012;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().toMultimap();
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.370 -0400", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "8A837CA88B36B2484E24B26B139B4A40")
    @Override
    public final Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1181214963 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot access request header fields after connection is set");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1181214963 = rawRequestHeaders.toMultimap();
        varB4EAC82CA7396A68D541C85D26508E83_1181214963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1181214963;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException(
                    //"Cannot access request header fields after connection is set");
        //}
        //return rawRequestHeaders.toMultimap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.370 -0400", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "56BB4D4081EF5ED6641D86F958DBFFCA")
    @Override
    public final InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1468929164 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("This protocol does not support input");
        } //End block
        HttpEngine response;
        response = getResponse();
        {
            boolean varD8022199865993DD9F92A0CC3F71EE2C_1762238110 = (getResponseCode() >= HTTP_BAD_REQUEST);
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(url.toString());
            } //End block
        } //End collapsed parenthetic
        InputStream result;
        result = response.getResponseBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No response body exists; responseCode=" + getResponseCode());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1468929164 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1468929164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468929164;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.420 -0400", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "7C1C138198F404388D7D892651C0B5A9")
    @Override
    public final OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_125240598 = null; //Variable for return #1
        connect();
        OutputStream result;
        result = httpEngine.getRequestBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("method does not support a request body: " + method);
        } //End block
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_1244586738 = (httpEngine.hasResponse());
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("cannot write request body after response has been read");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_125240598 = result;
        varB4EAC82CA7396A68D541C85D26508E83_125240598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_125240598;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.420 -0400", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "25088BED738E970BDE9B143BF46B4257")
    @Override
    public final Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1340951882 = null; //Variable for return #1
        String connectToAddress;
        connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        varB4EAC82CA7396A68D541C85D26508E83_1340951882 = new SocketPermission(connectToAddress, "connect, resolve");
        varB4EAC82CA7396A68D541C85D26508E83_1340951882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340951882;
        // ---------- Original Method ----------
        //String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        //return new SocketPermission(connectToAddress, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.429 -0400", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "95C438BD7AB8F9FC275EE1AAD44CEACD")
    private String getConnectToHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_725038531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725038531 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getHostName()
                : getURL().getHost();
        varB4EAC82CA7396A68D541C85D26508E83_725038531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725038531;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getHostName()
                //: getURL().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.429 -0400", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "A20F7E953173E67285ACC882D974EB5B")
    private int getConnectToPort() {
        int hostPort;
        boolean varF06E67F8D313A89972318AEDC57EC5D5_165914889 = (usingProxy());
        hostPort = ((InetSocketAddress) proxy.address()).getPort();
        hostPort = getURL().getPort();
        {
            Object var55AFC7D50DDC7EC77B4E62135E02DAE7_311500180 = (getDefaultPort());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425107593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425107593;
        // ---------- Original Method ----------
        //int hostPort = usingProxy()
                //? ((InetSocketAddress) proxy.address()).getPort()
                //: getURL().getPort();
        //return hostPort < 0 ? getDefaultPort() : hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.430 -0400", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "558FC9915CE944A752AA2741A6663522")
    @Override
    public final String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_2062689582 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1700376509 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2062689582 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1700376509 = rawRequestHeaders.get(field);
        addTaint(field.getTaint());
        String varA7E53CE21691AB073D9660D615818899_854758112; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_854758112 = varB4EAC82CA7396A68D541C85D26508E83_2062689582;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_854758112 = varB4EAC82CA7396A68D541C85D26508E83_1700376509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_854758112.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_854758112;
        // ---------- Original Method ----------
        //if (field == null) {
            //return null;
        //}
        //return rawRequestHeaders.get(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.432 -0400", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "1ED67F477FF202290349A8C07FD13747")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.444 -0400", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "1D161BDA784DCB28A55064C64C7B3207")
    protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_224583050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_224583050 = new HttpEngine(this, method, requestHeaders, connection, requestBody);
        addTaint(method.getTaint());
        addTaint(requestHeaders.getTaint());
        addTaint(connection.getTaint());
        addTaint(requestBody.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_224583050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224583050;
        // ---------- Original Method ----------
        //return new HttpEngine(this, method, requestHeaders, connection, requestBody);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.446 -0400", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "47B63A9B1D1E0851A91148FF911C905C")
    private HttpEngine getResponse() throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1683847516 = null; //Variable for return #1
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1629235943 = null; //Variable for return #2
        initHttpEngine();
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_39129833 = (httpEngine.hasResponse());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1683847516 = httpEngine;
            } //End block
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
            varB4EAC82CA7396A68D541C85D26508E83_1629235943 = httpEngine;
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        HttpEngine varA7E53CE21691AB073D9660D615818899_2115073237; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2115073237 = varB4EAC82CA7396A68D541C85D26508E83_1683847516;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2115073237 = varB4EAC82CA7396A68D541C85D26508E83_1629235943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2115073237.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2115073237;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.447 -0400", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "3D0D955F916A2D07517C26C7465A3D88")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1543988716 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1543988716 = httpEngine;
        varB4EAC82CA7396A68D541C85D26508E83_1543988716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1543988716;
        // ---------- Original Method ----------
        //return httpEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.462 -0400", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "27D6016EE95645F6E8D9FB4CC3768A74")
    private Retry processResponseHeaders() throws IOException {
        Retry varB4EAC82CA7396A68D541C85D26508E83_180977458 = null; //Variable for return #1
        Retry varB4EAC82CA7396A68D541C85D26508E83_1438097543 = null; //Variable for return #2
        Retry varB4EAC82CA7396A68D541C85D26508E83_255250616 = null; //Variable for return #3
        Retry varB4EAC82CA7396A68D541C85D26508E83_1034420144 = null; //Variable for return #4
        Retry varB4EAC82CA7396A68D541C85D26508E83_1342048186 = null; //Variable for return #5
        Retry varB4EAC82CA7396A68D541C85D26508E83_862717014 = null; //Variable for return #6
        Retry varB4EAC82CA7396A68D541C85D26508E83_1700669464 = null; //Variable for return #7
        {
            Object var20F042546572D69C7A9AC081DF38D953_1301947241 = (getResponseCode());
            //Begin case HTTP_PROXY_AUTH 
            {
                boolean var2930139243087265820932B7BDB2A558_904137405 = (!usingProxy());
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
            //Begin case HTTP_UNAUTHORIZED 
            varB4EAC82CA7396A68D541C85D26508E83_180977458 = credentialsFound ? Retry.SAME_CONNECTION : Retry.NONE;
            //End case HTTP_UNAUTHORIZED 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var4231036716F9E7BE127364976920804F_128822622 = (!getInstanceFollowRedirects());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1438097543 = Retry.NONE;
                } //End block
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_255250616 = Retry.NONE;
            } //End block
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
                boolean var127C9F96D37ED4D3E737D93D37262DCE_519244239 = (!previousUrl.getProtocol().equals(url.getProtocol()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1034420144 = Retry.NONE;
                } //End block
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var75E1451812FE086497460E33682B0EAF_575574920 = (previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1342048186 = Retry.SAME_CONNECTION;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_862717014 = Retry.DIFFERENT_CONNECTION;
                } //End block
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case default 
            varB4EAC82CA7396A68D541C85D26508E83_1700669464 = Retry.NONE;
            //End case default 
        } //End collapsed parenthetic
        Retry varA7E53CE21691AB073D9660D615818899_1448507145; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_180977458;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_1438097543;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_255250616;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_1034420144;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_1342048186;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_862717014;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1448507145 = varB4EAC82CA7396A68D541C85D26508E83_1700669464;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1448507145.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1448507145;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.463 -0400", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "8FD2531893B8C01F53DD086665BD14FE")
    final boolean processAuthHeader(int responseCode, ResponseHeaders response,
            RawHeaders successorRequestHeaders) throws IOException {
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
        addTaint(responseCode);
        addTaint(response.getTaint());
        addTaint(successorRequestHeaders.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373996446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373996446;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.465 -0400", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "42EDCC2EA2C5EFE3C672F9F7625313B9")
    private String getAuthorizationCredentials(String challenge) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_956488205 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_15765927 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1853825924 = null; //Variable for return #3
        int idx;
        idx = challenge.indexOf(" ");
        {
            varB4EAC82CA7396A68D541C85D26508E83_956488205 = null;
        } //End block
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_15765927 = null;
        } //End block
        String usernameAndPassword;
        usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes;
        bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded;
        encoded = Base64.encode(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1853825924 = scheme + " " + encoded;
        addTaint(challenge.getTaint());
        String varA7E53CE21691AB073D9660D615818899_965064090; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_965064090 = varB4EAC82CA7396A68D541C85D26508E83_956488205;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_965064090 = varB4EAC82CA7396A68D541C85D26508E83_15765927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_965064090 = varB4EAC82CA7396A68D541C85D26508E83_1853825924;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_965064090.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_965064090;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.465 -0400", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "D4A2820FA1FE38D52B22502A1A6631B7")
    private InetAddress getConnectToInetAddress() throws IOException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_485883361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_485883361 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getAddress()
                : InetAddress.getByName(getURL().getHost());
        varB4EAC82CA7396A68D541C85D26508E83_485883361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_485883361;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getAddress()
                //: InetAddress.getByName(getURL().getHost());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.477 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "3AAC42FCE39E7E0326EA06E7784120FA")
    final int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122438250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122438250;
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.477 -0400", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "6E810C1091FD0AB54FD8133489B27AF2")
    final int getFixedContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822523479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822523479;
        // ---------- Original Method ----------
        //return fixedContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.478 -0400", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "FEC9FDB73ABCEAC71752299257F4BFA7")
    final int getChunkLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375908565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375908565;
        // ---------- Original Method ----------
        //return chunkLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.478 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "F43EEE4DC7D64634F3BC420E2D13A0AB")
    final Proxy getProxy() {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_819038756 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819038756 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_819038756.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819038756;
        // ---------- Original Method ----------
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.479 -0400", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "8F3413271570AEBF18F485ACB70ADDF9")
    final void setProxy(Proxy proxy) {
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.479 -0400", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "FEDD8DB6411FDAD0E5FC515A97155A85")
    @Override
    public final boolean usingProxy() {
        boolean var16D5082FA751067548E744F8E069E68A_153873126 = ((proxy != null && proxy.type() != Proxy.Type.DIRECT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120294981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120294981;
        // ---------- Original Method ----------
        //return (proxy != null && proxy.type() != Proxy.Type.DIRECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.483 -0400", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "1045E7939A20B439182D464E70666A1D")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_360978718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_360978718 = getResponse().getResponseHeaders().getHeaders().getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_360978718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_360978718;
        // ---------- Original Method ----------
        //return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.491 -0400", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "1ADE7B014F2FBD825A3E9B449D865294")
    @Override
    public final int getResponseCode() throws IOException {
        int varDC13817E00562421F93742BC26746AB9_1921218990 = (getResponse().getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354711106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354711106;
        // ---------- Original Method ----------
        //return getResponse().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.492 -0400", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "AB976BA80845AE137C4065E8E7E93B41")
    @Override
    public final void setRequestProperty(String field, String newValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot set request property after connection is made");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        rawRequestHeaders.set(field, newValue);
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Cannot set request property after connection is made");
        //}
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
        //rawRequestHeaders.set(field, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.492 -0400", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "74F8CD8124DD50C32F80F311EBBF6DB7")
    @Override
    public final void addRequestProperty(String field, String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot add request property after connection is made");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        rawRequestHeaders.add(field, value);
        addTaint(field.getTaint());
        addTaint(value.getTaint());
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

