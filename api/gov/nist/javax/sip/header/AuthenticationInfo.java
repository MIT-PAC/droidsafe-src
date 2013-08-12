package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;

import java.text.ParseException;






public final class AuthenticationInfo extends ParametersHeader implements javax.sip.header.AuthenticationInfoHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.043 -0400", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "EF9C7B2271BA28B15E1D45A4FFBE5636")
    public  AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(COMMA);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.043 -0400", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "6C15125D2E458388455620DCFE89F588")
    public void add(NameValue nv) {
        addTaint(nv.getTaint());
        parameters.set(nv);
        // ---------- Original Method ----------
        //parameters.set(nv);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.043 -0400", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "32860898638888B38D5BC96415331A0B")
    protected String encodeBody() {
String varEF6E14FE7C327BE363085D7A5020E89C_1120349398 =         parameters.encode();
        varEF6E14FE7C327BE363085D7A5020E89C_1120349398.addTaint(taint);
        return varEF6E14FE7C327BE363085D7A5020E89C_1120349398;
        // ---------- Original Method ----------
        //return parameters.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.044 -0400", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "4F5EE5721B513BE4CACF2B38E2DC46AB")
    public NameValue getAuthInfo(String name) {
        addTaint(name.getTaint());
NameValue var08CE355D14F19014A56F4D6624A9A085_114181461 =         parameters.getNameValue(name);
        var08CE355D14F19014A56F4D6624A9A085_114181461.addTaint(taint);
        return var08CE355D14F19014A56F4D6624A9A085_114181461;
        // ---------- Original Method ----------
        //return parameters.getNameValue(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.044 -0400", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "05AA015668B0F018604DA14A71A348CA")
    public String getAuthenticationInfo() {
String varC32A0959BF3FBBB1F055BAFAA3BABC6F_1726128749 =         this.encodeBody();
        varC32A0959BF3FBBB1F055BAFAA3BABC6F_1726128749.addTaint(taint);
        return varC32A0959BF3FBBB1F055BAFAA3BABC6F_1726128749;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.044 -0400", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "87ED88D662DD926059A8F554BEC9CCBA")
    public String getCNonce() {
String varE2DF18D400D8A553B066B8EBEE3E0E83_422393695 =         this.getParameter(ParameterNames.CNONCE);
        varE2DF18D400D8A553B066B8EBEE3E0E83_422393695.addTaint(taint);
        return varE2DF18D400D8A553B066B8EBEE3E0E83_422393695;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.CNONCE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.044 -0400", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "9F97312BDF608E5F6D6885621CCBEF94")
    public String getNextNonce() {
String var14D8949ABEF605C6C1D564C15EBB9107_538100003 =         this.getParameter(ParameterNames.NEXT_NONCE);
        var14D8949ABEF605C6C1D564C15EBB9107_538100003.addTaint(taint);
        return var14D8949ABEF605C6C1D564C15EBB9107_538100003;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.045 -0400", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "C2CCF414036E3220F95B2381B86573F0")
    public int getNonceCount() {
        int var259FAEFC253EF28A06A03092946850BF_1417210649 = (this.getParameterAsInt(ParameterNames.NONCE_COUNT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417606237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417606237;
        // ---------- Original Method ----------
        //return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.045 -0400", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "000CAD863A3D951EC47630F5E9124595")
    public String getQop() {
String varA8271BA7C314C4DDDC2F17394A48B535_981786639 =         this.getParameter(ParameterNames.QOP);
        varA8271BA7C314C4DDDC2F17394A48B535_981786639.addTaint(taint);
        return varA8271BA7C314C4DDDC2F17394A48B535_981786639;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.QOP);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.045 -0400", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "6D67880231A4684BE554A0CE3E89D526")
    public String getResponse() {
String var652AB4C7E1504C0D435CEB3C517BD439_630296517 =         this.getParameter(ParameterNames.RESPONSE_AUTH);
        var652AB4C7E1504C0D435CEB3C517BD439_630296517.addTaint(taint);
        return var652AB4C7E1504C0D435CEB3C517BD439_630296517;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.045 -0400", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "5D479ED128D668886B36EE7821AAA7CB")
    public void setCNonce(String cNonce) throws ParseException {
        addTaint(cNonce.getTaint());
        this.setParameter(ParameterNames.CNONCE, cNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.046 -0400", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "257112CD3E8B37BCC56D25965E5E6064")
    public void setNextNonce(String nextNonce) throws ParseException {
        addTaint(nextNonce.getTaint());
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.046 -0400", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "0E1EEA4831F5ED2016C5399AD046BD96")
    public void setNonceCount(int nonceCount) throws ParseException {
        addTaint(nonceCount);
        if(nonceCount < 0)        
        {
        ParseException var54BE8DFF7C0EAB1F79C63979F741D118_756892725 = new ParseException("bad value", 0);
        var54BE8DFF7C0EAB1F79C63979F741D118_756892725.addTaint(taint);
        throw var54BE8DFF7C0EAB1F79C63979F741D118_756892725;
        }
        String nc = Integer.toHexString(nonceCount);
        String base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);
        // ---------- Original Method ----------
        //if (nonceCount < 0)
            //throw new ParseException("bad value", 0);
        //String nc = Integer.toHexString(nonceCount);
        //String base = "00000000";
        //nc = base.substring(0, 8 - nc.length()) + nc;
        //this.setParameter(ParameterNames.NC, nc);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.047 -0400", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "57A9BCC9E8F5D67744D6D9DFC75B8D43")
    public void setQop(String qop) throws ParseException {
        addTaint(qop.getTaint());
        this.setParameter(ParameterNames.QOP, qop);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.QOP, qop);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.047 -0400", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "C661184E5EE75DFCA9B4BC2803991365")
    public void setResponse(String response) throws ParseException {
        addTaint(response.getTaint());
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.048 -0400", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "6DD79AE2407635F7F14472FD03674AB4")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
        NullPointerException var2436528A4849C093D8F0C3ED74594749_1062790605 = new NullPointerException("null name");
        var2436528A4849C093D8F0C3ED74594749_1062790605.addTaint(taint);
        throw var2436528A4849C093D8F0C3ED74594749_1062790605;
        }
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if(nv == null)        
        {
            nv = new NameValue(name, value);
            if(name.equalsIgnoreCase(ParameterNames.QOP)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.REALM)
                || name.equalsIgnoreCase(ParameterNames.CNONCE)
                || name.equalsIgnoreCase(ParameterNames.NONCE)
                || name.equalsIgnoreCase(ParameterNames.OPAQUE)
                || name.equalsIgnoreCase(ParameterNames.USERNAME)
                || name.equalsIgnoreCase(ParameterNames.DOMAIN)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.RESPONSE_AUTH))            
            {
                if(value == null)                
                {
                NullPointerException var5581ED2812AE061277296C54374A63DE_1867735607 = new NullPointerException("null value");
                var5581ED2812AE061277296C54374A63DE_1867735607.addTaint(taint);
                throw var5581ED2812AE061277296C54374A63DE_1867735607;
                }
                if(value.startsWith(Separators.DOUBLE_QUOTE))                
                {
                ParseException varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1786461913 = new ParseException(
                        value + " : Unexpected DOUBLE_QUOTE",
                        0);
                varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1786461913.addTaint(taint);
                throw varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1786461913;
                }
                nv.setQuotedValue();
            } //End block
            super.setParameter(nv);
        } //End block
        else
        nv.setValueAsObject(value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.049 -0400", hash_original_field = "3D12B1C5F1DD39627A9C3476E23AB9F6", hash_generated_field = "7AD675CC1A8C3510545F19A418D005F3")

    private static final long serialVersionUID = -4371927900917127057L;
}

