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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.509 -0400", hash_original_method = "36FA164E6C8032C19B516E5C5C1FBE28", hash_generated_method = "39DF200E1B34A20756019E782FB91DD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequireParser(String require) {
        super(require);
        dsTaint.addTaint(require);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.510 -0400", hash_original_method = "B3FB5559B13CB63E7EB6EFAD451D2F82", hash_generated_method = "DF6DA02C98ED5EAEAED2D6519E634720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RequireParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.510 -0400", hash_original_method = "3025739AB5329DC0A390687D4C2BFD5B", hash_generated_method = "22BB108707FE5588FFC11DBA0687183C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        RequireList requireList;
        requireList = new RequireList();
        dbg_enter("RequireParser.parse");
        try 
        {
            headerName(TokenTypes.REQUIRE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1541984218 = (lexer.lookAhead(0) != '\n');
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
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_563969160 = (lexer.lookAhead(0) == ',');
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
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

