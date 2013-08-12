package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.Subject;

import java.text.ParseException;





public class SubjectParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.887 -0400", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "4E9A24155B9135611E61A72B0B1EB295")
    public  SubjectParser(String subject) {
        super(subject);
        addTaint(subject.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.887 -0400", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "0138B19C0795435818402790F3EC5E41")
    protected  SubjectParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.888 -0400", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "AC9C0E5B36F656DFF94C5D54FB0E7697")
    public SIPHeader parse() throws ParseException {
        Subject subject = new Subject();
        if(debug)        
        dbg_enter("SubjectParser.parse");
        try 
        {
            headerName(TokenTypes.SUBJECT);
            this.lexer.SPorHT();
            String s = this.lexer.getRest();
            subject.setSubject(s.trim());
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("SubjectParser.parse");
        } //End block
SIPHeader varC07EC1407326EABEF2FB6D781FE48674_1428169184 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_1428169184.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_1428169184;
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

