package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ContentLengthHeader;






public class ContentLength extends SIPHeader implements javax.sip.header.ContentLengthHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.103 -0500", hash_original_field = "4190EDB0E8C7DA78A55F07C7C89EE052", hash_generated_field = "0DAE05D7BF9A340249D2F42939DD9CA2")

    private static final long serialVersionUID = 1187190542411037027L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.104 -0500", hash_original_field = "E850850B45AA78B3DCEBACF023F218F0", hash_generated_field = "8B32F0E2687755E2873F555A7E264239")

    protected Integer contentLength;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.106 -0500", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "3098EB1A73E7D4E551F84D82834943DF")
    public ContentLength() {
        super(NAME);
    }

    /**
     * Constructor given a length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.107 -0500", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "CFB81A0992BCD18B37272999971C8572")
    public ContentLength(int length) {
        super(NAME);
        this.contentLength = Integer.valueOf(length);
    }

    /**
     * get the ContentLength field.
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.108 -0500", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "595B83E3D25C37BB48AE6582CFC3FA5E")
    public int getContentLength() {
        return contentLength.intValue();
    }

    /**
     * Set the contentLength member
     * @param contentLength int to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.109 -0500", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "981A882BC0402363784202E900A28FD7")
    public void setContentLength(int contentLength)
        throws InvalidArgumentException {
        if (contentLength < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", ContentLength, setContentLength(), the contentLength parameter is <0");
        this.contentLength = Integer.valueOf(contentLength);
    }

    /**
     * Encode into a canonical string.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.110 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.111 -0500", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "1DF485C93791BCB4B6E1873345F54F31")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        if (contentLength == null)
            buffer.append("0");
        else
            buffer.append(contentLength.toString());
        return buffer;
    }

    /**
     * Pattern matcher ignores content length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.112 -0500", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "4C8E8780FA3C7A09AF94E1277F10CB12")
    public boolean match(Object other) {
        if (other instanceof ContentLength)
            return true;
        else
            return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.113 -0500", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "3604017A7DB5E235BC0EF7B28CD6D46D")
    public boolean equals(Object other) {
        if (other instanceof ContentLengthHeader) {
            final ContentLengthHeader o = (ContentLengthHeader) other;
            return this.getContentLength() == o.getContentLength();
        }
        return false;
    }
}

