package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddresses;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class PChargingFunctionAddressesParser extends ParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.761 -0400", hash_original_method = "E6802C10162BF9ECF1CA7A726DBBAC6F", hash_generated_method = "BB98CB4F157993233BED571F48EF3863")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingFunctionAddressesParser(String charging) {
        super(charging);
        dsTaint.addTaint(charging);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.762 -0400", hash_original_method = "D9D24A0C312DDEF7581D0ED53212D170", hash_generated_method = "B4E6FC03732B78F4896F8A4E3EA5A1F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PChargingFunctionAddressesParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.762 -0400", hash_original_method = "5C436260248E496F94134402F46D8C6D", hash_generated_method = "C45A0833B5515CB5DB46F257F9D537F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.P_CHARGING_FUNCTION_ADDRESSES);
            PChargingFunctionAddresses chargingFunctionAddresses;
            chargingFunctionAddresses = new PChargingFunctionAddresses();
            try 
            {
                {
                    boolean var053C2AA6A70B74FC601942C3CC901981_909283165 = (lexer.lookAhead(0) != '\n');
                    {
                        this.parseParameter(chargingFunctionAddresses);
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
            super.parse(chargingFunctionAddresses);
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.762 -0400", hash_original_method = "E7DC882A60F6AF0A0416E9B2C1439960", hash_generated_method = "5EE13F5E051E95825026C0B3528AEB29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseParameter(PChargingFunctionAddresses chargingFunctionAddresses) throws ParseException {
        dsTaint.addTaint(chargingFunctionAddresses.dsTaint);
        dbg_enter("parseParameter");
        try 
        {
            NameValue nv;
            nv = this.nameValue('=');
            chargingFunctionAddresses.setMultiParameter(nv);
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
            //chargingFunctionAddresses.setMultiParameter(nv);
        //} finally {
            //if (debug)
                //dbg_leave("parseParameter");
        //}
    }

    
        public static void main(String args[]) throws ParseException {
        String r[] = {
                "P-Charging-Function-Addresses: ccf=\"test str\"; ecf=token\n",
                "P-Charging-Function-Addresses: ccf=192.1.1.1; ccf=192.1.1.2; ecf=192.1.1.3; ecf=192.1.1.4\n",
                "P-Charging-Function-Addresses: ccf=[5555::b99:c88:d77:e66]; ccf=[5555::a55:b44:c33:d22]; " +
                     "ecf=[5555::1ff:2ee:3dd:4cc]; ecf=[5555::6aa:7bb:8cc:9dd]\n"
                };
        for (int i = 0; i < r.length; i++ )
        {
            PChargingFunctionAddressesParser parser =
              new PChargingFunctionAddressesParser(r[i]);
            System.out.println("original = " + r[i]);
            PChargingFunctionAddresses chargAddr= (PChargingFunctionAddresses) parser.parse();
            System.out.println("encoded = " + chargAddr.encode());
        }
    }

    
}

