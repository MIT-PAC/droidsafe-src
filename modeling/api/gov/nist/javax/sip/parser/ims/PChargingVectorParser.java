package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.261 -0500", hash_original_method = "A4A88DE0006B5603CC0F71572978ABEB", hash_generated_method = "96732BBFCC82750F5383FA3F864C4181")
    
public PChargingVectorParser(String chargingVector) {

        super(chargingVector);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.264 -0500", hash_original_method = "73E61A8E6B9D3F4F5811815C202485DB", hash_generated_method = "3A6F5ECA4043411C8051DE3F3C15D307")
    
protected PChargingVectorParser(Lexer lexer) {

        super(lexer);

    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.267 -0500", hash_original_method = "4152406B40F94995C7A2549F5DE1C3E9", hash_generated_method = "11FFE0ABB2A8145D720507108B9B7673")
    
public SIPHeader parse() throws ParseException {


        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector chargingVector = new PChargingVector();

            try {
                while (lexer.lookAhead(0) != '\n') {
                    this.parseParameter(chargingVector);
                    this.lexer.SPorHT();
                    char la = lexer.lookAhead(0);
                    if (la == '\n' || la == '\0')
                        break;
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                }

            } catch (ParseException ex) {
                throw ex;
            }


            super.parse(chargingVector);
            if ( chargingVector.getParameter(ParameterNamesIms.ICID_VALUE) == null )
                throw new ParseException("Missing a required Parameter : " + ParameterNamesIms.ICID_VALUE, 0);
            return chargingVector;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.270 -0500", hash_original_method = "E5BADA3ECE6E53AAFFF871A13AE56E77", hash_generated_method = "E3B6AA992A01B7A0B76051AD76C8A80D")
    
protected void parseParameter(PChargingVector chargingVector) throws ParseException {

        if (debug)
            dbg_enter("parseParameter");
        try {
            NameValue nv = this.nameValue('=');
            chargingVector.setParameter(nv);
        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }



    }

    
}

