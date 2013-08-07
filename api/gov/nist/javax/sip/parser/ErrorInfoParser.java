package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.ErrorInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ErrorInfoParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.426 -0400", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "83D3B9F618EFC876DDE2B0F01045EEC6")
    public  ErrorInfoParser(String errorInfo) {
        super(errorInfo);
        addTaint(errorInfo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.426 -0400", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "5E6090731FD6E4E3002E0DA957BD8102")
    protected  ErrorInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.427 -0400", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "F2611BD7610CFCAB01784FE8DFAEDCB1")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list = new ErrorInfoList();
        try 
        {
            headerName(TokenTypes.ERROR_INFO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                do {
                    {
                        ErrorInfo errorInfo = new ErrorInfo();
                        errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
                        this.lexer.SPorHT();
                        this.lexer.match('<');
                        URLParser urlParser = new URLParser((Lexer) this.lexer);
                        GenericURI uri = urlParser.uriReference( true );
                        errorInfo.setErrorInfo(uri);
                        this.lexer.match('>');
                        this.lexer.SPorHT();
                        super.parse(errorInfo);
                        list.add(errorInfo);
                        if(lexer.lookAhead(0) == ',')                        
                        {
                            this.lexer.match(',');
                        } //End block
                        else
                        break;
                    } //End block
} while (true);
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1304406882 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1304406882.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1304406882;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ErrorInfoParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

