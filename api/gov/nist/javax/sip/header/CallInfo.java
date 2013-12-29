package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;






public final class CallInfo extends ParametersHeader implements javax.sip.header.CallInfoHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.669 -0500", hash_original_field = "ED4DDD16B2A29876422E00CB4936E7AF", hash_generated_field = "2D62DF7E0A2A79C01356DE01B010437F")

    private static final long serialVersionUID = -8179246487696752928L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.671 -0500", hash_original_field = "6698CBE12F148EEFF557B63CC4CD3669", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")


    protected GenericURI info;

    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.672 -0500", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "5B15A60622536973449DB72A7875F01A")
    public CallInfo() {
        super(CALL_INFO);
    }

    /**
     * Return canonical representation.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.674 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.675 -0500", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "58FA69A25F5F0D895251B013B730D054")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);

        if (parameters != null && !parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }

        return buffer;
    }

    /**
     * get the purpose field
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.677 -0500", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "C9AF8286A3A66FEDDBCA27281DEBEFEA")
    public String getPurpose() {
        return this.getParameter("purpose");
    }

    /**
     * get the URI field
     * @return URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.678 -0500", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "08BCE0CA97E1FDEE68837D588A916CA6")
    public javax.sip.address.URI getInfo() {
        return info;
    }

    /**
     * set the purpose field
     * @param purpose is the purpose field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.679 -0500", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "DA44A599564C6163C0B577B015D1679E")
    public void setPurpose(String purpose) {
        if (purpose == null)
            throw new NullPointerException("null arg");
        try {
            this.setParameter("purpose", purpose);
        } catch (ParseException ex) {
        }
    }

    /**
     * set the URI field
     * @param info is the URI to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.681 -0500", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "82FF90FEBD62D5DBE837F566BB0C9502")
    public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.682 -0500", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "EB36E89A4C736ABE4913A72866D4A39A")
    public Object clone() {
        CallInfo retval = (CallInfo) super.clone();
        if (this.info != null)
            retval.info = (GenericURI) this.info.clone();
        return retval;
    }
}

