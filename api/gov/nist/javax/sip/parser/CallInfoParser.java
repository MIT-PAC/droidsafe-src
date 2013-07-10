package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class CallInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.802 -0400", hash_original_method = "8BAB8761E46B5AA99EF5C7C4869D5271", hash_generated_method = "FA4D2DBF6C5CC7351F58D5D329C8A742")
    public  CallInfoParser(String callInfo) {
        super(callInfo);
        addTaint(callInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.802 -0400", hash_original_method = "389AF9661F1F957F7921EC977496F9ED", hash_generated_method = "25B8CFBB9F050E05BB3B0F1077FF4D1A")
    protected  CallInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.803 -0400", hash_original_method = "290368D57FB4A6E462380F5F8D42DA38", hash_generated_method = "30B22E6045DE344358DBB86A7B74E0B0")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1865028841 = null; 
        dbg_enter("CallInfoParser.parse");
        CallInfoList list = new CallInfoList();
        try 
        {
            headerName(TokenTypes.CALL_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_236111849 = (lexer.lookAhead(0) != '\n');
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
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1340586159 = (lexer.lookAhead(0) == ',');
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
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1865028841 = list;
        } 
        finally 
        {
            dbg_leave("CallInfoParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1865028841.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1865028841;
        
        
    }

    
}

