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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.803 -0400", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "C52570F1CB1987207E05DDE691DF8A74")
    public  PrivacyParser(String privacyType) {
        super(privacyType);
        addTaint(privacyType.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.803 -0400", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "B6191BCF2DD7124A6A14CC9328DDB2C9")
    protected  PrivacyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.809 -0400", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "861CB42B9B0B17453AC8DFC72159270C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_782435367 = null; //Variable for return #1
        dbg_enter("PrivacyParser.parse");
        PrivacyList privacyList;
        privacyList = new PrivacyList();
        try 
        {
            this.headerName(TokenTypes.PRIVACY);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1799872528 = (lexer.lookAhead(0) != '\n');
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
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_725754581 = (lexer.lookAhead(0) == ';');
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
            varB4EAC82CA7396A68D541C85D26508E83_782435367 = privacyList;
        } //End block
        finally 
        {
            dbg_leave("PrivacyParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_782435367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_782435367;
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

