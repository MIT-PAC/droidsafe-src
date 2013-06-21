package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class ErrorInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.274 -0400", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "3563031E1C138EFFA88B2CB495169E05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfoParser(String errorInfo) {
        super(errorInfo);
        dsTaint.addTaint(errorInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.275 -0400", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "600E716D1185AAF1AEAAEC602CE12A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ErrorInfoParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.275 -0400", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "30A1DF806BD6F814F8B151D5DAB32B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list;
        list = new ErrorInfoList();
        try 
        {
            headerName(TokenTypes.ERROR_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_504407656 = (lexer.lookAhead(0) != '\n');
                {
                    {
                        ErrorInfo errorInfo;
                        errorInfo = new ErrorInfo();
                        errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
                        this.lexer.SPorHT();
                        this.lexer.match('<');
                        URLParser urlParser;
                        urlParser = new URLParser((Lexer) this.lexer);
                        GenericURI uri;
                        uri = urlParser.uriReference( true );
                        errorInfo.setErrorInfo(uri);
                        this.lexer.match('>');
                        this.lexer.SPorHT();
                        super.parse(errorInfo);
                        list.add(errorInfo);
                        {
                            boolean var9AE54EB6EBAEA27AE99856C2C81EF714_1327739440 = (lexer.lookAhead(0) == ',');
                            {
                                this.lexer.match(',');
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("ErrorInfoParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

