package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;






public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.309 -0500", hash_original_field = "403105A958860DB5616FD28C593F6288", hash_generated_field = "85C85A2237A84342C80D2A96596481BF")

    private static final long serialVersionUID = -3105079479020693930L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.313 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.315 -0500", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "7144F05B316388D4FB02D674281EA11A")
    
public Allow() {
        super(ALLOW);
    }

    /** constructor
     * @param m String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.319 -0500", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "44564E201CD2D38AEACEA7E1490034D9")
    
public Allow(String m) {
        super(ALLOW);
        method = m;
    }

    /** get the method field
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.322 -0500", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "BC38B478E0AED2517A3460750CABA307")
    
public String getMethod() {
        return method;
    }

    /**
     * Set the method member
     * @param method method to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.325 -0500", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "2023EF4B56C823A949F968423E41B129")
    
public void setMethod(String method) throws ParseException {
        if (method == null)
            throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        this.method = method;
    }

    /** Return body encoded in canonical form.
     * @return body encoded as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.328 -0500", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "BF486431FF0AE34E20C9943AA080AC10")
    
protected String encodeBody() {
        return method;
    }
}

