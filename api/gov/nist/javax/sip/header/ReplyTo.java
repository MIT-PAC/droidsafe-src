package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;

public final class ReplyTo extends AddressParametersHeader implements ReplyToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.848 -0400", hash_original_method = "39A6C3CE738448740A75D288CF2B6517", hash_generated_method = "9351E959CBBABCA53952EE7B443BEEAE")
    public  ReplyTo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.849 -0400", hash_original_method = "FAB557ADCBC2DA51C11496316EFDCBFF", hash_generated_method = "EA33CECA8A42005784BBAB1C45EBA527")
    public  ReplyTo(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.849 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "C1D1B84B22271AD67224109DA1C3128D")
    public String encode() {
String var4D54AC96FDD6E716CB6C2C0211520077_1042412667 =         headerName + COLON + SP + encodeBody() + NEWLINE;
        var4D54AC96FDD6E716CB6C2C0211520077_1042412667.addTaint(taint);
        return var4D54AC96FDD6E716CB6C2C0211520077_1042412667;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.850 -0400", hash_original_method = "248CC4EEE70871BA210925CAD15B2704", hash_generated_method = "E2DFEB02D31D563B1EFDEC447F69C81C")
    public String encodeBody() {
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
String varF9E19AD6135C970F387F77C6F3DE4477_705683990 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_705683990.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_705683990;
        // ---------- Original Method ----------
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.850 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "72119DBAD6467C2F0F69C30D51198ED5")
    public HostPort getHostPort() {
HostPort var7605DBE171E4A11D1CF5181991039C28_106417094 =         address.getHostPort();
        var7605DBE171E4A11D1CF5181991039C28_106417094.addTaint(taint);
        return var7605DBE171E4A11D1CF5181991039C28_106417094;
        // ---------- Original Method ----------
        //return address.getHostPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.851 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "F532D52762240A272BFDA68B4BB7400C")
    public String getDisplayName() {
String var2D47464FECA9E570B1B7C27512E620BD_1212219772 =         address.getDisplayName();
        var2D47464FECA9E570B1B7C27512E620BD_1212219772.addTaint(taint);
        return var2D47464FECA9E570B1B7C27512E620BD_1212219772;
        // ---------- Original Method ----------
        //return address.getDisplayName();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.851 -0400", hash_original_field = "90C22B20F9F107B1942A4AAE75CB93E1", hash_generated_field = "236E3B2333C15B09CBC94B2F5B379AB6")

    private static final long serialVersionUID = -9103698729465531373L;
}

