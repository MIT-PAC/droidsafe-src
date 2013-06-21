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
    protected String scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.768 -0400", hash_original_method = "54F496DB6FA267582688938E2479AFBA", hash_generated_method = "F789E721D0EC59EE9A6D24E2302218BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHeader(String name) {
        super(name);
        dsTaint.addTaint(name);
        parameters.setSeparator(Separators.COMMA);
        this.scheme = ParameterNames.DIGEST;
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
        //this.scheme = ParameterNames.DIGEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.768 -0400", hash_original_method = "DB765A091C9F86F3B91F21F5A402D773", hash_generated_method = "AF7ABC2AFF9A4F2DB220A0160AEAC81F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHeader() {
        super();
        parameters.setSeparator(Separators.COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.768 -0400", hash_original_method = "63A2509649DB1C5E3D5569CEACEDF418", hash_generated_method = "B327D2088350EEC38C04FDF3B3951B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean var10AE350C0695E588E16CC251466FA7E8_1431194023 = (name.equalsIgnoreCase(ParameterNames.QOP)
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
                        boolean var735FDC7AA75BC0DEFB6B9B4871F89BEB_2093781450 = (((this instanceof Authorization) || (this instanceof ProxyAuthorization))
                        && name.equalsIgnoreCase(ParameterNames.QOP));
                        {
                            nv.setQuotedValue();
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null value");
                    {
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_1283595248 = (value.startsWith(Separators.DOUBLE_QUOTE));
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            super.setParameter(nv);
        } //End block
        nv.setValueAsObject(value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.769 -0400", hash_original_method = "855C75AA7A25318520BDD2BB747F87D1", hash_generated_method = "D44CC3958EB3B5439814D23DD16E724B")
    @DSModeled(DSC.SAFE)
    public void setChallenge(Challenge challenge) {
        dsTaint.addTaint(challenge.dsTaint);
        this.scheme = challenge.scheme;
        super.parameters = challenge.authParams;
        // ---------- Original Method ----------
        //this.scheme = challenge.scheme;
        //super.parameters = challenge.authParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.769 -0400", hash_original_method = "9C8F11B1DE9667C53D0EB2C6FF74CC89", hash_generated_method = "AD57CEE211E4C2ED54D652D0E2C854F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        this.parameters.setSeparator(Separators.COMMA);
        String varDAA25B25D2DB0FB0503144242DF72BFA_82950486 = (this.scheme + SP + parameters.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //this.parameters.setSeparator(Separators.COMMA);
        //return this.scheme + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.769 -0400", hash_original_method = "12283BFE3BE1F2D48F088D181A48BB59", hash_generated_method = "28D42005AE50D88195CA7AEFDC0E50A5")
    @DSModeled(DSC.SAFE)
    public void setScheme(String scheme) {
        dsTaint.addTaint(scheme);
        // ---------- Original Method ----------
        //this.scheme = scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.769 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.769 -0400", hash_original_method = "389B06AAD21713BEFD607954CE113A50", hash_generated_method = "5F41B0952F76A1D740099BD5EE4F0D83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRealm(String realm) throws ParseException {
        dsTaint.addTaint(realm);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setRealm(), The realm parameter is null");
        setParameter(ParameterNames.REALM, realm);
        // ---------- Original Method ----------
        //if (realm == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setRealm(), The realm parameter is null");
        //setParameter(ParameterNames.REALM, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "C947FEA98ED8A5E735C71437037B2D94", hash_generated_method = "16D4B9B023F6C13DA2E509B1C9B26305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRealm() {
        String var298458ECB1FAA42BD07AA21AFB965900_410767289 = (getParameter(ParameterNames.REALM));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.REALM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "D28512DD5DADEB1219799F9FE9539511", hash_generated_method = "C0E6687B46F316F44B84689AB339CAD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNonce(String nonce) throws ParseException {
        dsTaint.addTaint(nonce);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setNonce(), The nonce parameter is null");
        setParameter(NONCE, nonce);
        // ---------- Original Method ----------
        //if (nonce == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setNonce(), The nonce parameter is null");
        //setParameter(NONCE, nonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "AE10AC1E29E2379ECD11C42D2EA0F8C1", hash_generated_method = "817E11A58E8928656528913B1472622C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNonce() {
        String varE604A1B8A3587659DA9B9C6DD53A5C64_882546686 = (getParameter(ParameterNames.NONCE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.NONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "1D3E80F645890E8406B036C8FE6ADD92", hash_generated_method = "0B41379826A043D42FB94822392C093D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setURI(javax.sip.address.URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            NameValue nv;
            nv = new NameValue(ParameterNames.URI, uri);
            nv.setQuotedValue();
            super.parameters.set(nv);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null URI");
        } //End block
        // ---------- Original Method ----------
        //if (uri != null) {
            //NameValue nv = new NameValue(ParameterNames.URI, uri);
            //nv.setQuotedValue();
            //super.parameters.set(nv);
        //} else {
            //throw new NullPointerException("Null URI");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "C651D4576806B169F61A46B4807216FD", hash_generated_method = "8BDB5F9493E5D8A09232FDE795D57271")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.URI getURI() {
        javax.sip.address.URI var94016ED13A82107D22F5BD8C3F084171_999420021 = (getParameterAsURI(ParameterNames.URI));
        return (javax.sip.address.URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getParameterAsURI(ParameterNames.URI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.770 -0400", hash_original_method = "A70D72402AA001F050CF710FE3E4AACB", hash_generated_method = "6DB9AEC707994A6FF2256AE95A889425")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlgorithm(String algorithm) throws ParseException {
        dsTaint.addTaint(algorithm);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.ALGORITHM, algorithm);
        // ---------- Original Method ----------
        //if (algorithm == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.ALGORITHM, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "2AF2AF93F3BCE45D8EB0FCF5D647A3F0", hash_generated_method = "EDA811894573E7B92C1702273DC6198E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAlgorithm() {
        String varB254F7423871038C0F34DC828B622B3E_1424990676 = (getParameter(ParameterNames.ALGORITHM));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ALGORITHM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "33AFDF6E9223256AFA6668E8CADD3DE2", hash_generated_method = "6A60B0F35016CE885892B60AD1BAFFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQop(String qop) throws ParseException {
        dsTaint.addTaint(qop);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.QOP, qop);
        // ---------- Original Method ----------
        //if (qop == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "A29C3BFFBE330CF76325CB0EF7125F69", hash_generated_method = "168806A82602F17CDA81713F6B22829B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQop() {
        String var7891953F4A984CE99CB6C804B180E7A6_1003684536 = (getParameter(ParameterNames.QOP));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "76E3536FF05DCEF3BC0C3CCACC26C3E9", hash_generated_method = "EE868D986C57B561137449E6413A726B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOpaque(String opaque) throws ParseException {
        dsTaint.addTaint(opaque);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.OPAQUE, opaque);
        // ---------- Original Method ----------
        //if (opaque == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.OPAQUE, opaque);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "74CFB2775BB87B4CA5EB14E12EDD4FAA", hash_generated_method = "2CB5D11324339E446DD694430A1C9520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOpaque() {
        String var42ADC149D1DE021A328BD275869EF12B_544441325 = (getParameter(ParameterNames.OPAQUE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.OPAQUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.771 -0400", hash_original_method = "0CF00DF85E6E023A49347C3D97FE25E8", hash_generated_method = "CCD85D0511F8B6ACECF9E8304D0138E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDomain(String domain) throws ParseException {
        dsTaint.addTaint(domain);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        setParameter(ParameterNames.DOMAIN, domain);
        // ---------- Original Method ----------
        //if (domain == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.DOMAIN, domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "FF2BF47C5FE979FA8AC19766A91C33D5", hash_generated_method = "2301F8A35703B42F77942C062A40E90A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDomain() {
        String var9E8CB087203954B69AD3C503C4D3D447_995498308 = (getParameter(ParameterNames.DOMAIN));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.DOMAIN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "4D2E04293B20A27BD458DB2208C5CD5A", hash_generated_method = "391F243243664F69E56EDC92F7CDB02C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStale(boolean stale) {
        dsTaint.addTaint(stale);
        setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
        // ---------- Original Method ----------
        //setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "DC27EBD9E1BDFC9CCA499BC74F11D850", hash_generated_method = "69328E3C98EF33ADC2A0347DA6457C53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStale() {
        boolean var59C0D15E95DE4B7103AFB114D7F67902_1175790573 = (this.getParameterAsBoolean(ParameterNames.STALE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.getParameterAsBoolean(ParameterNames.STALE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "DC70DAD63B3B016EB719597770A168A8", hash_generated_method = "51398F45BA29D43A82C244FB1C23FE3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCNonce(String cnonce) throws ParseException {
        dsTaint.addTaint(cnonce);
        this.setParameter(ParameterNames.CNONCE, cnonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cnonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "2A1857D33807A19504A72F3100996078", hash_generated_method = "F8253358504B7E2E89DAE413BB0D6167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCNonce() {
        String varD8E910A08C3B40DDAC8DD9FAD241948E_1212964752 = (getParameter(ParameterNames.CNONCE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.CNONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.772 -0400", hash_original_method = "A399E18540C780BD641CBDC9149756E0", hash_generated_method = "965EB02DC915B61A54CD0724E0013065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNonceCount() {
        int var6D948F5C0412617498531BFE3A4615C0_1710222596 = (this.getParameterAsHexInt(ParameterNames.NC));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getParameterAsHexInt(ParameterNames.NC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "76CF7C4BB03DAD75C2063E167B2975DA", hash_generated_method = "D1BDE854A9EF3B70C0A0073C7A5D8550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNonceCount(int param) throws java.text.ParseException {
        dsTaint.addTaint(param);
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad value", 0);
        String nc;
        nc = Integer.toHexString(param);
        String base;
        base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);
        // ---------- Original Method ----------
        //if (param < 0)
            //throw new ParseException("bad value", 0);
        //String nc = Integer.toHexString(param);
        //String base = "00000000";
        //nc = base.substring(0, 8 - nc.length()) + nc;
        //this.setParameter(ParameterNames.NC, nc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "9CF506858536EED9F17336D37906D7B1", hash_generated_method = "0BECFC4A5A79907E2F914E2874258573")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResponse() {
        String var1ABCDB2445EFDCA5FE740C6FAA9ECCDE_111552873 = ((String) getParameterValue(ParameterNames.RESPONSE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) getParameterValue(ParameterNames.RESPONSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "3019C4D6EA7009219C4F2124D013528F", hash_generated_method = "A21E3A1C34536D099699B6C18EE468C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setResponse(String response) throws ParseException {
        dsTaint.addTaint(response);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null parameter");
        this.setParameter(RESPONSE, response);
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("Null parameter");
        //this.setParameter(RESPONSE, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "B515E3B485EA8C128CD8B454808B5965", hash_generated_method = "86A8AF0BE48EA5D69596E7AC69E81EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUsername() {
        String var9F6BE4A3964D87DDE8FBA78F9930EAA2_585528975 = ((String) getParameter(ParameterNames.USERNAME));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) getParameter(ParameterNames.USERNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "737A9BC8D666816000B1F83AF3435CC9", hash_generated_method = "A8C0B0AE21D196E2C8B6780EC56A494B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUsername(String username) throws ParseException {
        dsTaint.addTaint(username);
        this.setParameter(ParameterNames.USERNAME, username);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.USERNAME, username);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.773 -0400", hash_original_method = "C945DC5CCA937939305E33DCD57FE88B", hash_generated_method = "8FEC1E983293D8793264B51129C6BEBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIK(String ik) throws ParseException {
        dsTaint.addTaint(ik);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        setParameter(IK, ik);
        // ---------- Original Method ----------
        //if (ik == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        //setParameter(IK, ik);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.774 -0400", hash_original_method = "6860A8600CF9767918EEF6950728D612", hash_generated_method = "464A681E5C423F19689487CB1AB32DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIK() {
        String varF8526D6A70F89E72D1425B859877AC0F_94894961 = (getParameter(ParameterNamesIms.IK));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.IK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.774 -0400", hash_original_method = "294221E5C763C88C3235A01BF56EDDDF", hash_generated_method = "043BCCD444F185FB182CF370971B1055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCK(String ck) throws ParseException {
        dsTaint.addTaint(ck);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        setParameter(CK, ck);
        // ---------- Original Method ----------
        //if (ck == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        //setParameter(CK, ck);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.774 -0400", hash_original_method = "069687871A480347A7851D04BD98256F", hash_generated_method = "B35D71CB35E98D14B3B976C5B2C4043F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCK() {
        String varD0743C1827864314AB6533B838AB82E9_1314483742 = (getParameter(ParameterNamesIms.CK));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.774 -0400", hash_original_method = "2D0954ACD2F7E7C621F6D74F94C4BE3A", hash_generated_method = "5D77BC88A97C74B07695E16ACB1148FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIntegrityProtected(String integrityProtected) throws ParseException {
        dsTaint.addTaint(integrityProtected);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        setParameter(INTEGRITY_PROTECTED, integrityProtected);
        // ---------- Original Method ----------
        //if (integrityProtected == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        //setParameter(INTEGRITY_PROTECTED, integrityProtected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.774 -0400", hash_original_method = "84FABD46260852E6AB8072476C79DC4A", hash_generated_method = "2C366A694682E5A993DE7D66DACC3BA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIntegrityProtected() {
        String var37223D58203804D08EB71803EF9AA9D6_731529907 = (getParameter(ParameterNamesIms.INTEGRITY_PROTECTED));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
    }

    
    public static final String DOMAIN = ParameterNames.DOMAIN;
    public static final String REALM = ParameterNames.REALM;
    public static final String OPAQUE = ParameterNames.OPAQUE;
    public static final String ALGORITHM = ParameterNames.ALGORITHM;
    public static final String QOP = ParameterNames.QOP;
    public static final String STALE = ParameterNames.STALE;
    public static final String SIGNATURE = ParameterNames.SIGNATURE;
    public static final String RESPONSE = ParameterNames.RESPONSE;
    public static final String SIGNED_BY = ParameterNames.SIGNED_BY;
    public static final String NC = ParameterNames.NC;
    public static final String URI = ParameterNames.URI;
    public static final String USERNAME = ParameterNames.USERNAME;
    public static final String CNONCE = ParameterNames.CNONCE;
    public static final String NONCE = ParameterNames.NONCE;
    public static final String IK = ParameterNamesIms.IK;
    public static final String CK = ParameterNamesIms.CK;
    public static final String INTEGRITY_PROTECTED = ParameterNamesIms.INTEGRITY_PROTECTED;
}

