package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import gov.nist.core.NameValue;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSGenerator;

public class PChargingFunctionAddresses extends gov.nist.javax.sip.header.ParametersHeader implements PChargingFunctionAddressesHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.152 -0400", hash_original_method = "8D7038EECA0B07E6CABE7C4563FEE1B0", hash_generated_method = "85C85690ED146B961192627A81D00D75")
    public  PChargingFunctionAddresses() {
        super(P_CHARGING_FUNCTION_ADDRESSES);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.153 -0400", hash_original_method = "B754CD465EC1221F70524778BEB24E59", hash_generated_method = "485119BD7C61BA13D95416DC319E769B")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        if(!duplicates.isEmpty())        
        {
            encoding.append(duplicates.encode());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1451998674 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1451998674.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1451998674;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (!duplicates.isEmpty())
        //{
            //encoding.append(duplicates.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.153 -0400", hash_original_method = "04146A3594153EB2EF0E88997B90AD38", hash_generated_method = "71D57EA573554E238F5F38277AB3921B")
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
        if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1372673297 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1372673297.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1372673297;
        }
        setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.154 -0400", hash_original_method = "4EBC089EFA4A412FF008399341976E93", hash_generated_method = "A0FFD626C77055CDD54C2BCA3767DF4F")
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
        if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_256987726 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_256987726.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_256987726;
        }
        this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.155 -0400", hash_original_method = "E4304895721C991E07562D8775709E0E", hash_generated_method = "A9924862E06D616648A2AB2C3C76298B")
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
        if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_921203058 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_921203058.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_921203058;
        }
        if(!this.delete(ccfAddress, ParameterNamesIms.CCF))        
        {
            ParseException var36B925E46F37CA25D112CE896FEC51E3_488318303 = new ParseException("CCF Address Not Removed",0);
            var36B925E46F37CA25D112CE896FEC51E3_488318303.addTaint(taint);
            throw var36B925E46F37CA25D112CE896FEC51E3_488318303;
        } //End block
        // ---------- Original Method ----------
        //if (ccfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        //if(!this.delete(ccfAddress, ParameterNamesIms.CCF)) {
            //throw new ParseException("CCF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.156 -0400", hash_original_method = "3FA3BC1EE35C4A614E59F8D80CF072BA", hash_generated_method = "C464BAF2A4A21CFF9922913AD164A634")
    public ListIterator getChargingCollectionFunctionAddresses() {
        Iterator li = this.parameters.iterator();
        LinkedList ccfLIST = new LinkedList();
        NameValue nv;
        while
(li.hasNext())        
        {
            nv = (NameValue) li.next();
            if(nv.getName().equalsIgnoreCase(ParameterNamesIms.CCF))            
            {
                NameValue ccfNV = new NameValue();
                ccfNV.setName(nv.getName());
                ccfNV.setValueAsObject(nv.getValueAsObject());
                ccfLIST.add(ccfNV);
            } //End block
        } //End block
ListIterator var258D93B65AF7A31DC580C27ACCEE4A1E_1902549090 =         ccfLIST.listIterator();
        var258D93B65AF7A31DC580C27ACCEE4A1E_1902549090.addTaint(taint);
        return var258D93B65AF7A31DC580C27ACCEE4A1E_1902549090;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.156 -0400", hash_original_method = "E0FB708D70424943E5DFB76554EEFAC9", hash_generated_method = "A9FB3BA4F778D68E04F09438B092D2E0")
    public void setEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
        if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_432480911 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_432480911.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_432480911;
        }
        setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.157 -0400", hash_original_method = "A5F62C761E9F9A46D1D6185CEC65084F", hash_generated_method = "63058EF8697C54232544BC98D259A6F2")
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
        if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_1515376347 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_1515376347.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_1515376347;
        }
        this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.157 -0400", hash_original_method = "55FFD36C944B472AFBDD2C5B98B03BCA", hash_generated_method = "ADE8221672E2488BAD72C19E98731B5A")
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
        if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_1436778834 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_1436778834.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_1436778834;
        }
        if(!this.delete(ecfAddress, ParameterNamesIms.ECF))        
        {
            java.text.ParseException var10EAD238A7BD4A6031329EAB0E3E08D2_1627103731 = new java.text.ParseException("ECF Address Not Removed",0);
            var10EAD238A7BD4A6031329EAB0E3E08D2_1627103731.addTaint(taint);
            throw var10EAD238A7BD4A6031329EAB0E3E08D2_1627103731;
        } //End block
        // ---------- Original Method ----------
        //if (ecfAddress == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        //if(!this.delete(ecfAddress, ParameterNamesIms.ECF)) {
            //throw new java.text.ParseException("ECF Address Not Removed",0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.158 -0400", hash_original_method = "1CFCD9DC9A311745B4AD8E988ADAF97A", hash_generated_method = "F59BA27740A8D8F53839D4A81F28BBD2")
    public ListIterator<NameValue> getEventChargingFunctionAddresses() {
        LinkedList<NameValue> listw = new LinkedList<NameValue>();
        Iterator li = this.parameters.iterator();
        ListIterator<NameValue> ecfLIST = listw.listIterator();
        NameValue nv;
        boolean removed = false;
        while
(li.hasNext())        
        {
            nv = (NameValue) li.next();
            if(nv.getName().equalsIgnoreCase(ParameterNamesIms.ECF))            
            {
                NameValue ecfNV = new NameValue();
                ecfNV.setName(nv.getName());
                ecfNV.setValueAsObject(nv.getValueAsObject());
                ecfLIST.add(ecfNV);
            } //End block
        } //End block
ListIterator<NameValue> varE121826118567FAC0BD5D1878DD1BAB8_897224292 =         ecfLIST;
        varE121826118567FAC0BD5D1878DD1BAB8_897224292.addTaint(taint);
        return varE121826118567FAC0BD5D1878DD1BAB8_897224292;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.159 -0400", hash_original_method = "CC3F97A616116EB8BC182A6988C81981", hash_generated_method = "45175A86277F58BABEF32314A4EDC808")
    public boolean delete(String value, String name) {
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        Iterator li = this.parameters.iterator();
        NameValue nv;
        boolean removed = false;
        while
(li.hasNext())        
        {
            nv = (NameValue) li.next();
            if(((String) nv.getValueAsObject()).equalsIgnoreCase(value) && nv.getName().equalsIgnoreCase(name))            
            {
                li.remove();
                removed = true;
            } //End block
        } //End block
        boolean varB07286EBBB5BC7AA91CC3EAA8BC19711_1422436581 = (removed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648042036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648042036;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.159 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "30622AC1B972893212A085D3B763757E")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_640440025 = new ParseException ( value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_640440025.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_640440025;
        // ---------- Original Method ----------
        //throw new ParseException ( value,0);
    }

    
}

