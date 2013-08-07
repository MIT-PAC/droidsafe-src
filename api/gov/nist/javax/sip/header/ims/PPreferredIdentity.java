package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;



public class PPreferredIdentity extends AddressParametersHeader implements PPreferredIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.219 -0400", hash_original_method = "A7A18C7C290144143F0B066F971631B8", hash_generated_method = "33752445ADEA2817EC2F9458F7206A79")
    public  PPreferredIdentity(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.219 -0400", hash_original_method = "87907696BDC4EF5B0ECA8FC9DCAB5991", hash_generated_method = "FB7E20AB3A4056E3089E535CEABCA3D3")
    public  PPreferredIdentity() {
        super(P_PREFERRED_IDENTITY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.220 -0400", hash_original_method = "2167C0D1D3C772E3CF273B6DCAFE6265", hash_generated_method = "5B8FAA5416108974F58245BF55733D06")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(LESS_THAN);
        } //End block
        retval.append(address.encode());
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(GREATER_THAN);
        } //End block
String var1B324365A764C077A55854483509F4AB_310317996 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_310317996.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_310317996;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(LESS_THAN);
        //}
        //retval.append(address.encode());
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(GREATER_THAN);
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.221 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "02AF6028ABE40254D313B0E984537BF8")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1463993487 = new ParseException (value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1463993487.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1463993487;
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
}

