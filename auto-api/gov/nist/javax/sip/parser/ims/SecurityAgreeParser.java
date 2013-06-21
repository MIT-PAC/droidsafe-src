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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.786 -0400", hash_original_method = "3C9B744CAD21A5FF0128608065B78D3C", hash_generated_method = "04AFDE8A17D3A6C831BE46E9516F6D8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityAgreeParser(String security) {
        super(security);
        dsTaint.addTaint(security);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.786 -0400", hash_original_method = "901019111A521E611D0FA754D5F384A4", hash_generated_method = "6542B8CCCF94B1E5E2AEFB26A0070197")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecurityAgreeParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.786 -0400", hash_original_method = "F5B0772594CADDF674D010ACA1204B13", hash_generated_method = "F2FAB5AE1BEF2598A13EB0AB70A708CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseParameter(SecurityAgree header) throws ParseException {
        dsTaint.addTaint(header.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.787 -0400", hash_original_method = "12664C139391D128E477218D3F3EA9C3", hash_generated_method = "458D7997840B3092EEAE8E3DAA1F039F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeaderList parse(SecurityAgree header) throws ParseException {
        dsTaint.addTaint(header.dsTaint);
        SIPHeaderList list;
        {
            boolean var6125B6265576D46686936F755BE35B4F_53233464 = (header.getClass().isInstance(new SecurityClient()));
            {
                list = new SecurityClientList();
            } //End block
            {
                boolean var167B977914774511A374B371A7E0DF31_2144293294 = (header.getClass().isInstance(new SecurityServer()));
                {
                    list = new SecurityServerList();
                } //End block
                {
                    boolean var6B545B3415ED98D1499203019435A2B6_385950371 = (header.getClass().isInstance(new SecurityVerify()));
                    {
                        list = new SecurityVerifyList();
                    } //End block
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
        } //End block
        this.lexer.match(';');
        this.lexer.SPorHT();
        try 
        {
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1623341328 = (lexer.lookAhead(0) != '\n');
                {
                    this.parseParameter(header);
                    this.lexer.SPorHT();
                    char laInLoop;
                    laInLoop = lexer.lookAhead(0);
                    {
                        list.add(header);
                        {
                            boolean var65D2129F480BB89CB1D06E750274ACD3_703042880 = (header.getClass().isInstance(new SecurityClient()));
                            {
                                header = new SecurityClient();
                            } //End block
                            {
                                boolean var479B95A2CEAB14AF4180BE3858963638_642206038 = (header.getClass().isInstance(new SecurityServer()));
                                {
                                    header = new SecurityServer();
                                } //End block
                                {
                                    boolean var444027EFF78B94B2CC89FA6977547450_251062963 = (header.getClass().isInstance(new SecurityVerify()));
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
                        boolean varE30E2126F5FFE39A0C5A94E8EAEAED66_160924675 = (lexer.lookAhead(0) == ';');
                        this.lexer.match(';');
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            list.add(header);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        return (SIPHeaderList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

