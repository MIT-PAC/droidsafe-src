package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.javax.sip.address.AddressImpl;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.857 -0400", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "895B7864473D22CB612ECFF8E800F936")
    public  ReferTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.858 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "ABC930666767785C8A85B63DE79D0189")
    protected String encodeBody() {
        if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1385478608 =         null;
        var540C13E9E156B687226421B24F2DF178_1385478608.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1385478608;
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
String varF9E19AD6135C970F387F77C6F3DE4477_306557467 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_306557467.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_306557467;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.858 -0400", hash_original_field = "9E7B615A154FC45BB1B1F6461C751642", hash_generated_field = "F4CFDA8E2513677F950180F2D0A8DF68")

    private static final long serialVersionUID = -1666700428440034851L;
}

