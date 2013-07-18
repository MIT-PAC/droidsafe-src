package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Accept;
import gov.nist.javax.sip.header.AcceptList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AcceptParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.743 -0400", hash_original_method = "E50D6CA61897C534ECF6BFE2E6C66EEB", hash_generated_method = "47E74533E30A5580A43C253EA52B779A")
    public  AcceptParser(String accept) {
        super(accept);
        addTaint(accept.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.744 -0400", hash_original_method = "B0740C746A8D55CA7E1BAB3B373D9F3B", hash_generated_method = "CFD5C41C299FA64BEF69A6D9AEDB1EB1")
    protected  AcceptParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.746 -0400", hash_original_method = "4B990F83EF66D5D2EAA453ED852E8DC7", hash_generated_method = "C78778BCD730BF0A20D4E231F4863A2A")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AcceptParser.parse");
        AcceptList list = new AcceptList();
        try 
        {
            headerName(TokenTypes.ACCEPT);
            Accept accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accept.setContentType(token.getTokenValue());
            this.lexer.match('/');
            this.lexer.match(TokenTypes.ID);
            token = lexer.getNextToken();
            accept.setContentSubType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(accept);
            list.add(accept);
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                accept = new Accept();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentType(token.getTokenValue());
                this.lexer.match('/');
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentSubType(token.getTokenValue());
                this.lexer.SPorHT();
                super.parse(accept);
                list.add(accept);
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_370106463 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_370106463.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_370106463;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AcceptParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

