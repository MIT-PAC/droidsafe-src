package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.CallInfo;
import gov.nist.javax.sip.header.CallInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CallInfoParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.964 -0400", hash_original_method = "8BAB8761E46B5AA99EF5C7C4869D5271", hash_generated_method = "FA4D2DBF6C5CC7351F58D5D329C8A742")
    public  CallInfoParser(String callInfo) {
        super(callInfo);
        addTaint(callInfo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.964 -0400", hash_original_method = "389AF9661F1F957F7921EC977496F9ED", hash_generated_method = "25B8CFBB9F050E05BB3B0F1077FF4D1A")
    protected  CallInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.966 -0400", hash_original_method = "290368D57FB4A6E462380F5F8D42DA38", hash_generated_method = "B52AE90B14CEE9D41235CCBFF2DCA05F")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("CallInfoParser.parse");
        CallInfoList list = new CallInfoList();
        try 
        {
            headerName(TokenTypes.CALL_INFO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                CallInfo callInfo = new CallInfo();
                callInfo.setHeaderName(SIPHeaderNames.CALL_INFO);
                this.lexer.SPorHT();
                this.lexer.match('<');
                URLParser urlParser = new URLParser((Lexer)this.lexer);
                GenericURI uri = urlParser.uriReference(true);
                callInfo.setInfo(uri);
                this.lexer.match('>');
                this.lexer.SPorHT();
                super.parse(callInfo);
                list.add(callInfo);
                while
(lexer.lookAhead(0) == ',')                
                {
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
                } //End block
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1812130960 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1812130960.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1812130960;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("CallInfoParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

