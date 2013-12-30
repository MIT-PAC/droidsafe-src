package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;

import java.text.ParseException;






public abstract class AuthenticationHeader extends ParametersHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.909 -0500", hash_original_field = "0C44A58709479306B86B0611FCABFC25", hash_generated_field = "17FF58D2E4819C468CD0033E52CC7881")


    public static final String DOMAIN = ParameterNames.DOMAIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.912 -0500", hash_original_field = "1275ADD4899A05374E4917DEB3E85A56", hash_generated_field = "EBBD9BA1BADBAC5EF593F488645D5C46")


    public static final String REALM = ParameterNames.REALM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.915 -0500", hash_original_field = "81FBABA1EA606A8FA62DB9607A4FE8BA", hash_generated_field = "04CDC06BB0A5B6663DDA46DEE36CCB2B")


    public static final String OPAQUE = ParameterNames.OPAQUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.918 -0500", hash_original_field = "0BDB2E931C77EE01757E7E39F51323F7", hash_generated_field = "591C458296CAAD3DAD3DC69D39923AB3")


    public static final String ALGORITHM = ParameterNames.ALGORITHM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.922 -0500", hash_original_field = "467F6A3015D0A09F1AD10451955B0FA4", hash_generated_field = "7862B7814B761743D8679A1CE71BE925")


    public static final String QOP = ParameterNames.QOP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.925 -0500", hash_original_field = "A3C5D0834CA28C61E526EFE1B82B6B04", hash_generated_field = "9254AA79BC5CBC7DBBCE98D12C5618BC")


    public static final String STALE = ParameterNames.STALE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.929 -0500", hash_original_field = "C3F46FDD688E9B421594AAA8A6AC9EC3", hash_generated_field = "EC08D758804B4FDE227D2AAB23EED546")


    public static final String SIGNATURE = ParameterNames.SIGNATURE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.932 -0500", hash_original_field = "4589237E4C15BE9E58625B89E2F768D7", hash_generated_field = "0BBA7683ABB90D800A75724CF582A61A")


    public static final String RESPONSE = ParameterNames.RESPONSE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.935 -0500", hash_original_field = "E29A15EF258616A7A5914BE34AD5CFD4", hash_generated_field = "C2AF6C64E388AB2628A7844DCD27068F")


    public static final String SIGNED_BY = ParameterNames.SIGNED_BY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.938 -0500", hash_original_field = "B0423270CF67D4B30F83F52F789C0539", hash_generated_field = "945C00AD0FB2001FDFE332FC462F84B5")


    public static final String NC = ParameterNames.NC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.942 -0500", hash_original_field = "0E8BEAC5A0A9AAAE1E1CD6CDD2FE317F", hash_generated_field = "E0529E04E9C46EB7B3C9AFFEEB80131C")


    public static final String URI = ParameterNames.URI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.946 -0500", hash_original_field = "AB898748C444A07AD10F404A27361063", hash_generated_field = "141BBA99C5BA0E2C564C80B92D9ECEF4")


    public static final String USERNAME = ParameterNames.USERNAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.949 -0500", hash_original_field = "10AAA79FDFC92662FFD47EF0786E23AF", hash_generated_field = "7628B0C67486A8D201E3E813C670AEFA")


    public static final String CNONCE = ParameterNames.CNONCE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.953 -0500", hash_original_field = "C8B218AA96ADB2F432D4C2E2FBC23F05", hash_generated_field = "4FA62036A736AEB7215955B884E2C736")


    public static final String NONCE = ParameterNames.NONCE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.956 -0500", hash_original_field = "94BB9F892BFF2F6F53972B57303AB217", hash_generated_field = "509D45CD35B3A28E9024383BC022E75B")


    public static final String IK = ParameterNamesIms.IK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.959 -0500", hash_original_field = "55F393DE13C883134910B16185A7B2D3", hash_generated_field = "D36E5E6DD689766EC5136A3D190A0B78")

    public static final String CK = ParameterNamesIms.CK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.962 -0500", hash_original_field = "6AE837C289062B6A8779E0901E1A79BC", hash_generated_field = "2AD0537217FB260E580A1D4CCD6793D9")

    public static final String INTEGRITY_PROTECTED = ParameterNamesIms.INTEGRITY_PROTECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.965 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")


    protected String scheme;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.969 -0500", hash_original_method = "54F496DB6FA267582688938E2479AFBA", hash_generated_method = "0F9E71876BD3662DAF8367F64EDC75A9")
    
