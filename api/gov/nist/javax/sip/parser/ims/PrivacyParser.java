package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import droidsafe.annotations.DSGenerator;

public class PrivacyParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.091 -0400", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "C52570F1CB1987207E05DDE691DF8A74")
    public  PrivacyParser(String privacyType) {
        super(privacyType);
        addTaint(privacyType.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.092 -0400", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "B6191BCF2DD7124A6A14CC9328DDB2C9")
    protected  PrivacyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.094 -0400", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "E01D18141BBFCA440B8423CD111A504D")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("PrivacyParser.parse");
        PrivacyList privacyList = new PrivacyList();
        try 
        {
            this.headerName(TokenTypes.PRIVACY);
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.lexer.SPorHT();
                Privacy privacy = new Privacy();
                privacy.setHeaderName(SIPHeaderNamesIms.PRIVACY);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                privacy.setPrivacy(token.getTokenValue());
                this.lexer.SPorHT();
                privacyList.add(privacy);
                while
(lexer.lookAhead(0) == ';')                
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
            } //End block
SIPHeader varBC40B48158CF46DAFC762B89C302D71E_1893648069 =             privacyList;
            varBC40B48158CF46DAFC762B89C302D71E_1893648069.addTaint(taint);
            return varBC40B48158CF46DAFC762B89C302D71E_1893648069;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("PrivacyParser.parse");
        } //End block
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

