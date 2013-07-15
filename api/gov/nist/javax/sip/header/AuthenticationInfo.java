package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.text.ParseException;

public final class AuthenticationInfo extends ParametersHeader implements javax.sip.header.AuthenticationInfoHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.035 -0400", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "EF9C7B2271BA28B15E1D45A4FFBE5636")
    public  AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(COMMA);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.036 -0400", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "6C15125D2E458388455620DCFE89F588")
    public void add(NameValue nv) {
        addTaint(nv.getTaint());
        parameters.set(nv);
        // ---------- Original Method ----------
        //parameters.set(nv);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.036 -0400", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "F375C46970179028867AB35BAFF5FCCD")
    protected String encodeBody() {
String varEF6E14FE7C327BE363085D7A5020E89C_1618892631 =         parameters.encode();
        varEF6E14FE7C327BE363085D7A5020E89C_1618892631.addTaint(taint);
        return varEF6E14FE7C327BE363085D7A5020E89C_1618892631;
        // ---------- Original Method ----------
        //return parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.036 -0400", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "044B85E19D476478C662F93F6B80EE54")
    public NameValue getAuthInfo(String name) {
        addTaint(name.getTaint());
NameValue var08CE355D14F19014A56F4D6624A9A085_1870082615 =         parameters.getNameValue(name);
        var08CE355D14F19014A56F4D6624A9A085_1870082615.addTaint(taint);
        return var08CE355D14F19014A56F4D6624A9A085_1870082615;
        // ---------- Original Method ----------
        //return parameters.getNameValue(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.037 -0400", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "A4FB3F12C177980F735BFD97B04F2738")
    public String getAuthenticationInfo() {
String varC32A0959BF3FBBB1F055BAFAA3BABC6F_862147021 =         this.encodeBody();
        varC32A0959BF3FBBB1F055BAFAA3BABC6F_862147021.addTaint(taint);
        return varC32A0959BF3FBBB1F055BAFAA3BABC6F_862147021;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.037 -0400", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "590857B8349C8C24CB9F36D87CDFDDB7")
    public String getCNonce() {
String varE2DF18D400D8A553B066B8EBEE3E0E83_434024311 =         this.getParameter(ParameterNames.CNONCE);
        varE2DF18D400D8A553B066B8EBEE3E0E83_434024311.addTaint(taint);
        return varE2DF18D400D8A553B066B8EBEE3E0E83_434024311;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.CNONCE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.037 -0400", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "A3AF1C6A720BA295464328A67F5C6A3E")
    public String getNextNonce() {
String var14D8949ABEF605C6C1D564C15EBB9107_1106299774 =         this.getParameter(ParameterNames.NEXT_NONCE);
        var14D8949ABEF605C6C1D564C15EBB9107_1106299774.addTaint(taint);
        return var14D8949ABEF605C6C1D564C15EBB9107_1106299774;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.037 -0400", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "71D6BD4855E956D2D787BFA8C12DC1AD")
    public int getNonceCount() {
        int var259FAEFC253EF28A06A03092946850BF_725147015 = (this.getParameterAsInt(ParameterNames.NONCE_COUNT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061746133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061746133;
        // ---------- Original Method ----------
        //return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "6F0E2A6411E878D768B3A11390CE496B")
    public String getQop() {
String varA8271BA7C314C4DDDC2F17394A48B535_89019432 =         this.getParameter(ParameterNames.QOP);
        varA8271BA7C314C4DDDC2F17394A48B535_89019432.addTaint(taint);
        return varA8271BA7C314C4DDDC2F17394A48B535_89019432;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.QOP);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "9A59706F0DAA7B8CE5F3CC1500D2B5DF")
    public String getResponse() {
String var652AB4C7E1504C0D435CEB3C517BD439_1604967325 =         this.getParameter(ParameterNames.RESPONSE_AUTH);
        var652AB4C7E1504C0D435CEB3C517BD439_1604967325.addTaint(taint);
        return var652AB4C7E1504C0D435CEB3C517BD439_1604967325;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "5D479ED128D668886B36EE7821AAA7CB")
    public void setCNonce(String cNonce) throws ParseException {
        addTaint(cNonce.getTaint());
        this.setParameter(ParameterNames.CNONCE, cNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "257112CD3E8B37BCC56D25965E5E6064")
    public void setNextNonce(String nextNonce) throws ParseException {
        addTaint(nextNonce.getTaint());
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "485DA04B88467A3837F6B1471DCE1627")
    public void setNonceCount(int nonceCount) throws ParseException {
        addTaint(nonceCount);
    if(nonceCount < 0)        
        {
        ParseException var54BE8DFF7C0EAB1F79C63979F741D118_1531567305 = new ParseException("bad value", 0);
        var54BE8DFF7C0EAB1F79C63979F741D118_1531567305.addTaint(taint);
        throw var54BE8DFF7C0EAB1F79C63979F741D118_1531567305;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "57A9BCC9E8F5D67744D6D9DFC75B8D43")
    public void setQop(String qop) throws ParseException {
        addTaint(qop.getTaint());
        this.setParameter(ParameterNames.QOP, qop);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.046 -0400", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "C661184E5EE75DFCA9B4BC2803991365")
    public void setResponse(String response) throws ParseException {
        addTaint(response.getTaint());
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.047 -0400", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "67718F423454186BF3C2B152CD4D1FD7")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
        NullPointerException var2436528A4849C093D8F0C3ED74594749_568044038 = new NullPointerException("null name");
        var2436528A4849C093D8F0C3ED74594749_568044038.addTaint(taint);
        throw var2436528A4849C093D8F0C3ED74594749_568044038;
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
                NullPointerException var5581ED2812AE061277296C54374A63DE_1748057640 = new NullPointerException("null value");
                var5581ED2812AE061277296C54374A63DE_1748057640.addTaint(taint);
                throw var5581ED2812AE061277296C54374A63DE_1748057640;
                }
    if(value.startsWith(Separators.DOUBLE_QUOTE))                
                {
                ParseException varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1898907362 = new ParseException(
                        value + " : Unexpected DOUBLE_QUOTE",
                        0);
                varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1898907362.addTaint(taint);
                throw varE60A0A92BA5CA1ED6CE0AA8D83CBF780_1898907362;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.047 -0400", hash_original_field = "3D12B1C5F1DD39627A9C3476E23AB9F6", hash_generated_field = "7AD675CC1A8C3510545F19A418D005F3")

    private static final long serialVersionUID = -4371927900917127057L;
}

