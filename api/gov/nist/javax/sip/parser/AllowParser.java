package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Allow;
import gov.nist.javax.sip.header.AllowList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AllowParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.865 -0400", hash_original_method = "A24A575FAE973D160C4E5E7D0F1284A3", hash_generated_method = "B5D028234EA72E3459767A406114950D")
    public  AllowParser(String allow) {
        super(allow);
        addTaint(allow.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.866 -0400", hash_original_method = "A8034B0A3FEDB25038322A25EEE239D9", hash_generated_method = "3FAC5FFB098D2FF0D0FAAFD1280D611A")
    protected  AllowParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.867 -0400", hash_original_method = "EEEC9A9B7336175FA90CC43255548EC9", hash_generated_method = "EDF2ADBEB9F37EA77416CC9DB5DDE311")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AllowParser.parse");
        AllowList list = new AllowList();
        try 
        {
            headerName(TokenTypes.ALLOW);
            Allow allow = new Allow();
            allow.setHeaderName(SIPHeaderNames.ALLOW);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allow.setMethod(token.getTokenValue());
            list.add(allow);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                allow = new Allow();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                allow.setMethod(token.getTokenValue());
                list.add(allow);
                this.lexer.SPorHT();
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1010942504 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1010942504.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1010942504;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AllowParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

