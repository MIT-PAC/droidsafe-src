package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PAssertedIdentity extends AddressParametersHeader implements PAssertedIdentityHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.542 -0400", hash_original_method = "4DB521A98546EC6C210A063C8DC8A3AB", hash_generated_method = "2ABBDAC614E9DAF77F684B5D14D90D87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedIdentity(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.542 -0400", hash_original_method = "7A9E6607376C61D3870CDBD630C80B00", hash_generated_method = "44DEFC0ABC6FF74FF8AD15DA6F9C8AD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedIdentity() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.543 -0400", hash_original_method = "A02034091310C74B28639EFAE9360C33", hash_generated_method = "6585C787530BD966A3B6F7A35820C4DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_203683358 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_485173556 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1861729342 = (!parameters.isEmpty());
            retval.append(COMMA + this.parameters.encode());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_485124078 = (retval.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.543 -0400", hash_original_method = "0E5911CB2B858F97AB1667F7876EAA3E", hash_generated_method = "15C7E051314CE872905D978D964E9C9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAssertedIdentity retval;
        retval = (PAssertedIdentity) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssertedIdentity retval = (PAssertedIdentity) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.543 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

