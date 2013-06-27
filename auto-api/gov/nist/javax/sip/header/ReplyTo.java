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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.313 -0400", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "9351E959CBBABCA53952EE7B443BEEAE")
    public  ReplyTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.313 -0400", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "D9FA9DCA5D12A32B0DD17F9F9AE033D0")
    public  ReplyTo(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.314 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "2020EC718C5EC300B0751007C903C9ED")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1206039529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206039529 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_1206039529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206039529;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.315 -0400", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "DBD668876F2DF5A2A559F73C4985FF67")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1224749037 = null; //Variable for return #1
        String retval;
        retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_744040128 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } //End block
        } //End collapsed parenthetic
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1684210197 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_113990566 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1224749037 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1224749037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224749037;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.332 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "D8A13162E6E038D5CF021B7524E5E502")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_746980539 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746980539 = address.getHostPort();
        varB4EAC82CA7396A68D541C85D26508E83_746980539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746980539;
        // ---------- Original Method ----------
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.346 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "F3197F2FA80C144FB151F064C9655902")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1272898622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1272898622 = address.getDisplayName();
        varB4EAC82CA7396A68D541C85D26508E83_1272898622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272898622;
        // ---------- Original Method ----------
        //return address.getDisplayName();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.346 -0400", hash_original_field = "90C22B20F9F107B1942A4AAE75CB93E1", hash_generated_field = "96E66966C0D7BA1F67EF89E8A7742AF8")

    private static long serialVersionUID = -9103698729465531373L;
}

