package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;





public class AddressParser extends Parser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.203 -0500", hash_original_method = "DDF0B6D19753B0F457279892E29569BE", hash_generated_method = "438ED40881F1D015EA63BEE9986FED07")
    public AddressParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("charLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.204 -0500", hash_original_method = "8E6C25B6D8313F3B657F98EEF90351BF", hash_generated_method = "E237B9B2DD37CCD3FF8ACD8455EFCC59")
    public AddressParser(String address) {
        this.lexer = new Lexer("charLexer", address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.205 -0500", hash_original_method = "FFACB1FB21E7531199E63E4BDFD4B5B1", hash_generated_method = "9DE2C0DBF104708B50E4C9823F465F9F")
    protected AddressImpl nameAddr() throws ParseException {
        if (debug)
            dbg_enter("nameAddr");
        try {
            if (this.lexer.lookAhead(0) == '<') {
                this.lexer.consume(1);
                this.lexer.selectLexer("sip_urlLexer");
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                retval.setAddressType(AddressImpl.NAME_ADDR);
                retval.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
                return retval;
            } else {
                AddressImpl addr = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                String name = null;
                if (this.lexer.lookAhead(0) == '\"') {
                    name = this.lexer.quotedString();
                    this.lexer.SPorHT();
                } else
                    name = this.lexer.getNextToken('<');
                addr.setDisplayName(name.trim());
                this.lexer.match('<');
                this.lexer.SPorHT();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( true );
                AddressImpl retval = new AddressImpl();
                addr.setAddressType(AddressImpl.NAME_ADDR);
                addr.setURI(uri);
                this.lexer.SPorHT();
                this.lexer.match('>');
                return addr;
            }
        } finally {
            if (debug)
                dbg_leave("nameAddr");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.206 -0500", hash_original_method = "54D730AA0CABE4752468E1C28394616F", hash_generated_method = "EA4E294D1FF4943145F6E701E5452666")
    public AddressImpl address( boolean inclParams ) throws ParseException {
        if (debug)
            dbg_enter("address");
        AddressImpl retval = null;
        try {
            int k = 0;
            while (lexer.hasMoreChars()) {
                char la = lexer.lookAhead(k);
                if (la == '<'
                    || la == '\"'
                    || la == ':'
                    || la == '/')
                    break;
                else if (la == '\0')
                    throw createParseException("unexpected EOL");
                else
                    k++;
            }
            char la = lexer.lookAhead(k);
            if (la == '<' || la == '\"') {
                retval = nameAddr();
            } else if (la == ':' || la == '/') {
                retval = new AddressImpl();
                URLParser uriParser = new URLParser((Lexer) lexer);
                GenericURI uri = uriParser.uriReference( inclParams );
                retval.setAddressType(AddressImpl.ADDRESS_SPEC);
                retval.setURI(uri);
            } else {
                throw createParseException("Bad address spec");
            }
            return retval;
        } finally {
            if (debug)
                dbg_leave("address");
        }

    }

    
}

