package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ParametersHeader;

public class PAccessNetworkInfo extends ParametersHeader implements PAccessNetworkInfoHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.994 -0400", hash_original_field = "C094CFF5A400E24D3E32C2F411A1B793", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")

    private String accessType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.994 -0400", hash_original_field = "849A050A2DDE1357870F15A44C8398CE", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")

    private Object extendAccessInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.994 -0400", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "65F3138D03DFD60A3C1CA7CFEA9ABE25")
    public  PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.995 -0400", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "994A5E9F7763AD51E3ED2D1F94600F2B")
    public  PAccessNetworkInfo(String accessTypeVal) {
        this();
        addTaint(accessTypeVal.getTaint());
        setAccessType(accessTypeVal);
        // ---------- Original Method ----------
        //setAccessType(accessTypeVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.995 -0400", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "5D5FC3AFEEEF41A8566F92DB448E73E8")
    public void setAccessType(String accessTypeVal) {
        if(accessTypeVal == null)        
        {
        NullPointerException varC04CF5D9AD3BD8261BA02B62BA142947_2028574156 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        varC04CF5D9AD3BD8261BA02B62BA142947_2028574156.addTaint(taint);
        throw varC04CF5D9AD3BD8261BA02B62BA142947_2028574156;
        }
        this.accessType = accessTypeVal;
        // ---------- Original Method ----------
        //if (accessTypeVal == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");
        //this.accessType = accessTypeVal;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.995 -0400", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "471019DB517CEE09E00696CC4AD315E5")
    public String getAccessType() {
String var13839985BF7A2123F9C538846603D7DA_1567410722 =         accessType;
        var13839985BF7A2123F9C538846603D7DA_1567410722.addTaint(taint);
        return var13839985BF7A2123F9C538846603D7DA_1567410722;
        // ---------- Original Method ----------
        //return accessType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.996 -0400", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "9A86F70C5029A8A6ABCE8D99D73C0976")
    public void setCGI3GPP(String cgi) throws ParseException {
        addTaint(cgi.getTaint());
        if(cgi == null)        
        {
        NullPointerException varFF8AA56D7D55F1B17FB0AD2ABCAABD51_2009119786 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        varFF8AA56D7D55F1B17FB0AD2ABCAABD51_2009119786.addTaint(taint);
        throw varFF8AA56D7D55F1B17FB0AD2ABCAABD51_2009119786;
        }
        setParameter(ParameterNamesIms.CGI_3GPP, cgi);
        // ---------- Original Method ----------
        //if (cgi == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");
        //setParameter(ParameterNamesIms.CGI_3GPP, cgi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.996 -0400", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "DE7FC740AE4FEBEA0F84233A8FF1F868")
    public String getCGI3GPP() {
String var3812EB68A035524A86CF47B940DCA391_1222658306 =         getParameter(ParameterNamesIms.CGI_3GPP);
        var3812EB68A035524A86CF47B940DCA391_1222658306.addTaint(taint);
        return var3812EB68A035524A86CF47B940DCA391_1222658306;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CGI_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.996 -0400", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "ABF435C3AE4DAB96D42493BFB0F41173")
    public void setUtranCellID3GPP(String utranCellID) throws ParseException {
        addTaint(utranCellID.getTaint());
        if(utranCellID == null)        
        {
        NullPointerException varCEFC84FAAD9C65938851144DF0556B69_479485822 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        varCEFC84FAAD9C65938851144DF0556B69_479485822.addTaint(taint);
        throw varCEFC84FAAD9C65938851144DF0556B69_479485822;
        }
        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
        // ---------- Original Method ----------
        //if (utranCellID == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");
        //setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.997 -0400", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "5515B88E89A9930AC70D8B05A398828C")
    public String getUtranCellID3GPP() {
String varB7D6779487FCB9E7AA24DA0384F3987E_2018048575 =         getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
        varB7D6779487FCB9E7AA24DA0384F3987E_2018048575.addTaint(taint);
        return varB7D6779487FCB9E7AA24DA0384F3987E_2018048575;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.997 -0400", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "BAA1F24B401F4051A3757ADC524C0E99")
    public void setDSLLocation(String dslLocation) throws ParseException {
        addTaint(dslLocation.getTaint());
        if(dslLocation == null)        
        {
        NullPointerException var49921CC09DD0ECDA1653AA98E0FD4ACE_1811408470 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        var49921CC09DD0ECDA1653AA98E0FD4ACE_1811408470.addTaint(taint);
        throw var49921CC09DD0ECDA1653AA98E0FD4ACE_1811408470;
        }
        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
        // ---------- Original Method ----------
        //if (dslLocation == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");
        //setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.997 -0400", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "E10718C1062BE76946860F518C4C7DBF")
    public String getDSLLocation() {
String var56319797F5EE3CFB62504C9DF7482837_1386888619 =         getParameter(ParameterNamesIms.DSL_LOCATION);
        var56319797F5EE3CFB62504C9DF7482837_1386888619.addTaint(taint);
        return var56319797F5EE3CFB62504C9DF7482837_1386888619;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.DSL_LOCATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.998 -0400", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "8019DF5A344EC163F744A4F46DAD36BF")
    public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        addTaint(ci3Gpp2.getTaint());
        if(ci3Gpp2 == null)        
        {
        NullPointerException varF8B399B00306EE66DFB63411E177853E_815591492 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        varF8B399B00306EE66DFB63411E177853E_815591492.addTaint(taint);
        throw varF8B399B00306EE66DFB63411E177853E_815591492;
        }
        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
        // ---------- Original Method ----------
        //if (ci3Gpp2 == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");
        //setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.998 -0400", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "D7BACD60CB98CE6986E2F7A8D7828A96")
    public String getCI3GPP2() {
String varCE2F991713F6651BF4DC93FE5785DC00_191281456 =         getParameter(ParameterNamesIms.CI_3GPP2);
        varCE2F991713F6651BF4DC93FE5785DC00_191281456.addTaint(taint);
        return varCE2F991713F6651BF4DC93FE5785DC00_191281456;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CI_3GPP2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.998 -0400", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "F275D628C02B330A902E879BE60B1F3A")
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
            } //End block
            catch (ParseException e)
            {
            } //End block
        } //End block
        else
        {
            super.setParameter(name, value);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.999 -0400", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "D8CC1D243860E6AD0E3C4AA093FA2A43")
    public void setExtensionAccessInfo(Object extendAccessInfo) throws ParseException {
        if(extendAccessInfo == null)        
        {
        NullPointerException varF558C1AA21B67DD3E64E317BB4572F9C_81070486 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        varF558C1AA21B67DD3E64E317BB4572F9C_81070486.addTaint(taint);
        throw varF558C1AA21B67DD3E64E317BB4572F9C_81070486;
        }
        this.extendAccessInfo = extendAccessInfo;
        // ---------- Original Method ----------
        //if (extendAccessInfo == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");
        //this.extendAccessInfo = extendAccessInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.000 -0400", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "66B1D648E4B848C97110D1E81C8FA2AA")
    public Object getExtensionAccessInfo() {
Object var92A160837D8EF0168F11ECE20849458E_358224723 =         this.extendAccessInfo;
        var92A160837D8EF0168F11ECE20849458E_358224723.addTaint(taint);
        return var92A160837D8EF0168F11ECE20849458E_358224723;
        // ---------- Original Method ----------
        //return this.extendAccessInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.000 -0400", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "7F539465189CF5E80AFDD2ABC5CF1759")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        if(getAccessType() != null)        
        encoding.append(getAccessType());
        if(!parameters.isEmpty())        
        {
            encoding.append(SEMICOLON + SP + this.parameters.encode());
        } //End block
        if(getExtensionAccessInfo() != null)        
        {
            encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1991775628 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1991775628.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1991775628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.000 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "6C11BAD9357D4988BD67358362718391")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1697374572 = new ParseException(value, 0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1697374572.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1697374572;
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.001 -0400", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "2570FD9AF376DE8916963F4AC44A728D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varA5C91BB804C246CD67D472AD4B719C56_1080927761 = ((other instanceof PAccessNetworkInfoHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912252424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912252424;
        // ---------- Original Method ----------
        //return (other instanceof PAccessNetworkInfoHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.001 -0400", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "044159E09396A7960253B6C0B8A1D0DF")
    public Object clone() {
        PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_23269394 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_23269394.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_23269394;
        // ---------- Original Method ----------
        //PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        //return retval;
    }

    
}

