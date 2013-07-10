package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.697 -0400", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "12D1D6A1FF5C12C3F1476BBA8E937853")
    public  SupportedParser(String supported) {
        super(supported);
        addTaint(supported.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.698 -0400", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "BBF8FA0AF39F77794FFB58F84C4400DC")
    protected  SupportedParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.699 -0400", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "A6FF7AD9291875F50FD4813C9086C82D")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1681979962 = null; 
        SupportedList supportedList = new SupportedList();
        dbg_enter("SupportedParser.parse");
        try 
        {
            headerName(TokenTypes.SUPPORTED);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_216930012 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Supported supported = new Supported();
                    supported.setHeaderName(SIPHeaderNames.SUPPORTED);
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    supported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    supportedList.add(supported);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_2123459972 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            supported = new Supported();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            supported.setOptionTag(token.getTokenValue());
                            this.lexer.SPorHT();
                            supportedList.add(supported);
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            dbg_leave("SupportedParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1681979962 = supportedList;
        varB4EAC82CA7396A68D541C85D26508E83_1681979962.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1681979962;
        
        
    }

    
}

