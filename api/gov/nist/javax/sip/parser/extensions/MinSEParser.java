package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class MinSEParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.734 -0400", hash_original_method = "4E326F54C0BC2C416F3292ADC3B64C39", hash_generated_method = "2A074247CD48DBE45FB5E6C0EEF6E56E")
    public  MinSEParser(String text) {
        super(text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.735 -0400", hash_original_method = "B8B8CA8DFA565E816EE248A435214726", hash_generated_method = "C6A16FD6432DA865B85A7B65721542F7")
    protected  MinSEParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.754 -0400", hash_original_method = "528678E8CA90A52E25DB45830845A36C", hash_generated_method = "CEA5F129CA828EF26F6AC3876C928EB6")
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
            } //End block
            catch (NumberFormatException ex)
            {
                java.text.ParseException var5FB99FE9B64E519E79EC6426B25925EC_1316769831 = createParseException("bad integer format");
                var5FB99FE9B64E519E79EC6426B25925EC_1316769831.addTaint(taint);
                throw var5FB99FE9B64E519E79EC6426B25925EC_1316769831;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_916870105 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_916870105.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_916870105;
            } //End block
            this.lexer.SPorHT();
            super.parse(minse);
SIPHeader varF3CC1D7F771FF7BA71AED1439CF6D47D_158728804 =             minse;
            varF3CC1D7F771FF7BA71AED1439CF6D47D_158728804.addTaint(taint);
            return varF3CC1D7F771FF7BA71AED1439CF6D47D_158728804;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        //MinSE minse = new MinSE();
        //if (debug)
            //dbg_enter("parse");
        //try {
            //headerName(TokenTypes.MINSE_TO);
            //String nextId = lexer.getNextId();
            //try {
                //int delta = Integer.parseInt(nextId);
                //minse.setExpires(delta);
            //} catch (NumberFormatException ex) {
                //throw createParseException("bad integer format");
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //super.parse(minse);
            //return minse;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
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

