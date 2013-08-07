package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;



public class Path extends gov.nist.javax.sip.header.AddressParametersHeader implements PathHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.361 -0400", hash_original_method = "1A5DC98D9C587097429AD2D82BB7A094", hash_generated_method = "9E806A6AFF9F5E8AABFBB957AB3E2305")
    public  Path(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.362 -0400", hash_original_method = "1037FC87002CAE3F016A3DA3F4CF1390", hash_generated_method = "6BA54447352AEF48A71AC6B629E6A91B")
    public  Path() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.362 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "35EE9F187B8FA6EA1138142CE69EBE2D")
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
String var1B324365A764C077A55854483509F4AB_83315632 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_83315632.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_83315632;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.363 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "CD630894187AF173382C2C9AF178FB36")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1639404163 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1639404163.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1639404163;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

