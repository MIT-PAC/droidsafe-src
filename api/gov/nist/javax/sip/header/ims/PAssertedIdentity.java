package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PAssertedIdentity extends AddressParametersHeader implements PAssertedIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.851 -0400", hash_original_method = "4DB521A98546EC6C210A063C8DC8A3AB", hash_generated_method = "A652C0AFAB26596C9FECBC96D5E19D4F")
    public  PAssertedIdentity(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.852 -0400", hash_original_method = "7A9E6607376C61D3870CDBD630C80B00", hash_generated_method = "44DEFC0ABC6FF74FF8AD15DA6F9C8AD2")
    public  PAssertedIdentity() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.852 -0400", hash_original_method = "A02034091310C74B28639EFAE9360C33", hash_generated_method = "3E6AA694F90480600E612CB99A5A74E1")
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
        retval.append(COMMA + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_1344736507 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1344736507.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1344736507;
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
            //retval.append(COMMA + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.852 -0400", hash_original_method = "0E5911CB2B858F97AB1667F7876EAA3E", hash_generated_method = "312406F233B341F93DC656277E7FB239")
    public Object clone() {
        PAssertedIdentity retval = (PAssertedIdentity) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1562491065 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1562491065.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1562491065;
        // ---------- Original Method ----------
        //PAssertedIdentity retval = (PAssertedIdentity) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.853 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "AEA4089C80FE2EBDE37A87E58BDA2B43")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_203237098 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_203237098.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_203237098;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

