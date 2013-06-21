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

public class UnsupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.694 -0400", hash_original_method = "A2BE521086BBB92362B9FD64733842A2", hash_generated_method = "62E9D4FF7F05BDBEA9E5659423070D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedParser(String unsupported) {
        super(unsupported);
        dsTaint.addTaint(unsupported);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.694 -0400", hash_original_method = "FB5DFA63EA36D3A5606EA09CE2E82C0B", hash_generated_method = "57C62D2C6DEB4583B9BA4FF010775DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected UnsupportedParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.695 -0400", hash_original_method = "9F68B71E39A8D368C1910EB63F18B506", hash_generated_method = "FBCE94D7B53BF86E1EF468BCF37F979C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        UnsupportedList unsupportedList;
        unsupportedList = new UnsupportedList();
        dbg_enter("UnsupportedParser.parse");
        try 
        {
            headerName(TokenTypes.UNSUPPORTED);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1888887736 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Unsupported unsupported;
                    unsupported = new Unsupported();
                    unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    unsupported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    unsupportedList.add(unsupported);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_307090723 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            unsupported = new Unsupported();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            unsupported.setOptionTag(token.getTokenValue());
                            this.lexer.SPorHT();
                            unsupportedList.add(unsupported);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("UnsupportedParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

