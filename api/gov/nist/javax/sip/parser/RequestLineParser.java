package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.RequestLine;

import java.text.ParseException;





public class RequestLineParser extends Parser {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.469 -0500", hash_original_method = "81D449396CA92A7AD8E004264E406593", hash_generated_method = "DBBA46FA2C859B3EF3FBE0D60D8B4D68")
    
public static void main(String args[]) throws ParseException {
            String requestLines[] = {
                "REGISTER sip:192.168.0.68 SIP/2.0\n",
                "REGISTER sip:company.com SIP/2.0\n",
                "INVITE sip:3660@166.35.231.140 SIP/2.0\n",
                "INVITE sip:user@company.com SIP/2.0\n",
                "REGISTER sip:[2001::1]:5060;transport=tcp SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[2002:800:700:600:30:4:6:1]:5060;transport=udp SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[3ffe:800:700::30:4:6:1]:5060;transport=tls SIP/2.0\n", // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
                "REGISTER sip:[2001:720:1710:0:201:29ff:fe21:f403]:5060;transport=udp SIP/2.0\n",
                "OPTIONS sip:135.180.130.133 SIP/2.0\n" };
            for (int i = 0; i < requestLines.length; i++ ) {
                RequestLineParser rlp =
                  new RequestLineParser(requestLines[i]);
                RequestLine rl = rlp.parse();
                System.out.println("encoded = " + rl.encode());
            }

        }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.461 -0500", hash_original_method = "9E54F2AF74A618ACEB8F17B65C16A48F", hash_generated_method = "2EF319665DA089D9F7AB53A9E02C67CA")
    
public RequestLineParser(String requestLine) {
        this.lexer = new Lexer("method_keywordLexer", requestLine);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.463 -0500", hash_original_method = "A6666834E60C7B51DE2E6BABDAF9B193", hash_generated_method = "D233B63A45EDFB95DFD732BE908C3EB5")
    
public RequestLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("method_keywordLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.466 -0500", hash_original_method = "3F5CD164E270AAF338C0D4B97DF78E19", hash_generated_method = "B3DA0F50F698C533CAC7A4174C2C4620")
    
public RequestLine parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
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
            return retval;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

