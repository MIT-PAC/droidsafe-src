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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.600 -0400", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "F0F0E6847C399B7A4FA615AFF7558AF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SupportedParser(String supported) {
        super(supported);
        dsTaint.addTaint(supported);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.601 -0400", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "57335DE8D9A930DEC38BC9DE9F9611CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SupportedParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.601 -0400", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "943368698321D6AFD8AAFA69D95EB312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        SupportedList supportedList;
        supportedList = new SupportedList();
        dbg_enter("SupportedParser.parse");
        try 
        {
            headerName(TokenTypes.SUPPORTED);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_878865148 = (lexer.lookAhead(0) != '\n');
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
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1584208499 = (lexer.lookAhead(0) == ',');
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
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

