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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.513 -0400", hash_original_method = "C3DEC8F418CE8BBD8D4ED1D7A2F51A12", hash_generated_method = "44B60B9435122CE6D895DDF9A9B319C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferredBy() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.513 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.513 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "361A5373176191226E306836DF3BD528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1776689108 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1823677649 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_925367006 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    private static final long serialVersionUID = 3134344915465784267L;
    public static final String NAME = "Referred-By";
}

