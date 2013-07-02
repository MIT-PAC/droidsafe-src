package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class RequestLineParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.492 -0400", hash_original_method = "9E54F2AF74A618ACEB8F17B65C16A48F", hash_generated_method = "ECC9D14D924F666200406F406E44BA1E")
    public  RequestLineParser(String requestLine) {
        this.lexer = new Lexer("method_keywordLexer", requestLine);
        addTaint(requestLine.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.493 -0400", hash_original_method = "A6666834E60C7B51DE2E6BABDAF9B193", hash_generated_method = "11B589A13EED926FDBCAB426A03A5F5F")
    public  RequestLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("method_keywordLexer");
        addTaint(lexer.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.494 -0400", hash_original_method = "3F5CD164E270AAF338C0D4B97DF78E19", hash_generated_method = "515B8D488E98767FFAD2B70072B6F7C5")
    public RequestLine parse() throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1440136424 = null; 
        dbg_enter("parse");
        try 
        {
            RequestLine retval = new RequestLine();
            String m = method();
            lexer.SPorHT();
            retval.setMethod(m);
            this.lexer.selectLexer("sip_urlLexer");
            URLParser urlParser = new URLParser(this.getLexer());
            GenericURI url = urlParser.uriReference(true);
            lexer.SPorHT();
            retval.setUri(url);
            this.lexer.selectLexer("request_lineLexer");
            String v = sipVersion();
            retval.setSipVersion(v);
            lexer.SPorHT();
            lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1440136424 = retval;
        } 
        finally 
        {
            dbg_leave("parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1440136424.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1440136424;
        
        
            
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void main(String args[]) throws ParseException {
        String requestLines[] = {
                "REGISTER sip:192.168.0.68 SIP/2.0\n",
                "REGISTER sip:company.com SIP/2.0\n",
                "INVITE sip:3660@166.35.231.140 SIP/2.0\n",
                "INVITE sip:user@company.com SIP/2.0\n",
                "REGISTER sip:[2001::1]:5060;transport=tcp SIP/2.0\n", 
                "REGISTER sip:[2002:800:700:600:30:4:6:1]:5060;transport=udp SIP/2.0\n", 
                "REGISTER sip:[3ffe:800:700::30:4:6:1]:5060;transport=tls SIP/2.0\n", 
                "REGISTER sip:[2001:720:1710:0:201:29ff:fe21:f403]:5060;transport=udp SIP/2.0\n",
                "OPTIONS sip:135.180.130.133 SIP/2.0\n" };
        for (int i = 0; i < requestLines.length; i++ ) {
                RequestLineParser rlp =
                  new RequestLineParser(requestLines[i]);
                RequestLine rl = rlp.parse();
                System.out.println("encoded = " + rl.encode());
            }
    }

    
}

