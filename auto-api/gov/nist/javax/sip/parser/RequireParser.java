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

public class RequireParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.100 -0400", hash_original_method = "36FA164E6C8032C19B516E5C5C1FBE28", hash_generated_method = "F94E48DA9E197E682C0111A7C56DD74D")
    public  RequireParser(String require) {
        super(require);
        addTaint(require.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.100 -0400", hash_original_method = "B3FB5559B13CB63E7EB6EFAD451D2F82", hash_generated_method = "6113F629CADCCB8D972C33ACD6FE44BA")
    protected  RequireParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.105 -0400", hash_original_method = "3025739AB5329DC0A390687D4C2BFD5B", hash_generated_method = "855DDDF2F7A6A19343C33C130BD3A22E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1744484320 = null; //Variable for return #1
        RequireList requireList;
        requireList = new RequireList();
        dbg_enter("RequireParser.parse");
        try 
        {
            headerName(TokenTypes.REQUIRE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_871799113 = (lexer.lookAhead(0) != '\n');
                {
                    Require r;
                    r = new Require();
                    r.setHeaderName(SIPHeaderNames.REQUIRE);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    requireList.add(r);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_99654868 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            r = new Require();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            r.setOptionTag(token.getTokenValue());
                            this.lexer.SPorHT();
                            requireList.add(r);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("RequireParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1744484320 = requireList;
        varB4EAC82CA7396A68D541C85D26508E83_1744484320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744484320;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

