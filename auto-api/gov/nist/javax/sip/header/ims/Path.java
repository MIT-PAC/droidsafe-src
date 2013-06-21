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
import gov.nist.javax.sip.header.ims.PathHeader;

public class Path extends gov.nist.javax.sip.header.AddressParametersHeader implements PathHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.633 -0400", hash_original_method = "1A5DC98D9C587097429AD2D82BB7A094", hash_generated_method = "F401750ADFDCB017C037ACB022E3E6F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.633 -0400", hash_original_method = "1037FC87002CAE3F016A3DA3F4CF1390", hash_generated_method = "6BA54447352AEF48A71AC6B629E6A91B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Path() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.633 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "82BB4983C31E5C15A199E73500867F1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1084370553 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_82172464 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_396666844 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_427405483 = (retval.toString());
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
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.633 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

