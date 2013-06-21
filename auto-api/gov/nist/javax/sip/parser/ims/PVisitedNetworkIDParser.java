package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDList;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class PVisitedNetworkIDParser extends ParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.774 -0400", hash_original_method = "AAF2C926011534DC0A79DC60EEACAEEC", hash_generated_method = "76BA065545F60796EE2D1B342ECFCD4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkIDParser(String networkID) {
        super(networkID);
        dsTaint.addTaint(networkID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.774 -0400", hash_original_method = "356F93257D315AF255B12EF26A2A8CA1", hash_generated_method = "B139E1E81A3908BA86418AF96ABF114E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PVisitedNetworkIDParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.775 -0400", hash_original_method = "622891E063D73C9F0042092134963E28", hash_generated_method = "832202B7B5814F0EBBE27A6BCC477BFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        PVisitedNetworkIDList visitedNetworkIDList;
        visitedNetworkIDList = new PVisitedNetworkIDList();
        dbg_enter("VisitedNetworkIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_VISITED_NETWORK_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                PVisitedNetworkID visitedNetworkID;
                visitedNetworkID = new PVisitedNetworkID();
                {
                    boolean varD54B093B7D58DF0D2D4B6DA11127FB02_632436457 = (this.lexer.lookAhead(0) == '\"');
                    parseQuotedString(visitedNetworkID);
                    parseToken(visitedNetworkID);
                } //End collapsed parenthetic
                visitedNetworkIDList.add(visitedNetworkID);
                this.lexer.SPorHT();
                char la;
                la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char = " + la);
            } //End block
        } //End block
        finally 
        {
            dbg_leave("VisitedNetworkIDParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.775 -0400", hash_original_method = "F9BC064602A2F479DAA3AB501121BB36", hash_generated_method = "51368DC16D4B8687936D67B809BDB97B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseQuotedString(PVisitedNetworkID visitedNetworkID) throws ParseException {
        dsTaint.addTaint(visitedNetworkID.dsTaint);
        dbg_enter("parseQuotedString");
        try 
        {
            StringBuffer retval;
            retval = new StringBuffer();
            {
                boolean varA5BE0E2858CEEB1FE00BA9417CB3D42B_2052822954 = (this.lexer.lookAhead(0) != '\"');
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } //End collapsed parenthetic
            this.lexer.consume(1);
            {
                char next;
                next = this.lexer.getNextChar();
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("unexpected EOL", 1);
                } //End block
                {
                    retval.append(next);
                    next = this.lexer.getNextChar();
                    retval.append(next);
                } //End block
                {
                    retval.append(next);
                } //End block
            } //End block
            visitedNetworkID.setVisitedNetworkID(retval.toString());
            super.parse(visitedNetworkID);
        } //End block
        finally 
        {
            dbg_leave("parseQuotedString.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.775 -0400", hash_original_method = "DF631989BD446AE0B628512FDA7DF0A8", hash_generated_method = "D74DA4417D5712FF1AEB58B7C32FE2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseToken(PVisitedNetworkID visitedNetworkID) throws ParseException {
        dsTaint.addTaint(visitedNetworkID.dsTaint);
        lexer.match(TokenTypes.ID);
        Token token;
        token = lexer.getNextToken();
        visitedNetworkID.setVisitedNetworkID(token);
        super.parse(visitedNetworkID);
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.ID);
        //Token token = lexer.getNextToken();
        //visitedNetworkID.setVisitedNetworkID(token);
        //super.parse(visitedNetworkID);
    }

    
}

