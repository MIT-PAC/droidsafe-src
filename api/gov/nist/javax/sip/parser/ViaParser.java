package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostNameParser;
import gov.nist.core.HostPort;
import gov.nist.core.LexerCore;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Protocol;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;

import java.text.ParseException;





public class ViaParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.587 -0500", hash_original_method = "0CA9F50F0D44148E6CD64450736B4031", hash_generated_method = "1F132816A00B46E58B7BC1EC0DFF40DB")
    
public ViaParser(String via) {
        super(via);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.589 -0500", hash_original_method = "16747522FA7D80CA65EEE675350A9BF1", hash_generated_method = "76369E9A9B876D6F6852BF5392BEB475")
    
public ViaParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * a parser for the essential part of the via header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.594 -0500", hash_original_method = "2208496A4921623C92FF093043E5D238", hash_generated_method = "6C971D18B78C1160D112611D2C69AEEE")
    
private void parseVia(Via v) throws ParseException {
        // The protocol
        lexer.match(TokenTypes.ID);
        Token protocolName = lexer.getNextToken();

        this.lexer.SPorHT();
        // consume the "/"
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();
        Token protocolVersion = lexer.getNextToken();

        this.lexer.SPorHT();

        // We consume the "/"
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();

        Token transport = lexer.getNextToken();
        this.lexer.SPorHT();

        Protocol protocol = new Protocol();
        protocol.setProtocolName(protocolName.getTokenValue());
        protocol.setProtocolVersion(protocolVersion.getTokenValue());
        protocol.setTransport(transport.getTokenValue());
        v.setSentProtocol(protocol);

        // sent-By
        HostNameParser hnp = new HostNameParser(this.getLexer());
        HostPort hostPort = hnp.hostPort( true );
        v.setSentBy(hostPort);

        // Ignore blanks
        this.lexer.SPorHT();

        // parameters
        while (lexer.lookAhead(0) == ';') {
            this.lexer.consume(1);
            this.lexer.SPorHT();
            NameValue nameValue = this.nameValue();
            String name = nameValue.getName();
            if (name.equals(Via.BRANCH)) {
                String branchId = (String) nameValue.getValueAsObject();
                if (branchId == null)
                    throw new ParseException("null branch Id", lexer.getPtr());

            }
            v.setParameter(nameValue);
            this.lexer.SPorHT();
        }

        //
        // JvB Note: RFC3261 does not allow a comment in Via headers anymore
        //
        if (lexer.lookAhead(0) == '(') {
            this.lexer.selectLexer("charLexer");
            lexer.consume(1);
            StringBuffer comment = new StringBuffer();
            while (true) {
                char ch = lexer.lookAhead(0);
                if (ch == ')') {
                    lexer.consume(1);
                    break;
                } else if (ch == '\\') {
                    // Escaped character
                    Token tok = lexer.getNextToken();
                    comment.append(tok.getTokenValue());
                    lexer.consume(1);
                    tok = lexer.getNextToken();
                    comment.append(tok.getTokenValue());
                    lexer.consume(1);
                } else if (ch == '\n') {
                    break;
                } else {
                    comment.append(ch);
                    lexer.consume(1);
                }
            }
            v.setComment(comment.toString());
        }

    }

    /**
     * Overrides the superclass nameValue parser because we have to tolerate
     * IPV6 addresses in the received parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.597 -0500", hash_original_method = "5AA78E39B6EC64AD2F4CBC59769995CB", hash_generated_method = "CB3CC522C26BFEA09961AD4D142B51A3")
    
protected NameValue nameValue() throws ParseException {
        if (debug)
            dbg_enter("nameValue");
        try {

            lexer.match(LexerCore.ID);
            Token name = lexer.getNextToken();
            // eat white space.
            lexer.SPorHT();
            try {

                boolean quoted = false;

                char la = lexer.lookAhead(0);

                if (la == '=') {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str = null;
                    if (name.getTokenValue().compareToIgnoreCase(Via.RECEIVED) == 0) {
                        // Allow for IPV6 Addresses.
                        // these could have : in them!
                        str = lexer.byteStringNoSemicolon();
                    } else {
                        if (lexer.lookAhead(0) == '\"') {
                            str = lexer.quotedString();
                            quoted = true;
                        } else {
                            lexer.match(LexerCore.ID);
                            Token value = lexer.getNextToken();
                            str = value.getTokenValue();
                        }
                    }
                    NameValue nv = new NameValue(name.getTokenValue()
                            .toLowerCase(), str);
                    if (quoted)
                        nv.setQuotedValue();
                    return nv;
                } else {
                    return new NameValue(name.getTokenValue().toLowerCase(),
                            null);
                }
            } catch (ParseException ex) {
                return new NameValue(name.getTokenValue(), null);
            }

        } finally {
            if (debug)
                dbg_leave("nameValue");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.601 -0500", hash_original_method = "2B03679359A52BF0E5FCCEF061A24457", hash_generated_method = "55A478D3076709D8EA03DFE2374A0C93")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            ViaList viaList = new ViaList();
            // The first via header.
            this.lexer.match(TokenTypes.VIA);
            this.lexer.SPorHT(); // ignore blanks
            this.lexer.match(':'); // expect a colon.
            this.lexer.SPorHT(); // ingore blanks.

            while (true) {
                Via v = new Via();
                parseVia(v);
                viaList.add(v);
                this.lexer.SPorHT(); // eat whitespace.
                if (this.lexer.lookAhead(0) == ',') {
                    this.lexer.consume(1); // Consume the comma
                    this.lexer.SPorHT(); // Ignore space after.
                }
                if (this.lexer.lookAhead(0) == '\n')
                    break;
            }
            this.lexer.match('\n');
            return viaList;
        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

