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
import javax.sip.*;

public class WarningParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.717 -0400", hash_original_method = "38623B910ABA654EC8C258B1F2DD35A3", hash_generated_method = "76D294F09BA1D56A411070AB0333F4A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WarningParser(String warning) {
        super(warning);
        dsTaint.addTaint(warning);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.717 -0400", hash_original_method = "AB9AC91F8631F4AA3239C3547D18BC09", hash_generated_method = "A7E4A78735516B10273841AC6C28FC88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected WarningParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.718 -0400", hash_original_method = "5665BE3F4ECC43E3239D3F1D8B9B76A3", hash_generated_method = "DC366F8D8F2CB7F41098DBD270D98FCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        WarningList warningList;
        warningList = new WarningList();
        dbg_enter("WarningParser.parse");
        try 
        {
            headerName(TokenTypes.WARNING);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_2029168882 = (lexer.lookAhead(0) != '\n');
                {
                    Warning warning;
                    warning = new Warning();
                    warning.setHeaderName(SIPHeaderNames.WARNING);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    try 
                    {
                        int code;
                        code = Integer.parseInt(token.getTokenValue());
                        warning.setCode(code);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                    } //End block
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    {
                        boolean var14C8D39E8F94EF2F19C70A9DFC6A715B_2077673178 = (lexer.lookAhead(0) == ':');
                        {
                            this.lexer.match(':');
                            this.lexer.match(TokenTypes.ID);
                            Token token2;
                            token2 = lexer.getNextToken();
                            warning.setAgent(token.getTokenValue() + ":"
                            + token2.getTokenValue());
                        } //End block
                        {
                            warning.setAgent(token.getTokenValue());
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                    String text;
                    text = this.lexer.quotedString();
                    warning.setText(text);
                    this.lexer.SPorHT();
                    warningList.add(warning);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_153640125 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            warning = new Warning();
                            this.lexer.match(TokenTypes.ID);
                            Token tok;
                            tok = lexer.getNextToken();
                            try 
                            {
                                int code;
                                code = Integer.parseInt(tok.getTokenValue());
                                warning.setCode(code);
                            } //End block
                            catch (NumberFormatException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                            } //End block
                            catch (InvalidArgumentException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                            } //End block
                            this.lexer.SPorHT();
                            this.lexer.match(TokenTypes.ID);
                            tok = lexer.getNextToken();
                            {
                                boolean varB1CE638DDED33E6167E387BE765A9361_992450739 = (lexer.lookAhead(0) == ':');
                                {
                                    this.lexer.match(':');
                                    this.lexer.match(TokenTypes.ID);
                                    Token token2;
                                    token2 = lexer.getNextToken();
                                    warning.setAgent(tok.getTokenValue() + ":"
                                + token2.getTokenValue());
                                } //End block
                                {
                                    warning.setAgent(tok.getTokenValue());
                                } //End block
                            } //End collapsed parenthetic
                            this.lexer.SPorHT();
                            text = this.lexer.quotedString();
                            warning.setText(text);
                            this.lexer.SPorHT();
                            warningList.add(warning);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("WarningParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

