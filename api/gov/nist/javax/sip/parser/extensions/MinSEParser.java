package gov.nist.javax.sip.parser.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class MinSEParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.011 -0400", hash_original_method = "4E326F54C0BC2C416F3292ADC3B64C39", hash_generated_method = "2A074247CD48DBE45FB5E6C0EEF6E56E")
    public  MinSEParser(String text) {
        super(text);
        addTaint(text.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.011 -0400", hash_original_method = "B8B8CA8DFA565E816EE248A435214726", hash_generated_method = "C6A16FD6432DA865B85A7B65721542F7")
    protected  MinSEParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.011 -0400", hash_original_method = "528678E8CA90A52E25DB45830845A36C", hash_generated_method = "D4730D92823315985117411470A6FEB8")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_811158541 = null; 
        MinSE minse = new MinSE();
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
                if (DroidSafeAndroidRuntime.control) throw createParseException("bad integer format");
            } 
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } 
            this.lexer.SPorHT();
            super.parse(minse);
            varB4EAC82CA7396A68D541C85D26508E83_811158541 = minse;
        } 
        finally 
        {
            dbg_leave("parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_811158541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_811158541;
        
        
        
            
        
            
            
            
                
                
            
                
            
                
            
            
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
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

