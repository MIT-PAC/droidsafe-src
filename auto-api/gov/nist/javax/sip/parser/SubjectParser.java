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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.591 -0400", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "5F52ACD471C3CC65ADCEC2C1AB88F399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubjectParser(String subject) {
        super(subject);
        dsTaint.addTaint(subject);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.591 -0400", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "79B3529F3D3C2D3CB77A53D36E097E1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SubjectParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.591 -0400", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "B19777D9D3CA14A1F6E5664E058DE035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        return (SIPHeader)dsTaint.getTaint();
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

