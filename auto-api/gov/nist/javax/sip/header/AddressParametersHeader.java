package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.address.*;
import javax.sip.header.FromHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;
import gov.nist.javax.sip.address.*;

public abstract class AddressParametersHeader extends ParametersHeader implements Parameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.374 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "50232C7D5628BA6D2DA2D4A79905A12A")

    protected AddressImpl address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.374 -0400", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "F54EE8FA70CA0B8B70E354AD7FA7161D")
    protected  AddressParametersHeader(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.385 -0400", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "77CAEA2097C61BEA8E51E761DAAD5783")
    protected  AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
        addTaint(name.getTaint());
        addTaint(sync);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.386 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "F91F4B5D02D65308E8629DA3BBFD4572")
    public Address getAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_1331885857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1331885857 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1331885857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331885857;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.398 -0400", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "114975CEFB9215316F16FA0E0D004896")
    public void setAddress(Address address) {
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.412 -0400", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "25356A1656170442274047FCAEE92B50")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_478048371 = null; //Variable for return #1
        AddressParametersHeader retval;
        retval = (AddressParametersHeader) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_478048371 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_478048371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_478048371;
        // ---------- Original Method ----------
        //AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.414 -0400", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "4057F46CA8D0109B1740BE8142BC6F54")
    public boolean equals(Object other) {
        {
            HeaderAddress o;
            o = (HeaderAddress) other;
            boolean var7668DC229A5E6050701A9527291D931A_1629245275 = (this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453407603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453407603;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof HeaderAddress && other instanceof Parameters) {
            //final HeaderAddress o = (HeaderAddress) other;
            //return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );
        //}
        //return false;
    }

    
}

