package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.NameValue;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddressesHeader;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;

public class PChargingFunctionAddresses extends gov.nist.javax.sip.header.ParametersHeader implements PChargingFunctionAddressesHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.301 -0400", hash_original_method = "8D7038EECA0B07E6CABE7C4563FEE1B0", hash_generated_method = "85C85690ED146B961192627A81D00D75")
    public  PChargingFunctionAddresses() {
        super(P_CHARGING_FUNCTION_ADDRESSES);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.302 -0400", hash_original_method = "B754CD465EC1221F70524778BEB24E59", hash_generated_method = "CF45D24170CF94BD3F43B68E67DEA96C")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_585211690 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            boolean varE7A90190E466226C5EF9670A97EA0CF9_1158536530 = (!duplicates.isEmpty());
            {
                encoding.append(duplicates.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_585211690 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_585211690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585211690;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (!duplicates.isEmpty())
        //{
            //encoding.append(duplicates.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.303 -0400", hash_original_method = "04146A3594153EB2EF0E88997B90AD38", hash_generated_method = "5404717C39D7B2EB1AE070273B90BADA")
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
        addTaint(ccfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.303 -0400", hash_original_method = "4EBC089EFA4A412FF008399341976E93", hash_generated_method = "0061EEEB1A124F31A4E9276D91E4A08A")
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
        addTaint(ccfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.306 -0400", hash_original_method = "E4304895721C991E07562D8775709E0E", hash_generated_method = "3B62C52EFAA5EE6A4DF64448CEF1EF64")
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        {
            boolean var941269CB9D0C5CFF429DF75DE28A6639_1823725764 = (!this.delete(ccfAddress, ParameterNamesIms.CCF));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("CCF Address Not Removed",0);
            } //End block
        } //End collapsed parenthetic
        addTaint(ccfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //if(!this.delete(ccfAddress, ParameterNamesIms.CCF)) {
            //throw new ParseException("CCF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.313 -0400", hash_original_method = "3FA3BC1EE35C4A614E59F8D80CF072BA", hash_generated_method = "20B9EDDB56868AEBFF2BA8C8AA875EEF")
    public ListIterator getChargingCollectionFunctionAddresses() {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_1773460629 = null; //Variable for return #1
        Iterator li;
        li = this.parameters.iterator();
        LinkedList ccfLIST;
        ccfLIST = new LinkedList();
        NameValue nv;
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1358877349 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean var4E9900FEF739227185E928141AA0A92A_509534748 = (nv.getName().equalsIgnoreCase(ParameterNamesIms.CCF));
                    {
                        NameValue ccfNV;
                        ccfNV = new NameValue();
                        ccfNV.setName(nv.getName());
                        ccfNV.setValueAsObject(nv.getValueAsObject());
                        ccfLIST.add(ccfNV);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1773460629 = ccfLIST.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1773460629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1773460629;
        // ---------- Original Method ----------
        //Iterator li = this.parameters.iterator();
        //LinkedList ccfLIST = new LinkedList();
        //NameValue nv;
        //while (li.hasNext()) {
            //nv = (NameValue) li.next();
            //if (nv.getName().equalsIgnoreCase(ParameterNamesIms.CCF)) {
                //NameValue ccfNV = new NameValue();
                //ccfNV.setName(nv.getName());
                //ccfNV.setValueAsObject(nv.getValueAsObject());
                //ccfLIST.add(ccfNV);
            //}
        //}
        //return ccfLIST.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.332 -0400", hash_original_method = "E0FB708D70424943E5DFB76554EEFAC9", hash_generated_method = "3489CB733F8110AD4C2829B35C55E8A9")
    public void setEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
        addTaint(ecfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.332 -0400", hash_original_method = "A5F62C761E9F9A46D1D6185CEC65084F", hash_generated_method = "24030AE6A6C4212B1E8CB6106A3BF020")
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
        addTaint(ecfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.333 -0400", hash_original_method = "55FFD36C944B472AFBDD2C5B98B03BCA", hash_generated_method = "55678520871A353D52B2DA6C9A76FD0B")
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        {
            boolean varBB2E68779A5747176CB70E0C0B687523_1956996821 = (!this.delete(ecfAddress, ParameterNamesIms.ECF));
            {
                if (DroidSafeAndroidRuntime.control) throw new java.text.ParseException("ECF Address Not Removed",0);
            } //End block
        } //End collapsed parenthetic
        addTaint(ecfAddress.getTaint());
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //if(!this.delete(ecfAddress, ParameterNamesIms.ECF)) {
            //throw new java.text.ParseException("ECF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.338 -0400", hash_original_method = "1CFCD9DC9A311745B4AD8E988ADAF97A", hash_generated_method = "FF8F042CBA5D2DFD9075A3C85AE7433D")
    public ListIterator<NameValue> getEventChargingFunctionAddresses() {
        ListIterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_1880667900 = null; //Variable for return #1
        LinkedList<NameValue> listw;
        listw = new LinkedList<NameValue>();
        Iterator li;
        li = this.parameters.iterator();
        ListIterator<NameValue> ecfLIST;
        ecfLIST = listw.listIterator();
        NameValue nv;
        boolean removed;
        removed = false;
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_627545781 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean varF00BF4AD27CE29D5A8D1BEFF453AEA4F_418026388 = (nv.getName().equalsIgnoreCase(ParameterNamesIms.ECF));
                    {
                        NameValue ecfNV;
                        ecfNV = new NameValue();
                        ecfNV.setName(nv.getName());
                        ecfNV.setValueAsObject(nv.getValueAsObject());
                        ecfLIST.add(ecfNV);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1880667900 = ecfLIST;
        varB4EAC82CA7396A68D541C85D26508E83_1880667900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880667900;
        // ---------- Original Method ----------
        //LinkedList<NameValue> listw = new LinkedList<NameValue>();
        //Iterator li = this.parameters.iterator();
        //ListIterator<NameValue> ecfLIST = listw.listIterator();
        //NameValue nv;
        //boolean removed = false;
        //while (li.hasNext()) {
            //nv = (NameValue) li.next();
            //if (nv.getName().equalsIgnoreCase(ParameterNamesIms.ECF)) {
                //NameValue ecfNV = new NameValue();
                //ecfNV.setName(nv.getName());
                //ecfNV.setValueAsObject(nv.getValueAsObject());
                //ecfLIST.add(ecfNV);
            //}
        //}
        //return ecfLIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.351 -0400", hash_original_method = "CC3F97A616116EB8BC182A6988C81981", hash_generated_method = "923F3A6BE59B8CA800B35C191BDC94B5")
    public boolean delete(String value, String name) {
        Iterator li;
        li = this.parameters.iterator();
        NameValue nv;
        boolean removed;
        removed = false;
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1679414851 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean varC1B3550FA85F2748F4E9D1D5DAF151BF_557296353 = (((String) nv.getValueAsObject()).equalsIgnoreCase(value) && nv.getName().equalsIgnoreCase(name));
                    {
                        li.remove();
                        removed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669319737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_669319737;
        // ---------- Original Method ----------
        //Iterator li = this.parameters.iterator();
        //NameValue nv;
        //boolean removed = false;
        //while (li.hasNext()) {
            //nv = (NameValue) li.next();
            //if (((String) nv.getValueAsObject()).equalsIgnoreCase(value) && nv.getName().equalsIgnoreCase(name)) {
                //li.remove();
                //removed = true;
            //}
        //}
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.351 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException ( value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException ( value,0);
    }

    
}

