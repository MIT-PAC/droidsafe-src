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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.304 -0400", hash_original_field = "919C8B643B7133116B02FC0D9BB7DF3F", hash_generated_field = "3C457E45ADB86FDABE11A23A4F2DF029")

    private HttpRequest original;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.304 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.304 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.304 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "A45E7E8A6FD19D10CB427B41BDB9B7B2")

    private ProtocolVersion version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.304 -0400", hash_original_field = "BA5B97C127D4F43CB9E9A3264AD4D7F5", hash_generated_field = "27152AB8D3102E368441115AC3DC9BF0")

    private int execCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.305 -0400", hash_original_method = "D4A65E5F770DCC03C77DA90B18FEF06F", hash_generated_method = "3A1F6929563D2F2A98185C5197C061BE")
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
            RequestLine requestLine = request.getRequestLine();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.305 -0400", hash_original_method = "B4EE14BB96BEB0AC410A8A5396068660", hash_generated_method = "78DDFD160245227817E58E8F087B7FA9")
    public void resetHeaders() {
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
        // ---------- Original Method ----------
        //this.headergroup.clear();
        //setHeaders(this.original.getAllHeaders());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.306 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7CBA8F4D19B3D2A18E009F668A70BA1A")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_2116675433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2116675433 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_2116675433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2116675433;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.306 -0400", hash_original_method = "EFB4193DEE71013FE56C8307DE603C3A", hash_generated_method = "6BFAA71B9C7609F98776AAEFDBCE9483")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.307 -0400", hash_original_method = "F281AE1963E10543B4B6C15DF00211F7", hash_generated_method = "DF86A45CBC05DA2F4E6F1934C97BA469")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1176922241 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1945390504 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1176922241 = this.version;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1945390504 = HttpProtocolParams.getVersion(getParams());
        } //End block
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_1325862055; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1325862055 = varB4EAC82CA7396A68D541C85D26508E83_1176922241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1325862055 = varB4EAC82CA7396A68D541C85D26508E83_1945390504;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1325862055.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1325862055;
        // ---------- Original Method ----------
        //if (this.version != null) {
            //return this.version;
        //} else {
            //return HttpProtocolParams.getVersion(getParams());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.307 -0400", hash_original_method = "B7AE4BE889035DC000B6C604548769F2", hash_generated_method = "08E29A1903365C05B0B5AAD84F7FC9FB")
    public void setProtocolVersion(final ProtocolVersion version) {
        this.version = version;
        // ---------- Original Method ----------
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.307 -0400", hash_original_method = "548D933490D1B58733888D02043A11B0", hash_generated_method = "207BF2DC154F37062DD7C3F515596E8A")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1088942744 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1088942744 = this.uri;
        varB4EAC82CA7396A68D541C85D26508E83_1088942744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088942744;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.307 -0400", hash_original_method = "3320A765B2CE48350AC27D9599EAC026", hash_generated_method = "C72876729647E8A3A80A7FBC268F56B2")
    public void setURI(final URI uri) {
        this.uri = uri;
        // ---------- Original Method ----------
        //this.uri = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.308 -0400", hash_original_method = "ED6274B1F39BF31330A4BAC92EA0A101", hash_generated_method = "B08B221F02CB3C13D4A4EE4662E7819C")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_406111353 = null; //Variable for return #1
        String method = getMethod();
        ProtocolVersion ver = getProtocolVersion();
        String uritext = null;
        {
            uritext = uri.toASCIIString();
        } //End block
        {
            boolean var03A1675A35EE77EC28D14B979DA97E09_674491722 = (uritext == null || uritext.length() == 0);
            {
                uritext = "/";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_406111353 = new BasicRequestLine(method, uritext, ver);
        varB4EAC82CA7396A68D541C85D26508E83_406111353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_406111353;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.309 -0400", hash_original_method = "E0DAFB547C594AC310B6A938D5D82D39", hash_generated_method = "DE34F2FBB9B7A5C7FDD0512F1F02345A")
    public void abort() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.309 -0400", hash_original_method = "BBFC2C7FEB496FD80D74781CCFD675B2", hash_generated_method = "26DF462B8375BAE21C5A9F4BDFE55B4E")
    public boolean isAborted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156811600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156811600;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.310 -0400", hash_original_method = "031DFDACC38ED516BF6F8D68C4847FFF", hash_generated_method = "342DDF68DCCB01385E17F869940879F3")
    public HttpRequest getOriginal() {
        HttpRequest varB4EAC82CA7396A68D541C85D26508E83_1346486267 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346486267 = this.original;
        varB4EAC82CA7396A68D541C85D26508E83_1346486267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346486267;
        // ---------- Original Method ----------
        //return this.original;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.311 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "EAB0570588564E3678B7E0BBF26BDF46")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173951225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173951225;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.311 -0400", hash_original_method = "CF6A18341EACE9B23200B44E9109C775", hash_generated_method = "524FA8BBB271D372C7AF943A52B56CC5")
    public int getExecCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584329510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584329510;
        // ---------- Original Method ----------
        //return this.execCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.311 -0400", hash_original_method = "D2EB72E1336F92B73CC51A8B455EFCB5", hash_generated_method = "00D1090628F63367D0D79A7A5FB5C0A3")
    public void incrementExecCount() {
        // ---------- Original Method ----------
        //this.execCount++;
    }

    
}

