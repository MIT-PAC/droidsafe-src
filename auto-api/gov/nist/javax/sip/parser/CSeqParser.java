package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.message.SIPRequest;
import java.text.ParseException;
import javax.sip.*;
import gov.nist.core.*;

public class CSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.788 -0400", hash_original_method = "315D7450D70C30EDB72AC7255664118E", hash_generated_method = "A8FDE793BDDBAFC103CC08AC2EE3CE0D")
    public  CSeqParser(String cseq) {
        super(cseq);
        addTaint(cseq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.788 -0400", hash_original_method = "8A2748B0467C573864DACC8328A787A7", hash_generated_method = "206A239BD298BB64B23E3F5F5597EE51")
    protected  CSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.788 -0400", hash_original_method = "25983B4EEF6E8D8834C12C4F0FEB872C", hash_generated_method = "6ED81F8177B68EA17387CD4175E76976")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1457339015 = null; //Variable for return #1
        try 
        {
            CSeq c = new CSeq();
            this.lexer.match(TokenTypes.CSEQ);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            String number = this.lexer.number();
            c.setSeqNumber(Long.parseLong(number));
            this.lexer.SPorHT();
            String m = SIPRequest.getCannonicalName( method() );
            c.setMethod(m);
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1457339015 = c;
        } //End block
        catch (NumberFormatException ex)
        {
            Debug.printStackTrace(ex);
            if (DroidSafeAndroidRuntime.control) throw createParseException("Number format exception");
        } //End block
        catch (InvalidArgumentException ex)
        {
            Debug.printStackTrace(ex);
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1457339015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1457339015;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

