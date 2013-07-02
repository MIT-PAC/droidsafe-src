package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.*;
import javax.sip.header.FromHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;
import gov.nist.javax.sip.address.*;

public abstract class AddressParametersHeader extends ParametersHeader implements Parameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.857 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "50232C7D5628BA6D2DA2D4A79905A12A")

    protected AddressImpl address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.857 -0400", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "F54EE8FA70CA0B8B70E354AD7FA7161D")
    protected  AddressParametersHeader(String name) {
        super(name);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.858 -0400", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "77CAEA2097C61BEA8E51E761DAAD5783")
    protected  AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
        addTaint(name.getTaint());
        addTaint(sync);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.858 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "15F8FC3170395C816112F32B4DAD34C8")
    public Address getAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_1148285677 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1148285677 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1148285677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1148285677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.858 -0400", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "114975CEFB9215316F16FA0E0D004896")
    public void setAddress(Address address) {
        this.address = (AddressImpl) address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.859 -0400", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "8D296A1EC1CED06587EA86EA50E5FA1D")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_803576361 = null; 
        AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_803576361 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_803576361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_803576361;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.859 -0400", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "088873247A5576B8B9298D5BD966FEF2")
    public boolean equals(Object other) {
        {
            final HeaderAddress o = (HeaderAddress) other;
            boolean var7668DC229A5E6050701A9527291D931A_1915486402 = (this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447694389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447694389;
        
        
        
            
            
        
        
    }

    
}

