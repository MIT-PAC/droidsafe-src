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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.340 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    public  PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.341 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "9F672CEE53A14D48B4D185D3B5A9DF3B")
    public  PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.341 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "E475E1D8CB64581A77C13BB28429ADD1")
    public  PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //this.address = new AddressImpl();
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.343 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "CF05565D77A890E2C238CCFFF95F7285")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1686431714 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_782193518 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_415289863 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1279750780 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1686431714 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1686431714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1686431714;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.343 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "E3926A9A8F0CF2581F06840FEC55A697")
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        this.address.setURI(associatedURI);
        addTaint(associatedURI.getTaint());
        // ---------- Original Method ----------
        //if (associatedURI == null)
            //throw new NullPointerException("null URI");
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.357 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "EA4CA2370E833A4A942E6B790F799D93")
    public URI getAssociatedURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_2076200924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2076200924 = this.address.getURI();
        varB4EAC82CA7396A68D541C85D26508E83_2076200924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2076200924;
        // ---------- Original Method ----------
        //return this.address.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.367 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "7E443B069DA88457F4CCFCA3C93C0ED0")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1553498702 = null; //Variable for return #1
        PAssociatedURI retval;
        retval = (PAssociatedURI) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1553498702 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1553498702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1553498702;
        // ---------- Original Method ----------
        //PAssociatedURI retval = (PAssociatedURI) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.368 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

