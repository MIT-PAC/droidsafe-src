package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public class PAccessNetworkInfo extends ParametersHeader implements PAccessNetworkInfoHeader, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.608 -0500", hash_original_field = "A696923051D2A58D159F9B39FEED0908", hash_generated_field = "4265F4D4355352003752ED1DA82667CD")


    private String accessType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.611 -0500", hash_original_field = "4C41B3A690BCB5C2F6D884B522B300D9", hash_generated_field = "0CDE7F70FD33947CCE71E89D96DB001C")


    private Object extendAccessInfo;

    /**
     * Public constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.615 -0500", hash_original_method = "DEE74A53744AC3C87B8E5D43A4E5AAF1", hash_generated_method = "91E7EF6609D8DAD04F568A7121A83655")
    
public PAccessNetworkInfo() {
        super(PAccessNetworkInfoHeader.NAME);
        parameters.setSeparator(SEMICOLON);
    }

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.619 -0500", hash_original_method = "6534876DB72B3A707C2CB418BA871B14", hash_generated_method = "AC34A8190EF9D0A6BD3879F9EA4C45CB")
    
public PAccessNetworkInfo(String accessTypeVal) {
        this();
        setAccessType(accessTypeVal);
    }

    /**
     * Set the accessTpe
     *
     * @param accessTypeVal - access type
     * @throws NullPointerException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.623 -0500", hash_original_method = "D6FCF3C8B020A71473FC0BA5D5C4EFFC", hash_generated_method = "20F47E7829202E1172CC4E5EB80902E4")
    
public void setAccessType(String accessTypeVal) {
        if (accessTypeVal == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setAccessType(), the accessType parameter is null.");

        this.accessType = accessTypeVal;
    }

    /**
     * @return String access type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.626 -0500", hash_original_method = "7B5E071ADED3A6B6E006FB21C0442CF7", hash_generated_method = "E2F83D396E3BFE6CFC04987A88BFC11D")
    
public String getAccessType() {
        return accessType;
    }

    /**
     *
     * @param cgi -- String CGI value
     * @throws NullPointerException -- if null argument passed in
     * @throws ParseException -- if bad argument passed in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.629 -0500", hash_original_method = "E9F3B4E9864C75E8FFBFA10460D6CC15", hash_generated_method = "DBA07E921634B6E5EF99F72BAFEB3F17")
    
public void setCGI3GPP(String cgi) throws ParseException {

        if (cgi == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCGI3GPP(), the cgi parameter is null.");

        setParameter(ParameterNamesIms.CGI_3GPP, cgi);

    }

    /**
     *
     * @return String CGI value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.633 -0500", hash_original_method = "DB7CBC31CF308121D9BAFEDB35CD4092", hash_generated_method = "A45E79A5DE4A5A8ADB82FF6DC04F08AD")
    
public String getCGI3GPP() {
        return getParameter(ParameterNamesIms.CGI_3GPP);
    }

    /**
     * Set the UtranCellID field.
     *
     * @param  utranCellID -- String UTRAN Cell ID value
     * @throws NullPointerException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.636 -0500", hash_original_method = "3441B9130B7E2309E30E20A20941366E", hash_generated_method = "AC3F246D3C80B124CB121536F0AFE125")
    
public void setUtranCellID3GPP(String utranCellID) throws ParseException {

        if (utranCellID == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setUtranCellID3GPP(), the utranCellID parameter is null.");

        setParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP, utranCellID);

    }

    /**
     *
     * @return String UTRAN Cell ID value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.639 -0500", hash_original_method = "0ADE7B7C3AF1E996E987AFD2A2268F3F", hash_generated_method = "560268C317D31311D398DE827FA21A6B")
    
public String getUtranCellID3GPP() {
        return getParameter(ParameterNamesIms.UTRAN_CELL_ID_3GPP);
    }

    /**
     *
     * @param dslLocation - String with the DSL location value
     * @throws NullPointerException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.643 -0500", hash_original_method = "36CD4D2ED6BE8C30DC84C656A727D43F", hash_generated_method = "FECD0A87B992F78D5B01A99C33F2F827")
    
public void setDSLLocation(String dslLocation) throws ParseException {

        if (dslLocation == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setDSLLocation(), the dslLocation parameter is null.");

        setParameter(ParameterNamesIms.DSL_LOCATION, dslLocation);

    }

    /**
     *
     * @return String DSL location value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.646 -0500", hash_original_method = "4D20CBE53C80D56010466434BFFF6884", hash_generated_method = "8AFE48D88FA34430BDED0B8C0DAB3FF5")
    
public String getDSLLocation() {
        return getParameter(ParameterNamesIms.DSL_LOCATION);
    }

    /**
     *
     * @param ci3Gpp2 -- String CI 3GPP2 value
     * @throws NullPointerException -- if arg is null
     * @throws ParseException -- if arg is bad.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.649 -0500", hash_original_method = "8FAF3F13595D3CEC54730D14353CA65A", hash_generated_method = "7367414E6177A4D7A1FB06400BC54EE2")
    
public void setCI3GPP2(String ci3Gpp2) throws ParseException {
        if (ci3Gpp2 == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setCI3GPP2(), the ci3Gpp2 parameter is null.");

        setParameter(ParameterNamesIms.CI_3GPP2, ci3Gpp2);
    }

    /**
     *
     * @return String CI 3GPP2 value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.653 -0500", hash_original_method = "18AE63A32B787BFBE4E7AAC618BF3721", hash_generated_method = "3A19AE7BF16B224E9EBE1D5E5B558A55")
    
public String getCI3GPP2() {
        return getParameter(ParameterNamesIms.CI_3GPP2);
    }

    /**
     *
     * @param name --
     *            parameter name
     * @param value --
     *            value of parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.657 -0500", hash_original_method = "EBE4690A0158C298C62212A7BC5E46A3", hash_generated_method = "F4734D6D56C72B0F7F9D658A9C8DAAD5")
    
public void setParameter(String name, Object value) {
        /**
         * @todo ParametersHeader needs to be fix!? missing "throws
         *       ParseException" in setParameter(String, Object)
         */

        if (name.equalsIgnoreCase(ParameterNamesIms.CGI_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.UTRAN_CELL_ID_3GPP)
                || name.equalsIgnoreCase(ParameterNamesIms.DSL_LOCATION)
                || name.equalsIgnoreCase(ParameterNamesIms.CI_3GPP2)) {
            try {
                super.setQuotedParameter(name, value.toString());
            } catch (ParseException e) {

            }

        } else {
            // value can be token either than a quoted-string
            super.setParameter(name, value);

        }

    }

    /**
     * extension-access-info = gen-value gen-value = token / host /
     * quoted-string
     *
     * @param extendAccessInfo - extended Access Information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.661 -0500", hash_original_method = "14EC79395C271902F7A8954DCD0CA9FB", hash_generated_method = "9D8DC21B2E661CFB236A3E23E197F7D8")
    
public void setExtensionAccessInfo(Object extendAccessInfo)
            throws ParseException {

        if (extendAccessInfo == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Access-Network-Info, setExtendAccessInfo(), the extendAccessInfo parameter is null.");

        // or -> setParameter("", extendAccessInfo);

        this.extendAccessInfo = extendAccessInfo;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.664 -0500", hash_original_method = "1DDCE9F900020BBCC56ECC227A2A793D", hash_generated_method = "83AEFCD17FF33A85ECF496C6E47988A6")
    
public Object getExtensionAccessInfo() {
        return this.extendAccessInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.668 -0500", hash_original_method = "1EAFA3D993C26925ABBC9977DB42C837", hash_generated_method = "D9E442B522372DFDBEB103F441F0565E")
    
protected String encodeBody() {

        StringBuffer encoding = new StringBuffer();

        if (getAccessType() != null)
            encoding.append(getAccessType());

        if (!parameters.isEmpty()) {
            encoding.append(SEMICOLON + SP + this.parameters.encode());
        }
        // else if (getExtendAccessInfo() != null) // stack deve limitar, de
        // acordo com a especificação ?
        if (getExtensionAccessInfo() != null) {
            encoding.append(SEMICOLON + SP
                    + getExtensionAccessInfo().toString());
        }

        return encoding.toString();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.671 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value, 0);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.674 -0500", hash_original_method = "3C3E67AEA43A987A78987E8A7C9369D7", hash_generated_method = "A711518DD1BAB8F3F40B030EBFCB607A")
    
public boolean equals(Object other) {
        return (other instanceof PAccessNetworkInfoHeader) && super.equals(other);
    }

    /*
     * Makes a deep clone. (ParametersHeader)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.677 -0500", hash_original_method = "80A80943646C1EE5D35A726D4DDD4538", hash_generated_method = "DD76636312376A9FF23DDB3EF1FAD52D")
    
public Object clone() {
        PAccessNetworkInfo retval = (PAccessNetworkInfo) super.clone();
        return retval;
    }

    
}

