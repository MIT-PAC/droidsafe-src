package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PAssertedIdentity extends AddressParametersHeader implements PAssertedIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.170 -0400", hash_original_method = "4DB521A98546EC6C210A063C8DC8A3AB", hash_generated_method = "ECDE4F5491B010A785DC78B96DCB82B0")
    public  PAssertedIdentity(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.170 -0400", hash_original_method = "7A9E6607376C61D3870CDBD630C80B00", hash_generated_method = "44DEFC0ABC6FF74FF8AD15DA6F9C8AD2")
    public  PAssertedIdentity() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.171 -0400", hash_original_method = "A02034091310C74B28639EFAE9360C33", hash_generated_method = "0EBE36535739E3B078B4A9D2135F4249")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_625275685 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1692057557 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } 
        } 
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1850930941 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_611210008 = (!parameters.isEmpty());
            retval.append(COMMA + this.parameters.encode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_625275685 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_625275685.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_625275685;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.172 -0400", hash_original_method = "0E5911CB2B858F97AB1667F7876EAA3E", hash_generated_method = "D6AF4BF006A37AC0E77F716D69C708D8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_947788038 = null; 
        PAssertedIdentity retval = (PAssertedIdentity) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_947788038 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_947788038.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_947788038;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.172 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
}

