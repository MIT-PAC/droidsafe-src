package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;

public final class ReferredBy extends AddressParametersHeader implements ExtensionHeader, ReferredByHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.029 -0400", hash_original_method = "C3DEC8F418CE8BBD8D4ED1D7A2F51A12", hash_generated_method = "44B60B9435122CE6D895DDF9A9B319C3")
    public  ReferredBy() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.050 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.052 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "735F71B6CFCA0BAB324E1D5ACF42D760")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_523276549 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1850133875 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_523276549 = null;
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_576926266 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1860340515 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_903898848 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1850133875 = retval;
        String varA7E53CE21691AB073D9660D615818899_1179480151; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1179480151 = varB4EAC82CA7396A68D541C85D26508E83_523276549;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1179480151 = varB4EAC82CA7396A68D541C85D26508E83_1850133875;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1179480151.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1179480151;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.052 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "53BFCEBE88DAA1CC27A27399F3FE4701")

    private static long serialVersionUID = 3134344915465784267L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.052 -0400", hash_original_field = "2B901D53AC9F4437C27DC11F24B6E7E9", hash_generated_field = "BAA3173ECCDDFD8B4EF4E90187540A3C")

    public static final String NAME = "Referred-By";
}

