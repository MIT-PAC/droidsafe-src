package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;

import java.text.ParseException;






public abstract class AuthenticationHeader extends ParametersHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.948 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.948 -0400", hash_original_method = "54F496DB6FA267582688938E2479AFBA", hash_generated_method = "B4F236130307FEDC604CE6EF6AC3EF84")
    public  AuthenticationHeader(String name) {
        super(name);
        addTaint(name.getTaint());
        parameters.setSeparator(Separators.COMMA);
        this.scheme = ParameterNames.DIGEST;
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
        //this.scheme = ParameterNames.DIGEST;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.948 -0400", hash_original_method = "DB765A091C9F86F3B91F21F5A402D773", hash_generated_method = "AF7ABC2AFF9A4F2DB220A0160AEAC81F")
    public  AuthenticationHeader() {
        super();
        parameters.setSeparator(Separators.COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.COMMA);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.949 -0400", hash_original_method = "63A2509649DB1C5E3D5569CEACEDF418", hash_generated_method = "87B99C4BC0CEB8BB2C69CEBFF1E50DF1")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if(nv == null)        
        {
            nv = new NameValue(name, value);
            if(name.equalsIgnoreCase(ParameterNames.QOP)
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
                    || name.equalsIgnoreCase(ParameterNamesIms.INTEGRITY_PROTECTED))            
            {
                if(((this instanceof Authorization) || (this instanceof ProxyAuthorization))
                        && name.equalsIgnoreCase(ParameterNames.QOP))                
                {
                } //End block
                else
                {
                    nv.setQuotedValue();
                } //End block
                if(value == null)                
                {
                NullPointerException var5581ED2812AE061277296C54374A63DE_1459846263 = new NullPointerException("null value");
                var5581ED2812AE061277296C54374A63DE_1459846263.addTaint(taint);
                throw var5581ED2812AE061277296C54374A63DE_1459846263;
                }
                if(value.startsWith(Separators.DOUBLE_QUOTE))                
                {
                ParseException varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1871243482 = new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1871243482.addTaint(taint);
                throw varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1871243482;
                }
            } //End block
            super.setParameter(nv);
        } //End block
        else
        nv.setValueAsObject(value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.950 -0400", hash_original_method = "855C75AA7A25318520BDD2BB747F87D1", hash_generated_method = "9FFE68DB2BC797370DD296B8F23D1704")
    public void setChallenge(Challenge challenge) {
        this.scheme = challenge.scheme;
        super.parameters = challenge.authParams;
        // ---------- Original Method ----------
        //this.scheme = challenge.scheme;
        //super.parameters = challenge.authParams;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.950 -0400", hash_original_method = "9C8F11B1DE9667C53D0EB2C6FF74CC89", hash_generated_method = "7441C51576E8058857A5592C0B2FDB46")
    public String encodeBody() {
        this.parameters.setSeparator(Separators.COMMA);
String var1B7D7B4D1A71564D7B468B6DD2360685_614473823 =         this.scheme + SP + parameters.encode();
        var1B7D7B4D1A71564D7B468B6DD2360685_614473823.addTaint(taint);
        return var1B7D7B4D1A71564D7B468B6DD2360685_614473823;
        // ---------- Original Method ----------
        //this.parameters.setSeparator(Separators.COMMA);
        //return this.scheme + SP + parameters.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.951 -0400", hash_original_method = "12283BFE3BE1F2D48F088D181A48BB59", hash_generated_method = "F7F89B7A7F4E4526442680C88997CE5D")
    public void setScheme(String scheme) {
        this.scheme = scheme;
        // ---------- Original Method ----------
        //this.scheme = scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.951 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "EFCCEDBC8CF7B18775E09B38848C90F9")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1489726121 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1489726121.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1489726121;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.951 -0400", hash_original_method = "389B06AAD21713BEFD607954CE113A50", hash_generated_method = "03BA99A4C5873F0395A1F2A89555671C")
    public void setRealm(String realm) throws ParseException {
        addTaint(realm.getTaint());
        if(realm == null)        
        {
        NullPointerException var0675349FFDE9B2D4B75982B5BA5B3F92_900768088 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setRealm(), The realm parameter is null");
        var0675349FFDE9B2D4B75982B5BA5B3F92_900768088.addTaint(taint);
        throw var0675349FFDE9B2D4B75982B5BA5B3F92_900768088;
        }
        setParameter(ParameterNames.REALM, realm);
        // ---------- Original Method ----------
        //if (realm == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setRealm(), The realm parameter is null");
        //setParameter(ParameterNames.REALM, realm);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.952 -0400", hash_original_method = "C947FEA98ED8A5E735C71437037B2D94", hash_generated_method = "CAEB4AA8136D170413D785684EDD8A95")
    public String getRealm() {
String var52038303D79E876956378757E6718C39_784214331 =         getParameter(ParameterNames.REALM);
        var52038303D79E876956378757E6718C39_784214331.addTaint(taint);
        return var52038303D79E876956378757E6718C39_784214331;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.REALM);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.952 -0400", hash_original_method = "D28512DD5DADEB1219799F9FE9539511", hash_generated_method = "4613F598E2456BB507C814F2C3D24325")
    public void setNonce(String nonce) throws ParseException {
        addTaint(nonce.getTaint());
        if(nonce == null)        
        {
        NullPointerException var01A9E6B003A8D60DA1AC2B006E65C727_961704045 = new NullPointerException(
                    "JAIN-SIP Exception, "
                            + " AuthenticationHeader, setNonce(), The nonce parameter is null");
        var01A9E6B003A8D60DA1AC2B006E65C727_961704045.addTaint(taint);
        throw var01A9E6B003A8D60DA1AC2B006E65C727_961704045;
        }
        setParameter(NONCE, nonce);
        // ---------- Original Method ----------
        //if (nonce == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ " AuthenticationHeader, setNonce(), The nonce parameter is null");
        //setParameter(NONCE, nonce);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.952 -0400", hash_original_method = "AE10AC1E29E2379ECD11C42D2EA0F8C1", hash_generated_method = "08DD282D21DFF8101CDEEEA8661137ED")
    public String getNonce() {
String var633F5466DA94E80AD88E448E7E95AA79_2078218729 =         getParameter(ParameterNames.NONCE);
        var633F5466DA94E80AD88E448E7E95AA79_2078218729.addTaint(taint);
        return var633F5466DA94E80AD88E448E7E95AA79_2078218729;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.NONCE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.953 -0400", hash_original_method = "1D3E80F645890E8406B036C8FE6ADD92", hash_generated_method = "B64E7462367D0805607952CC2C1A749F")
    public void setURI(javax.sip.address.URI uri) {
        addTaint(uri.getTaint());
        if(uri != null)        
        {
            NameValue nv = new NameValue(ParameterNames.URI, uri);
            nv.setQuotedValue();
            super.parameters.set(nv);
        } //End block
        else
        {
            NullPointerException var64A282CF2B34A97D1F462E020A18B257_356731112 = new NullPointerException("Null URI");
            var64A282CF2B34A97D1F462E020A18B257_356731112.addTaint(taint);
            throw var64A282CF2B34A97D1F462E020A18B257_356731112;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.953 -0400", hash_original_method = "C651D4576806B169F61A46B4807216FD", hash_generated_method = "D5AF388D1973DC8874610909072DB916")
    public javax.sip.address.URI getURI() {
javax.sip.address.URI var6F068FBDDD0AF28B4DBD05B3B635730E_195112541 =         getParameterAsURI(ParameterNames.URI);
        var6F068FBDDD0AF28B4DBD05B3B635730E_195112541.addTaint(taint);
        return var6F068FBDDD0AF28B4DBD05B3B635730E_195112541;
        // ---------- Original Method ----------
        //return getParameterAsURI(ParameterNames.URI);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.953 -0400", hash_original_method = "A70D72402AA001F050CF710FE3E4AACB", hash_generated_method = "99671EC15312E664F48CD6056A4293F4")
    public void setAlgorithm(String algorithm) throws ParseException {
        addTaint(algorithm.getTaint());
        if(algorithm == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_750826119 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_750826119.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_750826119;
        }
        setParameter(ParameterNames.ALGORITHM, algorithm);
        // ---------- Original Method ----------
        //if (algorithm == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.ALGORITHM, algorithm);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.954 -0400", hash_original_method = "2AF2AF93F3BCE45D8EB0FCF5D647A3F0", hash_generated_method = "8DB76489777044700607F34EF2562DC2")
    public String getAlgorithm() {
String var5A22E04A96BC5555DBA79DFB7DA5327F_875507728 =         getParameter(ParameterNames.ALGORITHM);
        var5A22E04A96BC5555DBA79DFB7DA5327F_875507728.addTaint(taint);
        return var5A22E04A96BC5555DBA79DFB7DA5327F_875507728;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ALGORITHM);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.954 -0400", hash_original_method = "33AFDF6E9223256AFA6668E8CADD3DE2", hash_generated_method = "D202657FC70E47D838E46CC499739C62")
    public void setQop(String qop) throws ParseException {
        addTaint(qop.getTaint());
        if(qop == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1964673463 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1964673463.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1964673463;
        }
        setParameter(ParameterNames.QOP, qop);
        // ---------- Original Method ----------
        //if (qop == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.QOP, qop);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.954 -0400", hash_original_method = "A29C3BFFBE330CF76325CB0EF7125F69", hash_generated_method = "893E35BDA9B417E6A418A112C921C4F9")
    public String getQop() {
String varC63179C753820E5492FD8F46D306E183_819835197 =         getParameter(ParameterNames.QOP);
        varC63179C753820E5492FD8F46D306E183_819835197.addTaint(taint);
        return varC63179C753820E5492FD8F46D306E183_819835197;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.QOP);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.954 -0400", hash_original_method = "76E3536FF05DCEF3BC0C3CCACC26C3E9", hash_generated_method = "6B92F1599F99B48343BA6F2D123AF62D")
    public void setOpaque(String opaque) throws ParseException {
        addTaint(opaque.getTaint());
        if(opaque == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_217967069 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_217967069.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_217967069;
        }
        setParameter(ParameterNames.OPAQUE, opaque);
        // ---------- Original Method ----------
        //if (opaque == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.OPAQUE, opaque);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.955 -0400", hash_original_method = "74CFB2775BB87B4CA5EB14E12EDD4FAA", hash_generated_method = "6854D18DF6E4BABD0C06CFD57DEE63A3")
    public String getOpaque() {
String var66C8E7E8539DCA034949408787F5A673_1988937101 =         getParameter(ParameterNames.OPAQUE);
        var66C8E7E8539DCA034949408787F5A673_1988937101.addTaint(taint);
        return var66C8E7E8539DCA034949408787F5A673_1988937101;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.OPAQUE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.955 -0400", hash_original_method = "0CF00DF85E6E023A49347C3D97FE25E8", hash_generated_method = "F653B5C8338BB11B6DF5619B9264A017")
    public void setDomain(String domain) throws ParseException {
        addTaint(domain.getTaint());
        if(domain == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1263014642 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1263014642.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1263014642;
        }
        setParameter(ParameterNames.DOMAIN, domain);
        // ---------- Original Method ----------
        //if (domain == null)
            //throw new NullPointerException("null arg");
        //setParameter(ParameterNames.DOMAIN, domain);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.955 -0400", hash_original_method = "FF2BF47C5FE979FA8AC19766A91C33D5", hash_generated_method = "4EAF28EAA1E9C51B0444E63A43DA306E")
    public String getDomain() {
String varDF4BAC5A13827AD6B68DE69421DC0D6E_2098846362 =         getParameter(ParameterNames.DOMAIN);
        varDF4BAC5A13827AD6B68DE69421DC0D6E_2098846362.addTaint(taint);
        return varDF4BAC5A13827AD6B68DE69421DC0D6E_2098846362;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.DOMAIN);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.955 -0400", hash_original_method = "4D2E04293B20A27BD458DB2208C5CD5A", hash_generated_method = "1A4626977D06C4B7EBD4432AD9737FBA")
    public void setStale(boolean stale) {
        addTaint(stale);
        setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
        // ---------- Original Method ----------
        //setParameter(new NameValue(ParameterNames.STALE, Boolean.valueOf(stale)));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.955 -0400", hash_original_method = "DC27EBD9E1BDFC9CCA499BC74F11D850", hash_generated_method = "2AD1C79956DB377F600FF7F080588110")
    public boolean isStale() {
        boolean varA9B464E3576C4D1A79C92D651B4DE6A3_1911187739 = (this.getParameterAsBoolean(ParameterNames.STALE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346090093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346090093;
        // ---------- Original Method ----------
        //return this.getParameterAsBoolean(ParameterNames.STALE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.956 -0400", hash_original_method = "DC70DAD63B3B016EB719597770A168A8", hash_generated_method = "B0246F26097DE78998777B2A7395E2CE")
    public void setCNonce(String cnonce) throws ParseException {
        addTaint(cnonce.getTaint());
        this.setParameter(ParameterNames.CNONCE, cnonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cnonce);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.956 -0400", hash_original_method = "2A1857D33807A19504A72F3100996078", hash_generated_method = "5C16A90DF77EABA9BE014291A1B6E852")
    public String getCNonce() {
String var93BE962EB8A0FAE56B82EB332046CB96_68945360 =         getParameter(ParameterNames.CNONCE);
        var93BE962EB8A0FAE56B82EB332046CB96_68945360.addTaint(taint);
        return var93BE962EB8A0FAE56B82EB332046CB96_68945360;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.CNONCE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.956 -0400", hash_original_method = "A399E18540C780BD641CBDC9149756E0", hash_generated_method = "3A4CEAFE2EDEF4E81ADB90153D6DF8B9")
    public int getNonceCount() {
        int varBBD9396C889E55DC0AB3593C95514182_1668936373 = (this.getParameterAsHexInt(ParameterNames.NC));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343624181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343624181;
        // ---------- Original Method ----------
        //return this.getParameterAsHexInt(ParameterNames.NC);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.956 -0400", hash_original_method = "76CF7C4BB03DAD75C2063E167B2975DA", hash_generated_method = "EEF5CDEDE645B2C7BAD3735555E3309F")
    public void setNonceCount(int param) throws java.text.ParseException {
        addTaint(param);
        if(param < 0)        
        {
        ParseException var54BE8DFF7C0EAB1F79C63979F741D118_681521869 = new ParseException("bad value", 0);
        var54BE8DFF7C0EAB1F79C63979F741D118_681521869.addTaint(taint);
        throw var54BE8DFF7C0EAB1F79C63979F741D118_681521869;
        }
        String nc = Integer.toHexString(param);
        String base = "00000000";
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.957 -0400", hash_original_method = "9CF506858536EED9F17336D37906D7B1", hash_generated_method = "442CD77FDAEFC703438D318A254F3A49")
    public String getResponse() {
String var24BFA4FDC10873DF0F248DAD6AD7D84F_1065766430 =         (String) getParameterValue(ParameterNames.RESPONSE);
        var24BFA4FDC10873DF0F248DAD6AD7D84F_1065766430.addTaint(taint);
        return var24BFA4FDC10873DF0F248DAD6AD7D84F_1065766430;
        // ---------- Original Method ----------
        //return (String) getParameterValue(ParameterNames.RESPONSE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.957 -0400", hash_original_method = "3019C4D6EA7009219C4F2124D013528F", hash_generated_method = "62F4CBAB08A874D0B581B0C1A8D1196D")
    public void setResponse(String response) throws ParseException {
        addTaint(response.getTaint());
        if(response == null)        
        {
        NullPointerException varA9604F3EA58FBEB92FE5D724752C36F9_359614708 = new NullPointerException("Null parameter");
        varA9604F3EA58FBEB92FE5D724752C36F9_359614708.addTaint(taint);
        throw varA9604F3EA58FBEB92FE5D724752C36F9_359614708;
        }
        this.setParameter(RESPONSE, response);
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("Null parameter");
        //this.setParameter(RESPONSE, response);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.957 -0400", hash_original_method = "B515E3B485EA8C128CD8B454808B5965", hash_generated_method = "7ED7C195E40C09BC34101CB54E49C606")
    public String getUsername() {
String var786AEDEAFA8AD404AE5F376E479DDF76_2007163724 =         (String) getParameter(ParameterNames.USERNAME);
        var786AEDEAFA8AD404AE5F376E479DDF76_2007163724.addTaint(taint);
        return var786AEDEAFA8AD404AE5F376E479DDF76_2007163724;
        // ---------- Original Method ----------
        //return (String) getParameter(ParameterNames.USERNAME);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.957 -0400", hash_original_method = "737A9BC8D666816000B1F83AF3435CC9", hash_generated_method = "DD1FDBE94AEDC58215A73CAD62413EE2")
    public void setUsername(String username) throws ParseException {
        addTaint(username.getTaint());
        this.setParameter(ParameterNames.USERNAME, username);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.USERNAME, username);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.958 -0400", hash_original_method = "C945DC5CCA937939305E33DCD57FE88B", hash_generated_method = "DCAE02EF4B7AC9B9DA7D22276B2D88A1")
    public void setIK(String ik) throws ParseException {
        addTaint(ik.getTaint());
        if(ik == null)        
        {
        NullPointerException var1D10ABA05ED2489A3B39924A64E95426_1670271803 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        var1D10ABA05ED2489A3B39924A64E95426_1670271803.addTaint(taint);
        throw var1D10ABA05ED2489A3B39924A64E95426_1670271803;
        }
        setParameter(IK, ik);
        // ---------- Original Method ----------
        //if (ik == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        //setParameter(IK, ik);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.958 -0400", hash_original_method = "6860A8600CF9767918EEF6950728D612", hash_generated_method = "C53D96A271FDD85844D7E606F4B80822")
    public String getIK() {
String var7310368D1E6CD4663463BEE9181450C1_1032864210 =         getParameter(ParameterNamesIms.IK);
        var7310368D1E6CD4663463BEE9181450C1_1032864210.addTaint(taint);
        return var7310368D1E6CD4663463BEE9181450C1_1032864210;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.IK);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.958 -0400", hash_original_method = "294221E5C763C88C3235A01BF56EDDDF", hash_generated_method = "582DFAF5C20FC58BF6C7F79E58D4FC2B")
    public void setCK(String ck) throws ParseException {
        addTaint(ck.getTaint());
        if(ck == null)        
        {
        NullPointerException var55F5736E11503FA6EA4C256B2D0DC740_530390520 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        var55F5736E11503FA6EA4C256B2D0DC740_530390520.addTaint(taint);
        throw var55F5736E11503FA6EA4C256B2D0DC740_530390520;
        }
        setParameter(CK, ck);
        // ---------- Original Method ----------
        //if (ck == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        //setParameter(CK, ck);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.958 -0400", hash_original_method = "069687871A480347A7851D04BD98256F", hash_generated_method = "BD0694C663E57744A34AAD2DAE134466")
    public String getCK() {
String var2A1A980A8CCF8C989EB4EC1F15406575_953315241 =         getParameter(ParameterNamesIms.CK);
        var2A1A980A8CCF8C989EB4EC1F15406575_953315241.addTaint(taint);
        return var2A1A980A8CCF8C989EB4EC1F15406575_953315241;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.CK);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_method = "2D0954ACD2F7E7C621F6D74F94C4BE3A", hash_generated_method = "A524B28497626B89EC641D25B958F741")
    public void setIntegrityProtected(String integrityProtected) throws ParseException {
        addTaint(integrityProtected.getTaint());
        if(integrityProtected == null)        
        {
        NullPointerException var1D79F17EBE7F5845ADADDE1B8322BC82_1341200026 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        var1D79F17EBE7F5845ADADDE1B8322BC82_1341200026.addTaint(taint);
        throw var1D79F17EBE7F5845ADADDE1B8322BC82_1341200026;
        }
        setParameter(INTEGRITY_PROTECTED, integrityProtected);
        // ---------- Original Method ----------
        //if (integrityProtected == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        //setParameter(INTEGRITY_PROTECTED, integrityProtected);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_method = "84FABD46260852E6AB8072476C79DC4A", hash_generated_method = "5D9C95DB3EE0BF6E99D6C1B748B215F4")
    public String getIntegrityProtected() {
String var68F299ECC8BEA5D053EE37C98FF338B4_2099357085 =         getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
        var68F299ECC8BEA5D053EE37C98FF338B4_2099357085.addTaint(taint);
        return var68F299ECC8BEA5D053EE37C98FF338B4_2099357085;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.INTEGRITY_PROTECTED);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "17FF58D2E4819C468CD0033E52CC7881")

    public static final String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "EBBD9BA1BADBAC5EF593F488645D5C46")

    public static final String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "04CDC06BB0A5B6663DDA46DEE36CCB2B")

    public static final String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "591C458296CAAD3DAD3DC69D39923AB3")

    public static final String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "7862B7814B761743D8679A1CE71BE925")

    public static final String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "9254AA79BC5CBC7DBBCE98D12C5618BC")

    public static final String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "EC08D758804B4FDE227D2AAB23EED546")

    public static final String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "0BBA7683ABB90D800A75724CF582A61A")

    public static final String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.959 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C2AF6C64E388AB2628A7844DCD27068F")

    public static final String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "6B99FF024523454EDC36F1887E571D7D", hash_generated_field = "945C00AD0FB2001FDFE332FC462F84B5")

    public static final String NC = ParameterNames.NC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "E0529E04E9C46EB7B3C9AFFEEB80131C")

    public static final String URI = ParameterNames.URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "7D01DFAF0E866EC17460395E6A1D2AEF", hash_generated_field = "141BBA99C5BA0E2C564C80B92D9ECEF4")

    public static final String USERNAME = ParameterNames.USERNAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "7AC54993845CA13D03D423F8F71F248D", hash_generated_field = "7628B0C67486A8D201E3E813C670AEFA")

    public static final String CNONCE = ParameterNames.CNONCE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "A1A4F8636F685D229DB94D99C344EE7F", hash_generated_field = "4FA62036A736AEB7215955B884E2C736")

    public static final String NONCE = ParameterNames.NONCE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "DDEB1079010E599C8162878F194138D0", hash_generated_field = "509D45CD35B3A28E9024383BC022E75B")

    public static final String IK = ParameterNamesIms.IK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "81A1ECA06CB9A364EAB0AA343DFF1FE9", hash_generated_field = "D36E5E6DD689766EC5136A3D190A0B78")

    public static final String CK = ParameterNamesIms.CK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.960 -0400", hash_original_field = "A9D09F976D523EA433BE0BC37D227F69", hash_generated_field = "2AD0537217FB260E580A1D4CCD6793D9")

    public static final String INTEGRITY_PROTECTED = ParameterNamesIms.INTEGRITY_PROTECTED;
}

