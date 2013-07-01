package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.ExecutionContext;

public class DefaultRedirectHandler implements RedirectHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.149 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.149 -0400", hash_original_method = "2DD669B5624C7C7440898F877B0DEDA7", hash_generated_method = "AF7D1DF7149AE5425855C691382FBA51")
    public  DefaultRedirectHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.149 -0400", hash_original_method = "03F3AE903C1DF30A5B96C5B08682C8BA", hash_generated_method = "1703BBA3A6B5246D50BC7FCF14E11551")
    public boolean isRedirectRequested(
            final HttpResponse response,
            final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        int statusCode = response.getStatusLine().getStatusCode();
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128627570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128627570;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int statusCode = response.getStatusLine().getStatusCode();
        //switch (statusCode) {
        //case HttpStatus.SC_MOVED_TEMPORARILY:
        //case HttpStatus.SC_MOVED_PERMANENTLY:
        //case HttpStatus.SC_SEE_OTHER:
        //case HttpStatus.SC_TEMPORARY_REDIRECT:
            //return true;
        //default:
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.151 -0400", hash_original_method = "21747B99F20BEEB46FB81199FFB99B8C", hash_generated_method = "AAA1CBAF16CF30A6A08F7654FB584756")
    public URI getLocationURI(
            final HttpResponse response, 
            final HttpContext context) throws ProtocolException {
        URI varB4EAC82CA7396A68D541C85D26508E83_684334488 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        Header locationHeader = response.getFirstHeader("location");
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                    "Received redirect response " + response.getStatusLine()
                    + " but no location header");
        } //End block
        String location = locationHeader.getValue();
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_568285426 = (this.log.isDebugEnabled());
            {
                this.log.debug("Redirect requested to location '" + location + "'");
            } //End block
        } //End collapsed parenthetic
        URI uri;
        try 
        {
            uri = new URI(location);
        } //End block
        catch (URISyntaxException ex)
        {
        	throw new ProtocolException("Invalid redirect URI: " + location, ex);
        } //End block
        HttpParams params = response.getParams();
        {
            boolean varF9B59B784A8C73BDFDBDA505CB685702_1839748198 = (!uri.isAbsolute());
            {
                {
                    boolean varEEC38DC1A78FB4E25DF1CD4E6C8597FC_1533596947 = (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Relative redirect location '" 
                        + uri + "' not allowed");
                    } //End block
                } //End collapsed parenthetic
                HttpHost target = (HttpHost) context.getAttribute(
                    ExecutionContext.HTTP_TARGET_HOST);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Target host not available " +
                        "in the HTTP context");
                } //End block
                HttpRequest request = (HttpRequest) context.getAttribute(
                    ExecutionContext.HTTP_REQUEST);
                try 
                {
                    URI requestURI = new URI(request.getRequestLine().getUri());
                    URI absoluteRequestURI = URIUtils.rewriteURI(requestURI, target, true);
                    uri = URIUtils.resolve(absoluteRequestURI, uri);
                } //End block
                catch (URISyntaxException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException(ex.getMessage(), ex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7E39C79F6B08443892071262DECEA45B_1883948728 = (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS));
            {
                RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute(
                    REDIRECT_LOCATIONS);
                {
                    redirectLocations = new RedirectLocations();
                    context.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
                } //End block
                URI redirectURI;
                {
                    boolean varE4CF964BD57C865082A67C6AC59B32FF_113059501 = (uri.getFragment() != null);
                    {
                        try 
                        {
                            HttpHost target = new HttpHost(
                            uri.getHost(), 
                            uri.getPort(),
                            uri.getScheme());
                            redirectURI = URIUtils.rewriteURI(uri, target, true);
                        } //End block
                        catch (URISyntaxException ex)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ProtocolException(ex.getMessage(), ex);
                        } //End block
                    } //End block
                    {
                        redirectURI = uri;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD81B7BBC1C840166BCF4D092AFDCE75A_1344187849 = (redirectLocations.contains(redirectURI));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new CircularRedirectException("Circular redirect to '" +
                        redirectURI + "'");
                    } //End block
                    {
                        redirectLocations.add(redirectURI);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_684334488 = uri;
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_684334488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_684334488;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.151 -0400", hash_original_field = "CACA42EF18E239159E672E61845CAAD5", hash_generated_field = "AED16E84EEB6EA92E138FA12F2449034")

    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
}

