package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ParametersHeader;

public class PAccessNetworkInfo extends ParametersHeader implements PAccessNetworkInfoHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.152 -0400", hash_original_field = "C094CFF5A400E24D3E32C2F411A1B793", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")

    private String accessType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.152 -0400", hash_original_field = "849A050A2DDE1357870F15A44C8398CE", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")

    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.153 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    public  PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.153 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "C6C4AC41683770AA77BF93DC1DFE5880")
    public  PAccessNetworkInfo(String accessTypeVal) {
        this();
        setAccessType(accessTypeVal);
        addTaint(accessTypeVal.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.153 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "FD58C0FA587CA80AB39107E8E6A6EC63")
    public void setAccessType(String accessTypeVal) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        this.accessType = accessTypeVal;
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.154 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "7F9F24D9572C79C5F8106E50DC4B51BF")
    public String getAccessType() {
        String varB4EAC82CA7396A68D541C85D26508E83_547638236 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_547638236 = accessType;
        varB4EAC82CA7396A68D541C85D26508E83_547638236.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_547638236;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.154 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "E3564B435DF915E7951FB01017599309")
    public void setCGI3GPP(String cgi) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        setParameter(ParameterNamesIms.CGI_3GPP, cgi);
        addTaint(cgi.getTaint());
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.154 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "FB2A6156F70BA742BD9380C23A6A9AC0")
    public String getCGI3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_557398937 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_557398937 = getParameter(ParameterNamesIms.CGI_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_557398937.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_557398937;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.155 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "C8A38BFCB49DE546804D99E3416A9ECB")
    public void setUtranCellID3GPP(String utranCellID) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
        addTaint(utranCellID.getTaint());
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.155 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "49F50D5B2550367CF2219C333DC2333F")
    public String getUtranCellID3GPP() {
        String varB4EAC82CA7396A68D541C85D26508E83_1426195127 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1426195127 = getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
        varB4EAC82CA7396A68D541C85D26508E83_1426195127.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1426195127;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.155 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "78AF17FA9876266D15C7DE38B05C1D2A")
    public void setDSLLocation(String dslLocation) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
        addTaint(dslLocation.getTaint());
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.156 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "AA95468BA980021D3508C49F855A5354")
    public String getDSLLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_803329958 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_803329958 = getParameter(ParameterNamesIms.DSL_LOCATION);
        varB4EAC82CA7396A68D541C85D26508E83_803329958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_803329958;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.156 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "70B8D3A18F1D71B85C3EB7CF16A47BBA")
    public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
        addTaint(ci3Gpp2.getTaint());
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.156 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "9F9D11F9EA5F379DDDC37B8941B196CB")
    public String getCI3GPP2() {
        String varB4EAC82CA7396A68D541C85D26508E83_677260246 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_677260246 = getParameter(ParameterNamesIms.CI_3GPP2);
        varB4EAC82CA7396A68D541C85D26508E83_677260246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_677260246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.157 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "2B925811C4406E08A9C6CC9E16310307")
    public void setParameter(String name, Object value) {
        {
            boolean varD2413D96B5F8C50CF3206E0562B11CE3_1104709714 = (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.UTRAN_CELL_ID_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.DSL_LOCATION)
                || name.equalsIgnoreCase(ParameterNamesIms.CI_3GPP2));
            {
                try 
                {
                    super.setQuotedParameter(name, value.toString());
                } 
                catch (ParseException e)
                { }
            } 
            {
                super.setParameter(name, value);
            } 
        } 
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
                
                
                
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.157 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "B7BE74D4C25222EE2CA299844C6F3829")
    public void setExtensionAccessInfo(Object extendAccessInfo) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        this.extendAccessInfo = extendAccessInfo;
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.157 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "24E45F5260EB6601EDEA17A891033C85")
    public Object getExtensionAccessInfo() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1920499632 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1920499632 = this.extendAccessInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1920499632.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920499632;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.158 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "3C83E7CB45F1450B8366D3541210C1B2")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851822780 = null; 
        StringBuffer encoding = new StringBuffer();
        {
            boolean var0C52BDEAC32FB4CA69D41C41117E9F63_1788171768 = (getAccessType() != null);
            encoding.append(getAccessType());
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2126101943 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON + SP + this.parameters.encode());
            } 
        } 
        {
            boolean varA51DF3E70B4B6F22AEF496F2D20C8BB1_704960134 = (getExtensionAccessInfo() != null);
            {
                encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1851822780 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1851822780.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1851822780;
        
        
        
            
        
            
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.159 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.159 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "44E141C0C30E308378AF6E103EFB2C7E")
    public boolean equals(Object other) {
        boolean varA1F3002C153A325AFDA4385B75CBB9D0_683423755 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651774812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651774812;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.160 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "0797DD3B51EC50709B3FAAF41670247C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_648364265 = null; 
        PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_648364265 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_648364265.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_648364265;
        
        
        
    }

    
}

