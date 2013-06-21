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

public abstract class ChallengeParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.253 -0400", hash_original_method = "0297ABBADD5BD655B8C4CB1A6717CB49", hash_generated_method = "AB8049FF5225C32AC6582858EBB60B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ChallengeParser(String challenge) {
        super(challenge);
        dsTaint.addTaint(challenge);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.253 -0400", hash_original_method = "FE6E9A1011CEBAC8DED6715FCD76DE94", hash_generated_method = "492E1D12B6EEDED5003CC3B42615DAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ChallengeParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.253 -0400", hash_original_method = "9DA7C681662806B106F4C258133C7994", hash_generated_method = "49FB09A325A7112A1D86565CE0E3C0EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseParameter(AuthenticationHeader header) throws ParseException {
        dsTaint.addTaint(header.dsTaint);
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv;
            nv = this.nameValue('=');
            header.setParameter(nv);
        } //End block
        finally 
        {
            dbg_leave("parseParameter");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("parseParameter");
        //try {
            //NameValue nv = this.nameValue('=');
            //header.setParameter(nv);
        //} finally {
            //if (debug)
                //dbg_leave("parseParameter");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.254 -0400", hash_original_method = "B311542306ECD32A0F10ABE0BAAE80D2", hash_generated_method = "55A72B8F2489276338E525DD802C7A66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parse(AuthenticationHeader header) throws ParseException {
        dsTaint.addTaint(header.dsTaint);
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type;
        type = lexer.getNextToken();
        this.lexer.SPorHT();
        header.setScheme(type.getTokenValue());
        try 
        {
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1125084908 = (lexer.lookAhead(0) != '\n');
                {
                    this.parseParameter(header);
                    this.lexer.SPorHT();
                    char la;
                    la = lexer.lookAhead(0);
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        // ---------- Original Method ----------
        //this.lexer.SPorHT();
        //lexer.match(TokenTypes.ID);
        //Token type = lexer.getNextToken();
        //this.lexer.SPorHT();
        //header.setScheme(type.getTokenValue());
        //try {
            //while (lexer.lookAhead(0) != '\n') {
                //this.parseParameter(header);
                //this.lexer.SPorHT();
                //char la = lexer.lookAhead(0);
                //if (la == '\n' || la == '\0')
                    //break;
                //this.lexer.match(',');
                //this.lexer.SPorHT();
            //}
        //} catch (ParseException ex) {
            //throw ex;
        //}
    }

    
}

