package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.007 -0400", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "5CA1E44B9A2B6369A9863F92BA224A33")
    public  RecordRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.007 -0400", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "6E15848E792F6F3E30F683E515F8A47E")
    public  RecordRoute() {
        super(RECORD_ROUTE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.008 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "4BD150B0B693288B4693BE02A2556384")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1683174307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1683174307 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1683174307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1683174307;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.009 -0400", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "1272DEBB8F39134D47D3C69A57B49DED")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_327490979 = null; 
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_122476554 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(LESS_THAN);
            } 
        } 
        address.encode(buffer);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1575385121 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(GREATER_THAN);
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_272900810 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_327490979 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_327490979.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_327490979;
        
        
            
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.009 -0400", hash_original_field = "E32A96EEC9EC8C8193321B9247FF1E9B", hash_generated_field = "E1824FFE4050EC4E12856745910C83B9")

    private static final long serialVersionUID = 2388023364181727205L;
}

