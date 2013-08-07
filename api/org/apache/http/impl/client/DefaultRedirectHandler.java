package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;




public class DefaultRedirectHandler implements RedirectHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.714 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.715 -0400", hash_original_method = "2DD669B5624C7C7440898F877B0DEDA7", hash_generated_method = "AF7D1DF7149AE5425855C691382FBA51")
    public  DefaultRedirectHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.716 -0400", hash_original_method = "03F3AE903C1DF30A5B96C5B08682C8BA", hash_generated_method = "41D4D7C81E24A85E49C88B0BF083A225")
    public boolean isRedirectRequested(
            final HttpResponse response,
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_205919791 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_205919791.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_205919791;
        } //End block
        int statusCode = response.getStatusLine().getStatusCode();
switch(statusCode){
        case HttpStatus.SC_MOVED_TEMPORARILY:
        case HttpStatus.SC_MOVED_PERMANENTLY:
        case HttpStatus.SC_SEE_OTHER:
        case HttpStatus.SC_TEMPORARY_REDIRECT:
        boolean varB326B5062B2F0E69046810717534CB09_673538655 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835401411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835401411;
        default:
        boolean var68934A3E9455FA72420237EB05902327_651032240 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817164914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817164914;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.720 -0400", hash_original_method = "21747B99F20BEEB46FB81199FFB99B8C", hash_generated_method = "45EA369CF770069B804E499C59E2E04A")
    public URI getLocationURI(
            final HttpResponse response, 
            final HttpContext context) throws ProtocolException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1042809832 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1042809832.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1042809832;
        } //End block
        Header locationHeader = response.getFirstHeader("location");
        if(locationHeader == null)        
        {
            ProtocolException varA29CE366834988ED7E32EF8A9BD88635_169622675 = new ProtocolException(
                    "Received redirect response " + response.getStatusLine()
                    + " but no location header");
            varA29CE366834988ED7E32EF8A9BD88635_169622675.addTaint(taint);
            throw varA29CE366834988ED7E32EF8A9BD88635_169622675;
        } //End block
        String location = locationHeader.getValue();
        if(this.log.isDebugEnabled())        
        {
            this.log.debug("Redirect requested to location '" + location + "'");
        } //End block
        URI uri;
        try 
        {
            uri = new URI(location);
        } //End block
        catch (URISyntaxException ex)
        {
            ProtocolException var72DAF5DC676ECD76CE1D70F27EB6B68F_835281392 = new ProtocolException("Invalid redirect URI: " + location, ex);
            var72DAF5DC676ECD76CE1D70F27EB6B68F_835281392.addTaint(taint);
            throw var72DAF5DC676ECD76CE1D70F27EB6B68F_835281392;
        } //End block
        HttpParams params = response.getParams();
        if(!uri.isAbsolute())        
        {
            if(params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT))            
            {
                ProtocolException varF2AF951263D0E8DF4E3DFDCAC5023741_1047629130 = new ProtocolException("Relative redirect location '" 
                        + uri + "' not allowed");
                varF2AF951263D0E8DF4E3DFDCAC5023741_1047629130.addTaint(taint);
                throw varF2AF951263D0E8DF4E3DFDCAC5023741_1047629130;
            } //End block
            HttpHost target = (HttpHost) context.getAttribute(
                    ExecutionContext.HTTP_TARGET_HOST);
            if(target == null)            
            {
                IllegalStateException var836BD5955075A20D6BF6B9A3EF141972_298288953 = new IllegalStateException("Target host not available " +
                        "in the HTTP context");
                var836BD5955075A20D6BF6B9A3EF141972_298288953.addTaint(taint);
                throw var836BD5955075A20D6BF6B9A3EF141972_298288953;
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
                ProtocolException var160B5365F5E5F597D57076D8A0C02C6A_1416457088 = new ProtocolException(ex.getMessage(), ex);
                var160B5365F5E5F597D57076D8A0C02C6A_1416457088.addTaint(taint);
                throw var160B5365F5E5F597D57076D8A0C02C6A_1416457088;
            } //End block
        } //End block
        if(params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS))        
        {
            RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute(
                    REDIRECT_LOCATIONS);
            if(redirectLocations == null)            
            {
                redirectLocations = new RedirectLocations();
                context.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
            } //End block
            URI redirectURI;
            if(uri.getFragment() != null)            
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
                    ProtocolException var160B5365F5E5F597D57076D8A0C02C6A_1282934520 = new ProtocolException(ex.getMessage(), ex);
                    var160B5365F5E5F597D57076D8A0C02C6A_1282934520.addTaint(taint);
                    throw var160B5365F5E5F597D57076D8A0C02C6A_1282934520;
                } //End block
            } //End block
            else
            {
                redirectURI = uri;
            } //End block
            if(redirectLocations.contains(redirectURI))            
            {
                CircularRedirectException var2608332DF4B6741AA03D9F0EBCDDB1B4_1567656662 = new CircularRedirectException("Circular redirect to '" +
                        redirectURI + "'");
                var2608332DF4B6741AA03D9F0EBCDDB1B4_1567656662.addTaint(taint);
                throw var2608332DF4B6741AA03D9F0EBCDDB1B4_1567656662;
            } //End block
            else
            {
                redirectLocations.add(redirectURI);
            } //End block
        } //End block
URI varD12B663A5EB2F9B068EED08B4C05ECCC_198668064 =         uri;
        varD12B663A5EB2F9B068EED08B4C05ECCC_198668064.addTaint(taint);
        return varD12B663A5EB2F9B068EED08B4C05ECCC_198668064;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.722 -0400", hash_original_field = "CACA42EF18E239159E672E61845CAAD5", hash_generated_field = "AED16E84EEB6EA92E138FA12F2449034")

    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
}

