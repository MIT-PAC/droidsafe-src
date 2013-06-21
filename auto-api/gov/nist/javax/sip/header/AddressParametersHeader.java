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
    protected AddressImpl address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.654 -0400", hash_original_method = "86C06714D64ED7D78AC32A4EA648ACC6", hash_generated_method = "5734E80F27C2231D0E139096F101A3CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AddressParametersHeader(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.654 -0400", hash_original_method = "18F0A32F1016A1077EE2441198C172CD", hash_generated_method = "B241534D3E1077FE78ADFE947B738789")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AddressParametersHeader(String name, boolean sync) {
        super(name,sync);
        dsTaint.addTaint(sync);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.654 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "81C8979A4D6DB0ABC4C18B41D0F67A43")
    @DSModeled(DSC.SAFE)
    public Address getAddress() {
        return (Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.655 -0400", hash_original_method = "AAE5DCDD86A2817DB3BE7BA0761992E2", hash_generated_method = "E88E5FDF6EA5B3635B347F8209A6E80E")
    @DSModeled(DSC.SAFE)
    public void setAddress(Address address) {
        dsTaint.addTaint(address.dsTaint);
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.655 -0400", hash_original_method = "0CBC2CD54CDD43105BA83DF4459B73A7", hash_generated_method = "F1CF2E8616DCA1FADBFBF98C6E97583C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AddressParametersHeader retval;
        retval = (AddressParametersHeader) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AddressParametersHeader retval = (AddressParametersHeader) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.655 -0400", hash_original_method = "432CD1C0278E1FF82C91D27AB1E82A92", hash_generated_method = "1136F30038CFFE1D1C77D7A7CF91B434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            HeaderAddress o;
            o = (HeaderAddress) other;
            boolean var7668DC229A5E6050701A9527291D931A_979307101 = (this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof HeaderAddress && other instanceof Parameters) {
            //final HeaderAddress o = (HeaderAddress) other;
            //return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );
        //}
        //return false;
    }

    
}

