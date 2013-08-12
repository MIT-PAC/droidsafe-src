package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PChargingVector;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PChargingVectorParser extends ParametersParser implements TokenTypes {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.915 -0400", hash_original_method = "A4A88DE0006B5603CC0F71572978ABEB", hash_generated_method = "35D48DD81632D2F8F7FF660448B29BDD")
    public  PChargingVectorParser(String chargingVector) {
        super(chargingVector);
        addTaint(chargingVector.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.915 -0400", hash_original_method = "73E61A8E6B9D3F4F5811815C202485DB", hash_generated_method = "1FA51B4BA9AC220C5AAD3CD1EE4930E6")
    protected  PChargingVectorParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.916 -0400", hash_original_method = "4152406B40F94995C7A2549F5DE1C3E9", hash_generated_method = "2953FC5B3205B04F491D9A3F5DC53C53")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector chargingVector = new PChargingVector();
            try 
            {
                while
(lexer.lookAhead(0) != '\n')                
                {
                    this.parseParameter(chargingVector);
                    this.lexer.SPorHT();
                    char la = lexer.lookAhead(0);
                    if(la == '\n' || la == '\0')                    
                    break;
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                } //End block
            } //End block
            catch (ParseException ex)
            {
                ex.addTaint(taint);
                throw ex;
            } //End block
            super.parse(chargingVector);
            if(chargingVector.getParameter(ParameterNamesIms.ICID_VALUE) == null)            
            {
            ParseException var0DD7060F8BBFC854E0830DBF38FCBF08_1140105009 = new ParseException("Missing a required Parameter : " + ParameterNamesIms.ICID_VALUE, 0);
            var0DD7060F8BBFC854E0830DBF38FCBF08_1140105009.addTaint(taint);
            throw var0DD7060F8BBFC854E0830DBF38FCBF08_1140105009;
            }
SIPHeader var14792F8596B417D3663D3E76C47F07C6_559269095 =             chargingVector;
            var14792F8596B417D3663D3E76C47F07C6_559269095.addTaint(taint);
            return var14792F8596B417D3663D3E76C47F07C6_559269095;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.917 -0400", hash_original_method = "E5BADA3ECE6E53AAFFF871A13AE56E77", hash_generated_method = "0078A3AC8FDA8BB73D9F38FBA2325A6E")
    protected void parseParameter(PChargingVector chargingVector) throws ParseException {
        addTaint(chargingVector.getTaint());
        if(debug)        
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv = this.nameValue('=');
            chargingVector.setParameter(nv);
        } //End block
        finally 
        {
            if(debug)            
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

