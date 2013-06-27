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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.710 -0400", hash_original_method = "AAF2C926011534DC0A79DC60EEACAEEC", hash_generated_method = "DD49613DCF41DC1C22E1DA8263CFB424")
    public  PVisitedNetworkIDParser(String networkID) {
        super(networkID);
        addTaint(networkID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.710 -0400", hash_original_method = "356F93257D315AF255B12EF26A2A8CA1", hash_generated_method = "0D06CF469DC6F521E5DF659757FCDE0F")
    protected  PVisitedNetworkIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.711 -0400", hash_original_method = "622891E063D73C9F0042092134963E28", hash_generated_method = "9E77232B6FDB48F65D50AC0481A10DFB")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_292080699 = null; //Variable for return #1
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
                    boolean varD54B093B7D58DF0D2D4B6DA11127FB02_196143688 = (this.lexer.lookAhead(0) == '\"');
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
            varB4EAC82CA7396A68D541C85D26508E83_292080699 = visitedNetworkIDList;
        } //End block
        finally 
        {
            dbg_leave("VisitedNetworkIDParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_292080699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292080699;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.712 -0400", hash_original_method = "F9BC064602A2F479DAA3AB501121BB36", hash_generated_method = "7D315FD5A672A82486B49CDB63BAD8E6")
    protected void parseQuotedString(PVisitedNetworkID visitedNetworkID) throws ParseException {
        dbg_enter("parseQuotedString");
        try 
        {
            StringBuffer retval;
            retval = new StringBuffer();
            {
                boolean varA5BE0E2858CEEB1FE00BA9417CB3D42B_144688601 = (this.lexer.lookAhead(0) != '\"');
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
        addTaint(visitedNetworkID.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.713 -0400", hash_original_method = "DF631989BD446AE0B628512FDA7DF0A8", hash_generated_method = "689E3BA7AAEE1B6700FE5E06D601AC75")
    protected void parseToken(PVisitedNetworkID visitedNetworkID) throws ParseException {
        lexer.match(TokenTypes.ID);
        Token token;
        token = lexer.getNextToken();
        visitedNetworkID.setVisitedNetworkID(token);
        super.parse(visitedNetworkID);
        addTaint(visitedNetworkID.getTaint());
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.ID);
        //Token token = lexer.getNextToken();
        //visitedNetworkID.setVisitedNetworkID(token);
        //super.parse(visitedNetworkID);
    }

    
}

