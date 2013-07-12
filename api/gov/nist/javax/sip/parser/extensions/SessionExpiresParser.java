package gov.nist.javax.sip.parser.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class SessionExpiresParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.992 -0400", hash_original_method = "7C2BC7AE1B8B283C846DFC926BD1514D", hash_generated_method = "545C555B9486493C4D866EE22D7C9C8B")
    public  SessionExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.000 -0400", hash_original_method = "821EB3B546274960D96C2E7F96AD190B", hash_generated_method = "44A1638EF63BA8B620473329084C8EBC")
    protected  SessionExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.021 -0400", hash_original_method = "3CD97DF13D6C3B595D5C8777AA80A144", hash_generated_method = "CAE6AC65FEA20E3C22FDB55BAE879CB6")
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
            } 
            catch (NumberFormatException ex)
            {
                java.text.ParseException var5FB99FE9B64E519E79EC6426B25925EC_1650049449 = createParseException("bad integer format");
                var5FB99FE9B64E519E79EC6426B25925EC_1650049449.addTaint(taint);
                throw var5FB99FE9B64E519E79EC6426B25925EC_1650049449;
            } 
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_499621846 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_499621846.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_499621846;
            } 
            this.lexer.SPorHT();
            super.parse(se);
SIPHeader var0C8032DAF099798148753EFEC46D980B_239403035 =             se;
            var0C8032DAF099798148753EFEC46D980B_239403035.addTaint(taint);
            return var0C8032DAF099798148753EFEC46D980B_239403035;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("parse");
        } 
        
        
        
            
        
            
            
            
                
                
            
                
            
                
            
            
            
            
        
            
                
        
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

