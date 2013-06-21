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

public class ExpiresParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.281 -0400", hash_original_method = "A7328899640752C7683A3AAB5686C434", hash_generated_method = "098C5E8CD36CE022F5D5EF02BD7672D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpiresParser(String text) {
        super(text);
        dsTaint.addTaint(text);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.281 -0400", hash_original_method = "8C0F40C2F214AF533DDC04CFAC4ADA24", hash_generated_method = "CAC8C5CE056D0A89B9A930D37514C8DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ExpiresParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.281 -0400", hash_original_method = "BF637AC6A5CBD4DC0512611361485C35", hash_generated_method = "959CFAE99965A1223E523B16EACE8697")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        Expires expires;
        expires = new Expires();
        dbg_enter("parse");
        try 
        {
            lexer.match(TokenTypes.EXPIRES);
            lexer.SPorHT();
            lexer.match(':');
            lexer.SPorHT();
            String nextId;
            nextId = lexer.getNextId();
            lexer.match('\n');
            try 
            {
                int delta;
                delta = Integer.parseInt(nextId);
                expires.setExpires(delta);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException("bad integer format");
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Expires expires = new Expires();
        //if (debug)
            //dbg_enter("parse");
        //try {
            //lexer.match(TokenTypes.EXPIRES);
            //lexer.SPorHT();
            //lexer.match(':');
            //lexer.SPorHT();
            //String nextId = lexer.getNextId();
            //lexer.match('\n');
            //try {
                //int delta = Integer.parseInt(nextId);
                //expires.setExpires(delta);
                //return expires;
            //} catch (NumberFormatException ex) {
                //throw createParseException("bad integer format");
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
}

