package gov.nist.javax.sip.parser.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class MinSEParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.727 -0400", hash_original_method = "4E326F54C0BC2C416F3292ADC3B64C39", hash_generated_method = "2A074247CD48DBE45FB5E6C0EEF6E56E")
    public  MinSEParser(String text) {
        super(text);
        addTaint(text.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.730 -0400", hash_original_method = "B8B8CA8DFA565E816EE248A435214726", hash_generated_method = "C6A16FD6432DA865B85A7B65721542F7")
    protected  MinSEParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.766 -0400", hash_original_method = "528678E8CA90A52E25DB45830845A36C", hash_generated_method = "9187F4832D1994FFD82AD0EAE7BA3384")
    public SIPHeader parse() throws ParseException {
        MinSE minse = new MinSE();
    if(debug)        
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.MINSE_TO);
            String nextId = lexer.getNextId();
            try 
            {
                int delta = Integer.parseInt(nextId);
                minse.setExpires(delta);
            } 
            catch (NumberFormatException ex)
            {
                java.text.ParseException var5FB99FE9B64E519E79EC6426B25925EC_196574685 = createParseException("bad integer format");
                var5FB99FE9B64E519E79EC6426B25925EC_196574685.addTaint(taint);
                throw var5FB99FE9B64E519E79EC6426B25925EC_196574685;
            } 
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1541787794 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1541787794.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1541787794;
            } 
            this.lexer.SPorHT();
            super.parse(minse);
SIPHeader varF3CC1D7F771FF7BA71AED1439CF6D47D_1671047371 =             minse;
            varF3CC1D7F771FF7BA71AED1439CF6D47D_1671047371.addTaint(taint);
            return varF3CC1D7F771FF7BA71AED1439CF6D47D_1671047371;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("parse");
        } 
        
        
        
            
        
            
            
            
                
                
            
                
            
                
            
            
            
            
        
            
                
        
    }

    
        public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Min-SE: 30\n",
                "Min-SE: 45;some-param=somevalue\n",
            };
        for (int i = 0; i < to.length; i++) {
            MinSEParser tp = new MinSEParser(to[i]);
            MinSE t = (MinSE) tp.parse();
            System.out.println("encoded = " + t.encode());
            System.out.println("\ntime=" + t.getExpires() );
            if ( t.getParameter("some-param") != null)
                System.out.println("some-param=" + t.getParameter("some-param") );
        }
    }

    
}

