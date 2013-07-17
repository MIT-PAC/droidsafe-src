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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.698 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "50232C7D5628BA6D2DA2D4A79905A12A")

    protected AddressImpl address;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.698 -0400", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "F54EE8FA70CA0B8B70E354AD7FA7161D")
    protected  AddressParametersHeader(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.698 -0400", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "331BA800AAEF831082C717652B31761C")
    protected  AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
        addTaint(sync);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.699 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "8543242CD7140D2BC060D437982B0DF2")
    public Address getAddress() {
Address var814577DDD37BAFB17E08CBEFDB411BAE_2000272912 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_2000272912.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_2000272912;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.699 -0400", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "114975CEFB9215316F16FA0E0D004896")
    public void setAddress(Address address) {
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.699 -0400", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "ED101468A9F05E507CD4B782608AD607")
    public Object clone() {
        AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        if(this.address != null)        
        retval.address = (AddressImpl) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_522430559 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_522430559.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_522430559;
        // ---------- Original Method ----------
        //AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.700 -0400", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "1344E1C0C23F6F2FCFA257C63FB2DA98")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1924966882 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819313331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819313331;
        }
        if(other instanceof HeaderAddress && other instanceof Parameters)        
        {
            final HeaderAddress o = (HeaderAddress) other;
            boolean var825F75B5662FA898282EA146A00D80EB_556123255 = (this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141112784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141112784;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_575951387 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596222061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_596222061;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof HeaderAddress && other instanceof Parameters) {
            //final HeaderAddress o = (HeaderAddress) other;
            //return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );
        //}
        //return false;
    }

    
}

