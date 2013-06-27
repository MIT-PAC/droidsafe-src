package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AcceptParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.153 -0400", hash_original_method = "E50D6CA61897C534ECF6BFE2E6C66EEB", hash_generated_method = "47E74533E30A5580A43C253EA52B779A")
    public  AcceptParser(String accept) {
        super(accept);
        addTaint(accept.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.153 -0400", hash_original_method = "B0740C746A8D55CA7E1BAB3B373D9F3B", hash_generated_method = "CFD5C41C299FA64BEF69A6D9AEDB1EB1")
    protected  AcceptParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.155 -0400", hash_original_method = "4B990F83EF66D5D2EAA453ED852E8DC7", hash_generated_method = "FCA88EAF4AFB9A61BEEE75AF3E22738A")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_663511831 = null; //Variable for return #1
        dbg_enter("AcceptParser.parse");
        AcceptList list;
        list = new AcceptList();
        try 
        {
            headerName(TokenTypes.ACCEPT);
            Accept accept;
            accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            accept.setContentType(token.getTokenValue());
            this.lexer.match('/');
            this.lexer.match(TokenTypes.ID);
            token = lexer.getNextToken();
            accept.setContentSubType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(accept);
            list.add(accept);
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_415696912 = (lexer.lookAhead(0) == ',');
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
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_663511831 = list;
        } //End block
        finally 
        {
            dbg_leave("AcceptParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_663511831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_663511831;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

