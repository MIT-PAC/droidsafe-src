package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.298 -0400", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "895B7864473D22CB612ECFF8E800F936")
    public  ReferTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.318 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "AF75C8EE16236F68F2E4D127F4B61645")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1034868906 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_545687270 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1034868906 = null;
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_914252165 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_611009377 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1725425224 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_545687270 = retval;
        String varA7E53CE21691AB073D9660D615818899_600229625; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_600229625 = varB4EAC82CA7396A68D541C85D26508E83_1034868906;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_600229625 = varB4EAC82CA7396A68D541C85D26508E83_545687270;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_600229625.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_600229625;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //String retval = "";
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval += LESS_THAN;
        //}
        //retval += address.encode();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval += GREATER_THAN;
        //}
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.319 -0400", hash_original_field = "9E7B615A154FC45BB1B1F6461C751642", hash_generated_field = "6A9F6C7819B588DFA62DB51859094557")

    private static long serialVersionUID = -1666700428440034851L;
}

