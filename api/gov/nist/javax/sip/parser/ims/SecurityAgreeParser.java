package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityAgree;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;
import gov.nist.javax.sip.header.ims.SecurityServer;
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyList;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class SecurityAgreeParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.958 -0500", hash_original_method = "3C9B744CAD21A5FF0128608065B78D3C", hash_generated_method = "693ED6A66AE8EFF88C187F7207BB7AEA")
    
public SecurityAgreeParser(String security) {
        super(security);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.960 -0500", hash_original_method = "901019111A521E611D0FA754D5F384A4", hash_generated_method = "2DF8CC0EB1F18964A2541DC051B69355")
    
protected SecurityAgreeParser(Lexer lexer) {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.963 -0500", hash_original_method = "F5B0772594CADDF674D010ACA1204B13", hash_generated_method = "90EC3697B8B82B1EEDFD6B77A91DF932")
    
protected void parseParameter(SecurityAgree header)
        throws ParseException
    {
        if (debug)
            dbg_enter("parseParameter");
        try {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.967 -0500", hash_original_method = "12664C139391D128E477218D3F3EA9C3", hash_generated_method = "31C5AD713B3B0B11C9ECBCE0EC0E27A4")
    
public SIPHeaderList parse(SecurityAgree header) throws ParseException
    {

        SIPHeaderList list;

        if (header.getClass().isInstance(new SecurityClient())) {
            list = new SecurityClientList();
        } else if (header.getClass().isInstance(new SecurityServer())) {
            list = new SecurityServerList();
        } else if (header.getClass().isInstance(new SecurityVerify())) {
            list = new SecurityVerifyList();
        }
        else
            return null;


        // the security-mechanism:
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        header.setSecurityMechanism(type.getTokenValue());
        this.lexer.SPorHT();

        char la = lexer.lookAhead(0);
        if (la == '\n')
        {
            list.add(header);
            return list;
        }
        else if (la == ';')
            this.lexer.match(';');

        this.lexer.SPorHT();

        // The parameters:
        try {
            while (lexer.lookAhead(0) != '\n') {

                this.parseParameter(header);
                this.lexer.SPorHT();
                char laInLoop = lexer.lookAhead(0);
                if (laInLoop == '\n' || laInLoop == '\0')
                    break;
                else if (laInLoop == ',')
                {
                    list.add(header);
                    if (header.getClass().isInstance(new SecurityClient())) {
                        header = new SecurityClient();
                    } else if (header.getClass().isInstance(new SecurityServer())) {
                        header = new SecurityServer();
                    } else if (header.getClass().isInstance(new SecurityVerify())) {
                        header = new SecurityVerify();
                    }

                    this.lexer.match(',');
                    // the security-mechanism:
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    type = lexer.getNextToken();
                    header.setSecurityMechanism(type.getTokenValue());

                }
                this.lexer.SPorHT();

                if (lexer.lookAhead(0) == ';')
                    this.lexer.match(';');

                this.lexer.SPorHT();

            }
            list.add(header);

            return list;

        } catch (ParseException ex) {
            throw ex;
        }


    }

    
}

