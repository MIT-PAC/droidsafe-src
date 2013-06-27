package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpProtocolParams;

public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.558 -0400", hash_original_field = "919C8B643B7133116B02FC0D9BB7DF3F", hash_generated_field = "3C457E45ADB86FDABE11A23A4F2DF029")

    private HttpRequest original;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.559 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.559 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.559 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "A45E7E8A6FD19D10CB427B41BDB9B7B2")

    private ProtocolVersion version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.559 -0400", hash_original_field = "BA5B97C127D4F43CB9E9A3264AD4D7F5", hash_generated_field = "27152AB8D3102E368441115AC3DC9BF0")

    private int execCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.565 -0400", hash_original_method = "D4A65E5F770DCC03C77DA90B18FEF06F", hash_generated_method = "39D09846207D0F31C47BDF1C546C5A4B")
    public  RequestWrapper(final HttpRequest request) throws ProtocolException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        this.original = request;
        setParams(request.getParams());
        {
            this.uri = ((HttpUriRequest) request).getURI();
            this.method = ((HttpUriRequest) request).getMethod();
            this.version = null;
        } //End block
        {
            RequestLine requestLine;
            requestLine = request.getRequestLine();
            try 
            {
                this.uri = new URI(requestLine.getUri());
            } //End block
            catch (URISyntaxException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid request URI: " 
                        + requestLine.getUri(), ex);
            } //End block
            this.method = requestLine.getMethod();
            this.version = request.getProtocolVersion();
        } //End block
        this.execCount = 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.566 -0400", hash_original_method = "B4EE14BB96BEB0AC410A8A5396068660", hash_generated_method = "78DDFD160245227817E58E8F087B7FA9")
    public void resetHeaders() {
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
        // ---------- Original Method ----------
        //this.headergroup.clear();
        //setHeaders(this.original.getAllHeaders());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.566 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "C6704B0D0D259B7058A18D23CA1BFEEB")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_327135765 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_327135765 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_327135765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327135765;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.567 -0400", hash_original_method = "EFB4193DEE71013FE56C8307DE603C3A", hash_generated_method = "6BFAA71B9C7609F98776AAEFDBCE9483")
    public void setMethod(final String method) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Method name may not be null");
        } //End block
        this.method = method;
        // ---------- Original Method ----------
        //if (method == null) {
            //throw new IllegalArgumentException("Method name may not be null");
        //}
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.567 -0400", hash_original_method = "F281AE1963E10543B4B6C15DF00211F7", hash_generated_method = "85D99C32DA94F56BC0E0715455847A9A")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_799436530 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_796645165 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_799436530 = this.version;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_796645165 = HttpProtocolParams.getVersion(getParams());
        } //End block
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_379343883; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_379343883 = varB4EAC82CA7396A68D541C85D26508E83_799436530;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_379343883 = varB4EAC82CA7396A68D541C85D26508E83_796645165;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_379343883.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_379343883;
        // ---------- Original Method ----------
        //if (this.version != null) {
            //return this.version;
        //} else {
            //return HttpProtocolParams.getVersion(getParams());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.568 -0400", hash_original_method = "B7AE4BE889035DC000B6C604548769F2", hash_generated_method = "08E29A1903365C05B0B5AAD84F7FC9FB")
    public void setProtocolVersion(final ProtocolVersion version) {
        this.version = version;
        // ---------- Original Method ----------
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.584 -0400", hash_original_method = "548D933490D1B58733888D02043A11B0", hash_generated_method = "B4AFD5235D41EF572AE748D734CC984A")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_458329843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_458329843 = this.uri;
        varB4EAC82CA7396A68D541C85D26508E83_458329843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_458329843;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.584 -0400", hash_original_method = "3320A765B2CE48350AC27D9599EAC026", hash_generated_method = "C72876729647E8A3A80A7FBC268F56B2")
    public void setURI(final URI uri) {
        this.uri = uri;
        // ---------- Original Method ----------
        //this.uri = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.584 -0400", hash_original_method = "ED6274B1F39BF31330A4BAC92EA0A101", hash_generated_method = "A2A45A5BCE76214F6FAAD104108AF39B")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1895535730 = null; //Variable for return #1
        String method;
        method = getMethod();
        ProtocolVersion ver;
        ver = getProtocolVersion();
        String uritext;
        uritext = null;
        {
            uritext = uri.toASCIIString();
        } //End block
        {
            boolean var03A1675A35EE77EC28D14B979DA97E09_1082896598 = (uritext == null || uritext.length() == 0);
            {
                uritext = "/";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1895535730 = new BasicRequestLine(method, uritext, ver);
        varB4EAC82CA7396A68D541C85D26508E83_1895535730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895535730;
        // ---------- Original Method ----------
        //String method = getMethod();
        //ProtocolVersion ver = getProtocolVersion();
        //String uritext = null;
        //if (uri != null) {
            //uritext = uri.toASCIIString();
        //}
        //if (uritext == null || uritext.length() == 0) {
            //uritext = "/";
        //}
        //return new BasicRequestLine(method, uritext, ver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.585 -0400", hash_original_method = "E0DAFB547C594AC310B6A938D5D82D39", hash_generated_method = "DE34F2FBB9B7A5C7FDD0512F1F02345A")
    public void abort() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.585 -0400", hash_original_method = "BBFC2C7FEB496FD80D74781CCFD675B2", hash_generated_method = "1339EDAF1D7766186773428138D86BAD")
    public boolean isAborted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827258837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827258837;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.586 -0400", hash_original_method = "031DFDACC38ED516BF6F8D68C4847FFF", hash_generated_method = "B48DFEA1546393F76D8AFCD0EE675BA0")
    public HttpRequest getOriginal() {
        HttpRequest varB4EAC82CA7396A68D541C85D26508E83_1026948407 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1026948407 = this.original;
        varB4EAC82CA7396A68D541C85D26508E83_1026948407.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1026948407;
        // ---------- Original Method ----------
        //return this.original;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.586 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "B012A73CC537252B9EFAB67044EEB2AA")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382842667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382842667;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.586 -0400", hash_original_method = "CF6A18341EACE9B23200B44E9109C775", hash_generated_method = "1D23D56B6996938DBE9C4AEC3336C356")
    public int getExecCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283980806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283980806;
        // ---------- Original Method ----------
        //return this.execCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.586 -0400", hash_original_method = "D2EB72E1336F92B73CC51A8B455EFCB5", hash_generated_method = "00D1090628F63367D0D79A7A5FB5C0A3")
    public void incrementExecCount() {
        // ---------- Original Method ----------
        //this.execCount++;
    }

    
}

