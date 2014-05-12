package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.Parameters;

public abstract class SecurityAgree extends ParametersHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.021 -0500", hash_original_field = "146F3AF228A8EBD016754C7327503614", hash_generated_field = "B86FF84E39A7B19F8887BD2615927536")

    //private static final long serialVersionUID = -6671234553927258745L;

    //public static final String EALG = ParameterNamesIms.EALG;
    // ...

    /**
     * Security Mechanism value
     */
    private String secMechanism;

    /**
     * Constructor
     * @param name - name of the Security Agree header to create
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.025 -0500", hash_original_method = "37860681C961C756ECC7AFD430C41B9D", hash_generated_method = "242F326FD863FEFBB31CF2FE3F2757B3")
    
public SecurityAgree(String name)
    {
        super(name);
        parameters.setSeparator(Separators.SEMICOLON);
    }

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.028 -0500", hash_original_method = "0AED97FED716BE0BE4710B84F9A63527", hash_generated_method = "0C3A350126268E87A2E25AC163DCCBF6")
    
public SecurityAgree()
    {
        super();
        parameters.setSeparator(Separators.SEMICOLON);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.032 -0500", hash_original_method = "9AC5B140B15B11CFD450C965DE3EDCEF", hash_generated_method = "509F056BBA9BF53BB895A98CBBED4B13")
    
public void setParameter(String name, String value) throws ParseException
    {
        if (value == null)
            throw new NullPointerException("null value");

        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if (nv == null)
        {
            nv = new NameValue(name, value);

            // quoted values
            if (name.equalsIgnoreCase(ParameterNamesIms.D_VER))
            {
                nv.setQuotedValue();

                if (value.startsWith(Separators.DOUBLE_QUOTE))
                    throw new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
            }

            super.setParameter(nv);
        }
        else
        {
            nv.setValueAsObject(value);
        }

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.035 -0500", hash_original_method = "6B925B5DF777A76390B5A8992D469F0E", hash_generated_method = "E8743000B71DCE0A96254AB18F9F716F")
    
public String encodeBody()
    {
        return this.secMechanism + SEMICOLON + SP + parameters.encode();
    }

    /**
     * Set security mechanism.
     * <p>eg: Security-Client: ipsec-3gpp</p>
     * @param secMech - security mechanism name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.038 -0500", hash_original_method = "26617F329EF35F53927C51BE793DE18C", hash_generated_method = "9EA40010452B33BBFECF16C1B99E5113")
    
public void setSecurityMechanism(String secMech) throws ParseException {
        if (secMech == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        this.secMechanism = secMech;
    }

    /**
     * Set Encryption Algorithm (ealg parameter)
     * @param ealg - encryption algorithm value
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.042 -0500", hash_original_method = "C9B1596896385C915B9F0E305B24E414", hash_generated_method = "A7BC29347A4C5F2DAF8B701BCD310E61")
    
public void setEncryptionAlgorithm(String ealg) throws ParseException {
        if (ealg == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");

        setParameter(ParameterNamesIms.EALG, ealg);
    }

    /**
     * Set Algorithm (alg parameter)
     * @param alg - algorithm value
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.045 -0500", hash_original_method = "1034CB07B31AD4B972026DDB8CD1CF5A", hash_generated_method = "C920D9C9E3FE7CDEFA1D3C472F9B1DC6")
    
public void setAlgorithm(String alg) throws ParseException {
        if (alg == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        setParameter(ParameterNamesIms.ALG, alg);
    }

    /**
     * Set Protocol (prot paramater)
     * @param prot - protocol value
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.049 -0500", hash_original_method = "445CF41DA92D45C4C84C6BEE36D36BF6", hash_generated_method = "FEC21688D4F5371392F82FE61B7B8A33")
    
public void setProtocol(String prot) throws ParseException {
        if (prot == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        setParameter(ParameterNamesIms.PROT, prot);
    }

    /**
     * Set Mode (mod parameter)
     * @param mod - mode value
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.053 -0500", hash_original_method = "E016DD00F9E773B1BC74C49DD038424A", hash_generated_method = "C3F52653412DE6FCEE61CD6387FBC022")
    
public void setMode(String mod) throws ParseException {
        if (mod == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setMode(), the mode parameter is null");
        setParameter(ParameterNamesIms.MOD, mod);
    }

    /**
     * Set Client SPI (spi-c parameter)
     * @param spic - spi-c value
     * @throws InvalidArgumentException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.056 -0500", hash_original_method = "75DD86B518B8282C26250CE6A2B99A28", hash_generated_method = "7D8F4FFF7186646051C5F590F244443B")
    
public void setSPIClient(int spic) throws InvalidArgumentException {
        if (spic < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        setParameter(ParameterNamesIms.SPI_C, spic);
    }

    /**
     * Set Server SPI (spi-s parameter)
     * @param spis - spi-s value
     * @throws InvalidArgumentException - when value is not valid
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.059 -0500", hash_original_method = "3C648084DC1BE07708C4C0C2C0242BDB", hash_generated_method = "F98FBC535BCCC8DE19CF23EEAFFAF03F")
    
public void setSPIServer(int spis) throws InvalidArgumentException {
        if (spis < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        setParameter(ParameterNamesIms.SPI_S, spis);
    }

    /**
     * Set Client Port (port-c parameter)
     * @param portC - port-c value
     * @throws InvalidArgumentException - when value is not valid
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.062 -0500", hash_original_method = "EF3E10E5EB6E9ADB9B0EAA61EFC25272", hash_generated_method = "6147B4C6C251244A98982B41B9231BD8")
    
public void setPortClient(int portC) throws InvalidArgumentException {
        if (portC < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        setParameter(ParameterNamesIms.PORT_C, portC);
    }

    /**
     * Set Server Port (port-s parameter)
     * @param portS - port-s value
     * @throws InvalidArgumentException - when value is not valid
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.065 -0500", hash_original_method = "AE705CDEF098778FC0F68E357BFDF4CB", hash_generated_method = "58E743C3D0089E7D6277EED06FC15B27")
    
public void setPortServer(int portS) throws InvalidArgumentException {
        if (portS < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        setParameter(ParameterNamesIms.PORT_S, portS);
    }

    /**
     * <p>Set Preference.
     * The "q" parameter indicates a relative preference for the particular mechanism.
     * The higher the value the more preferred the mechanism is.
     * Range from 0.001 to 0.999.</p>
     * @param q - q parameter value
     * @throws InvalidArgumentException - when value is not valid
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.069 -0500", hash_original_method = "6E802E2384BCAE9DA923A1C36DFE2987", hash_generated_method = "B2481C956D269AD79A3718B0A369DCA5")
    
public void setPreference(float q) throws InvalidArgumentException {
        if (q < 0.0f)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        setParameter(ParameterNamesIms.Q, q);
    }

    // get param

    /**
     * Get Security Mechanism
     * @return security mechanims value
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.073 -0500", hash_original_method = "B428180B0BF5EA600E8FA7F08EE496F8", hash_generated_method = "08E3C50D04C59E763C0E2324F9F021A3")
    
public String getSecurityMechanism() {
        return this.secMechanism;
    }
    /**
     * Get Encryption Algorithm
     * @return ealg parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.076 -0500", hash_original_method = "E48981B0D788C9F15FB0701B5A5A9BFB", hash_generated_method = "B2D10D296E3BB5BCDD61B28712B05413")
    
public String getEncryptionAlgorithm() {
        return getParameter(ParameterNamesIms.EALG);
    }

    /**
     * Get Algorithm
     * @return alg parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.078 -0500", hash_original_method = "10709FDAA4AFF85555E2A3D151185971", hash_generated_method = "9E2A7DCD89D789B50C8DC73E7EC8C211")
    
public String getAlgorithm() {
        return getParameter(ParameterNamesIms.ALG);
    }

    /**
     * Get Protocol
     * @return prot parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.081 -0500", hash_original_method = "D8F37ABD0A193610338515FA46330650", hash_generated_method = "BEFC7F9E21500C70B788DD59F64C617B")
    
public String getProtocol() {
        return getParameter(ParameterNamesIms.PROT);
    }

    /**
     * Get Mode
     * @return mod parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.084 -0500", hash_original_method = "F9C1DAC229A690F6459CC03AC622A5E3", hash_generated_method = "E5E8145A79C72E91AAEF606A81153385")
    
public String getMode() {
        return getParameter(ParameterNamesIms.MOD);

    }
    /**
     * Get Client SPI
     * @return spi-c parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.088 -0500", hash_original_method = "2AA9C7181C6D09D271CB928F8ADC4E6A", hash_generated_method = "85B7F6113F9760E0BBC4D6C25E2AF9F8")
    
public int getSPIClient() {
        return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_C)));
    }

    /**
     * Get Server SPI
     * @return spi-s parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.091 -0500", hash_original_method = "87F3A8BE8E0310CD1D9EAD100DF812CC", hash_generated_method = "773DB7D4CF48A40FF9FAB994D05B91B4")
    
public int getSPIServer() {
        return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_S)));
    }

    /**
     * Get Client Port
     * @return port-c parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.094 -0500", hash_original_method = "452A6BD881785C9FC11C999CB3A20207", hash_generated_method = "F8BA68C6EBAF287CBC3C697602023FA8")
    
public int getPortClient() {
        return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_C)));
    }

    /**
     * Get Server Port
     * @return port-s parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.097 -0500", hash_original_method = "107465724D48A961682620CCB1B6C016", hash_generated_method = "FD726AAAE6EFB21F021FD2A88C7CA200")
    
public int getPortServer() {
        return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_S)));
    }

    /**
     * Get Preference
     * @return q parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.100 -0500", hash_original_method = "618486245568CF743B7149F19C0097DE", hash_generated_method = "B178ED3BB3ABC7587D21AE20DA71CD50")
    
public float getPreference() {
        return (Float.parseFloat(getParameter(ParameterNamesIms.Q)));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.104 -0500", hash_original_method = "AD0CCA4E33EB4C4CCEB107F65F233D48", hash_generated_method = "D2864490D9915CAB3F7DC7D092E6E822")
    
public boolean equals(Object other)
    {

        if(other instanceof SecurityAgreeHeader)
        {
            SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            return (this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                && this.equalParameters( (Parameters) o ));
        }
        return false;

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.108 -0500", hash_original_method = "027A143FB16239A6EF6573784EA7EAA2", hash_generated_method = "9CDB4A26E1662D64A7562B06E580DD62")
    
public Object clone() {
        SecurityAgree retval = (SecurityAgree) super.clone();
        if (this.secMechanism != null)
            retval.secMechanism = this.secMechanism;
        return retval;
    }
    
}

