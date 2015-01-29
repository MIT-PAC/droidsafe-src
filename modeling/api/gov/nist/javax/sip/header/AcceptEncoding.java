package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.AcceptEncodingHeader;

public final class AcceptEncoding extends ParametersHeader implements AcceptEncodingHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.234 -0500", hash_original_field = "6EAE0317E22E23A400E78CD4BC4E325D", hash_generated_field = "4930A84A156D9023318126D844288C58")

    private static final long serialVersionUID = -1476807565552873525L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.236 -0500", hash_original_field = "5EFF5DEE90403490A265438B990AF073", hash_generated_field = "984A82245D6D3FDFD20ECFB9ACF6FE25")

    protected String contentCoding;

    /**
     * default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.239 -0500", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "E9BA953A1356F68167BEB2C6A48B09A0")
    
public AcceptEncoding() {
        super(NAME);
    }

    /**
     * Encode the value of this header.
     *
     * @return the value of this header encoded into a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.242 -0500", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "E7B620457F2845A330A89D6C1E735AA1")
    
protected String encodeBody() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.245 -0500", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "1A92CE5A737BA0AFBD24555D9744EA34")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (contentCoding != null) {
            buffer.append(contentCoding);
        }
        if (parameters != null && !parameters.isEmpty()) {
            buffer.append(SEMICOLON).append(parameters.encode());
        }
        return buffer;
    }

    /**
     * get QValue field
     *
     * @return float
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.248 -0500", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "A0A867CA28AD6FE1753111449C70A72C")
    
public float getQValue() {
        return getParameterAsFloat("q");
    }

    /**
     * get ContentEncoding field
     *
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.251 -0500", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "D5E75F502117767332C80F541C2D5ACA")
    
public String getEncoding() {
        return contentCoding;
    }

    /**
     * Set the qvalue member
     *
     * @param q
     *            double to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.253 -0500", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "D2DFEF4188403CE62B3FDEC5F1DC109A")
    
public void setQValue(float q) throws InvalidArgumentException {
        if (q < 0.0 || q > 1.0)
            throw new InvalidArgumentException("qvalue out of range!");
        super.setParameter("q", q);
    }

    /**
     * Sets the encoding of an EncodingHeader.
     *
     * @param encoding -
     *            the new string value defining the encoding.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the encoding value.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.256 -0500", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "1D26ACC2D3AE2B50FB22B35F56F5A5F3")
    
public void setEncoding(String encoding) throws ParseException {
        if (encoding == null)
            throw new NullPointerException(" encoding parameter is null");
        contentCoding = encoding;
    }
}

