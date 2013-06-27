package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PChargingVector;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class PChargingVectorParser extends ParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.682 -0400", hash_original_method = "A4A88DE0006B5603CC0F71572978ABEB", hash_generated_method = "35D48DD81632D2F8F7FF660448B29BDD")
    public  PChargingVectorParser(String chargingVector) {
        super(chargingVector);
        addTaint(chargingVector.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.682 -0400", hash_original_method = "73E61A8E6B9D3F4F5811815C202485DB", hash_generated_method = "1FA51B4BA9AC220C5AAD3CD1EE4930E6")
    protected  PChargingVectorParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.683 -0400", hash_original_method = "4152406B40F94995C7A2549F5DE1C3E9", hash_generated_method = "48DAABC43340A1A95818B1903318347B")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1004711730 = null; //Variable for return #1
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector chargingVector;
            chargingVector = new PChargingVector();
            try 
            {
                {
                    boolean var053C2AA6A70B74FC601942C3CC901981_223046212 = (lexer.lookAhead(0) != '\n');
                    {
                        this.parseParameter(chargingVector);
                        this.lexer.SPorHT();
                        char la;
                        la = lexer.lookAhead(0);
                        this.lexer.match(';');
                        this.lexer.SPorHT();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            super.parse(chargingVector);
            {
                boolean var2C81E977376561A87E1895644F71162B_266372564 = (chargingVector.getParameter(ParameterNamesIms.ICID_VALUE) == null);
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Missing a required Parameter : " + ParameterNamesIms.ICID_VALUE, 0);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1004711730 = chargingVector;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1004711730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004711730;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.684 -0400", hash_original_method = "E5BADA3ECE6E53AAFFF871A13AE56E77", hash_generated_method = "1E585B86CEA5565FB7AA60F10991868E")
    protected void parseParameter(PChargingVector chargingVector) throws ParseException {
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv;
            nv = this.nameValue('=');
            chargingVector.setParameter(nv);
        } //End block
        finally 
        {
            dbg_leave("parseParameter");
        } //End block
        addTaint(chargingVector.getTaint());
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("parseParameter");
        //try {
            //NameValue nv = this.nameValue('=');
            //chargingVector.setParameter(nv);
        //} finally {
            //if (debug)
                //dbg_leave("parseParameter");
        //}
    }

    
}

