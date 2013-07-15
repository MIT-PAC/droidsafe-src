package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AllowParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.748 -0400", hash_original_method = "A24A575FAE973D160C4E5E7D0F1284A3", hash_generated_method = "B5D028234EA72E3459767A406114950D")
    public  AllowParser(String allow) {
        super(allow);
        addTaint(allow.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.748 -0400", hash_original_method = "A8034B0A3FEDB25038322A25EEE239D9", hash_generated_method = "3FAC5FFB098D2FF0D0FAAFD1280D611A")
    protected  AllowParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.749 -0400", hash_original_method = "EEEC9A9B7336175FA90CC43255548EC9", hash_generated_method = "7E423F98143FDBF70163C798C9496DD3")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1475597954 = null; 
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
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1966717134 = (lexer.lookAhead(0) == ',');
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
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1475597954 = list;
        } 
        finally 
        {
            dbg_leave("AllowParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1475597954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1475597954;
        
        
    }

    
}

