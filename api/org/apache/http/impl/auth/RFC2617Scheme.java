package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HeaderElement;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;




public abstract class RFC2617Scheme extends AuthSchemeBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.084 -0500", hash_original_field = "7854989D01B1B37A56829E9972EAD3C8", hash_generated_field = "B49004743386D72E13E3DDAE8A9782AD")

    private Map<String, String> params;

    /**
     * Default constructor for RFC2617 compliant authetication schemes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.086 -0500", hash_original_method = "80ED69FEE6B04980340E6722B9C707A6", hash_generated_method = "C7EAA723926AA5834DD84B52434026ED")
    
public RFC2617Scheme() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.089 -0500", hash_original_method = "94B96EA06442EEC21FB07C868A7FF799", hash_generated_method = "BA459E51883BFA0901F10D5CC9579C0C")
    
@Override
    protected void parseChallenge(
            final CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException {
        HeaderValueParser parser = BasicHeaderValueParser.DEFAULT;
        ParserCursor cursor = new ParserCursor(pos, buffer.length()); 
        HeaderElement[] elements = parser.parseElements(buffer, cursor);
        if (elements.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        
        this.params = new HashMap<String, String>(elements.length);
        for (HeaderElement element : elements) {
            this.params.put(element.getName(), element.getValue());
        }
    }

    /**
     * Returns authentication parameters map. Keys in the map are lower-cased.
     * 
     * @return the map of authentication parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.091 -0500", hash_original_method = "3C8F107729ADA298748F7F0240656480", hash_generated_method = "9EF1BD8868925B5BA101CD5E80C270AA")
    
protected Map<String, String> getParameters() {
        if (this.params == null) {
            this.params = new HashMap<String, String>();
        }
        return this.params;
    }

    /**
     * Returns authentication parameter with the given name, if available.
     * 
     * @param name The name of the parameter to be returned
     * 
     * @return the parameter with the given name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.094 -0500", hash_original_method = "438C518DA2063D2BB9EB7CDD3EF15700", hash_generated_method = "4A7ED79CC13B42F6BE93091979AB161C")
    
public String getParameter(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name may not be null"); 
        }
        if (this.params == null) {
            return null;
        }
        return this.params.get(name.toLowerCase(Locale.ENGLISH));
    }

    /**
     * Returns authentication realm. The realm may not be null.
     * 
     * @return the authentication realm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.096 -0500", hash_original_method = "39A90A5FE6DEA4D9B5180EC009C17361", hash_generated_method = "95628257AAB7B9858F8890E56C3E25EE")
    
public String getRealm() {
        return getParameter("realm");
    }

    
}

