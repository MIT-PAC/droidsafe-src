package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class RequireParser extends HeaderParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.667 -0400", hash_original_method = "36FA164E6C8032C19B516E5C5C1FBE28", hash_generated_method = "F94E48DA9E197E682C0111A7C56DD74D")
    public  RequireParser(String require) {
        super(require);
        addTaint(require.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.668 -0400", hash_original_method = "B3FB5559B13CB63E7EB6EFAD451D2F82", hash_generated_method = "6113F629CADCCB8D972C33ACD6FE44BA")
    protected  RequireParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.669 -0400", hash_original_method = "3025739AB5329DC0A390687D4C2BFD5B", hash_generated_method = "36C80F73F51E0486EB3B4AEBFEC66440")
    public SIPHeader parse() throws ParseException {
        RequireList requireList = new RequireList();
    if(debug)        
        dbg_enter("RequireParser.parse");
        try 
        {
            headerName(TokenTypes.REQUIRE);
            while
(lexer.lookAhead(0) != '\n')            
            {
                Require r = new Require();
                r.setHeaderName(SIPHeaderNames.REQUIRE);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                r.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();
                requireList.add(r);
                while
(lexer.lookAhead(0) == ',')                
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
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("RequireParser.parse");
        } //End block
SIPHeader varD3F029985BC4C44D5532864C73A6BF99_800773700 =         requireList;
        varD3F029985BC4C44D5532864C73A6BF99_800773700.addTaint(taint);
        return varD3F029985BC4C44D5532864C73A6BF99_800773700;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

