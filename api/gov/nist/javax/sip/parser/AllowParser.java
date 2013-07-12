package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AllowParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.846 -0400", hash_original_method = "A24A575FAE973D160C4E5E7D0F1284A3", hash_generated_method = "B5D028234EA72E3459767A406114950D")
    public  AllowParser(String allow) {
        super(allow);
        addTaint(allow.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.847 -0400", hash_original_method = "A8034B0A3FEDB25038322A25EEE239D9", hash_generated_method = "3FAC5FFB098D2FF0D0FAAFD1280D611A")
    protected  AllowParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.849 -0400", hash_original_method = "EEEC9A9B7336175FA90CC43255548EC9", hash_generated_method = "4830DFC201CD09805AEFE707693EACB9")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("AllowParser.parse");
        AllowList list = new AllowList();
        try 
        {
            headerName(TokenTypes.ALLOW);
            Allow allow = new Allow();
            allow.setHeaderName(SIPHeaderNames.ALLOW);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allow.setMethod(token.getTokenValue());
            list.add(allow);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                allow = new Allow();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                allow.setMethod(token.getTokenValue());
                list.add(allow);
                this.lexer.SPorHT();
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1180652692 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1180652692.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1180652692;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("AllowParser.parse");
        } 
        
        
    }

    
}

