package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;

public final class ReferTo extends AddressParametersHeader implements javax.sip.header.ReferToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.838 -0400", hash_original_method = "3600BA21C1DE3615470645CB07A3B945", hash_generated_method = "895B7864473D22CB612ECFF8E800F936")
    public  ReferTo() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.839 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "8BE28CA6C76DEEB4B3E08245DF08679E")
    protected String encodeBody() {
    if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1170949050 =         null;
        var540C13E9E156B687226421B24F2DF178_1170949050.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1170949050;
        }
        String retval = "";
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval += LESS_THAN;
        } 
        retval += address.encode();
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval += GREATER_THAN;
        } 
    if(!parameters.isEmpty())        
        {
            retval += SEMICOLON + parameters.encode();
        } 
String varF9E19AD6135C970F387F77C6F3DE4477_857170727 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_857170727.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_857170727;
        
        
            
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.839 -0400", hash_original_field = "9E7B615A154FC45BB1B1F6461C751642", hash_generated_field = "F4CFDA8E2513677F950180F2D0A8DF68")

    private static final long serialVersionUID = -1666700428440034851L;
}

