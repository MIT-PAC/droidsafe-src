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

public class InReplyToParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.995 -0400", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "C9411351C1E5B676DB6F3A4FEAFDBC61")
    public  InReplyToParser(String inReplyTo) {
        super(inReplyTo);
        addTaint(inReplyTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.995 -0400", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "CAE03DC805C508DE845B029D8069273B")
    protected  InReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.996 -0400", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "D51C5857D27C318AAF4910E0D1A15501")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1065000939 = null; //Variable for return #1
        dbg_enter("InReplyToParser.parse");
        InReplyToList list = new InReplyToList();
        try 
        {
            headerName(TokenTypes.IN_REPLY_TO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1268677240 = (lexer.lookAhead(0) != '\n');
                {
                    InReplyTo inReplyTo = new InReplyTo();
                    inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    {
                        boolean var699A6109F8CE540D45AC4B4945B92F1A_387505643 = (lexer.lookAhead(0) == '@');
                        {
                            this.lexer.match('@');
                            this.lexer.match(TokenTypes.ID);
                            Token secToken = lexer.getNextToken();
                            inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                        } //End block
                        {
                            inReplyTo.setCallId(token.getTokenValue());
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                    list.add(inReplyTo);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_677616321 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            inReplyTo = new InReplyTo();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            {
                                boolean var511BDD56B0BEFD5779ABAF457BF7910F_649544421 = (lexer.lookAhead(0) == '@');
                                {
                                    this.lexer.match('@');
                                    this.lexer.match(TokenTypes.ID);
                                    Token secToken = lexer.getNextToken();
                                    inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                                } //End block
                                {
                                    inReplyTo.setCallId(token.getTokenValue());
                                } //End block
                            } //End collapsed parenthetic
                            list.add(inReplyTo);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1065000939 = list;
        } //End block
        finally 
        {
            dbg_leave("InReplyToParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1065000939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065000939;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

