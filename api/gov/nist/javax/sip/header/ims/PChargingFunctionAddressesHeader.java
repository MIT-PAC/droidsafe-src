package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.NameValue;
import javax.sip.header.Header;
import javax.sip.header.Parameters;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ListIterator;

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
