package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PathHeader;

public class Path extends gov.nist.javax.sip.header.AddressParametersHeader implements PathHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.119 -0400", hash_original_method = "1A5DC98D9C587097429AD2D82BB7A094", hash_generated_method = "9E806A6AFF9F5E8AABFBB957AB3E2305")
    public  Path(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.120 -0400", hash_original_method = "1037FC87002CAE3F016A3DA3F4CF1390", hash_generated_method = "6BA54447352AEF48A71AC6B629E6A91B")
    public  Path() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.121 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "AA2B7A176C11F77EAF855676D12801E4")
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
String var1B324365A764C077A55854483509F4AB_1038337060 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1038337060.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1038337060;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.121 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "B209456B707A77EB6F2520EE48697F4A")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_2036896588 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_2036896588.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_2036896588;
        
        
    }

    
}

