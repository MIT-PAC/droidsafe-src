package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;

import java.text.ParseException;






public final class AuthenticationInfo extends ParametersHeader implements javax.sip.header.AuthenticationInfoHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.248 -0500", hash_original_field = "F0904DE5614084BF107B00049E857DFC", hash_generated_field = "7AD675CC1A8C3510545F19A418D005F3")

    private static final long serialVersionUID = -4371927900917127057L;

    /** Default contstructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.252 -0500", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "8C779D41B6773A6B4924C7A9509A8B3E")
    
public AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA); // Odd ball.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.256 -0500", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "AABDF2B87EDE286560C2ACBFC5BDE347")
    
public void add(NameValue nv) {
        parameters.set(nv);
    }

    /** Value of header encoded in canonical form.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.259 -0500", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "858465DF6EF0739C3EAC5171186AACA0")
    
protected String encodeBody() {
        return parameters.encode();

    }

    /** Get the name value pair for a given authentication info parameter.
     *
     *@param name is the name for which we want to retrieve the name value
     *  list.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.262 -0500", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "6162C1372B345C99FCD729BDF4A871F0")
    
public NameValue getAuthInfo(String name) {
        return parameters.getNameValue(name);
    }

    /**
     * Returns the AuthenticationInfo value of this AuthenticationInfoHeader.
     *
     *
     *
     * @return the String representing the AuthenticationInfo
     *
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.266 -0500", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "1EB28D1C34F82AD38B09D4E2ED3CEB8D")
    
public String getAuthenticationInfo() {
        return this.encodeBody();
    }

    /** Returns the CNonce value of this AuthenticationInfoHeader.
     *
     * @return the String representing the cNonce information, null if value is
     * not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.269 -0500", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "37FEE7B5E119C76CD60400CB0A3D0EDF")
    
public String getCNonce() {
        return this.getParameter(ParameterNames.CNONCE);
    }

    /** Returns the nextNonce value of this AuthenticationInfoHeader.
     *
     * @return the String representing the nextNonce
     * information, null if value is not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.272 -0500", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "796BF8E5CFD9EA81AC46DBCF52C2EB0E")
    
public String getNextNonce() {
        return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    /** Returns the Nonce Count value of this AuthenticationInfoHeader.
     *
     * @return the integer representing the nonceCount information, -1 if value is
     * not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.276 -0500", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "77BBBF52428C3BF1C01D276EF9A4D250")
    
public int getNonceCount() {
        return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    /** Returns the messageQop value of this AuthenticationInfoHeader.
     *
     * @return the string representing the messageQop information, null if the
     * value is not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.279 -0500", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "B5E86F61504F5985CB67A6B8707229C7")
    
public String getQop() {
        return this.getParameter(ParameterNames.QOP);
    }

    /** Returns the Response value of this AuthenticationInfoHeader.
     *
     * @return the String representing the Response information.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.282 -0500", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "47DF677BEA36CBAFD816670154B1BBF1")
    
public String getResponse() {
        return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    /** Sets the CNonce of the AuthenticationInfoHeader to the <var>cNonce</var>
     * parameter value.
     *
     * @param cNonce - the new cNonce String of this AuthenticationInfoHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the cNonce value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.285 -0500", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "41B51486494C7F58E8AA7B109E22F147")
    
public void setCNonce(String cNonce) throws ParseException {
        this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    /** Sets the NextNonce of the AuthenticationInfoHeader to the <var>nextNonce</var>
     * parameter value.
     *
     * @param nextNonce - the new nextNonce String of this AuthenticationInfoHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the nextNonce value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.288 -0500", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "F0203C4E3CF29EE7527705A5F7857885")
    
public void setNextNonce(String nextNonce) throws ParseException {
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    /** Sets the Nonce Count of the AuthenticationInfoHeader to the <var>nonceCount</var>
     * parameter value.
     *
     * @param nonceCount - the new nonceCount integer of this AuthenticationInfoHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the nonceCount value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.292 -0500", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "CF674C872915BC75F32CA37B4DE3CDD6")
    
public void setNonceCount(int nonceCount) throws ParseException {
        if (nonceCount < 0)
            throw new ParseException("bad value", 0);
        String nc = Integer.toHexString(nonceCount);

        String base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);
    }

    /** Sets the Qop value of the AuthenticationInfoHeader to the new
     * <var>qop</var> parameter value.
     *
     * @param qop - the new Qop string of this AuthenticationInfoHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the Qop value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.295 -0500", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "96D88A7459BA250900A548C0248407F8")
    
public void setQop(String qop) throws ParseException {
        this.setParameter(ParameterNames.QOP, qop);
    }

    /** Sets the Response of the
     * AuthenticationInfoHeader to the new <var>response</var>
     * parameter value.
     *
     * @param response - the new response String of this
     * AuthenticationInfoHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the Response.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.298 -0500", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "14AB0D437B9A8157E738FF3B6C029A94")
    
public void setResponse(String response) throws ParseException {
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.303 -0500", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "BEC8F8B3E0AEB5F651FA8DA5B4532999")
    
public void setParameter(String name, String value) throws ParseException {
        if (name == null)
            throw new NullPointerException("null name");
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if (nv == null) {
            nv = new NameValue(name, value);
            if (name.equalsIgnoreCase(ParameterNames.QOP)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.REALM)
                || name.equalsIgnoreCase(ParameterNames.CNONCE)
                || name.equalsIgnoreCase(ParameterNames.NONCE)
                || name.equalsIgnoreCase(ParameterNames.OPAQUE)
                || name.equalsIgnoreCase(ParameterNames.USERNAME)
                || name.equalsIgnoreCase(ParameterNames.DOMAIN)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.RESPONSE_AUTH)) {
                if (value == null)
                    throw new NullPointerException("null value");
                if (value.startsWith(Separators.DOUBLE_QUOTE))
                    throw new ParseException(
                        value + " : Unexpected DOUBLE_QUOTE",
                        0);
                nv.setQuotedValue();
            }
            super.setParameter(nv);
        } else
            nv.setValueAsObject(value);
    }
}

