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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.248 -0400", hash_original_field = "C094CFF5A400E24D3E32C2F411A1B793", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")

    private String accessType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.248 -0400", hash_original_field = "849A050A2DDE1357870F15A44C8398CE", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")

    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.312 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    public  PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.313 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "C6C4AC41683770AA77BF93DC1DFE5880")
    public  PAccessNetworkInfo(String accessTypeVal) {
        this();
        setAccessType(accessTypeVal);
        addTaint(accessTypeVal.getTaint());
        // ---------- Original Method ----------
        //setAccessType(accessTypeVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.314 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "FD58C0FA587CA80AB39107E8E6A6EC63")
    public void setAccessType(String accessTypeVal) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        this.accessType = accessTypeVal;
        // ---------- Original Method ----------
        //if (accessTypeVal == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        //this.accessType = accessTypeVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.314 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "91CA65B65C3109289475F75A46983444")
    public String getAccessType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1425292764 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1425292764 = accessType;
        varB4EAC82CA7396A68D541C85D26508E83_1425292764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1425292764;
        // ---------- Original Method ----------
        //return accessType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.319 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "E3564B435DF915E7951FB01017599309")
    public void setCGI3GPP(String cgi) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        setParameter(ParameterNamesIms.CGI_3GPP, cgi);
        addTaint(cgi.getTaint());
        // ---------- Original Method ----------
        //if (cgi == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        //setParameter(ParameterNamesIms.CGI_3GPP, cgi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.320 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "E7AA5354E90A549FAA833C5D91441D63")
    public String getCGI3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_883355736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_883355736 = getParameter(ParameterNamesIms.CGI_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_883355736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_883355736;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CGI_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.320 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "C8A38BFCB49DE546804D99E3416A9ECB")
    public void setUtranCellID3GPP(String utranCellID) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
        addTaint(utranCellID.getTaint());
        // ---------- Original Method ----------
        //if (utranCellID == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        //setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.321 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "77BC1B0DCC9209E766C124E0BADFF139")
    public String getUtranCellID3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_781504471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_781504471 = getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_781504471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781504471;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.324 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "78AF17FA9876266D15C7DE38B05C1D2A")
    public void setDSLLocation(String dslLocation) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
        addTaint(dslLocation.getTaint());
        // ---------- Original Method ----------
        //if (dslLocation == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        //setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.325 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "ABB072B44A079D4AF666A3D897D6C672")
    public String getDSLLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1177131488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177131488 = getParameter(ParameterNamesIms.DSL_LOCATION);
        varB4EAC82CA7396A68D541C85D26508E83_1177131488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177131488;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.DSL_LOCATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.344 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "70B8D3A18F1D71B85C3EB7CF16A47BBA")
    public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
        addTaint(ci3Gpp2.getTaint());
        // ---------- Original Method ----------
        //if (ci3Gpp2 == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        //setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.345 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "236BE1EC391D5E886AE2C0C0E4A246F8")
    public String getCI3GPP2() {
        String varB4EAC82CA7396A68D541C85D26508E83_886702156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_886702156 = getParameter(ParameterNamesIms.CI_3GPP2);
        varB4EAC82CA7396A68D541C85D26508E83_886702156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886702156;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CI_3GPP2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.346 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "69E7BCC487B0B29747F4314DA344431F")
    public void setParameter(String name, Object value) {
        {
            boolean varD2413D96B5F8C50CF3206E0562B11CE3_13683445 = (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
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
        addTaint(name.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.346 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "B7BE74D4C25222EE2CA299844C6F3829")
    public void setExtensionAccessInfo(Object extendAccessInfo) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        this.extendAccessInfo = extendAccessInfo;
        // ---------- Original Method ----------
        //if (extendAccessInfo == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        //this.extendAccessInfo = extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.347 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "C008262C7A1080241156EB2F09838D0E")
    public Object getExtensionAccessInfo() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1208421380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1208421380 = this.extendAccessInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1208421380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1208421380;
        // ---------- Original Method ----------
        //return this.extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.364 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "EF3689171799E61179201C338FD8C94F")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1318646590 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            boolean var0C52BDEAC32FB4CA69D41C41117E9F63_1942750208 = (getAccessType() != null);
            encoding.append(getAccessType());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_912924632 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON + SP + this.parameters.encode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA51DF3E70B4B6F22AEF496F2D20C8BB1_506018767 = (getExtensionAccessInfo() != null);
            {
                encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1318646590 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1318646590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318646590;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.366 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.378 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "E5628B7B4C7AF88C962C3822E77CE1C5")
    public boolean equals(Object other) {
        boolean varA1F3002C153A325AFDA4385B75CBB9D0_106748497 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944414941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944414941;
        // ---------- Original Method ----------
        //return (other instanceof PAccessNetworkInfoHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.379 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "C1E1CEFF3814DCEF4B60DE1BCB958370")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1685813941 = null; //Variable for return #1
        PAccessNetworkInfo retval;
        retval = (PAccessNetworkInfo) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1685813941 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1685813941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1685813941;
        // ---------- Original Method ----------
        //PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        //return retval;
    }

    
}

