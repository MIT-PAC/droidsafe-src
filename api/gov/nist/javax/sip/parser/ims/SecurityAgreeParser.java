package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.*;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class SecurityAgreeParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.287 -0400", hash_original_method = "3C9B744CAD21A5FF0128608065B78D3C", hash_generated_method = "CC9828D5309CF88A17780C7D47A7AC99")
    public  SecurityAgreeParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.288 -0400", hash_original_method = "901019111A521E611D0FA754D5F384A4", hash_generated_method = "DFEE8107DE9D6223B0CDE8A1E6B1EECC")
    protected  SecurityAgreeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.289 -0400", hash_original_method = "F5B0772594CADDF674D010ACA1204B13", hash_generated_method = "634F5424E1BC0DC9ACFD5EF7F2751253")
    protected void parseParameter(SecurityAgree header) throws ParseException {
        addTaint(header.getTaint());
    if(debug)        
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } 
        finally 
        {
    if(debug)            
            dbg_leave("parseParameter");
        } 
        
        
            
        
            
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.294 -0400", hash_original_method = "12664C139391D128E477218D3F3EA9C3", hash_generated_method = "6FACF4BF55B7DF3981150EE16C4970EC")
    public SIPHeaderList parse(SecurityAgree header) throws ParseException {
        addTaint(header.getTaint());
        SIPHeaderList list;
    if(header.getClass().isInstance(new SecurityClient()))        
        {
            list = new SecurityClientList();
        } 
        else
    if(header.getClass().isInstance(new SecurityServer()))        
        {
            list = new SecurityServerList();
        } 
        else
    if(header.getClass().isInstance(new SecurityVerify()))        
        {
            list = new SecurityVerifyList();
        } 
        else
        {
SIPHeaderList var540C13E9E156B687226421B24F2DF178_417713938 =         null;
        var540C13E9E156B687226421B24F2DF178_417713938.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_417713938;
        }
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        header.setSecurityMechanism(type.getTokenValue());
        this.lexer.SPorHT();
        char la = lexer.lookAhead(0);
    if(la == '\n')        
        {
            list.add(header);
SIPHeaderList varED12C351C2E8CA4F85F097DDC7E77B4D_922793288 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_922793288.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_922793288;
        } 
        else
    if(la == ';')        
        this.lexer.match(';');
        this.lexer.SPorHT();
        try 
        {
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.parseParameter(header);
                this.lexer.SPorHT();
                char laInLoop = lexer.lookAhead(0);
    if(laInLoop == '\n' || laInLoop == '\0')                
                break;
                else
    if(laInLoop == ',')                
                {
                    list.add(header);
    if(header.getClass().isInstance(new SecurityClient()))                    
                    {
                        header = new SecurityClient();
                    } 
                    else
    if(header.getClass().isInstance(new SecurityServer()))                    
                    {
                        header = new SecurityServer();
                    } 
                    else
    if(header.getClass().isInstance(new SecurityVerify()))                    
                    {
                        header = new SecurityVerify();
                    } 
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    type = lexer.getNextToken();
                    header.setSecurityMechanism(type.getTokenValue());
                } 
                this.lexer.SPorHT();
    if(lexer.lookAhead(0) == ';')                
                this.lexer.match(';');
                this.lexer.SPorHT();
            } 
            list.add(header);
SIPHeaderList varED12C351C2E8CA4F85F097DDC7E77B4D_1438813774 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1438813774.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1438813774;
        } 
        catch (ParseException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } 
        
        
    }

    
}

