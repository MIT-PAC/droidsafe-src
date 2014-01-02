package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.WarningHeader;






public class Warning extends SIPHeader implements WarningHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.025 -0500", hash_original_field = "13C733BFEA236EA008D6227D3F43B47A", hash_generated_field = "04331AE451A81F964F3C29BAAEBC8E2A")

    private static final long serialVersionUID = -3433328864230783899L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.029 -0500", hash_original_field = "0AB25991A8A700F155BF903F62C1F5DA", hash_generated_field = "F5A70E4F98FA3F77B9B0CD95DEE2E30D")

    protected int code;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.035 -0500", hash_original_field = "0DD3A276DE929C75BD7EEED978BE3FFF", hash_generated_field = "14267456FD4CBBE9D66A8DE4A6C42A36")

    protected String agent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.040 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "66B33F01239E8E09E0B8D1D466F29BFA")

    protected String text;

    /**
     * constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.045 -0500", hash_original_method = "EC205AAA0E57D7457805C01D650D3D4C", hash_generated_method = "40BC17C0B2C2A09F5451B1AFB0343F9A")
    
public Warning() {
        super(WARNING);
    }

    /** Encode the body of the header (return the stuff following name:).
     *@return the string encoding of the header value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.049 -0500", hash_original_method = "F1B6F008CE79EB2FBE5188D2B8BB2F2C", hash_generated_method = "63D88837AF9AA04B382889DBEED2351C")
    
public String encodeBody() {
        return text != null
            ? Integer.toString(code)
                + SP
                + agent
                + SP
                + DOUBLE_QUOTE
                + text
                + DOUBLE_QUOTE
            : Integer.toString(code) + SP + agent;
    }

    /**
    * Gets code of WarningHeader
    * @return code of WarningHeader
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.054 -0500", hash_original_method = "0DCDBA7E30E559B2571A09070ED05380", hash_generated_method = "C09692D4176718241CABC568676928E7")
    
public int getCode() {
        return code;
    }

    /**
    * Gets agent host of WarningHeader
    * @return agent host of WarningHeader
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.058 -0500", hash_original_method = "7B2F86C2E403FA4426A7AF0306AE1B67", hash_generated_method = "201CE4D5F161DDDAC2567AF68C206C18")
    
public String getAgent() {
        return agent;
    }

    /**
    * Gets text of WarningHeader
    * @return text of WarningHeader
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.063 -0500", hash_original_method = "C0F9B3C9D6FFAEB2F99491C721442157", hash_generated_method = "7679CCF41FBD015A1D63786DE3E0121C")
    
public String getText() {
        return text;
    }

    /**
     * Sets code of WarningHeader
     * @param code int to set
     * @throws SipParseException if code is not accepted by implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.067 -0500", hash_original_method = "741202B8F1CEFA0CCA05AB4A3FC24738", hash_generated_method = "A68C726C4A710A9BA0CCCD7F917DCAD1")
    
public void setCode(int code) throws InvalidArgumentException {
        if (code >99  && code < 1000) { // check this is a 3DIGIT code
            this.code = code;
        } else
            throw new InvalidArgumentException(
                "Code parameter in the Warning header is invalid: code="
                    + code);
    }

    /**
     * Sets host of WarningHeader
     * @param host String to set
     * @throws ParseException if host is not accepted by implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.072 -0500", hash_original_method = "25CC32B68A77A53B595C551260404BAA", hash_generated_method = "2DE84B40517EB311E7788AA4AA37DB44")
    
public void setAgent(String host) throws ParseException {
        if (host == null)
            throw new NullPointerException("the host parameter in the Warning header is null");
        else {
            this.agent = host;
        }
    }

    /**
     * Sets text of WarningHeader
     * @param text String to set
     * @throws ParseException if text is not accepted by implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.077 -0500", hash_original_method = "8DD43A4484C9753D191B662ECF9B8CD6", hash_generated_method = "3A70AE63F4FEFC162B7DC0F0B6B02D38")
    
public void setText(String text) throws ParseException {
        if (text == null) {
            throw new ParseException(
                "The text parameter in the Warning header is null",
                0);
        } else
            this.text = text;
    }
}

