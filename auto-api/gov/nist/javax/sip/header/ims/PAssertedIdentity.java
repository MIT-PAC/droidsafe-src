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
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PAssertedIdentity extends AddressParametersHeader implements PAssertedIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.226 -0400", hash_original_method = "4DB521A98546EC6C210A063C8DC8A3AB", hash_generated_method = "ECDE4F5491B010A785DC78B96DCB82B0")
    public  PAssertedIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.226 -0400", hash_original_method = "7A9E6607376C61D3870CDBD630C80B00", hash_generated_method = "44DEFC0ABC6FF74FF8AD15DA6F9C8AD2")
    public  PAssertedIdentity() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.236 -0400", hash_original_method = "A02034091310C74B28639EFAE9360C33", hash_generated_method = "12CD96BA0C37CC7558FC1FDD9DC44802")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1196666583 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_210325402 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_356608403 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1126284150 = (!parameters.isEmpty());
            retval.append(COMMA + this.parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1196666583 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1196666583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1196666583;
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
            //retval.append(COMMA + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.237 -0400", hash_original_method = "0E5911CB2B858F97AB1667F7876EAA3E", hash_generated_method = "4EACF98FF33409D7941B1FD441698EF6")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1093685185 = null; //Variable for return #1
        PAssertedIdentity retval;
        retval = (PAssertedIdentity) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1093685185 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1093685185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1093685185;
        // ---------- Original Method ----------
        //PAssertedIdentity retval = (PAssertedIdentity) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.237 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

