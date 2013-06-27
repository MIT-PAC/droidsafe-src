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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.798 -0400", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "EF9C7B2271BA28B15E1D45A4FFBE5636")
    public  AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.798 -0400", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "11A89D4ACAB3798C397902D765225EBF")
    public void add(NameValue nv) {
        parameters.set(nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.808 -0400", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "E1ADC1C0355061ACAF61292AF6513F3B")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1158284183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1158284183 = parameters.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1158284183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1158284183;
        // ---------- Original Method ----------
        //return parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "17A8802FA97D3512D4540D98657E56AB")
    public NameValue getAuthInfo(String name) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_524434547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524434547 = parameters.getNameValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_524434547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524434547;
        // ---------- Original Method ----------
        //return parameters.getNameValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.816 -0400", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "D9522E9FA3CE629F74795C4F2467D723")
    public String getAuthenticationInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_107099630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_107099630 = this.encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_107099630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107099630;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.817 -0400", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "DE0B9924E11389BC13214DF989AC55AA")
    public String getCNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_2047762858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2047762858 = this.getParameter(ParameterNames.CNONCE);
        varB4EAC82CA7396A68D541C85D26508E83_2047762858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047762858;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.CNONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.817 -0400", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "97285B413D922C50DBCA7742B13999E6")
    public String getNextNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1539419108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539419108 = this.getParameter(ParameterNames.NEXT_NONCE);
        varB4EAC82CA7396A68D541C85D26508E83_1539419108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539419108;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.817 -0400", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "BD111A4210126F0EA7AFCFD0EF3F7F39")
    public int getNonceCount() {
        int var7C4DA5669AB0D7F2DA3D136F9773E715_1922119757 = (this.getParameterAsInt(ParameterNames.NONCE_COUNT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486687206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486687206;
        // ---------- Original Method ----------
        //return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.818 -0400", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "6B4B413C4C1D0C6DD4419177A4BDE492")
    public String getQop() {
        String varB4EAC82CA7396A68D541C85D26508E83_503495811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_503495811 = this.getParameter(ParameterNames.QOP);
        varB4EAC82CA7396A68D541C85D26508E83_503495811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503495811;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.818 -0400", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "25B345827CD76BE13E0940C3F54C7AE4")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_1454040372 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1454040372 = this.getParameter(ParameterNames.RESPONSE_AUTH);
        varB4EAC82CA7396A68D541C85D26508E83_1454040372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454040372;
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.818 -0400", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "590F6C38104597D959A9ABF0B30B67B6")
    public void setCNonce(String cNonce) throws ParseException {
        this.setParameter(ParameterNames.CNONCE, cNonce);
        addTaint(cNonce.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.819 -0400", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "7D9642880A67F3C84EFBAA0180A90B01")
    public void setNextNonce(String nextNonce) throws ParseException {
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
        addTaint(nextNonce.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.819 -0400", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "3326D0D595FF9E07347B82A409C5BDFB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.819 -0400", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "A1D3D443376617C3569FC5B5989274BC")
    public void setQop(String qop) throws ParseException {
        this.setParameter(ParameterNames.QOP, qop);
        addTaint(qop.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.820 -0400", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "C057DD9A4D8186D752A53758C11D9B0C")
    public void setResponse(String response) throws ParseException {
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.827 -0400", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "E64AF7C26C301BFE0C04DE3BFE74F11A")
    public void setParameter(String name, String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null name");
        NameValue nv;
        nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean var61FF0B4F6B63FBABCC6CDEA65181B8AA_157215662 = (name.equalsIgnoreCase(ParameterNames.QOP)
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
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_1044740795 = (value.startsWith(Separators.DOUBLE_QUOTE));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.827 -0400", hash_original_field = "3D12B1C5F1DD39627A9C3476E23AB9F6", hash_generated_field = "D3C79AFE030EEE96A0D38DC41472D401")

    private static long serialVersionUID = -4371927900917127057L;
}

