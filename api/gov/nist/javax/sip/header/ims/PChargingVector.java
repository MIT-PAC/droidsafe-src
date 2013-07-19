package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSGenerator;

public class PChargingVector extends gov.nist.javax.sip.header.ParametersHeader implements PChargingVectorHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.176 -0400", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "6095E38714E723CF4021E2B80F418044")
    public  PChargingVector() {
        super(P_CHARGING_VECTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.177 -0400", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "37DC53E33B8861EA0CC924A515BFA304")
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
String varD48A745DC29A29C7851286E6A426D0D0_1113626324 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1113626324.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1113626324;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.177 -0400", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "DC5B8C1B4D7AB789B02201B510970BFC")
    public String getICID() {
String var8FB09FE306E053C5C94430AED16B3C8A_1933102323 =         getParameter(ParameterNamesIms.ICID_VALUE);
        var8FB09FE306E053C5C94430AED16B3C8A_1933102323.addTaint(taint);
        return var8FB09FE306E053C5C94430AED16B3C8A_1933102323;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.177 -0400", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "493F5EFC67403C38FD67F8DC92FF05E0")
    public void setICID(String icid) throws ParseException {
        addTaint(icid.getTaint());
        if(icid == null)        
        {
        NullPointerException varC038EACC8ADF43E3C09C81C2FB3E2F67_748481779 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICID(), the icid parameter is null.");
        varC038EACC8ADF43E3C09C81C2FB3E2F67_748481779.addTaint(taint);
        throw varC038EACC8ADF43E3C09C81C2FB3E2F67_748481779;
        }
        setParameter(ParameterNamesIms.ICID_VALUE, icid);
        // ---------- Original Method ----------
        //if (icid == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICID(), the icid parameter is null.");
        //setParameter(ParameterNamesIms.ICID_VALUE, icid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.178 -0400", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "7A383FE0C1FE7DDC163036EC127AB36F")
    public String getICIDGeneratedAt() {
String var353DF2B3886110E512F672D72362E9FC_2134426944 =         getParameter(ParameterNamesIms.ICID_GENERATED_AT);
        var353DF2B3886110E512F672D72362E9FC_2134426944.addTaint(taint);
        return var353DF2B3886110E512F672D72362E9FC_2134426944;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_GENERATED_AT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.178 -0400", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "178F52F63C8238C2E23B8250E870B1AA")
    public void setICIDGeneratedAt(String host) throws ParseException {
        addTaint(host.getTaint());
        if(host == null)        
        {
        NullPointerException var10D8D05B15ADAF8EEC93FD1D24D10A89_38629582 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        var10D8D05B15ADAF8EEC93FD1D24D10A89_38629582.addTaint(taint);
        throw var10D8D05B15ADAF8EEC93FD1D24D10A89_38629582;
        }
        setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        //setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.178 -0400", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "967F3106CA241FE99F8B796CCA6804DE")
    public String getOriginatingIOI() {
String var386819077BFE19DEBD440E43A3862CF1_1582475164 =         getParameter(ParameterNamesIms.ORIG_IOI);
        var386819077BFE19DEBD440E43A3862CF1_1582475164.addTaint(taint);
        return var386819077BFE19DEBD440E43A3862CF1_1582475164;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ORIG_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.178 -0400", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "B7AF2475F300A935FD3D982B665ED8EB")
    public void setOriginatingIOI(String origIOI) throws ParseException {
        addTaint(origIOI.getTaint());
        if(origIOI == null || origIOI.length() == 0)        
        {
            removeParameter(ParameterNamesIms.ORIG_IOI);
        } //End block
        else
        setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
        // ---------- Original Method ----------
        //if (origIOI == null || origIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.ORIG_IOI);
        //} else
            //setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.179 -0400", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "D0AA009224E1966E17087C0724DB2B1B")
    public String getTerminatingIOI() {
String var3BC0DA6BB104C1B12A39DBD2AA7F3225_1864786308 =         getParameter(ParameterNamesIms.TERM_IOI);
        var3BC0DA6BB104C1B12A39DBD2AA7F3225_1864786308.addTaint(taint);
        return var3BC0DA6BB104C1B12A39DBD2AA7F3225_1864786308;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.TERM_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.179 -0400", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "ACA07A2F47B91A5CB23744D3F968CF8D")
    public void setTerminatingIOI(String termIOI) throws ParseException {
        addTaint(termIOI.getTaint());
        if(termIOI == null || termIOI.length() == 0)        
        {
            removeParameter(ParameterNamesIms.TERM_IOI);
        } //End block
        else
        setParameter(ParameterNamesIms.TERM_IOI, termIOI);
        // ---------- Original Method ----------
        //if (termIOI == null || termIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.TERM_IOI);
        //} else
            //setParameter(ParameterNamesIms.TERM_IOI, termIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.180 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "2C7865670EB1D9B8575D1B5E288CA6A5")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_897787733 = new ParseException(value, 0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_897787733.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_897787733;
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
}

