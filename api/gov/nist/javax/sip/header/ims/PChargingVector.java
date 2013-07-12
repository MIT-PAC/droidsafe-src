package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;

public class PChargingVector extends gov.nist.javax.sip.header.ParametersHeader implements PChargingVectorHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.976 -0400", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "6095E38714E723CF4021E2B80F418044")
    public  PChargingVector() {
        super(P_CHARGING_VECTOR);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.976 -0400", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "C26639AD2A8D726A0E4AF7145818EF65")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        gov.nist.core.NameValue nv = getNameValue( ParameterNamesIms.ICID_VALUE );
        nv.encode( encoding );
    if(parameters.containsKey(ParameterNamesIms.ICID_GENERATED_AT))        
        encoding.append(SEMICOLON).append(
                    ParameterNamesIms.ICID_GENERATED_AT).append(EQUALS).append(
                    getICIDGeneratedAt());
    if(parameters.containsKey(ParameterNamesIms.TERM_IOI))        
        encoding.append(SEMICOLON).append(ParameterNamesIms.TERM_IOI)
                    .append(EQUALS).append(getTerminatingIOI());
    if(parameters.containsKey(ParameterNamesIms.ORIG_IOI))        
        encoding.append(SEMICOLON).append(ParameterNamesIms.ORIG_IOI)
                    .append(EQUALS).append(getOriginatingIOI());
String varD48A745DC29A29C7851286E6A426D0D0_1233430373 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1233430373.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1233430373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.977 -0400", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "5EE8C59A9DF9FA8544F6C05D128B910D")
    public String getICID() {
String var8FB09FE306E053C5C94430AED16B3C8A_45278033 =         getParameter(ParameterNamesIms.ICID_VALUE);
        var8FB09FE306E053C5C94430AED16B3C8A_45278033.addTaint(taint);
        return var8FB09FE306E053C5C94430AED16B3C8A_45278033;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.977 -0400", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "C3CF14DBB3A449EC0611840AE6D8E7A5")
    public void setICID(String icid) throws ParseException {
        addTaint(icid.getTaint());
    if(icid == null)        
        {
        NullPointerException varC038EACC8ADF43E3C09C81C2FB3E2F67_939820773 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICID(), the icid parameter is null.");
        varC038EACC8ADF43E3C09C81C2FB3E2F67_939820773.addTaint(taint);
        throw varC038EACC8ADF43E3C09C81C2FB3E2F67_939820773;
        }
        setParameter(ParameterNamesIms.ICID_VALUE, icid);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.977 -0400", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "7CBDECBF01826DE67EBDD4E3C1D19AF4")
    public String getICIDGeneratedAt() {
String var353DF2B3886110E512F672D72362E9FC_41430775 =         getParameter(ParameterNamesIms.ICID_GENERATED_AT);
        var353DF2B3886110E512F672D72362E9FC_41430775.addTaint(taint);
        return var353DF2B3886110E512F672D72362E9FC_41430775;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.977 -0400", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "A20B017D0A73B092E29BE5DABA824A97")
    public void setICIDGeneratedAt(String host) throws ParseException {
        addTaint(host.getTaint());
    if(host == null)        
        {
        NullPointerException var10D8D05B15ADAF8EEC93FD1D24D10A89_1394961045 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        var10D8D05B15ADAF8EEC93FD1D24D10A89_1394961045.addTaint(taint);
        throw var10D8D05B15ADAF8EEC93FD1D24D10A89_1394961045;
        }
        setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.978 -0400", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "913680F51BEF28B018E011CAFCB11AC7")
    public String getOriginatingIOI() {
String var386819077BFE19DEBD440E43A3862CF1_807840737 =         getParameter(ParameterNamesIms.ORIG_IOI);
        var386819077BFE19DEBD440E43A3862CF1_807840737.addTaint(taint);
        return var386819077BFE19DEBD440E43A3862CF1_807840737;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.978 -0400", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "B7AF2475F300A935FD3D982B665ED8EB")
    public void setOriginatingIOI(String origIOI) throws ParseException {
        addTaint(origIOI.getTaint());
    if(origIOI == null || origIOI.length() == 0)        
        {
            removeParameter(ParameterNamesIms.ORIG_IOI);
        } 
        else
        setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.978 -0400", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "A406D1E281C2AF5F334A8C2621A950B8")
    public String getTerminatingIOI() {
String var3BC0DA6BB104C1B12A39DBD2AA7F3225_1232195654 =         getParameter(ParameterNamesIms.TERM_IOI);
        var3BC0DA6BB104C1B12A39DBD2AA7F3225_1232195654.addTaint(taint);
        return var3BC0DA6BB104C1B12A39DBD2AA7F3225_1232195654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.978 -0400", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "ACA07A2F47B91A5CB23744D3F968CF8D")
    public void setTerminatingIOI(String termIOI) throws ParseException {
        addTaint(termIOI.getTaint());
    if(termIOI == null || termIOI.length() == 0)        
        {
            removeParameter(ParameterNamesIms.TERM_IOI);
        } 
        else
        setParameter(ParameterNamesIms.TERM_IOI, termIOI);
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.978 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "26B8455308E691E3303950790CE20D8C")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_707398641 = new ParseException(value, 0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_707398641.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_707398641;
        
        
    }

    
}

