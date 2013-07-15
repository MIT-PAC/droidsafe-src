package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.021 -0400", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "895B7864473D22CB612ECFF8E800F936")
    public  ReferTo() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.022 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "580F846DDEA6F6D40C68CA1F17F89F3D")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1567780849 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_576873796 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1567780849 = null;
        String retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_135772934 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } 
        } 
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1785567871 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1485757184 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_576873796 = retval;
        String varA7E53CE21691AB073D9660D615818899_1351123652; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1351123652 = varB4EAC82CA7396A68D541C85D26508E83_1567780849;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1351123652 = varB4EAC82CA7396A68D541C85D26508E83_576873796;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1351123652.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1351123652;
        
        
            
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.022 -0400", hash_original_field = "9E7B615A154FC45BB1B1F6461C751642", hash_generated_field = "F4CFDA8E2513677F950180F2D0A8DF68")

    private static final long serialVersionUID = -1666700428440034851L;
}

