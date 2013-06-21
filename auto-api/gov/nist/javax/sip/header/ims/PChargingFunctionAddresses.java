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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.572 -0400", hash_original_method = "8D7038EECA0B07E6CABE7C4563FEE1B0", hash_generated_method = "85C85690ED146B961192627A81D00D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingFunctionAddresses() {
        super(P_CHARGING_FUNCTION_ADDRESSES);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.572 -0400", hash_original_method = "B754CD465EC1221F70524778BEB24E59", hash_generated_method = "A934271B76ABC464E7523202AA18862A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            boolean varE7A90190E466226C5EF9670A97EA0CF9_1200056259 = (!duplicates.isEmpty());
            {
                encoding.append(duplicates.encode());
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_530831288 = (encoding.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (!duplicates.isEmpty())
        //{
            //encoding.append(duplicates.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.572 -0400", hash_original_method = "04146A3594153EB2EF0E88997B90AD38", hash_generated_method = "7C2584696E3BE3BDF23AF049E93F3EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        dsTaint.addTaint(ccfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.572 -0400", hash_original_method = "4EBC089EFA4A412FF008399341976E93", hash_generated_method = "592016243C103532FF38B9250829825E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        dsTaint.addTaint(ccfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.573 -0400", hash_original_method = "E4304895721C991E07562D8775709E0E", hash_generated_method = "C37DEB39BD375BDF6FE92BF9ED503AEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        dsTaint.addTaint(ccfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        {
            boolean var941269CB9D0C5CFF429DF75DE28A6639_1058039665 = (!this.delete(ccfAddress, ParameterNamesIms.CCF));
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("CCF Address Not Removed",0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //if(!this.delete(ccfAddress, ParameterNamesIms.CCF)) {
            //throw new ParseException("CCF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.573 -0400", hash_original_method = "3FA3BC1EE35C4A614E59F8D80CF072BA", hash_generated_method = "EA8FAA13E1A803AE7F306057E0121F7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator getChargingCollectionFunctionAddresses() {
        Iterator li;
        li = this.parameters.iterator();
        LinkedList ccfLIST;
        ccfLIST = new LinkedList();
        NameValue nv;
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_2067991019 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean var4E9900FEF739227185E928141AA0A92A_1059212556 = (nv.getName().equalsIgnoreCase(ParameterNamesIms.CCF));
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
        ListIterator var3AE9AE132F60B804F0B5017C3B758CA7_713496729 = (ccfLIST.listIterator());
        return (ListIterator)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.573 -0400", hash_original_method = "E0FB708D70424943E5DFB76554EEFAC9", hash_generated_method = "0B70E987207A8FFD71D0F42B34D2E9ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        dsTaint.addTaint(ecfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.573 -0400", hash_original_method = "A5F62C761E9F9A46D1D6185CEC65084F", hash_generated_method = "033FBE224D0FF60D8739807F396AAFA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        dsTaint.addTaint(ecfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.574 -0400", hash_original_method = "55FFD36C944B472AFBDD2C5B98B03BCA", hash_generated_method = "F8CF8517AAD12A8EE9EC568B3D58AF0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        dsTaint.addTaint(ecfAddress);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        {
            boolean varBB2E68779A5747176CB70E0C0B687523_223892592 = (!this.delete(ecfAddress, ParameterNamesIms.ECF));
            {
                if (DroidSafeAndroidRuntime.control) throw new java.text.ParseException("ECF Address Not Removed",0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //if(!this.delete(ecfAddress, ParameterNamesIms.ECF)) {
            //throw new java.text.ParseException("ECF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.574 -0400", hash_original_method = "1CFCD9DC9A311745B4AD8E988ADAF97A", hash_generated_method = "3BE686A22691F7939304A856355BE707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<NameValue> getEventChargingFunctionAddresses() {
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
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1668688785 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean varF00BF4AD27CE29D5A8D1BEFF453AEA4F_307753782 = (nv.getName().equalsIgnoreCase(ParameterNamesIms.ECF));
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
        return (ListIterator<NameValue>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.574 -0400", hash_original_method = "CC3F97A616116EB8BC182A6988C81981", hash_generated_method = "4C3717937F124CD20700E322F5EFFF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean delete(String value, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Iterator li;
        li = this.parameters.iterator();
        NameValue nv;
        boolean removed;
        removed = false;
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_141630362 = (li.hasNext());
            {
                nv = (NameValue) li.next();
                {
                    boolean varC1B3550FA85F2748F4E9D1D5DAF151BF_1791436941 = (((String) nv.getValueAsObject()).equalsIgnoreCase(value) && nv.getName().equalsIgnoreCase(name));
                    {
                        li.remove();
                        removed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.574 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException ( value,0);
        // ---------- Original Method ----------
        //throw new ParseException ( value,0);
    }

    
}

