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

public class CallInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.250 -0400", hash_original_method = "8BAB8761E46B5AA99EF5C7C4869D5271", hash_generated_method = "7908EBF18D46FB387EBA25531D801647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallInfoParser(String callInfo) {
        super(callInfo);
        dsTaint.addTaint(callInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.250 -0400", hash_original_method = "389AF9661F1F957F7921EC977496F9ED", hash_generated_method = "9594E69E19D773EA03022F15525DE362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CallInfoParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.251 -0400", hash_original_method = "290368D57FB4A6E462380F5F8D42DA38", hash_generated_method = "D7F611D688C58C1C71D9B9B282CE9193")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("CallInfoParser.parse");
        CallInfoList list;
        list = new CallInfoList();
        try 
        {
            headerName(TokenTypes.CALL_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_727351985 = (lexer.lookAhead(0) != '\n');
                {
                    CallInfo callInfo;
                    callInfo = new CallInfo();
                    callInfo.setHeaderName(SIPHeaderNames.CALL_INFO);
                    this.lexer.SPorHT();
                    this.lexer.match('<');
                    URLParser urlParser;
                    urlParser = new URLParser((Lexer)this.lexer);
                    GenericURI uri;
                    uri = urlParser.uriReference(true);
                    callInfo.setInfo(uri);
                    this.lexer.match('>');
                    this.lexer.SPorHT();
                    super.parse(callInfo);
                    list.add(callInfo);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_50000528 = (lexer.lookAhead(0) == ',');
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
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("CallInfoParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

