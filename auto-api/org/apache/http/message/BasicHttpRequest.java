package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpProtocolParams;

public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.137 -0400", hash_original_field = "52DD8E4929E0B6524949DDA0CE8874AA", hash_generated_field = "1A948EEF4738D8B68129911C16DED26C")

    private RequestLine requestline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.137 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.137 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.137 -0400", hash_original_method = "D336B902E966467A394D4F5E82995C23", hash_generated_method = "77274DE07DB6175EBB38F1A5F256BCE1")
    public  BasicHttpRequest(final String method, final String uri) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Method name may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Request URI may not be null");
        } //End block
        this.method = method;
        this.uri = uri;
        this.requestline = null;
        // ---------- Original Method ----------
        //if (method == null) {
            //throw new IllegalArgumentException("Method name may not be null");
        //}
        //if (uri == null) {
            //throw new IllegalArgumentException("Request URI may not be null");
        //}
        //this.method = method;
        //this.uri = uri;
        //this.requestline = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.139 -0400", hash_original_method = "32D970961D566BAF565D674274EE91DF", hash_generated_method = "4D6D3FD0CDBB41B3076F8A0779AAE1F0")
    public  BasicHttpRequest(final String method, final String uri, final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(ver.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.139 -0400", hash_original_method = "6934C052A0F550106B98ACB21507F0F6", hash_generated_method = "A86690524D8F454C5FE5130A8D68C25A")
    public  BasicHttpRequest(final RequestLine requestline) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Request line may not be null");
        } //End block
        this.requestline = requestline;
        this.method = requestline.getMethod();
        this.uri = requestline.getUri();
        // ---------- Original Method ----------
        //if (requestline == null) {
            //throw new IllegalArgumentException("Request line may not be null");
        //}
        //this.requestline = requestline;
        //this.method = requestline.getMethod();
        //this.uri = requestline.getUri();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.141 -0400", hash_original_method = "6D74E90047F33871E1F46E26807064EE", hash_generated_method = "5C6D65A6964783AAF1817B737FBCD200")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1418325128 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1265426782 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1418325128 = this.requestline.getProtocolVersion();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1265426782 = HttpProtocolParams.getVersion(getParams());
        } //End block
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_1529001951; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1529001951 = varB4EAC82CA7396A68D541C85D26508E83_1418325128;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1529001951 = varB4EAC82CA7396A68D541C85D26508E83_1265426782;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1529001951.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1529001951;
        // ---------- Original Method ----------
        //if (this.requestline != null) {
            //return this.requestline.getProtocolVersion();
        //} else {
            //return HttpProtocolParams.getVersion(getParams());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.141 -0400", hash_original_method = "C42D62E680F5FCF6E09789DDCB998F05", hash_generated_method = "6C836A99D61AA0FE577BA4C000E1B7FB")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_231759974 = null; //Variable for return #1
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1411668083 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_231759974 = this.requestline;
        } //End block
        {
            ProtocolVersion ver;
            ver = HttpProtocolParams.getVersion(getParams());
            varB4EAC82CA7396A68D541C85D26508E83_1411668083 = new BasicRequestLine(this.method, this.uri, ver);
        } //End block
        RequestLine varA7E53CE21691AB073D9660D615818899_952270251; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_952270251 = varB4EAC82CA7396A68D541C85D26508E83_231759974;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_952270251 = varB4EAC82CA7396A68D541C85D26508E83_1411668083;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_952270251.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_952270251;
        // ---------- Original Method ----------
        //if (this.requestline != null) {
            //return this.requestline;
        //} else {
            //ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
            //return new BasicRequestLine(this.method, this.uri, ver);
        //}
    }

    
}

