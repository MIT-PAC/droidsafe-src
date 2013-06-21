package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;

public final class ReplyTo extends AddressParametersHeader implements ReplyToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.119 -0400", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "9351E959CBBABCA53952EE7B443BEEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplyTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.121 -0400", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "859C5F3671F51F62721500871DDBB2D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplyTo(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.121 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "F9721A2196EDFE04067B54BD707B5C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String var803E280AC6E161553ACD6EAB6E4869F5_635289253 = (headerName + COLON + SP + encodeBody() + NEWLINE);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.122 -0400", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "8327684E545DA8BADBBE479D5A6CF210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1180879272 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_927846958 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2054068577 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.123 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "9F1806594DA322B943801A0D5B33F3B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        HostPort varEEF9871E33E64F4E24422F40F5C745CE_1399992072 = (address.getHostPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.123 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "77A0B41BD392255215414A4B903CE1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var31866FBF526B94C8B9049BB4E32C34D2_1668732356 = (address.getDisplayName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address.getDisplayName();
    }

    
    private static final long serialVersionUID = -9103698729465531373L;
}

