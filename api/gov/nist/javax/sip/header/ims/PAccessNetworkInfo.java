package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ParametersHeader;

public class PAccessNetworkInfo extends ParametersHeader implements PAccessNetworkInfoHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.825 -0400", hash_original_field = "C094CFF5A400E24D3E32C2F411A1B793", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")

    private String accessType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.825 -0400", hash_original_field = "849A050A2DDE1357870F15A44C8398CE", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")

    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.826 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    public  PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.826 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "994A5E9F7763AD51E3ED2D1F94600F2B")
    public  PAccessNetworkInfo(String accessTypeVal) {
        this();
        addTaint(accessTypeVal.getTaint());
        setAccessType(accessTypeVal);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.827 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "111961429D0F3755A627110B54FCB526")
    public void setAccessType(String accessTypeVal) {
    if(accessTypeVal == null)        
        {
        NullPointerException varC04CF5D9AD3BD8261BA02B62BA142947_659600365 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        varC04CF5D9AD3BD8261BA02B62BA142947_659600365.addTaint(taint);
        throw varC04CF5D9AD3BD8261BA02B62BA142947_659600365;
        }
        this.accessType = accessTypeVal;
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.827 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "021A03C9018E6BA232F8D6091D44DBA0")
    public String getAccessType() {
String var13839985BF7A2123F9C538846603D7DA_1384926364 =         accessType;
        var13839985BF7A2123F9C538846603D7DA_1384926364.addTaint(taint);
        return var13839985BF7A2123F9C538846603D7DA_1384926364;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.828 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "4A73BD7C5A8B370344550E0259F89C12")
    public void setCGI3GPP(String cgi) throws ParseException {
        addTaint(cgi.getTaint());
    if(cgi == null)        
        {
        NullPointerException varFF8AA56D7D55F1B17FB0AD2ABCAABD51_703009549 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        varFF8AA56D7D55F1B17FB0AD2ABCAABD51_703009549.addTaint(taint);
        throw varFF8AA56D7D55F1B17FB0AD2ABCAABD51_703009549;
        }
        setParameter(ParameterNamesIms.CGI_3GPP, cgi);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.828 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "1CB01038797F6851648A48E2B06CE6E9")
    public String getCGI3GPP() {
String var3812EB68A035524A86CF47B940DCA391_1776316939 =         getParameter(ParameterNamesIms.CGI_3GPP);
        var3812EB68A035524A86CF47B940DCA391_1776316939.addTaint(taint);
        return var3812EB68A035524A86CF47B940DCA391_1776316939;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.829 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "4D01D107186935CF5C006DD14440688C")
    public void setUtranCellID3GPP(String utranCellID) throws ParseException {
        addTaint(utranCellID.getTaint());
    if(utranCellID == null)        
        {
        NullPointerException varCEFC84FAAD9C65938851144DF0556B69_1799282524 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        varCEFC84FAAD9C65938851144DF0556B69_1799282524.addTaint(taint);
        throw varCEFC84FAAD9C65938851144DF0556B69_1799282524;
        }
        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.829 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "00AE9FC84ED55BAEEB0632F9D7EEAE68")
    public String getUtranCellID3GPP() {
String varB7D6779487FCB9E7AA24DA0384F3987E_1913598541 =         getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
        varB7D6779487FCB9E7AA24DA0384F3987E_1913598541.addTaint(taint);
        return varB7D6779487FCB9E7AA24DA0384F3987E_1913598541;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.830 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "ED82194D363DA54CAD7EE2940F81ED3F")
    public void setDSLLocation(String dslLocation) throws ParseException {
        addTaint(dslLocation.getTaint());
    if(dslLocation == null)        
        {
        NullPointerException var49921CC09DD0ECDA1653AA98E0FD4ACE_61469395 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        var49921CC09DD0ECDA1653AA98E0FD4ACE_61469395.addTaint(taint);
        throw var49921CC09DD0ECDA1653AA98E0FD4ACE_61469395;
        }
        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.830 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "B1543A81EFF5CC682F9B74B125C6ADEF")
    public String getDSLLocation() {
String var56319797F5EE3CFB62504C9DF7482837_1711982524 =         getParameter(ParameterNamesIms.DSL_LOCATION);
        var56319797F5EE3CFB62504C9DF7482837_1711982524.addTaint(taint);
        return var56319797F5EE3CFB62504C9DF7482837_1711982524;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.830 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "A740578E9078935CC27A25C7CF8E6B9C")
    public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        addTaint(ci3Gpp2.getTaint());
    if(ci3Gpp2 == null)        
        {
        NullPointerException varF8B399B00306EE66DFB63411E177853E_2011676616 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        varF8B399B00306EE66DFB63411E177853E_2011676616.addTaint(taint);
        throw varF8B399B00306EE66DFB63411E177853E_2011676616;
        }
        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
        
        
            
                    
                            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.830 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "3CDE03B731FB0B2E06493B4AE16AD504")
    public String getCI3GPP2() {
String varCE2F991713F6651BF4DC93FE5785DC00_1716415306 =         getParameter(ParameterNamesIms.CI_3GPP2);
        varCE2F991713F6651BF4DC93FE5785DC00_1716415306.addTaint(taint);
        return varCE2F991713F6651BF4DC93FE5785DC00_1716415306;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.831 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "F275D628C02B330A902E879BE60B1F3A")
    public void setParameter(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.UTRAN_CELL_ID_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.DSL_LOCATION)
                || name.equalsIgnoreCase(ParameterNamesIms.CI_3GPP2))        
        {
            try 
            {
                super.setQuotedParameter(name, value.toString());
            } 
            catch (ParseException e)
            {
            } 
        } 
        else
        {
            super.setParameter(name, value);
        } 
        
        
                
                
                
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.832 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "80FD077F7D39C174872105E76681967E")
    public void setExtensionAccessInfo(Object extendAccessInfo) throws ParseException {
    if(extendAccessInfo == null)        
        {
        NullPointerException varF558C1AA21B67DD3E64E317BB4572F9C_2130091970 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        varF558C1AA21B67DD3E64E317BB4572F9C_2130091970.addTaint(taint);
        throw varF558C1AA21B67DD3E64E317BB4572F9C_2130091970;
        }
        this.extendAccessInfo = extendAccessInfo;
        
        
            
                    
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.832 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "74BE9EEBE3F53A740417743C42649AC7")
    public Object getExtensionAccessInfo() {
Object var92A160837D8EF0168F11ECE20849458E_225445937 =         this.extendAccessInfo;
        var92A160837D8EF0168F11ECE20849458E_225445937.addTaint(taint);
        return var92A160837D8EF0168F11ECE20849458E_225445937;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.832 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "E942148CEA12D998927AC4E64D821FF6")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
    if(getAccessType() != null)        
        encoding.append(getAccessType());
    if(!parameters.isEmpty())        
        {
            encoding.append(SEMICOLON + SP + this.parameters.encode());
        } 
    if(getExtensionAccessInfo() != null)        
        {
            encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
        } 
String varD48A745DC29A29C7851286E6A426D0D0_595276141 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_595276141.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_595276141;
        
        
        
            
        
            
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.833 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "A9CA636A18B08DDDE5496FD7E93F5AC0")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_80660645 = new ParseException(value, 0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_80660645.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_80660645;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.833 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "8791455B7DF804C03F6E1561EB95297C")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varA5C91BB804C246CD67D472AD4B719C56_65279966 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789189099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_789189099;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.833 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "04176CD65E5A76CE609626DE48AA8783")
    public Object clone() {
        PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_269887174 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_269887174.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_269887174;
        
        
        
    }

    
}