public AuthenticationHeader(String name) {
        super(name);
        parameters.setSeparator(Separators.COMMA); // oddball
        this.scheme = ParameterNames.DIGEST;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.972 -0500", hash_original_method = "DB765A091C9F86F3B91F21F5A402D773", hash_generated_method = "1B70B5A7CD2F5AE89D02CE6BC90B33B3")
    
public AuthenticationHeader() {
        super();
        parameters.setSeparator(Separators.COMMA);
    }

    /**
     * set the specified parameter. Bug reported by Dominic Sparks.
     *
     * @param name --
     *            name of the parameter
     * @param value --
     *            value of the parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.976 -0500", hash_original_method = "63A2509649DB1C5E3D5569CEACEDF418", hash_generated_method = "314DD2EEBCA81FBD560B6C12E036AE2C")
    
public void setParameter(String name, String value) throws ParseException {
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if (nv == null) {
            nv = new NameValue(name, value);
            if (name.equalsIgnoreCase(ParameterNames.QOP)
                    || name.equalsIgnoreCase(ParameterNames.REALM)
                    || name.equalsIgnoreCase(ParameterNames.CNONCE)
                    || name.equalsIgnoreCase(ParameterNames.NONCE)
                    || name.equalsIgnoreCase(ParameterNames.USERNAME)
                    || name.equalsIgnoreCase(ParameterNames.DOMAIN)
                    || name.equalsIgnoreCase(ParameterNames.OPAQUE)
                    || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                    || name.equalsIgnoreCase(ParameterNames.URI)
                    || name.equalsIgnoreCase(ParameterNames.RESPONSE )
                    ||name.equalsIgnoreCase(ParameterNamesIms.IK)
                    || name.equalsIgnoreCase(ParameterNamesIms.CK)
                    || name.equalsIgnoreCase(ParameterNamesIms.INTEGRITY_PROTECTED)) {
                if (((this instanceof Authorization) || (this instanceof ProxyAuthorization))
                        && name.equalsIgnoreCase(ParameterNames.QOP)) {
                    // NOP, QOP not quoted in authorization headers
                } else {
                    nv.setQuotedValue();
                }
                if (value == null)
                    throw new NullPointerException("null value");
                if (value.startsWith(Separators.DOUBLE_QUOTE))
                    throw new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
            }
            super.setParameter(nv);
        } else
            nv.setValueAsObject(value);

    }

    /**
     * This is only used for the parser interface.
     *
     * @param challenge --
     *            the challenge from which the parameters are extracted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.979 -0500", hash_original_method = "855C75AA7A25318520BDD2BB747F87D1", hash_generated_method = "71C10291016CC53E8509DD1A88B4E3E8")
    
public void setChallenge(Challenge challenge) {
        this.scheme = challenge.scheme;
        super.parameters = challenge.authParams;
    }

    /**
     * Encode in canonical form.
     *
     * @return canonical string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.982 -0500", hash_original_method = "9C8F11B1DE9667C53D0EB2C6FF74CC89", hash_generated_method = "11BB745E9210EA37F0419F6FA283CA8A")
    
public String encodeBody() {
        this.parameters.setSeparator(Separators.COMMA);
        return this.scheme + SP + parameters.encode();
    }

    /**
     * Sets the scheme of the challenge information for this
     * AuthenticationHeaderHeader. For example, Digest.
     *
     * @param scheme -
     *            the new string value that identifies the challenge information
     *            scheme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.985 -0500", hash_original_method = "12283BFE3BE1F2D48F088D181A48BB59", hash_generated_method = "203B00EF94AA62506108BF34A2B2CAF4")
    
public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * Returns the scheme of the challenge information for this
     * AuthenticationHeaderHeader.
     *
     * @return the string value of the challenge information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.988 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
    
public String getScheme() {
        return scheme;
    }

    /**
     * Sets the Realm of the WWWAuthenicateHeader to the <var>realm</var>
     * parameter value. Realm strings MUST be globally unique. It is RECOMMENDED
     * that a realm string contain a hostname or domain name. Realm strings
     * SHOULD present a human-readable identifier that can be rendered to a
     * user.
     *
     * @param realm
     *            the new Realm String of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the realm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.991 -0500", hash_original_method = "389B06AAD21713BEFD607954CE113A50", hash_generated_method = "278CDFDEC070F3B95962D47193FC86E1")
    
public void setRealm(String realm) throws ParseException {
        if (realm == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setRealm(), The realm parameter is null");
        setParameter(ParameterNames.REALM, realm);
    }

    /**
     * Returns the Realm value of this WWWAuthenicateHeader. This convenience
     * method returns only the realm of the complete Challenge.
     *
     * @return the String representing the Realm information, null if value is
     *         not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.994 -0500", hash_original_method = "C947FEA98ED8A5E735C71437037B2D94", hash_generated_method = "C8EA395B9DCD0CF12E8BF45479353A0D")
    
public String getRealm() {
        return getParameter(ParameterNames.REALM);
    }

    /**
     * Sets the Nonce of the WWWAuthenicateHeader to the <var>nonce</var>
     * parameter value.
     *
     * @param nonce -
     *            the new nonce String of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the nonce value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.998 -0500", hash_original_method = "D28512DD5DADEB1219799F9FE9539511", hash_generated_method = "E477ACBD272F4E768E2B71FCAC9C539A")
    
public void setNonce(String nonce) throws ParseException {
        if (nonce == null)
            throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setNonce(), The nonce parameter is null");
        setParameter(NONCE, nonce);
    }

    /**
     * Returns the Nonce value of this WWWAuthenicateHeader.
     *
     * @return the String representing the nonce information, null if value is
     *         not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.001 -0500", hash_original_method = "AE10AC1E29E2379ECD11C42D2EA0F8C1", hash_generated_method = "97184A00E467160041BD5BC55A5DCBE8")
    
public String getNonce() {
        return getParameter(ParameterNames.NONCE);
    }

    /**
     * Sets the URI of the WWWAuthenicateHeader to the <var>uri</var> parameter
     * value.
     *
     * @param uri -
     *            the new URI of this AuthenicationHeader.
     * @since v1.1
     *
     * Note that since 1.2 this is no longer applicable to the WWW-Authenticate
     * and Proxy-Authenticate headers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.003 -0500", hash_original_method = "1D3E80F645890E8406B036C8FE6ADD92", hash_generated_method = "B9CE280725C3CB2AAB08E58B6496E7EC")
    
public void setURI(javax.sip.address.URI uri) {
        if (uri != null) {
            NameValue nv = new NameValue(ParameterNames.URI, uri);
            nv.setQuotedValue();
            super.parameters.set(nv);
        } else {
            throw new NullPointerException("Null URI");
        }
    }

    /**
     * Returns the URI value of this WWWAuthenicateHeader, for example
     * DigestURI.
     *
     * @return the URI representing the URI information, null if value is not
     *         set.
     * @since v1.1
     *
     * Note that since 1.2 this is no longer applicable to the WWW-Authenticate
     * and Proxy-Authenticate headers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.006 -0500", hash_original_method = "C651D4576806B169F61A46B4807216FD", hash_generated_method = "84AFEB48D3931E614EB2F783EC4D1482")
    
public javax.sip.address.URI getURI() {
        return getParameterAsURI(ParameterNames.URI);
    }

    /**
     * Sets the Algorithm of the WWWAuthenicateHeader to the new <var>algorithm</var>
     * parameter value.
     *
     * @param algorithm -
     *            the new algorithm String of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the algorithm value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.009 -0500", hash_original_method = "A70D72402AA001F050CF710FE3E4AACB", hash_generated_method = "DC13E51532E9C434B8853E41BA31CB9C")
    
public void setAlgorithm(String algorithm) throws ParseException {
        if (algorithm == null)
            throw new NullPointerException("null arg");
        setParameter(ParameterNames.ALGORITHM, algorithm);
    }

    /**
     * Returns the Algorithm value of this WWWAuthenicateHeader.
     *
     * @return the String representing the Algorithm information, null if the
     *         value is not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.013 -0500", hash_original_method = "2AF2AF93F3BCE45D8EB0FCF5D647A3F0", hash_generated_method = "84900DFA40566C511E8422A595081A85")
    
public String getAlgorithm() {
        return getParameter(ParameterNames.ALGORITHM);
    }

    /**
     * Sets the Qop value of the WWWAuthenicateHeader to the new <var>qop</var>
     * parameter value.
     *
     * @param qop -
     *            the new Qop string of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the Qop value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.016 -0500", hash_original_method = "33AFDF6E9223256AFA6668E8CADD3DE2", hash_generated_method = "C2A35CA8AAE389791841AECCB3D5E919")
    
public void setQop(String qop) throws ParseException {
        if (qop == null)
            throw new NullPointerException("null arg");
        setParameter(ParameterNames.QOP, qop);
    }

    /**
     * Returns the Qop value of this WWWAuthenicateHeader.
     *
     * @return the string representing the Qop information, null if the value is
     *         not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.019 -0500", hash_original_method = "A29C3BFFBE330CF76325CB0EF7125F69", hash_generated_method = "423A14FDF8433B479AAA8F0ACB99E1CA")
    
public String getQop() {
        return getParameter(ParameterNames.QOP);
    }

    /**
     * Sets the Opaque value of the WWWAuthenicateHeader to the new <var>opaque</var>
     * parameter value.
     *
     * @param opaque -
     *            the new Opaque string of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the opaque value.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.023 -0500", hash_original_method = "76E3536FF05DCEF3BC0C3CCACC26C3E9", hash_generated_method = "B4AA3AEA72AD9676F669E3CBB1E7FCA1")
    
public void setOpaque(String opaque) throws ParseException {
        if (opaque == null)
            throw new NullPointerException("null arg");
        setParameter(ParameterNames.OPAQUE, opaque);
    }

    /**
     * Returns the Opaque value of this WWWAuthenicateHeader.
     *
     * @return the String representing the Opaque information, null if the value
     *         is not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.025 -0500", hash_original_method = "74CFB2775BB87B4CA5EB14E12EDD4FAA", hash_generated_method = "5F8E1DDF05CDECA0AC29FCE0FBAE47E6")
    
public String getOpaque() {
        return getParameter(ParameterNames.OPAQUE);
    }

    /**
     * Sets the Domain of the WWWAuthenicateHeader to the <var>domain</var>
     * parameter value.
     *
     * @param domain -
     *            the new Domain string of this WWWAuthenicateHeader.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the domain.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.028 -0500", hash_original_method = "0CF00DF85E6E023A49347C3D97FE25E8", hash_generated_method = "6B6D37E373DF84FE349C3B17AAC263C6")
    
public void setDomain(String domain) throws ParseException {
        if (domain == null)
            throw new NullPointerException("null arg");
        setParameter(ParameterNames.DOMAIN, domain);
    }

    /**
     * Returns the Domain value of this WWWAuthenicateHeader.
     *
     * @return the String representing the Domain information, null if value is
     *         not set.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.031 -0500", hash_original_method = "FF2BF47C5FE979FA8AC19766A91C33D5", hash_generated_method = "B1316C355E4A18AB534539BAFC09F05E")
    
public String getDomain() {
        return getParameter(ParameterNames.DOMAIN);
    }

    /**
     * Sets the value of the stale parameter of the WWWAuthenicateHeader to the
     * <var>stale</var> parameter value.
     *
     * @param stale -
     *            the Boolean.valueOf value of the stale parameter.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.034 -0500", hash_original_method = "4D2E04293B20A27BD458DB2208C5CD5A", hash_generated_method = "FD3EA5DCE1E935A361DF664AB12D2CCE")
    
public void setStale(boolean stale) {
        setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
    }

    /**
     * Returns the boolean value of the state paramater of this
     * WWWAuthenicateHeader.
     *
     * @return the boolean representing if the challenge is stale.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.037 -0500", hash_original_method = "DC27EBD9E1BDFC9CCA499BC74F11D850", hash_generated_method = "95BF3D2E10AD365B3C7CFF52E91E0AEE")
    
public boolean isStale() {
        return this.getParameterAsBoolean(ParameterNames.STALE);
    }

    /**
     * Set the CNonce.
     *
     * @param cnonce --
     *            a nonce string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.040 -0500", hash_original_method = "DC70DAD63B3B016EB719597770A168A8", hash_generated_method = "958277A9478C6C70F74DECE39198BB81")
    
public void setCNonce(String cnonce) throws ParseException {
        this.setParameter(ParameterNames.CNONCE, cnonce);
    }

    /**
     * Get the CNonce.
     *
     * @return the cnonce value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.043 -0500", hash_original_method = "2A1857D33807A19504A72F3100996078", hash_generated_method = "4043EB639C6278F3D6DCAA9CABD4D306")
    
public String getCNonce() {
        return getParameter(ParameterNames.CNONCE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.046 -0500", hash_original_method = "A399E18540C780BD641CBDC9149756E0", hash_generated_method = "38E88A510A64FF3F3624210E2DF5E787")
    
public int getNonceCount() {
        return this.getParameterAsHexInt(ParameterNames.NC);

    }

    /**
     * Set the nonce count pakrameter. Bug fix sent in by Andreas Bystr�m
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.049 -0500", hash_original_method = "76CF7C4BB03DAD75C2063E167B2975DA", hash_generated_method = "255399408A7CFE98D3072A19F898FBFB")
    
public void setNonceCount(int param) throws java.text.ParseException {
        if (param < 0)
            throw new ParseException("bad value", 0);

        String nc = Integer.toHexString(param);

        String base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);

    }

    /**
     * Get the RESPONSE value (or null if it does not exist).
     *
     * @return String response parameter value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.051 -0500", hash_original_method = "9CF506858536EED9F17336D37906D7B1", hash_generated_method = "531577494568521F5B8236387FCF4885")
    
public String getResponse() {
        return (String) getParameterValue(ParameterNames.RESPONSE);
    }

    /**
     * Set the Response.
     *
     * @param response
     *            to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.056 -0500", hash_original_method = "3019C4D6EA7009219C4F2124D013528F", hash_generated_method = "387037A13DCB5E9360C7C4E87F900132")
    
public void setResponse(String response) throws ParseException {
        if (response == null)
            throw new NullPointerException("Null parameter");
        // Bug fix from Andreas Bystr�m
        this.setParameter(RESPONSE, response);
    }

    /**
     * Returns the Username value of this AuthorizationHeader. This convenience
     * method returns only the username of the complete Response.
     *
     * @return the String representing the Username information, null if value
     *         is not set.
     *
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.058 -0500", hash_original_method = "B515E3B485EA8C128CD8B454808B5965", hash_generated_method = "796BBFA12B42DE2F8B7D47B6571C4118")
    
public String getUsername() {
        return (String) getParameter(ParameterNames.USERNAME);
    }

    /**
     * Sets the Username of the AuthorizationHeader to the <var>username</var>
     * parameter value.
     *
     * @param username
     *            the new Username String of this AuthorizationHeader.
     *
     * @throws ParseException
     *             which signals that an error has been reached
     *
     * unexpectedly while parsing the username.
     *
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.061 -0500", hash_original_method = "737A9BC8D666816000B1F83AF3435CC9", hash_generated_method = "F2480664B0B56492D9B18CBAE1EBAA2F")
    
public void setUsername(String username) throws ParseException {
        this.setParameter(ParameterNames.USERNAME, username);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.064 -0500", hash_original_method = "C945DC5CCA937939305E33DCD57FE88B", hash_generated_method = "BE9FA00257792147FE8BFA513D4DF264")
    
public void setIK(String ik) throws ParseException {
        if (ik == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        setParameter(IK, ik);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.067 -0500", hash_original_method = "6860A8600CF9767918EEF6950728D612", hash_generated_method = "2C9711E272383AD3421950178C0F7248")
    
public String getIK() {
        return getParameter(ParameterNamesIms.IK);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.070 -0500", hash_original_method = "294221E5C763C88C3235A01BF56EDDDF", hash_generated_method = "48FF90077D940DB9E5D4C50865822C98")
    
public void setCK(String ck) throws ParseException {
        if (ck == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        setParameter(CK, ck);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.073 -0500", hash_original_method = "069687871A480347A7851D04BD98256F", hash_generated_method = "C1659F7CE51A370DAA424199F5EB1A02")
    
public String getCK() {
        return getParameter(ParameterNamesIms.CK);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.076 -0500", hash_original_method = "2D0954ACD2F7E7C621F6D74F94C4BE3A", hash_generated_method = "9688A46DDE518D30135950B7B8C2449F")
    
public void setIntegrityProtected(String integrityProtected) throws ParseException
    {
        if (integrityProtected == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");

        setParameter(INTEGRITY_PROTECTED, integrityProtected);
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.080 -0500", hash_original_method = "84FABD46260852E6AB8072476C79DC4A", hash_generated_method = "CF78EDA75FA8E8BF706F31AE2A84E9AA")
    
public String getIntegrityProtected() {
        return getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
    }
}

