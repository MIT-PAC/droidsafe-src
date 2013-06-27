package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.text.ParseException;

public final class AuthenticationInfo extends ParametersHeader implements javax.sip.header.AuthenticationInfoHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.694 -0400", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "EF9C7B2271BA28B15E1D45A4FFBE5636")
    public  AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.695 -0400", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "11A89D4ACAB3798C397902D765225EBF")
    public void add(NameValue nv) {
        parameters.set(nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.696 -0400", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "023A09E31CDB4C1739C233197315E604")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1928798899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928798899 = parameters.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1928798899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928798899;
        // ---------- Original Method ----------
        //return parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.696 -0400", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "A40CEACB495EAAB915EE45AF34206E07")
    public NameValue getAuthInfo(String name) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_172338299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_172338299 = parameters.getNameValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_172338299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_172338299;
        // ---------- Original Method ----------
        //return parameters.getNameValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.697 -0400", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "5F4B156E376FDC2E7064C5975E8C8766")
    public String getAuthenticationInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1271608255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1271608255 = this.encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_1271608255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271608255;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.697 -0400", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "ECA4D0146F1FF539A01E44CEF13A6F88")
    public String getCNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1447555349 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1447555349 = this.getParameter(ParameterNames.CNONCE);
        varB4EAC82CA7396A68D541C85D26508E83_1447555349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1447555349;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.CNONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.698 -0400", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "2148A317CDE3AC34C6356B8ABDB2B3D7")
    public String getNextNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1188555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1188555 = this.getParameter(ParameterNames.NEXT_NONCE);
        varB4EAC82CA7396A68D541C85D26508E83_1188555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1188555;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.699 -0400", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "A61F8D3EF0EA8DBF033030C674174771")
    public int getNonceCount() {
        int var7C4DA5669AB0D7F2DA3D136F9773E715_2092147875 = (this.getParameterAsInt(ParameterNames.NONCE_COUNT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543900870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543900870;
        // ---------- Original Method ----------
        //return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.712 -0400", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "C73170D2C569A946211978719ABF190B")
    public String getQop() {
        String varB4EAC82CA7396A68D541C85D26508E83_2124631658 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2124631658 = this.getParameter(ParameterNames.QOP);
        varB4EAC82CA7396A68D541C85D26508E83_2124631658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2124631658;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.713 -0400", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "F5C852027BE0A8A28A7311AE84508C79")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_1204703858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1204703858 = this.getParameter(ParameterNames.RESPONSE_AUTH);
        varB4EAC82CA7396A68D541C85D26508E83_1204703858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1204703858;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.713 -0400", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "590F6C38104597D959A9ABF0B30B67B6")
    public void setCNonce(String cNonce) throws ParseException {
        this.setParameter(ParameterNames.CNONCE, cNonce);
        addTaint(cNonce.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.714 -0400", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "7D9642880A67F3C84EFBAA0180A90B01")
    public void setNextNonce(String nextNonce) throws ParseException {
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
        addTaint(nextNonce.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.719 -0400", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "3326D0D595FF9E07347B82A409C5BDFB")
    public void setNonceCount(int nonceCount) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad value", 0);
        String nc;
        nc = Integer.toHexString(nonceCount);
        String base;
        base = "00000000";
        nc = base.substring(0, 8 - nc.length()) + nc;
        this.setParameter(ParameterNames.NC, nc);
        addTaint(nonceCount);
        // ---------- Original Method ----------
        //if (nonceCount < 0)
            //throw new ParseException("bad value", 0);
        //String nc = Integer.toHexString(nonceCount);
        //String base = "00000000";
        //nc = base.substring(0, 8 - nc.length()) + nc;
        //this.setParameter(ParameterNames.NC, nc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.719 -0400", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "A1D3D443376617C3569FC5B5989274BC")
    public void setQop(String qop) throws ParseException {
        this.setParameter(ParameterNames.QOP, qop);
        addTaint(qop.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.720 -0400", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "C057DD9A4D8186D752A53758C11D9B0C")
    public void setResponse(String response) throws ParseException {
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.721 -0400", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "3EFF3DB7A61585744E9A687BA23F2317")
    public void setParameter(String name, String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null name");
        NameValue nv;
        nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean var61FF0B4F6B63FBABCC6CDEA65181B8AA_2069082644 = (name.equalsIgnoreCase(ParameterNames.QOP)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.REALM)
                || name.equalsIgnoreCase(ParameterNames.CNONCE)
                || name.equalsIgnoreCase(ParameterNames.NONCE)
                || name.equalsIgnoreCase(ParameterNames.OPAQUE)
                || name.equalsIgnoreCase(ParameterNames.USERNAME)
                || name.equalsIgnoreCase(ParameterNames.DOMAIN)
                || name.equalsIgnoreCase(ParameterNames.NEXT_NONCE)
                || name.equalsIgnoreCase(ParameterNames.RESPONSE_AUTH));
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null value");
                    {
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_634085405 = (value.startsWith(Separators.DOUBLE_QUOTE));
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                        value + " : Unexpected DOUBLE_QUOTE",
                        0);
                    } //End collapsed parenthetic
                    nv.setQuotedValue();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.721 -0400", hash_original_field = "3D12B1C5F1DD39627A9C3476E23AB9F6", hash_generated_field = "D3C79AFE030EEE96A0D38DC41472D401")

    private static long serialVersionUID = -4371927900917127057L;
}

