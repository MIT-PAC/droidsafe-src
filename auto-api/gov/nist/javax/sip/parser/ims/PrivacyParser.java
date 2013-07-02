package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.195 -0400", hash_original_method = "1B46B2A155C790BA09FFD6B4EE4B1531", hash_generated_method = "C52570F1CB1987207E05DDE691DF8A74")
    public  PrivacyParser(String privacyType) {
        super(privacyType);
        addTaint(privacyType.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.196 -0400", hash_original_method = "4EC8E3CAF2B7BCDD5010285F1AA3D090", hash_generated_method = "B6191BCF2DD7124A6A14CC9328DDB2C9")
    protected  PrivacyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.196 -0400", hash_original_method = "8BE7913EB9359A0AA04D67D7439E50B1", hash_generated_method = "9B4342883E6FC1BBF382FC16CEBBE515")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1789887799 = null; 
        dbg_enter("PrivacyParser.parse");
        PrivacyList privacyList = new PrivacyList();
        try 
        {
            this.headerName(TokenTypes.PRIVACY);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1466048156 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Privacy privacy = new Privacy();
                    privacy.setHeaderName(SIPHeaderNamesIms.PRIVACY);
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    privacy.setPrivacy(token.getTokenValue());
                    this.lexer.SPorHT();
                    privacyList.add(privacy);
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_291213516 = (lexer.lookAhead(0) == ';');
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
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1789887799 = privacyList;
        } 
        finally 
        {
            dbg_leave("PrivacyParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1789887799.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1789887799;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

