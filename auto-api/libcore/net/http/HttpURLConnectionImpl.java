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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "C02B6920286CEE389E703ADA43236DB7", hash_generated_field = "C24593B7EDE7F3F9DC41BDC6F73FB5B0")

    private RawHeaders rawRequestHeaders = new RawHeaders();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "F24FBA8C419BC9FD2E48BCA15C14AACF", hash_generated_field = "EC2EBB12D4ECEAB53DC00655B16FEA0F")

    private int redirectionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "3C47E1E05D3879469502E6F58E1CAE6D", hash_generated_field = "7A97BD477901CB40BE3809D713545FCF")

    protected IOException httpEngineFailure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.006 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.013 -0400", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "2C1B9C1D66985D7A0121D87CDF841E32")
    protected  HttpURLConnectionImpl(URL url, int port) {
        super(url);
        defaultPort = port;
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //defaultPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.014 -0400", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "FB613379D440B80A9E0688E06C916D18")
    protected  HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        this.proxy = proxy;
        addTaint(url.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.014 -0400", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "B08642E815393E5148D7A6F89EC76906")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.015 -0400", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "E7767C0DEF86453F38282A3F19B4B27E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.016 -0400", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "E2A62A656C355909BEBF76856AE1EA0A")
    @Override
    public final InputStream getErrorStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1106199215 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_180899998 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1536222718 = null; //Variable for return #3
        try 
        {
            HttpEngine response;
            response = getResponse();
            {
                boolean varD7347A00FCC783C9748325680F5F39D3_1277026966 = (response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1106199215 = response.getResponseBody();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_180899998 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1536222718 = null;
        } //End block
        InputStream varA7E53CE21691AB073D9660D615818899_1682262538; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1682262538 = varB4EAC82CA7396A68D541C85D26508E83_1106199215;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1682262538 = varB4EAC82CA7396A68D541C85D26508E83_180899998;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1682262538 = varB4EAC82CA7396A68D541C85D26508E83_1536222718;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1682262538.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1682262538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.092 -0400", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "970EAADFED3A38745596CBF8C82B4764")
    @Override
    public final String getHeaderField(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_1509605000 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1665015316 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1509605000 = getResponse().getResponseHeaders().getHeaders().getValue(position);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1665015316 = null;
        } //End block
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_1511585738; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1511585738 = varB4EAC82CA7396A68D541C85D26508E83_1509605000;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1511585738 = varB4EAC82CA7396A68D541C85D26508E83_1665015316;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1511585738.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1511585738;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getValue(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.093 -0400", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "F99D4E1E43FAC1062E7FA0614972F9AE")
    @Override
    public final String getHeaderField(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_142225143 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_808387700 = null; //Variable for return #2
        try 
        {
            RawHeaders rawHeaders;
            rawHeaders = getResponse().getResponseHeaders().getHeaders();
            varB4EAC82CA7396A68D541C85D26508E83_142225143 = fieldName == null
                    ? rawHeaders.getStatusLine()
                    : rawHeaders.get(fieldName);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_808387700 = null;
        } //End block
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1296143933; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1296143933 = varB4EAC82CA7396A68D541C85D26508E83_142225143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1296143933 = varB4EAC82CA7396A68D541C85D26508E83_808387700;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1296143933.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1296143933;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.097 -0400", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "E30A617625329251D54200FA10E1071C")
    @Override
    public final String getHeaderFieldKey(int position) {
        String varB4EAC82CA7396A68D541C85D26508E83_2123432409 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1211720015 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2123432409 = getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1211720015 = null;
        } //End block
        addTaint(position);
        String varA7E53CE21691AB073D9660D615818899_481559965; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_481559965 = varB4EAC82CA7396A68D541C85D26508E83_2123432409;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_481559965 = varB4EAC82CA7396A68D541C85D26508E83_1211720015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_481559965.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_481559965;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.098 -0400", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "25545CAA2A224946B684C4007C0B073B")
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1451577830 = null; //Variable for return #1
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1043015874 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1451577830 = getResponse().getResponseHeaders().getHeaders().toMultimap();
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1043015874 = null;
        } //End block
        Map<String, List<String>> varA7E53CE21691AB073D9660D615818899_934045101; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_934045101 = varB4EAC82CA7396A68D541C85D26508E83_1451577830;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_934045101 = varB4EAC82CA7396A68D541C85D26508E83_1043015874;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_934045101.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_934045101;
        // ---------- Original Method ----------
        //try {
            //return getResponse().getResponseHeaders().getHeaders().toMultimap();
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.099 -0400", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "625F3803D61B40551D54539D5DD12D80")
    @Override
    public final Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1714934859 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot access request header fields after connection is set");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1714934859 = rawRequestHeaders.toMultimap();
        varB4EAC82CA7396A68D541C85D26508E83_1714934859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714934859;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException(
                    //"Cannot access request header fields after connection is set");
        //}
        //return rawRequestHeaders.toMultimap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.100 -0400", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "2E49EE4CD30731CDF3AF542820529F44")
    @Override
    public final InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1166235193 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("This protocol does not support input");
        } //End block
        HttpEngine response;
        response = getResponse();
        {
            boolean varD8022199865993DD9F92A0CC3F71EE2C_1421036477 = (getResponseCode() >= HTTP_BAD_REQUEST);
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(url.toString());
            } //End block
        } //End collapsed parenthetic
        InputStream result;
        result = response.getResponseBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No response body exists; responseCode=" + getResponseCode());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1166235193 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1166235193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166235193;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.105 -0400", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "9B46A46D28E1DB53295503D7A8CFF670")
    @Override
    public final OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1766498307 = null; //Variable for return #1
        connect();
        OutputStream result;
        result = httpEngine.getRequestBody();
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("method does not support a request body: " + method);
        } //End block
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_715351750 = (httpEngine.hasResponse());
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("cannot write request body after response has been read");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1766498307 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1766498307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766498307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.113 -0400", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "A6DE9D50AA2E9E0607091CFA08F9BA84")
    @Override
    public final Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1456295193 = null; //Variable for return #1
        String connectToAddress;
        connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        varB4EAC82CA7396A68D541C85D26508E83_1456295193 = new SocketPermission(connectToAddress, "connect, resolve");
        varB4EAC82CA7396A68D541C85D26508E83_1456295193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456295193;
        // ---------- Original Method ----------
        //String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        //return new SocketPermission(connectToAddress, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.114 -0400", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "80E6D0A568C817611CBCD36CB0D6A0CC")
    private String getConnectToHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_801242843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_801242843 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getHostName()
                : getURL().getHost();
        varB4EAC82CA7396A68D541C85D26508E83_801242843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801242843;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getHostName()
                //: getURL().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.114 -0400", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "BA9A8923CD6B68B6A8EA2038D95427D0")
    private int getConnectToPort() {
        int hostPort;
        boolean varF06E67F8D313A89972318AEDC57EC5D5_2078537685 = (usingProxy());
        hostPort = ((InetSocketAddress) proxy.address()).getPort();
        hostPort = getURL().getPort();
        {
            Object var55AFC7D50DDC7EC77B4E62135E02DAE7_603900807 = (getDefaultPort());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624082781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624082781;
        // ---------- Original Method ----------
        //int hostPort = usingProxy()
                //? ((InetSocketAddress) proxy.address()).getPort()
                //: getURL().getPort();
        //return hostPort < 0 ? getDefaultPort() : hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.122 -0400", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "B707BA3D66E58594E76DA3329B2AD7E3")
    @Override
    public final String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_625548601 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1312590308 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_625548601 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1312590308 = rawRequestHeaders.get(field);
        addTaint(field.getTaint());
        String varA7E53CE21691AB073D9660D615818899_238078261; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_238078261 = varB4EAC82CA7396A68D541C85D26508E83_625548601;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_238078261 = varB4EAC82CA7396A68D541C85D26508E83_1312590308;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_238078261.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_238078261;
        // ---------- Original Method ----------
        //if (field == null) {
            //return null;
        //}
        //return rawRequestHeaders.get(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.132 -0400", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "1ED67F477FF202290349A8C07FD13747")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.136 -0400", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "08964C93D8C3605ECC56F7A24E284F93")
    protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_801761668 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_801761668 = new HttpEngine(this, method, requestHeaders, connection, requestBody);
        addTaint(method.getTaint());
        addTaint(requestHeaders.getTaint());
        addTaint(connection.getTaint());
        addTaint(requestBody.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_801761668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801761668;
        // ---------- Original Method ----------
        //return new HttpEngine(this, method, requestHeaders, connection, requestBody);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.138 -0400", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "C106E548469572DAA22FBCB71A8B04BD")
    private HttpEngine getResponse() throws IOException {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1152706825 = null; //Variable for return #1
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_404521499 = null; //Variable for return #2
        initHttpEngine();
        {
            boolean var3DBD39046D71FCFAFF45606FCDE17FF5_308473352 = (httpEngine.hasResponse());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1152706825 = httpEngine;
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
            varB4EAC82CA7396A68D541C85D26508E83_404521499 = httpEngine;
        } //End block
        catch (IOException e)
        {
            httpEngineFailure = e;
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        HttpEngine varA7E53CE21691AB073D9660D615818899_1612120969; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1612120969 = varB4EAC82CA7396A68D541C85D26508E83_1152706825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1612120969 = varB4EAC82CA7396A68D541C85D26508E83_404521499;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1612120969.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1612120969;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.155 -0400", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "CB782FB8FC617C370D3634C2170F1480")
     HttpEngine getHttpEngine() {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1377471152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1377471152 = httpEngine;
        varB4EAC82CA7396A68D541C85D26508E83_1377471152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1377471152;
        // ---------- Original Method ----------
        //return httpEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.156 -0400", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "A5147E5F6FE80C1EFEC3600BB5DBCE4A")
    private Retry processResponseHeaders() throws IOException {
        Retry varB4EAC82CA7396A68D541C85D26508E83_1725030526 = null; //Variable for return #1
        Retry varB4EAC82CA7396A68D541C85D26508E83_936275983 = null; //Variable for return #2
        Retry varB4EAC82CA7396A68D541C85D26508E83_1840237666 = null; //Variable for return #3
        Retry varB4EAC82CA7396A68D541C85D26508E83_945560135 = null; //Variable for return #4
        Retry varB4EAC82CA7396A68D541C85D26508E83_985070340 = null; //Variable for return #5
        Retry varB4EAC82CA7396A68D541C85D26508E83_1364250002 = null; //Variable for return #6
        Retry varB4EAC82CA7396A68D541C85D26508E83_955770879 = null; //Variable for return #7
        {
            Object var20F042546572D69C7A9AC081DF38D953_1229665599 = (getResponseCode());
            //Begin case HTTP_PROXY_AUTH 
            {
                boolean var2930139243087265820932B7BDB2A558_1390391956 = (!usingProxy());
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
            varB4EAC82CA7396A68D541C85D26508E83_1725030526 = credentialsFound ? Retry.SAME_CONNECTION : Retry.NONE;
            //End case HTTP_UNAUTHORIZED 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var4231036716F9E7BE127364976920804F_1551995818 = (!getInstanceFollowRedirects());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_936275983 = Retry.NONE;
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
                varB4EAC82CA7396A68D541C85D26508E83_1840237666 = Retry.NONE;
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
                boolean var127C9F96D37ED4D3E737D93D37262DCE_488801125 = (!previousUrl.getProtocol().equals(url.getProtocol()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_945560135 = Retry.NONE;
                } //End block
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            {
                boolean var75E1451812FE086497460E33682B0EAF_1077569961 = (previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_985070340 = Retry.SAME_CONNECTION;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1364250002 = Retry.DIFFERENT_CONNECTION;
                } //End block
            } //End collapsed parenthetic
            //End case HTTP_MULT_CHOICE HTTP_MOVED_PERM HTTP_MOVED_TEMP HTTP_SEE_OTHER 
            //Begin case default 
            varB4EAC82CA7396A68D541C85D26508E83_955770879 = Retry.NONE;
            //End case default 
        } //End collapsed parenthetic
        Retry varA7E53CE21691AB073D9660D615818899_159747157; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_1725030526;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_936275983;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_1840237666;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_945560135;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_985070340;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_1364250002;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_159747157 = varB4EAC82CA7396A68D541C85D26508E83_955770879;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_159747157.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_159747157;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.158 -0400", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "76D1DAD062F27E4839FF239A01C63116")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33190265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33190265;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.166 -0400", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "DE120C86FDE6F59FDA417F807D02C0A6")
    private String getAuthorizationCredentials(String challenge) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1883922018 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_87747075 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1150549712 = null; //Variable for return #3
        int idx;
        idx = challenge.indexOf(" ");
        {
            varB4EAC82CA7396A68D541C85D26508E83_1883922018 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_87747075 = null;
        } //End block
        String usernameAndPassword;
        usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes;
        bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded;
        encoded = Base64.encode(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1150549712 = scheme + " " + encoded;
        addTaint(challenge.getTaint());
        String varA7E53CE21691AB073D9660D615818899_208173205; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_208173205 = varB4EAC82CA7396A68D541C85D26508E83_1883922018;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_208173205 = varB4EAC82CA7396A68D541C85D26508E83_87747075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_208173205 = varB4EAC82CA7396A68D541C85D26508E83_1150549712;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_208173205.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_208173205;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.167 -0400", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "70F7F2AF618680E2F706F2524F1AF662")
    private InetAddress getConnectToInetAddress() throws IOException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1114080143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1114080143 = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getAddress()
                : InetAddress.getByName(getURL().getHost());
        varB4EAC82CA7396A68D541C85D26508E83_1114080143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114080143;
        // ---------- Original Method ----------
        //return usingProxy()
                //? ((InetSocketAddress) proxy.address()).getAddress()
                //: InetAddress.getByName(getURL().getHost());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.167 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "73B56C4311B8B67C28B16CF5518C31CB")
    final int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006683844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006683844;
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.182 -0400", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "D8102F255896A641D14F58DB0189832D")
    final int getFixedContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484159828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484159828;
        // ---------- Original Method ----------
        //return fixedContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.185 -0400", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "0AAC16C16F77EF27BC72F68E0C4EF1C2")
    final int getChunkLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816842099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816842099;
        // ---------- Original Method ----------
        //return chunkLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.185 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "80831C89079D4028D00E12DADB2017C2")
    final Proxy getProxy() {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_465475767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465475767 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_465475767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465475767;
        // ---------- Original Method ----------
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.186 -0400", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "8F3413271570AEBF18F485ACB70ADDF9")
    final void setProxy(Proxy proxy) {
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.186 -0400", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "E17F10B93EC7EC5D26ACF119465456DA")
    @Override
    public final boolean usingProxy() {
        boolean var16D5082FA751067548E744F8E069E68A_1781446547 = ((proxy != null && proxy.type() != Proxy.Type.DIRECT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598196341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598196341;
        // ---------- Original Method ----------
        //return (proxy != null && proxy.type() != Proxy.Type.DIRECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.187 -0400", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "4535C5D9391EA465D3DAB3C0F3AE4172")
    @Override
    public String getResponseMessage() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_69960440 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_69960440 = getResponse().getResponseHeaders().getHeaders().getResponseMessage();
        varB4EAC82CA7396A68D541C85D26508E83_69960440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_69960440;
        // ---------- Original Method ----------
        //return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.188 -0400", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "28A556DD485F03FAC2AFF1F64A489708")
    @Override
    public final int getResponseCode() throws IOException {
        int varDC13817E00562421F93742BC26746AB9_45979445 = (getResponse().getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466093129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466093129;
        // ---------- Original Method ----------
        //return getResponse().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.188 -0400", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "AB976BA80845AE137C4065E8E7E93B41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.192 -0400", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "74F8CD8124DD50C32F80F311EBBF6DB7")
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

