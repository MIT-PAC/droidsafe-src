package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDList;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PVisitedNetworkIDParser extends ParametersParser implements TokenTypes {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.247 -0500", hash_original_method = "AAF2C926011534DC0A79DC60EEACAEEC", hash_generated_method = "8517C592DCD5002A943B1B3C71020029")
    public PVisitedNetworkIDParser(String networkID) {
        super(networkID);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.248 -0500", hash_original_method = "356F93257D315AF255B12EF26A2A8CA1", hash_generated_method = "8239A572FA11326C11131B96D5633363")
    protected PVisitedNetworkIDParser(Lexer lexer) {
        super(lexer);

    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.249 -0500", hash_original_method = "622891E063D73C9F0042092134963E28", hash_generated_method = "AD944C0EB913532128AE12D4D4466EE5")
    public SIPHeader parse() throws ParseException {

        PVisitedNetworkIDList visitedNetworkIDList = new PVisitedNetworkIDList();

        if (debug)
            dbg_enter("VisitedNetworkIDParser.parse");

        try {
            this.lexer.match(TokenTypes.P_VISITED_NETWORK_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();

            while (true) {

                PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();

                if (this.lexer.lookAhead(0) == '\"')
                    parseQuotedString(visitedNetworkID);
                else
                    parseToken(visitedNetworkID);

                visitedNetworkIDList.add(visitedNetworkID);

                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if (la == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else if (la == '\n')
                    break;
                else
                    throw createParseException("unexpected char = " + la);
            }
            return visitedNetworkIDList;
        } finally {
            if (debug)
                dbg_leave("VisitedNetworkIDParser.parse");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.251 -0500", hash_original_method = "F9BC064602A2F479DAA3AB501121BB36", hash_generated_method = "98E3D4CBF529DE9E8F8B3B09A64D1A5E")
    protected void parseQuotedString(PVisitedNetworkID visitedNetworkID) throws ParseException {

        if (debug)
            dbg_enter("parseQuotedString");

        try {

            StringBuffer retval = new StringBuffer();

            if (this.lexer.lookAhead(0) != '\"')
                throw createParseException("unexpected char");
            this.lexer.consume(1);

            while (true) {
                char next = this.lexer.getNextChar();
                if (next == '\"') {
                    // Got to the terminating quote.
                    break;
                } else if (next == '\0') {
                    throw new ParseException("unexpected EOL", 1);
                } else if (next == '\\') {
                    retval.append(next);
                    next = this.lexer.getNextChar();
                    retval.append(next);
                } else {
                    retval.append(next);
                }
            }

            visitedNetworkID.setVisitedNetworkID(retval.toString());
            super.parse(visitedNetworkID);



        }finally {
            if (debug)
                dbg_leave("parseQuotedString.parse");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.251 -0500", hash_original_method = "DF631989BD446AE0B628512FDA7DF0A8", hash_generated_method = "3036D8A17968CF71B549B986945DAE0F")
    protected void parseToken(PVisitedNetworkID visitedNetworkID) throws ParseException
    {
        // issued by Miguel Freitas

        lexer.match(TokenTypes.ID);
        Token token = lexer.getNextToken();
        //String value = token.getTokenValue();
        visitedNetworkID.setVisitedNetworkID(token);
        super.parse(visitedNetworkID);

    }

    
}

