package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;
import javax.sip.address.URI;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ims.PAssociatedURIHeader;

public class PAssociatedURI extends gov.nist.javax.sip.header.AddressParametersHeader implements PAssociatedURIHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.905 -0400", hash_original_method = "0CE9AC4DACE0AF9EAE08E4894C346C94", hash_generated_method = "E89CFA99CD3013AEEE12279CD13FCD79")
    public  PAssociatedURI() {
        super(PAssociatedURIHeader.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.905 -0400", hash_original_method = "23DD9D121A8A941629D341729647359A", hash_generated_method = "60201E23D7BC50CAED05486D01E59593")
    public  PAssociatedURI(AddressImpl address) {
        super(PAssociatedURIHeader.NAME);
        addTaint(address.getTaint());
        this.address = address;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.906 -0400", hash_original_method = "BEC6817E399EBD6982FBF2F710E24F3F", hash_generated_method = "F7EEAA2D2604C2E77936BF678270B94C")
    public  PAssociatedURI(GenericURI associatedURI) {
        super(PAssociatedURIHeader.NAME);
        addTaint(associatedURI.getTaint());
        this.address = new AddressImpl();
        this.address.setURI(associatedURI);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.906 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "5CC0F8FBA1FC29F6E0E26B9B60D1235D")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(LESS_THAN);
        } 
        retval.append(address.encode());
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(GREATER_THAN);
        } 
    if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_1258756981 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1258756981.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1258756981;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.907 -0400", hash_original_method = "BCB734BB1E91EA14E0E35E6B88E7C93B", hash_generated_method = "5333FF1EB58FF11D3D8D38D779BB3D17")
    public void setAssociatedURI(URI associatedURI) throws NullPointerException {
        addTaint(associatedURI.getTaint());
    if(associatedURI == null)        
        {
        NullPointerException varCC2B4CF1D5C3A06C7F71134B2649E466_2111216601 = new NullPointerException("null URI");
        varCC2B4CF1D5C3A06C7F71134B2649E466_2111216601.addTaint(taint);
        throw varCC2B4CF1D5C3A06C7F71134B2649E466_2111216601;
        }
        this.address.setURI(associatedURI);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.907 -0400", hash_original_method = "D8B52B7CB92D047EA9436CA55D36407D", hash_generated_method = "0B2B8D8253D74AA044836F0C460D8035")
    public URI getAssociatedURI() {
URI var90C92A89BE51D95AD79F613CFDD811DA_2120693804 =         this.address.getURI();
        var90C92A89BE51D95AD79F613CFDD811DA_2120693804.addTaint(taint);
        return var90C92A89BE51D95AD79F613CFDD811DA_2120693804;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.907 -0400", hash_original_method = "58EA9D2DAC0517F3416AFEEB738C5473", hash_generated_method = "D36E9D0B6DCD6653B1029D19138194B6")
    public Object clone() {
        PAssociatedURI retval = (PAssociatedURI) super.clone();
    if(this.address != null)        
        retval.address = (AddressImpl) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_462449601 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_462449601.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_462449601;
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.908 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "C4D494FF4E1562F99E4919E324CC20AE")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1286095329 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1286095329.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1286095329;
        
        
    }

    
}

