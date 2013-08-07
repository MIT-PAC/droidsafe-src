package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.ListIterator;

import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PChargingFunctionAddressesHeader extends Parameters, Header {

    
    public final static String NAME = "P-Charging-Function-Addresses";


    
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;

    
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;

    
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException;

    
    public ListIterator getChargingCollectionFunctionAddresses();

    
    public void setEventChargingFunctionAddress(String ecfAddress)throws ParseException;

    
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException;

    
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException;

    
    public ListIterator getEventChargingFunctionAddresses();

}
