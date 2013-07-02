package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;

public class ServiceRoute extends gov.nist.javax.sip.header.AddressParametersHeader implements ServiceRouteHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.575 -0400", hash_original_method = "9637595E6ECE05066933FE4B9C7C7011", hash_generated_method = "E867E592DF026CF03BA5F78F57866E4B")
    public  ServiceRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.575 -0400", hash_original_method = "DFE1A15880B80307A8195E7AA915629C", hash_generated_method = "6DF26201368D44BF3E02DEA232CD4D93")
    public  ServiceRoute() {
        super(SERVICE_ROUTE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.576 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "6560F9B52B844C82F2561F776F0C3BA9")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1529034209 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_917569692 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } 
        } 
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_902897287 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_244452797 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1529034209 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1529034209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1529034209;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.576 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        
        
    }

    
}

