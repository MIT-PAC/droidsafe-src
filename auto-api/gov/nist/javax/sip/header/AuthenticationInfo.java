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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.820 -0400", hash_original_method = "501AA426592E66DB320F694568AF73E3", hash_generated_method = "EF9C7B2271BA28B15E1D45A4FFBE5636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationInfo() {
        super(NAME);
        parameters.setSeparator(COMMA);
        // ---------- Original Method ----------
        //parameters.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.820 -0400", hash_original_method = "3780BAE96FA2BB1F0E2AD0AAFD0731BB", hash_generated_method = "8748A9345E6CC43376582827CFAC1045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(NameValue nv) {
        dsTaint.addTaint(nv.dsTaint);
        parameters.set(nv);
        // ---------- Original Method ----------
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.820 -0400", hash_original_method = "984A5DF7C514C121E76596CBE2C6D49B", hash_generated_method = "53599C0C86666A479871C56BDD9611DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String varCDDBF7EBD4BDD8EA62B9660B7830532F_1900299505 = (parameters.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.820 -0400", hash_original_method = "4557281A63D104D6DD73401BFDDD37E4", hash_generated_method = "62E4528BF9A9DF61592D7BACF772AD00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue getAuthInfo(String name) {
        dsTaint.addTaint(name);
        NameValue var44CB4D907E090CC08718C8DCCCC38330_1607823897 = (parameters.getNameValue(name));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters.getNameValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.820 -0400", hash_original_method = "45703CBA192DB8FE97E8CE6B0DE011B6", hash_generated_method = "A55C746BA2728339848B1BB50F2B75AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAuthenticationInfo() {
        String var7CD8161F9F63CECF143F9946FD49E225_1734582194 = (this.encodeBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.821 -0400", hash_original_method = "78E06BA6093F7AA3C4C2CE903F3FED26", hash_generated_method = "CC6372BB6D7B2D17922B6469BFF2600E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCNonce() {
        String var2AE3D4FE95BC8E5DD7DF034159A9644E_1523611009 = (this.getParameter(ParameterNames.CNONCE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.CNONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.821 -0400", hash_original_method = "4856BE956C44217C60CB87D76847AFE4", hash_generated_method = "463A15BF60BC6BFDCA8F14AB098B286B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNextNonce() {
        String var93AB7FBA6301AF4C9D324DABE0A137C3_787481868 = (this.getParameter(ParameterNames.NEXT_NONCE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.NEXT_NONCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.821 -0400", hash_original_method = "F46B5447262611FA3819A20578A12025", hash_generated_method = "39EC39A251439EEA503BA72E97E2042F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNonceCount() {
        int var7C4DA5669AB0D7F2DA3D136F9773E715_1848206649 = (this.getParameterAsInt(ParameterNames.NONCE_COUNT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getParameterAsInt(ParameterNames.NONCE_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.821 -0400", hash_original_method = "2EA7D13FA74BC0F4D2935AE8D437DBD8", hash_generated_method = "9846C57009DF11F5C3F4A1F53274CA42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQop() {
        String varFF9532F1DF50E0DCD2A6F161D9A38B49_1946721192 = (this.getParameter(ParameterNames.QOP));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.821 -0400", hash_original_method = "B75013AB6AA69C35681E13DE4A7E264C", hash_generated_method = "A8233B2F49B2160A9EBAEC908F43F4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResponse() {
        String varEE2B5512DC09AA44BDB01DC2E01655AA_320680221 = (this.getParameter(ParameterNames.RESPONSE_AUTH));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(ParameterNames.RESPONSE_AUTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.822 -0400", hash_original_method = "CDD1565AE66D1F19FAC92EF7F73506E7", hash_generated_method = "39A95D50B6CD6A4AC36900C6347A2FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCNonce(String cNonce) throws ParseException {
        dsTaint.addTaint(cNonce);
        this.setParameter(ParameterNames.CNONCE, cNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.CNONCE, cNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.822 -0400", hash_original_method = "4BA976DE811A19A0644E93DFC8BE6F26", hash_generated_method = "F5EC8D465380BC580DF6C759ADEC4BC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNextNonce(String nextNonce) throws ParseException {
        dsTaint.addTaint(nextNonce);
        this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.NEXT_NONCE, nextNonce);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.822 -0400", hash_original_method = "885E7CACD33EDD6ADEC8B61045CE08BB", hash_generated_method = "73D8D110AF5F4AB298F530DF7CBD88D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNonceCount(int nonceCount) throws ParseException {
        dsTaint.addTaint(nonceCount);
        if (DroidSafeAndroidRuntime.control) throw new ParseException("bad value", 0);
        String nc;
        nc = Integer.toHexString(nonceCount);
        String base;
        base = "00000000";
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.822 -0400", hash_original_method = "B224A85C0273DF0FE71ACDF1CBE34D20", hash_generated_method = "CFFDD3845A451120A5FB2EEBF1B7E911")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQop(String qop) throws ParseException {
        dsTaint.addTaint(qop);
        this.setParameter(ParameterNames.QOP, qop);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.QOP, qop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.822 -0400", hash_original_method = "79F5ECF04A9DFE6DE6CC38CF9BC2A733", hash_generated_method = "004DC7722D027041C3F6CD0C1BAA0AA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setResponse(String response) throws ParseException {
        dsTaint.addTaint(response);
        this.setParameter(ParameterNames.RESPONSE_AUTH, response);
        // ---------- Original Method ----------
        //this.setParameter(ParameterNames.RESPONSE_AUTH, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.823 -0400", hash_original_method = "755E28BB77A48AFE56357BE82519C7C0", hash_generated_method = "6752A1D55CD7A3EE8FD769996091F5C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null name");
        NameValue nv;
        nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean var61FF0B4F6B63FBABCC6CDEA65181B8AA_192426105 = (name.equalsIgnoreCase(ParameterNames.QOP)
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
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_1878922632 = (value.startsWith(Separators.DOUBLE_QUOTE));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final long serialVersionUID = -4371927900917127057L;
}

