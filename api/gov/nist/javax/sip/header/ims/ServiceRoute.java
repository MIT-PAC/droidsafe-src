package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import gov.nist.javax.sip.address.AddressImpl;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSGenerator;

public class ServiceRoute extends gov.nist.javax.sip.header.AddressParametersHeader implements ServiceRouteHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.506 -0400", hash_original_method = "9637595E6ECE05066933FE4B9C7C7011", hash_generated_method = "D6D1AF7E19CF1EF04536E499E39ECF7A")
    public  ServiceRoute(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.507 -0400", hash_original_method = "DFE1A15880B80307A8195E7AA915629C", hash_generated_method = "6DF26201368D44BF3E02DEA232CD4D93")
    public  ServiceRoute() {
        super(SERVICE_ROUTE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.508 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "282BD58F5B4CE2AC990B3C417F0F3FE3")
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
        if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_1538710250 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1538710250.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1538710250;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(LESS_THAN);
        //}
        //retval.append(address.encode());
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(GREATER_THAN);
        //}
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.509 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "E6F1C2344B61785890DE470D00E02512")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1851179981 = new ParseException (value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1851179981.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1851179981;
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
}

