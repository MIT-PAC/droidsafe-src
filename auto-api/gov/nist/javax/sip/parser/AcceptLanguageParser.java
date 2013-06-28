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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.645 -0400", hash_original_method = "4ECD6586A5A6ED08B6159E7C6D7079C1", hash_generated_method = "68B941454870B09E18FF5563FC674CF8")
    public  AcceptLanguageParser(String acceptLanguage) {
        super(acceptLanguage);
        addTaint(acceptLanguage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.646 -0400", hash_original_method = "8738AF37C5C1AC35B7D6DAA26504D715", hash_generated_method = "44799DF67856C143D12EE029A648B896")
    protected  AcceptLanguageParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.647 -0400", hash_original_method = "FB0497E5D9550DB51E743204446EFE6C", hash_generated_method = "D2446E7A4FE4AA1253A511A638E1318E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1131183348 = null; //Variable for return #1
        AcceptLanguageList acceptLanguageList = new AcceptLanguageList();
        dbg_enter("AcceptLanguageParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_LANGUAGE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_259800978 = (lexer.lookAhead(0) != '\n');
                {
                    AcceptLanguage acceptLanguage = new AcceptLanguage();
                    acceptLanguage.setHeaderName(SIPHeaderNames.ACCEPT_LANGUAGE);
                    {
                        boolean varF3558FE0373DEEFA605FB4C8BD89099A_98848469 = (lexer.lookAhead(0) != ';');
                        {
                            lexer.match(TokenTypes.ID);
                            Token value = lexer.getNextToken();
                            acceptLanguage.setLanguageRange(value.getTokenValue());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_1506695533 = (lexer.lookAhead(0) == ';');
                        {
                            this.lexer.match(';');
                            this.lexer.SPorHT();
                            this.lexer.match('q');
                            this.lexer.SPorHT();
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            lexer.match(TokenTypes.ID);
                            Token value = lexer.getNextToken();
                            try 
                            {
                                float fl = Float.parseFloat(value.getTokenValue());
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
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_664641763 = (lexer.lookAhead(0) == ',');
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
        varB4EAC82CA7396A68D541C85D26508E83_1131183348 = acceptLanguageList;
        varB4EAC82CA7396A68D541C85D26508E83_1131183348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1131183348;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

