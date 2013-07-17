package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpProtocolParams;

public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.867 -0400", hash_original_field = "52DD8E4929E0B6524949DDA0CE8874AA", hash_generated_field = "1A948EEF4738D8B68129911C16DED26C")

    private RequestLine requestline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.867 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.867 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.868 -0400", hash_original_method = "D336B902E966467A394D4F5E82995C23", hash_generated_method = "0FE4AAE896D37E83A2EEB70CE73AB25D")
    public  BasicHttpRequest(final String method, final String uri) {
        super();
        if(method == null)        
        {
            IllegalArgumentException var8A5B4D7BD491CB0F8D7A1A7F250316C5_325407892 = new IllegalArgumentException("Method name may not be null");
            var8A5B4D7BD491CB0F8D7A1A7F250316C5_325407892.addTaint(taint);
            throw var8A5B4D7BD491CB0F8D7A1A7F250316C5_325407892;
        } //End block
        if(uri == null)        
        {
            IllegalArgumentException var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1086662829 = new IllegalArgumentException("Request URI may not be null");
            var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1086662829.addTaint(taint);
            throw var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1086662829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.869 -0400", hash_original_method = "32D970961D566BAF565D674274EE91DF", hash_generated_method = "A33C678434B289592570C6B71DAC0A6E")
    public  BasicHttpRequest(final String method, final String uri, final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
        addTaint(ver.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.870 -0400", hash_original_method = "6934C052A0F550106B98ACB21507F0F6", hash_generated_method = "8CD57FF6CAD09D3B8A0C7CD3B3E61306")
    public  BasicHttpRequest(final RequestLine requestline) {
        super();
        if(requestline == null)        
        {
            IllegalArgumentException var57E7C227464A845296BA51EE2C094FE3_1598526780 = new IllegalArgumentException("Request line may not be null");
            var57E7C227464A845296BA51EE2C094FE3_1598526780.addTaint(taint);
            throw var57E7C227464A845296BA51EE2C094FE3_1598526780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.871 -0400", hash_original_method = "6D74E90047F33871E1F46E26807064EE", hash_generated_method = "124BCC5E791846E4DDA32891199C7991")
    public ProtocolVersion getProtocolVersion() {
        if(this.requestline != null)        
        {
ProtocolVersion varD6486995FFCD7C27F8CD9B1B0590B82A_2110666508 =             this.requestline.getProtocolVersion();
            varD6486995FFCD7C27F8CD9B1B0590B82A_2110666508.addTaint(taint);
            return varD6486995FFCD7C27F8CD9B1B0590B82A_2110666508;
        } //End block
        else
        {
ProtocolVersion varEDB6822BC4AFEFEDB387B740DB02A284_731079875 =             HttpProtocolParams.getVersion(getParams());
            varEDB6822BC4AFEFEDB387B740DB02A284_731079875.addTaint(taint);
            return varEDB6822BC4AFEFEDB387B740DB02A284_731079875;
        } //End block
        // ---------- Original Method ----------
        //if (this.requestline != null) {
            //return this.requestline.getProtocolVersion();
        //} else {
            //return HttpProtocolParams.getVersion(getParams());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.871 -0400", hash_original_method = "C42D62E680F5FCF6E09789DDCB998F05", hash_generated_method = "B52681735E51270FFCB6FDD512B363FA")
    public RequestLine getRequestLine() {
        if(this.requestline != null)        
        {
RequestLine var601B9A07762CDECF774B860E98E786BE_465428303 =             this.requestline;
            var601B9A07762CDECF774B860E98E786BE_465428303.addTaint(taint);
            return var601B9A07762CDECF774B860E98E786BE_465428303;
        } //End block
        else
        {
            ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
RequestLine var3D9B02579459F8A1CA31232B14F74FCA_1236739633 =             new BasicRequestLine(this.method, this.uri, ver);
            var3D9B02579459F8A1CA31232B14F74FCA_1236739633.addTaint(taint);
            return var3D9B02579459F8A1CA31232B14F74FCA_1236739633;
        } //End block
        // ---------- Original Method ----------
        //if (this.requestline != null) {
            //return this.requestline;
        //} else {
            //ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
            //return new BasicRequestLine(this.method, this.uri, ver);
        //}
    }

    
}

