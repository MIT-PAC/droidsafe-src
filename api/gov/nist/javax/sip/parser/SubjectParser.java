package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SubjectParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.664 -0400", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "4E9A24155B9135611E61A72B0B1EB295")
    public  SubjectParser(String subject) {
        super(subject);
        addTaint(subject.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.664 -0400", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "0138B19C0795435818402790F3EC5E41")
    protected  SubjectParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.665 -0400", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "C1354700B3CD613E3DAEF07707D38AF9")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1215269339 = null; 
        Subject subject = new Subject();
        dbg_enter("SubjectParser.parse");
        try 
        {
            headerName(TokenTypes.SUBJECT);
            this.lexer.SPorHT();
            String s = this.lexer.getRest();
            subject.setSubject(s.trim());
        } 
        finally 
        {
            dbg_leave("SubjectParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1215269339 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_1215269339.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1215269339;
        
        
        
            
        
            
            
            
            
        
            
                
        
        
    }

    
}

