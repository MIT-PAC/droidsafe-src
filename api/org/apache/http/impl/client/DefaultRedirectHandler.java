package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.468 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.468 -0400", hash_original_method = "2DD669B5624C7C7440898F877B0DEDA7", hash_generated_method = "AF7D1DF7149AE5425855C691382FBA51")
    public  DefaultRedirectHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.469 -0400", hash_original_method = "03F3AE903C1DF30A5B96C5B08682C8BA", hash_generated_method = "DB254F98A7FBF69C04F3F32D61E813B8")
    public boolean isRedirectRequested(
            final HttpResponse response,
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_124382015 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_124382015.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_124382015;
        } //End block
        int statusCode = response.getStatusLine().getStatusCode();
switch(statusCode){
        case HttpStatus.SC_MOVED_TEMPORARILY:
        case HttpStatus.SC_MOVED_PERMANENTLY:
        case HttpStatus.SC_SEE_OTHER:
        case HttpStatus.SC_TEMPORARY_REDIRECT:
        boolean varB326B5062B2F0E69046810717534CB09_95241365 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1263586259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1263586259;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1450251473 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633003928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633003928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.472 -0400", hash_original_method = "21747B99F20BEEB46FB81199FFB99B8C", hash_generated_method = "4C06DE48F59618B2DB0DD874CAEBCB39")
    public URI getLocationURI(
            final HttpResponse response, 
            final HttpContext context) throws ProtocolException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_631873870 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_631873870.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_631873870;
        } //End block
        Header locationHeader = response.getFirstHeader("location");
    if(locationHeader == null)        
        {
            ProtocolException varA29CE366834988ED7E32EF8A9BD88635_1269497501 = new ProtocolException(
                    "Received redirect response " + response.getStatusLine()
                    + " but no location header");
            varA29CE366834988ED7E32EF8A9BD88635_1269497501.addTaint(taint);
            throw varA29CE366834988ED7E32EF8A9BD88635_1269497501;
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
            ProtocolException var72DAF5DC676ECD76CE1D70F27EB6B68F_213859880 = new ProtocolException("Invalid redirect URI: " + location, ex);
            var72DAF5DC676ECD76CE1D70F27EB6B68F_213859880.addTaint(taint);
            throw var72DAF5DC676ECD76CE1D70F27EB6B68F_213859880;
        } //End block
        HttpParams params = response.getParams();
    if(!uri.isAbsolute())        
        {
    if(params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT))            
            {
                ProtocolException varF2AF951263D0E8DF4E3DFDCAC5023741_875991697 = new ProtocolException("Relative redirect location '" 
                        + uri + "' not allowed");
                varF2AF951263D0E8DF4E3DFDCAC5023741_875991697.addTaint(taint);
                throw varF2AF951263D0E8DF4E3DFDCAC5023741_875991697;
            } //End block
            HttpHost target = (HttpHost) context.getAttribute(
                    ExecutionContext.HTTP_TARGET_HOST);
    if(target == null)            
            {
                IllegalStateException var836BD5955075A20D6BF6B9A3EF141972_1590230879 = new IllegalStateException("Target host not available " +
                        "in the HTTP context");
                var836BD5955075A20D6BF6B9A3EF141972_1590230879.addTaint(taint);
                throw var836BD5955075A20D6BF6B9A3EF141972_1590230879;
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
                ProtocolException var160B5365F5E5F597D57076D8A0C02C6A_1120875597 = new ProtocolException(ex.getMessage(), ex);
                var160B5365F5E5F597D57076D8A0C02C6A_1120875597.addTaint(taint);
                throw var160B5365F5E5F597D57076D8A0C02C6A_1120875597;
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
                    ProtocolException var160B5365F5E5F597D57076D8A0C02C6A_1426144064 = new ProtocolException(ex.getMessage(), ex);
                    var160B5365F5E5F597D57076D8A0C02C6A_1426144064.addTaint(taint);
                    throw var160B5365F5E5F597D57076D8A0C02C6A_1426144064;
                } //End block
            } //End block
            else
            {
                redirectURI = uri;
            } //End block
    if(redirectLocations.contains(redirectURI))            
            {
                CircularRedirectException var2608332DF4B6741AA03D9F0EBCDDB1B4_1203956149 = new CircularRedirectException("Circular redirect to '" +
                        redirectURI + "'");
                var2608332DF4B6741AA03D9F0EBCDDB1B4_1203956149.addTaint(taint);
                throw var2608332DF4B6741AA03D9F0EBCDDB1B4_1203956149;
            } //End block
            else
            {
                redirectLocations.add(redirectURI);
            } //End block
        } //End block
URI varD12B663A5EB2F9B068EED08B4C05ECCC_495300692 =         uri;
        varD12B663A5EB2F9B068EED08B4C05ECCC_495300692.addTaint(taint);
        return varD12B663A5EB2F9B068EED08B4C05ECCC_495300692;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.473 -0400", hash_original_field = "CACA42EF18E239159E672E61845CAAD5", hash_generated_field = "AED16E84EEB6EA92E138FA12F2449034")

    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
}

