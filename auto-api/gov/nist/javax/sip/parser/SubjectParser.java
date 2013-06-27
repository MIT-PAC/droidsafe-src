package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SubjectParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.263 -0400", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "4E9A24155B9135611E61A72B0B1EB295")
    public  SubjectParser(String subject) {
        super(subject);
        addTaint(subject.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.263 -0400", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "0138B19C0795435818402790F3EC5E41")
    protected  SubjectParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.264 -0400", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "C74B60FC62E328771843C66A08F51A00")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1497016361 = null; //Variable for return #1
        Subject subject;
        subject = new Subject();
        dbg_enter("SubjectParser.parse");
        try 
        {
            headerName(TokenTypes.SUBJECT);
            this.lexer.SPorHT();
            String s;
            s = this.lexer.getRest();
            subject.setSubject(s.trim());
        } //End block
        finally 
        {
            dbg_leave("SubjectParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1497016361 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_1497016361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497016361;
        // ---------- Original Method ----------
        //Subject subject = new Subject();
        //if (debug)
            //dbg_enter("SubjectParser.parse");
        //try {
            //headerName(TokenTypes.SUBJECT);
            //this.lexer.SPorHT();
            //String s = this.lexer.getRest();
            //subject.setSubject(s.trim());
        //} finally {
            //if (debug)
                //dbg_leave("SubjectParser.parse");
        //}
        //return subject;
    }

    
}

