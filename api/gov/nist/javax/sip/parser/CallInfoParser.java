package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.CallInfo;
import gov.nist.javax.sip.header.CallInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class CallInfoParser extends ParametersParser {
    
    /**
     * Creates a new instance of CallInfoParser
     * @param callInfo the header to parse 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.371 -0500", hash_original_method = "8BAB8761E46B5AA99EF5C7C4869D5271", hash_generated_method = "5FFE7D6CA45162454C02F916915597DA")
    
public CallInfoParser(String callInfo) {
        super(callInfo);
    }
    
    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.373 -0500", hash_original_method = "389AF9661F1F957F7921EC977496F9ED", hash_generated_method = "335D6DBB7D9BB38CDAAC4DE22989107D")
    
protected  CallInfoParser(Lexer lexer) {
        super(lexer);
    }
    
    /**
     * parse the CallInfo String header
     * @return SIPHeader (CallInfoList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.378 -0500", hash_original_method = "290368D57FB4A6E462380F5F8D42DA38", hash_generated_method = "7E57AB4A89952934B3D3F2D586FF19C1")
    
public SIPHeader parse() throws ParseException {
        
        if (debug) dbg_enter("CallInfoParser.parse");
        CallInfoList list=new CallInfoList();
        
        try {
            headerName(TokenTypes.CALL_INFO);
            
            while (lexer.lookAhead(0) != '\n') {
                CallInfo callInfo= new CallInfo();
                callInfo.setHeaderName(SIPHeaderNames.CALL_INFO);
                
                this.lexer.SPorHT();
                this.lexer.match('<');
                URLParser urlParser=new URLParser((Lexer)this.lexer);
                GenericURI uri=urlParser.uriReference(true); 
                callInfo.setInfo(uri);
                this.lexer.match('>');
                this.lexer.SPorHT();
                
                super.parse(callInfo);
                list.add(callInfo);
                
                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    
                    callInfo= new CallInfo();
                    
                    this.lexer.SPorHT();
                    this.lexer.match('<');
                    urlParser=new URLParser((Lexer)this.lexer);
                    uri=urlParser.uriReference(true);
                    callInfo.setInfo(uri);
                    this.lexer.match('>');
                    this.lexer.SPorHT();
                    
                    super.parse(callInfo);
                    list.add(callInfo);
                }
            }
            
            return list;
        }
        finally {
            if (debug) dbg_leave("CallInfoParser.parse");
        }
    }

    
}

