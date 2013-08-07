package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

import javax.sip.address.URI;
import javax.sip.header.ExtensionHeader;



public class PAssociatedURI extends gov.nist.javax.sip.header.AddressParametersHeader implements PAssociatedURIHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.104 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    public  PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.104 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "60201E23D7BC50CAED05486D01E59593")
    public  PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.105 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "F7EEAA2D2604C2E77936BF678270B94C")
    public  PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        addTaint(associatedURI.getTaint());
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        // ---------- Original Method ----------
        //this.address = new AddressImpl();
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.106 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "EF423B8FEF77E01CBAEC31EBED8A2CA7")
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
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_130213149 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_130213149.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_130213149;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.107 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "3276BF96C686601FC6D3781F90F4CF1D")
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        addTaint(associatedURI.getTaint());
        if(associatedURI == null)        
        {
        NullPointerException varCC2B4CF1D5C3A06C7F71134B2649E466_912592110 = new NullPointerException("null URI");
        varCC2B4CF1D5C3A06C7F71134B2649E466_912592110.addTaint(taint);
        throw varCC2B4CF1D5C3A06C7F71134B2649E466_912592110;
        }
        this.address.setURI(associatedURI);
        // ---------- Original Method ----------
        //if (associatedURI == null)
            //throw new NullPointerException("null URI");
        //this.address.setURI(associatedURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.107 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "1C832F7C3860F9837FD89E56DE2681AC")
    public URI getAssociatedURI() {
URI var90C92A89BE51D95AD79F613CFDD811DA_1237841535 =         this.address.getURI();
        var90C92A89BE51D95AD79F613CFDD811DA_1237841535.addTaint(taint);
        return var90C92A89BE51D95AD79F613CFDD811DA_1237841535;
        // ---------- Original Method ----------
        //return this.address.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.108 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "C2A06663C2E200D9BF653BC159383B75")
    public Object clone() {
        PAssociatedURI retval = (PAssociatedURI) super.clone();
        if(this.address != null)        
        retval.address = (AddressImpl) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_780025759 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_780025759.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_780025759;
        // ---------- Original Method ----------
        //PAssociatedURI retval = (PAssociatedURI) super.clone();
        //if (this.address != null)
            //retval.address = (AddressImpl) this.address.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.108 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "71BF81AE11706B391B41A25AC9A37C9B")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_68907944 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_68907944.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_68907944;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

