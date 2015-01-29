package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.ListIterator;

import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PChargingFunctionAddressesHeader extends Parameters, Header {
    
    public final static String NAME = "P-Charging-Function-Addresses";
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ListIterator getChargingCollectionFunctionAddresses();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setEventChargingFunctionAddress(String ecfAddress)throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ListIterator getEventChargingFunctionAddresses();

}
