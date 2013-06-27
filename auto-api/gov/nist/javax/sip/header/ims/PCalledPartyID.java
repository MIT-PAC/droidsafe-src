package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;

public class PCalledPartyID extends gov.nist.javax.sip.header.AddressParametersHeader implements PCalledPartyIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.356 -0400", hash_original_method = "EDC402C5990746AE150AF00BD84032F6", hash_generated_method = "008625C37B00D68D1097FF30CAE49B29")
    public  PCalledPartyID(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.356 -0400", hash_original_method = "D34D544F1730F850E33368222A05354C", hash_generated_method = "49A3F9AF22422791AFB5269749C297FA")
    public  PCalledPartyID() {
        super(CALLED_PARTY_ID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.359 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "EC927B152F49C2D94A542BEC26E34523")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1235767800 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_35895598 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_117441877 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_720642770 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1235767800 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1235767800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235767800;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(LESS_THAN);
        //}
        //retval.append(address.encode());
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(GREATER_THAN);
        //}
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.360 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

