package org.apache.http.impl.auth;

// Droidsafe Imports
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HeaderElement;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public abstract class RFC2617Scheme extends AuthSchemeBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.473 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "B49004743386D72E13E3DDAE8A9782AD")

    private Map<String, String> params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.473 -0400", hash_original_method = "80ED69FEE6B04980340E6722B9C707A6", hash_generated_method = "B90D9EB300F2A770A1CD2621E397D28E")
    public  RFC2617Scheme() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.474 -0400", hash_original_method = "94B96EA06442EEC21FB07C868A7FF799", hash_generated_method = "EC2DABEF87AF6336BDEC5A390CB0FB7E")
    @Override
    protected void parseChallenge(
            final CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException {
        addTaint(len);
        addTaint(pos);
        addTaint(buffer.getTaint());
        HeaderValueParser parser = BasicHeaderValueParser.DEFAULT;
        ParserCursor cursor = new ParserCursor(pos, buffer.length());
        HeaderElement[] elements = parser.parseElements(buffer, cursor);
        if(elements.length == 0)        
        {
            MalformedChallengeException varB4181F999E7B1D8DD4899D0721FD90A4_1862873665 = new MalformedChallengeException("Authentication challenge is empty");
            varB4181F999E7B1D8DD4899D0721FD90A4_1862873665.addTaint(taint);
            throw varB4181F999E7B1D8DD4899D0721FD90A4_1862873665;
        } //End block
        this.params = new HashMap<String, String>(elements.length);
for(HeaderElement element : elements)
        {
            this.params.put(element.getName(), element.getValue());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.475 -0400", hash_original_method = "3C8F107729ADA298748F7F0240656480", hash_generated_method = "0D39B67F5D6066EFD2E3EA279BE7A20C")
    protected Map<String, String> getParameters() {
        if(this.params == null)        
        {
            this.params = new HashMap<String, String>();
        } //End block
Map<String, String> var751A5B03769AE238544A23D7966F9A50_1496208306 =         this.params;
        var751A5B03769AE238544A23D7966F9A50_1496208306.addTaint(taint);
        return var751A5B03769AE238544A23D7966F9A50_1496208306;
        // ---------- Original Method ----------
        //if (this.params == null) {
            //this.params = new HashMap<String, String>();
        //}
        //return this.params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.475 -0400", hash_original_method = "438C518DA2063D2BB9EB7CDD3EF15700", hash_generated_method = "22F41B0DC9A41B6139083CC397BF5C86")
    public String getParameter(final String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var27808EC28D2A61D0D9CEDF204AE56875_117592982 = new IllegalArgumentException("Parameter name may not be null");
            var27808EC28D2A61D0D9CEDF204AE56875_117592982.addTaint(taint);
            throw var27808EC28D2A61D0D9CEDF204AE56875_117592982;
        } //End block
        if(this.params == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1246713137 =             null;
            var540C13E9E156B687226421B24F2DF178_1246713137.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1246713137;
        } //End block
String varFBF77A7E99F84EB59C163A59DAFE14E8_92964026 =         this.params.get(name.toLowerCase(Locale.ENGLISH));
        varFBF77A7E99F84EB59C163A59DAFE14E8_92964026.addTaint(taint);
        return varFBF77A7E99F84EB59C163A59DAFE14E8_92964026;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Parameter name may not be null"); 
        //}
        //if (this.params == null) {
            //return null;
        //}
        //return this.params.get(name.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.476 -0400", hash_original_method = "39A90A5FE6DEA4D9B5180EC009C17361", hash_generated_method = "813663BF78B48991B1734EB381DE98AB")
    public String getRealm() {
String var11FB4A81E0A819600072705611ABDD2B_1738849770 =         getParameter("realm");
        var11FB4A81E0A819600072705611ABDD2B_1738849770.addTaint(taint);
        return var11FB4A81E0A819600072705611ABDD2B_1738849770;
        // ---------- Original Method ----------
        //return getParameter("realm");
    }

    
}

