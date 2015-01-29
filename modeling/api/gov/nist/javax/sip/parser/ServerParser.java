package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.Server;

import java.text.ParseException;





public class ServerParser extends HeaderParser {

    /**
     * Creates a new instance of ServerParser
     * @param server the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.413 -0500", hash_original_method = "34ED7286D2A920D6CAAB19B69F1E2272", hash_generated_method = "A3A9DCA8F9A15F41B8A594761AC6AC9B")
    
public ServerParser(String server) {
        super(server);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.416 -0500", hash_original_method = "D6FF2C5B569C35FFD38E06BDFF6C27A4", hash_generated_method = "534724306C9EF4ABB5A0DE79B21507A8")
    
protected ServerParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String server
     * @return SIPHeader (Server object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.419 -0500", hash_original_method = "F7C094FE7E8356B9E6B34E820636D434", hash_generated_method = "127D5A8E6D4BFFA2632A9B26A95B3888")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ServerParser.parse");
        Server server = new Server();
        try {
            headerName(TokenTypes.SERVER);
            if (this.lexer.lookAhead(0) == '\n')
                throw createParseException("empty header");

            //  mandatory token: product[/product-version] | (comment)
            while (this.lexer.lookAhead(0) != '\n'
                && this.lexer.lookAhead(0) != '\0') {
                if (this.lexer.lookAhead(0) == '(') {
                    String comment = this.lexer.comment();
                    server.addProductToken('(' + comment + ')');
                } else {
                    String tok;
                    int marker = 0;
                    try {
                        marker = this.lexer.markInputPosition();
                        tok = this.lexer.getString('/');

                        if (tok.charAt(tok.length() - 1) == '\n')
                            tok = tok.trim();
                        server.addProductToken(tok);
                    } catch (ParseException ex) {
                        this.lexer.rewindInputPosition(marker);
                        tok = this.lexer.getRest().trim();
                        server.addProductToken(tok);
                        break;
                    }
                }
            }

        } finally {
            if (debug)
                dbg_leave("ServerParser.parse");
        }

        return server;
    }

    
}

