package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.655 -0400", hash_original_field = "919C8B643B7133116B02FC0D9BB7DF3F", hash_generated_field = "3C457E45ADB86FDABE11A23A4F2DF029")

    private HttpRequest original;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.655 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.655 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.655 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "A45E7E8A6FD19D10CB427B41BDB9B7B2")

    private ProtocolVersion version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.656 -0400", hash_original_field = "BA5B97C127D4F43CB9E9A3264AD4D7F5", hash_generated_field = "27152AB8D3102E368441115AC3DC9BF0")

    private int execCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.657 -0400", hash_original_method = "D4A65E5F770DCC03C77DA90B18FEF06F", hash_generated_method = "32D129AA2F2DC5E99CD8ED1C2B3EA2A8")
    public  RequestWrapper(final HttpRequest request) throws ProtocolException {
        super();
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1636574213 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1636574213.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1636574213;
        } //End block
        this.original = request;
        setParams(request.getParams());
    if(request instanceof HttpUriRequest)        
        {
            this.uri = ((HttpUriRequest) request).getURI();
            this.method = ((HttpUriRequest) request).getMethod();
            this.version = null;
        } //End block
        else
        {
            RequestLine requestLine = request.getRequestLine();
            try 
            {
                this.uri = new URI(requestLine.getUri());
            } //End block
            catch (URISyntaxException ex)
            {
                ProtocolException var7C874B76F38F7AFEA5FA257A07BC94E1_879137056 = new ProtocolException("Invalid request URI: " 
                        + requestLine.getUri(), ex);
                var7C874B76F38F7AFEA5FA257A07BC94E1_879137056.addTaint(taint);
                throw var7C874B76F38F7AFEA5FA257A07BC94E1_879137056;
            } //End block
            this.method = requestLine.getMethod();
            this.version = request.getProtocolVersion();
        } //End block
        this.execCount = 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.657 -0400", hash_original_method = "B4EE14BB96BEB0AC410A8A5396068660", hash_generated_method = "78DDFD160245227817E58E8F087B7FA9")
    public void resetHeaders() {
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
        // ---------- Original Method ----------
        //this.headergroup.clear();
        //setHeaders(this.original.getAllHeaders());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.658 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "3A361861EE9171A558D32C78A43DBB35")
    public String getMethod() {
String varB88046C53AB584448F89DD952FF416E1_193403309 =         this.method;
        varB88046C53AB584448F89DD952FF416E1_193403309.addTaint(taint);
        return varB88046C53AB584448F89DD952FF416E1_193403309;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.659 -0400", hash_original_method = "EFB4193DEE71013FE56C8307DE603C3A", hash_generated_method = "AD26C1FB4FE5CE7F00CD49706D67C9C6")
    public void setMethod(final String method) {
    if(method == null)        
        {
            IllegalArgumentException var8A5B4D7BD491CB0F8D7A1A7F250316C5_55761373 = new IllegalArgumentException("Method name may not be null");
            var8A5B4D7BD491CB0F8D7A1A7F250316C5_55761373.addTaint(taint);
            throw var8A5B4D7BD491CB0F8D7A1A7F250316C5_55761373;
        } //End block
        this.method = method;
        // ---------- Original Method ----------
        //if (method == null) {
            //throw new IllegalArgumentException("Method name may not be null");
        //}
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.660 -0400", hash_original_method = "F281AE1963E10543B4B6C15DF00211F7", hash_generated_method = "89E2EF1A7504D7CEB6BE7F330E67D13C")
    public ProtocolVersion getProtocolVersion() {
    if(this.version != null)        
        {
ProtocolVersion var46589DB4A17DAAAC402EFCA09E806612_1761273827 =             this.version;
            var46589DB4A17DAAAC402EFCA09E806612_1761273827.addTaint(taint);
            return var46589DB4A17DAAAC402EFCA09E806612_1761273827;
        } //End block
        else
        {
ProtocolVersion varEDB6822BC4AFEFEDB387B740DB02A284_1568929630 =             HttpProtocolParams.getVersion(getParams());
            varEDB6822BC4AFEFEDB387B740DB02A284_1568929630.addTaint(taint);
            return varEDB6822BC4AFEFEDB387B740DB02A284_1568929630;
        } //End block
        // ---------- Original Method ----------
        //if (this.version != null) {
            //return this.version;
        //} else {
            //return HttpProtocolParams.getVersion(getParams());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.661 -0400", hash_original_method = "B7AE4BE889035DC000B6C604548769F2", hash_generated_method = "08E29A1903365C05B0B5AAD84F7FC9FB")
    public void setProtocolVersion(final ProtocolVersion version) {
        this.version = version;
        // ---------- Original Method ----------
        //this.version = version;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.661 -0400", hash_original_method = "548D933490D1B58733888D02043A11B0", hash_generated_method = "2F82B20846D7FEA99D2A42C803B90742")
    public URI getURI() {
URI varF8A43570A6D9CE873AAA24BBE28B6265_1128072050 =         this.uri;
        varF8A43570A6D9CE873AAA24BBE28B6265_1128072050.addTaint(taint);
        return varF8A43570A6D9CE873AAA24BBE28B6265_1128072050;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.661 -0400", hash_original_method = "3320A765B2CE48350AC27D9599EAC026", hash_generated_method = "C72876729647E8A3A80A7FBC268F56B2")
    public void setURI(final URI uri) {
        this.uri = uri;
        // ---------- Original Method ----------
        //this.uri = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.662 -0400", hash_original_method = "ED6274B1F39BF31330A4BAC92EA0A101", hash_generated_method = "3F6AF51A82D568F072DE71C383BBC1BF")
    public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion ver = getProtocolVersion();
        String uritext = null;
    if(uri != null)        
        {
            uritext = uri.toASCIIString();
        } //End block
    if(uritext == null || uritext.length() == 0)        
        {
            uritext = "/";
        } //End block
RequestLine var61D16D1DBAF633F6BF5B3B3F6C9131D9_1564002888 =         new BasicRequestLine(method, uritext, ver);
        var61D16D1DBAF633F6BF5B3B3F6C9131D9_1564002888.addTaint(taint);
        return var61D16D1DBAF633F6BF5B3B3F6C9131D9_1564002888;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.662 -0400", hash_original_method = "E0DAFB547C594AC310B6A938D5D82D39", hash_generated_method = "E455703787416F71ACBD8FE87536A204")
    public void abort() throws UnsupportedOperationException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_867082206 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_867082206.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_867082206;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.662 -0400", hash_original_method = "BBFC2C7FEB496FD80D74781CCFD675B2", hash_generated_method = "E6E8A84F496A526C83FD312307736BBE")
    public boolean isAborted() {
        boolean var68934A3E9455FA72420237EB05902327_238396303 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695594682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695594682;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.662 -0400", hash_original_method = "031DFDACC38ED516BF6F8D68C4847FFF", hash_generated_method = "6368E5F9D5FC137A56BABB4C09965F09")
    public HttpRequest getOriginal() {
HttpRequest varC5306F3E881F6B4E683392DE999AE02E_231959337 =         this.original;
        varC5306F3E881F6B4E683392DE999AE02E_231959337.addTaint(taint);
        return varC5306F3E881F6B4E683392DE999AE02E_231959337;
        // ---------- Original Method ----------
        //return this.original;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.663 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "F2F26916A698E95B3DA4AFB6442748BA")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_466681002 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702936283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_702936283;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.663 -0400", hash_original_method = "CF6A18341EACE9B23200B44E9109C775", hash_generated_method = "5FC13166E00CB198686E28E9364B09C5")
    public int getExecCount() {
        int var9E851E1B1933DC6A3C11FD40EC97D806_4017760 = (this.execCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661079640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661079640;
        // ---------- Original Method ----------
        //return this.execCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.663 -0400", hash_original_method = "D2EB72E1336F92B73CC51A8B455EFCB5", hash_generated_method = "198898552D46A3B891136D3847E5D4E5")
    public void incrementExecCount() {
        this.execCount++;
        // ---------- Original Method ----------
        //this.execCount++;
    }

    
}

