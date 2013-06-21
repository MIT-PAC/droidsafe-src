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

public class ContentDispositionParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.259 -0400", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "96B2664728EA4150012B744BF79D4677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
        dsTaint.addTaint(contentDisposition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.259 -0400", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "F7B528B4179FD0F17D4B177462F42C46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ContentDispositionParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.259 -0400", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "D310270A889282B6219300D204240091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("ContentDispositionParser.parse");
        try 
        {
            headerName(TokenTypes.CONTENT_DISPOSITION);
            ContentDisposition cd;
            cd = new ContentDisposition();
            cd.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            cd.setDispositionType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(cd);
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("ContentDispositionParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

