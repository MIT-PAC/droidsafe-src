package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class InReplyToParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.686 -0400", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "C9411351C1E5B676DB6F3A4FEAFDBC61")
    public  InReplyToParser(String inReplyTo) {
        super(inReplyTo);
        addTaint(inReplyTo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.687 -0400", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "CAE03DC805C508DE845B029D8069273B")
    protected  InReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.688 -0400", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "29C93F2C91D2ABFFB7442FF9C7C26B68")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("InReplyToParser.parse");
        InReplyToList list = new InReplyToList();
        try 
        {
            headerName(TokenTypes.IN_REPLY_TO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                InReplyTo inReplyTo = new InReplyTo();
                inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
    if(lexer.lookAhead(0) == '@')                
                {
                    this.lexer.match('@');
                    this.lexer.match(TokenTypes.ID);
                    Token secToken = lexer.getNextToken();
                    inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                } 
                else
                {
                    inReplyTo.setCallId(token.getTokenValue());
                } 
                this.lexer.SPorHT();
                list.add(inReplyTo);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    inReplyTo = new InReplyTo();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
    if(lexer.lookAhead(0) == '@')                    
                    {
                        this.lexer.match('@');
                        this.lexer.match(TokenTypes.ID);
                        Token secToken = lexer.getNextToken();
                        inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                    } 
                    else
                    {
                        inReplyTo.setCallId(token.getTokenValue());
                    } 
                    list.add(inReplyTo);
                } 
            } 
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_705151226 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_705151226.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_705151226;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("InReplyToParser.parse");
        } 
        
        
    }

    
}

