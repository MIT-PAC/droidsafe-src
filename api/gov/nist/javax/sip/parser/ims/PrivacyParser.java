package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PrivacyParser extends HeaderParser implements TokenTypes {


    /** Test program */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.230 -0500", hash_original_method = "F91DB731CF24DA9E3E2F5684453D2459", hash_generated_method = "3AB5FDE092DACA9A0F1C16F409861211")
    public static void main(String args[]) throws ParseException
    {
        String rou[] = {

                "Privacy: none\n",
                "Privacy: none;id;user\n"
            };

        for (int i = 0; i < rou.length; i++ ) {
            PrivacyParser rp =
              new PrivacyParser(rou[i]);
            PrivacyList list = (PrivacyList) rp.parse();
            System.out.println("encoded = " +list.encode());
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.226 -0500", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "E5D6672E8CB56B53A9E18D6EC9D94BB9")
    public PrivacyParser(String privacyType) {

        super(privacyType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.227 -0500", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "DFEC70CFD3F07B0233C8601E873BA0C2")
    protected PrivacyParser(Lexer lexer) {

        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.228 -0500", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "8D3FCDE70624A88DB35C97E8715F8F66")
    public SIPHeader parse() throws ParseException
    {
        if (debug)
            dbg_enter("PrivacyParser.parse");

        PrivacyList privacyList = new PrivacyList();

        try
        {
            this.headerName(TokenTypes.PRIVACY);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();

                Privacy privacy = new Privacy();
                privacy.setHeaderName(SIPHeaderNamesIms.PRIVACY);

                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                privacy.setPrivacy(token.getTokenValue());
                this.lexer.SPorHT();
                privacyList.add(privacy);

                // Parsing others option-tags
                while (lexer.lookAhead(0) == ';')
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    privacy = new Privacy();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    privacy.setPrivacy(token.getTokenValue());
                    this.lexer.SPorHT();

                    privacyList.add(privacy);
                }
            }

            return privacyList;

        }
        finally {
            if (debug)
                dbg_leave("PrivacyParser.parse");
        }

    }

    
}

