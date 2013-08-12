package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.ReferredBy;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class ReferredByParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.778 -0400", hash_original_method = "B42987DBDBA12D8A1BC8285C2A945786", hash_generated_method = "C9FBBE0DB0ED57749A664431F28AF13A")
    public  ReferredByParser(String referBy) {
        super(referBy);
        addTaint(referBy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.780 -0400", hash_original_method = "CCD7CFF6FCA48FCEC6FB3D9B7402721E", hash_generated_method = "B489F8353291A605BC8CE38D58B2E5FF")
    protected  ReferredByParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.780 -0400", hash_original_method = "17616601F399F4EC4152D86BF5F11B96", hash_generated_method = "5476ED3E555FFB13AEC0FA6D5B9A3592")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.REFERREDBY_TO);
        ReferredBy referBy = new ReferredBy();
        super.parse(referBy);
        this.lexer.match('\n');
SIPHeader var21AF0A523395D9560F4C726AD88CCDA3_1579208755 =         referBy;
        var21AF0A523395D9560F4C726AD88CCDA3_1579208755.addTaint(taint);
        return var21AF0A523395D9560F4C726AD88CCDA3_1579208755;
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

