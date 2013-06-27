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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.416 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.417 -0400", hash_original_method = "2DD669B5624C7C7440898F877B0DEDA7", hash_generated_method = "AF7D1DF7149AE5425855C691382FBA51")
    public  DefaultRedirectHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.417 -0400", hash_original_method = "03F3AE903C1DF30A5B96C5B08682C8BA", hash_generated_method = "88AC0DB08D316BC3C782FE18C393C5F6")
    public boolean isRedirectRequested(
            final HttpResponse response,
            final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        int statusCode;
        statusCode = response.getStatusLine().getStatusCode();
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080081162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080081162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.434 -0400", hash_original_method = "21747B99F20BEEB46FB81199FFB99B8C", hash_generated_method = "E7DA0C7EC9D4609240EDC3848B738A59")
    public URI getLocationURI(
            final HttpResponse response, 
            final HttpContext context) throws ProtocolException {
        URI varB4EAC82CA7396A68D541C85D26508E83_408021576 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        Header locationHeader;
        locationHeader = response.getFirstHeader("location");
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                    "Received redirect response " + response.getStatusLine()
                    + " but no location header");
        } //End block
        String location;
        location = locationHeader.getValue();
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_803479243 = (this.log.isDebugEnabled());
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
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid redirect URI: " + location, ex);
        } //End block
        HttpParams params;
        params = response.getParams();
        {
            boolean varF9B59B784A8C73BDFDBDA505CB685702_608817789 = (!uri.isAbsolute());
            {
                {
                    boolean varEEC38DC1A78FB4E25DF1CD4E6C8597FC_913734875 = (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Relative redirect location '" 
                        + uri + "' not allowed");
                    } //End block
                } //End collapsed parenthetic
                HttpHost target;
                target = (HttpHost) context.getAttribute(
                    ExecutionContext.HTTP_TARGET_HOST);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Target host not available " +
                        "in the HTTP context");
                } //End block
                HttpRequest request;
                request = (HttpRequest) context.getAttribute(
                    ExecutionContext.HTTP_REQUEST);
                try 
                {
                    URI requestURI;
                    requestURI = new URI(request.getRequestLine().getUri());
                    URI absoluteRequestURI;
                    absoluteRequestURI = URIUtils.rewriteURI(requestURI, target, true);
                    uri = URIUtils.resolve(absoluteRequestURI, uri);
                } //End block
                catch (URISyntaxException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException(ex.getMessage(), ex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7E39C79F6B08443892071262DECEA45B_1790477275 = (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS));
            {
                RedirectLocations redirectLocations;
                redirectLocations = (RedirectLocations) context.getAttribute(
                    REDIRECT_LOCATIONS);
                {
                    redirectLocations = new RedirectLocations();
                    context.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
                } //End block
                URI redirectURI;
                {
                    boolean varE4CF964BD57C865082A67C6AC59B32FF_2052370074 = (uri.getFragment() != null);
                    {
                        try 
                        {
                            HttpHost target;
                            target = new HttpHost(
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
                    boolean varD81B7BBC1C840166BCF4D092AFDCE75A_478656881 = (redirectLocations.contains(redirectURI));
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
        varB4EAC82CA7396A68D541C85D26508E83_408021576 = uri;
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_408021576.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_408021576;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.434 -0400", hash_original_field = "CACA42EF18E239159E672E61845CAAD5", hash_generated_field = "5930D861EFE85476A27381761F74E160")

    private static String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
}

