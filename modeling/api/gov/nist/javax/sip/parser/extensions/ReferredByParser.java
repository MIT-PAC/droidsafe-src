package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.ReferredBy;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class ReferredByParser extends AddressParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.961 -0500", hash_original_method = "82F03150C822A41FBE0CF591ACC6B7EA", hash_generated_method = "C7983019473C7E424A7264EFBDFE05A3")
    
public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Referred-By: <sip:dave@denver.example.org?" +
                    "Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n",
                "Referred-By: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n",
                "Referred-By: T. A. Watson <sip:watson@bell-telephone.com>\n",
                "Referred-By: LittleGuy <sip:UserB@there.com>\n",
                "Referred-By: sip:mranga@120.6.55.9\n",
                "Referred-By: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n" };

        for (int i = 0; i < to.length; i++) {
            ReferredByParser tp = new ReferredByParser(to[i]);
            ReferredBy t = (ReferredBy) tp.parse();
            System.out.println("encoded = " + t.encode());

        }
    }

    /**
     * Creates new ToParser
     * @param referBy String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.953 -0500", hash_original_method = "B42987DBDBA12D8A1BC8285C2A945786", hash_generated_method = "C11482D97B3933DFF07329C83C87588F")
    
public ReferredByParser(String referBy) {
        super(referBy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.956 -0500", hash_original_method = "CCD7CFF6FCA48FCEC6FB3D9B7402721E", hash_generated_method = "B697C666568A793899B147BAA0F14208")
    
protected ReferredByParser(Lexer lexer) {
        super(lexer);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.958 -0500", hash_original_method = "17616601F399F4EC4152D86BF5F11B96", hash_generated_method = "9073F14779DC7234E7D7991D964379DB")
    
public SIPHeader parse() throws ParseException {

        headerName(TokenTypes.REFERREDBY_TO);
        ReferredBy referBy = new ReferredBy();
        super.parse(referBy);
        this.lexer.match('\n');
        return referBy;
    }

    
}

