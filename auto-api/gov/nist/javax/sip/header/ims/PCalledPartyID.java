package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;

public class PCalledPartyID extends gov.nist.javax.sip.header.AddressParametersHeader implements PCalledPartyIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.239 -0400", hash_original_method = "EDC402C5990746AE150AF00BD84032F6", hash_generated_method = "008625C37B00D68D1097FF30CAE49B29")
    public  PCalledPartyID(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.239 -0400", hash_original_method = "D34D544F1730F850E33368222A05354C", hash_generated_method = "49A3F9AF22422791AFB5269749C297FA")
    public  PCalledPartyID() {
        super(CALLED_PARTY_ID);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.240 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "A226886C2E51634E2D7136EED07EDB61")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1706983812 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_615011870 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } 
        } 
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_2083875513 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_148036509 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1706983812 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1706983812.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1706983812;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.240 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
}

