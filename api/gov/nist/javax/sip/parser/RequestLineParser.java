package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class RequestLineParser extends Parser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.546 -0400", hash_original_method = "9E54F2AF74A618ACEB8F17B65C16A48F", hash_generated_method = "FB8FE551FA5D181ADCB5FE9C481BD6ED")
    public  RequestLineParser(String requestLine) {
        addTaint(requestLine.getTaint());
        this.lexer = new Lexer("method_keywordLexer", requestLine);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("method_keywordLexer", requestLine);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.547 -0400", hash_original_method = "A6666834E60C7B51DE2E6BABDAF9B193", hash_generated_method = "219D76BC983E87B19D174293804330B6")
    public  RequestLineParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("method_keywordLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("method_keywordLexer");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.549 -0400", hash_original_method = "3F5CD164E270AAF338C0D4B97DF78E19", hash_generated_method = "1499F00D9A76D57C02C0C877E606EC26")
    public RequestLine parse() throws ParseException {
        if(debug)        
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
RequestLine varF9E19AD6135C970F387F77C6F3DE4477_1840565442 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1840565442.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1840565442;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("parse");
        //try {
            //RequestLine retval = new RequestLine();
            //String m = method();
            //lexer.SPorHT();
            //retval.setMethod(m);
            //this.lexer.selectLexer("sip_urlLexer");
            //URLParser urlParser = new URLParser(this.getLexer());
            //GenericURI url = urlParser.uriReference(true);
            //lexer.SPorHT();
            //retval.setUri(url);
            //this.lexer.selectLexer("request_lineLexer");
            //String v = sipVersion();
            //retval.setSipVersion(v);
            //lexer.SPorHT();
            //lexer.match('\n');
            //return retval;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
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

