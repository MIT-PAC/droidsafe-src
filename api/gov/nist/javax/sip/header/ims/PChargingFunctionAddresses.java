package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.sip.header.ExtensionHeader;

public class PChargingFunctionAddresses extends gov.nist.javax.sip.header.ParametersHeader implements PChargingFunctionAddressesHeader, SIPHeaderNamesIms, ExtensionHeader {

    // TODO: serialVersionUID

    /**
     * Defaul Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.501 -0500", hash_original_method = "8D7038EECA0B07E6CABE7C4563FEE1B0", hash_generated_method = "97630B1F07A042D4DB456E7449447A07")
    
public PChargingFunctionAddresses() {

        super(P_CHARGING_FUNCTION_ADDRESSES);
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.ParametersHeader#encodeBody()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.504 -0500", hash_original_method = "B754CD465EC1221F70524778BEB24E59", hash_generated_method = "0D8CD1DFC338CFF567B92C8951BDD5B4")
    
protected String encodeBody() {

        StringBuffer encoding = new StringBuffer();

        // issued by Miguel Freitas
        if (!duplicates.isEmpty())
        {
            encoding.append(duplicates.encode());
        }

        return encoding.toString();

    }

    /**
     * <p>Set the Charging Collection Function (CCF) Address</p>
     *
     * @param ccfAddress - the address to set in the CCF parameter
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.508 -0500", hash_original_method = "04146A3594153EB2EF0E88997B90AD38", hash_generated_method = "C700A3AD4CD92E6DEBD6737A1995ACE4")
    
public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {

        if (ccfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");

       // setParameter(ParameterNamesIms.CCF, ccfAddress);
        setMultiParameter(ParameterNamesIms.CCF, ccfAddress);

    }

    /**
     * <p>Add another Charging Collection Function (CCF) Address to this header</p>
     *
     * @param ccfAddress - the address to set in the CCF parameter
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.511 -0500", hash_original_method = "4EBC089EFA4A412FF008399341976E93", hash_generated_method = "9DB37741C3C76B607492F3B78C073BA3")
    
public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {

        if (ccfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");

        this.parameters.set(ParameterNamesIms.CCF, ccfAddress);

    }

    /**
     * <p>Remove a Charging Collection Function (CCF) Address set in this header</p>
     *
     * @param ccfAddress - the address in the CCF parameter to remove
     * @throws ParseException if the address was not removed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.515 -0500", hash_original_method = "E4304895721C991E07562D8775709E0E", hash_generated_method = "4DEA8A7D31FCA622334591A054AF24E7")
    
public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {

        if (ccfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");

        if(!this.delete(ccfAddress, ParameterNamesIms.CCF)) {

            throw new ParseException("CCF Address Not Removed",0);

        }

    }

    /**
     * <p>Get all the Charging Collection Function (CCF) Addresses set in this header</p>
     *
     * @return ListIterator that constains all CCF addresses of this header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.519 -0500", hash_original_method = "3FA3BC1EE35C4A614E59F8D80CF072BA", hash_generated_method = "AFC032E688605C4C14805F458A686D07")
    
public ListIterator getChargingCollectionFunctionAddresses() {

        Iterator li = this.parameters.iterator();
        LinkedList ccfLIST = new LinkedList();
        NameValue nv;
        while (li.hasNext()) {
            nv = (NameValue) li.next();
            if (nv.getName().equalsIgnoreCase(ParameterNamesIms.CCF)) {

                NameValue ccfNV = new NameValue();

                ccfNV.setName(nv.getName());
                ccfNV.setValueAsObject(nv.getValueAsObject());

                ccfLIST.add(ccfNV);

            }
        }

        return ccfLIST.listIterator();
    }

    /**
     * <p>Set the Event Charging Function (ECF) Address</p>
     *
     * @param ecfAddress - the address to set in the ECF parameter
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.522 -0500", hash_original_method = "E0FB708D70424943E5DFB76554EEFAC9", hash_generated_method = "6F808E4ECFAF495ADBC0E2678B1E7E9E")
    
public void setEventChargingFunctionAddress(String ecfAddress) throws ParseException {

        if (ecfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");

        setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
       // setParameter(ParameterNamesIms.ECF, ecfAddress);

    }

    /**
     * <p>Add another Event Charging Function (ECF) Address to this header</p>
     *
     * @param ecfAddress - the address to set in the ECF parameter
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.525 -0500", hash_original_method = "A5F62C761E9F9A46D1D6185CEC65084F", hash_generated_method = "E40F5F22E972A72C70D03CD93ED05067")
    
public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException {

        if (ecfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");

        this.parameters.set(ParameterNamesIms.ECF, ecfAddress);

    }

    /**
     * <p>Remove a Event Charging Function (ECF) Address set in this header</p>
     *
     * @param ecfAddress - the address in the ECF parameter to remove
     * @throws ParseException if the address was not removed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.529 -0500", hash_original_method = "55FFD36C944B472AFBDD2C5B98B03BCA", hash_generated_method = "31B8408597A4DC1E734B781A9374793B")
    
public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException {

        if (ecfAddress == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");

        if(!this.delete(ecfAddress, ParameterNamesIms.ECF)) {

            throw new java.text.ParseException("ECF Address Not Removed",0);

        }

    }

    /**
     * <p>Get all the Event Charging Function (ECF) Addresses set in this header</p>
     *
     * @return ListIterator that constains all CCF addresses of this header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.533 -0500", hash_original_method = "1CFCD9DC9A311745B4AD8E988ADAF97A", hash_generated_method = "53F0AE1C267060557FBA77960B0D35E1")
    
public ListIterator<NameValue> getEventChargingFunctionAddresses() {

    	LinkedList<NameValue> listw = new LinkedList<NameValue>();
   
        Iterator li = this.parameters.iterator();
        ListIterator<NameValue> ecfLIST = listw.listIterator();
        NameValue nv;
        boolean removed = false;
        while (li.hasNext()) {
            nv = (NameValue) li.next();
            if (nv.getName().equalsIgnoreCase(ParameterNamesIms.ECF)) {

                NameValue ecfNV = new NameValue();

                ecfNV.setName(nv.getName());
                ecfNV.setValueAsObject(nv.getValueAsObject());

                ecfLIST.add(ecfNV);

            }
        }

        return ecfLIST;
    }

    /**
     * <p>Remove parameter </p>
     *
     * @param value - of the parameter
     * @param name - of the parameter
     * @return true if parameter was removed, and false if not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.537 -0500", hash_original_method = "CC3F97A616116EB8BC182A6988C81981", hash_generated_method = "617B242448321408D09B83A0C2142957")
    
public boolean delete(String value, String name) {
        Iterator li = this.parameters.iterator();
        NameValue nv;
        boolean removed = false;
        while (li.hasNext()) {
            nv = (NameValue) li.next();
            if (((String) nv.getValueAsObject()).equalsIgnoreCase(value) && nv.getName().equalsIgnoreCase(name)) {
                li.remove();
                removed = true;
            }
        }

        return removed;

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.540 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException ( value,0);

    }
    
}

