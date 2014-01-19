package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.RetryAfterHeader;

public class RetryAfter extends ParametersHeader implements RetryAfterHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.890 -0500", hash_original_field = "53788FC2EFE21B05993D0333891B7891", hash_generated_field = "B2AC1F82873AC3043D2A9F969B88DCB0")

    private static final long serialVersionUID = -1029458515616146140L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.893 -0500", hash_original_field = "85C9E0AAE39AB09C30FB0116AB569AEE", hash_generated_field = "78034668ED13E4C36E5EDE2705F12AE3")

    public static final String DURATION = ParameterNames.DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.896 -0500", hash_original_field = "36504241F4F992B91E9DA617BB336448", hash_generated_field = "7E62DE420E31BD45BF50074711B37EB1")

    protected Integer retryAfter = new Integer(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.899 -0500", hash_original_field = "6C9FE4127C88B2FD28EFE861CA65A713", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.903 -0500", hash_original_method = "5EF666CD25CA3C0D16B00CF8EC3126E1", hash_generated_method = "5B9A1EA301F48CD574745C730D016F37")
    
public RetryAfter() {
        super(NAME);
    }

    /** Encode body of this into cannonical form.
     * @return encoded body
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.906 -0500", hash_original_method = "1D294A58F2AF56C9FF5AA47948D4FB5C", hash_generated_method = "E9923B82A81C7844CF398360A889445F")
    
public String encodeBody() {
        StringBuffer s = new StringBuffer();
        
        if (retryAfter != null)
            s.append(retryAfter);

        if (comment != null)
            s.append(SP + LPAREN + comment + RPAREN);

        if (!parameters.isEmpty()) {
            s.append(SEMICOLON + parameters.encode());
        }

        return s.toString();
    }

    /** Boolean function
     * @return true if comment exist, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.909 -0500", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "4AECA1BA2AB25600F1AD63164D2ACAC2")
    
public boolean hasComment() {
        return comment != null;
    }

    /** remove comment field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.912 -0500", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "4C5598F3753C2A0079DD4D0DD691D05A")
    
public void removeComment() {
        comment = null;
    }

    /** remove duration field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.914 -0500", hash_original_method = "D3E525F6B574030796E656911FFC55CD", hash_generated_method = "118C65E13828C54F00900E8E296208A9")
    
public void removeDuration() {
        super.removeParameter(DURATION);
    }

    /**
     * Sets the retry after value of the RetryAfterHeader.
     * The retry after value MUST be greater than zero and
     * MUST be less than 2**31.
     *
     * @param retryAfter - the new retry after value of this RetryAfterHeader
     * @throws InvalidArgumentException if supplied value is less than zero.
     *
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.918 -0500", hash_original_method = "F25BCD66BB29500F6C458D690EB883C8", hash_generated_method = "94E3F74B497123D08CF2A7691AD0B887")
    
public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
        if (retryAfter < 0)
            throw new InvalidArgumentException(
                "invalid parameter " + retryAfter);
        this.retryAfter = Integer.valueOf(retryAfter);
    }

    /**
     * Gets the retry after value of the RetryAfterHeader. This retry after
     * value is relative time.
     *
     * @return the retry after value of the RetryAfterHeader.
     *
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.921 -0500", hash_original_method = "2986C3BA8F6864799163ED0F6663DF18", hash_generated_method = "1C3CDEEF56F10DD210E8B5582AD6DC07")
    
public int getRetryAfter() {
        return retryAfter.intValue();
    }

    /**
     * Gets the comment of RetryAfterHeader.
     *
     * @return the comment of this RetryAfterHeader, return null if no comment
     * is available.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.924 -0500", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E40F10878D62F1009133973700BC0B5C")
    
public String getComment() {
        return comment;
    }

    /**
     * Sets the comment value of the RetryAfterHeader.
     *
     * @param comment - the new comment string value of the RetryAfterHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the comment.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.927 -0500", hash_original_method = "3E03F4EDAEEF7A953B18FA1E34879AC1", hash_generated_method = "92FA274C155E0BB36CFABA6F81D23EA3")
    
public void setComment(String comment) throws ParseException {
        if (comment == null)
            throw new NullPointerException("the comment parameter is null");
        this.comment = comment;
    }

    /**
     * Sets the duration value of the RetryAfterHeader. The retry after value
     * MUST be greater than zero and MUST be less than 2**31.
     *
     * @param duration - the new duration value of this RetryAfterHeader
     * @throws InvalidArgumentException if supplied value is less than zero.
     *
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.930 -0500", hash_original_method = "7BA99CB446FF1B0F64CCC86D40E4D1B9", hash_generated_method = "A07234399F3A781352E6D49244863D4D")
    
public void setDuration(int duration) throws InvalidArgumentException {
        if (duration < 0)
            throw new InvalidArgumentException("the duration parameter is <0");
        this.setParameter(DURATION, duration);
    }

    /**
     * Gets the duration value of the RetryAfterHeader. This duration value
     * is relative time.
     *
     * @return the duration value of the RetryAfterHeader, return zero if not
     * set.
     *
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.933 -0500", hash_original_method = "B3E153B821BFB44B99CC6101FC6E67A6", hash_generated_method = "2D478A4C5720BF8E8855ACA86DB46240")
    
public int getDuration() {
      if (this.getParameter(DURATION) == null) return -1;
      else return super.getParameterAsInt(DURATION);
    }
}

