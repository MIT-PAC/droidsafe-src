package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.*;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class SecurityAgreeParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.210 -0400", hash_original_method = "3C9B744CAD21A5FF0128608065B78D3C", hash_generated_method = "CC9828D5309CF88A17780C7D47A7AC99")
    public  SecurityAgreeParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.210 -0400", hash_original_method = "901019111A521E611D0FA754D5F384A4", hash_generated_method = "DFEE8107DE9D6223B0CDE8A1E6B1EECC")
    protected  SecurityAgreeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.210 -0400", hash_original_method = "F5B0772594CADDF674D010ACA1204B13", hash_generated_method = "2C7DF2BF5E1087ABDC8E55B420CAF16A")
    protected void parseParameter(SecurityAgree header) throws ParseException {
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } 
        finally 
        {
            dbg_leave("parseParameter");
        } 
        addTaint(header.getTaint());
        
        
            
        
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.212 -0400", hash_original_method = "12664C139391D128E477218D3F3EA9C3", hash_generated_method = "EFA6DADC5D1AF152F6E2C999577E832A")
    public SIPHeaderList parse(SecurityAgree header) throws ParseException {
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_56322672 = null; 
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_2022173647 = null; 
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_1989777198 = null; 
        SIPHeaderList list;
        {
            boolean var6125B6265576D46686936F755BE35B4F_2103480933 = (header.getClass().isInstance(new SecurityClient()));
            {
                list = new SecurityClientList();
            } 
            {
                boolean var167B977914774511A374B371A7E0DF31_2063240119 = (header.getClass().isInstance(new SecurityServer()));
                {
                    list = new SecurityServerList();
                } 
                {
                    boolean var6B545B3415ED98D1499203019435A2B6_659800530 = (header.getClass().isInstance(new SecurityVerify()));
                    {
                        list = new SecurityVerifyList();
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_56322672 = null;
                } 
            } 
        } 
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        header.setSecurityMechanism(type.getTokenValue());
        this.lexer.SPorHT();
        char la = lexer.lookAhead(0);
        {
            list.add(header);
            varB4EAC82CA7396A68D541C85D26508E83_2022173647 = list;
        } 
        this.lexer.match(';');
        this.lexer.SPorHT();
        try 
        {
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_635324900 = (lexer.lookAhead(0) != '\n');
                {
                    this.parseParameter(header);
                    this.lexer.SPorHT();
                    char laInLoop = lexer.lookAhead(0);
                    {
                        list.add(header);
                        {
                            boolean var65D2129F480BB89CB1D06E750274ACD3_925368215 = (header.getClass().isInstance(new SecurityClient()));
                            {
                                header = new SecurityClient();
                            } 
                            {
                                boolean var479B95A2CEAB14AF4180BE3858963638_1331205874 = (header.getClass().isInstance(new SecurityServer()));
                                {
                                    header = new SecurityServer();
                                } 
                                {
                                    boolean var444027EFF78B94B2CC89FA6977547450_178846759 = (header.getClass().isInstance(new SecurityVerify()));
                                    {
                                        header = new SecurityVerify();
                                    } 
                                } 
                            } 
                        } 
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                        lexer.match(TokenTypes.ID);
                        type = lexer.getNextToken();
                        header.setSecurityMechanism(type.getTokenValue());
                    } 
                    this.lexer.SPorHT();
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_951359833 = (lexer.lookAhead(0) == ';');
                        this.lexer.match(';');
                    } 
                    this.lexer.SPorHT();
                } 
            } 
            list.add(header);
            varB4EAC82CA7396A68D541C85D26508E83_1989777198 = list;
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        addTaint(header.getTaint());
        SIPHeaderList varA7E53CE21691AB073D9660D615818899_549138390; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_549138390 = varB4EAC82CA7396A68D541C85D26508E83_56322672;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_549138390 = varB4EAC82CA7396A68D541C85D26508E83_2022173647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_549138390 = varB4EAC82CA7396A68D541C85D26508E83_1989777198;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_549138390.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_549138390;
        
        
    }

    
}

