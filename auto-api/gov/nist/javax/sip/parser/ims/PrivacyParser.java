package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.HeaderParser;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;

public class PrivacyParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.781 -0400", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "FA65DB9491729B6B9E7C1A1B2CFA4EC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrivacyParser(String privacyType) {
        super(privacyType);
        dsTaint.addTaint(privacyType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.781 -0400", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "7F5230746FBCD46782ADDE9F3A9DC464")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PrivacyParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.781 -0400", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "9DF82480B9803751563DC5E35A7BBB97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("PrivacyParser.parse");
        PrivacyList privacyList;
        privacyList = new PrivacyList();
        try 
        {
            this.headerName(TokenTypes.PRIVACY);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1075423136 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Privacy privacy;
                    privacy = new Privacy();
                    privacy.setHeaderName(SIPHeaderNamesIms.PRIVACY);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    privacy.setPrivacy(token.getTokenValue());
                    this.lexer.SPorHT();
                    privacyList.add(privacy);
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_106735749 = (lexer.lookAhead(0) == ';');
                        {
                            this.lexer.match(';');
                            this.lexer.SPorHT();
                            privacy = new Privacy();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            privacy.setPrivacy(token.getTokenValue());
                            this.lexer.SPorHT();
                            privacyList.add(privacy);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("PrivacyParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static void main(String args[]) throws ParseException {
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

    
}

