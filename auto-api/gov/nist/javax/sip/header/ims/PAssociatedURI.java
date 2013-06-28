package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;
import javax.sip.address.URI;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ims.PAssociatedURIHeader;

public class PAssociatedURI extends gov.nist.javax.sip.header.AddressParametersHeader implements PAssociatedURIHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.216 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    public  PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.217 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "9F672CEE53A14D48B4D185D3B5A9DF3B")
    public  PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.217 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "E475E1D8CB64581A77C13BB28429ADD1")
    public  PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //this.address = new AddressImpl();
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.218 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "47F9618684159B691B13BD88D5AE85EB")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1220433725 = null; //Variable for return #1
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1927484096 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_530284516 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1367028712 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1220433725 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1220433725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220433725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.218 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "E3926A9A8F0CF2581F06840FEC55A697")
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //if (associatedURI == null)
            //throw new NullPointerException("null URI");
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.219 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "25FE9986013D0684AED6D2C16894A201")
    public URI getAssociatedURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1059642165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1059642165 = this.address.getURI();
        varB4EAC82CA7396A68D541C85D26508E83_1059642165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1059642165;
        // ---------- Original Method ----------
        //return this.address.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.219 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "69EDADD54A14C207783F3EE1311B46DD")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_306645326 = null; //Variable for return #1
        PAssociatedURI retval = (PAssociatedURI) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_306645326 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_306645326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306645326;
        // ---------- Original Method ----------
        //PAssociatedURI retval = (PAssociatedURI) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.220 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

