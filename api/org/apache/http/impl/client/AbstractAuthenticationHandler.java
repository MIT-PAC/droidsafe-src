package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.245 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.246 -0400", hash_original_method = "E0C989328AEDF63A6A5F2E03C11F9A89", hash_generated_method = "3C9B9AA4DECDD14BF6F40DFCFEDAF1CD")
    public  AbstractAuthenticationHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.247 -0400", hash_original_method = "784665A0C5858E32179EE01DA6E7685F", hash_generated_method = "56B36BD885EC29783212ECFA460B0CAD")
    protected Map<String, Header> parseChallenges(
            final Header[] headers) throws MalformedChallengeException {
        addTaint(headers[0].getTaint());
        Map<String, Header> map = new HashMap<String, Header>(headers.length);
for(Header header : headers)
        {
            CharArrayBuffer buffer;
            int pos;
    if(header instanceof FormattedHeader)            
            {
                buffer = ((FormattedHeader) header).getBuffer();
                pos = ((FormattedHeader) header).getValuePos();
            } 
            else
            {
                String s = header.getValue();
    if(s == null)                
                {
                    MalformedChallengeException var7F2BB44ACA42A76F5E79899908E75392_1025710112 = new MalformedChallengeException("Header value is null");
                    var7F2BB44ACA42A76F5E79899908E75392_1025710112.addTaint(taint);
                    throw var7F2BB44ACA42A76F5E79899908E75392_1025710112;
                } 
                buffer = new CharArrayBuffer(s.length());
                buffer.append(s);
                pos = 0;
            } 
            while
(pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos)))            
            {
                pos++;
            } 
            int beginIndex = pos;
            while
(pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos)))            
            {
                pos++;
            } 
            int endIndex = pos;
            String s = buffer.substring(beginIndex, endIndex);
            map.put(s.toLowerCase(Locale.ENGLISH), header);
        } 
Map<String, Header> var16A0D6FA6CCA40A72F4213E7169FA153_1631838458 =         map;
        var16A0D6FA6CCA40A72F4213E7169FA153_1631838458.addTaint(taint);
        return var16A0D6FA6CCA40A72F4213E7169FA153_1631838458;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.247 -0400", hash_original_method = "8FECC262A845210AB3069E334FB88F27", hash_generated_method = "5C3458C9A02A80E6BFCCBA881AF7B6CA")
    protected List<String> getAuthPreferences() {
List<String> var2B9683BFFB8A6468D0E659E64C20929F_1506952061 =         DEFAULT_SCHEME_PRIORITY;
        var2B9683BFFB8A6468D0E659E64C20929F_1506952061.addTaint(taint);
        return var2B9683BFFB8A6468D0E659E64C20929F_1506952061;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.248 -0400", hash_original_method = "D1D9EE92C2146B6CF626CD8981908A9B", hash_generated_method = "0F66A1F29A90B557AE5833BDB82489AF")
    public AuthScheme selectScheme(
            final Map<String, Header> challenges, 
            final HttpResponse response,
            final HttpContext context) throws AuthenticationException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        addTaint(challenges.getTaint());
        AuthSchemeRegistry registry = (AuthSchemeRegistry) context.getAttribute(
                ClientContext.AUTHSCHEME_REGISTRY);
    if(registry == null)        
        {
            IllegalStateException var19021B1761D2A004A1BD3BFCE4096EE3_1063956146 = new IllegalStateException("AuthScheme registry not set in HTTP context");
            var19021B1761D2A004A1BD3BFCE4096EE3_1063956146.addTaint(taint);
            throw var19021B1761D2A004A1BD3BFCE4096EE3_1063956146;
        } 
        List<?> authPrefs = (List<?>) context.getAttribute(
                ClientContext.AUTH_SCHEME_PREF);
    if(authPrefs == null)        
        {
            authPrefs = getAuthPreferences();
        } 
    if(this.log.isDebugEnabled())        
        {
            this.log.debug("Authentication schemes in the order of preference: " 
                + authPrefs);
        } 
        AuthScheme authScheme = null;
for(int i = 0;i < authPrefs.size();i++)
        {
            String id = (String) authPrefs.get(i);
            Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
    if(challenge != null)            
            {
    if(this.log.isDebugEnabled())                
                {
                    this.log.debug(id + " authentication scheme selected");
                } 
                try 
                {
                    authScheme = registry.getAuthScheme(id, response.getParams());
                    break;
                } 
                catch (IllegalStateException e)
                {
    if(this.log.isWarnEnabled())                    
                    {
                        this.log.warn("Authentication scheme " + id + " not supported");
                    } 
                } 
            } 
            else
            {
    if(this.log.isDebugEnabled())                
                {
                    this.log.debug("Challenge for " + id + " authentication scheme not available");
                } 
            } 
        } 
    if(authScheme == null)        
        {
            AuthenticationException var34DCC811AB7511BBAC3E049E65DF97C8_515185239 = new AuthenticationException(
                "Unable to respond to any of these challenges: "
                    + challenges);
            var34DCC811AB7511BBAC3E049E65DF97C8_515185239.addTaint(taint);
            throw var34DCC811AB7511BBAC3E049E65DF97C8_515185239;
        } 
AuthScheme var2B462B7DF158CE6CFBB29C41135FC249_2046656897 =         authScheme;
        var2B462B7DF158CE6CFBB29C41135FC249_2046656897.addTaint(taint);
        return var2B462B7DF158CE6CFBB29C41135FC249_2046656897;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.249 -0400", hash_original_field = "8E1E7BBCB8E76EF751092CB437CFD5AB", hash_generated_field = "E23A56881AF7D598302EFE0E841EEF54")

    private static final List<String> DEFAULT_SCHEME_PRIORITY = Arrays.asList(new String[] {
            "ntlm",
            "digest",
            "basic"
    });
}

