package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.SessionExpires;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;



public class SessionExpiresParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.824 -0400", hash_original_method = "7C2BC7AE1B8B283C846DFC926BD1514D", hash_generated_method = "545C555B9486493C4D866EE22D7C9C8B")
    public  SessionExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.824 -0400", hash_original_method = "821EB3B546274960D96C2E7F96AD190B", hash_generated_method = "44A1638EF63BA8B620473329084C8EBC")
    protected  SessionExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.847 -0400", hash_original_method = "3CD97DF13D6C3B595D5C8777AA80A144", hash_generated_method = "807FEFDFE3B679A1CB8C4CFD54507224")
    public SIPHeader parse() throws ParseException {
        SessionExpires se = new SessionExpires();
        if(debug)        
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
                java.text.ParseException var5FB99FE9B64E519E79EC6426B25925EC_765794338 = createParseException("bad integer format");
                var5FB99FE9B64E519E79EC6426B25925EC_765794338.addTaint(taint);
                throw var5FB99FE9B64E519E79EC6426B25925EC_765794338;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1745141763 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1745141763.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1745141763;
            } //End block
            this.lexer.SPorHT();
            super.parse(se);
SIPHeader var0C8032DAF099798148753EFEC46D980B_345849325 =             se;
            var0C8032DAF099798148753EFEC46D980B_345849325.addTaint(taint);
            return var0C8032DAF099798148753EFEC46D980B_345849325;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
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

