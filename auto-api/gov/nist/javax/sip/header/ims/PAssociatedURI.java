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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.556 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.556 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "902F8C0A35D9766C3F9BB1F3A4ABE517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.556 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "674AC44E8F75FAA286A24A368E820299")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        dsTaint.addTaint(associatedURI.dsTaint);
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        // ---------- Original Method ----------
        //this.address = new AddressImpl();
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.556 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "A6209D9D6C240D2EC2D71911B1A82F4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_617265879 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_988760270 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_993228904 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_790683896 = (retval.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.557 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "63FFD59D500AE56D5DA3B0CE3109A6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        dsTaint.addTaint(associatedURI.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        this.address.setURI(associatedURI);
        // ---------- Original Method ----------
        //if (associatedURI == null)
            //throw new NullPointerException("null URI");
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.557 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "76A20629659FCF1A44F47DD853077B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI getAssociatedURI() {
        URI var243C4F8453239471B867DBE9FF92ADC7_912405324 = (this.address.getURI());
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.address.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.557 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "A93BCD87C07FD19D7E828946AEFEDB31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAssociatedURI retval;
        retval = (PAssociatedURI) super.clone();
        retval.address = (AddressImpl) this.address.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssociatedURI retval = (PAssociatedURI) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.557 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

