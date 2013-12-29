package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;






public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.867 -0500", hash_original_field = "7C03D5110AD07BA3A5BDC24C12533FBC", hash_generated_field = "A6105BB7D9606B15FED8D5EA58524006")

    private static final long serialVersionUID = 2034230276579558857L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.868 -0500", hash_original_field = "CEA29DCF66C639EAD8E96ECC619BF901", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.869 -0500", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "09CFAB9F360924133F778652D1D0B4E0")
    public ContentEncoding() {
        super(CONTENT_ENCODING);
    }

    /**
     * Constructor.
     * @param enc String to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.870 -0500", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "DDA3A120F8FE7C363BB05513A1923AAF")
    public ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
    }

    /**
     * Canonical encoding of body of the header.
     * @return  encoded body of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.872 -0500", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "35FF15333BFC2F82D2301F5965AF8264")
    public String encodeBody() {
        return contentEncoding;
    }

    /**
     * Get the ContentEncoding field.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.873 -0500", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "BA6542BA89565E59728F6E58B857CC11")
    public String getEncoding() {
        return contentEncoding;
    }

    /**
     * Set the ConentEncoding field.
     * @param encoding String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.874 -0500", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "991B89D57D56C0543FDE0E0545CB63A5")
    public void setEncoding(String encoding) throws ParseException {
        if (encoding == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        contentEncoding = encoding;
    }
}

