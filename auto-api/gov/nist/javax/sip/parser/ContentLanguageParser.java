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

public class ContentLanguageParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.264 -0400", hash_original_method = "0E099EDE885EEFB21F71B8A7B980DD82", hash_generated_method = "A0A4C55E1C76A00108493947743966E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLanguageParser(String contentLanguage) {
        super(contentLanguage);
        dsTaint.addTaint(contentLanguage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.265 -0400", hash_original_method = "2896A247DEE95FE46B57871751B12905", hash_generated_method = "58E69282816410365E32B83744FBCED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ContentLanguageParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.265 -0400", hash_original_method = "B9174D052A2AFCDDC5C88393A2D6AF07", hash_generated_method = "48C073F9E220866103EDD9749FB518E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("ContentLanguageParser.parse");
        ContentLanguageList list;
        list = new ContentLanguageList();
        try 
        {
            headerName(TokenTypes.CONTENT_LANGUAGE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_534344649 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    ContentLanguage cl;
                    cl = new ContentLanguage( token.getTokenValue() );
                    this.lexer.SPorHT();
                    list.add(cl);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1983433216 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            this.lexer.match(TokenTypes.ID);
                            this.lexer.SPorHT();
                            token = lexer.getNextToken();
                            cl = new ContentLanguage( token.getTokenValue() );
                            this.lexer.SPorHT();
                            list.add(cl);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("ContentLanguageParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

