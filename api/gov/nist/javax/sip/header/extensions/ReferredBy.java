package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public final class ReferredBy extends AddressParametersHeader implements ExtensionHeader, ReferredByHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.905 -0400", hash_original_method = "C3DEC8F418CE8BBD8D4ED1D7A2F51A12", hash_generated_method = "44B60B9435122CE6D895DDF9A9B319C3")
    public  ReferredBy() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.906 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "BEECE6B15183A89E4FDA16E2D01DF4E0")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1819624200 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1819624200.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1819624200;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.908 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "E95A37985A465C81CC4D7627590F055D")
    protected String encodeBody() {
        if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1404885404 =         null;
        var540C13E9E156B687226421B24F2DF178_1404885404.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1404885404;
        }
        String retval = "";
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval += LESS_THAN;
        } //End block
        retval += address.encode();
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval += GREATER_THAN;
        } //End block
        if(!parameters.isEmpty())        
        {
            retval += SEMICOLON + parameters.encode();
        } //End block
String varF9E19AD6135C970F387F77C6F3DE4477_1850382424 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1850382424.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1850382424;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //String retval = "";
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval += LESS_THAN;
        //}
        //retval += address.encode();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval += GREATER_THAN;
        //}
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.908 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.908 -0400", hash_original_field = "2B901D53AC9F4437C27DC11F24B6E7E9", hash_generated_field = "BAA3173ECCDDFD8B4EF4E90187540A3C")

    public static final String NAME = "Referred-By";
}

