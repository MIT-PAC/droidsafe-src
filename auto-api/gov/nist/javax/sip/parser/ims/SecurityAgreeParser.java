package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.737 -0400", hash_original_method = "3C9B744CAD21A5FF0128608065B78D3C", hash_generated_method = "CC9828D5309CF88A17780C7D47A7AC99")
    public  SecurityAgreeParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.738 -0400", hash_original_method = "901019111A521E611D0FA754D5F384A4", hash_generated_method = "DFEE8107DE9D6223B0CDE8A1E6B1EECC")
    protected  SecurityAgreeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.738 -0400", hash_original_method = "F5B0772594CADDF674D010ACA1204B13", hash_generated_method = "DF75D2A86ED83EF28695E814E7042481")
    protected void parseParameter(SecurityAgree header) throws ParseException {
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv;
            nv = this.nameValue('=');
            header.setParameter(nv);
        } //End block
        finally 
        {
            dbg_leave("parseParameter");
        } //End block
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("parseParameter");
        //try {
            //NameValue nv = this.nameValue('=');
            //header.setParameter(nv);
        //} finally {
            //if (debug)
                //dbg_leave("parseParameter");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.758 -0400", hash_original_method = "12664C139391D128E477218D3F3EA9C3", hash_generated_method = "47B9D02147F2657ADF422EE90CF51C53")
    public SIPHeaderList parse(SecurityAgree header) throws ParseException {
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_2062575276 = null; //Variable for return #1
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_1498522391 = null; //Variable for return #2
        SIPHeaderList varB4EAC82CA7396A68D541C85D26508E83_2022990886 = null; //Variable for return #3
        SIPHeaderList list;
        {
            boolean var6125B6265576D46686936F755BE35B4F_781494885 = (header.getClass().isInstance(new SecurityClient()));
            {
                list = new SecurityClientList();
            } //End block
            {
                boolean var167B977914774511A374B371A7E0DF31_1714047884 = (header.getClass().isInstance(new SecurityServer()));
                {
                    list = new SecurityServerList();
                } //End block
                {
                    boolean var6B545B3415ED98D1499203019435A2B6_1888763215 = (header.getClass().isInstance(new SecurityVerify()));
                    {
                        list = new SecurityVerifyList();
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_2062575276 = null;
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type;
        type = lexer.getNextToken();
        header.setSecurityMechanism(type.getTokenValue());
        this.lexer.SPorHT();
        char la;
        la = lexer.lookAhead(0);
        {
            list.add(header);
            varB4EAC82CA7396A68D541C85D26508E83_1498522391 = list;
        } //End block
        this.lexer.match(';');
        this.lexer.SPorHT();
        try 
        {
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_423531801 = (lexer.lookAhead(0) != '\n');
                {
                    this.parseParameter(header);
                    this.lexer.SPorHT();
                    char laInLoop;
                    laInLoop = lexer.lookAhead(0);
                    {
                        list.add(header);
                        {
                            boolean var65D2129F480BB89CB1D06E750274ACD3_1826853770 = (header.getClass().isInstance(new SecurityClient()));
                            {
                                header = new SecurityClient();
                            } //End block
                            {
                                boolean var479B95A2CEAB14AF4180BE3858963638_1565972174 = (header.getClass().isInstance(new SecurityServer()));
                                {
                                    header = new SecurityServer();
                                } //End block
                                {
                                    boolean var444027EFF78B94B2CC89FA6977547450_2091697927 = (header.getClass().isInstance(new SecurityVerify()));
                                    {
                                        header = new SecurityVerify();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                        lexer.match(TokenTypes.ID);
                        type = lexer.getNextToken();
                        header.setSecurityMechanism(type.getTokenValue());
                    } //End block
                    this.lexer.SPorHT();
                    {
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_253913270 = (lexer.lookAhead(0) == ';');
                        this.lexer.match(';');
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            list.add(header);
            varB4EAC82CA7396A68D541C85D26508E83_2022990886 = list;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        addTaint(header.getTaint());
        SIPHeaderList varA7E53CE21691AB073D9660D615818899_1990994972; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1990994972 = varB4EAC82CA7396A68D541C85D26508E83_2062575276;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1990994972 = varB4EAC82CA7396A68D541C85D26508E83_1498522391;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1990994972 = varB4EAC82CA7396A68D541C85D26508E83_2022990886;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1990994972.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1990994972;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

