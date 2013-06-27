package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.295 -0400", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "12D1D6A1FF5C12C3F1476BBA8E937853")
    public  SupportedParser(String supported) {
        super(supported);
        addTaint(supported.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.296 -0400", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "BBF8FA0AF39F77794FFB58F84C4400DC")
    protected  SupportedParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.297 -0400", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "D85AC4A147A14A321C52942C12425915")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_84055472 = null; //Variable for return #1
        SupportedList supportedList;
        supportedList = new SupportedList();
        dbg_enter("SupportedParser.parse");
        try 
        {
            headerName(TokenTypes.SUPPORTED);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_193356211 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Supported supported;
                    supported = new Supported();
                    supported.setHeaderName(SIPHeaderNames.SUPPORTED);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    supported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    supportedList.add(supported);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_617166693 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            supported = new Supported();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            supported.setOptionTag(token.getTokenValue());
                            this.lexer.SPorHT();
                            supportedList.add(supported);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("SupportedParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_84055472 = supportedList;
        varB4EAC82CA7396A68D541C85D26508E83_84055472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84055472;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

