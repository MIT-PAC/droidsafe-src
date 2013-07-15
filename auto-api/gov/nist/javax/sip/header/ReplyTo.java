package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;

public final class ReplyTo extends AddressParametersHeader implements ReplyToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.036 -0400", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "9351E959CBBABCA53952EE7B443BEEAE")
    public  ReplyTo() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.037 -0400", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "D9FA9DCA5D12A32B0DD17F9F9AE033D0")
    public  ReplyTo(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.038 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "5A7A8C830B6DBE049B46B035BE1C11EC")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1898998142 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1898998142 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_1898998142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1898998142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.039 -0400", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "70C3B10DD2E60901ECB1AE28AE211CF5")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049133160 = null; 
        String retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1513061913 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } 
        } 
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1902710898 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_954881351 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1049133160 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1049133160.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1049133160;
        
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.040 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "8202C0B356AD923310B3F5F6DAE9FA39")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_495581239 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_495581239 = address.getHostPort();
        varB4EAC82CA7396A68D541C85D26508E83_495581239.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_495581239;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.040 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "AB645F495D4637388CF17A2216758CF2")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1392187283 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1392187283 = address.getDisplayName();
        varB4EAC82CA7396A68D541C85D26508E83_1392187283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1392187283;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.040 -0400", hash_original_field = "90C22B20F9F107B1942A4AAE75CB93E1", hash_generated_field = "236E3B2333C15B09CBC94B2F5B379AB6")

    private static final long serialVersionUID = -9103698729465531373L;
}

