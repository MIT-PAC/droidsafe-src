package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.908 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.908 -0400", hash_original_method = "E0C989328AEDF63A6A5F2E03C11F9A89", hash_generated_method = "3C9B9AA4DECDD14BF6F40DFCFEDAF1CD")
    public  AbstractAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.910 -0400", hash_original_method = "784665A0C5858E32179EE01DA6E7685F", hash_generated_method = "2CB79DA8FFF687BC5A6FD7C3319D559C")
    protected Map<String, Header> parseChallenges(
            final Header[] headers) throws MalformedChallengeException {
        Map<String, Header> varB4EAC82CA7396A68D541C85D26508E83_1351921193 = null; //Variable for return #1
        Map<String, Header> map = new HashMap<String, Header>(headers.length);
        {
            Iterator<Header> varEB4B2371BC0CCACE92E0AF8B1282EFFC_1018987709 = (headers).iterator();
            varEB4B2371BC0CCACE92E0AF8B1282EFFC_1018987709.hasNext();
            Header header = varEB4B2371BC0CCACE92E0AF8B1282EFFC_1018987709.next();
            {
                CharArrayBuffer buffer;
                int pos;
                {
                    buffer = ((FormattedHeader) header).getBuffer();
                    pos = ((FormattedHeader) header).getValuePos();
                } //End block
                {
                    String s = header.getValue();
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("Header value is null");
                    } //End block
                    buffer = new CharArrayBuffer(s.length());
                    buffer.append(s);
                    pos = 0;
                } //End block
                {
                    boolean varAB98498E5EAE33F83FAE94050C546B5B_731863623 = (pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos)));
                } //End collapsed parenthetic
                int beginIndex = pos;
                {
                    boolean varE67B8F42292C21C2A22A5E4055F9BC86_1668265888 = (pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos)));
                } //End collapsed parenthetic
                int endIndex = pos;
                String s = buffer.substring(beginIndex, endIndex);
                map.put(s.toLowerCase(Locale.ENGLISH), header);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1351921193 = map;
        addTaint(headers[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1351921193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1351921193;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.912 -0400", hash_original_method = "8FECC262A845210AB3069E334FB88F27", hash_generated_method = "D60E4D7B82208BC0A8E265810CE52609")
    protected List<String> getAuthPreferences() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_327757468 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_327757468 = DEFAULT_SCHEME_PRIORITY;
        varB4EAC82CA7396A68D541C85D26508E83_327757468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327757468;
        // ---------- Original Method ----------
        //return DEFAULT_SCHEME_PRIORITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.913 -0400", hash_original_method = "D1D9EE92C2146B6CF626CD8981908A9B", hash_generated_method = "DA832504B6940B138EEE8E898DE04E6A")
    public AuthScheme selectScheme(
            final Map<String, Header> challenges, 
            final HttpResponse response,
            final HttpContext context) throws AuthenticationException {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_1389730873 = null; //Variable for return #1
        AuthSchemeRegistry registry = (AuthSchemeRegistry) context.getAttribute(
                ClientContext.AUTHSCHEME_REGISTRY);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("AuthScheme registry not set in HTTP context");
        } //End block
        List<?> authPrefs = (List<?>) context.getAttribute(
                ClientContext.AUTH_SCHEME_PREF);
        {
            authPrefs = getAuthPreferences();
        } //End block
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_272618921 = (this.log.isDebugEnabled());
            {
                this.log.debug("Authentication schemes in the order of preference: " 
                + authPrefs);
            } //End block
        } //End collapsed parenthetic
        AuthScheme authScheme = null;
        {
            int i = 0;
            boolean var68E8B9FCC6DB2F6BBA5DE222C3A83253_146614058 = (i < authPrefs.size());
            {
                String id = (String) authPrefs.get(i);
                Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
                {
                    {
                        boolean var1F07AE7CFC0030A6905273861F288C94_1482334376 = (this.log.isDebugEnabled());
                        {
                            this.log.debug(id + " authentication scheme selected");
                        } //End block
                    } //End collapsed parenthetic
                    try 
                    {
                        authScheme = registry.getAuthScheme(id, response.getParams());
                    } //End block
                    catch (IllegalStateException e)
                    {
                        {
                            boolean var8FB6A51EC66682AFCBAAD946B98737A1_1499360839 = (this.log.isWarnEnabled());
                            {
                                this.log.warn("Authentication scheme " + id + " not supported");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    {
                        boolean var1F07AE7CFC0030A6905273861F288C94_164243141 = (this.log.isDebugEnabled());
                        {
                            this.log.debug("Challenge for " + id + " authentication scheme not available");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new AuthenticationException(
                "Unable to respond to any of these challenges: "
                    + challenges);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1389730873 = authScheme;
        addTaint(challenges.getTaint());
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1389730873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389730873;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.914 -0400", hash_original_field = "8E1E7BBCB8E76EF751092CB437CFD5AB", hash_generated_field = "E23A56881AF7D598302EFE0E841EEF54")

    private static final List<String> DEFAULT_SCHEME_PRIORITY = Arrays.asList(new String[] {
            "ntlm",
            "digest",
            "basic"
    });
}

