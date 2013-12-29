package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.Utils;

import java.text.ParseException;






public class Reason extends ParametersHeader implements javax.sip.header.ReasonHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.860 -0500", hash_original_field = "3E66E5ED0D00DCDE0CD65D891C65BC72", hash_generated_field = "7D21FB644FECBA65363EF6F0D18662A5")

    private static final long serialVersionUID = -8903376965568297388L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.862 -0500", hash_original_field = "AF75EB96831459D98A972B9E05A7F523", hash_generated_field = "0D9A1057F894C5C025812C805A74752D")

    public final String TEXT = ParameterNames.TEXT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.864 -0500", hash_original_field = "632653A569DEEDD5F462530FDC8AA132", hash_generated_field = "FB6C8196B2C2E307FFF20FE5A583FA8B")

    public final String CAUSE = ParameterNames.CAUSE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.865 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")


    protected String protocol;

    /** Set the cause.

    /** Creates a new instance of Reason */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.879 -0500", hash_original_method = "49B37C8425CF255FB1500AD2816C1ABC", hash_generated_method = "3E2A51EAE5404A0B504CFC44DF350058")
    public Reason() {
        super(NAME);
    }

    /** Get the cause token.
     *@return the cause code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.867 -0500", hash_original_method = "8E10C2A6776CBAA32EF7257A8A62ADDC", hash_generated_method = "7F13B56B54E84BA2BA32D8FECC0D0785")
    public int getCause() {
        return getParameterAsInt(CAUSE);
    }

    /**
     * Set the cause.
     *
     *@param cause - cause to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.869 -0500", hash_original_method = "3B7AE3E82D120F32D14143BCEAA3D0F3", hash_generated_method = "A14B040FD00ADC7282BB2527B0B399D9")
    public void setCause(int cause) throws javax.sip.InvalidArgumentException {
        this.parameters.set("cause", Integer.valueOf(cause));
    }

    /** Set the protocol
     *
     *@param protocol - protocol to set.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.872 -0500", hash_original_method = "70E0561C3515B6199EF81B19035663E5", hash_generated_method = "AD1562F51AB1C85A8929BDAAE1B899B2")
    public void setProtocol(String protocol) throws ParseException {
        this.protocol = protocol;
    }

    /** Return the protocol.
     *
     *@return the protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.874 -0500", hash_original_method = "5EF709A41590C5E9760EDEDCACA5AD40", hash_generated_method = "044A2D0CFF5B1F22FCBA9304F70D399F")
    public String getProtocol() {
        return this.protocol;
    }

    /** Set the text.
     *
     *@param text -- string text to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.876 -0500", hash_original_method = "A59A90A2875E29D5E7D7A7D1C378A11A", hash_generated_method = "E5EA8F6160270FCECA149101B1BB3108")
    public void setText(String text) throws ParseException {
        // JvB: MUST be quoted
        if ( text.charAt(0) != '"' ) {
            text = Utils.getQuotedString(text);
        }
        this.parameters.set("text", text);
    }

    /** Get the text.
     *
     *@return text parameter.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.877 -0500", hash_original_method = "E868EA376D386565EBAAF11DC1F8D010", hash_generated_method = "DDBD8B65122C2D957E4C8DC3AB8F432C")
    public String getText() {
        return this.parameters.getParameter("text");
    }

    /** Gets the unique string name of this Header. A name constant is defined in
     * each individual Header identifying each Header.
     *
     * @return the name of this specific Header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.881 -0500", hash_original_method = "58D1ADCDFA9509486623D4E556DE8E64", hash_generated_method = "5A2D2B592CEBD7762F5C6B85CBD1BD89")
    public String getName() {
        return NAME;

    }

    /**
     * Encode the body of this header (the stuff that follows headerName).
     * A.K.A headerValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:49.883 -0500", hash_original_method = "F6A3921BF2DA3805D24A4DD375373A7E", hash_generated_method = "B93955B76AECF570145E6D79A55D84AB")
    protected String encodeBody() {
        StringBuffer s = new StringBuffer();
        s.append(protocol);
        if (parameters != null && !parameters.isEmpty())
            s.append(SEMICOLON).append(parameters.encode());
        return s.toString();
    }
}

