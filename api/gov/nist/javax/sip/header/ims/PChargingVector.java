package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class PChargingVector extends gov.nist.javax.sip.header.ParametersHeader implements PChargingVectorHeader, SIPHeaderNamesIms, ExtensionHeader {

    /**
     * Default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.293 -0500", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "E45256AC9BE7B402FEAB95C496CA137D")
    
public PChargingVector() {

        super(P_CHARGING_VECTOR);
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.header.ParametersHeader#encodeBody()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.297 -0500", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "2127FA58DC7C796BE898D2520CAEFBBE")
    
protected String encodeBody() {

        StringBuffer encoding = new StringBuffer();
        /*
         * no need to check for the presence of icid-value. According to the
         * spec above this is a mandatory field. if it does not exist, then we
         * should throw an exception
         *
         * JvB 26/5: fix for issue #159, check for quotes around icid value
         */
        gov.nist.core.NameValue nv = getNameValue( ParameterNamesIms.ICID_VALUE );
        nv.encode( encoding );

        //the remaining parameters are optional.
        // check for their presence, then add the parameter if it exists.
        if (parameters.containsKey(ParameterNamesIms.ICID_GENERATED_AT))
            encoding.append(SEMICOLON).append(
                    ParameterNamesIms.ICID_GENERATED_AT).append(EQUALS).append(
                    getICIDGeneratedAt());

        if (parameters.containsKey(ParameterNamesIms.TERM_IOI))

            encoding.append(SEMICOLON).append(ParameterNamesIms.TERM_IOI)
                    .append(EQUALS).append(getTerminatingIOI());

        if (parameters.containsKey(ParameterNamesIms.ORIG_IOI))

            encoding.append(SEMICOLON).append(ParameterNamesIms.ORIG_IOI)
                    .append(EQUALS).append(getOriginatingIOI());

        return encoding.toString();
    }

    /**
     * <p>
     * Get the icid-value parameter value
     * </p>
     *
     * @return the value of the icid-value parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.302 -0500", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "C4EF68B293DA907A161EAA6E8768C520")
    
public String getICID() {

        return getParameter(ParameterNamesIms.ICID_VALUE);
    }

    /**
     * <p>
     * Set the icid-value parameter
     * </p>
     *
     * @param icid -
     *            value to set in the icid-value parameter
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.306 -0500", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "02390D1820BB56DDAC79879517E5B1A4")
    
public void setICID(String icid) throws ParseException {

        if (icid == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICID(), the icid parameter is null.");

        setParameter(ParameterNamesIms.ICID_VALUE, icid);

    }

    /**
     * <p>
     * Get the icid-generated-at parameter value
     * </p>
     *
     * @return the icid-generated-at parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.309 -0500", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "D28F8919292C0854C480D364C88F012C")
    
public String getICIDGeneratedAt() {

        return getParameter(ParameterNamesIms.ICID_GENERATED_AT);

    }

    /**
     * <p>
     * Set the icid-generated-at parameter
     * </p>
     *
     * @param host -
     *            value to set in the icid-generated-at parameter
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.313 -0500", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "6A8BBA420E866100D843E5FA8F95F57A")
    
public void setICIDGeneratedAt(String host) throws ParseException {

        if (host == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");

        setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);

    }

    /**
     * <p>
     * Get the orig-ioi parameter value
     * </p>
     *
     * @return the orig-ioi parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.316 -0500", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "743D4A1C1C0F5C6A2C4B198A38D1C279")
    
public String getOriginatingIOI() {

        return getParameter(ParameterNamesIms.ORIG_IOI);
    }

    /**
     * <p>
     * Set the orig-ioi parameter
     * </p>
     *
     * @param origIOI -
     *            value to set in the orig-ioi parameter. If value is null or
     *            empty, the parameter is removed
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.320 -0500", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "401969D016B5DB1EF735E9701F54C2A1")
    
public void setOriginatingIOI(String origIOI) throws ParseException {

        if (origIOI == null || origIOI.length() == 0) {
            removeParameter(ParameterNamesIms.ORIG_IOI);
        } else
            setParameter(ParameterNamesIms.ORIG_IOI, origIOI);

    }

    /**
     * <p>
     * Get the term-ioi parameter value
     * </p>
     *
     * @return the term-ioi parameter value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.323 -0500", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "664D9EC3B3C9B493DA4EE303E31BE1BB")
    
public String getTerminatingIOI() {

        return getParameter(ParameterNamesIms.TERM_IOI);
    }

    /**
     * <p>
     * Set the term-ioi parameter
     * </p>
     *
     * @param termIOI -
     *            value to set in the term-ioi parameter. If value is null or
     *            empty, the parameter is removed
     * @throws ParseException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.328 -0500", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "43BA1EA4D60B466AD13D8EE393DC0F4D")
    
public void setTerminatingIOI(String termIOI) throws ParseException {

        if (termIOI == null || termIOI.length() == 0) {
            removeParameter(ParameterNamesIms.TERM_IOI);
        } else
            setParameter(ParameterNamesIms.TERM_IOI, termIOI);

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.331 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value, 0);

    }
    
}

