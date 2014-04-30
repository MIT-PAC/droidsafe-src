package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

import javax.sip.address.URI;
import javax.sip.header.ErrorInfoHeader;

public final class ErrorInfo extends ParametersHeader implements ErrorInfoHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.829 -0500", hash_original_field = "791D536489C514903E76DAA4549A6C80", hash_generated_field = "9BD0FFEC94B76824606332C7C1A80F81")

    private static final long serialVersionUID = -6347702901964436362L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.832 -0500", hash_original_field = "E209D51164376F85929B22203A06B026", hash_generated_field = "8F903FEA2C89EDECE455B9C7E7CF07FC")

    protected GenericURI errorInfo;

    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.835 -0500", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "920425A7F961A766542027E68BBE215D")
    
public ErrorInfo() {
        super(NAME);
    }

    /**
     * Constructor given the error info
     * @param errorInfo -- the error information to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.839 -0500", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "A29109CFA43DF183FE043DB552ECB560")
    
public ErrorInfo(GenericURI errorInfo) {
        this();
        this.errorInfo = errorInfo;
    }

    /**
     * Encode into canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.842 -0500", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "719D35B248AF1706517F971F9B3687C2")
    
public String encodeBody() {
        StringBuffer retval =
            new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
        if (!parameters.isEmpty()) {
            retval.append(SEMICOLON).append(parameters.encode());
        }
        return retval.toString();
    }

    /**
     * Sets the ErrorInfo of the ErrorInfoHeader to the <var>errorInfo</var>
     * parameter value.
     *
     * @param errorInfo the new ErrorInfo of this ErrorInfoHeader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.844 -0500", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "7C1BCC06BFC849342C899C0F3DA68BB8")
    
public void setErrorInfo(javax.sip.address.URI errorInfo) {
        this.errorInfo = (GenericURI) errorInfo;

    }

    /**
     * Returns the ErrorInfo value of this ErrorInfoHeader. This message
     * may return null if a String message identifies the ErrorInfo.
     *
     * @return the URI representing the ErrorInfo.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.847 -0500", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "A2C85436611C1E6C971751A5AE9C48FD")
    
public URI getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets the Error information message to the new <var>message</var> value
     * supplied to this method.
     *
     * @param message - the new string value that represents the error message.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the error message.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.849 -0500", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "9DFBC8F57ECFEEC783E54C15958523F0")
    
public void setErrorMessage(String message) throws ParseException {
        if (message == null)
            throw new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        setParameter("message", message);
    }

    /**
     * Get the Error information message of this ErrorInfoHeader.
     *
     * @return the stringified version of the ErrorInfo header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.852 -0500", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "D8BBA929BDD3DFB34137BEC9E30DBE62")
    
public String getErrorMessage() {
        return getParameter("message");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.855 -0500", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "58A93F84D67668D0D8D65F60ACC662F5")
    
public Object clone() {
        ErrorInfo retval = (ErrorInfo) super.clone();
        if (this.errorInfo != null)
            retval.errorInfo = (GenericURI) this.errorInfo.clone();
        return retval;
    }
}

