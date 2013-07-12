package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpProtocolParams;

public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.493 -0400", hash_original_field = "52DD8E4929E0B6524949DDA0CE8874AA", hash_generated_field = "1A948EEF4738D8B68129911C16DED26C")

    private RequestLine requestline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.493 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.493 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.494 -0400", hash_original_method = "D336B902E966467A394D4F5E82995C23", hash_generated_method = "452E9D05162A7F89DAC09305D6D5D159")
    public  BasicHttpRequest(final String method, final String uri) {
        super();
    if(method == null)        
        {
            IllegalArgumentException var8A5B4D7BD491CB0F8D7A1A7F250316C5_973586119 = new IllegalArgumentException("Method name may not be null");
            var8A5B4D7BD491CB0F8D7A1A7F250316C5_973586119.addTaint(taint);
            throw var8A5B4D7BD491CB0F8D7A1A7F250316C5_973586119;
        } 
    if(uri == null)        
        {
            IllegalArgumentException var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1850966418 = new IllegalArgumentException("Request URI may not be null");
            var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1850966418.addTaint(taint);
            throw var7E2E287C9A1E5F37DBFB2C9CB0A67B1E_1850966418;
        } 
        this.method = method;
        this.uri = uri;
        this.requestline = null;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.495 -0400", hash_original_method = "32D970961D566BAF565D674274EE91DF", hash_generated_method = "A33C678434B289592570C6B71DAC0A6E")
    public  BasicHttpRequest(final String method, final String uri, final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
        addTaint(ver.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.496 -0400", hash_original_method = "6934C052A0F550106B98ACB21507F0F6", hash_generated_method = "65B989D9B8528FF0EEAD04AA35D21A43")
    public  BasicHttpRequest(final RequestLine requestline) {
        super();
    if(requestline == null)        
        {
            IllegalArgumentException var57E7C227464A845296BA51EE2C094FE3_584782272 = new IllegalArgumentException("Request line may not be null");
            var57E7C227464A845296BA51EE2C094FE3_584782272.addTaint(taint);
            throw var57E7C227464A845296BA51EE2C094FE3_584782272;
        } 
        this.requestline = requestline;
        this.method = requestline.getMethod();
        this.uri = requestline.getUri();
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.496 -0400", hash_original_method = "6D74E90047F33871E1F46E26807064EE", hash_generated_method = "CFAB73EEB487C625BAA86D93F9C5793C")
    public ProtocolVersion getProtocolVersion() {
    if(this.requestline != null)        
        {
ProtocolVersion varD6486995FFCD7C27F8CD9B1B0590B82A_1912461121 =             this.requestline.getProtocolVersion();
            varD6486995FFCD7C27F8CD9B1B0590B82A_1912461121.addTaint(taint);
            return varD6486995FFCD7C27F8CD9B1B0590B82A_1912461121;
        } 
        else
        {
ProtocolVersion varEDB6822BC4AFEFEDB387B740DB02A284_1013079929 =             HttpProtocolParams.getVersion(getParams());
            varEDB6822BC4AFEFEDB387B740DB02A284_1013079929.addTaint(taint);
            return varEDB6822BC4AFEFEDB387B740DB02A284_1013079929;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.497 -0400", hash_original_method = "C42D62E680F5FCF6E09789DDCB998F05", hash_generated_method = "D68F2D297923946E72345978ECDC34F0")
    public RequestLine getRequestLine() {
    if(this.requestline != null)        
        {
RequestLine var601B9A07762CDECF774B860E98E786BE_1167059138 =             this.requestline;
            var601B9A07762CDECF774B860E98E786BE_1167059138.addTaint(taint);
            return var601B9A07762CDECF774B860E98E786BE_1167059138;
        } 
        else
        {
            ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
RequestLine var3D9B02579459F8A1CA31232B14F74FCA_1895410224 =             new BasicRequestLine(this.method, this.uri, ver);
            var3D9B02579459F8A1CA31232B14F74FCA_1895410224.addTaint(taint);
            return var3D9B02579459F8A1CA31232B14F74FCA_1895410224;
        } 
        
        
            
        
            
            
        
    }

    
}

