package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.982 -0400", hash_original_method = "AAF2C926011534DC0A79DC60EEACAEEC", hash_generated_method = "DD49613DCF41DC1C22E1DA8263CFB424")
    public  PVisitedNetworkIDParser(String networkID) {
        super(networkID);
        addTaint(networkID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.983 -0400", hash_original_method = "356F93257D315AF255B12EF26A2A8CA1", hash_generated_method = "0D06CF469DC6F521E5DF659757FCDE0F")
    protected  PVisitedNetworkIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.012 -0400", hash_original_method = "622891E063D73C9F0042092134963E28", hash_generated_method = "C58DE856E5DBB409858A66F3F2FE44E1")
    public SIPHeader parse() throws ParseException {
        PVisitedNetworkIDList visitedNetworkIDList = new PVisitedNetworkIDList();
        if(debug)        
        dbg_enter("VisitedNetworkIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_VISITED_NETWORK_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
                if(this.lexer.lookAhead(0) == '\"')                
                parseQuotedString(visitedNetworkID);
                else
                parseToken(visitedNetworkID);
                visitedNetworkIDList.add(visitedNetworkID);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if(la == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                else
                if(la == '\n')                
                break;
                else
                {
                java.text.ParseException varEDAD4F165A77947E764D959330B42690_153925385 = createParseException("unexpected char = " + la);
                varEDAD4F165A77947E764D959330B42690_153925385.addTaint(taint);
                throw varEDAD4F165A77947E764D959330B42690_153925385;
                }
            } //End block
SIPHeader varBC7EEB21C758F2C49F34FDE84F1EE5BB_1646940601 =             visitedNetworkIDList;
            varBC7EEB21C758F2C49F34FDE84F1EE5BB_1646940601.addTaint(taint);
            return varBC7EEB21C758F2C49F34FDE84F1EE5BB_1646940601;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("VisitedNetworkIDParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.036 -0400", hash_original_method = "F9BC064602A2F479DAA3AB501121BB36", hash_generated_method = "BEFF0D89F149951F0F7F8DEB881C7B55")
    protected void parseQuotedString(PVisitedNetworkID visitedNetworkID) throws ParseException {
        addTaint(visitedNetworkID.getTaint());
        if(debug)        
        dbg_enter("parseQuotedString");
        try 
        {
            StringBuffer retval = new StringBuffer();
            if(this.lexer.lookAhead(0) != '\"')            
            {
            java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_2130083025 = createParseException("unexpected char");
            var7805DD1445672D84C07E56FCC19D9765_2130083025.addTaint(taint);
            throw var7805DD1445672D84C07E56FCC19D9765_2130083025;
            }
            this.lexer.consume(1);
            while
(true)            
            {
                char next = this.lexer.getNextChar();
                if(next == '\"')                
                {
                    break;
                } //End block
                else
                if(next == '\0')                
                {
                    ParseException var27CA867AF3062F3C529DF2355F291430_1962720692 = new ParseException("unexpected EOL", 1);
                    var27CA867AF3062F3C529DF2355F291430_1962720692.addTaint(taint);
                    throw var27CA867AF3062F3C529DF2355F291430_1962720692;
                } //End block
                else
                if(next == '\\')                
                {
                    retval.append(next);
                    next = this.lexer.getNextChar();
                    retval.append(next);
                } //End block
                else
                {
                    retval.append(next);
                } //End block
            } //End block
            visitedNetworkID.setVisitedNetworkID(retval.toString());
            super.parse(visitedNetworkID);
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parseQuotedString.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.038 -0400", hash_original_method = "DF631989BD446AE0B628512FDA7DF0A8", hash_generated_method = "DBB4D028A55367AB7AE247C99A9DB99C")
    protected void parseToken(PVisitedNetworkID visitedNetworkID) throws ParseException {
        addTaint(visitedNetworkID.getTaint());
        lexer.match(TokenTypes.ID);
        Token token = lexer.getNextToken();
        visitedNetworkID.setVisitedNetworkID(token);
        super.parse(visitedNetworkID);
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.ID);
        //Token token = lexer.getNextToken();
        //visitedNetworkID.setVisitedNetworkID(token);
        //super.parse(visitedNetworkID);
    }

    
}

