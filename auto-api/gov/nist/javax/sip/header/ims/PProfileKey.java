package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;
import javax.sip.header.ExtensionHeader;

public class PProfileKey extends AddressParametersHeader implements PProfileKeyHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.603 -0400", hash_original_method = "62A39FCB1E97FABE3CE56B88DF28D500", hash_generated_method = "6CF76ED268EA92EBF0466748DD23DF23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PProfileKey( ) {
        super(P_PROFILE_KEY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.603 -0400", hash_original_method = "0A29E597AFEA61D9850CF327C87E8DD7", hash_generated_method = "EBC98E876453A7A5C000485BB43C1D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PProfileKey(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.603 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "73132D064AE4B19768404B5810C720D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1971756165 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1572830721 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1087817260 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1987425937 = (retval.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.603 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.603 -0400", hash_original_method = "9C9266054F44A0CD7DB49784A3A7D69D", hash_generated_method = "A74C5A8F9BDFE61D624277CD3F7E80E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varCA4B4D302580B6347E8C5820870B3AF3_1508486345 = ((other instanceof PProfileKey) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof PProfileKey) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.604 -0400", hash_original_method = "38197786CF7CEF8229067A4B5205EC8C", hash_generated_method = "E1F900629DBB91A64AFCDD3BA0491C85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PProfileKey retval;
        retval = (PProfileKey) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PProfileKey retval = (PProfileKey) super.clone();
        //return retval;
    }

    
}

