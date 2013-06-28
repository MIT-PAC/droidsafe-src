package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class SessionExpiresParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.053 -0400", hash_original_method = "7C2BC7AE1B8B283C846DFC926BD1514D", hash_generated_method = "545C555B9486493C4D866EE22D7C9C8B")
    public  SessionExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.053 -0400", hash_original_method = "821EB3B546274960D96C2E7F96AD190B", hash_generated_method = "44A1638EF63BA8B620473329084C8EBC")
    protected  SessionExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.053 -0400", hash_original_method = "3CD97DF13D6C3B595D5C8777AA80A144", hash_generated_method = "568E69171809E4C172967FA7B079112E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_580260293 = null; //Variable for return #1
        SessionExpires se = new SessionExpires();
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.SESSIONEXPIRES_TO);
            String nextId = lexer.getNextId();
            try 
            {
                int delta = Integer.parseInt(nextId);
                se.setExpires(delta);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException("bad integer format");
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            super.parse(se);
            varB4EAC82CA7396A68D541C85D26508E83_580260293 = se;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_580260293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_580260293;
        // ---------- Original Method ----------
        //SessionExpires se = new SessionExpires();
        //if (debug)
            //dbg_enter("parse");
        //try {
            //headerName(TokenTypes.SESSIONEXPIRES_TO);
            //String nextId = lexer.getNextId();
            //try {
                //int delta = Integer.parseInt(nextId);
                //se.setExpires(delta);
            //} catch (NumberFormatException ex) {
                //throw createParseException("bad integer format");
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //super.parse(se);
            //return se;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
    public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Session-Expires: 30\n",
                "Session-Expires: 45;refresher=uac\n",
            };
        for (int i = 0; i < to.length; i++) {
            SessionExpiresParser tp = new SessionExpiresParser(to[i]);
            SessionExpires t = (SessionExpires) tp.parse();
            System.out.println("encoded = " + t.encode());
            System.out.println("\ntime=" + t.getExpires() );
            if ( t.getParameter("refresher") != null)
                System.out.println("refresher=" + t.getParameter("refresher") );
        }
    }

    
}

