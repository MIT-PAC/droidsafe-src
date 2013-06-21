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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.766 -0400", hash_original_method = "A4A88DE0006B5603CC0F71572978ABEB", hash_generated_method = "F7369DEE9965C4D02DF375235C709697")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingVectorParser(String chargingVector) {
        super(chargingVector);
        dsTaint.addTaint(chargingVector);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.766 -0400", hash_original_method = "73E61A8E6B9D3F4F5811815C202485DB", hash_generated_method = "7389286ACA83DD579596B52FAC76520B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PChargingVectorParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.767 -0400", hash_original_method = "4152406B40F94995C7A2549F5DE1C3E9", hash_generated_method = "5D55FB2BCDE03159EA5C1915E453D717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector chargingVector;
            chargingVector = new PChargingVector();
            try 
            {
                {
                    boolean var053C2AA6A70B74FC601942C3CC901981_1223253913 = (lexer.lookAhead(0) != '\n');
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
                boolean var2C81E977376561A87E1895644F71162B_1259907553 = (chargingVector.getParameter(ParameterNamesIms.ICID_VALUE) == null);
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Missing a required Parameter : " + ParameterNamesIms.ICID_VALUE, 0);
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.767 -0400", hash_original_method = "E5BADA3ECE6E53AAFFF871A13AE56E77", hash_generated_method = "B18B1EDE55ABA2CAB9FA204CB83A4E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseParameter(PChargingVector chargingVector) throws ParseException {
        dsTaint.addTaint(chargingVector.dsTaint);
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

