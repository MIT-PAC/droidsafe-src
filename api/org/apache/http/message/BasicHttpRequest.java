package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpProtocolParams;




public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.970 -0500", hash_original_field = "BB7A5ADC85895E8229C34E0A6FE732F6", hash_generated_field = "1A948EEF4738D8B68129911C16DED26C")

    
    private  RequestLine requestline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.971 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private  String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.971 -0500", hash_original_field = "EDEBE52DCF191A03299D02F6C51FE39B", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private  String uri;
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.972 -0500", hash_original_method = "D336B902E966467A394D4F5E82995C23", hash_generated_method = "E5A9BDAAC5E7D027DBBA71615ACA6A1B")
    public BasicHttpRequest(final String method, final String uri) {
        super();
        if (method == null) {
            throw new IllegalArgumentException("Method name may not be null");
        }
        if (uri == null) {
            throw new IllegalArgumentException("Request URI may not be null");
        }
        this.method = method;
        this.uri = uri;
        this.requestline = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.973 -0500", hash_original_method = "32D970961D566BAF565D674274EE91DF", hash_generated_method = "CD839F8D2AE59D3E9A42445099A6994B")
    public BasicHttpRequest(final String method, final String uri, final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.974 -0500", hash_original_method = "6934C052A0F550106B98ACB21507F0F6", hash_generated_method = "1498B1ADC9262FBA213A6CB02876A3A2")
    public BasicHttpRequest(final RequestLine requestline) {
        super();
        if (requestline == null) {
            throw new IllegalArgumentException("Request line may not be null");
        }
        this.requestline = requestline;
        this.method = requestline.getMethod();
        this.uri = requestline.getUri();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.975 -0500", hash_original_method = "6D74E90047F33871E1F46E26807064EE", hash_generated_method = "A8CF03EA6002AD71099B37468C7ADB19")
    public ProtocolVersion getProtocolVersion() {
        if (this.requestline != null) {
            return this.requestline.getProtocolVersion();
        } else {
            return HttpProtocolParams.getVersion(getParams());
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.976 -0500", hash_original_method = "C42D62E680F5FCF6E09789DDCB998F05", hash_generated_method = "B9BB611E2F486CBE5BAF525A101C1752")
    public RequestLine getRequestLine() {
        if (this.requestline != null) {
            return this.requestline;
        } else {
            ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
            return new BasicRequestLine(this.method, this.uri, ver);
        }
    }

    
}

