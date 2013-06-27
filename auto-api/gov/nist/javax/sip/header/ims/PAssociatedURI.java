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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.218 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    public  PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.218 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "9F672CEE53A14D48B4D185D3B5A9DF3B")
    public  PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.218 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "E475E1D8CB64581A77C13BB28429ADD1")
    public  PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //this.address = new AddressImpl();
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.230 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "0EC19D24EA51EAAAAB2878C60AE84F30")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1401571425 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1570158439 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_889884675 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1596084068 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1401571425 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1401571425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1401571425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.230 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "E3926A9A8F0CF2581F06840FEC55A697")
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //if (associatedURI == null)
            //throw new NullPointerException("null URI");
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.231 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "E512D942EB1B55FAE9A6BB8EE1EC3F97")
    public URI getAssociatedURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1013495667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013495667 = this.address.getURI();
        varB4EAC82CA7396A68D541C85D26508E83_1013495667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013495667;
        // ---------- Original Method ----------
        //return this.address.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.237 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "2D2FF1C5ACE5D5DEF02CE57BFC17E655")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1018073735 = null; //Variable for return #1
        PAssociatedURI retval;
        retval = (PAssociatedURI) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1018073735 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1018073735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018073735;
        // ---------- Original Method ----------
        //PAssociatedURI retval = (PAssociatedURI) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.237 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

