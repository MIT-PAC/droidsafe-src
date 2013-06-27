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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.747 -0400", hash_original_method = "A7328899640752C7683A3AAB5686C434", hash_generated_method = "91AD4A144E3219744EF95FFB87DA18A5")
    public  ExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.748 -0400", hash_original_method = "8C0F40C2F214AF533DDC04CFAC4ADA24", hash_generated_method = "01CE2D3D2FDBF84082EF3A8A9C12D81D")
    protected  ExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.757 -0400", hash_original_method = "BF637AC6A5CBD4DC0512611361485C35", hash_generated_method = "8B7A2D40A220D0ED0F13E4C1AE0FCE93")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_946653072 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_946653072 = expires;
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
        varB4EAC82CA7396A68D541C85D26508E83_946653072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946653072;
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

