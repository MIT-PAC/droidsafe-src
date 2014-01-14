package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

import javax.sip.address.URI;
import javax.sip.header.ExtensionHeader;

public class PAssociatedURI extends gov.nist.javax.sip.header.AddressParametersHeader implements PAssociatedURIHeader, SIPHeaderNamesIms, ExtensionHeader {
    // TODO: Need a unique UID

    /**
     * Default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.842 -0500", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "376327DCAE4A50DE63C0C1864E9666E2")
    
public PAssociatedURI()
    {
        super(PAssociatedURIHeader.NAME);
    }

    /**
     * Constructor
     * @param address to be set in the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.847 -0500", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "1C07562B3B274F046F3E1A160C5A3311")
    
public PAssociatedURI(AddressImpl address)
    {
        super(PAssociatedURIHeader.NAME);
        this.address = address;
    }

    /**
     * Constructor
     * @param associatedURI - GenericURI to be set in the address of this header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.850 -0500", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "28F000A360E5ECB6B0117A0C2450AA9C")
    
public PAssociatedURI(GenericURI associatedURI)
    {
        super(PAssociatedURIHeader.NAME);
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
    }

    /**
     * Encode into canonical form.
     * @return String containing the canonicaly encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.854 -0500", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "D16B9D80B8A3FF76F7E29D31CF350BD3")
    
public String encodeBody()
    {
        StringBuffer retval = new StringBuffer();
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(LESS_THAN);
        }
        retval.append(address.encode());
        if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            retval.append(GREATER_THAN);
        }

        if (!parameters.isEmpty())
            retval.append(SEMICOLON + this.parameters.encode());
        return retval.toString();
    }

    /**
     * <p>Set the URI on this address</p>
     * @param associatedURI - GenericURI to be set in the address of this header
     * @throws NullPointerException when supplied URI is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.857 -0500", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "4B4F117F2AE366418DAA873B4B2D28C7")
    
public void setAssociatedURI(URI associatedURI) throws NullPointerException
    {
        if (associatedURI == null)
            throw new NullPointerException("null URI");

        this.address.setURI(associatedURI);
    }

    /**
     * <p>Get the address's URI</p>
     * @return URI set in the address of this header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.860 -0500", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "A8DFFEEAB52A9C7E8B734E22C45C63EB")
    
public URI getAssociatedURI() {
        return this.address.getURI();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.863 -0500", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "0322E510B605B1362C67E8B7107DDDB0")
    
public Object clone() {
        PAssociatedURI retval = (PAssociatedURI) super.clone();
        if (this.address != null)
            retval.address = (AddressImpl) this.address.clone();
        return retval;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.867 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "163D19EF420D7A42ACC60EDFB9E60BB8")
    
public void setValue(String value) throws ParseException{
        // not implemented
        throw new ParseException(value,0);

    }
    
}

