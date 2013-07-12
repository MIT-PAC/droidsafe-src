package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.963 -0400", hash_original_method = "8D7038EECA0B07E6CABE7C4563FEE1B0", hash_generated_method = "85C85690ED146B961192627A81D00D75")
    public  PChargingFunctionAddresses() {
        super(P_CHARGING_FUNCTION_ADDRESSES);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.963 -0400", hash_original_method = "B754CD465EC1221F70524778BEB24E59", hash_generated_method = "6569E1D5098B08B10001CC77514C6877")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
    if(!duplicates.isEmpty())        
        {
            encoding.append(duplicates.encode());
        } 
String varD48A745DC29A29C7851286E6A426D0D0_1235274709 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1235274709.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1235274709;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.963 -0400", hash_original_method = "04146A3594153EB2EF0E88997B90AD38", hash_generated_method = "A059D66D19D211DC2FAC76F35A0615A2")
    public void setChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
    if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_560807749 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_560807749.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_560807749;
        }
        setMultiParameter(ParameterNamesIms.CCF, ccfAddress);
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.964 -0400", hash_original_method = "4EBC089EFA4A412FF008399341976E93", hash_generated_method = "BC0A269B9385DF9010293D42A39C366C")
    public void addChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
    if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1967749454 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1967749454.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_1967749454;
        }
        this.parameters.set(ParameterNamesIms.CCF, ccfAddress);
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.964 -0400", hash_original_method = "E4304895721C991E07562D8775709E0E", hash_generated_method = "85DB52CB422E6B8727240DA526084D4A")
    public void removeChargingCollectionFunctionAddress(String ccfAddress) throws ParseException {
        addTaint(ccfAddress.getTaint());
    if(ccfAddress == null)        
        {
        NullPointerException varCD2C2F46FDAB7F4E4EDDFFC1212E3878_371767896 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setChargingCollectionFunctionAddress(), the ccfAddress parameter is null.");
        varCD2C2F46FDAB7F4E4EDDFFC1212E3878_371767896.addTaint(taint);
        throw varCD2C2F46FDAB7F4E4EDDFFC1212E3878_371767896;
        }
    if(!this.delete(ccfAddress, ParameterNamesIms.CCF))        
        {
            ParseException var36B925E46F37CA25D112CE896FEC51E3_919480820 = new ParseException("CCF Address Not Removed",0);
            var36B925E46F37CA25D112CE896FEC51E3_919480820.addTaint(taint);
            throw var36B925E46F37CA25D112CE896FEC51E3_919480820;
        } 
        
        
            
                
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.964 -0400", hash_original_method = "3FA3BC1EE35C4A614E59F8D80CF072BA", hash_generated_method = "CF930447BE27B67F661CEAC5C7C96B4B")
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
            } 
        } 
ListIterator var258D93B65AF7A31DC580C27ACCEE4A1E_1933936701 =         ccfLIST.listIterator();
        var258D93B65AF7A31DC580C27ACCEE4A1E_1933936701.addTaint(taint);
        return var258D93B65AF7A31DC580C27ACCEE4A1E_1933936701;
        
        
        
        
        
            
            
                
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.964 -0400", hash_original_method = "E0FB708D70424943E5DFB76554EEFAC9", hash_generated_method = "C4A7B54413EB2621AD2622C9EAE4ECF9")
    public void setEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
    if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_2060110909 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_2060110909.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_2060110909;
        }
        setMultiParameter(ParameterNamesIms.ECF, ecfAddress);
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.965 -0400", hash_original_method = "A5F62C761E9F9A46D1D6185CEC65084F", hash_generated_method = "6C22DA2DCF9D225F6AE2AFA1B9EEF7D2")
    public void addEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
    if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_1539194822 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_1539194822.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_1539194822;
        }
        this.parameters.set(ParameterNamesIms.ECF, ecfAddress);
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.965 -0400", hash_original_method = "55FFD36C944B472AFBDD2C5B98B03BCA", hash_generated_method = "1A3DB80EF78468FF2A56EAD38B436FC7")
    public void removeEventChargingFunctionAddress(String ecfAddress) throws ParseException {
        addTaint(ecfAddress.getTaint());
    if(ecfAddress == null)        
        {
        NullPointerException var9A2261485AEB710E03059779E00E748F_567665680 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "P-Charging-Function-Addresses, setEventChargingFunctionAddress(), the ecfAddress parameter is null.");
        var9A2261485AEB710E03059779E00E748F_567665680.addTaint(taint);
        throw var9A2261485AEB710E03059779E00E748F_567665680;
        }
    if(!this.delete(ecfAddress, ParameterNamesIms.ECF))        
        {
            java.text.ParseException var10EAD238A7BD4A6031329EAB0E3E08D2_1036443478 = new java.text.ParseException("ECF Address Not Removed",0);
            var10EAD238A7BD4A6031329EAB0E3E08D2_1036443478.addTaint(taint);
            throw var10EAD238A7BD4A6031329EAB0E3E08D2_1036443478;
        } 
        
        
            
                
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.965 -0400", hash_original_method = "1CFCD9DC9A311745B4AD8E988ADAF97A", hash_generated_method = "B998327B3EC53179FCFE11069A574C25")
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
            } 
        } 
ListIterator<NameValue> varE121826118567FAC0BD5D1878DD1BAB8_1140422167 =         ecfLIST;
        varE121826118567FAC0BD5D1878DD1BAB8_1140422167.addTaint(taint);
        return varE121826118567FAC0BD5D1878DD1BAB8_1140422167;
        
        
        
        
        
        
        
            
            
                
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.965 -0400", hash_original_method = "CC3F97A616116EB8BC182A6988C81981", hash_generated_method = "D3BE288B7AC5453C2CE504B5C732C59A")
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
            } 
        } 
        boolean varB07286EBBB5BC7AA91CC3EAA8BC19711_1290780792 = (removed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113934901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113934901;
        
        
        
        
        
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.966 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "70436B13BAE07B25F7CE956A7AB21947")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1145366535 = new ParseException ( value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1145366535.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1145366535;
        
        
    }

    
}

