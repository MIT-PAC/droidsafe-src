package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class RSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.453 -0400", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "19E58F9B2E34A4644FEA540BC42B5F57")
    public  RSeqParser(String rseq) {
        super(rseq);
        addTaint(rseq.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.453 -0400", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "7AF2D4D55AEBB49DC8FBC47276DA96F7")
    protected  RSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.454 -0400", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "3903F8581EB448E146456DC5769FFC42")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_336988278 = null; 
        dbg_enter("RSeqParser.parse");
        RSeq rseq = new RSeq();
        try 
        {
            headerName(TokenTypes.RSEQ);
            rseq.setHeaderName(SIPHeaderNames.RSEQ);
            String number = this.lexer.number();
            try 
            {
                rseq.setSeqNumber(Long.parseLong(number));
            } 
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_336988278 = rseq;
        } 
        finally 
        {
            dbg_leave("RSeqParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_336988278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_336988278;
        
        
            
        
        
            
            
            
            
                
            
                
            
            
            
            
        
            
                
        
    }

    
}

