package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.170 -0400", hash_original_method = "AAF2C926011534DC0A79DC60EEACAEEC", hash_generated_method = "DD49613DCF41DC1C22E1DA8263CFB424")
    public  PVisitedNetworkIDParser(String networkID) {
        super(networkID);
        addTaint(networkID.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.170 -0400", hash_original_method = "356F93257D315AF255B12EF26A2A8CA1", hash_generated_method = "0D06CF469DC6F521E5DF659757FCDE0F")
    protected  PVisitedNetworkIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.171 -0400", hash_original_method = "622891E063D73C9F0042092134963E28", hash_generated_method = "0F2B675DFD05AC660F2D4DF908E2BD71")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_206668041 = null; 
        PVisitedNetworkIDList visitedNetworkIDList = new PVisitedNetworkIDList();
        dbg_enter("VisitedNetworkIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_VISITED_NETWORK_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
                {
                    boolean varD54B093B7D58DF0D2D4B6DA11127FB02_922800664 = (this.lexer.lookAhead(0) == '\"');
                    parseQuotedString(visitedNetworkID);
                    parseToken(visitedNetworkID);
                } 
                visitedNetworkIDList.add(visitedNetworkID);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } 
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char = " + la);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_206668041 = visitedNetworkIDList;
        } 
        finally 
        {
            dbg_leave("VisitedNetworkIDParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_206668041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_206668041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.172 -0400", hash_original_method = "F9BC064602A2F479DAA3AB501121BB36", hash_generated_method = "C1B63F98D6D8684922C1F28D87BC6FAE")
    protected void parseQuotedString(PVisitedNetworkID visitedNetworkID) throws ParseException {
        dbg_enter("parseQuotedString");
        try 
        {
            StringBuffer retval = new StringBuffer();
            {
                boolean varA5BE0E2858CEEB1FE00BA9417CB3D42B_491226426 = (this.lexer.lookAhead(0) != '\"');
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } 
            this.lexer.consume(1);
            {
                char next = this.lexer.getNextChar();
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("unexpected EOL", 1);
                } 
                {
                    retval.append(next);
                    next = this.lexer.getNextChar();
                    retval.append(next);
                } 
                {
                    retval.append(next);
                } 
            } 
            visitedNetworkID.setVisitedNetworkID(retval.toString());
            super.parse(visitedNetworkID);
        } 
        finally 
        {
            dbg_leave("parseQuotedString.parse");
        } 
        addTaint(visitedNetworkID.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.173 -0400", hash_original_method = "DF631989BD446AE0B628512FDA7DF0A8", hash_generated_method = "7720BAB35DF4C9355F8D29A3BCD987CF")
    protected void parseToken(PVisitedNetworkID visitedNetworkID) throws ParseException {
        lexer.match(TokenTypes.ID);
        Token token = lexer.getNextToken();
        visitedNetworkID.setVisitedNetworkID(token);
        super.parse(visitedNetworkID);
        addTaint(visitedNetworkID.getTaint());
        
        
        
        
        
    }

    
}

