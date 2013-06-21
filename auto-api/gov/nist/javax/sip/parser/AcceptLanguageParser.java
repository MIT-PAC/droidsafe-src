package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import java.text.ParseException;

public class AcceptLanguageParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.209 -0400", hash_original_method = "4ECD6586A5A6ED08B6159E7C6D7079C1", hash_generated_method = "55E06D8E4782750E09EE1FFBAF916AD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguageParser(String acceptLanguage) {
        super(acceptLanguage);
        dsTaint.addTaint(acceptLanguage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.209 -0400", hash_original_method = "8738AF37C5C1AC35B7D6DAA26504D715", hash_generated_method = "A54127C7C264051A072088B7CD40D578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AcceptLanguageParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.210 -0400", hash_original_method = "FB0497E5D9550DB51E743204446EFE6C", hash_generated_method = "5891819F5C99C52CE0A679FF62F19662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        AcceptLanguageList acceptLanguageList;
        acceptLanguageList = new AcceptLanguageList();
        dbg_enter("AcceptLanguageParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_LANGUAGE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1674521456 = (lexer.lookAhead(0) != '\n');
                {
                    AcceptLanguage acceptLanguage;
                    acceptLanguage = new AcceptLanguage();
                    acceptLanguage.setHeaderName(SIPHeaderNames.ACCEPT_LANGUAGE);
                    {
                        boolean varF3558FE0373DEEFA605FB4C8BD89099A_1878419223 = (lexer.lookAhead(0) != ';');
                        {
                            lexer.match(TokenTypes.ID);
                            Token value;
                            value = lexer.getNextToken();
                            acceptLanguage.setLanguageRange(value.getTokenValue());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_694257688 = (lexer.lookAhead(0) == ';');
                        {
                            this.lexer.match(';');
                            this.lexer.SPorHT();
                            this.lexer.match('q');
                            this.lexer.SPorHT();
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            lexer.match(TokenTypes.ID);
                            Token value;
                            value = lexer.getNextToken();
                            try 
                            {
                                float fl;
                                fl = Float.parseFloat(value.getTokenValue());
                                acceptLanguage.setQValue(fl);
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
                        } //End block
                    } //End collapsed parenthetic
                    acceptLanguageList.add(acceptLanguage);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1387092179 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                        } //End block
                        this.lexer.SPorHT();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("AcceptLanguageParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

