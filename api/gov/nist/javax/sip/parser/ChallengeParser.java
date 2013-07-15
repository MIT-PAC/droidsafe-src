package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public abstract class ChallengeParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.953 -0400", hash_original_method = "0297ABBADD5BD655B8C4CB1A6717CB49", hash_generated_method = "719892B1E8D278F5962FC3FCB6618200")
    protected  ChallengeParser(String challenge) {
        super(challenge);
        addTaint(challenge.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.953 -0400", hash_original_method = "FE6E9A1011CEBAC8DED6715FCD76DE94", hash_generated_method = "36BC49D420A570C5A7102D5D60C3B1AC")
    protected  ChallengeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.954 -0400", hash_original_method = "9DA7C681662806B106F4C258133C7994", hash_generated_method = "E6D914E68849AB28C98C072C729961EF")
    protected void parseParameter(AuthenticationHeader header) throws ParseException {
        addTaint(header.getTaint());
    if(debug)        
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } //End block
        finally 
        {
    if(debug)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.955 -0400", hash_original_method = "B311542306ECD32A0F10ABE0BAAE80D2", hash_generated_method = "32C3EF3462ACE09F76E0F629C07D6C33")
    public void parse(AuthenticationHeader header) throws ParseException {
        addTaint(header.getTaint());
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        this.lexer.SPorHT();
        header.setScheme(type.getTokenValue());
        try 
        {
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.parseParameter(header);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
    if(la == '\n' || la == '\0')                
                break;
                this.lexer.match(',');
                this.lexer.SPorHT();
            } //End block
        } //End block
        catch (ParseException ex)
        {
            ex.addTaint(taint);
            throw ex;
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

