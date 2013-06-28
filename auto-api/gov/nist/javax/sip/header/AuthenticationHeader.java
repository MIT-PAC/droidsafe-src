package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import java.text.ParseException;

public abstract class AuthenticationHeader extends ParametersHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.083 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.084 -0400", hash_original_method = "54F496DB6FA267582688938E2479AFBA", hash_generated_method = "C1BB95A9FA3F2A3327CCAC3009EF9697")
    public  AuthenticationHeader(String name) {
        super(name);
        parameters.setSeparator(Separators.COMMA);
        this.scheme = ParameterNames.DIGEST;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
        //this.scheme = ParameterNames.DIGEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.084 -0400", hash_original_method = "DB765A091C9F86F3B91F21F5A402D773", hash_generated_method = "AF7ABC2AFF9A4F2DB220A0160AEAC81F")
    public  AuthenticationHeader() {
        super();
        parameters.setSeparator(Separators.COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.085 -0400", hash_original_method = "63A2509649DB1C5E3D5569CEACEDF418", hash_generated_method = "BD7596062920643D96621A9A1ED54839")
    public void setParameter(String name, String value) throws ParseException {
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean var10AE350C0695E588E16CC251466FA7E8_2094307330 = (name.equalsIgnoreCase(ParameterNames.QOP)
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
                    || name.equalsIgnoreCase(ParameterNamesIms.INTEGRITY_PROTECTED));
                {
                    {
                        boolean var735FDC7AA75BC0DEFB6B9B4871F89BEB_608191961 = (((this instanceof Authorization) || (this instanceof ProxyAuthorization))
                        && name.equalsIgnoreCase(ParameterNames.QOP));
                        {
                            nv.setQuotedValue();
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null value");
                    {
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_548515678 = (value.startsWith(Separators.DOUBLE_QUOTE));
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            super.setParameter(nv);
        } //End block
        nv.setValueAsObject(value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.086 -0400", hash_original_method = "855C75AA7A25318520BDD2BB747F87D1", hash_generated_method = "9FFE68DB2BC797370DD296B8F23D1704")
    public void setChallenge(Challenge challenge) {
        this.scheme = challenge.scheme;
        super.parameters = challenge.authParams;
        // ---------- Original Method ----------
        //this.scheme = challenge.scheme;
        //super.parameters = challenge.authParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.086 -0400", hash_original_method = "9C8F11B1DE9667C53D0EB2C6FF74CC89", hash_generated_method = "9DEF0F94F79D3EA340BCB46CE5C6EC4F")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_90576579 = null; //Variable for return #1
        this.parameters.setSeparator(Separators.COMMA);
        varB4EAC82CA7396A68D541C85D26508E83_90576579 = this.scheme + SP + parameters.encode();
        varB4EAC82CA7396A68D541C85D26508E83_90576579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90576579;
        // ---------- Original Method ----------
        //this.parameters.setSeparator(Separators.COMMA);
        //return this.scheme + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.087 -0400", hash_original_method = "12283BFE3BE1F2D48F088D181A48BB59", hash_generated_method = "F7F89B7A7F4E4526442680C88997CE5D")
    public void setScheme(String scheme) {
        this.scheme = scheme;
        // ---------- Original Method ----------
        //this.scheme = scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.087 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "35A1A18B057F5BE41F9FD58FB5852DE2")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_339065880 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339065880 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_339065880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339065880;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.088 -0400", hash_original_method = "389B06AAD21713BEFD607954CE113A50", hash_generated_method = "C6EE03B18CBD52708B26355BEEF6DCAC")
    public void setRealm(String realm) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setRealm(), The realm parameter is null");
        setParameter(ParameterNames.REALM, realm);
        addTaint(realm.getTaint());
        // ---------- Original Method ----------
        //if (realm == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setRealm(), The realm parameter is null");
        //setParameter(ParameterNames.REALM, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.089 -0400", hash_original_method = "C947FEA98ED8A5E735C71437037B2D94", hash_generated_method = "448BCCADFF6FE32643AFD34B803ACC72")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_216188189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_216188189 = getParameter(ParameterNames.REALM);
        varB4EAC82CA7396A68D541C85D26508E83_216188189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216188189;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.REALM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.089 -0400", hash_original_method = "D28512DD5DADEB1219799F9FE9539511", hash_generated_method = "D527F6DE488E62A8D84FE512E4A2997C")
    public void setNonce(String nonce) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setNonce(), The nonce parameter is null");
        setParameter(NONCE, nonce);
        addTaint(nonce.getTaint());
        // ---------- Original Method ----------
        //if (nonce == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setNonce(), The nonce parameter is null");
        //setParameter(NONCE, nonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.090 -0400", hash_original_method = "AE10AC1E29E2379ECD11C42D2EA0F8C1", hash_generated_method = "1E2A6E26864D023918B0D1A98C9D1C54")
    public String getNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1588946498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1588946498 = getParameter(ParameterNames.NONCE);
        varB4EAC82CA7396A68D541C85D26508E83_1588946498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1588946498;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.NONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.090 -0400", hash_original_method = "1D3E80F645890E8406B036C8FE6ADD92", hash_generated_method = "2D683FD59D6183D72E7398CC2A64D43F")
    public void setURI(javax.sip.address.URI uri) {
        {
            NameValue nv = new NameValue(ParameterNames.URI, uri);
            nv.setQuotedValue();
            super.parameters.set(nv);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null URI");
        } //End block
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //if (uri != null) {
            //NameValue nv = new NameValue(ParameterNames.URI, uri);
            //nv.setQuotedValue();
            //super.parameters.set(nv);
        //} else {
            //throw new NullPointerException("Null URI");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.090 -0400", hash_original_method = "C651D4576806B169F61A46B4807216FD", hash_generated_method = "A86827574C29AAA3E8E008230FF481CA")
    public javax.sip.address.URI getURI() {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_190684272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_190684272 = getParameterAsURI(ParameterNames.URI);
        varB4EAC82CA7396A68D541C85D26508E83_190684272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_190684272;
        // ---------- Original Method ----------
        //return getParameterAsURI(ParameterNames.URI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.091 -0400", hash_original_method = "A70D72402AA001F050CF710FE3E4AACB", hash_generated_method = "3B0DA8291ABE0B14567073D00D887EB1")
    public void setAlgorithm(String algorithm) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.ALGORITHM, algorithm);
        addTaint(algorithm.getTaint());
        // ---------- Original Method ----------
        //if (algorithm == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.ALGORITHM, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.092 -0400", hash_original_method = "2AF2AF93F3BCE45D8EB0FCF5D647A3F0", hash_generated_method = "AFD5A1EF5ED534AEECBE9953DD939487")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_43931090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_43931090 = getParameter(ParameterNames.ALGORITHM);
        varB4EAC82CA7396A68D541C85D26508E83_43931090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_43931090;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ALGORITHM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.093 -0400", hash_original_method = "33AFDF6E9223256AFA6668E8CADD3DE2", hash_generated_method = "0C77258A09112164F773C18AB9BE92AC")
    public void setQop(String qop) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.QOP, qop);
        addTaint(qop.getTaint());
        // ---------- Original Method ----------
        //if (qop == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.093 -0400", hash_original_method = "A29C3BFFBE330CF76325CB0EF7125F69", hash_generated_method = "70A8EC574EC89C3BEE435E3E53FB2D9D")
    public String getQop() {
        String varB4EAC82CA7396A68D541C85D26508E83_238224339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_238224339 = getParameter(ParameterNames.QOP);
        varB4EAC82CA7396A68D541C85D26508E83_238224339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_238224339;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.094 -0400", hash_original_method = "76E3536FF05DCEF3BC0C3CCACC26C3E9", hash_generated_method = "F640A3A9174FCC0BC9F65B0D29823EBA")
    public void setOpaque(String opaque) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.OPAQUE, opaque);
        addTaint(opaque.getTaint());
        // ---------- Original Method ----------
        //if (opaque == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.OPAQUE, opaque);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.094 -0400", hash_original_method = "74CFB2775BB87B4CA5EB14E12EDD4FAA", hash_generated_method = "41116D43B3967488FC016F0E71C945DB")
    public String getOpaque() {
        String varB4EAC82CA7396A68D541C85D26508E83_374669862 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_374669862 = getParameter(ParameterNames.OPAQUE);
        varB4EAC82CA7396A68D541C85D26508E83_374669862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_374669862;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.OPAQUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.095 -0400", hash_original_method = "0CF00DF85E6E023A49347C3D97FE25E8", hash_generated_method = "A9A4C476AE2735C0D17BA261127188EE")
    public void setDomain(String domain) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.DOMAIN, domain);
        addTaint(domain.getTaint());
        // ---------- Original Method ----------
        //if (domain == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.DOMAIN, domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.095 -0400", hash_original_method = "FF2BF47C5FE979FA8AC19766A91C33D5", hash_generated_method = "38FC5633613F6602DF42116C5FDB57A6")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_320803959 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_320803959 = getParameter(ParameterNames.DOMAIN);
        varB4EAC82CA7396A68D541C85D26508E83_320803959.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_320803959;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.DOMAIN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.096 -0400", hash_original_method = "4D2E04293B20A27BD458DB2208C5CD5A", hash_generated_method = "B13FA037852614B910AAE5525DD79363")
    public void setStale(boolean stale) {
        setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
        addTaint(stale);
        // ---------- Original Method ----------
        //setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.097 -0400", hash_original_method = "DC27EBD9E1BDFC9CCA499BC74F11D850", hash_generated_method = "B42E5DA77ABDD21B7323F141EC2F1929")
    public boolean isStale() {
        boolean var59C0D15E95DE4B7103AFB114D7F67902_347264276 = (this.getParameterAsBoolean(ParameterNames.STALE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809462459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809462459;
        // ---------- Original Method ----------
        //return this.getParameterAsBoolean(ParameterNames.STALE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.097 -0400", hash_original_method = "DC70DAD63B3B016EB719597770A168A8", hash_generated_method = "AB5D468593D8C28D910F14CEBF6A1D4A")
    public void setCNonce(String cnonce) throws ParseException {
        this.setParameter(ParameterNames.CNONCE, cnonce);
        addTaint(cnonce.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cnonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.104 -0400", hash_original_method = "2A1857D33807A19504A72F3100996078", hash_generated_method = "3A6CD6D286B51D691B06537E8F789DCA")
    public String getCNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1032712749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032712749 = getParameter(ParameterNames.CNONCE);
        varB4EAC82CA7396A68D541C85D26508E83_1032712749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032712749;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.CNONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.104 -0400", hash_original_method = "A399E18540C780BD641CBDC9149756E0", hash_generated_method = "2A70809A1FE953F6F6911D7C1A15EEB7")
    public int getNonceCount() {
        int var6D948F5C0412617498531BFE3A4615C0_2026780866 = (this.getParameterAsHexInt(ParameterNames.NC));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626288010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626288010;
        // ---------- Original Method ----------
        //return this.getParameterAsHexInt(ParameterNames.NC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.105 -0400", hash_original_method = "76CF7C4BB03DAD75C2063E167B2975DA", hash_generated_method = "D8D10CC16988458DB62388ED52B98B33")
    public void setNonceCount(int param) throws java.text.ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad value", 0);
        String nc = Integer.toHexString(param);
        String base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);
        addTaint(param);
        // ---------- Original Method ----------
        //if (param < 0)
            //throw new ParseException("bad value", 0);
        //String nc = Integer.toHexString(param);
        //String base = "00000000";
        //nc = base.substring(0, 8 - nc.length()) + nc;
        //this.setParameter(ParameterNames.NC, nc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.105 -0400", hash_original_method = "9CF506858536EED9F17336D37906D7B1", hash_generated_method = "93896DE64BA1AC082E9C25448540EF49")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_1893724663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1893724663 = (String) getParameterValue(ParameterNames.RESPONSE);
        varB4EAC82CA7396A68D541C85D26508E83_1893724663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1893724663;
        // ---------- Original Method ----------
        //return (String) getParameterValue(ParameterNames.RESPONSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.105 -0400", hash_original_method = "3019C4D6EA7009219C4F2124D013528F", hash_generated_method = "BD1BCC26B5EA53D31099394942F83566")
    public void setResponse(String response) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null parameter");
        this.setParameter(RESPONSE, response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("Null parameter");
        //this.setParameter(RESPONSE, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.106 -0400", hash_original_method = "B515E3B485EA8C128CD8B454808B5965", hash_generated_method = "F1DF8C88C38ADD3B0C073BE95AC76B08")
    public String getUsername() {
        String varB4EAC82CA7396A68D541C85D26508E83_834046924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_834046924 = (String) getParameter(ParameterNames.USERNAME);
        varB4EAC82CA7396A68D541C85D26508E83_834046924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_834046924;
        // ---------- Original Method ----------
        //return (String) getParameter(ParameterNames.USERNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.106 -0400", hash_original_method = "737A9BC8D666816000B1F83AF3435CC9", hash_generated_method = "D26C4A07BF3362F73AEF7EE581C2DD09")
    public void setUsername(String username) throws ParseException {
        this.setParameter(ParameterNames.USERNAME, username);
        addTaint(username.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.USERNAME, username);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.106 -0400", hash_original_method = "C945DC5CCA937939305E33DCD57FE88B", hash_generated_method = "B71267AEAD3CF9FAA06A8A1599EF8FA7")
    public void setIK(String ik) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        setParameter(IK, ik);
        addTaint(ik.getTaint());
        // ---------- Original Method ----------
        //if (ik == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        //setParameter(IK, ik);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.106 -0400", hash_original_method = "6860A8600CF9767918EEF6950728D612", hash_generated_method = "6E68C60DAEAC7B84C174BCD2929296FC")
    public String getIK() {
        String varB4EAC82CA7396A68D541C85D26508E83_1044516789 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1044516789 = getParameter(ParameterNamesIms.IK);
        varB4EAC82CA7396A68D541C85D26508E83_1044516789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044516789;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.IK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_method = "294221E5C763C88C3235A01BF56EDDDF", hash_generated_method = "0DBE326E9A75AEE0E2C8E0CC832FEDE4")
    public void setCK(String ck) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        setParameter(CK, ck);
        addTaint(ck.getTaint());
        // ---------- Original Method ----------
        //if (ck == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        //setParameter(CK, ck);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_method = "069687871A480347A7851D04BD98256F", hash_generated_method = "8B4880A0AB01E819CDAA44D5490AD18B")
    public String getCK() {
        String varB4EAC82CA7396A68D541C85D26508E83_293218174 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_293218174 = getParameter(ParameterNamesIms.CK);
        varB4EAC82CA7396A68D541C85D26508E83_293218174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293218174;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_method = "2D0954ACD2F7E7C621F6D74F94C4BE3A", hash_generated_method = "D71E8BB09F9488C19BC6BC22ED8B1200")
    public void setIntegrityProtected(String integrityProtected) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        setParameter(INTEGRITY_PROTECTED, integrityProtected);
        addTaint(integrityProtected.getTaint());
        // ---------- Original Method ----------
        //if (integrityProtected == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        //setParameter(INTEGRITY_PROTECTED, integrityProtected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_method = "84FABD46260852E6AB8072476C79DC4A", hash_generated_method = "2E24B162D55AEA063FD69A6D739580D3")
    public String getIntegrityProtected() {
        String varB4EAC82CA7396A68D541C85D26508E83_1798856690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798856690 = getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
        varB4EAC82CA7396A68D541C85D26508E83_1798856690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798856690;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "17FF58D2E4819C468CD0033E52CC7881")

    public static final String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "EBBD9BA1BADBAC5EF593F488645D5C46")

    public static final String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "04CDC06BB0A5B6663DDA46DEE36CCB2B")

    public static final String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "591C458296CAAD3DAD3DC69D39923AB3")

    public static final String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "7862B7814B761743D8679A1CE71BE925")

    public static final String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "9254AA79BC5CBC7DBBCE98D12C5618BC")

    public static final String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "EC08D758804B4FDE227D2AAB23EED546")

    public static final String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.107 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "0BBA7683ABB90D800A75724CF582A61A")

    public static final String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C2AF6C64E388AB2628A7844DCD27068F")

    public static final String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "6B99FF024523454EDC36F1887E571D7D", hash_generated_field = "945C00AD0FB2001FDFE332FC462F84B5")

    public static final String NC = ParameterNames.NC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "E0529E04E9C46EB7B3C9AFFEEB80131C")

    public static final String URI = ParameterNames.URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "7D01DFAF0E866EC17460395E6A1D2AEF", hash_generated_field = "141BBA99C5BA0E2C564C80B92D9ECEF4")

    public static final String USERNAME = ParameterNames.USERNAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "7AC54993845CA13D03D423F8F71F248D", hash_generated_field = "7628B0C67486A8D201E3E813C670AEFA")

    public static final String CNONCE = ParameterNames.CNONCE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "A1A4F8636F685D229DB94D99C344EE7F", hash_generated_field = "4FA62036A736AEB7215955B884E2C736")

    public static final String NONCE = ParameterNames.NONCE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "DDEB1079010E599C8162878F194138D0", hash_generated_field = "509D45CD35B3A28E9024383BC022E75B")

    public static final String IK = ParameterNamesIms.IK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "81A1ECA06CB9A364EAB0AA343DFF1FE9", hash_generated_field = "D36E5E6DD689766EC5136A3D190A0B78")

    public static final String CK = ParameterNamesIms.CK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.108 -0400", hash_original_field = "A9D09F976D523EA433BE0BC37D227F69", hash_generated_field = "2AD0537217FB260E580A1D4CCD6793D9")

    public static final String INTEGRITY_PROTECTED = ParameterNamesIms.INTEGRITY_PROTECTED;
}

