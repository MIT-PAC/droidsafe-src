package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PPreferredIdentity extends AddressParametersHeader implements PPreferredIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.326 -0400", hash_original_method = "A7A18C7C290144143F0B066F971631B8", hash_generated_method = "9C3F701BE302C93D2275700892F28FFC")
    public  PPreferredIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.326 -0400", hash_original_method = "87907696BDC4EF5B0ECA8FC9DCAB5991", hash_generated_method = "FB7E20AB3A4056E3089E535CEABCA3D3")
    public  PPreferredIdentity() {
        super(P_PREFERRED_IDENTITY);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.327 -0400", hash_original_method = "2167C0D1D3C772E3CF273B6DCAFE6265", hash_generated_method = "9105F7A1280EEA63A5D01FB34FCC7EB6")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1396955406 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1063082778 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } 
        } 
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_59326165 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1396955406 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1396955406.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1396955406;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.328 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        
        
    }

    
}

