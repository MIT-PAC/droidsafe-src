package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.959 -0500", hash_original_field = "37C1D0302B013586291E425BC45727A2", hash_generated_field = "3C457E45ADB86FDABE11A23A4F2DF029")
    
    private  HttpRequest original;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.961 -0500", hash_original_field = "1154143EF3A042E6515BD6D5B42C64B6", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.964 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.966 -0500", hash_original_field = "13C53702653F644DDC1FA30419623DC6", hash_generated_field = "A45E7E8A6FD19D10CB427B41BDB9B7B2")

    private ProtocolVersion version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.968 -0500", hash_original_field = "93A811271E55687D3B46AA3FA797E15D", hash_generated_field = "27152AB8D3102E368441115AC3DC9BF0")

    private int execCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.972 -0500", hash_original_method = "D4A65E5F770DCC03C77DA90B18FEF06F", hash_generated_method = "C0206E1AD0FB3C581098735E48064A5B")
    
public RequestWrapper(final HttpRequest request) throws ProtocolException {
        super();
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        this.original = request;
        setParams(request.getParams());
        // Make a copy of the original URI 
        if (request instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) request).getURI();
            this.method = ((HttpUriRequest) request).getMethod();
            this.version = null;
        } else {
            RequestLine requestLine = request.getRequestLine();
            try {
                this.uri = new URI(requestLine.getUri());
            } catch (URISyntaxException ex) {
                throw new ProtocolException("Invalid request URI: " 
                        + requestLine.getUri(), ex);
            }
            this.method = requestLine.getMethod();
            this.version = request.getProtocolVersion();
        }
        this.execCount = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.974 -0500", hash_original_method = "B4EE14BB96BEB0AC410A8A5396068660", hash_generated_method = "1B7F0121B31195EC7FA03414C145F47A")
    
public void resetHeaders() {
        // Make a copy of original headers
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.976 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7472B5026828D1D5EB47237766CBDA14")
    
public String getMethod() {
        return this.method;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.978 -0500", hash_original_method = "EFB4193DEE71013FE56C8307DE603C3A", hash_generated_method = "18FD841B5454B2AB83FCBD812E954F82")
    
public void setMethod(final String method) {
        if (method == null) {
            throw new IllegalArgumentException("Method name may not be null");
        }
        this.method = method;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.981 -0500", hash_original_method = "F281AE1963E10543B4B6C15DF00211F7", hash_generated_method = "B29FD2F4F0EB6836EED105620AE7A6F7")
    
public ProtocolVersion getProtocolVersion() {
        if (this.version != null) {
            return this.version;
        } else {
            return HttpProtocolParams.getVersion(getParams());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.983 -0500", hash_original_method = "B7AE4BE889035DC000B6C604548769F2", hash_generated_method = "5F6F23903F8959F9587F0C5960A71103")
    
public void setProtocolVersion(final ProtocolVersion version) {
        this.version = version;
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.985 -0500", hash_original_method = "548D933490D1B58733888D02043A11B0", hash_generated_method = "FE9C67AB573105BAB4263EEFA9A78DCB")
    
public URI getURI() {
        return this.uri;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.987 -0500", hash_original_method = "3320A765B2CE48350AC27D9599EAC026", hash_generated_method = "26209B88B14367E9C8A191527A27C7FB")
    
public void setURI(final URI uri) {
        this.uri = uri;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.989 -0500", hash_original_method = "ED6274B1F39BF31330A4BAC92EA0A101", hash_generated_method = "39924B4D6F1E6AA189C69E0FFF0425F6")
    
public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion ver = getProtocolVersion();
        String uritext = null;
        if (uri != null) {
            uritext = uri.toASCIIString();
        }
        if (uritext == null || uritext.length() == 0) {
            uritext = "/";
        }
        return new BasicRequestLine(method, uritext, ver);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.992 -0500", hash_original_method = "E0DAFB547C594AC310B6A938D5D82D39", hash_generated_method = "6BBA179A3D49995BE87F7F485D8B226E")
    
public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.994 -0500", hash_original_method = "BBFC2C7FEB496FD80D74781CCFD675B2", hash_generated_method = "C2C048BA92ED71E1094F2102F6C544E8")
    
public boolean isAborted() {
        return false;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.996 -0500", hash_original_method = "031DFDACC38ED516BF6F8D68C4847FFF", hash_generated_method = "C19BDFC727DCC2D2C04301CACF2B6D60")
    
public HttpRequest getOriginal() {
        return this.original;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.998 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    
public boolean isRepeatable() {
        return true;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.001 -0500", hash_original_method = "CF6A18341EACE9B23200B44E9109C775", hash_generated_method = "D012534975EA1936A0C53E346FD27CD9")
    
public int getExecCount() {
        return this.execCount;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.003 -0500", hash_original_method = "D2EB72E1336F92B73CC51A8B455EFCB5", hash_generated_method = "064A0CAD82F0801EC41860A42DC17167")
    
public void incrementExecCount() {
        this.execCount++;
    }
    
}

