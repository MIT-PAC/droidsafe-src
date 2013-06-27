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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.191 -0400", hash_original_field = "C094CFF5A400E24D3E32C2F411A1B793", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")

    private String accessType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.192 -0400", hash_original_field = "849A050A2DDE1357870F15A44C8398CE", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")

    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.192 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    public  PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.192 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "C6C4AC41683770AA77BF93DC1DFE5880")
    public  PAccessNetworkInfo(String accessTypeVal) {
        this();
        setAccessType(accessTypeVal);
        addTaint(accessTypeVal.getTaint());
        // ---------- Original Method ----------
        //setAccessType(accessTypeVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.192 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "FD58C0FA587CA80AB39107E8E6A6EC63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.193 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "92322149580AF264ACFD8468A42C9B53")
    public String getAccessType() {
        String varB4EAC82CA7396A68D541C85D26508E83_789366949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_789366949 = accessType;
        varB4EAC82CA7396A68D541C85D26508E83_789366949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789366949;
        // ---------- Original Method ----------
        //return accessType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.193 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "E3564B435DF915E7951FB01017599309")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.194 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "09CE3C6A38FA60BA2D0E9CE4B33AA722")
    public String getCGI3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_1667510832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1667510832 = getParameter(ParameterNamesIms.CGI_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_1667510832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1667510832;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CGI_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.198 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "C8A38BFCB49DE546804D99E3416A9ECB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.208 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "32377D03A919CA6814E224D7ACB92F8E")
    public String getUtranCellID3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_1315150908 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1315150908 = getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_1315150908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1315150908;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.208 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "78AF17FA9876266D15C7DE38B05C1D2A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.209 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "19FAF8218166E01B028006E16071334E")
    public String getDSLLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_705202261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705202261 = getParameter(ParameterNamesIms.DSL_LOCATION);
        varB4EAC82CA7396A68D541C85D26508E83_705202261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705202261;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.DSL_LOCATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.209 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "70B8D3A18F1D71B85C3EB7CF16A47BBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.210 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "66A5ECDC19672440448F5DD03DE18852")
    public String getCI3GPP2() {
        String varB4EAC82CA7396A68D541C85D26508E83_1530679185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1530679185 = getParameter(ParameterNamesIms.CI_3GPP2);
        varB4EAC82CA7396A68D541C85D26508E83_1530679185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530679185;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CI_3GPP2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.223 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "6F277F90600ADF6B9AF0893A8E58A5EE")
    public void setParameter(String name, Object value) {
        {
            boolean varD2413D96B5F8C50CF3206E0562B11CE3_1728804628 = (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.224 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "B7BE74D4C25222EE2CA299844C6F3829")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.224 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "0091D2C0D1839E6DE8025F4BBDF85ECF")
    public Object getExtensionAccessInfo() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1475378023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1475378023 = this.extendAccessInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1475378023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1475378023;
        // ---------- Original Method ----------
        //return this.extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.232 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "FF5AECEFE99CBA224EBE94DB0911BB9B")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_830434840 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            boolean var0C52BDEAC32FB4CA69D41C41117E9F63_178482136 = (getAccessType() != null);
            encoding.append(getAccessType());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1124676594 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON + SP + this.parameters.encode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA51DF3E70B4B6F22AEF496F2D20C8BB1_1225206178 = (getExtensionAccessInfo() != null);
            {
                encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_830434840 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_830434840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830434840;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.232 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.238 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "F8D0247EE5D734096427E8EF0B54FD3A")
    public boolean equals(Object other) {
        boolean varA1F3002C153A325AFDA4385B75CBB9D0_781210953 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784583934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784583934;
        // ---------- Original Method ----------
        //return (other instanceof PAccessNetworkInfoHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.249 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "ACDB2A9C3C0B1208883988C7698CF9D9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_183861918 = null; //Variable for return #1
        PAccessNetworkInfo retval;
        retval = (PAccessNetworkInfo) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_183861918 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_183861918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183861918;
        // ---------- Original Method ----------
        //PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        //return retval;
    }

    
}

