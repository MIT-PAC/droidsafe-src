package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class RSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.027 -0400", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "19E58F9B2E34A4644FEA540BC42B5F57")
    public  RSeqParser(String rseq) {
        super(rseq);
        addTaint(rseq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.028 -0400", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "7AF2D4D55AEBB49DC8FBC47276DA96F7")
    protected  RSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.029 -0400", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "A7DCF9F3984C56A425DCAE688CB2F490")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_959988287 = null; //Variable for return #1
        dbg_enter("RSeqParser.parse");
        RSeq rseq;
        rseq = new RSeq();
        try 
        {
            headerName(TokenTypes.RSEQ);
            rseq.setHeaderName(SIPHeaderNames.RSEQ);
            String number;
            number = this.lexer.number();
            try 
            {
                rseq.setSeqNumber(Long.parseLong(number));
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_959988287 = rseq;
        } //End block
        finally 
        {
            dbg_leave("RSeqParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_959988287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_959988287;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("RSeqParser.parse");
        //RSeq rseq = new RSeq();
        //try {
            //headerName(TokenTypes.RSEQ);
            //rseq.setHeaderName(SIPHeaderNames.RSEQ);
            //String number = this.lexer.number();
            //try {
                //rseq.setSeqNumber(Long.parseLong(number));
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return rseq;
        //} finally {
            //if (debug)
                //dbg_leave("RSeqParser.parse");
        //}
    }

    
}

