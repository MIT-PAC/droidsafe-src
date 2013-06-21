package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ParametersHeader;

public class PAccessNetworkInfo extends ParametersHeader implements PAccessNetworkInfoHeader, ExtensionHeader {
    private String accessType;
    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.535 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.535 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "8B8896140031C1F7B3C3810E4F5DE512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAccessNetworkInfo(String accessTypeVal) {
        this();
        dsTaint.addTaint(accessTypeVal);
        setAccessType(accessTypeVal);
        // ---------- Original Method ----------
        //setAccessType(accessTypeVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.535 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "8171D4C9A731F548330129FDA1682E39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAccessType(String accessTypeVal) {
        dsTaint.addTaint(accessTypeVal);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        // ---------- Original Method ----------
        //if (accessTypeVal == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        //this.accessType = accessTypeVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.536 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "84EEAF74AE5109457B7DE66B7B6BA2A9")
    @DSModeled(DSC.SAFE)
    public String getAccessType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return accessType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.536 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "9CCB1EE3D13D64976604EABB15B80344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCGI3GPP(String cgi) throws ParseException {
        dsTaint.addTaint(cgi);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        setParameter(ParameterNamesIms.CGI_3GPP, cgi);
        // ---------- Original Method ----------
        //if (cgi == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        //setParameter(ParameterNamesIms.CGI_3GPP, cgi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.536 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "CBD93B90F922E230ABFDC57599157B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCGI3GPP() {
        String var7C5416CEECFAB5C4F99770D45AA2B3A0_149010335 = (getParameter(ParameterNamesIms.CGI_3GPP));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CGI_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.536 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "3880A9F714CA1DB2DD85CB751957EEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUtranCellID3GPP(String utranCellID) throws ParseException {
        dsTaint.addTaint(utranCellID);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
        // ---------- Original Method ----------
        //if (utranCellID == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        //setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.536 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "CA5EF624338061CA3852DCA14FE501D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUtranCellID3GPP() {
        String var085D4B22F5B5227EC0FBE0AABD1BAAD9_969842097 = (getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.537 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "93A1931564FF6E12BBEAA437C32F8F55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDSLLocation(String dslLocation) throws ParseException {
        dsTaint.addTaint(dslLocation);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
        // ---------- Original Method ----------
        //if (dslLocation == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        //setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.537 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "0EFC5EE76C620244F33E00798EE9B81A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDSLLocation() {
        String varB2F6031AC384B23A7CAC786D2E7E712F_1934551594 = (getParameter(ParameterNamesIms.DSL_LOCATION));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.DSL_LOCATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.537 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "88763CB8960FD43A5B70F3FC61E68C7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        dsTaint.addTaint(ci3Gpp2);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
        // ---------- Original Method ----------
        //if (ci3Gpp2 == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        //setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.537 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "404207C8B6993A704511388C66B9E333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCI3GPP2() {
        String var4A7E2B84A627187C9E8A660A162A3A3F_684909004 = (getParameter(ParameterNamesIms.CI_3GPP2));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CI_3GPP2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.537 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "7A40B4F128CE099C2495C353EE8B4E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varD2413D96B5F8C50CF3206E0562B11CE3_1378766410 = (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.UTRAN_CELL_ID_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.DSL_LOCATION)
                || name.equalsIgnoreCase(ParameterNamesIms.CI_3GPP2));
            {
                try 
                {
                    super.setQuotedParameter(name, value.toString());
                } //End block
                catch (ParseException e)
                { }
            } //End block
            {
                super.setParameter(name, value);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
                //|| name.equalsIgnoreCase(ParameterNamesIms.UTRAN_CELL_ID_3GPP)
                //|| name.equalsIgnoreCase(ParameterNamesIms.DSL_LOCATION)
                //|| name.equalsIgnoreCase(ParameterNamesIms.CI_3GPP2)) {
            //try {
                //super.setQuotedParameter(name, value.toString());
            //} catch (ParseException e) {
            //}
        //} else {
            //super.setParameter(name, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.538 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "15139BAA3AB8490C23FEC9214D9B831C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtensionAccessInfo(Object extendAccessInfo) throws ParseException {
        dsTaint.addTaint(extendAccessInfo.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        // ---------- Original Method ----------
        //if (extendAccessInfo == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        //this.extendAccessInfo = extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.538 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "B342354AC459ABF7186F8E1172BD397A")
    @DSModeled(DSC.SAFE)
    public Object getExtensionAccessInfo() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.538 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "C9F5FDAE4696B4311B7FCA4B06A2B51F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            boolean var0C52BDEAC32FB4CA69D41C41117E9F63_50400820 = (getAccessType() != null);
            encoding.append(getAccessType());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1888266180 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON + SP + this.parameters.encode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA51DF3E70B4B6F22AEF496F2D20C8BB1_310674374 = (getExtensionAccessInfo() != null);
            {
                encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_126319349 = (encoding.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (getAccessType() != null)
            //encoding.append(getAccessType());
        //if (!parameters.isEmpty()) {
            //encoding.append(SEMICOLON + SP + this.parameters.encode());
        //}
        //if (getExtensionAccessInfo() != null) {
            //encoding.append(SEMICOLON + SP
                    //+ getExtensionAccessInfo().toString());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.538 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.538 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "F554954337994D315600047A8766ADAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varA1F3002C153A325AFDA4385B75CBB9D0_11060298 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof PAccessNetworkInfoHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.539 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "213851658EBA9DD2079F41FB7F9F340E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAccessNetworkInfo retval;
        retval = (PAccessNetworkInfo) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        //return retval;
    }

    
}

