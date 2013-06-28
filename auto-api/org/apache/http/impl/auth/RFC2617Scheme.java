package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.867 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "B49004743386D72E13E3DDAE8A9782AD")

    private Map<String, String> params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.867 -0400", hash_original_method = "80ED69FEE6B04980340E6722B9C707A6", hash_generated_method = "B90D9EB300F2A770A1CD2621E397D28E")
    public  RFC2617Scheme() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.874 -0400", hash_original_method = "94B96EA06442EEC21FB07C868A7FF799", hash_generated_method = "D9E126895440E2BD00C4564D4367B8D2")
    @Override
    protected void parseChallenge(
            final CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException {
        HeaderValueParser parser = BasicHeaderValueParser.DEFAULT;
        ParserCursor cursor = new ParserCursor(pos, buffer.length());
        HeaderElement[] elements = parser.parseElements(buffer, cursor);
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("Authentication challenge is empty");
        } //End block
        this.params = new HashMap<String, String>(elements.length);
        {
            HeaderElement element = elements[0];
            {
                this.params.put(element.getName(), element.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        addTaint(pos);
        addTaint(len);
        // ---------- Original Method ----------
        //HeaderValueParser parser = BasicHeaderValueParser.DEFAULT;
        //ParserCursor cursor = new ParserCursor(pos, buffer.length());
        //HeaderElement[] elements = parser.parseElements(buffer, cursor);
        //if (elements.length == 0) {
            //throw new MalformedChallengeException("Authentication challenge is empty");
        //}
        //this.params = new HashMap<String, String>(elements.length);
        //for (HeaderElement element : elements) {
            //this.params.put(element.getName(), element.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.876 -0400", hash_original_method = "3C8F107729ADA298748F7F0240656480", hash_generated_method = "0E6900DAC25A38123C107C6409DD96A9")
    protected Map<String, String> getParameters() {
        Map<String, String> varB4EAC82CA7396A68D541C85D26508E83_9527055 = null; //Variable for return #1
        {
            this.params = new HashMap<String, String>();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_9527055 = this.params;
        varB4EAC82CA7396A68D541C85D26508E83_9527055.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_9527055;
        // ---------- Original Method ----------
        //if (this.params == null) {
            //this.params = new HashMap<String, String>();
        //}
        //return this.params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.877 -0400", hash_original_method = "438C518DA2063D2BB9EB7CDD3EF15700", hash_generated_method = "FFC19A698CF2CCC7F562915B4A031A48")
    public String getParameter(final String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1487409733 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_924383875 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameter name may not be null");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1487409733 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_924383875 = this.params.get(name.toLowerCase(Locale.ENGLISH));
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1197332263; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1197332263 = varB4EAC82CA7396A68D541C85D26508E83_1487409733;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1197332263 = varB4EAC82CA7396A68D541C85D26508E83_924383875;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1197332263.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1197332263;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Parameter name may not be null"); 
        //}
        //if (this.params == null) {
            //return null;
        //}
        //return this.params.get(name.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.878 -0400", hash_original_method = "39A90A5FE6DEA4D9B5180EC009C17361", hash_generated_method = "FC0F9D733F6B6D0597BD14287A7493A2")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1879415290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1879415290 = getParameter("realm");
        varB4EAC82CA7396A68D541C85D26508E83_1879415290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879415290;
        // ---------- Original Method ----------
        //return getParameter("realm");
    }

    
}

