package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class PriorityParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.414 -0400", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "9BE707ABFEAC5474F38DAD743E30A97D")
    public  PriorityParser(String priority) {
        super(priority);
        addTaint(priority.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.415 -0400", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "12837E715683B7A7200A42CDA1F47E2E")
    protected  PriorityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.415 -0400", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "CAB4D3CD49C715237596B80F32BE651C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1866494879 = null; 
        dbg_enter("PriorityParser.parse");
        Priority priority = new Priority();
        try 
        {
            headerName(TokenTypes.PRIORITY);
            priority.setHeaderName(SIPHeaderNames.PRIORITY);
            this.lexer.SPorHT();
            priority.setPriority(this.lexer.ttokenSafe());
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1866494879 = priority;
        } 
        finally 
        {
            dbg_leave("PriorityParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1866494879.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1866494879;
        
        
            
        
        
            
            
            
            
            
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void main(String args[]) throws ParseException {
        String p[] = {
            "Priority: 8;a\n"
            };
        for (int i = 0; i < p.length; i++ ) {
        PriorityParser parser =
          new PriorityParser(p[i]);
        Priority prio= (Priority) parser.parse();
        System.out.println("encoded = " + prio.encode());
    }
    }

    
}

