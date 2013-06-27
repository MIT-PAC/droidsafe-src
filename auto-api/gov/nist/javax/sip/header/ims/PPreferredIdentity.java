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
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PPreferredIdentity extends AddressParametersHeader implements PPreferredIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.440 -0400", hash_original_method = "A7A18C7C290144143F0B066F971631B8", hash_generated_method = "9C3F701BE302C93D2275700892F28FFC")
    public  PPreferredIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.441 -0400", hash_original_method = "87907696BDC4EF5B0ECA8FC9DCAB5991", hash_generated_method = "FB7E20AB3A4056E3089E535CEABCA3D3")
    public  PPreferredIdentity() {
        super(P_PREFERRED_IDENTITY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.442 -0400", hash_original_method = "2167C0D1D3C772E3CF273B6DCAFE6265", hash_generated_method = "EEB06CAA8604CFEBBC872C4434A9BA73")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_430646174 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1251209057 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_812147283 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_430646174 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_430646174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_430646174;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(LESS_THAN);
        //}
        //retval.append(address.encode());
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(GREATER_THAN);
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.444 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
}

