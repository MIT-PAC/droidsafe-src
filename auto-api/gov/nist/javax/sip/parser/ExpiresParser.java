package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class ExpiresParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.955 -0400", hash_original_method = "A7328899640752C7683A3AAB5686C434", hash_generated_method = "91AD4A144E3219744EF95FFB87DA18A5")
    public  ExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.956 -0400", hash_original_method = "8C0F40C2F214AF533DDC04CFAC4ADA24", hash_generated_method = "01CE2D3D2FDBF84082EF3A8A9C12D81D")
    protected  ExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.956 -0400", hash_original_method = "BF637AC6A5CBD4DC0512611361485C35", hash_generated_method = "351AC6D52E055CB4DD12105ADF80922E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_700434671 = null; 
        Expires expires = new Expires();
        dbg_enter("parse");
        try 
        {
            lexer.match(TokenTypes.EXPIRES);
            lexer.SPorHT();
            lexer.match(':');
            lexer.SPorHT();
            String nextId = lexer.getNextId();
            lexer.match('\n');
            try 
            {
                int delta = Integer.parseInt(nextId);
                expires.setExpires(delta);
                varB4EAC82CA7396A68D541C85D26508E83_700434671 = expires;
            } 
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException("bad integer format");
            } 
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } 
        } 
        finally 
        {
            dbg_leave("parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_700434671.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_700434671;
        
        
        
            
        
            
            
            
            
            
            
            
                
                
                
            
                
            
                
            
        
            
                
        
    }

    
}

