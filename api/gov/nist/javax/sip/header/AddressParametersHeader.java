package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.address.*;
import javax.sip.header.FromHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;
import gov.nist.javax.sip.address.*;

public abstract class AddressParametersHeader extends ParametersHeader implements Parameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.711 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "50232C7D5628BA6D2DA2D4A79905A12A")

    protected AddressImpl address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.711 -0400", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "F54EE8FA70CA0B8B70E354AD7FA7161D")
    protected  AddressParametersHeader(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.712 -0400", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "331BA800AAEF831082C717652B31761C")
    protected  AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
        addTaint(sync);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.712 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "DE98070BE4B7EF4B9422A842827CE616")
    public Address getAddress() {
Address var814577DDD37BAFB17E08CBEFDB411BAE_1547623709 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1547623709.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1547623709;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.712 -0400", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "114975CEFB9215316F16FA0E0D004896")
    public void setAddress(Address address) {
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.713 -0400", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "815C39D9359ED7F5D7743EA12C535153")
    public Object clone() {
        AddressParametersHeader retval = (AddressParametersHeader) super.clone();
    if(this.address != null)        
        retval.address = (AddressImpl) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1414399860 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1414399860.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1414399860;
        // ---------- Original Method ----------
        //AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.713 -0400", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "A106DAB13FB8B23DFB99F45AE11024F0")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_154235656 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282912130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282912130;
        }
    if(other instanceof HeaderAddress && other instanceof Parameters)        
        {
            final HeaderAddress o = (HeaderAddress) other;
            boolean var825F75B5662FA898282EA146A00D80EB_1620493056 = (this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145251394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_145251394;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_320836657 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776872003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776872003;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof HeaderAddress && other instanceof Parameters) {
            //final HeaderAddress o = (HeaderAddress) other;
            //return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );
        //}
        //return false;
    }

    
}

