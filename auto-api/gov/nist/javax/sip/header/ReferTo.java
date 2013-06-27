package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.373 -0400", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "895B7864473D22CB612ECFF8E800F936")
    public  ReferTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.374 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "FAA3FC0D2811EF59FA5932EC21E9205A")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_881684693 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1493904839 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_881684693 = null;
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1003145795 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1407730192 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_277539650 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1493904839 = retval;
        String varA7E53CE21691AB073D9660D615818899_1447444371; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1447444371 = varB4EAC82CA7396A68D541C85D26508E83_881684693;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1447444371 = varB4EAC82CA7396A68D541C85D26508E83_1493904839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1447444371.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1447444371;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.374 -0400", hash_original_field = "9E7B615A154FC45BB1B1F6461C751642", hash_generated_field = "6A9F6C7819B588DFA62DB51859094557")

    private static long serialVersionUID = -1666700428440034851L;
}

