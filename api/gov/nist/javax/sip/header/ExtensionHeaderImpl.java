package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.330 -0500", hash_original_field = "E26E48B78C14AE0E08B98124495F2F94", hash_generated_field = "2299100AA92F5021DFDAE61FD8547A67")

    private static final long serialVersionUID = -8693922839612081849L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.332 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "67AFEE1CECFFBA6E89413397161A2E7D")


    protected String value;

    /**
     * This was added to allow for automatic cloning of headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.334 -0500", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "C6043CD0EAD75587ED688DD1766D732D")
    public ExtensionHeaderImpl() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.336 -0500", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "BD5C90BE3F3F46DAB4A9EA7B9AE060AB")
    public ExtensionHeaderImpl(String headerName) {
        super(headerName);
    }

    /**
     * Set the name of the header.
     * @param headerName is the name of the header to set.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.337 -0500", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "7D66D57BFF952061277DF9510749D566")
    public void setName(String headerName) {
        this.headerName = headerName;
    }

    /**
     * Set the value of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.339 -0500", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "75AA9597DE892B8BCB023CCA090F290A")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get the value of the extension header.
     * @return the value of the extension header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.341 -0500", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "4D7EEBBCEC030C07FBDF544F2D7D1052")
    public String getHeaderValue() {
        if (this.value != null) {
            return this.value;
        } else {
            String encodedHdr = null;
            try {
                // Bug fix submitted by Lamine Brahimi
                encodedHdr = this.encode();
            } catch (Exception ex) {
                return null;
            }
            StringBuffer buffer = new StringBuffer(encodedHdr);
            while (buffer.length() > 0 && buffer.charAt(0) != ':') {
                buffer.deleteCharAt(0);
            }
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
            return this.value;
        }
    }

    /**
     * Return the canonical encoding of this header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.342 -0500", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "281B47BDC9545EEB94B7BF57D4FC12A7")
    public String encode() {
        return new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString();
    }

    /**
     * Return just the body of this header encoded (leaving out the
     * name and the CRLF at the end).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.344 -0500", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "646DD12F25E51B0A987F2D8C2CEBECAF")
    public String encodeBody() {
        return this.getHeaderValue();
    }
}

