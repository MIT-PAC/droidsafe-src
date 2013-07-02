package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class MaxForwardsParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.052 -0400", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "48AAFDDDE42774E4C5643D05760B0D86")
    public  MaxForwardsParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.052 -0400", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "5B26658256F06654B3E660E86989DD56")
    protected  MaxForwardsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.052 -0400", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "0161BBDA47C70FD63A41BB88E5CF4273")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1720961711 = null; 
        dbg_enter("MaxForwardsParser.enter");
        try 
        {
            MaxForwards contentLength = new MaxForwards();
            headerName(TokenTypes.MAX_FORWARDS);
            String number = this.lexer.number();
            contentLength.setMaxForwards(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1720961711 = contentLength;
        } 
        catch (InvalidArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } 
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } 
        finally 
        {
            dbg_leave("MaxForwardsParser.leave");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1720961711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1720961711;
        
        
            
        
            
            
            
            
            
            
            
        
            
        
            
        
            
                
        
    }

    
}

