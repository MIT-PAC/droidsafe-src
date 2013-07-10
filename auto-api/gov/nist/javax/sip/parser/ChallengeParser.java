package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public abstract class ChallengeParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.828 -0400", hash_original_method = "0297ABBADD5BD655B8C4CB1A6717CB49", hash_generated_method = "719892B1E8D278F5962FC3FCB6618200")
    protected  ChallengeParser(String challenge) {
        super(challenge);
        addTaint(challenge.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.828 -0400", hash_original_method = "FE6E9A1011CEBAC8DED6715FCD76DE94", hash_generated_method = "36BC49D420A570C5A7102D5D60C3B1AC")
    protected  ChallengeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.828 -0400", hash_original_method = "9DA7C681662806B106F4C258133C7994", hash_generated_method = "ACBB75F54B75D8712A7AB87933F2824E")
    protected void parseParameter(AuthenticationHeader header) throws ParseException {
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } 
        finally 
        {
            dbg_leave("parseParameter");
        } 
        addTaint(header.getTaint());
        
        
            
        
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.828 -0400", hash_original_method = "B311542306ECD32A0F10ABE0BAAE80D2", hash_generated_method = "1A80ECD48D31B50867E9A757E27221ED")
    public void parse(AuthenticationHeader header) throws ParseException {
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        this.lexer.SPorHT();
        header.setScheme(type.getTokenValue());
        try 
        {
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_162748935 = (lexer.lookAhead(0) != '\n');
                {
                    this.parseParameter(header);
                    this.lexer.SPorHT();
                    char la = lexer.lookAhead(0);
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } 
            } 
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        addTaint(header.getTaint());
        
        
        
        
        
        
        
            
                
                
                
                
                    
                
                
            
        
            
        
    }

    
}

