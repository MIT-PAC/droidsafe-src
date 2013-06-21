package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;

public class ReferredByParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.736 -0400", hash_original_method = "B42987DBDBA12D8A1BC8285C2A945786", hash_generated_method = "CE411DC20F603ABBB77227C60F332758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferredByParser(String referBy) {
        super(referBy);
        dsTaint.addTaint(referBy);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.736 -0400", hash_original_method = "CCD7CFF6FCA48FCEC6FB3D9B7402721E", hash_generated_method = "CA9CFBA73D70A722105BAA06A32E55B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ReferredByParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.737 -0400", hash_original_method = "17616601F399F4EC4152D86BF5F11B96", hash_generated_method = "34D491FD52CD83BDA65CFFECD2A9B409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.REFERREDBY_TO);
        ReferredBy referBy;
        referBy = new ReferredBy();
        super.parse(referBy);
        this.lexer.match('\n');
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //headerName(TokenTypes.REFERREDBY_TO);
        //ReferredBy referBy = new ReferredBy();
        //super.parse(referBy);
        //this.lexer.match('\n');
        //return referBy;
    }

    
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

    
}

